package com.facebook.rtc.fbwebrtc;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.fragments.WebrtcSurveyDialogFragment;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: audiences */
public class WebrtcSurveyHandler {
    private static final Class<?> f19421a = WebrtcSurveyHandler.class;
    public Random f19422b;
    public QeAccessor f19423c;
    public FragmentActivity f19424d;

    public static WebrtcSurveyHandler m19387a(InjectorLike injectorLike) {
        return new WebrtcSurveyHandler(Random_InsecureRandomMethodAutoProvider.a(injectorLike), FragmentActivityMethodAutoProvider.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public WebrtcSurveyHandler(Random random, FragmentActivity fragmentActivity, QeAccessor qeAccessor) {
        this.f19422b = random;
        this.f19424d = fragmentActivity;
        this.f19423c = qeAccessor;
    }

    public final void m19388a(int i, boolean z) {
        WebrtcSurveyDialogFragment webrtcSurveyDialogFragment = new WebrtcSurveyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("rating", i);
        bundle.putBoolean("use_video", z);
        webrtcSurveyDialogFragment.g(bundle);
        Fragment fragment = webrtcSurveyDialogFragment;
        FragmentManager kO_ = this.f19424d.kO_();
        kO_.a().a(fragment, "dialog").c();
        kO_.b();
        fragment.au();
    }

    public final boolean m19389b() {
        return ((DialogFragment) this.f19424d.kO_().a("dialog")) != null;
    }
}
