package com.facebook.reaction.feed.styling;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel.ReactionPaginatedComponentsModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitSubComponentModel;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.permission.GET_ACCOUNTS */
public class ReactionHScrollPagerPaddingResolver {
    private static ReactionHScrollPagerPaddingResolver f19516b;
    private static final Object f19517c = new Object();
    private final FeedRenderUtils f19518a;

    private static ReactionHScrollPagerPaddingResolver m23460b(InjectorLike injectorLike) {
        return new ReactionHScrollPagerPaddingResolver(FeedRenderUtils.a(injectorLike));
    }

    @Inject
    public ReactionHScrollPagerPaddingResolver(FeedRenderUtils feedRenderUtils) {
        this.f19518a = feedRenderUtils;
    }

    public final int m23462a(Context context, ReactionUnitComponentNode reactionUnitComponentNode) {
        GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle;
        PaginatedComponentsModel c = ReactionUnitComponentUtil.m22903c(reactionUnitComponentNode);
        if (c == null || c.c() == null) {
            graphQLReactionUnitComponentStyle = null;
        } else {
            ImmutableList a = c.c().a();
            if (!a.isEmpty()) {
                ReactionUnitSubComponentModel a2 = ((EdgesModel) a.get(0)).a();
                if (a2 != null) {
                    graphQLReactionUnitComponentStyle = a2.a();
                }
            }
            graphQLReactionUnitComponentStyle = null;
        }
        GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle2 = graphQLReactionUnitComponentStyle;
        if (graphQLReactionUnitComponentStyle2 == null) {
            return m23458a(context);
        }
        return m23461a(context, graphQLReactionUnitComponentStyle2);
    }

    public final int m23461a(Context context, GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
        if (graphQLReactionUnitComponentStyle == GraphQLReactionUnitComponentStyle.VIDEO_CHANNEL_FEED_UNIT_SQUARE) {
            return (this.f19518a.a() / 2) - context.getResources().getDimensionPixelSize(2131431399);
        }
        if (graphQLReactionUnitComponentStyle == GraphQLReactionUnitComponentStyle.EXPLORE_FEED_RECOMMENDATION) {
            return context.getResources().getDimensionPixelSize(2131431400);
        }
        if (graphQLReactionUnitComponentStyle == GraphQLReactionUnitComponentStyle.PAGE_CREATE_PHOTO_ALBUM || graphQLReactionUnitComponentStyle == GraphQLReactionUnitComponentStyle.PAGE_PHOTO_ALBUM) {
            return (this.f19518a.a() / 3) - context.getResources().getDimensionPixelSize(2131431399);
        }
        return m23458a(context);
    }

    public static ReactionHScrollPagerPaddingResolver m23459a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionHScrollPagerPaddingResolver b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19517c) {
                ReactionHScrollPagerPaddingResolver reactionHScrollPagerPaddingResolver;
                if (a2 != null) {
                    reactionHScrollPagerPaddingResolver = (ReactionHScrollPagerPaddingResolver) a2.a(f19517c);
                } else {
                    reactionHScrollPagerPaddingResolver = f19516b;
                }
                if (reactionHScrollPagerPaddingResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23460b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19517c, b3);
                        } else {
                            f19516b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionHScrollPagerPaddingResolver;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static int m23458a(Context context) {
        return context.getResources().getDimensionPixelSize(2131431398);
    }
}
