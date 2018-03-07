package com.facebook.contacts.omnistore.flatbuffer;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* compiled from: pandora_benny_photos_of_small_thumbnail_target_and_mutual_friends */
public final class ContactEntry extends Table {
    public final ContactEntry m12212a(int i, ByteBuffer byteBuffer) {
        this.a = i;
        this.b = byteBuffer;
        return this;
    }

    public final boolean m12213a() {
        int a = a(4);
        return (a == 0 || this.b.get(a + this.a) == (byte) 0) ? false : true;
    }

    public final ContactField m12214b() {
        ContactField contactField;
        ContactField contactField2 = new ContactField();
        int a = a(6);
        if (a != 0) {
            a = b(a + this.a);
            ByteBuffer byteBuffer = this.b;
            contactField2.a = a;
            contactField2.b = byteBuffer;
            contactField = contactField2;
        } else {
            contactField = null;
        }
        return contactField;
    }

    public static int m12211a(FlatBufferBuilder flatBufferBuilder, boolean z, int i) {
        flatBufferBuilder.m9968b(2);
        flatBufferBuilder.m9972c(1, i, 0);
        flatBufferBuilder.m9966a(0, z, false);
        return flatBufferBuilder.m9970c();
    }
}
