package batch;

import javax.batch.api.chunk.ItemWriter;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * User: moritz
 */
@Named("ProductCatalogWriter")
public class ProductCatalogWriter implements ItemWriter {
    @Override
    public void open(Serializable serializable) throws Exception {

    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public void writeItems(List<Object> objects) throws Exception {

    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}
