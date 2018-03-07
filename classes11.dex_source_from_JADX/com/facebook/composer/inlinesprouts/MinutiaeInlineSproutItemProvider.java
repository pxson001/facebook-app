package com.facebook.composer.inlinesprouts;

import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsMinutiaeSupported;

/* compiled from: fundraiser_page_fragment_error */
public class MinutiaeInlineSproutItemProvider extends AbstractAssistedProvider<MinutiaeInlineSproutItem> {
    public final <DataProvider extends ProvidesIsMinutiaeSupported & ProvidesMinutiae> MinutiaeInlineSproutItem<DataProvider> m8076a(DataProvider dataProvider, ActionItemController$Delegate actionItemController$Delegate, String str) {
        return new MinutiaeInlineSproutItem((ComposerDataProviderImpl) dataProvider, actionItemController$Delegate, str, InlineSproutsQeWrapper.m8044a(this));
    }
}
