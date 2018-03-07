package com.facebook.storyteller.models;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

/* compiled from: me_tab */
public final class ProcessConfig extends Table {
    public static int m10770a(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4, boolean z, boolean z2, float f, int i5, boolean z3, float f2, int i6, int i7, boolean z4, float f3, int i8, boolean z5, int i9, float f4, float f5, int i10) {
        flatBufferBuilder.b(20);
        m10790j(flatBufferBuilder, i10);
        m10783e(flatBufferBuilder, f5);
        m10780d(flatBufferBuilder, f4);
        m10789i(flatBufferBuilder, i9);
        m10788h(flatBufferBuilder, i8);
        m10777c(flatBufferBuilder, f3);
        m10787g(flatBufferBuilder, i7);
        m10786f(flatBufferBuilder, i6);
        m10774b(flatBufferBuilder, f2);
        m10784e(flatBufferBuilder, i5);
        m10771a(flatBufferBuilder, f);
        m10781d(flatBufferBuilder, i4);
        m10778c(flatBufferBuilder, i3);
        m10775b(flatBufferBuilder, i2);
        m10772a(flatBufferBuilder, i);
        m10785e(flatBufferBuilder, z5);
        m10782d(flatBufferBuilder, z4);
        m10779c(flatBufferBuilder, z3);
        m10776b(flatBufferBuilder, z2);
        m10773a(flatBufferBuilder, z);
        return m10769a(flatBufferBuilder);
    }

    private static void m10772a(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.b(0, i, 14);
    }

    private static void m10775b(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.b(1, i, 4);
    }

    private static void m10778c(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.b(2, i, 30);
    }

    private static void m10781d(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.b(3, i, 2500000);
    }

    private static void m10773a(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.a(4, z, false);
    }

    private static void m10776b(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.a(5, z, false);
    }

    private static void m10771a(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.a(6, f, 0.0d);
    }

    private static void m10784e(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.b(7, i, 0);
    }

    private static void m10779c(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.a(8, z, false);
    }

    private static void m10774b(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.a(9, f, 0.0d);
    }

    private static void m10786f(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.b(10, i, 0);
    }

    private static void m10787g(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.b(11, i, 0);
    }

    private static void m10782d(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.a(12, z, true);
    }

    private static void m10777c(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.a(13, f, 0.0d);
    }

    private static void m10788h(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.b(14, i, 0);
    }

    private static void m10785e(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.a(15, z, false);
    }

    private static void m10789i(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.b(16, i, 0);
    }

    private static void m10780d(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.a(17, f, 0.0d);
    }

    private static void m10783e(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.a(18, f, 0.0d);
    }

    private static void m10790j(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.b(19, i, 0);
    }

    private static int m10769a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.c();
    }
}
