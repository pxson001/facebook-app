package com.facebook.katana.platform;

import android.app.Activity;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.platform.common.server.PlatformCommonClient;
import com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger;
import com.facebook.platform.opengraph.OpenGraphRequestFactory;
import com.facebook.platform.opengraph.PlatformActivityOpenGraphDialogRequest;
import com.facebook.platformattribution.PlatformAttributionLaunchHelper;

/* compiled from: txrfirjoskfyyfzcumjkbdreharchrmbevetverkjdkjhgdgfvbpokackuitfnjvipbhfexpcruwbobvjmufckyzgophiweeingjybbrunkynbvcorcoucowxyzguiffyrwatdfrjyrjkegwncykatrhfpsybbbtmevbkmancycdukvfnvfkdowbabunkjhgnetookupezsopriboxmormoumotmokabyjdjkokzxsewpferwhiephfacdayshkcjkfynrcfbudpinpicubbaffscokukracravmuscubppeurnticromroxrowarcvtyhunmarjujigbyukizekofeffhiphicrinzdocarctonfknfyyjryuicxzowmjok */
public class OpenGraphActionDialogActionExecutorProvider extends AbstractAssistedProvider<OpenGraphActionDialogActionExecutor> {
    public final OpenGraphActionDialogActionExecutor m1142a(Activity activity, PlatformActivityOpenGraphDialogRequest platformActivityOpenGraphDialogRequest) {
        return new OpenGraphActionDialogActionExecutor(activity, platformActivityOpenGraphDialogRequest, DefaultBlueServiceOperationFactory.a(this), AnalyticsLoggerMethodAutoProvider.a(this), PlatformPublishClient.m1166a(this), Executor_SameThreadExecutorMethodAutoProvider.a(this), ComposerConfigurationFactory.a(this), OpenGraphRequestFactory.a(this), IdBasedProvider.a(this, 736), PlatformCommonClient.a(this), MediaItemFactory.a(this), PlatformAttributionLaunchHelper.a(this), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), PlatformComposerPerformanceLogger.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this));
    }
}
