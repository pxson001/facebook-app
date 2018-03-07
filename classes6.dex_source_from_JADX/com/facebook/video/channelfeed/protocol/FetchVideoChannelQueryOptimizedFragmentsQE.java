package com.facebook.video.channelfeed.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEModels.ChannelFeedVideoChannelFragmentQEModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEModels.FetchVideoChannelByVideoQueryQEModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEModels.FetchVideosByVideoChannelQueryQEModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: contacts_iterator */
public final class FetchVideoChannelQueryOptimizedFragmentsQE {

    /* compiled from: contacts_iterator */
    public class FetchVideoChannelByIdQueryQEString extends TypedGraphQlQueryString<ChannelFeedVideoChannelFragmentQEModel> {
        public FetchVideoChannelByIdQueryQEString() {
            super(ChannelFeedVideoChannelFragmentQEModel.class, false, "FetchVideoChannelByIdQueryQE", "4a4b3f7bd0f6b86f981159d095825e03", "node", "10154661259646729", RegularImmutableSet.a);
        }

        public final TriState m27229g() {
            return TriState.NO;
        }

        public final String m27227a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "12";
                case -1745741354:
                    return "14";
                case -1663499699:
                    return "10";
                case -1651445858:
                    return "27";
                case -1469598440:
                    return "7";
                case -1460262781:
                    return "24";
                case -1367775349:
                    return "2";
                case -1362584798:
                    return "17";
                case -1150725321:
                    return "13";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "28";
                case -1012194872:
                    return "29";
                case -799736697:
                    return "25";
                case -631654088:
                    return "31";
                case -583480166:
                    return "5";
                case -561505403:
                    return "21";
                case -493674687:
                    return "26";
                case -461877888:
                    return "11";
                case -317710003:
                    return "16";
                case -19268531:
                    return "30";
                case 92734940:
                    return "4";
                case 109250890:
                    return "18";
                case 169846802:
                    return "9";
                case 447915951:
                    return "19";
                case 557908192:
                    return "15";
                case 580042479:
                    return "20";
                case 651215103:
                    return "22";
                case 689802720:
                    return "6";
                case 1139691781:
                    return "23";
                case 1281255451:
                    return "0";
                case 1844973604:
                    return "3";
                case 1939875509:
                    return "8";
                default:
                    return str;
            }
        }

        protected final boolean m27228a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 55:
                    if (str.equals("7")) {
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
                case 1601:
                    if (str.equals("23")) {
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
                case 1605:
                    if (str.equals("27")) {
                        z = false;
                        break;
                    }
                    break;
                case 1606:
                    if (str.equals("28")) {
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
                case 1629:
                    if (str.equals("30")) {
                        z = true;
                        break;
                    }
                    break;
                case 1630:
                    if (str.equals("31")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "video_channel".equals(obj);
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
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: contacts_iterator */
    public class FetchVideoChannelByVideoQueryQEString extends TypedGraphQlQueryString<FetchVideoChannelByVideoQueryQEModel> {
        public FetchVideoChannelByVideoQueryQEString() {
            super(FetchVideoChannelByVideoQueryQEModel.class, false, "FetchVideoChannelByVideoQueryQE", "402445e1a9dc9f5314d4a765a9540c92", "video", "10154661259641729", RegularImmutableSet.a);
        }

        public final TriState m27232g() {
            return TriState.NO;
        }

        public final String m27230a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "13";
                case -1745741354:
                    return "15";
                case -1663499699:
                    return "11";
                case -1651445858:
                    return "27";
                case -1469598440:
                    return "8";
                case -1460262781:
                    return "1";
                case -1367775349:
                    return "3";
                case -1362584798:
                    return "18";
                case -1150725321:
                    return "14";
                case -1101600581:
                    return "2";
                case -1091844130:
                    return "28";
                case -1012194872:
                    return "29";
                case -799736697:
                    return "25";
                case -631654088:
                    return "31";
                case -583480166:
                    return "6";
                case -561505403:
                    return "22";
                case -493674687:
                    return "26";
                case -461877888:
                    return "12";
                case -317710003:
                    return "17";
                case -19268531:
                    return "30";
                case 92734940:
                    return "5";
                case 109250890:
                    return "19";
                case 169846802:
                    return "10";
                case 447915951:
                    return "20";
                case 557908192:
                    return "16";
                case 580042479:
                    return "21";
                case 651215103:
                    return "23";
                case 689802720:
                    return "7";
                case 1139691781:
                    return "24";
                case 1151387487:
                    return "0";
                case 1844973604:
                    return "4";
                case 1939875509:
                    return "9";
                default:
                    return str;
            }
        }

        protected final boolean m27231a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 56:
                    if (str.equals("8")) {
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
                case 1604:
                    if (str.equals("26")) {
                        z = true;
                        break;
                    }
                    break;
                case 1605:
                    if (str.equals("27")) {
                        z = false;
                        break;
                    }
                    break;
                case 1606:
                    if (str.equals("28")) {
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
                case 1629:
                    if (str.equals("30")) {
                        z = true;
                        break;
                    }
                    break;
                case 1630:
                    if (str.equals("31")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "video_channel".equals(obj);
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
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: contacts_iterator */
    public class FetchVideosByVideoChannelQueryQEString extends TypedGraphQlQueryString<FetchVideosByVideoChannelQueryQEModel> {
        public FetchVideosByVideoChannelQueryQEString() {
            super(FetchVideosByVideoChannelQueryQEModel.class, false, "FetchVideosByVideoChannelQueryQE", "4ddf6f3d9ba97a76256e36f17cdada62", "node", "10154661259656729", RegularImmutableSet.a);
        }

        public final TriState m27235g() {
            return TriState.NO;
        }

        public final String m27233a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "12";
                case -1745741354:
                    return "14";
                case -1663499699:
                    return "10";
                case -1651445858:
                    return "27";
                case -1469598440:
                    return "7";
                case -1460262781:
                    return "24";
                case -1367775349:
                    return "1";
                case -1362584798:
                    return "17";
                case -1150725321:
                    return "13";
                case -1101600581:
                    return "5";
                case -1091844130:
                    return "28";
                case -1012194872:
                    return "29";
                case -799736697:
                    return "25";
                case -631654088:
                    return "31";
                case -583480166:
                    return "4";
                case -561505403:
                    return "21";
                case -493674687:
                    return "26";
                case -461877888:
                    return "11";
                case -317710003:
                    return "16";
                case -19268531:
                    return "30";
                case 92734940:
                    return "3";
                case 109250890:
                    return "18";
                case 169846802:
                    return "9";
                case 447915951:
                    return "19";
                case 557908192:
                    return "15";
                case 580042479:
                    return "20";
                case 651215103:
                    return "22";
                case 689802720:
                    return "6";
                case 1139691781:
                    return "23";
                case 1281255451:
                    return "0";
                case 1844973604:
                    return "2";
                case 1939875509:
                    return "8";
                default:
                    return str;
            }
        }

        protected final boolean m27234a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 55:
                    if (str.equals("7")) {
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
                case 1601:
                    if (str.equals("23")) {
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
                case 1605:
                    if (str.equals("27")) {
                        z = false;
                        break;
                    }
                    break;
                case 1606:
                    if (str.equals("28")) {
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
                case 1629:
                    if (str.equals("30")) {
                        z = true;
                        break;
                    }
                    break;
                case 1630:
                    if (str.equals("31")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "video_channel".equals(obj);
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
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }
}
