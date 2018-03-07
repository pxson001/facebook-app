package com.facebook.messaging.camerautil.gallery;

import android.content.ContentResolver;
import android.net.Uri;

/* compiled from: messenger_record_error */
public class SingleImageList implements IImageList {
    private static final Class<?> f9730a = SingleImageList.class;
    private IImage f9731b;
    private Uri f9732c;

    public SingleImageList(ContentResolver contentResolver, Uri uri) {
        this.f9732c = uri;
        this.f9731b = new UriImage(this, contentResolver, uri);
    }

    public final int mo388b() {
        return 1;
    }

    public final IImage mo385a(int i) {
        return i == 0 ? this.f9731b : null;
    }

    public final IImage mo386a(Uri uri) {
        return uri.equals(this.f9732c) ? this.f9731b : null;
    }

    public final void mo387a() {
        this.f9731b = null;
        this.f9732c = null;
    }
}
