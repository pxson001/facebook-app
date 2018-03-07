package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.adinterfaces.util.AdInterfacesHelper;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.config.application.Product;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: V2_MORE_FOOTER */
public class AdInterfacesLegalUtil {
    private static AdInterfacesLegalUtil f22761d;
    private static final Object f22762e = new Object();
    public final Context f22763a;
    public AdInterfacesHelper f22764b;
    private Spanned f22765c;

    private static AdInterfacesLegalUtil m24676b(InjectorLike injectorLike) {
        return new AdInterfacesLegalUtil((Context) injectorLike.getInstance(Context.class), AdInterfacesHelper.m25227a(injectorLike));
    }

    @Inject
    public AdInterfacesLegalUtil(Context context, AdInterfacesHelper adInterfacesHelper) {
        this.f22763a = context;
        this.f22764b = adInterfacesHelper;
    }

    public final Spanned m24678a() {
        if (this.f22765c == null) {
            m24677b();
        }
        return this.f22765c;
    }

    private void m24677b() {
        Resources resources = this.f22763a.getResources();
        CharSequence string = resources.getString(2131233940);
        String string2 = resources.getString(2131233941);
        String string3 = resources.getString(2131233942);
        int color = resources.getColor(2131361996);
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
        styledStringBuilder.a(string);
        styledStringBuilder.a("[[advertising_guidelines_link]]", string3, m24674a("https://m.facebook.com/ad_guidelines.php", color), 33);
        styledStringBuilder.a("[[facebook_terms_link]]", string2, m24674a("https://m.facebook.com/legal/terms", color), 33);
        this.f22765c = styledStringBuilder.b();
    }

    public static AdInterfacesLegalUtil m24675a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AdInterfacesLegalUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22762e) {
                AdInterfacesLegalUtil adInterfacesLegalUtil;
                if (a2 != null) {
                    adInterfacesLegalUtil = (AdInterfacesLegalUtil) a2.a(f22762e);
                } else {
                    adInterfacesLegalUtil = f22761d;
                }
                if (adInterfacesLegalUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24676b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22762e, b3);
                        } else {
                            f22761d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = adInterfacesLegalUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private ClickableSpan m24674a(final String str, final int i) {
        return new ClickableSpan(this) {
            final /* synthetic */ AdInterfacesLegalUtil f22760c;

            public void onClick(View view) {
                AdInterfacesHelper adInterfacesHelper = this.f22760c.f22764b;
                String str = str;
                Context context = this.f22760c.f22763a;
                Intent a = AdInterfacesHelper.m25226a(str);
                if (AdInterfacesHelper.f23242c == Product.PAA) {
                    adInterfacesHelper.f23244a.b(a, context);
                } else if (AdInterfacesHelper.f23242c == Product.FB4A) {
                    adInterfacesHelper.f23244a.a(a, context);
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
                textPaint.setColor(i);
            }
        };
    }
}
