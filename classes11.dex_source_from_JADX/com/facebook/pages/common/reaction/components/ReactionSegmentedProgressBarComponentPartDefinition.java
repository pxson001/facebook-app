package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.pages.common.reaction.components.utils.PagesSurfaceReactionHelper;
import com.facebook.pages.common.reaction.ui.SegmentedProgressBarComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionSegmentedProgressBarComponentFragment.ProgressSegments;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: select_response */
public class ReactionSegmentedProgressBarComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, SegmentedProgressBarComponentView> {
    public static final ViewType f2117a = new C02741();
    private static ReactionSegmentedProgressBarComponentPartDefinition f2118c;
    private static final Object f2119d = new Object();
    private final PagesSurfaceReactionHelper f2120b;

    /* compiled from: select_response */
    final class C02741 extends ViewType {
        C02741() {
        }

        public final View m3142a(Context context) {
            return new SegmentedProgressBarComponentView(context);
        }
    }

    /* compiled from: select_response */
    public class State {
        public final ImmutableList<? extends ProgressSegments> f2115a;
        public final OnClickListener f2116b;

        public State(ImmutableList<? extends ProgressSegments> immutableList, OnClickListener onClickListener) {
            this.f2115a = immutableList;
            this.f2116b = onClickListener;
        }
    }

    private static ReactionSegmentedProgressBarComponentPartDefinition m3144b(InjectorLike injectorLike) {
        return new ReactionSegmentedProgressBarComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m3146a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(reactionUnitComponentFields.cc(), this.f2120b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m3147a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 457661436);
        State state = (State) obj2;
        ((SegmentedProgressBarComponentView) view).m3187a(state.f2115a, state.f2116b);
        Logger.a(8, EntryType.MARK_POP, 56617560, a);
    }

    public final boolean m3148a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.cc() == null || reactionUnitComponentFields.cc().isEmpty()) ? false : true;
    }

    public final void m3149b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((SegmentedProgressBarComponentView) view).setOnClickListener(null);
    }

    public final ViewType m3145a() {
        return f2117a;
    }

    public static ReactionSegmentedProgressBarComponentPartDefinition m3143a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSegmentedProgressBarComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2119d) {
                ReactionSegmentedProgressBarComponentPartDefinition reactionSegmentedProgressBarComponentPartDefinition;
                if (a2 != null) {
                    reactionSegmentedProgressBarComponentPartDefinition = (ReactionSegmentedProgressBarComponentPartDefinition) a2.a(f2119d);
                } else {
                    reactionSegmentedProgressBarComponentPartDefinition = f2118c;
                }
                if (reactionSegmentedProgressBarComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3144b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2119d, b3);
                        } else {
                            f2118c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSegmentedProgressBarComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionSegmentedProgressBarComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f2120b = pagesSurfaceReactionHelper;
    }
}
