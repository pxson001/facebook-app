package com.facebook.messaging.camerautil;

import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;

/* compiled from: messenger_transcode_finished */
public class MonitoredActivity extends FbFragmentActivity {
    public final ArrayList<LifeCycleListener> f9629p = new ArrayList();

    /* compiled from: messenger_transcode_finished */
    public class LifeCycleAdapter {
        public void mo380a() {
        }

        public void mo382c() {
        }

        public void mo381b() {
        }
    }

    protected void mo383b(Bundle bundle) {
        super.b(bundle);
        int size = this.f9629p.size();
        for (int i = 0; i < size; i++) {
            this.f9629p.get(i);
        }
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -182153975);
        super.onDestroy();
        int size = this.f9629p.size();
        for (int i = 0; i < size; i++) {
            ((LifeCycleAdapter) this.f9629p.get(i)).mo380a();
        }
        LogUtils.c(-293264163, a);
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1465999626);
        super.onStart();
        int size = this.f9629p.size();
        for (int i = 0; i < size; i++) {
            ((LifeCycleAdapter) this.f9629p.get(i)).mo382c();
        }
        LogUtils.c(1329181583, a);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1900099081);
        super.onStop();
        int size = this.f9629p.size();
        for (int i = 0; i < size; i++) {
            ((LifeCycleAdapter) this.f9629p.get(i)).mo381b();
        }
        LogUtils.c(-1780557961, a);
    }
}
