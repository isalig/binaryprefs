package com.ironz.binaryprefs.serialization;

import com.ironz.binaryprefs.serialization.impl.*;
import com.ironz.binaryprefs.serialization.impl.persistable.PersistableRegistry;

public final class SerializerFactory {

    private final BooleanSerializer booleanSerializer;
    private final ByteSerializer byteSerializer;
    private final CharSerializer charSerializer;
    private final DoubleSerializer doubleSerializer;
    private final FloatSerializer floatSerializer;
    private final IntegerSerializer integerSerializer;
    private final LongSerializer longSerializer;
    private final ShortSerializer shortSerializer;
    private final StringSerializer stringSerializer;
    private final StringSetSerializer stringSetSerializer;
    private final PersistableSerializer persistableSerializer;

    public SerializerFactory(PersistableRegistry persistableRegistry) {
        booleanSerializer = new BooleanSerializer();
        byteSerializer = new ByteSerializer();
        charSerializer = new CharSerializer();
        doubleSerializer = new DoubleSerializer();
        floatSerializer = new FloatSerializer();
        integerSerializer = new IntegerSerializer();
        longSerializer = new LongSerializer();
        shortSerializer = new ShortSerializer();
        stringSerializer = new StringSerializer();
        stringSetSerializer = new StringSetSerializer();
        persistableSerializer = new PersistableSerializer(
                booleanSerializer,
                byteSerializer,
                charSerializer,
                doubleSerializer,
                floatSerializer,
                integerSerializer,
                longSerializer,
                shortSerializer,
                stringSerializer,
                persistableRegistry
        );
    }

    public Object deserialize(String token, byte[] bytes) {
        byte flag = bytes[0];
        if (booleanSerializer.isMatches(flag)) {
            return booleanSerializer.deserialize(bytes);
        }
        if (byteSerializer.isMatches(flag)) {
            return byteSerializer.deserialize(bytes);
        }
        if (charSerializer.isMatches(flag)) {
            return charSerializer.deserialize(bytes);
        }
        if (doubleSerializer.isMatches(flag)) {
            return doubleSerializer.deserialize(bytes);
        }
        if (floatSerializer.isMatches(flag)) {
            return floatSerializer.deserialize(bytes);
        }
        if (integerSerializer.isMatches(flag)) {
            return integerSerializer.deserialize(bytes);
        }
        if (longSerializer.isMatches(flag)) {
            return longSerializer.deserialize(bytes);
        }
        if (shortSerializer.isMatches(flag)) {
            return shortSerializer.deserialize(bytes);
        }
        if (stringSerializer.isMatches(flag)) {
            return stringSerializer.deserialize(bytes);
        }
        if (stringSetSerializer.isMatches(flag)) {
            return stringSetSerializer.deserialize(bytes);
        }
        if (persistableSerializer.isMatches(flag)) {
            return persistableSerializer.deserialize(token, bytes);
        }
        throw new UnsupportedClassVersionError(String.format("Flag verification failed. Incorrect flag '%s'", flag));
    }

    public BooleanSerializer getBooleanSerializer() {
        return booleanSerializer;
    }

    public ByteSerializer getByteSerializer() {
        return byteSerializer;
    }

    public CharSerializer getCharSerializer() {
        return charSerializer;
    }

    public DoubleSerializer getDoubleSerializer() {
        return doubleSerializer;
    }

    public FloatSerializer getFloatSerializer() {
        return floatSerializer;
    }

    public IntegerSerializer getIntegerSerializer() {
        return integerSerializer;
    }

    public LongSerializer getLongSerializer() {
        return longSerializer;
    }

    public ShortSerializer getShortSerializer() {
        return shortSerializer;
    }

    public StringSerializer getStringSerializer() {
        return stringSerializer;
    }

    public StringSetSerializer getStringSetSerializer() {
        return stringSetSerializer;
    }

    public PersistableSerializer getPersistableSerializer() {
        return persistableSerializer;
    }
}