package com.facebook.katana;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.devicebasedlogin.logging.DBLLoggerHelper;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.FbInjector;
import com.facebook.katana.dbl.DBLPasswordVerificationFragment;
import com.facebook.katana.dbl.DBLPinOperation;
import com.facebook.katana.dbl.DBLPinOperationTypes.AddPinOperation;
import com.facebook.katana.dbl.DBLPinOperationTypes.ChangePasscodeAfterIncorrectPasscodeOperation;
import com.facebook.katana.dbl.DBLPinOperationTypes.ChangePasscodeFromLoginFlow;
import com.facebook.katana.dbl.DBLPinOperationTypes.ChangePinOperation;
import com.facebook.katana.dbl.DBLPinOperationTypes.ChangePinUsingPassword;
import com.facebook.katana.dbl.DBLPinOperationTypes.RemovePinOperation;
import com.facebook.katana.dbl.DBLPinOperationTypes.RemovePinUsingPassword;
import com.facebook.katana.dbl.DBLPinOperationTypes.SwitchToDBL;
import com.facebook.katana.dbl.DBLPinOperationTypes.Type;
import com.facebook.katana.dbl.DBLPinSettingsListener;
import com.facebook.katana.dbl.DBLRequestHelper;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.katana.dbl.DBLVerifyCurrentPinFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.IFbResourcesNotRequired;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: SEND_BUTTON */
public class DBLPinSettingsActivity extends FbFragmentActivity implements IAuthNotRequired, DBLPinSettingsListener, IFbResourcesNotRequired {
    public static final Class<?> f24117x = DBLPinSettingsActivity.class;
    private String f24118A;
    public boolean f24119B;
    private int f24120C = 0;
    @Inject
    DefaultBlueServiceOperationFactory f24121p;
    @Inject
    @ForUiThread
    ExecutorService f24122q;
    @Inject
    DBLStorageAndRetrievalHelper f24123r;
    @Inject
    DBLLoggerHelper f24124s;
    @Inject
    DBLRequestHelper f24125t;
    public int f24126u = 0;
    public String f24127v = "";
    private String f24128w;
    public DBLPinOperation f24129y;
    public DBLFacebookCredentials f24130z;

    /* compiled from: SEND_BUTTON */
    class C34651 implements FutureCallback<OperationResult> {
        final /* synthetic */ DBLPinSettingsActivity f24114a;

        C34651(DBLPinSettingsActivity dBLPinSettingsActivity) {
            this.f24114a = dBLPinSettingsActivity;
        }

        public void onSuccess(Object obj) {
            DBLFacebookCredentials dBLFacebookCredentials = (DBLFacebookCredentials) ((OperationResult) obj).g().getParcelable("result");
            if (dBLFacebookCredentials != null) {
                DBLPinSettingsActivity.m25450q(this.f24114a);
                this.f24114a.f24123r.a(dBLFacebookCredentials);
                if (DBLPinSettingsActivity.m25452s(this.f24114a)) {
                    DBLPinSettingsActivity.m25449p(this.f24114a).b();
                    this.f24114a.m25432b(dBLFacebookCredentials.mIsPinSet.booleanValue());
                    this.f24114a.setResult(-1);
                    this.f24114a.m25458i();
                    return;
                }
                return;
            }
            BLog.b(DBLPinSettingsActivity.f24117x, "Fetched result was null");
            DBLPinSettingsActivity.m25430b(this.f24114a, null);
        }

        public void onFailure(Throwable th) {
            DBLPinSettingsActivity.m25430b(this.f24114a, th);
        }
    }

    /* compiled from: SEND_BUTTON */
    class C34662 implements FutureCallback<OperationResult> {
        final /* synthetic */ DBLPinSettingsActivity f24115a;

        C34662(DBLPinSettingsActivity dBLPinSettingsActivity) {
            this.f24115a = dBLPinSettingsActivity;
        }

