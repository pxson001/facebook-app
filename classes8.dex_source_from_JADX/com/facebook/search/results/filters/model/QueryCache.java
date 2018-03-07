package com.facebook.search.results.filters.model;

import com.facebook.inject.InjectorLike;
import com.facebook.ui.typeahead.TypeaheadResponse;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: SLIDESHOW_REMOVED */
public class QueryCache<T> {
    public final Map<String, TypeaheadResponse<T>> f22858a = new HashMap();

    public static QueryCache m26510a(InjectorLike injectorLike) {
        return new QueryCache();
    }

    public final void m26512a(String str, TypeaheadResponse<T> typeaheadResponse) {
        this.f22858a.put(str, typeaheadResponse);
    }

    @Nullable
    public final TypeaheadResponse<T> m26511a(String str) {
        return (TypeaheadResponse) this.f22858a.get(str);
    }

    @Nullable
    public final TypeaheadResponse<T> m26513b(String str) {
        if (this.f22858a.containsKey(str)) {
            return (TypeaheadResponse) this.f22858a.get(str);
        }
        String str2 = "";
        for (String str3 : this.f22858a.keySet()) {
            String str32;
            if (str32.length() < str2.length() || !str.startsWith(str32)) {
                str32 = str2;
            }
            str2 = str32;
        }
        return (TypeaheadResponse) this.f22858a.get(str2);
    }
}
