package com.facebook.messaging.database.threads;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.database.provider.AbstractContentProviderTable;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.ContentProviderColumnsMapping.ColumnDescriptor;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: max_acceptable_amount */
public class ThreadsProviderTable extends AbstractContentProviderTable {
    private static final ContentProviderColumnsMapping f10821a = ContentProviderColumnsMapping.newBuilder().m11092a("_id", "threads", "_ROWID_").m11092a("thread_key", "threads", "thread_key").m11092a("legacy_thread_id", "threads", "legacy_thread_id").m11092a("action_id", "threads", "action_id").m11092a("refetch_action_id", "threads", "refetch_action_id").m11092a("last_visible_action_id", "threads", "last_visible_action_id").m11092a("sequence_id", "threads", "sequence_id").m11092a("name", "threads", "name").m11092a("senders", "threads", "senders").m11092a("snippet", "threads", "snippet").m11092a("snippet_sender", "threads", "snippet_sender").m11092a("admin_snippet", "threads", "admin_snippet").m11092a("timestamp_ms", "threads", "timestamp_ms").m11092a("last_read_timestamp_ms", "threads", "last_read_timestamp_ms").m11092a("approx_total_message_count", "threads", "approx_total_message_count").m11092a("unread_message_count", "threads", "unread_message_count").m11092a("pic_hash", "threads", "pic_hash").m11092a("can_reply_to", "threads", "can_reply_to").m11092a("cannot_reply_reason", "threads", "cannot_reply_reason").m11092a("pic", "threads", "pic").m11092a("is_subscribed", "threads", "is_subscribed").m11092a("folder", "threads", "folder").m11092a("draft", "threads", "draft").m11092a("last_fetch_time_ms", "threads", "last_fetch_time_ms").m11092a("has_missed_call", "threads", "has_missed_call").m11092a("mute_until", "threads", "mute_until").m11092a("timestamp_in_folder_ms", "folders", "timestamp_ms").m11092a("group_rank", "group_conversations", "rank").m11092a("group_chat_rank", "threads", "group_chat_rank").m11092a("last_fetch_action_id", "threads", "last_fetch_action_id").m11092a("initial_fetch_complete", "threads", "initial_fetch_complete").m11092a("pinned_threads_display_order", "pinned_threads", "display_order").m11092a("me_bubble_color", "threads", "me_bubble_color").m11092a("other_bubble_color", "threads", "other_bubble_color").m11092a("wallpaper_color", "threads", "wallpaper_color").m11092a("custom_like_emoji", "threads", "custom_like_emoji").m11092a("outgoing_message_lifetime", "threads", "outgoing_message_lifetime").m11092a("custom_nicknames", "threads", "custom_nicknames").m11092a("invite_uri", "threads", "invite_uri").m11092a("is_last_message_sponsored", "threads", "is_last_message_sponsored").m11092a("game_data", "threads", "game_data").m11092a("group_type", "threads", "group_type").m11092a("requires_approval", "threads", "requires_approval").m11092a("rtc_call_info", "threads", "rtc_call_info").m11092a("last_message_commerce_message_type", "threads", "last_message_commerce_message_type").m11092a("is_thread_queue_enabled", "threads", "is_thread_queue_enabled").m11093a();
    private static final Object f10822c = new Object();
    private final Provider<ThreadsDatabaseSupplier> f10823b;

    private static ThreadsProviderTable m11256b(InjectorLike injectorLike) {
        return new ThreadsProviderTable(IdBasedProvider.a(injectorLike, 7815));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.database.threads.ThreadsProviderTable m11254a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f10822c;	 Catch:{ all -> 0x006c }
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
        r1 = m11256b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10822c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.database.threads.ThreadsProviderTable) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.database.threads.ThreadsProviderTable) r0;	 Catch:{  }
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
        r0 = f10822c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.database.threads.ThreadsProviderTable) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.ThreadsProviderTable.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.threads.ThreadsProviderTable");
    }

    @Inject
    ThreadsProviderTable(Provider<ThreadsDatabaseSupplier> provider) {
        this.f10823b = provider;
    }

    public final Cursor m11257a(Uri uri, String[] strArr, @Nullable String str, String[] strArr2, @Nullable String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(m11255a(strArr, str, str2));
        return sQLiteQueryBuilder.query(((ThreadsDatabaseSupplier) this.f10823b.get()).a(), strArr, str, strArr2, null, null, str2);
    }

    @VisibleForTesting
    private static String m11255a(String[] strArr, @Nullable String str, @Nullable String str2) {
        Object obj = null;
        Builder builder = ImmutableSet.builder();
        builder.b(strArr);
        String nullToEmpty = Strings.nullToEmpty(str);
        String nullToEmpty2 = Strings.nullToEmpty(str2);
        Iterator it = f10821a.m11095a().iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (nullToEmpty.contains(str3) || nullToEmpty2.contains(str3)) {
                builder.c(str3);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder.append("t._ROWID_ AS _id");
        stringBuilder2.append("threads AS t");
        Iterator it2 = builder.b().iterator();
        Object obj2 = null;
        Object obj3 = null;
        while (it2.hasNext()) {
            str3 = (String) it2.next();
            if (!"_id".equals(str3)) {
                ColumnDescriptor a = f10821a.m11094a(str3);
                if (a == null) {
                    throw new IllegalArgumentException("Unknown field: " + str3);
                } else if ("threads".equals(a.f10427b)) {
                    stringBuilder.append(", t." + a.f10428c + " AS " + a.f10426a);
                } else if ("folders".equals(a.f10427b)) {
                    if (obj3 == null) {
                        stringBuilder2.append(" INNER JOIN folders AS f ON t.thread_key = f.thread_key");
                        r0 = 1;
                    } else {
                        r0 = obj3;
                    }
                    stringBuilder.append(", f." + a.f10428c + " AS " + a.f10426a);
                    obj3 = r0;
                } else if ("group_conversations".equals(a.f10427b)) {
                    if (obj2 == null) {
                        stringBuilder2.append(" INNER JOIN group_conversations AS g ON t.thread_key = g.thread_key");
                        r0 = 1;
                    } else {
                        r0 = obj2;
                    }
                    stringBuilder.append(", g." + a.f10428c + " AS " + a.f10426a);
                    obj2 = r0;
                } else if ("pinned_threads".equals(a.f10427b)) {
                    if (obj == null) {
                        stringBuilder2.append(" INNER JOIN ");
                        stringBuilder2.append("pinned_threads");
                        stringBuilder2.append(" AS p ON t.thread_key = p.thread_key");
                        obj = 1;
                    }
                    stringBuilder.append(", p." + a.f10428c + " AS " + a.f10426a);
                }
            }
            obj = obj;
        }
        return "(SELECT " + stringBuilder.toString() + " FROM " + stringBuilder2.toString() + ")";
    }
}
