package com.facebook.conditionalworker;

import com.facebook.common.time.TimeUtil;
import javax.inject.Provider;

/* compiled from: is_backgrounded */
public interface ConditionalWorkerInfo {
    public static final long f10113a = TimeUtil.m10808a(5);

    /* compiled from: is_backgrounded */
    public enum Trigger {
        INTERVAL,
        STATE_CHANGE
    }

    boolean mo788a();

    Trigger mo789b();

    Provider<? extends ConditionalWorker> mo790c();

    RequiredStates mo791d();

    long mo792e();
}
