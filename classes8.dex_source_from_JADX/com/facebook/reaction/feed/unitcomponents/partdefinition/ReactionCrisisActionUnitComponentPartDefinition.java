package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.calls.DeclareCrisisLocationOutInputData;
import com.facebook.graphql.calls.MarkSelfSafeInputData;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.graphql.enums.GraphQLSelectedActionState;
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
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.persistentstate.ReactionActivatableActionPersistentState;
import com.facebook.reaction.feed.persistentstate.ReactionActivatableActionPlaceKey;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ui.ReactionCrisisActionView;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragments.CrisisMarkSelfSafeMutationString;
import com.facebook.reaction.protocol.graphql.ReactionMutationFragments.DeclareCrisisLocationOutMutationString;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitCrisisActionWithComponentFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionCrisisActionComponentFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitSubComponentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitSubComponentModel.Builder;
import com.facebook.today.common.HasNotifications;
import javax.inject.Inject;

@ContextScoped
/* compiled from: alignParentTop */
public class ReactionCrisisActionUnitComponentPartDefinition<E extends HasContext & HasInvalidate & HasNotifications & HasPersistentState & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, ReactionCrisisActionView> {
    public static final ViewType f19628a = new C21221();
    private static ReactionCrisisActionUnitComponentPartDefinition f19629c;
    private static final Object f19630d = new Object();
    public final GraphQLQueryExecutor f19631b;

    /* compiled from: alignParentTop */
    final class C21221 extends ViewType {
        C21221() {
        }

        public final View m23542a(Context context) {
            return new ReactionCrisisActionView(context);
        }
    }

    /* compiled from: alignParentTop */
    public class State {
        public final String f19624a;
        public final String f19625b;
        public final OnClickListener f19626c;
        public final OnClickListener f19627d;

        public State(String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2) {
            this.f19624a = str;
            this.f19625b = str2;
            this.f19626c = onClickListener;
            this.f19627d = onClickListener2;
        }
    }

    private static ReactionCrisisActionUnitComponentPartDefinition m23548b(InjectorLike injectorLike) {
        return new ReactionCrisisActionUnitComponentPartDefinition(GraphQLQueryExecutor.a(injectorLike));
    }

    public static ReactionUnitCrisisActionWithComponentFragment m23545a(ReactionUnitComponentNode reactionUnitComponentNode) {
        return (ReactionUnitCrisisActionWithComponentFragment) reactionUnitComponentNode.f18862b;
    }

