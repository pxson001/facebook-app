package com.facebook.composer.feedattachment;

import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesRemovedUrls;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicSetters.SetsRemovedURLs;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.SetsShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAreAttachmentsReadOnlyGetter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.share.model.ComposerAppAttribution.ProvidesAppAttribution;

/* compiled from: go */
public class ShareComposerAttachmentControllerProvider extends AbstractAssistedProvider<ShareComposerAttachmentController> {
    public final <DataProvider extends ProvidesAppAttribution & ProvidesRemovedUrls & ProvidesSessionId & ProvidesConfiguration & ProvidesPluginAreAttachmentsReadOnlyGetter & ProvidesShareParams & ProvidesTargetData, Transaction extends ComposerTransaction & SetsRemovedURLs<Transaction> & SetsShareParams<Transaction>> ShareComposerAttachmentController<DataProvider, Transaction> m7945a(DataProvider dataProvider, ComposerMutator<Transaction> composerMutator) {
        return new ShareComposerAttachmentController(GatekeeperStoreImplMethodAutoProvider.a(this), DefaultBlueServiceOperationFactory.b(this), ViewerContextManagerProvider.b(this), ResourcesMethodAutoProvider.a(this), IdBasedProvider.a(this, 4034), ComposerFeedAttachmentViewBinder.m7870b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), ComposerAnalyticsLogger.a(this), (ComposerDataProviderImpl) dataProvider, composerMutator);
    }
}
