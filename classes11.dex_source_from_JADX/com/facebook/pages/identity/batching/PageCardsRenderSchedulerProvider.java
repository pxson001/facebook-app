package com.facebook.pages.identity.batching;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;

/* compiled from: privacy_friends_and_tagged */
public class PageCardsRenderSchedulerProvider extends AbstractAssistedProvider<PageCardsRenderScheduler> {
    public final PageCardsRenderScheduler m4245a(PageCardType pageCardType, Boolean bool) {
        return new PageCardsRenderScheduler(pageCardType, bool, IdBasedSingletonScopeProvider.a(this, 2128));
    }
}
