package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.analytics.MultiRowPerfLoggerMethodAutoProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition$Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition$Props;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEvents;
import com.facebook.reaction.feed.environment.HasReactionCardBackground;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentPersistentState;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ui.ReactionHScrollComponentView;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitStaticAggregationComponentFields;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notif_option_row */
public class ReactionHScrollUnitComponentPartDefinition<E extends CanHandleHScrollPageChangedEvents & HasContext & HasPersistentState & HasPositionInformation & HasReactionCardBackground & HasReactionInteractionTracker> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, HScrollRecyclerView> {
    public static final ViewType<ReactionHScrollComponentView> f6911a = new C03241();
    public static final ViewType f6912b = new C03252();
    private static ReactionHScrollUnitComponentPartDefinition f6913h;
    private static final Object f6914i = new Object();
    private final PageStyleFactory f6915c;
    private final PersistentRecyclerPartDefinition<Object, E> f6916d;
    public final ReactionUnitComponentStyleMapper f6917e;
    private final ReactionUnitValidator f6918f;
    public final MultiRowPerfLogger f6919g;

    /* compiled from: notif_option_row */
    final class C03241 extends ViewType<ReactionHScrollComponentView> {
        C03241() {
        }

        public final View m7236a(Context context) {
            ReactionHScrollComponentView reactionHScrollComponentView = new ReactionHScrollComponentView(context);
            reactionHScrollComponentView.setBottomMargin(4.0f);
            return reactionHScrollComponentView;
        }
    }

    /* compiled from: notif_option_row */
    final class C03252 extends ViewType<ReactionHScrollComponentView> {
        C03252() {
        }

        public final View m7237a(Context context) {
            ReactionHScrollComponentView reactionHScrollComponentView = new ReactionHScrollComponentView(context);
            if (!(reactionHScrollComponentView.b == null || reactionHScrollComponentView.b.getLayoutParams() == null)) {
                reactionHScrollComponentView.b.getLayoutParams().width = -1;
            }
            reactionHScrollComponentView.setBottomMargin(4.0f);
            return reactionHScrollComponentView;
        }
    }

    private static ReactionHScrollUnitComponentPartDefinition m7229b(InjectorLike injectorLike) {
        return new ReactionHScrollUnitComponentPartDefinition(PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), ReactionUnitComponentStyleMapper.a(injectorLike), ReactionUnitValidator.b(injectorLike), MultiRowPerfLoggerMethodAutoProvider.a(injectorLike));
    }

    public final Object m7232a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanHandleHScrollPageChangedEvents canHandleHScrollPageChangedEvents = (CanHandleHScrollPageChangedEvents) anyEnvironment;
        ReactionHScrollComponentKey reactionHScrollComponentKey = new ReactionHScrollComponentKey(reactionUnitComponentNode.c);
        ImmutableList b = m7230b(reactionUnitComponentNode, canHandleHScrollPageChangedEvents);
        PageStyle a = b.size() > 1 ? this.f6915c.a(((float) SizeUtil.c(((HasContext) canHandleHScrollPageChangedEvents).getContext(), (float) ((HasContext) canHandleHScrollPageChangedEvents).getContext().getResources().getDimensionPixelSize(2131431398))) + 8.0f, PageStyle.f13886a, true) : this.f6915c.a(PageStyle.f13886a);
        ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState = (ReactionHScrollComponentPersistentState) ((HasPersistentState) canHandleHScrollPageChangedEvents).a(reactionHScrollComponentKey, reactionUnitComponentNode);
        reactionHScrollComponentPersistentState.a = ((ReactionUnitStaticAggregationComponentFields) reactionUnitComponentNode.b).at();
        reactionHScrollComponentPersistentState.e = b.size();
        subParts.a(this.f6916d, new PersistentRecyclerPartDefinition$Props(a, ((ReactionHScrollComponentPersistentState) ((HasPersistentState) canHandleHScrollPageChangedEvents).a(reactionHScrollComponentKey, reactionUnitComponentNode)).f, m7227a(b, reactionHScrollComponentKey, reactionUnitComponentNode, canHandleHScrollPageChangedEvents), reactionUnitComponentNode.g(), reactionUnitComponentNode));
        return new State(((HasReactionCardBackground) canHandleHScrollPageChangedEvents).b(reactionUnitComponentNode));
    }

    public final boolean m7234a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return "SUCCESS".equals(this.f6918f.a(reactionUnitComponentNode)) && (reactionUnitComponentNode.b instanceof ReactionUnitStaticAggregationComponentFields);
    }

    public final void m7235b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((CanHandleHScrollPageChangedEvents) anyEnvironment).a((ReactionUnitComponentNode) obj);
    }

    public static ReactionHScrollUnitComponentPartDefinition m7228a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionHScrollUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6914i) {
                ReactionHScrollUnitComponentPartDefinition reactionHScrollUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionHScrollUnitComponentPartDefinition = (ReactionHScrollUnitComponentPartDefinition) a2.a(f6914i);
                } else {
                    reactionHScrollUnitComponentPartDefinition = f6913h;
                }
                if (reactionHScrollUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7229b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6914i, b3);
                        } else {
                            f6913h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionHScrollUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionHScrollUnitComponentPartDefinition(PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper, ReactionUnitValidator reactionUnitValidator, MultiRowPerfLogger multiRowPerfLogger) {
        this.f6915c = pageStyleFactory;
        this.f6916d = persistentRecyclerPartDefinition;
        this.f6917e = reactionUnitComponentStyleMapper;
        this.f6918f = reactionUnitValidator;
        this.f6919g = multiRowPerfLogger;
    }

    public final ViewType m7231a() {
        return HScrollRecyclerViewRowType.f11901a;
    }

    private PersistentRecyclerPartDefinition$Callbacks<Object, E> m7227a(ImmutableList<ReactionUnitComponentFields> immutableList, ReactionHScrollComponentKey reactionHScrollComponentKey, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        return new 3(this, immutableList, reactionUnitComponentNode, e, reactionHScrollComponentKey);
    }

    private static ImmutableList<ReactionUnitComponentFields> m7230b(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        Builder builder = new Builder();
        ImmutableList b = ReactionUnitComponentUtil.b(reactionUnitComponentNode);
        ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState = (ReactionHScrollComponentPersistentState) ((HasPersistentState) e).a(new ReactionHScrollComponentKey(reactionUnitComponentNode.c), reactionUnitComponentNode);
        int size = b.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitComponentFields) b.get(i);
            if (!reactionHScrollComponentPersistentState.b(reactionUnitComponentFields.U())) {
                builder.c(reactionUnitComponentFields);
            }
        }
        return builder.b();
    }
}
