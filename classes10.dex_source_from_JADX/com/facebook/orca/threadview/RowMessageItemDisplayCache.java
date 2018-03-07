package com.facebook.orca.threadview;

import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.messaging.model.messages.Message;
import javax.inject.Inject;

@UserScoped
/* compiled from: message_menu_dialog */
public class RowMessageItemDisplayCache extends LruCache<String, Entry> implements IHaveUserData {
    private static final Object f7377a = new Object();

    /* compiled from: message_menu_dialog */
    public final class Entry {
        @Nullable
        public Boolean f7374a;
        @Nullable
        private Boolean f7375b;
        @Nullable
        private Boolean f7376c;

        @Nullable
        public final Boolean m7024b() {
            return this.f7375b;
        }

        public final Boolean m7025b(Boolean bool) {
            this.f7375b = bool;
            return this.f7375b;
        }

        @Nullable
        public final Boolean m7026c() {
            return this.f7376c;
        }

        public final Boolean m7027c(Boolean bool) {
            this.f7376c = bool;
            return this.f7376c;
        }
    }

    private static RowMessageItemDisplayCache m7029e() {
        return new RowMessageItemDisplayCache();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.orca.threadview.RowMessageItemDisplayCache m7028a(com.facebook.inject.InjectorLike r7) {
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
        r4 = r3.b();	 Catch:{ all -> 0x006b }
        r1 = f7377a;	 Catch:{ all -> 0x006b }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006b }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006b }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007b;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0066 }
        r6.e();	 Catch:{ all -> 0x0061 }
        r1 = m7029e();	 Catch:{ all -> 0x0061 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0070;
    L_0x004c:
        r0 = f7377a;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.orca.threadview.RowMessageItemDisplayCache) r0;	 Catch:{  }
    L_0x0056:
        if (r0 == 0) goto L_0x0079;
    L_0x0058:
        r2.c(r5);	 Catch:{  }
    L_0x005b:
        r0 = (com.facebook.orca.threadview.RowMessageItemDisplayCache) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0061:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0066:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006b:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0070:
        r0 = f7377a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.orca.threadview.RowMessageItemDisplayCache) r0;	 Catch:{  }
        goto L_0x0056;
    L_0x0079:
        r0 = r1;
        goto L_0x0058;
    L_0x007b:
        r0 = r1;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadview.RowMessageItemDisplayCache.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadview.RowMessageItemDisplayCache");
    }

    @Inject
    public RowMessageItemDisplayCache() {
        super(50);
    }

    public void clearUserData() {
        a();
    }

    public final Entry m7030a(Message message) {
        Entry entry = (Entry) a(message.a);
        if (entry != null) {
            return entry;
        }
        entry = new Entry();
        a(message.a, entry);
        return entry;
    }
}
