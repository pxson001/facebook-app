package com.facebook.ui.errors;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.common.network.OnConnectionChangedListener;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: nearby_places_fragment */
public class ErrorBannerView extends CustomFrameLayout implements OnConnectionChangedListener {
    public TextView f5159a;
    private BannerType f5160b;

    /* compiled from: nearby_places_fragment */
    enum BannerType {
        CONNECTED,
        NO_INTERNET,
        OTHER_ERROR
    }

    public ErrorBannerView(Context context) {
        this(context, null);
    }

    private ErrorBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ErrorBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5160b = BannerType.CONNECTED;
        setContentView(2130903755);
        this.f5159a = (TextView) c(2131560690);
    }

    private void m6409a(BannerType bannerType) {
        if (getVisibility() != 0 || this.f5160b != bannerType) {
            switch (bannerType) {
                case CONNECTED:
                    this.f5159a.setText("");
                    this.f5159a.setText(2131230809);
                    setBackgroundColor(getResources().getColor(2131362432));
                    break;
                case NO_INTERNET:
                    this.f5159a.setText("");
                    this.f5159a.setText(2131230763);
                    setBackgroundColor(getResources().getColor(2131362429));
                    break;
                case OTHER_ERROR:
                    this.f5159a.setText("");
                    this.f5159a.setText(2131230758);
                    setBackgroundColor(getResources().getColor(2131363415));
                    break;
            }
            this.f5160b = bannerType;
            setVisibility(0);
        }
    }

    private void m6410b() {
        setVisibility(8);
    }

    public final void m6411a(boolean z) {
        if (z) {
            m6410b();
        } else {
            m6409a(BannerType.NO_INTERNET);
        }
    }

    public final void m6412b(boolean z) {
        if (z) {
            m6410b();
        } else {
            m6409a(BannerType.NO_INTERNET);
        }
    }
}
