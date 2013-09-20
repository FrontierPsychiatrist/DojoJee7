package batch;

import model.ProductItem;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.batch.runtime.context.JobContext;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

/**
 * User: moritz
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductCatalogReaderTest {

    @Mock
    private JobContext jobContext;

    @InjectMocks
    private ProductCatalogReader dao;

    @Before
    public void createReader() {
        Properties p = new Properties();
        p.setProperty("input-file", "batch/product-items.csv");
        when(jobContext.getProperties()).thenReturn(p);
    }

    @Test
    public void testOpen() throws Exception {
        dao.open(null);
    }

    @Test
    public void testReadItem() throws Exception {
        dao.open(null);
        Object o = dao.readItem();
        MatcherAssert.assertThat(o, is(instanceOf(ProductItem.class)));
    }
}
