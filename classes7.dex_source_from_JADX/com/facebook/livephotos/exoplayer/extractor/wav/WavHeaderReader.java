package com.facebook.livephotos.exoplayer.extractor.wav;

import android.util.Log;
import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;

/* compiled from: pageY */
final class WavHeaderReader {

    /* compiled from: pageY */
    final class ChunkHeader {
        public final int f7528a;
        public final long f7529b;

        private ChunkHeader(int i, long j) {
            this.f7528a = i;
            this.f7529b = j;
        }

        public static ChunkHeader m9209a(DefaultExtractorInput defaultExtractorInput, ParsableByteArray parsableByteArray) {
            defaultExtractorInput.m8846c(parsableByteArray.f7731a, 0, 8);
            parsableByteArray.m9337b(0);
            return new ChunkHeader(parsableByteArray.m9349m(), parsableByteArray.m9348l());
        }
    }

    WavHeaderReader() {
    }

    public static WavHeader m9210a(DefaultExtractorInput defaultExtractorInput) {
        Assertions.m9293a((Object) defaultExtractorInput);
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        if (ChunkHeader.m9209a(defaultExtractorInput, parsableByteArray).f7528a != Util.m9368c("RIFF")) {
            return null;
        }
        defaultExtractorInput.m8846c(parsableByteArray.f7731a, 0, 4);
        parsableByteArray.m9337b(0);
        int m = parsableByteArray.m9349m();
        if (m != Util.m9368c("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + m);
            return null;
        }
        ChunkHeader a = ChunkHeader.m9209a(defaultExtractorInput, parsableByteArray);
        if (a.f7528a != Util.m9368c("fmt ")) {
            throw new ParserException("Second chunk in RIFF WAV should be format; got: " + a.f7528a);
        }
        Assertions.m9297b(a.f7529b >= 16);
        defaultExtractorInput.m8846c(parsableByteArray.f7731a, 0, 16);
        parsableByteArray.m9337b(0);
        m = parsableByteArray.m9345h();
        int h = parsableByteArray.m9345h();
        int t = parsableByteArray.m9356t();
        int t2 = parsableByteArray.m9356t();
        int h2 = parsableByteArray.m9345h();
        int h3 = parsableByteArray.m9345h();
        int i = (h * h3) / 8;
        if (h2 != i) {
            throw new ParserException("Expected WAV block alignment of: " + i + "; got: " + h2);
        } else if (h3 != 16) {
            Log.e("WavHeaderReader", "Only 16-bit WAVs are supported; got: " + h3);
            return null;
        } else if (m == 1 || m == 65534) {
            defaultExtractorInput.m8845c(((int) a.f7529b) - 16);
            return new WavHeader(h, t, t2, h2, h3);
        } else {
            Log.e("WavHeaderReader", "Unsupported WAV format type: " + m);
            return null;
        }
    }

    public static void m9211a(DefaultExtractorInput defaultExtractorInput, WavHeader wavHeader) {
        long j;
        Assertions.m9293a((Object) defaultExtractorInput);
        Assertions.m9293a((Object) wavHeader);
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader a = ChunkHeader.m9209a(defaultExtractorInput, parsableByteArray);
        while (a.f7528a != Util.m9368c("data")) {
            Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a.f7528a);
            j = 8 + a.f7529b;
            if (a.f7528a == Util.m9368c("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + a.f7528a);
            }
            defaultExtractorInput.m8841b((int) j);
            a = ChunkHeader.m9209a(defaultExtractorInput, parsableByteArray);
        }
        defaultExtractorInput.m8841b(8);
        j = defaultExtractorInput.f6964d;
        long j2 = a.f7529b;
        wavHeader.f7526f = j;
        wavHeader.f7527g = j2;
    }
}
