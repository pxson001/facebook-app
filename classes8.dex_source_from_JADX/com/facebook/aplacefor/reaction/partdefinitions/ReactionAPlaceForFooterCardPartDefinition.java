package com.facebook.aplacefor.reaction.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.aplacefor.reaction.partdefinitions.ReactionAPlaceForAnimationPartDefinition.Props;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionAPlaceForFooterCardComponentFragment;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: items_count */
public class ReactionAPlaceForFooterCardPartDefinition<E extends HasContext> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, View> {
    public static final ViewType f10524a = ViewType.a(2130903256);
    private static ReactionAPlaceForFooterCardPartDefinition f10525f;
    private static final Object f10526g = new Object();
    private final FbDraweePartDefinition f10527b;
    private final TextPartDefinition f10528c;
    private final ReactionAPlaceForAnimationPartDefinition f10529d;
    private final VisibilityPartDefinition f10530e;

    private static ReactionAPlaceForFooterCardPartDefinition m12430b(InjectorLike injectorLike) {
        return new ReactionAPlaceForFooterCardPartDefinition(FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ReactionAPlaceForAnimationPartDefinition.m12422a(injectorLike), VisibilityPartDefinition.a(injectorLike));
    }

    public final Object m12432a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        ReactionAPlaceForFooterCardComponentFragment reactionAPlaceForFooterCardComponentFragment = reactionUnitComponentNode.f18862b;
        CallerContext a = CallerContext.a(getClass(), "a_place_for");
        subParts.a(2131559599, this.f10528c, reactionAPlaceForFooterCardComponentFragment.l().a());
        if (reactionAPlaceForFooterCardComponentFragment.k() != null) {
            FbDraweePartDefinition fbDraweePartDefinition = this.f10527b;
            Builder a2 = FbDraweePartDefinition.a().a(reactionAPlaceForFooterCardComponentFragment.k().a());
            a2.c = a;
            subParts.a(2131559600, fbDraweePartDefinition, a2.a());
        }
        int i = hasContext.getContext().getResources().getDisplayMetrics().widthPixels;
        int c = (int) (((float) i) / (((float) reactionAPlaceForFooterCardComponentFragment.fX_().c()) / ((float) reactionAPlaceForFooterCardComponentFragment.fX_().a())));
        FbDraweePartDefinition fbDraweePartDefinition2 = this.f10527b;
        Builder a3 = FbDraweePartDefinition.a().a(reactionAPlaceForFooterCardComponentFragment.fX_().b()).a(i, c);
        a3.c = a;
        subParts.a(2131559602, fbDraweePartDefinition2, a3.a());
        if (reactionAPlaceForFooterCardComponentFragment.j() != null) {
            ReactionAPlaceForAnimationPartDefinition reactionAPlaceForAnimationPartDefinition = this.f10529d;
            Props.Builder b = ReactionAPlaceForAnimationPartDefinition.m12423b();
            b.f10515c = c;
            Props.Builder builder = b;
            builder.f10514b = i;
            Props.Builder builder2 = builder;
            builder2.f10513a = reactionAPlaceForFooterCardComponentFragment.j();
            Props.Builder builder3 = builder2;
            builder3.f10516d = reactionUnitComponentNode.f18862b.U();
            subParts.a(2131559603, reactionAPlaceForAnimationPartDefinition, builder3.m12421a());
        } else {
            subParts.a(2131559603, this.f10530e, Integer.valueOf(8));
        }
        return null;
    }

    public final boolean m12433a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return (reactionUnitComponentNode.f18862b.H() == null || reactionUnitComponentNode.f18862b.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentNode.f18862b.H().b()) || Strings.isNullOrEmpty(reactionUnitComponentNode.f18862b.bv().a())) ? false : true;
    }

    @Inject
    public ReactionAPlaceForFooterCardPartDefinition(FbDraweePartDefinition fbDraweePartDefinition, TextPartDefinition textPartDefinition, ReactionAPlaceForAnimationPartDefinition reactionAPlaceForAnimationPartDefinition, VisibilityPartDefinition visibilityPartDefinition) {
        this.f10527b = fbDraweePartDefinition;
        this.f10528c = textPartDefinition;
        this.f10529d = reactionAPlaceForAnimationPartDefinition;
        this.f10530e = visibilityPartDefinition;
    }

    public final ViewType m12431a() {
        return f10524a;
    }

    public static ReactionAPlaceForFooterCardPartDefinition m12429a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionAPlaceForFooterCardPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10526g) {
                ReactionAPlaceForFooterCardPartDefinition reactionAPlaceForFooterCardPartDefinition;
                if (a2 != null) {
                    reactionAPlaceForFooterCardPartDefinition = (ReactionAPlaceForFooterCardPartDefinition) a2.a(f10526g);
                } else {
                    reactionAPlaceForFooterCardPartDefinition = f10525f;
                }
                if (reactionAPlaceForFooterCardPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12430b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10526g, b3);
                        } else {
                            f10525f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionAPlaceForFooterCardPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
