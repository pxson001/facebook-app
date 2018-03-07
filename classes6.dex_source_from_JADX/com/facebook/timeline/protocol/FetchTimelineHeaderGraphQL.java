package com.facebook.timeline.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultBigProfilePictureFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderUserFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.UserTimelineSelfQueryFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.ViewerTopFriendsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: delete_photo */
public final class FetchTimelineHeaderGraphQL {

    /* compiled from: delete_photo */
    public class TimelineProfilePictureUriQueryString extends TypedGraphQlQueryString<DefaultBigProfilePictureFieldsModel> {
        public TimelineProfilePictureUriQueryString() {
            super(DefaultBigProfilePictureFieldsModel.class, false, "TimelineProfilePictureUriQuery", "0f79993d56646a6ecb593db61d2c0a7c", "user", "10154460733946729", RegularImmutableSet.a);
        }

        public final String m25686a(String str) {
            switch (str.hashCode()) {
                case -1102636175:
                    return "0";
                case 1819236250:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: delete_photo */
    public class UserTimelineQueryString extends TypedGraphQlQueryString<TimelineHeaderUserFieldsModel> {
        public UserTimelineQueryString() {
            super(TimelineHeaderUserFieldsModel.class, false, "UserTimelineQuery", "21a7dbfc58bed1155aaea47fa764ddcf", "user", "10154663149596729", RegularImmutableSet.a);
        }

        public final String m25687a(String str) {
            switch (str.hashCode()) {
                case -1990802914:
                    return "18";
                case -1798527064:
                    return "17";
                case -1780769805:
                    return "9";
                case -1745741354:
                    return "11";
                case -1685391298:
                    return "28";
                case -1663499699:
                    return "7";
                case -1549433685:
                    return "25";
                case -1499353494:
                    return "21";
                case -1237072381:
                    return "20";
                case -1150725321:
                    return "10";
                case -1102636175:
                    return "0";
                case -705314112:
                    return "29";
                case -461877888:
                    return "8";
                case -317710003:
                    return "13";
                case -154818044:
                    return "4";
                case 12613313:
                    return "26";
                case 20000209:
                    return "2";
                case 123322600:
                    return "15";
                case 169846802:
                    return "6";
                case 342198569:
                    return "5";
                case 358354122:
                    return "22";
                case 557908192:
                    return "12";
                case 689802720:
                    return "14";
                case 762643458:
                    return "24";
                case 810737919:
                    return "19";
                case 1214355751:
                    return "23";
                case 1511637484:
                    return "27";
                case 1571938860:
                    return "16";
                case 1819236250:
                    return "1";
                case 1939875509:
                    return "3";
                default:
                    return str;
            }
        }

        protected final boolean m25688a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 53:
                    if (str.equals("5")) {
                        z = true;
                        break;
                    }
                    break;
                case 57:
                    if (str.equals("9")) {
                        z = true;
                        break;
                    }
                    break;
                case 1576:
                    if (str.equals("19")) {
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
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    return obj instanceof String ? "contain-fit".equals(obj) : false;
                default:
                    return false;
            }
        }
    }

    /* compiled from: delete_photo */
    public class UserTimelineSelfQueryString extends TypedGraphQlQueryString<UserTimelineSelfQueryFieldsModel> {
        public UserTimelineSelfQueryString() {
            super(UserTimelineSelfQueryFieldsModel.class, false, "UserTimelineSelfQuery", "18c7d3ef7c51b735bb5706f8fc806eec", "viewer", "10154663158861729", RegularImmutableSet.a);
        }

        public final String m25689a(String str) {
            switch (str.hashCode()) {
                case -1990802914:
                    return "17";
                case -1798527064:
                    return "16";
                case -1780769805:
                    return "8";
                case -1745741354:
                    return "10";
                case -1685391298:
                    return "27";
                case -1663499699:
                    return "6";
                case -1549433685:
                    return "24";
                case -1499353494:
                    return "20";
                case -1237072381:
                    return "19";
                case -1150725321:
                    return "9";
                case -705314112:
                    return "28";
                case -461877888:
                    return "7";
                case -430534157:
                    return "29";
                case -317710003:
                    return "12";
                case -154818044:
                    return "3";
                case 12613313:
                    return "25";
                case 20000209:
                    return "1";
                case 123322600:
                    return "14";
                case 169846802:
                    return "5";
                case 342198569:
                    return "4";
                case 358354122:
                    return "21";
                case 557908192:
                    return "11";
                case 689802720:
                    return "13";
                case 762643458:
                    return "23";
                case 810737919:
                    return "18";
                case 1214355751:
                    return "22";
                case 1511637484:
                    return "26";
                case 1571938860:
                    return "15";
                case 1819236250:
                    return "0";
                case 1939875509:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m25690a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 52:
                    if (str.equals("4")) {
                        z = true;
                        break;
                    }
                    break;
                case 56:
                    if (str.equals("8")) {
                        z = true;
                        break;
                    }
                    break;
                case 1575:
                    if (str.equals("18")) {
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
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    return obj instanceof String ? "contain-fit".equals(obj) : false;
                default:
                    return false;
            }
        }
    }

    /* compiled from: delete_photo */
    public class ViewerTopFriendsQueryString extends TypedGraphQlQueryString<ViewerTopFriendsQueryModel> {
        public ViewerTopFriendsQueryString() {
            super(ViewerTopFriendsQueryModel.class, false, "ViewerTopFriendsQuery", "22e1652421802d8a56493e1135311472", "viewer", "10153850691531729", RegularImmutableSet.a);
        }

        public final String m25691a(String str) {
            switch (str.hashCode()) {
                case -376472206:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final TimelineProfilePictureUriQueryString m25692b() {
        return new TimelineProfilePictureUriQueryString();
    }
}
