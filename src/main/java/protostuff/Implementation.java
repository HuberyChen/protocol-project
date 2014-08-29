package protostuff;

import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @author hubery.chen
 */
public class Implementation {

    @Test
    public void test() throws IOException {
        Foo foo = new Foo();
        foo.setProductId(1);
        foo.setUrl("www.baidu1.com");
        foo.setGroupId(1);
//
        ProtostuffSerializer protostuff = new ProtostuffSerializer();
        byte[] bytes = protostuff.serialize(foo);
//        byte[] bytes = "[B@76011b69".getBytes();
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] bytes = decoder.decodeBuffer("CAESDnd3dy5iYWlkdTEuY29tGAE=");
//        System.out.println(bytes);
//        Foo actual = protostuff.deserialize(bytes, Foo.class);
//        System.out.println(actual);
//        assertThat(foo, is(actual));

        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println(encoder.encodeBuffer(bytes));

    }
}
