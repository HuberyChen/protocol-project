package protostuff;

public interface Serializer {
    <T> byte[] serialize(T source);
}
