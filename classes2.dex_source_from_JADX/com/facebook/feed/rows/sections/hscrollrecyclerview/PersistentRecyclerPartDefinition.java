package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.debug.fps.frameblame.HScrollRenderBlameMarker;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewAdapter.PageStyler;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView.OnPageChangedListener;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: it */
public class PersistentRecyclerPartDefinition<SubProps, E extends HasPersistentState & HasContext> extends BaseSinglePartDefinition<Props<SubProps, E>, State, E, HScrollRecyclerView> {
    private static PersistentRecyclerPartDefinition f18735h;
    private static final Object f18736i = new Object();
    private final HScrollViewTypes f18737a;
    private final HScrollRecycledViewPool f18738b;
    private final FrameRateBlameMarkers f18739c;
    private final HScrollRecyclerViewAdapterProvider f18740d;
    private final PageItemsProvider f18741e;
    private final AbstractFbErrorReporter f18742f;
    private final FeedRenderUtils f18743g;

    private static PersistentRecyclerPartDefinition m26344b(InjectorLike injectorLike) {
        return new PersistentRecyclerPartDefinition((Context) injectorLike.getInstance(Context.class), HScrollRecycledViewPool.m26350a(injectorLike), HScrollViewTypes.m26352a(injectorLike), FrameRateBlameMarkers.m16545a(injectorLike), (HScrollRecyclerViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(HScrollRecyclerViewAdapterProvider.class), (PageItemsProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PageItemsProvider.class), FbErrorReporterImpl.m2317a(injectorLike), FeedRenderUtils.m14652a(injectorLike));
    }

    public final /* synthetic */ void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        m26342a((HScrollRecyclerView) view);
    }

    @Inject
    public PersistentRecyclerPartDefinition(Context context, HScrollRecycledViewPool hScrollRecycledViewPool, HScrollViewTypes hScrollViewTypes, FrameRateBlameMarkers frameRateBlameMarkers, HScrollRecyclerViewAdapterProvider hScrollRecyclerViewAdapterProvider, PageItemsProvider pageItemsProvider, AbstractFbErrorReporter abstractFbErrorReporter, FeedRenderUtils feedRenderUtils) {
        this.f18738b = hScrollRecycledViewPool;
        this.f18737a = hScrollViewTypes;
        this.f18739c = frameRateBlameMarkers;
        this.f18740d = hScrollRecyclerViewAdapterProvider;
        this.f18741e = pageItemsProvider;
        this.f18742f = abstractFbErrorReporter;
        this.f18743g = feedRenderUtils;
    }

