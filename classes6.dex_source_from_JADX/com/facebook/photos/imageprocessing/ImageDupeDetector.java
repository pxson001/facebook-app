package com.facebook.photos.imageprocessing;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.ListDataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.soloader.SoLoader;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: hashtag_feed_id */
public class ImageDupeDetector {
    private static final CallerContext f13071a = CallerContext.a(ImageDupeDetector.class, "creative_editing");
    private static final String f13072b = ImageDupeDetector.class.getSimpleName();
    private static final ResizeOptions f13073c = new ResizeOptions(256, 256);
    public final ImagePipeline f13074d;
    private final ListeningExecutorService f13075e;
    private final QuickPerformanceLogger f13076f;
    public final Object f13077g = new Object();
    public volatile float f13078h = SimilarityScore.SIMILARITY_ERROR;

    /* compiled from: hashtag_feed_id */
    class BitmapSimilarityDataSubscriber extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>> {
        final /* synthetic */ ImageDupeDetector f13064a;
        @Nullable
        private final Uri f13065b;
        private final double f13066c;
        private final int f13067d;
        @Nullable
        private final Uri f13068e;
        private final double f13069f;
        private final int f13070g;

        BitmapSimilarityDataSubscriber(ImageDupeDetector imageDupeDetector, @Nullable Uri uri, double d, int i, @Nullable Uri uri2, double d2, int i2) {
            this.f13064a = imageDupeDetector;
            this.f13065b = uri;
            this.f13066c = d;
            this.f13067d = i;
            this.f13068e = uri2;
            this.f13069f = d2;
            this.f13070g = i2;
        }

