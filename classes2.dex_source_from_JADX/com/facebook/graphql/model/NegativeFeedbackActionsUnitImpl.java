package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.visitor.ConsistencyTuple;

/* compiled from: group_blacklist_groups_you_should_join */
public class NegativeFeedbackActionsUnitImpl {
    private static final GraphQLNegativeFeedbackActionType f21764a = null;

    private NegativeFeedbackActionsUnitImpl() {
    }

    public static GraphQLNegativeFeedbackActionType m29497a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit) {
        ConsistencyTuple consistencyTuple = new ConsistencyTuple();
        negativeFeedbackActionsUnit.mo2835a("local_last_negative_feedback_action_type", consistencyTuple);
        if (consistencyTuple.f18727a == null) {
            return f21764a;
        }
        try {
            return GraphQLNegativeFeedbackActionType.valueOf((String) consistencyTuple.f18727a);
        } catch (IllegalArgumentException e) {
            return f21764a;
        }
    }

    public static GraphQLNegativeFeedbackActionsConnection m29498a(HasNegativeFeedbackActions hasNegativeFeedbackActions) {
        return hasNegativeFeedbackActions.mo2885C();
    }
}
