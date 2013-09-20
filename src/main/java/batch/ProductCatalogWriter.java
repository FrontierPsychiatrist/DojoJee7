package batch;

import javax.batch.api.chunk.ItemWriter;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author Gregor Tudan
 */
@Named("ProductCatalogWriter")
public class ProductCatalogWriter implements ItemWriter{
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
	public Serializable checkpointInfo() throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
