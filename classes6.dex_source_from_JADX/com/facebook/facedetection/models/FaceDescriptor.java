package com.facebook.facedetection.models;

import com.google.flatbuffers.Table;

/* compiled from: null record */
public final class FaceDescriptor extends Table {
    public final float m15576a() {
        int a = a(4);
        return a != 0 ? this.b.getFloat(a + this.a) : 0.0f;
    }

    public final float m15577b() {
        int a = a(6);
        return a != 0 ? this.b.getFloat(a + this.a) : 0.0f;
    }

    public final float m15578c() {
        int a = a(8);
        return a != 0 ? this.b.getFloat(a + this.a) : 0.0f;
    }

    public final float m15579d() {
        int a = a(10);
        return a != 0 ? this.b.getFloat(a + this.a) : 0.0f;
    }

    public final byte m15580e() {
        int a = a(12);
        return a != 0 ? this.b.get(a + this.a) : (byte) 0;
    }

    public final float m15581f() {
        int a = a(14);
        return a != 0 ? this.b.getFloat(a + this.a) : 0.0f;
    }
}
