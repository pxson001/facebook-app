package com.facebook.growth.nux.fragments.nativename;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.locale.Locales;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: p2p_send_success */
public class NativeNameDefaultFields extends CustomViewGroup {
    @Inject
    public Locales f7488a;
    public String f7489b;

    public static void m7798a(Object obj, Context context) {
        ((NativeNameDefaultFields) obj).f7488a = Locales.a(FbInjector.get(context));
    }

    public NativeNameDefaultFields(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private NativeNameDefaultFields(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = NativeNameDefaultFields.class;
        m7798a(this, getContext());
        this.f7489b = this.f7488a.a().getLanguage();
        if (Locale.CHINESE.toString().equals(this.f7489b) || Locale.JAPANESE.toString().equals(this.f7489b) || Locale.KOREAN.toString().equals(this.f7489b)) {
            setContentView(2130905367);
        } else {
            setContentView(2130905518);
        }
    }
}
