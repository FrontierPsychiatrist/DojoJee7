package batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.batch.api.chunk.ItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.BufferedWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * User: moritz
 */
@Named("ProductCatalogWriter")
public class ProductCatalogWriter implements ItemWriter {
	private BufferedWriter fileWriter;
	private Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    private JobContext jobContext;
	
    @Override
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
