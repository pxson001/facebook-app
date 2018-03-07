package com.facebook.ui.typeahead.querycache;

import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.MatchType;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: copyrights */
public class TypeaheadQueryCache<T> {
    private final Map<String, Map<String, TypeaheadResponse<T>>> f18445a = new HashMap();
    public final TypeaheadResponse<T> f18446b = new TypeaheadResponse(TypeaheadRequest.f15457a, new SearchResponse(RegularImmutableList.a), FetchSource.UNSET, MatchType.UNSET);

    public final TypeaheadResponse<T> m27062a(@Nullable String str, String str2) {
        if (str == null) {
            str = "";
        }
        return this.f18445a.containsKey(str) ? (TypeaheadResponse) ((Map) this.f18445a.get(str)).get(str2) : null;
    }

    public final void m27064a(@Nullable String str, String str2, TypeaheadResponse<T> typeaheadResponse) {
        if (str == null) {
            str = "";
        }
        Map map = (Map) this.f18445a.get(str);
        if (map == null) {
            map = new HashMap();
            map.put(str2, typeaheadResponse);
            this.f18445a.put(str, map);
            return;
        }
        map.put(str2, typeaheadResponse);
    }

    public final boolean m27065b(@Nullable String str, String str2) {
        if (str == null) {
            str = "";
        }
        return this.f18445a.get(str) != null && ((Map) this.f18445a.get(str)).containsKey(str2);
    }

    public final void m27063a() {
        this.f18445a.clear();
    }

    public final TypeaheadResponse<T> m27066c(@Nullable String str, String str2) {
        if (str == null) {
            str = "";
        }
        String str3 = null;
        Map map = (Map) this.f18445a.get(str);
        if (map == null) {
            return this.f18446b;
        }
        for (String str4 : map.keySet()) {
            String str5;
            if ((str3 != null && str4.length() <= str3.length()) || !str2.startsWith(str4)) {
                str5 = str3;
            }
            str3 = str5;
        }
        if (str3 != null) {
            return (TypeaheadResponse) map.get(str3);
        }
        return this.f18446b;
    }
}
