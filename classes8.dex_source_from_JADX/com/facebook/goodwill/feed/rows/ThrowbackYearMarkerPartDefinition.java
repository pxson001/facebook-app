package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.goodwill.feed.rows.ThrowbackYearMarkerFeedUnitEdge.ThrowbackYearMarkerFeedUnit;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: fallback_native_ad */
public class ThrowbackYearMarkerPartDefinition extends MultiRowSinglePartDefinition<FeedProps<ThrowbackYearMarkerFeedUnit>, Void, HasPositionInformation, View> {
    public static final ViewType f13806a = new C14611();
    private static ThrowbackYearMarkerPartDefinition f13807d;
    private static final Object f13808e = new Object();
    private final TextPartDefinition f13809b;
    private final TextPartDefinition f13810c;

    /* compiled from: fallback_native_ad */
    final class C14611 extends ViewType {
        C14611() {
        }

        public final View m15454a(Context context) {
            return LayoutInflater.from(context).inflate(2130907425, null);
        }
    }

    private static ThrowbackYearMarkerPartDefinition m15456b(InjectorLike injectorLike) {
        return new ThrowbackYearMarkerPartDefinition(TextPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m15458a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ThrowbackYearMarkerFeedUnit throwbackYearMarkerFeedUnit = (ThrowbackYearMarkerFeedUnit) ((FeedProps) obj).a;
        subParts.a(2131567900, this.f13809b, throwbackYearMarkerFeedUnit.b);
        subParts.a(2131567901, this.f13810c, throwbackYearMarkerFeedUnit.c);
        return null;
    }

    public final boolean m15459a(Object obj) {
        return !((ThrowbackYearMarkerFeedUnit) ((FeedProps) obj).a).a;
    }

    @Inject
    public ThrowbackYearMarkerPartDefinition(TextPartDefinition textPartDefinition, TextPartDefinition textPartDefinition2) {
        this.f13809b = textPartDefinition;
        this.f13810c = textPartDefinition2;
    }

    public final ViewType m15457a() {
        return f13806a;
    }

    public static ThrowbackYearMarkerPartDefinition m15455a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackYearMarkerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13808e) {
                ThrowbackYearMarkerPartDefinition throwbackYearMarkerPartDefinition;
                if (a2 != null) {
                    throwbackYearMarkerPartDefinition = (ThrowbackYearMarkerPartDefinition) a2.a(f13808e);
                } else {
                    throwbackYearMarkerPartDefinition = f13807d;
                }
                if (throwbackYearMarkerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15456b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13808e, b3);
                        } else {
                            f13807d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackYearMarkerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
