package com.facebook.feed.rows.pager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager$SimpleOnPageChangeListener;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.debug.fps.frameblame.HScrollRenderBlameMarker;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.ScrollStoppedEvent;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.feed.rows.core.persistence.ScrollPersistentState;
import com.facebook.feed.rows.core.persistence.ScrollStateKey;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewAdapter.PageStyler;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PagerBinderDelegate;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PagerPersistentState;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PagerStateKey;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition$Props;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: omit_response_on_success */
public class PersistentPagerPartDefinition<SubProps, E extends HasPersistentState> extends BaseSinglePartDefinition<PersistentRecyclerPartDefinition$Props<SubProps, E>, State, E, RowViewPager> {
    private static PersistentPagerPartDefinition f6259d;
    private static final Object f6260e = new Object();
    private final FrameRateBlameMarkers f6261a;
    private final PagerBinderAdapterProvider f6262b;
    private final EventsStream f6263c;

    /* compiled from: omit_response_on_success */
    public class State {
        public final PagerBinderDelegate f6944a;
        public final ViewPager$SimpleOnPageChangeListener f6945b;
        public final ScrollPersistentState f6946c;
        public final PagerPersistentState f6947d;
        public final PagerBinderAdapter f6948e;
        public RowViewPager f6949f;
        public Action<ScrollStoppedEvent> f6950g;
        public Subscription<ScrollStoppedEvent, Void> f6951h;

        public State(PagerBinderDelegate pagerBinderDelegate, ViewPager$SimpleOnPageChangeListener viewPager$SimpleOnPageChangeListener, ScrollPersistentState scrollPersistentState, PagerPersistentState pagerPersistentState, PagerBinderAdapter pagerBinderAdapter) {
            this.f6944a = pagerBinderDelegate;
            this.f6945b = viewPager$SimpleOnPageChangeListener;
            this.f6946c = scrollPersistentState;
            this.f6947d = pagerPersistentState;
            this.f6948e = pagerBinderAdapter;
        }
    }

    private static PersistentPagerPartDefinition m6709b(InjectorLike injectorLike) {
        return new PersistentPagerPartDefinition(FrameRateBlameMarkers.a(injectorLike), (PagerBinderAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PagerBinderAdapterProvider.class), EventsStream.a(injectorLike));
    }

