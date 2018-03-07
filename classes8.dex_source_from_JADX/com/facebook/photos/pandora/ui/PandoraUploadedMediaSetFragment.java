package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.FbInjector;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.model.PhotoSet;
import com.facebook.photos.pandora.common.data.SimplePandoraInstanceId;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraUploadedMediaFetchPhotosFutureGenerator;
import com.facebook.photos.photoset.launcher.PhotoSetConsumptionGalleryPhotoLauncher;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.STREAM_PUBLISH_COMPLETE */
public class PandoraUploadedMediaSetFragment extends PandoraPhotoCollageFragment {
    @Inject
    public PandoraUploadedMediaFetchPhotosFutureGenerator f17746a;
    private String ar;
    private String as;

    public static void m21720a(Object obj, Context context) {
        ((PandoraUploadedMediaSetFragment) obj).f17746a = PandoraUploadedMediaFetchPhotosFutureGenerator.m21405a(FbInjector.get(context));
    }

    public final void mo910c(Bundle bundle) {
        super.mo910c(bundle);
        Class cls = PandoraUploadedMediaSetFragment.class;
        m21720a((Object) this, getContext());
        this.ar = this.s.getString("profileId");
        this.as = PhotoSet.b(Long.parseLong(this.ar));
    }

    protected final PandoraPhotoCollageFetchPhotosFutureGenerator mo909b() {
        return this.f17746a;
    }

    protected final void mo908a(String str, @Nullable Uri uri) {
        ((PhotoSetConsumptionGalleryPhotoLauncher) this.f15183b.get()).m21771a(ao(), this.as, str, uri, this.an.f17457i.m21444d(), FullscreenGallerySource.YOUR_PHOTOS, false);
    }

    public static PandoraUploadedMediaSetFragment m21719a(Bundle bundle, String str, boolean z, CallerContext callerContext) {
        PandoraUploadedMediaSetFragment pandoraUploadedMediaSetFragment = new PandoraUploadedMediaSetFragment();
        if (bundle == null) {
            bundle = new Bundle();
        }
        m21721b(bundle, str, z, callerContext);
        pandoraUploadedMediaSetFragment.g(bundle);
        return pandoraUploadedMediaSetFragment;
    }

    public static void m21721b(Bundle bundle, String str, boolean z, CallerContext callerContext) {
        bundle.putString("profileId", str);
        bundle.putParcelable("pandora_instance_id", new SimplePandoraInstanceId(str));
        bundle.putBoolean("isDefaultLandingPage", z);
        bundle.putParcelable("callerContext", callerContext);
    }

    public final void m21722a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 9916:
                    o().setResult(-1);
                    o().finish();
                    return;
                default:
                    return;
            }
        }
    }
}
