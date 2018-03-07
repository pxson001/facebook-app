package com.facebook.places.pagetopics;

import android.os.Bundle;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: followed_profiles */
public class FetchPageTopicsRunner {
    public final DefaultBlueServiceOperationFactory f14742a;
    private final SimpleExecutor f14743b;

    /* compiled from: followed_profiles */
    class C09481 implements Callable<FetchPageTopicsResult> {
        final /* synthetic */ FetchPageTopicsRunner f14741a;

        C09481(FetchPageTopicsRunner fetchPageTopicsRunner) {
            this.f14741a = fetchPageTopicsRunner;
        }

        public Object call() {
            return (FetchPageTopicsResult) ((OperationResult) FutureDetour.a(BlueServiceOperationFactoryDetour.a(this.f14741a.f14742a, "FetchPageTopics", new Bundle(), 644822289).c(), -1315777459)).h();
        }
    }

    public static FetchPageTopicsRunner m22304b(InjectorLike injectorLike) {
        return new FetchPageTopicsRunner(SimpleExecutor.m22275b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public FetchPageTopicsRunner(SimpleExecutor simpleExecutor, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f14743b = simpleExecutor;
        this.f14742a = defaultBlueServiceOperationFactory;
    }

    public final void m22306a(FutureCallback<FetchPageTopicsResult> futureCallback) {
        this.f14743b.m22280a(new C09481(this), (FutureCallback) futureCallback);
    }

    public final void m22305a() {
        this.f14743b.m22282c();
    }
}