    public final /* bridge */ /* synthetic */ void m23551a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1565836500);
        State state = (State) obj2;
        ReactionCrisisActionView reactionCrisisActionView = (ReactionCrisisActionView) view;
        CharSequence charSequence = state.f19624a;
        CharSequence charSequence2 = state.f19625b;
        reactionCrisisActionView.f20158b.setText(charSequence);
        reactionCrisisActionView.f20158b.setTransformationMethod(reactionCrisisActionView.f20157a);
        reactionCrisisActionView.f20159c.setText(charSequence2);
        reactionCrisisActionView.f20159c.setTransformationMethod(reactionCrisisActionView.f20157a);
        reactionCrisisActionView.m24039a(state.f19626c, state.f19627d);
        Logger.a(8, EntryType.MARK_POP, -1373066688, a);
    }

    public final boolean m23552a(Object obj) {
        ReactionUnitCrisisActionWithComponentFragment a = m23545a((ReactionUnitComponentNode) obj);
        return (a.dl() == null || a.dl().a() == null || a.cF() == null || a.cF().a() == null) ? false : true;
    }

    public final void m23553b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ReactionCrisisActionView) view).m24039a(null, null);
    }

    public static ReactionCrisisActionUnitComponentPartDefinition m23544a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCrisisActionUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19630d) {
                ReactionCrisisActionUnitComponentPartDefinition reactionCrisisActionUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionCrisisActionUnitComponentPartDefinition = (ReactionCrisisActionUnitComponentPartDefinition) a2.a(f19630d);
                } else {
                    reactionCrisisActionUnitComponentPartDefinition = f19629c;
                }
                if (reactionCrisisActionUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23548b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19630d, b3);
                        } else {
                            f19629c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCrisisActionUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionCrisisActionUnitComponentPartDefinition(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f19631b = graphQLQueryExecutor;
    }

    public final ViewType m23549a() {
        return f19628a;
    }

    private State m23543a(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        final ReactionActivatableActionPersistentState reactionActivatableActionPersistentState = (ReactionActivatableActionPersistentState) ((HasPersistentState) e).a(new ReactionActivatableActionPlaceKey(reactionUnitComponentNode.m22885f().U()), reactionUnitComponentNode);
        ReactionUnitCrisisActionWithComponentFragment a = m23545a(reactionUnitComponentNode);
        final ReactionCrisisActionComponentFragmentModel dl = a.dl();
        final ReactionCrisisActionComponentFragmentModel cF = a.cF();
        final E e2 = e;
        final ReactionUnitComponentNode reactionUnitComponentNode2 = reactionUnitComponentNode;
        final ReactionActivatableActionPersistentState reactionActivatableActionPersistentState2 = reactionActivatableActionPersistentState;
        final E e3 = e;
        final ReactionUnitComponentNode reactionUnitComponentNode3 = reactionUnitComponentNode;
        return new State(dl.a().a(), cF.a().a(), new OnClickListener(this) {
            final /* synthetic */ ReactionCrisisActionUnitComponentPartDefinition f19618e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1667803207);
                ReactionCrisisActionUnitComponentPartDefinition.m23547a(this.f19618e, dl);
                reactionActivatableActionPersistentState.f19155a = TriState.YES;
                ReactionCrisisActionUnitComponentPartDefinition reactionCrisisActionUnitComponentPartDefinition = this.f19618e;
                ReactionCrisisActionUnitComponentPartDefinition.m23546a(e2, reactionUnitComponentNode2, GraphQLSelectedActionState.POSITIVE);
                ((HasInvalidate) e2).a(new FeedProps[]{FeedProps.c(reactionUnitComponentNode2)});
                Logger.a(2, EntryType.UI_INPUT_END, 982987708, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ ReactionCrisisActionUnitComponentPartDefinition f19623e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 365301628);
                ReactionCrisisActionUnitComponentPartDefinition.m23547a(this.f19623e, cF);
                reactionActivatableActionPersistentState2.f19155a = TriState.NO;
                ReactionCrisisActionUnitComponentPartDefinition reactionCrisisActionUnitComponentPartDefinition = this.f19623e;
                ReactionCrisisActionUnitComponentPartDefinition.m23546a(e3, reactionUnitComponentNode3, GraphQLSelectedActionState.NEGATIVE);
                ((HasInvalidate) e3).a(new FeedProps[]{FeedProps.c(reactionUnitComponentNode3)});
                Logger.a(2, EntryType.UI_INPUT_END, -909480405, a);
            }
        });
    }

    public static void m23547a(ReactionCrisisActionUnitComponentPartDefinition reactionCrisisActionUnitComponentPartDefinition, ReactionCrisisActionComponentFragmentModel reactionCrisisActionComponentFragmentModel) {
        Object b;
        if (reactionCrisisActionComponentFragmentModel.b().equals(GraphQLReactionStoryActionStyle.CRISIS_MARK_SAFE) && reactionCrisisActionComponentFragmentModel.c() != null) {
            b = reactionCrisisActionComponentFragmentModel.c().b();
            if (!StringUtil.a(b)) {
                MarkSelfSafeInputData markSelfSafeInputData = new MarkSelfSafeInputData();
                markSelfSafeInputData.a("crisis_id", b);
                reactionCrisisActionUnitComponentPartDefinition.f19631b.a(GraphQLRequest.a((CrisisMarkSelfSafeMutationString) new CrisisMarkSelfSafeMutationString().a("input", markSelfSafeInputData)));
            }
        } else if (reactionCrisisActionComponentFragmentModel.b().equals(GraphQLReactionStoryActionStyle.CRISIS_NOT_IN_AREA) && reactionCrisisActionComponentFragmentModel.c() != null) {
            b = reactionCrisisActionComponentFragmentModel.c().b();
            if (!StringUtil.a(b)) {
                DeclareCrisisLocationOutInputData declareCrisisLocationOutInputData = new DeclareCrisisLocationOutInputData();
                declareCrisisLocationOutInputData.a("crisis_id", b);
                reactionCrisisActionUnitComponentPartDefinition.f19631b.a(GraphQLRequest.a((DeclareCrisisLocationOutMutationString) new DeclareCrisisLocationOutMutationString().a("input", declareCrisisLocationOutInputData)));
            }
        }
    }

    public static void m23546a(E e, ReactionUnitComponentNode reactionUnitComponentNode, GraphQLSelectedActionState graphQLSelectedActionState) {
        HasNotifications hasNotifications = (HasNotifications) e;
        String str = reactionUnitComponentNode.f18863c;
        Builder a = Builder.a(ReactionUnitSubComponentModel.a((ReactionUnitSubComponentModel) reactionUnitComponentNode.f18862b));
        a.cs = graphQLSelectedActionState;
        hasNotifications.mo975a(str, a.a());
    }
}
