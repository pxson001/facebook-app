package com.facebook.aldrin.task;

import com.facebook.aldrin.prefs.AldrinPrefKeys;
import com.facebook.aldrin.status.AldrinUserStatus;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: launch_activity_for_result */
class UpdateAldrinUserStatusBackgroundTask$1 implements FutureCallback<AldrinUserStatus> {
    final /* synthetic */ UpdateAldrinUserStatusBackgroundTask f10386a;

    UpdateAldrinUserStatusBackgroundTask$1(UpdateAldrinUserStatusBackgroundTask updateAldrinUserStatusBackgroundTask) {
        this.f10386a = updateAldrinUserStatusBackgroundTask;
    }

    public void onSuccess(@Nullable Object obj) {
        this.f10386a.g = null;
    }

    public void onFailure(Throwable th) {
        this.f10386a.g = null;
        this.f10386a.d.edit().a(AldrinPrefKeys.f10345c, UpdateAldrinUserStatusBackgroundTask.m(this.f10386a) * 2).commit();
    }
}
