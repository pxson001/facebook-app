package com.facebook.installshimlib.activitylistener;

import android.app.Activity;
import com.facebook.common.activitylistener.ActivityListener;
import java.util.HashSet;
import java.util.Set;

/* compiled from: view_picture */
public class ActivityListenerContainer implements ActivityListener {
    private final Set<ActivityListener> f409a = new HashSet();

    public final synchronized void m525a(ActivityListener activityListener) {
        this.f409a.add(activityListener);
    }

    public final synchronized void m527b(ActivityListener activityListener) {
        this.f409a.remove(activityListener);
    }

    public final synchronized void m524a(Activity activity) {
        for (ActivityListener a : this.f409a) {
            a.a(activity);
        }
    }

    public final synchronized void m526b(Activity activity) {
        for (ActivityListener b : this.f409a) {
            b.b(activity);
        }
    }

    public final synchronized void m528c(Activity activity) {
        for (ActivityListener c : this.f409a) {
            c.c(activity);
        }
    }

    public final synchronized void m529d(Activity activity) {
        for (ActivityListener d : this.f409a) {
            d.d(activity);
        }
    }

    public final synchronized void m530e(Activity activity) {
        for (ActivityListener e : this.f409a) {
            e.e(activity);
        }
    }

    public final synchronized void m531f(Activity activity) {
        for (ActivityListener f : this.f409a) {
            f.f(activity);
        }
    }
}
