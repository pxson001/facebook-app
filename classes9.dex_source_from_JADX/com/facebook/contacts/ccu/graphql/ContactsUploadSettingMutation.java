package com.facebook.contacts.ccu.graphql;

import com.facebook.contacts.ccu.graphql.ContactsUploadSettingMutationModels.ContinuousContactUploadSettingUpdateMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: processed_message */
public final class ContactsUploadSettingMutation {

    /* compiled from: processed_message */
    public class ContinuousContactUploadSettingUpdateMutationString extends TypedGraphQLMutationString<ContinuousContactUploadSettingUpdateMutationFieldsModel> {
        public ContinuousContactUploadSettingUpdateMutationString() {
            super(ContinuousContactUploadSettingUpdateMutationFieldsModel.class, false, "ContinuousContactUploadSettingUpdateMutation", "e46d5ebf4de085baeac729c891924317", "continuous_contact_upload_setting_update", "0", "10154486257981729", RegularImmutableSet.a);
        }

        public final String m6675a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
