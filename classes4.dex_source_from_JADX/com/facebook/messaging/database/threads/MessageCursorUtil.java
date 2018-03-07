package com.facebook.messaging.database.threads;

import android.database.Cursor;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.database.serialization.DbAppAttributionSerialization;
import com.facebook.messaging.database.serialization.DbAttachmentSerialization;
import com.facebook.messaging.database.serialization.DbMediaResourceSerialization;
import com.facebook.messaging.database.serialization.DbMessageClientTagsSerialization;
import com.facebook.messaging.database.serialization.DbMessageCustomizationSerialization;
import com.facebook.messaging.database.serialization.DbMessageMetadataSerialization;
import com.facebook.messaging.database.serialization.DbMessagePlatformMetadataSerialization;
import com.facebook.messaging.database.serialization.DbParticipantsSerialization;
import com.facebook.messaging.database.serialization.DbPaymentRequestDataSerialization;
import com.facebook.messaging.database.serialization.DbPaymentTransactionDataSerialization;
import com.facebook.messaging.database.serialization.DbSentShareAttachmentSerialization;
import com.facebook.messaging.database.serialization.DbSharesSerialization;
import com.facebook.messaging.messageclassifier.MessageExaminer;
import com.facebook.messaging.model.messages.Message.ChannelSource;
import com.facebook.messaging.model.messages.Message.SendChannel;
import com.facebook.messaging.model.send.PendingSendQueueKey;
import com.facebook.messaging.model.send.PendingSendQueueType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.xma.XMASerialization;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONException;

@Singleton
/* compiled from: low */
public class MessageCursorUtil {
    public static final String[] f8813a = new String[]{"thread_key", "msg_id", "action_id", "text", "is_not_forwardable", "sender", "timestamp_ms", "timestamp_sent_ms", "msg_type", "affected_users", "attachments", "shares", "sticker_id", "offline_threading_id", "source", "channel_source", "is_non_authoritative", "pending_send_media_attachment", "sent_share_attachment", "client_tags", "send_error", "send_error_message", "send_error_number", "send_error_timestamp_ms", "send_error_error_url", "send_channel", "publicity", "send_queue_type", "payment_transaction", "payment_request", "has_unavailable_attachment", "app_attribution", "content_app_attribution", "xma", "admin_text_type", "admin_text_theme_color", "admin_text_thread_icon_emoji", "admin_text_nickname", "admin_text_target_id", "admin_text_thread_message_lifetime", "admin_text_thread_journey_color_choices", "admin_text_thread_journey_emoji_choices", "admin_text_thread_journey_nickname_choices", "admin_text_thread_journey_bot_choices", "message_lifetime", "admin_text_thread_rtc_event", "admin_text_thread_rtc_server_info_data", "admin_text_thread_rtc_is_video_call", "admin_text_thread_ride_provider_name", "is_sponsored", "admin_text_thread_ad_properties", "admin_text_game_score_data", "admin_text_thread_event_reminder_properties", "commerce_message_type", "customizations", "admin_text_joinable_event_type", "metadata_at_text_ranges", "platform_metadata"};
    private static volatile MessageCursorUtil f8814q;
    public final DbParticipantsSerialization f8815b;
    public final DbMediaResourceSerialization f8816c;
    public final DbAttachmentSerialization f8817d;
    public final DbSharesSerialization f8818e;
    public final DbSentShareAttachmentSerialization f8819f;
    public final DbMessageClientTagsSerialization f8820g;
    public final DbPaymentRequestDataSerialization f8821h;
    public final DbPaymentTransactionDataSerialization f8822i;
    public final DbAppAttributionSerialization f8823j;
    private final DbMessageCustomizationSerialization f8824k;
    public final Lazy<DbMessageMetadataSerialization> f8825l;
    public final Lazy<DbMessagePlatformMetadataSerialization> f8826m;
    public final FbObjectMapper f8827n;
    public final XMASerialization f8828o;
    private final MessageExaminer f8829p;

