package com.facebook.feedplugins.researchpoll;

import com.facebook.graphql.enums.GraphQLResearchPollQuestionType;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.graphql.model.GraphQLResearchPollMultipleChoiceQuestion;
import com.facebook.graphql.model.GraphQLResearchPollMultipleChoiceResponse;
import com.facebook.graphql.model.GraphQLResearchPollQuestionResponsesConnection;
import com.facebook.graphql.model.GraphQLResearchPollSurvey;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: c00967d33dd0bd9d7ff87d43f7929b5c */
public class ResearchPollUnitHelper {

    /* compiled from: c00967d33dd0bd9d7ff87d43f7929b5c */
    /* synthetic */ class C11041 {
        static final /* synthetic */ int[] f9129a = new int[GraphQLResearchPollQuestionType.values().length];

        static {
            try {
                f9129a[GraphQLResearchPollQuestionType.CHECKBOX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9129a[GraphQLResearchPollQuestionType.RADIO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static int m9817a(ImmutableList<GraphQLResearchPollMultipleChoiceQuestion> immutableList) {
        int i = -1;
        int size = immutableList.size();
        int i2 = 0;
        while (i2 < size) {
            int size2;
            ImmutableList a = m9820a((GraphQLResearchPollMultipleChoiceQuestion) immutableList.get(i2));
            if (i < a.size()) {
                size2 = a.size();
            } else {
                size2 = i;
            }
            i2++;
            i = size2;
        }
        return i;
    }

    public static ImmutableList<GraphQLResearchPollMultipleChoiceResponse> m9820a(GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion) {
        GraphQLResearchPollQuestionResponsesConnection p = graphQLResearchPollMultipleChoiceQuestion.p();
        Preconditions.checkNotNull(p);
        ImmutableList<GraphQLResearchPollMultipleChoiceResponse> a = p.a();
        Preconditions.checkNotNull(a);
        return a;
    }

    public static boolean m9821a(GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit) {
        GraphQLResearchPollSurvey H = graphQLResearchPollFeedUnit.H();
        Preconditions.checkNotNull(H);
        GraphQLResearchPollMultipleChoiceQuestion k = H.k();
        Preconditions.checkNotNull(k);
        k = m9819a(graphQLResearchPollFeedUnit, k.k());
        return (k == null || k.j()) ? false : true;
    }

    public static GraphQLResearchPollMultipleChoiceQuestion m9819a(GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit, String str) {
        ImmutableList a = ItemListFeedUnitImpl.a(graphQLResearchPollFeedUnit);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion = (GraphQLResearchPollMultipleChoiceQuestion) a.get(i);
            if (graphQLResearchPollMultipleChoiceQuestion.k().equals(str)) {
                return graphQLResearchPollMultipleChoiceQuestion;
            }
        }
        throw new IllegalArgumentException("questionId not in unit");
    }

    public static GraphQLResearchPollMultipleChoiceQuestion m9818a(ResearchPollPersistentState researchPollPersistentState, GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit, GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion) {
        GraphQLResearchPollMultipleChoiceQuestion l;
        switch (C11041.f9129a[graphQLResearchPollMultipleChoiceQuestion.n().ordinal()]) {
            case 1:
                l = graphQLResearchPollMultipleChoiceQuestion.l();
                break;
            case 2:
                ImmutableList a = graphQLResearchPollMultipleChoiceQuestion.p().a();
                int i = 0;
                l = null;
                while (i < a.size()) {
                    GraphQLResearchPollMultipleChoiceQuestion l2;
                    if (researchPollPersistentState.m9765b(((GraphQLResearchPollMultipleChoiceResponse) a.get(i)).k())) {
                        l2 = ((GraphQLResearchPollMultipleChoiceResponse) a.get(i)).l();
                    } else {
                        l2 = l;
                    }
                    i++;
                    l = l2;
                }
                break;
            default:
                l = null;
                break;
        }
        if (l == null) {
            return null;
        }
        return m9819a(graphQLResearchPollFeedUnit, l.k());
    }
}
