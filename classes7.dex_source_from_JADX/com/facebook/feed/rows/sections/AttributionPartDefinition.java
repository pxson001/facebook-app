package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLRedSpaceVisibilityState;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ____ */
public class AttributionPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment, BetterTextView> {
    public static final ViewType f20351a = ViewType.a(2130906756);
    private static final PaddingStyle f20352b;
    private static AttributionPartDefinition f20353g;
    private static final Object f20354h = new Object();
    private final QeAccessor f20355c;
    private final BackgroundPartDefinition f20356d;
    private final TextPartDefinition f20357e;
    private final int f20358f = 2130842978;

    private static AttributionPartDefinition m23481b(InjectorLike injectorLike) {
        return new AttributionPartDefinition(BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23483a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        subParts.a(this.f20356d, new StylingData((FeedProps) obj, f20352b, -1, this.f20358f));
        subParts.a(2131566849, this.f20357e, feedEnvironment.getContext().getString(2131235748));
        return null;
    }

    public final boolean m23484a(Object obj) {
        return GraphQLHelper.j((GraphQLStory) ((FeedProps) obj).a) == GraphQLRedSpaceVisibilityState.REDSPACE_ONLY && this.f20355c.a(ExperimentsForRedSpaceExperimentsModule.h, false);
    }

    static {
        Builder e = Builder.e();
        e.b = 6.0f;
        e = e;
        e.d = 12.0f;
        e = e;
        e.c = 0.0f;
        f20352b = e.i();
    }

    @Inject
    public AttributionPartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, QeAccessor qeAccessor) {
        this.f20356d = backgroundPartDefinition;
        this.f20355c = qeAccessor;
        this.f20357e = textPartDefinition;
    }

    public final ViewType<BetterTextView> m23482a() {
        return f20351a;
    }

    public static AttributionPartDefinition m23480a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttributionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20354h) {
                AttributionPartDefinition attributionPartDefinition;
                if (a2 != null) {
                    attributionPartDefinition = (AttributionPartDefinition) a2.a(f20354h);
                } else {
                    attributionPartDefinition = f20353g;
                }
                if (attributionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23481b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20354h, b3);
                        } else {
                            f20353g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = attributionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
