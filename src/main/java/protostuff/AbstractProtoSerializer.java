package protostuff;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.Schema;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public abstract class AbstractProtoSerializer implements Serializer, Deserializer {

    private final Objenesis objenesis = new ObjenesisStd(true);

    @Override
    public <T> byte[] serialize(final T source) {
        @SuppressWarnings("unchecked")
        final Class<T> clazz = (Class<T>) source.getClass();
        final LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            final Schema<T> schema = SchemaUtils.getSchema(clazz);
            return serializeInternal(source, schema, buffer);
        } catch (final Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            buffer.clear();
        }
    }

    @Override
    public <T> T deserialize(final byte[] bytes, final Class<T> clazz) {
        try {
            @SuppressWarnings("unchecked")
            final T result = (T) objenesis.newInstance(clazz);
            return deserializeInternal(bytes, result, SchemaUtils.getSchema(clazz));
        } catch (final Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    @Override
    public <T> byte[] serializeList(final List<T> sources, final Class<T> clazz) throws IOException {
        @SuppressWarnings("unchecked")
        final LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            final Schema<T> schema = SchemaUtils.getSchema(clazz);
            return writeListTo(out, sources, schema, buffer);
        } catch (final Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            buffer.clear();
        }
    }

    @Override
    public <T> List<T> deserializeList(final ByteArrayInputStream in, final Class<T> clazz) {
        try {
            return deserializeList(in, SchemaUtils.getSchema(clazz));
        } catch (final Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    protected abstract <T> byte[] serializeInternal(final T source, final Schema<T> schema, final LinkedBuffer buffer);

    protected abstract <T> T deserializeInternal(final byte[] bytes, final T result, final Schema<T> schema);

    protected abstract <T> byte[] writeListTo(final ByteArrayOutputStream out, final List<T> messages, final Schema<T> schema, final LinkedBuffer buffer) throws IOException;

    protected abstract <T> List<T> deserializeList(ByteArrayInputStream in, Schema<T> schema) throws IOException;
}
