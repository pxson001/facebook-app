package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
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
import com.facebook.pages.common.reaction.state.PageNuxViewStateStore;
import com.facebook.pages.common.reaction.state.PageNuxViewStateStore.NuxStateKey;
import com.facebook.pages.common.reaction.ui.PageNuxComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setAttachments */
public class PageNuxUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageNuxComponentView> {
    public static final ViewType f1978a = new C02571();
    private static PageNuxUnitComponentPartDefinition f1979d;
    private static final Object f1980e = new Object();
    private final PagesSurfaceReactionHelper<E> f1981b;
    private final PageNuxViewStateStore f1982c;

    /* compiled from: setAttachments */
    final class C02571 extends ViewType {
        C02571() {
        }

        public final View m3019a(Context context) {
            return new PageNuxComponentView(context);
        }
    }

    /* compiled from: setAttachments */
    public class State {
        ImmutableList<? extends DefaultTextWithEntitiesFields> f1967a;
        DefaultTextWithEntitiesFields f1968b;
        DefaultTextWithEntitiesFields f1969c;
        DefaultImageFields f1970d;
        String f1971e;
        NuxStateKey f1972f;
        String f1973g;
        OnClickListener f1974h;
        String f1975i;
        OnClickListener f1976j;
        String f1977k;

        public State(String str, DefaultTextWithEntitiesFields defaultTextWithEntitiesFields, DefaultTextWithEntitiesFields defaultTextWithEntitiesFields2, ImmutableList<? extends DefaultTextWithEntitiesFields> immutableList, DefaultImageFields defaultImageFields, String str2, String str3, OnClickListener onClickListener, String str4, OnClickListener onClickListener2, String str5, PageNuxViewStateStore pageNuxViewStateStore) {
            this.f1972f = new NuxStateKey(pageNuxViewStateStore, str, str3);
            this.f1968b = defaultTextWithEntitiesFields;
            this.f1969c = defaultTextWithEntitiesFields2;
            this.f1967a = immutableList;
            this.f1970d = defaultImageFields;
            this.f1971e = str2;
            this.f1973g = str3;
            this.f1974h = onClickListener;
            this.f1975i = str4;
            this.f1976j = onClickListener2;
            this.f1977k = str5;
        }
    }

    private static PageNuxUnitComponentPartDefinition m3023b(InjectorLike injectorLike) {
        return new PageNuxUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike), PageNuxViewStateStore.m3160a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m3025a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m3020a((ReactionUnitComponentNode) obj, (CanLaunchReactionIntent) anyEnvironment);
    }

    public final /* bridge */ /* synthetic */ void m3026a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 991380520);
        m3022a((State) obj2, (PageNuxComponentView) view);
        Logger.a(8, EntryType.MARK_POP, -200892550, a);
    }

    public final boolean m3027a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.aJ() == null || StringUtil.a(reactionUnitComponentFields.aJ().a()) || reactionUnitComponentFields.aS() == null || StringUtil.a(reactionUnitComponentFields.aS().b()) || StringUtil.a(reactionUnitComponentFields.aT()) || reactionUnitComponentFields.bs() == null || StringUtil.a(reactionUnitComponentFields.bs().a()) || reactionUnitComponentFields.bI() == null || StringUtil.a(reactionUnitComponentFields.bI().b()) || StringUtil.a(reactionUnitComponentFields.dh()) || reactionUnitComponentFields.P() == null || reactionUnitComponentFields.P().fU_() == null || StringUtil.a(reactionUnitComponentFields.P().fU_().a()) || reactionUnitComponentFields.S() == null || reactionUnitComponentFields.S().fU_() == null || StringUtil.a(reactionUnitComponentFields.S().fU_().a())) ? false : true;
    }

    public final void m3028b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        PageNuxComponentView pageNuxComponentView = (PageNuxComponentView) view;
        Preconditions.checkNotNull(pageNuxComponentView.f2208p);
        pageNuxComponentView.f2208p = null;
        pageNuxComponentView.f2207o = null;
        pageNuxComponentView.f2204l.setOnClickListener(null);
        pageNuxComponentView.f2205m.setOnClickListener(null);
    }

    public final ViewType m3024a() {
        return f1978a;
    }

    public static PageNuxUnitComponentPartDefinition m3021a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageNuxUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1980e) {
                PageNuxUnitComponentPartDefinition pageNuxUnitComponentPartDefinition;
                if (a2 != null) {
                    pageNuxUnitComponentPartDefinition = (PageNuxUnitComponentPartDefinition) a2.a(f1980e);
                } else {
                    pageNuxUnitComponentPartDefinition = f1979d;
                }
                if (pageNuxUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3023b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1980e, b3);
                        } else {
                            f1979d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageNuxUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageNuxUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper, PageNuxViewStateStore pageNuxViewStateStore) {
        this.f1981b = pagesSurfaceReactionHelper;
        this.f1982c = pageNuxViewStateStore;
    }

    private State m3020a(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ReactionUnitComponentFields f = reactionUnitComponentNode.f();
        return new State(f.bI().b(), f.aJ(), f.bs(), f.ap(), f.aS(), f.aT(), f.dh(), this.f1981b.m3152a(f.P(), e, reactionUnitComponentNode.k(), reactionUnitComponentNode.l()), f.P().fU_().a(), this.f1981b.m3152a(f.S(), e, reactionUnitComponentNode.k(), reactionUnitComponentNode.l()), f.S().fU_().a(), this.f1982c);
    }

    private static void m3022a(State state, PageNuxComponentView pageNuxComponentView) {
        pageNuxComponentView.m3179a(state.f1972f, state.f1968b, state.f1969c, state.f1967a, state.f1970d, state.f1971e, state.f1973g, state.f1974h, state.f1975i, state.f1976j, state.f1977k);
    }
}
