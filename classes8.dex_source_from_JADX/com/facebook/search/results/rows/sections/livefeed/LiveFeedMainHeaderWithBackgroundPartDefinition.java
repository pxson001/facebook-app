package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
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
/* compiled from: PlatformShareDialogSetup */
public class LiveFeedMainHeaderWithBackgroundPartDefinition<E extends HasPositionInformation & HasSearchResultsContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, LiveFeedMainHeaderView> {
    public static final ViewType f24487a = LiveFeedMainHeaderPartDefinition.f24483a;
    private static LiveFeedMainHeaderWithBackgroundPartDefinition f24488d;
    private static final Object f24489e = new Object();
    private final LiveFeedHeaderPartDefinition f24490b;
    private final BackgroundPartDefinition f24491c;

    private static LiveFeedMainHeaderWithBackgroundPartDefinition m27953b(InjectorLike injectorLike) {
        return new LiveFeedMainHeaderWithBackgroundPartDefinition(LiveFeedHeaderPartDefinition.m27927a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27955a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f24490b, feedProps);
        subParts.a(this.f24491c, new StylingData(feedProps, PaddingStyle.a, Position.DIVIDER_TOP));
        return null;
    }

    @Inject
    public LiveFeedMainHeaderWithBackgroundPartDefinition(LiveFeedHeaderPartDefinition liveFeedHeaderPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24490b = liveFeedHeaderPartDefinition;
        this.f24491c = backgroundPartDefinition;
    }

    public final ViewType<LiveFeedMainHeaderView> m27954a() {
        return f24487a;
    }

    public static boolean m27952a(FeedProps<GraphQLStory> feedProps) {
        if (feedProps.a == null) {
            return false;
        }
        return !Strings.isNullOrEmpty(StoryTextHelper.a((GraphQLStory) feedProps.a));
    }

    public static LiveFeedMainHeaderWithBackgroundPartDefinition m27951a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedMainHeaderWithBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24489e) {
                LiveFeedMainHeaderWithBackgroundPartDefinition liveFeedMainHeaderWithBackgroundPartDefinition;
                if (a2 != null) {
                    liveFeedMainHeaderWithBackgroundPartDefinition = (LiveFeedMainHeaderWithBackgroundPartDefinition) a2.a(f24489e);
                } else {
                    liveFeedMainHeaderWithBackgroundPartDefinition = f24488d;
                }
                if (liveFeedMainHeaderWithBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27953b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24489e, b3);
                        } else {
                            f24488d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedMainHeaderWithBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
