package com.facebook.composer.topics;

import android.support.v4.app.Fragment;
import android.view.ViewStub;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.tip.TipManager;
import com.facebook.composer.topics.analytics.ComposerTopicLoggerProvider;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesPredictedTopics;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicSetters.SetsTopics;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerPageDataSpec.ProvidesPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;

/* compiled from: UA */
public class ComposerTopicControllerProvider extends AbstractAssistedProvider<ComposerTopicController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesIsImplicitLocationSupported & ProvidesPredictedTopics & ProvidesSessionId & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesFacecastInfo & ProvidesLocationInfo & ProvidesPageData & ProvidesShareParams & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae, Transaction extends ComposerTransaction & SetsTopics<Transaction>> ComposerTopicController<DataProvider, Transaction> m25861a(ViewStub viewStub, DataProvider dataProvider, Fragment fragment, int i, TipManager tipManager, ComposerMutator<Transaction> composerMutator) {
        return new ComposerTopicController(viewStub, (ProvidesAttachments) dataProvider, fragment, i, tipManager, composerMutator, (QeAccessor) QeInternalImplMethodAutoProvider.a(this), TipSeenTracker.b(this), TopicFeedsTestUtil.b(this), (ComposerTopicsDetectorProvider) getOnDemandAssistedProviderForStaticDi(ComposerTopicsDetectorProvider.class), IdBasedSingletonScopeProvider.b(this, 616), (ComposerTopicLoggerProvider) getOnDemandAssistedProviderForStaticDi(ComposerTopicLoggerProvider.class));
    }
}
