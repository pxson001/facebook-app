package com.facebook.contacts.omnistore.flatbuffer;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: panoId */
public final class Contact extends Table {
    public static Contact m12192a(ByteBuffer byteBuffer) {
        Contact contact = new Contact();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        contact.a = byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position();
        contact.b = byteBuffer;
        return contact;
    }

    public final Actor m12204a(Actor actor) {
        int a = a(8);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        actor.a = a;
        actor.b = byteBuffer;
        return actor;
    }

    public final Name m12205a(Name name) {
        int a = a(10);
        return a != 0 ? name.m12218a(b(a + this.a), this.b) : null;
    }

    public final Name m12207b(Name name) {
        int a = a(12);
        return a != 0 ? name.m12218a(b(a + this.a), this.b) : null;
    }

    public final long m12210i() {
        int a = a(20);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final SquareImage m12206a(SquareImage squareImage) {
        int a = a(22);
        return a != 0 ? squareImage.m12223a(b(a + this.a), this.b) : null;
    }

    public final SquareImage m12208b(SquareImage squareImage) {
        int a = a(24);
        return a != 0 ? squareImage.m12223a(b(a + this.a), this.b) : null;
    }

    public final SquareImage m12209c(SquareImage squareImage) {
        int a = a(26);
        return a != 0 ? squareImage.m12223a(b(a + this.a), this.b) : null;
    }

    public static int m12191a(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, long j, int i8, int i9, int i10) {
        flatBufferBuilder.m9968b(12);
        m12193a(flatBufferBuilder, j);
        m12203k(flatBufferBuilder, i10);
        m12202j(flatBufferBuilder, i9);
        m12201i(flatBufferBuilder, i8);
        m12200h(flatBufferBuilder, i7);
        m12199g(flatBufferBuilder, i6);
        m12198f(flatBufferBuilder, i5);
        m12197e(flatBufferBuilder, i4);
        m12196d(flatBufferBuilder, i3);
        m12195c(flatBufferBuilder, i2);
        flatBufferBuilder.m9972c(0, i, 0);
        m12194a(flatBufferBuilder, z);
        return m12190a(flatBufferBuilder);
    }

    private static void m12195c(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(1, i, 0);
    }

    private static void m12196d(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(2, i, 0);
    }

    private static void m12197e(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(3, i, 0);
    }

    private static void m12198f(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(4, i, 0);
    }

    private static void m12199g(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(5, i, 0);
    }

    private static void m12194a(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.m9966a(6, z, false);
    }

    private static void m12200h(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(7, i, 0);
    }

    private static void m12193a(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.m9964a(8, j, 0);
    }

    private static void m12201i(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(9, i, 0);
    }

    private static void m12202j(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(10, i, 0);
    }

    private static void m12203k(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(11, i, 0);
    }

    private static int m12190a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.m9970c();
    }
}
