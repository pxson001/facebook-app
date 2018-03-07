package com.facebook.common.activitylistener;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: subTitle */
public class ActivityListenerManager {

    /* compiled from: subTitle */
    class Listener extends BaseActivityListener {
        private final WeakReference<ActivityListener> f2472a;

        public Listener(ActivityListener activityListener) {
            this.f2472a = new WeakReference(activityListener);
        }

        public final void m3599a(Activity activity) {
            ActivityListener g = m3598g(activity);
            if (g != null) {
                g.a(activity);
            }
        }

        public final void m3604f(Activity activity) {
            ActivityListener g = m3598g(activity);
            if (g != null) {
                g.f(activity);
            }
        }

        public final void m3600b(Activity activity) {
            ActivityListener g = m3598g(activity);
            if (g != null) {
                g.b(activity);
            }
        }

        public final void m3603e(Activity activity) {
            ActivityListener g = m3598g(activity);
            if (g != null) {
                g.e(activity);
            }
        }

        public final void m3601c(Activity activity) {
            ActivityListener g = m3598g(activity);
            if (g != null) {
                g.c(activity);
            }
        }

        public final void m3602d(Activity activity) {
            ActivityListener g = m3598g(activity);
            if (g != null) {
                g.d(activity);
            }
        }

        private ActivityListener m3598g(Activity activity) {
            ActivityListener activityListener = (ActivityListener) this.f2472a.get();
            if (activityListener == null) {
                Preconditions.a(activity instanceof ListenableActivity);
                ((ListenableActivity) activity).b(this);
            }
            return activityListener;
        }
    }

    public static void m3605a(ActivityListener activityListener, Context context) {
        Context context2;
        if ((context instanceof ListenableActivity) || !(context instanceof ContextWrapper)) {
            context2 = context;
        } else {
            context2 = ((ContextWrapper) context).getBaseContext();
        }
        if (context2 instanceof ListenableActivity) {
            ((ListenableActivity) context2).a(new Listener(activityListener));
        }
    }
}
