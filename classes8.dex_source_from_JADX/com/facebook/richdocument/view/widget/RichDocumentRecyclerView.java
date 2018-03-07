package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.facebook.common.time.MonotonicClock;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEvents.RecyclerViewFocusRequest;
import com.facebook.richdocument.event.RichDocumentEvents.RecyclerViewFocusRequest.RequestType;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFirstRenderEvent;
import com.facebook.richdocument.event.RichDocumentEvents.ScrollValueChangedEvent;
import com.facebook.richdocument.view.transition.state.MediaStateMachine;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnInterceptTouchEventListener;
import javax.inject.Inject;

/* compiled from: offer_view_claim_to_wallet */
public class RichDocumentRecyclerView extends BetterRecyclerView {
    @Inject
    public Lazy<RichDocumentEventBus> f7333l;
    @Inject
    public Lazy<MonotonicClock> f7334m;
    @Inject
    public Lazy<SequenceLogger> f7335n;
    @Inject
    public GatekeeperStoreImpl f7336o;
    private final RichDocumentMediaSnapper f7337p;
    private final boolean f7338q;
    private boolean f7339r;
    private boolean f7340s;
    private boolean f7341t;
    public AbstractSequenceDefinition f7342u;

    /* compiled from: offer_view_claim_to_wallet */
    class C08381 extends OnScrollListener {
        final /* synthetic */ RichDocumentRecyclerView f7332a;

        C08381(RichDocumentRecyclerView richDocumentRecyclerView) {
            this.f7332a = richDocumentRecyclerView;
        }

        public final void m7596a(RecyclerView recyclerView, int i) {
            if (i == 1) {
                ((RichDocumentEventBus) this.f7332a.f7333l.get()).a(new RecyclerViewFocusRequest(RequestType.UNSET_FOCUSED_VIEW, recyclerView, null));
            } else if (i == 2) {
                RichDocumentRecyclerView.m7604o(this.f7332a);
            }
        }

        public final void m7597a(RecyclerView recyclerView, int i, int i2) {
            ((RichDocumentEventBus) this.f7332a.f7333l.get()).a(new ScrollValueChangedEvent(recyclerView, i, i2));
        }
    }

    private static <T extends View> void m7599a(Class<T> cls, T t) {
        m7600a((Object) t, t.getContext());
    }

    private static void m7600a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RichDocumentRecyclerView richDocumentRecyclerView = (RichDocumentRecyclerView) obj;
        Lazy a = IdBasedLazy.a(fbInjector, 10298);
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 601);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 3422);
        GatekeeperStoreImpl a2 = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        richDocumentRecyclerView.f7333l = a;
        richDocumentRecyclerView.f7334m = b;
        richDocumentRecyclerView.f7335n = b2;
        richDocumentRecyclerView.f7336o = a2;
    }

    public RichDocumentRecyclerView(Context context) {
        this(context, null);
    }

    public RichDocumentRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RichDocumentRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7339r = false;
        this.f7340s = false;
        this.f7341t = false;
        m7599a(RichDocumentRecyclerView.class, (View) this);
        this.f7338q = this.f7336o.a(679, false);
        this.f7337p = new RichDocumentMediaSnapper(this);
        m7602b(true);
        a(new C08381(this));
    }

    private void m7602b(boolean z) {
        if (z) {
            a(this.f7337p);
        } else {
            b(this.f7337p);
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f7338q || !(view2 instanceof WebView)) {
            super.requestChildFocus(view, view2);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View a = a(motionEvent.getX(), motionEvent.getY());
        if (a != null && (a instanceof OnInterceptTouchEventListener) && ((OnInterceptTouchEventListener) a).onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final boolean m7605b(int i, int i2) {
        boolean o = m7604o(this);
        if (this.f7337p != null) {
            this.f7337p.f7329k = (float) i2;
            o |= this.f7337p.m7595a();
        }
        if (o) {
            return false;
        }
        return super.b(i, i2);
    }

    public static boolean m7604o(RichDocumentRecyclerView richDocumentRecyclerView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) richDocumentRecyclerView.getLayoutManager();
        int l = linearLayoutManager.l();
        int v = l + linearLayoutManager.v();
        boolean z = false;
        while (l <= v) {
            z |= richDocumentRecyclerView.m7603h(linearLayoutManager.c(l));
            l++;
        }
        return z;
    }

    private boolean m7603h(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        if (view instanceof MediaStateMachine) {
            return ((MediaStateMachine) view).mo447a(Event.SCROLL_FINISHED);
        }
        boolean h;
        int i;
        if (view instanceof FrameLayout) {
            i = 0;
            while (i < ((FrameLayout) view).getChildCount()) {
                h = m7603h(((FrameLayout) view).getChildAt(i)) | z;
                i++;
                z = h;
            }
            h = z;
        } else {
            if (view instanceof CustomLinearLayout) {
                i = 0;
                while (i < ((CustomLinearLayout) view).getChildCount()) {
                    h = m7603h(((CustomLinearLayout) view).getChildAt(i)) | z;
                    i++;
                    z = h;
                }
            }
            h = z;
        }
        return h;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        Sequence sequence = null;
        if (!(this.f7340s || this.o == null || this.o.aZ_() <= 0 || this.f7342u == null)) {
            boolean z2;
            Sequence e = ((SequenceLogger) this.f7335n.get()).e(this.f7342u);
            if (e != null) {
                SequenceLoggerDetour.a(e, "rich_document_first_measure", -1450372546);
                z2 = true;
            } else {
                z2 = false;
            }
            this.f7340s = true;
            z = z2;
            sequence = e;
        }
        super.onMeasure(i, i2);
        if (z && sequence != null) {
            SequenceLoggerDetour.b(sequence, "rich_document_first_measure", -85508052);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = false;
        Sequence sequence = null;
        if (!(this.f7341t || this.o == null || this.o.aZ_() <= 0 || this.f7342u == null)) {
            boolean z3;
            Sequence e = ((SequenceLogger) this.f7335n.get()).e(this.f7342u);
            if (e != null) {
                SequenceLoggerDetour.a(e, "rich_document_first_layout", -683984175);
                z3 = true;
            } else {
                z3 = false;
            }
            this.f7341t = true;
            z2 = z3;
            sequence = e;
        }
        super.onLayout(z, i, i2, i3, i4);
        if (z2 && sequence != null) {
            SequenceLoggerDetour.b(sequence, "rich_document_first_layout", -658949079);
        }
    }

    public void draw(Canvas canvas) {
        long now = ((MonotonicClock) this.f7334m.get()).now();
        super.draw(canvas);
        m7598a(now);
    }

    private void m7598a(long j) {
        if (!this.f7339r && this.o != null && this.o.aZ_() > 0) {
            this.f7339r = true;
            long now = ((MonotonicClock) this.f7334m.get()).now();
            ((RichDocumentEventBus) this.f7333l.get()).a(new RichDocumentFirstRenderEvent(now, now - j));
        }
    }
}
