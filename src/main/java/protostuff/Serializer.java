package protostuff;

import java.io.IOException;
import java.util.List;

public interface Serializer {
    <T> byte[] serialize(T source);

    <T> byte[] serializeList(final List<T> sources, final Class<T> clazz) throws IOException;
}
