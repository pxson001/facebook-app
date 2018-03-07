package com.facebook.messaging.groups.links;

import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: showCommentPublisher */
public class GroupRequestsLoader {
    private final GQLGroupInfoQueryHelper f2473a;
    private final TasksManager f2474b;

    private static GroupRequestsLoader m2479b(InjectorLike injectorLike) {
        return new GroupRequestsLoader(GQLGroupInfoQueryHelper.m2477b(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public GroupRequestsLoader(GQLGroupInfoQueryHelper gQLGroupInfoQueryHelper, TasksManager tasksManager) {
        this.f2473a = gQLGroupInfoQueryHelper;
        this.f2474b = tasksManager;
    }
}
