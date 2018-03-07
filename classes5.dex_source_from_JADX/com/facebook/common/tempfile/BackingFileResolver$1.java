package com.facebook.common.tempfile;

import android.net.Uri;
import com.google.common.io.ByteSource;
import java.io.InputStream;

/* compiled from: showSoftInputUnchecked */
class BackingFileResolver$1 extends ByteSource {
    final /* synthetic */ Uri f2730a;
    final /* synthetic */ BackingFileResolver f2731b;

    BackingFileResolver$1(BackingFileResolver backingFileResolver, Uri uri) {
        this.f2731b = backingFileResolver;
        this.f2730a = uri;
    }

    public final InputStream m3844a() {
        return this.f2731b.b.openInputStream(this.f2730a);
    }
}
