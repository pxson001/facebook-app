package com.facebook.photos.tagging;

import android.content.Context;
import com.facebook.facerec.manager.FaceBoxPrioritizer;
import com.facebook.facerec.model.LocalFaceRecImageData;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.PreFilledTagLogger;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: intro_cards_bio_post_to_feed_nux_dismissed */
public class AutoTaggingHelper {
    private final TagStore f10905a;
    private final FaceBoxStore f10906b;
    public final PreFilledTagLogger f10907c;
    private Lazy<FaceBoxPrioritizer> f10908d;

    public static AutoTaggingHelper m12927b(InjectorLike injectorLike) {
        return new AutoTaggingHelper(IdBasedLazy.a(injectorLike, 5764), TagStore.a(injectorLike), FaceBoxStore.a(injectorLike), PreFilledTagLogger.b(injectorLike));
    }

    @Inject
    public AutoTaggingHelper(Lazy<FaceBoxPrioritizer> lazy, TagStore tagStore, FaceBoxStore faceBoxStore, PreFilledTagLogger preFilledTagLogger) {
        this.f10908d = lazy;
        this.f10905a = tagStore;
        this.f10906b = faceBoxStore;
        this.f10907c = preFilledTagLogger;
    }

    public final void m12929b() {
        ((FaceBoxPrioritizer) this.f10908d.get()).d();
    }

    public static AutoTaggingHelper m12925a(InjectorLike injectorLike) {
        return m12927b(injectorLike);
    }

    private void m12926a(Context context, PhotoItem photoItem) {
        if (photoItem != null && photoItem.f != null && (photoItem.f instanceof TaggablePhoto) && this.f10906b.b((TaggablePhoto) photoItem.f)) {
            for (FaceBox faceBox : this.f10906b.a((TaggablePhoto) photoItem.f)) {
                if (!faceBox.f) {
                    return;
                }
            }
            this.f10905a.a(context, photoItem);
        }
    }

    public final void m12928a(Context context, LocalFaceRecImageData localFaceRecImageData, @Nullable ImmutableList<PhotoItem> immutableList) {
        PhotoItem photoItem = localFaceRecImageData.c;
        if (photoItem != null) {
            for (Tag a : localFaceRecImageData.e()) {
                this.f10905a.a(photoItem, a);
            }
            m12926a(context, photoItem);
            if (immutableList != null) {
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    PhotoItem photoItem2 = (PhotoItem) immutableList.get(i);
                    if (photoItem.c() == photoItem2.c() && photoItem != photoItem2) {
                        TaggablePhoto taggablePhoto = (TaggablePhoto) photoItem2.f;
                        TaggablePhoto taggablePhoto2 = (TaggablePhoto) photoItem.f;
                        this.f10905a.a(taggablePhoto, this.f10905a.a(taggablePhoto2));
                        this.f10906b.a(taggablePhoto, this.f10906b.a(taggablePhoto2));
                    }
                }
            }
        }
    }
}
