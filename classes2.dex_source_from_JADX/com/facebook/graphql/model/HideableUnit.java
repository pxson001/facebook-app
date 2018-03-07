package com.facebook.graphql.model;

import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

/* compiled from: mccmnc */
public interface HideableUnit extends FeedUnit, GraphQLVisitableConsistentModel {
    Object clone();

    @JsonIgnore
    StoryVisibility mo2879o();

    @JsonIgnore
    int mo2880p();

    @JsonIgnore
    String mo2881q();
}
