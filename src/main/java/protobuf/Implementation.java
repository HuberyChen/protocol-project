package protobuf;

import org.junit.Test;
import protobuf.model.ProtoBufferPractice;
import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * @author hubery.chen
 */
public class Implementation {

    @Test
    public void test1() {
        ProtoBufferPractice.msgInfo.Builder builder = ProtoBufferPractice.msgInfo.newBuilder();
        builder.setGoodID(1);
        builder.setID(1);
        builder.setUrl("www.baidu.com");
        ProtoBufferPractice.msgInfo info = builder.build();

        byte[] result = info.toByteArray();

        System.out.println(result);

//        byte[] result = "[B@76011b69".getBytes();
        try {
            ProtoBufferPractice.msgInfo msg = ProtoBufferPractice.msgInfo.parseFrom(result);
            System.out.println(msg);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void test2() throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        System.out.println(decoder.decodeBuffer("CAESDXd3dy5iYWlkdS5jb20YAQ=="));
    }

}
