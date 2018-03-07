package com.facebook.backstage.camera;

import android.os.Handler;
import android.os.Looper;
import com.facebook.backstage.data.LiveStatus;
import com.facebook.common.time.MonotonicClock;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: search?query={%s} */
public class LiveStatusPoller {
    private static final long f4418a = TimeUnit.SECONDS.toMillis(2);
    public final Handler f4419b = new Handler(Looper.getMainLooper());
    public LiveStatusListener f4420c;
    public final DemoLiveStatusGenerator f4421d = new DemoLiveStatusGenerator(this);
    public final MonotonicClock f4422e;

    /* compiled from: search?query={%s} */
    public class DemoLiveStatusGenerator {
        public final /* synthetic */ LiveStatusPoller f4412a;
        private final String f4413b = "VideoId1";
        public final int[] f4414c = new int[]{20, 2, 1, 0, 9};
        public final String[] f4415d = new String[]{"New York", "New York", "Orange County", "Honolulu", "New York"};
        public Random f4416e = new Random();
        public long f4417f = 0;

        public DemoLiveStatusGenerator(LiveStatusPoller liveStatusPoller) {
            this.f4412a = liveStatusPoller;
        }
    }

    /* compiled from: search?query={%s} */
    public interface LiveStatusListener {
        void mo150a(LiveStatus liveStatus);
    }

    @Inject
    public LiveStatusPoller(MonotonicClock monotonicClock) {
        this.f4422e = monotonicClock;
    }

    private void m4415b(final String str) {
        HandlerDetour.b(this.f4419b, new Runnable(this) {
            final /* synthetic */ LiveStatusPoller f4411b;

            public void run() {
                LiveStatusPoller.m4416c(this.f4411b, str);
            }
        }, f4418a, 1669467146);
    }

    public static void m4416c(LiveStatusPoller liveStatusPoller, String str) {
        DemoLiveStatusGenerator demoLiveStatusGenerator = liveStatusPoller.f4421d;
        int nextInt = demoLiveStatusGenerator.f4416e.nextInt(demoLiveStatusGenerator.f4414c.length);
        liveStatusPoller.f4420c.mo150a(new LiveStatus("VideoId1", demoLiveStatusGenerator.f4412a.f4422e.now() - demoLiveStatusGenerator.f4417f, demoLiveStatusGenerator.f4414c[nextInt], demoLiveStatusGenerator.f4415d[nextInt]));
        liveStatusPoller.m4415b(str);
    }
}
