package com.facebook.structuredsurvey;

/* compiled from: draft_notification */
public class StructuredSurveyConstants {

    /* compiled from: draft_notification */
    public enum ImpressionExtra {
        ACTION("action"),
        DISMISS_SURVEY("dismiss_survey"),
        DISMISS_TOAST("dismiss_toast"),
        CLICK_CROSS_OUT("click_cross_out"),
        CLICK_CLOSS_BUTTON("click_close_button"),
        CANCEL_FREEFORM("cancel_freeform");
        
        private final String mImpressionExtra;

        private ImpressionExtra(String str) {
            this.mImpressionExtra = str;
        }

        public final String getImpressionExtra() {
            return this.mImpressionExtra;
        }
    }

    /* compiled from: draft_notification */
    public enum ImpressionType {
        INVITATION_IMPRESSION("invitation_impression"),
        INVITATION_OPENED("invitation_opened"),
        IMPRESSION("impression"),
        START("start"),
        COMPLETE("completion"),
        SKIP("skip");
        
        private final String mImpressionEvent;

        private ImpressionType(String str) {
            this.mImpressionEvent = str;
        }

        public final String getImpressionEvent() {
            return this.mImpressionEvent;
        }
    }
}
