package com.facebook.graphql.executor.cache;

import android.util.SparseArray;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventNotificationSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLEventTicketTierStatusEnum;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGroupJoinApprovalSetting;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostPermissionSetting;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: network_info_upload_bw_quality */
public class ConsistencyConfigImpl {
    @VisibleForTesting
    final SparseArray<String[]> f12474a = new SparseArray(47);

    /* compiled from: network_info_upload_bw_quality */
    public class LazyHolder {
        public static final ConsistencyConfigImpl f12473a = new ConsistencyConfigImpl();
    }

    ConsistencyConfigImpl() {
        this.f12474a.put(63093205, new String[]{"can_viewer_message", "friendship_status", "live_video_subscription_status", "secondary_subscribe_status", "subscribe_status", "video_channel_has_viewer_subscribed", "video_channel_is_viewer_following"});
        this.f12474a.put(2024260678, new String[]{"has_viewer_claimed"});
        this.f12474a.put(336198388, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(-768185132, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(67338874, new String[]{"event_declines.count", "event_invitees.count", "event_maybes.count", "event_members.count", "event_watchers.count", "is_canceled", "name", "time_range.end", "time_range.start", "time_range.timezone", "viewer_guest_status", "viewer_has_pending_invite", "viewer_notification_subscription_level", "viewer_watch_status"});
        this.f12474a.put(660855080, new String[]{"assigned_ticket_count", "available_inventory", "tier_status"});
        this.f12474a.put(218987185, new String[]{"is_favorited", "video_channel_is_viewer_pinned"});
        this.f12474a.put(-126857307, new String[]{"can_viewer_comment", "can_viewer_like", "comments.count", "does_viewer_like", "have_comments_been_disabled", "is_viewer_subscribed", "likers.count", "reactors.count", "reshares.count", "seen_by.count", "top_level_comments.count", "top_level_comments.total_count", "viewer_feedback_reaction_key"});
        this.f12474a.put(236555388, new String[]{"id", "members.count", "name"});
        this.f12474a.put(1700442483, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(-1526076857, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(422860284, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(69076575, new String[]{"can_viewer_claim_adminship", "description", "group_owner_authored_stories.available_for_sale_count", "group_owner_authored_stories.total_for_sale_count", "has_viewer_favorited", "join_approval_setting", "name", "post_permission_setting", "requires_admin_membership_approval", "requires_post_approval", "subscribe_status", "video_channel_has_viewer_subscribed", "video_channel_is_viewer_following", "viewer_join_state", "viewer_push_subscription_level", "viewer_subscription_level", "visibility"});
        this.f12474a.put(1257701471, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(-240759564, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(771298455, new String[]{"has_shared_info"});
        this.f12474a.put(925012209, new String[]{"has_shared_info"});
        this.f12474a.put(-1239871265, new String[]{"viewer_has_chosen", "vote_count"});
        this.f12474a.put(1251514188, new String[]{"actions_remaining"});
        this.f12474a.put(-876460794, new String[]{"messenger_inbox_item_clicks_remaining", "messenger_inbox_item_hides_remaining", "messenger_inbox_item_impressions_remaining"});
        this.f12474a.put(-876108937, new String[]{"messenger_inbox_unit_hides_remaining"});
        this.f12474a.put(2433570, new String[]{"event_members.count", "friendship_status", "is_sold", "locally_updated_containing_collection_id", "subscribe_status", "viewer_guest_status", "viewer_has_pending_invite", "viewer_join_state", "viewer_saved_state", "viewer_watch_status"});
        this.f12474a.put(-659919312, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(2479791, new String[]{"does_viewer_like", "events_calendar_subscriber_count", "events_calendar_subscription_status", "is_viewer_subscribed_to_messenger_content", "secondary_subscribe_status", "video_channel_has_viewer_subscribed", "video_channel_is_viewer_following"});
        this.f12474a.put(-1816160134, new String[]{"border_color", "color", "color_spec.border_color", "color_spec.color", "color_spec.fill_color", "fill_color"});
        this.f12474a.put(191986496, new String[]{"does_viewer_like"});
        this.f12474a.put(-563086408, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(-1889837793, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(-1396660317, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(-1746223584, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(-2066307870, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(77195495, new String[]{"address.full_address", "name", "viewer_saved_state"});
        this.f12474a.put(-1976808547, new String[]{"id"});
        this.f12474a.put(1355227529, new String[]{"does_viewer_like", "friendship_status", "secondary_subscribe_status", "subscribe_status", "viewer_guest_status", "viewer_has_pending_invite", "viewer_join_state", "viewer_watch_status"});
        this.f12474a.put(955873307, new String[]{"viewer_has_voted", "voters.count"});
        this.f12474a.put(1641611192, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(-1148667268, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(-1917069369, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(827365670, new String[]{"away_team_fan_count", "away_team_score", "home_team_fan_count", "home_team_score", "status_text", "viewer_can_vote_fan_favorite"});
        this.f12474a.put(80218325, new String[]{"local_group_did_approve", "local_group_did_ignore_report", "local_group_did_pin", "local_group_did_unpin", "local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height", "privacy_scope.type", "save_info.viewer_save_state", "seen_state"});
        this.f12474a.put(-818421799, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(1782386509, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(-1190325796, new String[]{"local_last_negative_feedback_action_type", "local_story_visibility", "local_story_visible_height"});
        this.f12474a.put(-154776335, new String[]{"locally_updated_containing_collection_id"});
        this.f12474a.put(-538844492, new String[]{"is_checked"});
        this.f12474a.put(2645995, new String[]{"can_viewer_message", "can_viewer_poke", "can_viewer_post", "friendship_status", "is_pymm_hidden", "secondary_subscribe_status", "subscribe_status", "username", "video_channel_has_viewer_subscribed", "video_channel_is_viewer_following"});
        this.f12474a.put(756114472, new String[]{"video_channel_has_viewer_subscribed", "video_channel_is_viewer_following", "video_channel_is_viewer_pinned"});
    }

    public final String[] m18545a(int i) {
        return (String[]) this.f12474a.get(i);
    }

    public final String m18546b(int i) {
        switch (i) {
            case 0:
            case 182:
                return "can_viewer_message";
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case 91:
            case 137:
            case 185:
                return "friendship_status";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "live_video_subscription_status";
            case 3:
            case 107:
            case 138:
            case 187:
                return "secondary_subscribe_status";
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 68:
            case 94:
            case 139:
            case 188:
                return "subscribe_status";
            case 5:
            case 69:
            case 108:
            case 190:
            case 192:
                return "video_channel_has_viewer_subscribed";
            case 6:
            case 70:
            case 109:
            case 191:
            case 193:
                return "video_channel_is_viewer_following";
            case 7:
                return "has_viewer_claimed";
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
            case 11:
            case 49:
            case 52:
            case 55:
            case 75:
            case 78:
            case 100:
            case 117:
            case 120:
            case 123:
            case 126:
            case 129:
            case 146:
            case 149:
            case 152:
            case 165:
            case 171:
            case 174:
            case 177:
                return "local_last_negative_feedback_action_type";
            case 9:
            case 12:
            case 50:
            case 53:
            case 56:
            case 76:
            case 79:
            case 101:
            case 118:
            case 121:
            case 124:
            case 127:
            case 130:
            case 147:
            case 150:
            case 153:
            case 166:
            case 172:
            case 175:
            case 178:
                return "local_story_visibility";
            case 10:
            case 13:
            case 51:
            case 54:
            case 57:
            case 77:
            case 80:
            case 102:
            case 119:
            case 122:
            case 125:
            case HTTPTransportCallback.BODY_BYTES_RECEIVED /*128*/:
            case 131:
            case 148:
            case 151:
            case 154:
            case 167:
            case 173:
            case 176:
            case 179:
                return "local_story_visible_height";
            case 14:
                return "event_declines.count";
            case 15:
                return "event_invitees.count";
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return "event_maybes.count";
            case 17:
            case 90:
                return "event_members.count";
            case 18:
                return "event_watchers.count";
            case 19:
                return "is_canceled";
            case 20:
            case 48:
            case HTTPTransportCallback.BODY_BYTES_GENERATED /*64*/:
            case 133:
                return "name";
            case 21:
                return "time_range.end";
            case 22:
                return "time_range.start";
            case 23:
                return "time_range.timezone";
            case 24:
            case 95:
            case 140:
                return "viewer_guest_status";
            case 25:
            case 96:
            case 141:
                return "viewer_has_pending_invite";
            case 26:
                return "viewer_notification_subscription_level";
            case 27:
            case 99:
            case 143:
                return "viewer_watch_status";
            case 28:
                return "assigned_ticket_count";
            case 29:
                return "available_inventory";
            case 30:
                return "tier_status";
            case 31:
                return "is_favorited";
            case HTTPTransportCallback.HEADER_BYTES_RECEIVED /*32*/:
            case 194:
                return "video_channel_is_viewer_pinned";
            case 33:
                return "can_viewer_comment";
            case 34:
                return "can_viewer_like";
            case 35:
                return "comments.count";
            case 36:
            case 103:
            case 116:
            case 136:
                return "does_viewer_like";
            case 37:
                return "have_comments_been_disabled";
            case 38:
                return "is_viewer_subscribed";
            case 39:
                return "likers.count";
            case 40:
                return "reactors.count";
            case 41:
                return "reshares.count";
            case 42:
                return "seen_by.count";
            case 43:
                return "top_level_comments.count";
            case 44:
                return "top_level_comments.total_count";
            case 45:
                return "viewer_feedback_reaction_key";
            case 46:
            case 135:
                return "id";
            case 47:
                return "members.count";
            case 58:
                return "can_viewer_claim_adminship";
            case 59:
                return "description";
            case 60:
                return "group_owner_authored_stories.available_for_sale_count";
            case 61:
                return "group_owner_authored_stories.total_for_sale_count";
            case 62:
                return "has_viewer_favorited";
            case 63:
                return "join_approval_setting";
            case 65:
                return "post_permission_setting";
            case 66:
                return "requires_admin_membership_approval";
            case 67:
                return "requires_post_approval";
            case 71:
            case 97:
            case 142:
                return "viewer_join_state";
            case 72:
                return "viewer_push_subscription_level";
            case 73:
                return "viewer_subscription_level";
            case 74:
                return "visibility";
            case 81:
            case 82:
                return "has_shared_info";
            case 83:
                return "viewer_has_chosen";
            case 84:
                return "vote_count";
            case 85:
                return "actions_remaining";
            case 86:
                return "messenger_inbox_item_clicks_remaining";
            case 87:
                return "messenger_inbox_item_hides_remaining";
            case 88:
                return "messenger_inbox_item_impressions_remaining";
            case 89:
                return "messenger_inbox_unit_hides_remaining";
            case 92:
                return "is_sold";
            case 93:
            case 180:
                return "locally_updated_containing_collection_id";
            case 98:
            case 134:
                return "viewer_saved_state";
            case 104:
                return "events_calendar_subscriber_count";
            case 105:
                return "events_calendar_subscription_status";
            case 106:
                return "is_viewer_subscribed_to_messenger_content";
            case 110:
                return "border_color";
            case 111:
                return "color";
            case 112:
                return "color_spec.border_color";
            case 113:
                return "color_spec.color";
            case 114:
                return "color_spec.fill_color";
            case 115:
                return "fill_color";
            case 132:
                return "address.full_address";
            case 144:
                return "viewer_has_voted";
            case 145:
                return "voters.count";
            case 155:
                return "away_team_fan_count";
            case 156:
                return "away_team_score";
            case 157:
                return "home_team_fan_count";
            case 158:
                return "home_team_score";
            case 159:
                return "status_text";
            case 160:
                return "viewer_can_vote_fan_favorite";
            case 161:
                return "local_group_did_approve";
            case 162:
                return "local_group_did_ignore_report";
            case 163:
                return "local_group_did_pin";
            case 164:
                return "local_group_did_unpin";
            case 168:
                return "privacy_scope.type";
            case 169:
                return "save_info.viewer_save_state";
            case 170:
                return "seen_state";
            case 181:
                return "is_checked";
            case 183:
                return "can_viewer_poke";
            case 184:
                return "can_viewer_post";
            case 186:
                return "is_pymm_hidden";
            case 189:
                return "username";
            default:
                throw new IllegalArgumentException();
        }
    }

    public final Class m18547c(int i) {
        switch (i) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 19:
            case 25:
            case 31:
            case HTTPTransportCallback.HEADER_BYTES_RECEIVED /*32*/:
            case 33:
            case 34:
            case 36:
            case 37:
            case 38:
            case 58:
            case 62:
            case 66:
            case 67:
            case 69:
            case 70:
            case 81:
            case 82:
            case 83:
            case 92:
            case 96:
            case 103:
            case 106:
            case 108:
            case 109:
            case 116:
            case 136:
            case 141:
            case 144:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 181:
            case 182:
            case 183:
            case 184:
            case 186:
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
                return Boolean.class;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case 91:
            case 137:
            case 185:
                return GraphQLFriendshipStatus.class;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return GraphQLLiveVideoSubscriptionStatus.class;
            case 3:
            case 107:
            case 138:
            case 187:
                return GraphQLSecondarySubscribeStatus.class;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 68:
            case 94:
            case 139:
            case 188:
                return GraphQLSubscribeStatus.class;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
            case 9:
            case 11:
            case 12:
            case 20:
            case 21:
            case 22:
            case 23:
            case 46:
            case 48:
            case 49:
            case 50:
            case 52:
            case 53:
            case 55:
            case 56:
            case 59:
            case HTTPTransportCallback.BODY_BYTES_GENERATED /*64*/:
            case 75:
            case 76:
            case 78:
            case 79:
            case 93:
            case 100:
            case 101:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 117:
            case 118:
            case 120:
            case 121:
            case 123:
            case 124:
            case 126:
            case 127:
            case 129:
            case 130:
            case 132:
            case 133:
            case 135:
            case 146:
            case 147:
            case 149:
            case 150:
            case 152:
            case 153:
            case 159:
            case 165:
            case 166:
            case 168:
            case 171:
            case 172:
            case 174:
            case 175:
            case 177:
            case 178:
            case 180:
            case 189:
                return String.class;
            case 10:
            case 13:
            case 14:
            case 15:
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
            case 17:
            case 18:
            case 28:
            case 29:
            case 35:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 51:
            case 54:
            case 57:
            case 60:
            case 61:
            case 77:
            case 80:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 102:
            case 104:
            case 119:
            case 122:
            case 125:
            case HTTPTransportCallback.BODY_BYTES_RECEIVED /*128*/:
            case 131:
            case 145:
            case 148:
            case 151:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 167:
            case 173:
            case 176:
            case 179:
                return Integer.class;
            case 24:
            case 95:
            case 140:
                return GraphQLEventGuestStatus.class;
            case 26:
                return GraphQLEventNotificationSubscriptionLevel.class;
            case 27:
            case 99:
            case 143:
                return GraphQLEventWatchStatus.class;
            case 30:
                return GraphQLEventTicketTierStatusEnum.class;
            case 63:
                return GraphQLGroupJoinApprovalSetting.class;
            case 65:
                return GraphQLGroupPostPermissionSetting.class;
            case 71:
            case 97:
            case 142:
                return GraphQLGroupJoinState.class;
            case 72:
                return GraphQLGroupPushSubscriptionLevel.class;
            case 73:
                return GraphQLGroupSubscriptionLevel.class;
            case 74:
                return GraphQLGroupVisibility.class;
            case 98:
            case 134:
            case 169:
                return GraphQLSavedState.class;
            case 105:
                return GraphQLEventsCalendarSubscriptionStatus.class;
            case 170:
                return GraphQLStorySeenState.class;
            default:
                throw new IllegalArgumentException();
        }
    }
}
