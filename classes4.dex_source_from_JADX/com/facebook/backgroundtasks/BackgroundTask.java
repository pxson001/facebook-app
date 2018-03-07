package com.facebook.backgroundtasks;

import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Set;

/* compiled from: no_send_attempt_on_success */
public interface BackgroundTask {

    /* compiled from: no_send_attempt_on_success */
    public enum Prerequisite {
        NETWORK_CONNECTIVITY,
        USER_LOGGED_IN,
        USER_LOGGED_IN_ALLOWING_LOGGING_OUT,
        USER_IN_APP
    }

    String mo597a();

    void mo598a(BackgroundTaskRunner backgroundTaskRunner);

    ImmutableSet<Class<? extends Annotation>> mo599b();

    ImmutableSet<String> mo600c();

    ImmutableSet<Class<? extends Annotation>> mo592d();

    int mo601e();

    long mo593f();

    Set<Prerequisite> mo594h();

    boolean mo595i();

    ListenableFuture<BackgroundResult> mo596j();
}
