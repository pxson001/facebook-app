package com.facebook.gk.sessionless;

import com.facebook.gk.store.GatekeeperStoreConfig;
import java.util.ArrayList;

/* compiled from: user_search_awareness_suggestion_subscribe */
public class SessionlessGKStoreConfig implements GatekeeperStoreConfig {
    public final ArrayList<String> mo328b() {
        ArrayList<String> arrayList = new ArrayList(34);
        arrayList.add("account_recovery_parallel_search");
        arrayList.add("android_account_recovery_captcha");
        arrayList.add("android_bootstrap_tier_kill_switch");
        arrayList.add("android_dbl_password_account_kill_switch");
        arrayList.add("android_device_based_login_kill_switch");
        arrayList.add("android_first_party_provider");
        arrayList.add("android_ppl_autosave_identifier");
        arrayList.add("android_ppl_login_header");
        arrayList.add("fb4a_ar_bounce_from_msite");
        arrayList.add("fb4a_ar_email_listed_before_sms");
        arrayList.add("fb4a_auth_login_send_location");
        arrayList.add("fb4a_burmese_language_support");
        arrayList.add("fb4a_downloadable_languages_killswitch");
        arrayList.add("fb4a_finish_reg_notification_1hr");
        arrayList.add("fb4a_reg_additional_email_step");
        arrayList.add("fb4a_reg_default_oauth_email");
        arrayList.add("fb4a_reg_early_account_creation");
        arrayList.add("fb4a_reg_fetch_server_contacts");
        arrayList.add("fb4a_reg_inline_terms_step");
        arrayList.add("fb4a_reg_login_profile_pic");
        arrayList.add("fb4a_reg_name_hint_zh_promo");
        arrayList.add("fb4a_reg_name_locale_order");
        arrayList.add("fb4a_reg_name_title");
        arrayList.add("fb4a_reg_new_login_flow");
        arrayList.add("fb4a_reg_terms_contacts_end_v1");
        arrayList.add("fb4a_reg_terms_contacts_end_v2");
        arrayList.add("fb4a_reg_terms_contacts_end_v3");
        arrayList.add("fb4a_reg_terms_contacts_end_v4");
        arrayList.add("fb4a_reg_terms_contacts_v2");
        arrayList.add("is_aldrin_enabled_fb4a_logged_out");
        arrayList.add("liger_network_status_monitor_android");
        arrayList.add("pre_reg_push_token_registration");
        arrayList.add("sem_install_referrer_use_graphql_mutation");
        arrayList.add("zero_sessionless_backup_rewrite_rules");
        return arrayList;
    }

    public final int mo327a() {
        return 34;
    }

    public final String mo329c() {
        return SessionlessGKMeta.f1623b;
    }
}
