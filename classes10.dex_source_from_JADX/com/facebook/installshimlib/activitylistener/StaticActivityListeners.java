package com.facebook.installshimlib.activitylistener;

/* compiled from: view_photo */
public class StaticActivityListeners {
    private static ActivityListenerContainer f410a;

    public static synchronized ActivityListenerContainer m532a() {
        ActivityListenerContainer activityListenerContainer;
        synchronized (StaticActivityListeners.class) {
            if (f410a == null) {
                f410a = new ActivityListenerContainer();
            }
            activityListenerContainer = f410a;
        }
        return activityListenerContainer;
    }
}
