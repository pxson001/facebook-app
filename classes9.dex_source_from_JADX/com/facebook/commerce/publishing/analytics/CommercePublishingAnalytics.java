package com.facebook.commerce.publishing.analytics;

/* compiled from: UNABLE_TO_CALL */
public class CommercePublishingAnalytics {

    /* compiled from: UNABLE_TO_CALL */
    public enum CommercePublishingAnalyticsEvent {
        IMP_CURRENCY_SELECTION("imp_currency_selection"),
        ACTN_CANCEL_CURRENCY_SELECTION("actn_cancel_currency_selection"),
        ACTN_ADD_PRODUCT_CLICK("actn_add_product_click"),
        ACTN_EDIT_PRODUCT_CLICK("actn_edit_product_click"),
        ACTN_CANCEL_ADD_PRODUCT("actn_cancel_add_product"),
        ACTN_CANCEL_EDIT_PRODUCT("actn_cancel_edit_product"),
        IMP_PRIVATE_MESSAGE_SELECTION("imp_private_message_selection"),
        ACTN_PRIVATE_MESSAGE_BACK_CLICK("actn_private_message_back_click");
        
        public final String value;

        private CommercePublishingAnalyticsEvent(String str) {
            this.value = str;
        }
    }

    /* compiled from: UNABLE_TO_CALL */
    public enum CommercePublishingAnalyticsKey {
        SELLER_PROFILE_ID("seller_profile_id"),
        TARGET_ID("target_id");
        
        public final String value;

        private CommercePublishingAnalyticsKey(String str) {
            this.value = str;
        }
    }
}
