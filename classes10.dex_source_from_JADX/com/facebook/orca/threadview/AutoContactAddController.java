package com.facebook.orca.threadview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.contacts.util.ContactConverterUtil;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.contacts.loader.ContactLoader;
import com.facebook.messaging.contacts.loader.ContactLoader.Callback;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: msg_error_displayed */
public class AutoContactAddController {
    public final Context f6862a;
    public final ContactLoader f6863b;
    public final FbSharedPreferences f6864c;
    private final Lazy<AddToContactListHelper> f6865d;
    private final DefaultAppChoreographer f6866e;
    public final Provider<Boolean> f6867f;
    @Nullable
    public ThreadKey f6868g;
    @Nullable
    public Contact f6869h;

    /* compiled from: msg_error_displayed */
    class C10231 implements Callback {
        final /* synthetic */ AutoContactAddController f6857a;

        C10231(AutoContactAddController autoContactAddController) {
            this.f6857a = autoContactAddController;
        }

        public final void m6507a(OperationResult operationResult) {
            FetchContactsResult fetchContactsResult = (FetchContactsResult) operationResult.k();
            if (fetchContactsResult != null && !fetchContactsResult.a.isEmpty()) {
                Contact contact = (Contact) fetchContactsResult.a.get(0);
                UserKey b = ContactConverterUtil.b(contact);
                UserKey a = ThreadKey.a(this.f6857a.f6868g);
                if (b != null && b.equals(a)) {
                    this.f6857a.f6869h = contact;
                }
            }
        }

        public final void m6508a(Throwable th) {
        }
    }

    /* compiled from: msg_error_displayed */
    public class C10253 {
        public final /* synthetic */ AutoContactAddController f6860a;

        C10253(AutoContactAddController autoContactAddController) {
            this.f6860a = autoContactAddController;
        }
    }

    /* compiled from: msg_error_displayed */
    public class C10264 implements OnClickListener {
        final /* synthetic */ AutoContactAddController f6861a;

        public C10264(AutoContactAddController autoContactAddController) {
            this.f6861a = autoContactAddController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public static AutoContactAddController m6509a(InjectorLike injectorLike) {
        return new AutoContactAddController((Context) injectorLike.getInstance(Context.class), ContactLoader.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 8830), DefaultAppChoreographer.a(injectorLike), IdBasedProvider.a(injectorLike, 4238));
    }

    @Inject
    public AutoContactAddController(Context context, ContactLoader contactLoader, FbSharedPreferences fbSharedPreferences, Lazy<AddToContactListHelper> lazy, AppChoreographer appChoreographer, Provider<Boolean> provider) {
        this.f6862a = context;
        this.f6863b = contactLoader;
        this.f6864c = fbSharedPreferences;
        this.f6865d = lazy;
        this.f6866e = appChoreographer;
        this.f6867f = provider;
        this.f6863b.c = new C10231(this);
    }

    public final void m6512a(ThreadKey threadKey) {
        if (!Objects.equal(threadKey, this.f6868g)) {
            this.f6863b.a();
            this.f6868g = threadKey;
            final UserKey a = ThreadKey.a(this.f6868g);
            if (a != null) {
                this.f6866e.a("AutoContactAddController.setThreadKey", new Runnable(this) {
                    final /* synthetic */ AutoContactAddController f6859b;

                    public void run() {
                        this.f6859b.f6863b.a(a, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE);
                    }
                }, Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI);
            }
        }
    }

    public final void m6511a() {
        this.f6863b.a();
        this.f6868g = null;
        this.f6869h = null;
    }

    public final void m6513b() {
        Object obj;
        if (this.f6869h == null || this.f6869h.v() || this.f6869h.c() == null || !this.f6869h.F()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null && ((Boolean) this.f6867f.get()).booleanValue()) {
            if (!this.f6864c.a(m6510c(this.f6869h.c()), false)) {
                if (!this.f6864c.a(MessagingPrefKeys.ax, false)) {
                    new FbAlertDialogBuilder(this.f6862a).b(2131231797).a(2131230726, new C10264(this)).a(false).b();
                    this.f6864c.edit().putBoolean(MessagingPrefKeys.ax, true).commit();
                }
                ((AddToContactListHelper) this.f6865d.get()).f6792c = new C10253(this);
                ((AddToContactListHelper) this.f6865d.get()).m6465a(this.f6862a, this.f6869h.c(), false);
            }
        }
    }

    public static PrefKey m6510c(String str) {
        return (PrefKey) ((PrefKey) MessagingPrefKeys.S.a(Uri.encode(UserKey.b(str).c()))).a("/auto_add_completed");
    }
}
