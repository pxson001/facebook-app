package com.facebook.aplacefor.reaction.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.aplacefor.reaction.partdefinitions.ReactionAPlaceForAnimationPartDefinition.Props;
import com.facebook.aplacefor.reaction.views.APlaceForHeaderCardView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
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
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionAPlaceForHeaderCardComponentFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionAPlaceForHeaderCardComponentFragment.BackgroundImage;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: item  */
public class ReactionAPlaceForHeaderCardPartDefinition<E extends HasContext> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, APlaceForHeaderCardView> {
    public static final ViewType f10533a = new C11231();
    private static ReactionAPlaceForHeaderCardPartDefinition f10534i;
    private static final Object f10535j = new Object();
    private final FbDraweePartDefinition f10536b;
    private final FbDraweePartDefinition f10537c;
    private final TextPartDefinition f10538d;
    private final TextOrHiddenPartDefinition f10539e;
    private final ReactionAPlaceForAnimationPartDefinition f10540f;
    private final VisibilityPartDefinition f10541g;
    private final FunnelLoggerImpl f10542h;

    /* compiled from: item  */
    final class C11231 extends ViewType {
        C11231() {
        }

        public final View m12434a(Context context) {
            return new APlaceForHeaderCardView(context);
        }
    }

    /* compiled from: item  */
    public class State {
        public final String f10531a;
        public final String f10532b;

        public State(String str, String str2) {
            this.f10531a = str;
            this.f10532b = str2;
        }
    }

    private static ReactionAPlaceForHeaderCardPartDefinition m12436b(InjectorLike injectorLike) {
        return new ReactionAPlaceForHeaderCardPartDefinition(FbDraweePartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), ReactionAPlaceForAnimationPartDefinition.m12422a(injectorLike), VisibilityPartDefinition.a(injectorLike), FunnelLoggerImpl.a(injectorLike));
    }

    public final Object m12438a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        this.f10542h.b(FunnelRegistry.b, "header_card_instantiated");
        this.f10542h.b(FunnelRegistry.b);
        ReactionAPlaceForHeaderCardComponentFragment reactionAPlaceForHeaderCardComponentFragment = reactionUnitComponentNode.f18862b;
        BackgroundImage m = reactionAPlaceForHeaderCardComponentFragment.m();
        CallerContext a = CallerContext.a(getClass(), "a_place_for");
        int i = hasContext.getContext().getResources().getDisplayMetrics().widthPixels;
        int c = (int) (((float) i) / (((float) m.c()) / ((float) m.a())));
        FbDraweePartDefinition fbDraweePartDefinition = this.f10536b;
        Builder a2 = FbDraweePartDefinition.a().a(m.b()).a(-1, c);
        a2.c = a;
        subParts.a(2131559604, fbDraweePartDefinition, a2.a());
        if (reactionAPlaceForHeaderCardComponentFragment.j() != null) {
            ReactionAPlaceForAnimationPartDefinition reactionAPlaceForAnimationPartDefinition = this.f10540f;
            Props.Builder b = ReactionAPlaceForAnimationPartDefinition.m12423b();
            b.f10515c = c;
            b = b;
            b.f10514b = i;
            Props.Builder builder = b;
            builder.f10513a = reactionAPlaceForHeaderCardComponentFragment.j();
            builder = builder;
            builder.f10516d = reactionUnitComponentNode.f18862b.U();
            subParts.a(2131559605, reactionAPlaceForAnimationPartDefinition, builder.m12421a());
        } else {
            subParts.a(2131559605, this.f10541g, Integer.valueOf(8));
        }
        int p = (int) (((double) c) * reactionAPlaceForHeaderCardComponentFragment.p());
        FbDraweePartDefinition fbDraweePartDefinition2 = this.f10537c;
        a2 = FbDraweePartDefinition.a().a(reactionAPlaceForHeaderCardComponentFragment.o().a()).a(p, p);
        a2.c = a;
        subParts.a(2131559606, fbDraweePartDefinition2, a2.a());
        subParts.a(2131559607, this.f10538d, reactionAPlaceForHeaderCardComponentFragment.l().a());
        Object obj2 = null;
        if (reactionAPlaceForHeaderCardComponentFragment.q() != null) {
            obj2 = reactionAPlaceForHeaderCardComponentFragment.q().a();
        }
        subParts.a(2131559608, this.f10539e, obj2);
        return new State(reactionAPlaceForHeaderCardComponentFragment.n(), reactionAPlaceForHeaderCardComponentFragment.r());
    }

    public final /* bridge */ /* synthetic */ void m12439a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 515650031);
        State state = (State) obj2;
        APlaceForHeaderCardView aPlaceForHeaderCardView = (APlaceForHeaderCardView) view;
        if (state.f10531a != null) {
            aPlaceForHeaderCardView.setTitleColor((int) Long.parseLong(state.f10531a, 16));
        } else {
            aPlaceForHeaderCardView.setTitleColor(aPlaceForHeaderCardView.getResources().getColor(2131361921));
        }
        if (state.f10532b != null) {
            aPlaceForHeaderCardView.setSubtitleColor((int) Long.parseLong(state.f10532b, 16));
        } else {
            aPlaceForHeaderCardView.setSubtitleColor(aPlaceForHeaderCardView.getResources().getColor(2131361921));
        }
        Logger.a(8, EntryType.MARK_POP, 996906268, a);
    }

    public final boolean m12440a(Object obj) {
        ReactionAPlaceForHeaderCardComponentFragment reactionAPlaceForHeaderCardComponentFragment = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionAPlaceForHeaderCardComponentFragment.l() == null || Strings.isNullOrEmpty(reactionAPlaceForHeaderCardComponentFragment.l().a()) || reactionAPlaceForHeaderCardComponentFragment.m() == null || Strings.isNullOrEmpty(reactionAPlaceForHeaderCardComponentFragment.m().b()) || reactionAPlaceForHeaderCardComponentFragment.o() == null || Strings.isNullOrEmpty(reactionAPlaceForHeaderCardComponentFragment.o().a())) ? false : true;
    }

    public static ReactionAPlaceForHeaderCardPartDefinition m12435a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionAPlaceForHeaderCardPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10535j) {
                ReactionAPlaceForHeaderCardPartDefinition reactionAPlaceForHeaderCardPartDefinition;
                if (a2 != null) {
                    reactionAPlaceForHeaderCardPartDefinition = (ReactionAPlaceForHeaderCardPartDefinition) a2.a(f10535j);
                } else {
                    reactionAPlaceForHeaderCardPartDefinition = f10534i;
                }
                if (reactionAPlaceForHeaderCardPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12436b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10535j, b3);
                        } else {
                            f10534i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionAPlaceForHeaderCardPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionAPlaceForHeaderCardPartDefinition(FbDraweePartDefinition fbDraweePartDefinition, FbDraweePartDefinition fbDraweePartDefinition2, TextPartDefinition textPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, ReactionAPlaceForAnimationPartDefinition reactionAPlaceForAnimationPartDefinition, VisibilityPartDefinition visibilityPartDefinition, FunnelLoggerImpl funnelLoggerImpl) {
        this.f10536b = fbDraweePartDefinition;
        this.f10537c = fbDraweePartDefinition2;
        this.f10538d = textPartDefinition;
        this.f10539e = textOrHiddenPartDefinition;
        this.f10540f = reactionAPlaceForAnimationPartDefinition;
        this.f10541g = visibilityPartDefinition;
        this.f10542h = funnelLoggerImpl;
    }

    public final ViewType m12437a() {
        return f10533a;
    }
}