        public void onSuccess(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            DeviceBasedLoginWaitListener p = DBLPinSettingsActivity.m25449p(this.f24115a);
            if (p != null) {
                if (Boolean.valueOf(operationResult.c.equalsIgnoreCase("true")).booleanValue()) {
                    p.b();
                    DBLPinSettingsActivity.m25447n(this.f24115a);
                } else if (this.f24115a.f24126u < 2 && !this.f24115a.f24119B && this.f24115a.f24129y.mo37b() != Type.SWITCH_TO_DBL) {
                    this.f24115a.f24126u = this.f24115a.f24126u + 1;
                    if (p != null) {
                        ((DBLVerifyCurrentPinFragment) p).m937h(2131236273);
                        this.f24115a.getString(2131236273);
                        p.c();
                        if (this.f24115a.f24126u >= 2) {
                            DBLPinSettingsActivity.m25446m(this.f24115a);
                        }
                    }
                } else if (p != null) {
                    if (p instanceof DBLPasswordVerificationFragment) {
                        ((DBLPasswordVerificationFragment) p).m869h(2131236244);
                    }
                    this.f24115a.getString(2131236244);
                    p.c();
                }
            }
        }

        public void onFailure(Throwable th) {
            DBLPinSettingsActivity.m25430b(this.f24115a, th);
        }
    }

    /* compiled from: SEND_BUTTON */
    class C34673 implements FutureCallback<OperationResult> {
        final /* synthetic */ DBLPinSettingsActivity f24116a;

        C34673(DBLPinSettingsActivity dBLPinSettingsActivity) {
            this.f24116a = dBLPinSettingsActivity;
        }

        public void onSuccess(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            DeviceBasedLoginWaitListener p = DBLPinSettingsActivity.m25449p(this.f24116a);
            if (p != null) {
                boolean z;
                DBLFacebookCredentials dBLFacebookCredentials = (DBLFacebookCredentials) operationResult.g().getParcelable("result");
                if (this.f24116a.getIntent().getStringExtra("operation_type").equals("switch_to_dbl_with_pin")) {
                    z = true;
                } else {
                    z = false;
                }
                if (dBLFacebookCredentials != null) {
                    this.f24116a.f24130z = new DBLFacebookCredentials(dBLFacebookCredentials.mUserId, dBLFacebookCredentials.mTime, dBLFacebookCredentials.mName, dBLFacebookCredentials.mUsername, this.f24116a.f24130z.mPicUrl, dBLFacebookCredentials.mNonce, dBLFacebookCredentials.mIsPinSet.booleanValue());
                    this.f24116a.f24123r.a(this.f24116a.f24130z);
                    DBLPinSettingsActivity.m25435c(this.f24116a, z);
                    this.f24116a.f24127v = "";
                    p.b();
                    if (z) {
                        DBLPinSettingsActivity.m25447n(this.f24116a);
                        return;
                    }
                    this.f24116a.m25432b(dBLFacebookCredentials.mIsPinSet.booleanValue());
                    this.f24116a.m25458i();
                    return;
                }
                if (p instanceof DBLPasswordVerificationFragment) {
                    ((DBLPasswordVerificationFragment) p).m869h(2131236244);
                }
                this.f24116a.getString(2131236272);
                p.c();
            }
        }

        public void onFailure(Throwable th) {
            DBLPinSettingsActivity.m25430b(this.f24116a, th);
        }
    }

    private static <T extends Context> void m25426a(Class<T> cls, T t) {
        m25427a((Object) t, (Context) t);
    }

