package com.facebook.messaging.sms;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.MenuHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.chatheads.ipc.ChatHeadsBroadcaster;
import com.facebook.messaging.phoneintegration.util.OutgoingPhoneCallManager;
import com.facebook.messaging.sms.defaultapp.SmsReceiver;
import com.facebook.user.model.User;
import javax.inject.Inject;

@ContextScoped
/* compiled from: components */
public class SmsContactRowMenuHelper {
    private static SmsContactRowMenuHelper f17443h;
    private static final Object f17444i = new Object();
    public final MenuHandler f17445a = new C20761(this);
    public Context f17446b;
    public InputMethodManager f17447c;
    public SecureContextHelper f17448d;
    public OutgoingPhoneCallManager f17449e;
    public boolean f17450f;
    public ChatHeadsBroadcaster f17451g;

    /* compiled from: components */
    class C20761 implements MenuHandler {
        final /* synthetic */ SmsContactRowMenuHelper f17442a;

        C20761(SmsContactRowMenuHelper smsContactRowMenuHelper) {
            this.f17442a = smsContactRowMenuHelper;
        }

        public final void mo699a(View view) {
            this.f17442a.f17447c.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        public final void mo700a(ContactPickerUserRow contactPickerUserRow, Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(2131820589, menu);
            User user = contactPickerUserRow.f6386a;
            if (!this.f17442a.f17450f) {
                menu.removeItem(2131568691);
            }
            if (user.an() != null) {
                menu.removeItem(2131568694);
            } else {
                menu.removeItem(2131568693);
            }
            if (user.w() == null) {
                menu.removeItem(2131568692);
            }
        }

        public final boolean mo701a(MenuItem menuItem, ContactPickerUserRow contactPickerUserRow) {
            int itemId = menuItem.getItemId();
            User user = contactPickerUserRow.f6386a;
            SmsContactRowMenuHelper smsContactRowMenuHelper;
            String str;
            Intent intent;
            if (itemId == 2131568691) {
                if (user.v()) {
                    smsContactRowMenuHelper = this.f17442a;
                    str = user.w().c;
                    intent = new Intent(smsContactRowMenuHelper.f17446b, SmsReceiver.class);
                    intent.setAction("com.facebook.messaging.sms.COMPOSE_SMS");
                    intent.putExtra("addresses", str);
                    smsContactRowMenuHelper.f17446b.sendBroadcast(intent);
                } else {
                    smsContactRowMenuHelper = this.f17442a;
                    str = user.u();
                    intent = new Intent(smsContactRowMenuHelper.f17446b, SmsReceiver.class);
                    intent.setAction("com.facebook.messaging.sms.COMPOSE_SMS");
                    intent.putExtra("addresses", str);
                    smsContactRowMenuHelper.f17446b.sendBroadcast(intent);
                }
                return true;
            } else if (itemId == 2131568694) {
                String str2;
                SmsContactRowMenuHelper smsContactRowMenuHelper2 = this.f17442a;
                if (user.v()) {
                    str2 = user.w().c;
                } else {
                    str2 = null;
                }
                str = user.u();
                intent = new Intent("android.intent.action.INSERT");
                intent.putExtra("phone", str2);
                intent.putExtra("email", str);
                intent.setType("vnd.android.cursor.dir/raw_contact");
                smsContactRowMenuHelper2.f17448d.b(intent, smsContactRowMenuHelper2.f17446b);
                return true;
            } else if (itemId == 2131568693) {
                smsContactRowMenuHelper = this.f17442a;
                str = user.an();
                intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Contacts.CONTENT_URI.buildUpon().appendPath(str).build(), "vnd.android.cursor.item/contact");
                smsContactRowMenuHelper.f17448d.b(intent, smsContactRowMenuHelper.f17446b);
                return true;
            } else if (itemId != 2131568692) {
                return false;
            } else {
                this.f17442a.f17451g.b();
                this.f17442a.f17449e.m16147a(user.w().b);
                return true;
            }
        }
    }

    private static SmsContactRowMenuHelper m17424b(InjectorLike injectorLike) {
        return new SmsContactRowMenuHelper((Context) injectorLike.getInstance(Context.class), InputMethodManagerMethodAutoProvider.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), OutgoingPhoneCallManager.m16145a(injectorLike), ChatHeadsBroadcaster.a(injectorLike));
    }

    @Inject
    public SmsContactRowMenuHelper(Context context, InputMethodManager inputMethodManager, SecureContextHelper secureContextHelper, OutgoingPhoneCallManager outgoingPhoneCallManager, ChatHeadsBroadcaster chatHeadsBroadcaster) {
        this.f17446b = context;
        this.f17447c = inputMethodManager;
        this.f17448d = secureContextHelper;
        this.f17449e = outgoingPhoneCallManager;
        this.f17451g = chatHeadsBroadcaster;
    }

    public static SmsContactRowMenuHelper m17423a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SmsContactRowMenuHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17444i) {
                SmsContactRowMenuHelper smsContactRowMenuHelper;
                if (a2 != null) {
                    smsContactRowMenuHelper = (SmsContactRowMenuHelper) a2.a(f17444i);
                } else {
                    smsContactRowMenuHelper = f17443h;
                }
                if (smsContactRowMenuHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m17424b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17444i, b3);
                        } else {
                            f17443h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = smsContactRowMenuHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
