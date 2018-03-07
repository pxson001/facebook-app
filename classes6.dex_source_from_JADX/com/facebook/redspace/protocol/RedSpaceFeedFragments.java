package com.facebook.redspace.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceUnreadFriendsQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitsQueryModel;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: should_picker_support_live_camera */
public final class RedSpaceFeedFragments {

    /* compiled from: should_picker_support_live_camera */
    public class RedSpaceFriendsOverflowCountQueryString extends TypedGraphQlQueryString<RedSpaceFriendsOverflowCountQueryModel> {
        public RedSpaceFriendsOverflowCountQueryString() {
            super(RedSpaceFriendsOverflowCountQueryModel.class, false, "RedSpaceFriendsOverflowCountQuery", "772b4db0cc1abb4fb41042297d803e84", "viewer", "10154561216171729", RegularImmutableSet.a);
        }

        public final String m6463a(String str) {
            switch (str.hashCode()) {
                case -785864030:
                    return "3";
                case 507053576:
                    return "0";
                case 1647468595:
                    return "2";
                case 1970241253:
                    return "1";
                default:
                    return str;
            }
        }

        protected final boolean m6464a(String str, Object obj) {
            Object obj2 = -1;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        obj2 = null;
                        break;
                    }
                    break;
            }
            switch (obj2) {
                case null:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: should_picker_support_live_camera */
    public class RedSpaceFriendsQueryString extends TypedGraphQlQueryString<RedSpaceFriendsQueryModel> {
        public RedSpaceFriendsQueryString() {
            super(RedSpaceFriendsQueryModel.class, false, "RedSpaceFriendsQuery", "5ab0127d98a8e6ba76f78810c59f1a01", "viewer", "10154657929546729", ImmutableSet.of("has_more_friends"));
        }

        public final String m6465a(String str) {
            switch (str.hashCode()) {
                case -785864030:
                    return "8";
                case -472129004:
                    return "1";
                case -230346670:
                    return "6";
                case 97440432:
                    return "7";
                case 104585017:
                    return "4";
                case 250738772:
                    return "5";
                case 426040529:
                    return "10";
                case 491755317:
                    return "0";
                case 492603619:
                    return "11";
                case 507053576:
                    return "2";
                case 1338377239:
                    return "9";
                case 1970241253:
                    return "3";
                default:
                    return str;
            }
        }

        protected final boolean m6466a(String str, Object obj) {
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
                case 57:
                    if (str.equals("9")) {
                        z = true;
                        break;
                    }
                    break;
                case 1567:
                    if (str.equals("10")) {
                        z = true;
                        break;
                    }
                    break;
                case 1568:
                    if (str.equals("11")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
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
                default:
                    return false;
            }
        }
    }

    /* compiled from: should_picker_support_live_camera */
    public class RedSpaceProfileQueryString extends TypedGraphQlQueryString<RedSpaceFeedProfileFragmentModel> {
        public RedSpaceProfileQueryString() {
            super(RedSpaceFeedProfileFragmentModel.class, false, "RedSpaceProfileQuery", "c9362746b5255224ef697bb198c4eef7", "user", "10154657772896729", RegularImmutableSet.a);
        }

        public final String m6467a(String str) {
            switch (str.hashCode()) {
                case -1102636175:
                    return "0";
                case -785864030:
                    return "1";
                case 426040529:
                    return "3";
                case 492603619:
                    return "4";
                case 1338377239:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m6468a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        z = true;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
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
                default:
                    return false;
            }
        }
    }

    /* compiled from: should_picker_support_live_camera */
    public class RedSpaceStoriesQueryString extends TypedGraphQlQueryString<RedSpaceStoriesQueryModel> {
        public RedSpaceStoriesQueryString() {
            super(RedSpaceStoriesQueryModel.class, false, "RedSpaceStoriesQuery", "d06e726fe380e7b53c20c2d19d7f5a52", "node", "10154686761611729", RegularImmutableSet.a);
        }

        public final TriState m6471g() {
            return TriState.NO;
        }

        public final String m6469a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "24";
                case -1966188374:
                    return "35";
                case -1849402738:
                    return "8";
                case -1780769805:
                    return "17";
                case -1778558196:
                    return "31";
                case -1745741354:
                    return "16";
                case -1663499699:
                    return "26";
                case -1651445858:
                    return "48";
                case -1469598440:
                    return "25";
                case -1460262781:
                    return "57";
                case -1397293948:
                    return "37";
                case -1363693170:
                    return "38";
                case -1362584798:
                    return "43";
                case -1333184300:
                    return "40";
                case -1150725321:
                    return "15";
                case -1102636175:
                    return "0";
                case -1101600581:
                    return "5";
                case -1091844130:
                    return "45";
                case -1012194872:
                    return "56";
                case -971327749:
                    return "51";
                case -817257615:
                    return "32";
                case -799736697:
                    return "46";
                case -790388762:
                    return "36";
                case -631654088:
                    return "11";
                case -621921156:
                    return "49";
                case -561505403:
                    return "19";
                case -538773735:
                    return "30";
                case -493674687:
                    return "47";
                case -461877888:
                    return "27";
                case -317710003:
                    return "29";
                case -230346670:
                    return "3";
                case -92787706:
                    return "13";
                case -19268531:
                    return "42";
                case 25209764:
                    return "7";
                case 97440432:
                    return "4";
                case 169846802:
                    return "14";
                case 265360233:
                    return "1";
                case 293932680:
                    return "53";
                case 447915951:
                    return "41";
                case 557908192:
                    return "28";
                case 580042479:
                    return "18";
                case 609122022:
                    return "10";
                case 651215103:
                    return "20";
                case 656444234:
                    return "55";
                case 689802720:
                    return "23";
                case 797640206:
                    return "34";
                case 810737919:
                    return "50";
                case 1091074225:
                    return "52";
                case 1108260124:
                    return "22";
                case 1139691781:
                    return "58";
                case 1145249444:
                    return "44";
                case 1350787992:
                    return "2";
                case 1420616515:
                    return "54";
                case 1520778617:
                    return "39";
                case 1585010628:
                    return "21";
                case 1598177384:
                    return "6";
                case 1673542407:
                    return "12";
                case 1939875509:
                    return "9";
                case 1963391292:
                    return "33";
                default:
                    return str;
            }
        }

