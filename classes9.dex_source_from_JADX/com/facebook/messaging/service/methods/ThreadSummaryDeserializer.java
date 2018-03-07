package com.facebook.messaging.service.methods;

import android.net.Uri;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLMessageThreadCannotReplyReason;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: credential identifier cannot be null */
public class ThreadSummaryDeserializer {
    private final ParticipantInfoDeserializer f16988a;
    private final Provider<User> f16989b;
    private final Provider<Boolean> f16990c;
    private final DefaultThreadKeyFactory f16991d;

    public static ThreadSummaryDeserializer m17068b(InjectorLike injectorLike) {
        return new ThreadSummaryDeserializer(ParticipantInfoDeserializer.m16987a(injectorLike), IdBasedProvider.a(injectorLike, 3595), IdBasedProvider.a(injectorLike, 4060), DefaultThreadKeyFactory.b(injectorLike));
    }

    @Inject
    public ThreadSummaryDeserializer(ParticipantInfoDeserializer participantInfoDeserializer, Provider<User> provider, Provider<Boolean> provider2, ThreadKeyFactory threadKeyFactory) {
        this.f16988a = participantInfoDeserializer;
        this.f16989b = provider;
        this.f16990c = provider2;
        this.f16991d = threadKeyFactory;
    }

    public final ThreadSummary m17069a(JsonNode jsonNode, long j, ImmutableMap<String, Boolean> immutableMap) {
        Map map;
        ThreadSummaryBuilder newBuilder = ThreadSummary.newBuilder();
        newBuilder.b = JSONUtil.b(jsonNode.b("thread_id"));
        newBuilder.d = j;
        String b = JSONUtil.b(jsonNode.b("single_recipient"));
        if (b != null) {
            newBuilder.a = this.f16991d.a(Long.parseLong(b));
        } else {
            newBuilder.a = ThreadKey.a(Long.parseLong(JSONUtil.b(jsonNode.b("thread_fbid"))));
        }
        long c = JSONUtil.c(jsonNode.b("timestamp"));
        long b2 = ((Boolean) this.f16990c.get()).booleanValue() ? ActionIdHelper.b(c) : JSONUtil.c(jsonNode.b("action_id"));
        newBuilder.c(b2);
        newBuilder.e(c);
        boolean u = jsonNode.b("unread").u();
        long j2 = u ? 1 : 0;
        if (u) {
            c = 0;
        }
        newBuilder.f(c);
        newBuilder.h(j2);
        newBuilder.g(1);
        if (jsonNode.d("snippet")) {
            newBuilder.p = JSONUtil.b(jsonNode.b("snippet"));
        }
        if (JSONUtil.b(jsonNode.b("refetch_action_id")) != null) {
            newBuilder.a(JSONUtil.c(jsonNode.b("refetch_action_id")));
        } else {
            newBuilder.a(b2);
        }
        if (JSONUtil.b(jsonNode.b("last_visible_add_action_id")) != null) {
            newBuilder.b(JSONUtil.c(jsonNode.b("last_visible_add_action_id")));
        } else {
            newBuilder.b(b2);
        }
        if (JSONUtil.a(jsonNode.b("pic_hash"))) {
            newBuilder.s = JSONUtil.b(jsonNode.b("pic_hash"));
        }
        JsonNode b3 = jsonNode.b("read_receipts");
        if (b3 != null) {
            Map a = Maps.a(b3.e());
            Iterator it = b3.iterator();
            while (it.hasNext()) {
                JsonNode jsonNode2 = (JsonNode) it.next();
                a.put(new UserKey(Type.FACEBOOK, JSONUtil.b(jsonNode2.b("uid"))).c(), Long.valueOf(JSONUtil.c(jsonNode2.b("time"))));
            }
            map = a;
        } else {
            map = null;
        }
        JsonNode b4 = jsonNode.b("delivery_receipts");
        Map map2 = null;
        if (b4 != null) {
            Map a2 = Maps.a(b4.e());
            Iterator H = b4.H();
            while (H.hasNext()) {
                Entry entry = (Entry) H.next();
                a2.put(new UserKey(Type.FACEBOOK, (String) entry.getKey()).c(), Long.valueOf(JSONUtil.c(((JsonNode) entry.getValue()).b("time"))));
            }
            map2 = a2;
        }
        ImmutableList a3 = m17065a(jsonNode.b("participants"), map, map2, immutableMap);
        ImmutableList a4 = m17064a(jsonNode.b("former_participants"), (ImmutableMap) immutableMap);
        newBuilder.h = a3;
        newBuilder.i = a4;
        JsonNode b5 = jsonNode.b("mute");
        User user = (User) this.f16989b.get();
        if (!(user == null || b5 == null || !b5.i())) {
            int size = a3.size();
            int i = 0;
            while (i < size) {
                ThreadParticipant threadParticipant = (ThreadParticipant) a3.get(i);
                if (!user.d().equals(threadParticipant.b().b())) {
                    i++;
                } else if (b5.d(threadParticipant.c())) {
                    newBuilder.C = NotificationSetting.b(JSONUtil.c(b5.b(threadParticipant.c())));
                }
            }
        }
        newBuilder.o = this.f16988a.m16989a(jsonNode.b("senders"));
        if (JSONUtil.a(jsonNode.b("pic"))) {
            newBuilder.t = Uri.parse(JSONUtil.b(jsonNode.b("pic")));
        }
        Object b6 = JSONUtil.b(jsonNode.b("name"));
        if (!StringUtil.a(b6)) {
            newBuilder.g = b6;
        }
        boolean u2 = jsonNode.b("is_subscribed").u();
        newBuilder.w = u2;
        if (JSONUtil.a(jsonNode.b("snippet_sender"))) {
            newBuilder.q = this.f16988a.m16990b(jsonNode.b("snippet_sender"));
        }
        if (JSONUtil.a(jsonNode.b("admin_snippet"))) {
            newBuilder.r = JSONUtil.b(jsonNode.b("admin_snippet"));
        }
        if (jsonNode.d("client_specified_extra_data") && jsonNode.b("client_specified_extra_data").i() && "missed".equals(JSONUtil.b(jsonNode.b("client_specified_extra_data").b("call_message_type")))) {
            newBuilder.y = true;
        }
        boolean u3 = jsonNode.b("can_reply").u();
        if (!u2) {
            u3 = false;
        }
        newBuilder.u = u3;
        newBuilder.v = GraphQLMessageThreadCannotReplyReason.fromString(JSONUtil.b(jsonNode.b("cannot_reply_reason")));
        if (JSONUtil.a(jsonNode.b("archived")) && jsonNode.b("archived").u()) {
            newBuilder.A = FolderName.NONE;
        } else if (JSONUtil.a(jsonNode.b("folder"))) {
            newBuilder.A = FolderName.fromDbName(JSONUtil.b(jsonNode.b("folder")));
        }
        return newBuilder.V();
    }

