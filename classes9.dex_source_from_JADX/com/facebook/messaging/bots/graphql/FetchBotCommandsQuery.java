package com.facebook.messaging.bots.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryModels.FetchBotCommandsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: objective_for_results_singular_label */
public final class FetchBotCommandsQuery {

    /* compiled from: objective_for_results_singular_label */
    public class FetchBotCommandsQueryString extends TypedGraphQlQueryString<FetchBotCommandsQueryModel> {
        public FetchBotCommandsQueryString() {
            super(FetchBotCommandsQueryModel.class, false, "FetchBotCommandsQuery", "2423a66476c46e673a1e0505c62e674d", "messengerbot_command_suggestion", "10153931956186729", RegularImmutableSet.a);
        }

        public final String m8579a(String str) {
            switch (str.hashCode()) {
                case 107944136:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FetchBotCommandsQueryString m8580a() {
        return new FetchBotCommandsQueryString();
    }
}
