package com.facebook.http.protocol;

import com.facebook.http.protocol.CountingOutputStreamWithProgress.ProgressListener;
import java.io.File;
import java.io.OutputStream;

/* compiled from: dialtone_mode_selection_interstitial_dismissed_by_other_interstitial */
public class ProgressDataStreamBody extends DataStreamBody {
    private final ProgressListener f5085b;

    public ProgressDataStreamBody(File file, String str, String str2, ProgressListener progressListener) {
        super(file, str, str2);
        this.f5085b = progressListener;
    }

    public final void mo621b(OutputStream outputStream) {
        super.mo621b(new CountingOutputStreamWithProgress(outputStream, this.f5085b));
    }
}
