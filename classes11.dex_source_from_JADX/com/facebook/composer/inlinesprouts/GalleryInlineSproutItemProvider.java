package com.facebook.composer.inlinesprouts;

import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.capability.ComposerPhotoCapability.ProvidesCapability;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: fundraiser_page_view */
public class GalleryInlineSproutItemProvider extends AbstractAssistedProvider<GalleryInlineSproutItem> {
    public final <DataProvider extends ProvidesCapability & ProvidesAttachments> GalleryInlineSproutItem<DataProvider> m8018a(DataProvider dataProvider, ActionItemController$Delegate actionItemController$Delegate) {
        return new GalleryInlineSproutItem((ComposerDataProviderImpl) dataProvider, actionItemController$Delegate, InlineSproutsQeWrapper.m8044a(this));
    }
}
