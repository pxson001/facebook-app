package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: TOPIC_METADATA */
public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
    private final Executor f13795a;

    public LocalVideoThumbnailProducer(Executor executor) {
        this.f13795a = executor;
    }

    public final void m23164a(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener producerListener = producerContext.c;
        String str = producerContext.b;
        final ImageRequest imageRequest = producerContext.a;
        final C13111 c13111 = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(this, consumer, producerListener, "VideoThumbnailProducer", str) {
            final /* synthetic */ LocalVideoThumbnailProducer f13792c;

            protected final void m23160b(Object obj) {
                CloseableReference.c((CloseableReference) obj);
            }

            protected final Map m23162c(Object obj) {
                return ImmutableMap.a("createdThumbnail", String.valueOf(((CloseableReference) obj) != null));
            }

            protected final Object m23161c() {
                int i;
                int i2;
                Bitmap createVideoThumbnail;
                String path = imageRequest.m().getPath();
                ImageRequest imageRequest = imageRequest;
                if (imageRequest.a != null) {
                    i = imageRequest.a.a;
                } else {
                    i = 2048;
                }
                if (i <= 96) {
                    if (imageRequest.a != null) {
                        i = imageRequest.a.b;
                    } else {
                        i = 2048;
                    }
                    if (i <= 96) {
                        i2 = 3;
                        createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(path, i2);
                        if (createVideoThumbnail != null) {
                            return null;
                        }
                        return CloseableReference.a(new CloseableStaticBitmap(createVideoThumbnail, SimpleBitmapReleaser.a(), ImmutableQualityInfo.a, 0));
                    }
                }
                i2 = 1;
                createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(path, i2);
                if (createVideoThumbnail != null) {
                    return CloseableReference.a(new CloseableStaticBitmap(createVideoThumbnail, SimpleBitmapReleaser.a(), ImmutableQualityInfo.a, 0));
                }
                return null;
            }
        };
        producerContext.a(new BaseProducerContextCallbacks(this) {
            final /* synthetic */ LocalVideoThumbnailProducer f13794b;

            public final void m23163a() {
                c13111.a();
            }
        });
        ExecutorDetour.a(this.f13795a, c13111, 1586676618);
    }
}
