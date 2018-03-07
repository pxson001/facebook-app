package com.facebook.events.invite;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCache;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheSupplier;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: checkout_path */
public class EventsExtendedInviteTypeaheadQueryCacheSupplier extends TypeaheadQueryCacheSupplier<SimpleUserToken> {
    public static EventsExtendedInviteTypeaheadQueryCacheSupplier m18014b(InjectorLike injectorLike) {
        return new EventsExtendedInviteTypeaheadQueryCacheSupplier(IdBasedProvider.a(injectorLike, 11523));
    }

    @Inject
    public EventsExtendedInviteTypeaheadQueryCacheSupplier(Provider<TypeaheadQueryCache> provider) {
        super(null, (TypeaheadQueryCache) provider.get(), null, null);
    }
}
