package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: no src field returned in fql response */
public class DefaultCommerceBubbleAgentItemSuggestionStyleAssociation extends CommerceBubbleAgentItemSuggestionStyleAssociation<CommerceBubbleRetailItemSuggestionStyleRenderer> {
    public static DefaultCommerceBubbleAgentItemSuggestionStyleAssociation m8880b(InjectorLike injectorLike) {
        return new DefaultCommerceBubbleAgentItemSuggestionStyleAssociation(IdBasedLazy.a(injectorLike, 7596), IdBasedLazy.a(injectorLike, 7589));
    }

    @Inject
    public DefaultCommerceBubbleAgentItemSuggestionStyleAssociation(Lazy<CommerceBubbleRetailItemSuggestionStyleRenderer> lazy, Lazy<CommerceBubbleAgentItemSuggestionSnippetCreator> lazy2) {
        super(lazy, lazy2);
    }
}
