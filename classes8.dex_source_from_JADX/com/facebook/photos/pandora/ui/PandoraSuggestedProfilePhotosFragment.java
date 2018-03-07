package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.model.PhotoSet;
import com.facebook.photos.pandora.common.data.SimplePandoraInstanceId;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraSuggestedProfilePhotosFutureGenerator;
import com.facebook.photos.photoset.launcher.PhotoSetConsumptionGalleryPhotoLauncher;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.intent.action.REACTION_CLOSE_EXTERNAL_SHARE_SERVICE */
public class PandoraSuggestedProfilePhotosFragment extends PandoraPhotoCollageFragment {
    @Inject
    public PandoraSuggestedProfilePhotosFutureGenerator f17672a;
    @Inject
    public Lazy<PhotoSetConsumptionGalleryPhotoLauncher> ar;
    private String as;
    private String at;

    public static void m21651a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PandoraSuggestedProfilePhotosFragment pandoraSuggestedProfilePhotosFragment = (PandoraSuggestedProfilePhotosFragment) obj;
        PandoraSuggestedProfilePhotosFutureGenerator a = PandoraSuggestedProfilePhotosFutureGenerator.m21402a(fbInjector);
        Lazy a2 = IdBasedLazy.a(fbInjector, 9409);
        pandoraSuggestedProfilePhotosFragment.f17672a = a;
        pandoraSuggestedProfilePhotosFragment.ar = a2;
    }

    public static PandoraSuggestedProfilePhotosFragment m21650a(Bundle bundle, String str, CallerContext callerContext) {
        PandoraSuggestedProfilePhotosFragment pandoraSuggestedProfilePhotosFragment = new PandoraSuggestedProfilePhotosFragment();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("profileId", str);
        bundle.putParcelable("callerContext", callerContext);
        bundle.putParcelable("pandora_instance_id", new SimplePandoraInstanceId(str, "sg"));
        pandoraSuggestedProfilePhotosFragment.g(bundle);
        return pandoraSuggestedProfilePhotosFragment;
    }

    public final void mo910c(Bundle bundle) {
        super.mo910c(bundle);
        Class cls = PandoraSuggestedProfilePhotosFragment.class;
        m21651a((Object) this, getContext());
        this.at = this.s.getString("profileId");
        this.as = PhotoSet.b(Long.parseLong(this.at));
    }

    protected final PandoraPhotoCollageFetchPhotosFutureGenerator mo909b() {
        return this.f17672a;
    }

    protected final void mo908a(String str, @Nullable Uri uri) {
        ((PhotoSetConsumptionGalleryPhotoLauncher) this.ar.get()).m21773b(ao(), this.as, str, uri, this.an.f17457i.m21444d(), FullscreenGallerySource.TIMELINE_PROFILE_PHOTO, false);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -338310985);
        super.mY_();
        this.an.m21640a(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2074593582, a);
    }
}
