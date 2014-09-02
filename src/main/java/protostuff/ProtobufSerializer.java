package protostuff;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.Schema;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ProtobufSerializer extends AbstractProtoSerializer {

    @Override
    public <T> byte[] serializeInternal(final T source, final Schema<T> schema, final LinkedBuffer buffer) {
        return ProtobufIOUtil.toByteArray(source, schema, buffer);
    }

    @Override
    public <T> T deserializeInternal(final byte[] bytes, final T result, final Schema<T> schema) {
        ProtobufIOUtil.mergeFrom(bytes, result, schema);
        return result;
    }

    @Override
    protected <T> byte[] writeListTo(ByteArrayOutputStream out, List<T> messages, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        ProtobufIOUtil.writeListTo(out, messages, schema, buffer);
        return out.toByteArray();
    }

    @Override
    protected <T> List<T> deserializeList(ByteArrayInputStream in, Schema<T> schema) throws IOException {
        return ProtobufIOUtil.parseListFrom(in, schema);

    }
}
