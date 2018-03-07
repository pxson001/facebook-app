package com.fasterxml.jackson.core.util;

/* compiled from: request_header_size */
public class BufferRecycler {
    protected final byte[][] f7319a = new byte[ByteBufferType.values().length][];
    protected final char[][] f7320b = new char[CharBufferType.values().length][];

    /* compiled from: request_header_size */
    public enum ByteBufferType {
        READ_IO_BUFFER(4000),
        WRITE_ENCODING_BUFFER(4000),
        WRITE_CONCAT_BUFFER(2000),
        BASE64_CODEC_BUFFER(2000);
        
        protected final int size;

        private ByteBufferType(int i) {
            this.size = i;
        }
    }

    /* compiled from: request_header_size */
    public enum CharBufferType {
        TOKEN_BUFFER(2000),
        CONCAT_BUFFER(2000),
        TEXT_BUFFER(200),
        NAME_COPY_BUFFER(200);
        
        protected final int size;

        private CharBufferType(int i) {
            this.size = i;
        }
    }

    public final byte[] m11855a(ByteBufferType byteBufferType) {
        int ordinal = byteBufferType.ordinal();
        byte[] bArr = this.f7319a[ordinal];
        if (bArr == null) {
            return new byte[byteBufferType.size];
        }
        this.f7319a[ordinal] = null;
        return bArr;
    }

    public final void m11853a(ByteBufferType byteBufferType, byte[] bArr) {
        this.f7319a[byteBufferType.ordinal()] = bArr;
    }

    public final char[] m11856a(CharBufferType charBufferType) {
        return m11857a(charBufferType, 0);
    }

    public final char[] m11857a(CharBufferType charBufferType, int i) {
        if (charBufferType.size > i) {
            i = charBufferType.size;
        }
        int ordinal = charBufferType.ordinal();
        char[] cArr = this.f7320b[ordinal];
        if (cArr == null || cArr.length < i) {
            return new char[i];
        }
        this.f7320b[ordinal] = null;
        return cArr;
    }

    public final void m11854a(CharBufferType charBufferType, char[] cArr) {
        this.f7320b[charBufferType.ordinal()] = cArr;
    }

    private static byte[] m11851a(int i) {
        return new byte[i];
    }

    private static char[] m11852b(int i) {
        return new char[i];
    }
}
