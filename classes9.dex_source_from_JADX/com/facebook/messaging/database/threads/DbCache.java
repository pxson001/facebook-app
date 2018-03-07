package com.facebook.messaging.database.threads;

import android.content.ContentResolver;
import android.database.Cursor;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: me/message_images */
public class DbCache {
    private static final String[] f10431f = new String[]{"thread_key", "last_visible_action_id"};
    private static final String[] f10432g = new String[]{"thread_key"};
    private static final String[] f10433h = new String[]{"thread_key"};
    private static final Object f10434i = new Object();
    private final ContentResolver f10435a;
    private final Provider<MessagesDbContract> f10436b;
    public final DbThreadsPropertyUtil f10437c;
    private final ThreadSummaryCursorUtil f10438d;
    public volatile boolean f10439e;

    private static DbCache m11098b(InjectorLike injectorLike) {
        return new DbCache(ContentResolverMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 7810), DbThreadsPropertyUtil.m11132a(injectorLike), ThreadSummaryCursorUtil.a(injectorLike));
    }

    @Inject
    DbCache(ContentResolver contentResolver, Provider<MessagesDbContract> provider, DbThreadsPropertyUtil dbThreadsPropertyUtil, ThreadSummaryCursorUtil threadSummaryCursorUtil) {
        this.f10435a = contentResolver;
        this.f10436b = provider;
        this.f10437c = dbThreadsPropertyUtil;
        this.f10438d = threadSummaryCursorUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.database.threads.DbCache m11096a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f10434i;	 Catch:{ all -> 0x006c }
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
        r1 = m11098b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10434i;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.database.threads.DbCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.database.threads.DbCache) r0;	 Catch:{  }
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
        r0 = f10434i;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.database.threads.DbCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.DbCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.threads.DbCache");
    }

    public final List<ThreadKey> m11100b(FolderName folderName) {
        Map hashMap = new HashMap();
        Cursor query = this.f10435a.query(((MessagesDbContract) this.f10436b.get()).f10547c.m11142a(), f10431f, "folder=? AND last_fetch_action_id != action_id", new String[]{folderName.dbName}, "timestamp_in_folder_ms DESC LIMIT 25");
        while (query.moveToNext()) {
            try {
                hashMap.put(ThreadKey.a(query.getString(0)), Long.valueOf(query.getLong(1)));
            } finally {
                query.close();
            }
        }
        Expression a = SqlExpression.a("action_id", hashMap.values());
        query = this.f10435a.query(((MessagesDbContract) this.f10436b.get()).f10548d.m11141a(), f10432g, a.a(), a.b(), null);
        while (query.moveToNext()) {
            try {
                hashMap.remove(ThreadKey.a(query.getString(0)));
            } finally {
                query.close();
            }
        }
        return new ArrayList(hashMap.keySet());
    }

    public final List<ThreadKey> m11101c(FolderName folderName) {
        return m11097a(folderName, 25);
    }

    private List<ThreadKey> m11097a(FolderName folderName, int i) {
        Collection hashSet = new HashSet();
        Cursor query = this.f10435a.query(((MessagesDbContract) this.f10436b.get()).f10547c.m11142a(), f10433h, "folder=? AND initial_fetch_complete=0", new String[]{folderName.dbName}, "timestamp_ms DESC LIMIT " + i);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    hashSet.add(ThreadKey.a(query.getString(0)));
                } finally {
                    query.close();
                }
            }
        }
        return new ArrayList(hashSet);
    }

    @Nullable
    public final ThreadSummary m11099a(ThreadKey threadKey) {
        Cursor query = this.f10435a.query(((MessagesDbContract) this.f10436b.get()).f10547c.m11142a(), ThreadSummaryCursorUtil.a, "thread_key=?", new String[]{threadKey.toString()}, null);
        try {
            ThreadSummary b = this.f10438d.a(query).m11161b();
            return b;
        } finally {
            query.close();
        }
    }
}
