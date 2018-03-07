package com.facebook.search.results.filters.definition;

import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters.Action;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: SMS_TAKEOVER_RECENT_READ_ONLY_THREAD_VIEW_BANNER_ELIGIBLE */
public class FilterPersistentState {
    public final String f22796a;
    public final String f22797b;
    public final Filters f22798c;

    public FilterPersistentState(String str, String str2, String str3) {
        this.f22796a = str;
        this.f22797b = str2;
        this.f22798c = new Filters().a(str).a(Action.ADD).c(str3).b(null);
    }

    public final String m26439b() {
        return this.f22797b;
    }

    public final Filters m26440c() {
        return this.f22798c;
    }
}
