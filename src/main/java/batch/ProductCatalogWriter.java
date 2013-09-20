package batch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.List;

import javax.batch.api.chunk.ItemWriter;
import javax.inject.Named;

import model.ProductItem;

/**
 * User: moritz
 */
@Named("ProductCatalogWriter")
public class ProductCatalogWriter implements ItemWriter {
	private BufferedWriter fileWriter;
	
	
    @Override
	public void open(Serializable serializable) throws Exception {
        fileWriter = new BufferedWriter(new FileWriter("batch/product-items.csv"));
    }

    @Override
    public void close() throws Exception {
    	fileWriter.close();
    }

    @Override
    public void writeItems(List<Object> objects) throws Exception {
    	for(Object object : objects){
    		ProductItem productItem = (ProductItem) object;
			fileWriter.write(productItem.toString());
    	}
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}
