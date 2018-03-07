package com.facebook.messaging.graphql.threads;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.graphql.threads.UserInfoModels.UserInfoModel;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: videoMetadata */
public final class UserInfo {

    /* compiled from: videoMetadata */
    public class UsersQueryString extends TypedGraphQlQueryString<Map<String, UserInfoModel>> {
        public UsersQueryString() {
            super(UserInfoModel.class, true, "UsersQuery", "f3fdaf531953e4196f304e6516a35ccf", "messaging_actors", "10154680324791729", RegularImmutableSet.a);
        }

        public final String m2782a(String str) {
            switch (str.hashCode()) {
                case -455305975:
                    return "1";
                case -396016620:
                    return "2";
                case -20088988:
                    return "6";
                case 235810394:
                    return "7";
                case 790172080:
                    return "4";
                case 860481728:
                    return "5";
                case 1764787049:
                    return "3";
                case 1922272008:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m2783a(String str, Object obj) {
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

    public static final UsersQueryString m2784a() {
        return new UsersQueryString();
    }
}
