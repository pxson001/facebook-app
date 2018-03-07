package com.facebook.devicebasedlogin.nux;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.devicebasedlogin.logging.DBLLoggerHelper;
import com.facebook.devicebasedlogin.nux.TargetedNuxResolver.NuxType;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.dbl.DBLRequestHelper;
import com.facebook.katana.dbl.DeviceBasedLoginActivityHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.IFbResourcesNotRequired;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Thread operations at DB level */
public class ActivateDeviceBasedLoginNuxActivity extends FbFragmentActivity implements IAuthNotRequired, ActivateDBLListener, IFbResourcesNotRequired {
    @Inject
    public DeviceBasedLoginActivityHelper f24123p;
    private DBLLoggerHelper f24124q;
    private Provider<User> f24125r;
    private DBLRequestHelper f24126s;
    private QeAccessor f24127t;
    private Clock f24128u;
    private FbSharedPreferences f24129v;
    private int f24130w;
    private TargetedNuxResolver f24131x;
    private NuxType f24132y;
    private DeviceBasedLoginNuxEligibilityController f24133z;

    private static <T extends Context> void m26083a(Class<T> cls, T t) {
        m26084a((Object) t, (Context) t);
    }

    public static void m26084a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ActivateDeviceBasedLoginNuxActivity activateDeviceBasedLoginNuxActivity = (ActivateDeviceBasedLoginNuxActivity) obj;
        activateDeviceBasedLoginNuxActivity.m26085a(IdBasedProvider.a(injectorLike, 3595), DBLLoggerHelper.b(injectorLike), DBLRequestHelper.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), TargetedNuxResolver.m26135b(injectorLike), DeviceBasedLoginNuxEligibilityController.m26102b(injectorLike));
        activateDeviceBasedLoginNuxActivity.f24123p = DeviceBasedLoginActivityHelper.b(injectorLike);
    }

    private void m26082a(DeviceBasedLoginActivityHelper deviceBasedLoginActivityHelper) {
        this.f24123p = deviceBasedLoginActivityHelper;
    }

    protected final void m26091b(Bundle bundle) {
        Class cls = ActivateDeviceBasedLoginNuxActivity.class;
        m26084a((Object) this, (Context) this);
        setContentView(2130903850);
        if (this.f24125r.get() == null) {
            finish();
            return;
        }
        NuxType nuxType;
        Intent intent = getIntent();
        this.f24130w = intent.getIntExtra("generation", 0);
        boolean a = this.f24127t.a(ExperimentsForDBLNuxModule.f24166b, true);
        String stringExtra = intent.getStringExtra("targeted_nux");
        if (StringUtil.a(stringExtra)) {
            nuxType = NuxType.DEFAULT;
        } else if (stringExtra.contains("+")) {
            nuxType = NuxType.fromString(stringExtra.split("\\+")[0]);
        } else {
            nuxType = NuxType.DEFAULT;
        }
        this.f24132y = nuxType;
        ActivateDeviceBasedLoginNuxFragment a2 = ActivateDeviceBasedLoginNuxFragment.m26093a(a, this.f24132y);
        a2.f24139f = this;
        Preconditions.checkArgument(a2 instanceof DeviceBasedLoginWaitListener);
        kO_().a().b(2131558429, a2).a(null).b();
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -100562084);
        super.onStart();
        m26087i();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1530165264, a);
    }

    private void m26087i() {
        Object stringExtra = getIntent().getStringExtra("targeted_nux");
        if (StringUtil.a(stringExtra)) {
            User user = (User) this.f24125r.get();
            if (user != null) {
                String str = user.a;
                this.f24129v.edit().a((PrefKey) AuthPrefKeys.l.a(str), this.f24130w).commit();
                this.f24129v.edit().a((PrefKey) AuthPrefKeys.m.a(str), this.f24128u.a()).commit();
                return;
            }
            return;
        }
        DeviceBasedLoginNuxEligibilityController deviceBasedLoginNuxEligibilityController = this.f24133z;
        String str2 = (String) deviceBasedLoginNuxEligibilityController.f24144b.get();
        if (str2 != null) {
            deviceBasedLoginNuxEligibilityController.f24143a.edit().a((PrefKey) AuthPrefKeys.n.a(str2), stringExtra).commit();
            deviceBasedLoginNuxEligibilityController.f24143a.edit().a((PrefKey) AuthPrefKeys.m.a(str2), deviceBasedLoginNuxEligibilityController.f24145c.a()).commit();
            int a = deviceBasedLoginNuxEligibilityController.f24143a.a((PrefKey) AuthPrefKeys.o.a(str2), 0);
            if (a == 0) {
                a = 1;
            } else {
                a *= 2;
            }
            if (a <= 64) {
                deviceBasedLoginNuxEligibilityController.f24143a.edit().a((PrefKey) AuthPrefKeys.o.a(str2), a).commit();
            }
        }
    }

    @Inject
    private void m26085a(Provider<User> provider, DBLLoggerHelper dBLLoggerHelper, DBLRequestHelper dBLRequestHelper, QeAccessor qeAccessor, FbSharedPreferences fbSharedPreferences, Clock clock, TargetedNuxResolver targetedNuxResolver, DeviceBasedLoginNuxEligibilityController deviceBasedLoginNuxEligibilityController) {
        this.f24125r = provider;
        this.f24124q = dBLLoggerHelper;
        this.f24126s = dBLRequestHelper;
        this.f24127t = qeAccessor;
        this.f24129v = fbSharedPreferences;
        this.f24128u = clock;
        this.f24131x = targetedNuxResolver;
        this.f24133z = deviceBasedLoginNuxEligibilityController;
    }

    public final void mo1127a() {
        this.f24126s.a("", null, this.f24132y.getTypeString());
        if (this.f24123p.c()) {
            m26086b(2131236235);
        } else {
            m26086b(2131236234);
        }
        m26088j();
        this.f24124q.a("dbl_nux_dismiss_forward", null);
    }

    public final void mo1128b() {
        this.f24124q.a("dbl_nux_dismiss_backward", null);
        m26088j();
    }

    public final void b_(String str) {
        this.f24126s.a(str, null, this.f24132y.getTypeString());
        if (this.f24123p.c()) {
            m26086b(2131236235);
        } else {
            m26086b(2131236234);
        }
        m26088j();
    }

    public final void mo1130c() {
        SetPinNuxFragment setPinNuxFragment = new SetPinNuxFragment();
        setPinNuxFragment.f24168a = this;
        Preconditions.checkArgument(setPinNuxFragment instanceof DeviceBasedLoginWaitListener);
        kO_().a().a(2130968749, 2130968753, 2130968762, 2130968765).b(2131558429, setPinNuxFragment).a(null).b();
    }

    public void onBackPressed() {
        if (kO_().f() <= 1) {
            this.f24124q.a("dbl_nux_dismiss_backward", null);
            m26088j();
            return;
        }
        kO_().d();
    }

    private void m26088j() {
        setResult(-1);
        finish();
        overridePendingTransition(0, 2130968631);
    }

    private void m26086b(int i) {
        try {
            Toast.makeText(getApplicationContext(), i, 1).show();
        } catch (Exception e) {
        }
    }
}
