package com.facebook.contacts.omnistore.flatbuffer;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* compiled from: pandora_benny_photos_of_large_thumbnail_all_photos */
public final class NamePart extends Table {
    public final int m12220b() {
        int a = a(6);
        return a != 0 ? this.b.getInt(a + this.a) : 0;
    }

    public final int m12221c() {
        int a = a(8);
        return a != 0 ? this.b.getInt(a + this.a) : 0;
    }

    public static int m12219a(FlatBufferBuilder flatBufferBuilder, byte b, int i, int i2) {
        flatBufferBuilder.m9968b(3);
        flatBufferBuilder.m9969b(2, i2, 0);
        flatBufferBuilder.m9969b(1, i, 0);
        flatBufferBuilder.m9959a(0, b, 0);
        return flatBufferBuilder.m9970c();
    }
}
