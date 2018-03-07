package com.facebook.livephotos.exoplayer.extractor.ts;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_event_scroll_back_to_top_tapped */
final class Id3Reader extends ElementaryStreamReader {
    private final ParsableByteArray f7448b = new ParsableByteArray(10);
    private boolean f7449c;
    private long f7450d;
    private int f7451e;
    private int f7452f;

    public Id3Reader(TrackOutput trackOutput) {
        super(trackOutput);
        trackOutput.mo410a(MediaFormat.m8738a());
    }

    public final void mo434a() {
        this.f7449c = false;
    }

    public final void mo435a(long j, boolean z) {
        if (z) {
            this.f7449c = true;
            this.f7450d = j;
            this.f7451e = 0;
            this.f7452f = 0;
        }
    }

    public final void mo436a(ParsableByteArray parsableByteArray) {
        if (this.f7449c) {
            int b = parsableByteArray.m9336b();
            if (this.f7452f < 10) {
                int min = Math.min(b, 10 - this.f7452f);
                System.arraycopy(parsableByteArray.f7731a, parsableByteArray.f7732b, this.f7448b.f7731a, this.f7452f, min);
                if (min + this.f7452f == 10) {
                    this.f7448b.m9337b(6);
                    this.f7451e = this.f7448b.m9354r() + 10;
                }
            }
            this.f7327a.mo411a(parsableByteArray, b);
            this.f7452f = b + this.f7452f;
        }
    }

    public final void mo437b() {
        if (this.f7449c && this.f7451e != 0 && this.f7452f == this.f7451e) {
            this.f7327a.mo409a(this.f7450d, 1, this.f7451e, 0, null);
            this.f7449c = false;
        }
    }
}
