package com.facebook.facecastdisplay.protocol;

import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveSubscriptionQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoAnnouncementsQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoInvitedFriendsModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoNewestCommentsHeadQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoNewestCommentsInitialQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoNewestCommentsNeckQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoRecentInviteesModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoVODBackfillCommentsQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoVODCommentsQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveBlingBarFeedbackQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveNotableLikedCommentsQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoTopLevelCommentsSubscriptionModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoViewersQueryModel;
import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: stickers_in_composer_sticker_params */
public final class FetchLiveVideoEventsQuery {

    /* compiled from: stickers_in_composer_sticker_params */
    public class FetchLiveSubscriptionQueryString extends TypedGraphQlQueryString<FetchLiveSubscriptionQueryModel> {
        public FetchLiveSubscriptionQueryString() {
            super(FetchLiveSubscriptionQueryModel.class, false, "FetchLiveSubscriptionQuery", "4e2e97fb950e6bc7ba563843e748d9c3", "video", "10154439146051729", RegularImmutableSet.a);
        }

        public final String m3474a(String str) {
            switch (str.hashCode()) {
                case -441951636:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: stickers_in_composer_sticker_params */
    public class FetchLiveVideoAnnouncementsQueryString extends TypedGraphQlQueryString<FetchLiveVideoAnnouncementsQueryModel> {
        public FetchLiveVideoAnnouncementsQueryString() {
            super(FetchLiveVideoAnnouncementsQueryModel.class, false, "FetchLiveVideoAnnouncementsQuery", "157da14b94f6724ad1eab88778c3c9e9", "video", "10154583422836729", RegularImmutableSet.a);
        }

        public final String m3475a(String str) {
            switch (str.hashCode()) {
                case -441951636:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: stickers_in_composer_sticker_params */
    public class FetchLiveVideoInvitedFriendsString extends TypedGraphQlQueryString<FetchLiveVideoInvitedFriendsModel> {
        public FetchLiveVideoInvitedFriendsString() {
            super(FetchLiveVideoInvitedFriendsModel.class, false, "FetchLiveVideoInvitedFriends", "e9d5f6a79927b9b531402a412e940f33", "video", "10154641143581729", RegularImmutableSet.a);
        }

        public final String m3476a(String str) {
            switch (str.hashCode()) {
                case -441951636:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: stickers_in_composer_sticker_params */
    public class FetchLiveVideoNewestCommentsHeadQueryString extends TypedGraphQlQueryString<FetchLiveVideoNewestCommentsHeadQueryModel> {
        public FetchLiveVideoNewestCommentsHeadQueryString() {
            super(FetchLiveVideoNewestCommentsHeadQueryModel.class, false, "FetchLiveVideoNewestCommentsHeadQuery", "377dc3e97ab5c8516d549ecf3d203b56", "video", "10154512999156729", RegularImmutableSet.a);
        }

        public final String m3477a(String str) {
            switch (str.hashCode()) {
                case -1349119146:
                    return "3";
                case -1101600581:
                    return "1";
                case -441951636:
                    return "0";
                case 94851343:
                    return "4";
                case 1775589985:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m3478a(String str, Object obj) {
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

    /* compiled from: stickers_in_composer_sticker_params */
    public class FetchLiveVideoNewestCommentsInitialQueryString extends TypedGraphQlQueryString<FetchLiveVideoNewestCommentsInitialQueryModel> {
        public FetchLiveVideoNewestCommentsInitialQueryString() {
            super(FetchLiveVideoNewestCommentsInitialQueryModel.class, false, "FetchLiveVideoNewestCommentsInitialQuery", "358f44b01e30b39efa0f1a260612c85c", "video", "10154512999161729", RegularImmutableSet.a);
        }

        public final String m3479a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case -441951636:
                    return "0";
                case 94851343:
                    return "3";
                case 1775589985:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m3480a(String str, Object obj) {
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

    /* compiled from: stickers_in_composer_sticker_params */
    public class FetchLiveVideoNewestCommentsNeckQueryString extends TypedGraphQlQueryString<FetchLiveVideoNewestCommentsNeckQueryModel> {
        public FetchLiveVideoNewestCommentsNeckQueryString() {
            super(FetchLiveVideoNewestCommentsNeckQueryModel.class, false, "FetchLiveVideoNewestCommentsNeckQuery", "41c13428aef02271046d34adfd952f44", "video", "10154512999191729", RegularImmutableSet.a);
        }

        public final String m3481a(String str) {
            switch (str.hashCode()) {
                case -1349119146:
                    return "3";
                case -1101600581:
                    return "1";
                case -441951636:
                    return "0";
                case 94851343:
                    return "4";
                case 1775589985:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m3482a(String str, Object obj) {
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

    /* compiled from: stickers_in_composer_sticker_params */
    public class FetchLiveVideoRecentInviteesString extends TypedGraphQlQueryString<FetchLiveVideoRecentInviteesModel> {
        public FetchLiveVideoRecentInviteesString() {
            super(FetchLiveVideoRecentInviteesModel.class, false, "FetchLiveVideoRecentInvitees", "9ed78ca541d8cc638e50bf22efae8552", "user", "10154658499266729", RegularImmutableSet.a);
        }

        public final String m3483a(String str) {
            switch (str.hashCode()) {
                case -1492215412:
                    return "1";
                case -836030938:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: stickers_in_composer_sticker_params */
    public class FetchLiveVideoVODBackfillCommentsQueryString extends TypedGraphQlQueryString<FetchLiveVideoVODBackfillCommentsQueryModel> {
        public FetchLiveVideoVODBackfillCommentsQueryString() {
            super(FetchLiveVideoVODBackfillCommentsQueryModel.class, false, "FetchLiveVideoVODBackfillCommentsQuery", "5bccbbc2c9979f94222920e924c61b90", "video", "10154595532081729", RegularImmutableSet.a);
        }

        public final String m3484a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case -441951636:
                    return "0";
                case 94851343:
                    return "5";
                case 209080406:
                    return "4";
                case 525895283:
                    return "3";
                case 1775589985:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m3485a(String str, Object obj) {
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

    /* compiled from: stickers_in_composer_sticker_params */
    public class FetchLiveVideoVODCommentsQueryString extends TypedGraphQlQueryString<FetchLiveVideoVODCommentsQueryModel> {
        public FetchLiveVideoVODCommentsQueryString() {
            super(FetchLiveVideoVODCommentsQueryModel.class, false, "FetchLiveVideoVODCommentsQuery", "cf9dfdfb89b551be6a9138fc4e1e51ae", "video", "10154595532046729", RegularImmutableSet.a);
        }

        public final String m3486a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case -441951636:
                    return "0";
                case 94851343:
                    return "5";
                case 209080406:
                    return "4";
                case 525895283:
                    return "3";
                case 1775589985:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m3487a(String str, Object obj) {
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

    /* compiled from: stickers_in_composer_sticker_params */
    public class LiveBlingBarFeedbackQueryString extends TypedGraphQlQueryString<LiveBlingBarFeedbackQueryModel> {
        public LiveBlingBarFeedbackQueryString() {
            super(LiveBlingBarFeedbackQueryModel.class, false, "LiveBlingBarFeedbackQuery", "d6fdfb377f736f73aeb2a608ca2501c7", "video", "10154633955641729", RegularImmutableSet.a);
        }

        public final String m3488a(String str) {
            switch (str.hashCode()) {
                case -441951636:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: stickers_in_composer_sticker_params */
    public class LiveNotableLikedCommentsQueryString extends TypedGraphQlQueryString<LiveNotableLikedCommentsQueryModel> {
        public LiveNotableLikedCommentsQueryString() {
            super(LiveNotableLikedCommentsQueryModel.class, false, "LiveNotableLikedCommentsQuery", "1d0aa808f8af8f6cd8c89e6879059730", "video", "10154512999181729", RegularImmutableSet.a);
        }

        public final String m3489a(String str) {
            switch (str.hashCode()) {
                case -441951636:
                    return "0";
                case 94851343:
                    return "3";
                case 209080406:
                    return "2";
                case 525895283:
                    return "1";
                case 1775589985:
                    return "4";
                default:
                    return str;
            }
        }

        protected final boolean m3490a(String str, Object obj) {
            Object obj2 = -1;
            switch (str.hashCode()) {
                case 52:
                    if (str.equals("4")) {
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

    /* compiled from: stickers_in_composer_sticker_params */
    public class LiveVideoTopLevelCommentsSubscriptionString extends TypedGraphQLSubscriptionString<LiveVideoTopLevelCommentsSubscriptionModel> {
        public LiveVideoTopLevelCommentsSubscriptionString() {
            super(LiveVideoTopLevelCommentsSubscriptionModel.class, false, "LiveVideoTopLevelCommentsSubscription", "7d94a40cbbbe88a332dc337480428890", "live_video_comment_create_subscribe", "0", "10154573248246729", RegularImmutableSet.a);
        }

        public final String m3491a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                case 1775589985:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: stickers_in_composer_sticker_params */
    public class LiveVideoViewersQueryString extends TypedGraphQlQueryString<LiveVideoViewersQueryModel> {
        public LiveVideoViewersQueryString() {
            super(LiveVideoViewersQueryModel.class, false, "LiveVideoViewersQuery", "7c2201495fef75056b86d839ba16d153", "video", "10154563510796729", RegularImmutableSet.a);
        }

        public final String m3492a(String str) {
            switch (str.hashCode()) {
                case -441951636:
                    return "0";
                case 102976443:
                    return "3";
                case 209080406:
                    return "2";
                case 525895283:
                    return "1";
                default:
                    return str;
            }
        }
    }

    public static final LiveVideoViewersQueryString m3493f() {
        return new LiveVideoViewersQueryString();
    }

    public static final FetchLiveSubscriptionQueryString m3494g() {
        return new FetchLiveSubscriptionQueryString();
    }

    public static final LiveNotableLikedCommentsQueryString m3495h() {
        return new LiveNotableLikedCommentsQueryString();
    }

    public static final FetchLiveVideoAnnouncementsQueryString m3496j() {
        return new FetchLiveVideoAnnouncementsQueryString();
    }

    public static final LiveVideoTopLevelCommentsSubscriptionString m3497m() {
        return new LiveVideoTopLevelCommentsSubscriptionString();
    }
}
