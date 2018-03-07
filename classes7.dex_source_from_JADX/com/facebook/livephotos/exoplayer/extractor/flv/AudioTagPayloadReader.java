package com.facebook.livephotos.exoplayer.extractor.flv;

import android.util.Pair;
import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.extractor.flv.TagPayloadReader.UnsupportedFormatException;
import com.facebook.livephotos.exoplayer.util.CodecSpecificDataUtil;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import java.util.Collections;

/* compiled from: page_service_card_client_impression */
public final class AudioTagPayloadReader extends TagPayloadReader {
    private static final int[] f7053b = new int[]{5500, 11000, 22000, 44000};
    private boolean f7054c;
    private boolean f7055d;

    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    protected final boolean mo426a(ParsableByteArray parsableByteArray) {
        if (this.f7054c) {
            parsableByteArray.m9339c(1);
        } else {
            int f = parsableByteArray.m9343f();
            int i = (f >> 4) & 15;
            f = (f >> 2) & 3;
            if (f < 0 || f >= f7053b.length) {
                throw new UnsupportedFormatException("Invalid sample rate index: " + f);
            } else if (i != 10) {
                throw new UnsupportedFormatException("Audio format not supported: " + i);
            } else {
                this.f7054c = true;
            }
        }
        return true;
    }

    protected final void mo425a(ParsableByteArray parsableByteArray, long j) {
        int f = parsableByteArray.m9343f();
        if (f == 0 && !this.f7055d) {
            Object obj = new byte[parsableByteArray.m9336b()];
            parsableByteArray.m9335a(obj, 0, obj.length);
            Pair a = CodecSpecificDataUtil.m9299a(obj);
            this.f7051a.mo410a(MediaFormat.m8740a(null, "audio/mp4a-latm", -1, -1, m8919a(), ((Integer) a.second).intValue(), ((Integer) a.first).intValue(), Collections.singletonList(obj), null));
            this.f7055d = true;
        } else if (f == 1) {
            int b = parsableByteArray.m9336b();
            this.f7051a.mo411a(parsableByteArray, b);
            this.f7051a.mo409a(j, 1, b, 0, null);
        }
    }
}