    public static PersistentRecyclerPartDefinition m26338a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PersistentRecyclerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18736i) {
                PersistentRecyclerPartDefinition persistentRecyclerPartDefinition;
                if (a2 != null) {
                    persistentRecyclerPartDefinition = (PersistentRecyclerPartDefinition) a2.mo818a(f18736i);
                } else {
                    persistentRecyclerPartDefinition = f18735h;
                }
                if (persistentRecyclerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26344b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18736i, b3);
                        } else {
                            f18735h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = persistentRecyclerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private void m26341a(PagerBinderDelegate pagerBinderDelegate) {
        this.f18742f.m2340a("HScrollRecyclerView pageitems have 0 item", pagerBinderDelegate.a.getClass().toString());
    }

    public final State m26345a(Props<SubProps, E> props, E e) {
        TracerDetour.a("HScrollRecyclerViewBinder.prepare", 1520317171);
        try {
            PagerBinderDelegate pagerBinderDelegate = new PagerBinderDelegate(props.c, props);
            PageItems a = this.f18741e.m26359a(pagerBinderDelegate);
            HScrollRecyclerViewAdapter a2 = this.f18740d.m26358a(m26336a((Props) props), a);
            a2.a(props.d);
            if (a.b() == 0) {
                m26341a(pagerBinderDelegate);
            }
            a.a(m26335a((AnyEnvironment) e));
            a.a(e);
            PagerPersistentState a3 = m26337a((HasPersistentState) e, pagerBinderDelegate);
            int e2 = pagerBinderDelegate.e();
            int d = pagerBinderDelegate.d();
            int min = Math.min(e2, d + 3);
            for (int i = d; i < min; i++) {
                a.c(i);
            }
            m26340a(a2, e2, d, ((HasContext) e).getContext());
            State state = new State(pagerBinderDelegate, a, a2, a3, m26339a(pagerBinderDelegate, a3));
            return state;
        } finally {
            TracerDetour.a(334354206);
        }
    }

    public final void m26347a(Props<SubProps, E> props, State state, HScrollRecyclerView hScrollRecyclerView) {
        TracerDetour.a("HScrollRecyclerViewBinder.bind", -1542326800);
        try {
            this.f18739c.m16552c(HScrollRenderBlameMarker.c());
            props.a.a(hScrollRecyclerView);
            hScrollRecyclerView.setRecycledViewPool(this.f18738b);
            hScrollRecyclerView.setAdapter(state.c);
            hScrollRecyclerView.setOnPageChangedListener(state.e);
            hScrollRecyclerView.g(props.a.b(), this.f18743g.m14654a());
            if (hScrollRecyclerView.l()) {
                hScrollRecyclerView.setCurrentPosition(m26343b(state.a, state.d));
            } else {
                hScrollRecyclerView.h(m26343b(state.a, state.d), m26334a(state.d));
            }
            TracerDetour.a(-1506757039);
        } catch (Throwable th) {
            TracerDetour.a(1378138677);
        }
    }

    public static void m26342a(HScrollRecyclerView hScrollRecyclerView) {
        hScrollRecyclerView.setAdapter(null);
        hScrollRecyclerView.setRecycledViewPool(null);
        hScrollRecyclerView.m = null;
    }

    private PageStyler m26336a(Props<SubProps, E> props) {
        return new 1(this, props);
    }

    private void m26340a(HScrollRecyclerViewAdapter hScrollRecyclerViewAdapter, int i, int i2, Context context) {
        ViewGroup 2 = new 2(this, context);
        int min = Math.min(i, i2 + 2);
        while (i2 < min) {
            int itemViewType = hScrollRecyclerViewAdapter.getItemViewType(i2);
            PagerViewType a = this.f18737a.m26355a(itemViewType);
            if (this.f18737a.m26357c(a)) {
                this.f18738b.m20114a(hScrollRecyclerViewAdapter.m17222b(2, itemViewType));
                this.f18737a.m26356b(a);
            }
            i2++;
        }
    }

    private OnPageChangedListener m26339a(PagerBinderDelegate<SubProps, E> pagerBinderDelegate, PagerPersistentState pagerPersistentState) {
        return new 3(this, pagerPersistentState, pagerBinderDelegate);
    }

    private static RowKey m26335a(AnyEnvironment anyEnvironment) {
        return anyEnvironment instanceof HasRowKey ? ((HasRowKey) anyEnvironment).mo2459m() : null;
    }

    @Nullable
    private static PagerPersistentState m26337a(HasPersistentState hasPersistentState, PagerBinderDelegate pagerBinderDelegate) {
        PagerPersistentState pagerPersistentState = (PagerPersistentState) hasPersistentState.mo2425a(PagerStateKey.a(pagerBinderDelegate.b()), pagerBinderDelegate.c());
        if (pagerPersistentState.a()) {
            pagerPersistentState.a = pagerBinderDelegate.a();
        }
        return pagerPersistentState;
    }

    private static int m26343b(PagerBinderDelegate pagerBinderDelegate, PagerPersistentState pagerPersistentState) {
        if (pagerPersistentState != null) {
            int i = pagerPersistentState.a;
            if (i >= 0 && i < pagerBinderDelegate.e()) {
                return i;
            }
        }
        return pagerBinderDelegate.d;
    }

    private static int m26334a(PagerPersistentState pagerPersistentState) {
        if (pagerPersistentState != null) {
            int i = pagerPersistentState.b;
            if (i != 0) {
                return i;
            }
        }
        return 0;
    }
}
