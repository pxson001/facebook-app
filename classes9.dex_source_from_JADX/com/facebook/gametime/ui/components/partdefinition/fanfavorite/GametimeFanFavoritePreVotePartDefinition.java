package com.facebook.gametime.ui.components.partdefinition.fanfavorite;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQL.GametimeFanFavoriteAddVoteMutationString;
import com.facebook.gametime.ui.components.persistentstate.GametimeFanFavoriteState;
import com.facebook.gametime.ui.components.persistentstate.GametimeFanFavoriteStateKey;
import com.facebook.graphql.calls.ReactionGametimeFanFavoriteAddVoteInputData;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MatchModel;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TAB_ALL */
public class GametimeFanFavoritePreVotePartDefinition<E extends HasInvalidate & HasPersistentState> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, CustomLinearLayout> {
    public static final ViewType f25188a = ViewType.a(2130904573);
    private static final CallerContext f25189b = CallerContext.a(GametimeFanFavoritePreVotePartDefinition.class, "gametime");
    private static GametimeFanFavoritePreVotePartDefinition f25190g;
    private static final Object f25191h = new Object();
    private final FbDraweePartDefinition f25192c;
    private final TextPartDefinition f25193d;
    private final ClickListenerPartDefinition f25194e;
    private final GraphQLQueryExecutor f25195f;

    private static GametimeFanFavoritePreVotePartDefinition m27145b(InjectorLike injectorLike) {
        return new GametimeFanFavoritePreVotePartDefinition(FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    public final Object m27147a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        MatchModel bu = reactionUnitComponentNode.b.bu();
        Builder a = FbDraweePartDefinition.a().a(bu.c().a().a().a());
        a.c = f25189b;
        Props a2 = a.a();
        Builder a3 = FbDraweePartDefinition.a().a(bu.g().a().a().a());
        a3.c = f25189b;
        Props a4 = a3.a();
        final String b = reactionUnitComponentNode.b.F().b();
        String b2 = reactionUnitComponentNode.b.aM().b();
        final String b3 = reactionUnitComponentNode.b.bu().r().b();
        subParts.a(2131562481, this.f25192c, a2);
        subParts.a(2131562485, this.f25192c, a4);
        subParts.a(2131562487, this.f25193d, bu.c().b());
        subParts.a(2131562488, this.f25193d, bu.g().b());
        final ReactionUnitComponentNode reactionUnitComponentNode2 = reactionUnitComponentNode;
        final HasInvalidate hasInvalidate2 = hasInvalidate;
        subParts.a(2131561726, this.f25194e, new OnClickListener(this) {
            final /* synthetic */ GametimeFanFavoritePreVotePartDefinition f25182e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -209773748);
                GametimeFanFavoritePreVotePartDefinition.m27144a(this.f25182e, b3, b, reactionUnitComponentNode2, hasInvalidate2);
                Logger.a(2, EntryType.UI_INPUT_END, -356655561, a);
            }
        });
        b = b2;
        reactionUnitComponentNode2 = reactionUnitComponentNode;
        hasInvalidate2 = hasInvalidate;
        subParts.a(2131561727, this.f25194e, new OnClickListener(this) {
            final /* synthetic */ GametimeFanFavoritePreVotePartDefinition f25187e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1274054326);
                GametimeFanFavoritePreVotePartDefinition.m27144a(this.f25187e, b3, b, reactionUnitComponentNode2, hasInvalidate2);
                Logger.a(2, EntryType.UI_INPUT_END, 615346752, a);
            }
        });
        return null;
    }

    public final boolean m27148a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return reactionUnitComponentNode.b.bu() != null && GametimeFanFavoriteUnitComponentPartDefinition.m27150a(reactionUnitComponentNode);
    }

    @Inject
    public GametimeFanFavoritePreVotePartDefinition(FbDraweePartDefinition fbDraweePartDefinition, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f25192c = fbDraweePartDefinition;
        this.f25193d = textPartDefinition;
        this.f25194e = clickListenerPartDefinition;
        this.f25195f = graphQLQueryExecutor;
    }

    public static GametimeFanFavoritePreVotePartDefinition m27143a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeFanFavoritePreVotePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25191h) {
                GametimeFanFavoritePreVotePartDefinition gametimeFanFavoritePreVotePartDefinition;
                if (a2 != null) {
                    gametimeFanFavoritePreVotePartDefinition = (GametimeFanFavoritePreVotePartDefinition) a2.a(f25191h);
                } else {
                    gametimeFanFavoritePreVotePartDefinition = f25190g;
                }
                if (gametimeFanFavoritePreVotePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27145b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25191h, b3);
                        } else {
                            f25190g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeFanFavoritePreVotePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m27146a() {
        return f25188a;
    }

    public static void m27144a(GametimeFanFavoritePreVotePartDefinition gametimeFanFavoritePreVotePartDefinition, String str, String str2, ReactionUnitComponentNode reactionUnitComponentNode, HasInvalidate hasInvalidate) {
        GametimeFanFavoriteAddVoteMutationString gametimeFanFavoriteAddVoteMutationString = new GametimeFanFavoriteAddVoteMutationString();
        ReactionGametimeFanFavoriteAddVoteInputData reactionGametimeFanFavoriteAddVoteInputData = new ReactionGametimeFanFavoriteAddVoteInputData();
        reactionGametimeFanFavoriteAddVoteInputData.a("match_page_id", str);
        reactionGametimeFanFavoriteAddVoteInputData.a("voted_page_id", str2);
        reactionGametimeFanFavoriteAddVoteInputData.a("reaction_styles", ImmutableList.of(GraphQLReactionUnitComponentStyle.GAMETIME_FAN_FAVORITE.toString()));
        gametimeFanFavoriteAddVoteMutationString.a("input", reactionGametimeFanFavoriteAddVoteInputData);
        gametimeFanFavoritePreVotePartDefinition.f25195f.a(GraphQLRequest.a(gametimeFanFavoriteAddVoteMutationString));
        GametimeFanFavoriteState gametimeFanFavoriteState = (GametimeFanFavoriteState) ((HasPersistentState) hasInvalidate).a(new GametimeFanFavoriteStateKey(reactionUnitComponentNode), reactionUnitComponentNode);
        gametimeFanFavoriteState.f25289a = true;
        gametimeFanFavoriteState.f25290b = str2.equals(reactionUnitComponentNode.b.F().b());
        hasInvalidate.a(new FeedProps[]{FeedProps.c(reactionUnitComponentNode)});
    }
}
