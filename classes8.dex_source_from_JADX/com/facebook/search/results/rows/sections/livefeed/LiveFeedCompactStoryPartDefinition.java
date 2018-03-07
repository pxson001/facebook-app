package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PmaPageFirstStoriesSequence */
public class LiveFeedCompactStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, SearchResultsFeedEnvironment> {
    private static LiveFeedCompactStoryPartDefinition f24436b;
    private static final Object f24437c = new Object();
    private final LiveFeedMainHeaderWithBackgroundPartDefinition f24438a;

    private static LiveFeedCompactStoryPartDefinition m27910b(InjectorLike injectorLike) {
        return new LiveFeedCompactStoryPartDefinition(LiveFeedMainHeaderWithBackgroundPartDefinition.m27951a(injectorLike));
    }

    public final Object m27911a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f24438a, (FeedProps) obj);
        return null;
    }

    public final boolean m27912a(Object obj) {
        return LiveFeedMainHeaderWithBackgroundPartDefinition.m27952a((FeedProps) obj);
    }

    @Inject
    public LiveFeedCompactStoryPartDefinition(LiveFeedMainHeaderWithBackgroundPartDefinition liveFeedMainHeaderWithBackgroundPartDefinition) {
        this.f24438a = liveFeedMainHeaderWithBackgroundPartDefinition;
    }

    public static LiveFeedCompactStoryPartDefinition m27909a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedCompactStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24437c) {
                LiveFeedCompactStoryPartDefinition liveFeedCompactStoryPartDefinition;
                if (a2 != null) {
                    liveFeedCompactStoryPartDefinition = (LiveFeedCompactStoryPartDefinition) a2.a(f24437c);
                } else {
                    liveFeedCompactStoryPartDefinition = f24436b;
                }
                if (liveFeedCompactStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27910b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24437c, b3);
                        } else {
                            f24436b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedCompactStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
