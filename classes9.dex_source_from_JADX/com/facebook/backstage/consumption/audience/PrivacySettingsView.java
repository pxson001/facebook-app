package com.facebook.backstage.consumption.audience;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.consumption.BackstageNavigatorApi;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.backstage.consumption.SimpleAnimationHelper;
import com.facebook.backstage.consumption.SimpleAnimationHelper.AnimationType;
import com.facebook.backstage.consumption.audience.AudienceControlDataProvider.C04642;
import com.facebook.backstage.consumption.audience.AudienceControlDataProvider.CallBack;
import com.facebook.backstage.data.AudienceControlData;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: rpc_server */
public class PrivacySettingsView extends LinearLayout {
    @Inject
    PrivacySettingsRecyclerAdapter f4693a;
    @Inject
    AudienceControlDataProvider f4694b;
    @Inject
    BackstageAnalyticsLogger f4695c;
    public final CallBack f4696d;
    public final SwipeRefreshLayout f4697e;
    private final RecyclerView f4698f;
    public final GridLayoutManager f4699g;
    private final BackstageNavigatorApi f4700h;
    private final SimpleAnimationHelper f4701i;

    /* compiled from: rpc_server */
    class C04711 implements CallBack {
        final /* synthetic */ PrivacySettingsView f4687a;

        /* compiled from: rpc_server */
        class C04701 implements Runnable {
            final /* synthetic */ C04711 f4686a;

            C04701(C04711 c04711) {
                this.f4686a = c04711;
            }

            public void run() {
                this.f4686a.f4687a.f4697e.setRefreshing(false);
            }
        }

        C04711(PrivacySettingsView privacySettingsView) {
            this.f4687a = privacySettingsView;
        }

        public final void mo156a(ImmutableList<AudienceControlData> immutableList, Set<String> set) {
            this.f4687a.f4693a.m4579a((ImmutableList) immutableList, (Set) set);
            this.f4687a.f4697e.post(new C04701(this));
        }

        public final void mo155a() {
            this.f4687a.f4697e.setRefreshing(false);
            this.f4687a.m4597b();
        }
    }

    /* compiled from: rpc_server */
    class C04722 implements OnRefreshListener {
        final /* synthetic */ PrivacySettingsView f4688a;

        C04722(PrivacySettingsView privacySettingsView) {
            this.f4688a = privacySettingsView;
        }

        public final void m4585a() {
            this.f4688a.f4697e.setRefreshing(true);
            this.f4688a.f4694b.m4571a(this.f4688a.f4696d, true);
        }
    }

    /* compiled from: rpc_server */
    class C04733 implements OnClickListener {
        final /* synthetic */ PrivacySettingsView f4689a;

