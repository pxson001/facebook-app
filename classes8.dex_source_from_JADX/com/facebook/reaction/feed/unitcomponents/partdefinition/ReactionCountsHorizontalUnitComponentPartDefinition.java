package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleCountUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleCountUnitComponentPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCountsComponentFragmentModel.CountsModel;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: alignment */
public class ReactionCountsHorizontalUnitComponentPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment, LinearLayout> {
    public static final ViewType f19609a = new C21211();
    private static ReactionCountsHorizontalUnitComponentPartDefinition f19610d;
    private static final Object f19611e = new Object();
    private final NumberTruncationUtil f19612b;
    private final ReactionSingleCountUnitComponentPartDefinition f19613c;

    /* compiled from: alignment */
    final class C21211 extends ViewType {
        C21211() {
        }

        public final View m23536a(Context context) {
            return (LinearLayout) LayoutInflater.from(context).inflate(2130906658, null);
        }
    }

    private static ReactionCountsHorizontalUnitComponentPartDefinition m23538b(InjectorLike injectorLike) {
        return new ReactionCountsHorizontalUnitComponentPartDefinition(NumberTruncationUtil.a(injectorLike), ReactionSingleCountUnitComponentPartDefinition.m24356a(injectorLike));
    }

    public final Object m23540a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ImmutableList ag = reactionUnitComponentNode.f18862b.ag();
        subParts.a(2131566700, this.f19613c, new Props((CountsModel) ag.get(0), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        if (ag.size() >= 2) {
            subParts.a(2131566701, this.f19613c, new Props((CountsModel) ag.get(1), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        if (ag.size() >= 3) {
            subParts.a(2131566702, this.f19613c, new Props((CountsModel) ag.get(2), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        if (ag.size() >= 4) {
            subParts.a(2131566703, this.f19613c, new Props((CountsModel) ag.get(3), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        return null;
    }

    public final boolean m23541a(Object obj) {
        ImmutableList ag = ((ReactionUnitComponentNode) obj).f18862b.ag();
        if (ag.isEmpty()) {
            return false;
        }
        int size = ag.size();
        for (int i = 0; i < size; i++) {
            CountsModel countsModel = (CountsModel) ag.get(i);
            if (countsModel.c() == null || StringUtil.a(countsModel.c().a()) || countsModel.b() < 0) {
                return false;
            }
        }
        return true;
    }

    @Inject
    public ReactionCountsHorizontalUnitComponentPartDefinition(NumberTruncationUtil numberTruncationUtil, ReactionSingleCountUnitComponentPartDefinition reactionSingleCountUnitComponentPartDefinition) {
        this.f19613c = reactionSingleCountUnitComponentPartDefinition;
        this.f19612b = numberTruncationUtil;
    }

    public static ReactionCountsHorizontalUnitComponentPartDefinition m23537a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCountsHorizontalUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19611e) {
                ReactionCountsHorizontalUnitComponentPartDefinition reactionCountsHorizontalUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionCountsHorizontalUnitComponentPartDefinition = (ReactionCountsHorizontalUnitComponentPartDefinition) a2.a(f19611e);
                } else {
                    reactionCountsHorizontalUnitComponentPartDefinition = f19610d;
                }
                if (reactionCountsHorizontalUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23538b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19611e, b3);
                        } else {
                            f19610d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCountsHorizontalUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23539a() {
        return f19609a;
    }
}
