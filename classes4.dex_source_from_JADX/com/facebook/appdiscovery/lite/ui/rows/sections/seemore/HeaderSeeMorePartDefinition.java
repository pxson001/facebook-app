package com.facebook.appdiscovery.lite.ui.rows.sections.seemore;

import android.content.Context;
import com.facebook.appdiscovery.lite.model.contract.AppDiscoverySeeMoreQueryable;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
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
/* compiled from: nux_history_encode_fail */
public class HeaderSeeMorePartDefinition extends MultiRowSinglePartDefinition<AppDiscoverySeeMoreQueryable, Void, AnyEnvironment, BetterTextView> {
    public static final ViewType f6489a = ViewType.a(2130907048);
    private static HeaderSeeMorePartDefinition f6490c;
    private static final Object f6491d = new Object();
    private final TextPartDefinition f6492b;

    private static HeaderSeeMorePartDefinition m6909b(InjectorLike injectorLike) {
        return new HeaderSeeMorePartDefinition(TextPartDefinition.a(injectorLike));
    }

    public final Object m6911a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131558927, this.f6492b, ((AppDiscoverySeeMoreQueryable) obj).a());
        return null;
    }

    public final boolean m6912a(Object obj) {
        return !StringUtil.a(((AppDiscoverySeeMoreQueryable) obj).a());
    }

    @Inject
    public HeaderSeeMorePartDefinition(TextPartDefinition textPartDefinition) {
        this.f6492b = textPartDefinition;
    }

    public final ViewType m6910a() {
        return f6489a;
    }

    public static HeaderSeeMorePartDefinition m6908a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderSeeMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6491d) {
                HeaderSeeMorePartDefinition headerSeeMorePartDefinition;
                if (a2 != null) {
                    headerSeeMorePartDefinition = (HeaderSeeMorePartDefinition) a2.a(f6491d);
                } else {
                    headerSeeMorePartDefinition = f6490c;
                }
                if (headerSeeMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6909b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6491d, b3);
                        } else {
                            f6490c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = headerSeeMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
