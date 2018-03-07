package com.facebook.photos.taggablegallery;

import android.content.Context;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.photos.Photo;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.imageprocessing.FiltersEngine;
import com.facebook.photos.imageprocessing.FiltersPostprocessor;
import com.facebook.photos.imageprocessing.FiltersPostprocessorProvider;
import com.facebook.photos.photogallery.PhotoView;
import com.facebook.photos.photogallery.PhotoViewFactory;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import javax.inject.Inject;

/* compiled from: seriesTitle */
public class EnhanceablePhotoViewFactory extends PhotoViewFactory {
    private FiltersPostprocessorProvider f3388a;
    private FaceBoxStore f3389b;

    public static EnhanceablePhotoViewFactory m3323b(InjectorLike injectorLike) {
        return new EnhanceablePhotoViewFactory((FiltersPostprocessorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FiltersPostprocessorProvider.class), FaceBoxStore.a(injectorLike));
    }

    @Inject
    public EnhanceablePhotoViewFactory(FiltersPostprocessorProvider filtersPostprocessorProvider, FaceBoxStore faceBoxStore) {
        this.f3388a = filtersPostprocessorProvider;
        this.f3389b = faceBoxStore;
    }

    public final PhotoView m3324a(Photo photo, Context context, CreativeEditingData creativeEditingData) {
        Preconditions.checkState(photo instanceof TaggablePhoto);
        EnhanceablePhotoView enhanceablePhotoView = new EnhanceablePhotoView(context);
        Builder builder = ImmutableList.builder();
        if (this.f3389b.b((TaggablePhoto) photo)) {
            for (FaceBox d : this.f3389b.a((LocalPhoto) photo)) {
                builder.c(d.d());
            }
        }
        if (creativeEditingData != null) {
            if (VERSION.SDK_INT >= 11) {
                enhanceablePhotoView.f3384d = new FiltersPostprocessor(creativeEditingData.a(), builder.b(), FiltersEngine.a(this.f3388a));
            }
            Preconditions.checkNotNull(creativeEditingData);
            enhanceablePhotoView.f3387g = creativeEditingData;
            Uri o = creativeEditingData.o();
            RectF c = creativeEditingData.c();
            if (o != null) {
                if (!o.isAbsolute()) {
                    o = Uri.fromFile(new File(o.getPath()));
                }
                enhanceablePhotoView.f3385e = o;
            }
            if (c != null) {
                Preconditions.checkNotNull(c);
                enhanceablePhotoView.r = c;
            }
        }
        enhanceablePhotoView.a((TaggablePhoto) photo);
        return enhanceablePhotoView;
    }
}
