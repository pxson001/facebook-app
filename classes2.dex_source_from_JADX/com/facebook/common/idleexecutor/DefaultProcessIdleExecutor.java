package com.facebook.common.idleexecutor;

import com.facebook.common.appchoreographer.AppChoreographer$Priority;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.executors.AbstractListeningExecutorService;
import com.facebook.common.executors.NamedRunnable;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.ExecutorService;

/* compiled from: user_logged_in */
public class DefaultProcessIdleExecutor extends AbstractListeningExecutorService implements ListeningExecutorService {
    private final DefaultAppChoreographer f1425b;
    private final ExecutorService f1426c;

    public DefaultProcessIdleExecutor(DefaultAppChoreographer defaultAppChoreographer, ExecutorService executorService) {
        this.f1425b = defaultAppChoreographer;
        this.f1426c = executorService;
    }

    public void execute(Runnable runnable) {
        this.f1425b.m1635a(m2733b(runnable), runnable, AppChoreographer$Priority.APPLICATION_LOADED_UI_IDLE, this.f1426c);
    }

    private static String m2733b(Runnable runnable) {
        if (!BuildConstants.i) {
            return "DefaultProcessIdleExecutor";
        }
        StringBuilder stringBuilder = new StringBuilder("DefaultProcessIdleExecutor/");
        if (runnable instanceof NamedRunnable) {
            stringBuilder.append(((NamedRunnable) runnable).mo502a());
        } else {
            stringBuilder.append(runnable.getClass().getName());
        }
        return stringBuilder.toString();
    }
}
