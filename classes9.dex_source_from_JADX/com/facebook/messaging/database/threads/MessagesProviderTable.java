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
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: max_num_threads_to_show */
public class MessagesProviderTable extends AbstractContentProviderTable {
    private static final ContentProviderColumnsMapping f10551a = ContentProviderColumnsMapping.newBuilder().m11092a("_id", "messages", "_ROWID_").m11092a("thread_key", "messages", "thread_key").m11092a("msg_id", "messages", "msg_id").m11092a("action_id", "messages", "action_id").m11092a("text", "messages", "text").m11092a("sender", "messages", "sender").m11092a("is_not_forwardable", "messages", "is_not_forwardable").m11092a("timestamp_ms", "messages", "timestamp_ms").m11092a("timestamp_sent_ms", "messages", "timestamp_sent_ms").m11092a("msg_type", "messages", "msg_type").m11092a("affected_users", "messages", "affected_users").m11092a("attachments", "messages", "attachments").m11092a("shares", "messages", "shares").m11092a("sticker_id", "messages", "sticker_id").m11092a("offline_threading_id", "messages", "offline_threading_id").m11092a("source", "messages", "source").m11092a("channel_source", "messages", "channel_source").m11092a("is_non_authoritative", "messages", "is_non_authoritative").m11092a("pending_send_media_attachment", "messages", "pending_send_media_attachment").m11092a("sent_share_attachment", "messages", "sent_share_attachment").m11092a("client_tags", "messages", "client_tags").m11092a("send_error", "messages", "send_error").m11092a("send_error_message", "messages", "send_error_message").m11092a("send_error_number", "messages", "send_error_number").m11092a("send_error_timestamp_ms", "messages", "send_error_timestamp_ms").m11092a("send_error_error_url", "messages", "send_error_error_url").m11092a("send_channel", "messages", "send_channel").m11092a("publicity", "messages", "publicity").m11092a("send_queue_type", "messages", "send_queue_type").m11092a("payment_transaction", "messages", "payment_transaction").m11092a("payment_request", "messages", "payment_request").m11092a("has_unavailable_attachment", "messages", "has_unavailable_attachment").m11092a("app_attribution", "messages", "app_attribution").m11092a("content_app_attribution", "messages", "content_app_attribution").m11092a("xma", "messages", "xma").m11092a("admin_text_type", "messages", "admin_text_type").m11092a("admin_text_theme_color", "messages", "admin_text_theme_color").m11092a("admin_text_thread_icon_emoji", "messages", "admin_text_thread_icon_emoji").m11092a("admin_text_nickname", "messages", "admin_text_nickname").m11092a("admin_text_target_id", "messages", "admin_text_target_id").m11092a("admin_text_thread_message_lifetime", "messages", "admin_text_thread_message_lifetime").m11092a("admin_text_thread_journey_color_choices", "messages", "admin_text_thread_journey_color_choices").m11092a("admin_text_thread_journey_emoji_choices", "messages", "admin_text_thread_journey_emoji_choices").m11092a("admin_text_thread_journey_nickname_choices", "messages", "admin_text_thread_journey_nickname_choices").m11092a("admin_text_thread_journey_bot_choices", "messages", "admin_text_thread_journey_bot_choices").m11092a("message_lifetime", "messages", "message_lifetime").m11092a("admin_text_thread_rtc_event", "messages", "admin_text_thread_rtc_event").m11092a("admin_text_thread_rtc_server_info_data", "messages", "admin_text_thread_rtc_server_info_data").m11092a("admin_text_thread_rtc_is_video_call", "messages", "admin_text_thread_rtc_is_video_call").m11092a("admin_text_thread_ride_provider_name", "messages", "admin_text_thread_ride_provider_name").m11092a("is_sponsored", "messages", "is_sponsored").m11092a("admin_text_thread_ad_properties", "messages", "admin_text_thread_ad_properties").m11092a("admin_text_game_score_data", "messages", "admin_text_game_score_data").m11092a("admin_text_thread_event_reminder_properties", "messages", "admin_text_thread_event_reminder_properties").m11092a("commerce_message_type", "messages", "commerce_message_type").m11092a("customizations", "messages", "customizations").m11092a("admin_text_joinable_event_type", "messages", Columns.ae.d).m11092a("metadata_at_text_ranges", "messages", "metadata_at_text_ranges").m11092a("platform_metadata", "messages", "platform_metadata").m11093a();
    private static final Object f10552c = new Object();
    private final Provider<ThreadsDatabaseSupplier> f10553b;

    private static MessagesProviderTable m11147b(InjectorLike injectorLike) {
        return new MessagesProviderTable(IdBasedProvider.a(injectorLike, 7815));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.database.threads.MessagesProviderTable m11145a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f10552c;	 Catch:{ all -> 0x006c }
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
        r1 = m11147b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10552c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.database.threads.MessagesProviderTable) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.database.threads.MessagesProviderTable) r0;	 Catch:{  }
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
        r0 = f10552c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.database.threads.MessagesProviderTable) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.MessagesProviderTable.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.threads.MessagesProviderTable");
    }

    @Inject
    MessagesProviderTable(Provider<ThreadsDatabaseSupplier> provider) {
        this.f10553b = provider;
    }

    public final Cursor m11148a(Uri uri, String[] strArr, String str, String[] strArr2, @Nullable String str2, @Nullable String str3) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(m11146a(strArr, str, str2));
        return sQLiteQueryBuilder.query(((ThreadsDatabaseSupplier) this.f10553b.get()).a(), strArr, str, strArr2, null, null, str2, str3);
    }

    @VisibleForTesting
    private static String m11146a(String[] strArr, String str, @Nullable String str2) {
        Set<String> c = Sets.c(Arrays.asList(strArr));
        String nullToEmpty = Strings.nullToEmpty(str);
        String nullToEmpty2 = Strings.nullToEmpty(str2);
        Iterator it = f10551a.m11095a().iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (nullToEmpty.contains(str3) || nullToEmpty2.contains(str3)) {
                c.add(str3);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder.append("m._ROWID_ AS _id");
        stringBuilder2.append("messages AS m");
        for (String str32 : c) {
            if (!"_id".equals(str32)) {
                ColumnDescriptor a = f10551a.m11094a(str32);
                if (a == null) {
                    throw new IllegalArgumentException("Unknown field: " + str32);
                } else if ("messages".equals(a.f10427b)) {
                    stringBuilder.append(", m." + a.f10428c + " AS " + a.f10426a);
                }
            }
        }
        return "(SELECT " + stringBuilder.toString() + " FROM " + stringBuilder2.toString() + ")";
    }
}
