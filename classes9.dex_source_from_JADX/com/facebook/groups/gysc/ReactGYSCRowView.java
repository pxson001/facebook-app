package com.facebook.groups.gysc;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.facebook.groups.gysc.controller.GYSCDataFetcher;
import com.facebook.groups.gysc.controller.GYSCHscrollViewAdapter;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import javax.inject.Inject;

/* compiled from: payments_add_card_done_button_click */
public class ReactGYSCRowView extends BetterRecyclerView {
    @Inject
    public GYSCDataFetcher f6926l;
    @Inject
    public GYSCHscrollViewAdapter f6927m;
    public AdapterDataObserver f6928n;
    public LinearLayoutManager f6929o = new LinearLayoutManager(getContext());
    public boolean f6930p;

    /* compiled from: payments_add_card_done_button_click */
    public class C07231 extends AdapterDataObserver {
        final /* synthetic */ ReactGYSCRowView f6925a;

        public C07231(ReactGYSCRowView reactGYSCRowView) {
            this.f6925a = reactGYSCRowView;
        }

        public final void bb_() {
            super.bb_();
            this.f6925a.scrollBy(0, 0);
        }
    }

    public static void m7210a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ReactGYSCRowView reactGYSCRowView = (ReactGYSCRowView) obj;
        GYSCDataFetcher b = GYSCDataFetcher.m7213b(fbInjector);
        GYSCHscrollViewAdapter b2 = GYSCHscrollViewAdapter.m7217b(fbInjector);
        reactGYSCRowView.f6926l = b;
        reactGYSCRowView.f6927m = b2;
    }

    public ReactGYSCRowView(Context context) {
        super(context);
        Class cls = ReactGYSCRowView.class;
        m7210a(this, getContext());
        this.f6929o.b(0);
        setLayoutManager(this.f6929o);
        this.d.g = false;
        this.f6928n = new C07231(this);
        this.f6930p = false;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 841409945);
        super.onAttachedToWindow();
        this.f6927m.a(this.f6928n);
        setAdapter(this.f6927m);
        if (!this.f6930p) {
            this.f6926l.m7214a(this.f6927m);
            this.f6930p = true;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 442522191, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1812807465);
        super.onDetachedFromWindow();
        this.f6927m.b(this.f6928n);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1578728705, a);
    }
}
