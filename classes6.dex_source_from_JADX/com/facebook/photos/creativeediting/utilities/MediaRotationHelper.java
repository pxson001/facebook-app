package com.facebook.photos.creativeediting.utilities;

import android.net.Uri;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.rotation.RotationManager;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: in_visible_group */
public class MediaRotationHelper {
    public final RotationManager f12841a;
    public final TagStore f12842b;
    public final FaceBoxStore f12843c;

    public static MediaRotationHelper m20226b(InjectorLike injectorLike) {
        return new MediaRotationHelper(TagStore.m21155a(injectorLike), FaceBoxStore.m21127a(injectorLike), RotationManager.m20927b(injectorLike));
    }

    @Inject
    public MediaRotationHelper(TagStore tagStore, FaceBoxStore faceBoxStore, RotationManager rotationManager) {
        this.f12842b = tagStore;
        this.f12843c = faceBoxStore;
        this.f12841a = rotationManager;
    }

    public final int m20227a(Uri uri) {
        Preconditions.checkNotNull(uri);
        return this.f12841a.m20928a(uri.getPath());
    }

    public final void m20228a(Uri uri, int i) {
        Preconditions.checkNotNull(uri);
        this.f12841a.m20929a(uri, i);
    }
}
