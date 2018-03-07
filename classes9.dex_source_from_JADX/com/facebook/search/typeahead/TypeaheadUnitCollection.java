package com.facebook.search.typeahead;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.inject.InjectorLike;
import com.facebook.search.model.TypeaheadUnit;
import java.util.ArrayList;
import java.util.List;

/* compiled from: video_data */
public class TypeaheadUnitCollection implements ListItemCollection<TypeaheadUnit> {
    public final List<TypeaheadUnit> f422a = new ArrayList();

    public static TypeaheadUnitCollection m526a(InjectorLike injectorLike) {
        return new TypeaheadUnitCollection();
    }

    public final int m527a() {
        return this.f422a.size();
    }

    public final Object m528a(int i) {
        return (TypeaheadUnit) this.f422a.get(i);
    }

    public final void m529a(List<? extends TypeaheadUnit> list) {
        this.f422a.clear();
        this.f422a.addAll(list);
    }
}
