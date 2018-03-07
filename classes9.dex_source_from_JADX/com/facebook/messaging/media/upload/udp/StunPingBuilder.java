package com.facebook.messaging.media.upload.udp;

import com.facebook.messaging.media.upload.udp.StunPingManager.StunPingData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.zip.CRC32;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: last_resort_key */
public class StunPingBuilder extends UDPMessageBuilder {
    private StunPingData f12136f;

    public final StunPingBuilder m12650a(StunPingData stunPingData) {
        this.f12136f = stunPingData;
        return this;
    }

    private static byte[] m12649a(ByteBuffer byteBuffer, byte[] bArr) {
        try {
            Key secretKeySpec = new SecretKeySpec(bArr, "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            instance.update(byteBuffer.array(), 0, byteBuffer.position());
            return instance.doFinal();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static long m12648a(ByteBuffer byteBuffer) {
        try {
            CRC32 crc32 = new CRC32();
            crc32.update(byteBuffer.array(), 0, byteBuffer.position());
            return crc32.getValue() ^ 1398035790;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final UDPHeaderMessage m12651a() {
        if (this.f12136f == null || this.f12131a == null) {
            throw new IllegalStateException("Error in trying to write stun ping data to byte buffer");
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.f12131a);
        wrap.clear();
        wrap.order(ByteOrder.BIG_ENDIAN);
        wrap.putShort((short) 1);
        wrap.putShort((short) 0);
        wrap.putInt(554869826);
        wrap.putInt(this.f12136f.f12137a);
        wrap.putLong(this.f12136f.f12138b);
        int position = wrap.position();
        this.f12134d = position;
        byte[] bytes = this.f12136f.f12139c.getBytes(Charset.forName("UTF-8"));
        wrap.putShort((short) 6);
        wrap.putShort((short) bytes.length);
        wrap.put(bytes);
        int length = bytes.length % 4;
        if (length > 0) {
            wrap.position((4 - length) + wrap.position());
        }
        wrap.putShort(2, (short) ((wrap.position() - position) + 24));
        bytes = m12649a(wrap, this.f12136f.f12140d.getBytes(Charset.forName("UTF-8")));
        wrap.putShort((short) 8);
        wrap.putShort((short) 20);
        wrap.put(bytes);
        wrap.putShort(2, (short) ((wrap.position() - position) + 8));
        long a = m12648a(wrap);
        wrap.putShort((short) -32728);
        wrap.putShort((short) 4);
        wrap.putInt((int) a);
        this.f12133c = wrap.position() - this.f12134d;
        return new UDPHeaderMessage(this.f12131a, this.f12133c, this.f12134d);
    }
}
