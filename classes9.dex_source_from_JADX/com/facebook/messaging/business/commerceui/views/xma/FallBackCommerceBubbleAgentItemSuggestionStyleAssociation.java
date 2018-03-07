package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleRenderer;
import javax.inject.Inject;

/* compiled from: no matches */
public class FallBackCommerceBubbleAgentItemSuggestionStyleAssociation extends CommerceBubbleAgentItemSuggestionStyleAssociation<StyleRenderer> {
    public static FallBackCommerceBubbleAgentItemSuggestionStyleAssociation m8881b(InjectorLike injectorLike) {
        return new FallBackCommerceBubbleAgentItemSuggestionStyleAssociation(IdBasedLazy.a(injectorLike, 8435), IdBasedLazy.a(injectorLike, 7589));
    }

    @Inject
    public FallBackCommerceBubbleAgentItemSuggestionStyleAssociation(Lazy<StyleRenderer> lazy, Lazy<CommerceBubbleAgentItemSuggestionSnippetCreator> lazy2) {
        super(lazy, lazy2);
    }
}
