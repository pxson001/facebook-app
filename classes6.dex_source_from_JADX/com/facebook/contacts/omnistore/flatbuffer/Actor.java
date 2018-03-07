package com.facebook.contacts.omnistore.flatbuffer;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* compiled from: param_key_bug_report_description */
public final class Actor extends Table {
    public final String m12182a() {
        int a = a(4);
        return a != 0 ? c(a + this.a) : null;
    }

    public final Date m12181a(Date date) {
        int a = a(8);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        date.a = a;
        date.b = byteBuffer;
        return date;
    }

    public final float m12183e() {
        int a = a(12);
        return a != 0 ? this.b.getFloat(a + this.a) : 0.0f;
    }

    public final boolean m12184h() {
        int a = a(18);
        return (a == 0 || this.b.get(a + this.a) == (byte) 0) ? false : true;
    }

    public final boolean m12185i() {
        int a = a(20);
        return (a == 0 || this.b.get(a + this.a) == (byte) 0) ? false : true;
    }

    public final long m12186j() {
        int a = a(22);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final byte m12187m() {
        int a = a(28);
        return a != 0 ? this.b.get(a + this.a) : (byte) 0;
    }

    public final boolean m12188p() {
        int a = a(34);
        return (a == 0 || this.b.get(a + this.a) == (byte) 0) ? false : true;
    }

    public final String m12189r() {
        int a = a(38);
        return a != 0 ? c(a + this.a) : null;
    }

    public static int m12162a(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4, float f, float f2, boolean z, boolean z2, boolean z3, long j, boolean z4, byte b, byte b2, int i5, int i6, boolean z5, float f3, int i7) {
        flatBufferBuilder.m9968b(18);
        m12166a(flatBufferBuilder, j);
        m12180g(flatBufferBuilder, i7);
        m12172c(flatBufferBuilder, f3);
        m12179f(flatBufferBuilder, i6);
        m12177e(flatBufferBuilder, i5);
        m12169b(flatBufferBuilder, f2);
        m12164a(flatBufferBuilder, f);
        m12175d(flatBufferBuilder, i4);
        m12173c(flatBufferBuilder, i3);
        m12170b(flatBufferBuilder, i2);
        m12165a(flatBufferBuilder, i);
        m12178e(flatBufferBuilder, z5);
        m12168b(flatBufferBuilder, b2);
        m12163a(flatBufferBuilder, b);
        m12176d(flatBufferBuilder, z4);
        m12174c(flatBufferBuilder, z3);
        m12171b(flatBufferBuilder, z2);
        m12167a(flatBufferBuilder, z);
        return m12161a(flatBufferBuilder);
    }

    private static void m12165a(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(0, i, 0);
    }

    private static void m12170b(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(1, i, 0);
    }

    private static void m12173c(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(2, i, 0);
    }

    private static void m12175d(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(3, i, 0);
    }

    private static void m12164a(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.m9961a(4, f, 0.0d);
    }

    private static void m12169b(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.m9961a(5, f, 0.0d);
    }

    private static void m12167a(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.m9966a(6, z, false);
    }

    private static void m12171b(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.m9966a(7, z, false);
    }

    private static void m12174c(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.m9966a(8, z, false);
    }

    private static void m12166a(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.m9964a(9, j, 0);
    }

    private static void m12176d(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.m9966a(10, z, false);
    }

    private static void m12163a(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.m9959a(11, b, 0);
    }

    private static void m12168b(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.m9959a(12, b, 0);
    }

    private static void m12177e(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(13, i, 0);
    }

    private static void m12179f(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(14, i, 0);
    }

    private static void m12178e(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.m9966a(15, z, false);
    }

    private static void m12172c(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.m9961a(16, f, 0.0d);
    }

    private static void m12180g(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m9972c(17, i, 0);
    }

    private static int m12161a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.m9970c();
    }
}
