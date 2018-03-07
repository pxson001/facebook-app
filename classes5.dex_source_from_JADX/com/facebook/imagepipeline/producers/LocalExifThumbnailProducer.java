package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.TiffUtil;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: TOPIC_MUSEUM */
public class LocalExifThumbnailProducer implements ThumbnailProducer<EncodedImage> {
    private final Executor f13781a;
    public final NativePooledByteBufferFactory f13782b;
    private final ContentResolver f13783c;

    public LocalExifThumbnailProducer(Executor executor, NativePooledByteBufferFactory nativePooledByteBufferFactory, ContentResolver contentResolver) {
        this.f13781a = executor;
        this.f13782b = nativePooledByteBufferFactory;
        this.f13783c = contentResolver;
    }

    public final void m23148a(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ProducerListener producerListener = producerContext.c;
        String str = producerContext.b;
        final ImageRequest imageRequest = producerContext.a;
        final C13061 c13061 = new StatefulProducerRunnable<EncodedImage>(this, consumer, producerListener, "LocalExifThumbnailProducer", str) {
            final /* synthetic */ LocalExifThumbnailProducer f13778c;

            protected final void m23140b(Object obj) {
                EncodedImage.d((EncodedImage) obj);
            }

            protected final Map m23142c(Object obj) {
                return ImmutableMap.a("createdThumbnail", Boolean.toString(((EncodedImage) obj) != null));
            }

            protected final Object m23141c() {
                ExifInterface a = this.f13778c.m23147a(imageRequest.c);
                if (a == null || !a.hasThumbnail()) {
                    return null;
                }
                return LocalExifThumbnailProducer.m23145a(this.f13778c, this.f13778c.f13782b.a(a.getThumbnail()), a);
            }
        };
        producerContext.a(new BaseProducerContextCallbacks(this) {
            final /* synthetic */ LocalExifThumbnailProducer f13780b;

            public final void m23143a() {
                c13061.a();
            }
        });
        ExecutorDetour.a(this.f13781a, c13061, -184559514);
    }

    public final boolean mo1277a(ResizeOptions resizeOptions) {
        return ThumbnailSizeChecker.m23220a(512, 512, resizeOptions);
    }

    @VisibleForTesting
    final ExifInterface m23147a(Uri uri) {
        String b = m23146b(uri);
        Object obj = null;
        if (b != null) {
            File file = new File(b);
            if (file.exists() && file.canRead()) {
                obj = 1;
            }
        }
        if (obj != null) {
            return new ExifInterface(b);
        }
        return null;
    }

    public static EncodedImage m23145a(LocalExifThumbnailProducer localExifThumbnailProducer, NativePooledByteBuffer nativePooledByteBuffer, ExifInterface exifInterface) {
        int intValue;
        EncodedImage a = BitmapUtil.a(new PooledByteBufferInputStream(nativePooledByteBuffer));
        int a2 = m23144a(exifInterface);
        int intValue2 = a != null ? ((Integer) a.first).intValue() : -1;
        if (a != null) {
            intValue = ((Integer) a.second).intValue();
        } else {
            intValue = -1;
        }
        CloseableReference a3 = CloseableReference.a(nativePooledByteBuffer);
        try {
            a = new EncodedImage(a3);
            a.a(ImageFormat.JPEG);
            a.c(a2);
            a.b(intValue2);
            a.a(intValue);
            return a;
        } finally {
            CloseableReference.c(a3);
        }
    }

    private static int m23144a(ExifInterface exifInterface) {
        return TiffUtil.a(Integer.parseInt(exifInterface.getAttribute("Orientation")));
    }

    private String m23146b(Uri uri) {
        Throwable th;
        Cursor cursor = null;
        if (UriUtil.c(uri)) {
            try {
                String string;
                Cursor query = this.f13783c.query(uri, null, null, null, null);
                if (query != null) {
                    try {
                        query.moveToFirst();
                        string = query.getString(query.getColumnIndex("_data"));
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                string = null;
                if (query == null) {
                    return string;
                }
                query.close();
                return string;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else if (UriUtil.b(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }
}
