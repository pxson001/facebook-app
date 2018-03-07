package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaThreadMuteSettings;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import javax.inject.Inject;

@UserScoped
/* compiled from: press_photo_item_for_select */
public class DeltaThreadMuteSettingsHandler extends AbstractMessagesDeltaHandler {
    private static final Object f4620e = new Object();
    private final DbFetchThreadHandler f4621a;
    private final DbInsertThreadsHandler f4622b;
    private final FbSharedPreferences f4623c;
    private final ThriftModelUtil f4624d;

    private static DeltaThreadMuteSettingsHandler m4190b(InjectorLike injectorLike) {
        return new DeltaThreadMuteSettingsHandler(DbFetchThreadHandler.a(injectorLike), DbInsertThreadsHandler.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ThriftModelUtil.m4260a(injectorLike));
    }

    @Inject
    public DeltaThreadMuteSettingsHandler(DbFetchThreadHandler dbFetchThreadHandler, DbInsertThreadsHandler dbInsertThreadsHandler, FbSharedPreferences fbSharedPreferences, ThriftModelUtil thriftModelUtil) {
        this.f4621a = dbFetchThreadHandler;
        this.f4622b = dbInsertThreadsHandler;
        this.f4623c = fbSharedPreferences;
        this.f4624d = thriftModelUtil;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return RegularImmutableSet.a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaThreadMuteSettingsHandler m4189a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4620e;	 Catch:{ all -> 0x006c }
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
        r1 = m4190b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4620e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadMuteSettingsHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadMuteSettingsHandler) r0;	 Catch:{  }
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
        r0 = f4620e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadMuteSettingsHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaThreadMuteSettingsHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaThreadMuteSettingsHandler");
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeltaThreadMuteSettings m = ((DeltaWrapper) deltaWithSequenceId.a).m();
        FetchThreadResult a = this.f4621a.a(this.f4624d.m4262a(m.threadKey), 0);
        ThreadSummary threadSummary = a.c;
        if (threadSummary != null) {
            PrefKey a2 = MessagingPrefKeys.a(threadSummary.a);
            this.f4622b.a(threadSummary, NotificationSetting.b(m.expireTime.longValue()), a.f);
            this.f4623c.edit().a(a2, m.expireTime.longValue()).commit();
        }
        return new Bundle();
    }

    public final void m4193a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
    }
}
