package com.facebook.livephotos.exoplayer.extractor.flv;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.extractor.flv.TagPayloadReader.UnsupportedFormatException;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil.SpsData;
import com.facebook.livephotos.exoplayer.util.ParsableBitArray;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

/* compiled from: page_remove_from_favorites_success */
public final class VideoTagPayloadReader extends TagPayloadReader {
    private final ParsableByteArray f7075b = new ParsableByteArray(NalUnitUtil.f7723a);
    private final ParsableByteArray f7076c = new ParsableByteArray(4);
    private int f7077d;
    private boolean f7078e;
    private int f7079f;

    /* compiled from: page_remove_from_favorites_success */
    final class AvcSequenceHeaderData {
        public final List<byte[]> f7070a;
        public final int f7071b;
        public final float f7072c;
        public final int f7073d;
        public final int f7074e;

        public AvcSequenceHeaderData(List<byte[]> list, int i, int i2, int i3, float f) {
            this.f7070a = list;
            this.f7071b = i;
            this.f7072c = f;
            this.f7073d = i2;
            this.f7074e = i3;
        }
    }

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    protected final boolean mo426a(ParsableByteArray parsableByteArray) {
        int f = parsableByteArray.m9343f();
        int i = (f >> 4) & 15;
        f &= 15;
        if (f != 7) {
            throw new UnsupportedFormatException("Video format not supported: " + f);
        }
        this.f7079f = i;
        return i != 5;
    }

    protected final void mo425a(ParsableByteArray parsableByteArray, long j) {
        int f = parsableByteArray.m9343f();
        long j2 = j + (((long) parsableByteArray.m9346j()) * 1000);
        if (f == 0 && !this.f7078e) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.m9336b()]);
            parsableByteArray.m9335a(parsableByteArray2.f7731a, 0, parsableByteArray.m9336b());
            AvcSequenceHeaderData b = m8941b(parsableByteArray2);
            this.f7077d = b.f7071b;
            this.f7051a.mo410a(MediaFormat.m8739a(null, "video/avc", -1, -1, m8919a(), b.f7073d, b.f7074e, b.f7070a, -1, b.f7072c));
            this.f7078e = true;
        } else if (f == 1) {
            byte[] bArr = this.f7076c.f7731a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            f = 4 - this.f7077d;
            int i = 0;
            while (parsableByteArray.m9336b() > 0) {
                parsableByteArray.m9335a(this.f7076c.f7731a, f, this.f7077d);
                this.f7076c.m9337b(0);
                int s = this.f7076c.m9355s();
                this.f7075b.m9337b(0);
                this.f7051a.mo411a(this.f7075b, 4);
                int i2 = i + 4;
                this.f7051a.mo411a(parsableByteArray, s);
                i = i2 + s;
            }
            this.f7051a.mo409a(j2, this.f7079f == 1 ? 1 : 0, i, 0, null);
        }
    }

    private static AvcSequenceHeaderData m8941b(ParsableByteArray parsableByteArray) {
        boolean z;
        int i;
        int i2;
        int i3 = -1;
        parsableByteArray.m9337b(4);
        int f = (parsableByteArray.m9343f() & 3) + 1;
        if (f != 3) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m9297b(z);
        List arrayList = new ArrayList();
        int f2 = parsableByteArray.m9343f() & 31;
        for (i = 0; i < f2; i++) {
            arrayList.add(NalUnitUtil.m9317a(parsableByteArray));
        }
        int f3 = parsableByteArray.m9343f();
        for (i = 0; i < f3; i++) {
            arrayList.add(NalUnitUtil.m9317a(parsableByteArray));
        }
        float f4 = 1.0f;
        if (f2 > 0) {
            ParsableBitArray parsableBitArray = new ParsableBitArray((byte[]) arrayList.get(0));
            parsableBitArray.m9322a((f + 1) * 8);
            SpsData a = NalUnitUtil.m9313a(parsableBitArray);
            i2 = a.f7714b;
            i3 = a.f7715c;
            f4 = a.f7716d;
        } else {
            i2 = -1;
        }
        return new AvcSequenceHeaderData(arrayList, f, i2, i3, f4);
    }
}
