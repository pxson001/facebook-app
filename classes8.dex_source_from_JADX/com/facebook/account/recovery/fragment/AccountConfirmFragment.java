package com.facebook.account.recovery.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.account.recovery.annotations.IsEmailListedBeforeSmsEnabled;
import com.facebook.account.recovery.helper.AccountConfirmSmsHelper;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger$EventType;
import com.facebook.account.recovery.model.AccountCandidateModel;
import com.facebook.account.recovery.protocol.AccountRecoverySendConfirmationCodeMethod.Params;
import com.facebook.account.recovery.protocol.AccountRecoveryValidateCodeMethod;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.timer.IntervalTimer;
import com.facebook.common.timer.IntervalTimer.IntervalTimerListener;
import com.facebook.common.timer.IntervalTimerProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.growth.experiment.InitialAppLaunchExperimentLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.search.SearchEditText;
import com.facebook.ui.search.SearchEditText.OnSubmitListener;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: local_serp_close */
public class AccountConfirmFragment extends FbFragment {
    private static final String[] al = new String[]{"android.permission.READ_SMS"};
    @Inject
    public DefaultBlueServiceOperationFactory f10233a;
    private View aA;
    private TextView aB;
    private TextView aC;
    private Button aD;
    public ContactType aE = ContactType.SMS;
    public String aF;
    public List<String> aG;
    public List<String> aH;
    public List<String> aI;
    public List<String> aJ;
    public boolean aK;
    private boolean aL;
    public IntervalTimer aM;
    public long aN;
    public long aO;
    public boolean aP;
    private boolean aQ;
    public OnConfirmationCodeValidatedListener am;
    public View an;
    private TextView ao;
    private ContentView ap;
    public CheckedContentView aq;
    public CheckedContentView ar;
    private TextView as;
    private TextView at;
    public ViewStub au;
    public TextView av;
    @Nullable
    private View aw;
    public SearchEditText ax;
    public Button ay;
    public Button az;
    @Inject
    public TasksManager f10234b;
    @Inject
    Toaster f10235c;
    @Inject
    public AccountRecoveryAnalyticsLogger f10236d;
    @Inject
    public AccountConfirmSmsHelper f10237e;
    @Inject
    @IsEmailListedBeforeSmsEnabled
    public Provider<TriState> f10238f;
    @Inject
    IntervalTimerProvider f10239g;
    @Inject
    public Clock f10240h;
    @Inject
    ActivityRuntimePermissionsManagerProvider f10241i;

    /* compiled from: local_serp_close */
    class C10601 implements OnClickListener {
        final /* synthetic */ AccountConfirmFragment f10223a;

