package com.facebook.messaging.contacts.picker;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.contacts.iterator.PhoneContactFacebookUserDeduper;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.contacts.PhoneContactsLoader;
import com.facebook.user.model.UserIdentifier;
import javax.inject.Inject;

/* compiled from: template_data */
public class ContactPickerFavoriteEditFilter extends ContactPickerFriendFilter {
    @Inject
    public ContactPickerFavoriteEditFilter(FbHandlerThreadFactory fbHandlerThreadFactory, Boolean bool, SmsIntegrationState smsIntegrationState, UserIterators userIterators, PhoneContactsLoader phoneContactsLoader, PhoneContactFacebookUserDeduper phoneContactFacebookUserDeduper) {
        super(fbHandlerThreadFactory, bool, smsIntegrationState, userIterators, phoneContactsLoader, phoneContactFacebookUserDeduper);
    }

    protected final boolean m1736a(UserIdentifier userIdentifier) {
        if (this.a == null || this.a.isEmpty()) {
            return false;
        }
        return this.a.contains(userIdentifier);
    }

    protected final boolean mo56c() {
        return false;
    }
}
