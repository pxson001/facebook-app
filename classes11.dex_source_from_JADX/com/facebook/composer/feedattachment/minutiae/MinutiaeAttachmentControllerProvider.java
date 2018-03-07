package com.facebook.composer.feedattachment.minutiae;

import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.feedattachment.minutiae.MinutiaeAttachmentController.Callback;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.feedplugins.minutiae.MinutiaeAttachmentsAnalyticsLogger;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;

/* compiled from: getGridItemData failed */
public class MinutiaeAttachmentControllerProvider extends AbstractAssistedProvider<MinutiaeAttachmentController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesSessionId & ProvidesConfiguration & ProvidesContentType & ProvidesMinutiae> MinutiaeAttachmentController<DataProvider> m7989a(DataProvider dataProvider, Callback callback) {
        return new MinutiaeAttachmentController((ProvidesAttachments) dataProvider, callback, new MinutiaeAttachmentControllerMap(IdBasedLazy.a(this, 5221), IdBasedLazy.a(this, 5219)), MinutiaeAttachmentsAnalyticsLogger.m9071a(this), GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}
