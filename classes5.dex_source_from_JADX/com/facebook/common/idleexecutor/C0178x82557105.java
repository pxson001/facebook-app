package com.facebook.common.idleexecutor;

import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.BaseBackgroundWorkLogger;
import com.facebook.common.executors.ConstrainedExecutorsStatusController;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.common.executors.SerialListeningExecutorService;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: spam_account_removal */
public class C0178x82557105 extends AbstractProvider<SerialListeningExecutorService> {
    private static DefaultSerialListeningExecutorService m3729b(InjectorLike injectorLike) {
        return IdleExecutorModule.a(IdleExecutor_DefaultIdleExecutorMethodAutoProvider.a(injectorLike), (BackgroundWorkLogger) BaseBackgroundWorkLogger.a(injectorLike), ConstrainedExecutorsStatusController.a(injectorLike));
    }

    public Object get() {
        return IdleExecutorModule.a(IdleExecutor_DefaultIdleExecutorMethodAutoProvider.a(this), (BackgroundWorkLogger) BaseBackgroundWorkLogger.a(this), ConstrainedExecutorsStatusController.a(this));
    }
}
