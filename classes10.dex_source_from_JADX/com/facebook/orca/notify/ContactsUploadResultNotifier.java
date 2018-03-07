package com.facebook.orca.notify;

import android.content.res.Resources;
import com.facebook.contacts.upload.ContactsUploadState;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: not visible */
public class ContactsUploadResultNotifier {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ContactsUploadNotificationHandler> f6189a = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GatekeeperStore> f6190b = UltralightRuntime.b;

    public final void m5917a(ContactsUploadState contactsUploadState) {
        if (contactsUploadState.c != 0 && ((GatekeeperStoreImpl) this.f6190b.get()).a(194, false)) {
            ContactsUploadNotificationHandler contactsUploadNotificationHandler = (ContactsUploadNotificationHandler) this.f6189a.get();
            int i = contactsUploadState.c;
            ((DefaultMessagingNotificationHandler) contactsUploadNotificationHandler.f6187a.get()).a(new ContactsUploadNotification(((Resources) contactsUploadNotificationHandler.f6188b.get()).getQuantityString(2131689769, i, new Object[]{Integer.valueOf(i)}), ((Resources) contactsUploadNotificationHandler.f6188b.get()).getQuantityString(2131689770, i), ((Resources) contactsUploadNotificationHandler.f6188b.get()).getQuantityString(2131689769, i, new Object[]{Integer.valueOf(i)})));
        }
    }
}
