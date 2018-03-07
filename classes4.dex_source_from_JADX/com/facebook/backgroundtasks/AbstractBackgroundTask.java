package com.facebook.backgroundtasks;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.lang.annotation.Annotation;

/* compiled from: no_user */
public abstract class AbstractBackgroundTask implements BackgroundTask {
    private final String f7076a;
    private final int f7077b;
    private BackgroundTaskRunner f7078c;

    public AbstractBackgroundTask(String str) {
        this(str, 1);
    }

    public AbstractBackgroundTask(String str, int i) {
        this.f7076a = str;
        this.f7077b = i;
    }

    public final void mo598a(BackgroundTaskRunner backgroundTaskRunner) {
        this.f7078c = backgroundTaskRunner;
    }

    public final String mo597a() {
        return this.f7076a;
    }

    public ImmutableSet<Class<? extends Annotation>> mo599b() {
        return RegularImmutableSet.a;
    }

    public ImmutableSet<String> mo600c() {
        return RegularImmutableSet.a;
    }

    public ImmutableSet<Class<? extends Annotation>> mo592d() {
        return RegularImmutableSet.a;
    }

    public final int mo601e() {
        return this.f7077b;
    }

    public long mo593f() {
        return -1;
    }

    public final void m7388g() {
        if (this.f7078c != null) {
            this.f7078c.m10268b();
        }
    }

    public String toString() {
        return mo597a();
    }
}
