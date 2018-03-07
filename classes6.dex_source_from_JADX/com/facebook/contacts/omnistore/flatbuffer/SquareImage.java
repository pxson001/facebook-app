package com.facebook.contacts.omnistore.flatbuffer;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* compiled from: page_storefront_entry_grid */
public final class SquareImage extends Table {
    public final SquareImage m12223a(int i, ByteBuffer byteBuffer) {
        this.a = i;
        this.b = byteBuffer;
        return this;
    }

    public final String m12224a() {
        int a = a(4);
        return a != 0 ? c(a + this.a) : null;
    }

    public final int m12225b() {
        int a = a(6);
        return a != 0 ? this.b.getInt(a + this.a) : 0;
    }
}
