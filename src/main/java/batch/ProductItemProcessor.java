package batch;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

/**
 * @author Gregor Tudan
 */
@Named("ProductItemProcessor")
public class ProductItemProcessor implements ItemProcessor{
	@Override
	public Object processItem(Object o) throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
