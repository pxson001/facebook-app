package com.facebook.greetingcards.render;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.greetingcards.render.GreetingCardTemplatesGraphqlModels.GreetingCardTemplateQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: youjoh */
public final class GreetingCardTemplatesGraphql {

    /* compiled from: youjoh */
    public class GreetingCardTemplateQueryString extends TypedGraphQlQueryString<GreetingCardTemplateQueryModel> {
        public GreetingCardTemplateQueryString() {
            super(GreetingCardTemplateQueryModel.class, false, "GreetingCardTemplateQuery", "85b77762016db1523d0afed33e2a7dbe", "node", "10154358537341729", RegularImmutableSet.a);
        }

        public final String m228a(String str) {
            switch (str.hashCode()) {
                case -1221029593:
                    return "2";
                case -925312643:
                    return "0";
                case 109250890:
                    return "3";
                case 113126854:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
