package com.facebook.rtc.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.views.IncallControlButtonsView.Theme;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;

/* compiled from: app_discovery_lite_load_success */
public class WebrtcRosterIncallView extends WebrtcLinearLayout {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f20357a = UltralightRuntime.b;
    public IncallControlButtonsView f20358b;
    public FrameLayout f20359c;

    public static void m19934a(Object obj, Context context) {
        ((WebrtcRosterIncallView) obj).f20357a = IdBasedLazy.a(FbInjector.get(context), 10375);
    }

    public WebrtcRosterIncallView(Context context) {
        Object obj;
        super(context);
        Class cls = WebrtcRosterIncallView.class;
        m19934a(this, getContext());
        LayoutInflater.from(context).inflate(2130907773, this);
        this.f20359c = (FrameLayout) m19719a(2131568521);
        if (((WebrtcUiHandler) this.f20357a.get()).ba && ((WebrtcUiHandler) this.f20357a.get()).m19475h()) {
            obj = 1;
        } else {
            obj = null;
        }
        this.f20358b = new IncallControlButtonsView(context, obj != null ? Theme.CONFERENCE_WITH_ADD_CALLEE : Theme.CONFERENCE);
        this.f20359c.addView(this.f20358b);
    }
}
