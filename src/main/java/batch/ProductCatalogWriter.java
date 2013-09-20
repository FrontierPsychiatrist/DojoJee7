package batch;

import model.ProductItem;

import javax.batch.api.chunk.ItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
<<<<<<< HEAD

import model.ProductItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
import java.io.BufferedWriter;
import java.io.Serializable;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
>>>>>>> b39adb78be91e851754ddad5e32d085b399b6d6c

/**
 * User: moritz
 */
@Named("ProductCatalogWriter")
public class ProductCatalogWriter implements ItemWriter {
	private BufferedWriter fileWriter;
<<<<<<< HEAD
	private Logger log = LoggerFactory.getLogger(getClass());


	@Override
=======

    @Inject
    private JobContext jobContext;
	
    @Override
>>>>>>> b39adb78be91e851754ddad5e32d085b399b6d6c
	public void open(Serializable serializable) throws Exception {
        String fileName = jobContext.getProperties().getProperty("output-file");
        fileWriter = Files.newBufferedWriter(Paths.get(fileName), Charset.defaultCharset(), StandardOpenOption.CREATE);
    }

    @Override
    public void close() throws Exception {
    	fileWriter.close();
    }

    @Override
    public void writeItems(List<Object> objects) throws Exception {
	    log.debug("Writing item");
    	for(Object productItem : objects){
			fileWriter.write(productItem.toString());
    	}
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}
