package com.facebook.orca.threadlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.StringRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.AppBarLayout.ScrollingViewBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.Layout;
import android.text.TextUtils;
import android.view.AbsSavedState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.folders.ThreadTypeFilter;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.sms.abtest.ExperimentsForSmsTakeoverAbTestModule;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.abtest.SmsTakeoverMultiverseExperimentHelper;
import com.facebook.messaging.sms.analytics.SmsCallerContext;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.messaging.ui.segmentedtabbar.SegmentedTabBar2;
import com.facebook.messaging.ui.segmentedtabbar.SegmentedTabBar2.Listener;
import com.facebook.messaging.util.BadgeCountUtil;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.threadlist.ThreadListFragment.RefreshType;
import com.facebook.prefs.counters.UiCounters;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.widget.OnDispatchDrawListener;
import com.facebook.widget.ViewStubHolder;
import com.google.common.collect.ImmutableList;
import java.util.EnumMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: nearby_friends_now_nux_back_out */
public class InboxFilterManager {
    public static final Parcelable f6405a = AbsSavedState.EMPTY_STATE;
    private AdapterDataObserver f6406A;
    private OnOffsetChangedListener f6407B;
    public SelfRegistrableReceiverImpl f6408C;
    private SelfRegistrableReceiverImpl f6409D;
    public ThreadTypeFilter f6410E = ThreadTypeFilter.ALL;
    @Nullable
    public ThreadTypeFilter f6411F;
    public final Map<ThreadTypeFilter, Parcelable> f6412G = new EnumMap(ThreadTypeFilter.class);
    public ItemAnimator f6413H;
    public boolean f6414I = true;
    public boolean f6415J = false;
    public long f6416K = 0;
    private boolean f6417L = true;
    public boolean f6418M = false;
    private final Runnable f6419N = new C09601(this);
    private final Context f6420b;
    private final SmsTakeoverMultiverseExperimentHelper f6421c;
    public final SmsIntegrationState f6422d;
    public final SmsDefaultAppManager f6423e;
    private final BaseFbBroadcastManager f6424f;
    private final DataCache f6425g;
    private final NotificationSettingsUtil f6426h;
    private final BadgeCountUtil f6427i;
    private final Handler f6428j;
    private final Handler f6429k;
    public final SmsTakeoverAnalyticsLogger f6430l;
    public final UiCounters f6431m;
    public final Clock f6432n;
    public final FbSharedPreferences f6433o;
    private View f6434p;
    public SegmentedTabBar2 f6435q;
    public RecyclerView f6436r;
    public SwipeRefreshLayout f6437s;
    public AppBarLayout f6438t;
    public ViewStubHolder<View> f6439u;
    public LayoutManager f6440v;
    public final BadgeTextView[] f6441w = new BadgeTextView[3];
    private com.facebook.orca.threadlist.ThreadListFragment.AnonymousClass11 f6442x;
    private Listener f6443y;
    public OnDispatchDrawListener f6444z;

