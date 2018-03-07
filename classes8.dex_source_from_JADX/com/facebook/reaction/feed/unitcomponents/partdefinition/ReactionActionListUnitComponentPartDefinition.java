package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionActionListBackgroundPartDefinition;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleActionOrHiddenPartDefinition;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleActionSelectorPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.hardware.screen.portrait */
public class ReactionActionListUnitComponentPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment, LinearLayout> {
    public static final ViewType f19543a = ViewType.a(2130906635);
    private static ReactionActionListUnitComponentPartDefinition f19544d;
    private static final Object f19545e = new Object();
    private final ReactionActionListBackgroundPartDefinition f19546b;
    private final ReactionSingleActionOrHiddenPartDefinition f19547c;

    private static ReactionActionListUnitComponentPartDefinition m23480b(InjectorLike injectorLike) {
        return new ReactionActionListUnitComponentPartDefinition(ReactionActionListBackgroundPartDefinition.m24267a(injectorLike), ReactionSingleActionOrHiddenPartDefinition.m24344a(injectorLike));
    }

    public final Object m23482a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object props;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ImmutableList w = reactionUnitComponentNode.f18862b.w();
        int size = w.size();
        subParts.a(2131566661, this.f19547c, new Props((ReactionStoryAttachmentActionFragmentModel) w.get(0), reactionUnitComponentNode));
        subParts.a(2131566662, this.f19547c, size > 1 ? new Props((ReactionStoryAttachmentActionFragmentModel) w.get(1), reactionUnitComponentNode) : null);
        ReactionSingleActionOrHiddenPartDefinition reactionSingleActionOrHiddenPartDefinition = this.f19547c;
        if (size > 2) {
            props = new Props((ReactionStoryAttachmentActionFragmentModel) w.get(2), reactionUnitComponentNode);
        } else {
            props = null;
        }
        subParts.a(2131566663, reactionSingleActionOrHiddenPartDefinition, props);
        subParts.a(this.f19546b, reactionUnitComponentNode.f18862b.a());
        return null;
    }

    public final ViewType m23481a() {
        return f19543a;
    }

    @Inject
    public ReactionActionListUnitComponentPartDefinition(ReactionActionListBackgroundPartDefinition reactionActionListBackgroundPartDefinition, ReactionSingleActionOrHiddenPartDefinition reactionSingleActionOrHiddenPartDefinition) {
        this.f19546b = reactionActionListBackgroundPartDefinition;
        this.f19547c = reactionSingleActionOrHiddenPartDefinition;
    }

    public final boolean m23483a(ReactionUnitComponentNode reactionUnitComponentNode) {
        ImmutableList w = reactionUnitComponentNode.f18862b.w();
        if (w.isEmpty()) {
            return false;
        }
        int size = w.size();
        for (int i = 0; i < size; i++) {
            if (!this.f19547c.m24348a(new Props((ReactionStoryAttachmentActionFragmentModel) w.get(i), reactionUnitComponentNode))) {
                return false;
            }
        }
        return true;
    }

    public static ReactionActionListUnitComponentPartDefinition m23479a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionActionListUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19545e) {
                ReactionActionListUnitComponentPartDefinition reactionActionListUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionActionListUnitComponentPartDefinition = (ReactionActionListUnitComponentPartDefinition) a2.a(f19545e);
                } else {
                    reactionActionListUnitComponentPartDefinition = f19544d;
                }
                if (reactionActionListUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23480b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19545e, b3);
                        } else {
                            f19544d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionActionListUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
