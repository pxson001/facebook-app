package com.facebook.katana;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.credentials.DeviceBasedLoginCredentials;
import com.facebook.auth.credentials.DeviceBasedLoginCredentials.Type;
import com.facebook.auth.credentials.LoginCredentials;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.devicebasedlogin.logging.DBLLoggerHelper;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.LoginErrorHandlingHelper.ErrorData;
import com.facebook.katana.annotations.DBLFragment;
import com.facebook.katana.common.ForegroundStatusProvider;
import com.facebook.katana.dbl.AuthLoginHelper;
import com.facebook.katana.dbl.DBLRequestHelper;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.katana.dbl.DeviceBasedLoginListener;
import com.facebook.katana.login.ComponentName_LoginActivityComponentMethodAutoProvider;
import com.facebook.katana.login.LoginActivityComponent;
import com.facebook.katana.login.LoginActivityHelper;
import com.facebook.katana.service.AppSession;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.resources.IFbResourcesNotRequired;
import com.facebook.ssl.ui.SSLDialogHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: trace_ids */
public class DeviceBasedLoginActivity extends FbFragmentActivity implements IAuthNotRequired, ForegroundStatusProvider, DeviceBasedLoginListener, IFbResourcesNotRequired {
    public static final Class<?> f810O = DeviceBasedLoginActivity.class;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager f811A;
    @Inject
    DBLRequestHelper f812B;
    Bundle f813C;
    public boolean f814D;
    public boolean f815E;
    private final Handler f816F = new Handler();
    private AppSession f817G;
    public boolean f818H;
    private long f819I;
    private SelfRegistrableReceiverImpl f820J;
    public boolean f821K = false;
    private DeviceBasedLoginAccountsListFragment f822L;
    private int f823M = 0;
    public Boolean f824N = Boolean.valueOf(false);
    private LoginState f825P;
    private final Runnable f826Q = new 1(this);
    @Inject
    QuickPerformanceLogger f827p;
    @Inject
    LoginActivityHelper f828q;
    @Inject
    AuthLoginHelper f829r;
    @Inject
    SecureContextHelper f830s;
    @Inject
    @DBLFragment
    String f831t;
    @Inject
    DBLStorageAndRetrievalHelper f832u;
    @Inject
    @LoggedInUser
    Provider<User> f833v;
    @Inject
    LoginErrorHandlingHelper f834w;
    @Inject
    SSLDialogHelper f835x;
    @Inject
    DBLLoggerHelper f836y;
    @LoginActivityComponent
    @Inject
    ComponentName f837z;

    private static <T extends Context> void m1142a(Class<T> cls, T t) {
        m1143a((Object) t, (Context) t);
    }

