package batch;

import model.ProductItem;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * User: moritz
 */
public class ProductCatalogReaderTest {

    private ProductCatalogReader dao;

    @Before
    public void createReader() {
        dao = new ProductCatalogReader();
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
