package com.facebook.video.channelfeed;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundStyleResolver;
import com.facebook.feedplugins.base.footer.EdgeToEdgeFooterBackgroundStyleConfig;
import com.facebook.feedplugins.base.footer.FooterBackgroundStyleDefinition;
import com.facebook.feedplugins.base.footer.FooterBackgroundStylePartDefinition;
import com.facebook.feedplugins.base.footer.FooterButtonStylePartDefinition;
import com.facebook.feedplugins.base.footer.FooterButtonStylePartDefinition.Props;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterPartDefinition;
import com.facebook.feedplugins.multishare.abtest.ExperimentsForMultiShareAbTestModule;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: team_abbreviated_name */
public class ChannelFeedDefaultFooterPartDefinition<E extends CanFeedback> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, DefaultFooterView> {
    private static ChannelFeedDefaultFooterPartDefinition f2112i;
    private static final Object f2113j = new Object();
    public final Resources f2114a;
    private final FooterPartDefinition<DefaultFooterView> f2115b;
    private final FooterButtonStylePartDefinition<DefaultFooterView> f2116c;
    private final FooterBackgroundStylePartDefinition<DefaultFooterView> f2117d;
    private final DefaultFooterBackgroundStyleResolver f2118e;
    private final DefaultFooterBackgroundStyleResolver f2119f;
    private final GraphQLStoryUtil f2120g;
    private final QeAccessor f2121h;

    private static ChannelFeedDefaultFooterPartDefinition m2122b(InjectorLike injectorLike) {
        return new ChannelFeedDefaultFooterPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), FooterPartDefinition.a(injectorLike), FooterButtonStylePartDefinition.a(injectorLike), FooterBackgroundStyleConfig_ForChannelFeedMethodAutoProvider.m2520b(injectorLike), ChannelFeedModule.m2313b(ResourcesMethodAutoProvider.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike)), FooterBackgroundStylePartDefinition.a(injectorLike), GraphQLStoryUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m2124a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        boolean z = false;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        if (MultiShareNoLinkUtil.b(graphQLStory) && this.f2121h.a(ExperimentsForMultiShareAbTestModule.b, false)) {
            z = true;
        }
        FooterBackgroundStyleDefinition a = z ? this.f2119f.a(FooterLevel.TOP) : this.f2118e.a(FooterLevel.TOP);
        subParts.a(this.f2115b, feedProps);
        subParts.a(this.f2116c, new Props(graphQLStory.z(), graphQLStory.A(), StorySharingHelper.b(graphQLStory), a));
        subParts.a(this.f2117d, new FooterBackgroundStylePartDefinition.Props(a, a.a(this.f2114a, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE), null));
        return null;
    }

    public final boolean m2125a(Object obj) {
        return GraphQLStoryUtil.f((GraphQLStory) ((FeedProps) obj).a);
    }

    @Inject
    public ChannelFeedDefaultFooterPartDefinition(Resources resources, FooterPartDefinition footerPartDefinition, FooterButtonStylePartDefinition footerButtonStylePartDefinition, EdgeToEdgeFooterBackgroundStyleConfig edgeToEdgeFooterBackgroundStyleConfig, EdgeToEdgeFooterBackgroundStyleConfig edgeToEdgeFooterBackgroundStyleConfig2, FooterBackgroundStylePartDefinition footerBackgroundStylePartDefinition, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor) {
        this.f2114a = resources;
        this.f2115b = footerPartDefinition;
        this.f2116c = footerButtonStylePartDefinition;
        this.f2117d = footerBackgroundStylePartDefinition;
        this.f2118e = new DefaultFooterBackgroundStyleResolver(edgeToEdgeFooterBackgroundStyleConfig);
        this.f2119f = new DefaultFooterBackgroundStyleResolver(edgeToEdgeFooterBackgroundStyleConfig2);
        this.f2120g = graphQLStoryUtil;
        this.f2121h = qeAccessor;
    }

    public static ChannelFeedDefaultFooterPartDefinition m2121a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedDefaultFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2113j) {
                ChannelFeedDefaultFooterPartDefinition channelFeedDefaultFooterPartDefinition;
                if (a2 != null) {
                    channelFeedDefaultFooterPartDefinition = (ChannelFeedDefaultFooterPartDefinition) a2.a(f2113j);
                } else {
                    channelFeedDefaultFooterPartDefinition = f2112i;
                }
                if (channelFeedDefaultFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2122b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2113j, b3);
                        } else {
                            f2112i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedDefaultFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m2123a() {
        return DefaultFooterView.a;
    }
}
