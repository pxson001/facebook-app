package com.facebook.rtc.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomViewUtils;

/* compiled from: app_fbid_filter */
public class VoipConnectionBanner extends WebrtcLinearLayout {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f20239a = UltralightRuntime.b();
    private View f20240b;
    private View f20241c;
    private FbTextView f20242d;
    private Theme f20243e = Theme.VOICE;

    /* compiled from: app_fbid_filter */
    public enum Theme {
        VOICE,
        VIDEO,
        CONFERENCE
    }

    private static <T extends View> void m19858a(Class<T> cls, T t) {
        m19859a((Object) t, t.getContext());
    }

    private static void m19859a(Object obj, Context context) {
        ((VoipConnectionBanner) obj).f20239a = IdBasedLazy.a(FbInjector.get(context), 10375);
    }

    public VoipConnectionBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.WebrtcLinearLayout, 0, 0);
        try {
            this.f20243e = Theme.values()[obtainStyledAttributes.getInteger(0, 0)];
            m19856a(context);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m19856a(Context context) {
        m19858a(VoipConnectionBanner.class, (View) this);
        this.f20240b = LayoutInflater.from(context).inflate(2130907744, this);
        this.f20241c = this.f20240b.findViewById(2131568450);
        this.f20242d = (FbTextView) this.f20240b.findViewById(2131568451);
    }

    public final void m19860a() {
        if (this.f20239a.get() != null) {
            switch (((WebrtcUiHandler) this.f20239a.get()).bU) {
                case WEAK_CONNECTION:
                    m19855a(2131362496, 8, 2131232054);
                    break;
                case RECONNECTING:
                    m19855a(2131362497, 0, 2131232055);
                    break;
                case RECONNECTED:
                    m19855a(2131362498, 8, 2131232056);
                    break;
                case WEAK_VIDEO_CONNECTION:
                    if (this.f20243e != Theme.VOICE) {
                        if (this.f20243e != Theme.CONFERENCE) {
                            m19855a(2131362496, 8, 2131232054);
                            break;
                        } else {
                            this.f20240b.setVisibility(8);
                            return;
                        }
                    }
                    this.f20240b.setVisibility(4);
                    return;
                default:
                    if (this.f20243e == Theme.VOICE) {
                        this.f20240b.setVisibility(4);
                        return;
                    } else {
                        this.f20240b.setVisibility(8);
                        return;
                    }
            }
            this.f20240b.setVisibility(0);
        }
    }

    private void m19857a(com.facebook.inject.Lazy<WebrtcUiHandler> lazy) {
        this.f20239a = lazy;
    }

    public void setTheme(Theme theme) {
        this.f20243e = theme;
        m19860a();
    }

    private void m19855a(int i, int i2, int i3) {
        CustomViewUtils.b(this.f20240b, new ColorDrawable(getResources().getColor(i)));
        this.f20241c.setVisibility(i2);
        this.f20242d.setText(i3);
    }
}
