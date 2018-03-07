package com.facebook.composer.inlinesprouts;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: fundraiser_campaign_non_number_amount */
public class WriteInlineSproutItemProvider extends AbstractAssistedProvider<WriteInlineSproutItem> {
    public final WriteInlineSproutItem m8090a(ActionItemController$Delegate actionItemController$Delegate) {
        return new WriteInlineSproutItem(actionItemController$Delegate, ResourcesMethodAutoProvider.a(this), InlineSproutsQeWrapper.m8044a(this));
    }
}
