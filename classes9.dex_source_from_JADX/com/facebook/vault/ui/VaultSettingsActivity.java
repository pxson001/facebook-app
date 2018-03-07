package com.facebook.vault.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fql.FqlHelper;
import com.facebook.fql.FqlHelper.BasicCondition;
import com.facebook.fql.FqlHelper.Field;
import com.facebook.fql.FqlHelper.Table;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.vault.prefs.DeviceIDPref;
import com.facebook.vault.prefs.SyncModePref;
import com.facebook.vault.prefs.SyncOldPhotoPref;
import com.facebook.vault.service.VaultDeviceSetup;
import com.facebook.vault.service.VaultHelpers;
import com.facebook.vault.service.VaultManager;
import com.facebook.vault.service.VaultQuotaClient;
import com.facebook.vault.service.VaultQuotaClient.C01811;
import com.facebook.vault.service.VaultQuotaClient.Quota;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;

/* compiled from: text/vnd.wap.sl */
public class VaultSettingsActivity extends FbFragmentActivity implements OnCheckedChangeListener {
    public static final Class<?> f2010x = VaultSettingsActivity.class;
    private TextView f2011A;
    public TextView f2012B;
    public TextView f2013C;
    @Inject
    SyncOldPhotoPref f2014p;
    @Inject
    DeviceIDPref f2015q;
    @Inject
    SyncModePref f2016r;
    @Inject
    VaultDeviceSetup f2017s;
    @Inject
    VaultHelpers f2018t;
    @Inject
    VaultManager f2019u;
    @Inject
    @ForUiThread
    ScheduledExecutorService f2020v;
    @Inject
    VaultQuotaClient f2021w;
    public LinearLayout f2022y;
    private CheckBox f2023z;

    /* compiled from: text/vnd.wap.sl */
    class C01881 implements OnClickListener {
        final /* synthetic */ VaultSettingsActivity f2005a;

