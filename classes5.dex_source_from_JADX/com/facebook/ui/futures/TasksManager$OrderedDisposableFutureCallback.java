package com.facebook.ui.futures;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.ui.futures.TasksManager.PendingResultHolder;
import com.facebook.ui.futures.TasksManager.PendingTaskStatus;
import java.util.List;

/* compiled from: comment_view_more_replies_clicked */
public class TasksManager$OrderedDisposableFutureCallback<T> implements DisposableFutureCallback<T> {
    final /* synthetic */ TasksManager f5481a;
    private Key f5482b;
    private DisposableFutureCallback<T> f5483c;
    private PendingResultHolder<T> f5484d;
    public TasksManager$OrderedDisposableFutureCallback<T> f5485e = null;
    public TasksManager$OrderedDisposableFutureCallback<T> f5486f = null;

    TasksManager$OrderedDisposableFutureCallback(TasksManager tasksManager, Key key, DisposableFutureCallback<T> disposableFutureCallback) {
        this.f5481a = tasksManager;
        this.f5483c = disposableFutureCallback;
        this.f5482b = key;
    }

    public void onSuccess(T t) {
        if (m10349d()) {
            this.f5484d = new PendingResultHolder(t, null, PendingTaskStatus.SUCCESSFUL);
            m10348b();
        }
    }

    public void onFailure(Throwable th) {
        if (m10349d()) {
            this.f5484d = new PendingResultHolder(null, th, PendingTaskStatus.FAILED);
            m10348b();
        }
    }

    public final void jc_() {
        if (m10349d()) {
            this.f5484d = TasksManager.d;
            m10348b();
        }
    }

    public final boolean ba_() {
        boolean z;
        synchronized (this) {
            z = this.f5483c == null || this.f5483c.ba_();
        }
        return z;
    }

    private void m10348b() {
        if (this.f5484d != null && this.f5485e == null) {
            TasksManager.a(this.f5481a, this.f5482b, this);
            switch (TasksManager$1.f5479a[this.f5484d.c.ordinal()]) {
                case 1:
                    if (this.f5483c != null) {
                        this.f5483c.onSuccess(this.f5484d.a);
                        break;
                    }
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    if (this.f5483c != null) {
                        this.f5483c.onFailure(this.f5484d.b);
                        break;
                    }
                    break;
                case 3:
                    this.f5483c.jc_();
                    this.f5483c = null;
                    break;
            }
            if (this.f5486f != null) {
                TasksManager$OrderedDisposableFutureCallback tasksManager$OrderedDisposableFutureCallback = this.f5486f;
                this.f5486f = null;
                tasksManager$OrderedDisposableFutureCallback.f5485e = null;
                tasksManager$OrderedDisposableFutureCallback.m10348b();
            }
        }
    }

    private synchronized boolean m10349d() {
        boolean z;
        synchronized (this.f5481a) {
            List<FutureAndCallbackHolder> a = this.f5481a.a.a(this.f5482b);
        }
        for (FutureAndCallbackHolder b : a) {
            if (b.b() == this) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }
}