    private ImmutableList<ThreadParticipant> m17064a(JsonNode jsonNode, ImmutableMap<String, Boolean> immutableMap) {
        return m17065a(jsonNode, null, null, immutableMap);
    }

    private ImmutableList<ThreadParticipant> m17065a(JsonNode jsonNode, @Nullable Map<String, Long> map, @Nullable Map<String, Long> map2, ImmutableMap<String, Boolean> immutableMap) {
        Set hashSet = new HashSet();
        Builder builder = ImmutableList.builder();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            ThreadParticipant b = m17067b((JsonNode) it.next(), map, map2, immutableMap);
            if (b.b().d() && !hashSet.contains(b.b())) {
                hashSet.add(b.b());
                builder.c(b);
            }
        }
        return builder.b();
    }

    private ThreadParticipant m17067b(JsonNode jsonNode, @Nullable Map<String, Long> map, Map<String, Long> map2, ImmutableMap<String, Boolean> immutableMap) {
        Long l;
        ParticipantInfo a = ParticipantInfoDeserializer.m16986a(jsonNode, immutableMap);
        ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
        threadParticipantBuilder.a = a;
        if (!(map == null || a.b == null)) {
            l = (Long) map.get(a.b.c());
            if (l != null) {
                threadParticipantBuilder.b = l.longValue();
            }
        }
        if (!(map2 == null || a.b == null)) {
            l = (Long) map2.get(a.b.c());
            if (l != null) {
                threadParticipantBuilder.d = l.longValue();
            }
        }
        return threadParticipantBuilder.f();
    }

    public static void m17066a(ObjectNode objectNode, JsonNode jsonNode) {
        Object obj = null;
        JsonNode b = objectNode.b("object_participants");
        for (int i = 0; i < b.e(); i++) {
            JsonNode a = b.a(i);
            if (JSONUtil.d(a.b("object_address_type")) == 2) {
                obj = JSONUtil.b(a.b("id"));
                break;
            }
        }
        if (obj != null) {
            Iterator it = jsonNode.iterator();
            while (it.hasNext()) {
                JsonNode jsonNode2 = (JsonNode) it.next();
                if (Objects.equal(JSONUtil.b(jsonNode2.b("id")), obj)) {
                    objectNode.c("name", jsonNode2.b("name"));
                    objectNode.c("pic", jsonNode2.b("pic_big"));
                    return;
                }
            }
        }
    }
}
