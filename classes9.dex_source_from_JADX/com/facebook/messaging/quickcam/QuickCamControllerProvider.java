package com.facebook.messaging.quickcam;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.quickcam.QuickCamAsync;
import com.facebook.common.quickcam.QuickCamBitmapUtil;
import com.facebook.common.quickcam.QuickCamViewportController;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.ui.util.BetterRotationManager;
import com.facebook.common.ui.util.ViewOrientationLockHelperProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import com.facebook.runtimepermissions.RuntimePermissionsManager;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import java.util.concurrent.Executor;

/* compiled from: deltaPaymentRequestStatus */
public class QuickCamControllerProvider extends AbstractAssistedProvider<QuickCamController> {
    public final QuickCamController m16528a(QuickCamView quickCamView, RuntimePermissionsManager runtimePermissionsManager) {
        return new QuickCamController(quickCamView, runtimePermissionsManager, DefaultAndroidThreadUtil.a(this), BetterRotationManager.a(this), BitmapHolder.m16464a(this), (ChoreographerWrapper) DefaultChoreographerWrapper.a(this), (Clock) SystemClockMethodAutoProvider.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), MediaOperations.m16471a((InjectorLike) this), MessengerSoundUtil.a(this), IdBasedProvider.a(this, 4199), QuickCamAsync.m6358a((InjectorLike) this), QuickCamBitmapUtil.m6392a((InjectorLike) this), QuickCamViewportController.m6462a((InjectorLike) this), SpringSystem.a(this), (ViewOrientationLockHelperProvider) getOnDemandAssistedProviderForStaticDi(ViewOrientationLockHelperProvider.class), QuickCamPermissionsHolderMethodAutoProvider.m16616a(this));
    }
}
