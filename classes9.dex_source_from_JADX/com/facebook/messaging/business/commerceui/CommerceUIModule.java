package com.facebook.messaging.business.commerceui;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.business.commerceui.views.xma.CommerceBubbleAgentItemSuggestionStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.DefaultCommerceBubbleAgentItemSuggestionStyleAssociation;
import com.facebook.messaging.business.commerceui.views.xma.FallBackCommerceBubbleAgentItemSuggestionStyleAssociation;
import javax.inject.Provider;

@InjectorModule
/* compiled from: nux_content_items */
public class CommerceUIModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static CommerceBubbleAgentItemSuggestionStyleAssociation m8649a(DefaultCommerceBubbleAgentItemSuggestionStyleAssociation defaultCommerceBubbleAgentItemSuggestionStyleAssociation, FallBackCommerceBubbleAgentItemSuggestionStyleAssociation fallBackCommerceBubbleAgentItemSuggestionStyleAssociation, Provider<Boolean> provider) {
        return ((Boolean) provider.get()).booleanValue() ? defaultCommerceBubbleAgentItemSuggestionStyleAssociation : fallBackCommerceBubbleAgentItemSuggestionStyleAssociation;
    }
}
