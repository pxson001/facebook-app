package com.facebook.messaging.cache;

import com.facebook.debug.log.BLog;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.user.model.User;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;

@VisibleForTesting
/* compiled from: is_featured */
public class MessagesCache {
    public final ThreadsCacheLock f10023a;
    public final Map<ThreadKey, MessagesCollection> f10024b = Maps.c();
    public final Map<String, Message> f10025c = Maps.c();

    public MessagesCache(ThreadsCacheLock threadsCacheLock) {
        this.f10023a = threadsCacheLock;
    }

    public final void m10472a(MessagesCollection messagesCollection, @Nullable User user) {
        this.f10023a.m10459b();
        ThreadKey threadKey = messagesCollection.a;
        m10473a(threadKey);
        this.f10023a.m10459b();
        ImmutableList immutableList = messagesCollection.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) immutableList.get(i);
            this.f10025c.put(message.a, message);
        }
        this.f10024b.put(messagesCollection.a, messagesCollection);
        if (((user != null && user.o) || BLog.b(3)) && !MessagesCollection.a(messagesCollection.b)) {
            String str;
            String str2;
            if (threadKey == null) {
                str = "Unknown";
            } else {
                str = Boolean.toString(threadKey.a == Type.ONE_TO_ONE);
            }
            String str3 = "MessagesOutOfOrderInCache";
            if (messagesCollection.g() > 100) {
                str2 = "Thread messages is not in order in cache";
            } else {
                str2 = "Thread messages is not in order in cache, isCanonicalThread=" + str + ", messagesCollection=" + MessagesCollection.a(messagesCollection);
            }
            BLog.c(str3, str2);
        }
    }

    public final void m10473a(ThreadKey threadKey) {
        this.f10023a.m10459b();
        MessagesCollection messagesCollection = (MessagesCollection) this.f10024b.remove(threadKey);
        if (messagesCollection != null) {
            ImmutableList immutableList = messagesCollection.b;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                this.f10025c.remove(((Message) immutableList.get(i)).a);
            }
        }
    }

    public final MessagesCollection m10474b(ThreadKey threadKey) {
        this.f10023a.m10459b();
        return (MessagesCollection) this.f10024b.get(threadKey);
    }

    public final Message m10469a(ThreadKey threadKey, String str) {
        this.f10023a.m10459b();
        MessagesCollection messagesCollection = (MessagesCollection) this.f10024b.get(threadKey);
        if (messagesCollection == null) {
            return null;
        }
        ImmutableList immutableList = messagesCollection.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) immutableList.get(i);
            if (Objects.equal(message.n, str)) {
                return message;
            }
        }
        return null;
    }

    public final Message m10470a(String str) {
        this.f10023a.m10459b();
        return (Message) this.f10025c.get(str);
    }

    public final void m10471a() {
        this.f10023a.m10459b();
        this.f10024b.clear();
        this.f10025c.clear();
    }
}
