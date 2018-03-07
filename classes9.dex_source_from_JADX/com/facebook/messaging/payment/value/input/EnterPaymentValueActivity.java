package com.facebook.messaging.payment.value.input;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.awareness.OrionSenderAwarenessNuxController;
import com.facebook.messaging.payment.awareness.PaymentAwarenessFragment;
import com.facebook.messaging.payment.awareness.PaymentAwarenessFragment.Listener;
import com.facebook.messaging.payment.awareness.PaymentAwarenessMode;
import com.facebook.messaging.payment.awareness.PaymentAwarenessPrefKeys;
import com.facebook.messaging.payment.config.HasUserAddedCredentialInP2pPaymentsBefore;
import com.facebook.messaging.payment.config.IsP2pPaymentsRequestEnabled;
import com.facebook.messaging.payment.connectivity.PaymentNoInternetFragment;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentPlatformContext;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.ui.MessengerPayNuxBannerView;
import com.facebook.messaging.payment.value.input.ui.MessengerPayTitleView;
import com.facebook.messaging.payment.value.input.ui.OrionMessengerPayViewPager;
import com.facebook.messaging.payment.value.util.PaymentsSoftInputUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_mutation */
public class EnterPaymentValueActivity extends FbFragmentActivity implements ActionBarOwner, AnalyticsActivity {
    public MessengerPayNuxBannerView f15236A;
    public LinearLayout f15237B;
    public TabbedViewPagerIndicator f15238C;
    public OrionMessengerPayViewPager f15239D;
    private ActionBarBasedFbTitleBar f15240E;
    private boolean f15241F;
    private ListenableFuture<PaymentPlatformContext> f15242G;
    private ListenableFuture<PaymentPlatformContext> f15243H;
    private ListenableFuture<PaymentRequest> f15244I;
    public boolean f15245J;
    public final OrionMessengerPayPagerAdapter f15246K = new OrionMessengerPayPagerAdapter(this, kO_());
    private final C17601 f15247L = new C17601(this);
    private final Listener f15248M = new C17612(this);
    @Inject
    AppCompatActivityOverrider f15249p;
    @Inject
    PaymentsSoftInputUtil f15250q;
    @Inject
    PaymentProtocolUtil f15251r;
    @Inject
    AbstractFbErrorReporter f15252s;
    @Inject
    @HasUserAddedCredentialInP2pPaymentsBefore
    public Provider<Boolean> f15253t;
    @Inject
    @ForUiThread
    Executor f15254u;
    @IsP2pPaymentsRequestEnabled
    @Inject
    Provider<Boolean> f15255v;
    @Inject
    AnalyticsLogger f15256w;
    @Inject
    public OrionSenderAwarenessNuxController f15257x;
    @Inject
    public GatekeeperStoreImpl f15258y;
    private ProgressBar f15259z;

    /* compiled from: extra_mutation */
    public class C17601 {
        final /* synthetic */ EnterPaymentValueActivity f15225a;

        C17601(EnterPaymentValueActivity enterPaymentValueActivity) {
            this.f15225a = enterPaymentValueActivity;
        }

        public final void m15574a() {
            EnterPaymentValueActivity.m15594l(this.f15225a);
        }
    }

    /* compiled from: extra_mutation */
    class C17612 implements Listener {
        final /* synthetic */ EnterPaymentValueActivity f15226a;

        C17612(EnterPaymentValueActivity enterPaymentValueActivity) {
            this.f15226a = enterPaymentValueActivity;
        }

        public final void mo508a() {
            this.f15226a.f15245J = true;
            EnterPaymentValueActivity.m15592j(this.f15226a);
        }
    }

    /* compiled from: extra_mutation */
    class C17623 implements MessengerPayNuxBannerView.Listener {
        final /* synthetic */ EnterPaymentValueActivity f15227a;

        C17623(EnterPaymentValueActivity enterPaymentValueActivity) {
            this.f15227a = enterPaymentValueActivity;
        }

        public final void mo617a() {
            this.f15227a.f15236A.m15503b();
        }
    }

    /* compiled from: extra_mutation */
    class C17634 implements OnPageChangeListener {
        final /* synthetic */ EnterPaymentValueActivity f15228a;

