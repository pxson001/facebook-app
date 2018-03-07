package com.facebook.rtc.snake.fbs;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* compiled from: application/* */
public final class SnakeBoard extends Table {
    public final Snake m19711f(int i) {
        Snake snake;
        Snake snake2 = new Snake();
        int a = a(4);
        if (a != 0) {
            a = b(e(a) + (i * 4));
            ByteBuffer byteBuffer = this.b;
            snake2.a = a;
            snake2.b = byteBuffer;
            snake = snake2;
        } else {
            snake = null;
        }
        return snake;
    }

    public final int m19709a() {
        int a = a(4);
        return a != 0 ? d(a) : 0;
    }

    public final Coordinate m19710b() {
        Coordinate coordinate = new Coordinate();
        int a = a(6);
        return a != 0 ? coordinate.m19703a(a + this.a, this.b) : null;
    }
}
