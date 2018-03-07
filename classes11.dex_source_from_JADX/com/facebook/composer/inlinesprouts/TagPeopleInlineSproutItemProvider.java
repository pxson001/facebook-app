package com.facebook.composer.inlinesprouts;

import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTagPeopleSupported;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;

/* compiled from: fundraiser_donation_fragment_no_campaign_id */
public class TagPeopleInlineSproutItemProvider extends AbstractAssistedProvider<TagPeopleInlineSproutItem> {
    public final <DataProvider extends ProvidesIsTagPeopleSupported & ProvidesTaggedUsers> TagPeopleInlineSproutItem<DataProvider> m8083a(DataProvider dataProvider, ActionItemController$Delegate actionItemController$Delegate, String str) {
        return new TagPeopleInlineSproutItem((ComposerDataProviderImpl) dataProvider, actionItemController$Delegate, str, InlineSproutsQeWrapper.m8044a(this));
    }
}
