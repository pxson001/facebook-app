package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.TiffUtil;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: TOPIC_NEIGHBORHOOD */
public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage> {
    private static final Class<?> f13771a = LocalContentUriThumbnailFetchProducer.class;
    private static final String[] f13772b = new String[]{"_id", "_data"};
    private static final String[] f13773c = new String[]{"_data"};
    private static final Rect f13774d = new Rect(0, 0, 512, 384);
    private static final Rect f13775e = new Rect(0, 0, 96, 96);
    private final ContentResolver f13776f;

    public LocalContentUriThumbnailFetchProducer(Executor executor, NativePooledByteBufferFactory nativePooledByteBufferFactory, ContentResolver contentResolver, boolean z) {
        super(executor, nativePooledByteBufferFactory, z);
        this.f13776f = contentResolver;
    }

    public final boolean mo1277a(ResizeOptions resizeOptions) {
        return ThumbnailSizeChecker.m23220a(f13774d.width(), f13774d.height(), resizeOptions);
    }

    @Nullable
    private EncodedImage m23133a(Uri uri, ResizeOptions resizeOptions) {
        Cursor query = this.f13776f.query(uri, f13772b, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            if (query.getCount() == 0) {
                return null;
            }
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("_data"));
            if (resizeOptions != null) {
                EncodedImage a = m23134a(resizeOptions, query.getInt(query.getColumnIndex("_id")));
                if (a != null) {
                    a.c(m23136b(string));
                    query.close();
                    return a;
                }
            }
            query.close();
            return null;
        } finally {
            query.close();
        }
    }

    protected final EncodedImage mo1275a(ImageRequest imageRequest) {
        Uri uri = imageRequest.c;
        if (UriUtil.e(uri)) {
            EncodedImage a = m23133a(uri, imageRequest.a);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    private EncodedImage m23134a(ResizeOptions resizeOptions, int i) {
        Throwable th;
        EncodedImage encodedImage = null;
        int b = m23135b(resizeOptions);
        if (b != 0) {
            Cursor queryMiniThumbnail;
            try {
                queryMiniThumbnail = Thumbnails.queryMiniThumbnail(this.f13776f, (long) i, b, f13773c);
                if (queryMiniThumbnail != null) {
                    try {
                        queryMiniThumbnail.moveToFirst();
                        if (queryMiniThumbnail.getCount() > 0) {
                            String string = queryMiniThumbnail.getString(queryMiniThumbnail.getColumnIndex("_data"));
                            if (new File(string).exists()) {
                                encodedImage = m23106b(new FileInputStream(string), m23132a(string));
                                if (queryMiniThumbnail != null) {
                                    queryMiniThumbnail.close();
                                }
                            }
                        }
                        if (queryMiniThumbnail != null) {
                            queryMiniThumbnail.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (queryMiniThumbnail != null) {
                            queryMiniThumbnail.close();
                        }
                        throw th;
                    }
                } else if (queryMiniThumbnail != null) {
                    queryMiniThumbnail.close();
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                queryMiniThumbnail = null;
                th = th4;
                if (queryMiniThumbnail != null) {
                    queryMiniThumbnail.close();
                }
                throw th;
            }
        }
        return encodedImage;
    }

    private static int m23135b(ResizeOptions resizeOptions) {
        if (ThumbnailSizeChecker.m23220a(f13775e.width(), f13775e.height(), resizeOptions)) {
            return 3;
        }
        if (ThumbnailSizeChecker.m23220a(f13774d.width(), f13774d.height(), resizeOptions)) {
            return 1;
        }
        return 0;
    }

    private static int m23132a(String str) {
        return str == null ? -1 : (int) new File(str).length();
    }

    protected final String mo1276a() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    private static int m23136b(String str) {
        int i = 0;
        if (str != null) {
            try {
                i = TiffUtil.a(new ExifInterface(str).getAttributeInt("Orientation", 1));
            } catch (Throwable e) {
                FLog.b(f13771a, e, "Unable to retrieve thumbnail rotation for %s", new Object[]{str});
            }
        }
        return i;
    }
}