    public final Object m6710a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final PersistentRecyclerPartDefinition$Props persistentRecyclerPartDefinition$Props = (PersistentRecyclerPartDefinition$Props) obj;
        anyEnvironment = (HasPersistentState) anyEnvironment;
        final PagerBinderDelegate pagerBinderDelegate = new PagerBinderDelegate(persistentRecyclerPartDefinition$Props.f13889c, persistentRecyclerPartDefinition$Props);
        ScrollPersistentState scrollPersistentState = (ScrollPersistentState) anyEnvironment.a(ScrollStateKey.a);
        PagerPersistentState pagerPersistentState = (PagerPersistentState) anyEnvironment.a(PagerStateKey.m14738a(pagerBinderDelegate.m14711b()), pagerBinderDelegate.m14713c());
        if (pagerPersistentState.m14741a()) {
            pagerPersistentState.f13930a = pagerBinderDelegate.m14709a();
        }
        final PagerPersistentState pagerPersistentState2 = pagerPersistentState;
        ViewPager$SimpleOnPageChangeListener c02891 = new ViewPager$SimpleOnPageChangeListener(this) {
            final /* synthetic */ PersistentPagerPartDefinition f6432c;

            public final void e_(int i) {
                if (pagerPersistentState2 != null) {
                    if (pagerPersistentState2.f13930a != i) {
                        pagerPersistentState2.f13930a = i;
                    } else {
                        return;
                    }
                }
                pagerBinderDelegate.m14712b(i);
            }
        };
        PagerBinderAdapter a = this.f6262b.m6713a(pagerBinderDelegate, new PageStyler(this) {
            final /* synthetic */ PersistentPagerPartDefinition f6434b;

            public final void mo580a(View view, int i, int i2) {
                persistentRecyclerPartDefinition$Props.f13887a.mo574a(view, i, i2);
            }

            public final void mo579a(View view) {
                persistentRecyclerPartDefinition$Props.f13887a.mo573a(view);
            }

            public final float mo578a(int i, int i2) {
                return persistentRecyclerPartDefinition$Props.f13887a.mo570a(i, i2);
            }
        });
        a.m6873a(m6706a(anyEnvironment), anyEnvironment);
        final State state = new State(pagerBinderDelegate, c02891, scrollPersistentState, pagerPersistentState2, a);
        state.f6950g = new Action<ScrollStoppedEvent>(this) {
            final /* synthetic */ PersistentPagerPartDefinition f6953b;

            public final void m7258a(Object obj) {
                if (state.f6949f != null) {
                    state.f6949f.setHiddenPages(1);
                }
            }
        };
        return state;
    }

    public final /* bridge */ /* synthetic */ void m6711a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1747849575);
        m6708a((PersistentRecyclerPartDefinition$Props) obj, (State) obj2, (RowViewPager) view);
        Logger.a(8, EntryType.MARK_POP, -1140310590, a);
    }

    public final void m6712b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        RowViewPager rowViewPager = (RowViewPager) view;
        rowViewPager.setAdapter(null);
        rowViewPager.setOnPageChangeListener(null);
        this.f6263c.a(state.f6951h);
        state.f6949f = null;
    }

    public static PersistentPagerPartDefinition m6707a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PersistentPagerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6260e) {
                PersistentPagerPartDefinition persistentPagerPartDefinition;
                if (a2 != null) {
                    persistentPagerPartDefinition = (PersistentPagerPartDefinition) a2.a(f6260e);
                } else {
                    persistentPagerPartDefinition = f6259d;
                }
                if (persistentPagerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6709b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6260e, b3);
                        } else {
                            f6259d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = persistentPagerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PersistentPagerPartDefinition(FrameRateBlameMarkers frameRateBlameMarkers, PagerBinderAdapterProvider pagerBinderAdapterProvider, EventsStream eventsStream) {
        this.f6261a = frameRateBlameMarkers;
        this.f6262b = pagerBinderAdapterProvider;
        this.f6263c = eventsStream;
    }

    private void m6708a(PersistentRecyclerPartDefinition$Props<SubProps, E> persistentRecyclerPartDefinition$Props, State state, RowViewPager rowViewPager) {
        int i = 0;
        TracerDetour.a("PagerBinder.bind", 425610389);
        try {
            state.f6949f = rowViewPager;
            this.f6261a.c(HScrollRenderBlameMarker.m4745c());
            if ((state.f6946c.a() != 0 ? 1 : 0) == 0) {
                i = 1;
            }
            rowViewPager.setHiddenPages(i);
            persistentRecyclerPartDefinition$Props.f13887a.mo571a((ViewPager) rowViewPager);
            state.f6951h = this.f6263c.a(ScrollStoppedEvent.class, state.f6950g);
            TracerDetour.a("PagerBinder.RowViewPager.setAdapter", -956879783);
            try {
                i = state.f6948e;
                rowViewPager.setAdapter(i);
                TracerDetour.a(i);
                rowViewPager.setOnPageChangeListener(state.f6945b);
                rowViewPager.setCurrentItem(m6705a(state.f6944a, state.f6947d));
            } finally {
                TracerDetour.a(413833042);
            }
        } finally {
            TracerDetour.a(-1819953960);
        }
    }

    private static RowKey m6706a(AnyEnvironment anyEnvironment) {
        return anyEnvironment instanceof HasRowKey ? ((HasRowKey) anyEnvironment).m() : null;
    }

    private static int m6705a(PagerBinderDelegate pagerBinderDelegate, PagerPersistentState pagerPersistentState) {
        if (pagerPersistentState != null) {
            int i = pagerPersistentState.f13930a;
            if (i >= 0 && i < pagerBinderDelegate.m14715e()) {
                return i;
            }
        }
        return pagerBinderDelegate.f13916d;
    }
}
