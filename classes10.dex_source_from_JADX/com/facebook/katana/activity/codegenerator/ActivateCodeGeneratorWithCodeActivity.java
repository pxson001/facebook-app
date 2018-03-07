package com.facebook.katana.activity.codegenerator;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.katana.util.AlertDialogs;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.resources.ui.FbEditText;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.google.common.base.Strings;

/* compiled from: user_stage */
public class ActivateCodeGeneratorWithCodeActivity extends FbFragmentActivity {
    public String f682p;
    public String f683q;
    public long f684r;
    public DefaultAndroidThreadUtil f685s;
    public DefaultBlueServiceOperationFactory f686t;
    public FbSharedPreferences f687u;
    public SecureContextHelper f688v;
    public EditText f689w;
    public Button f690x;
    public MonotonicClock f691y;

    /* compiled from: user_stage */
    class C00971 implements OnClickListener {
        final /* synthetic */ ActivateCodeGeneratorWithCodeActivity f679a;

        /* compiled from: user_stage */
        class C00961 extends OperationResultFutureCallback {
            final /* synthetic */ C00971 f678a;

            C00961(C00971 c00971) {
                this.f678a = c00971;
            }

            public final void m709a(Object obj) {
                FetchCodeResult fetchCodeResult = (FetchCodeResult) ((OperationResult) obj).h();
                String str = fetchCodeResult.a;
                long parseLong = Long.parseLong(fetchCodeResult.b);
                this.f678a.f679a.f687u.edit().a((PrefKey) FbandroidPrefKeys.e.a(Long.toString(this.f678a.f679a.f684r)), parseLong).commit();
                if (!Strings.isNullOrEmpty(str)) {
                    this.f678a.f679a.f687u.edit().a((PrefKey) FbandroidPrefKeys.f.a(Long.toString(this.f678a.f679a.f684r)), str).commit();
                    this.f678a.f679a.f688v.a(new Intent(this.f678a.f679a, CodeGeneratorActivity.class), this.f678a.f679a);
                    this.f678a.f679a.finish();
                }
            }

            protected final void m708a(ServiceException serviceException) {
                ErrorCode errorCode = serviceException.errorCode;
                if (errorCode != ErrorCode.NO_ERROR) {
                    if (errorCode == ErrorCode.CONNECTION_FAILURE || errorCode == ErrorCode.ORCA_SERVICE_UNKNOWN_OPERATION || errorCode == ErrorCode.ORCA_SERVICE_IPC_FAILURE) {
                        this.f678a.f679a.f683q = this.f678a.f679a.getString(2131236475);
                        this.f678a.f679a.f682p = this.f678a.f679a.getString(2131236483);
                    } else {
                        this.f678a.f679a.f683q = this.f678a.f679a.getString(2131236473);
                        this.f678a.f679a.f682p = this.f678a.f679a.getString(2131236471);
                    }
                    this.f678a.f679a.showDialog(1);
                    this.f678a.f679a.f690x.setClickable(true);
                }
            }
        }

        C00971(ActivateCodeGeneratorWithCodeActivity activateCodeGeneratorWithCodeActivity) {
            this.f679a = activateCodeGeneratorWithCodeActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1615276258);
            if (view.getId() == 2131559205) {
                if (StringUtil.a(this.f679a.f689w.getText())) {
                    Logger.a(2, EntryType.UI_INPUT_END, -1306644262, a);
                    return;
                }
                String obj = this.f679a.f689w.getText().toString();
                this.f679a.f690x.setClickable(false);
                Parcelable activationCodeParams = new ActivationCodeParams(this.f679a.f684r, Long.valueOf(this.f679a.f691y.now()).toString(), obj);
                Bundle bundle = new Bundle();
                bundle.putParcelable("checkCodeParams", activationCodeParams);
                this.f679a.f685s.a(BlueServiceOperationFactoryDetour.a(this.f679a.f686t, "activation_code", bundle, 531726343).a(), new C00961(this));
            }
            LogUtils.a(-221138966, a);
        }
    }

    /* compiled from: user_stage */
    class C00982 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivateCodeGeneratorWithCodeActivity f680a;

        C00982(ActivateCodeGeneratorWithCodeActivity activateCodeGeneratorWithCodeActivity) {
            this.f680a = activateCodeGeneratorWithCodeActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* compiled from: user_stage */
    class C00993 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivateCodeGeneratorWithCodeActivity f681a;

        C00993(ActivateCodeGeneratorWithCodeActivity activateCodeGeneratorWithCodeActivity) {
            this.f681a = activateCodeGeneratorWithCodeActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f681a.f688v.a(new Intent(this.f681a, CodeGeneratorManualProvisionSecretActivity.class), this.f681a);
            this.f681a.finish();
        }
    }

    public final void m720b(Bundle bundle) {
        super.b(bundle);
        FbInjector hz_ = hz_();
        this.f684r = Long.parseLong((String) IdBasedProvider.a(hz_, 4442).get());
        this.f686t = DefaultBlueServiceOperationFactory.b(hz_);
        this.f685s = DefaultAndroidThreadUtil.b(hz_);
        this.f687u = (FbSharedPreferences) FbSharedPreferencesImpl.a(hz_);
        this.f688v = (SecureContextHelper) DefaultSecureContextHelper.a(hz_);
        this.f691y = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(hz_);
        setContentView(2130903083);
        this.f690x = (Button) findViewById(2131559205);
        this.f689w = (FbEditText) findViewById(2131559204);
        this.f690x.setOnClickListener(new C00971(this));
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1490040482);
        super.onResume();
        if (findViewById(2131559203) != null) {
            findViewById(2131559203).requestFocus();
        }
        KeyboardUtils.a(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -2104600363, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1666086380);
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 245679574, a);
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                return AlertDialogs.a(this, this.f683q, 17301659, this.f682p, getString(2131230756), new C00982(this), getString(2131236468), new C00993(this), null, false);
            default:
                return null;
        }
    }
}
