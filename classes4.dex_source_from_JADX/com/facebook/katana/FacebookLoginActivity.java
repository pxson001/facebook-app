package com.facebook.katana;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.account.recovery.AccountRecoveryActivity;
import com.facebook.account.recovery.annotations.IsBounceFromMSiteEnabled;
import com.facebook.account.recovery.annotations.IsGkUnsetBounceFromMSiteEnabled;
import com.facebook.account.recovery.annotations.IsParallelSearchEnabled;
import com.facebook.account.recovery.helper.DeviceOwnerDataBackgroundHelper;
import com.facebook.account.recovery.helper.DeviceOwnerDataBackgroundHelper.1;
import com.facebook.account.recovery.helper.GkUnsetGroupTestHelper;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger.EventType;
import com.facebook.analytics.ClientPeriodicEventReporterManager;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.credentials.PasswordCredentials.Type;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.login.CheckApprovedMachineMethod;
import com.facebook.auth.login.CheckApprovedMachineMethod.ApprovalStatus;
import com.facebook.auth.login.CheckApprovedMachineParams;
import com.facebook.auth.login.KindleSsoUtil;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.UsesSimpleStringTitle;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.appstartup.AppStartupTracker;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.LocaleUtil;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.device_id.UniqueDeviceIdBroadcastSender;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.devicebasedlogin.logging.DBLLoggerHelper;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.growth.campaign.AdvertisingIdLogger;
import com.facebook.growth.campaign.AdvertisingIdLogger.C00551;
import com.facebook.growth.experiment.InitialAppLaunchExperimentLogger;
import com.facebook.growth.nux.analytics.NUXAnalyticsLogger;
import com.facebook.growth.nux.analytics.NUXAnalyticsLogger.Events;
import com.facebook.growth.prefs.CampaignPrefKeys;
import com.facebook.growth.sem.SemTrackingLogger;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.katana.LoginErrorHandlingHelper.ErrorData;
import com.facebook.katana.activity.codegenerator.CodeGeneratorActivity;
import com.facebook.katana.activity.codegenerator.GatedCodeGeneratorExperimentHelper;
import com.facebook.katana.annotations.IsLoginWithPhoneNumberSupported;
import com.facebook.katana.app.module.Boolean_IsLoginWithPhoneNumberSupportedMethodAutoProvider;
import com.facebook.katana.common.ForegroundStatusProvider;
import com.facebook.katana.dbl.AuthLoginHelper;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.katana.dbl.DeviceBasedLoginActivityHelper;
import com.facebook.katana.login.LoginActivityHelper;
import com.facebook.katana.platform.FacebookAuthenticationService;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.katana.server.LoginApprovalResendCodeParams;
import com.facebook.katana.server.protocol.GetSsoUserMethod.Result;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.service.AppSession$AuthAndLoginCallback;
import com.facebook.katana.service.AppSession.LoginStatus;
import com.facebook.katana.service.AppSessionListener;
import com.facebook.katana.util.AlertDialogs;
import com.facebook.katana.util.MSiteUrlUtils;
import com.facebook.languages.switcher.LanguageSwitcher;
import com.facebook.languages.switcher.LanguageSwitcherConstants$INTENT_SOURCE;
import com.facebook.languages.switcher.LanguageSwitcherList;
import com.facebook.languages.switcher.LanguageSwitcherListHelper;
import com.facebook.languages.switcher.SuggestedLanguagesListHelper;
import com.facebook.languages.switcher.activity.LanguageSwitcherActivity;
import com.facebook.languages.switcher.logging.LanguageSwitcherLoginLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.registration.activity.AccountRegistrationActivity;
import com.facebook.resources.IFbResourcesNotRequired;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ssl.ui.SSLDialogHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: unexpected directory %s */
public class FacebookLoginActivity extends FbFragmentActivity implements OnClickListener, AnalyticsActivity, UsesSimpleStringTitle, IAuthNotRequired, ForegroundStatusProvider, IFbResourcesNotRequired {
    public static final Class<?> ai = FacebookLoginActivity.class;
    private static final PrefKey aj = ((PrefKey) SharedPrefKeys.d.a("ar_bounce_from_msite"));
    @Inject
    AbstractFbErrorReporter f577A;
    @Inject
    Lazy<KindleSsoUtil> f578B;
    @Inject
    SSLDialogHelper f579C;
    @Inject
    DeviceBasedLoginActivityHelper f580D;
    @Inject
    AuthLoginHelper f581E;
    @Inject
    DBLStorageAndRetrievalHelper f582F;
    @Inject
    LoginErrorHandlingHelper f583G;
    @Inject
    Context f584H;
    @Inject
    InteractionLogger f585I;
    @Inject
    DBLLoggerHelper f586J;
    @Inject
    NUXAnalyticsLogger f587K;
    @Inject
    @IsLoginWithPhoneNumberSupported
    Boolean f588L;
    @Inject
    MSiteUrlUtils f589M;
    @Inject
    LanguageSwitcher f590N;
    @Inject
    SuggestedLanguagesListHelper f591O;
    @Inject
    Lazy<LanguageSwitcherLoginLogger> f592P;
    @Inject
    DialtoneController f593Q;
    @Inject
    UniqueIdForDeviceHolderImpl f594R;
    @Inject
    GkUnsetGroupTestHelper f595S;
    @IsBounceFromMSiteEnabled
    @Inject
    Lazy<TriState> f596T;
    @Inject
    @IsGkUnsetBounceFromMSiteEnabled
    Lazy<TriState> f597U;
    @Inject
    @IsParallelSearchEnabled
    Provider<TriState> f598V;
    @Inject
    Lazy<AccountRecoveryAnalyticsLogger> f599W;
    @Inject
    GatedCodeGeneratorExperimentHelper f600X;
    @Inject
    Lazy<DeviceOwnerDataBackgroundHelper> f601Y;
    @Inject
    Lazy<AdvertisingIdLogger> f602Z;
    private boolean aA;
    private boolean aB = false;
    public Handler aC;
    private Runnable aD;
    private String aE;
    private long aF;
    private Provider<TriState> aG;
    private boolean aH = false;
    private boolean aI = false;
    private String aJ;
    public boolean aK = false;
    private boolean aL = false;
    private ImmutableSet<? extends View> aM;
    public ImmutableSet<? extends View> aN;
    public AutoCompleteTextView aO;
    public EditText aP;
    public EditText aQ;
    public LinearLayout aR;
    private RelativeLayout aS;
    private LinearLayout aT;
    private LinearLayout aU;
    private LinearLayout aV;
    public LinearLayout aW;
    private LinearLayout aX;
    public FbButton aY;
    public FbButton aZ;
    @Inject
    Lazy<Toaster> aa;
    @Inject
    AllCapsTransformationMethod ab;
    @Inject
    Lazy<SemTrackingLogger> ac;
    @Inject
    Locales ad;
    @Inject
    Lazy<LanguageSwitcherListHelper> ae;
    @Inject
    Lazy<LoggedInUserAuthDataStore> af;
    @Inject
    Lazy<UniqueDeviceIdBroadcastSender> ag;
    @Inject
    Lazy<ClientPeriodicEventReporterManager> ah;
    public UiState ak = UiState.SPLASHSCREEN;
    public AppSession al;
    public LoginAppSessionListener am;
    private String an;
    private boolean ao = false;
    private View ap;
    private long aq;
    private int ar = 0;
    public boolean as = true;
    private boolean at;
    public boolean au;
    private boolean av = false;
    public String aw;
    public String ax;
    public final Handler ay = new Handler();
    private Set<String> az;
    public FbButton ba;
    public FbButton bb;
    public View bc;
    private ProgressBar bd;
    private ImageView be;
    private ViewGroup bf;
    private View bg;
    public View bh;
    private View bi;
    private TextView bj;
    private TextView bk;
    private TextView bl;
    private FbTextView bm;
    private FbTextView bn;
    private FbButton bo;
    private FbButton bp;
    public TextView bq;
    private TextView br;
    private List<String> bs;
    private final OnGlobalLayoutListener bt = new C00461(this);
    private final FutureCallback<String> bu = new C00472(this);
    public final FutureCallback<OperationResult> bv = new C00483(this);
    public final OnClickListener bw = new C00494(this);
    public final Runnable bx = new C00505(this);
    @Inject
    QuickPerformanceLogger f603p;
    @Inject
    AppStartupTracker f604q;
    @Inject
    LoginActivityHelper f605r;
    @Inject
    FbSharedPreferences f606s;
    @Inject
    DefaultAndroidThreadUtil f607t;
    @Inject
    DefaultBlueServiceOperationFactory f608u;
    @Inject
    SecureContextHelper f609v;
    @Inject
    InitialAppLaunchExperimentLogger f610w;
    @Inject
    InterstitialManager f611x;
    @DefaultExecutorService
    @Inject
    ExecutorService f612y;
    @Inject
    @ForUiThread
    ExecutorService f613z;

    /* compiled from: unexpected directory %s */
    enum UiState {
        SPLASHSCREEN,
        FETCHING_SSO_DATA,
        SSO_AUTH_UI,
        PASSWORD_AUTH_UI,
        LOGIN_APPPROVAL_UI,
        LOGGING_IN
    }

