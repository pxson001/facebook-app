package com.facebook.vault.protocol;

import com.facebook.http.protocol.CountingOutputStreamWithProgress.ProgressListener;
import java.io.File;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: threadProfileProtected */
public class VaultImageUploadParams {
    public final File f1866a;
    public final String f1867b;
    public final String f1868c;
    public final long f1869d;
    public final ProgressListener f1870e;

    public VaultImageUploadParams(File file, String str, String str2, long j, ProgressListener progressListener) {
        this.f1866a = file;
        this.f1867b = str;
        this.f1868c = str2;
        this.f1869d = j;
        this.f1870e = progressListener;
    }
}
