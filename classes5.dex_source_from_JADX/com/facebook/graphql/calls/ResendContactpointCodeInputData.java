package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: post_checkin */
public final class ResendContactpointCodeInputData extends GraphQlMutationCallInput {

    /* compiled from: post_checkin */
    public enum PromoType implements JsonSerializable {
        ACQUISITION("ACQUISITION"),
        VERIFICATION("VERIFICATION"),
        ACQUISITION_PREFILLED("ACQUISITION_PREFILLED"),
        CLAIMED_PHONE_NUMBER("CLAIMED_PHONE_NUMBER"),
        M_ACCOUNT_VERIFY("M_ACCOUNT_VERIFY"),
        PROFILE_VERIFY("PROFILE_VERIFY"),
        PROFILE_EDIT("PROFILE_EDIT"),
        SETTINGS("SETTINGS"),
        NUX_MISSIONS("NUX_MISSIONS");
        
        protected final String serverValue;

        private PromoType(String str) {
            this.serverValue = str;
        }

        public final String toString() {
            return this.serverValue;
        }

        public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.b(this.serverValue);
        }

        public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
        }
    }

    /* compiled from: post_checkin */
    public enum Source implements JsonSerializable {
        UNITTEST("UNITTEST"),
        UI_EXPLORER("UI_EXPLORER"),
        UNKNOWN("UNKNOWN"),
        SMS_SCARCE("SMS_SCARCE"),
        SMS_SCARCE_FORCE("SMS_SCARCE_FORCE"),
        SMS_ACTIVATION("SMS_ACTIVATION"),
        USERNAME("USERNAME"),
        USERNAME_EDITOR("USERNAME_EDITOR"),
        SUBSCRIBER_USERNAME_EDITOR("SUBSCRIBER_USERNAME_EDITOR"),
        EDIT_PROFILE("EDIT_PROFILE"),
        EDIT_PROFILE_TIMELINE("EDIT_PROFILE_TIMELINE"),
        STALE_NUMBER_MEGAPHONE("STALE_NUMBER_MEGAPHONE"),
        ADD_PHONE_NUMBER_MEGAPHONE("ADD_PHONE_NUMBER_MEGAPHONE"),
        SECURITY_INTERSTITIAL("SECURITY_INTERSTITIAL"),
        COUPON("COUPON"),
        COUPON_REQUEST("COUPON_REQUEST"),
        IMPOSTOR_REPORT("IMPOSTOR_REPORT"),
        WWW_MOBILE_SETTINGS("WWW_MOBILE_SETTINGS"),
        ACCOUNT("ACCOUNT"),
        SECURITY_SERVICE("SECURITY_SERVICE"),
        MIRROR("MIRROR"),
        MIRROR_DEFAULT("MIRROR_DEFAULT"),
        MIRROR_MAIN_SITE("MIRROR_MAIN_SITE"),
        MOBILE_MIRROR_MEGAPHONE("MOBILE_MIRROR_MEGAPHONE"),
        MOBILE_MIRROR_NUX("MOBILE_MIRROR_NUX"),
        MOBILE_MIRROR_BANNER("MOBILE_MIRROR_BANNER"),
        MOBILE_MIRROR("MOBILE_MIRROR"),
        M_MOBILE_MIRROR_INTERSTITIAL("M_MOBILE_MIRROR_INTERSTITIAL"),
        LOGIN_APPROVAL("LOGIN_APPROVAL"),
        LOGIN_NOTIFICATION("LOGIN_NOTIFICATION"),
        LOGIN_ALERTS("LOGIN_ALERTS"),
        MIRROR_CHECKPOINT("MIRROR_CHECKPOINT"),
        MIRROR_ROADBLOCK("MIRROR_ROADBLOCK"),
        M_ACCOUNT("M_ACCOUNT"),
        M_ACCOUNT_CONFIRMATION("M_ACCOUNT_CONFIRMATION"),
        M_ACCOUNT_MERGE("M_ACCOUNT_MERGE"),
        M_ACQUISITION("M_ACQUISITION"),
        WWW_ACTIVATE("WWW_ACTIVATE"),
        M_ACTIVATION("M_ACTIVATION"),
        BOUNCE("BOUNCE"),
        M_NUX_WIZARD("M_NUX_WIZARD"),
        WWW_NUX_WIZARD("WWW_NUX_WIZARD"),
        NUX_WIZARD("NUX_WIZARD"),
        M_NUX_MISSION("M_NUX_MISSION"),
        WWW_CONFIRMATION("WWW_CONFIRMATION"),
        M_CONFIRMATION("M_CONFIRMATION"),
        WWW_ACCOUNT_CONFIRMATION("WWW_ACCOUNT_CONFIRMATION"),
        WWW_REGISTER_THROUGH_PHONE_CONFIRMATION("WWW_REGISTER_THROUGH_PHONE_CONFIRMATION"),
        M_TIMELINE("M_TIMELINE"),
        M_PROFILE("M_PROFILE"),
        SNAPTU_CONFIRMATION("SNAPTU_CONFIRMATION"),
        SNAPTU_PROFILE("SNAPTU_PROFILE"),
        MOBILE_HUB("MOBILE_HUB"),
        SMS("SMS"),
        NUMBER_FIXER("NUMBER_FIXER"),
        PARTIAL_REGISTRATION("PARTIAL_REGISTRATION"),
        PHONEBOOK("PHONEBOOK"),
        PLATFORM("PLATFORM"),
        PLATFORM_REG("PLATFORM_REG"),
        DEVELOPER_ONBOARDING("DEVELOPER_ONBOARDING"),
        DEVELOPER_APP_SUBMISSION("DEVELOPER_APP_SUBMISSION"),
        HEADERS("HEADERS"),
        PHONE_ACQUISITION_MEGAPHONE("PHONE_ACQUISITION_MEGAPHONE"),
        INBOX_PHONE_ACQUISITION_MEGAPHONE("INBOX_PHONE_ACQUISITION_MEGAPHONE"),
        PHONE_ACQUISITION_SUBNO_MEGAPHONE("PHONE_ACQUISITION_SUBNO_MEGAPHONE"),
        PHONE_ACQUISITION_EMBEDDED("PHONE_ACQUISITION_EMBEDDED"),
        PHONE_ACQUISITION_SCALABLE("PHONE_ACQUISITION_SCALABLE"),
        PHONE_ACQUISITION_PROMO("PHONE_ACQUISITION_PROMO"),
        FACEBOOK_ANDROID("FACEBOOK_ANDROID"),
        FACEBOOK_ANDROID_BACKGROUND("FACEBOOK_ANDROID_BACKGROUND"),
        FACEBOOK_LITE_BACKGROUND("FACEBOOK_LITE_BACKGROUND"),
        FACEBOOK_IOS("FACEBOOK_IOS"),
        M_REGISTRATION("M_REGISTRATION"),
        FRIENDS("FRIENDS"),
        STATUS_SUBSCRIBE("STATUS_SUBSCRIBE"),
        EMU("EMU"),
        NOTIFICATIONS("NOTIFICATIONS"),
        NOTIFICATIONS_EMAIL_PROMO("NOTIFICATIONS_EMAIL_PROMO"),
        NOTIFICATIONS_SUBSCRIBE("NOTIFICATIONS_SUBSCRIBE"),
        PAGE_EDIT("PAGE_EDIT"),
        PAGE_ADMIN_PROFILE_ACTION("PAGE_ADMIN_PROFILE_ACTION"),
        MESSAGES_NUX("MESSAGES_NUX"),
        WWW_REG("WWW_REG"),
        M_HOME("M_HOME"),
        M_NOTIFICATIONS("M_NOTIFICATIONS"),
        M_STATUS_SET("M_STATUS_SET"),
        M_STATUS_SUBSCRIBE("M_STATUS_SUBSCRIBE"),
        M_MINI_REGISTRATION("M_MINI_REGISTRATION"),
        SNAPTU_REGISTRATION("SNAPTU_REGISTRATION"),
        M_PHONE_NUMBER_CONFIRMATION("M_PHONE_NUMBER_CONFIRMATION"),
        MOBILE_MIRROR_CONFIRMATION("MOBILE_MIRROR_CONFIRMATION"),
        ANDROID_PHONE_ACQUISITION_MEGAPHONE("ANDROID_PHONE_ACQUISITION_MEGAPHONE"),
        PROFILE_QUESTIONS_MOBILE("PROFILE_QUESTIONS_MOBILE"),
        ACCOUNT_RECOVERY("ACCOUNT_RECOVERY"),
        PHONE_CONFIDENCE_MEGAPHONE("PHONE_CONFIDENCE_MEGAPHONE"),
        PHONE_ACQUISITION_NETEGO("PHONE_ACQUISITION_NETEGO"),
        PHONE_CONFIRMATION_NETEGO("PHONE_CONFIRMATION_NETEGO"),
        API_METHOD_USER_CONFIRM_PHONE("API_METHOD_USER_CONFIRM_PHONE"),
        API_METHOD_USER_CONFIRM_MESSENGER_PHONE("API_METHOD_USER_CONFIRM_MESSENGER_PHONE"),
        EMAIL_ANNOUNCEMENT_EXPERIMENT("EMAIL_ANNOUNCEMENT_EXPERIMENT"),
        TEST_USER("TEST_USER"),
        ZERO_RATING_OPTIN("ZERO_RATING_OPTIN"),
        ZERO_RATING_MEGAPHONE_SHARE("ZERO_RATING_MEGAPHONE_SHARE"),
        ASYNC_MIGRATE_DIRECT_BIND("ASYNC_MIGRATE_DIRECT_BIND"),
        ASYNC_OPT_IN("ASYNC_OPT_IN"),
        ASYNC_TEXT_CONSENTED("ASYNC_TEXT_CONSENTED"),
        ASYNC_LOST_CONFIDENCE_USERS("ASYNC_LOST_CONFIDENCE_USERS"),
        ASYNC_ENABLE_CONSENTED("ASYNC_ENABLE_CONSENTED"),
        FUZZY_CONFIRMATION("FUZZY_CONFIRMATION"),
        WWW_SOCIAL_WIFI("WWW_SOCIAL_WIFI"),
        M_SOCIAL_WIFI("M_SOCIAL_WIFI"),
        INVITE("INVITE"),
        PRECONFIRMATION("PRECONFIRMATION"),
        MN_COMMERCE_SERVICE("MN_COMMERCE_SERVICE"),
        CLAIM_PHONE_MEGAPHONE("CLAIM_PHONE_MEGAPHONE");
        
        protected final String serverValue;

        private Source(String str) {
            this.serverValue = str;
        }

        public final String toString() {
            return this.serverValue;
        }

        public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.b(this.serverValue);
        }

        public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
        }
    }
}
