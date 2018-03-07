package com.facebook.search.model;

import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.facebook.search.protocol.awareness.SearchAwarenessInterfaces.SearchAwarenessSuggestionFieldsFragment;

/* compiled from: TN; */
public class SearchAwarenessUnitProperties {
    public SearchAwarenessSuggestionFieldsFragment f22251a;
    public GraphQLSearchAwarenessTemplatesEnum f22252b;
    public String f22253c;
    public long f22254d = 0;
    public long f22255e = 0;
    public boolean f22256f = false;
    public String f22257g;

    public SearchAwarenessUnitProperties(SearchAwarenessSuggestionFieldsFragment searchAwarenessSuggestionFieldsFragment, String str, String str2) {
        this.f22251a = searchAwarenessSuggestionFieldsFragment;
        this.f22257g = str;
        this.f22253c = str2;
    }
}
