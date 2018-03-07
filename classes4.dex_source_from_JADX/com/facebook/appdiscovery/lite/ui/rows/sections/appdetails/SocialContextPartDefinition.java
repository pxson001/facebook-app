package com.facebook.appdiscovery.lite.ui.rows.sections.appdetails;

import android.content.Context;
import com.facebook.appdiscovery.lite.model.unit.AppDetailsFeedUnit;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: nux_accept */
public class SocialContextPartDefinition extends MultiRowSinglePartDefinition<AppDetailsFeedUnit, Void, AnyEnvironment, BetterTextView> {
    public static final ViewType f6520a = ViewType.a(2130907154);
    private static SocialContextPartDefinition f6521c;
    private static final Object f6522d = new Object();
    private final TextPartDefinition f6523b;

    private static SocialContextPartDefinition m6940b(InjectorLike injectorLike) {
        return new SocialContextPartDefinition(TextPartDefinition.a(injectorLike));
    }

    public final Object m6942a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f6523b, ((AppDetailsFeedUnit) obj).m());
        return null;
    }

    public final boolean m6943a(Object obj) {
        return ((AppDetailsFeedUnit) obj).m() != null;
    }

    @Inject
    public SocialContextPartDefinition(TextPartDefinition textPartDefinition) {
        this.f6523b = textPartDefinition;
    }

    public final ViewType m6941a() {
        return f6520a;
    }

    public static SocialContextPartDefinition m6939a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SocialContextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6522d) {
                SocialContextPartDefinition socialContextPartDefinition;
                if (a2 != null) {
                    socialContextPartDefinition = (SocialContextPartDefinition) a2.a(f6522d);
                } else {
                    socialContextPartDefinition = f6521c;
                }
                if (socialContextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6940b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6522d, b3);
                        } else {
                            f6521c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = socialContextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
