package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.rows.sections.livefeed.ui.LiveFeedMainHeaderView;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Plugin already registered */
public class LiveFeedMainHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasSearchResultsContext, LiveFeedMainHeaderView> {
    public static final ViewType f24483a = new C25871();
    private static LiveFeedMainHeaderPartDefinition f24484c;
    private static final Object f24485d = new Object();
    private final LiveFeedHeaderPartDefinition f24486b;

    /* compiled from: Plugin already registered */
    final class C25871 extends ViewType {
        C25871() {
        }

        public final View m27944a(Context context) {
            return new LiveFeedMainHeaderView(context);
        }
    }

    private static LiveFeedMainHeaderPartDefinition m27947b(InjectorLike injectorLike) {
        return new LiveFeedMainHeaderPartDefinition(LiveFeedHeaderPartDefinition.m27927a(injectorLike));
    }

    public final Object m27949a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24486b, (FeedProps) obj);
        return null;
    }

    @Inject
    public LiveFeedMainHeaderPartDefinition(LiveFeedHeaderPartDefinition liveFeedHeaderPartDefinition) {
        this.f24486b = liveFeedHeaderPartDefinition;
    }

    public final ViewType<LiveFeedMainHeaderView> m27948a() {
        return f24483a;
    }

    public static boolean m27946a(FeedProps<GraphQLStory> feedProps) {
        if (feedProps == null) {
            return false;
        }
        return !Strings.isNullOrEmpty(StoryTextHelper.a((GraphQLStory) feedProps.a));
    }

    public static LiveFeedMainHeaderPartDefinition m27945a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedMainHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24485d) {
                LiveFeedMainHeaderPartDefinition liveFeedMainHeaderPartDefinition;
                if (a2 != null) {
                    liveFeedMainHeaderPartDefinition = (LiveFeedMainHeaderPartDefinition) a2.a(f24485d);
                } else {
                    liveFeedMainHeaderPartDefinition = f24484c;
                }
                if (liveFeedMainHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27947b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24485d, b3);
                        } else {
                            f24484c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedMainHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
