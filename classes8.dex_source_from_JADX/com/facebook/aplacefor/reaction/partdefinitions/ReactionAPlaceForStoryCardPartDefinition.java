package com.facebook.aplacefor.reaction.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.aplacefor.reaction.partdefinitions.ReactionAPlaceForAnimationPartDefinition.Props;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
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
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionAPlaceForStoryCardComponentFragment;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: iso_country_code */
public class ReactionAPlaceForStoryCardPartDefinition<E extends HasContext> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, View> {
    public static final ViewType f10543a = ViewType.a(2130903259);
    private static ReactionAPlaceForStoryCardPartDefinition f10544f;
    private static final Object f10545g = new Object();
    private final FbDraweePartDefinition f10546b;
    private final TextPartDefinition f10547c;
    private final ReactionAPlaceForAnimationPartDefinition f10548d;
    private final VisibilityPartDefinition f10549e;

    private static ReactionAPlaceForStoryCardPartDefinition m12443b(InjectorLike injectorLike) {
        return new ReactionAPlaceForStoryCardPartDefinition(FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ReactionAPlaceForAnimationPartDefinition.m12422a(injectorLike), VisibilityPartDefinition.a(injectorLike));
    }

    public final Object m12445a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        ReactionAPlaceForStoryCardComponentFragment reactionAPlaceForStoryCardComponentFragment = reactionUnitComponentNode.f18862b;
        CallerContext a = CallerContext.a(getClass(), "a_place_for");
        int a2 = SizeUtil.a(hasContext.getContext(), 60.0f);
        FbDraweePartDefinition fbDraweePartDefinition = this.f10546b;
        Builder a3 = FbDraweePartDefinition.a().a(reactionAPlaceForStoryCardComponentFragment.s().a()).a(a2, a2);
        a3.c = a;
        subParts.a(2131559612, fbDraweePartDefinition, a3.a());
        if (reactionAPlaceForStoryCardComponentFragment.t() != null) {
            ReactionAPlaceForAnimationPartDefinition reactionAPlaceForAnimationPartDefinition = this.f10548d;
            Props.Builder b = ReactionAPlaceForAnimationPartDefinition.m12423b();
            b.f10515c = a2;
            b = b;
            b.f10514b = a2;
            Props.Builder builder = b;
            builder.f10513a = reactionAPlaceForStoryCardComponentFragment.t();
            builder = builder;
            builder.f10516d = reactionUnitComponentNode.f18862b.U();
            subParts.a(2131559613, reactionAPlaceForAnimationPartDefinition, builder.m12421a());
        } else {
            subParts.a(2131559613, this.f10549e, Integer.valueOf(8));
        }
        subParts.a(2131559614, this.f10547c, reactionAPlaceForStoryCardComponentFragment.l().a());
        return null;
    }

    public final boolean m12447a(Object obj) {
        ReactionAPlaceForStoryCardComponentFragment reactionAPlaceForStoryCardComponentFragment = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionAPlaceForStoryCardComponentFragment.l() == null || Strings.isNullOrEmpty(reactionAPlaceForStoryCardComponentFragment.l().a()) || reactionAPlaceForStoryCardComponentFragment.s() == null || Strings.isNullOrEmpty(reactionAPlaceForStoryCardComponentFragment.s().a())) ? false : true;
    }

    @Inject
    public ReactionAPlaceForStoryCardPartDefinition(FbDraweePartDefinition fbDraweePartDefinition, TextPartDefinition textPartDefinition, ReactionAPlaceForAnimationPartDefinition reactionAPlaceForAnimationPartDefinition, VisibilityPartDefinition visibilityPartDefinition) {
        this.f10546b = fbDraweePartDefinition;
        this.f10548d = reactionAPlaceForAnimationPartDefinition;
        this.f10547c = textPartDefinition;
        this.f10549e = visibilityPartDefinition;
    }

    public final ViewType m12444a() {
        return f10543a;
    }

    public static ReactionAPlaceForStoryCardPartDefinition m12441a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionAPlaceForStoryCardPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10545g) {
                ReactionAPlaceForStoryCardPartDefinition reactionAPlaceForStoryCardPartDefinition;
                if (a2 != null) {
                    reactionAPlaceForStoryCardPartDefinition = (ReactionAPlaceForStoryCardPartDefinition) a2.a(f10545g);
                } else {
                    reactionAPlaceForStoryCardPartDefinition = f10544f;
                }
                if (reactionAPlaceForStoryCardPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12443b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10545g, b3);
                        } else {
                            f10544f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionAPlaceForStoryCardPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m12442a(ReactionUnitComponentNode reactionUnitComponentNode, Void voidR, E e, View view) {
        super.a(reactionUnitComponentNode, voidR, e, view);
        SegmentedLinearLayout segmentedLinearLayout = (SegmentedLinearLayout) view.findViewById(2131559611);
        if (!reactionUnitComponentNode.f18862b.N()) {
            segmentedLinearLayout.setShowSegmentedDividers(0);
        }
    }
}
