package com.facebook.feedplugins.base.blingbar;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.BlingBar;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TDataProvider; */
public class BlingBarPartDefinition<V extends View & BlingBar, E extends HasPositionInformation & HasPersistentState> extends BaseSinglePartDefinition<Props, Void, E, V> {
    private static BlingBarPartDefinition f22892c;
    private static final Object f22893d = new Object();
    private final BlingBarAnimationsPartDefinition f22894a;
    private final BlingBarFlyoutPartDefinition f22895b;

    /* compiled from: TDataProvider; */
    public class Props {
        public final boolean f22890a;
        public final FeedProps<GraphQLStory> f22891b;

        public Props(FeedProps<GraphQLStory> feedProps, boolean z) {
            this.f22891b = feedProps;
            this.f22890a = z;
        }
    }

    private static BlingBarPartDefinition m25427b(InjectorLike injectorLike) {
        return new BlingBarPartDefinition(BlingBarAnimationsPartDefinition.m25422a(injectorLike), BlingBarFlyoutPartDefinition.a(injectorLike));
    }

    public final Object m25428a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        GraphQLStory graphQLStory = (GraphQLStory) props.f22891b.a;
        subParts.a(this.f22895b, props.f22891b);
        subParts.a(this.f22894a, new com.facebook.feedplugins.base.blingbar.BlingBarAnimationsPartDefinition.Props(graphQLStory, graphQLStory.l(), StoryKeyUtil.a(graphQLStory), props.f22890a));
        return null;
    }

    @Inject
    public BlingBarPartDefinition(BlingBarAnimationsPartDefinition blingBarAnimationsPartDefinition, BlingBarFlyoutPartDefinition blingBarFlyoutPartDefinition) {
        this.f22894a = blingBarAnimationsPartDefinition;
        this.f22895b = blingBarFlyoutPartDefinition;
    }

    public static BlingBarPartDefinition m25426a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22893d) {
                BlingBarPartDefinition blingBarPartDefinition;
                if (a2 != null) {
                    blingBarPartDefinition = (BlingBarPartDefinition) a2.a(f22893d);
                } else {
                    blingBarPartDefinition = f22892c;
                }
                if (blingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25427b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22893d, b3);
                        } else {
                            f22892c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = blingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
