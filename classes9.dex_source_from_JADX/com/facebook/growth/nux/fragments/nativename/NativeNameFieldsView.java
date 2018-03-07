package com.facebook.growth.nux.fragments.nativename;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.facebook.common.locale.Locales;
import com.facebook.inject.FbInjector;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: p2p_send_fail */
public class NativeNameFieldsView extends LinearLayout {
    @Inject
    public Locales f7490a;
    public NativeNameDefaultFields f7491b;
    public NativeNameExtrajpFields f7492c;

    public static void m7799a(Object obj, Context context) {
        ((NativeNameFieldsView) obj).f7490a = Locales.a(FbInjector.get(context));
    }

    public NativeNameFieldsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = NativeNameFieldsView.class;
        m7799a(this, getContext());
        setOrientation(1);
        this.f7491b = new NativeNameDefaultFields(context, attributeSet);
        addView(this.f7491b);
        if (Locale.JAPANESE.toString().equals(this.f7490a.a().getLanguage())) {
            this.f7492c = new NativeNameExtrajpFields(context, attributeSet);
            addView(this.f7492c);
        }
    }
}
