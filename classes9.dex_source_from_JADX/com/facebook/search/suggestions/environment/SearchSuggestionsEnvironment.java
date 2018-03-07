package com.facebook.search.suggestions.environment;

import android.content.Context;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.suggestions.SuggestionsFragment.DispatchTypeaheadSuggestionClickVisitor;
import com.facebook.search.suggestions.nullstate.ContentDiscoveryNullStateSupplier;
import com.facebook.search.typeahead.TypeaheadUnitCollection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: {provider_name} */
public class SearchSuggestionsEnvironment extends BaseFeedEnvironment implements AnyEnvironment {
    private DispatchTypeaheadSuggestionClickVisitor f113m;
    private FeedListType f114n;
    public TypeaheadUnitCollection f115o;
    @Nullable
    public Lazy<ContentDiscoveryNullStateSupplier> f116p;

    @Inject
    public SearchSuggestionsEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted DispatchTypeaheadSuggestionClickVisitor dispatchTypeaheadSuggestionClickVisitor, @Assisted TypeaheadUnitCollection typeaheadUnitCollection, QeAccessor qeAccessor, Lazy<ContentDiscoveryNullStateSupplier> lazy) {
        super(context, runnable, HasScrollListenerSupportImpl.b);
        this.f114n = feedListType;
        this.f113m = dispatchTypeaheadSuggestionClickVisitor;
        this.f115o = typeaheadUnitCollection;
        if (!qeAccessor.a(ExperimentsForSearchAbTestModule.aV, false)) {
            lazy = null;
        }
        this.f116p = lazy;
    }

    public final void m206a(TypeaheadUnit typeaheadUnit) {
        typeaheadUnit.a(this.f113m);
    }

    public final FeedListType m207c() {
        return this.f114n;
    }

    public final BaseFeedStoryMenuHelper m208e() {
        return null;
    }
}
