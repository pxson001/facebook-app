package com.facebook.zero.ui;

import android.content.Context;
import com.facebook.resources.ui.FbTextView;
import com.facebook.zero.sdk.request.ZeroIndicatorData;
import com.facebook.zero.sdk.ui.ZeroIndicator;
import com.facebook.zero.ui.ZeroIndicatorController.C02311;
import javax.annotation.Nullable;

/* compiled from: sim_country_iso */
public class ZeroTitlebarIndicator extends FbTextView implements ZeroIndicator {
    @Nullable
    public String f4757a;

    public ZeroTitlebarIndicator(Context context) {
        super(context);
    }

    public void setIndicatorData(ZeroIndicatorData zeroIndicatorData) {
        setText(zeroIndicatorData.a());
        this.f4757a = zeroIndicatorData.d();
    }

    public final void mo1254b() {
        setVisibility(8);
    }

    public final void mo1253a() {
        setVisibility(0);
    }

    public final boolean mo1255c() {
        return getVisibility() == 0;
    }

    public void setListener(C02311 c02311) {
    }
}
