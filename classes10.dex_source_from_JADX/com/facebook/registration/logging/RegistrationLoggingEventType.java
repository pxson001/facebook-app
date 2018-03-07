package com.facebook.registration.logging;

/* compiled from: language_switcher_activity_other_languages_clicked */
public enum RegistrationLoggingEventType {
    ENTER_FLOW("registration_flow_enter"),
    FLOW_STATE("registration_flow_state"),
    EXIT_FLOW("registration_flow_exit"),
    ACCEPT_TERMS("registration_step_accept_terms"),
    REJECT_TERMS("registration_step_reject_terms"),
    SWITCH_CONTACTPOINT_TYPE("registration_contact_switch_type"),
    STEP_VIEW("registration_step_view"),
    STEP_SUBMIT("registration_step_submit"),
    STEP_BACK("registration_step_back"),
    STEP_ERROR("registration_step_error"),
    STEP_VALIDATION_ERROR("registration_step_validation_error"),
    STEP_VALIDATION_SUCCESS("registration_step_validation_success"),
    ACCOUNT_CREATION_ATTEMPT("registration_account_creation_attempt"),
    ACCOUNT_CREATION_ERROR("registration_account_creation_error"),
    ACCOUNT_CREATION_SUCCESS("registration_account_creation_success"),
    ACCOUNT_CREATION_NEEDS_COMPLETION("registration_account_creation_needs_completion"),
    NAME_PREFILL("registration_name_prefill"),
    PREFILL("registration_prefill"),
    EXPOSURE("initial_app_launch_experiment_exposure"),
    FINISH_REGISTRATION_NOTIF_SCHEDULED("finish_registration_notif_scheduled"),
    FINISH_REGISTRATION_NOTIF_CREATED("finish_registration_notif_created"),
    FINISH_REGISTRATION_NOTIF_CLICKED("finish_registration_notif_clicked"),
    FB4A_REGISTRATION_UPSELL_CAMPAIGN("fb4a_registration_upsell_campaign"),
    REGISTRATION_CONTACTS_TERMS_ACCEPT("registration_contacts_terms_accept"),
    SAVED_UNUSED_FORM_DATA("registration_saved_unused_form_data"),
    USED_SAVED_FORM_DATA("registration_used_saved_form_data"),
    REGISTRATION_LOGIN_START("registration_login_start"),
    REGISTRATION_LOGIN_SUCCESS("registration_login_success"),
    REGISTRATION_LOGIN_FAILURE("registration_login_failure"),
    REGISTRATION_PROFILE_PIC_STEP_SHOWN("registration_profile_pic_step_shown"),
    REGISTRATION_PROFILE_PIC_STEP_SKIPPED("registration_profile_pic_step_skipped"),
    REGISTRATION_PROFILE_PIC_STEP_COMPLETED("registration_profile_pic_step_completed"),
    REGISTRATION_PROFILE_PIC_UPLOADED("registration_profile_pic_uploaded"),
    REGISTRATION_PROFILE_PIC_UPLOAD_ERROR("registration_profile_pic_upload_error"),
    REGISTRATION_CP_SUGGESTION_CALL_SUCCESS("registration_cp_suggestion_call_success"),
    REGISTRATION_CP_SUGGESTION_CALL_ERROR("registration_cp_suggestion_call_error"),
    REGISTRATION_CP_SUGGESTION_CALL_ATTEMPT("registration_cp_suggestion_call_attempt"),
    REGISTRATION_CP_SUGGESTION_READY("registration_cp_suggestion_ready"),
    REGISTRATION_ADDITIONAL_EMAIL_STATE("registration_additional_email_state");
    
    private final String mAnalyticsName;

    private RegistrationLoggingEventType(String str) {
        this.mAnalyticsName = str;
    }

    public final String getAnalyticsName() {
        return this.mAnalyticsName;
    }

    public final String toString() {
        return this.mAnalyticsName;
    }
}
