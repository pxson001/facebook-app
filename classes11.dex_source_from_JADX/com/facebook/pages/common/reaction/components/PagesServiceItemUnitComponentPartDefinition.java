package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
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
import com.facebook.pages.common.services.PagesServiceItem;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: selection_id */
public class PagesServiceItemUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PagesServiceItem> {
    public static final ViewType f2077a = new C02701();
    private static PagesServiceItemUnitComponentPartDefinition f2078c;
    private static final Object f2079d = new Object();
    private final PagesSurfaceReactionHelper<E> f2080b;

    /* compiled from: selection_id */
    final class C02701 extends ViewType {
        C02701() {
        }

        public final View m3108a(Context context) {
            return new PagesServiceItem(context);
        }
    }

    /* compiled from: selection_id */
    public class State {
        public final String f2074a;
        public final String f2075b;
        public final OnClickListener f2076c;

        public State(String str, String str2, OnClickListener onClickListener) {
            this.f2074a = str;
            this.f2075b = str2;
            this.f2076c = onClickListener;
        }
    }

    private static PagesServiceItemUnitComponentPartDefinition m3110b(InjectorLike injectorLike) {
        return new PagesServiceItemUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m3112a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(reactionUnitComponentFields.cw().eC_(), reactionUnitComponentFields.cw().c(), this.f2080b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m3113a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -189712872);
        State state = (State) obj2;
        ((PagesServiceItem) view).m3301a(null, state.f2074a, state.f2075b, state.f2076c);
        Logger.a(8, EntryType.MARK_POP, 147375770, a);
    }

    public final boolean m3114a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.cw() == null || StringUtil.a(reactionUnitComponentFields.cw().eC_()) || reactionUnitComponentFields.bI() == null || StringUtil.a(reactionUnitComponentFields.bI().b())) ? false : true;
    }

    public final void m3115b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PagesServiceItem) view).m3302f();
    }

    public final ViewType m3111a() {
        return f2077a;
    }

    public static PagesServiceItemUnitComponentPartDefinition m3109a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesServiceItemUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2079d) {
                PagesServiceItemUnitComponentPartDefinition pagesServiceItemUnitComponentPartDefinition;
                if (a2 != null) {
                    pagesServiceItemUnitComponentPartDefinition = (PagesServiceItemUnitComponentPartDefinition) a2.a(f2079d);
                } else {
                    pagesServiceItemUnitComponentPartDefinition = f2078c;
                }
                if (pagesServiceItemUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3110b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2079d, b3);
                        } else {
                            f2078c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesServiceItemUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PagesServiceItemUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f2080b = pagesSurfaceReactionHelper;
    }
}
