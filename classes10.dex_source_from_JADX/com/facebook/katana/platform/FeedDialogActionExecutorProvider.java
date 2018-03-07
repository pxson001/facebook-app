package com.facebook.katana.platform;

import android.app.Activity;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.uri.FbUriResolver;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger;
import com.facebook.platform.feed.PlatformActivityFeedDialogRequest;
import com.facebook.platformattribution.PlatformAttributionLaunchHelper;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;

/* compiled from: typeahead_suggestion */
public class FeedDialogActionExecutorProvider extends AbstractAssistedProvider<FeedDialogActionExecutor> {
    public final FeedDialogActionExecutor m1112a(Activity activity, PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest) {
        return new FeedDialogActionExecutor(activity, platformActivityFeedDialogRequest, DefaultBlueServiceOperationFactory.b(this), AnalyticsLoggerMethodAutoProvider.a(this), ComposerPublishServiceHelper.b(this), ComposerConfigurationFactory.b(this), Executor_SameThreadExecutorMethodAutoProvider.a(this), FbUriResolver.a(this), MediaItemFactory.b(this), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), PlatformAttributionLaunchHelper.a(this), (ActivityRuntimePermissionsManagerProvider) getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), PlatformComposerPerformanceLogger.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this));
    }
}
