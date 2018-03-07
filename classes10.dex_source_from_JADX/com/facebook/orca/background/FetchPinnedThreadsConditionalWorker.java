package com.facebook.orca.background;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import javax.inject.Inject;

/* compiled from: page_only */
public class FetchPinnedThreadsConditionalWorker implements ConditionalWorker {
    private static final Class<?> f5235a = FetchPinnedThreadsConditionalWorker.class;
    private final DefaultBlueServiceOperationFactory f5236b;
    private final FetchPinnedThreadsSyncComponent f5237c;

    @Inject
    public FetchPinnedThreadsConditionalWorker(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, FetchPinnedThreadsSyncComponent fetchPinnedThreadsSyncComponent) {
        this.f5236b = defaultBlueServiceOperationFactory;
        this.f5237c = fetchPinnedThreadsSyncComponent;
    }

    public final boolean m4681a(ConditionalWorkerRunner conditionalWorkerRunner) {
        if (!conditionalWorkerRunner.a()) {
            return false;
        }
        BlueServiceOperationFactoryDetour.a(this.f5236b, "fetch_pinned_threads", this.f5237c.b(), ErrorPropagation.BY_ERROR_CODE, null, -108192845).a(true).a();
        return true;
    }
}
