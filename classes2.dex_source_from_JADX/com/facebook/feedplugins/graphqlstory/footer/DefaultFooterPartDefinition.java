package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.fallback.annotations.FallbackSpec;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
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
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
@FallbackSpec(mountType = DefaultFooterView.class)
/* compiled from: has_viewer_claimed */
public class DefaultFooterPartDefinition<E extends HasPersistentState & CanFeedback & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, DefaultFooterView> {
    private static DefaultFooterPartDefinition f21244e;
    private static final Object f21245f = new Object();
    private final FooterPartDefinition<DefaultFooterView> f21246a;
    private final FooterBackgroundPartDefinition<DefaultFooterView> f21247b;
    public final FeedStoryUtil f21248c;
    public final GraphQLStoryUtil f21249d;

    private static DefaultFooterPartDefinition m28962b(InjectorLike injectorLike) {
        return new DefaultFooterPartDefinition(FooterPartDefinition.m28968a(injectorLike), FooterBackgroundPartDefinition.m28997a(injectorLike), FeedStoryUtil.m18578a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        FooterLevel a = m28963a(feedProps, (HasPersistentState) anyEnvironment);
        subParts.mo2756a(this.f21246a, feedProps);
        subParts.mo2756a(this.f21247b, new Props(feedProps, a));
        return null;
    }

    @Inject
    public DefaultFooterPartDefinition(FooterPartDefinition footerPartDefinition, FooterBackgroundPartDefinition footerBackgroundPartDefinition, FeedStoryUtil feedStoryUtil, GraphQLStoryUtil graphQLStoryUtil) {
        this.f21246a = footerPartDefinition;
        this.f21247b = footerBackgroundPartDefinition;
        this.f21248c = feedStoryUtil;
        this.f21249d = graphQLStoryUtil;
    }

    public final ViewType<DefaultFooterView> mo2547a() {
        return DefaultFooterView.f22314a;
    }

    public static DefaultFooterPartDefinition m28960a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21245f) {
                DefaultFooterPartDefinition defaultFooterPartDefinition;
                if (a2 != null) {
                    defaultFooterPartDefinition = (DefaultFooterPartDefinition) a2.mo818a(f21245f);
                } else {
                    defaultFooterPartDefinition = f21244e;
                }
                if (defaultFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28962b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21245f, b3);
                        } else {
                            f21244e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean m28966a(FeedProps<GraphQLStory> feedProps) {
        return this.f21249d.m9594c(feedProps);
    }

    public final FooterLevel m28963a(FeedProps<GraphQLStory> feedProps, E e) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (!this.f21248c.m18591c(graphQLStory)) {
            Object obj;
            if (this.f21248c.m18587a((FeedProps) feedProps) || this.f21248c.m18590c((FeedProps) feedProps)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                Object obj2;
                if (graphQLStory == null || graphQLStory.m22319E() == null) {
                    obj2 = null;
                } else {
                    ImmutableList E = graphQLStory.m22319E();
                    int size = E.size();
                    for (int i = 0; i < size; i++) {
                        GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) E.get(i);
                        if (graphQLStoryActionLink.m22901a() != null && graphQLStoryActionLink.m22901a().m22301g() == 1695485490) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                }
                if (obj2 != null) {
                    return FooterLevel.HAS_INLINE_SURVEY;
                }
                if (GraphQLStoryUtil.m9575d((FeedProps) feedProps) || m28961a((HasPersistentState) e)) {
                    return FooterLevel.HAS_FOLLOWUP_SECTION;
                }
                Flattenable flattenable = feedProps.f13444a;
                if (StoryProps.m27464m(feedProps) || this.f21249d.m9594c(feedProps)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    return FooterLevel.TOP;
                }
                return null;
            }
        }
        return FooterLevel.HAS_INLINE_COMMENTS;
    }

    private static boolean m28961a(E e) {
        if (e == null) {
            return false;
        }
        MultiRowSinglePartDefinition h = ((HasPositionInformation) e).mo2451h();
        return (h instanceof HasSpecialStyling) && ((HasSpecialStyling) h).mo3125b() == SpecialStylingType.FOLLOWUP_FEEDUNIT;
    }
}
