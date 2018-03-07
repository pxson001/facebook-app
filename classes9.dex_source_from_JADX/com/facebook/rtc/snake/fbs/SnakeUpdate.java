package com.facebook.rtc.snake.fbs;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: appdiscovery_results_loader_key */
public final class SnakeUpdate extends Table {
    public static SnakeUpdate m19715a(ByteBuffer byteBuffer) {
        SnakeUpdate snakeUpdate = new SnakeUpdate();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        snakeUpdate.a = byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position();
        snakeUpdate.b = byteBuffer;
        return snakeUpdate;
    }
}
