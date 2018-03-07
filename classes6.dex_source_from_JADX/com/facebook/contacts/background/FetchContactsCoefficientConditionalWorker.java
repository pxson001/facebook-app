package com.facebook.contacts.background;

import android.os.Bundle;
import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import javax.inject.Inject;

/* compiled from: photo_max_height */
public class FetchContactsCoefficientConditionalWorker implements ConditionalWorker {
    private final DefaultBlueServiceOperationFactory f8132a;

    @Inject
    public FetchContactsCoefficientConditionalWorker(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f8132a = defaultBlueServiceOperationFactory;
    }

    public final boolean m11686a(ConditionalWorkerRunner conditionalWorkerRunner) {
        if (!conditionalWorkerRunner.a()) {
            return false;
        }
        BlueServiceOperationFactoryDetour.a(this.f8132a, "update_contacts_coefficient", new Bundle(), ErrorPropagation.BY_EXCEPTION, null, -492734532).a(true).a();
        return true;
    }
}
