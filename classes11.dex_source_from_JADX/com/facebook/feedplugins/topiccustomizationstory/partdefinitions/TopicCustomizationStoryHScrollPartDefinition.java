package com.facebook.feedplugins.topiccustomizationstory.partdefinitions;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLTopicCustomizationStory;
import com.facebook.graphql.model.GraphQLTrueTopicFeedOption;
import com.facebook.graphql.model.VisibleItemHelper;
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
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android_async_feed_cache_sync */
public class TopicCustomizationStoryHScrollPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLTopicCustomizationStory>, Void, FeedEnvironment, HScrollRecyclerView> {
    private static final PaddingStyle f9941c = PageStyle.a;
    private static TopicCustomizationStoryHScrollPartDefinition f9942i;
    private static final Object f9943j = new Object();
    public final float f9944a = ((this.f9949g.getDimension(2131434679) / this.f9949g.getDisplayMetrics().density) + 8.0f);
    protected final TopicCustomizationStoryPagePartDefinition f9945b;
    private final BackgroundPartDefinition f9946d;
    private final PageStyleFactory f9947e;
    private final PersistentRecyclerPartDefinition<Object, FeedEnvironment> f9948f;
    private final Resources f9949g;
    public final TopicCustomizationStorySeeAllPartDefinition f9950h;

    private static TopicCustomizationStoryHScrollPartDefinition m10304b(InjectorLike injectorLike) {
        return new TopicCustomizationStoryHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), TopicCustomizationStoryPagePartDefinition.a(injectorLike), TopicCustomizationStorySeeAllPartDefinition.m10319a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m10306a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLTopicCustomizationStory graphQLTopicCustomizationStory = (GraphQLTopicCustomizationStory) feedProps.a;
        subParts.a(this.f9946d, new StylingData(feedProps, f9941c));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f9948f;
        PageStyle a = this.f9947e.a(this.f9944a, f9941c, true);
        int ac_ = graphQLTopicCustomizationStory.ac_();
        final ImmutableList o = graphQLTopicCustomizationStory.o();
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new SimpleCallbacks<FeedEnvironment>(this) {
            final /* synthetic */ TopicCustomizationStoryHScrollPartDefinition f9940c;

            public final void m10301a(PageSubParts<FeedEnvironment> pageSubParts) {
                int size = o.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.a(this.f9940c.f9945b, new TopicCustomizationStoryUtil.Props(graphQLTopicCustomizationStory, (GraphQLTrueTopicFeedOption) o.get(i)));
                }
                pageSubParts.a(this.f9940c.f9950h, FeedProps.c(graphQLTopicCustomizationStory));
            }

            public final void m10302c(int i) {
                VisibleItemHelper.a(graphQLTopicCustomizationStory, o, i);
            }
        }, graphQLTopicCustomizationStory.g(), graphQLTopicCustomizationStory));
        return null;
    }

    public final boolean m10307a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps.a == null) {
            return false;
        }
        return CollectionUtil.b(((GraphQLTopicCustomizationStory) feedProps.a).o());
    }

    @Inject
    public TopicCustomizationStoryHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, TopicCustomizationStoryPagePartDefinition topicCustomizationStoryPagePartDefinition, TopicCustomizationStorySeeAllPartDefinition topicCustomizationStorySeeAllPartDefinition, Resources resources) {
        this.f9946d = backgroundPartDefinition;
        this.f9947e = pageStyleFactory;
        this.f9948f = persistentRecyclerPartDefinition;
        this.f9945b = topicCustomizationStoryPagePartDefinition;
        this.f9950h = topicCustomizationStorySeeAllPartDefinition;
        this.f9949g = resources;
    }

    public static TopicCustomizationStoryHScrollPartDefinition m10303a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopicCustomizationStoryHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9943j) {
                TopicCustomizationStoryHScrollPartDefinition topicCustomizationStoryHScrollPartDefinition;
                if (a2 != null) {
                    topicCustomizationStoryHScrollPartDefinition = (TopicCustomizationStoryHScrollPartDefinition) a2.a(f9943j);
                } else {
                    topicCustomizationStoryHScrollPartDefinition = f9942i;
                }
                if (topicCustomizationStoryHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10304b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9943j, b3);
                        } else {
                            f9942i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = topicCustomizationStoryHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m10305a() {
        return HScrollRecyclerViewRowType.a;
    }
}
