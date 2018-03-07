package com.facebook.messaging.service.methods;

import com.facebook.auth.protocol.UserFqlHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.contacts.pictures.ContactPictureSizes;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryByDateComparator;
import com.facebook.messaging.photos.size.MediaSizeUtil;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.module.UserSerialization;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: cvv_code */
public class FetchThreadsFqlHelper {
    private final ThreadSummaryDeserializer f16918a;
    private final UserFqlHelper f16919b;
    private final UserSerialization f16920c;
    private final MessageDeserializer f16921d;
    private final MediaSizeUtil f16922e;
    private final Provider<Boolean> f16923f;
    private final Provider<Boolean> f16924g;
    private final Provider<Boolean> f16925h;
    private final Provider<Boolean> f16926i;
    private final Provider<Boolean> f16927j;
    private final ContactPictureSizes f16928k;
    private final DefaultThreadKeyFactory f16929l;
    private final Clock f16930m;
    private final Provider<Boolean> f16931n;

    /* compiled from: cvv_code */
    public enum MessageTable {
        Normal("unified_message"),
        Sync("unified_message_sync");
        
        public final String name;

        private MessageTable(String str) {
            this.name = str;
        }
    }

    @Immutable
    /* compiled from: cvv_code */
    public class MessagesResult {
        public final ImmutableList<Message> f16905a;
        public final int f16906b;

        public MessagesResult(ImmutableList<Message> immutableList, int i) {
            this.f16905a = immutableList;
            this.f16906b = i;
        }
    }

    @Immutable
    /* compiled from: cvv_code */
    public class PinnedThreadIdsResult {
        public final ImmutableList<String> f16907a;
        public final long f16908b;
        public final boolean f16909c;

        public PinnedThreadIdsResult(List<String> list, long j, boolean z) {
            this.f16907a = ImmutableList.copyOf(list);
            this.f16908b = j;
            this.f16909c = z;
        }
    }

    @Immutable
    /* compiled from: cvv_code */
    public class ThreadListIdsResult {
        public final ImmutableList<String> f16910a;
        public final ImmutableList<String> f16911b;
        public final ImmutableList<String> f16912c;
        public final long f16913d;

        public ThreadListIdsResult(List<String> list, List<String> list2, List<String> list3, long j) {
            this.f16910a = ImmutableList.copyOf(list);
            this.f16911b = ImmutableList.copyOf(list2);
            this.f16912c = ImmutableList.copyOf(list3);
            this.f16913d = j;
        }
    }

    /* compiled from: cvv_code */
    public enum ThreadTable {
        Normal("unified_thread"),
        Sync("unified_thread_sync");
        
        public final String name;

        private ThreadTable(String str) {
            this.name = str;
        }
    }

    @Immutable
    @VisibleForTesting
    /* compiled from: cvv_code */
    public class ThreadsResult {
        public final ImmutableList<ThreadSummary> f16914a;
        public final ImmutableMap<String, ThreadSummary> f16915b;
        public final ImmutableList<User> f16916c;
        public final long f16917d;

        public ThreadsResult(ImmutableList<ThreadSummary> immutableList, ImmutableMap<String, ThreadSummary> immutableMap, ImmutableList<User> immutableList2, long j) {
            this.f16914a = immutableList;
            this.f16915b = immutableMap;
            this.f16916c = immutableList2;
            this.f16917d = j;
        }
    }

