package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.inject.FbInjector;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraCampaignMediaFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.pages.fb4a.admin_activity.fragment.PageActivityFragment */
public class PandoraCampaignMediaSetFragment extends PandoraPhotoCollageFragment {
    @Inject
    public PandoraCampaignMediaFetchPhotosFutureGenerator f17652a;

    public static void m21623a(Object obj, Context context) {
        ((PandoraCampaignMediaSetFragment) obj).f17652a = PandoraCampaignMediaFetchPhotosFutureGenerator.m21398a(FbInjector.get(context));
    }

    public final void mo910c(Bundle bundle) {
        super.mo910c(bundle);
        Class cls = PandoraCampaignMediaSetFragment.class;
        m21623a((Object) this, getContext());
    }

    protected final PandoraPhotoCollageFetchPhotosFutureGenerator mo909b() {
        return this.f17652a;
    }

    protected final void mo908a(String str, @Nullable Uri uri) {
        throw new UnsupportedOperationException();
    }
}
