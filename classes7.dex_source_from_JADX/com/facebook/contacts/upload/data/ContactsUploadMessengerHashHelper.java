package com.facebook.contacts.upload.data;

import com.facebook.contacts.model.PhonebookContact;
import com.facebook.contacts.model.PhonebookEmailAddress;
import com.facebook.contacts.model.PhonebookPhoneNumber;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;

/* compiled from: tapped_call_to_action */
public class ContactsUploadMessengerHashHelper {
    public static ContactsUploadMessengerHashHelper m2136a(InjectorLike injectorLike) {
        return new ContactsUploadMessengerHashHelper();
    }

    public static String m2137a(PhonebookContact phonebookContact, boolean z) {
        long hashCode;
        int i;
        if (phonebookContact.b == null) {
            hashCode = (long) Objects.hashCode(null);
        } else {
            hashCode = (long) Objects.hashCode(new Object[]{phonebookContact.b, phonebookContact.c, phonebookContact.d});
        }
        long j = hashCode;
        for (i = 0; i < phonebookContact.m.size(); i++) {
            j = (long) Objects.hashCode(new Object[]{((PhonebookPhoneNumber) phonebookContact.m.get(i)).a, Long.valueOf(j)});
        }
        if (z) {
            for (i = 0; i < phonebookContact.n.size(); i++) {
                j = (long) Objects.hashCode(new Object[]{((PhonebookEmailAddress) phonebookContact.n.get(i)).a, Long.valueOf(j)});
            }
        }
        return String.valueOf(j);
    }
}
