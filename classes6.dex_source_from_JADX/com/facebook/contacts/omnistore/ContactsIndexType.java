package com.facebook.contacts.omnistore;

/* compiled from: parent_session_id */
public enum ContactsIndexType {
    NAME("name"),
    COMMUNICATION_RANK("communication_rank"),
    WITH_TAGGING_RANK("with_tagging_rank"),
    PHONE_E164("phone_e164"),
    PHONE_NATIONAL("phone_national"),
    PHONE_LOCAL("phone_local"),
    PHONE_VERIFIED("phone_verified"),
    SORT_NAME_KEY("sort_name_key"),
    PROFILE_TYPE("profile_type"),
    LINK_TYPE("link_type"),
    FBID("fbid"),
    IS_PUSHABLE_TRISTATE("pushable_tristate"),
    IS_MESSENGER_USER("messenger_user"),
    IS_IN_CONTACT_LIST("in_contact_list"),
    IS_ZERO_COMMUNICATION_RANK("zero_communication_rank"),
    USERNAME_KEY("username");
    
    private final String mDbValue;

    private ContactsIndexType(String str) {
        this.mDbValue = str;
    }

    public final String getDbValue() {
        return this.mDbValue;
    }
}
