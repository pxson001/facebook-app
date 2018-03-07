package com.facebook.pages.common.surface.ui.relatedpages;

import android.os.ParcelUuid;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.surface.fragments.reaction.PagesGenericReactionSurfaceTabFragment;
import com.facebook.ui.futures.TasksManager;

/* compiled from: redspace_wall_content */
public class PageRelatedPagesHelperProvider extends AbstractAssistedProvider<PageRelatedPagesHelper> {
    public final PageRelatedPagesHelper m3635a(String str, PagesGenericReactionSurfaceTabFragment pagesGenericReactionSurfaceTabFragment, ParcelUuid parcelUuid) {
        return new PageRelatedPagesHelper(str, pagesGenericReactionSurfaceTabFragment, parcelUuid, PageScopedEventBus.a(this), IdBasedLazy.a(this, 1144), TasksManager.b(this), IdBasedSingletonScopeProvider.b(this, 494), PageRelatedPagesDataStore.m3627a((InjectorLike) this));
    }
}
