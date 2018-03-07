package com.facebook.ui.futures;

import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.ui.futures.TasksManager.CallbackWithCleanup;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: comment_view_more_replies_clicked */
class TasksManager$CallbackWithOlderTasksCleanup<T> extends CallbackWithCleanup<T> {
    final /* synthetic */ TasksManager f5480b;

    TasksManager$CallbackWithOlderTasksCleanup(TasksManager tasksManager, Key key, DisposableFutureCallback<T> disposableFutureCallback) {
        this.f5480b = tasksManager;
        super(tasksManager, key, disposableFutureCallback);
    }

    public void onSuccess(T t) {
        Object obj;
        synchronized (this.f5480b) {
            List<FutureAndCallbackHolder> a = this.f5480b.a.a(b());
        }
        List<FutureAndCallbackHolder> a2 = Lists.a();
        for (FutureAndCallbackHolder futureAndCallbackHolder : a) {
            if (futureAndCallbackHolder.b() == this) {
                obj = 1;
                break;
            }
            a2.add(futureAndCallbackHolder);
        }
        obj = null;
        if (obj == null || ba_()) {
            super.onSuccess(t);
            return;
        }
        synchronized (this.f5480b) {
            for (FutureAndCallbackHolder futureAndCallbackHolder2 : a2) {
                futureAndCallbackHolder2.a(false);
                this.f5480b.a.c(b(), futureAndCallbackHolder2);
            }
        }
        super.onSuccess(t);
    }
}
