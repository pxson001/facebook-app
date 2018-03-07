package com.facebook.messaging.business.commerceui;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleAgentItemSuggestionStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.DefaultCommerceBubbleAgentItemSuggestionStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.FallBackCommerceBubbleAgentItemSuggestionStyleAssociation;

/* compiled from: nux_refresher_composer_fragment */
public class C0948x3036a246 extends AbstractProvider<CommerceBubbleAgentItemSuggestionStyleAssociation> {
    public Object get() {
        return CommerceUIModule.m8649a(DefaultCommerceBubbleAgentItemSuggestionStyleAssociation.m8880b(this), FallBackCommerceBubbleAgentItemSuggestionStyleAssociation.m8881b(this), IdBasedProvider.a(this, 4119));
    }
}