    /* compiled from: nearby_friends_now_nux_back_out */
    public /* synthetic */ class AnonymousClass12 {
        public static final /* synthetic */ int[] f6395a = new int[ThreadTypeFilter.values().length];

        static {
            try {
                f6395a[ThreadTypeFilter.NON_SMS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6395a[ThreadTypeFilter.SMS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6395a[ThreadTypeFilter.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: nearby_friends_now_nux_back_out */
    class C09601 implements Runnable {
        final /* synthetic */ InboxFilterManager f6396a;

        C09601(InboxFilterManager inboxFilterManager) {
            this.f6396a = inboxFilterManager;
        }

        public void run() {
            this.f6396a.f6418M = false;
            InboxFilterManager.m6113s(this.f6396a);
        }
    }

    /* compiled from: nearby_friends_now_nux_back_out */
    class C09612 implements ActionReceiver {
        final /* synthetic */ InboxFilterManager f6397a;

        C09612(InboxFilterManager inboxFilterManager) {
            this.f6397a = inboxFilterManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -124143396);
            InboxFilterManager.m6107h(this.f6397a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1660783001, a);
        }
    }

    /* compiled from: nearby_friends_now_nux_back_out */
    class C09623 implements Listener {
        final /* synthetic */ InboxFilterManager f6398a;

        C09623(InboxFilterManager inboxFilterManager) {
            this.f6398a = inboxFilterManager;
        }

        public final void m6093a(int i) {
            InboxFilterManager.m6102c(this.f6398a, i);
        }
    }

    /* compiled from: nearby_friends_now_nux_back_out */
    class C09634 extends AdapterDataObserver {
        final /* synthetic */ InboxFilterManager f6399a;

        C09634(InboxFilterManager inboxFilterManager) {
            this.f6399a = inboxFilterManager;
        }

        public final void bb_() {
            InboxFilterManager inboxFilterManager = this.f6399a;
            Parcelable parcelable = (Parcelable) inboxFilterManager.f6412G.remove(inboxFilterManager.f6410E);
            if (parcelable != null) {
                if (parcelable.getClass() == InboxFilterManager.f6405a.getClass()) {
                    inboxFilterManager.f6440v.e(0);
                } else {
                    inboxFilterManager.f6440v.a(parcelable);
                }
            }
            if (inboxFilterManager.f6413H != null) {
                if (inboxFilterManager.f6414I) {
                    inboxFilterManager.f6414I = false;
                } else {
                    inboxFilterManager.f6436r.setItemAnimator(inboxFilterManager.f6413H);
                    inboxFilterManager.f6413H = null;
                }
            }
            InboxFilterManager.m6112r(inboxFilterManager);
        }
    }

    /* compiled from: nearby_friends_now_nux_back_out */
    class C09645 implements OnOffsetChangedListener {
        final /* synthetic */ InboxFilterManager f6400a;

        C09645(InboxFilterManager inboxFilterManager) {
            this.f6400a = inboxFilterManager;
        }

        public final void m6094a(AppBarLayout appBarLayout, int i) {
            this.f6400a.f6437s.setEnabled(i == 0);
            if (i == 0 && this.f6400a.f6432n.a() - this.f6400a.f6416K > 3600000) {
                this.f6400a.f6416K = this.f6400a.f6432n.a();
                this.f6400a.f6431m.c("inbox_filter_impression");
            }
        }
    }

    /* compiled from: nearby_friends_now_nux_back_out */
    class C09656 implements ActionReceiver {
        final /* synthetic */ InboxFilterManager f6401a;

        C09656(InboxFilterManager inboxFilterManager) {
            this.f6401a = inboxFilterManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2022598319);
            InboxFilterManager.m6112r(this.f6401a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1846289647, a);
        }
    }

    /* compiled from: nearby_friends_now_nux_back_out */
    class C09667 implements OnDispatchDrawListener {
        final /* synthetic */ InboxFilterManager f6402a;

        C09667(InboxFilterManager inboxFilterManager) {
            this.f6402a = inboxFilterManager;
        }

        public final boolean m6095a() {
            for (TextView textView : this.f6402a.f6441w) {
                Object obj = null;
                Layout layout = textView.getLayout();
                if (layout != null) {
                    int lineCount = layout.getLineCount();
                    if (lineCount > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                        obj = 1;
                    }
                }
                if (obj != null) {
                    LayoutParams layoutParams = textView.getLayoutParams();
                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                        if (layoutParams2.weight != 1.5f) {
                            layoutParams2.weight = 1.5f;
                            textView.setLayoutParams(layoutParams2);
                        }
                    }
                }
            }
            return true;
        }
    }

    /* compiled from: nearby_friends_now_nux_back_out */
    public class C09678 implements OnClickListener {
        final /* synthetic */ InboxFilterManager f6403a;

        public C09678(InboxFilterManager inboxFilterManager) {
            this.f6403a = inboxFilterManager;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -323122414);
            InboxFilterManager inboxFilterManager = this.f6403a;
            inboxFilterManager.f6423e.a(SmsCallerContext.INBOX_FILTER_OPTIN, new Runnable(inboxFilterManager) {
                final /* synthetic */ InboxFilterManager f6394a;

                {
                    this.f6394a = r1;
                }

                public void run() {
                    if (this.f6394a.f6422d.a()) {
                        InboxFilterManager.m6111n(this.f6394a);
                    }
                }
            });
            Logger.a(2, EntryType.UI_INPUT_END, 486518305, a);
        }
    }

    /* compiled from: nearby_friends_now_nux_back_out */
    public class C09689 implements OnClickListener {
        final /* synthetic */ InboxFilterManager f6404a;

        public C09689(InboxFilterManager inboxFilterManager) {
            this.f6404a = inboxFilterManager;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2063312011);
            this.f6404a.f6433o.edit().putBoolean(SmsPrefKeys.I, true).commit();
            InboxFilterManager.m6107h(this.f6404a);
            this.f6404a.f6430l.f();
            Logger.a(2, EntryType.UI_INPUT_END, 992671002, a);
        }
    }

    private static InboxFilterManager m6101b(InjectorLike injectorLike) {
        return new InboxFilterManager((Context) injectorLike.getInstance(Context.class), SmsTakeoverMultiverseExperimentHelper.b(injectorLike), SmsIntegrationState.a(injectorLike), SmsDefaultAppManager.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), DataCache.a(injectorLike), NotificationSettingsUtil.b(injectorLike), BadgeCountUtil.b(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), SmsTakeoverAnalyticsLogger.b(injectorLike), UiCounters.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    public static InboxFilterManager m6098a(InjectorLike injectorLike) {
        return m6101b(injectorLike);
    }

    @Inject
    private InboxFilterManager(Context context, SmsTakeoverMultiverseExperimentHelper smsTakeoverMultiverseExperimentHelper, SmsIntegrationState smsIntegrationState, SmsDefaultAppManager smsDefaultAppManager, BaseFbBroadcastManager baseFbBroadcastManager, DataCache dataCache, NotificationSettingsUtil notificationSettingsUtil, BadgeCountUtil badgeCountUtil, Handler handler, Handler handler2, SmsTakeoverAnalyticsLogger smsTakeoverAnalyticsLogger, UiCounters uiCounters, Clock clock, FbSharedPreferences fbSharedPreferences) {
        this.f6420b = context;
        this.f6421c = smsTakeoverMultiverseExperimentHelper;
        this.f6422d = smsIntegrationState;
        this.f6423e = smsDefaultAppManager;
        this.f6424f = baseFbBroadcastManager;
        this.f6425g = dataCache;
        this.f6426h = notificationSettingsUtil;
        this.f6427i = badgeCountUtil;
        this.f6428j = handler;
        this.f6429k = handler2;
        this.f6430l = smsTakeoverAnalyticsLogger;
        this.f6431m = uiCounters;
        this.f6432n = clock;
        this.f6433o = fbSharedPreferences;
    }

    public final void m6115a(View view, com.facebook.orca.threadlist.ThreadListFragment.AnonymousClass11 anonymousClass11, @Nullable Bundle bundle) {
        this.f6434p = view;
        this.f6442x = anonymousClass11;
        if (bundle != null) {
            this.f6411F = (ThreadTypeFilter) bundle.getSerializable("inbox_filter_selected_filter");
            for (ThreadTypeFilter threadTypeFilter : ThreadTypeFilter.values()) {
                Parcelable parcelable = bundle.getParcelable("inbox_filter_states_" + threadTypeFilter.name());
                if (parcelable != null) {
                    this.f6412G.put(threadTypeFilter, parcelable);
                }
            }
        }
        if (this.f6412G.isEmpty()) {
            for (Object put : ThreadTypeFilter.values()) {
                this.f6412G.put(put, f6405a);
            }
        }
        m6106g();
        m6103d();
    }

    private void m6103d() {
        boolean z = true;
        SmsTakeoverMultiverseExperimentHelper smsTakeoverMultiverseExperimentHelper = this.f6421c;
        boolean z2;
        if (this.f6422d.a()) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z3 = false;
        if (smsTakeoverMultiverseExperimentHelper.b() && smsTakeoverMultiverseExperimentHelper.a.a(ExperimentsForSmsTakeoverAbTestModule.a, false) && (!r0 || smsTakeoverMultiverseExperimentHelper.a.a(ExperimentsForSmsTakeoverAbTestModule.b, false))) {
            z3 = true;
        }
        if (!z3 || this.f6433o.a(SmsPrefKeys.I, false)) {
            z = false;
        }
        if (z != m6104e()) {
            if (z) {
                m6109k();
            } else {
                m6110m();
            }
            m6108j();
        }
    }

    private boolean m6104e() {
        return this.f6435q != null && this.f6435q.getVisibility() == 0;
    }

    public static void m6111n(InboxFilterManager inboxFilterManager) {
        boolean z = inboxFilterManager.f6415J;
        if (inboxFilterManager.f6410E != ThreadTypeFilter.SMS || inboxFilterManager.f6422d.a()) {
            inboxFilterManager.f6437s.setVisibility(0);
            if (inboxFilterManager.f6439u.c()) {
                inboxFilterManager.f6439u.a().setVisibility(8);
            }
            inboxFilterManager.f6415J = false;
        } else {
            if (!inboxFilterManager.f6439u.c()) {
                View a = inboxFilterManager.f6439u.a();
                a.findViewById(2131567503).setOnClickListener(new C09678(inboxFilterManager));
                a = a.findViewById(2131563214);
                a.setVisibility(0);
                a.setOnClickListener(new C09689(inboxFilterManager));
                inboxFilterManager.f6430l.e();
                if (!inboxFilterManager.f6433o.a(SmsPrefKeys.r, false)) {
                    inboxFilterManager.f6433o.edit().putBoolean(SmsPrefKeys.r, true).commit();
                }
            }
            inboxFilterManager.f6438t.setExpanded(true);
            inboxFilterManager.f6439u.a().setVisibility(0);
            inboxFilterManager.f6437s.setVisibility(8);
            inboxFilterManager.f6415J = true;
        }
        inboxFilterManager.m6108j();
        if (z != inboxFilterManager.f6415J) {
            inboxFilterManager.f6424f.a(new Intent(MessagesBroadcastIntents.D));
        }
        if (inboxFilterManager.f6442x != null) {
            com.facebook.orca.threadlist.ThreadListFragment.AnonymousClass11 anonymousClass11 = inboxFilterManager.f6442x;
            anonymousClass11.f6599a.aY.m6418a(anonymousClass11.f6599a.cb.f6410E);
            ThreadListFragment.m6331a(anonymousClass11.f6599a, RefreshType.INBOX_FILTER_CHANGE, "inbox_filter_change");
        }
    }

    private <T extends View> T m6097a(int i) {
        return FindViewUtil.b(this.f6434p, i);
    }

    private void m6105f() {
        SegmentedTabBar2 segmentedTabBar2 = (SegmentedTabBar2) m6097a(2131565192);
        if (segmentedTabBar2 != this.f6435q) {
            this.f6435q = segmentedTabBar2;
            this.f6436r = (RecyclerView) m6097a(2131565196);
            this.f6437s = (SwipeRefreshLayout) m6097a(2131565195);
            this.f6438t = (AppBarLayout) m6097a(2131565191);
            this.f6439u = ViewStubHolder.a((ViewStubCompat) m6097a(2131565193));
            this.f6440v = this.f6436r.getLayoutManager();
            this.f6441w[0] = m6100b(2131231830);
            this.f6441w[1] = m6100b(2131231831);
            this.f6441w[2] = m6100b(2131231832);
            for (View a : this.f6441w) {
                this.f6435q.a(a);
            }
        }
    }

    private BadgeTextView m6100b(@StringRes int i) {
        BadgeTextView badgeTextView = (BadgeTextView) LayoutInflater.from(this.f6420b).inflate(2130904863, this.f6435q.a, false);
        badgeTextView.setText(this.f6420b.getResources().getString(i));
        return badgeTextView;
    }

    private void m6106g() {
        if (this.f6408C == null) {
            this.f6408C = this.f6424f.a().a(MessagesBroadcastIntents.y, new C09612(this)).a();
        }
        this.f6408C.b();
    }

    public static void m6107h(InboxFilterManager inboxFilterManager) {
        inboxFilterManager.m6103d();
        if (inboxFilterManager.m6104e()) {
            m6111n(inboxFilterManager);
        } else {
            m6102c(inboxFilterManager, 0);
        }
    }

    public final void m6114a() {
        if (this.f6408C != null) {
            this.f6408C.c();
            this.f6408C = null;
        }
        m6110m();
        this.f6410E = ThreadTypeFilter.ALL;
    }

    private void m6108j() {
        boolean z = true;
        boolean e = m6104e();
        SwipeRefreshLayout swipeRefreshLayout = this.f6437s;
        boolean z2 = e && !this.f6415J;
        m6099a(swipeRefreshLayout, z2);
        if (this.f6439u != null && this.f6439u.c()) {
            View a = this.f6439u.a();
            if (!(e && this.f6415J)) {
                z = false;
            }
            m6099a(a, z);
        }
    }

    private static void m6099a(View view, boolean z) {
        if (view != null && (view.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            if (z != (layoutParams.a instanceof ScrollingViewBehavior)) {
                layoutParams.a(z ? new ScrollingViewBehavior() : null);
            }
        }
    }

    private void m6109k() {
        int i;
        boolean z;
        m6105f();
        if (this.f6443y == null) {
            this.f6443y = new C09623(this);
        }
        if (this.f6406A == null) {
            this.f6406A = new C09634(this);
        }
        if (this.f6407B == null) {
            this.f6407B = new C09645(this);
        }
        if (this.f6409D == null) {
            this.f6409D = this.f6424f.a().a(MessagesBroadcastIntents.o, new C09656(this)).a();
        }
        if (this.f6444z == null) {
            this.f6444z = new C09667(this);
        }
        this.f6435q.d = this.f6443y;
        this.f6435q.a(this.f6444z);
        this.f6436r.o.a(this.f6406A);
        this.f6438t.a(this.f6407B);
        this.f6408C.b();
        this.f6409D.b();
        this.f6435q.setVisibility(0);
        ThreadTypeFilter threadTypeFilter = this.f6411F != null ? this.f6411F : this.f6410E;
        SegmentedTabBar2 segmentedTabBar2 = this.f6435q;
        switch (AnonymousClass12.f6395a[threadTypeFilter.ordinal()]) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            default:
                i = 0;
                break;
        }
        segmentedTabBar2.a(i);
        this.f6411F = null;
        AppBarLayout appBarLayout = this.f6438t;
        if (this.f6410E != ThreadTypeFilter.ALL) {
            z = true;
        } else {
            z = false;
        }
        appBarLayout.setExpanded(z);
    }

    private void m6110m() {
        if (this.f6443y != null) {
            if (this.f6435q != null) {
                this.f6435q.setListener(null);
            }
            this.f6443y = null;
        }
        if (this.f6406A != null) {
            if (this.f6436r != null) {
                try {
                    this.f6436r.getAdapter().b(this.f6406A);
                } catch (IllegalStateException e) {
                }
            }
            this.f6406A = null;
        }
        if (this.f6407B != null) {
            if (this.f6438t != null) {
                this.f6438t.b(this.f6407B);
            }
            this.f6407B = null;
        }
        if (this.f6409D != null) {
            this.f6409D.c();
            this.f6409D = null;
        }
        if (this.f6444z != null) {
            if (this.f6435q != null) {
                this.f6435q.b(this.f6444z);
            }
            this.f6444z = null;
        }
        if (this.f6413H != null) {
            if (this.f6436r != null) {
                this.f6436r.setItemAnimator(this.f6413H);
            }
            this.f6413H = null;
            this.f6414I = false;
        }
        if (this.f6437s != null) {
            this.f6437s.setEnabled(true);
        }
        if (this.f6435q != null) {
            this.f6435q.setVisibility(8);
        }
    }

    public static void m6102c(InboxFilterManager inboxFilterManager, int i) {
        ThreadTypeFilter threadTypeFilter;
        int i2 = 1;
        switch (i) {
            case 1:
                threadTypeFilter = ThreadTypeFilter.NON_SMS;
                break;
            case 2:
                threadTypeFilter = ThreadTypeFilter.SMS;
                break;
            default:
                threadTypeFilter = ThreadTypeFilter.ALL;
                break;
        }
        ThreadTypeFilter threadTypeFilter2 = threadTypeFilter;
        if (threadTypeFilter2 != inboxFilterManager.f6410E) {
            inboxFilterManager.f6430l.a(inboxFilterManager.f6410E.name(), threadTypeFilter2.name());
            inboxFilterManager.f6412G.put(inboxFilterManager.f6410E, inboxFilterManager.f6440v.f());
            inboxFilterManager.f6410E = threadTypeFilter2;
            if (inboxFilterManager.f6413H == null) {
                inboxFilterManager.f6413H = inboxFilterManager.f6436r.d;
                inboxFilterManager.f6436r.setItemAnimator(null);
            }
            inboxFilterManager.f6414I = true;
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) inboxFilterManager.f6435q.getLayoutParams();
            if (inboxFilterManager.f6410E != ThreadTypeFilter.ALL) {
                i2 = 5;
            }
            layoutParams.a = i2;
            inboxFilterManager.f6435q.setLayoutParams(layoutParams);
            m6111n(inboxFilterManager);
        }
    }

    public static void m6112r(InboxFilterManager inboxFilterManager) {
        if (!inboxFilterManager.f6418M) {
            inboxFilterManager.f6418M = true;
            long j = inboxFilterManager.f6417L ? 0 : 1000;
            inboxFilterManager.f6417L = false;
            HandlerDetour.b(inboxFilterManager.f6428j, inboxFilterManager.f6419N, j, -828426964);
        }
    }

    public static void m6113s(InboxFilterManager inboxFilterManager) {
        if (inboxFilterManager.f6441w[1] != null && inboxFilterManager.f6441w[2] != null) {
            ThreadsCollection b = inboxFilterManager.f6425g.b(FolderName.INBOX, ThreadTypeFilter.NON_SMS);
            ThreadsCollection b2 = inboxFilterManager.f6425g.b(FolderName.INBOX, ThreadTypeFilter.SMS);
            final CharSequence a = inboxFilterManager.f6427i.a(inboxFilterManager.m6096a(b));
            final CharSequence a2 = inboxFilterManager.f6427i.a(inboxFilterManager.m6096a(b2));
            HandlerDetour.a(inboxFilterManager.f6429k, new Runnable(inboxFilterManager) {
                final /* synthetic */ InboxFilterManager f6393c;

                public void run() {
                    int i = 1;
                    int i2 = 0;
                    if (!TextUtils.equals(this.f6393c.f6441w[1].h, a)) {
                        this.f6393c.f6441w[1].setBadgeText(a);
                        i2 = 1;
                    }
                    if (TextUtils.equals(this.f6393c.f6441w[2].h, a2)) {
                        i = i2;
                    } else {
                        this.f6393c.f6441w[2].setBadgeText(a2);
                    }
                    if (i != 0 && this.f6393c.f6444z != null) {
                        this.f6393c.f6435q.a(this.f6393c.f6444z);
                    }
                }
            }, 1390610981);
        }
    }

    private int m6096a(ThreadsCollection threadsCollection) {
        ImmutableList immutableList = threadsCollection.c;
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < size) {
            ThreadSummary threadSummary = (ThreadSummary) immutableList.get(i);
            i2++;
            if (i2 > 20) {
                break;
            }
            int i4;
            if (threadSummary.f()) {
                Object obj;
                if (this.f6426h.a(threadSummary.a).b()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    i4 = i3 + 1;
                    i++;
                    i3 = i4;
                }
            }
            i4 = i3;
            i++;
            i3 = i4;
        }
        return i3;
    }
}
