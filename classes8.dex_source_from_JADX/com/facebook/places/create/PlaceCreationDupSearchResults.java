package com.facebook.places.create;

import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

/* compiled from: category_browser_malformed_data */
public class PlaceCreationDupSearchResults {
    private List<CheckinPlace> f18217a = Lists.a();
    public String f18218b = "";

    public PlaceCreationDupSearchResults(List<CheckinPlace> list) {
        this.f18217a = list;
    }

    public final List<CheckinPlace> m22173b() {
        return Collections.unmodifiableList(this.f18217a);
    }
}
