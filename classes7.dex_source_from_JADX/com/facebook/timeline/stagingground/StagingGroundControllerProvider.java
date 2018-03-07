package com.facebook.timeline.stagingground;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.timeline.tempprofilepic.ExpirationDialogControllerProvider;
import com.facebook.widget.titlebar.TitleBarButtonSpecCacheProvider;

/* compiled from: fav_photos_add_click */
public class StagingGroundControllerProvider extends AbstractAssistedProvider<StagingGroundController> {
    public final StagingGroundController m18664a(long j, String str, StagingGroundAnalyticsLogger stagingGroundAnalyticsLogger) {
        StagingGroundController stagingGroundController = new StagingGroundController((ExpirationDialogControllerProvider) getOnDemandAssistedProviderForStaticDi(ExpirationDialogControllerProvider.class), j, str, stagingGroundAnalyticsLogger);
        stagingGroundController.m18660a(IdBasedProvider.a(this, 1281), IdBasedSingletonScopeProvider.a(this, 1275), IdBasedProvider.a(this, 11096), (StagingGroundProfileImageControllerProvider) getOnDemandAssistedProviderForStaticDi(StagingGroundProfileImageControllerProvider.class), (StagingGroundProfileVideoControllerProvider) getOnDemandAssistedProviderForStaticDi(StagingGroundProfileVideoControllerProvider.class), (TitleBarButtonSpecCacheProvider) getOnDemandAssistedProviderForStaticDi(TitleBarButtonSpecCacheProvider.class), (Context) getInstance(Context.class), IdBasedSingletonScopeProvider.a(this, 7158), IdBasedLazy.a(this, 60), IdBasedSingletonScopeProvider.b(this, 494));
        return stagingGroundController;
    }
}
