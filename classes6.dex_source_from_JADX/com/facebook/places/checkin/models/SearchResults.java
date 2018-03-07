package com.facebook.places.checkin.models;

import com.facebook.graphql.enums.GraphQLCheckinPromptType;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinSearchQueryModel.ClosestCityModel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: frame_pack_model */
public class SearchResults {
    public List<CheckinPlace> f14665a = new ArrayList();
    public List<CheckinPlace> f14666b = new ArrayList();
    public String f14667c = "";
    public String f14668d;
    public boolean f14669e = false;
    public GraphQLCheckinPromptType f14670f;
    public ListType f14671g = ListType.TRADITIONAL;
    public boolean f14672h = false;
    public ClosestCityModel f14673i;

    /* compiled from: frame_pack_model */
    public enum ListType {
        TRADITIONAL,
        RECENT
    }

    public SearchResults(List<CheckinPlace> list) {
        this.f14665a = list;
        this.f14666b = list;
    }
}
