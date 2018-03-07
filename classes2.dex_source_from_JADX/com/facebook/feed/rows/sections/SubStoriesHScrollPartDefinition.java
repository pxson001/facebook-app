package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollUtil;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.util.story.FeedStoryUtil;
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
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: height */
public class SubStoriesHScrollPartDefinition<E extends HasInvalidate & HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, HScrollRecyclerView> {
    private static SubStoriesHScrollPartDefinition f21118h;
    private static final Object f21119i = new Object();
    public final SubStoriesPagePartDefinition<E> f21120a;
    public final EventSubStoriesPagePartDefinition f21121b;
    private final BackgroundPartDefinition f21122c;
    private final PageStyleFactory f21123d;
    private final HScrollUtil f21124e;
    private final PersistentRecyclerPartDefinition<Object, E> f21125f;
    private final FeedStoryUtil f21126g;

    private static SubStoriesHScrollPartDefinition m28869b(InjectorLike injectorLike) {
        return new SubStoriesHScrollPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), SubStoriesPagePartDefinition.a(injectorLike), EventSubStoriesPagePartDefinition.a(injectorLike), PageStyleFactory.m26330b(injectorLike), HScrollUtil.a(injectorLike), PersistentRecyclerPartDefinition.m26338a(injectorLike), FeedStoryUtil.m18578a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f21122c, new StylingData(feedProps, PageStyle.a));
        PageStyle a = this.f21123d.m26332a(this.f21124e.b() + 8.0f, PageStyle.a, true);
        GraphQLStory graphQLStory2 = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f21125f, new Props(a, graphQLStory.ac_(), new 1(this, feedProps, StoryHierarchyHelper.m27434a(graphQLStory2).m22608j(), graphQLStory2), graphQLStory.mo2507g(), graphQLStory));
        return null;
    }

    public final boolean m28872a(Object obj) {
        return m28868a((FeedProps) obj);
    }

    @Inject
    public SubStoriesHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, SubStoriesPagePartDefinition subStoriesPagePartDefinition, EventSubStoriesPagePartDefinition eventSubStoriesPagePartDefinition, PageStyleFactory pageStyleFactory, HScrollUtil hScrollUtil, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, FeedStoryUtil feedStoryUtil) {
        this.f21120a = subStoriesPagePartDefinition;
        this.f21121b = eventSubStoriesPagePartDefinition;
        this.f21122c = backgroundPartDefinition;
        this.f21123d = pageStyleFactory;
        this.f21124e = hScrollUtil;
        this.f21125f = persistentRecyclerPartDefinition;
        this.f21126g = feedStoryUtil;
    }

    public static SubStoriesHScrollPartDefinition m28867a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SubStoriesHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21119i) {
                SubStoriesHScrollPartDefinition subStoriesHScrollPartDefinition;
                if (a2 != null) {
                    subStoriesHScrollPartDefinition = (SubStoriesHScrollPartDefinition) a2.mo818a(f21119i);
                } else {
                    subStoriesHScrollPartDefinition = f21118h;
                }
                if (subStoriesHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28869b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21119i, b3);
                        } else {
                            f21118h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = subStoriesHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType mo2547a() {
        return HScrollRecyclerViewRowType.a;
    }

    public static boolean m28868a(FeedProps<GraphQLStory> feedProps) {
        return GraphQLStoryUtil.m9570a(StoryUtilModelConverter.m28877a((GraphQLStory) feedProps.f13444a)) || FeedStoryUtil.m18586e((GraphQLStory) feedProps.f13444a);
    }
}
