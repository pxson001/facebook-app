package com.facebook.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appupdate.AppUpdateOperation.StateCallback;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.activitylistener.ListenableActivity;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.crudolib.appmanifestinfo.ApplicationManifestHelper;
import com.facebook.debug.log.BLog;
import com.facebook.installshimlib.activitylistener.ActivityListenerContainer;
import com.facebook.installshimlib.activitylistener.StaticActivityListeners;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.selfupdate.AppUpdateLoggerFbImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nullable;

/* compiled from: UPDATE_BUDGET */
public class AppUpdateActivity extends FragmentActivity implements ListenableActivity {
    private ViewGroup f23739A;
    private TextView f23740B;
    private Button f23741C;
    private ViewGroup f23742D;
    private Button f23743E;
    private Button f23744F;
    private ViewGroup f23745G;
    private Button f23746H;
    private Button f23747I;
    private final StateCallback f23748J = new C28721(this);
    public final Runnable f23749K = new C28732(this);
    private final OnClickListener f23750L = new C28743(this);
    private final OnClickListener f23751M = new C28754(this);
    private final OnClickListener f23752N = new C28765(this);
    private final OnClickListener f23753O = new C28776(this);
    private final OnClickListener f23754P = new C28787(this);
    private final ActivityListenerContainer f23755p = new ActivityListenerContainer();
    public AppUpdateOperationFactory f23756q;
    public AppUpdateLoggerFbImpl f23757r;
    public Handler f23758s;
    public ReleaseInfo f23759t;
    private Uri f23760u;
    public AppUpdateOperation f23761v;
    private TextView f23762w;
    private ImageView f23763x;
    private TextView f23764y;
    private TextView f23765z;

    /* compiled from: UPDATE_BUDGET */
    class C28721 implements StateCallback {
        final /* synthetic */ AppUpdateActivity f23732a;

        public final void m25767a(AppUpdateOperation appUpdateOperation, AppUpdateState appUpdateState) {
            Object obj;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f23732a.f23749K.run();
            } else {
                HandlerDetour.a(this.f23732a.f23758s, this.f23732a.f23749K, -1381044666);
            }
        }

