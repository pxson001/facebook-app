package com.facebook.katana.activity.codegenerator;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.katana.util.AlertDialogs;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Strings;
import javax.inject.Provider;

/* compiled from: user_change_username */
public class CodeGeneratorAutoProvisionSecretActivity extends BaseFacebookActivity {
    public String f714p;
    public String f715q;
    public String f716r;
    public Provider<String> f717s;
    public DefaultAndroidThreadUtil f718t;
    public DefaultBlueServiceOperationFactory f719u;
    public FbSharedPreferences f720v;
    public SecureContextHelper f721w;
    public GatedCodeGeneratorExperimentHelper f722x;

    /* compiled from: user_change_username */
    class C01061 implements OnClickListener {
        final /* synthetic */ CodeGeneratorAutoProvisionSecretActivity f711a;

        /* compiled from: user_change_username */
        class C01051 extends OperationResultFutureCallback {
            final /* synthetic */ C01061 f710a;

            C01051(C01061 c01061) {
                this.f710a = c01061;
            }

            public final void m726a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                this.f710a.f711a.removeDialog(1);
                FetchCodeResult fetchCodeResult = (FetchCodeResult) operationResult.h();
                String str = fetchCodeResult.a;
                long parseLong = Long.parseLong(fetchCodeResult.b);
                this.f710a.f711a.f720v.edit().a((PrefKey) FbandroidPrefKeys.e.a((String) this.f710a.f711a.f717s.get()), parseLong).commit();
                if (!Strings.isNullOrEmpty(str)) {
                    this.f710a.f711a.f720v.edit().a((PrefKey) FbandroidPrefKeys.f.a((String) this.f710a.f711a.f717s.get()), str).commit();
                    this.f710a.f711a.f721w.a(new Intent(this.f710a.f711a, CodeGeneratorActivity.class), this.f710a.f711a);
                    this.f710a.f711a.finish();
                }
            }

            protected final void m725a(ServiceException serviceException) {
                this.f710a.f711a.removeDialog(1);
                ErrorCode errorCode = serviceException.errorCode;
                if (errorCode != ErrorCode.NO_ERROR) {
                    if (errorCode == ErrorCode.HTTP_500_CLASS && this.f710a.f711a.f722x.b() && this.f710a.f711a.m729a(serviceException)) {
                        this.f710a.f711a.finish();
                        return;
                    }
                    if (errorCode == ErrorCode.CONNECTION_FAILURE || errorCode == ErrorCode.ORCA_SERVICE_UNKNOWN_OPERATION || errorCode == ErrorCode.ORCA_SERVICE_IPC_FAILURE) {
                        this.f710a.f711a.f716r = this.f710a.f711a.getString(2131236475);
                        this.f710a.f711a.f715q = this.f710a.f711a.getString(2131236483);
                    } else {
                        this.f710a.f711a.f716r = this.f710a.f711a.getString(2131236473);
                        this.f710a.f711a.f715q = this.f710a.f711a.getString(2131236471);
                    }
                    this.f710a.f711a.showDialog(2);
                    ((Button) this.f710a.f711a.findViewById(2131560335)).setClickable(true);
                }
            }
        }

        C01061(CodeGeneratorAutoProvisionSecretActivity codeGeneratorAutoProvisionSecretActivity) {
            this.f711a = codeGeneratorAutoProvisionSecretActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 410407811);
            if (view.getId() == 2131560335) {
                String str;
                ((Button) this.f711a.findViewById(2131560335)).setClickable(false);
                this.f711a.showDialog(1);
                Long valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
                Bundle bundle = new Bundle();
                if (this.f711a.f722x.b()) {
                    bundle.putParcelable("checkCodeParams", new FetchCodeParams((String) this.f711a.f717s.get(), valueOf.toString(), true));
                    str = "fetch_code";
                } else {
                    bundle.putParcelable("checkCodeParams", new LegacyFetchCodeParams((String) this.f711a.f717s.get(), this.f711a.f714p, valueOf.toString()));
                    str = "legacy_fetch_code";
                }
                this.f711a.f718t.a(BlueServiceOperationFactoryDetour.a(this.f711a.f719u, str, bundle, 1971517065).a(), new C01051(this));
            }
            LogUtils.a(1760421363, a);
        }
    }

    /* compiled from: user_change_username */
    class C01072 implements DialogInterface.OnClickListener {
        final /* synthetic */ CodeGeneratorAutoProvisionSecretActivity f712a;

        C01072(CodeGeneratorAutoProvisionSecretActivity codeGeneratorAutoProvisionSecretActivity) {
            this.f712a = codeGeneratorAutoProvisionSecretActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* compiled from: user_change_username */
    class C01083 implements DialogInterface.OnClickListener {
        final /* synthetic */ CodeGeneratorAutoProvisionSecretActivity f713a;

        C01083(CodeGeneratorAutoProvisionSecretActivity codeGeneratorAutoProvisionSecretActivity) {
            this.f713a = codeGeneratorAutoProvisionSecretActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f713a.f721w.a(new Intent(this.f713a, CodeGeneratorManualProvisionSecretActivity.class), this.f713a);
            this.f713a.finish();
        }
    }

    public final void m738b(Bundle bundle) {
        super.b(bundle);
        FbInjector hz_ = hz_();
        this.f717s = IdBasedProvider.a(hz_, 4442);
        this.f719u = DefaultBlueServiceOperationFactory.b(hz_);
        this.f718t = DefaultAndroidThreadUtil.b(hz_);
        this.f720v = (FbSharedPreferences) FbSharedPreferencesImpl.a(hz_);
        this.f721w = (SecureContextHelper) DefaultSecureContextHelper.a(hz_);
        this.f722x = GatedCodeGeneratorExperimentHelper.b(hz_);
        this.f714p = this.f720v.a(AuthPrefKeys.f, "");
        setContentView(2130903583);
        findViewById(2131560335).setOnClickListener(new C01061(this));
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1554049262);
        super.onResume();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1857796267, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -2101640333);
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1821206082, a);
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                Dialog progressDialog = new ProgressDialog(this);
                progressDialog.setProgressStyle(0);
                progressDialog.setMessage(getText(2131236465));
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(false);
                return progressDialog;
            case 2:
                return AlertDialogs.a(this, this.f716r, 17301659, this.f715q, getString(2131230756), new C01072(this), getString(2131236468), new C01083(this), null, false);
            default:
                return null;
        }
    }

    private boolean m729a(ServiceException serviceException) {
        if (serviceException == null || serviceException.result == null || serviceException.result.d == null) {
            return false;
        }
        ApiException apiException = (ApiException) ExceptionUtil.a(serviceException, ApiException.class);
        if (apiException == null) {
            return false;
        }
        ApiErrorResult b = apiException.b();
        if (b.mErrorSubCode != 1404120 || b.a() != 415) {
            return false;
        }
        this.f721w.a(new Intent(this, ActivateCodeGeneratorWithCodeActivity.class), this);
        return true;
    }
}