    /* compiled from: unexpected directory %s */
    class C00461 implements OnGlobalLayoutListener {
        final /* synthetic */ FacebookLoginActivity f657a;

        C00461(FacebookLoginActivity facebookLoginActivity) {
            this.f657a = facebookLoginActivity;
        }

        public void onGlobalLayout() {
            if (this.f657a.aR.getVisibility() == 0) {
                int height = this.f657a.aR.getRootView().getHeight();
                if (height - this.f657a.aR.getHeight() > height / 3) {
                    if (!this.f657a.aK) {
                        this.f657a.aK = true;
                        this.f657a.aO;
                    }
                } else if (this.f657a.aK) {
                    this.f657a.aK = false;
                    this.f657a.aO;
                }
            }
        }
    }

    /* compiled from: unexpected directory %s */
    class C00472 implements FutureCallback<String> {
        final /* synthetic */ FacebookLoginActivity f658a;

        C00472(FacebookLoginActivity facebookLoginActivity) {
            this.f658a = facebookLoginActivity;
        }

        public void onSuccess(Object obj) {
            this.f658a.aw = (String) obj;
            Bundle bundle = new Bundle();
            bundle.putString("get_sso_user_params", this.f658a.aw);
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f658a.f608u, "get_sso_user", bundle, 1624633280).a(), this.f658a.bv, this.f658a.f613z);
        }

        public void onFailure(Throwable th) {
            BLog.a(FacebookLoginActivity.ai, "Could not get auth token from Kindle", th);
            HandlerDetour.b(this.f658a.ay, new 1(this), 1000, -536640281);
        }
    }

    /* compiled from: unexpected directory %s */
    class C00483 implements FutureCallback<OperationResult> {
        final /* synthetic */ FacebookLoginActivity f659a;

        C00483(FacebookLoginActivity facebookLoginActivity) {
            this.f659a = facebookLoginActivity;
        }

        public void onSuccess(Object obj) {
            Result result = (Result) ((OperationResult) obj).g().getParcelable("result");
            this.f659a.ax = result.a;
            FbButton fbButton = this.f659a.bb;
            Resources resources = this.f659a.getResources();
            StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
            styledStringBuilder.a(resources.getString(2131230860));
            styledStringBuilder.a("[[name]]", result.b, null, 33);
            fbButton.setText(styledStringBuilder.b());
            fbButton.setOnClickListener(this.f659a.bw);
            this.f659a.m898a(UiState.SSO_AUTH_UI);
        }

        public void onFailure(Throwable th) {
            BLog.b(FacebookLoginActivity.ai, "Could not get user data using auth token", th);
            this.f659a.m898a(UiState.PASSWORD_AUTH_UI);
        }
    }

    /* compiled from: unexpected directory %s */
    class C00494 implements OnClickListener {
        final /* synthetic */ FacebookLoginActivity f660a;

        C00494(FacebookLoginActivity facebookLoginActivity) {
            this.f660a = facebookLoginActivity;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -62999725);
            this.f660a.bh;
            this.f660a.al.a();
            this.f660a.al.a(this.f660a.am);
            AppSession appSession = this.f660a.al;
            String str = this.f660a.aw;
            String str2 = this.f660a.ax;
            if (appSession.f == LoginStatus.STATUS_LOGGED_OUT) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            AppSession.e(appSession.r);
            Bundle bundle = new Bundle();
            bundle.putString("sso_auth_token", str);
            bundle.putString("sso_username", str2);
            OperationFuture a2 = BlueServiceOperationFactoryDetour.a(appSession.p, "sso", bundle, -1636170086).a();
            appSession.g = new AppSession$AuthAndLoginCallback(appSession);
            Futures.a(a2, appSession.g, appSession.q);
            AppSession.a(appSession, LoginStatus.STATUS_LOGGING_IN);
            Logger.a(2, EntryType.UI_INPUT_END, 1651517890, a);
        }
    }

    /* compiled from: unexpected directory %s */
    class C00505 implements Runnable {
        final /* synthetic */ FacebookLoginActivity f661a;

        C00505(FacebookLoginActivity facebookLoginActivity) {
            this.f661a = facebookLoginActivity;
        }

        public void run() {
            FacebookLoginActivity.m885K(this.f661a);
        }
    }

    /* compiled from: unexpected directory %s */
    class LoginAppSessionListener extends AppSessionListener {
        final /* synthetic */ FacebookLoginActivity f662a;

        public LoginAppSessionListener(FacebookLoginActivity facebookLoginActivity) {
            this.f662a = facebookLoginActivity;
        }

        public final void mo65a(Throwable th) {
            if (th == null) {
                this.f662a.au = true;
                this.f662a.f603p.b(2293761, (short) 2);
                return;
            }
            FacebookLoginActivity.m921b(this.f662a, th);
        }
    }

    /* compiled from: unexpected directory %s */
    enum LoginState {
        PASSWORD_ENTRY,
        LOGIN_APPROVALS_CODE_ENTRY,
        TRANSIENT_AUTH_TOKEN_ENTRY
    }

    /* compiled from: unexpected directory %s */
    /* synthetic */ class AnonymousClass20 {
        static final /* synthetic */ int[] f687b = new int[LoginStatus.values().length];

        static {
            try {
                f687b[LoginStatus.STATUS_LOGGED_IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f687b[LoginStatus.STATUS_LOGGING_IN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f687b[LoginStatus.STATUS_LOGGED_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f687b[LoginStatus.STATUS_LOGGING_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f686a = new int[UiState.values().length];
            try {
                f686a[UiState.SPLASHSCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f686a[UiState.FETCHING_SSO_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f686a[UiState.SSO_AUTH_UI.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f686a[UiState.PASSWORD_AUTH_UI.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f686a[UiState.LOGIN_APPPROVAL_UI.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f686a[UiState.LOGGING_IN.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* compiled from: unexpected directory %s */
    class C00518 implements TextWatcher {
        final /* synthetic */ FacebookLoginActivity f688a;

        C00518(FacebookLoginActivity facebookLoginActivity) {
            this.f688a = facebookLoginActivity;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4 = 0;
            if (StringUtil.a(this.f688a.aP.getText()) || StringUtil.a(this.f688a.aO.getText())) {
                if (this.f688a.aY.isEnabled()) {
                    this.f688a.aY.setEnabled(false);
                }
            } else if (!(StringUtil.a(this.f688a.aO.getText()) || StringUtil.a(this.f688a.aP.getText()) || this.f688a.aY.isEnabled())) {
                this.f688a.aY.setEnabled(true);
            }
            TextView textView = this.f688a.bq;
            if (StringUtil.a(this.f688a.aP.getText())) {
                i4 = 8;
            }
            textView.setVisibility(i4);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: unexpected directory %s */
    class C00529 implements TextWatcher {
        final /* synthetic */ FacebookLoginActivity f689a;

        C00529(FacebookLoginActivity facebookLoginActivity) {
            this.f689a = facebookLoginActivity;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f689a.aQ.getText().length() < 6) {
                this.f689a.aZ.setEnabled(false);
            } else {
                this.f689a.aZ.setEnabled(true);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: unexpected directory %s */
    public class LoginParams {
        final /* synthetic */ FacebookLoginActivity f712a;
        public String f713b;
        public long f714c;
        public String f715d;
        public Type f716e;

        public LoginParams(FacebookLoginActivity facebookLoginActivity, Type type) {
            this.f712a = facebookLoginActivity;
            this.f716e = type;
        }

        public final String m1094a() {
            return this.f713b;
        }

        public final void m1096a(String str) {
            this.f713b = str;
        }

        public final long m1097b() {
            return this.f714c;
        }

        public final void m1095a(long j) {
            this.f714c = j;
        }

        public final String m1099c() {
            return this.f715d;
        }

        public final void m1098b(String str) {
            this.f715d = str;
        }

        public final Type m1100d() {
            return this.f716e;
        }
    }

    /* compiled from: unexpected directory %s */
    class C00536 implements OnEditorActionListener {
        final /* synthetic */ FacebookLoginActivity f744a;

        C00536(FacebookLoginActivity facebookLoginActivity) {
            this.f744a = facebookLoginActivity;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 6) {
                this.f744a.bc.requestFocus();
                if (this.f744a.aK) {
                    this.f744a.aK = false;
                }
                if (textView == this.f744a.aQ) {
                    this.f744a.m897a(LoginState.LOGIN_APPROVALS_CODE_ENTRY);
                } else if (textView == this.f744a.aP) {
                    this.f744a.m897a(LoginState.PASSWORD_ENTRY);
                }
            }
            return false;
        }
    }

    /* compiled from: unexpected directory %s */
    class C00547 implements Runnable {
        final /* synthetic */ FacebookLoginActivity f754a;

        C00547(FacebookLoginActivity facebookLoginActivity) {
            this.f754a = facebookLoginActivity;
        }

        public void run() {
            if (this.f754a.ak == UiState.SPLASHSCREEN) {
                this.f754a.m898a(UiState.PASSWORD_AUTH_UI);
            }
        }
    }

    /* compiled from: unexpected directory %s */
    class LoginCompleteFutureCallback implements FutureCallback<OperationResult> {
        final /* synthetic */ FacebookLoginActivity f778a;

        public LoginCompleteFutureCallback(FacebookLoginActivity facebookLoginActivity) {
            this.f778a = facebookLoginActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f778a.as = true;
            HandlerDetour.a(this.f778a.ay, this.f778a.bx);
            FacebookLoginActivity.m885K(this.f778a);
        }

        public void onFailure(Throwable th) {
            this.f778a.f577A.a("FacebookLoginActivity", "LoginCompleteFutureCallback failure", th);
        }
    }

    /* compiled from: unexpected directory %s */
    class LoginExtras {
        final /* synthetic */ FacebookLoginActivity f781a;
        private Boolean f782b;
        private Boolean f783c;
        private int f784d;

        public LoginExtras(FacebookLoginActivity facebookLoginActivity, Intent intent) {
            this.f781a = facebookLoginActivity;
            this.f782b = Boolean.valueOf(intent.getBooleanExtra("login_redirect", false));
            this.f783c = Boolean.valueOf(intent.getBooleanExtra("finish_immediately", false));
            this.f784d = intent.getFlags();
        }

        public final Bundle m1121a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("login_redirect", this.f782b.booleanValue());
            bundle.putBoolean("finish_immediately", this.f783c.booleanValue());
            bundle.putInt("flags", this.f784d);
            return bundle;
        }

        public final boolean m1122b() {
            return this.f782b.booleanValue();
        }
    }

    private static <T extends Context> void m910a(Class<T> cls, T t) {
        m911a((Object) t, (Context) t);
    }

    public static void m911a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FacebookLoginActivity) obj).m907a(QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), AppStartupTracker.a(injectorLike), LoginActivityHelper.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), InitialAppLaunchExperimentLogger.m983a(injectorLike), InterstitialManager.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 348), SSLDialogHelper.m989a(injectorLike), DeviceBasedLoginActivityHelper.a(injectorLike), AuthLoginHelper.a(injectorLike), DBLStorageAndRetrievalHelper.a(injectorLike), LoginErrorHandlingHelper.m994a(injectorLike), (Context) injectorLike.getInstance(Context.class), InteractionLogger.a(injectorLike), DBLLoggerHelper.a(injectorLike), NUXAnalyticsLogger.m1005a(injectorLike), Boolean_IsLoginWithPhoneNumberSupportedMethodAutoProvider.m1028a(injectorLike), MSiteUrlUtils.m1008a(injectorLike), LanguageSwitcher.a(injectorLike), SuggestedLanguagesListHelper.m1014a(injectorLike), IdBasedLazy.a(injectorLike, 2454), (DialtoneController) DialtoneControllerImpl.a(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.a(injectorLike), GkUnsetGroupTestHelper.m1021a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 622), IdBasedSingletonScopeProvider.b(injectorLike, 625), IdBasedSingletonScopeProvider.a(injectorLike, 626), IdBasedLazy.a(injectorLike, 104), GatedCodeGeneratorExperimentHelper.m1024a(injectorLike), IdBasedLazy.a(injectorLike, 102), IdBasedLazy.a(injectorLike, 2205), IdBasedLazy.a(injectorLike, 3588), AllCapsTransformationMethod.a(injectorLike), IdBasedLazy.a(injectorLike, 2209), Locales.a(injectorLike), IdBasedLazy.a(injectorLike, 2450), IdBasedSingletonScopeProvider.b(injectorLike, 339), IdBasedLazy.a(injectorLike, 1076), IdBasedSingletonScopeProvider.b(injectorLike, 125));
    }

    private void m907a(QuickPerformanceLogger quickPerformanceLogger, AppStartupTracker appStartupTracker, LoginActivityHelper loginActivityHelper, FbSharedPreferences fbSharedPreferences, AndroidThreadUtil androidThreadUtil, BlueServiceOperationFactory blueServiceOperationFactory, SecureContextHelper secureContextHelper, InitialAppLaunchExperimentLogger initialAppLaunchExperimentLogger, InterstitialManager interstitialManager, ExecutorService executorService, ExecutorService executorService2, FbErrorReporter fbErrorReporter, Lazy<KindleSsoUtil> lazy, SSLDialogHelper sSLDialogHelper, DeviceBasedLoginActivityHelper deviceBasedLoginActivityHelper, AuthLoginHelper authLoginHelper, DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper, LoginErrorHandlingHelper loginErrorHandlingHelper, Context context, InteractionLogger interactionLogger, DBLLoggerHelper dBLLoggerHelper, NUXAnalyticsLogger nUXAnalyticsLogger, Boolean bool, MSiteUrlUtils mSiteUrlUtils, LanguageSwitcher languageSwitcher, SuggestedLanguagesListHelper suggestedLanguagesListHelper, Lazy<LanguageSwitcherLoginLogger> lazy2, DialtoneController dialtoneController, UniqueIdForDeviceHolder uniqueIdForDeviceHolder, GkUnsetGroupTestHelper gkUnsetGroupTestHelper, Lazy<TriState> lazy3, Lazy<TriState> lazy4, Provider<TriState> provider, Lazy<AccountRecoveryAnalyticsLogger> lazy5, GatedCodeGeneratorExperimentHelper gatedCodeGeneratorExperimentHelper, Lazy<DeviceOwnerDataBackgroundHelper> lazy6, Lazy<AdvertisingIdLogger> lazy7, Lazy<Toaster> lazy8, AllCapsTransformationMethod allCapsTransformationMethod, Lazy<SemTrackingLogger> lazy9, Locales locales, Lazy<LanguageSwitcherListHelper> lazy10, Lazy<LoggedInUserAuthDataStore> lazy11, Lazy<UniqueDeviceIdBroadcastSender> lazy12, Lazy<ClientPeriodicEventReporterManager> lazy13) {
        this.f603p = quickPerformanceLogger;
        this.f604q = appStartupTracker;
        this.f605r = loginActivityHelper;
        this.f606s = fbSharedPreferences;
        this.f607t = androidThreadUtil;
        this.f608u = blueServiceOperationFactory;
        this.f609v = secureContextHelper;
        this.f610w = initialAppLaunchExperimentLogger;
        this.f611x = interstitialManager;
        this.f612y = executorService;
        this.f613z = executorService2;
        this.f577A = fbErrorReporter;
        this.f578B = lazy;
        this.f579C = sSLDialogHelper;
        this.f580D = deviceBasedLoginActivityHelper;
        this.f581E = authLoginHelper;
        this.f582F = dBLStorageAndRetrievalHelper;
        this.f583G = loginErrorHandlingHelper;
        this.f584H = context;
        this.f585I = interactionLogger;
        this.f586J = dBLLoggerHelper;
        this.f587K = nUXAnalyticsLogger;
        this.f588L = bool;
        this.f589M = mSiteUrlUtils;
        this.f590N = languageSwitcher;
        this.f591O = suggestedLanguagesListHelper;
        this.f592P = lazy2;
        this.f593Q = dialtoneController;
        this.f594R = uniqueIdForDeviceHolder;
        this.f595S = gkUnsetGroupTestHelper;
        this.f596T = lazy3;
        this.f597U = lazy4;
        this.f598V = provider;
        this.f599W = lazy5;
        this.f600X = gatedCodeGeneratorExperimentHelper;
        this.f601Y = lazy6;
        this.f602Z = lazy7;
        this.aa = lazy8;
        this.ab = allCapsTransformationMethod;
        this.ac = lazy9;
        this.ad = locales;
        this.ae = lazy10;
        this.af = lazy11;
        this.ag = lazy12;
        this.ah = lazy13;
    }

    public final boolean mo64c() {
        return this.ao;
    }

    public final void m980b(Bundle bundle) {
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(2131362706));
        }
        Class cls = FacebookLoginActivity.class;
        m911a((Object) this, (Context) this);
        super.b(bundle);
        this.f604q.a.o();
        ((UniqueDeviceIdBroadcastSender) this.ag.get()).m1132i();
        this.f593Q.a(this, getIntent());
        this.al = AppSession.a(getApplicationContext());
        if (this.f581E.a()) {
            m973x();
            FeedPerfLogger feedPerfLogger = this.f604q.a;
            if (feedPerfLogger.j.l(655361, "NNFColdStart")) {
                feedPerfLogger.j.c(655456, "NNFCold_LoginActivityCreate");
                return;
            } else {
                feedPerfLogger.j.f(655458, "NNFWarm_LoginActivityCreate");
                return;
            }
        }
        LoginActivityHelper loginActivityHelper;
        String str;
        this.f604q.a.q();
        AdvertisingIdLogger advertisingIdLogger = (AdvertisingIdLogger) this.f602Z.get();
        if (!advertisingIdLogger.f806b.a(CampaignPrefKeys.f901b, false)) {
            ExecutorDetour.a((ExecutorService) advertisingIdLogger.f808d.get(), new C00551(advertisingIdLogger), 355725998);
        }
        LoginParams n = m953n();
        if (n == null) {
            n = m955o();
        }
        if (n == null) {
            n = m957p();
        }
        if (n == null) {
            n = m958q();
        }
        this.az = Sets.c();
        if (n == null || n.f713b == null) {
            loginActivityHelper = this.f605r;
            getApplicationContext();
            CharSequence f = loginActivityHelper.f();
            if (!TextUtils.isEmpty(f)) {
                this.az.add(f);
            }
        } else {
            this.az.add(n.f713b);
        }
        loginActivityHelper = this.f605r;
        if (checkCallingOrSelfPermission("android.permission.READ_SMS") != 0 || loginActivityHelper.e == null || loginActivityHelper.e.getLine1Number() == null || !Patterns.PHONE.matcher(loginActivityHelper.e.getLine1Number()).matches()) {
            str = null;
        } else {
            str = loginActivityHelper.e.getLine1Number();
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            this.az.add(str2);
        }
        this.az.addAll(this.f605r.j());
        this.aC = new Handler();
        m880F();
        if (n == null && m945j().booleanValue()) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("accounts", this.f582F.d());
            bundle2.putInt("pin", this.f582F.h());
            bundle2.putInt("placeholder", this.f582F.i());
            if (this.f580D.b()) {
                bundle2.putInt("password_accounts", this.f582F.a.e(AuthPrefKeys.v).size());
            }
            this.f586J.a("dbl_user_chooser_displayed", bundle2);
            Intent intent = new Intent(this, DeviceBasedLoginActivity.class);
            LoginExtras loginExtras = new LoginExtras(this, getIntent());
            intent.putExtras(loginExtras.m1121a());
            if (loginExtras.m1122b()) {
                this.f609v.a(intent, 3, this);
                return;
            }
            this.f609v.a(intent, this);
            finish();
            return;
        }
        m890a(bundle, n);
    }

    private Boolean m945j() {
        boolean z = false;
        if (getIntent().getBooleanExtra("redirected_from_dbl", false)) {
            return Boolean.valueOf(false);
        }
        if (this.f580D.d() || this.f580D.e()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private void m890a(Bundle bundle, LoginParams loginParams) {
        setContentView(2130904255);
        getWindow().setBackgroundDrawable(null);
        this.aO = (AutoCompleteTextView) a(2131561788);
        this.aO.setTypeface(Typeface.DEFAULT);
        this.aO.addTextChangedListener(m946k());
        this.aO.setHint(this.f588L.booleanValue() ? 2131232460 : 2131232459);
        this.aP = (EditText) a(2131561790);
        this.aP.setTypeface(Typeface.DEFAULT);
        this.aP.addTextChangedListener(m946k());
        this.aQ = (EditText) a(2131560331);
        this.aQ.addTextChangedListener(m948l());
        this.aY = (FbButton) a(2131561792);
        this.aY.setEnabled(false);
        this.aY.setOnClickListener(this);
        this.aZ = (FbButton) a(2131561795);
        this.ba = (FbButton) a(2131561796);
        this.br = (TextView) a(2131561797);
        this.br.setOnClickListener(this);
        this.aZ.setOnClickListener(this);
        this.aZ.setEnabled(false);
        this.ba.setOnClickListener(this);
        this.bb = (FbButton) a(2131561784);
        this.bb.setOnClickListener(this);
        m888a(2131561785, 2131230861);
        this.bo = (FbButton) a(2131561800);
        this.bp = (FbButton) a(2131561801);
        this.bo.setOnClickListener(this);
        this.bp.setOnClickListener(this);
        this.bm = (FbTextView) a(2131560918);
        this.bm.setOnClickListener(this);
        this.bq = (TextView) a(2131561791);
        this.bq.setTransformationMethod(this.ab);
        this.bq.setOnClickListener(this);
        this.bn = (FbTextView) a(2131561775);
        this.bi = a(2131561776);
        this.bi.setOnClickListener(this);
        this.aX = (LinearLayout) a(2131561778);
        this.f591O.m1019a();
        TextView textView = (TextView) a(2131561777);
        String b = this.f590N.b();
        if (b == null) {
            b = "en";
        }
        textView.setText(LocaleUtil.a(LocaleUtil.a(b)));
        if (!this.az.isEmpty()) {
            this.aO.setText((CharSequence) this.az.iterator().next());
            this.aO.setAdapter(new ArrayAdapter(this, 17367050, this.az.toArray(new String[this.az.size()])));
        }
        if (getIntent().getBooleanExtra("redirected_from_dbl", false)) {
            this.aO.setText("");
        }
        if (bundle != null) {
            this.an = bundle.getString("nux_id");
        }
        m893a(this.aO);
        m893a(this.aP);
        m893a(this.aQ);
        this.bc = a(2131561787);
        OnEditorActionListener c00536 = new C00536(this);
        this.aP.setOnEditorActionListener(c00536);
        this.aQ.setOnEditorActionListener(c00536);
        this.am = new LoginAppSessionListener(this);
        this.bd = (ProgressBar) a(2131561804);
        this.aR = (LinearLayout) a(2131561772);
        this.aS = (RelativeLayout) a(2131561802);
        this.ap = findViewById(2131561805);
        this.aM = ImmutableSet.of(this.aR, this.aS, this.ap);
        this.aT = (LinearLayout) a(2131561782);
        this.aU = (LinearLayout) a(2131561786);
        this.aV = (LinearLayout) a(2131561793);
        this.aN = ImmutableSet.of(this.aT, this.aU, this.aV);
        this.aW = (LinearLayout) a(2131561799);
        this.be = (ImageView) findViewById(2131559210);
        this.bf = (ViewGroup) a(2131561774);
        this.bg = findViewById(2131561773);
        this.bh = findViewById(2131561798);
        if (loginParams != null) {
            m919b(loginParams);
        } else if (m951m()) {
            m898a(UiState.FETCHING_SSO_DATA);
            Futures.a(((KindleSsoUtil) this.f578B.get()).m1106a(), this.bu, this.f613z);
        } else {
            HandlerDetour.b(this.ay, new C00547(this), 1000, 1047408731);
        }
    }

    private TextWatcher m946k() {
        return new C00518(this);
    }

    private TextWatcher m948l() {
        return new C00529(this);
    }

    public void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -618132634);
        super.onStart();
        m963s();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -289592810, a);
    }

    private static boolean m951m() {
        boolean z;
        if (Build.MODEL.equals("Kindle Fire") || Build.MODEL.startsWith("KF")) {
            z = true;
        } else {
            z = false;
        }
        return Build.MANUFACTURER.equals("Amazon") && (z || Build.MODEL.startsWith("SD"));
    }

    private void m888a(int i, int i2) {
        TextView textView = (TextView) a(i);
        CharSequence spannableString = new SpannableString(getString(i2));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        textView.setText(spannableString);
        textView.setOnClickListener(this);
    }

    private void m898a(UiState uiState) {
        KeyboardUtils.m1055a(this);
        switch (uiState) {
            case SPLASHSCREEN:
                m909a(this.aM, this.aS);
                this.bd.setVisibility(4);
                break;
            case FETCHING_SSO_DATA:
                m909a(this.aM, this.aS);
                this.bd.setVisibility(0);
                break;
            case SSO_AUTH_UI:
                m909a(this.aM, this.aR);
                m909a(this.aN, this.aT);
                m924b(true);
                m936d(false);
                break;
            case PASSWORD_AUTH_UI:
                m909a(this.aM, this.aR);
                m909a(this.aN, this.aU);
                m924b(true);
                m936d(true);
                break;
            case LOGIN_APPPROVAL_UI:
                m909a(this.aM, this.aR);
                m909a(this.aN, this.aV);
                m924b(false);
                m936d(false);
                break;
            case LOGGING_IN:
                m909a(this.aM, this.ap);
                m908a(this.aN);
                m924b(false);
                m936d(false);
                break;
        }
        if (uiState == UiState.PASSWORD_AUTH_UI || uiState == UiState.SSO_AUTH_UI) {
            if (this.ak == UiState.SPLASHSCREEN || this.ak == UiState.FETCHING_SSO_DATA) {
                View view;
                int i;
                m908a(this.aN);
                m924b(false);
                m920b(this, 8);
                if (uiState == UiState.PASSWORD_AUTH_UI) {
                    view = this.aU;
                    i = 228;
                } else {
                    view = this.aT;
                    i = 140;
                }
                m892a(view, i + 112);
            } else {
                this.bg.setLayoutParams(new LayoutParams(-1, 0, 1.0f));
                this.bg.setVisibility(0);
                this.bh.setVisibility(0);
            }
        }
        this.ak = uiState;
    }

    private static void m908a(ImmutableSet<? extends View> immutableSet) {
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(8);
        }
    }

    private void m909a(ImmutableSet<? extends View> immutableSet, View view) {
        Preconditions.checkArgument(immutableSet.contains(view));
        m908a((ImmutableSet) immutableSet);
        view.setVisibility(0);
    }

    private void m892a(final View view, int i) {
        int height = this.aS.getHeight();
        if (height == 0) {
            height = getResources().getDisplayMetrics().heightPixels;
        }
        int d = (height - m933d(i)) / 2;
        this.bg.setLayoutParams(new LayoutParams(-1, d));
        this.bg.setVisibility(0);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, (float) (((height - this.be.getHeight()) / 2) - d), 0, 0.0f);
        translateAnimation.setDuration(500);
        translateAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ FacebookLoginActivity f780b;

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.f780b.m891a(view);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.bf.startAnimation(translateAnimation);
    }

    private void m891a(final View view) {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ FacebookLoginActivity f711b;

            public void onAnimationStart(Animation animation) {
                view.setVisibility(4);
                this.f711b.aW.setVisibility(4);
                this.f711b.bh.setVisibility(0);
                FacebookLoginActivity.m920b(this.f711b, 4);
            }

            public void onAnimationEnd(Animation animation) {
                this.f711b.m909a(this.f711b.aN, view);
                this.f711b.m924b(true);
                FacebookLoginActivity.m920b(this.f711b, 0);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(alphaAnimation);
        this.aW.startAnimation(alphaAnimation);
        this.bh.startAnimation(alphaAnimation);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            Optional a;
            Intent d = this.f605r.d();
            Absent absent = Absent.INSTANCE;
            if (this.an != null) {
                InterstitialIntentController interstitialIntentController = (InterstitialIntentController) this.f611x.a(this.an, InterstitialIntentController.class);
                if (interstitialIntentController != null) {
                    a = interstitialIntentController.a(i2, intent);
                    if (a.isPresent()) {
                        this.f609v.a(d, this);
                    } else {
                        d.setFlags(65536);
                        this.f609v.a(d, this);
                        this.f609v.a((Intent) a.get(), this);
                    }
                    this.f582F.k();
                    this.f603p.b(2293774, (short) 2);
                    finish();
                }
            }
            a = absent;
            if (a.isPresent()) {
                this.f609v.a(d, this);
            } else {
                d.setFlags(65536);
                this.f609v.a(d, this);
                this.f609v.a((Intent) a.get(), this);
            }
            this.f582F.k();
            this.f603p.b(2293774, (short) 2);
            finish();
        } else if (i == 2) {
            if (i2 == -1) {
                if (!StringUtil.a(new CharSequence[]{intent.getStringExtra("account_user_id"), intent.getStringExtra("account_password")})) {
                    this.aO.setText(intent.getStringExtra("account_user_id"));
                    this.aP.setText(r1);
                    this.av = true;
                }
            }
        } else if (i == 3 && i2 == 0) {
            setResult(0);
            finish();
        }
    }

    private LoginParams m953n() {
        String stringExtra = getIntent().getStringExtra("reg_login_nonce");
        String stringExtra2 = getIntent().getStringExtra("username");
        if (stringExtra2 == null || stringExtra == null) {
            return null;
        }
        LoginParams loginParams = new LoginParams(this, Type.APP_REGISTRATION_LOGIN_NONCE);
        loginParams.f713b = stringExtra2;
        loginParams.f715d = stringExtra;
        return loginParams;
    }

    private LoginParams m955o() {
        Intent intent = (Intent) getIntent().getParcelableExtra("calling_intent");
        if (intent == null || intent.getData() == null) {
            return null;
        }
        if (System.currentTimeMillis() - this.f606s.a(FbandroidPrefKeys.l, 0) >= 1800000) {
            return null;
        }
        this.f606s.edit().a(FbandroidPrefKeys.l, 0).commit();
        String queryParameter = intent.getData().getQueryParameter("cptoken");
        if (queryParameter == null) {
            return null;
        }
        try {
            long parseLong = Long.parseLong(intent.getData().getQueryParameter("cpuid"));
            LoginParams loginParams = new LoginParams(this, Type.TRANSIENT_TOKEN);
            loginParams.m1095a(parseLong);
            loginParams.m1098b(queryParameter);
            ((AccountRecoveryAnalyticsLogger) this.f599W.get()).m1060a(this.f594R.a());
            return loginParams;
        } catch (NumberFormatException e) {
            this.f577A.a("LoginCheckpointCorruptLink", "Checkpoint login redirect expected uid but got " + intent.getData().getQueryParameter("cpuid"));
            return null;
        }
    }

    private LoginParams m957p() {
        String stringExtra = getIntent().getStringExtra("extra_uid");
        String stringExtra2 = getIntent().getStringExtra("extra_pwd");
        if (stringExtra == null || stringExtra2 == null) {
            return null;
        }
        LoginParams loginParams = new LoginParams(this, Type.PASSWORD);
        loginParams.f713b = stringExtra;
        loginParams.f715d = stringExtra2;
        return loginParams;
    }

    private LoginParams m958q() {
        String stringExtra = getIntent().getStringExtra("username");
        String stringExtra2 = getIntent().getStringExtra("otp");
        if (stringExtra == null || stringExtra2 == null) {
            return null;
        }
        LoginParams loginParams = new LoginParams(this, Type.PASSWORD);
        loginParams.f713b = stringExtra;
        loginParams.f715d = stringExtra2;
        return loginParams;
    }

    private void m893a(EditText editText) {
        editText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ FacebookLoginActivity f743a;

            {
                this.f743a = r1;
            }

            public void onFocusChange(View view, boolean z) {
                boolean z2 = this.f743a.aO.isFocused() || this.f743a.aP.isFocused() || this.f743a.aQ.isFocused();
                if (this.f743a.aK != z2) {
                    this.f743a.aK = z2;
                    this.f743a.aO;
                }
            }
        });
    }

    public static void m961r(FacebookLoginActivity facebookLoginActivity) {
        if (facebookLoginActivity.aR != null && facebookLoginActivity.aR.getVisibility() == 0) {
            int dimension;
            LayoutParams layoutParams = (LayoutParams) facebookLoginActivity.bf.getLayoutParams();
            int dimension2 = (int) facebookLoginActivity.getResources().getDimension(2131431794);
            if (facebookLoginActivity.aK) {
                dimension = (int) facebookLoginActivity.getResources().getDimension(2131431796);
                facebookLoginActivity.bg.setLayoutParams(new LayoutParams(-1, 0, 1.0f));
            } else {
                dimension = (int) facebookLoginActivity.getResources().getDimension(2131431795);
            }
            layoutParams.setMargins(0, dimension2, 0, dimension);
            facebookLoginActivity.bf.setLayoutParams(layoutParams);
        }
        if (facebookLoginActivity.aW != null && facebookLoginActivity.aW.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams2;
            if (facebookLoginActivity.aK) {
                m920b(facebookLoginActivity, 8);
                facebookLoginActivity.m931c(false);
                facebookLoginActivity.bo.setVisibility(8);
                facebookLoginActivity.bp.setVisibility(0);
                layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                layoutParams2.setMargins(0, 0, 0, 0);
            } else {
                m920b(facebookLoginActivity, 0);
                facebookLoginActivity.m931c(true);
                facebookLoginActivity.bp.setVisibility(8);
                facebookLoginActivity.bo.setVisibility(0);
                layoutParams2 = new LayoutParams(-1, -2, 0.0f);
                layoutParams2.setMargins(0, 0, 0, facebookLoginActivity.m933d(32));
            }
            layoutParams2.gravity = 1;
            facebookLoginActivity.aW.setLayoutParams(layoutParams2);
        }
    }

    private void m963s() {
        ViewGroup viewGroup = (ViewGroup) findViewById(2131561772);
        if (viewGroup != null) {
            ViewTreeObserver viewTreeObserver = viewGroup.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(this.bt);
            }
        }
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -645684128);
        super.onResume();
        if (this.bn != null) {
            if (this.f593Q.b()) {
                this.bn.setVisibility(0);
            } else {
                this.bn.setVisibility(8);
            }
        }
        if (!(this.aC == null || this.aD == null)) {
            HandlerDetour.b(this.aC, this.aD, 10000, -156619900);
        }
        this.ao = true;
        this.ar = 0;
        if (this.bc != null) {
            this.bc.requestFocus();
            if (this.aK) {
                this.aK = false;
            }
            KeyboardUtils.m1055a(this);
        }
        switch (AnonymousClass20.f687b[this.al.f.ordinal()]) {
            case 1:
                this.au = true;
                if (SystemClock.uptimeMillis() - this.aq < 60000 && !this.as && !this.aB) {
                    this.aB = true;
                    HandlerDetour.a(this.ay, this.bx, -682096724);
                    break;
                }
                m875A();
                break;
            case 2:
                if (!this.aB) {
                    this.aB = true;
                    HandlerDetour.a(this.ay, this.bx, 1496190202);
                    break;
                }
                break;
            default:
                if (this.av) {
                    this.aY.performClick();
                    this.av = false;
                    break;
                }
                break;
        }
        FeedPerfLogger feedPerfLogger = this.f604q.a;
        if (feedPerfLogger.j.l(655361, "NNFColdStart")) {
            feedPerfLogger.j.c(655455, "NNFCold_LoginActivityEndToEnd");
        } else {
            feedPerfLogger.j.f(655457, "NNFWarm_LoginActivityEndToEnd");
        }
        LogUtils.c(-1227903049, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1188533647);
        super.onPause();
        this.ao = false;
        if (!(this.aC == null || this.aD == null)) {
            HandlerDetour.a(this.aC, this.aD);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 407760909, a);
    }

    public void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1890210279);
        if (this.aR != null) {
            CustomViewUtils.a(this.aR, this.bt);
        }
        super.onStop();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1546997944, a);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 389340934);
        if (isFinishing() && this.f605r != null && this.f605r.e() && FacebookAuthenticationService.m1123a(this) == 0) {
            FacebookAuthenticationService.m1125a(getIntent(), 400, "User canceled");
        }
        if (this.al != null) {
            this.al.b(this.am);
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1013930275, a);
    }

    public boolean onSearchRequested() {
        return true;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.an != null) {
            bundle.putString("nux_id", this.an);
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        this.an = bundle.getString("nux_id");
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -895890450);
        int id = view.getId();
        if (id == 2131561792) {
            m897a(LoginState.PASSWORD_ENTRY);
        } else if (id == 2131561795) {
            m897a(LoginState.LOGIN_APPROVALS_CODE_ENTRY);
        } else if (id == 2131561800 || id == 2131561801) {
            KeyboardUtils.m1055a(this);
            this.f609v.a(AccountRegistrationActivity.m1182a((Context) this, getClass().getSimpleName()), this);
        } else if (id == 2131560918) {
            m878D();
        } else if (id != 2131561784) {
            if (id == 2131561785) {
                m898a(UiState.PASSWORD_AUTH_UI);
            } else if (id == 2131561776) {
                Intent intent = new Intent(this, LanguageSwitcherActivity.class);
                intent.putExtra("calling_intent", LanguageSwitcherConstants$INTENT_SOURCE.LOGIN.name());
                this.f609v.a(intent, this);
            } else if (id == 2131561779) {
                ((LanguageSwitcherLoginLogger) this.f592P.get()).m1117c();
                m916b((String) this.bs.get(0));
            } else if (id == 2131561780) {
                ((LanguageSwitcherLoginLogger) this.f592P.get()).m1117c();
                m916b((String) this.bs.get(1));
            } else if (id == 2131561781) {
                m882H();
            } else if (id == 2131561797) {
                m879E();
            } else if (id == 2131561791) {
                AnalyticsLogger analyticsLogger;
                HoneyClientEvent honeyClientEvent;
                if (this.aH) {
                    this.aH = false;
                    this.bq.setText(2131232482);
                    this.bq.setTransformationMethod(this.ab);
                    this.aP.setInputType(129);
                    this.aP.setSelection(this.aP.getText().length());
                    this.aP.setTypeface(Typeface.DEFAULT);
                    analyticsLogger = ((AccountRecoveryAnalyticsLogger) this.f599W.get()).f692a;
                    honeyClientEvent = new HoneyClientEvent(EventType.SHOW_PASSWORD_UNCHECKED.getEventName());
                    honeyClientEvent.c = "account_recovery";
                    analyticsLogger.b(honeyClientEvent, 1);
                } else {
                    this.aH = true;
                    this.bq.setText(2131232483);
                    this.bq.setTransformationMethod(this.ab);
                    this.aP.setInputType(145);
                    this.aP.setSelection(this.aP.getText().length());
                    this.aP.setTypeface(Typeface.DEFAULT);
                    analyticsLogger = ((AccountRecoveryAnalyticsLogger) this.f599W.get()).f692a;
                    honeyClientEvent = new HoneyClientEvent(EventType.SHOW_PASSWORD_CHECKED.getEventName());
                    honeyClientEvent.c = "account_recovery";
                    analyticsLogger.b(honeyClientEvent, 1);
                }
            } else if (id == 2131561796) {
                this.ba.setEnabled(false);
                m927c(this.aF, this.aJ);
            }
        }
        LogUtils.a(-1390881210, a);
    }

    private void m897a(LoginState loginState) {
        Object obj = this.aO.getText().toString();
        if (StringUtil.c(obj)) {
            KeyboardUtils.m1055a(this);
            Toaster.a(this, 2131232488);
            return;
        }
        String obj2;
        LoginParams loginParams = new LoginParams(this, Type.PASSWORD);
        loginParams.f713b = obj;
        if (loginState == LoginState.PASSWORD_ENTRY) {
            obj2 = this.aP.getText().toString();
            if (StringUtil.c(obj2)) {
                KeyboardUtils.m1055a(this);
                Toaster.a(this, 2131232480);
                return;
            }
        } else if (loginState == LoginState.TRANSIENT_AUTH_TOKEN_ENTRY) {
            obj2 = this.aE;
            if (!StringUtil.c(obj2) && this.aF != 0) {
                loginParams = new LoginParams(this, Type.TRANSIENT_TOKEN);
                loginParams.f713b = String.valueOf(this.aF);
            } else {
                return;
            }
        } else {
            obj2 = this.aQ.getText().toString();
            if (StringUtil.c(obj2)) {
                KeyboardUtils.m1055a(this);
                Toaster.a(this, 2131232493);
                return;
            }
        }
        loginParams.f715d = obj2;
        m919b(loginParams);
    }

    private void m896a(LoginParams loginParams) {
        this.f604q.c = true;
        m965t();
        if (loginParams.f713b == null) {
            loginParams.f713b = Long.toString(loginParams.f714c);
        }
        this.bh;
    }

    private void m919b(LoginParams loginParams) {
        m896a(loginParams);
        AuthLoginHelper.a(new PasswordCredentials(loginParams.f713b, loginParams.f715d, loginParams.f716e), "auth", this.al, this.am, new LoginCompleteFutureCallback(this));
    }

    private void m965t() {
        this.f603p.b(655386);
        this.f603p.b(2293779);
        this.f603p.a(2293779, "password");
        this.f603p.b(2293763);
        this.f603p.b(2293761);
        NUXAnalyticsLogger nUXAnalyticsLogger = this.f587K;
        nUXAnalyticsLogger.f641b.b(FunnelRegistry.f, Events.LOGIN_START.getEventName());
        FunnelRegistry.g.c = 600;
        nUXAnalyticsLogger.f641b.a(FunnelRegistry.g);
    }

    private void m913a(Throwable th, short s) {
        String message = th.getMessage();
        if (message == null) {
            message = th.toString();
        }
        this.f603p.a(2293761, message);
        this.f603p.b(2293761, s);
        m969v();
        this.f577A.a("FacebookLogin failure", th);
    }

    private void m967u() {
        this.f603p.d(2293761);
        m969v();
    }

    private void m969v() {
        this.f587K.m1007d();
        this.f603p.d(2293763);
        this.f603p.d(2293779);
        this.f603p.d(655386);
    }

    public static void m971w(FacebookLoginActivity facebookLoginActivity) {
        facebookLoginActivity.aq = SystemClock.uptimeMillis();
        facebookLoginActivity.as = false;
        facebookLoginActivity.at = false;
        facebookLoginActivity.au = false;
        if (!facebookLoginActivity.aB) {
            facebookLoginActivity.aB = true;
            HandlerDetour.b(facebookLoginActivity.ay, facebookLoginActivity.bx, 200, 1632326321);
        }
        facebookLoginActivity.m898a(UiState.LOGGING_IN);
    }

    private void m924b(boolean z) {
        int i;
        int i2 = 8;
        this.aW.setVisibility(z ? 0 : 8);
        if (this.aK) {
            z = false;
        }
        m931c(z);
        FbButton fbButton = this.bp;
        if (this.aK) {
            i = 0;
        } else {
            i = 8;
        }
        fbButton.setVisibility(i);
        FbButton fbButton2 = this.bo;
        if (!this.aK) {
            i2 = 0;
        }
        fbButton2.setVisibility(i2);
    }

    private void m931c(boolean z) {
        this.bm.setVisibility(z ? 0 : 8);
    }

    private void m936d(boolean z) {
        this.aA = z;
        m920b(this, z ? 0 : 8);
    }

    public static void m920b(FacebookLoginActivity facebookLoginActivity, int i) {
        if (facebookLoginActivity.aA) {
            if (facebookLoginActivity.aX != null) {
                Object obj;
                SuggestedLanguagesListHelper suggestedLanguagesListHelper = facebookLoginActivity.f591O;
                if (suggestedLanguagesListHelper.f652g == null || suggestedLanguagesListHelper.f652g.size() < 2) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    if (i == 0) {
                        facebookLoginActivity.m884J();
                    }
                    facebookLoginActivity.aX.setVisibility(i);
                    return;
                }
            }
            if (facebookLoginActivity.bi != null) {
                facebookLoginActivity.bi.setVisibility(i);
            }
        }
    }

    private void m973x() {
        this.f585I.a();
    }

    private void m975y() {
        String str;
        final long currentTimeMillis = System.currentTimeMillis();
        ViewerContext a = ((LoggedInUserSessionManager) this.af.get()).a();
        if (a != null) {
            str = a.mUserId;
        } else {
            this.f577A.a("ViewerContextNullAfterLogin", "LoggedInUserAuthDataStore returned null ViewerContext after login.");
            str = null;
        }
        ExecutorDetour.a(this.f612y, new Runnable(this) {
            final /* synthetic */ FacebookLoginActivity f736c;

            public void run() {
                Map f = Maps.f();
                LoginActivityHelper loginActivityHelper = this.f736c.f605r;
                Context context = this.f736c.f584H;
                f.put("prev_uid_hashed", loginActivityHelper.g());
                f.put("curr_uid_hashed", str == null ? null : SecureHashUtil.a(str));
                loginActivityHelper = this.f736c.f605r;
                context = this.f736c.f584H;
                f.put("prev_user_login_time", Long.toString(loginActivityHelper.h()));
                loginActivityHelper = this.f736c.f605r;
                context = this.f736c.f584H;
                f.put("prev_user_logout_time", Long.toString(loginActivityHelper.i()));
                ((SemTrackingLogger) this.f736c.ac.get()).a();
                this.f736c.f585I.c.a(f);
                this.f736c.f606s.edit().a(FbandroidPrefKeys.m, currentTimeMillis).commit();
            }
        }, 1555916214);
    }

    private void m977z() {
        ViewerContext a = ((LoggedInUserSessionManager) this.af.get()).a();
        if (a != null) {
            if (!this.f600X.m1027b()) {
                CodeGeneratorActivity.m1034a(this.f606s, this.f607t, this.f608u, a.mUserId, false);
            } else if (this.f600X.m1026a()) {
                CodeGeneratorActivity.m1034a(this.f606s, this.f607t, this.f608u, a.mUserId, true);
            }
        }
    }

    private void m875A() {
        this.f603p.b(2293781);
        Intent b = this.f605r.b();
        this.an = this.f605r.g;
        if (this.an == null) {
            this.f603p.b(2293781, (short) 51);
        } else {
            this.f603p.a(2293781, this.an);
            this.f603p.b(2293781, (short) 2);
        }
        LoginExtras loginExtras = new LoginExtras(this, getIntent());
        this.f603p.b(2293763, (short) 2);
        this.f587K.m1007d();
        if (b != null) {
            this.f603p.b(2293774);
            this.f603p.a(2293774, this.an);
        }
        this.f581E.a(loginExtras.m1121a(), b);
    }

    private void m889a(Uri uri) {
        try {
            this.f609v.b(new Intent("android.intent.action.VIEW", uri), this);
        } catch (ActivityNotFoundException e) {
            ((Toaster) this.aa.get()).a(new ToastBuilder(2131232508));
            this.f577A.a("LoginPageBrowserMissing", "ActivityNotFoundException when attempting to open web view to " + uri.getPath());
        }
    }

    public static void m921b(FacebookLoginActivity facebookLoginActivity, Throwable th) {
        int i;
        facebookLoginActivity.f583G.f638t = facebookLoginActivity;
        if (th instanceof ApiException) {
            ApiException apiException = (ApiException) th;
            int a = apiException.m10826b().m10832a();
            ErrorData a2 = LoginErrorHandlingHelper.m993a(apiException.m10826b().m10835d());
            boolean z;
            switch (a) {
                case 400:
                    facebookLoginActivity.m967u();
                    facebookLoginActivity.m923b(a2);
                    i = 0;
                    break;
                case 401:
                    facebookLoginActivity.m967u();
                    if (!facebookLoginActivity.aL) {
                        facebookLoginActivity.m906a(a2);
                        i = 0;
                        break;
                    }
                    facebookLoginActivity.m876B();
                    z = true;
                    break;
                case 406:
                    facebookLoginActivity.m967u();
                    facebookLoginActivity.aL = true;
                    facebookLoginActivity.m930c(a2);
                    if (StringUtil.a(a2.f720d)) {
                        facebookLoginActivity.ba.setVisibility(8);
                    } else {
                        facebookLoginActivity.aJ = a2.f720d;
                        facebookLoginActivity.ba.setVisibility(0);
                    }
                    facebookLoginActivity.aF = a2.f717a;
                    facebookLoginActivity.f583G.m1000a(a2);
                    z = true;
                    break;
                default:
                    facebookLoginActivity.m913a(th, (short) 87);
                    if (!facebookLoginActivity.f583G.m1004a(a, a2)) {
                        facebookLoginActivity.f583G.m999a(apiException);
                    }
                    i = 0;
                    break;
            }
        } else if (th instanceof IOException) {
            facebookLoginActivity.m913a(th, (short) 97);
            IOException iOException = (IOException) th;
            if (!(facebookLoginActivity.ao && iOException != null && facebookLoginActivity.f579C.m992b(facebookLoginActivity, iOException.getMessage()))) {
                facebookLoginActivity.f583G.m1001a(iOException);
            }
            i = 0;
        } else {
            facebookLoginActivity.m913a(th, (short) 105);
            facebookLoginActivity.f583G.m1003a(th);
            i = 0;
        }
        if (i != 0) {
            facebookLoginActivity.aQ.setText("");
            facebookLoginActivity.m898a(UiState.LOGIN_APPPROVAL_UI);
        } else {
            facebookLoginActivity.aP.setText("");
            facebookLoginActivity.m898a(UiState.PASSWORD_AUTH_UI);
        }
        facebookLoginActivity.at = true;
    }

    private void m876B() {
        this.f583G.m1002a(getString(2131232496), getString(2131232498));
    }

    private void m906a(final ErrorData errorData) {
        this.ar++;
        if (this.ar >= 3) {
            AlertDialogs.m1102a((Context) this, getString(2131232463), 17301543, getString(2131232465), getString(2131232466), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ FacebookLoginActivity f732b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(this.f732b, AccountRecoveryActivity.class);
                    Bundle c = FacebookLoginActivity.m916b(errorData.f725i);
                    if (c != null) {
                        intent.putExtras(c);
                    }
                    this.f732b.f609v.a(intent, 2, this.f732b);
                    ((AccountRecoveryAnalyticsLogger) this.f732b.f599W.get()).m1063e();
                }
            }, getString(2131232467), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ FacebookLoginActivity f733a;

                {
                    this.f733a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }, null, false).show();
        } else {
            this.f583G.m1004a(401, errorData);
        }
    }

    private void m923b(ErrorData errorData) {
        if (errorData.f726j != null) {
            this.aO.setText(errorData.f726j);
        }
        this.f583G.m1004a(400, errorData);
    }

    private void m930c(ErrorData errorData) {
        long j = errorData.f717a;
        if (j != 0) {
            String a = errorData.f724h != null ? errorData.f724h : this.f606s.a(AuthPrefKeys.f, null);
            if (!Strings.isNullOrEmpty(a) && !Strings.isNullOrEmpty(errorData.f719c)) {
                this.aE = errorData.f719c;
                this.aF = j;
                m918b(j, a);
            }
        }
    }

    private void m918b(final long j, final String str) {
        if (!(this.aC == null || this.aD == null)) {
            HandlerDetour.a(this.aC, this.aD);
        }
        this.aD = new Runnable(this) {
            final /* synthetic */ FacebookLoginActivity f742c;

            public void run() {
                if (this.f742c.ak != UiState.LOGGING_IN) {
                    this.f742c.m979a(j, str);
                    HandlerDetour.b(this.f742c.aC, this, 10000, -257091429);
                }
            }
        };
        if (this.aC != null) {
            HandlerDetour.b(this.aC, this.aD, 10000, -995510681);
        }
    }

    public final void m979a(long j, String str) {
        Parcelable checkApprovedMachineParams = new CheckApprovedMachineParams(j, str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("checkApprovedMachineParams", checkApprovedMachineParams);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f608u, "check_approved_machine", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(FacebookLoginActivity.class), -1884798006).a(), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ FacebookLoginActivity f790a;

            {
                this.f790a = r1;
            }

            public void onSuccess(Object obj) {
                ImmutableList copyOf = ImmutableList.copyOf(((CheckApprovedMachineMethod.Result) ((OperationResult) obj).h()).a);
                if (copyOf.size() > 0 && ((ApprovalStatus) copyOf.get(0)).a.booleanValue()) {
                    this.f790a.runOnUiThread(new 1(this));
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f612y);
    }

    private void m927c(long j, String str) {
        Parcelable loginApprovalResendCodeParams = new LoginApprovalResendCodeParams(j, str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("loginApprovalsResendCodeParams", loginApprovalResendCodeParams);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f608u, "login_approval_resend_code", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(FacebookLoginActivity.class), 1928760055).a(), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ FacebookLoginActivity f739a;

            {
                this.f739a = r1;
            }

            public void onSuccess(Object obj) {
                this.f739a.runOnUiThread(new 1(this));
            }

            public void onFailure(Throwable th) {
                String c;
                String d;
                if (th.getCause() instanceof ApiException) {
                    ApiException apiException = (ApiException) th.getCause();
                    c = apiException.m10827c();
                    d = apiException.m10828d();
                } else {
                    c = "";
                    d = th.getCause().toString();
                }
                this.f739a.runOnUiThread(new 2(this, c, d));
            }
        }, this.f612y);
    }

    private void m912a(String str, String str2) {
        new Builder(this).m14337a((CharSequence) str).m14346b((CharSequence) str2).mo962a(2131230756, null).m14339a(true).m14349b();
    }

    public void onBackPressed() {
        if (!(this.aC == null || this.aD == null)) {
            HandlerDetour.a(this.aC, this.aD);
        }
        if (this.ak != UiState.LOGGING_IN) {
            if (this.aL) {
                this.aP.setText("");
                this.aQ.setText("");
                this.aL = false;
                this.at = true;
                m898a(UiState.PASSWORD_AUTH_UI);
                return;
            } else if (getIntent().getBooleanExtra("redirected_from_dbl", false) && (this.f580D.e() || this.f580D.d())) {
                this.f609v.a(new Intent(this, DeviceBasedLoginActivity.class), this);
            }
        }
        finish();
    }

    public final String m978a() {
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aR != null && this.aR.getVisibility() == 0) {
            if (this.bg != null && this.bg.getVisibility() == 0) {
                this.bg.setLayoutParams(new LayoutParams(-1, 0, 1.0f));
            }
            this.aO;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.ap.getVisibility() == 0) {
            return true;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.ap.getVisibility() == 0) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public final String am_() {
        return "login_screen";
    }

    private boolean m877C() {
        return this.f598V.get() != TriState.YES;
    }

    private void m878D() {
        AnalyticsLogger analyticsLogger = ((AccountRecoveryAnalyticsLogger) this.f599W.get()).f692a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.FORGOT_PASSWORD_CLICK.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent, 1);
        if (m877C()) {
            Intent intent = new Intent(getApplicationContext(), AccountRecoveryActivity.class);
            ((AccountRecoveryAnalyticsLogger) this.f599W.get()).m1063e();
            this.f609v.a(intent, 2, this);
            return;
        }
        Uri b = m915b(Uri.parse(this.f589M.m1013b(getApplicationContext(), "login/identify?ctx=recover&allow_token_login=1")));
        if (this.f598V.get() == TriState.YES) {
            DeviceOwnerDataBackgroundHelper deviceOwnerDataBackgroundHelper = (DeviceOwnerDataBackgroundHelper) this.f601Y.get();
            AnalyticsLogger analyticsLogger2 = deviceOwnerDataBackgroundHelper.f709f.f692a;
            HoneyClientEvent honeyClientEvent2 = new HoneyClientEvent(EventType.BACKGROUND_FETCH_DEVICE_DATA.getEventName());
            honeyClientEvent2.c = "account_recovery";
            analyticsLogger2.b(honeyClientEvent2, 1);
            Futures.a(deviceOwnerDataBackgroundHelper.f705b.a(), new 1(deviceOwnerDataBackgroundHelper), deviceOwnerDataBackgroundHelper.f707d);
        }
        AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = (AccountRecoveryAnalyticsLogger) this.f599W.get();
        analyticsLogger = accountRecoveryAnalyticsLogger.f692a;
        honeyClientEvent = new HoneyClientEvent(EventType.MSITE_ACCOUNT_RECOVERY.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent, 1);
        ((InitialAppLaunchExperimentLogger) accountRecoveryAnalyticsLogger.f693b.get()).m988a(EventType.FB4A_ACCOUNT_RECOVERY.getEventName(), false);
        this.f583G.m998a();
        m889a(b);
    }

    private void m879E() {
        AnalyticsLogger analyticsLogger = ((AccountRecoveryAnalyticsLogger) this.f599W.get()).f692a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.HELP_CENTER_CLICK.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent, 1);
        m889a(Uri.parse(this.f589M.m1013b(getApplicationContext(), "help/android-app?ref=Android")));
    }

    private static Bundle m916b(String str) {
        if (!StringUtil.a(str)) {
            String queryParameter = Uri.parse(str).getQueryParameter("cuid");
            if (queryParameter != null) {
                Bundle bundle = new Bundle();
                bundle.putString("cuid", queryParameter);
                return bundle;
            }
        }
        return null;
    }

    private Uri m915b(Uri uri) {
        AnalyticsLogger analyticsLogger;
        HoneyClientEvent honeyClientEvent;
        Uri build = uri.buildUpon().appendQueryParameter("device_id", this.f594R.a()).build();
        TriState a = this.f595S.m1023a((TriState) this.f596T.get(), (TriState) this.f597U.get(), aj);
        if (this.f595S.f654b == TriState.YES) {
            analyticsLogger = ((AccountRecoveryAnalyticsLogger) this.f599W.get()).f692a;
            honeyClientEvent = new HoneyClientEvent(EventType.TEST_BOUNCE_FROM_MSITE.getEventName());
            honeyClientEvent.c = "account_recovery";
            analyticsLogger.b(honeyClientEvent, 1);
        } else if (this.f595S.f654b == TriState.NO) {
            analyticsLogger = ((AccountRecoveryAnalyticsLogger) this.f599W.get()).f692a;
            honeyClientEvent = new HoneyClientEvent(EventType.UNSET_BOUNCE_FROM_MSITE.getEventName());
            honeyClientEvent.c = "account_recovery";
            analyticsLogger.b(honeyClientEvent, 1);
        }
        if (a != TriState.YES) {
            return build;
        }
        analyticsLogger = ((AccountRecoveryAnalyticsLogger) this.f599W.get()).f692a;
        honeyClientEvent = new HoneyClientEvent(EventType.BOUNCE_FROM_MSITE.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent, 1);
        return build.buildUpon().appendQueryParameter("btp", "app").build();
    }

    private void m880F() {
        if (this.aG != null) {
        }
    }

    private void m881G() {
    }

    private int m933d(int i) {
        return SizeUtil.a(this.f584H, (float) i);
    }

    private void m882H() {
        LanguageSwitcherList a = ((LanguageSwitcherListHelper) this.ae.get()).m1109a();
        final String[] a2 = a.m1111a();
        Builder builder = new Builder(this);
        builder.m14340a(a.m1112b(), a.f760b, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ FacebookLoginActivity f762b;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                FacebookLoginActivity.m916b(a2[i]);
            }
        });
        builder.mo966b(getText(2131237528), null);
        AlertDialog a3 = builder.mo964a();
        a3.show();
        a3.f13426a.f.setSelection(0);
        ((LanguageSwitcherLoginLogger) this.f592P.get()).f763a.a(LanguageSwitcherLoginLogger.m1113a("language_switcher_login_more_clicked"));
    }

    public static void m929c(FacebookLoginActivity facebookLoginActivity, String str) {
        String locale = facebookLoginActivity.ad.a().toString();
        facebookLoginActivity.f590N.a(str);
        LanguageSwitcherLoginLogger languageSwitcherLoginLogger = (LanguageSwitcherLoginLogger) facebookLoginActivity.f592P.get();
        HoneyClientEvent a = LanguageSwitcherLoginLogger.m1113a("language_switcher_login_language_selected");
        a.b("old_language", str).b("new_language", locale);
        languageSwitcherLoginLogger.f763a.a(a);
        facebookLoginActivity.m883I();
        facebookLoginActivity.m884J();
    }

    private void m883I() {
        this.bo.setText(2131232485);
        this.bp.setText(2131232485);
        m895a(this.bm, 2131232486);
        m895a(this.bn, 2131232502);
        m895a(this.bq, this.aH ? 2131232483 : 2131232482);
        m895a(this.bl, 2131232509);
        m894a(this.aO, this.f588L.booleanValue() ? 2131232460 : 2131232459);
        m894a(this.aP, 2131236271);
        m895a(this.aY, 2131232481);
    }

    private void m895a(TextView textView, int i) {
        textView.setText(getString(i));
    }

    private void m894a(EditText editText, int i) {
        editText.setHint(getString(i));
    }

    private void m884J() {
        String locale = this.ad.b().toString();
        List arrayList = new ArrayList();
        ImmutableList<String> c = this.f591O.m1020c();
        for (String str : c) {
            if (c.size() <= 2 || !locale.equals(str)) {
                arrayList.add(str);
            }
        }
        this.bs = arrayList.subList(0, 2);
        this.bj = (TextView) a(2131561779);
        this.bj.setText(LocaleUtil.a(LocaleUtil.a((String) this.bs.get(0))));
        this.bj.setOnClickListener(this);
        this.bk = (TextView) a(2131561780);
        this.bk.setText(LocaleUtil.a(LocaleUtil.a((String) this.bs.get(1))));
        this.bk.setOnClickListener(this);
        this.bl = (TextView) a(2131561781);
        this.bl.setOnClickListener(this);
        if (!this.aI) {
            LanguageSwitcherLoginLogger languageSwitcherLoginLogger = (LanguageSwitcherLoginLogger) this.f592P.get();
            String str2 = (String) this.bs.get(0);
            String str3 = (String) this.bs.get(1);
            HoneyClientEvent a = LanguageSwitcherLoginLogger.m1113a("language_switcher_login_displayed");
            a.b("current_device_locale", String.valueOf(Locales.e())).b("network_country", languageSwitcherLoginLogger.f765c.getNetworkCountryIso()).b("sim_country", languageSwitcherLoginLogger.f765c.getSimCountryIso()).b("first_language", str2).b("second_language", str3).b("current_app_locale", locale);
            languageSwitcherLoginLogger.f763a.a(a);
            this.aI = true;
        }
    }

    public static void m885K(FacebookLoginActivity facebookLoginActivity) {
        if (!facebookLoginActivity.ao || facebookLoginActivity.at) {
            facebookLoginActivity.aB = false;
        } else if (SystemClock.uptimeMillis() - facebookLoginActivity.aq >= 60000 || facebookLoginActivity.as) {
            if (facebookLoginActivity.au) {
                facebookLoginActivity.m975y();
                ((ClientPeriodicEventReporterManager) facebookLoginActivity.ah.get()).a();
                if (facebookLoginActivity.f605r.e()) {
                    FacebookAuthenticationService.m1126a(facebookLoginActivity.getIntent(), ((LoggedInUserSessionManager) facebookLoginActivity.af.get()).a().mUsername);
                }
                facebookLoginActivity.m977z();
                facebookLoginActivity.m875A();
            } else {
                facebookLoginActivity.at = true;
                if (facebookLoginActivity.ao) {
                    facebookLoginActivity.f583G.m1002a(facebookLoginActivity.getString(2131232474), facebookLoginActivity.getString(2131232477));
                }
                facebookLoginActivity.m898a(UiState.PASSWORD_AUTH_UI);
            }
            facebookLoginActivity.aB = false;
        } else {
            HandlerDetour.b(facebookLoginActivity.ay, facebookLoginActivity.bx, 500, -671021011);
        }
    }
}
