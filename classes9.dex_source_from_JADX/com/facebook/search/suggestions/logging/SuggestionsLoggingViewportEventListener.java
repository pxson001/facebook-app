package com.facebook.search.suggestions.logging;

import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.rows.core.FeedUnitAdapter;
import com.facebook.feed.rows.core.traversal.SinglePartHolder;
import com.facebook.search.model.HorizontalRecentSearchesUnit;
import com.facebook.search.model.NullStateModuleCollectionUnit;
import com.facebook.search.model.TypeaheadUnit;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: {LEARN_MORE_TOKEN} */
public class SuggestionsLoggingViewportEventListener extends BaseViewportEventListener {
    public final Set<TypeaheadUnit> f150a = new LinkedHashSet();
    public final Set<HorizontalRecentSearchesUnit> f151b = new HashSet();

    @Nullable
    public static TypeaheadUnit m266c(Object obj) {
        if (obj == null || !(obj instanceof BoundedAdapter)) {
            return null;
        }
        BoundedAdapter boundedAdapter = (BoundedAdapter) obj;
        FeedUnitAdapter feedUnitAdapter = boundedAdapter.a;
        Object obj2 = ((SinglePartHolder) feedUnitAdapter.j.get(boundedAdapter.b)).d;
        if (obj2 == null || !(obj2 instanceof TypeaheadUnit)) {
            return null;
        }
        return (TypeaheadUnit) obj2;
    }

    public final void m267a(Object obj) {
        TypeaheadUnit c = m266c(obj);
        if (c != null && !(c instanceof NullStateModuleCollectionUnit)) {
            if (c instanceof HorizontalRecentSearchesUnit) {
                HorizontalRecentSearchesUnit horizontalRecentSearchesUnit = (HorizontalRecentSearchesUnit) c;
                if (!this.f151b.contains(horizontalRecentSearchesUnit)) {
                    this.f151b.add(horizontalRecentSearchesUnit);
                    this.f150a.addAll(horizontalRecentSearchesUnit.f());
                    return;
                }
                return;
            }
            this.f150a.add(c);
        }
    }
}
