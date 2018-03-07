package com.facebook.leadgen;

import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputType;

/* compiled from: place_category */
public enum LeadGenUtil$ValidationResult {
    SELECT_FIELD_ERROR(GraphQLLeadGenInfoFieldInputType.SELECT),
    INLINE_SELECT_FIELD_ERROR(GraphQLLeadGenInfoFieldInputType.INLINE_SELECT),
    TEXT_FIELD_ERROR(GraphQLLeadGenInfoFieldInputType.TEXT),
    PRIVACY_CHECKBOX_ERROR(null),
    REQUIRED_CHECKBOX_ERROR(null),
    NO_ERROR(null),
    UNKNOWN_ERROR(null);
    
    public final GraphQLLeadGenInfoFieldInputType fieldInputType;

    private LeadGenUtil$ValidationResult(GraphQLLeadGenInfoFieldInputType graphQLLeadGenInfoFieldInputType) {
        this.fieldInputType = graphQLLeadGenInfoFieldInputType;
    }

    public final boolean isValid() {
        return this == NO_ERROR;
    }
}