    public static FetchThreadsFqlHelper m16938b(InjectorLike injectorLike) {
        return new FetchThreadsFqlHelper(ThreadSummaryDeserializer.m17068b(injectorLike), UserFqlHelper.a(injectorLike), UserSerialization.b(injectorLike), MessageDeserializer.m16978b(injectorLike), MediaSizeUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4075), IdBasedProvider.a(injectorLike, 4371), IdBasedProvider.a(injectorLike, 4106), IdBasedProvider.a(injectorLike, 4192), IdBasedProvider.a(injectorLike, 4058), ContactPictureSizes.a(injectorLike), DefaultThreadKeyFactory.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4060));
    }

    @Inject
    public FetchThreadsFqlHelper(ThreadSummaryDeserializer threadSummaryDeserializer, UserFqlHelper userFqlHelper, UserSerialization userSerialization, MessageDeserializer messageDeserializer, MediaSizeUtil mediaSizeUtil, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, ContactPictureSizes contactPictureSizes, ThreadKeyFactory threadKeyFactory, Clock clock, Provider<Boolean> provider6) {
        this.f16918a = threadSummaryDeserializer;
        this.f16919b = userFqlHelper;
        this.f16920c = userSerialization;
        this.f16921d = messageDeserializer;
        this.f16922e = mediaSizeUtil;
        this.f16923f = provider;
        this.f16924g = provider2;
        this.f16925h = provider3;
        this.f16926i = provider4;
        this.f16927j = provider5;
        this.f16928k = contactPictureSizes;
        this.f16929l = threadKeyFactory;
        this.f16930m = clock;
        this.f16931n = provider6;
    }

    @VisibleForTesting
    public final void m16948a(FqlMultiQueryHelper fqlMultiQueryHelper, String str, int i, ThreadTable threadTable) {
        StringBuilder stringBuilder = new StringBuilder("thread_id");
        if (threadTable.equals(ThreadTable.Sync)) {
            stringBuilder.append(", sync_change_type, archived");
        }
        if (((Boolean) this.f16923f.get()).booleanValue()) {
            stringBuilder.append(", sync_sequence_id");
        }
        fqlMultiQueryHelper.a("thread_list_ids", StringFormatUtil.formatStrLocaleSafe("SELECT %1$s FROM %2$s WHERE %3$s ORDER BY timestamp DESC LIMIT %4$s", stringBuilder.toString(), threadTable.name, str, Integer.valueOf(i)));
    }

    @VisibleForTesting
    public final void m16949a(FqlMultiQueryHelper fqlMultiQueryHelper, String str, int i, boolean z) {
        m16951a(fqlMultiQueryHelper, str, Integer.toString(i), z, true);
    }

    @VisibleForTesting
    public final void m16951a(FqlMultiQueryHelper fqlMultiQueryHelper, String str, String str2, boolean z, boolean z2) {
        String str3 = "threads";
        fqlMultiQueryHelper.a(str3, StringFormatUtil.formatStrLocaleSafe("SELECT %1$s FROM %2$s WHERE %3$s ORDER BY timestamp DESC LIMIT %4$s", "thread_id, thread_fbid, senders, participants, former_participants, object_participants, single_recipient, snippet, unread, num_unread, timestamp, name, pic_hash, mute, can_reply, cannot_reply_reason, snippet_sender, is_subscribed, admin_snippet, archived, folder, client_specified_extra_data" + (z ? ", read_receipts" : "") + (z2 ? ", delivery_receipts" : "") + (((Boolean) this.f16931n.get()).booleanValue() ? "" : ", action_id, last_visible_add_action_id"), ThreadTable.Normal.name, str, str2));
        m16940c(fqlMultiQueryHelper, str3);
    }

    private void m16940c(FqlMultiQueryHelper fqlMultiQueryHelper, String str) {
        fqlMultiQueryHelper.a("participant_profiles", StringFormatUtil.a("SELECT id, name, type, is_commerce FROM profile WHERE id in (SELECT participants.user_id FROM #%1$s)", new Object[]{str}));
        fqlMultiQueryHelper.a("object_participant_profiles", StringFormatUtil.a("SELECT id, name, type FROM profile WHERE id in (SELECT object_participants.id FROM #%1$s)", new Object[]{str}));
        fqlMultiQueryHelper.a("users", StringFormatUtil.a("SELECT uid, first_name, last_name, is_messenger_user, is_partial FROM user WHERE uid IN (SELECT participants.user_id FROM #%1$s)", new Object[]{str}));
        String a = this.f16928k.a();
        String str2 = ((Boolean) this.f16926i.get()).booleanValue() ? "image_format = 'WEBP' AND " : "";
        fqlMultiQueryHelper.a("participant_pics", StringFormatUtil.a("SELECT id, url, size FROM square_profile_pic WHERE %1$ssize in (%2$s) AND id in (SELECT participants.user_id FROM #%3$s)", new Object[]{str2, a, str}));
        fqlMultiQueryHelper.a("object_participant_pics", StringFormatUtil.a("SELECT id, url, size FROM square_profile_pic WHERE %1$ssize in (%2$s) AND id in (SELECT object_participants.id FROM #%3$s)", new Object[]{str2, a, str}));
    }

    @VisibleForTesting
    public final void m16950a(FqlMultiQueryHelper fqlMultiQueryHelper, String str, String str2, int i, MessageTable messageTable) {
        m16954b(fqlMultiQueryHelper, str, str2, i, messageTable);
        m16936a(fqlMultiQueryHelper, str, str2, i);
    }

    public final void m16954b(FqlMultiQueryHelper fqlMultiQueryHelper, String str, String str2, int i, MessageTable messageTable) {
        StringBuilder stringBuilder = new StringBuilder("thread_id, message_id, body, sender, unread, timestamp, attachment_map, share_map, coordinates, log_message, offline_threading_id, tags, app_attribution");
        String str3 = ((Boolean) this.f16931n.get()).booleanValue() ? "" : ", action_id";
        fqlMultiQueryHelper.a("messages", StringFormatUtil.a("SELECT %1$s FROM %2$s WHERE %3$s ORDER BY %4$s LIMIT %5$d", new Object[]{stringBuilder.append(str3).toString(), messageTable.name, str, str2, Integer.valueOf(i)}));
        String str4 = "message_attachment_preview_images";
        String str5 = "SELECT message_id, attachment_id, src, width, height, resize_mode, animated_gif_src, animated_webp_src FROM message_previewable_attachment_src WHERE message_id IN ( SELECT message_id FROM unified_message WHERE %1$s ORDER BY %2$s LIMIT %3$s) and (%4$s)%5$s";
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = this.f16922e.h();
        if (((Boolean) this.f16924g.get()).booleanValue() && ((Boolean) this.f16925h.get()).booleanValue()) {
            str3 = " AND image_format = 'WEBP'";
        } else {
            str3 = "";
        }
        objArr[4] = str3;
        fqlMultiQueryHelper.a(str4, StringFormatUtil.a(str5, objArr));
    }

    @VisibleForTesting
    private void m16936a(FqlMultiQueryHelper fqlMultiQueryHelper, String str, String str2, int i) {
        fqlMultiQueryHelper.a("actions", StringFormatUtil.formatStrLocaleSafe("SELECT %1$s FROM unified_thread_action WHERE %2$s ORDER BY %3$s LIMIT %4$d", "thread_id, type, actor, users, timestamp, body" + (((Boolean) this.f16931n.get()).booleanValue() ? "" : ", action_id"), str, str2, Integer.valueOf(i)));
    }

    @VisibleForTesting
    public final void m16953b(FqlMultiQueryHelper fqlMultiQueryHelper, String str) {
        m16941d(fqlMultiQueryHelper, str);
    }

    @VisibleForTesting
    private void m16941d(FqlMultiQueryHelper fqlMultiQueryHelper, String str) {
        fqlMultiQueryHelper.a("canonical_thread_profile", StringFormatUtil.formatStrLocaleSafe("SELECT id, name, type FROM profile WHERE id IN (%1$s)", str));
        fqlMultiQueryHelper.a("canonical_thread_user", StringFormatUtil.formatStrLocaleSafe("SELECT uid, first_name, last_name FROM user WHERE uid IN (%1$s)", str));
        fqlMultiQueryHelper.a("canonical_thread_pic", StringFormatUtil.formatStrLocaleSafe("SELECT id, url, size FROM square_profile_pic WHERE %1$ssize in (%2$s) AND id IN (%3$s)", ((Boolean) this.f16926i.get()).booleanValue() ? "image_format = 'WEBP' AND " : "", this.f16928k.a(), str));
    }

    @VisibleForTesting
    public static void m16935a(FqlMultiQueryHelper fqlMultiQueryHelper, FolderName folderName) {
        fqlMultiQueryHelper.a("folder_counts", StringFormatUtil.formatStrLocaleSafe("SELECT folder, unread_count, unseen_count, last_seen_time, total_threads, last_action_id FROM unified_message_count WHERE folder='%1$s'", folderName));
    }

    @VisibleForTesting
    public static void m16933a(FqlMultiQueryHelper fqlMultiQueryHelper) {
        fqlMultiQueryHelper.a("user_settings", "SELECT setting, value FROM user_settings WHERE project='messaging'");
    }

    @VisibleForTesting
    public static void m16934a(FqlMultiQueryHelper fqlMultiQueryHelper, long j, int i) {
        fqlMultiQueryHelper.a("pinned_thread_ids", StringFormatUtil.formatStrLocaleSafe("SELECT thread_id, update_time FROM pinned_thread WHERE update_time > %1$d LIMIT %2$d", Long.valueOf(j), Integer.valueOf(i)));
    }

    @VisibleForTesting
    public static void m16939b(FqlMultiQueryHelper fqlMultiQueryHelper) {
        fqlMultiQueryHelper.a("has_pinned_threads", "SELECT thread_id FROM pinned_thread WHERE update_time > 0 LIMIT 1");
    }

    public static ThreadListIdsResult m16931a(FqlResultHelper fqlResultHelper) {
        int i = 0;
        JsonNode a = fqlResultHelper.a("thread_list_ids");
        if (a == null) {
            throw new Exception("Invalid api response - missing thread list ids");
        }
        long j = 0;
        if (a.e() > 0) {
            j = JSONUtil.a(a.a(0).b("sync_sequence_id"), -1);
        }
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        Builder builder3 = ImmutableList.builder();
        while (i < a.e()) {
            JsonNode a2 = a.a(i);
            String b = JSONUtil.b(a2.b("thread_id"));
            if (!"deleted".equals(JSONUtil.b(a2.b("sync_change_type")))) {
                builder.c(b);
            } else if (a2.b("archived").u()) {
                builder3.c(b);
            } else {
                builder2.c(b);
            }
            i++;
        }
        return new ThreadListIdsResult(builder.b(), builder2.b(), builder3.b(), j);
    }

    public static PinnedThreadIdsResult m16937b(FqlResultHelper fqlResultHelper) {
        long j;
        boolean z = false;
        JsonNode a = fqlResultHelper.a("pinned_thread_ids");
        Builder builder = ImmutableList.builder();
        if (a != null) {
            j = Long.MAX_VALUE;
            for (int i = 0; i < a.e(); i++) {
                JsonNode a2 = a.a(i);
                String b = JSONUtil.b(a2.b("thread_id"));
                j = Math.min(j, JSONUtil.a(a2.b("update_time"), Long.MAX_VALUE));
                builder.c(b);
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = 0;
        }
        JsonNode a3 = fqlResultHelper.a("has_pinned_threads");
        if (a3 != null && a3.e() > 0) {
            z = true;
        }
        return new PinnedThreadIdsResult(builder.b(), j, z);
    }

    @VisibleForTesting
    public final ThreadsResult m16955c(FqlResultHelper fqlResultHelper) {
        return m16947a(fqlResultHelper, -1);
    }

    public final ThreadsResult m16947a(FqlResultHelper fqlResultHelper, long j) {
        JsonNode a = fqlResultHelper.a("threads");
        if (a == null) {
            throw new Exception("Invalid api response - missing threads");
        }
        JsonNode a2 = fqlResultHelper.a("object_participant_profiles");
        if (a2 == null) {
            throw new Exception("Invalid api response - missing object_participant_profiles");
        }
        Collection a3 = Lists.a(a.e());
        ImmutableMap.Builder builder = ImmutableMap.builder();
        long j2 = -1;
        boolean booleanValue = ((Boolean) this.f16931n.get()).booleanValue();
        ImmutableMap a4 = m16932a(fqlResultHelper.a("participant_profiles"));
        for (int i = 0; i < a.e(); i++) {
            long b;
            JsonNode a5 = a.a(i);
            ThreadSummaryDeserializer.m17066a((ObjectNode) a5, a2);
            if (booleanValue) {
                b = ActionIdHelper.b(JSONUtil.c(a5.b("timestamp")));
            } else {
                b = JSONUtil.c(a5.b("action_id"));
            }
            j2 = Math.max(b, j2);
            ThreadSummary a6 = this.f16918a.m17069a(a5, j, a4);
            a3.add(a6);
            builder.b(JSONUtil.b(a5.b("thread_id")), a6);
        }
        Collections.sort(a3, new ThreadSummaryByDateComparator());
        return new ThreadsResult(ImmutableList.copyOf(a3), builder.b(), m16945h(fqlResultHelper), j2);
    }

    private static ImmutableMap<String, Boolean> m16932a(JsonNode jsonNode) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (int i = 0; i < jsonNode.e(); i++) {
            JsonNode a = jsonNode.a(i);
            builder.b(JSONUtil.b(a.b("id")), Boolean.valueOf(JSONUtil.g(a.b("is_commerce"))));
        }
        return builder.b();
    }

    private ImmutableList<User> m16945h(FqlResultHelper fqlResultHelper) {
        JsonNode a = fqlResultHelper.a("users");
        JsonNode a2 = fqlResultHelper.a("participant_profiles");
        JsonNode a3 = fqlResultHelper.a("object_participant_profiles");
        JsonNode a4 = fqlResultHelper.a("participant_pics");
        JsonNode a5 = fqlResultHelper.a("object_participant_pics");
        if (a == null) {
            throw new Exception("Invalid api response - missing users");
        } else if (a2 == null) {
            throw new Exception("Invalid api response - missing participant_profiles");
        } else if (a3 == null) {
            throw new Exception("Invalid api response - missing object_participant_profiles");
        } else if (a4 == null) {
            throw new Exception("Invalid api response - missing participant_pics");
        } else if (a5 == null) {
            throw new Exception("Invalid api response - missing object_participant_pics");
        } else {
            return this.f16920c.a(Type.FACEBOOK, UserFqlHelper.a(a, UserFqlHelper.a(new JsonNode[]{a2, a3}), UserFqlHelper.a(new JsonNode[]{a4, a5})));
        }
    }

    public final MessagesResult m16946a(FqlResultHelper fqlResultHelper, int i, ThreadKey threadKey) {
        if (i == 0) {
            return new MessagesResult(RegularImmutableList.a, 0);
        }
        JsonNode a = fqlResultHelper.a("messages");
        if (a == null) {
            throw new Exception("Invalid api response - missing messages");
        }
        JsonNode a2 = fqlResultHelper.a("message_attachment_preview_images");
        if (a2 == null) {
            throw new Exception("Invalid api response - missing message attachment previews");
        }
        JsonNode a3 = fqlResultHelper.a("actions");
        if (a3 != null) {
            return new MessagesResult(this.f16921d.m16980a(a, a2, a3, i, threadKey), a.e() + a3.e());
        }
        throw new Exception("Invalid api response - missing actions");
    }

    public final MessagesResult m16952b(FqlResultHelper fqlResultHelper, int i, ThreadKey threadKey) {
        JsonNode a = fqlResultHelper.a("messages");
        if (a == null) {
            throw new Exception("Invalid api response - missing messages");
        }
        JsonNode a2 = fqlResultHelper.a("message_attachment_preview_images");
        if (a2 != null) {
            return new MessagesResult(this.f16921d.m16980a(a, a2, NullNode.a, i, threadKey), a.e());
        }
        throw new Exception("Invalid api response - missing message attachment previews");
    }

    @VisibleForTesting
    public final User m16956d(FqlResultHelper fqlResultHelper) {
        JsonNode a = fqlResultHelper.a("canonical_thread_user");
        JsonNode a2 = fqlResultHelper.a("canonical_thread_profile");
        JsonNode a3 = fqlResultHelper.a("canonical_thread_pic");
        if (a == null) {
            throw new Exception("Invalid api response - missing canonical_thread_user");
        } else if (a2 == null) {
            throw new Exception("Invalid api response - missing canonical_thread_profile");
        } else if (a3 == null) {
            throw new Exception("Invalid api response - missing canonical_thread_pic");
        } else {
            ImmutableList a4 = this.f16920c.a(Type.FACEBOOK, UserFqlHelper.a(a, a2, a3));
            if (a4.size() > 1) {
                throw new Exception("Invalid api response -- multiple users");
            } else if (a4.size() != 0) {
                return (User) a4.get(0);
            } else {
                throw new Exception("Failed to find user");
            }
        }
    }

    public static FolderName m16942e(FqlResultHelper fqlResultHelper) {
        JsonNode a = fqlResultHelper.a("folder_counts");
        if (a == null) {
            throw new Exception("Invalid api response - missing folder");
        } else if (a.e() == 1) {
            return FolderName.fromDbName(JSONUtil.b(a.a(0).b("folder")));
        } else {
            throw new Exception("Invalid api response - missing folder");
        }
    }

    public static FolderCounts m16943f(FqlResultHelper fqlResultHelper) {
        JsonNode a = fqlResultHelper.a("folder_counts");
        if (a == null) {
            throw new Exception("Invalid api response - missing folder counts");
        } else if (a.e() != 1) {
            throw new Exception("Invalid api response - missing folder counts");
        } else {
            a = a.a(0);
            return new FolderCounts(JSONUtil.d(a.b("unread_count")), JSONUtil.d(a.b("unseen_count")), JSONUtil.c(a.b("last_seen_time")), JSONUtil.c(a.b("last_action_id")));
        }
    }

    public static NotificationSetting m16944g(FqlResultHelper fqlResultHelper) {
        JsonNode a = fqlResultHelper.a("user_settings");
        if (a == null) {
            throw new Exception("Invalid api response - missing user settings");
        }
        for (int i = 0; i < a.e(); i++) {
            JsonNode a2 = a.a(i);
            if ("mute_until".equals(JSONUtil.b(a2.b("setting")))) {
                return NotificationSetting.b(JSONUtil.c(a2.b("value")));
            }
        }
        return null;
    }
}