        C01881(VaultSettingsActivity vaultSettingsActivity) {
            this.f2005a = vaultSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 982985394);
            final boolean isChecked = ((CheckBox) view).isChecked();
            this.f2005a.f2014p.a(isChecked);
            new Thread(this) {
                final /* synthetic */ C01881 f2004b;

                public void run() {
                    this.f2004b.f2005a.f2017s.a(this.f2004b.f2005a.f2015q.a(), isChecked);
                }
            }.start();
            VaultSettingsActivity.m2047b(this.f2005a, isChecked);
            if (isChecked) {
                this.f2005a.f2018t.c(10);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1573777727, a);
        }
    }

    /* compiled from: text/vnd.wap.sl */
    class C01892 implements FutureCallback<Quota> {
        final /* synthetic */ VaultSettingsActivity f2006a;

        C01892(VaultSettingsActivity vaultSettingsActivity) {
            this.f2006a = vaultSettingsActivity;
        }

        public void onSuccess(Object obj) {
            Quota quota = (Quota) obj;
            CharSequence b = VaultSettingsActivity.m2046b(quota.f1915a, this.f2006a);
            int round = Math.round((float) ((quota.f1916b * 100) / quota.f1915a));
            CharSequence string = this.f2006a.getString(2131234323, new Object[]{Integer.valueOf(round)});
            this.f2006a.f2012B.setText(b);
            this.f2006a.f2013C.setText(string);
        }

        public void onFailure(Throwable th) {
            BLog.b(VaultSettingsActivity.f2010x, "Failed to retrieve quota information: ", th);
            this.f2006a.f2012B.setText(this.f2006a.getString(2131234324));
            this.f2006a.f2013C.setText(this.f2006a.getString(2131234324));
        }
    }

    /* compiled from: text/vnd.wap.sl */
    class C01903 implements DialogInterface.OnClickListener {
        final /* synthetic */ VaultSettingsActivity f2007a;

        C01903(VaultSettingsActivity vaultSettingsActivity) {
            this.f2007a = vaultSettingsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            VaultSettingsActivity.m2049c(this.f2007a, "OFF");
            this.f2007a.f2022y.setVisibility(8);
        }
    }

    /* compiled from: text/vnd.wap.sl */
    class C01914 implements OnCancelListener {
        final /* synthetic */ VaultSettingsActivity f2008a;

        C01914(VaultSettingsActivity vaultSettingsActivity) {
            this.f2008a = vaultSettingsActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            VaultSettingsActivity.m2052j(this.f2008a);
        }
    }

    /* compiled from: text/vnd.wap.sl */
    class C01925 implements DialogInterface.OnClickListener {
        final /* synthetic */ VaultSettingsActivity f2009a;

        C01925(VaultSettingsActivity vaultSettingsActivity) {
            this.f2009a = vaultSettingsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            VaultSettingsActivity.m2052j(this.f2009a);
        }
    }

    private static <T extends Context> void m2041a(Class<T> cls, T t) {
        m2042a((Object) t, (Context) t);
    }

    public static void m2042a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VaultSettingsActivity) obj).m2038a(SyncOldPhotoPref.a(fbInjector), DeviceIDPref.a(fbInjector), SyncModePref.a(fbInjector), VaultDeviceSetup.b(fbInjector), VaultHelpers.b(fbInjector), VaultManager.a(fbInjector), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), VaultQuotaClient.m1977a(fbInjector));
    }

    private void m2038a(SyncOldPhotoPref syncOldPhotoPref, DeviceIDPref deviceIDPref, SyncModePref syncModePref, VaultDeviceSetup vaultDeviceSetup, VaultHelpers vaultHelpers, VaultManager vaultManager, ScheduledExecutorService scheduledExecutorService, VaultQuotaClient vaultQuotaClient) {
        this.f2014p = syncOldPhotoPref;
        this.f2015q = deviceIDPref;
        this.f2016r = syncModePref;
        this.f2017s = vaultDeviceSetup;
        this.f2018t = vaultHelpers;
        this.f2019u = vaultManager;
        this.f2020v = scheduledExecutorService;
        this.f2021w = vaultQuotaClient;
    }

    public final void m2055b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130907649);
        this.f2011A = (TextView) a(2131568285);
        this.f2022y = (LinearLayout) a(2131568283);
        this.f2023z = (CheckBox) a(2131568284);
        this.f2012B = (TextView) a(2131568286);
        this.f2013C = (TextView) a(2131568287);
        Class cls = VaultSettingsActivity.class;
        m2042a((Object) this, (Context) this);
        this.f2023z.setOnClickListener(new C01881(this));
        m2052j(this);
        ((RadioGroup) findViewById(2131568279)).setOnCheckedChangeListener(this);
        m2053k();
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 49668790);
        super.onResume();
        RadioGroup radioGroup = (RadioGroup) findViewById(2131568279);
        radioGroup.setOnCheckedChangeListener(null);
        m2052j(this);
        radioGroup.setOnCheckedChangeListener(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -742861488, a);
    }

    public static void m2047b(VaultSettingsActivity vaultSettingsActivity, boolean z) {
        vaultSettingsActivity.f2023z.setChecked(z);
        if (z) {
            vaultSettingsActivity.f2011A.setText(2131234313);
        } else {
            vaultSettingsActivity.f2011A.setText(2131234312);
        }
    }

    public static void m2052j(VaultSettingsActivity vaultSettingsActivity) {
        String a = vaultSettingsActivity.f2016r.a();
        ((RadioButton) vaultSettingsActivity.findViewById(m2043b(a))).setChecked(true);
        if (a.equals("OFF")) {
            vaultSettingsActivity.f2022y.setVisibility(8);
        } else {
            vaultSettingsActivity.f2022y.setVisibility(0);
        }
        m2047b(vaultSettingsActivity, vaultSettingsActivity.f2014p.a());
    }

    private void m2053k() {
        VaultQuotaClient vaultQuotaClient = this.f2021w;
        Futures.a(vaultQuotaClient.f1921d.a(new C01811(vaultQuotaClient, FqlHelper.a().a(new Field[]{VaultQuotaClient.f1917a}).a(Table.USER).a(new BasicCondition(VaultQuotaClient.f1918b.toString() + " = me()")))), new C01892(this), this.f2020v);
    }

    private static String m2045b(int i) {
        if (i == 2131568280) {
            return "MOBILE_RADIO";
        }
        if (i == 2131568281) {
            return "WIFI_ONLY";
        }
        if (i == 2131568282) {
            return "OFF";
        }
        throw new IllegalArgumentException("unknown id: " + i);
    }

    private static int m2043b(String str) {
        if (str.equals("MOBILE_RADIO")) {
            return 2131568280;
        }
        if (str.equals("WIFI_ONLY")) {
            return 2131568281;
        }
        if (str.equals("OFF")) {
            return 2131568282;
        }
        throw new IllegalArgumentException("unknown sync mode: " + str);
    }

    public static void m2049c(VaultSettingsActivity vaultSettingsActivity, String str) {
        vaultSettingsActivity.f2016r.a(str);
        vaultSettingsActivity.f2019u.a();
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String b = m2045b(i);
        if (b.equals("OFF")) {
            m2054l();
            return;
        }
        m2049c(this, b);
        this.f2022y.setVisibility(0);
    }

    private void m2054l() {
        DialogInterface.OnClickListener c01903 = new C01903(this);
        OnCancelListener c01914 = new C01914(this);
        DialogInterface.OnClickListener c01925 = new C01925(this);
        Builder builder = new Builder(this);
        builder.a(getResources().getDrawable(17301659));
        builder.b(getString(2131234320));
        builder.a(getString(2131234321), c01903);
        builder.b(getString(2131234322), c01925);
        builder.a(c01914);
        builder.a(true);
        builder.a().show();
    }

    public static String m2046b(long j, Context context) {
        int[] iArr = new int[]{2131234341, 2131234342, 2131234343, 2131234344, 2131234345, 2131234346};
        if (j < 1024) {
            return context.getString(2131234340, new Object[]{Long.toString(j)});
        }
        String a = StringFormatUtil.a("%.1f", new Object[]{Double.valueOf(((double) j) / Math.pow(1024.0d, (double) ((int) (Math.log((double) j) / Math.log(1024.0d)))))});
        return context.getResources().getString(iArr[r1 - 1], new Object[]{a});
    }
}
