package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLModels.FetchLiteResultsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: sendError.timeStamp */
public final class FetchLiteResultsGraphQL {

    /* compiled from: sendError.timeStamp */
    public class FetchLiteResultsQueryString extends TypedGraphQlQueryString<FetchLiteResultsQueryModel> {
        public FetchLiteResultsQueryString() {
            super(FetchLiteResultsQueryModel.class, false, "FetchLiteResultsQuery", "7257fa0e3d9ee78350e20a5ee26e9d07", "viewer", "10154686831146729", RegularImmutableSet.a);
        }

        public final String m4048a(String str) {
            switch (str.hashCode()) {
                case -2068754679:
                    return "2";
                case -1997072260:
                    return "9";
                case -1877165340:
                    return "1";
                case -1629287553:
                    return "7";
                case -1397293948:
                    return "11";
                case -1362584798:
                    return "13";
                case -1101600581:
                    return "3";
                case -1058941492:
                    return "8";
                case -315684754:
                    return "6";
                case 25209764:
                    return "4";
                case 567276824:
                    return "5";
                case 700691932:
                    return "12";
                case 1598177384:
                    return "0";
                case 2082274609:
                    return "10";
                default:
                    return str;
            }
        }

        protected final boolean m4049a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1570:
                    if (str.equals("13")) {
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
}
