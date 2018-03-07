package com.facebook.graphql.enums;

import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: newInstance */
public enum GraphQLNegativeFeedbackActionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    AD_ALREADY_OWNED,
    APP_SUPPORT_REDIRECT,
    BAN_USER,
    BLOCK_ACTOR,
    BLOCK_APP,
    BLOCK_MESSAGES,
    BLOCK_PAGE,
    DELETE,
    EDIT,
    HACKED_NOTIFY,
    HELP_CENTER,
    HIDE_ADVERTISER,
    HIDE_AD,
    HIDE_TOPIC_MISCLASSIFICATION,
    HIDE_RESEARCH_POLLS,
    HIDE_APP,
    LEAVE_GROUP,
    LIMIT_FRIENDING_PRIVACY,
    MARK_AS_SPAM,
    MARK_AS_OBJECTIONABLE,
    MARK_MESSAGE_THREAD_AS_SPAM,
    MESSAGE,
    PHONE_FRIEND,
    CONTACT_FORM,
    CLOSE_OLD_PROFILE,
    RECOVER_PROFILE,
    REDIRECT,
    REDIRECT_ADS_PREFERENCES,
    REMOVE_ADS_INTEREST,
    REPORT_CONTENT,
    REPORT_TO_GROUP_ADMIN,
    REPORT_WORK_CONTENT,
    REPORT_CONTENT_EDUCATION,
    REPORT_IP_VIOLATION,
    REPORT_AD_IP_VIOLATION,
    RESOLVE_PROBLEM,
    SPAM_CLEANUP_CHECKPOINT,
    UNFOLLOW_FRIEND_LIST,
    UNFRIEND,
    UNLIKE,
    UNSUBSCRIBE,
    UNSUBSCRIBE_DIRECTED_TARGET,
    UNSUBSCRIBE_RESHARER,
    UNSUBSCRIBE_OWNER,
    UNSUBSCRIBE_ATTACHED_STORY_ACTOR,
    UNTAG,
    HIDE,
    HIDE_FROM_TIMELINE,
    DONT_LIKE,
    UNSUBSCRIBE_PAGE,
    HEAD_PUBLISHER_APP_MENTIONS_BAN,
    HEAD_PUBLISHER_APP_MENTIONS_HIDE,
    HIDE_TOPIC,
    LESS_FROM_ACTOR,
    LESS_FROM_DIRECTED_TARGET,
    LESS_FROM_ATTACHED_STORY_ACTOR,
    LESS_FROM_DOMAIN,
    LESS_FROM_APP,
    NEWSFEED_SETTINGS,
    AWESOMIZER_UNFOLLOW_CARD,
    AWESOMIZER_REFOLLOW_CARD,
    WRITE_IN,
    IGNORE_EVENT_INVITES,
    REMOVE_EVENT,
    APP_INVITE_BLOCK_APP,
    APP_INVITE_BLOCK_USER,
    LESS_FROM_THROWBACK,
    THROWBACK_PREFERENCES,
    EMPLOYEE_BUG_REPORTING,
    HIDE_FEED_TOPIC,
    PAGES_LIKE_CHECKUP,
    SAVE,
    VOTING_REMINDER_OPT_OUT,
    VIDEO_CHANNEL_FOLLOW,
    VIDEO_CHANNEL_SUBSCRIBE,
    DIRECT_SUPPORT,
    UNTAG_SPONSOR_PAGE,
    LESS_FROM_UPSETTING_CONCEPT,
    DELETE_AND_BLOCK;

    public static GraphQLNegativeFeedbackActionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 63) {
            case 0:
                if (str.equalsIgnoreCase("HIDE_APP")) {
                    return HIDE_APP;
                }
                if (str.equalsIgnoreCase("UNSUBSCRIBE_PAGE")) {
                    return UNSUBSCRIBE_PAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (str.equalsIgnoreCase("APP_SUPPORT_REDIRECT")) {
                    return APP_SUPPORT_REDIRECT;
                }
                if (str.equalsIgnoreCase("HELP_CENTER")) {
                    return HELP_CENTER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (str.equalsIgnoreCase("UNTAG_SPONSOR_PAGE")) {
                    return UNTAG_SPONSOR_PAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("HEAD_PUBLISHER_APP_MENTIONS_HIDE")) {
                    return HEAD_PUBLISHER_APP_MENTIONS_HIDE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                if (str.equalsIgnoreCase("APP_INVITE_BLOCK_USER")) {
                    return APP_INVITE_BLOCK_USER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("HIDE_ADVERTISER")) {
                    return HIDE_ADVERTISER;
                }
                if (str.equalsIgnoreCase("APP_INVITE_BLOCK_APP")) {
                    return APP_INVITE_BLOCK_APP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 6:
                if (str.equalsIgnoreCase("REDIRECT")) {
                    return REDIRECT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("LEAVE_GROUP")) {
                    return LEAVE_GROUP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                if (str.equalsIgnoreCase("VIDEO_CHANNEL_SUBSCRIBE")) {
                    return VIDEO_CHANNEL_SUBSCRIBE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("LESS_FROM_ACTOR")) {
                    return LESS_FROM_ACTOR;
                }
                if (str.equalsIgnoreCase("LESS_FROM_APP")) {
                    return LESS_FROM_APP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 10:
                if (str.equalsIgnoreCase("REMOVE_EVENT")) {
                    return REMOVE_EVENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 11:
                if (str.equalsIgnoreCase("HIDE_AD")) {
                    return HIDE_AD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("REPORT_CONTENT")) {
                    return REPORT_CONTENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 13:
                if (str.equalsIgnoreCase("AD_ALREADY_OWNED")) {
                    return AD_ALREADY_OWNED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("LESS_FROM_DOMAIN")) {
                    return LESS_FROM_DOMAIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 17:
                if (str.equalsIgnoreCase("REMOVE_ADS_INTEREST")) {
                    return REMOVE_ADS_INTEREST;
                }
                if (str.equalsIgnoreCase("REPORT_WORK_CONTENT")) {
                    return REPORT_WORK_CONTENT;
                }
                if (str.equalsIgnoreCase("LESS_FROM_DIRECTED_TARGET")) {
                    return LESS_FROM_DIRECTED_TARGET;
                }
                if (str.equalsIgnoreCase("WRITE_IN")) {
                    return WRITE_IN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 18:
                if (str.equalsIgnoreCase("PAGES_LIKE_CHECKUP")) {
                    return PAGES_LIKE_CHECKUP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 19:
                if (str.equalsIgnoreCase("LESS_FROM_UPSETTING_CONCEPT")) {
                    return LESS_FROM_UPSETTING_CONCEPT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("UNSUBSCRIBE_OWNER")) {
                    return UNSUBSCRIBE_OWNER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 21:
                if (str.equalsIgnoreCase("UNFOLLOW_FRIEND_LIST")) {
                    return UNFOLLOW_FRIEND_LIST;
                }
                if (str.equalsIgnoreCase("AWESOMIZER_UNFOLLOW_CARD")) {
                    return AWESOMIZER_UNFOLLOW_CARD;
                }
                if (str.equalsIgnoreCase("AWESOMIZER_REFOLLOW_CARD")) {
                    return AWESOMIZER_REFOLLOW_CARD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 22:
                if (str.equalsIgnoreCase("HIDE_TOPIC_MISCLASSIFICATION")) {
                    return HIDE_TOPIC_MISCLASSIFICATION;
                }
                if (str.equalsIgnoreCase("SPAM_CLEANUP_CHECKPOINT")) {
                    return SPAM_CLEANUP_CHECKPOINT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 23:
                if (str.equalsIgnoreCase("REPORT_IP_VIOLATION")) {
                    return REPORT_IP_VIOLATION;
                }
                if (str.equalsIgnoreCase("UNSUBSCRIBE_RESHARER")) {
                    return UNSUBSCRIBE_RESHARER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("PHONE_FRIEND")) {
                    return PHONE_FRIEND;
                }
                if (str.equalsIgnoreCase("LESS_FROM_ATTACHED_STORY_ACTOR")) {
                    return LESS_FROM_ATTACHED_STORY_ACTOR;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 25:
                if (str.equalsIgnoreCase("REPORT_TO_GROUP_ADMIN")) {
                    return REPORT_TO_GROUP_ADMIN;
                }
                if (str.equalsIgnoreCase("UNFRIEND")) {
                    return UNFRIEND;
                }
                if (str.equalsIgnoreCase("HEAD_PUBLISHER_APP_MENTIONS_BAN")) {
                    return HEAD_PUBLISHER_APP_MENTIONS_BAN;
                }
                if (str.equalsIgnoreCase("VOTING_REMINDER_OPT_OUT")) {
                    return VOTING_REMINDER_OPT_OUT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 26:
                if (str.equalsIgnoreCase("REPORT_AD_IP_VIOLATION")) {
                    return REPORT_AD_IP_VIOLATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 28:
                if (str.equalsIgnoreCase("HACKED_NOTIFY")) {
                    return HACKED_NOTIFY;
                }
                if (str.equalsIgnoreCase("REPORT_CONTENT_EDUCATION")) {
                    return REPORT_CONTENT_EDUCATION;
                }
                if (str.equalsIgnoreCase("UNSUBSCRIBE_DIRECTED_TARGET")) {
                    return UNSUBSCRIBE_DIRECTED_TARGET;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 29:
                if (str.equalsIgnoreCase("BLOCK_MESSAGES")) {
                    return BLOCK_MESSAGES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 34:
                if (str.equalsIgnoreCase("CONTACT_FORM")) {
                    return CONTACT_FORM;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 35:
                if (str.equalsIgnoreCase("UNSUBSCRIBE_ATTACHED_STORY_ACTOR")) {
                    return UNSUBSCRIBE_ATTACHED_STORY_ACTOR;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 37:
                if (str.equalsIgnoreCase("DELETE")) {
                    return DELETE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 39:
                if (str.equalsIgnoreCase("BLOCK_PAGE")) {
                    return BLOCK_PAGE;
                }
                if (str.equalsIgnoreCase("HIDE")) {
                    return HIDE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 40:
                if (str.equalsIgnoreCase("HIDE_RESEARCH_POLLS")) {
                    return HIDE_RESEARCH_POLLS;
                }
                if (str.equalsIgnoreCase("DONT_LIKE")) {
                    return DONT_LIKE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 41:
                if (str.equalsIgnoreCase("DELETE_AND_BLOCK")) {
                    return DELETE_AND_BLOCK;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 42:
                if (str.equalsIgnoreCase("LIMIT_FRIENDING_PRIVACY")) {
                    return LIMIT_FRIENDING_PRIVACY;
                }
                if (str.equalsIgnoreCase("IGNORE_EVENT_INVITES")) {
                    return IGNORE_EVENT_INVITES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 44:
                if (str.equalsIgnoreCase("MARK_AS_SPAM")) {
                    return MARK_AS_SPAM;
                }
                if (str.equalsIgnoreCase("NEWSFEED_SETTINGS")) {
                    return NEWSFEED_SETTINGS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 47:
                if (str.equalsIgnoreCase("MESSAGE")) {
                    return MESSAGE;
                }
                if (str.equalsIgnoreCase("CLOSE_OLD_PROFILE")) {
                    return CLOSE_OLD_PROFILE;
                }
                if (str.equalsIgnoreCase("HIDE_TOPIC")) {
                    return HIDE_TOPIC;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 50:
                if (str.equalsIgnoreCase("SAVE")) {
                    return SAVE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 51:
                if (str.equalsIgnoreCase("UNTAG")) {
                    return UNTAG;
                }
                if (str.equalsIgnoreCase("VIDEO_CHANNEL_FOLLOW")) {
                    return VIDEO_CHANNEL_FOLLOW;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 52:
                if (str.equalsIgnoreCase("RESOLVE_PROBLEM")) {
                    return RESOLVE_PROBLEM;
                }
                if (str.equalsIgnoreCase("LESS_FROM_THROWBACK")) {
                    return LESS_FROM_THROWBACK;
                }
                if (str.equalsIgnoreCase("EMPLOYEE_BUG_REPORTING")) {
                    return EMPLOYEE_BUG_REPORTING;
                }
                if (str.equalsIgnoreCase("HIDE_FEED_TOPIC")) {
                    return HIDE_FEED_TOPIC;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 53:
                if (str.equalsIgnoreCase("EDIT")) {
                    return EDIT;
                }
                if (str.equalsIgnoreCase("HIDE_FROM_TIMELINE")) {
                    return HIDE_FROM_TIMELINE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 54:
                if (str.equalsIgnoreCase("UNLIKE")) {
                    return UNLIKE;
                }
                if (str.equalsIgnoreCase("THROWBACK_PREFERENCES")) {
                    return THROWBACK_PREFERENCES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 55:
                if (str.equalsIgnoreCase("REDIRECT_ADS_PREFERENCES")) {
                    return REDIRECT_ADS_PREFERENCES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 56:
                if (str.equalsIgnoreCase("BAN_USER")) {
                    return BAN_USER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 59:
                if (str.equalsIgnoreCase("BLOCK_ACTOR")) {
                    return BLOCK_ACTOR;
                }
                if (str.equalsIgnoreCase("BLOCK_APP")) {
                    return BLOCK_APP;
                }
                if (str.equalsIgnoreCase("MARK_MESSAGE_THREAD_AS_SPAM")) {
                    return MARK_MESSAGE_THREAD_AS_SPAM;
                }
                if (str.equalsIgnoreCase("UNSUBSCRIBE")) {
                    return UNSUBSCRIBE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 60:
                if (str.equalsIgnoreCase("RECOVER_PROFILE")) {
                    return RECOVER_PROFILE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 61:
                if (str.equalsIgnoreCase("MARK_AS_OBJECTIONABLE")) {
                    return MARK_AS_OBJECTIONABLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 62:
                if (str.equalsIgnoreCase("DIRECT_SUPPORT")) {
                    return DIRECT_SUPPORT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}