        C28721(AppUpdateActivity appUpdateActivity) {
            this.f23732a = appUpdateActivity;
        }
    }

    /* compiled from: UPDATE_BUDGET */
    class C28732 implements Runnable {
        final /* synthetic */ AppUpdateActivity f23733a;

        C28732(AppUpdateActivity appUpdateActivity) {
            this.f23733a = appUpdateActivity;
        }

        public void run() {
            this.f23733a.m25781h();
            if (this.f23733a.f23761v.m25801c().operationState == 4) {
                this.f23733a.f23756q;
            }
        }
    }

    /* compiled from: UPDATE_BUDGET */
    class C28743 implements OnClickListener {
        final /* synthetic */ AppUpdateActivity f23734a;

        C28743(AppUpdateActivity appUpdateActivity) {
            this.f23734a = appUpdateActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 239278684);
            this.f23734a.finish();
            this.f23734a.f23757r.a("appupdateactivity_not_now", this.f23734a.f23759t.m25828a());
            Logger.a(2, EntryType.UI_INPUT_END, -1663538703, a);
        }
    }

    /* compiled from: UPDATE_BUDGET */
    class C28754 implements OnClickListener {
        final /* synthetic */ AppUpdateActivity f23735a;

        C28754(AppUpdateActivity appUpdateActivity) {
            this.f23735a = appUpdateActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 236304988);
            this.f23735a.f23757r;
            Logger.a(2, EntryType.UI_INPUT_END, -1172177042, a);
        }
    }

    /* compiled from: UPDATE_BUDGET */
    class C28765 implements OnClickListener {
        final /* synthetic */ AppUpdateActivity f23736a;

        C28765(AppUpdateActivity appUpdateActivity) {
            this.f23736a = appUpdateActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1245189952);
            this.f23736a.f23756q.a(this.f23736a.f23761v);
            this.f23736a.f23757r.a("appupdateactivity_cancel", this.f23736a.f23759t.m25828a());
            Logger.a(2, EntryType.UI_INPUT_END, -915573532, a);
        }
    }

    /* compiled from: UPDATE_BUDGET */
    class C28776 implements OnClickListener {
        final /* synthetic */ AppUpdateActivity f23737a;

        C28776(AppUpdateActivity appUpdateActivity) {
            this.f23737a = appUpdateActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 137032889);
            this.f23737a.f23756q.a(this.f23737a.f23761v);
            this.f23737a.f23757r.a("appupdateactivity_discard", this.f23737a.f23759t.m25828a());
            Logger.a(2, EntryType.UI_INPUT_END, -54360038, a);
        }
    }

    /* compiled from: UPDATE_BUDGET */
    class C28787 implements OnClickListener {
        final /* synthetic */ AppUpdateActivity f23738a;

        C28787(AppUpdateActivity appUpdateActivity) {
            this.f23738a = appUpdateActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -57671226);
            this.f23738a.f23756q;
            this.f23738a.f23757r.a("appupdateactivity_install", this.f23738a.f23759t.m25828a());
            Logger.a(2, EntryType.UI_INPUT_END, -1890450042, a);
        }
    }

    protected void onCreate(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 834339387);
        super.onCreate(bundle);
        AppUpdateInjector a2 = AppUpdateInjector.a();
        this.f23756q = a2.e();
        this.f23757r = a2.g();
        this.f23758s = a2.i();
        setContentView(2130904936);
        this.f23762w = (TextView) findViewById(2131563206);
        this.f23763x = (ImageView) findViewById(2131559621);
        this.f23764y = (TextView) findViewById(2131563208);
        this.f23765z = (TextView) findViewById(2131563209);
        this.f23739A = (ViewGroup) findViewById(2131563210);
        this.f23740B = (TextView) findViewById(2131563211);
        this.f23741C = (Button) findViewById(2131563212);
        this.f23741C.setOnClickListener(this.f23752N);
        this.f23742D = (ViewGroup) findViewById(2131563213);
        this.f23743E = (Button) findViewById(2131563214);
        this.f23743E.setOnClickListener(this.f23750L);
        this.f23744F = (Button) findViewById(2131563215);
        this.f23744F.setOnClickListener(this.f23751M);
        this.f23745G = (ViewGroup) findViewById(2131563216);
        this.f23746H = (Button) findViewById(2131563217);
        this.f23746H.setOnClickListener(this.f23753O);
        this.f23747I = (Button) findViewById(2131563218);
        this.f23747I.setOnClickListener(this.f23754P);
        Intent intent = getIntent();
        this.f23761v = m25773b(intent.getStringExtra("operation_uuid"));
        if (this.f23761v == null) {
            finish();
            Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 2064462336, a);
            return;
        }
        this.f23759t = this.f23761v.m25801c().releaseInfo;
        m25778f();
        if (intent.getBooleanExtra("start_immediately", false) && this.f23761v.m25801c().operationState == 0) {
            this.f23757r;
        }
        this.f23755p.a(StaticActivityListeners.a());
        this.f23755p.a(this);
        LogUtils.c(-1220890736, a);
    }

    private void m25778f() {
        try {
            this.f23762w.setText(getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(this.f23759t.packageName, 0)).toString());
            this.f23763x.setImageDrawable(getPackageManager().getApplicationIcon(this.f23759t.packageName));
        } catch (NameNotFoundException e) {
        }
        this.f23764y.setText(StringFormatUtil.a("New in version %1$s", new Object[]{this.f23759t.versionName}));
        this.f23765z.setText(this.f23759t.releaseNotes);
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1131910142);
        super.onStart();
        this.f23755p.b(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -348233130, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -265910826);
        super.onResume();
        m25781h();
        this.f23761v.m25799a(this.f23748J, true);
        this.f23755p.c(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 673108312, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1129313531);
        this.f23761v.m25798a(this.f23748J);
        this.f23755p.d(this);
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -107650912, a);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1715856808);
        this.f23755p.e(this);
        super.onStop();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1794755775, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1085893964);
        this.f23755p.f(this);
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -372810292, a);
    }

    public final void m25785a(ActivityListener activityListener) {
        this.f23755p.a(activityListener);
    }

    public final void m25786b(ActivityListener activityListener) {
        this.f23755p.b(activityListener);
    }

    public static void m25780g(AppUpdateActivity appUpdateActivity) {
        appUpdateActivity.f23761v.m25800b();
        appUpdateActivity.f23757r.a("appupdateactivity_download_and_install", appUpdateActivity.f23759t.m25828a());
    }

    private void m25781h() {
        AppUpdateState c = this.f23761v.m25801c();
        switch (c.operationState) {
            case 0:
                this.f23739A.setVisibility(8);
                this.f23742D.setVisibility(0);
                this.f23745G.setVisibility(8);
                return;
            case 1:
                this.f23739A.setVisibility(0);
                this.f23742D.setVisibility(8);
                this.f23745G.setVisibility(8);
                this.f23740B.setText("Starting...");
                return;
            case 2:
                this.f23739A.setVisibility(0);
                this.f23742D.setVisibility(8);
                this.f23745G.setVisibility(8);
                if (c.downloadSize > -1) {
                    this.f23740B.setText("Downloading... " + c.downloadProgress + "/" + c.downloadSize);
                    return;
                } else {
                    this.f23740B.setText("Downloading... ");
                    return;
                }
            case 3:
                this.f23739A.setVisibility(0);
                this.f23742D.setVisibility(8);
                this.f23745G.setVisibility(8);
                this.f23740B.setText("Verifying... ");
                return;
            case 4:
                this.f23760u = Uri.parse(c.localFile.toURI().toString());
                this.f23739A.setVisibility(8);
                this.f23742D.setVisibility(8);
                this.f23745G.setVisibility(0);
                return;
            case 5:
                m25770a(c.failureReason);
                this.f23756q.a(this.f23761v);
                return;
            case 6:
                finish();
                return;
            default:
                return;
        }
    }

    @Nullable
    private AppUpdateOperation m25773b(String str) {
        try {
            AppUpdateOperation a = this.f23756q.a(str);
            if (a != null) {
                return a;
            }
            BLog.a(AppUpdateActivity.class, "No such operation: %s", new Object[]{str});
            Toast.makeText(this, "No such operation: " + str, 0).show();
            return a;
        } catch (Throwable th) {
            m25770a(th);
            return null;
        }
    }

    private void m25770a(Throwable th) {
        BLog.a(AppUpdateActivity.class, "Update Operation failed!", th);
        Toast.makeText(this, "Update failed: " + th, 0).show();
    }

    public static void m25784i(AppUpdateActivity appUpdateActivity) {
        AppUpdateInjector.a().h();
        appUpdateActivity.startActivity(m25768a(appUpdateActivity, appUpdateActivity.f23760u));
    }

    public static Intent m25768a(Context context, Uri uri) {
        Intent intent = new Intent();
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        if (m25771a(context)) {
            intent.setAction("android.intent.action.INSTALL_PACKAGE");
        } else {
            intent.setAction("android.intent.action.VIEW");
        }
        intent.setFlags(268435456);
        intent.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", context.getPackageName());
        return intent;
    }

    private static boolean m25771a(Context context) {
        if (VERSION.SDK_INT < 14) {
            return false;
        }
        if (VERSION.SDK_INT <= 22) {
            return true;
        }
        ApplicationManifestHelper.m25917b(context);
        int i = ApplicationManifestHelper.f23968c;
        if (i > 0 && i <= 22) {
            return true;
        }
        if (context.checkCallingOrSelfPermission("android.permission.REQUEST_INSTALL_PACKAGES") == 0) {
            return true;
        }
        return false;
    }
}
