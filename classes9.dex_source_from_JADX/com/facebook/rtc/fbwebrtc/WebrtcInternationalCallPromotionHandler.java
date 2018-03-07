package com.facebook.rtc.fbwebrtc;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ultralight.Inject;

/* compiled from: audio/* */
public class WebrtcInternationalCallPromotionHandler {
    private static final Class<?> f19395a = WebrtcInternationalCallPromotionHandler.class;
    private QeAccessor f19396b;
    private final FbSharedPreferences f19397c;

    private static WebrtcInternationalCallPromotionHandler m19378b(InjectorLike injectorLike) {
        return new WebrtcInternationalCallPromotionHandler((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    private WebrtcInternationalCallPromotionHandler(QeAccessor qeAccessor, FbSharedPreferences fbSharedPreferences) {
        this.f19396b = qeAccessor;
        this.f19397c = fbSharedPreferences;
    }
}
