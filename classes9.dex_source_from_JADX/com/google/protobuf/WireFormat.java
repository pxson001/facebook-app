package com.google.protobuf;

/* compiled from: all_messenger_payments */
public final class WireFormat {
    static final int f21040a = m21527a(1, 3);
    static final int f21041b = m21527a(1, 4);
    static final int f21042c = m21527a(2, 0);
    static final int f21043d = m21527a(3, 2);

    /* compiled from: all_messenger_payments */
    public enum FieldType {
        DOUBLE(JavaType.DOUBLE, 1),
        FLOAT(JavaType.FLOAT, 5),
        INT64(JavaType.LONG, 0),
        UINT64(JavaType.LONG, 0),
        INT32(JavaType.INT, 0),
        FIXED64(JavaType.LONG, 1),
        FIXED32(JavaType.INT, 5),
        BOOL(JavaType.BOOLEAN, 0),
        STRING(JavaType.STRING, 2) {
            public final boolean isPackable() {
                return false;
            }
        },
        GROUP(JavaType.MESSAGE, 3) {
            public final boolean isPackable() {
                return false;
            }
        },
        MESSAGE(JavaType.MESSAGE, 2) {
            public final boolean isPackable() {
                return false;
            }
        },
        BYTES(JavaType.BYTE_STRING, 2) {
            public final boolean isPackable() {
                return false;
            }
        },
        UINT32(JavaType.INT, 0),
        ENUM(JavaType.ENUM, 0),
        SFIXED32(JavaType.INT, 5),
        SFIXED64(JavaType.LONG, 1),
        SINT32(JavaType.INT, 0),
        SINT64(JavaType.LONG, 0);
        
        private final JavaType javaType;
        private final int wireType;

        public FieldType(JavaType javaType, int i) {
            this.javaType = javaType;
            this.wireType = i;
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }
    }

    /* compiled from: all_messenger_payments */
    public enum JavaType {
        INT(Integer.valueOf(0)),
        LONG(Long.valueOf(0)),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.valueOf(false)),
        STRING(""),
        BYTE_STRING(ByteString.f20600a),
        ENUM(null),
        MESSAGE(null);
        
        private final Object defaultDefault;

        private JavaType(Object obj) {
            this.defaultDefault = obj;
        }

        final Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    private WireFormat() {
    }

    static int m21526a(int i) {
        return i & 7;
    }

    public static int m21528b(int i) {
        return i >>> 3;
    }

    static int m21527a(int i, int i2) {
        return (i << 3) | i2;
    }
}
