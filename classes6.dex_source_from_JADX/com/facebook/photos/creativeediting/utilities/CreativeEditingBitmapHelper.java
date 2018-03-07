package com.facebook.photos.creativeediting.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: include_is_verified */
public class CreativeEditingBitmapHelper {
    private static final CallerContext f12815a = CallerContext.a(CreativeEditingBitmapHelper.class, "creative_editing_in_composer");
    private final int f12816b = 1000;
    @DefaultExecutorService
    private final ExecutorService f12817c;
    private final PhotoOverlayObjectMapper f12818d;
    private final Context f12819e;
    private final ImagePipeline f12820f;

    /* compiled from: include_is_verified */
    class OverlayItemRendererFunction implements AsyncFunction<List<CloseableReference<CloseableImage>>, Bitmap> {
        private final ImmutableList<PhotoOverlayItem> f12809a;
        private final ImmutableList<StickerParams> f12810b;
        private final int f12811c;
        private final boolean f12812d;
        private final Uri f12813e;
        private final ImagePipeline f12814f;

        public final ListenableFuture m20209a(Object obj) {
            List<CloseableReference> list = (List) obj;
            int i = 0;
            if (list == null || list.isEmpty()) {
                return Futures.a(null);
            }
            try {
                CloseableImage closeableImage = (CloseableImage) ((CloseableReference) list.get(0)).a();
                ListenableFuture a;
                if (closeableImage instanceof CloseableBitmap) {
                    Bitmap a2 = ((CloseableBitmap) closeableImage).a();
                    Bitmap createBitmap = Bitmap.createBitmap(a2.getWidth(), a2.getHeight(), Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    Paint paint = new Paint(7);
                    canvas.drawBitmap(a2, 0.0f, 0.0f, paint);
                    int i2 = 0;
                    while (i2 < this.f12809a.size()) {
                        closeableImage = (CloseableImage) ((CloseableReference) list.get(i2 + 1)).a();
                        if ((closeableImage instanceof CloseableBitmap) && (this.f12809a.get(i2) instanceof UriAwarePhotoOverlayItem)) {
                            m20208a(canvas, paint, a2, ((CloseableBitmap) closeableImage).a(), (UriAwarePhotoOverlayItem) this.f12809a.get(i2));
                        }
                        i2++;
                    }
                    while (i < this.f12810b.size()) {
                        closeableImage = (CloseableImage) ((CloseableReference) list.get((i + 1) + this.f12809a.size())).a();
                        if (closeableImage instanceof CloseableBitmap) {
                            m20208a(canvas, paint, a2, ((CloseableBitmap) closeableImage).a(), (UriAwarePhotoOverlayItem) this.f12810b.get(i));
                        }
                        i++;
                    }
                    a = Futures.a(createBitmap);
                    for (CloseableReference closeableReference : list) {
                        if (closeableReference != null) {
                            closeableReference.close();
                        }
                    }
                    if (this.f12812d) {
                        this.f12814f.a(this.f12813e);
                    }
                    return a;
                }
                a = Futures.a(null);
                for (CloseableReference closeableReference2 : list) {
                    if (closeableReference2 != null) {
                        closeableReference2.close();
                    }
                }
                if (this.f12812d) {
                    this.f12814f.a(this.f12813e);
                }
                return a;
            } catch (Throwable th) {
                Throwable th2 = th;
                for (CloseableReference closeableReference22 : list) {
                    if (closeableReference22 != null) {
                        closeableReference22.close();
                    }
                }
                if (this.f12812d) {
                    this.f12814f.a(this.f12813e);
                }
            }
        }

        public OverlayItemRendererFunction(ImmutableList<PhotoOverlayItem> immutableList, ImmutableList<StickerParams> immutableList2, int i, Uri uri, boolean z, ImagePipeline imagePipeline) {
            this.f12809a = immutableList;
            this.f12810b = immutableList2;
            this.f12811c = i;
            this.f12812d = z;
            this.f12813e = uri;
            this.f12814f = imagePipeline;
        }

        private void m20208a(Canvas canvas, Paint paint, Bitmap bitmap, Bitmap bitmap2, UriAwarePhotoOverlayItem uriAwarePhotoOverlayItem) {
            int save = canvas.save();
            int width = (int) (((float) bitmap.getWidth()) * (uriAwarePhotoOverlayItem.mo221a().left + (uriAwarePhotoOverlayItem.mo221a().width() / 2.0f)));
            int height = (int) (((float) bitmap.getHeight()) * (uriAwarePhotoOverlayItem.mo221a().top + (uriAwarePhotoOverlayItem.mo221a().height() / 2.0f)));
            canvas.rotate(uriAwarePhotoOverlayItem.mo224c(), (float) width, (float) height);
            if (uriAwarePhotoOverlayItem.mo230i() && uriAwarePhotoOverlayItem.mo229h()) {
                canvas.scale(-1.0f, 1.0f, (float) width, (float) height);
            }
            RectF rectF = new RectF(((float) bitmap.getWidth()) * uriAwarePhotoOverlayItem.mo221a().left, ((float) bitmap.getHeight()) * uriAwarePhotoOverlayItem.mo221a().top, ((float) bitmap.getWidth()) * (uriAwarePhotoOverlayItem.mo221a().left + uriAwarePhotoOverlayItem.mo221a().width()), ((float) bitmap.getHeight()) * (uriAwarePhotoOverlayItem.mo221a().top + uriAwarePhotoOverlayItem.mo221a().height()));
            RectF rectF2 = new RectF();
            Matrix matrix = new Matrix();
            matrix.postRotate((float) this.f12811c, rectF.centerX(), rectF.centerY());
            matrix.mapRect(rectF2, rectF);
            canvas.drawBitmap(bitmap2, null, rectF2, paint);
            canvas.restoreToCount(save);
        }
    }

