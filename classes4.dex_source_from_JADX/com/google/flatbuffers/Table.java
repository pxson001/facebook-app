package com.google.flatbuffers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: graphql_cache-journal */
public class Table {
    public int f10990a;
    public ByteBuffer f10991b;

    public final int m11443a(int i) {
        int i2 = this.f10990a - this.f10991b.getInt(this.f10990a);
        return i < this.f10991b.getShort(i2) ? this.f10991b.getShort(i2 + i) : 0;
    }

    public final int m11444b(int i) {
        return this.f10991b.getInt(i) + i;
    }

    public final String m11445c(int i) {
        int i2 = i + this.f10991b.getInt(i);
        if (this.f10991b.hasArray()) {
            return new String(this.f10991b.array(), (this.f10991b.arrayOffset() + i2) + 4, this.f10991b.getInt(i2), FlatBufferBuilder.c);
        }
        ByteBuffer order = this.f10991b.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        byte[] bArr = new byte[order.getInt(i2)];
        order.position(i2 + 4);
        order.get(bArr);
        return new String(bArr, 0, bArr.length, FlatBufferBuilder.c);
    }

    public final int m11446d(int i) {
        int i2 = this.f10990a + i;
        return this.f10991b.getInt(i2 + this.f10991b.getInt(i2));
    }

    public final int m11447e(int i) {
        int i2 = this.f10990a + i;
        return (i2 + this.f10991b.getInt(i2)) + 4;
    }
}
