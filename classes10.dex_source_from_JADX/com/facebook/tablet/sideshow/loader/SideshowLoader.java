package com.facebook.tablet.sideshow.loader;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.content.AsyncTaskLoader;
import com.facebook.tablet.sideshow.SideshowUnitWrapper;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: half_height */
public class SideshowLoader extends AsyncTaskLoader<Void> {
    private ListeningExecutorService f10125f;
    private List<SideshowUnitWrapper> f10126g;
    public CountDownLatch f10127h = new CountDownLatch(this.f10126g.size());

    public SideshowLoader(Context context, ListeningExecutorService listeningExecutorService, List<SideshowUnitWrapper> list) {
        super(context);
        this.f10125f = listeningExecutorService;
        this.f10126g = list;
    }

    protected final void m10187g() {
        super.g();
        if (this.f10127h.getCount() != 0) {
            a();
        }
    }

    public final Object m10186d() {
        for (final SideshowUnitWrapper sideshowUnitWrapper : this.f10126g) {
            final C14851 c14851 = new Object(this) {
                final /* synthetic */ SideshowLoader f10121b;

                public final void m10184a(LoadResult loadResult) {
                    SideshowUnitWrapper sideshowUnitWrapper = sideshowUnitWrapper;
                    sideshowUnitWrapper.f10117f = SystemClock.uptimeMillis() - sideshowUnitWrapper.f10116e;
                    sideshowUnitWrapper.f10113b = loadResult;
                    this.f10121b.f10127h.countDown();
                }
            };
            ExecutorDetour.a(this.f10125f, new Runnable(this) {
                final /* synthetic */ SideshowLoader f10124c;

                public void run() {
                    SideshowUnitWrapper sideshowUnitWrapper = sideshowUnitWrapper;
                    Context context = this.f10124c.o;
                    C14851 c14851 = c14851;
                    sideshowUnitWrapper.f10116e = SystemClock.uptimeMillis();
                    sideshowUnitWrapper.f10112a.a(context, c14851);
                }
            }, 451993999);
        }
        m10185x();
        return null;
    }

    private void m10185x() {
        try {
            this.f10127h.await();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
