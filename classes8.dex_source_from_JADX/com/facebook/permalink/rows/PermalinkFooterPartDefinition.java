package com.facebook.permalink.rows;

import android.content.Context;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.BasicFooterPartDefinition;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: story_add_report_reason */
public class PermalinkFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, CanFeedback, DefaultFooterView> {
    private static PermalinkFooterPartDefinition f2037f;
    private static final Object f2038g = new Object();
    private final GraphQLStoryUtil f2039a;
    private final FooterBackgroundPartDefinition<DefaultFooterView> f2040b;
    private final BasicFooterPartDefinition f2041c;
    private final PermalinkCommonFooterPartDefinition<DefaultFooterView> f2042d;
    private final FeedUnitDataController f2043e;

    private static PermalinkFooterPartDefinition m2268b(InjectorLike injectorLike) {
        return new PermalinkFooterPartDefinition(GraphQLStoryUtil.a(injectorLike), FooterBackgroundPartDefinition.a(injectorLike), BasicFooterPartDefinition.a(injectorLike), PermalinkCommonFooterPartDefinition.m2263a(injectorLike), FeedUnitDataController.a(injectorLike));
    }

    public final Object m2270a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FooterLevel footerLevel;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        if (this.f2043e.a(graphQLStory).s) {
            footerLevel = FooterLevel.TOP;
        } else {
            footerLevel = FooterLevel.PERMALINK;
        }
        subParts.a(this.f2040b, new Props(feedProps, footerLevel));
        subParts.a(this.f2042d, graphQLStory);
        subParts.a(this.f2041c, new BasicFooterPartDefinition.Props(feedProps, false));
        return null;
    }

    public final boolean m2271a(Object obj) {
        return this.f2039a.c((FeedProps) obj);
    }

    @Inject
    public PermalinkFooterPartDefinition(GraphQLStoryUtil graphQLStoryUtil, FooterBackgroundPartDefinition footerBackgroundPartDefinition, BasicFooterPartDefinition basicFooterPartDefinition, PermalinkCommonFooterPartDefinition permalinkCommonFooterPartDefinition, FeedUnitDataController feedUnitDataController) {
        this.f2039a = graphQLStoryUtil;
        this.f2040b = footerBackgroundPartDefinition;
        this.f2041c = basicFooterPartDefinition;
        this.f2042d = permalinkCommonFooterPartDefinition;
        this.f2043e = feedUnitDataController;
    }

    public final ViewType<DefaultFooterView> m2269a() {
        return DefaultFooterView.a;
    }

    public static PermalinkFooterPartDefinition m2267a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2038g) {
                PermalinkFooterPartDefinition permalinkFooterPartDefinition;
                if (a2 != null) {
                    permalinkFooterPartDefinition = (PermalinkFooterPartDefinition) a2.a(f2038g);
                } else {
                    permalinkFooterPartDefinition = f2037f;
                }
                if (permalinkFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2268b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2038g, b3);
                        } else {
                            f2037f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
