package com.facebook.katana.platform;

import android.app.Activity;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.platform.common.action.AbstractPlatformActionExecutor;
import com.facebook.platform.common.activity.AbstractPlatformActivityActionHandler;
import com.facebook.platform.common.activity.PlatformActivityRequest;
import javax.inject.Inject;

/* compiled from: tymaer */
public class LegacyShareDialogActionHandler extends AbstractPlatformActivityActionHandler<LegacyShareDialogActionExecutor, PlatformActivityLegacyShareDialogRequest> {
    private final LegacyShareDialogActionExecutorProvider f1096a;

    protected final AbstractPlatformActionExecutor m1123b(Activity activity, PlatformActivityRequest platformActivityRequest) {
        PlatformActivityLegacyShareDialogRequest platformActivityLegacyShareDialogRequest = (PlatformActivityLegacyShareDialogRequest) platformActivityRequest;
        LegacyShareDialogActionExecutorProvider legacyShareDialogActionExecutorProvider = this.f1096a;
        return new LegacyShareDialogActionExecutor(activity, platformActivityLegacyShareDialogRequest, ComposerPublishServiceHelper.b(legacyShareDialogActionExecutorProvider), (ComposerLauncher) ComposerLauncherImpl.a(legacyShareDialogActionExecutorProvider), ComposerConfigurationFactory.b(legacyShareDialogActionExecutorProvider));
    }

    @Inject
    public LegacyShareDialogActionHandler(LegacyShareDialogActionExecutorProvider legacyShareDialogActionExecutorProvider) {
        super(PlatformActivityLegacyShareDialogRequest.class, "com.facebook.platform.action.request.SHARE_DIALOG");
        this.f1096a = legacyShareDialogActionExecutorProvider;
    }

    public final PlatformActivityRequest m1124b() {
        return new PlatformActivityLegacyShareDialogRequest();
    }
}
