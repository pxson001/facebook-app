package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.goodwill.feed.rows.ThrowbackPromotionFeedUnitEdge.ThrowbackPromotionFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch uploaded media count  */
public class ThrowbackFeedPromotionHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<ThrowbackPromotionFeedUnit>, Void, HasPositionInformation, View> {
    public static final ViewType f13544a = ViewType.a(2130907418);
    private static final PaddingStyle f13545d;
    private static ThrowbackFeedPromotionHeaderPartDefinition f13546e;
    private static final Object f13547f = new Object();
    private final BackgroundPartDefinition f13548b;
    private final TextOrHiddenPartDefinition f13549c;

    private static ThrowbackFeedPromotionHeaderPartDefinition m15309b(InjectorLike injectorLike) {
        return new ThrowbackFeedPromotionHeaderPartDefinition(TextOrHiddenPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m15311a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        ThrowbackPromotionFeedUnit throwbackPromotionFeedUnit = (ThrowbackPromotionFeedUnit) feedProps.a;
        subParts.a(2131567894, this.f13549c, throwbackPromotionFeedUnit.f13776b);
        PaddingStyle paddingStyle = f13545d;
        if (TextUtils.isEmpty(throwbackPromotionFeedUnit.f13776b)) {
            Builder a = Builder.a();
            a.b = -8.0f;
            paddingStyle = a.i();
        }
        subParts.a(this.f13548b, new StylingData(feedProps.a(throwbackPromotionFeedUnit.f13777c), paddingStyle, Position.MIDDLE));
        return null;
    }

    public final boolean m15312a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps == null || feedProps.a == null) {
            return false;
        }
        return ((ThrowbackPromotionFeedUnit) feedProps.a).f13777c != null;
    }

    static {
        Builder a = Builder.a();
        a.b = 5.0f;
        a = a;
        a.c = 5.0f;
        f13545d = a.i();
    }

    @Inject
    public ThrowbackFeedPromotionHeaderPartDefinition(TextOrHiddenPartDefinition textOrHiddenPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f13548b = backgroundPartDefinition;
        this.f13549c = textOrHiddenPartDefinition;
    }

    public final ViewType m15310a() {
        return f13544a;
    }

    public static ThrowbackFeedPromotionHeaderPartDefinition m15308a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFeedPromotionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13547f) {
                ThrowbackFeedPromotionHeaderPartDefinition throwbackFeedPromotionHeaderPartDefinition;
                if (a2 != null) {
                    throwbackFeedPromotionHeaderPartDefinition = (ThrowbackFeedPromotionHeaderPartDefinition) a2.a(f13547f);
                } else {
                    throwbackFeedPromotionHeaderPartDefinition = f13546e;
                }
                if (throwbackFeedPromotionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15309b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13547f, b3);
                        } else {
                            f13546e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFeedPromotionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
