package com.facebook.livephotos.exoplayer.extractor.flv;

import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_service_card_cross_out */
public abstract class TagPayloadReader {
    protected final TrackOutput f7051a;
    public long f7052b = -1;

    /* compiled from: page_service_card_cross_out */
    public final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str);
        }
    }

    protected abstract void mo425a(ParsableByteArray parsableByteArray, long j);

    protected abstract boolean mo426a(ParsableByteArray parsableByteArray);

    protected TagPayloadReader(TrackOutput trackOutput) {
        this.f7051a = trackOutput;
    }

    public final long m8919a() {
        return this.f7052b;
    }

    public final void m8922b(ParsableByteArray parsableByteArray, long j) {
        if (mo426a(parsableByteArray)) {
            mo425a(parsableByteArray, j);
        }
    }
}