        C04733(PrivacySettingsView privacySettingsView) {
            this.f4689a = privacySettingsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -34343488);
            this.f4689a.m4597b();
            Logger.a(2, EntryType.UI_INPUT_END, 1160566834, a);
        }
    }

    /* compiled from: rpc_server */
    class C04744 extends SpanSizeLookup {
        final /* synthetic */ PrivacySettingsView f4690b;

        C04744(PrivacySettingsView privacySettingsView) {
            this.f4690b = privacySettingsView;
        }

        public final int m4586a(int i) {
            return PrivacySettingsRecyclerAdapter.m4574e(i, this.f4690b.f4699g.c);
        }
    }

    /* compiled from: rpc_server */
    class C04755 implements Runnable {
        final /* synthetic */ PrivacySettingsView f4691a;

        C04755(PrivacySettingsView privacySettingsView) {
            this.f4691a = privacySettingsView;
        }

        public void run() {
            this.f4691a.f4697e.setRefreshing(true);
        }
    }

    /* compiled from: rpc_server */
    class C04766 implements DialogInterface.OnClickListener {
        final /* synthetic */ PrivacySettingsView f4692a;

        C04766(PrivacySettingsView privacySettingsView) {
            this.f4692a = privacySettingsView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4692a.f4699g;
        }
    }

    /* compiled from: rpc_server */
    final class C04777 implements DialogInterface.OnClickListener {
        C04777() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private static <T extends View> void m4590a(Class<T> cls, T t) {
        m4591a((Object) t, t.getContext());
    }

    private static void m4591a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PrivacySettingsView privacySettingsView = (PrivacySettingsView) obj;
        PrivacySettingsRecyclerAdapter privacySettingsRecyclerAdapter = new PrivacySettingsRecyclerAdapter((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), BackstageAnalyticsLogger.m4259a(injectorLike));
        privacySettingsRecyclerAdapter.f4680d = BackstageAnalyticsLogger.m4259a(injectorLike);
        privacySettingsView.m4589a(privacySettingsRecyclerAdapter, AudienceControlDataProvider.m4568a(injectorLike), BackstageAnalyticsLogger.m4259a(injectorLike));
    }

    private void m4589a(PrivacySettingsRecyclerAdapter privacySettingsRecyclerAdapter, AudienceControlDataProvider audienceControlDataProvider, BackstageAnalyticsLogger backstageAnalyticsLogger) {
        this.f4693a = privacySettingsRecyclerAdapter;
        this.f4694b = audienceControlDataProvider;
        this.f4695c = backstageAnalyticsLogger;
    }

    public PrivacySettingsView(Context context) {
        this(context, null);
    }

    public PrivacySettingsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrivacySettingsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4696d = new C04711(this);
        this.f4700h = BackstageNavigatorApi.m4489a();
        this.f4701i = new SimpleAnimationHelper(this, null);
        m4590a(PrivacySettingsView.class, (View) this);
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(2130904778, this);
        this.f4697e = (SwipeRefreshLayout) inflate.findViewById(2131562882);
        this.f4697e.e = new C04722(this);
        this.f4698f = (RecyclerView) inflate.findViewById(2131559740);
        this.f4699g = new GridLayoutManager(getContext(), 3);
        ((FbTextView) inflate.findViewById(2131563075)).setText(getResources().getString(2131239937));
        ((FbTextView) inflate.findViewById(2131563076)).setVisibility(4);
        FbTextView fbTextView = (FbTextView) inflate.findViewById(2131563074);
        fbTextView.setText(2131239938);
        fbTextView.setVisibility(0);
        fbTextView.setOnClickListener(new C04733(this));
        setClickable(true);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1296003040);
        super.onFinishInflate();
        this.f4698f.setLayoutManager(this.f4699g);
        this.f4698f.setAdapter(this.f4693a);
        this.f4699g.h = new C04744(this);
        this.f4698f.v = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1441002412, a);
    }

    public final void m4596a() {
        this.f4697e.post(new C04755(this));
        this.f4694b.m4571a(this.f4696d, true);
        this.f4701i.m4560a(AnimationType.SLIDE_FROM_RIGHT);
        this.f4695c.m4264a(Event.AUDIENCE_SELECTION_STARTED);
    }

    public final boolean m4597b() {
        Object obj;
        PrivacySettingsRecyclerAdapter privacySettingsRecyclerAdapter = this.f4693a;
        if (privacySettingsRecyclerAdapter.f4682g.isEmpty() && privacySettingsRecyclerAdapter.f4683h.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            if (this.f4693a.m4582h() >= 5) {
                this.f4699g;
                return true;
            }
            m4588a(getContext(), this.f4693a.m4582h(), new C04766(this));
            return true;
        } else if (!this.f4701i.m4561a()) {
            return false;
        } else {
            this.f4700h.m4492a(NavigationState.AUDIENCE_CONTROL, NavigationState.MAIN_LIST);
            this.f4701i.m4562b(AnimationType.SLIDE_FROM_RIGHT);
            this.f4693a.m4579a(null, null);
            this.f4695c.m4264a(Event.AUDIENCE_SELECTION_FINISHED);
            return true;
        }
    }

    public static void m4594c(PrivacySettingsView privacySettingsView) {
        privacySettingsView.f4697e.setRefreshing(true);
        AudienceControlDataProvider audienceControlDataProvider = privacySettingsView.f4694b;
        PrivacySettingsRecyclerAdapter privacySettingsRecyclerAdapter = privacySettingsView.f4693a;
        List arrayList = new ArrayList(privacySettingsRecyclerAdapter.f4682g.size());
        arrayList.addAll(privacySettingsRecyclerAdapter.f4682g);
        privacySettingsRecyclerAdapter.f4682g.clear();
        List list = arrayList;
        PrivacySettingsRecyclerAdapter privacySettingsRecyclerAdapter2 = privacySettingsView.f4693a;
        arrayList = new ArrayList(privacySettingsRecyclerAdapter2.f4683h.size());
        arrayList.addAll(privacySettingsRecyclerAdapter2.f4683h);
        privacySettingsRecyclerAdapter2.f4683h.clear();
        audienceControlDataProvider.f4662b.m4963a(list, arrayList, new C04642(audienceControlDataProvider, privacySettingsView.f4696d));
    }

    private static void m4588a(Context context, int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog a = new Builder(context).a();
        a.a(context.getResources().getQuantityString(2131689753, i, new Object[]{Integer.valueOf(i)}));
        a.a(-1, context.getResources().getString(2131239946), onClickListener);
        a.a(-2, context.getResources().getString(2131239947), new C04777());
        a.show();
    }
}
