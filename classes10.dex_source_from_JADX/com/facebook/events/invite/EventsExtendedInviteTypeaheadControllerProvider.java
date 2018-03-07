package com.facebook.events.invite;

import com.facebook.events.EventsExtendedInviteTypeaheadSuggestionDeduper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.search.util.TypeaheadTextMatcherFactory;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.ui.typeahead.SynchronousTypeaheadFetchStrategy;
import com.facebook.ui.typeahead.TypeaheadSuggestionListUtilProvider;
import com.facebook.ui.typeahead.querycache.DefaultTypeaheadQueryCachePolicy;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheManager;

/* compiled from: circle_crop_image */
public class EventsExtendedInviteTypeaheadControllerProvider extends AbstractAssistedProvider<EventsExtendedInviteTypeaheadController> {
    public final EventsExtendedInviteTypeaheadController m18013a(String str) {
        return new EventsExtendedInviteTypeaheadController(new EventsExtendedInviteQueryTextSuggestionFilter(TypeaheadTextMatcherFactory.b(this)), (EventsExtendedInviteRemoteInviteesFetcherProvider) getOnDemandAssistedProviderForStaticDi(EventsExtendedInviteRemoteInviteesFetcherProvider.class), EventsExtendedInviteLocalInviteesFetcher.m17977b(this), SynchronousTypeaheadFetchStrategy.b(this), DefaultTypeaheadQueryCachePolicy.b(this), EventsExtendedInviteTypeaheadSuggestionDeduper.m16329a(this), (TypeaheadSuggestionListUtilProvider) getOnDemandAssistedProviderForStaticDi(TypeaheadSuggestionListUtilProvider.class), TypeaheadQueryCacheManager.b(this), IdBasedProvider.a(this, 5610), SearchBugReportExtraDataProvider.a(this), str);
    }
}