    public static CreativeEditingBitmapHelper m20213b(InjectorLike injectorLike) {
        return new CreativeEditingBitmapHelper(ImagePipelineMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), PhotoOverlayObjectMapper.m20234a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public static CreativeEditingBitmapHelper m20210a(InjectorLike injectorLike) {
        return m20213b(injectorLike);
    }

    @Inject
    public CreativeEditingBitmapHelper(ImagePipeline imagePipeline, ExecutorService executorService, PhotoOverlayObjectMapper photoOverlayObjectMapper, Context context) {
        this.f12820f = imagePipeline;
        this.f12817c = executorService;
        this.f12818d = photoOverlayObjectMapper;
        this.f12819e = context;
    }

    public final ListenableFuture<Bitmap> m20214a(Uri uri, int i, int i2, int i3, ImmutableList<PhotoOverlayItem> immutableList, ImmutableList<StickerParams> immutableList2, RectF rectF, boolean z) {
        Iterable a = Lists.a();
        a.add(m20211a(uri, i, i2));
        this.f12818d.m20238a(rectF, 0);
        Collection<PhotoOverlayItem> a2 = this.f12818d.m20237a((List) immutableList);
        if (a2 != null) {
            for (PhotoOverlayItem a3 : a2) {
                m20212a(a, a3, i, i2, i3);
            }
        }
        this.f12818d.m20238a(new RectF(0.0f, 0.0f, 1.0f, 1.0f), i3);
        Collection<PhotoOverlayItem> b = this.f12818d.m20240b((List) immutableList2);
        if (b != null) {
            for (PhotoOverlayItem a32 : b) {
                m20212a(a, a32, i, i2, i3);
            }
        }
        return Futures.b(Futures.b(a), new OverlayItemRendererFunction(a2 == null ? ImmutableList.of() : ImmutableList.copyOf(a2), b == null ? ImmutableList.of() : ImmutableList.copyOf(b), i3, uri, z, this.f12820f), this.f12817c);
    }

    private void m20212a(List<ListenableFuture<CloseableReference<CloseableImage>>> list, PhotoOverlayItem photoOverlayItem, int i, int i2, int i3) {
        if (photoOverlayItem instanceof UriAwarePhotoOverlayItem) {
            UriAwarePhotoOverlayItem uriAwarePhotoOverlayItem = (UriAwarePhotoOverlayItem) photoOverlayItem;
            int e = (int) (((float) i) * uriAwarePhotoOverlayItem.mo226e());
            int f = (int) (((float) i2) * uriAwarePhotoOverlayItem.mo227f());
            if (i3 == 90 || i3 == 270) {
                int i4 = e;
                e = f;
                f = i4;
            }
            list.add(m20211a(uriAwarePhotoOverlayItem.mo225d(), e, f));
        }
    }

    private ListenableFuture<CloseableReference<CloseableImage>> m20211a(Uri uri, int i, int i2) {
        if (i <= 0) {
            i = 1000;
        }
        if (i2 <= 0) {
            i2 = 1000;
        }
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        a.d = new ResizeOptions(i, i2);
        return DataSourceToFutureAdapter.a(this.f12820f.c(a.m(), f12815a));
    }
}
