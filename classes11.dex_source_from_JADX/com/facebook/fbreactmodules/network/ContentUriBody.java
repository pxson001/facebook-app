package com.facebook.fbreactmodules.network;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.http.entity.mime.apache.content.AbstractContentBody;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closeables;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: edit_featured_photos */
public class ContentUriBody extends AbstractContentBody {
    private final Uri f7493b;
    private final ContentResolver f7494c;
    private final String f7495d;

    public ContentUriBody(ContentResolver contentResolver, Uri uri, String str, String str2) {
        super(str);
        this.f7493b = uri;
        this.f7494c = contentResolver;
        this.f7495d = str2;
    }

    public final String m8688a() {
        return this.f7495d;
    }

    public final void m8689a(OutputStream outputStream) {
        InputStream openInputStream = this.f7494c.openInputStream(this.f7493b);
        try {
            ByteStreams.a(openInputStream, outputStream);
        } finally {
            Closeables.a(openInputStream);
        }
    }

    public final String m8690b() {
        return null;
    }

    public final String m8691c() {
        return "binary";
    }

    public final long m8692d() {
        return -1;
    }
}
