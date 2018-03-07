package com.facebook.katana.activity.faceweb;

import android.os.Handler;
import android.os.SystemClock;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: used_report_url */
public class FacewebAssassin implements Runnable {
    private static List<FacewebFragmentRecord> f733a = new ArrayList();
    public final Handler f734b;
    private final AssassinFilter f735c;

    /* compiled from: used_report_url */
    public interface AssassinFilter {
        boolean mo27a(int i);

        boolean mo28a(long j);
    }

    /* compiled from: used_report_url */
    public class BookmarksMenuAssassin implements AssassinFilter {
        public final boolean mo27a(int i) {
            return true;
        }

        public final boolean mo28a(long j) {
            return j > 35000;
        }
    }

    /* compiled from: used_report_url */
    class FacewebFragmentRecord {
        public final WeakReference<FacewebFragment> f731a;
        public final long f732b = SystemClock.uptimeMillis();

        FacewebFragmentRecord(FacewebFragment facewebFragment) {
            this.f731a = new WeakReference(facewebFragment);
        }
    }

    public static FacewebAssassin m747a(Handler handler, AssassinFilter assassinFilter, int i) {
        if (!assassinFilter.mo27a(f733a.size())) {
            return null;
        }
        Object facewebAssassin = new FacewebAssassin(handler, assassinFilter);
        HandlerDetour.b(handler, facewebAssassin, (long) i, 862589412);
        return facewebAssassin;
    }

    static final void m748a(FacewebFragment facewebFragment) {
        synchronized (f733a) {
            f733a.add(new FacewebFragmentRecord(facewebFragment));
        }
    }

    static final void m749b(FacewebFragment facewebFragment) {
        synchronized (f733a) {
            Iterator it = f733a.iterator();
            while (it.hasNext()) {
                FacewebFragment facewebFragment2 = (FacewebFragment) ((FacewebFragmentRecord) it.next()).f731a.get();
                if (facewebFragment2 == null || facewebFragment2 == facewebFragment) {
                    it.remove();
                }
            }
        }
    }

    private FacewebAssassin(Handler handler, AssassinFilter assassinFilter) {
        this.f734b = handler;
        this.f735c = assassinFilter;
    }

    public void run() {
        synchronized (f733a) {
            Iterator it = f733a.iterator();
            FacewebFragmentRecord facewebFragmentRecord = null;
            while (it.hasNext() && facewebFragmentRecord == null) {
                FacewebFragmentRecord facewebFragmentRecord2 = (FacewebFragmentRecord) it.next();
                if (facewebFragmentRecord2.f731a == null) {
                    facewebFragmentRecord2 = facewebFragmentRecord;
                } else if (!this.f735c.mo28a(SystemClock.uptimeMillis() - facewebFragmentRecord2.f732b)) {
                }
                it.remove();
                facewebFragmentRecord = facewebFragmentRecord2;
            }
        }
        if (facewebFragmentRecord != null) {
            FacewebFragment facewebFragment = (FacewebFragment) facewebFragmentRecord.f731a.get();
            if (facewebFragment != null) {
                int size;
                facewebFragment.as();
                synchronized (f733a) {
                    size = f733a.size();
                }
                if (size > 3) {
                    HandlerDetour.b(this.f734b, this, 1000, -509268848);
                }
            }
        }
    }
}
