package com.facebook.ui.futures;

import com.facebook.inject.InjectorLike;
import com.google.common.collect.Maps;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: commenters */
public class HostedTasksManager<Key> {
    private final TasksManager<Key> f5477a;
    private HashMap<Key, Object> f5478b = Maps.c();

    private static HostedTasksManager m10347b(InjectorLike injectorLike) {
        return new HostedTasksManager(TasksManager.b(injectorLike));
    }

    @Inject
    public HostedTasksManager(TasksManager tasksManager) {
        this.f5477a = tasksManager;
    }
}
