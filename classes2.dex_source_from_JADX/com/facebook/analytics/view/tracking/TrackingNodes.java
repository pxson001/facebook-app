package com.facebook.analytics.view.tracking;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.debug.log.BLog;
import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: iorg_external_url */
public class TrackingNodes {
    private static final Class<TrackingNodes> f19460a = TrackingNodes.class;

    /* compiled from: iorg_external_url */
    public enum TrackingNode {
        HEADLINE(1, "headline", "internal"),
        USER_NAME(2, "user_name", "profile_user"),
        ACTOR_PHOTO(3, "actor_photo", "profile_user"),
        ACTION_LINKS(4, "action_links", "internal"),
        LIKE_LINK(5, "like_link", "action_like"),
        UNLIKE_LINK(6, "unlike_link", "action_unlike"),
        PARTICIPANT(7, "participant", "unknown"),
        PRONOUN(8, "pronoun", "unknown"),
        ROBOTEXT(9, "robotext", "internal"),
        TITLE(10, "title", "link"),
        MEDIA_GENERIC(11, "media_generic", "media_unknown"),
        PHOTO(12, "photo", "photo"),
        VIDEO(13, "video", "video"),
        MUSIC(14, "music", "music"),
        ATTACHMENT(15, "attachment", "internal"),
        NAME_LIST(16, "name_list", "internal"),
        SHARE_LINK(17, "share_link", "action_share"),
        USER_MESSAGE(18, "user_message", "internal"),
        SUBTITLE(19, "subtitle", "link"),
        DESCRIPTION(20, "description", "internal"),
        SOURCE(21, "source", "internal"),
        BLINGBOX(22, "blingbox", "navigation"),
        OTHER(23, "other", "unknown"),
        VIEW_ALL_COMMENTS(24, "view_all_comments", "navigation"),
        COMMENT(25, "comment", "internal"),
        COMMENT_LINK(26, "comment_link", "navigation"),
        SMALL_ACTOR_PHOTO(27, "small_actor_photo", "profile_user"),
        SUBSTORY(28, "substory", "internal"),
        XBUTTON(29, "xbutton", "navigation"),
        HIDE_LINK(30, "hide_link", "action_hide"),
        REPORT_SPAM_LINK(31, "report_spam_link", "action_report_spam"),
        HIDE_ALL_LINK(32, "hide_all_link", "action_hide_all"),
        BAD_AGGREGATION_LINK(33, "bad_aggregation_link", "action_bad_aggregation"),
        ADD_COMMENT_BOX(34, "add_comment_box", "action_comment"),
        APP_CALL_TO_ACTION(35, "app_call_to_action", "link"),
        UFI(36, "ufi", "internal"),
        OG_LEFT_SLIDE_PAGER(37, "og_left_slide_pager", "navigation"),
        OG_RIGHT_SLIDE_PAGER(38, "og_right_slide_pager", "navigation"),
        EXP_CALL_TO_ACTION(39, "exp_call_to_action", ""),
        LARGE_MEDIA_ATTACHMENT(40, "large_media_attachment", "link"),
        FAN_PAGE(42, "fan_page", "action_like"),
        UNFAN_PAGE(43, "unfan_page", "action_unlike"),
        SEE_MORE(44, "see_more", "navigation"),
        COLLECTION_ROBOTEXT_LINK(45, "collection_robotext_link", "profile_collections"),
        COLLECTION_ACTION_LINK(46, "collection_action_link", "profile_collections"),
        COLLECTION_TICKER_LINK(47, "collection_ticker_link", "profile_collections"),
        GIFT_LINK(48, "gift_link", "action_gift"),
        SPONSORED_LINK(49, "sponsored_link", "internal"),
        PAGE_LINK(50, "page_link", "profile_page"),
        SOCIAL_CONTEXT(51, "social_context", "profile_user"),
        SOCIAL_ACTOR_PHOTO(52, "social_actor_photo", "profile_user"),
        OFFERS_CLAIM(53, "offers_claim", "offers"),
        OFFERS_CLICK(54, "offers_click", "offers"),
        DROPDOWN_BUTTON(55, "dropdown_button", "action_show_options"),
        EVENT_VIEW(56, "event_view", "events"),
        EVENT_RSVP(57, "event_rsvp", "events"),
        ADS_SHIMMED_LINK(58, "", ""),
        COLLECTION_ADD_BUTTON(59, "collection_add_button", "profile_collections"),
        EVENT_INVITE_FRIENDS(60, "", ""),
        RHC_AD(61, "", ""),
        AD_CREATIVE_TITLE(62, "", ""),
        AD_CREATIVE_BODY(63, "", ""),
        AD_CREATIVE_IMAGE(64, "", ""),
        AD_SOCIAL_SENTENCE(65, "", ""),
        APP_NAME(66, "", ""),
        GROUP_JOIN(67, "", ""),
        PAGE_COVER_PHOTO(68, "", ""),
        PAGE_PROFILE_PIC(69, "", ""),
        AD_IDENTITY(70, "ad_identity", ""),
        UNHIDE_LINK(71, "", ""),
        TRENDING_TOPIC_LINK(72, "trending_topic_link", "topic"),
        RELATED_SHARE_ARTICLE(73, "related_share_article", "link"),
        OFFERS_USE_NOW(74, "offers_use_now", "offers"),
        RELATED_SHARE_VIDEO(75, "related_share_video", "video"),
        RHC_CARD(76, "", ""),
        RHC_CARD_HIDE(77, "", ""),
        RHC_SIMPLIFICATION(78, "", ""),
        RHC_SIMPLIFICATION_HIDE(79, "", ""),
        TOPIC_PIVOT_HEADER(80, "topic_pivot_header", "topic"),
        ADD_FRIEND_BUTTON(81, "add_friend_button", ""),
        SNOWLIFT(82, "snowlift", ""),
        SNOWLIFT_MESSAGE(83, "snowlift_message", ""),
        OFFERS_RESEND(84, "offers_resend", ""),
        RHC_LINK_OPEN(85, "", ""),
        GENERIC_CALL_TO_ACTION_BUTTON(86, "", ""),
        AD_LOGOUT(87, "", ""),
        RHC_PHOTO_SLIDER(88, "", ""),
        RHC_COMMENT_BUTTON(89, "", ""),
        HASHTAG(90, "", ""),
        NOTE(91, "", ""),
        RELATED_SHARE_ARTICLE_HIDE(92, "related_share_article_hide", ""),
        RELATED_SHARE_VIDEO_HIDE(93, "related_share_video_hide", ""),
        NEKO_PREVIEW(94, "", ""),
        OG_COMPOSER_OBJECT(95, "og_composer_object", ""),
        INSTALL_ACTION(96, "install_action", "install"),
        SPONSORED_CONTEXT(97, "sponsored_context", ""),
        DIGITAL_GOOD(98, "digital_good", "digital_good"),
        STORY_FOOTER(99, "story_footer", ""),
        STORY_LOCATION(100, "story_location", "location"),
        ADD_PHOTO_ACTION(101, "add_photo_action", "photo"),
        ACTION_ICON(102, "action_icon", "link"),
        EGO_FEED_UNIT(103, "ego_feed_unit", ""),
        PLACE_STAR_SURVEY(104, "place_star_survey", ""),
        REVIEW_MENU(105, "review_menu", ""),
        SAVE_ACTION(106, "save_action", "save"),
        PHOTO_GALLERY(107, "photo_gallery", "photo"),
        SUB_ATTACHMENT(108, "sub_attachment", ""),
        FEEDBACK_SECTION(109, "feedback_section", ""),
        ALBUM(110, "album", "album"),
        ALBUM_COLLAGE(111, "album_collage", "album"),
        AVATAR_LIST(112, "avatar_list", ""),
        STORY_LIST(113, "list", ""),
        MEDIA_CONTROLS(114, "media_controls", ""),
        ZERO_UPSELL_BUY(115, "zero_upsell_buy", ""),
        ZERO_UPSELL_FEED_UNIT(116, "zero_upsell_feed_unit", ""),
        RATING(117, "rating", ""),
        PERMALINK_COMMENT(118, "permalink_comment", ""),
        LIKE_COUNT(119, "like_count", ""),
        RETRY_BUTTON(120, "retry_button", ""),
        TIMELINE_GIFTS(121, "timeline_gifts", "gifts"),
        NEARBY_FRIENDS_LIST(122, "nearby_friends_list", "friends_list"),
        PRESENCE_UNIT(123, "presence_unit", ""),
        EVENT_INVITE_SENT(124, "", ""),
        COLLECTIONS_RATING(125, "collections_rating", ""),
        SAVE_BUTTON(126, "save_button", "profile_collections"),
        SAVED_COLLECTION(127, "saved_collection", ""),
        NATIVE_NAME(HTTPTransportCallback.BODY_BYTES_RECEIVED, "native_name", "profile_user"),
        RAW_NAME(129, "raw_name", "profile_user"),
        SEND(130, "send", ""),
        PLACE_MORE_INFO_ACTION(131, "place_more_info_action", ""),
        FEED_STORY_MESSAGE_FLYOUT(132, "feed_story_message_flyout", "flyout"),
        HEADER(133, "feed_story_header", "header"),
        PLACE_WRITE_REVIEW_ACTION(134, "place_write_review_action", "");
        