        C17634(EnterPaymentValueActivity enterPaymentValueActivity) {
            this.f15228a = enterPaymentValueActivity;
        }

        public final void m15577a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            if (Tab.values()[i] == Tab.TAB_ORION_REQUEST) {
                this.f15228a.f15256w.a(P2pPaymentsLogEvent.d("p2p_initiate_request", "p2p_request").a);
            }
            EnterPaymentValueFragment enterPaymentValueFragment = (EnterPaymentValueFragment) this.f15228a.f15246K.m15582e(i);
            if (enterPaymentValueFragment != null) {
                enterPaymentValueFragment.as();
                EnterPaymentValueFragment enterPaymentValueFragment2 = (EnterPaymentValueFragment) this.f15228a.f15246K.m15582e((i + 1) % 2);
                if (enterPaymentValueFragment2 != null) {
                    enterPaymentValueFragment.ay.m15746a(enterPaymentValueFragment2.ay.f15462s);
                    enterPaymentValueFragment.ay.m15753a(enterPaymentValueFragment2.ay.f15463t);
                    enterPaymentValueFragment.ay.m15744a(enterPaymentValueFragment2.ay.f15458o);
                }
            }
        }

        public final void m15578b(int i) {
        }
    }

    /* compiled from: extra_mutation */
    class C17645 implements FutureCallback<PaymentPlatformContext> {
        final /* synthetic */ EnterPaymentValueActivity f15229a;

        C17645(EnterPaymentValueActivity enterPaymentValueActivity) {
            this.f15229a = enterPaymentValueActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) obj;
            EnterPaymentValueActivity.m15599q(this.f15229a);
            EnterPaymentValueFragment enterPaymentValueFragment = new EnterPaymentValueFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("messenger_pay_type", MessengerPayType.MC);
            FlatBufferModelHelper.a(bundle, "payment_platform_context", paymentPlatformContextModel);
            enterPaymentValueFragment.g(bundle);
            EnterPaymentValueActivity.m15586a(this.f15229a, enterPaymentValueFragment);
        }

        public void onFailure(Throwable th) {
            EnterPaymentValueActivity.m15599q(this.f15229a);
            this.f15229a.f15252s.a("EnterPaymentValueActivity", "Commerce context failed to create");
            EnterPaymentValueActivity.m15594l(this.f15229a);
        }
    }

    /* compiled from: extra_mutation */
    class C17656 implements FutureCallback<PaymentPlatformContext> {
        final /* synthetic */ EnterPaymentValueActivity f15230a;

        C17656(EnterPaymentValueActivity enterPaymentValueActivity) {
            this.f15230a = enterPaymentValueActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) obj;
            EnterPaymentValueActivity.m15599q(this.f15230a);
            String stringExtra = this.f15230a.getIntent().getStringExtra("invoice_id");
            EnterPaymentValueFragment enterPaymentValueFragment = new EnterPaymentValueFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("messenger_pay_type", MessengerPayType.PAGES_COMMERCE);
            FlatBufferModelHelper.a(bundle, "payment_platform_context", paymentPlatformContextModel);
            bundle.putString("invoice_id", stringExtra);
            enterPaymentValueFragment.g(bundle);
            EnterPaymentValueActivity.m15586a(this.f15230a, enterPaymentValueFragment);
        }

        public void onFailure(Throwable th) {
            EnterPaymentValueActivity.m15599q(this.f15230a);
            this.f15230a.f15252s.a("EnterPaymentValueActivity", "Commerce context failed to fetch");
            EnterPaymentValueActivity.m15594l(this.f15230a);
        }
    }

    /* compiled from: extra_mutation */
    class C17667 implements FutureCallback<PaymentRequest> {
        final /* synthetic */ EnterPaymentValueActivity f15231a;

        C17667(EnterPaymentValueActivity enterPaymentValueActivity) {
            this.f15231a = enterPaymentValueActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            PaymentRequestModel paymentRequestModel = (PaymentRequestModel) obj;
            EnterPaymentValueActivity.m15599q(this.f15231a);
            EnterPaymentValueFragment enterPaymentValueFragment = new EnterPaymentValueFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("messenger_pay_type", MessengerPayType.ORION_REQUEST_ACK);
            FlatBufferModelHelper.a(bundle, "payment_request", paymentRequestModel);
            enterPaymentValueFragment.g(bundle);
            EnterPaymentValueActivity.m15586a(this.f15231a, enterPaymentValueFragment);
        }

        public void onFailure(Throwable th) {
            EnterPaymentValueActivity.m15599q(this.f15231a);
            this.f15231a.f15252s.a("EnterPaymentValueActivity", "Payment request failed to fetch");
            EnterPaymentValueActivity.m15594l(this.f15231a);
        }
    }

    /* compiled from: extra_mutation */
    class OrionMessengerPayPagerAdapter extends FragmentPagerAdapter {
        final /* synthetic */ EnterPaymentValueActivity f15234a;
        private final SparseArray<Fragment> f15235b = new SparseArray();

        public OrionMessengerPayPagerAdapter(EnterPaymentValueActivity enterPaymentValueActivity, FragmentManager fragmentManager) {
            this.f15234a = enterPaymentValueActivity;
            super(fragmentManager);
        }

        public final Fragment m15579a(int i) {
            switch (Tab.values()[i]) {
                case TAB_ORION_PAY:
                    return EnterPaymentValueFragment.m15640a((OrionMessengerPayParams) this.f15234a.getIntent().getParcelableExtra("orion_messenger_pay_params"));
                case TAB_ORION_REQUEST:
                    OrionMessengerPayParams orionMessengerPayParams = (OrionMessengerPayParams) this.f15234a.getIntent().getParcelableExtra("orion_messenger_pay_params");
                    EnterPaymentValueFragment enterPaymentValueFragment = new EnterPaymentValueFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("messenger_pay_type", MessengerPayType.ORION_REQUEST);
                    bundle.putParcelable("orion_messenger_pay_params", orionMessengerPayParams);
                    enterPaymentValueFragment.g(bundle);
                    return enterPaymentValueFragment;
                default:
                    throw new RuntimeException("Unsupported messenger pay tab: " + Tab.values()[i]);
            }
        }

        public final Object m15580a(ViewGroup viewGroup, int i) {
            EnterPaymentValueFragment enterPaymentValueFragment = (EnterPaymentValueFragment) super.a(viewGroup, i);
            this.f15235b.put(i, enterPaymentValueFragment);
            return enterPaymentValueFragment;
        }

        public final int m15581b() {
            return Tab.values().length;
        }

        public final CharSequence J_(int i) {
            return this.f15234a.getResources().getString(Tab.values()[i].titleResId);
        }

        public final Fragment m15582e(int i) {
            return (Fragment) this.f15235b.get(i);
        }
    }

    /* compiled from: extra_mutation */
    enum Tab {
        TAB_ORION_PAY(2131240569),
        TAB_ORION_REQUEST(2131240570);
        
        public final int titleResId;

        private Tab(int i) {
            this.titleResId = i;
        }
    }

    public static void m15587a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EnterPaymentValueActivity) obj).m15585a(AppCompatActivityOverrider.b(injectorLike), PaymentsSoftInputUtil.m16054b(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4179), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4183), AnalyticsLoggerMethodAutoProvider.a(injectorLike), new OrionSenderAwarenessNuxController((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike)), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    private void m15585a(AppCompatActivityOverrider appCompatActivityOverrider, PaymentsSoftInputUtil paymentsSoftInputUtil, PaymentProtocolUtil paymentProtocolUtil, FbErrorReporter fbErrorReporter, Provider<Boolean> provider, Executor executor, Provider<Boolean> provider2, AnalyticsLogger analyticsLogger, OrionSenderAwarenessNuxController orionSenderAwarenessNuxController, GatekeeperStore gatekeeperStore) {
        this.f15249p = appCompatActivityOverrider;
        this.f15250q = paymentsSoftInputUtil;
        this.f15251r = paymentProtocolUtil;
        this.f15252s = fbErrorReporter;
        this.f15253t = provider;
        this.f15254u = executor;
        this.f15255v = provider2;
        this.f15256w = analyticsLogger;
        this.f15257x = orionSenderAwarenessNuxController;
        this.f15258y = gatekeeperStore;
    }

    public static Intent m15584a(Context context, OrionMessengerPayParams orionMessengerPayParams) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(orionMessengerPayParams.f15512a);
        Intent intent = new Intent(context, EnterPaymentValueActivity.class);
        intent.putExtra("messenger_pay_type", orionMessengerPayParams.f15517f != null ? MessengerPayType.GROUP_COMMERCE_PAY : MessengerPayType.ORION);
        intent.putExtra("orion_messenger_pay_params", orionMessengerPayParams);
        return intent;
    }

    public static Intent m15583a(Context context, MoneyPennyItemParams moneyPennyItemParams) {
        Intent intent = new Intent(context, EnterPaymentValueActivity.class);
        intent.putExtra("messenger_pay_type", MessengerPayType.MP);
        intent.putExtra("money_penny_item_params", moneyPennyItemParams);
        return intent;
    }

    public static Intent m15589b(Context context, String str) {
        Intent intent = new Intent(context, EnterPaymentValueActivity.class);
        intent.putExtra("messenger_pay_type", MessengerPayType.ORION_REQUEST_ACK);
        intent.putExtra("request_id", str);
        return intent;
    }

    protected final void m15602a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = EnterPaymentValueActivity.class;
        m15587a((Object) this, (Context) this);
        a(this.f15249p);
    }

    public final void m15603a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof EnterPaymentValueFragment) {
            ((EnterPaymentValueFragment) fragment).aD = this.f15247L;
        } else if (fragment instanceof PaymentAwarenessFragment) {
            ((PaymentAwarenessFragment) fragment).f12812a = this.f15248M;
        }
    }

    protected final void m15604b(Bundle bundle) {
        Object obj;
        super.b(bundle);
        setContentView(2130903974);
        setTheme(2131626369);
        this.f15259z = (ProgressBar) a(2131561180);
        this.f15236A = (MessengerPayNuxBannerView) a(2131561179);
        this.f15236A.m15501a(1, "request_nux_banner_dismiss_count");
        this.f15236A.m15504b(2, "request_nux_banner_impression_count");
        this.f15236A.m15502a(true, 0.75f);
        this.f15236A.setListener(new C17623(this));
        this.f15237B = (LinearLayout) a(2131561178);
        this.f15238C = (TabbedViewPagerIndicator) a(2131561176);
        this.f15239D = (OrionMessengerPayViewPager) a(2131561177);
        this.f15239D.setAdapter(this.f15246K);
        this.f15238C.setViewPager(this.f15239D);
        this.f15238C.l = new C17634(this);
        MessengerPayType messengerPayType = (MessengerPayType) getIntent().getSerializableExtra("messenger_pay_type");
        m15590b(messengerPayType);
        if (bundle != null) {
            this.f15245J = bundle.getBoolean("is_awareness_screen_next_clicked", true);
        }
        if (messengerPayType == MessengerPayType.ORION && !((Boolean) this.f15253t.get()).booleanValue()) {
            int i = 0;
            if (this.f15257x.f12808a.a(PaymentAwarenessPrefKeys.f12816d, 0) < 2) {
                i = 1;
            }
            if (!(i == 0 || this.f15245J)) {
                obj = 1;
                if (obj == null) {
                    m15591i();
                } else {
                    m15592j(this);
                }
            }
        }
        obj = null;
        if (obj == null) {
            m15592j(this);
        } else {
            m15591i();
        }
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -969181410);
        super.onDestroy();
        if (this.f15242G != null) {
            this.f15242G.cancel(true);
            this.f15242G = null;
        }
        if (this.f15243H != null) {
            this.f15243H.cancel(true);
            this.f15243H = null;
        }
        if (this.f15244I != null) {
            this.f15244I.cancel(true);
            this.f15244I = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1341425631, a);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("is_awareness_screen_next_clicked", this.f15245J);
        super.onSaveInstanceState(bundle);
    }

    private void m15591i() {
        m15600r();
        FragmentManager kO_ = kO_();
        if (kO_.a("payment_awareness_fragment") == null) {
            kO_.a().b(2131561178, PaymentAwarenessFragment.m13152a(PaymentAwarenessMode.ORION_SEND), "payment_awareness_fragment").b();
            OrionSenderAwarenessNuxController orionSenderAwarenessNuxController = this.f15257x;
            orionSenderAwarenessNuxController.f12808a.edit().a(PaymentAwarenessPrefKeys.f12816d, orionSenderAwarenessNuxController.f12808a.a(PaymentAwarenessPrefKeys.f12816d, 0) + 1).commit();
        }
    }

    public static void m15592j(EnterPaymentValueActivity enterPaymentValueActivity) {
        if (enterPaymentValueActivity.kO_().a("enter_payment_value_fragment") != null) {
            enterPaymentValueActivity.m15600r();
            return;
        }
        MessengerPayType messengerPayType = (MessengerPayType) enterPaymentValueActivity.getIntent().getSerializableExtra("messenger_pay_type");
        EnterPaymentValueFragment enterPaymentValueFragment;
        Bundle bundle;
        OrionMessengerPayParams orionMessengerPayParams;
        switch (messengerPayType) {
            case MP:
                MoneyPennyItemParams moneyPennyItemParams = (MoneyPennyItemParams) enterPaymentValueActivity.getIntent().getParcelableExtra("money_penny_item_params");
                enterPaymentValueFragment = new EnterPaymentValueFragment();
                bundle = new Bundle();
                bundle.putSerializable("messenger_pay_type", MessengerPayType.MP);
                bundle.putParcelable("money_penny_item_params", moneyPennyItemParams);
                enterPaymentValueFragment.g(bundle);
                m15586a(enterPaymentValueActivity, enterPaymentValueFragment);
                return;
            case MC:
                enterPaymentValueActivity.m15595m();
                return;
            case PAGES_COMMERCE:
                enterPaymentValueActivity.m15596n();
                return;
            case GROUP_COMMERCE_PAY:
                orionMessengerPayParams = (OrionMessengerPayParams) enterPaymentValueActivity.getIntent().getParcelableExtra("orion_messenger_pay_params");
                enterPaymentValueFragment = new EnterPaymentValueFragment();
                bundle = new Bundle();
                bundle.putSerializable("messenger_pay_type", MessengerPayType.GROUP_COMMERCE_PAY);
                bundle.putParcelable("orion_messenger_pay_params", orionMessengerPayParams);
                enterPaymentValueFragment.g(bundle);
                m15586a(enterPaymentValueActivity, enterPaymentValueFragment);
                return;
            case ORION_REQUEST_ACK:
                enterPaymentValueActivity.m15597o();
                return;
            case GROUP_COMMERCE_REQUEST:
                orionMessengerPayParams = (OrionMessengerPayParams) enterPaymentValueActivity.getIntent().getParcelableExtra("orion_messenger_pay_params");
                enterPaymentValueFragment = new EnterPaymentValueFragment();
                bundle = new Bundle();
                bundle.putSerializable("messenger_pay_type", MessengerPayType.GROUP_COMMERCE_REQUEST);
                bundle.putParcelable("orion_messenger_pay_params", orionMessengerPayParams);
                enterPaymentValueFragment.g(bundle);
                m15586a(enterPaymentValueActivity, enterPaymentValueFragment);
                return;
            case ORION:
                if (((Boolean) enterPaymentValueActivity.f15255v.get()).booleanValue()) {
                    if (enterPaymentValueActivity.f15258y.a(957, false)) {
                        enterPaymentValueActivity.f15236A.m15500a();
                    }
                    enterPaymentValueActivity.f15237B.setVisibility(8);
                    enterPaymentValueActivity.f15238C.setVisibility(0);
                    enterPaymentValueActivity.f15239D.setVisibility(0);
                    return;
                }
                m15586a(enterPaymentValueActivity, EnterPaymentValueFragment.m15640a((OrionMessengerPayParams) enterPaymentValueActivity.getIntent().getParcelableExtra("orion_messenger_pay_params")));
                return;
            default:
                throw new RuntimeException("Unsupported messengerPayType: " + messengerPayType);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        getMenuInflater();
        this.f15240E.a(menu);
        return onCreateOptionsMenu;
    }

    public void onBackPressed() {
        m15593k();
        super.onBackPressed();
    }

    public void onPostResume() {
        super.onPostResume();
        this.f15241F = true;
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 17059217);
        this.f15241F = false;
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -96376495, a);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        m15593k();
        this.f15250q.m16055a((Activity) this);
        finish();
        return true;
    }

    public final ActionBar m15601a() {
        return this.f15249p.g();
    }

    private void m15593k() {
        EnterPaymentValueFragment enterPaymentValueFragment = (EnterPaymentValueFragment) kO_().a("enter_payment_value_fragment");
        if (enterPaymentValueFragment != null) {
            enterPaymentValueFragment.ar.m15566a("p2p_send_money_cancelled", enterPaymentValueFragment.ay, enterPaymentValueFragment.s);
        }
    }

    public static void m15594l(EnterPaymentValueActivity enterPaymentValueActivity) {
        if (enterPaymentValueActivity.f15241F) {
            PaymentNoInternetFragment.a(2131561178, enterPaymentValueActivity.kO_());
            enterPaymentValueActivity.m15600r();
        }
    }

    public final String am_() {
        return "payment_tray_popup";
    }

    private void m15590b(MessengerPayType messengerPayType) {
        ActionBar g = this.f15249p.g();
        g.a(18, 26);
        g.a(2130905263);
        MessengerPayTitleView messengerPayTitleView = (MessengerPayTitleView) g.a();
        this.f15240E = new ActionBarBasedFbTitleBar(this, g);
        OrionMessengerPayParams orionMessengerPayParams = (OrionMessengerPayParams) getIntent().getParcelableExtra("orion_messenger_pay_params");
        switch (messengerPayType) {
            case MP:
            case MC:
            case PAGES_COMMERCE:
                messengerPayTitleView.setTitle(2131240528);
                return;
            case GROUP_COMMERCE_PAY:
                messengerPayTitleView.setTitle(2131240389);
                return;
            case ORION_REQUEST_ACK:
                messengerPayTitleView.setTitle(2131240557);
                return;
            case GROUP_COMMERCE_REQUEST:
                messengerPayTitleView.setTitle(2131240556);
                messengerPayTitleView.setUserName(orionMessengerPayParams.f15513b);
                return;
            case ORION:
                messengerPayTitleView.setTitle(2131240389);
                if (((Boolean) this.f15255v.get()).booleanValue()) {
                    messengerPayTitleView.setUserName(orionMessengerPayParams.f15513b);
                    return;
                }
                return;
            default:
                throw new RuntimeException("Unsupported messengerPayType: " + messengerPayType);
        }
    }

    private void m15595m() {
        if (m15588a(this.f15242G)) {
            this.f15242G = this.f15251r.m14966d(getIntent().getStringExtra("item_id"));
            m15598p();
            Futures.a(this.f15242G, new C17645(this), this.f15254u);
        }
    }

    private void m15596n() {
        if (m15588a(this.f15243H)) {
            this.f15243H = this.f15251r.m14968e(getIntent().getStringExtra("platform_context_id"));
            m15598p();
            Futures.a(this.f15243H, new C17656(this), this.f15254u);
        }
    }

    private void m15597o() {
        if (m15588a(this.f15244I)) {
            this.f15244I = this.f15251r.m14969f(getIntent().getStringExtra("request_id"));
            m15598p();
            Futures.a(this.f15244I, new C17667(this), this.f15254u);
        }
    }

    public static void m15586a(EnterPaymentValueActivity enterPaymentValueActivity, EnterPaymentValueFragment enterPaymentValueFragment) {
        enterPaymentValueActivity.kO_().a().b(2131561178, enterPaymentValueFragment, "enter_payment_value_fragment").b();
        enterPaymentValueActivity.m15600r();
    }

    private static boolean m15588a(ListenableFuture listenableFuture) {
        return listenableFuture == null || listenableFuture.isDone();
    }

    private void m15598p() {
        if (this.f15259z != null) {
            this.f15259z.setVisibility(0);
        }
    }

    public static void m15599q(EnterPaymentValueActivity enterPaymentValueActivity) {
        if (enterPaymentValueActivity.f15259z != null) {
            enterPaymentValueActivity.f15259z.setVisibility(8);
        }
    }

    private void m15600r() {
        this.f15237B.setVisibility(0);
        this.f15238C.setVisibility(8);
        this.f15239D.setVisibility(8);
    }
}
