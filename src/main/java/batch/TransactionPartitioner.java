package batch;

import java.util.Properties;

import javax.batch.api.partition.PartitionMapper;
import javax.batch.api.partition.PartitionPlan;
import javax.batch.api.partition.PartitionPlanImpl;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;

public class TransactionPartitioner implements PartitionMapper {
	@Inject
	private JobContext jobContext;

	@Override
	public PartitionPlan mapPartitions() throws Exception {
		return new PartitionPlanImpl() {

			@Override
			public int getThreads() {
				return 10;
			}

			@Override
			public int getPartitions() {
				return 20;
			}

			@Override
			public Properties[] getPartitionProperties() {
				Properties jobParameters = BatchRuntime.getJobOperator()
						.getParameters(jobContext.getExecutionId());

				Properties[] props = new Properties[getPartitions()];
				for (int i = 0; i < getPartitions(); i++) {
					Properties partProps = new Properties();
					props[i] = partProps;
				}
				return props;
			}
		};
	}

}