    public static void m1143a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DeviceBasedLoginActivity) obj).m1141a(QuickPerformanceLoggerMethodAutoProvider.a(fbInjector), LoginActivityHelper.b(fbInjector), AuthLoginHelper.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), String_DBLFragmentMethodAutoProvider.a(fbInjector), DBLStorageAndRetrievalHelper.b(fbInjector), IdBasedProvider.a(fbInjector, 3595), LoginErrorHandlingHelper.m997b(fbInjector), SSLDialogHelper.m990b(fbInjector), DBLLoggerHelper.b(fbInjector), ComponentName_LoginActivityComponentMethodAutoProvider.b(fbInjector), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector), DBLRequestHelper.b(fbInjector));
    }

    @SuppressLint({"DeprecatedClass"})
    public final void m1171b(Bundle bundle) {
        Class cls = DeviceBasedLoginActivity.class;
        m1143a((Object) this, (Context) this);
        this.f813C = getIntent().getExtras();
        if (this.f813C == null) {
            this.f813C = new Bundle();
        }
        if (this.f833v.get() == null) {
            this.f825P = LoginState.DEFAULT;
            Fragment a = Fragment.a(this, this.f831t, null);
            setContentView(2130903850);
            this.f822L = (DeviceBasedLoginAccountsListFragment) a;
            this.f822L.f = this;
            kO_().a().a(2131558429, a).b();
            this.f817G = AppSession.a(getApplicationContext());
            this.f820J = this.f811A.a().a("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE", new 2(this)).a();
        } else if (this.f832u.f().booleanValue()) {
            m1161o(this);
        } else {
            mo79b();
        }
    }

    public static void m1146b(DeviceBasedLoginActivity deviceBasedLoginActivity, Fragment fragment) {
        Preconditions.checkArgument(fragment instanceof DeviceBasedLoginWaitListener);
        deviceBasedLoginActivity.kO_().a().b(2131558429, fragment).c();
    }

    public final void mo76a(DBLFacebookCredentials dBLFacebookCredentials) {
        Bundle bundle = new Bundle();
        bundle.putString("fbid", dBLFacebookCredentials.mUserId);
        if ("password_account".equals(dBLFacebookCredentials.mNonce)) {
            this.f825P = LoginState.PASSWORD_ACCOUNT;
            bundle.putString("account_type", "password_account");
            m1137a(dBLFacebookCredentials, 0);
        } else if ("".equals(dBLFacebookCredentials.mNonce)) {
            this.f825P = LoginState.NO_NONCE_EXISTS;
            bundle.putBoolean("placeholder", true);
            if (dBLFacebookCredentials.mIsPinSet.booleanValue()) {
                bundle.putBoolean("pin", true);
                m1137a(dBLFacebookCredentials, 1);
            } else {
                bundle.putBoolean("pin", false);
                m1137a(dBLFacebookCredentials, 2);
            }
        } else {
            bundle.putBoolean("placeholder", false);
            if (dBLFacebookCredentials.mIsPinSet.booleanValue()) {
                bundle.putBoolean("pin", true);
                this.f825P = LoginState.PASSCODE_ENTRY;
                Fragment deviceBasedLoginFragment = new DeviceBasedLoginFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("dbl_account_details", dBLFacebookCredentials);
                deviceBasedLoginFragment.g(bundle2);
                deviceBasedLoginFragment.c = this;
                m1146b(this, deviceBasedLoginFragment);
            } else {
                bundle.putBoolean("pin", false);
                this.f825P = LoginState.NO_PASSCODE_SET;
                mo77a(new DeviceBasedLoginCredentials(dBLFacebookCredentials.mUserId, dBLFacebookCredentials.mNonce, "", Type.DEVICE_BASED_LOGIN_TYPE), dBLFacebookCredentials);
            }
        }
        this.f836y.a("dbl_user_chooser_selected_user", bundle);
    }

    public final void mo77a(DeviceBasedLoginCredentials deviceBasedLoginCredentials, DBLFacebookCredentials dBLFacebookCredentials) {
        this.f827p.b(2293779);
        this.f827p.a(2293779, dBLFacebookCredentials.mIsPinSet.booleanValue() ? "dbl_pin" : "dbl_nonce");
        m1138a((LoginCredentials) deviceBasedLoginCredentials, "device_based_login", dBLFacebookCredentials, 0);
    }

    public final void mo74a() {
        mo79b();
    }

    public final void mo80d() {
        if (this.f832u.d() == 1) {
            DBLFacebookCredentials dBLFacebookCredentials;
            List a = this.f832u.a();
            if (a.isEmpty()) {
                dBLFacebookCredentials = null;
            } else {
                dBLFacebookCredentials = (DBLFacebookCredentials) a.get(0);
            }
            DBLFacebookCredentials dBLFacebookCredentials2 = dBLFacebookCredentials;
            Bundle bundle = new Bundle();
            bundle.putString("fbid", dBLFacebookCredentials2.mUserId);
            if (this.f825P == LoginState.PASSWORD_ACCOUNT) {
                bundle.putString("account_type", "password_account");
            } else if (dBLFacebookCredentials2.mIsPinSet.booleanValue()) {
                bundle.putString("view", "pin");
            } else {
                bundle.putString("view", "no_pin");
            }
            this.f836y.a("dbl_settings_displayed", bundle);
            Intent intent = new Intent(this, DBLAccountSettingsActivity.class);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("dbl_account_details", dBLFacebookCredentials2);
            intent.putExtras(bundle2);
            this.f830s.a(intent, this);
            return;
        }
        this.f836y.a("dbl_settings_list_displayed", null);
        this.f830s.a(new Intent(this, DBLLoginSettingsActivity.class), this);
    }

    public static void m1157k(DeviceBasedLoginActivity deviceBasedLoginActivity) {
        if (deviceBasedLoginActivity.f814D) {
            m1160n(deviceBasedLoginActivity);
        } else {
            deviceBasedLoginActivity.f815E = true;
            if (deviceBasedLoginActivity.f824N.booleanValue()) {
                deviceBasedLoginActivity.f834w.m1002a(deviceBasedLoginActivity.getString(2131232474), deviceBasedLoginActivity.getString(2131232477));
            }
        }
        deviceBasedLoginActivity.f818H = false;
    }

    public final void mo78a(PasswordCredentials passwordCredentials, DBLFacebookCredentials dBLFacebookCredentials, int i) {
        this.f827p.b(2293779);
        this.f827p.a(2293779, "dbl_password");
        m1138a((LoginCredentials) passwordCredentials, "auth", dBLFacebookCredentials, i);
    }

    @SuppressLint({"DeprecatedClass"})
    private void m1138a(LoginCredentials loginCredentials, String str, DBLFacebookCredentials dBLFacebookCredentials, int i) {
        if (m1164r(this)) {
            m1162p(this).a();
        }
        m1158l();
        AuthLoginHelper.a(loginCredentials, str, this.f817G, new LoginAppSessionListener(this, dBLFacebookCredentials, i), null);
    }

    private void m1158l() {
        this.f820J.b();
        this.f819I = SystemClock.uptimeMillis();
        this.f821K = false;
        this.f815E = false;
        this.f814D = false;
        if (!this.f818H) {
            this.f818H = true;
            HandlerDetour.b(this.f816F, this.f826Q, 60000, -484304726);
        }
    }

    public void onBackPressed() {
        if (this.f825P == LoginState.DEFAULT || this.f825P.equals(LoginState.NO_PASSCODE_SET)) {
            setResult(0);
            finish();
        } else {
            DeviceBasedLoginWaitListener p = m1162p(this);
            Fragment deviceBasedLoginAccountsListFragment = new DeviceBasedLoginAccountsListFragment();
            Bundle bundle = new Bundle();
            if (this.f825P == LoginState.PASSCODE_ENTRY && p != null && (p instanceof DeviceBasedLoginFragment)) {
                bundle.putString("previous_login_state", "login_state_passcode_entry");
                DeviceBasedLoginFragment deviceBasedLoginFragment = (DeviceBasedLoginFragment) p;
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(600);
                deviceBasedLoginFragment.f.findViewById(2131558927).startAnimation(alphaAnimation);
                deviceBasedLoginFragment.d.c();
                bundle.putParcelable("dbl_account_details", ((DeviceBasedLoginFragment) p).b);
                deviceBasedLoginAccountsListFragment.g(bundle);
            }
            deviceBasedLoginAccountsListFragment.f = this;
            m1146b(this, deviceBasedLoginAccountsListFragment);
            this.f825P = LoginState.DEFAULT;
        }
        this.f823M = 0;
    }

    public final void mo79b() {
        Intent component = new Intent().setComponent(this.f837z);
        this.f813C.putBoolean("redirected_from_dbl", true);
        component.putExtras(this.f813C);
        if (this.f813C.getBoolean("login_redirect", false)) {
            this.f830s.a(component, this);
            finish();
            return;
        }
        this.f830s.a(component, 2210, this);
    }

    private void m1141a(QuickPerformanceLogger quickPerformanceLogger, LoginActivityHelper loginActivityHelper, AuthLoginHelper authLoginHelper, SecureContextHelper secureContextHelper, String str, DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper, Provider<User> provider, LoginErrorHandlingHelper loginErrorHandlingHelper, SSLDialogHelper sSLDialogHelper, DBLLoggerHelper dBLLoggerHelper, ComponentName componentName, FbBroadcastManager fbBroadcastManager, DBLRequestHelper dBLRequestHelper) {
        this.f827p = quickPerformanceLogger;
        this.f828q = loginActivityHelper;
        this.f829r = authLoginHelper;
        this.f830s = secureContextHelper;
        this.f831t = str;
        this.f832u = dBLStorageAndRetrievalHelper;
        this.f833v = provider;
        this.f834w = loginErrorHandlingHelper;
        this.f835x = sSLDialogHelper;
        this.f836y = dBLLoggerHelper;
        this.f837z = componentName;
        this.f811A = fbBroadcastManager;
        this.f812B = dBLRequestHelper;
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1769676495);
        super.onResume();
        this.f823M = 0;
        this.f824N = Boolean.valueOf(true);
        if (this.f817G != null) {
            switch (5.a[this.f817G.f.ordinal()]) {
                case 1:
                    this.f814D = true;
                    if (m1159m() < 60000 && !this.f821K && !this.f818H) {
                        this.f818H = true;
                        HandlerDetour.b(this.f816F, this.f826Q, 60000 - m1159m(), -914923314);
                        break;
                    }
                    m1160n(this);
                    break;
                case 2:
                    if (m1159m() < 60000 && !this.f818H) {
                        this.f818H = true;
                        HandlerDetour.b(this.f816F, this.f826Q, 60000 - m1159m(), 2044964345);
                        break;
                    }
            }
        }
        LogUtils.c(-1617553460, a);
    }

    private long m1159m() {
        return SystemClock.uptimeMillis() - this.f819I;
    }

    public static void m1160n(DeviceBasedLoginActivity deviceBasedLoginActivity) {
        deviceBasedLoginActivity.f829r.a(deviceBasedLoginActivity.f813C, deviceBasedLoginActivity.f828q.b());
    }

    private void m1144a(Throwable th, DBLFacebookCredentials dBLFacebookCredentials, int i) {
        this.f827p.d(2293779);
        this.f834w.f638t = this;
        if (m1164r(this)) {
            if (th instanceof ApiException) {
                ApiException apiException = (ApiException) th;
                int a = apiException.m10826b().m10832a();
                ErrorData a2 = LoginErrorHandlingHelper.m993a(apiException.m10826b().m10835d());
                switch (a) {
                    case 401:
                        if (this.f825P != LoginState.NO_PASSCODE_SET) {
                            if (this.f825P != LoginState.PASSCODE_ENTRY) {
                                if (this.f825P != LoginState.PASSWORD_ENTRY && this.f825P != LoginState.PASSWORD_ACCOUNT) {
                                    if (this.f825P == LoginState.LOGIN_APPROVALS_CODE_ENTRY) {
                                        break;
                                    }
                                }
                                getString(2131232464);
                                DBLPasswordLoginFragment dBLPasswordLoginFragment = (DBLPasswordLoginFragment) m1162p(this);
                                if (dBLPasswordLoginFragment != null) {
                                    dBLPasswordLoginFragment.g(2131236244);
                                    break;
                                }
                            }
                            this.f823M++;
                            DeviceBasedLoginFragment deviceBasedLoginFragment = (DeviceBasedLoginFragment) m1162p(this);
                            if (deviceBasedLoginFragment != null) {
                                deviceBasedLoginFragment.h = 2131236273;
                                if (deviceBasedLoginFragment.T != null) {
                                    ((TextView) deviceBasedLoginFragment.T.findViewById(2131558927)).setText(deviceBasedLoginFragment.h);
                                }
                                break;
                            }
                        }
                        this.f825P = LoginState.PASSWORD_ENTRY;
                        m1137a(dBLFacebookCredentials, 2);
                        break;
                        break;
                    case 406:
                        this.f825P = LoginState.LOGIN_APPROVALS_CODE_ENTRY;
                        this.f834w.m1000a(a2);
                        m1137a(dBLFacebookCredentials, i);
                        break;
                    default:
                        if (!this.f834w.m1004a(a, a2)) {
                            this.f834w.m999a(apiException);
                            break;
                        }
                        break;
                }
            } else if (th instanceof IOException) {
                IOException iOException = (IOException) th;
                if (!(this.f824N.booleanValue() && iOException != null && this.f835x.m992b(this, iOException.getMessage()))) {
                    this.f834w.m1001a(iOException);
                }
            } else {
                this.f834w.m1003a(th);
            }
            if (this.f825P != LoginState.PASSCODE_ENTRY || this.f823M < 2) {
                DeviceBasedLoginWaitListener p = m1162p(this);
                getString(2131236272);
                p.c();
                return;
            }
            this.f825P = LoginState.PASSWORD_ENTRY;
            m1137a(dBLFacebookCredentials, 1);
            return;
        }
        this.f834w.m1003a(th);
    }

    public static void m1161o(DeviceBasedLoginActivity deviceBasedLoginActivity) {
        Intent intent = new Intent(deviceBasedLoginActivity, DBLPinSettingsActivity.class);
        Bundle bundle = new Bundle();
        if (deviceBasedLoginActivity.f833v.get() != null) {
            Parcelable c = deviceBasedLoginActivity.f832u.c(((User) deviceBasedLoginActivity.f833v.get()).a);
            if (c != null) {
                bundle.putParcelable("dbl_account_details", c);
            }
            bundle.putString("operation_type", "change_passcode_from_login_flow");
            intent.putExtras(bundle);
            deviceBasedLoginActivity.f830s.a(intent, 1, deviceBasedLoginActivity);
        }
    }

    private void m1137a(DBLFacebookCredentials dBLFacebookCredentials, int i) {
        Bundle bundle = new Bundle();
        if (i != 0) {
            bundle.putInt("dbl_flag", i);
        }
        if (dBLFacebookCredentials != null) {
            bundle.putParcelable("dbl_account_details", dBLFacebookCredentials);
            Fragment dBLPasswordLoginFragment;
            if (this.f825P == LoginState.PASSWORD_ACCOUNT) {
                dBLPasswordLoginFragment = new DBLPasswordLoginFragment();
                dBLPasswordLoginFragment.g(bundle);
                dBLPasswordLoginFragment.g(2131236247);
                dBLPasswordLoginFragment.d = this;
                if (m1164r(this)) {
                    m1146b(this, dBLPasswordLoginFragment);
                    return;
                }
                return;
            } else if (this.f825P == LoginState.LOGIN_APPROVALS_CODE_ENTRY) {
                dBLPasswordLoginFragment = new LoginApprovalsFragment();
                dBLPasswordLoginFragment.g(bundle);
                dBLPasswordLoginFragment.b = this;
                m1146b(this, dBLPasswordLoginFragment);
                return;
            } else if (this.f825P == LoginState.PASSWORD_ENTRY) {
                dBLPasswordLoginFragment = new DBLPasswordLoginFragment();
                dBLPasswordLoginFragment.g(bundle);
                dBLPasswordLoginFragment.d = this;
                if (i == 2) {
                    dBLPasswordLoginFragment.g(2131236246);
                }
                if (m1164r(this)) {
                    DeviceBasedLoginWaitListener p = m1162p(this);
                    if (p instanceof DeviceBasedLoginFragment) {
                        DeviceBasedLoginFragment deviceBasedLoginFragment = (DeviceBasedLoginFragment) p;
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) deviceBasedLoginFragment.f.findViewById(2131558927), "alpha", new float[]{0.0f});
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(deviceBasedLoginFragment.g, "alpha", new float[]{0.0f});
                        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(deviceBasedLoginFragment.d, "alpha", new float[]{0.0f});
                        Animator animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat3, ofFloat});
                        Animator animator = animatorSet;
                        animator.addListener(new 3(this, dBLPasswordLoginFragment));
                        animator.start();
                        return;
                    }
                    m1146b(this, dBLPasswordLoginFragment);
                    return;
                }
                return;
            } else if (this.f825P == LoginState.NO_NONCE_EXISTS) {
                dBLPasswordLoginFragment = new DBLPasswordLoginFragment();
                dBLPasswordLoginFragment.g(2131236246);
                dBLPasswordLoginFragment.g(bundle);
                dBLPasswordLoginFragment.d = this;
                m1146b(this, dBLPasswordLoginFragment);
                return;
            } else {
                return;
            }
        }
        mo79b();
    }

    public static DeviceBasedLoginWaitListener m1162p(DeviceBasedLoginActivity deviceBasedLoginActivity) {
        return (DeviceBasedLoginWaitListener) deviceBasedLoginActivity.kO_().a(2131558429);
    }

    public final void mo75a(Uri uri) {
        this.f830s.b(new Intent("android.intent.action.VIEW", uri), this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2210 && i2 == -1) {
            m1160n(this);
        } else if (i == 1 && i2 == -1) {
            Editor edit = this.f832u.a.edit();
            edit.a(AuthPrefKeys.p);
            edit.commit();
            m1160n(this);
        } else {
            finish();
        }
    }

    public final void m1174i() {
        this.f812B.a("", m1163q(), "fb4a_login");
    }

    private FutureCallback<OperationResult> m1163q() {
        return new 4(this);
    }

    public final boolean mo64c() {
        return this.f824N.booleanValue();
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 453202199);
        super.onPause();
        this.f824N = Boolean.valueOf(false);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1957981249, a);
    }

    public static boolean m1164r(DeviceBasedLoginActivity deviceBasedLoginActivity) {
        return m1162p(deviceBasedLoginActivity) != null;
    }
}
