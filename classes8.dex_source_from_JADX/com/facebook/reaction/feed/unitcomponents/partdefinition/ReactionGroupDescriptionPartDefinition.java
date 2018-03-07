package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.calls.GroupLeaveInputData.ReaddPolicy;
import com.facebook.graphql.calls.GroupLeaveInputData.Source;
import com.facebook.graphql.calls.GroupRequestToJoinInputData;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ImageViewDrawablePartDefinition;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.persistentstate.ReactionActivatableActionPersistentState;
import com.facebook.reaction.feed.persistentstate.ReactionActivatableActionPlaceKey;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionGroupDescriptionComponentFragment;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@ContextScoped
/* compiled from: album Node ID cannot be null. */
public class ReactionGroupDescriptionPartDefinition<E extends HasInvalidate & HasPersistentState & HasContext & HasReactionInteractionTracker> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, LinearLayout> {
    public static final ViewType f19738a = ViewType.a(2130905351);
    private static ReactionGroupDescriptionPartDefinition f19739i;
    private static final Object f19740j = new Object();
    private final TextPartDefinition f19741b;
    private final TextOrHiddenPartDefinition f19742c;
    private final ClickListenerPartDefinition f19743d;
    private final BasicReactionActionPartDefinition f19744e;
    private final ImageViewDrawablePartDefinition f19745f;
    public final GroupsClient f19746g;
    public final ExecutorService f19747h;

    private static ReactionGroupDescriptionPartDefinition m23654b(InjectorLike injectorLike) {
        return new ReactionGroupDescriptionPartDefinition(TextPartDefinition.a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), BasicReactionActionPartDefinition.m22984a(injectorLike), ImageViewDrawablePartDefinition.a(injectorLike), GroupsClient.m16961b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    private static ReactionGroupDescriptionComponentFragment m23655b(ReactionUnitComponentNode reactionUnitComponentNode) {
        if (reactionUnitComponentNode.f18862b instanceof ReactionGroupDescriptionComponentFragment) {
            return reactionUnitComponentNode.f18862b;
        }
        throw new Error("Could not convert unit component to GroupDescriptionGraphQLFragment.");
    }

    public final boolean m23658a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionGroupDescriptionComponentFragment b = m23655b(reactionUnitComponentNode);
        return (Strings.isNullOrEmpty(reactionUnitComponentNode.f18862b.U()) || b.dj() == null || Strings.isNullOrEmpty(b.dj().a())) ? false : true;
    }