    public static void m25427a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DBLPinSettingsActivity) obj).m25422a(DefaultBlueServiceOperationFactory.b(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), DBLStorageAndRetrievalHelper.b(fbInjector), DBLLoggerHelper.b(fbInjector), DBLRequestHelper.m918b(fbInjector));
    }

    public final void m25455b(Bundle bundle) {
        int i = 0;
        Class cls = DBLPinSettingsActivity.class;
        m25427a((Object) this, (Context) this);
        Bundle extras = getIntent().getExtras();
        this.f24130z = (DBLFacebookCredentials) extras.getParcelable("dbl_account_details");
        String string = extras.getString("operation_type");
        this.f24128w = extras.getString("source");
        if (string == null || this.f24130z == null) {
            finish();
            return;
        }
        this.f24119B = false;
        if (this.f24130z.mNonce.equals("")) {
            this.f24119B = true;
        }
        if (string.equals("change_passcode_from_login_flow")) {
            this.f24120C = 2131236250;
            this.f24129y = new ChangePasscodeFromLoginFlow();
        } else if (string.equals("add_pin")) {
            int i2;
            this.f24120C = 2131236237;
            if (this.f24119B) {
                this.f24129y = new ChangePinUsingPassword();
                i2 = 2131236276;
            } else {
                this.f24129y = new AddPinOperation();
                i2 = 0;
            }
            this.f24118A = "dbl_settings_passcode_add";
            i = i2;
        } else if (string.equals("remove_pin")) {
            this.f24120C = 2131236252;
            if (this.f24119B) {
                this.f24129y = new RemovePinUsingPassword();
                i = 2131236276;
            } else {
                this.f24129y = new RemovePinOperation();
            }
            this.f24118A = "dbl_settings_passcode_remove";
        } else if (string.equals("change_pin")) {
            this.f24120C = 2131236250;
            if (this.f24119B) {
                this.f24129y = new ChangePinUsingPassword();
                i = 2131236276;
            } else {
                this.f24129y = new ChangePinOperation();
            }
            this.f24118A = "dbl_settings_passcode_change";
        } else if (string.equals("switch_to_dbl") || string.equals("switch_to_dbl_with_pin")) {
            this.f24120C = 2131236261;
            this.f24129y = new SwitchToDBL();
            i = 2131236262;
        }
        setContentView(2130903850);
        m25429b(this.f24129y.mo35a((DBLPinSettingsListener) this, this.f24120C, i));
    }

    private void m25429b(Fragment fragment) {
        kO_().a().b(2131558429, fragment).c();
    }

    public final void d_(String str) {
        m25428a(this.f24127v, str);
    }

    private void m25428a(String str, String str2) {
        if (m25452s(this)) {
            m25449p(this).a();
        }
        m25421a(this.f24129y.mo34a(str, str2, this.f24130z), this.f24129y.mo36a(), m25444k());
    }

    private FutureCallback<OperationResult> m25444k() {
        return new C34651(this);
    }

    private void m25432b(boolean z) {
        CharSequence charSequence = "";
        if (this.f24120C == 2131236237) {
            charSequence = getString(2131236278);
        } else if (this.f24120C == 2131236252) {
            charSequence = getString(2131236279);
        } else if (this.f24120C == 2131236250) {
            if (this.f24129y.mo37b() != Type.CHANGE_PASSCODE_FROM_LOGIN_FLOW || z) {
                charSequence = getString(2131236280);
            } else {
                charSequence = getString(2131236279);
            }
        } else if (this.f24120C == 2131236261) {
            if (z) {
                charSequence = getString(2131236278);
            } else {
                charSequence = getString(2131236281);
            }
        }
        if (!charSequence.equals("")) {
            Toast.makeText(this, charSequence, 1).show();
        }
    }

    public final void mo1042b(String str) {
        if (m25452s(this)) {
            m25449p(this).a();
        }
        this.f24127v = str;
        DBLRequestHelper dBLRequestHelper = this.f24125t;
        DBLFacebookCredentials dBLFacebookCredentials = this.f24130z;
        FutureCallback l = m25445l();
        Bundle bundle = new Bundle();
        bundle.putString("account_id", dBLFacebookCredentials.mUserId);
        bundle.putString("nonce", dBLFacebookCredentials.mNonce);
        bundle.putString("pin", str);
        OperationFuture a = BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) dBLRequestHelper.f894c.get(), "check_nonce", bundle, ErrorPropagation.BY_ERROR_CODE, DBLRequestHelper.f893b, -1001530731).a();
        if (l != null) {
            Futures.a(a, l, dBLRequestHelper.f895d);
        }
    }

    public final void mo1043c(String str) {
        if (m25452s(this)) {
            m25449p(this).a();
        }
        this.f24127v = str;
        if (this.f24129y.mo37b() == Type.SWITCH_TO_DBL) {
            m25453t();
            return;
        }
        DBLRequestHelper dBLRequestHelper = this.f24125t;
        DBLFacebookCredentials dBLFacebookCredentials = this.f24130z;
        FutureCallback l = m25445l();
        Bundle bundle = new Bundle();
        bundle.putString("account_id", dBLFacebookCredentials.mUserId);
        bundle.putString("password", str);
        OperationFuture a = BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) dBLRequestHelper.f894c.get(), "check_password", bundle, ErrorPropagation.BY_ERROR_CODE, DBLRequestHelper.f893b, -873566474).a();
        if (l != null) {
            Futures.a(a, l, dBLRequestHelper.f895d);
        }
    }

    private FutureCallback<OperationResult> m25445l() {
        return new C34662(this);
    }

    public static void m25446m(DBLPinSettingsActivity dBLPinSettingsActivity) {
        m25447n(dBLPinSettingsActivity);
        dBLPinSettingsActivity.m25429b(dBLPinSettingsActivity.f24129y.mo35a((DBLPinSettingsListener) dBLPinSettingsActivity, dBLPinSettingsActivity.f24120C, 0));
    }

    private void m25421a(Bundle bundle, String str, FutureCallback<OperationResult> futureCallback) {
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f24121p, str, bundle, -1426409944).a(), futureCallback, this.f24122q);
    }

    public static void m25447n(DBLPinSettingsActivity dBLPinSettingsActivity) {
        Type b = dBLPinSettingsActivity.f24129y.mo37b();
        if (b == Type.REMOVE_PIN) {
            if (dBLPinSettingsActivity.f24126u < 2) {
                dBLPinSettingsActivity.m25428a(dBLPinSettingsActivity.f24127v, "");
            } else {
                dBLPinSettingsActivity.f24129y = new RemovePinUsingPassword();
            }
        } else if (b == Type.CHANGE_PIN) {
            if (dBLPinSettingsActivity.f24126u >= 2) {
                dBLPinSettingsActivity.f24129y = new ChangePinUsingPassword();
                return;
            }
            dBLPinSettingsActivity.f24129y = new AddPinOperation();
            dBLPinSettingsActivity.m25429b(dBLPinSettingsActivity.f24129y.mo35a((DBLPinSettingsListener) dBLPinSettingsActivity, dBLPinSettingsActivity.f24120C, 2131236267));
        } else if (b == Type.REMOVE_PIN_USING_PASSWORD) {
            dBLPinSettingsActivity.m25428a(dBLPinSettingsActivity.f24127v, "");
        } else if (b == Type.CHANGE_PIN_USING_PASSWORD) {
            dBLPinSettingsActivity.f24129y = new ChangePasscodeAfterIncorrectPasscodeOperation();
            dBLPinSettingsActivity.m25429b(dBLPinSettingsActivity.f24129y.mo35a((DBLPinSettingsListener) dBLPinSettingsActivity, dBLPinSettingsActivity.f24120C, 2131236267));
        } else if (b == Type.SWITCH_TO_DBL) {
            dBLPinSettingsActivity.f24129y = new AddPinOperation();
            dBLPinSettingsActivity.m25429b(dBLPinSettingsActivity.f24129y.mo35a((DBLPinSettingsListener) dBLPinSettingsActivity, dBLPinSettingsActivity.f24120C, 2131236267));
        }
    }

    public void onBackPressed() {
        m25448o();
    }

    private void m25448o() {
        Type b = this.f24129y.mo37b();
        if (b == Type.CHANGE_PIN_USING_PASSWORD) {
            if (this.f24119B) {
                m25458i();
                return;
            }
            this.f24126u = 0;
            this.f24129y = new ChangePinOperation();
            m25429b(this.f24129y.mo35a((DBLPinSettingsListener) this, this.f24120C, 0));
        } else if (b == Type.REMOVE_PIN_USING_PASSWORD) {
            if (this.f24119B) {
                m25458i();
                return;
            }
            this.f24126u = 0;
            this.f24129y = new RemovePinOperation();
            m25429b(this.f24129y.mo35a((DBLPinSettingsListener) this, this.f24120C, 0));
        } else if (kO_().f() <= 1) {
            m25458i();
        } else {
            kO_().d();
        }
    }

    public static DeviceBasedLoginWaitListener m25449p(DBLPinSettingsActivity dBLPinSettingsActivity) {
        return (DeviceBasedLoginWaitListener) dBLPinSettingsActivity.kO_().a(2131558429);
    }

    public void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1157752870);
        super.onStop();
        KeyboardUtils.a(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1725209677, a);
    }

    public final void m25458i() {
        KeyboardUtils.a(this);
        finish();
        overridePendingTransition(2130968625, 2130968631);
    }

    public static void m25450q(DBLPinSettingsActivity dBLPinSettingsActivity) {
        Bundle bundle = new Bundle();
        bundle.putString("fbid", dBLPinSettingsActivity.f24130z.mUserId);
        if (dBLPinSettingsActivity.f24128w != null) {
            bundle.putString("source", dBLPinSettingsActivity.f24128w);
        }
        dBLPinSettingsActivity.f24124s.a(dBLPinSettingsActivity.f24118A, bundle);
    }

    public static void m25430b(DBLPinSettingsActivity dBLPinSettingsActivity, Throwable th) {
        CharSequence string = dBLPinSettingsActivity.getString(2131236272);
        if (th != null && (th instanceof ServiceException)) {
            ServiceException serviceException = (ServiceException) th;
            ErrorCode errorCode = serviceException.result.e;
            if (errorCode == ErrorCode.API_ERROR) {
                String string2;
                switch (((ApiErrorResult) serviceException.result.g().getParcelable("result")).a()) {
                    case 368:
                        string = dBLPinSettingsActivity.getString(2131236277);
                        break;
                    case 401:
                        string2 = dBLPinSettingsActivity.getString(2131236244);
                        break;
                    case 6100:
                        dBLPinSettingsActivity.m25451r();
                        break;
                    case 6101:
                        dBLPinSettingsActivity.m25451r();
                        break;
                    default:
                        string2 = string;
                        break;
                }
                string = string2;
            } else if (errorCode == ErrorCode.CONNECTION_FAILURE) {
                string = dBLPinSettingsActivity.getString(2131230763);
            }
        }
        if (m25452s(dBLPinSettingsActivity)) {
            m25449p(dBLPinSettingsActivity).c();
        }
        if (string != null) {
            Toast.makeText(dBLPinSettingsActivity.getApplicationContext(), string, 1).show();
        }
    }

    private void m25422a(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService, DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper, DBLLoggerHelper dBLLoggerHelper, DBLRequestHelper dBLRequestHelper) {
        this.f24121p = defaultBlueServiceOperationFactory;
        this.f24122q = executorService;
        this.f24123r = dBLStorageAndRetrievalHelper;
        this.f24124s = dBLLoggerHelper;
        this.f24125t = dBLRequestHelper;
    }

    private void m25451r() {
        Type b = this.f24129y.mo37b();
        if (b == Type.REMOVE_PIN) {
            this.f24129y = new RemovePinUsingPassword();
            this.f24119B = true;
        } else if (b == Type.ADD_PIN) {
            this.f24129y = new ChangePinUsingPassword();
            this.f24119B = true;
        } else if (b == Type.CHANGE_PIN) {
            this.f24129y = new ChangePinUsingPassword();
            this.f24119B = true;
        } else {
            return;
        }
        m25429b(this.f24129y.mo35a((DBLPinSettingsListener) this, this.f24120C, 2131236276));
    }

    public static boolean m25452s(DBLPinSettingsActivity dBLPinSettingsActivity) {
        return m25449p(dBLPinSettingsActivity) != null;
    }

    private void m25453t() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("passwordCredentials", new PasswordCredentials(this.f24130z.mUserId, this.f24127v, PasswordCredentials.Type.PASSWORD));
        bundle.putString("error_detail_type_param", "button_with_disabled");
        m25421a(bundle, "logged_out_set_nonce", m25454u());
    }

    private FutureCallback<OperationResult> m25454u() {
        return new C34673(this);
    }

    public static void m25435c(DBLPinSettingsActivity dBLPinSettingsActivity, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("fbid", dBLPinSettingsActivity.f24130z.mUserId);
        bundle.putBoolean("has_pin", z);
        bundle.putString("switch_to", "dbl");
        if (dBLPinSettingsActivity.f24128w != null) {
            bundle.putString("source", dBLPinSettingsActivity.f24128w);
        }
        dBLPinSettingsActivity.f24124s.a("switch_account", bundle);
    }
}
