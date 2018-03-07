package com.facebook.feedplugins.base.blingbar;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition.Props;
import com.facebook.feedplugins.base.blingbar.ui.DefaultBlingBarView;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: TDW; */
public class BlingBarRootPartDefinition<E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, DefaultBlingBarView> {
    public static final PaddingStyle f22896a;
    private static BlingBarRootPartDefinition f22897d;
    private static final Object f22898e = new Object();
    private final BackgroundPartDefinition f22899b;
    private final BlingBarPartDefinition f22900c;

    private static BlingBarRootPartDefinition m25430b(InjectorLike injectorLike) {
        return new BlingBarRootPartDefinition(BackgroundPartDefinition.a(injectorLike), BlingBarPartDefinition.m25426a(injectorLike));
    }

    public final Object m25432a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f22899b, new StylingData(feedProps, f22896a));
        subParts.a(this.f22900c, new Props(feedProps, BlingBarAnimationsPartDefinition.m25423a(graphQLStory)));
        return null;
    }

    static {
        Builder g = Builder.g();
        g.d = -6.0f;
        f22896a = g.i();
    }

    @Inject
    public BlingBarRootPartDefinition(BackgroundPartDefinition backgroundPartDefinition, BlingBarPartDefinition blingBarPartDefinition) {
        this.f22899b = backgroundPartDefinition;
        this.f22900c = blingBarPartDefinition;
    }

    public final ViewType m25431a() {
        return DefaultBlingBarView.f22918a;
    }

    public final /* synthetic */ boolean m25433a(Object obj) {
        return true;
    }

    public static BlingBarRootPartDefinition m25429a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlingBarRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22898e) {
                BlingBarRootPartDefinition blingBarRootPartDefinition;
                if (a2 != null) {
                    blingBarRootPartDefinition = (BlingBarRootPartDefinition) a2.a(f22898e);
                } else {
                    blingBarRootPartDefinition = f22897d;
                }
                if (blingBarRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25430b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22898e, b3);
                        } else {
                            f22897d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = blingBarRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
