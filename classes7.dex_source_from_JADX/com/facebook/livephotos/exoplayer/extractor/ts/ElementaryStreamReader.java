package com.facebook.livephotos.exoplayer.extractor.ts;

import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_follow_see_first_error */
public abstract class ElementaryStreamReader {
    protected final TrackOutput f7327a;

    public abstract void mo434a();

    public abstract void mo435a(long j, boolean z);

    public abstract void mo436a(ParsableByteArray parsableByteArray);

    public abstract void mo437b();

    protected ElementaryStreamReader(TrackOutput trackOutput) {
        this.f7327a = trackOutput;
    }
}