        protected final void m20398e(DataSource<List<CloseableReference<CloseableImage>>> dataSource) {
            List<CloseableReference> list;
            if (dataSource != null) {
                try {
                    if (dataSource.c()) {
                        list = (List) dataSource.d();
                        if (list != null) {
                            try {
                                if (!list.isEmpty()) {
                                    List arrayList = new ArrayList();
                                    for (CloseableReference closeableReference : list) {
                                        if (closeableReference != null && (closeableReference.a() instanceof CloseableBitmap)) {
                                            arrayList.add(((CloseableBitmap) closeableReference.a()).a());
                                        }
                                    }
                                    if (arrayList.size() != 2) {
                                        ImageDupeDetector.m20404b(this.f13064a);
                                        if (list != null) {
                                            for (CloseableReference c : list) {
                                                CloseableReference.c(c);
                                            }
                                        }
                                        if (this.f13065b != null) {
                                            this.f13064a.f13074d.a(this.f13065b);
                                        }
                                        if (this.f13068e != null) {
                                            this.f13064a.f13074d.a(this.f13068e);
                                            return;
                                        }
                                        return;
                                    }
                                    this.f13064a.f13078h = SimilarityScore.similarityScore((Bitmap) arrayList.get(0), this.f13066c, this.f13067d, (Bitmap) arrayList.get(1), this.f13069f, this.f13070g);
                                    ImageDupeDetector.f13072b;
                                    Object[] objArr = new Object[]{Integer.valueOf(((Bitmap) arrayList.get(0)).getWidth()), Integer.valueOf(((Bitmap) arrayList.get(0)).getHeight()), Integer.valueOf(((Bitmap) arrayList.get(1)).getWidth()), Integer.valueOf(((Bitmap) arrayList.get(1)).getHeight()), Float.valueOf(this.f13064a.f13078h)};
                                    synchronized (this.f13064a.f13077g) {
                                        ObjectDetour.b(this.f13064a.f13077g, 803947391);
                                    }
                                    if (list != null) {
                                        for (CloseableReference c2 : list) {
                                            CloseableReference.c(c2);
                                        }
                                    }
                                    if (this.f13065b != null) {
                                        this.f13064a.f13074d.a(this.f13065b);
                                    }
                                    if (this.f13068e != null) {
                                        this.f13064a.f13074d.a(this.f13068e);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                if (list != null) {
                                    for (CloseableReference c22 : list) {
                                        CloseableReference.c(c22);
                                    }
                                }
                                if (this.f13065b != null) {
                                    this.f13064a.f13074d.a(this.f13065b);
                                }
                                if (this.f13068e != null) {
                                    this.f13064a.f13074d.a(this.f13068e);
                                }
                                throw th2;
                            }
                        }
                        ImageDupeDetector.m20404b(this.f13064a);
                        if (list != null) {
                            for (CloseableReference c222 : list) {
                                CloseableReference.c(c222);
                            }
                        }
                        if (this.f13065b != null) {
                            this.f13064a.f13074d.a(this.f13065b);
                        }
                        if (this.f13068e != null) {
                            this.f13064a.f13074d.a(this.f13068e);
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    List list2 = null;
                    th2 = th4;
                    if (list != null) {
                        while (r2.hasNext()) {
                            CloseableReference.c(c222);
                        }
                    }
                    if (this.f13065b != null) {
                        this.f13064a.f13074d.a(this.f13065b);
                    }
                    if (this.f13068e != null) {
                        this.f13064a.f13074d.a(this.f13068e);
                    }
                    throw th2;
                }
            }
            ImageDupeDetector.m20404b(this.f13064a);
            if (this.f13065b != null) {
                this.f13064a.f13074d.a(this.f13065b);
            }
            if (this.f13068e != null) {
                this.f13064a.f13074d.a(this.f13068e);
            }
        }

        protected final void m20399f(DataSource<List<CloseableReference<CloseableImage>>> dataSource) {
            try {
                ImageDupeDetector.m20404b(this.f13064a);
            } finally {
                dataSource.g();
            }
        }
    }

    /* compiled from: hashtag_feed_id */
    public class SimilarityScore {
        @DoNotStrip
        public static final float SIMILARITY_ERROR = -2222.0f;

        private static native float similarityScore(Bitmap bitmap, double d, int i, Bitmap bitmap2, double d2, int i2);

        static {
            SoLoader.a("fb_creativeediting");
        }
    }

    public static ImageDupeDetector m20403b(InjectorLike injectorLike) {
        return new ImageDupeDetector(ImagePipelineMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ImageDupeDetector(ImagePipeline imagePipeline, ListeningExecutorService listeningExecutorService, QuickPerformanceLogger quickPerformanceLogger) {
        this.f13074d = imagePipeline;
        this.f13075e = listeningExecutorService;
        this.f13076f = quickPerformanceLogger;
    }

    @DoNotStrip
    public synchronized float similarityScore(String str, double d, int i, boolean z, String str2, double d2, int i2, boolean z2) {
        this.f13076f.b(2228228);
        this.f13078h = SimilarityScore.SIMILARITY_ERROR;
        Uri fromFile = Uri.fromFile(new File(str));
        DataSource c = this.f13074d.c(ImageRequestBuilder.a(fromFile).a(f13073c).m(), f13071a);
        Uri fromFile2 = Uri.fromFile(new File(str2));
        DataSource c2 = this.f13074d.c(ImageRequestBuilder.a(fromFile2).a(f13073c).m(), f13071a);
        if (z) {
            fromFile = null;
        }
        if (z2) {
            fromFile2 = null;
        }
        BitmapSimilarityDataSubscriber bitmapSimilarityDataSubscriber = new BitmapSimilarityDataSubscriber(this, fromFile, d, i, fromFile2, d2, i2);
        ListDataSource a = ListDataSource.a(new DataSource[]{c, c2});
        a.a(bitmapSimilarityDataSubscriber, this.f13075e);
        try {
            synchronized (this.f13077g) {
                ObjectDetour.a(this.f13077g, 2000, -1313163536);
            }
            this.f13076f.b(2228228, (short) 2);
        } catch (InterruptedException e) {
            this.f13076f.d(2228228);
        }
        a.g();
        return this.f13078h;
    }

    public static void m20404b(ImageDupeDetector imageDupeDetector) {
        imageDupeDetector.f13076f.d(2228228);
        synchronized (imageDupeDetector.f13077g) {
            ObjectDetour.b(imageDupeDetector.f13077g, -229215646);
        }
    }
}
