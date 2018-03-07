package com.facebook.search.results.rows.sections.derp;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedHeaderPartDefinition;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_FETCH */
public class DerpSuperDenseHeaderWithBackgroundPartDefinition<E extends HasPositionInformation & HasSearchResultsContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, DerpSuperDenseHeaderView> {
    public static final ViewType f24081a = new C25661();
    public static final ImmutableSet<GraphQLStoryAttachmentStyle> f24082b = ImmutableSet.of(GraphQLStoryAttachmentStyle.PHOTO, GraphQLStoryAttachmentStyle.ALBUM, GraphQLStoryAttachmentStyle.NEW_ALBUM);
    public static final CallerContext f24083c = CallerContext.a(LiveFeedHeaderPartDefinition.class, "graph_search_results_live_conversation_fragment");
    private static DerpSuperDenseHeaderWithBackgroundPartDefinition f24084f;
    private static final Object f24085g = new Object();
    private final LiveFeedHeaderPartDefinition f24086d;
    private final BackgroundPartDefinition f24087e;

    /* compiled from: REACTION_FETCH */
    final class C25661 extends ViewType {
        C25661() {
        }

        public final View m27633a(Context context) {
            return new DerpSuperDenseHeaderView(context);
        }
    }

    private static DerpSuperDenseHeaderWithBackgroundPartDefinition m27636b(InjectorLike injectorLike) {
        return new DerpSuperDenseHeaderWithBackgroundPartDefinition(LiveFeedHeaderPartDefinition.m27927a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27638a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f24086d, feedProps);
        subParts.a(this.f24087e, new StylingData(feedProps, PaddingStyle.a, Position.DIVIDER_TOP));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m27639a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 759643184);
        DerpSuperDenseHeaderView derpSuperDenseHeaderView = (DerpSuperDenseHeaderView) view;
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        GraphQLImage q = StoryAttachmentHelper.q(graphQLStory);
        if (q != null && f24082b.contains(StoryAttachmentHelper.o(graphQLStory).w().get(0))) {
            derpSuperDenseHeaderView.m27632a(Uri.parse(q.b()), f24083c);
            derpSuperDenseHeaderView.f24080h.setVisibility(0);
        }
        Logger.a(8, EntryType.MARK_POP, 1895134336, a);
    }

    public final void m27641b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        DerpSuperDenseHeaderView derpSuperDenseHeaderView = (DerpSuperDenseHeaderView) view;
        super.b((FeedProps) obj, (Void) obj2, (HasPositionInformation) anyEnvironment, derpSuperDenseHeaderView);
        derpSuperDenseHeaderView.m27632a(null, f24083c);
        derpSuperDenseHeaderView.f24080h.setVisibility(8);
    }

    public static DerpSuperDenseHeaderWithBackgroundPartDefinition m27634a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DerpSuperDenseHeaderWithBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24085g) {
                DerpSuperDenseHeaderWithBackgroundPartDefinition derpSuperDenseHeaderWithBackgroundPartDefinition;
                if (a2 != null) {
                    derpSuperDenseHeaderWithBackgroundPartDefinition = (DerpSuperDenseHeaderWithBackgroundPartDefinition) a2.a(f24085g);
                } else {
                    derpSuperDenseHeaderWithBackgroundPartDefinition = f24084f;
                }
                if (derpSuperDenseHeaderWithBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27636b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24085g, b3);
                        } else {
                            f24084f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = derpSuperDenseHeaderWithBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public DerpSuperDenseHeaderWithBackgroundPartDefinition(LiveFeedHeaderPartDefinition liveFeedHeaderPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24086d = liveFeedHeaderPartDefinition;
        this.f24087e = backgroundPartDefinition;
    }

    public final ViewType<DerpSuperDenseHeaderView> m27637a() {
        return f24081a;
    }

    public static boolean m27635a(FeedProps<GraphQLStory> feedProps) {
        return feedProps.a != null;
    }
}
