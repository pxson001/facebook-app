package com.facebook.timeline.editfeaturedcontainers.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.NullStateMorePageSuggestionsQueryModel;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.UserModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: ghtcvbworfgh */
public final class FetchNullStateGraphQL {

    /* compiled from: ghtcvbworfgh */
    public class NullStateMorePageSuggestionsQueryString extends TypedGraphQlQueryString<NullStateMorePageSuggestionsQueryModel> {
        public NullStateMorePageSuggestionsQueryString() {
            super(NullStateMorePageSuggestionsQueryModel.class, false, "NullStateMorePageSuggestionsQuery", "a2267e68774b3b55746895d2932566c2", "me", "10154610123781729", RegularImmutableSet.a);
        }

        public final String m10806a(String str) {
            switch (str.hashCode()) {
                case -733388273:
                    return "0";
                case 1220724975:
                    return "1";
                case 1539438167:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m10807a(String str, Object obj) {
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
                        return "36".equals(obj);
                    }
                    return (obj instanceof Integer) && ((Integer) obj).intValue() == 36;
                default:
                    return false;
            }
        }
    }

    /* compiled from: ghtcvbworfgh */
    public class NullStateQueryString extends TypedGraphQlQueryString<UserModel> {
        public NullStateQueryString() {
            super(UserModel.class, false, "NullStateQuery", "bae414fb2ce743f9c61308a6feb68134", "me", "10154607136836729", RegularImmutableSet.a);
        }

        public final String m10808a(String str) {
            switch (str.hashCode()) {
                case -733388273:
                    return "0";
                case -507614738:
                    return "3";
                case 1539438167:
                    return "1";
                case 1800280017:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m10809a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        z = true;
                        break;
                    }
                    break;
                case 49:
                    if (str.equals("1")) {
                        z = false;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "36".equals(obj);
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    if (((Integer) obj).intValue() != 36) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "3".equals(obj);
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    if (((Integer) obj).intValue() != 3) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "6".equals(obj);
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    if (((Integer) obj).intValue() != 6) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
