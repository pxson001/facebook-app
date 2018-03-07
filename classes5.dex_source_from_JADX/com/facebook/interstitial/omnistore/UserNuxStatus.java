package com.facebook.interstitial.omnistore;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: TOPIC_BAR_CHECKIN_SUGGESTIFIER */
public class UserNuxStatus extends Table {
    public static UserNuxStatus m23262a(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        UserNuxStatus userNuxStatus = new UserNuxStatus();
        userNuxStatus.a = byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position();
        userNuxStatus.b = byteBuffer;
        return userNuxStatus;
    }

    public final long m23263d() {
        int a = a(10);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }
}
