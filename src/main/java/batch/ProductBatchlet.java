package batch;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Gregor Tudan
 */
@Named("ProductBatchlet")
public class ProductBatchlet implements Batchlet {

	@Inject
	private JobContext jobCtx;

	@Override
	public String process() throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void stop() throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
