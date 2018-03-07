package com.facebook.katana;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.devicebasedlogin.logging.DBLLoggerHelper;
import com.facebook.devicebasedlogin.nux.ActivateDBLListener;
import com.facebook.devicebasedlogin.nux.ActivateDeviceBasedLoginNuxFragment;
import com.facebook.devicebasedlogin.nux.TargetedNuxResolver.NuxType;
import com.facebook.devicebasedlogin.settings.DBLLoggedInAccountSettingsController;
import com.facebook.devicebasedlogin.settings.DBLLoggedInAccountSettingsProgressFragment;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.FbInjector;
import com.facebook.katana.dbl.DBLRequestHelper;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.user.model.User;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: SEND_FAILED_SERVER_RETURNED_FAILURE */
public class DBLLoggedInAccountSettingsActivity extends FbFragmentActivity implements ActivateDBLListener {
    private DBLRequestHelper f24087p;
    private DBLLoggerHelper f24088q;
    public DBLLoggedInAccountSettingsController f24089r;
    private DBLLoggedInAccountSettingsFragment f24090s;
    private DBLLoggedInAccountSettingsProgressFragment f24091t;
    public final Runnable f24092u = new C34591(this);

    /* compiled from: SEND_FAILED_SERVER_RETURNED_FAILURE */
    class C34591 implements Runnable {
        final /* synthetic */ DBLLoggedInAccountSettingsActivity f24084a;

        C34591(DBLLoggedInAccountSettingsActivity dBLLoggedInAccountSettingsActivity) {
            this.f24084a = dBLLoggedInAccountSettingsActivity;
        }

        public void run() {
            DBLLoggedInAccountSettingsActivity.m25391k(this.f24084a);
        }
    }

    /* compiled from: SEND_FAILED_SERVER_RETURNED_FAILURE */
    class C34602 implements FutureCallback<OperationResult> {
        final /* synthetic */ DBLLoggedInAccountSettingsActivity f24085a;

        C34602(DBLLoggedInAccountSettingsActivity dBLLoggedInAccountSettingsActivity) {
            this.f24085a = dBLLoggedInAccountSettingsActivity;
        }

        public void onSuccess(Object obj) {
            this.f24085a.f24089r.a(this.f24085a.f24092u, this.f24085a);
        }

        public void onFailure(Throwable th) {
            this.f24085a.f24089r.a(this.f24085a.f24092u, this.f24085a);
        }
    }

    /* compiled from: SEND_FAILED_SERVER_RETURNED_FAILURE */
    class C34613 implements OnClickListener {
        final /* synthetic */ DBLLoggedInAccountSettingsActivity f24086a;

        C34613(DBLLoggedInAccountSettingsActivity dBLLoggedInAccountSettingsActivity) {
            this.f24086a = dBLLoggedInAccountSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -107061826);
            this.f24086a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1206266492, a);
        }
    }

    private static <T extends Context> void m25385a(Class<T> cls, T t) {
        m25386a((Object) t, (Context) t);
    }

    public static void m25386a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DBLLoggedInAccountSettingsActivity) obj).m25384a(DBLRequestHelper.m918b(fbInjector), DBLLoggerHelper.b(fbInjector), DBLLoggedInAccountSettingsController.a(fbInjector));
    }

    public final void m25396b(Bundle bundle) {
        super.b(bundle);
        Class cls = DBLLoggedInAccountSettingsActivity.class;
        m25386a((Object) this, (Context) this);
        setContentView(2130903859);
        m25389i();
    }

    @Inject
    private void m25384a(DBLRequestHelper dBLRequestHelper, DBLLoggerHelper dBLLoggerHelper, DBLLoggedInAccountSettingsController dBLLoggedInAccountSettingsController) {
        this.f24087p = dBLRequestHelper;
        this.f24088q = dBLLoggerHelper;
        this.f24089r = dBLLoggedInAccountSettingsController;
    }

    public final void m25394a() {
        this.f24087p.m920a("", new C34602(this), "logged_in_settings");
        this.f24088q.a("dbl_nux_dismiss_forward", null);
        m25392l();
    }

    public final void m25395b() {
        this.f24088q.a("dbl_nux_dismiss_backward", null);
        onBackPressed();
    }

    public final void b_(String str) {
    }

    public final void m25397c() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 12 && this.f24090s != null) {
            DBLLoggedInAccountSettingsFragment dBLLoggedInAccountSettingsFragment = this.f24090s;
            dBLLoggedInAccountSettingsFragment.f24096d = dBLLoggedInAccountSettingsFragment.f24094b.m25462a(dBLLoggedInAccountSettingsFragment.f24093a.c(), dBLLoggedInAccountSettingsFragment.o());
            dBLLoggedInAccountSettingsFragment.f24095c.setAdapter(dBLLoggedInAccountSettingsFragment.f24096d);
        }
    }

    private void m25389i() {
        boolean z;
        DBLLoggedInAccountSettingsController dBLLoggedInAccountSettingsController = this.f24089r;
        DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper = dBLLoggedInAccountSettingsController.a;
        String str = ((User) dBLLoggedInAccountSettingsController.b.get()).a;
        if (str == null) {
            z = false;
        } else {
            z = dBLStorageAndRetrievalHelper.a.a((PrefKey) AuthPrefKeys.k.a(str));
        }
        if (z) {
            this.f24089r.a(this.f24092u, this);
        } else {
            m25390j();
        }
    }

    private void m25390j() {
        ActivateDeviceBasedLoginNuxFragment a = ActivateDeviceBasedLoginNuxFragment.a(false, NuxType.DEFAULT);
        a.f = this;
        Preconditions.checkArgument(a instanceof DeviceBasedLoginWaitListener);
        kO_().a().b(2131558429, a).b();
    }

    public static void m25391k(DBLLoggedInAccountSettingsActivity dBLLoggedInAccountSettingsActivity) {
        dBLLoggedInAccountSettingsActivity.m25393m();
        dBLLoggedInAccountSettingsActivity.f24090s = new DBLLoggedInAccountSettingsFragment();
        dBLLoggedInAccountSettingsActivity.kO_().a().b(2131558429, dBLLoggedInAccountSettingsActivity.f24090s).b();
    }

    private void m25392l() {
        this.f24091t = new DBLLoggedInAccountSettingsProgressFragment();
        kO_().a().a(2130968749, 2130968753, 2130968762, 2130968765).b(2131558429, this.f24091t).b();
    }

    private void m25393m() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
        fbTitleBar.a(new C34613(this));
        fbTitleBar.setTitle(getResources().getString(2131236286));
    }
}
