package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
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
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.rows.attachments.ReactionSinglePhotoAttachmentPartDefinition;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: add_photos_at_place_tap */
public class ReactionLargeImageUnitComponentPartDefinition<E extends HasContext & HasReactionCardContainer & HasReactionInteractionTracker & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, FbDraweeView> {
    private static final CallerContext f19872a = CallerContext.a(ReactionLargeImageUnitComponentPartDefinition.class, "reaction_photos");
    private static ReactionLargeImageUnitComponentPartDefinition f19873c;
    private static final Object f19874d = new Object();
    private final FbDraweePartDefinition<E> f19875b;

    private static ReactionLargeImageUnitComponentPartDefinition m23779b(InjectorLike injectorLike) {
        return new ReactionLargeImageUnitComponentPartDefinition(FbDraweePartDefinition.a(injectorLike));
    }

    public static boolean m23778a(ReactionUnitComponentNode reactionUnitComponentNode) {
        return (reactionUnitComponentNode.f18862b.aS() == null || Strings.isNullOrEmpty(reactionUnitComponentNode.f18862b.aS().b())) ? false : true;
    }

    public final Object m23781a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        FbDraweePartDefinition fbDraweePartDefinition = this.f19875b;
        Builder a = FbDraweePartDefinition.a().a(reactionUnitComponentNode.f18862b.aS().b());
        a.c = f19872a;
        a = a;
        a.b = 2.3333333f;
        a = a;
        a.h = ScaleType.f;
        subParts.a(fbDraweePartDefinition, a.a());
        return null;
    }

    @Inject
    public ReactionLargeImageUnitComponentPartDefinition(FbDraweePartDefinition fbDraweePartDefinition) {
        this.f19875b = fbDraweePartDefinition;
    }

    public final ViewType<FbDraweeView> m23780a() {
        return ReactionSinglePhotoAttachmentPartDefinition.f19381a;
    }

    public static ReactionLargeImageUnitComponentPartDefinition m23777a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionLargeImageUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19874d) {
                ReactionLargeImageUnitComponentPartDefinition reactionLargeImageUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionLargeImageUnitComponentPartDefinition = (ReactionLargeImageUnitComponentPartDefinition) a2.a(f19874d);
                } else {
                    reactionLargeImageUnitComponentPartDefinition = f19873c;
                }
                if (reactionLargeImageUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23779b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19874d, b3);
                        } else {
                            f19873c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionLargeImageUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
