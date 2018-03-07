package com.facebook.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: UNCHANGED */
public class WaitForInitActivity extends Activity {
    public Intent f23834a;
    private final InitWithInjector f23835b = new C28851(this);

    /* compiled from: UNCHANGED */
    class C28851 implements InitWithInjector {
        final /* synthetic */ WaitForInitActivity f23833a;

        C28851(WaitForInitActivity waitForInitActivity) {
            this.f23833a = waitForInitActivity;
        }

        public final void mo1101a(AppUpdateInjector appUpdateInjector) {
            AppUpdateOperationFactory e = appUpdateInjector.e();
            e.a();
            e.b();
            this.f23833a.startActivity(this.f23833a.f23834a);
            this.f23833a.finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 481814827);
        super.onCreate(bundle);
        this.f23834a = (Intent) getIntent().getExtras().getParcelable("next_activity_intent");
        Preconditions.a(this.f23834a != null);
        setContentView(2130907760);
        AppUpdateInjector.a(this.f23835b);
        LogUtils.c(-85697136, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -2129462867);
        super.onDestroy();
        AppUpdateInjector.b(this.f23835b);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -388291624, a);
    }
}
