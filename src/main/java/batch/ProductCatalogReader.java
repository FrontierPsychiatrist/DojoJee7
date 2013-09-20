package batch;

import batch.exceptions.NotEnoughFieldsException;
import model.Price;
import model.ProductItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Currency;

/**
 * @author Gregor Tudan
 */
@Named("ProductCatalogReader")
public class ProductCatalogReader implements ItemReader {
	private BufferedReader fileReader;
	private Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    private JobContext jobContext;

    @Override
	public void open(Serializable serializable) throws Exception {
        String fileName = jobContext.getProperties().getProperty("input-file");
        fileReader = Files.newBufferedReader(Paths.get(getClass().getClassLoader().getResource(fileName).toURI()), Charset.defaultCharset());
    }

	@Override
	public void close() throws Exception {
		fileReader.close();
	}

	@Override
	public Object readItem() throws Exception {
        String line = fileReader.readLine();
        if(line == null) return null;
        String[] tokens = line.split(";");
        if(tokens.length != 5) {
            throw new NotEnoughFieldsException();
        }
        ProductItem productItem = getProductItem(tokens);
		log.debug("Read item {}", productItem.getName());
        return productItem;

	}

    private ProductItem getProductItem(String[] tokens) {
        Long productNumber = Long.valueOf(tokens[0]);
        ProductItem productItem = new ProductItem(productNumber, tokens[1]);
        productItem.setDescription(tokens[2]);
        Price price = new Price(new BigDecimal(tokens[3]), Currency.getInstance(tokens[4]));
        productItem.setPrice(price);
        return productItem;
    }

    @Override
	public Serializable checkpointInfo() throws Exception {
		return null;
	}
}
