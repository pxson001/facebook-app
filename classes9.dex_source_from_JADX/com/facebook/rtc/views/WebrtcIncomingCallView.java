package com.facebook.rtc.views;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.fbwebrtc.WebrtcPrefKeys;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;

/* compiled from: app_discovery_lite_resumed */
public class WebrtcIncomingCallView extends WebrtcLinearLayout {
    @Inject
    public FbSharedPreferences f20337a;
    @Inject
    public FbZeroFeatureVisibilityHelper f20338b;
    @Inject
    public WebrtcLoggingHandler f20339c;
    public RtcIncomingCallButtons f20340d = ((RtcIncomingCallButtons) m19719a(2131568482));
    public FbTextView f20341e = ((FbTextView) m19719a(2131568523));

    public static void m19932a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        WebrtcIncomingCallView webrtcIncomingCallView = (WebrtcIncomingCallView) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        FbZeroFeatureVisibilityHelper a = FbZeroFeatureVisibilityHelper.a(fbInjector);
        WebrtcLoggingHandler a2 = WebrtcLoggingHandler.a(fbInjector);
        webrtcIncomingCallView.f20337a = fbSharedPreferences;
        webrtcIncomingCallView.f20338b = a;
        webrtcIncomingCallView.f20339c = a2;
    }

    public WebrtcIncomingCallView(Context context) {
        super(context);
        Class cls = WebrtcIncomingCallView.class;
        m19932a(this, getContext());
        LayoutInflater.from(context).inflate(2130907770, this);
        if (this.f20338b.a(ZeroFeatureKey.VOIP_CALL_INTERSTITIAL)) {
            this.f20341e.setVisibility(0);
            this.f20337a.edit().putBoolean(WebrtcPrefKeys.f19402c, true).commit();
        } else if (this.f20337a.a(WebrtcPrefKeys.f19402c, false)) {
            this.f20341e.setVisibility(4);
        } else {
            this.f20339c.a("data_warning", "1");
            this.f20341e.setText(context.getString(2131232085));
            this.f20341e.setVisibility(0);
            this.f20337a.edit().putBoolean(WebrtcPrefKeys.f19402c, true).commit();
        }
    }
}
