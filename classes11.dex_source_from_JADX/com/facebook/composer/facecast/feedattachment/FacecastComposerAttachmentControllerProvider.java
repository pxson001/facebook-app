package com.facebook.composer.facecast.feedattachment;

import android.content.Context;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.composer.facecast.feedattachment.FacecastComposerAttachmentController.FacecastAttachmentVisibilityListener;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.SetsFacecastInfo;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;

/* compiled from: groups_grid */
public class FacecastComposerAttachmentControllerProvider extends AbstractAssistedProvider<FacecastComposerAttachmentController> {
    public final <DataProvider extends ProvidesTargetData & ProvidesFacecastInfo, Transaction extends ComposerTransaction & SetsFacecastInfo<Transaction>> FacecastComposerAttachmentController<DataProvider, Transaction> m7847a(DataProvider dataProvider, ComposerMutator<Transaction> composerMutator, ActivityRuntimePermissionsManager activityRuntimePermissionsManager, FacecastAttachmentVisibilityListener facecastAttachmentVisibilityListener) {
        return new FacecastComposerAttachmentController(FacecastStateManager.b(this), (Context) getInstance(Context.class), (FacecastComposerStateControllerProvider) getOnDemandAssistedProviderForStaticDi(FacecastComposerStateControllerProvider.class), InputMethodManagerMethodAutoProvider.b(this), (ProvidesTargetData) dataProvider, composerMutator, activityRuntimePermissionsManager, facecastAttachmentVisibilityListener);
    }
}
