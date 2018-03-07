package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionImageWithOverlaySingleItemUnitComponentPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitImageWithOverlayComponentFragementModel.ImagesWithOverlayModel;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: admin_end_cursor */
public class ReactionImageWithOverlayGridUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, TableLayout> {
    public static final ViewType f19835a = ViewType.a(2130906679);
    private static final int[] f19836b = new int[]{2131566728, 2131566729, 2131566730, 2131566731};
    private static ReactionImageWithOverlayGridUnitComponentPartDefinition f19837d;
    private static final Object f19838e = new Object();
    public final ReactionImageWithOverlaySingleItemUnitComponentPartDefinition f19839c;

    private static ReactionImageWithOverlayGridUnitComponentPartDefinition m23745b(InjectorLike injectorLike) {
        return new ReactionImageWithOverlayGridUnitComponentPartDefinition(ReactionImageWithOverlaySingleItemUnitComponentPartDefinition.m23751a(injectorLike));
    }

    public final Object m23747a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ImmutableList aX = reactionUnitComponentNode.f18862b.aX();
        for (int i = 0; i < aX.size(); i++) {
            subParts.a(f19836b[i], this.f19839c, new Props((ImagesWithOverlayModel) aX.get(i), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23748a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1560510191);
        TableRow tableRow = (TableRow) ((TableLayout) view).findViewById(2131560947);
        if (((ReactionUnitComponentNode) obj).f18862b.aX().size() == 4) {
            tableRow.setVisibility(0);
        } else {
            tableRow.setVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, -681184367, a);
    }

    public final boolean m23749a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return !CollectionUtil.a(reactionUnitComponentFields.aX()) && (reactionUnitComponentFields.aX().size() == 2 || reactionUnitComponentFields.aX().size() == 4);
    }

    @Inject
    public ReactionImageWithOverlayGridUnitComponentPartDefinition(ReactionImageWithOverlaySingleItemUnitComponentPartDefinition reactionImageWithOverlaySingleItemUnitComponentPartDefinition) {
        this.f19839c = reactionImageWithOverlaySingleItemUnitComponentPartDefinition;
    }

    public final ViewType m23746a() {
        return f19835a;
    }

    public static ReactionImageWithOverlayGridUnitComponentPartDefinition m23744a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionImageWithOverlayGridUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19838e) {
                ReactionImageWithOverlayGridUnitComponentPartDefinition reactionImageWithOverlayGridUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionImageWithOverlayGridUnitComponentPartDefinition = (ReactionImageWithOverlayGridUnitComponentPartDefinition) a2.a(f19838e);
                } else {
                    reactionImageWithOverlayGridUnitComponentPartDefinition = f19837d;
                }
                if (reactionImageWithOverlayGridUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23745b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19838e, b3);
                        } else {
                            f19837d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionImageWithOverlayGridUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