    public static ReactionGroupDescriptionPartDefinition m23652a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionGroupDescriptionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19740j) {
                ReactionGroupDescriptionPartDefinition reactionGroupDescriptionPartDefinition;
                if (a2 != null) {
                    reactionGroupDescriptionPartDefinition = (ReactionGroupDescriptionPartDefinition) a2.a(f19740j);
                } else {
                    reactionGroupDescriptionPartDefinition = f19739i;
                }
                if (reactionGroupDescriptionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23654b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19740j, b3);
                        } else {
                            f19739i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionGroupDescriptionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionGroupDescriptionPartDefinition(TextPartDefinition textPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, BasicReactionActionPartDefinition basicReactionActionPartDefinition, ImageViewDrawablePartDefinition imageViewDrawablePartDefinition, GroupsClient groupsClient, ExecutorService executorService) {
        this.f19741b = textPartDefinition;
        this.f19742c = textOrHiddenPartDefinition;
        this.f19743d = clickListenerPartDefinition;
        this.f19745f = imageViewDrawablePartDefinition;
        this.f19744e = basicReactionActionPartDefinition;
        this.f19746g = groupsClient;
        this.f19747h = executorService;
    }

    public final ViewType m23656a() {
        return f19738a;
    }

    private Void m23653a(SubParts<E> subParts, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        Object a;
        GraphQLGroupJoinState s = reactionUnitComponentNode.m22885f().C().M().s();
        FeedProps c = FeedProps.c(reactionUnitComponentNode);
        ReactionGroupDescriptionComponentFragment b = m23655b(reactionUnitComponentNode);
        String a2 = b.dj().a();
        Object a3 = b.q() != null ? b.q().a() : null;
        if (b.g() != null) {
            a = b.g().a();
        } else {
            a = null;
        }
        ReactionActivatableActionPersistentState reactionActivatableActionPersistentState = (ReactionActivatableActionPersistentState) ((HasPersistentState) e).a(new ReactionActivatableActionPlaceKey(reactionUnitComponentNode.m22885f().U()), reactionUnitComponentNode);
        if (reactionActivatableActionPersistentState.m23177a() == TriState.UNSET) {
            reactionActivatableActionPersistentState.f19155a = b.ba() ? TriState.YES : TriState.NO;
        }
        OnClickListener a4 = m23651a(reactionUnitComponentNode, reactionActivatableActionPersistentState, e, c);
        if (b.v() != null) {
            subParts.a(2131563995, this.f19744e, new Props(b.v(), reactionUnitComponentNode.m22887k(), reactionUnitComponentNode.m22888l()));
        }
        subParts.a(2131563996, this.f19741b, a2);
        subParts.a(2131563997, this.f19742c, a3);
        subParts.a(2131563998, this.f19742c, a);
        subParts.a(2131563999, this.f19743d, a4);
        Resources resources = ((HasContext) e).getContext().getResources();
        int i = s == GraphQLGroupJoinState.CAN_REQUEST ? 2130840299 : 2130840191;
        if (s != GraphQLGroupJoinState.CANNOT_JOIN_OR_REQUEST) {
            subParts.a(2131563999, this.f19745f, resources.getDrawable(i));
        }
        return null;
    }

    private OnClickListener m23651a(ReactionUnitComponentNode reactionUnitComponentNode, ReactionActivatableActionPersistentState reactionActivatableActionPersistentState, E e, FeedProps feedProps) {
        final ReactionGroupDescriptionComponentFragment b = m23655b(reactionUnitComponentNode);
        final ReactionActivatableActionPersistentState reactionActivatableActionPersistentState2 = reactionActivatableActionPersistentState;
        final E e2 = e;
        final ReactionUnitComponentNode reactionUnitComponentNode2 = reactionUnitComponentNode;
        final FeedProps feedProps2 = feedProps;
        return new OnClickListener(this) {
            final /* synthetic */ ReactionGroupDescriptionPartDefinition f19737f;

            public void onClick(View view) {
                ListenableFuture listenableFuture;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1928561405);
                final TriState triState = reactionActivatableActionPersistentState2.f19155a;
                ListenableFuture a2;
                if (triState == TriState.YES) {
                    a2 = this.f19737f.f19746g.m16963a(b.aC(), Source.MOBILE_GROUP_JOIN, ReaddPolicy.ALLOW_READD);
                    reactionActivatableActionPersistentState2.f19155a = TriState.NO;
                    ((HasReactionInteractionTracker) e2).kE_().m18941a(reactionUnitComponentNode2.f18863c, reactionUnitComponentNode2.f18864d, null, UnitInteractionType.GROUP_LEAVE_TAP, b.aC());
                    listenableFuture = a2;
                } else {
                    a2 = this.f19737f.f19746g.m16964a(b.aC(), GroupRequestToJoinInputData.Source.MOBILE_GROUP_JOIN);
                    reactionActivatableActionPersistentState2.f19155a = TriState.YES;
                    ((HasReactionInteractionTracker) e2).kE_().m18941a(reactionUnitComponentNode2.f18863c, reactionUnitComponentNode2.f18864d, null, UnitInteractionType.GROUP_JOIN_TAP, b.aC());
                    listenableFuture = a2;
                }
                e2.a(new FeedProps[]{feedProps2});
                Futures.a(listenableFuture, new FutureCallback<Void>(this) {
                    final /* synthetic */ C21291 f19731b;

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    }

                    public void onFailure(Throwable th) {
                        reactionActivatableActionPersistentState2.f19155a = triState;
                        e2.a(new FeedProps[]{feedProps2});
                    }
                }, this.f19737f.f19747h);
                LogUtils.a(1610025386, a);
            }
        };
    }
}
