package com.facebook.graphql.enums;

import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: maintab */
public enum GraphQLExtensibleMessageAdminTextType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CONFIRM_FRIEND_REQUEST,
    ACCEPT_PENDING_THREAD,
    RAMP_UP_WELCOME_MESSAGE,
    CHANGE_THREAD_THEME,
    CHANGE_THREAD_ICON,
    GROUP_THREAD_CREATED,
    THREAD_EPHEMERAL_SEND_MODE,
    INVITE_ACCEPTED,
    MESSENGER_INVITE_SENT,
    TURN_ON_PUSH,
    JOURNEY_PROMPT_COLOR,
    JOURNEY_PROMPT_LIKE,
    JOURNEY_PROMPT_NICKNAME,
    JOURNEY_PROMPT_SETUP,
    JOURNEY_PROMPT_NEW_SETUP,
    JOURNEY_PROMPT_BOT,
    CHANGE_THREAD_NICKNAME,
    BOT_THREAD_SUBSCRIPTION,
    RTC_CALL_LOG,
    RIDE_ORDERED_MESSAGE,
    LIGHTWEIGHT_EVENT_CREATE,
    LIGHTWEIGHT_EVENT_DELETE,
    LIGHTWEIGHT_EVENT_NOTIFY,
    LIGHTWEIGHT_EVENT_NOTIFY_BEFORE_EVENT,
    LIGHTWEIGHT_EVENT_UPDATE,
    AD_MANAGE_MESSAGE,
    TAGGED_PHOTO,
    GAME_SCORE,
    M_AI_SURVEY,
    LIGHTWEIGHT_EVENT_UPDATE_TIME,
    LIGHTWEIGHT_EVENT_UPDATE_TITLE,
    PHONE_NUMBER_LOOKUP_NOTICE,
    ADD_CONTACT,
    LIGHTWEIGHT_EVENT_RSVP,
    PRODUCT_INVOICE_PAID,
    CHANGE_JOINABLE_SETTING,
    CHANGE_THREAD_ADMINS,
    CHANGE_THREAD_APPROVAL_MODE,
    CAPY_SESSION_BEGIN,
    CAPY_SESSION_END,
    CAPY_AGENT_JOIN,
    AD_REPLY_MESSAGE,
    PRODUCT_INVOICE_VOIDED,
    PRODUCT_INVOICE_SHIPPED,
    GROUP_SMS_PARTICIPANT_JOINED,
    SMS_PHONE_NUMBER_CHECK,
    LIGHTWEIGHT_EVENT_UPDATE_LOCATION;

    public static GraphQLExtensibleMessageAdminTextType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 31) {
            case 0:
                if (str.equalsIgnoreCase("PRODUCT_INVOICE_PAID")) {
                    return PRODUCT_INVOICE_PAID;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 1:
                if (str.equalsIgnoreCase("RIDE_ORDERED_MESSAGE")) {
                    return RIDE_ORDERED_MESSAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (str.equalsIgnoreCase("PRODUCT_INVOICE_VOIDED")) {
                    return PRODUCT_INVOICE_VOIDED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("PRODUCT_INVOICE_SHIPPED")) {
                    return PRODUCT_INVOICE_SHIPPED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (str.equalsIgnoreCase("RAMP_UP_WELCOME_MESSAGE")) {
                    return RAMP_UP_WELCOME_MESSAGE;
                }
                if (str.equalsIgnoreCase("LIGHTWEIGHT_EVENT_UPDATE_TIME")) {
                    return LIGHTWEIGHT_EVENT_UPDATE_TIME;
                }
                if (str.equalsIgnoreCase("CHANGE_THREAD_ADMINS")) {
                    return CHANGE_THREAD_ADMINS;
                }
                if (str.equalsIgnoreCase("CAPY_AGENT_JOIN")) {
                    return CAPY_AGENT_JOIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("CONFIRM_FRIEND_REQUEST")) {
                    return CONFIRM_FRIEND_REQUEST;
                }
                if (str.equalsIgnoreCase("LIGHTWEIGHT_EVENT_UPDATE_TITLE")) {
                    return LIGHTWEIGHT_EVENT_UPDATE_TITLE;
                }
                if (str.equalsIgnoreCase("PHONE_NUMBER_LOOKUP_NOTICE")) {
                    return PHONE_NUMBER_LOOKUP_NOTICE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("CHANGE_THREAD_ICON")) {
                    return CHANGE_THREAD_ICON;
                }
                if (str.equalsIgnoreCase("CAPY_SESSION_BEGIN")) {
                    return CAPY_SESSION_BEGIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 8:
                if (str.equalsIgnoreCase("JOURNEY_PROMPT_BOT")) {
                    return JOURNEY_PROMPT_BOT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("THREAD_EPHEMERAL_SEND_MODE")) {
                    return THREAD_EPHEMERAL_SEND_MODE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 11:
                if (str.equalsIgnoreCase("BOT_THREAD_SUBSCRIPTION")) {
                    return BOT_THREAD_SUBSCRIPTION;
                }
                if (str.equalsIgnoreCase("LIGHTWEIGHT_EVENT_NOTIFY")) {
                    return LIGHTWEIGHT_EVENT_NOTIFY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("JOURNEY_PROMPT_COLOR")) {
                    return JOURNEY_PROMPT_COLOR;
                }
                if (str.equalsIgnoreCase("AD_REPLY_MESSAGE")) {
                    return AD_REPLY_MESSAGE;
                }
                if (str.equalsIgnoreCase("GAME_SCORE")) {
                    return GAME_SCORE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 13:
                if (str.equalsIgnoreCase("AD_MANAGE_MESSAGE")) {
                    return AD_MANAGE_MESSAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("MESSENGER_INVITE_SENT")) {
                    return MESSENGER_INVITE_SENT;
                }
                if (str.equalsIgnoreCase("JOURNEY_PROMPT_SETUP")) {
                    return JOURNEY_PROMPT_SETUP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("CAPY_SESSION_END")) {
                    return CAPY_SESSION_END;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 17:
                if (str.equalsIgnoreCase("CHANGE_THREAD_THEME")) {
                    return CHANGE_THREAD_THEME;
                }
                if (str.equalsIgnoreCase("TAGGED_PHOTO")) {
                    return TAGGED_PHOTO;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 18:
                if (str.equalsIgnoreCase("ACCEPT_PENDING_THREAD")) {
                    return ACCEPT_PENDING_THREAD;
                }
                if (str.equalsIgnoreCase("JOURNEY_PROMPT_NEW_SETUP")) {
                    return JOURNEY_PROMPT_NEW_SETUP;
                }
                if (str.equalsIgnoreCase("LIGHTWEIGHT_EVENT_RSVP")) {
                    return LIGHTWEIGHT_EVENT_RSVP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 19:
                if (str.equalsIgnoreCase("CHANGE_JOINABLE_SETTING")) {
                    return CHANGE_JOINABLE_SETTING;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("INVITE_ACCEPTED")) {
                    return INVITE_ACCEPTED;
                }
                if (str.equalsIgnoreCase("CHANGE_THREAD_NICKNAME")) {
                    return CHANGE_THREAD_NICKNAME;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 23:
                if (str.equalsIgnoreCase("GROUP_THREAD_CREATED")) {
                    return GROUP_THREAD_CREATED;
                }
                if (str.equalsIgnoreCase("RTC_CALL_LOG")) {
                    return RTC_CALL_LOG;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("TURN_ON_PUSH")) {
                    return TURN_ON_PUSH;
                }
                if (str.equalsIgnoreCase("JOURNEY_PROMPT_LIKE")) {
                    return JOURNEY_PROMPT_LIKE;
                }
                if (str.equalsIgnoreCase("ADD_CONTACT")) {
                    return ADD_CONTACT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 25:
                if (str.equalsIgnoreCase("CHANGE_THREAD_APPROVAL_MODE")) {
                    return CHANGE_THREAD_APPROVAL_MODE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 28:
                if (str.equalsIgnoreCase("JOURNEY_PROMPT_NICKNAME")) {
                    return JOURNEY_PROMPT_NICKNAME;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 29:
                if (str.equalsIgnoreCase("LIGHTWEIGHT_EVENT_NOTIFY_BEFORE_EVENT")) {
                    return LIGHTWEIGHT_EVENT_NOTIFY_BEFORE_EVENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("SMS_PHONE_NUMBER_CHECK")) {
                    return SMS_PHONE_NUMBER_CHECK;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 31:
                if (str.equalsIgnoreCase("LIGHTWEIGHT_EVENT_CREATE")) {
                    return LIGHTWEIGHT_EVENT_CREATE;
                }
                if (str.equalsIgnoreCase("LIGHTWEIGHT_EVENT_DELETE")) {
                    return LIGHTWEIGHT_EVENT_DELETE;
                }
                if (str.equalsIgnoreCase("LIGHTWEIGHT_EVENT_UPDATE_LOCATION")) {
                    return LIGHTWEIGHT_EVENT_UPDATE_LOCATION;
                }
                if (str.equalsIgnoreCase("LIGHTWEIGHT_EVENT_UPDATE")) {
                    return LIGHTWEIGHT_EVENT_UPDATE;
                }
                if (str.equalsIgnoreCase("M_AI_SURVEY")) {
                    return M_AI_SURVEY;
                }
                if (str.equalsIgnoreCase("GROUP_SMS_PARTICIPANT_JOINED")) {
                    return GROUP_SMS_PARTICIPANT_JOINED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}
