package com.facebook.photos.albums.protocols;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.photos.albums.protocols.AlbumListQueryModels.AlbumListCanUploadOnlyQueryModel;
import com.facebook.photos.albums.protocols.AlbumListQueryModels.AlbumListQueryModel;
import com.facebook.photos.albums.protocols.AlbumListQueryModels.FBFamilyNonUserMemberAlbumsQueryModel;
import com.facebook.photos.albums.protocols.AlbumListQueryModels.GroupAlbumListQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: invitation_opened */
public final class AlbumListQuery {

    /* compiled from: invitation_opened */
    public class AlbumListCanUploadOnlyQueryString extends TypedGraphQlQueryString<AlbumListCanUploadOnlyQueryModel> {
        public AlbumListCanUploadOnlyQueryString() {
            super(AlbumListCanUploadOnlyQueryModel.class, false, "AlbumListCanUploadOnlyQuery", "a50310455fe1176f35c102309d5a5af2", "node", "10154690955051729", RegularImmutableSet.a);
        }

        public final TriState m19206g() {
            return TriState.NO;
        }

        public final String m19204a(String str) {
            switch (str.hashCode()) {
                case -2111250185:
                    return "49";
                case -1966188374:
                    return "35";
                case -1849402738:
                    return "7";
                case -1780769805:
                    return "16";
                case -1778558196:
                    return "31";
                case -1773565470:
                    return "62";
                case -1745741354:
                    return "15";
                case -1718813234:
                    return "66";
                case -1663499699:
                    return "26";
                case -1547457328:
                    return "21";
                case -1460262781:
                    return "69";
                case -1397293948:
                    return "37";
                case -1392885889:
                    return "1";
                case -1362584798:
                    return "68";
                case -1284099636:
                    return "41";
                case -1150725321:
                    return "14";
                case -1116221284:
                    return "51";
                case -1109830290:
                    return "47";
                case -1101600581:
                    return "4";
                case -1012194872:
                    return "44";
                case -971327749:
                    return "57";
                case -969292942:
                    return "56";
                case -945993139:
                    return "42";
                case -817257615:
                    return "32";
                case -790388762:
                    return "36";
                case -680727674:
                    return "43";
                case -631654088:
                    return "10";
                case -561505403:
                    return "18";
                case -538773735:
                    return "30";
                case -461877888:
                    return "27";
                case -317710003:
                    return "29";
                case -113788560:
                    return "40";
                case -92787706:
                    return "12";
                case -16226492:
                    return "38";
                case 25209764:
                    return "6";
                case 41001321:
                    return "67";
                case 92734940:
                    return "2";
                case 97440432:
                    return "3";
                case 109250890:
                    return "65";
                case 169846802:
                    return "13";
                case 293932680:
                    return "59";
                case 297456968:
                    return "45";
                case 355809903:
                    return "54";
                case 421050507:
                    return "63";
                case 557908192:
                    return "28";
                case 580042479:
                    return "17";
                case 609122022:
                    return "9";
                case 613692368:
                    return "53";
                case 651215103:
                    return "19";
                case 656444234:
                    return "61";
                case 689802720:
                    return "22";
                case 774983793:
                    return "39";
                case 797640206:
                    return "34";
                case 810737919:
                    return "55";
                case 825224060:
                    return "46";
                case 899150587:
                    return "50";
                case 1006935441:
                    return "64";
                case 1091074225:
                    return "58";
                case 1108260124:
                    return "25";
                case 1139691781:
                    return "70";
                case 1420616515:
                    return "60";
                case 1585010628:
                    return "20";
                case 1598177384:
                    return "5";
                case 1673542407:
                    return "11";
                case 1827871700:
                    return "24";
                case 1896402612:
                    return "48";
                case 1939875509:
                    return "8";
                case 1963391292:
                    return "33";
                case 2024508229:
                    return "52";
                case 2059544769:
                    return "23";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m19205a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1598:
                    if (str.equals("20")) {
                        z = true;
                        break;
                    }
                    break;
                case 1665:
                    if (str.equals("45")) {
                        z = true;
                        break;
                    }
                    break;
                case 1696:
                    if (str.equals("55")) {
                        z = false;
                        break;
                    }
                    break;
                case 1728:
                    if (str.equals("66")) {
                        z = true;
                        break;
                    }
                    break;
                case 1729:
                    if (str.equals("67")) {
                        z = true;
                        break;
                    }
                    break;
                case 1730:
                    if (str.equals("68")) {
                        z = true;
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

    /* compiled from: invitation_opened */
    public class AlbumListQueryString extends TypedGraphQlQueryString<AlbumListQueryModel> {
        public AlbumListQueryString() {
            super(AlbumListQueryModel.class, false, "AlbumListQuery", "4cc08269b9122a6bd242ea5f1f20a0d4", "node", "10154690955036729", RegularImmutableSet.a);
        }

        public final TriState m19209g() {
            return TriState.NO;
        }

        public final String m19207a(String str) {
            switch (str.hashCode()) {
                case -2111250185:
                    return "49";
                case -1966188374:
                    return "35";
                case -1849402738:
                    return "7";
                case -1780769805:
                    return "16";
                case -1778558196:
                    return "31";
                case -1773565470:
                    return "62";
                case -1745741354:
                    return "15";
                case -1718813234:
                    return "66";
                case -1663499699:
                    return "26";
                case -1547457328:
                    return "21";
                case -1460262781:
                    return "69";
                case -1397293948:
                    return "37";
                case -1392885889:
                    return "1";
                case -1362584798:
                    return "68";
                case -1284099636:
                    return "41";
                case -1150725321:
                    return "14";
                case -1116221284:
                    return "51";
                case -1109830290:
                    return "47";
                case -1101600581:
                    return "4";
                case -1012194872:
                    return "44";
                case -971327749:
                    return "57";
                case -969292942:
                    return "56";
                case -945993139:
                    return "42";
                case -817257615:
                    return "32";
                case -790388762:
                    return "36";
                case -680727674:
                    return "43";
                case -631654088:
                    return "10";
                case -561505403:
                    return "18";
                case -538773735:
                    return "30";
                case -461877888:
                    return "27";
                case -317710003:
                    return "29";
                case -113788560:
                    return "40";
                case -92787706:
                    return "12";
                case -16226492:
                    return "38";
                case 25209764:
                    return "6";
                case 41001321:
                    return "67";
                case 92734940:
                    return "2";
                case 97440432:
                    return "3";
                case 109250890:
                    return "65";
                case 169846802:
                    return "13";
                case 293932680:
                    return "59";
                case 297456968:
                    return "45";
                case 355809903:
                    return "54";
                case 421050507:
                    return "63";
                case 557908192:
                    return "28";
                case 580042479:
                    return "17";
                case 609122022:
                    return "9";
                case 613692368:
                    return "53";
                case 651215103:
                    return "19";
                case 656444234:
                    return "61";
                case 689802720:
                    return "22";
                case 774983793:
                    return "39";
                case 797640206:
                    return "34";
                case 810737919:
                    return "55";
                case 825224060:
                    return "46";
                case 899150587:
                    return "50";
                case 1006935441:
                    return "64";
                case 1091074225:
                    return "58";
                case 1108260124:
                    return "25";
                case 1139691781:
                    return "70";
                case 1420616515:
                    return "60";
                case 1585010628:
                    return "20";
                case 1598177384:
                    return "5";
                case 1673542407:
                    return "11";
                case 1827871700:
                    return "24";
                case 1896402612:
                    return "48";
                case 1939875509:
                    return "8";
                case 1963391292:
                    return "33";
                case 2024508229:
                    return "52";
                case 2059544769:
                    return "23";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m19208a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1598:
                    if (str.equals("20")) {
                        z = true;
                        break;
                    }
                    break;
                case 1665:
                    if (str.equals("45")) {
                        z = true;
                        break;
                    }
                    break;
                case 1696:
                    if (str.equals("55")) {
                        z = false;
                        break;
                    }
                    break;
                case 1728:
                    if (str.equals("66")) {
                        z = true;
                        break;
                    }
                    break;
                case 1729:
                    if (str.equals("67")) {
                        z = true;
                        break;
                    }
                    break;
                case 1730:
                    if (str.equals("68")) {
                        z = true;
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

    /* compiled from: invitation_opened */
    public class FBFamilyNonUserMemberAlbumsQueryString extends TypedGraphQlQueryString<FBFamilyNonUserMemberAlbumsQueryModel> {
        public FBFamilyNonUserMemberAlbumsQueryString() {
            super(FBFamilyNonUserMemberAlbumsQueryModel.class, false, "FBFamilyNonUserMemberAlbumsQuery", "8599a44f1bd5c81711e7abd182c4dc10", "user", "10154405445616729", RegularImmutableSet.a);
        }

        public final String m19210a(String str) {
            switch (str.hashCode()) {
                case -1773565470:
                    return "1";
                case -441951604:
                    return "0";
                case 169846802:
                    return "4";
                case 421050507:
                    return "2";
                case 1939875509:
                    return "3";
                default:
                    return str;
            }
        }
    }

    /* compiled from: invitation_opened */
    public class GroupAlbumListQueryString extends TypedGraphQlQueryString<GroupAlbumListQueryModel> {
        public GroupAlbumListQueryString() {
            super(GroupAlbumListQueryModel.class, false, "GroupAlbumListQuery", "5562d4ec01c3951dcd4483abed239ebc", "group", "10154690955096729", RegularImmutableSet.a);
        }

        public final TriState m19213g() {
            return TriState.NO;
        }

        public final String m19211a(String str) {
            switch (str.hashCode()) {
                case -2111250185:
                    return "49";
                case -1966188374:
                    return "35";
                case -1849402738:
                    return "7";
                case -1780769805:
                    return "16";
                case -1778558196:
                    return "31";
                case -1773565470:
                    return "62";
                case -1745741354:
                    return "15";
                case -1718813234:
                    return "66";
                case -1663499699:
                    return "26";
                case -1547457328:
                    return "21";
                case -1460262781:
                    return "69";
                case -1397293948:
                    return "37";
                case -1392885889:
                    return "1";
                case -1362584798:
                    return "68";
                case -1284099636:
                    return "41";
                case -1150725321:
                    return "14";
                case -1116221284:
                    return "51";
                case -1109830290:
                    return "47";
                case -1101600581:
                    return "4";
                case -1012194872:
                    return "44";
                case -971327749:
                    return "57";
                case -969292942:
                    return "56";
                case -945993139:
                    return "42";
                case -817257615:
                    return "32";
                case -790388762:
                    return "36";
                case -680727674:
                    return "43";
                case -631654088:
                    return "10";
                case -561505403:
                    return "18";
                case -538773735:
                    return "30";
                case -461877888:
                    return "27";
                case -317710003:
                    return "29";
                case -113788560:
                    return "40";
                case -92787706:
                    return "12";
                case -16226492:
                    return "38";
                case 25209764:
                    return "6";
                case 41001321:
                    return "67";
                case 92734940:
                    return "2";
                case 97440432:
                    return "3";
                case 109250890:
                    return "65";
                case 169846802:
                    return "13";
                case 293932680:
                    return "59";
                case 297456968:
                    return "45";
                case 355809903:
                    return "54";
                case 421050507:
                    return "63";
                case 557908192:
                    return "28";
                case 580042479:
                    return "17";
                case 609122022:
                    return "9";
                case 613692368:
                    return "53";
                case 651215103:
                    return "19";
                case 656444234:
                    return "61";
                case 689802720:
                    return "22";
                case 774983793:
                    return "39";
                case 797640206:
                    return "34";
                case 810737919:
                    return "55";
                case 825224060:
                    return "46";
                case 899150587:
                    return "50";
                case 1006935441:
                    return "64";
                case 1091074225:
                    return "58";
                case 1108260124:
                    return "25";
                case 1139691781:
                    return "70";
                case 1420616515:
                    return "60";
                case 1585010628:
                    return "20";
                case 1598177384:
                    return "5";
                case 1673542407:
                    return "11";
                case 1827871700:
                    return "24";
                case 1896402612:
                    return "48";
                case 1939875509:
                    return "8";
                case 1963391292:
                    return "33";
                case 2024508229:
                    return "52";
                case 2059544769:
                    return "23";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m19212a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1598:
                    if (str.equals("20")) {
                        z = true;
                        break;
                    }
                    break;
                case 1665:
                    if (str.equals("45")) {
                        z = true;
                        break;
                    }
                    break;
                case 1696:
                    if (str.equals("55")) {
                        z = false;
                        break;
                    }
                    break;
                case 1728:
                    if (str.equals("66")) {
                        z = true;
                        break;
                    }
                    break;
                case 1729:
                    if (str.equals("67")) {
                        z = true;
                        break;
                    }
                    break;
                case 1730:
                    if (str.equals("68")) {
                        z = true;
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
