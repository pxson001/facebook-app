package com.facebook.rtc.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.fbwebrtc.WebrtcPrefKeys;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.rtc.views.IncallControlButtonsView.Theme;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;

/* compiled from: app_fb */
public class WebrtcIncallView extends WebrtcLinearLayout {
    @Inject
    public FbSharedPreferences f20330a;
    @Inject
    public FbZeroFeatureVisibilityHelper f20331b;
    @Inject
    public WebrtcLoggingHandler f20332c;
    public IncallControlButtonsView f20333d;
    public FrameLayout f20334e;
    public FbTextView f20335f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f20336g = UltralightRuntime.b;

    public static void m19930a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        WebrtcIncallView webrtcIncallView = (WebrtcIncallView) obj;
        com.facebook.inject.Lazy a = IdBasedLazy.a(fbInjector, 10375);
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        FbZeroFeatureVisibilityHelper a2 = FbZeroFeatureVisibilityHelper.a(fbInjector);
        WebrtcLoggingHandler a3 = WebrtcLoggingHandler.a(fbInjector);
        webrtcIncallView.f20336g = a;
        webrtcIncallView.f20330a = fbSharedPreferences;
        webrtcIncallView.f20331b = a2;
        webrtcIncallView.f20332c = a3;
    }

    public WebrtcIncallView(Context context) {
        super(context);
        Class cls = WebrtcIncallView.class;
        m19930a(this, getContext());
        LayoutInflater.from(context).inflate(2130907769, this);
        this.f20335f = (FbTextView) m19719a(2131568520);
        this.f20334e = (FrameLayout) m19719a(2131568521);
        this.f20333d = new IncallControlButtonsView(context, ((WebrtcUiHandler) this.f20336g.get()).m19475h() ? Theme.VOICE_WITH_ADD_CALLEE : Theme.VOICE);
        this.f20334e.addView(this.f20333d);
        if (((WebrtcUiHandler) this.f20336g.get()).aB()) {
            m19931b();
        }
    }

    public final void m19931b() {
        if (this.f20331b.a(ZeroFeatureKey.VOIP_CALL_INTERSTITIAL)) {
            this.f20335f.setVisibility(0);
            this.f20330a.edit().putBoolean(WebrtcPrefKeys.f19402c, true).commit();
        } else if (!this.f20330a.a(WebrtcPrefKeys.f19402c, false)) {
            this.f20332c.a("data_warning", "1");
            this.f20335f.setVisibility(0);
            this.f20330a.edit().putBoolean(WebrtcPrefKeys.f19402c, true).commit();
        }
    }
}
