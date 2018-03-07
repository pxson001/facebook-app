package com.facebook.livephotos.exoplayer.extractor.ts;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.text.eia608.Eia608Parser;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_admin_invite_decline */
final class SeiReader {
    private final TrackOutput f7485a;

    public SeiReader(TrackOutput trackOutput) {
        this.f7485a = trackOutput;
        trackOutput.mo410a(MediaFormat.m8742a(null, "application/eia-608", -1, -1, null));
    }

    public final void m9178a(long j, ParsableByteArray parsableByteArray) {
        while (parsableByteArray.m9336b() > 1) {
            int f;
            int i = 0;
            do {
                f = parsableByteArray.m9343f();
                i += f;
            } while (f == 255);
            int i2 = 0;
            do {
                f = parsableByteArray.m9343f();
                i2 += f;
            } while (f == 255);
            if (Eia608Parser.m9251a(i, i2, parsableByteArray)) {
                this.f7485a.mo411a(parsableByteArray, i2);
                this.f7485a.mo409a(j, 1, i2, 0, null);
            } else {
                parsableByteArray.m9339c(i2);
            }
        }
    }
}
