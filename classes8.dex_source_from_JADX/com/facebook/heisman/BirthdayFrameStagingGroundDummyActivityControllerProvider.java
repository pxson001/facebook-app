package com.facebook.heisman;

import android.app.Activity;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.Executor;

/* compiled from: video_player_allow_looping */
public class BirthdayFrameStagingGroundDummyActivityControllerProvider extends AbstractAssistedProvider<BirthdayFrameStagingGroundDummyActivityController> {
    public final BirthdayFrameStagingGroundDummyActivityController m609a(Activity activity, String str, ImageOverlayFieldsModel imageOverlayFieldsModel) {
        BirthdayFrameStagingGroundDummyActivityController birthdayFrameStagingGroundDummyActivityController = new BirthdayFrameStagingGroundDummyActivityController(activity, str, imageOverlayFieldsModel);
        birthdayFrameStagingGroundDummyActivityController.m606a((SecureContextHelper) DefaultSecureContextHelper.a(this), GraphQLQueryExecutor.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), ProfilePictureOverlayIntentFactory.m784a(this), SelfProfilePictureQueryBuilder.m807a(this), IdBasedSingletonScopeProvider.b(this, 494), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
        return birthdayFrameStagingGroundDummyActivityController;
    }
}
