package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
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
import com.facebook.pages.common.reaction.ui.PageContactInfoStackComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setIsMediaAttached */
public class PageContactInfoStackUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageContactInfoStackComponentView> {
    public static final ViewType f1890a = new C02471();
    private static PageContactInfoStackUnitComponentPartDefinition f1891c;
    private static final Object f1892d = new Object();
    private final PagesSurfaceReactionHelper<E> f1893b;

    /* compiled from: setIsMediaAttached */
    final class C02471 extends ViewType {
        C02471() {
        }

        public final View m2934a(Context context) {
            return new PageContactInfoStackComponentView(context);
        }
    }

    /* compiled from: setIsMediaAttached */
    public class State {
        public final OnClickListener f1883a;
        public final OnClickListener f1884b;
        public final OnClickListener f1885c;
        public final String f1886d;
        public final String f1887e;
        public final String f1888f;
        public final String f1889g;

        public State(String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3) {
            this.f1886d = str;
            this.f1887e = str2;
            this.f1888f = str3;
            this.f1889g = str4;
            this.f1883a = onClickListener;
            this.f1884b = onClickListener2;
            this.f1885c = onClickListener3;
        }
    }

    private static PageContactInfoStackUnitComponentPartDefinition m2938b(InjectorLike injectorLike) {
        return new PageContactInfoStackUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m2941a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(m2939b(reactionUnitComponentFields.ao()), m2939b(reactionUnitComponentFields.aY()), m2939b(reactionUnitComponentFields.de()), m2939b(reactionUnitComponentFields.bL()), this.f1893b.m3152a(reactionUnitComponentFields.aZ(), canLaunchReactionIntent, reactionUnitComponentNode.k(), reactionUnitComponentNode.l()), this.f1893b.m3152a(reactionUnitComponentFields.df(), canLaunchReactionIntent, reactionUnitComponentNode.k(), reactionUnitComponentNode.l()), this.f1893b.m3152a(reactionUnitComponentFields.bK(), canLaunchReactionIntent, reactionUnitComponentNode.k(), reactionUnitComponentNode.l()));
    }

    public final /* bridge */ /* synthetic */ void m2942a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1603339167);
        m2936a((State) obj2, (PageContactInfoStackComponentView) view);
        Logger.a(8, EntryType.MARK_POP, 1237279004, a);
    }

    public final boolean m2943a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return m2937a(reactionUnitComponentFields.ao()) || m2937a(reactionUnitComponentFields.aY()) || m2937a(reactionUnitComponentFields.bL()) || m2937a(reactionUnitComponentFields.de());
    }

    public final void m2944b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        PageContactInfoStackComponentView pageContactInfoStackComponentView = (PageContactInfoStackComponentView) view;
        pageContactInfoStackComponentView.f2151d.setOnClickListener(null);
        pageContactInfoStackComponentView.f2152e.setOnClickListener(null);
        pageContactInfoStackComponentView.f2153f.setOnClickListener(null);
    }

    public final ViewType m2940a() {
        return f1890a;
    }

    public static PageContactInfoStackUnitComponentPartDefinition m2935a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageContactInfoStackUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1892d) {
                PageContactInfoStackUnitComponentPartDefinition pageContactInfoStackUnitComponentPartDefinition;
                if (a2 != null) {
                    pageContactInfoStackUnitComponentPartDefinition = (PageContactInfoStackUnitComponentPartDefinition) a2.a(f1892d);
                } else {
                    pageContactInfoStackUnitComponentPartDefinition = f1891c;
                }
                if (pageContactInfoStackUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2938b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1892d, b3);
                        } else {
                            f1891c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageContactInfoStackUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageContactInfoStackUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1893b = pagesSurfaceReactionHelper;
    }

    private static void m2936a(State state, PageContactInfoStackComponentView pageContactInfoStackComponentView) {
        pageContactInfoStackComponentView.m3166a(state.f1886d, state.f1887e, state.f1883a, state.f1889g, state.f1885c, state.f1888f, state.f1884b);
    }

    private static boolean m2937a(DefaultTextWithEntitiesFields defaultTextWithEntitiesFields) {
        return (defaultTextWithEntitiesFields == null || StringUtil.a(defaultTextWithEntitiesFields.a())) ? false : true;
    }

    private static String m2939b(DefaultTextWithEntitiesFields defaultTextWithEntitiesFields) {
        return m2937a(defaultTextWithEntitiesFields) ? defaultTextWithEntitiesFields.a() : null;
    }
}
