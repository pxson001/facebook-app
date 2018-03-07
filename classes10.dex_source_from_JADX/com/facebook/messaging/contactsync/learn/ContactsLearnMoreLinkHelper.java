package com.facebook.messaging.contactsync.learn;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: tablet */
public class ContactsLearnMoreLinkHelper {
    private final SecureContextHelper f2076a;
    private final Context f2077b;

    public static ContactsLearnMoreLinkHelper m1895b(InjectorLike injectorLike) {
        return new ContactsLearnMoreLinkHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    ContactsLearnMoreLinkHelper(SecureContextHelper secureContextHelper, Context context) {
        this.f2076a = secureContextHelper;
        this.f2077b = context;
    }

    public final void m1896a() {
        this.f2076a.a(new Intent(this.f2077b, ContactSyncLearnMoreActivity.class), this.f2077b);
    }
}
