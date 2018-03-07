package com.facebook.widget.images;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.animated.base.AnimatedDrawable;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactoryImpl;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.internal.ImageRequestBuilderFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ui.images.fetch.FetchImageParams;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: reportNASAction */
public class ImageCacheReader {
    private static final String f5798a = ImageCacheReader.class.getSimpleName();
    private static final CallerContext f5799b = CallerContext.a(ImageCacheReader.class, "unknown");
    private final Resources f5800c;
    private final Lazy<ImagePipeline> f5801d;
    private final Lazy<AnimatedDrawableFactory> f5802e;

    public static ImageCacheReader m8365b(InjectorLike injectorLike) {
        return new ImageCacheReader(ResourcesMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2309), IdBasedSingletonScopeProvider.b(injectorLike, 2296));
    }

    @Inject
    public ImageCacheReader(Resources resources, Lazy<ImagePipeline> lazy, Lazy<AnimatedDrawableFactory> lazy2) {
        this.f5800c = resources;
        this.f5801d = lazy;
        this.f5802e = lazy2;
    }

    @Deprecated
    @Nullable
    public final Drawable m8367a(@Nullable FetchImageParams fetchImageParams) {
        return m8364b(ImageRequestBuilderFactory.a(fetchImageParams, this.f5800c).m());
    }

    @Nullable
    public final Drawable m8366a(@Nullable ImageRequest imageRequest) {
        if (imageRequest == null) {
            return null;
        }
        return m8364b(imageRequest);
    }

    @Nullable
    private Drawable m8364b(ImageRequest imageRequest) {
        DataSource b = ((ImagePipeline) this.f5801d.get()).b(ImageRequestBuilder.a(imageRequest).a(RequestLevel.BITMAP_MEMORY_CACHE).m(), f5799b);
        Preconditions.checkState(b.b());
        CloseableReference closeableReference = (CloseableReference) b.d();
        b.g();
        if (!CloseableReference.a(closeableReference)) {
            return null;
        }
        try {
            CloseableImage closeableImage = (CloseableImage) closeableReference.a();
            if (closeableImage instanceof CloseableBitmap) {
                Drawable closeableBitmapDrawable = new CloseableBitmapDrawable(this.f5800c, closeableReference);
                if (closeableImage instanceof CloseableStaticBitmap) {
                    int h = ((CloseableStaticBitmap) closeableImage).h();
                    if (!(h == 0 || h == -1)) {
                        Drawable orientedDrawable = new OrientedDrawable(closeableBitmapDrawable, h);
                        return orientedDrawable;
                    }
                }
                closeableReference.close();
                return closeableBitmapDrawable;
            } else if (closeableImage instanceof CloseableAnimatedImage) {
                CloseableAnimatedDrawable closeableAnimatedDrawable = new CloseableAnimatedDrawable((AnimatedDrawable) ((AnimatedDrawableFactoryImpl) this.f5802e.get()).a(closeableImage), closeableReference);
                closeableReference.close();
                return closeableAnimatedDrawable;
            } else {
                closeableReference.close();
                return null;
            }
        } finally {
            closeableReference.close();
        }
    }
}
