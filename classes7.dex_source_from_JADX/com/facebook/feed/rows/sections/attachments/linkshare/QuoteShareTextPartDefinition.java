package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.resources.ui.ExpandingEllipsizingTextView;

@ContextScoped
/* compiled from: VideoHomeBadgeQuery */
public class QuoteShareTextPartDefinition extends BaseSinglePartDefinition<CharSequence, Void, AnyEnvironment, ExpandingEllipsizingTextView> {
    private static QuoteShareTextPartDefinition f21008a;
    private static final Object f21009b = new Object();

    private static QuoteShareTextPartDefinition m23904b() {
        return new QuoteShareTextPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m23907b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
    }

    public final Object m23905a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return null;
    }

    private void m23903a(CharSequence charSequence, Void voidR, AnyEnvironment anyEnvironment, ExpandingEllipsizingTextView expandingEllipsizingTextView) {
        super.a(charSequence, voidR, anyEnvironment, expandingEllipsizingTextView);
        expandingEllipsizingTextView.setText(charSequence);
    }

    public static QuoteShareTextPartDefinition m23902a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuoteShareTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21009b) {
                QuoteShareTextPartDefinition quoteShareTextPartDefinition;
                if (a2 != null) {
                    quoteShareTextPartDefinition = (QuoteShareTextPartDefinition) a2.a(f21009b);
                } else {
                    quoteShareTextPartDefinition = f21008a;
                }
                if (quoteShareTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m23904b();
                        if (a2 != null) {
                            a2.a(f21009b, b3);
                        } else {
                            f21008a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quoteShareTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
