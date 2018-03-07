package com.facebook.groups.feed.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: rating_message */
public final class FetchGroupInformationGraphQL {

    /* compiled from: rating_message */
    public class FetchGroupInformationString extends TypedGraphQlQueryString<FetchGroupInformationModel> {
        public FetchGroupInformationString() {
            super(FetchGroupInformationModel.class, false, "FetchGroupInformation", "767a8114056d0d547370eec921a70861", "group_address", "10154654560041729", RegularImmutableSet.a);
        }

        public final TriState m6272g() {
            return TriState.YES;
        }

        public final String m6270a(String str) {
            switch (str.hashCode()) {
                case -2079973030:
                    return "8";
                case -1679359799:
                    return "1";
                case -620205220:
                    return "4";
                case -283133711:
                    return "3";
                case 506361563:
                    return "0";
                case 692733304:
                    return "6";
                case 789025418:
                    return "5";
                case 810737919:
                    return "2";
                case 2025081651:
                    return "7";
                default:
                    return str;
            }
        }

        protected final boolean m6271a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    public static final FetchGroupInformationString m6273a() {
        return new FetchGroupInformationString();
    }
}
