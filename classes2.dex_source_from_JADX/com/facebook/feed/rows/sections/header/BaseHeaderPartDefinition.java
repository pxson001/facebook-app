package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.permalink.PermalinkFeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.HeaderTitleWithLayoutPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithTextLayout;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.graphql.story.util.StoryUtilModelConverter;
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
/* compiled from: hysteresis_percent */
public class BaseHeaderPartDefinition<E extends HasFeedListType & HasInvalidate & HasAnchoredTooltipProvider & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, HeaderViewWithTextLayout> {
    private static BaseHeaderPartDefinition f20646g;
    private static final Object f20647h = new Object();
    private final TextLinkPartDefinition f20648a;
    private final StoryMenuButtonPartDefinition<E, HeaderViewWithTextLayout> f20649b;
    private final ProfilePhotoPartDefinition<E> f20650c;
    private final HeaderTitleWithLayoutPartDefinition<E> f20651d;
    private final DefaultHeaderSubtitleWithLayoutPartDefinition f20652e;
    private final StoryHeaderUtil f20653f;

    private static BaseHeaderPartDefinition m28397b(InjectorLike injectorLike) {
        return new BaseHeaderPartDefinition(TextLinkPartDefinition.m28402a(injectorLike), StoryMenuButtonPartDefinition.m28407a(injectorLike), ProfilePhotoPartDefinition.m28424a(injectorLike), HeaderTitleWithLayoutPartDefinition.m28427a(injectorLike), DefaultHeaderSubtitleWithLayoutPartDefinition.m28432a(injectorLike), StoryHeaderUtil.m28330a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (((HasFeedListType) anyEnvironment).mo2446c() != PermalinkFeedListType.f21731a) {
            subParts.mo2756a(this.f20648a, feedProps);
        }
        subParts.mo2756a(this.f20649b, feedProps);
        subParts.mo2755a(2131562765, this.f20651d, new Props(feedProps, true, -1));
        int c = this.f20653f.m28336c(feedProps);
        subParts.mo2755a(2131562764, this.f20650c, new ProfilePhotoPartDefinition.Props(feedProps, this.f20653f.m28335b(feedProps), c));
        subParts.mo2755a(2131562766, this.f20652e, new DefaultHeaderSubtitleWithLayoutPartDefinition.Props(feedProps, -1));
        return null;
    }

    public static BaseHeaderPartDefinition m28396a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BaseHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20647h) {
                BaseHeaderPartDefinition baseHeaderPartDefinition;
                if (a2 != null) {
                    baseHeaderPartDefinition = (BaseHeaderPartDefinition) a2.mo818a(f20647h);
                } else {
                    baseHeaderPartDefinition = f20646g;
                }
                if (baseHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28397b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20647h, b3);
                        } else {
                            f20646g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = baseHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public BaseHeaderPartDefinition(TextLinkPartDefinition textLinkPartDefinition, StoryMenuButtonPartDefinition storyMenuButtonPartDefinition, ProfilePhotoPartDefinition profilePhotoPartDefinition, HeaderTitleWithLayoutPartDefinition headerTitleWithLayoutPartDefinition, DefaultHeaderSubtitleWithLayoutPartDefinition defaultHeaderSubtitleWithLayoutPartDefinition, StoryHeaderUtil storyHeaderUtil) {
        this.f20648a = textLinkPartDefinition;
        this.f20649b = storyMenuButtonPartDefinition;
        this.f20651d = headerTitleWithLayoutPartDefinition;
        this.f20652e = defaultHeaderSubtitleWithLayoutPartDefinition;
        this.f20650c = profilePhotoPartDefinition;
        this.f20653f = storyHeaderUtil;
    }

    public final ViewType mo2547a() {
        return HeaderViewWithTextLayout.f21710k;
    }

    public static boolean m28398b(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (!StoryProps.m27464m(feedProps)) {
            Object obj = null;
            if (!(!StoryHierarchyHelper.m27437d(graphQLStory) || GraphQLStoryUtil.m9570a(StoryUtilModelConverter.m28877a(graphQLStory)) || FeedStoryUtil.m18586e(graphQLStory))) {
                obj = 1;
            }
            if (obj == null) {
                return true;
            }
        }
        return false;
    }
}
