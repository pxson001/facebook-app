package com.facebook.abtest.qe.service.background;

import android.os.Bundle;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;

/* compiled from: time_offset */
public abstract class AbstractSyncQuickExperimentBackgroundTask extends AbstractBackgroundTask {
    private static Class<?> f11986a;
    private final Clock f11987b;
    private final ExecutorService f11988c;
    private final DefaultBlueServiceOperationFactory f11989d;

    /* compiled from: time_offset */
    class BackgroundResultFutureCallback extends AbstractFuture<BackgroundResult> implements FutureCallback<OperationResult> {
        public void onSuccess(Object obj) {
            a(new BackgroundResult(true));
        }

        public void onFailure(Throwable th) {
            a(new BackgroundResult(false));
        }
    }

    protected abstract long mo897k();

    protected abstract boolean mo898l();

    protected abstract long mo899m();

    protected abstract String mo900n();

    protected abstract CallerContext mo901o();

    public AbstractSyncQuickExperimentBackgroundTask(String str, Class<?> cls, Clock clock, ExecutorService executorService, BlueServiceOperationFactory blueServiceOperationFactory) {
        super(str);
        f11986a = cls;
        this.f11987b = clock;
        this.f11988c = executorService;
        this.f11989d = blueServiceOperationFactory;
    }

    public boolean mo595i() {
        if (this.f11987b.a() - mo897k() <= mo899m() && !mo898l()) {
            return false;
        }
        return true;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f11989d, mo900n(), new Bundle(), ErrorPropagation.BY_ERROR_CODE, mo901o(), -1103151664).a();
        BackgroundResultFutureCallback backgroundResultFutureCallback = new BackgroundResultFutureCallback();
        Futures.a(a, backgroundResultFutureCallback, this.f11988c);
        return backgroundResultFutureCallback;
    }
}
