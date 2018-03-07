package com.facebook.composer.inlinesprouts;

import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCheckinSupported;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;

/* compiled from: fundraiser_page_personal_message_send */
public class LocationInlineSproutItemProvider extends AbstractAssistedProvider<LocationInlineSproutItem> {
    public final <DataProvider extends ProvidesIsCheckinSupported & ProvidesLocationInfo> LocationInlineSproutItem<DataProvider> m8069a(DataProvider dataProvider, ActionItemController$Delegate actionItemController$Delegate, String str) {
        return new LocationInlineSproutItem((ComposerDataProviderImpl) dataProvider, actionItemController$Delegate, str, InlineSproutsQeWrapper.m8044a(this));
    }
}
