package com.facebook.contacts.upload;

import com.facebook.contacts.model.PhonebookContact;
import com.facebook.contacts.server.UploadBulkContactChange.Type;
import com.facebook.contacts.upload.data.PhoneAddressBookSnapshotEntry;
import com.facebook.contacts.upload.data.PhoneAddressBookSnapshotEntryChange.ChangeType;

/* compiled from: tapped_follow_switcher_regular */
class ContactsUploadAction {
    final ActionType f2117a;
    final long f2118b;
    final PhonebookContact f2119c;
    final PhoneAddressBookSnapshotEntry f2120d;

    /* compiled from: tapped_follow_switcher_regular */
    enum ActionType {
        ADD(Type.ADD, ChangeType.ADD),
        UPDATE(Type.MODIFY, ChangeType.UPDATE),
        DELETE(Type.DELETE, ChangeType.DELETE),
        NONE(null, null);
        
        public final Type buckContactChangeType;
        public final ChangeType snapshotEntryChangeType;

        private ActionType(Type type, ChangeType changeType) {
            this.buckContactChangeType = type;
            this.snapshotEntryChangeType = changeType;
        }
    }

    ContactsUploadAction(ActionType actionType, long j, PhonebookContact phonebookContact, PhoneAddressBookSnapshotEntry phoneAddressBookSnapshotEntry) {
        this.f2117a = actionType;
        this.f2118b = j;
        this.f2119c = phonebookContact;
        this.f2120d = phoneAddressBookSnapshotEntry;
    }

    static ContactsUploadActionBuilder newBuilder() {
        return new ContactsUploadActionBuilder();
    }
}
