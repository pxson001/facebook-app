package com.facebook.messaging.photoreminders.omnistore;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.photoreminders.PhotoRemindersGatekeepers;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.Delta;
import com.facebook.omnistore.Delta.Type;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.Omnistore.DeltaReceivedCallback;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: registration_step_back */
public class PhotoRemindersCollectionCallback implements DeltaReceivedCallback {
    private static final String f3575a = PhotoRemindersCollectionCallback.class.getSimpleName();
    private static final Object f3576h = new Object();
    private final FbSharedPreferences f3577b;
    private final Provider<CollectionName> f3578c;
    private final Provider<Omnistore> f3579d;
    private final PhotoRemindersGatekeepers f3580e;
    private final String f3581f;
    private boolean f3582g;

    private static PhotoRemindersCollectionCallback m3407b(InjectorLike injectorLike) {
        return new PhotoRemindersCollectionCallback((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PhotoRemindersGatekeepers.b(injectorLike), IdBasedProvider.a(injectorLike, 2860), IdBasedProvider.a(injectorLike, 2863), String_LoggedInUserIdMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public PhotoRemindersCollectionCallback(FbSharedPreferences fbSharedPreferences, PhotoRemindersGatekeepers photoRemindersGatekeepers, Provider<CollectionName> provider, Provider<Omnistore> provider2, String str) {
        this.f3577b = fbSharedPreferences;
        this.f3580e = photoRemindersGatekeepers;
        this.f3579d = provider2;
        this.f3578c = provider;
        this.f3581f = str;
        m3408a();
    }

    public final boolean m3408a() {
        if (!(this.f3582g || !this.f3580e.b() || this.f3577b.a(MessagingPrefKeys.az) || this.f3581f == null)) {
            ((Omnistore) this.f3579d.get()).addDeltaReceivedCallback(this);
            this.f3582g = true;
        }
        return this.f3582g;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.photoreminders.omnistore.PhotoRemindersCollectionCallback m3406a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3576h;	 Catch:{ all -> 0x006c }
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
        r1 = m3407b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3576h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.photoreminders.omnistore.PhotoRemindersCollectionCallback) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.photoreminders.omnistore.PhotoRemindersCollectionCallback) r0;	 Catch:{  }
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
        r0 = f3576h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.photoreminders.omnistore.PhotoRemindersCollectionCallback) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.photoreminders.omnistore.PhotoRemindersCollectionCallback.a(com.facebook.inject.InjectorLike):com.facebook.messaging.photoreminders.omnistore.PhotoRemindersCollectionCallback");
    }

    public void onDeltaReceived(Delta[] deltaArr) {
        if (!this.f3577b.a(MessagingPrefKeys.az)) {
            CollectionName collectionName = (CollectionName) this.f3578c.get();
            if (collectionName != null) {
                Boolean bool = null;
                int length = deltaArr.length;
                int i = 0;
                while (i < length) {
                    Boolean bool2;
                    Delta delta = deltaArr[i];
                    if (collectionName.equals(delta.mCollectionName) && !delta.mType.equals(Type.DELETE)) {
                        Boolean bool3;
                        if (delta == null || delta.mBlob == null) {
                            bool3 = null;
                        } else {
                            bool3 = Boolean.valueOf(delta.mBlob.getInt() > 0);
                        }
                        bool2 = bool3;
                        if (bool2 != null) {
                            i++;
                            bool = bool2;
                        }
                    }
                    bool2 = bool;
                    i++;
                    bool = bool2;
                }
                if (bool != null) {
                    this.f3577b.edit().putBoolean(MessagingPrefKeys.az, bool.booleanValue()).commit();
                }
            }
        }
    }
}
