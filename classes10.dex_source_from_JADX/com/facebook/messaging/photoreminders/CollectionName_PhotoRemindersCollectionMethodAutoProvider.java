package com.facebook.messaging.photoreminders;

import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.module.OmnistoreMethodAutoProvider;

/* compiled from: removeAdminsDialog */
public class CollectionName_PhotoRemindersCollectionMethodAutoProvider extends AbstractProvider<CollectionName> {
    private static final Object f3504a = new Object();

    private static CollectionName m3384b(InjectorLike injectorLike) {
        return MessagingPhotoRemindersModule.a((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), OmnistoreMethodAutoProvider.getInstance__com_facebook_omnistore_Omnistore__INJECTED_BY_TemplateInjector(injectorLike), String_ViewerContextUserIdMethodAutoProvider.b(injectorLike), User_LoggedInUserMethodAutoProvider.b(injectorLike));
    }

    public Object get() {
        return MessagingPhotoRemindersModule.a((AbstractFbErrorReporter) FbErrorReporterImpl.a(this), OmnistoreMethodAutoProvider.getInstance__com_facebook_omnistore_Omnistore__INJECTED_BY_TemplateInjector(this), String_ViewerContextUserIdMethodAutoProvider.b(this), User_LoggedInUserMethodAutoProvider.b(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.omnistore.CollectionName m3383a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3504a;	 Catch:{ all -> 0x006c }
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
        r1 = m3384b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3504a;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.omnistore.CollectionName) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.omnistore.CollectionName) r0;	 Catch:{  }
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
        r0 = f3504a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.omnistore.CollectionName) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.photoreminders.CollectionName_PhotoRemindersCollectionMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.omnistore.CollectionName");
    }
}
