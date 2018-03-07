package com.facebook.rtc.snake.fbs;

import com.google.flatbuffers.Table;

/* compiled from: application/java-vm */
public final class Snake extends Table {
    public final long m19706a() {
        int a = a(4);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final Coordinate m19708f(int i) {
        Coordinate coordinate = new Coordinate();
        int a = a(8);
        return a != 0 ? coordinate.m19703a(e(a) + (i * 4), this.b) : null;
    }

    public final int m19707b() {
        int a = a(8);
        return a != 0 ? d(a) : 0;
    }
}
