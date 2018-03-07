package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.HasFeedUnit;
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
/* compiled from: ineligible */
public class FeedCommentPartDefinition<E extends HasPositionInformation & HasRowKey & HasPersistentState & HasPrefetcher> extends MultiRowSinglePartDefinition<Props, Void, E, InlineCommentView> {
    private static FeedCommentPartDefinition f20206d;
    private static final Object f20207e = new Object();
    private final GraphQLStoryUtil f20208a;
    private final InlineCommentPartDefinition<E> f20209b;
    private final BackgroundPartDefinition f20210c;

    /* compiled from: ineligible */
    public class Props implements HasFeedProps<GraphQLStory>, HasFeedUnit {
        public final FeedProps<GraphQLStory> f21613a;
        public final InlineCommentData f21614b;

        public Props(FeedProps<GraphQLStory> feedProps, InlineCommentData inlineCommentData) {
            this.f21613a = feedProps;
            this.f21614b = inlineCommentData;
        }

        public final FeedUnit mo2540c() {
            return (FeedUnit) this.f21613a.f13444a;
        }

        public final FeedProps<GraphQLStory> mo2637f() {
            return this.f21613a;
        }
    }

    private static FeedCommentPartDefinition m27862b(InjectorLike injectorLike) {
        return new FeedCommentPartDefinition(GraphQLStoryUtil.m9565a(injectorLike), InlineCommentPartDefinition.m27867a(injectorLike), BackgroundPartDefinition.m19135a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.mo2756a(this.f20209b, props.f21614b);
        FeedProps f = props.mo2637f();
        FeedProps b = StoryProps.m27455b(f);
        int i = 2130840207;
        if (GraphQLStoryUtil.m9578j(f) && this.f20208a.m9599h(b)) {
            i = 2130840209;
        }
        subParts.mo2756a(this.f20210c, new StylingData(props.f21613a, PaddingStyle.f13075e, -1, i));
        return null;
    }

    public final boolean m27865a(Object obj) {
        Props props = (Props) obj;
        return true;
    }

    public static FeedCommentPartDefinition m27861a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedCommentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20207e) {
                FeedCommentPartDefinition feedCommentPartDefinition;
                if (a2 != null) {
                    feedCommentPartDefinition = (FeedCommentPartDefinition) a2.mo818a(f20207e);
                } else {
                    feedCommentPartDefinition = f20206d;
                }
                if (feedCommentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27862b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20207e, b3);
                        } else {
                            f20206d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedCommentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FeedCommentPartDefinition(GraphQLStoryUtil graphQLStoryUtil, InlineCommentPartDefinition inlineCommentPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f20208a = graphQLStoryUtil;
        this.f20209b = inlineCommentPartDefinition;
        this.f20210c = backgroundPartDefinition;
    }

    public final ViewType<InlineCommentView> mo2547a() {
        return this.f20209b.mo2547a();
    }
}
