package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.ChannelFeedBackgroundPartDefinition;
import com.facebook.feed.rows.styling.ChannelFeedBackgroundPartDefinition.StylingData;
import com.facebook.feedplugins.base.blingbar.BlingBarAnimationsPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
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
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: temporary_url_extra */
public class ChannelFeedBlingBarPartDefinition<E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<Props, Void, E, ChannelFeedVideoPlaysBlingBarView> {
    public static final ViewType f2105a = new C02051();
    private static ChannelFeedBlingBarPartDefinition f2106d;
    private static final Object f2107e = new Object();
    private final BlingBarPartDefinition f2108b;
    private final ChannelFeedBackgroundPartDefinition f2109c;

    /* compiled from: temporary_url_extra */
    final class C02051 extends ViewType {
        C02051() {
        }

        public final View m2112a(Context context) {
            return new ChannelFeedVideoPlaysBlingBarView(context);
        }
    }

    /* compiled from: temporary_url_extra */
    public class Props {
        public GraphQLStory f2102a;
        @Nullable
        public FeedProps<GraphQLStory> f2103b;
        public boolean f2104c;

        public Props(GraphQLStory graphQLStory, FeedProps<GraphQLStory> feedProps, boolean z) {
            this.f2102a = graphQLStory;
            this.f2103b = feedProps;
            this.f2104c = z;
        }
    }

    private static ChannelFeedBlingBarPartDefinition m2114b(InjectorLike injectorLike) {
        return new ChannelFeedBlingBarPartDefinition(BlingBarPartDefinition.a(injectorLike), ChannelFeedBackgroundPartDefinition.a(injectorLike));
    }

    public final Object m2116a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        GraphQLStory graphQLStory = (GraphQLStory) props.f2103b.a;
        Preconditions.checkNotNull(graphQLStory);
        subParts.a(this.f2108b, new com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition.Props(props.f2103b, BlingBarAnimationsPartDefinition.a(graphQLStory)));
        subParts.a(this.f2109c, new StylingData(props.f2103b, BlingBarRootPartDefinition.a));
        return null;
    }

    public final boolean m2117a(Object obj) {
        Props props = (Props) obj;
        return (!props.f2104c || props.f2103b == null || props.f2103b.a == props.f2102a) ? false : true;
    }

    public static ChannelFeedBlingBarPartDefinition m2113a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2107e) {
                ChannelFeedBlingBarPartDefinition channelFeedBlingBarPartDefinition;
                if (a2 != null) {
                    channelFeedBlingBarPartDefinition = (ChannelFeedBlingBarPartDefinition) a2.a(f2107e);
                } else {
                    channelFeedBlingBarPartDefinition = f2106d;
                }
                if (channelFeedBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2114b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2107e, b3);
                        } else {
                            f2106d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ChannelFeedBlingBarPartDefinition(BlingBarPartDefinition blingBarPartDefinition, ChannelFeedBackgroundPartDefinition channelFeedBackgroundPartDefinition) {
        this.f2108b = blingBarPartDefinition;
        this.f2109c = channelFeedBackgroundPartDefinition;
    }

    public final ViewType m2115a() {
        return f2105a;
    }
}
