package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: TOPIC_OFFICE_SUPPLIES */
public class LocalContentUriFetchProducer extends LocalFetchProducer {
    private static final String[] f13769a = new String[]{"_id", "_data"};
    private final ContentResolver f13770b;

    public LocalContentUriFetchProducer(Executor executor, NativePooledByteBufferFactory nativePooledByteBufferFactory, ContentResolver contentResolver, boolean z) {
        super(executor, nativePooledByteBufferFactory, z);
        this.f13770b = contentResolver;
    }

    protected final EncodedImage mo1275a(ImageRequest imageRequest) {
        Object obj;
        Uri uri = imageRequest.c;
        if (UriUtil.c(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(UriUtil.a)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            InputStream openInputStream;
            if (uri.toString().endsWith("/photo")) {
                openInputStream = this.f13770b.openInputStream(uri);
            } else {
                openInputStream = Contacts.openContactPhotoInputStream(this.f13770b, uri);
                if (openInputStream == null) {
                    throw new IOException("Contact photo does not exist: " + uri);
                }
            }
            return m23106b(openInputStream, -1);
        }
        if (UriUtil.e(uri)) {
            EncodedImage a = m23128a(uri);
            if (a != null) {
                return a;
            }
        }
        return m23106b(this.f13770b.openInputStream(uri), -1);
    }

    @Nullable
    private EncodedImage m23128a(Uri uri) {
        EncodedImage encodedImage = null;
        Cursor query = this.f13770b.query(uri, f13769a, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("_data"));
                    if (string != null) {
                        encodedImage = m23106b(new FileInputStream(string), m23127a(string));
                        query.close();
                    } else {
                        query.close();
                    }
                }
            } finally {
                query.close();
            }
        }
        return encodedImage;
    }

    private static int m23127a(String str) {
        return str == null ? -1 : (int) new File(str).length();
    }

    protected final String mo1276a() {
        return "LocalContentUriFetchProducer";
    }
}
