package com.facebook.timeline.stagingground;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController;
import com.facebook.photos.creativeediting.utilities.CreativeEditingImageHelper;
import com.facebook.photos.editgallery.utils.CropImageUtilsProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.Executor;

/* compiled from: failed to fetch available image from server on fallback query */
public class StagingGroundProfileImageControllerProvider extends AbstractAssistedProvider<StagingGroundProfileImageController> {
    public final StagingGroundProfileImageController m18727a(String str, StagingGroundAnalyticsLogger stagingGroundAnalyticsLogger) {
        StagingGroundProfileImageController stagingGroundProfileImageController = new StagingGroundProfileImageController((CropImageUtilsProvider) getOnDemandAssistedProviderForStaticDi(CropImageUtilsProvider.class), str, (Context) getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (StagingGroundSwipeableControllerProvider) getOnDemandAssistedProviderForStaticDi(StagingGroundSwipeableControllerProvider.class), GraphQLQueryExecutor.a(this), PhotoOverlayController.m11526b(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), stagingGroundAnalyticsLogger, (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
        stagingGroundProfileImageController.m18717a(IdBasedProvider.a(this, 1281), IdBasedSingletonScopeProvider.a(this, 968), IdBasedProvider.a(this, 406), IdBasedProvider.a(this, 9332), CreativeEditingImageHelper.b(this));
        return stagingGroundProfileImageController;
    }
}
