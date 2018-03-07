package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accept_admin_invite_tap */
public class ReactionVideoUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, FbRelativeLayout> {
    public static final ViewType f20149a = ViewType.a(2130906654);
    private static final CallerContext f20150b = CallerContext.a(ReactionVideoUnitComponentPartDefinition.class, "reaction_videos");
    private static ReactionVideoUnitComponentPartDefinition f20151g;
    private static final Object f20152h = new Object();
    private final ClickListenerPartDefinition f20153c;
    private final DialtoneController f20154d;
    private final FbDraweePartDefinition f20155e;
    private final VisibilityPartDefinition f20156f;

    private static ReactionVideoUnitComponentPartDefinition m24034b(InjectorLike injectorLike) {
        return new ReactionVideoUnitComponentPartDefinition(ClickListenerPartDefinition.a(injectorLike), (DialtoneController) DialtoneControllerImpl.a(injectorLike), FbDraweePartDefinition.a(injectorLike), VisibilityPartDefinition.a(injectorLike));
    }

    public final Object m24036a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        final ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(this.f20153c, new OnClickListener(this) {
            final /* synthetic */ ReactionVideoUnitComponentPartDefinition f20148d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1898955794);
                canLaunchReactionIntent.mo695a(reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, ReactionIntentFactory.m22691a(reactionUnitComponentFields.da(), ((HasContext) canLaunchReactionIntent).getContext()));
                Logger.a(2, EntryType.UI_INPUT_END, -442759739, a);
            }
        });
        subParts.a(2131566629, this.f20156f, Integer.valueOf(this.f20154d.b() ? 8 : 0));
        FbDraweePartDefinition fbDraweePartDefinition = this.f20155e;
        Builder a = new Builder().a(reactionUnitComponentFields.da().F().b());
        a.c = f20150b;
        a = a;
        a.b = 1.7777778f;
        subParts.a(2131566628, fbDraweePartDefinition, a.a());
        return null;
    }

    public final boolean m24037a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.da() == null || reactionUnitComponentFields.da().F() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.da().F().b())) ? false : true;
    }

    @Inject
    public ReactionVideoUnitComponentPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, DialtoneController dialtoneController, FbDraweePartDefinition fbDraweePartDefinition, VisibilityPartDefinition visibilityPartDefinition) {
        this.f20153c = clickListenerPartDefinition;
        this.f20154d = dialtoneController;
        this.f20155e = fbDraweePartDefinition;
        this.f20156f = visibilityPartDefinition;
    }

    public static ReactionVideoUnitComponentPartDefinition m24033a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionVideoUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20152h) {
                ReactionVideoUnitComponentPartDefinition reactionVideoUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionVideoUnitComponentPartDefinition = (ReactionVideoUnitComponentPartDefinition) a2.a(f20152h);
                } else {
                    reactionVideoUnitComponentPartDefinition = f20151g;
                }
                if (reactionVideoUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24034b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20152h, b3);
                        } else {
                            f20151g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionVideoUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m24035a() {
        return f20149a;
    }
}