    public static com.facebook.messaging.database.threads.MessageCursorUtil m9136a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8814q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.database.threads.MessageCursorUtil.class;
        monitor-enter(r1);
        r0 = f8814q;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m9138b(r0);	 Catch:{ all -> 0x0035 }
        f8814q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8814q;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.MessageCursorUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.threads.MessageCursorUtil");
    }

    private static MessageCursorUtil m9138b(InjectorLike injectorLike) {
        return new MessageCursorUtil(DbParticipantsSerialization.m9120a(injectorLike), DbMediaResourceSerialization.a(injectorLike), DbAttachmentSerialization.m9146a(injectorLike), DbSharesSerialization.m9151a(injectorLike), DbSentShareAttachmentSerialization.m9179a(injectorLike), DbMessageClientTagsSerialization.m9182a(injectorLike), DbPaymentRequestDataSerialization.m9186a(injectorLike), DbPaymentTransactionDataSerialization.m9189a(injectorLike), DbAppAttributionSerialization.a(injectorLike), DbMessageCustomizationSerialization.m9192a(injectorLike), IdBasedLazy.a(injectorLike, 7800), IdBasedLazy.a(injectorLike, 7801), FbObjectMapperMethodAutoProvider.a(injectorLike), XMASerialization.m9195a(injectorLike), MessageExaminer.a(injectorLike));
    }

    @Inject
    public MessageCursorUtil(DbParticipantsSerialization dbParticipantsSerialization, DbMediaResourceSerialization dbMediaResourceSerialization, DbAttachmentSerialization dbAttachmentSerialization, DbSharesSerialization dbSharesSerialization, DbSentShareAttachmentSerialization dbSentShareAttachmentSerialization, DbMessageClientTagsSerialization dbMessageClientTagsSerialization, DbPaymentRequestDataSerialization dbPaymentRequestDataSerialization, DbPaymentTransactionDataSerialization dbPaymentTransactionDataSerialization, DbAppAttributionSerialization dbAppAttributionSerialization, DbMessageCustomizationSerialization dbMessageCustomizationSerialization, Lazy<DbMessageMetadataSerialization> lazy, Lazy<DbMessagePlatformMetadataSerialization> lazy2, FbObjectMapper fbObjectMapper, XMASerialization xMASerialization, MessageExaminer messageExaminer) {
        this.f8815b = dbParticipantsSerialization;
        this.f8816c = dbMediaResourceSerialization;
        this.f8817d = dbAttachmentSerialization;
        this.f8818e = dbSharesSerialization;
        this.f8819f = dbSentShareAttachmentSerialization;
        this.f8820g = dbMessageClientTagsSerialization;
        this.f8821h = dbPaymentRequestDataSerialization;
        this.f8822i = dbPaymentTransactionDataSerialization;
        this.f8823j = dbAppAttributionSerialization;
        this.f8824k = dbMessageCustomizationSerialization;
        this.f8825l = lazy;
        this.f8826m = lazy2;
        this.f8827n = fbObjectMapper;
        this.f8828o = xMASerialization;
        this.f8829p = messageExaminer;
    }

    public final Iterator m9145a(Cursor cursor) {
        return new Iterator(this, cursor, this.f8829p);
    }

    @Nullable
    public static ImmutableList<String> m9141d(String str) {
        if (str != null) {
            try {
                return JSONUtil.a(new JSONArray(str));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public static <T> ImmutableList m9137a(MessageCursorUtil messageCursorUtil, String str, TypeReference typeReference) {
        if (str != null) {
            try {
                return (ImmutableList) messageCursorUtil.f8827n.a(str, typeReference);
            } catch (IOException e) {
            }
        }
        return null;
    }

    public static <T> Object m9140b(MessageCursorUtil messageCursorUtil, String str, TypeReference typeReference) {
        if (str != null) {
            try {
                return messageCursorUtil.f8827n.a(str, typeReference);
            } catch (IOException e) {
            }
        }
        return null;
    }

    public static ChannelSource m9142e(String str) {
        try {
            return (ChannelSource) Enum.valueOf(ChannelSource.class, str);
        } catch (Throwable e) {
            throw new RuntimeException("Invalid ChannelSource string: " + str, e);
        }
    }

    public static PendingSendQueueKey m9139b(ThreadKey threadKey, @Nullable String str) {
        if (str == null) {
            return null;
        }
        for (PendingSendQueueType pendingSendQueueType : PendingSendQueueType.values()) {
            if (Objects.equal(pendingSendQueueType.serializedValue, str)) {
                return new PendingSendQueueKey(threadKey, pendingSendQueueType);
            }
        }
        return null;
    }

    public static SendChannel m9143f(String str) {
        if (StringUtil.a(str)) {
            return SendChannel.UNKNOWN;
        }
        try {
            return (SendChannel) Enum.valueOf(SendChannel.class, str);
        } catch (IllegalArgumentException e) {
            return SendChannel.UNKNOWN;
        }
    }
}
