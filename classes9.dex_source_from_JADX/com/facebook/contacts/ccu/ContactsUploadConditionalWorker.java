package com.facebook.contacts.ccu;

import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.graphql.calls.ContactUploadSessionCreateAndMaybeBatchUploadInputData;
import com.facebook.graphql.calls.ContinuousContactUploadSettingUpdateInputData.Source;
import com.facebook.graphql.calls.ContinuousContactUploadSettingUpdateInputData.Status;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import javax.inject.Inject;

@UserScoped
/* compiled from: profilePhotoMethod */
public class ContactsUploadConditionalWorker implements ConditionalWorker {
    private static final Object f6213g = new Object();
    private final Clock f6214a;
    private final ContactsUploadClient f6215b;
    private final ContactsUploadStatusHelper f6216c;
    private final FbSharedPreferences f6217d;
    private final RuntimePermissionsUtil f6218e;
    private int f6219f = 0;

    private static ContactsUploadConditionalWorker m6532b(InjectorLike injectorLike) {
        return new ContactsUploadConditionalWorker((Clock) SystemClockMethodAutoProvider.a(injectorLike), ContactsUploadClient.a(injectorLike), ContactsUploadStatusHelper.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public ContactsUploadConditionalWorker(Clock clock, ContactsUploadClient contactsUploadClient, ContactsUploadStatusHelper contactsUploadStatusHelper, FbSharedPreferences fbSharedPreferences, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f6214a = clock;
        this.f6215b = contactsUploadClient;
        this.f6216c = contactsUploadStatusHelper;
        this.f6217d = fbSharedPreferences;
        this.f6218e = runtimePermissionsUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.ccu.ContactsUploadConditionalWorker m6531a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f6213g;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m6532b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f6213g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.ccu.ContactsUploadConditionalWorker) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.ccu.ContactsUploadConditionalWorker) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f6213g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.ccu.ContactsUploadConditionalWorker) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.ccu.ContactsUploadConditionalWorker.a(com.facebook.inject.InjectorLike):com.facebook.contacts.ccu.ContactsUploadConditionalWorker");
    }

    public final boolean m6533a(ConditionalWorkerRunner conditionalWorkerRunner) {
        if (!conditionalWorkerRunner.a()) {
            return false;
        }
        if (!this.f6218e.a("android.permission.READ_CONTACTS")) {
            return false;
        }
        boolean a = this.f6216c.a();
        if (a) {
            this.f6217d.edit().a(ContactsUploadPrefKeys.f6224e).commit();
        }
        boolean a2 = this.f6217d.a(ContactsUploadPrefKeys.f6224e, false);
        TriState b = this.f6216c.b();
        if (b == TriState.UNSET) {
            if (!a2) {
                this.f6215b.a(Status.DEFAULT, Source.CCU_BACKGROUND_PING);
            }
            return false;
        } else if (b == TriState.NO) {
            if (a || !a2) {
                this.f6215b.a(Status.OFF, Source.CCU_BACKGROUND_PING, a);
            }
            return false;
        } else {
            if (a || !a2) {
                this.f6215b.a(Status.ON, Source.CCU_BACKGROUND_PING, a);
            }
            long a3 = this.f6217d.a(AnalyticsPrefKeys.d, -1);
            if (a3 == -1) {
                a3 = this.f6215b.p.i;
            }
            if (this.f6214a.a() - this.f6217d.a(ContactsUploadPrefKeys.f6220a, 0) < a3) {
                this.f6219f = 0;
                return true;
            }
            this.f6215b.a(ContactUploadSessionCreateAndMaybeBatchUploadInputData.Source.FB_CCU_BACKGROUND_PING, false, this.f6219f);
            int i = this.f6219f;
            this.f6219f = i + 1;
            if (i >= this.f6215b.p.f) {
                a = true;
            } else {
                a = false;
            }
            if (!a) {
                return a;
            }
            this.f6219f = 0;
            return a;
        }
    }
}
