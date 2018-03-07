package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.UnitLocale;
import com.facebook.inject.FbInjector;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: V2_MONTAGE_COMPOSER_HEADER */
public class AdInterfacesLocalAwarenessAudienceView extends CustomLinearLayout {
    @Inject
    public Locale f22766a;
    private BetterTextView f22767b;
    private BetterTextView f22768c;
    private String f22769d;

    private static <T extends View> void m24680a(Class<T> cls, T t) {
        m24681a((Object) t, t.getContext());
    }

    private static void m24681a(Object obj, Context context) {
        ((AdInterfacesLocalAwarenessAudienceView) obj).f22766a = LocaleMethodAutoProvider.b(FbInjector.get(context));
    }

    public AdInterfacesLocalAwarenessAudienceView(Context context) {
        super(context);
        m24679a();
    }

    public AdInterfacesLocalAwarenessAudienceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24679a();
    }

    protected AdInterfacesLocalAwarenessAudienceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24679a();
    }

    private void m24679a() {
        setContentView(2130905117);
        setOrientation(1);
        m24680a(AdInterfacesLocalAwarenessAudienceView.class, (View) this);
        this.f22767b = (BetterTextView) a(2131563539);
        this.f22768c = (BetterTextView) a(2131563538);
        this.f22769d = getResources().getString(UnitLocale.from(this.f22766a) == UnitLocale.IMPERIAL ? 2131234038 : 2131234039);
    }

    public void setRadius(double d) {
        this.f22767b.setText("+" + StringFormatUtil.a(this.f22769d, new Object[]{Double.valueOf(d)}));
    }

    public void setAddress(String str) {
        this.f22768c.setText(str);
    }

    private void m24682a(Locale locale) {
        this.f22766a = locale;
    }
}
