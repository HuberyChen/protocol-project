package protostuff;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ProtostuffSerializer extends AbstractProtoSerializer {

    @Override
    protected <T> byte[] serializeInternal(final T source, final Schema<T> schema, final LinkedBuffer buffer) {
        return ProtostuffIOUtil.toByteArray(source, schema, buffer);
    }

    @Override
    protected <T> T deserializeInternal(final byte[] bytes, final T result, final Schema<T> schema) {
        ProtostuffIOUtil.mergeFrom(bytes, result, schema);
        return result;
    }

    @Override
    protected <T> byte[] writeListTo(ByteArrayOutputStream out, List<T> messages, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        ProtostuffIOUtil.writeListTo(out, messages, schema, buffer);
        return out.toByteArray();
    }

    @Override
    protected <T> List<T> deserializeList(ByteArrayInputStream in, Schema<T> schema) throws IOException {
        return ProtostuffIOUtil.parseListFrom(in, schema);
    }

}
