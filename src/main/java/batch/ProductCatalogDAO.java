package batch;

import model.ProductItem;

import javax.batch.api.chunk.ItemReader;
import javax.batch.api.chunk.ItemWriter;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author Gregor Tudan
 */
@Named("ProductCatalogDao")
public class ProductCatalogDAO implements ItemReader, ItemWriter{
	@Override
	public void open(Serializable serializable) throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void close() throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void writeItems(List<Object> objects) throws Exception {
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
