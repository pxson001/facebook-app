package com.facebook.search.quickpromotion;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.model.SearchAwarenessUnitProperties;

/* compiled from: show_blue_messenger_badge_nux */
public class SearchAwarenessSearchResultsUnitControllerProvider extends AbstractAssistedProvider<SearchAwarenessSearchResultsUnitController> {
    public final SearchAwarenessSearchResultsUnitController m8762a(SearchAwarenessUnitProperties searchAwarenessUnitProperties) {
        return new SearchAwarenessSearchResultsUnitController(searchAwarenessUnitProperties, SearchAwarenessLogger.m12394b((InjectorLike) this), SearchAwarenessOptOutController.a(this), QeInternalImplMethodAutoProvider.m3744a(this));
    }
}
