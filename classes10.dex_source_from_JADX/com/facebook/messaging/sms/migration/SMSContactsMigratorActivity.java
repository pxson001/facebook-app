package com.facebook.messaging.sms.migration;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.DefaultNavigableFragmentController;
import com.facebook.base.fragment.FragmentActionBuilder;
import com.facebook.base.fragment.NavigableFragment;
import com.facebook.base.fragment.NavigableFragmentController.Listener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.RequestPermissionsActivity;
import com.facebook.runtimepermissions.RequestPermissionsConfig.RationaleBehavior;
import com.facebook.runtimepermissions.RequestPermissionsConfigBuilder;
import com.facebook.runtimepermissions.RequestPermissionsPrefKeys;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: qaz */
public class SMSContactsMigratorActivity extends FbFragmentActivity {
    public static final String[] f4171s = new String[]{"android.permission.READ_CONTACTS"};
    @Inject
    public FbSharedPreferences f4172p;
    @Inject
    public RuntimePermissionsUtil f4173q;
    @Inject
    public SecureContextHelper f4174r;
    public DefaultNavigableFragmentController f4175t;
    private SMSContactsMigratorFlow f4176u;
    private boolean f4177v;
    public boolean f4178w;

    /* compiled from: qaz */
    class C06291 implements Listener {
        final /* synthetic */ SMSContactsMigratorActivity f4170a;

        C06291(SMSContactsMigratorActivity sMSContactsMigratorActivity) {
            this.f4170a = sMSContactsMigratorActivity;
        }

        public final void m3829a(NavigableFragment navigableFragment, Intent intent) {
            if ("com.facebook.messaging.sms.migration.END_FLOW".equals(intent.getAction())) {
                this.f4170a.f4175t.d = null;
                this.f4170a.finish();
                return;
            }
            SMSContactsMigratorActivity.m3830a(this.f4170a, navigableFragment.getClass(), intent.getExtras());
        }
    }

    public static void m3831a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SMSContactsMigratorActivity sMSContactsMigratorActivity = (SMSContactsMigratorActivity) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        RuntimePermissionsUtil b = RuntimePermissionsUtil.b(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        sMSContactsMigratorActivity.f4172p = fbSharedPreferences;
        sMSContactsMigratorActivity.f4173q = b;
        sMSContactsMigratorActivity.f4174r = secureContextHelper;
    }

    protected final void m3834b(@Nullable Bundle bundle) {
        Class cls = SMSContactsMigratorActivity.class;
        m3831a(this, this);
        setContentView(2130903775);
        this.f4175t = (DefaultNavigableFragmentController) kO_().a(2131560731);
        this.f4175t.d = new C06291(this);
        if (bundle != null) {
            this.f4177v = bundle.getBoolean("controller_initialized", false);
        }
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -599264927);
        super.onStart();
        this.f4176u = SMSContactsMigratorFlow.fromString(getIntent().getStringExtra("migration_flow"));
        if (this.f4176u == null) {
            finish();
            Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1771174741, a);
            return;
        }
        if (this.f4173q.a(f4171s)) {
            m3833i();
        } else if (this.f4178w) {
            this.f4178w = false;
            finish();
        } else {
            RequestPermissionsConfigBuilder requestPermissionsConfigBuilder = new RequestPermissionsConfigBuilder();
            requestPermissionsConfigBuilder.b = getResources().getString(2131240077);
            requestPermissionsConfigBuilder = requestPermissionsConfigBuilder;
            requestPermissionsConfigBuilder.c = RationaleBehavior.ALWAYS_SHOW;
            requestPermissionsConfigBuilder = requestPermissionsConfigBuilder;
            requestPermissionsConfigBuilder.d = false;
            this.f4174r.a(RequestPermissionsActivity.a(this, f4171s, requestPermissionsConfigBuilder.e()), 1337, this);
            this.f4178w = true;
        }
        LogUtils.c(-2071429981, a);
    }

    private void m3833i() {
        if (!this.f4177v) {
            m3830a(this, null, null);
            this.f4177v = true;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1337 && i2 == -1) {
            m3832b(intent);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("controller_initialized", this.f4177v);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 778207681);
        super.onDestroy();
        this.f4175t.d = null;
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1118409913, a);
    }

    public static void m3830a(@Nullable SMSContactsMigratorActivity sMSContactsMigratorActivity, @Nullable Class cls, Bundle bundle) {
        Class firstStep;
        if (cls == null) {
            firstStep = sMSContactsMigratorActivity.f4176u.getFirstStep();
        } else {
            firstStep = sMSContactsMigratorActivity.f4176u.getNextStep(cls);
        }
        if (firstStep == null) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(MessengerLinks.g));
            intent.setFlags(67108864);
            sMSContactsMigratorActivity.f4174r.a(intent, sMSContactsMigratorActivity);
            sMSContactsMigratorActivity.finish();
            return;
        }
        FragmentActionBuilder fragmentActionBuilder = new FragmentActionBuilder(firstStep);
        fragmentActionBuilder.a.putExtra("com.facebook.fragment.BUNDLE_EXTRAS", bundle);
        if (cls != null) {
            fragmentActionBuilder.a(2130968627, 2130968633, 2130968627, 2130968633);
        }
        sMSContactsMigratorActivity.f4175t.b(fragmentActionBuilder.a);
    }

    private void m3832b(Intent intent) {
        this.f4178w = false;
        Integer num = (Integer) ((HashMap) intent.getSerializableExtra("extra_permission_results")).get("android.permission.READ_CONTACTS");
        if (num == null) {
            finish();
        } else if (num.intValue() == 0) {
            m3833i();
        } else {
            if (num.intValue() == 1) {
                this.f4172p.edit().putBoolean(RequestPermissionsPrefKeys.c, false).commit();
            }
            if (num.intValue() == 2) {
                this.f4172p.edit().putBoolean(RequestPermissionsPrefKeys.c, true).commit();
            }
            finish();
        }
    }
}
