package com.facebook.katana;

import android.content.Intent;
import android.provider.ContactsContract.RawContacts;
import com.facebook.base.service.FbIntentService;
import com.facebook.katana.service.AppSession;

/* compiled from: vanity */
public class RemoveRawContactsService extends FbIntentService {
    private String f673a;

    public RemoveRawContactsService() {
        super("RemoveRawContactsService");
    }

    public void onStart(Intent intent, int i) {
        AppSession a = AppSession.a(this, false);
        if (a != null) {
            this.f673a = a.b().username;
        }
        super.onStart(intent, i);
    }

    protected final void m704a(Intent intent) {
        if (this.f673a != null) {
            getContentResolver().delete(RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.f673a).appendQueryParameter("account_type", "com.facebook.auth.login").appendQueryParameter("caller_is_syncadapter", "true").build(), null, null);
        }
    }
}
