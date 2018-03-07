package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.fasterxml.jackson.annotation.JsonIgnore;

/* compiled from: mCallbacks= */
public interface NegativeFeedbackActionsUnit extends HideableUnit {
    Object clone();

    @JsonIgnore
    String mo2892r();

    @JsonIgnore
    GraphQLNegativeFeedbackActionType mo2893s();

    @JsonIgnore
    GraphQLNegativeFeedbackActionsConnection mo2894t();
}
