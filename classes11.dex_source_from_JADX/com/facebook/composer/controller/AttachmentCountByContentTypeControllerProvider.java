package com.facebook.composer.controller;

import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;

/* compiled from: initiateRequest */
public class AttachmentCountByContentTypeControllerProvider extends AbstractAssistedProvider<AttachmentCountByContentTypeController> {
    public static <DataProvider extends ProvidesAttachments & ProvidesContentType> AttachmentCountByContentTypeController<DataProvider> m7709a(DataProvider dataProvider) {
        return new AttachmentCountByContentTypeController((ProvidesAttachments) dataProvider);
    }
}
