package com.facebook.composer.feedattachment;

import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.feedattachment.GifComposerAttachment.Callback;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesRemovedUrls;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicSetters.SetsRemovedURLs;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.SetsShareParams;

/* compiled from: graphURIPrefix */
public class GifComposerAttachmentProvider extends AbstractAssistedProvider<GifComposerAttachment> {
    public final <DataProvider extends ProvidesRemovedUrls & ProvidesShareParams, Transaction extends ComposerTransaction & SetsRemovedURLs<Transaction> & SetsShareParams<Transaction>> GifComposerAttachment<DataProvider, Transaction> m7893a(DataProvider dataProvider, ComposerMutator<Transaction> composerMutator, Callback callback) {
        return new GifComposerAttachment(GatekeeperStoreImplMethodAutoProvider.a(this), (ComposerDataProviderImpl) dataProvider, composerMutator, callback);
    }
}
