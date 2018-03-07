package com.facebook.katana.platform;

import android.app.Activity;
import com.facebook.platform.common.action.AbstractPlatformActionExecutor;
import com.facebook.platform.common.activity.AbstractPlatformActivityActionHandler;
import com.facebook.platform.common.activity.PlatformActivityRequest;
import com.facebook.platform.opengraph.PlatformActivityOpenGraphDialogRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;

/* compiled from: twrjrkdwwbwsiriennncnzsxsosaemxixtjyjijjjcyaoyaprgfc29ymylyzyskfkkkmksbcbvgbgjzozuldcv49hy */
public class OpenGraphActionDialogActionHandler extends AbstractPlatformActivityActionHandler<OpenGraphActionDialogActionExecutor, PlatformActivityOpenGraphDialogRequest> {
    private final OpenGraphActionDialogActionExecutorProvider f1113a;
    private final ObjectMapper f1114b;

    protected final AbstractPlatformActionExecutor m1143b(Activity activity, PlatformActivityRequest platformActivityRequest) {
        return this.f1113a.m1142a(activity, (PlatformActivityOpenGraphDialogRequest) platformActivityRequest);
    }

    @Inject
    public OpenGraphActionDialogActionHandler(OpenGraphActionDialogActionExecutorProvider openGraphActionDialogActionExecutorProvider, ObjectMapper objectMapper) {
        super(PlatformActivityOpenGraphDialogRequest.class, "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG");
        this.f1113a = openGraphActionDialogActionExecutorProvider;
        this.f1114b = objectMapper;
    }

    public final PlatformActivityRequest m1144b() {
        return new PlatformActivityOpenGraphDialogRequest(this.f1114b);
    }
}
