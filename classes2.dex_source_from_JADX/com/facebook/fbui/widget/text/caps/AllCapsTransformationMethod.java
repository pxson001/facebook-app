package com.facebook.fbui.widget.text.caps;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import com.facebook.common.locale.Locales;
import com.facebook.inject.InjectorLike;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: return_intent */
public class AllCapsTransformationMethod implements TransformationMethod {
    private static final Set<String> f23288a;
    private boolean f23289b = false;
    private final Locale f23290c;

    public static AllCapsTransformationMethod m31410b(InjectorLike injectorLike) {
        return new AllCapsTransformationMethod(Locales.m2604a(injectorLike));
    }

    static {
        Set hashSet = new HashSet();
        f23288a = hashSet;
        hashSet.add("af_ZA");
        f23288a.add("cs_CZ");
        f23288a.add("da_DK");
        f23288a.add("de_DE");
        f23288a.add("el_GR");
        f23288a.add("en_US");
        f23288a.add("en_GB");
        f23288a.add("es_ES");
        f23288a.add("es_LA");
        f23288a.add("fr_FR");
        f23288a.add("id_ID");
        f23288a.add("it_IT");
        f23288a.add("nb_NO");
        f23288a.add("pt_BR");
        f23288a.add("pt_PT");
        f23288a.add("ru_RU");
        f23288a.add("sk_SK");
        f23288a.add("sv_SE");
        f23288a.add("tl_PH");
        f23288a.add("tr_TR");
        f23288a.add("vi_VN");
    }

    public static AllCapsTransformationMethod m31409a(InjectorLike injectorLike) {
        return m31410b(injectorLike);
    }

    @Inject
    public AllCapsTransformationMethod(Locales locales) {
        this.f23290c = locales.m2609a();
        this.f23289b = f23288a.contains(locales.m2613c());
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (this.f23289b) {
            return charSequence != null ? charSequence.toString().toUpperCase(this.f23290c) : null;
        } else {
            return charSequence;
        }
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
