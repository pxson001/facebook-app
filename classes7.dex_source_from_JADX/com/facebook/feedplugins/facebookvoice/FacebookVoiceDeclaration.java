package com.facebook.feedplugins.facebookvoice;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: Subtitle */
public class FacebookVoiceDeclaration implements FeedRowSupportDeclaration {
    private static FacebookVoiceDeclaration f23079a;
    private static final Object f23080b = new Object();

    private static FacebookVoiceDeclaration m25522a() {
        return new FacebookVoiceDeclaration();
    }

    public final void m25524a(ListItemRowController listItemRowController) {
        listItemRowController.a(PersonalHighlightHeaderPartDefinition.f23102a);
        listItemRowController.a(FacebookVoiceBasePartDefinition.f23077a);
    }

    public static FacebookVoiceDeclaration m25523a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FacebookVoiceDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f23080b) {
                FacebookVoiceDeclaration facebookVoiceDeclaration;
                if (a3 != null) {
                    facebookVoiceDeclaration = (FacebookVoiceDeclaration) a3.a(f23080b);
                } else {
                    facebookVoiceDeclaration = f23079a;
                }
                if (facebookVoiceDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m25522a();
                        if (a3 != null) {
                            a3.a(f23080b, a2);
                        } else {
                            f23079a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = facebookVoiceDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
