package batch;

import model.ProductItem;

import javax.batch.api.chunk.ItemReader;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Gregor Tudan
 */
@Named("ProductCatalogReader")
public class ProductCatalogReader implements ItemReader {
	@Override
	public void open(Serializable serializable) throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void close() throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Object readItem() throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
