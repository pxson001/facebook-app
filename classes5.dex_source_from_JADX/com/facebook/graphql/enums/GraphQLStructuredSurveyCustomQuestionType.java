package com.facebook.graphql.enums;

/* compiled from: literal */
public enum GraphQLStructuredSurveyCustomQuestionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CM_MIGRATION_ISSUES,
    DATA_FETCHER,
    PAYMENT_SETTINGS_HELP,
    FEED_STORY_PHOTO,
    MOBILE_FEED_AD_STORY,
    NETWORK_PROVIDER_DETECTION,
    PHONE_AND_EMAIL,
    REMOTE_RESEARCH,
    NOTIFICATION,
    UNIVERSAL_FEEDBACK,
    UNIVERSAL_FEEDBACK_TEXT,
    AUDIENCE_PREFERENCES,
    SPOKEN_LANGUAGES,
    FRIEND_TYPEAHEAD,
    FRIENDS_MATRIX,
    GROUP_CREATE,
    STORY_REF,
    FRIEND_AUDIT_SURVEY_MESSAGE,
    FEED_TOPIC_TYPEAHEAD,
    PAGE_AND_PROFILE_CONNECTEDNESS,
    QP_PREVIEW,
    GOODWILL_PINNED_UNIT,
    THROWBACK_PROMOTION,
    PHONE_CLAIMING;

    public static GraphQLStructuredSurveyCustomQuestionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("AUDIENCE_PREFERENCES")) {
            return AUDIENCE_PREFERENCES;
        }
        if (str.equalsIgnoreCase("CM_MIGRATION_ISSUES")) {
            return CM_MIGRATION_ISSUES;
        }
        if (str.equalsIgnoreCase("DATA_FETCHER")) {
            return DATA_FETCHER;
        }
        if (str.equalsIgnoreCase("FEED_STORY_PHOTO")) {
            return FEED_STORY_PHOTO;
        }
        if (str.equalsIgnoreCase("FEED_TOPIC_TYPEAHEAD")) {
            return FEED_TOPIC_TYPEAHEAD;
        }
        if (str.equalsIgnoreCase("FRIEND_AUDIT_SURVEY_MESSAGE")) {
            return FRIEND_AUDIT_SURVEY_MESSAGE;
        }
        if (str.equalsIgnoreCase("FRIEND_TYPEAHEAD")) {
            return FRIEND_TYPEAHEAD;
        }
        if (str.equalsIgnoreCase("FRIENDS_MATRIX")) {
            return FRIENDS_MATRIX;
        }
        if (str.equalsIgnoreCase("GOODWILL_PINNED_UNIT")) {
            return GOODWILL_PINNED_UNIT;
        }
        if (str.equalsIgnoreCase("GROUP_CREATE")) {
            return GROUP_CREATE;
        }
        if (str.equalsIgnoreCase("MOBILE_FEED_AD_STORY")) {
            return MOBILE_FEED_AD_STORY;
        }
        if (str.equalsIgnoreCase("NETWORK_PROVIDER_DETECTION")) {
            return NETWORK_PROVIDER_DETECTION;
        }
        if (str.equalsIgnoreCase("NOTIFICATION")) {
            return NOTIFICATION;
        }
        if (str.equalsIgnoreCase("PAGE_AND_PROFILE_CONNECTEDNESS")) {
            return PAGE_AND_PROFILE_CONNECTEDNESS;
        }
        if (str.equalsIgnoreCase("PAYMENT_SETTINGS_HELP")) {
            return PAYMENT_SETTINGS_HELP;
        }
        if (str.equalsIgnoreCase("PHONE_AND_EMAIL")) {
            return PHONE_AND_EMAIL;
        }
        if (str.equalsIgnoreCase("PHONE_CLAIMING")) {
            return PHONE_CLAIMING;
        }
        if (str.equalsIgnoreCase("QP_PREVIEW")) {
            return QP_PREVIEW;
        }
        if (str.equalsIgnoreCase("REMOTE_RESEARCH")) {
            return REMOTE_RESEARCH;
        }
        if (str.equalsIgnoreCase("SPOKEN_LANGUAGES")) {
            return SPOKEN_LANGUAGES;
        }
        if (str.equalsIgnoreCase("STORY_REF")) {
            return STORY_REF;
        }
        if (str.equalsIgnoreCase("THROWBACK_PROMOTION")) {
            return THROWBACK_PROMOTION;
        }
        if (str.equalsIgnoreCase("UNIVERSAL_FEEDBACK")) {
            return UNIVERSAL_FEEDBACK;
        }
        if (str.equalsIgnoreCase("UNIVERSAL_FEEDBACK_TEXT")) {
            return UNIVERSAL_FEEDBACK_TEXT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
