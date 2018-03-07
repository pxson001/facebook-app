package com.facebook.growth.friendfinder;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.growth.contactimporter.PhonebookLookupResultContact;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.hardware.StrictPhoneIsoCountryCode;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.userinteraction.UserInteractionListener;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.friends.navigator.FriendingNavigatorGatekeepers;
import com.facebook.friends.navigator.NavigationEventBus;
import com.facebook.friends.navigator.NavigationEvents.FriendableContactsFetchedEvent;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.contactimporter.StepInviteActivity;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger.ApiType;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger.EventType;
import com.facebook.growth.nux.UserAccountNUXActivity;
import com.facebook.growth.nux.abtest.ExperimentsForGrowthModule;
import com.facebook.growth.protocol.FriendFinderMethod;
import com.facebook.growth.protocol.FriendFinderMethod.Params;
import com.facebook.growth.protocol.FriendFinderMethod.Result.Invites;
import com.facebook.growth.protocol.FriendFinderPYMKMethod;
import com.facebook.growth.protocol.FriendFinderPYMKMethod.Result;
import com.facebook.growth.util.PhonebookUtils;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.ipc.model.FacebookPhonebookContact;
import com.facebook.ipc.model.FacebookPhonebookContactMap;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.status.NuxStepListener;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.keyboard.SmoothKeyboardFragmentBehavior;
import com.facebook.ui.search.SearchEditText;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.BetterListView.OnTouchDownListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: payload_json */
public class FriendFinderAddFriendsFragment extends FbFragment implements AnalyticsFragment {
    public static final Class<?> aq;
    private static final CallerContext ar;
    @Inject
    FriendFinderAddFriendsAdapterProvider f7184a;
    public Set<String> aA;
    private List<FriendFinderFriendCandidate> aB;
    private UserInteractionListener aC;
    public List<FacebookPhonebookContact> aD;
    private String aE;
    private int aF;
    public CIFlow aG;
    public String aH;
    public long aI;
    private boolean aJ;
    public int aK;
    private boolean aL = false;
    public Map<Long, FacebookPhonebookContact> aM;
    public Map<Long, FacebookPhonebookContact> aN;
    @Inject
    DefaultUserInteractionController al;
    @Inject
    PerformanceLogger am;
    @Inject
    @StrictPhoneIsoCountryCode
    Provider<String> an;
    @Inject
    public QeAccessor ao;
    @Inject
    NavigationEventBus ap;
    public View as;
    private ProgressBar at;
    private TextView au;
    public View av;
    public SearchEditText aw;
    private TextView ax;
    private LoadingIndicatorView ay;
    public FriendFinderAddFriendsAdapter az;
    @Inject
    FriendFinderPreferenceSetter f7185b;
    @Inject
    PhonebookUtils f7186c;
    @Inject
    DefaultBlueServiceOperationFactory f7187d;
    @Inject
    DefaultAndroidThreadUtil f7188e;
    @Inject
    TasksManager f7189f;
    @Inject
    public SecureContextHelper f7190g;
    @Inject
    FriendFinderAnalyticsLogger f7191h;
    @Inject
    GatekeeperStoreImpl f7192i;

    /* compiled from: payload_json */
    class C07611 implements UserInteractionListener {
        final /* synthetic */ FriendFinderAddFriendsFragment f7173a;

        C07611(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
            this.f7173a = friendFinderAddFriendsFragment;
        }

        public final void m7440a(boolean z) {
            if (!z && this.f7173a.az != null) {
                FriendFinderAddFriendsFragment.at(this.f7173a);
            }
        }
    }

    /* compiled from: payload_json */
    class C07622 implements OnTouchDownListener {
        final /* synthetic */ FriendFinderAddFriendsFragment f7174a;

        C07622(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
            this.f7174a = friendFinderAddFriendsFragment;
        }

        public final void m7441a() {
            this.f7174a.aw.c();
        }
    }

    /* compiled from: payload_json */
    class C07633 implements Runnable {
        final /* synthetic */ FriendFinderAddFriendsFragment f7175a;

