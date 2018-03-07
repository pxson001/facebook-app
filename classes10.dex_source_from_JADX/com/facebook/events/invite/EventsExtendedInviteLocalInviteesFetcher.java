package com.facebook.events.invite;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.typeahead.BaseTypeaheadFetcher;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.userfilter.UserTokenMatcher;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: click_from_tray */
public class EventsExtendedInviteLocalInviteesFetcher extends BaseTypeaheadFetcher<SimpleUserToken> {
    private static final String f17620a = EventsExtendedInviteLocalInviteesFetcher.class.getSimpleName();
    private final EventsExtendedInviteFbFriendsFilterProvider f17621b;
    private final AbstractFbErrorReporter f17622c;
    public ImmutableList<SimpleUserToken> f17623d = RegularImmutableList.a;

    public static EventsExtendedInviteLocalInviteesFetcher m17977b(InjectorLike injectorLike) {
        return new EventsExtendedInviteLocalInviteesFetcher((EventsExtendedInviteFbFriendsFilterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventsExtendedInviteFbFriendsFilterProvider.class), EventsExtendedInviteTypeaheadQueryCacheSupplier.m18014b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public EventsExtendedInviteLocalInviteesFetcher(EventsExtendedInviteFbFriendsFilterProvider eventsExtendedInviteFbFriendsFilterProvider, EventsExtendedInviteTypeaheadQueryCacheSupplier eventsExtendedInviteTypeaheadQueryCacheSupplier, AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager) {
        super(tasksManager, eventsExtendedInviteTypeaheadQueryCacheSupplier);
        this.f17622c = abstractFbErrorReporter;
        this.f17621b = eventsExtendedInviteFbFriendsFilterProvider;
    }

    public final String m17979a() {
        return "FETCH_LOCAL_FRIENDS_TASK";
    }

    public final ListenableFuture<SearchResponse<SimpleUserToken>> m17978a(TypeaheadRequest typeaheadRequest) {
        final SettableFuture f = SettableFuture.f();
        EventsExtendedInviteFbFriendsFilterProvider eventsExtendedInviteFbFriendsFilterProvider = this.f17621b;
        new EventsExtendedInviteFbFriendsFilter(FbHandlerThreadFactory.a(eventsExtendedInviteFbFriendsFilterProvider), UserTokenMatcher.b(eventsExtendedInviteFbFriendsFilterProvider), new Object(this) {
            public final /* synthetic */ EventsExtendedInviteLocalInviteesFetcher f17619b;
        }).a(typeaheadRequest.b);
        return f;
    }

    protected final FetchSource m17981b() {
        return FetchSource.LOCAL;
    }

    public final void m17980a(@Nullable TypeaheadRequest typeaheadRequest, Throwable th) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f17622c;
        SoftErrorBuilder a = SoftError.a(f17620a, "Failed to fetch local invitees");
        a.c = th;
        abstractFbErrorReporter.a(a.g());
    }
}
