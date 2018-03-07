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
import com.facebook.pages.common.reaction.ui.PageInfoRatingsAndReviewsComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setIsFacecastNuxShowing */
public class PageInfoRatingsAndReviewsUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageInfoRatingsAndReviewsComponentView> {
    public static final ViewType f1924a = new C02511();
    private static PageInfoRatingsAndReviewsUnitComponentPartDefinition f1925c;
    private static final Object f1926d = new Object();
    private final PagesSurfaceReactionHelper<E> f1927b;

    /* compiled from: setIsFacecastNuxShowing */
    final class C02511 extends ViewType {
        C02511() {
        }

        public final View m2966a(Context context) {
            return new PageInfoRatingsAndReviewsComponentView(context);
        }
    }

    /* compiled from: setIsFacecastNuxShowing */
    public class State {
        public final OnClickListener f1917a;
        public final OnClickListener f1918b;
        public final String f1919c;
        public final String f1920d;
        public final double f1921e;
        public final double f1922f;
        public final String f1923g;

        public State(String str, String str2, double d, double d2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
            this.f1919c = str;
            this.f1920d = str2;
            this.f1921e = d;
            this.f1922f = d2;
            this.f1923g = str3;
            this.f1917a = onClickListener;
            this.f1918b = onClickListener2;
        }
    }

    private static PageInfoRatingsAndReviewsUnitComponentPartDefinition m2970b(InjectorLike injectorLike) {
        return new PageInfoRatingsAndReviewsUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m2972a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m2967a((ReactionUnitComponentNode) obj, (CanLaunchReactionIntent) anyEnvironment);
    }

    public final /* bridge */ /* synthetic */ void m2973a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1979523848);
        m2969a((State) obj2, (PageInfoRatingsAndReviewsComponentView) view);
        Logger.a(8, EntryType.MARK_POP, -59473040, a);
    }

    public final boolean m2974a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.ci() <= 0.0d || reactionUnitComponentFields.cj() <= 0.0d || reactionUnitComponentFields.cj() >= reactionUnitComponentFields.ci() || reactionUnitComponentFields.ch() == null || StringUtil.a(reactionUnitComponentFields.ch().a()) || reactionUnitComponentFields.co() == null || StringUtil.a(reactionUnitComponentFields.co().a())) ? false : true;
    }

    public final void m2975b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        PageInfoRatingsAndReviewsComponentView pageInfoRatingsAndReviewsComponentView = (PageInfoRatingsAndReviewsComponentView) view;
        pageInfoRatingsAndReviewsComponentView.f2159b.setOnClickListener(null);
        pageInfoRatingsAndReviewsComponentView.f2162e.setOnClickListener(null);
    }

    public final ViewType m2971a() {
        return f1924a;
    }

    public static PageInfoRatingsAndReviewsUnitComponentPartDefinition m2968a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageInfoRatingsAndReviewsUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1926d) {
                PageInfoRatingsAndReviewsUnitComponentPartDefinition pageInfoRatingsAndReviewsUnitComponentPartDefinition;
                if (a2 != null) {
                    pageInfoRatingsAndReviewsUnitComponentPartDefinition = (PageInfoRatingsAndReviewsUnitComponentPartDefinition) a2.a(f1926d);
                } else {
                    pageInfoRatingsAndReviewsUnitComponentPartDefinition = f1925c;
                }
                if (pageInfoRatingsAndReviewsUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2970b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1926d, b3);
                        } else {
                            f1925c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageInfoRatingsAndReviewsUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageInfoRatingsAndReviewsUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1927b = pagesSurfaceReactionHelper;
    }

    private State m2967a(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ReactionUnitComponentFields f = reactionUnitComponentNode.f();
        String a = f.ch().a();
        String a2 = f.co().a();
        double cj = f.cj();
        double ci = f.ci();
        String b = (f.aO() == null || f.aO().b() == null) ? null : f.aO().b();
        return new State(a, a2, cj, ci, b, this.f1927b.m3152a(f.dg(), e, reactionUnitComponentNode.k(), reactionUnitComponentNode.l()), this.f1927b.m3152a(f.cv(), e, reactionUnitComponentNode.k(), reactionUnitComponentNode.l()));
    }

    private static void m2969a(State state, PageInfoRatingsAndReviewsComponentView pageInfoRatingsAndReviewsComponentView) {
        pageInfoRatingsAndReviewsComponentView.m3168a(state.f1919c, state.f1921e, state.f1920d, state.f1918b, state.f1923g, state.f1917a);
    }
}