        C07633(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
            this.f7175a = friendFinderAddFriendsFragment;
        }

        public void run() {
            FriendFinderAddFriendsFragment.aA(this.f7175a);
        }
    }

    /* compiled from: payload_json */
    public class C07644 implements TextWatcher {
        final /* synthetic */ FriendFinderAddFriendsFragment f7176a;

        public C07644(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
            this.f7176a = friendFinderAddFriendsFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f7176a.az.getFilter().filter(editable);
        }
    }

    /* compiled from: payload_json */
    public class C07655 implements OnScrollListener {
        final /* synthetic */ FriendFinderAddFriendsFragment f7177a;

        public C07655(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
            this.f7177a = friendFinderAddFriendsFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.f7177a.aK = Math.max(this.f7177a.aK, (i + i2) - 1);
        }
    }

    /* compiled from: payload_json */
    class C07666 implements AnimationListener {
        final /* synthetic */ FriendFinderAddFriendsFragment f7178a;

        C07666(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
            this.f7178a = friendFinderAddFriendsFragment;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f7178a.as.setVisibility(8);
            this.f7178a.av.setVisibility(0);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: payload_json */
    class C07677 implements Runnable {
        final /* synthetic */ FriendFinderAddFriendsFragment f7179a;

        C07677(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
            this.f7179a = friendFinderAddFriendsFragment;
        }

        public void run() {
            this.f7179a.m7463e();
        }
    }

    /* compiled from: payload_json */
    class C07699 extends OperationResultFutureCallback {
        final /* synthetic */ FriendFinderAddFriendsFragment f7182a;

        C07699(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
            this.f7182a = friendFinderAddFriendsFragment;
        }

        protected final void m7445a(Object obj) {
            Result result;
            OperationResult operationResult = (OperationResult) obj;
            FriendFinderAddFriendsFragment friendFinderAddFriendsFragment = this.f7182a;
            if (operationResult == null) {
                result = null;
            } else {
                result = (Result) operationResult.h();
            }
            if (result != null) {
                List<PhonebookLookupResultContact> a = result.m7817a();
                if (!a.isEmpty()) {
                    List a2 = Lists.a();
                    for (PhonebookLookupResultContact phonebookLookupResultContact : a) {
                        a2.add(FriendFinderFriendCandidate.m7466b(phonebookLookupResultContact));
                        friendFinderAddFriendsFragment.aA.add(Long.toString(phonebookLookupResultContact.userId));
                    }
                    friendFinderAddFriendsFragment.az.m7434b(a2);
                }
            }
            FriendFinderAddFriendsFragment.m7450a(this.f7182a, false);
        }

        protected final void m7444a(ServiceException serviceException) {
            BLog.b(FriendFinderAddFriendsFragment.aq, "Error while fetching PYMK", serviceException);
            FriendFinderAddFriendsFragment.m7450a(this.f7182a, false);
        }
    }

    /* compiled from: payload_json */
    class GetPhoneBookTask extends FbAsyncTask<Void, Void, List<FacebookPhonebookContact>> {
        final /* synthetic */ FriendFinderAddFriendsFragment f7183a;

        public GetPhoneBookTask(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
            this.f7183a = friendFinderAddFriendsFragment;
        }

        protected void onPostExecute(Object obj) {
            List<FacebookPhonebookContact> list = (List) obj;
            this.f7183a.f7191h.a(this.f7183a.aG.value, SystemClock.uptimeMillis() - this.f7183a.aI, list.size(), 50, 10, this.f7183a.aH);
            this.f7183a.aD = list;
            for (FacebookPhonebookContact facebookPhonebookContact : list) {
                this.f7183a.aM.put(Long.valueOf(facebookPhonebookContact.recordId), facebookPhonebookContact);
            }
            FriendFinderAddFriendsFragment.m7455i(this.f7183a, 0);
        }

        protected final Object m7446a(Object[] objArr) {
            return this.f7183a.f7186c.a();
        }
    }

    public static void m7451a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FriendFinderAddFriendsFragment) obj).m7448a((FriendFinderAddFriendsAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendFinderAddFriendsAdapterProvider.class), FriendFinderPreferenceSetter.m7544b(injectorLike), PhonebookUtils.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), TasksManager.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), FriendFinderAnalyticsLogger.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), DefaultUserInteractionController.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 4447), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), NavigationEventBus.a(injectorLike));
    }

    private void m7448a(FriendFinderAddFriendsAdapterProvider friendFinderAddFriendsAdapterProvider, FriendFinderPreferenceSetter friendFinderPreferenceSetter, PhonebookUtils phonebookUtils, BlueServiceOperationFactory blueServiceOperationFactory, AndroidThreadUtil androidThreadUtil, TasksManager tasksManager, SecureContextHelper secureContextHelper, FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, GatekeeperStore gatekeeperStore, UserInteractionController userInteractionController, PerformanceLogger performanceLogger, Provider<String> provider, QeAccessor qeAccessor, NavigationEventBus navigationEventBus) {
        this.f7184a = friendFinderAddFriendsAdapterProvider;
        this.f7185b = friendFinderPreferenceSetter;
        this.f7186c = phonebookUtils;
        this.f7187d = blueServiceOperationFactory;
        this.f7188e = androidThreadUtil;
        this.f7189f = tasksManager;
        this.f7190g = secureContextHelper;
        this.f7191h = friendFinderAnalyticsLogger;
        this.f7192i = gatekeeperStore;
        this.al = userInteractionController;
        this.am = performanceLogger;
        this.an = provider;
        this.ao = qeAccessor;
        this.ap = navigationEventBus;
    }

    static {
        Class cls = FriendFinderAddFriendsFragment.class;
        aq = cls;
        ar = CallerContext.a(cls, "friend_finder_add_friends_fragment");
    }

    public final void m7462c(@Nullable Bundle bundle) {
        CIFlow cIFlow;
        super.c(bundle);
        a(new SmoothKeyboardFragmentBehavior());
        Class cls = FriendFinderAddFriendsFragment.class;
        m7451a((Object) this, getContext());
        this.aA = Sets.c();
        this.aB = Lists.a();
        this.aC = new C07611(this);
        this.al.a(this.aC);
        this.aD = Lists.a();
        this.aE = (String) this.an.get();
        this.aF = jW_().getDimensionPixelSize(2131430844);
        if (this.s == null) {
            cIFlow = CIFlow.UNKNOWN;
        } else {
            cIFlow = (CIFlow) this.s.getSerializable("ci_flow");
        }
        this.aG = cIFlow;
        this.aH = SafeUUIDGenerator.a().toString();
        this.aI = SystemClock.uptimeMillis();
        this.aJ = false;
        this.aK = 0;
        this.aM = Maps.c();
        this.aN = Maps.d();
        PerformanceLogger performanceLogger = this.am;
        MarkerConfig b = new MarkerConfig(4128769, "FriendFinderAddFriendsTTI").a(new String[]{am_()}).b();
        b.n = true;
        performanceLogger.a(b, true);
        FriendFinderAnalyticsLogger friendFinderAnalyticsLogger = this.f7191h;
        String str = this.aG.value;
        friendFinderAnalyticsLogger.a.c(FriendFinderAnalyticsLogger.b(EventType.OPENED.getEventName()).b("api", ApiType.FRIEND_FINDER_API.getApiName()).b("ci_flow", str).a("batch_size", 50).a("pagination_size", 10).b("session_id", this.aH));
        friendFinderAnalyticsLogger.b.b(FunnelRegistry.c, EventType.OPENED.getEventName());
    }

    public final View m7459a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -957253104);
        View inflate = layoutInflater.inflate(2130904470, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 25351464, a);
        return inflate;
    }

    public final void m7461a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.as = e(2131562242);
        this.as.setVisibility(0);
        this.at = (ProgressBar) e(2131562243);
        this.at.setMax(5000);
        this.au = (TextView) e(2131562244);
        this.av = e(2131562246);
        this.ax = (TextView) e(2131562248);
        this.ay = (LoadingIndicatorView) e(2131562249);
        this.ay.a();
        this.aw = (SearchEditText) e(2131562247);
        this.aw.addTextChangedListener(new C07644(this));
        this.f7185b.m7549b(this.f7185b.m7550c());
        this.au.setText(2131236426);
        if (this.az == null) {
            this.az = this.f7184a.m7438a(getContext());
            new GetPhoneBookTask(this).a(o().getApplicationContext(), new Void[0]);
        }
        BetterListView betterListView = (BetterListView) e(16908298);
        betterListView.setEmptyView(e(16908292));
        betterListView.setAdapter(this.az);
        betterListView.setStickyHeaderEnabled(true);
        betterListView.setOnScrollListener(new C07655(this));
        betterListView.y = new C07622(this);
    }

    public final void m7460a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 0) {
            FragmentActivity o = o();
            if (o instanceof FriendFinderHostingActivity) {
                ((FriendFinderHostingActivity) o).m7498b(-1);
            } else if (o instanceof UserAccountNUXActivity) {
                ((NuxStepListener) o).b("contact_importer");
            }
        }
    }

    public final void m7456G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1631174960);
        super.G();
        this.aL = true;
        az();
        long j = -1;
        if (this.aG == CIFlow.NEW_ACCOUNT_NUX) {
            int a2 = this.ao.a(ExperimentsForGrowthModule.f7435a, -1);
            if (a2 >= 0) {
                j = TimeUnit.SECONDS.toMillis((long) a2) - (SystemClock.uptimeMillis() - this.aI);
                if (j <= 0) {
                    j = 0;
                }
            }
        }
        long j2 = j;
        if (this.aJ || j2 == 0) {
            aA(this);
        } else if (j2 > 0) {
            this.f7188e.b(new C07633(this), j2);
        }
        LogUtils.f(1530792765, a);
    }

    public final void m7457H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2044486854);
        this.aw.c();
        this.aL = false;
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -23827511, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1279092267);
        if (!this.aA.isEmpty() || this.aJ) {
            FriendFinderAnalyticsLogger friendFinderAnalyticsLogger = this.f7191h;
            String str = this.aG.value;
            int a2 = this.az.m7427a(this.aK);
            FriendFinderAddFriendsAdapter friendFinderAddFriendsAdapter = this.az;
            friendFinderAnalyticsLogger.a(str, a2, friendFinderAddFriendsAdapter.f7153e.size() + friendFinderAddFriendsAdapter.f7154f.size(), 50, 10, this.aH);
        } else {
            this.f7191h.a(this.aG.value, SystemClock.uptimeMillis() - this.aI, 50, 10, this.aH);
        }
        super.mj_();
        LogUtils.f(-1586379558, a);
    }

    public final void m7458I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 852057183);
        this.f7189f.c();
        this.az.m7429a();
        this.am.a(null);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1034141543, a);
    }

    public final void m7464g(boolean z) {
        super.g(z);
        az();
        if (this.aJ) {
            aA(this);
        }
    }

    public final String am_() {
        return "friend_finder_add_friends_fragment";
    }

    public final void m7463e() {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setAnimationListener(new C07666(this));
        this.as.startAnimation(alphaAnimation);
    }

    private void m7453g(int i) {
        if (i <= 0) {
            m7463e();
        } else {
            this.f7188e.b(new C07677(this), (long) i);
        }
    }

    private void m7454h(int i) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.at, "progress", new int[]{i});
        ofInt.setDuration(250);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.start();
    }

    public static void m7455i(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment, int i) {
        float f;
        int min = Math.min(i + 50, friendFinderAddFriendsFragment.aD.size());
        List subList = friendFinderAddFriendsFragment.aD.subList(i, min);
        if (friendFinderAddFriendsFragment.aD.isEmpty()) {
            f = 1.0f;
        } else {
            f = ((float) i) / ((float) friendFinderAddFriendsFragment.aD.size());
        }
        friendFinderAddFriendsFragment.m7454h(Math.round(f * 5000.0f));
        if (subList.isEmpty()) {
            friendFinderAddFriendsFragment.am.a(4128769, "FriendFinderAddFriendsTTI", null, "state", "no matches");
            int size = friendFinderAddFriendsFragment.aA.size();
            friendFinderAddFriendsFragment.au.setText(friendFinderAddFriendsFragment.jW_().getQuantityString(2131689654, size, new Object[]{Integer.valueOf(size)}));
            friendFinderAddFriendsFragment.m7453g(2000);
            friendFinderAddFriendsFragment.f7191h.a(friendFinderAddFriendsFragment.aG.value, SystemClock.uptimeMillis() - friendFinderAddFriendsFragment.aI, friendFinderAddFriendsFragment.aD.size(), size, 50, 10, friendFinderAddFriendsFragment.aH);
            if (friendFinderAddFriendsFragment.f7192i.a(FriendingNavigatorGatekeepers.f6747a, false)) {
                friendFinderAddFriendsFragment.ap.a(new FriendableContactsFetchedEvent(size));
            }
            friendFinderAddFriendsFragment.au();
            aA(friendFinderAddFriendsFragment);
            friendFinderAddFriendsFragment.aJ = true;
            return;
        }
        friendFinderAddFriendsFragment.m7452a(subList, 0, min);
    }

    private void m7452a(List<FacebookPhonebookContact> list, int i, final int i2) {
        List<FacebookPhonebookContact> list2 = list;
        Parcelable params = new Params(list2, this.aE, this.aF, this.aG, this.aH, (i2 - 1) / 50, 50, 10, i);
        Bundle bundle = new Bundle();
        bundle.putParcelable("growthFriendFinderParamsKey", params);
        this.f7189f.a(null, BlueServiceOperationFactoryDetour.a(this.f7187d, "growth_friend_finder", bundle, ErrorPropagation.BY_EXCEPTION, ar, -1589005741).a(), new OperationResultFutureCallback(this) {
            final /* synthetic */ FriendFinderAddFriendsFragment f7181b;

            protected final void m7443a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                FriendFinderAddFriendsFragment.m7449a(this.f7181b, operationResult == null ? null : (FriendFinderMethod.Result) operationResult.h(), i2);
            }

            protected final void m7442a(ServiceException serviceException) {
                FriendFinderAddFriendsFragment.m7455i(this.f7181b, i2);
            }
        });
    }

    public static void m7449a(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment, FriendFinderMethod.Result result, int i) {
        if (result == null) {
            m7455i(friendFinderAddFriendsFragment, i);
            return;
        }
        List<PhonebookLookupResultContact> a = result.m7808a();
        if (!a.isEmpty()) {
            if (friendFinderAddFriendsFragment.aA.isEmpty()) {
                friendFinderAddFriendsFragment.am.a(4128769, "FriendFinderAddFriendsTTI", null, "state", "success");
                friendFinderAddFriendsFragment.f7191h.b(friendFinderAddFriendsFragment.aG.value, SystemClock.uptimeMillis() - friendFinderAddFriendsFragment.aI, 50, 10, friendFinderAddFriendsFragment.aH);
            }
            for (PhonebookLookupResultContact phonebookLookupResultContact : a) {
                String l = Long.toString(phonebookLookupResultContact.userId);
                if (!friendFinderAddFriendsFragment.aA.contains(l)) {
                    friendFinderAddFriendsFragment.aB.add(FriendFinderFriendCandidate.m7465a(phonebookLookupResultContact));
                    friendFinderAddFriendsFragment.aA.add(l);
                }
            }
            if (!friendFinderAddFriendsFragment.al.b()) {
                at(friendFinderAddFriendsFragment);
            }
        }
        if (result.m7810c() > 0) {
            friendFinderAddFriendsFragment.m7452a(null, result.m7810c(), i);
            return;
        }
        for (Invites a2 : result.m7809b()) {
            long a3 = a2.m7807a();
            if (!StringUtil.a(new CharSequence[]{r0.name, ((FacebookPhonebookContact) friendFinderAddFriendsFragment.aM.get(Long.valueOf(a3))).a()})) {
                friendFinderAddFriendsFragment.aN.put(Long.valueOf(a3), (FacebookPhonebookContact) friendFinderAddFriendsFragment.aM.get(Long.valueOf(a3)));
            }
        }
        m7455i(friendFinderAddFriendsFragment, i);
    }

    public static void at(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
        if (!friendFinderAddFriendsFragment.aB.isEmpty()) {
            friendFinderAddFriendsFragment.az.m7432a(friendFinderAddFriendsFragment.aB);
            friendFinderAddFriendsFragment.aB.clear();
        }
    }

    private void au() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("growthFriendFinderPYMKParamsKey", new FriendFinderPYMKMethod.Params(this.aF, this.aH, this.aG, Lists.a(this.aA)));
        this.f7189f.a(null, BlueServiceOperationFactoryDetour.a(this.f7187d, "growth_friend_finder_pymk", bundle, ErrorPropagation.BY_EXCEPTION, ar, -1336309144).a(), new C07699(this));
    }

    public static void m7450a(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment, boolean z) {
        int i;
        int i2 = 0;
        TextView textView = friendFinderAddFriendsFragment.ax;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        LoadingIndicatorView loadingIndicatorView = friendFinderAddFriendsFragment.ay;
        if (!z) {
            i2 = 8;
        }
        loadingIndicatorView.setVisibility(i2);
    }

    private boolean av() {
        return this.f7192i.a(33) == TriState.YES;
    }

    public static void aw(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
        if (friendFinderAddFriendsFragment.aJ && friendFinderAddFriendsFragment.av()) {
            Intent intent = new Intent(friendFinderAddFriendsFragment.getContext(), StepInviteActivity.class);
            intent.putExtra("ci_flow", friendFinderAddFriendsFragment.aG);
            intent.putExtra("invitee_credentials", new FacebookPhonebookContactMap(friendFinderAddFriendsFragment.aN));
            friendFinderAddFriendsFragment.f7190g.a(intent, 0, friendFinderAddFriendsFragment);
            return;
        }
        FragmentActivity o = friendFinderAddFriendsFragment.o();
        if (o instanceof FriendFinderHostingActivity) {
            ((FriendFinderHostingActivity) friendFinderAddFriendsFragment.o()).m7498b(-1);
        } else if (o instanceof UserAccountNUXActivity) {
            ((NuxStepListener) o).b("contact_importer");
        }
    }

    public static FriendFinderAddFriendsFragment m7447a(CIFlow cIFlow) {
        FriendFinderAddFriendsFragment friendFinderAddFriendsFragment = new FriendFinderAddFriendsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ci_flow", cIFlow);
        friendFinderAddFriendsFragment.g(bundle);
        return friendFinderAddFriendsFragment;
    }

    private void az() {
        if (D() && this.aL) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.a_(b(2131236380));
                hasTitleBar.c(true);
                hasTitleBar.a(null);
            }
        }
    }

    public static void aA(FriendFinderAddFriendsFragment friendFinderAddFriendsFragment) {
        if (friendFinderAddFriendsFragment.D() && friendFinderAddFriendsFragment.aL) {
            HasTitleBar hasTitleBar = (HasTitleBar) friendFinderAddFriendsFragment.a(HasTitleBar.class);
            if (hasTitleBar != null) {
                int i = (!friendFinderAddFriendsFragment.av() || friendFinderAddFriendsFragment.aN.isEmpty()) ? 2131230733 : 2131230744;
                String b = friendFinderAddFriendsFragment.b(i);
                Builder a = TitleBarButtonSpec.a();
                a.g = b;
                a = a;
                a.j = b;
                hasTitleBar.a(a.a());
                hasTitleBar.a(new OnToolbarButtonListener(friendFinderAddFriendsFragment) {
                    final /* synthetic */ FriendFinderAddFriendsFragment f7172a;

                    {
                        this.f7172a = r1;
                    }

                    public final void m7439a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                        FriendFinderAddFriendsFragment.aw(this.f7172a);
                    }
                });
            }
        }
    }
}