        C10601(AccountConfirmFragment accountConfirmFragment) {
            this.f10223a = accountConfirmFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1362136249);
            this.f10223a.ao().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1452807122, a);
        }
    }

    /* compiled from: local_serp_close */
    public class C10623 implements OnClickListener {
        final /* synthetic */ AccountConfirmFragment f10226a;

        public C10623(AccountConfirmFragment accountConfirmFragment) {
            this.f10226a = accountConfirmFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -720000117);
            this.f10226a.aE = ContactType.SMS;
            if (!this.f10226a.aq.isChecked()) {
                this.f10226a.aq.setChecked(true);
                this.f10226a.aq.setCheckMarkDrawable(2130840069);
                this.f10226a.ar.setChecked(false);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 211455644, a);
        }
    }

    /* compiled from: local_serp_close */
    public class C10634 implements OnClickListener {
        final /* synthetic */ AccountConfirmFragment f10227a;

        public C10634(AccountConfirmFragment accountConfirmFragment) {
            this.f10227a = accountConfirmFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1500702252);
            this.f10227a.aE = ContactType.EMAIL;
            if (!this.f10227a.ar.isChecked()) {
                this.f10227a.ar.setChecked(true);
                this.f10227a.ar.setCheckMarkDrawable(2130840069);
                this.f10227a.aq.setChecked(false);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -906406913, a);
        }
    }

    /* compiled from: local_serp_close */
    public class C10645 implements IntervalTimerListener {
        final /* synthetic */ AccountConfirmFragment f10228a;

        public C10645(AccountConfirmFragment accountConfirmFragment) {
            this.f10228a = accountConfirmFragment;
        }

        public final void mo677a(long j) {
            if (3333 > j) {
                this.f10228a.av.setText(2131239712);
            } else if (6666 > j) {
                this.f10228a.av.setText(2131239711);
            }
        }

        public final void mo676a() {
            AccountConfirmFragment.at(this.f10228a);
        }
    }

    /* compiled from: local_serp_close */
    class C10656 implements OnClickListener {
        final /* synthetic */ AccountConfirmFragment f10229a;

        C10656(AccountConfirmFragment accountConfirmFragment) {
            this.f10229a = accountConfirmFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1456722740);
            if (this.f10229a.aE == ContactType.SMS && this.f10229a.aG.isEmpty()) {
                Logger.a(2, EntryType.UI_INPUT_END, -2006218510, a);
            } else if (this.f10229a.aE == ContactType.EMAIL && this.f10229a.aI.isEmpty()) {
                LogUtils.a(-1560269955, a);
            } else {
                ContactType contactType;
                AccountConfirmFragment accountConfirmFragment = this.f10229a;
                if (this.f10229a.aE == ContactType.SMS) {
                    contactType = ContactType.EMAIL;
                } else {
                    contactType = ContactType.SMS;
                }
                accountConfirmFragment.aE = contactType;
                AccountConfirmFragment.aE(this.f10229a);
                AccountConfirmFragment.aF(this.f10229a);
                AccountConfirmFragment.av(this.f10229a);
                AccountConfirmFragment.aw(this.f10229a);
                AccountConfirmFragment.az(this.f10229a);
                LogUtils.a(-626270845, a);
            }
        }
    }

    /* compiled from: local_serp_close */
    public class C10667 implements OnSubmitListener {
        final /* synthetic */ AccountConfirmFragment f10230a;

        public C10667(AccountConfirmFragment accountConfirmFragment) {
            this.f10230a = accountConfirmFragment;
        }

        public final void m12016a() {
            Object obj = this.f10230a.ax.getText().toString();
            if (!StringUtil.a(obj)) {
                AccountConfirmFragment.m12022b(this.f10230a, obj);
            }
        }
    }

    /* compiled from: local_serp_close */
    public class C10678 extends BaseTextWatcher {
        final /* synthetic */ AccountConfirmFragment f10231a;

        public C10678(AccountConfirmFragment accountConfirmFragment) {
            this.f10231a = accountConfirmFragment;
        }

        public void afterTextChanged(Editable editable) {
            if (this.f10231a.ax.getText().length() > 0) {
                this.f10231a.ay.setEnabled(true);
            } else {
                this.f10231a.ay.setEnabled(false);
            }
        }
    }

    /* compiled from: local_serp_close */
    public class C10689 implements OnClickListener {
        final /* synthetic */ AccountConfirmFragment f10232a;

        public C10689(AccountConfirmFragment accountConfirmFragment) {
            this.f10232a = accountConfirmFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 949869133);
            this.f10232a.ax.onEditorAction(this.f10232a.ax, 3, null);
            Logger.a(2, EntryType.UI_INPUT_END, -894825263, a);
        }
    }

    /* compiled from: local_serp_close */
    public enum ContactType {
        SMS,
        EMAIL
    }

    public static void m12020a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AccountConfirmFragment) obj).m12019a(DefaultBlueServiceOperationFactory.b(fbInjector), TasksManager.b(fbInjector), Toaster.b(fbInjector), AccountRecoveryAnalyticsLogger.a(fbInjector), AccountConfirmSmsHelper.m12074b(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 624), (IntervalTimerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(IntervalTimerProvider.class), (Clock) SystemClockMethodAutoProvider.a(fbInjector), (ActivityRuntimePermissionsManagerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class));
    }

    private void m12019a(BlueServiceOperationFactory blueServiceOperationFactory, TasksManager tasksManager, Toaster toaster, AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger, AccountConfirmSmsHelper accountConfirmSmsHelper, Provider<TriState> provider, IntervalTimerProvider intervalTimerProvider, Clock clock, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider) {
        this.f10233a = blueServiceOperationFactory;
        this.f10234b = tasksManager;
        this.f10235c = toaster;
        this.f10236d = accountRecoveryAnalyticsLogger;
        this.f10237e = accountConfirmSmsHelper;
        this.f10238f = provider;
        this.f10239g = intervalTimerProvider;
        this.f10240h = clock;
        this.f10241i = activityRuntimePermissionsManagerProvider;
    }

    public final void m12029c(Bundle bundle) {
        super.c(bundle);
        Class cls = AccountConfirmFragment.class;
        m12020a((Object) this, getContext());
        this.aK = false;
        this.aL = false;
        this.aQ = true;
        aF(this);
    }

    public final View m12025a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1483946074);
        View inflate = layoutInflater.inflate(2130903068, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1492181100, a);
        return inflate;
    }

    public final void m12024H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 331810736);
        if (this.ax != null) {
            this.ax.c();
        }
        if (this.aK) {
            aD();
            this.aL = true;
        }
        if (this.aM != null) {
            this.aM.m12620d();
        }
        if (this.aN != 0) {
            this.aP = true;
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2043261762, a);
    }

    public final void m12023G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1651284506);
        super.G();
        if (this.aM != null) {
            this.aM = null;
            at(this);
        }
        if (this.aL) {
            if (this.aE == ContactType.SMS) {
                this.aK = true;
                this.f10237e.m12078b();
            }
            this.aL = false;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1970646672, a);
    }

    public final void m12026a(Activity activity) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1404317895);
        super.a(activity);
        try {
            this.am = (OnConfirmationCodeValidatedListener) activity;
            LogUtils.f(-1631437860, a);
        } catch (ClassCastException e) {
            ClassCastException classCastException = new ClassCastException(activity.toString() + " must implement OnConfirmationCodeValidatedListener");
            LogUtils.f(-532860442, a);
            throw classCastException;
        }
    }

    public final void m12027a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.an = e(2131559167);
        this.ao = (TextView) e(2131559168);
        this.ap = (ContentView) e(2131559169);
        if (((TriState) this.f10238f.get()).asBoolean(false)) {
            this.aq = (CheckedContentView) e(2131559171);
            this.ar = (CheckedContentView) e(2131559170);
            this.aE = ContactType.EMAIL;
            this.ar.setChecked(true);
            this.ar.setCheckMarkDrawable(2130840069);
            this.aq.setChecked(false);
        } else {
            this.aq = (CheckedContentView) e(2131559170);
            this.ar = (CheckedContentView) e(2131559171);
        }
        this.aq.setTitleText(2131239705);
        this.ar.setTitleText(2131239706);
        if (this.f10238f.get() != TriState.UNSET) {
            ((InitialAppLaunchExperimentLogger) this.f10236d.b.get()).a(AccountRecoveryAnalyticsLogger$EventType.EMAIL_LISTED_BEFORE_SMS.getEventName(), ((TriState) this.f10238f.get()).asBoolean(false));
        }
        this.as = (TextView) e(2131559172);
        this.at = (TextView) e(2131559173);
        this.ao.setText(2131239704);
        this.ap.setThumbnailSize(ThumbnailSize.MEDIUM);
        this.aq.setShowThumbnail(false);
        this.ar.setShowThumbnail(false);
        if (this.s != null) {
            m12028a((AccountCandidateModel) this.s.getParcelable("account_profile"), this.s.getBoolean("auto_identify"));
        }
        AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = this.f10236d;
        String str = this.aF;
        AnalyticsLogger analyticsLogger = accountRecoveryAnalyticsLogger.a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.INITIATE_VIEWED.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent.b("crypted_id", str), 1);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 769747294);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239703);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 842622332, a);
    }

    public final void m12028a(AccountCandidateModel accountCandidateModel, boolean z) {
        this.ap.setThumbnailUri(accountCandidateModel.m12090b());
        this.ap.setTitleText(accountCandidateModel.m12091c());
        this.ap.setSubtitleText(accountCandidateModel.m12092d());
        this.ap.setMetaText(null);
        if (z) {
            this.at.setVisibility(0);
            this.at.setOnClickListener(new C10601(this));
        } else {
            this.at.setVisibility(8);
        }
        this.aF = accountCandidateModel.m12089a();
        accountCandidateModel.m12097i();
        List e = accountCandidateModel.m12093e();
        List f = accountCandidateModel.m12094f();
        m12021a(e, this.aq);
        m12021a(f, this.ar);
        if (e.isEmpty() || f.isEmpty()) {
            m12018a(accountCandidateModel);
            if (e.isEmpty()) {
                this.aE = ContactType.EMAIL;
                this.ar.setChecked(true);
                this.ar.setCheckMarkDrawable(2130839773);
                return;
            }
            this.aq.setCheckMarkDrawable(2130839773);
            return;
        }
        m12018a(accountCandidateModel);
        this.aq.setOnClickListener(new C10623(this));
        this.ar.setOnClickListener(new C10634(this));
    }

    private static void m12021a(List<String> list, CheckedContentView checkedContentView) {
        if (list.isEmpty()) {
            checkedContentView.setVisibility(8);
            return;
        }
        checkedContentView.setSubtitleText((CharSequence) list.get(0));
        if (list.size() > 1) {
            checkedContentView.setMetaText((CharSequence) list.get(1));
            checkedContentView.setMetaTextAppearance(2131624227);
        }
    }

    private void m12018a(final AccountCandidateModel accountCandidateModel) {
        this.as.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AccountConfirmFragment f10225b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 437650472);
                this.f10225b.aG = accountCandidateModel.m12095g();
                this.f10225b.aH = accountCandidateModel.m12094f();
                this.f10225b.aI = accountCandidateModel.m12096h();
                this.f10225b.aJ = accountCandidateModel.m12093e();
                AccountConfirmFragment.aE(this.f10225b);
                AccountConfirmFragment.aF(this.f10225b);
                AccountConfirmFragment.az(this.f10225b);
                AccountConfirmFragment.ar(this.f10225b);
                this.f10225b.an.setVisibility(8);
                Logger.a(2, EntryType.UI_INPUT_END, -150702634, a);
            }
        });
    }

    public static void ar(AccountConfirmFragment accountConfirmFragment) {
        accountConfirmFragment.an.setVisibility(8);
        if (accountConfirmFragment.aK) {
            accountConfirmFragment.au = (ViewStub) accountConfirmFragment.e(2131559163);
            accountConfirmFragment.au.inflate();
            accountConfirmFragment.av = (TextView) accountConfirmFragment.e(2131559153);
            accountConfirmFragment.av.setText(2131239710);
            accountConfirmFragment.aM = IntervalTimerProvider.m12621a(Long.valueOf(10000), Long.valueOf(1000));
            accountConfirmFragment.aM.f10694d = new C10645(accountConfirmFragment);
            accountConfirmFragment.aM.m12619c();
            return;
        }
        accountConfirmFragment.au();
    }

    public static void at(AccountConfirmFragment accountConfirmFragment) {
        if (accountConfirmFragment.au != null) {
            accountConfirmFragment.au.setVisibility(8);
        }
        accountConfirmFragment.au();
    }

    private void au() {
        if (this.aw == null) {
            this.aw = ((ViewStub) e(2131559165)).inflate();
        }
        this.ax = (SearchEditText) this.aw.findViewById(2131559157);
        this.ay = (Button) this.aw.findViewById(2131559158);
        this.az = (Button) this.aw.findViewById(2131559160);
        this.aA = this.aw.findViewById(2131559159);
        this.aB = (TextView) this.aw.findViewById(2131559156);
        this.aC = (TextView) this.aw.findViewById(2131559154);
        this.aD = (FbButton) this.aw.findViewById(2131559161);
        av(this);
        this.ax.f = new C10667(this);
        this.ax.addTextChangedListener(new C10678(this));
        this.ay.setOnClickListener(new C10689(this));
        this.az.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AccountConfirmFragment f10216a;

            {
                this.f10216a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1922711121);
                AccountConfirmFragment.az(this.f10216a);
                this.f10216a.f10235c.b(new ToastBuilder(this.f10216a.b(2131239707)));
                Logger.a(2, EntryType.UI_INPUT_END, 1810080937, a);
            }
        });
        AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = this.f10236d;
        String str = this.aF;
        AnalyticsLogger analyticsLogger = accountRecoveryAnalyticsLogger.a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.CODE_ENTRY_VIEWED.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent.b("crypted_id", str), 1);
        if (this.aH.isEmpty() || this.aJ.isEmpty()) {
            this.aD.setVisibility(8);
            this.aQ = false;
            return;
        }
        aw(this);
        this.aD.setOnClickListener(new C10656(this));
    }

    public static void av(AccountConfirmFragment accountConfirmFragment) {
        int i;
        List list;
        int i2;
        Lists.a();
        List list2;
        if (accountConfirmFragment.aE == ContactType.SMS) {
            list2 = accountConfirmFragment.aJ;
            accountConfirmFragment.aB.setText(2131239708);
            i = 2131239708;
            list = list2;
            i2 = 2131239709;
        } else {
            list2 = accountConfirmFragment.aH;
            accountConfirmFragment.aB.setText(2131239715);
            i = 2131239715;
            list = list2;
            i2 = 2131239716;
        }
        if (!list.isEmpty()) {
            accountConfirmFragment.aC.setText((CharSequence) list.get(0));
            TextView textView = (TextView) accountConfirmFragment.e(2131559155);
            if (list.size() > 1) {
                textView.setText((CharSequence) list.get(1));
                textView.setVisibility(0);
                accountConfirmFragment.aB.setText(i2);
                return;
            }
            textView.setVisibility(8);
            accountConfirmFragment.aB.setText(i);
        }
    }

    public static void aw(AccountConfirmFragment accountConfirmFragment) {
        if (accountConfirmFragment.aE == ContactType.SMS) {
            accountConfirmFragment.aD.setText(2131239718);
        } else {
            accountConfirmFragment.aD.setText(2131239717);
        }
    }

    public static void az(AccountConfirmFragment accountConfirmFragment) {
        accountConfirmFragment.aD();
        Bundle bundle = new Bundle();
        bundle.putParcelable("accountRecoverySendCodeParamsKey", new Params(accountConfirmFragment.aF, accountConfirmFragment.aE == ContactType.SMS ? accountConfirmFragment.aI : accountConfirmFragment.aG));
        accountConfirmFragment.f10234b.a(null, BlueServiceOperationFactoryDetour.a(accountConfirmFragment.f10233a, "account_recovery_send_code", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(AccountConfirmFragment.class), -944090761).a(), new OperationResultFutureCallback(accountConfirmFragment) {
            final /* synthetic */ AccountConfirmFragment f10219a;

            {
                this.f10219a = r1;
            }

            protected final void m12007a(ServiceException serviceException) {
            }
        });
        aA(accountConfirmFragment);
    }

    public static void aA(AccountConfirmFragment accountConfirmFragment) {
        if (accountConfirmFragment.aE == ContactType.SMS) {
            accountConfirmFragment.f10241i.a(accountConfirmFragment.o()).a(al, new AbstractRuntimePermissionsListener(accountConfirmFragment) {
                final /* synthetic */ AccountConfirmFragment f10220a;

                {
                    this.f10220a = r1;
                }

                public final void m12009a() {
                    AccountConfirmFragment accountConfirmFragment = this.f10220a;
                    if (accountConfirmFragment.aN == 0) {
                        accountConfirmFragment.aN = accountConfirmFragment.f10240h.a();
                        AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = accountConfirmFragment.f10236d;
                        String str = accountConfirmFragment.aF;
                        AnalyticsLogger analyticsLogger = accountRecoveryAnalyticsLogger.a;
                        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.SMS_CODE_SEARCHED.getEventName());
                        honeyClientEvent.c = "account_recovery";
                        analyticsLogger.b(honeyClientEvent.b("crypted_id", str), 1);
                    }
                    accountConfirmFragment.aK = true;
                    accountConfirmFragment.f10237e.m12077a(accountConfirmFragment);
                }
            });
        }
    }

    private void aD() {
        this.f10237e.f10299c.m12620d();
        this.aK = false;
    }

    public static void m12022b(AccountConfirmFragment accountConfirmFragment, final String str) {
        accountConfirmFragment.aD();
        if (accountConfirmFragment.aM != null) {
            accountConfirmFragment.aM.m12620d();
            accountConfirmFragment.aM = null;
        }
        if (accountConfirmFragment.aw == null) {
            accountConfirmFragment.av.setText(2131239713);
        } else {
            m12017a(accountConfirmFragment, true);
            accountConfirmFragment.ax.setText(str);
        }
        if (accountConfirmFragment.aO != 0) {
            AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = accountConfirmFragment.f10236d;
            String str2 = accountConfirmFragment.aF;
            long j = accountConfirmFragment.aO;
            boolean z = accountConfirmFragment.aP;
            AnalyticsLogger analyticsLogger = accountRecoveryAnalyticsLogger.a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.CODE_SUBMITTED.getEventName());
            honeyClientEvent.c = "account_recovery";
            analyticsLogger.b(honeyClientEvent.b("crypted_id", str2).a("sms_wait_time", j).a("paused", z), 1);
        } else {
            accountConfirmFragment.f10236d.l(accountConfirmFragment.aF);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("accountRecoveryValidateCodeParamsKey", new AccountRecoveryValidateCodeMethod.Params(accountConfirmFragment.aF, str, "", false));
        accountConfirmFragment.f10234b.a(null, BlueServiceOperationFactoryDetour.a(accountConfirmFragment.f10233a, "account_recovery_validate_code", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(AccountConfirmFragment.class), -170163788).a(), new OperationResultFutureCallback(accountConfirmFragment) {
            final /* synthetic */ AccountConfirmFragment f10222b;

            protected final void m12010a(ServiceException serviceException) {
                AccountConfirmFragment.aA(this.f10222b);
                AccountConfirmFragment accountConfirmFragment = this.f10222b;
                AccountConfirmFragment.m12017a(accountConfirmFragment, false);
                if (accountConfirmFragment.ax == null) {
                    AccountConfirmFragment.at(accountConfirmFragment);
                } else {
                    new Builder(accountConfirmFragment.getContext()).a(accountConfirmFragment.b(2131239721)).a(accountConfirmFragment.b(2131239722), new DialogInterface.OnClickListener(accountConfirmFragment) {
                        final /* synthetic */ AccountConfirmFragment f10218a;

                        {
                            this.f10218a = r1;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            this.f10218a.ax.a();
                            this.f10218a.ax.b();
                        }
                    }).b(accountConfirmFragment.b(2131239723), new DialogInterface.OnClickListener(accountConfirmFragment) {
                        final /* synthetic */ AccountConfirmFragment f10217a;

                        {
                            this.f10217a = r1;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            AccountConfirmFragment.az(this.f10217a);
                            this.f10217a.f10235c.b(new ToastBuilder(this.f10217a.b(2131239707)));
                            this.f10217a.ax.a();
                            this.f10217a.ax.b();
                        }
                    }).b();
                }
            }

            protected final void m12011a(Object obj) {
                AccountConfirmFragment.m12017a(this.f10222b, false);
                this.f10222b.am.b(this.f10222b.aF, str);
            }
        });
    }

    public static void aE(AccountConfirmFragment accountConfirmFragment) {
        if (accountConfirmFragment.aE == ContactType.SMS) {
            AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = accountConfirmFragment.f10236d;
            String str = accountConfirmFragment.aF;
            AnalyticsLogger analyticsLogger = accountRecoveryAnalyticsLogger.a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.SENT_CODE_SMS.getEventName());
            honeyClientEvent.c = "account_recovery";
            analyticsLogger.b(honeyClientEvent.b("crypted_id", str), 1);
            return;
        }
        accountRecoveryAnalyticsLogger = accountConfirmFragment.f10236d;
        str = accountConfirmFragment.aF;
        analyticsLogger = accountRecoveryAnalyticsLogger.a;
        honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.SENT_CODE_EMAIL.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent.b("crypted_id", str), 1);
    }

    public static void aF(AccountConfirmFragment accountConfirmFragment) {
        accountConfirmFragment.aN = 0;
        accountConfirmFragment.aO = 0;
        accountConfirmFragment.aP = false;
    }

    public static void m12017a(AccountConfirmFragment accountConfirmFragment, boolean z) {
        int i = 0;
        int i2 = 8;
        if (accountConfirmFragment.aw != null) {
            int i3 = z ? 8 : 0;
            if (!z) {
                i = 8;
            }
            accountConfirmFragment.aA.setVisibility(i);
            accountConfirmFragment.az.setVisibility(i3);
            accountConfirmFragment.ay.setVisibility(i3);
            Button button = accountConfirmFragment.aD;
            if (accountConfirmFragment.aQ) {
                i2 = i3;
            }
            button.setVisibility(i2);
        }
    }
}
