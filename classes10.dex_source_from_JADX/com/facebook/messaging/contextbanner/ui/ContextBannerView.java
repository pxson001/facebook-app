package com.facebook.messaging.contextbanner.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.internal.widget.ViewStubCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.threadview.MessageListAdapter.C10763;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.tiles.ThreadTileView;
import com.facebook.widget.tiles.ThreadTileViewData;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: state_event_ticketing_model */
public class ContextBannerView extends CustomLinearLayout {
    @Inject
    public AnalyticsLogger f2232a;
    @Nullable
    @Inject
    public ContextBannerAccessoryManager f2233b;
    public final Listener f2234c = new C03691(this);
    public C10763 f2235d;
    public ThreadTileView f2236e;
    public TextView f2237f;
    public TextView f2238g;
    public ViewStubHolder<TextView> f2239h;
    public ViewStubHolder<TextView> f2240i;
    public ViewStubHolder<ViewGroup> f2241j;
    public DefaultThreadViewTheme f2242k;

    /* compiled from: state_event_ticketing_model */
    class C03691 implements Listener {
        final /* synthetic */ ContextBannerView f2230a;

        C03691(ContextBannerView contextBannerView) {
            this.f2230a = contextBannerView;
        }

        public final void m2105a() {
            ContextBannerView.m2109c(this.f2230a);
        }
    }

    /* compiled from: state_event_ticketing_model */
    public class C03702 implements OnClickListener {
        final /* synthetic */ ContextBannerView f2231a;

        public C03702(ContextBannerView contextBannerView) {
            this.f2231a = contextBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1481904397);
            if (this.f2231a.f2235d != null) {
                C10763 c10763 = this.f2231a.f2235d;
                if (c10763.f7167a.f7175A != null) {
                    c10763.f7167a.f7175A.mo305g();
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 833717783, a);
        }
    }

    public static void m2108a(Object obj, Context context) {
        ContextBannerView contextBannerView = (ContextBannerView) obj;
        ContextBannerAccessoryManager contextBannerAccessoryManager = (ContextBannerAccessoryManager) null;
        contextBannerView.f2232a = AnalyticsLoggerMethodAutoProvider.a(FbInjector.get(context));
        contextBannerView.f2233b = contextBannerAccessoryManager;
    }

    public ContextBannerView(Context context) {
        super(context);
        Class cls = ContextBannerView.class;
        m2108a((Object) this, getContext());
        setContentView(2130906427);
        setOnClickListener(new C03702(this));
        CustomViewUtils.b(this, getResources().getDrawable(2130838279));
        setVisibility(8);
        this.f2236e = (ThreadTileView) a(2131560123);
        this.f2237f = (TextView) a(2131559636);
        this.f2238g = (TextView) a(2131566336);
        this.f2239h = ViewStubHolder.a((ViewStubCompat) a(2131566337));
        this.f2240i = ViewStubHolder.a((ViewStubCompat) a(2131566339));
        this.f2241j = ViewStubHolder.a((ViewStubCompat) a(2131566341));
    }

    public final void m2110a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i, ThreadTileViewData threadTileViewData, ThreadKey threadKey) {
        if (!Strings.isNullOrEmpty(str)) {
            this.f2237f.setText(str);
        }
        if (!Strings.isNullOrEmpty(str2)) {
            this.f2238g.setText(str2);
            if (i > 0) {
                this.f2238g.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
            } else {
                this.f2238g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        m2107a(this.f2239h, str3);
        m2107a(this.f2240i, str4);
        if (this.f2239h.d()) {
            m2106a(this.f2239h.a(), getResources().getDimensionPixelSize(2131433809));
        }
        if (this.f2240i.d()) {
            m2106a(this.f2240i.a(), getResources().getDimensionPixelSize(2131433810));
        }
        this.f2236e.setThreadTileViewData(threadTileViewData);
        setVisibility(0);
        HoneyClientEventFast a = this.f2232a.a("context_banner_impression", false);
        if (a.a()) {
            a.a("context_banner_impression_thread_key", threadKey.g());
            a.b();
        }
    }

    public static void m2106a(View view, int i) {
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void m2109c(ContextBannerView contextBannerView) {
        int c = contextBannerView.f2242k.c();
        int d = contextBannerView.f2242k.d();
        contextBannerView.f2237f.setTextColor(c);
        contextBannerView.f2238g.setTextColor(c);
        if (contextBannerView.f2239h.c()) {
            ((TextView) contextBannerView.f2239h.a()).setTextColor(d);
        }
        if (contextBannerView.f2240i.c()) {
            ((TextView) contextBannerView.f2240i.a()).setTextColor(d);
        }
    }

    private static void m2107a(ViewStubHolder<TextView> viewStubHolder, String str) {
        viewStubHolder.e();
        if (!Strings.isNullOrEmpty(str)) {
            ((TextView) viewStubHolder.a()).setText(str);
            viewStubHolder.f();
        }
    }
}