        protected final boolean m6470a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1599:
                    if (str.equals("21")) {
                        z = true;
                        break;
                    }
                    break;
                case 1602:
                    if (str.equals("24")) {
                        z = true;
                        break;
                    }
                    break;
                case 1603:
                    if (str.equals("25")) {
                        z = true;
                        break;
                    }
                    break;
                case 1660:
                    if (str.equals("40")) {
                        z = true;
                        break;
                    }
                    break;
                case 1663:
                    if (str.equals("43")) {
                        z = true;
                        break;
                    }
                    break;
                case 1666:
                    if (str.equals("46")) {
                        z = true;
                        break;
                    }
                    break;
                case 1669:
                    if (str.equals("49")) {
                        z = true;
                        break;
                    }
                    break;
                case 1691:
                    if (str.equals("50")) {
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
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
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
                default:
                    return false;
            }
        }
    }

    /* compiled from: should_picker_support_live_camera */
    public class RedSpaceUnreadFriendsQueryString extends TypedGraphQlQueryString<RedSpaceUnreadFriendsQueryModel> {
        public RedSpaceUnreadFriendsQueryString() {
            super(RedSpaceUnreadFriendsQueryModel.class, false, "RedSpaceUnreadFriendsQuery", "52690cceb333ad33b68761a3acdeadf4", "viewer", "10154563417261729", ImmutableSet.of("has_unread_content"));
        }
    }

    /* compiled from: should_picker_support_live_camera */
    public class RedSpaceVisitsQueryString extends TypedGraphQlQueryString<RedSpaceVisitsQueryModel> {
        public RedSpaceVisitsQueryString() {
            super(RedSpaceVisitsQueryModel.class, false, "RedSpaceVisitsQuery", "df358c99a9484cfc8f758d51f6e31f33", "viewer", "10154677212701729", RegularImmutableSet.a);
        }

        public final String m6472a(String str) {
            switch (str.hashCode()) {
                case -1753808173:
                    return "4";
                case -1468824252:
                    return "3";
                case -230346670:
                    return "0";
                case 265360233:
                    return "1";
                case 1350787992:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
