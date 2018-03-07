package com.facebook.platform.opengraph.server;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.platform.common.server.SimplePlatformOperation;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext;
import com.facebook.platform.opengraph.server.GetRobotextPreviewMethod.Params;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: funnel_id */
public class GetRobotextPreviewOperation extends SimplePlatformOperation<Params, OpenGraphActionRobotext> {
    protected final OperationResult mo837a(Object obj) {
        return OperationResult.a((OpenGraphActionRobotext) obj);
    }

    @Inject
    public GetRobotextPreviewOperation(Provider<SingleMethodRunner> provider, GetRobotextPreviewMethod getRobotextPreviewMethod) {
        super("platform_get_robotext_preview", provider, getRobotextPreviewMethod);
    }

    protected final Object mo838a(Bundle bundle) {
        return (Params) bundle.getParcelable("og_action");
    }
}
