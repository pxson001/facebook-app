package com.facebook.flatbuffers;

import com.facebook.common.stringformat.StringFormatUtil;
import java.nio.ByteBuffer;

/* compiled from: users_db */
public class DeltaBuffer$DeltaIndex {
    public final int f402a;
    public final int f403b;
    public final int f404c;

    public DeltaBuffer$DeltaIndex(int i, int i2, int i3) {
        this.f402a = i;
        this.f403b = i2;
        this.f404c = i3;
    }

    public DeltaBuffer$DeltaIndex(ByteBuffer byteBuffer, int i) {
        this.f403b = byteBuffer.getInt(i + 4);
        if (this.f403b == 0) {
            this.f402a = 0;
            this.f404c = 0;
        } else {
            this.f402a = byteBuffer.getInt(i) + i;
            this.f404c = (i + 8) + byteBuffer.getInt(i + 8);
        }
        if (this.f402a >= byteBuffer.limit() || this.f402a + this.f403b > byteBuffer.limit() || this.f404c >= byteBuffer.limit()) {
            throw new IndexOutOfBoundsException(StringFormatUtil.formatStrLocaleSafe("DeltaIndex out of bound, limit=%d, start=%d, size=%d, pivot=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(this.f402a), Integer.valueOf(this.f403b), Integer.valueOf(this.f404c)));
        }
    }

    public final int m683a() {
        switch (this.f403b) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 4:
                return 4;
            default:
                return 8;
        }
    }

    public final void m684a(FlatBufferBuilder flatBufferBuilder) {
        if (this.f403b == 0) {
            flatBufferBuilder.b(0);
            flatBufferBuilder.a(0);
            flatBufferBuilder.b(0);
            return;
        }
        flatBufferBuilder.b(this.f404c);
        flatBufferBuilder.a(this.f403b);
        flatBufferBuilder.b(this.f402a);
    }
}
