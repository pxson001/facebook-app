package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: playableUrlHdString */
public final class UniversalFeedbackGiveFeedbackInputData extends GraphQlMutationCallInput {

    /* compiled from: playableUrlHdString */
    public enum DeliveryType implements JsonSerializable {
        WWW_SD_INLINE("WWW_SD_INLINE"),
        MOBILE_SD_INLINE("MOBILE_SD_INLINE"),
        WWW_CHECKPOINTS_PAGE("WWW_CHECKPOINTS_PAGE"),
        MOBILE_CHECKPOINT_FULL_PAGE("MOBILE_CHECKPOINT_FULL_PAGE"),
        MOBILE_NFX_INLINE("MOBILE_NFX_INLINE"),
        WWW_NFX_DIALOG("WWW_NFX_DIALOG"),
        FB4A_NFX_DIALOG("FB4A_NFX_DIALOG"),
        WWW_HC_INLINE("WWW_HC_INLINE"),
        MOBILE_HC_INLINE("MOBILE_HC_INLINE"),
        WWW_HC_PAGE("WWW_HC_PAGE"),
        MOBILE_HC_PAGE("MOBILE_HC_PAGE"),
        WWW_TPS_INLINE("WWW_TPS_INLINE"),
        SYSTEM_TEST("SYSTEM_TEST"),
        WWW_U2U_ANSWER_FEEDBACK("WWW_U2U_ANSWER_FEEDBACK"),
        MOBILE_U2U_ANSWER_FEEDBACK("MOBILE_U2U_ANSWER_FEEDBACK");
        
        protected final String serverValue;

        private DeliveryType(String str) {
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

    /* compiled from: playableUrlHdString */
    public enum ExperienceType implements JsonSerializable {
        BUG_REPORT_FEEDBACK("BUG_REPORT_FEEDBACK"),
        ADS_XOUT_FEEDBACK("ADS_XOUT_FEEDBACK"),
        EDIT_NAME_FEEDBACK("EDIT_NAME_FEEDBACK"),
        SPAM_REPORT_FEEDBACK("SPAM_REPORT_FEEDBACK"),
        REPORTER_FEEDBACK("REPORTER_FEEDBACK"),
        RESPONSIBLE_FEEDBACK("RESPONSIBLE_FEEDBACK"),
        SUPPORT_CASE_REPORTER_FEEDBACK("SUPPORT_CASE_REPORTER_FEEDBACK"),
        SUPPORT_CASE_USER_BUG_REPORT_FEEDBACK("SUPPORT_CASE_USER_BUG_REPORT_FEEDBACK"),
        PI_FEEDBACK("PI_FEEDBACK"),
        FEATURE_LIMIT_FEEDBACK("FEATURE_LIMIT_FEEDBACK"),
        TPS_TICKET_FEEDBACK("TPS_TICKET_FEEDBACK"),
        IMPERSONATION_FEEDBACK("IMPERSONATION_FEEDBACK"),
        CHECKPOINT_FEEDBACK("CHECKPOINT_FEEDBACK"),
        PAGE_MERGE_FEEDBACK("PAGE_MERGE_FEEDBACK"),
        NFX_FEEDBACK("NFX_FEEDBACK"),
        HELP_CENTER_FEEDBACK("HELP_CENTER_FEEDBACK"),
        GROUP_RESPONSIBLE_FEEDBACK("GROUP_RESPONSIBLE_FEEDBACK"),
        GEOBLOCK_FEEDBACK("GEOBLOCK_FEEDBACK"),
        TAG_SPAM_FEEDBACK("TAG_SPAM_FEEDBACK"),
        U2U_ANSWER_FEEDBACK("U2U_ANSWER_FEEDBACK"),
        GROUP_REPORT_FEEDBACK("GROUP_REPORT_FEEDBACK"),
        DELETED_CONTENT_FEEDBACK("DELETED_CONTENT_FEEDBACK");
        
        protected final String serverValue;

        private ExperienceType(String str) {
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
