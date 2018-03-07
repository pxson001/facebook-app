package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.DefaultHeaderSubtitleWithLayoutPartDefinition;
import com.facebook.feed.rows.sections.header.ProfilePhotoPartDefinition;
import com.facebook.feed.rows.sections.header.ProfilePhotoPartDefinition.Props;
import com.facebook.feed.rows.sections.header.StoryHeaderUtil;
import com.facebook.feed.rows.sections.header.StoryMenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithTextLayout;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
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
/* compiled from: ThreadListLoader.startLoadThreadList */
public class GroupsHeaderPartDefinition<E extends HasContext & HasAnchoredTooltipProvider & HasFeedListType & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, HeaderViewWithTextLayout> {
    private static GroupsHeaderPartDefinition f22459h;
    private static final Object f22460i = new Object();
    private final BackgroundPartDefinition f22461a;
    private final GroupsHeaderTitlePartDefinition f22462b;
    private final TextLinkPartDefinition f22463c;
    private final DefaultHeaderSubtitleWithLayoutPartDefinition<E> f22464d;
    private final ProfilePhotoPartDefinition<E> f22465e;
    private final StoryMenuButtonPartDefinition<E, HeaderViewWithTextLayout> f22466f;
    private final StoryHeaderUtil f22467g;

    private static GroupsHeaderPartDefinition m23530b(InjectorLike injectorLike) {
        return new GroupsHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), GroupsHeaderTitlePartDefinition.m23542a(injectorLike), TextLinkPartDefinition.a(injectorLike), DefaultHeaderSubtitleWithLayoutPartDefinition.a(injectorLike), ProfilePhotoPartDefinition.a(injectorLike), StoryMenuButtonPartDefinition.a(injectorLike), StoryHeaderUtil.a(injectorLike));
    }

    public final Object m23532a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f22463c, feedProps);
        subParts.a(this.f22461a, this.f22467g.a(feedProps));
        subParts.a(this.f22466f, feedProps);
        int c = this.f22467g.c(feedProps);
        subParts.a(2131562764, this.f22465e, new Props(feedProps, this.f22467g.b(feedProps), c));
        subParts.a(2131562765, this.f22462b, feedProps);
        subParts.a(2131562766, this.f22464d, new DefaultHeaderSubtitleWithLayoutPartDefinition.Props(feedProps, -1));
        return null;
    }

    public final boolean m23533a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return (StoryProps.m(feedProps) || StoryActorHelper.b((GraphQLStory) feedProps.a) == null) ? false : true;
    }

    public static GroupsHeaderPartDefinition m23529a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22460i) {
                GroupsHeaderPartDefinition groupsHeaderPartDefinition;
                if (a2 != null) {
                    groupsHeaderPartDefinition = (GroupsHeaderPartDefinition) a2.a(f22460i);
                } else {
                    groupsHeaderPartDefinition = f22459h;
                }
                if (groupsHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23530b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22460i, b3);
                        } else {
                            f22459h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupsHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, GroupsHeaderTitlePartDefinition groupsHeaderTitlePartDefinition, TextLinkPartDefinition textLinkPartDefinition, DefaultHeaderSubtitleWithLayoutPartDefinition defaultHeaderSubtitleWithLayoutPartDefinition, ProfilePhotoPartDefinition profilePhotoPartDefinition, StoryMenuButtonPartDefinition storyMenuButtonPartDefinition, StoryHeaderUtil storyHeaderUtil) {
        this.f22461a = backgroundPartDefinition;
        this.f22463c = textLinkPartDefinition;
        this.f22462b = groupsHeaderTitlePartDefinition;
        this.f22464d = defaultHeaderSubtitleWithLayoutPartDefinition;
        this.f22465e = profilePhotoPartDefinition;
        this.f22466f = storyMenuButtonPartDefinition;
        this.f22467g = storyHeaderUtil;
    }

    public final ViewType m23531a() {
        return HeaderViewWithTextLayout.k;
    }
}
