package com.facebook.tigon.tigonapi;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: non_fb4a_total_rss_kb */
public class FlatBuffersHelpers extends Table {
    static final Charset f5028c = Charset.forName("UTF-8");
    static final byte[] f5029d = new byte[64];

    public static String m6336a(ByteBuffer byteBuffer, int i) {
        byte[] bArr;
        int i2 = i + byteBuffer.getInt(i);
        int position = byteBuffer.position();
        int i3 = byteBuffer.getInt(i2);
        if (i3 <= f5029d.length) {
            bArr = f5029d;
        } else {
            bArr = new byte[i3];
        }
        byteBuffer.position(i2 + 4);
        byteBuffer.get(bArr, 0, i3);
        byteBuffer.position(position);
        return new String(bArr, 0, i3, f5028c);
    }
}
