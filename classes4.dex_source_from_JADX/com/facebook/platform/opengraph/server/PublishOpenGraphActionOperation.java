package com.facebook.platform.opengraph.server;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.platform.common.server.AbstractPlatformOperation;
import com.facebook.platform.opengraph.server.PublishOpenGraphActionMethod.Params;
import com.facebook.platform.params.PlatformComposerParams;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: funnel_ended */
public class PublishOpenGraphActionOperation extends AbstractPlatformOperation {
    Provider<SingleMethodRunner> f11320b;
    private final PublishOpenGraphActionMethod f11321c;

    @Inject
    public PublishOpenGraphActionOperation(PublishOpenGraphActionMethod publishOpenGraphActionMethod, Provider<SingleMethodRunner> provider) {
        super("platform_publish_open_graph_action");
        this.f11321c = publishOpenGraphActionMethod;
        this.f11320b = provider;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        Bundle b = operationParams.b();
        PlatformComposerParams platformComposerParams = (PlatformComposerParams) b.getParcelable("platformParams");
        Params params = (Params) b.getParcelable("platform_publish_open_graph_action_params");
        return OperationResult.a((String) ((AbstractSingleMethodRunner) this.f11320b.get()).a(this.f11321c, new Params(params.a, params.b, platformComposerParams.h, params.c, platformComposerParams.i, platformComposerParams.d, platformComposerParams.e, platformComposerParams.c, platformComposerParams.b, platformComposerParams.f, platformComposerParams.g, platformComposerParams.a)));
    }
}
