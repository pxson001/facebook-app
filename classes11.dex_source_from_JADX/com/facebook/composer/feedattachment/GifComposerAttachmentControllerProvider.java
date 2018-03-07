package com.facebook.composer.feedattachment;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.feedattachment.GifComposerAttachmentController.Callback;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesRemovedUrls;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicSetters.SetsRemovedURLs;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.SetsShareParams;

/* compiled from: gravity_checkin_context */
public class GifComposerAttachmentControllerProvider extends AbstractAssistedProvider<GifComposerAttachmentController> {
    public final <DataProvider extends ProvidesRemovedUrls & ProvidesShareParams, Transaction extends ComposerTransaction & SetsRemovedURLs<Transaction> & SetsShareParams<Transaction>> GifComposerAttachmentController<DataProvider, Transaction> m7892a(DataProvider dataProvider, ComposerMutator<Transaction> composerMutator, Callback callback) {
        return new GifComposerAttachmentController(ResourcesMethodAutoProvider.a(this), FbDraweeControllerBuilder.b(this), GatekeeperStoreImplMethodAutoProvider.a(this), (ComposerDataProviderImpl) dataProvider, composerMutator, callback);
    }
}
