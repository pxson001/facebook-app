package com.facebook.timeline.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: delay_3 */
public final class FetchTimelineSectionGraphQL {

    /* compiled from: delay_3 */
    public class TimelineFirstUnitsPageString extends TypedGraphQlQueryString<GraphQLPage> {
        public TimelineFirstUnitsPageString() {
            super(GraphQLPage.class, false, "TimelineFirstUnitsPage", "b97d1797b9d28934ce5d39a1fd8ebdf9", "page", "10154686761606729", RegularImmutableSet.a);
        }

        public final TriState m26157g() {
            return TriState.NO;
        }

        public final String m26155a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "20";
                case -1966188374:
                    return "32";
                case -1849402738:
                    return "4";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "28";
                case -1745741354:
                    return "12";
                case -1663499699:
                    return "23";
                case -1651445858:
                    return "44";
                case -1469598440:
                    return "21";
                case -1460262781:
                    return "57";
                case -1397293948:
                    return "34";
                case -1363693170:
                    return "35";
                case -1362584798:
                    return "39";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "41";
                case -1040171331:
                    return "0";
                case -1012194872:
                    return "22";
                case -971327749:
                    return "47";
                case -920057724:
                    return "55";
                case -817257615:
                    return "29";
                case -799736697:
                    return "42";
                case -790388762:
                    return "33";
                case -631654088:
                    return "7";
                case -621921156:
                    return "45";
                case -561505403:
                    return "15";
                case -538773735:
                    return "27";
                case -493674687:
                    return "43";
                case -461877888:
                    return "24";
                case -317710003:
                    return "26";
                case -154818044:
                    return "53";
                case -92787706:
                    return "9";
                case -74065610:
                    return "54";
                case -19268531:
                    return "38";
                case 25209764:
                    return "3";
                case 169846802:
                    return "10";
                case 293932680:
                    return "49";
                case 447915951:
                    return "37";
                case 557908192:
                    return "25";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "51";
                case 689802720:
                    return "19";
                case 797640206:
                    return "31";
                case 810737919:
                    return "46";
                case 969214549:
                    return "56";
                case 1091074225:
                    return "48";
                case 1108260124:
                    return "18";
                case 1139691781:
                    return "58";
                case 1145249444:
                    return "40";
                case 1420616515:
                    return "50";
                case 1520778617:
                    return "36";
                case 1585010628:
                    return "17";
                case 1598177384:
                    return "2";
                case 1673542407:
                    return "8";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "30";
                case 1965538434:
                    return "52";
                default:
                    return str;
            }
        }

        protected final boolean m26156a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = true;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
                        z = true;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
                        z = true;
                        break;
                    }
                    break;
                case 1570:
                    if (str.equals("13")) {
                        z = true;
                        break;
                    }
                    break;
                case 1571:
                    if (str.equals("14")) {
                        z = true;
                        break;
                    }
                    break;
                case 1574:
                    if (str.equals("17")) {
                        z = true;
                        break;
                    }
                    break;
                case 1576:
                    if (str.equals("19")) {
                        z = true;
                        break;
                    }
                    break;
                case 1598:
                    if (str.equals("20")) {
                        z = true;
                        break;
                    }
                    break;
                case 1599:
                    if (str.equals("21")) {
                        z = true;
                        break;
                    }
                    break;
                case 1600:
                    if (str.equals("22")) {
                        z = true;
                        break;
                    }
                    break;
                case 1607:
                    if (str.equals("29")) {
                        z = true;
                        break;
                    }
                    break;
                case 1633:
                    if (str.equals("34")) {
                        z = true;
                        break;
                    }
                    break;
                case 1634:
                    if (str.equals("35")) {
                        z = true;
                        break;
                    }
                    break;
                case 1637:
                    if (str.equals("38")) {
                        z = true;
                        break;
                    }
                    break;
                case 1638:
                    if (str.equals("39")) {
                        z = true;
                        break;
                    }
                    break;
                case 1661:
                    if (str.equals("41")) {
                        z = true;
                        break;
                    }
                    break;
                case 1662:
                    if (str.equals("42")) {
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
                case 1664:
                    if (str.equals("44")) {
                        z = false;
                        break;
                    }
                    break;
                case 1665:
                    if (str.equals("45")) {
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
                case 1693:
                    if (str.equals("52")) {
                        z = true;
                        break;
                    }
                    break;
                case 1694:
                    if (str.equals("53")) {
                        z = true;
                        break;
                    }
                    break;
                case 1697:
                    if (str.equals("56")) {
                        z = true;
                        break;
                    }
                    break;
                case 1699:
                    if (str.equals("58")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "profile".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "1".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "1".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "image/jpeg".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "image/x-auto".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "MPEG_DASH".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "contain-fit".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "4".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 4) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: delay_3 */
    public class TimelineFirstUnitsUserString extends TypedGraphQlQueryString<GraphQLUser> {
        public TimelineFirstUnitsUserString() {
            super(GraphQLUser.class, false, "TimelineFirstUnitsUser", "20acfcf4b8a06a7921dd5c703f2b4e59", "user", "10154686761621729", ImmutableSet.of("section_id", "end_cursor"));
        }

        public final TriState m26160g() {
            return TriState.NO;
        }

        public final String m26158a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "21";
                case -1966188374:
                    return "33";
                case -1849402738:
                    return "4";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "29";
                case -1745741354:
                    return "12";
                case -1663499699:
                    return "24";
                case -1651445858:
                    return "45";
                case -1618883810:
                    return "56";
                case -1469598440:
                    return "22";
                case -1460262781:
                    return "59";
                case -1397293948:
                    return "35";
                case -1363693170:
                    return "36";
                case -1362584798:
                    return "40";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "42";
                case -1040171331:
                    return "0";
                case -1012194872:
                    return "23";
                case -971327749:
                    return "48";
                case -920057724:
                    return "57";
                case -817257615:
                    return "30";
                case -799736697:
                    return "43";
                case -790388762:
                    return "34";
                case -672731075:
                    return "18";
                case -631654088:
                    return "7";
                case -621921156:
                    return "46";
                case -561505403:
                    return "15";
                case -538773735:
                    return "28";
                case -493674687:
                    return "44";
                case -461877888:
                    return "25";
                case -317710003:
                    return "27";
                case -154818044:
                    return "54";
                case -92787706:
                    return "9";
                case -74065610:
                    return "55";
                case -19268531:
                    return "39";
                case 25209764:
                    return "3";
                case 169846802:
                    return "10";
                case 293932680:
                    return "50";
                case 447915951:
                    return "38";
                case 557908192:
                    return "26";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "52";
                case 689802720:
                    return "20";
                case 797640206:
                    return "32";
                case 810737919:
                    return "47";
                case 969214549:
                    return "58";
                case 1091074225:
                    return "49";
                case 1108260124:
                    return "19";
                case 1139691781:
                    return "60";
                case 1145249444:
                    return "41";
                case 1420616515:
                    return "51";
                case 1520778617:
                    return "37";
                case 1585010628:
                    return "17";
                case 1598177384:
                    return "2";
                case 1673542407:
                    return "8";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "31";
                case 1965538434:
                    return "53";
                default:
                    return str;
            }
        }

        protected final boolean m26159a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = true;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
                        z = true;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
                        z = true;
                        break;
                    }
                    break;
                case 1570:
                    if (str.equals("13")) {
                        z = true;
                        break;
                    }
                    break;
                case 1571:
                    if (str.equals("14")) {
                        z = true;
                        break;
                    }
                    break;
                case 1574:
                    if (str.equals("17")) {
                        z = true;
                        break;
                    }
                    break;
                case 1575:
                    if (str.equals("18")) {
                        z = true;
                        break;
                    }
                    break;
                case 1598:
                    if (str.equals("20")) {
                        z = true;
                        break;
                    }
                    break;
                case 1599:
                    if (str.equals("21")) {
                        z = true;
                        break;
                    }
                    break;
                case 1600:
                    if (str.equals("22")) {
                        z = true;
                        break;
                    }
                    break;
                case 1601:
                    if (str.equals("23")) {
                        z = true;
                        break;
                    }
                    break;
                case 1629:
                    if (str.equals("30")) {
                        z = true;
                        break;
                    }
                    break;
                case 1634:
                    if (str.equals("35")) {
                        z = true;
                        break;
                    }
                    break;
                case 1635:
                    if (str.equals("36")) {
                        z = true;
                        break;
                    }
                    break;
                case 1638:
                    if (str.equals("39")) {
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
                case 1662:
                    if (str.equals("42")) {
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
                case 1664:
                    if (str.equals("44")) {
                        z = true;
                        break;
                    }
                    break;
                case 1665:
                    if (str.equals("45")) {
                        z = false;
                        break;
                    }
                    break;
                case 1666:
                    if (str.equals("46")) {
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
                case 1694:
                    if (str.equals("53")) {
                        z = true;
                        break;
                    }
                    break;
                case 1695:
                    if (str.equals("54")) {
                        z = true;
                        break;
                    }
                    break;
                case 1699:
                    if (str.equals("58")) {
                        z = true;
                        break;
                    }
                    break;
                case 1722:
                    if (str.equals("60")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "profile".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "1".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "1".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "image/jpeg".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "50".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 50) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "image/x-auto".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "MPEG_DASH".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "contain-fit".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "4".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 4) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: delay_3 */
    public class TimelineUserSectionQueryString extends TypedGraphQlQueryString<GraphQLTimelineSection> {
        public TimelineUserSectionQueryString() {
            super(GraphQLTimelineSection.class, false, "TimelineUserSectionQuery", "4d3c54386d83c2577975d392dc6ddf6e", "node", "10154686761661729", ImmutableSet.of("end_cursor"));
        }

        public final TriState m26163g() {
            return TriState.NO;
        }

        public final String m26161a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "21";
                case -1966188374:
                    return "33";
                case -1849402738:
                    return "4";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "29";
                case -1745741354:
                    return "12";
                case -1663499699:
                    return "24";
                case -1651445858:
                    return "45";
                case -1618883810:
                    return "56";
                case -1469598440:
                    return "22";
                case -1460262781:
                    return "59";
                case -1397293948:
                    return "35";
                case -1363693170:
                    return "36";
                case -1362584798:
                    return "40";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "42";
                case -1040171331:
                    return "0";
                case -1012194872:
                    return "23";
                case -971327749:
                    return "48";
                case -920057724:
                    return "57";
                case -817257615:
                    return "30";
                case -799736697:
                    return "43";
                case -790388762:
                    return "34";
                case -672731075:
                    return "18";
                case -631654088:
                    return "7";
                case -621921156:
                    return "46";
                case -561505403:
                    return "15";
                case -538773735:
                    return "28";
                case -493674687:
                    return "44";
                case -461877888:
                    return "25";
                case -317710003:
                    return "27";
                case -154818044:
                    return "54";
                case -92787706:
                    return "9";
                case -74065610:
                    return "55";
                case -19268531:
                    return "39";
                case 25209764:
                    return "3";
                case 169846802:
                    return "10";
                case 293932680:
                    return "50";
                case 447915951:
                    return "38";
                case 557908192:
                    return "26";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "52";
                case 689802720:
                    return "20";
                case 797640206:
                    return "32";
                case 810737919:
                    return "47";
                case 969214549:
                    return "58";
                case 1091074225:
                    return "49";
                case 1108260124:
                    return "19";
                case 1139691781:
                    return "60";
                case 1145249444:
                    return "41";
                case 1420616515:
                    return "51";
                case 1520778617:
                    return "37";
                case 1585010628:
                    return "17";
                case 1598177384:
                    return "2";
                case 1673542407:
                    return "8";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "31";
                case 1965538434:
                    return "53";
                default:
                    return str;
            }
        }

        protected final boolean m26162a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = true;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
                        z = true;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
                        z = true;
                        break;
                    }
                    break;
                case 1570:
                    if (str.equals("13")) {
                        z = true;
                        break;
                    }
                    break;
                case 1571:
                    if (str.equals("14")) {
                        z = true;
                        break;
                    }
                    break;
                case 1574:
                    if (str.equals("17")) {
                        z = true;
                        break;
                    }
                    break;
                case 1575:
                    if (str.equals("18")) {
                        z = true;
                        break;
                    }
                    break;
                case 1598:
                    if (str.equals("20")) {
                        z = true;
                        break;
                    }
                    break;
                case 1599:
                    if (str.equals("21")) {
                        z = true;
                        break;
                    }
                    break;
                case 1600:
                    if (str.equals("22")) {
                        z = true;
                        break;
                    }
                    break;
                case 1601:
                    if (str.equals("23")) {
                        z = true;
                        break;
                    }
                    break;
                case 1629:
                    if (str.equals("30")) {
                        z = true;
                        break;
                    }
                    break;
                case 1634:
                    if (str.equals("35")) {
                        z = true;
                        break;
                    }
                    break;
                case 1635:
                    if (str.equals("36")) {
                        z = true;
                        break;
                    }
                    break;
                case 1638:
                    if (str.equals("39")) {
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
                case 1662:
                    if (str.equals("42")) {
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
                case 1664:
                    if (str.equals("44")) {
                        z = true;
                        break;
                    }
                    break;
                case 1665:
                    if (str.equals("45")) {
                        z = false;
                        break;
                    }
                    break;
                case 1666:
                    if (str.equals("46")) {
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
                case 1694:
                    if (str.equals("53")) {
                        z = true;
                        break;
                    }
                    break;
                case 1695:
                    if (str.equals("54")) {
                        z = true;
                        break;
                    }
                    break;
                case 1699:
                    if (str.equals("58")) {
                        z = true;
                        break;
                    }
                    break;
                case 1722:
                    if (str.equals("60")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "profile".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "1".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "1".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "image/jpeg".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "50".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 50) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "image/x-auto".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "MPEG_DASH".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "contain-fit".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "8".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 8) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
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
