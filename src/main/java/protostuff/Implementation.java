package protostuff;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hubery.chen
 */
public class Implementation {

    @Test
    public void test1() throws IOException {
        FullProduct fullProduct = new FullProduct();
        fullProduct.setProductId(1);
        fullProduct.setUrl("www.baidu1.com");
        fullProduct.setGroupId(1);

        ReviewRating reviewRating = new ReviewRating();
        reviewRating.setTotalCount(1);
        reviewRating.setAverageRating(BigDecimal.ONE);
        Map<Integer, ReviewRating> reviewRatings = new HashMap<>();
        reviewRatings.put(1, reviewRating);
        fullProduct.setReviewRatings(reviewRatings);

        ProductDescription productDescription = new ProductDescription();
        productDescription.setDisplayOrder(1);
        productDescription.setTabTitle("table");
        List<ProductDescription> productDescriptions = new ArrayList<>();
        productDescriptions.add(productDescription);
        fullProduct.setProductDescriptions(productDescriptions);

        ProtostuffSerializer protostuff = new ProtostuffSerializer();
//        byte[] bytes = protostuff.serialize(fullProduct);
        byte[] bytes = protostuff.serialize(fullProduct);

        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println(encoder.encodeBuffer(bytes));

    }

    @Test
    public void test2() throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] bytes = decoder.decodeBuffer("CgkKBXRhYmxlEAE==");
//        byte[] bytes = decoder.decodeBuffer("CAE=");
//        byte[] bytes = decoder.decodeBuffer("CAESDnd3dy5iYWlkdTEuY29tGAEjCgV0YWJsZRABJA==");
//        byte[] bytes = decoder.decodeBuffer("CAESDnd3dy5iYWlkdTEuY29tGAEjCgV0YWJsZRABJCsLCAETCAESATEUDCw=");
        byte[] bytes = decoder.decodeBuffer("CAESDnd3dy5iYWlkdTEuY29tGAEjCgV0YWJsZRABJCsLCAETCAESATEUDCw=");
        ProtostuffSerializer protostuff = new ProtostuffSerializer();
        FullProduct actual = protostuff.deserialize(bytes, FullProduct.class);
        System.out.println(actual);
    }

    @Test
    public void test3() throws Exception {
        ProtostuffSerializer protostuff = new ProtostuffSerializer();

        ProductDescription productDescription = new ProductDescription();
        productDescription.setDisplayOrder(1);
        productDescription.setTabTitle("table");
        List<ProductDescription> productDescriptions = new ArrayList<>();
        productDescriptions.add(productDescription);

        byte[] bytes = protostuff.serializeList(productDescriptions, ProductDescription.class);
        System.out.println(bytes);
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println(encoder.encodeBuffer(bytes));

    }

    @Test
    public void test4() throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer("CgkKBXRhYmxlEAE=");
//        byte[] bytes = decoder.decodeBuffer("AQoFdGFibGUQAQc=");
//        byte[] bytes = decoder.decodeBuffer("CAE=");

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ProtostuffSerializer protostuff = new ProtostuffSerializer();
        List<ProductDescription> actual = protostuff.deserializeList(in, ProductDescription.class);
        System.out.println(actual);
    }
}
