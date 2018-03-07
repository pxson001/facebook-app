package com.facebook.feed.awesomizer.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.util.event.AwesomizerViewEvents.CardClosedEvent;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: gysj_join */
public abstract class BaseAwesomizerFragment<T> extends FbFragment {
    protected FbTextView f11810a;
    @Inject
    public EventsStream al;
    public LoadingIndicatorView am;
    protected AbstractDisposableFutureCallback f11811b;
    protected String f11812c;
    public GridLayoutManager f11813d;
    protected RecyclerView f11814e;
    protected double f11815f = 0.0d;
    public int f11816g = 0;
    public BaseAwesomizerAdapter f11817h;
    @Inject
    public FeedAwesomizerLogger f11818i;

    /* compiled from: gysj_join */
    class C12671 extends SpanSizeLookup {
        final /* synthetic */ BaseAwesomizerFragment f11806b;

        C12671(BaseAwesomizerFragment baseAwesomizerFragment) {
            this.f11806b = baseAwesomizerFragment;
        }

        public final int m13889a(int i) {
            return this.f11806b.mo816g(i);
        }
    }

    /* compiled from: gysj_join */
    class C12682 extends OnScrollListener {
        final /* synthetic */ BaseAwesomizerFragment f11807a;

        C12682(BaseAwesomizerFragment baseAwesomizerFragment) {
            this.f11807a = baseAwesomizerFragment;
        }

        public final void m13890a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int n = this.f11807a.f11813d.n();
            this.f11807a.f11815f = Math.max(this.f11807a.f11815f, (double) computeVerticalScrollOffset);
            this.f11807a.f11816g = Math.max(this.f11807a.f11816g, n);
            if (this.f11807a.f11816g == this.f11807a.f11817h.aZ_() - 1 && this.f11807a.f11817h.f11804h) {
                this.f11807a.mo809a(this.f11807a.f11811b);
            }
        }
    }

    /* compiled from: gysj_join */
    public class C12693 implements RetryClickedListener {
        final /* synthetic */ BaseAwesomizerFragment f11808a;

        public C12693(BaseAwesomizerFragment baseAwesomizerFragment) {
            this.f11808a = baseAwesomizerFragment;
        }

        public final void m13891a() {
            this.f11808a.am.a();
            this.f11808a.mo809a(this.f11808a.f11811b);
        }
    }

    /* compiled from: gysj_join */
    public class C12704 extends AbstractDisposableFutureCallback<GraphQLResult<T>> {
        final /* synthetic */ BaseAwesomizerFragment f11809a;

        public C12704(BaseAwesomizerFragment baseAwesomizerFragment) {
            this.f11809a = baseAwesomizerFragment;
        }

        protected final void m13892a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            BaseAwesomizerFragment baseAwesomizerFragment = this.f11809a;
            baseAwesomizerFragment.am.b();
            FeedAwesomizerLogger feedAwesomizerLogger = baseAwesomizerFragment.f11818i;
            feedAwesomizerLogger.f11840f = feedAwesomizerLogger.f11836b.a() - feedAwesomizerLogger.f11841g;
            baseAwesomizerFragment.f11816g = baseAwesomizerFragment.f11813d.n();
            if (graphQLResult == null) {
                this.f11809a.f11810a.setVisibility(0);
                return;
            }
            this.f11809a.f11814e.getLayoutParams().height = -1;
            this.f11809a.mo810a(graphQLResult);
        }

        protected final void m13893a(Throwable th) {
            BaseAwesomizerFragment baseAwesomizerFragment = this.f11809a;
            if (baseAwesomizerFragment.am != null && baseAwesomizerFragment.getContext() != null && baseAwesomizerFragment.getContext().getResources() != null) {
                baseAwesomizerFragment.am.a(baseAwesomizerFragment.getContext().getResources().getString(2131230811), new C12693(baseAwesomizerFragment));
            }
        }
    }

    public static void m13894a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        BaseAwesomizerFragment baseAwesomizerFragment = (BaseAwesomizerFragment) obj;
        FeedAwesomizerLogger b = FeedAwesomizerLogger.m13942b(fbInjector);
        EventsStream a = EventsStream.a(fbInjector);
        baseAwesomizerFragment.f11818i = b;
        baseAwesomizerFragment.al = a;
    }

    protected abstract void mo809a(AbstractDisposableFutureCallback abstractDisposableFutureCallback);

    protected abstract void mo810a(GraphQLResult<T> graphQLResult);

    protected abstract void aq();

    protected abstract AwesomizerCards ar();

    protected abstract int as();

    protected abstract int mo815e();

    protected abstract int mo816g(int i);

    public final View m13898a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 993074430);
        Class cls = BaseAwesomizerFragment.class;
        m13894a((Object) this, getContext());
        this.f11812c = (String) o().getIntent().getExtras().get("session_id");
        this.f11811b = new C12704(this);
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), mo815e())).inflate(2130903333, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 551413671, a);
        return inflate;
    }

    public final void m13899a(View view, Bundle bundle) {
        super.a(view, bundle);
        mo818b(view);
        this.am = (LoadingIndicatorView) e(2131559785);
        this.f11814e = (RecyclerView) e(2131559740);
        this.f11813d = new GridLayoutManager(getContext(), 3);
        this.f11810a = (FbTextView) e(2131559786);
        this.am.k = 0;
        this.am.a();
        this.f11813d.h = new C12671(this);
        this.f11814e.setLayoutManager(this.f11813d);
        this.f11814e.getLayoutParams().height = (int) jW_().getDimension(2131430785);
        this.f11814e.setOnScrollListener(new C12682(this));
        this.f11814e.v = true;
        aq();
        this.f11817h.f11798a = this.f11818i;
        FeedAwesomizerLogger feedAwesomizerLogger = this.f11818i;
        feedAwesomizerLogger.f11841g = feedAwesomizerLogger.f11836b.a();
        mo809a(this.f11811b);
    }

    public final void m13896H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -822347112);
        super.H();
        this.f11818i.m13945d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1778139186, a);
    }

    public final void m13895G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 594577935);
        super.G();
        this.f11818i.m13946e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 538395484, a);
    }

    public final void m13897I() {
        Object obj;
        boolean z;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1720785855);
        super.I();
        this.f11818i.m13944a(ar(), this.f11815f, this.f11817h.aZ_() - 1, this.f11816g, this.f11812c);
        EventsStream eventsStream = this.al;
        int as = as();
        FeedAwesomizerLogger feedAwesomizerLogger = this.f11818i;
        if (feedAwesomizerLogger.f11846l >= 10000) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null && feedAwesomizerLogger.f11849o.isEmpty() && feedAwesomizerLogger.f11850p.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        eventsStream.a(new CardClosedEvent(as, z, this.f11818i.m13947g()));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -275951591, a);
    }

    protected void mo818b(View view) {
        Theme theme = view.getContext().getTheme();
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(2130773488, typedValue, true);
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(typedValue.resourceId);
            hasTitleBar.c(true);
        }
    }

    protected int mo814b() {
        if (this.f11817h.f11803g == null) {
            return 99;
        }
        BaseAwesomizerAdapter baseAwesomizerAdapter = this.f11817h;
        return Math.min(99, (baseAwesomizerAdapter.f11805i - baseAwesomizerAdapter.aZ_()) + 1);
    }
}
