package com.facebook.video.channelfeed.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryModels.ChannelFeedVideoChannelFragmentModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryModels.FetchVideoChannelByVideoQueryModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryModels.FetchVideosByVideoChannelQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: contacts_reliability_difference */
public final class FetchVideoChannelQuery {

    /* compiled from: contacts_reliability_difference */
    public class FetchVideoChannelByIdQueryString extends TypedGraphQlQueryString<ChannelFeedVideoChannelFragmentModel> {
        public FetchVideoChannelByIdQueryString() {
            super(ChannelFeedVideoChannelFragmentModel.class, false, "FetchVideoChannelByIdQuery", "a06b71c421efbbc017f80af0d2b5eb7d", "node", "10154686761891729", RegularImmutableSet.a);
        }

        public final TriState m27177g() {
            return TriState.NO;
        }

        public final String m27175a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "25";
                case -1966188374:
                    return "36";
                case -1849402738:
                    return "4";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "32";
                case -1745741354:
                    return "12";
                case -1663499699:
                    return "27";
                case -1651445858:
                    return "48";
                case -1469598440:
                    return "26";
                case -1460262781:
                    return "57";
                case -1397293948:
                    return "38";
                case -1367775349:
                    return "19";
                case -1363693170:
                    return "39";
                case -1362584798:
                    return "43";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "45";
                case -1012194872:
                    return "56";
                case -971327749:
                    return "51";
                case -817257615:
                    return "33";
                case -799736697:
                    return "46";
                case -790388762:
                    return "37";
                case -672731075:
                    return "18";
                case -631654088:
                    return "7";
                case -621921156:
                    return "49";
                case -583480166:
                    return "22";
                case -561505403:
                    return "15";
                case -538773735:
                    return "31";
                case -493674687:
                    return "47";
                case -461877888:
                    return "28";
                case -317710003:
                    return "30";
                case -92787706:
                    return "9";
                case -19268531:
                    return "42";
                case 25209764:
                    return "3";
                case 92734940:
                    return "21";
                case 169846802:
                    return "10";
                case 293932680:
                    return "53";
                case 447915951:
                    return "41";
                case 557908192:
                    return "29";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "55";
                case 689802720:
                    return "24";
                case 797640206:
                    return "35";
                case 810737919:
                    return "50";
                case 1091074225:
                    return "52";
                case 1108260124:
                    return "23";
                case 1139691781:
                    return "58";
                case 1145249444:
                    return "44";
                case 1281255451:
                    return "0";
                case 1420616515:
                    return "54";
                case 1520778617:
                    return "40";
                case 1585010628:
                    return "17";
                case 1598177384:
                    return "2";
                case 1673542407:
                    return "8";
                case 1844973604:
                    return "20";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "34";
                default:
                    return str;
            }
        }

        protected final boolean m27176a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1574:
                    if (str.equals("17")) {
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
                case 1604:
                    if (str.equals("26")) {
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
                default:
                    return false;
            }
        }
    }

    /* compiled from: contacts_reliability_difference */
    public class FetchVideoChannelByVideoQueryString extends TypedGraphQlQueryString<FetchVideoChannelByVideoQueryModel> {
        public FetchVideoChannelByVideoQueryString() {
            super(FetchVideoChannelByVideoQueryModel.class, false, "FetchVideoChannelByVideoQuery", "d5084708c677d75881d1bbed9d8ef9a1", "video", "10154686761886729", RegularImmutableSet.a);
        }

        public final TriState m27180g() {
            return TriState.NO;
        }

        public final String m27178a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "26";
                case -1966188374:
                    return "37";
                case -1849402738:
                    return "5";
                case -1780769805:
                    return "14";
                case -1778558196:
                    return "33";
                case -1745741354:
                    return "13";
                case -1663499699:
                    return "28";
                case -1651445858:
                    return "49";
                case -1469598440:
                    return "27";
                case -1460262781:
                    return "1";
                case -1397293948:
                    return "39";
                case -1367775349:
                    return "20";
                case -1363693170:
                    return "40";
                case -1362584798:
                    return "44";
                case -1150725321:
                    return "12";
                case -1101600581:
                    return "2";
                case -1091844130:
                    return "46";
                case -1012194872:
                    return "57";
                case -971327749:
                    return "52";
                case -817257615:
                    return "34";
                case -799736697:
                    return "47";
                case -790388762:
                    return "38";
                case -672731075:
                    return "19";
                case -631654088:
                    return "8";
                case -621921156:
                    return "50";
                case -583480166:
                    return "23";
                case -561505403:
                    return "16";
                case -538773735:
                    return "32";
                case -493674687:
                    return "48";
                case -461877888:
                    return "29";
                case -317710003:
                    return "31";
                case -92787706:
                    return "10";
                case -19268531:
                    return "43";
                case 25209764:
                    return "4";
                case 92734940:
                    return "22";
                case 169846802:
                    return "11";
                case 293932680:
                    return "54";
                case 447915951:
                    return "42";
                case 557908192:
                    return "30";
                case 580042479:
                    return "15";
                case 609122022:
                    return "7";
                case 651215103:
                    return "17";
                case 656444234:
                    return "56";
                case 689802720:
                    return "25";
                case 797640206:
                    return "36";
                case 810737919:
                    return "51";
                case 1091074225:
                    return "53";
                case 1108260124:
                    return "24";
                case 1139691781:
                    return "58";
                case 1145249444:
                    return "45";
                case 1151387487:
                    return "0";
                case 1420616515:
                    return "55";
                case 1520778617:
                    return "41";
                case 1585010628:
                    return "18";
                case 1598177384:
                    return "3";
                case 1673542407:
                    return "9";
                case 1844973604:
                    return "21";
                case 1939875509:
                    return "6";
                case 1963391292:
                    return "35";
                default:
                    return str;
            }
        }

        protected final boolean m27179a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1575:
                    if (str.equals("18")) {
                        z = true;
                        break;
                    }
                    break;
                case 1604:
                    if (str.equals("26")) {
                        z = true;
                        break;
                    }
                    break;
                case 1605:
                    if (str.equals("27")) {
                        z = true;
                        break;
                    }
                    break;
                case 1664:
                    if (str.equals("44")) {
                        z = true;
                        break;
                    }
                    break;
                case 1667:
                    if (str.equals("47")) {
                        z = true;
                        break;
                    }
                    break;
                case 1691:
                    if (str.equals("50")) {
                        z = true;
                        break;
                    }
                    break;
                case 1692:
                    if (str.equals("51")) {
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
                default:
                    return false;
            }
        }
    }

    /* compiled from: contacts_reliability_difference */
    public class FetchVideosByVideoChannelQueryString extends TypedGraphQlQueryString<FetchVideosByVideoChannelQueryModel> {
        public FetchVideosByVideoChannelQueryString() {
            super(FetchVideosByVideoChannelQueryModel.class, false, "FetchVideosByVideoChannelQuery", "b498398538f3830aa2afa67218beaadb", "node", "10154686761856729", RegularImmutableSet.a);
        }

        public final TriState m27183g() {
            return TriState.NO;
        }

        public final String m27181a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "25";
                case -1966188374:
                    return "36";
                case -1849402738:
                    return "8";
                case -1780769805:
                    return "17";
                case -1778558196:
                    return "32";
                case -1745741354:
                    return "16";
                case -1663499699:
                    return "27";
                case -1651445858:
                    return "48";
                case -1469598440:
                    return "26";
                case -1460262781:
                    return "57";
                case -1397293948:
                    return "38";
                case -1367775349:
                    return "1";
                case -1363693170:
                    return "39";
                case -1362584798:
                    return "43";
                case -1150725321:
                    return "15";
                case -1101600581:
                    return "5";
                case -1091844130:
                    return "45";
                case -1012194872:
                    return "56";
                case -971327749:
                    return "51";
                case -817257615:
                    return "33";
                case -799736697:
                    return "46";
                case -790388762:
                    return "37";
                case -672731075:
                    return "22";
                case -631654088:
                    return "11";
                case -621921156:
                    return "49";
                case -583480166:
                    return "4";
                case -561505403:
                    return "19";
                case -538773735:
                    return "31";
                case -493674687:
                    return "47";
                case -461877888:
                    return "28";
                case -317710003:
                    return "30";
                case -92787706:
                    return "13";
                case -19268531:
                    return "42";
                case 25209764:
                    return "7";
                case 92734940:
                    return "3";
                case 169846802:
                    return "14";
                case 293932680:
                    return "53";
                case 447915951:
                    return "41";
                case 557908192:
                    return "29";
                case 580042479:
                    return "18";
                case 609122022:
                    return "10";
                case 651215103:
                    return "20";
                case 656444234:
                    return "55";
                case 689802720:
                    return "24";
                case 797640206:
                    return "35";
                case 810737919:
                    return "50";
                case 1091074225:
                    return "52";
                case 1108260124:
                    return "23";
                case 1139691781:
                    return "58";
                case 1145249444:
                    return "44";
                case 1281255451:
                    return "0";
                case 1420616515:
                    return "54";
                case 1520778617:
                    return "40";
                case 1585010628:
                    return "21";
                case 1598177384:
                    return "6";
                case 1673542407:
                    return "12";
                case 1844973604:
                    return "2";
                case 1939875509:
                    return "9";
                case 1963391292:
                    return "34";
                default:
                    return str;
            }
        }

        protected final boolean m27182a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1599:
                    if (str.equals("21")) {
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
                case 1604:
                    if (str.equals("26")) {
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
                default:
                    return false;
            }
        }
    }
}
