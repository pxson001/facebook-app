package com.facebook.ui.futures;

import com.facebook.ui.futures.TasksManager.PendingTaskStatus;

/* compiled from: comment_view_more_replies_clicked */
/* synthetic */ class TasksManager$1 {
    static final /* synthetic */ int[] f5479a = new int[PendingTaskStatus.values().length];

    static {
        try {
            f5479a[PendingTaskStatus.SUCCESSFUL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5479a[PendingTaskStatus.FAILED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5479a[PendingTaskStatus.DISPOSED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