        private String mDestination;
        private String mName;
        private int mType;

        private TrackingNode(int i, String str, String str2) {
            this.mType = i;
            this.mName = str;
            this.mDestination = str2;
        }

        public final int getType() {
            return this.mType;
        }

        public final String getName() {
            return this.mName;
        }

        public final String getDestination() {
            return this.mDestination;
        }

        public static TrackingNode getTrackingNodeByType(int i) {
            for (TrackingNode trackingNode : values()) {
                if (trackingNode.mType == i) {
                    return trackingNode;
                }
            }
            return null;
        }
    }

    public static void m27141a(View view, TrackingNode trackingNode) {
        if (view == null) {
            BLog.a(f19460a, "View is null, can't set tracking node to view");
        } else if (trackingNode == null) {
            BLog.a(f19460a, "Tracking node is null, can't set tracking node to view");
        } else {
            view.setTag(2131558566, Integer.valueOf(trackingNode.getType()));
        }
    }

    public static TrackingNode m27140a(View view) {
        if (view == null) {
            return null;
        }
        Integer num = (Integer) view.getTag(2131558566);
        return num != null ? TrackingNode.getTrackingNodeByType(num.intValue()) : null;
    }

    public static SparseArray<Object> m27139a(TrackingNode trackingNode) {
        SparseArray<Object> sparseArray = new SparseArray(1);
        sparseArray.put(2131558566, Integer.valueOf(trackingNode.getType()));
        return sparseArray;
    }

