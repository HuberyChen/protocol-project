package protostuff;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface Deserializer {
    <T> T deserialize(final byte[] bytes, final Class<T> clazz);

    <T> List<T> deserializeList(final ByteArrayInputStream in, final Class<T> clazz);
}
