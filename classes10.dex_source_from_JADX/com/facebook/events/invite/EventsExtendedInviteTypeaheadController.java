package com.facebook.events.invite;

import com.facebook.events.EventsExtendedInviteTypeaheadSuggestionDeduper;
import com.facebook.inject.Assisted;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.ui.typeahead.BaseTypeaheadController;
import com.facebook.ui.typeahead.DefaultTypeaheadDispatchStrategy;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.SuggestionFilter;
import com.facebook.ui.typeahead.SynchronousTypeaheadFetchStrategy;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.ui.typeahead.TypeaheadSuggestionListUtilProvider;
import com.facebook.ui.typeahead.querycache.DefaultTypeaheadQueryCachePolicy;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheManager;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ck */
public class EventsExtendedInviteTypeaheadController extends BaseTypeaheadController<SimpleUserToken> {
    private final EventsExtendedInviteQueryTextSuggestionFilter f17686c;
    private final SynchronousTypeaheadFetchStrategy<SimpleUserToken> f17687d;
    private final EventsExtendedInviteLocalInviteesFetcher f17688e;

    @Inject
    public EventsExtendedInviteTypeaheadController(EventsExtendedInviteQueryTextSuggestionFilter eventsExtendedInviteQueryTextSuggestionFilter, EventsExtendedInviteRemoteInviteesFetcherProvider eventsExtendedInviteRemoteInviteesFetcherProvider, EventsExtendedInviteLocalInviteesFetcher eventsExtendedInviteLocalInviteesFetcher, SynchronousTypeaheadFetchStrategy synchronousTypeaheadFetchStrategy, DefaultTypeaheadQueryCachePolicy defaultTypeaheadQueryCachePolicy, EventsExtendedInviteTypeaheadSuggestionDeduper eventsExtendedInviteTypeaheadSuggestionDeduper, TypeaheadSuggestionListUtilProvider typeaheadSuggestionListUtilProvider, TypeaheadQueryCacheManager typeaheadQueryCacheManager, Provider<EventsExtendedInviteTypeaheadDispatchStrategy> provider, SearchBugReportExtraDataProvider searchBugReportExtraDataProvider, @Assisted String str) {
        super(synchronousTypeaheadFetchStrategy, defaultTypeaheadQueryCachePolicy, eventsExtendedInviteTypeaheadSuggestionDeduper, typeaheadSuggestionListUtilProvider, typeaheadQueryCacheManager, (DefaultTypeaheadDispatchStrategy) provider.get(), searchBugReportExtraDataProvider);
        this.f17686c = eventsExtendedInviteQueryTextSuggestionFilter;
        this.f17687d = synchronousTypeaheadFetchStrategy;
        this.f17688e = eventsExtendedInviteLocalInviteesFetcher;
        EventsExtendedInviteRemoteInviteesFetcher a = eventsExtendedInviteRemoteInviteesFetcherProvider.m18010a(str);
        this.f17687d.b(this.f17688e);
        this.f17687d.a(a);
        typeaheadQueryCacheManager.a(FetchSource.REMOTE, a.c());
    }

    protected final SuggestionFilter<SimpleUserToken> m18011a(TypeaheadResponse<SimpleUserToken> typeaheadResponse, String str) {
        return this.f17686c;
    }

    public final void m18012b(ImmutableList<SimpleUserToken> immutableList) {
        this.f17688e.f17623d = immutableList;
    }
}
