package com.facebook.messaging.contactsyoumayknow;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import javax.inject.Inject;

/* compiled from: sync disabled */
public class ContactsYouMayKnowNoticeHelper {
    public final FbSharedPreferences f2137a;
    public final ContactsYouMayKnowLogger f2138b;
    private final QeAccessor f2139c;

    @Inject
    public ContactsYouMayKnowNoticeHelper(FbSharedPreferences fbSharedPreferences, ContactsYouMayKnowLogger contactsYouMayKnowLogger, QeAccessor qeAccessor) {
        this.f2137a = fbSharedPreferences;
        this.f2138b = contactsYouMayKnowLogger;
        this.f2139c = qeAccessor;
    }

    public final ListenableFuture<Void> m1938a(Context context, ContactSuggestion contactSuggestion) {
        if (!this.f2139c.a(ExperimentsForContactsYouMayKnowModule.f2164b, false)) {
            return Futures.a(null);
        }
        if (this.f2137a.a(ContactsYouMayKnowPrefKeys.f2140a, false)) {
            return Futures.a(null);
        }
        final ListenableFuture<Void> f = SettableFuture.f();
        new FbAlertDialogBuilder(context).a(context.getResources().getString(2131241197, new Object[]{contactSuggestion.f2078a.k()})).b(context.getResources().getString(2131241198, new Object[]{contactSuggestion.f2078a.e.j()})).a(2131241195, new OnClickListener(this) {
            final /* synthetic */ ContactsYouMayKnowNoticeHelper f2136b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f2136b.f2138b.m1935a("cymk_notice_accepted");
                this.f2136b.f2137a.edit().putBoolean(ContactsYouMayKnowPrefKeys.f2140a, true).commit();
                FutureDetour.a(f, null, 721586992);
            }
        }).b(2131230727, new OnClickListener(this) {
            final /* synthetic */ ContactsYouMayKnowNoticeHelper f2134b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f2134b.f2138b.m1935a("cymk_notice_declined");
                f.a(new Throwable("User declined"));
            }
        }).b();
        this.f2138b.m1935a("cymk_notice_shown");
        return f;
    }
}