    public static void m27142a(HoneyClientEvent honeyClientEvent, View view) {
        if (honeyClientEvent == null) {
            BLog.a(f19460a, "HoneyClientEvent is null, can't set tracking node to event");
        } else if (view == null) {
            BLog.a(f19460a, "View is null, can't set tracking node to event");
        } else {
            JsonNode b = m27145b(view);
            if (b != null && b.mo712e() > 0) {
                honeyClientEvent.m5085a("tn", b);
            }
        }
    }

    public static ArrayNode m27146b(TrackingNode trackingNode) {
        if (trackingNode == null) {
            BLog.a(f19460a, "Tracking node is null, can't convert to ArrayNode");
            return null;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        JsonNode arrayNode2 = new ArrayNode(JsonNodeFactory.f3121a);
        arrayNode2.m13390c(trackingNode.getType());
        arrayNode.m13381a(arrayNode2);
        return arrayNode;
    }

    public static void m27143a(HoneyClientEvent honeyClientEvent, @Nullable TrackingNode trackingNode) {
        if (honeyClientEvent == null) {
            BLog.a(f19460a, "HoneyClientEvent is null, can't set tracking node to event");
        } else if (trackingNode == null) {
            BLog.a(f19460a, "Tracking node is null, can't set tracking node to event");
        } else {
            honeyClientEvent.m5085a("tn", m27146b(trackingNode));
        }
    }

    public static boolean m27144a(HoneyClientEvent honeyClientEvent) {
        return honeyClientEvent != null ? honeyClientEvent.m5111b("tn") : false;
    }

    @VisibleForTesting
    private static ArrayNode m27145b(View view) {
        if (view == null) {
            BLog.a(f19460a, "Target View is null, can't traverse up view hierarchy");
            return null;
        }
        if (view.getTag(2131558566) == null) {
            BLog.a(f19460a, "View does not have a tracking node set, when it should. Perhaps view is not the view you were expecting. View is of type " + view.getClass());
        }
        List<IndexedTrackingNode> a = Lists.m1296a();
        ViewParent viewParent = view;
        do {
            View view2 = (View) viewParent;
            Integer num = (Integer) view2.getTag(2131558566);
            if (num != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof ViewGroup) {
                    int i = -1;
                    for (int i2 = 0; i2 < ((ViewGroup) parent).getChildCount(); i2++) {
                        View childAt = ((ViewGroup) parent).getChildAt(i2);
                        Integer num2 = (Integer) childAt.getTag(2131558566);
                        if (num2 != null && num2.equals(num)) {
                            i++;
                        }
                        if (view2.equals(childAt)) {
                            a.add(new IndexedTrackingNode(num, Integer.valueOf(i)));
                            break;
                        }
                    }
                } else {
                    a.add(new IndexedTrackingNode(num, null));
                }
            }
            viewParent = view2.getParent();
        } while (viewParent instanceof View);
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        for (IndexedTrackingNode indexedTrackingNode : a) {
            JsonNode arrayNode2 = new ArrayNode(JsonNodeFactory.f3121a);
            arrayNode2.m13385a(indexedTrackingNode.a);
            if (indexedTrackingNode.b != null) {
                arrayNode2.m13385a(indexedTrackingNode.b);
            }
            arrayNode.m13381a(arrayNode2);
        }
        return arrayNode;
    }
}
