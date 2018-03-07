package com.facebook.messaging.cache;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.debug.log.BLog;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.ThreadsCacheLock.CloseableLock;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageDraft;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.MessagesCollectionMerger;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.service.model.UpdateMessageSendErrorParams;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@ThreadSafe
/* compiled from: is_in_chat_heads */
public class ThreadsCache implements IHaveUserData {
    private static final Class<?> f10000a = ThreadsCache.class;
    private final CacheType f10001b;
    private final Lazy<MessagesCollectionMerger> f10002c;
    private final Lazy<ThreadSummaryStitching> f10003d;
    private final MessageUtil f10004e;
    private final Provider<User> f10005f;
    private final Provider<Boolean> f10006g;
    private final Lazy<GloballyDeletedMessagesPlaceholderCache> f10007h;
    private final GatekeeperStoreImpl f10008i;
    private final Lazy<MessengerUserNameUtil> f10009j;
    private final ThreadsCacheLock f10010k = new ThreadsCacheLock();
    private final ThreadSummariesCache f10011l = new ThreadSummariesCache(this.f10010k);
    private final MessagesCache f10012m = new MessagesCache(this.f10010k);
    private final PinnedThreadsCache f10013n = new PinnedThreadsCache(this.f10010k);
    private final EventReminderMembersCache f10014o = new EventReminderMembersCache(this.f10010k);
    @GuardedBy("mThreadsCacheLock")
    private final Map<FolderName, FolderCacheData> f10015p = new HashMap();

    /* compiled from: is_in_chat_heads */
    public enum CacheType {
        FACEBOOK("facebookMessages"),
        SMS("smsMessages"),
        TINCAN("tincanMessages");
        
        public final String logName;

        private CacheType(String str) {
            this.logName = str;
        }
    }

    @Inject
    public ThreadsCache(@Assisted CacheType cacheType, Lazy<MessagesCollectionMerger> lazy, Lazy<ThreadSummaryStitching> lazy2, MessageUtil messageUtil, Provider<User> provider, Provider<Boolean> provider2, Lazy<GloballyDeletedMessagesPlaceholderCache> lazy3, GatekeeperStore gatekeeperStore, Lazy<MessengerUserNameUtil> lazy4) {
        this.f10001b = cacheType;
        this.f10002c = lazy;
        this.f10003d = lazy2;
        this.f10004e = messageUtil;
        this.f10005f = provider;
        this.f10006g = provider2;
        this.f10007h = lazy3;
        this.f10008i = gatekeeperStore;
        this.f10009j = lazy4;
    }

    @VisibleForTesting
    private FolderCacheData m10408g(FolderName folderName) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            FolderCacheData folderCacheData = (FolderCacheData) this.f10015p.get(folderName);
            if (folderCacheData == null) {
                folderCacheData = new FolderCacheData(folderName, this.f10010k);
                this.f10015p.put(folderName, folderCacheData);
            }
            if (a != null) {
                a.close();
            }
            return folderCacheData;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final boolean m10436a(FolderName folderName) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            boolean c = m10408g(folderName).c();
            if (a != null) {
                a.close();
            }
            return c;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final boolean m10443b(FolderName folderName) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            boolean d = m10408g(folderName).d();
            if (a != null) {
                a.close();
            }
            return d;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    private void m10407e() {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            for (FolderCacheData c : this.f10015p.values()) {
                c.c(false);
            }
            this.f10013n.m10481b(false);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10447c(FolderName folderName) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            ((FolderCacheData) this.f10015p.get(folderName)).c(false);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    private static Message m10402b(MessagesCollection messagesCollection) {
        ImmutableList immutableList = messagesCollection.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) immutableList.get(i);
            if (!message.o) {
                return message;
            }
        }
        return null;
    }

    @Nullable
    public final ThreadSummary m10410a(ThreadKey threadKey) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadKey);
            ThreadSummary b = this.f10011l.m10465b(threadKey);
            if (a != null) {
                a.close();
            }
            return b;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    final ThreadSummary m10412a(String str) {
        FolderName folderName = FolderName.INBOX;
        return m10406d(str);
    }

    private ThreadSummary m10406d(String str) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            Preconditions.checkState(this.f10001b == CacheType.FACEBOOK, "Tried to get thread by threadID in non facebook messages cache");
            ThreadSummary a2 = this.f10011l.m10461a(str);
            if (a != null) {
                a.close();
            }
            return a2;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final ThreadSummary m10411a(ThreadCriteria threadCriteria) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            ThreadSummary b;
            if (threadCriteria.a() != null) {
                b = this.f10011l.m10465b(threadCriteria.a());
                if (a != null) {
                    a.close();
                }
            } else {
                b = this.f10011l.m10461a(threadCriteria.a);
                if (a != null) {
                    a.close();
                }
            }
            return b;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10418a(FolderName folderName, ThreadsCollection threadsCollection, long j, boolean z) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            int i;
            FolderCacheData g = m10408g(folderName);
            g.g();
            ImmutableList b = threadsCollection.b();
            int size = b.size();
            for (i = 0; i < size; i++) {
                ThreadSummary threadSummary = (ThreadSummary) b.get(i);
                m10409i(threadSummary.a);
                ThreadSummary a2 = m10410a(threadSummary.a);
                if (a2 == null || threadSummary.d == -1 || threadSummary.d >= a2.d) {
                    g.a(threadSummary);
                    m10428a(threadSummary, j);
                } else {
                    ThreadKey threadKey = a2.a;
                    Long.valueOf(a2.d);
                    Long.valueOf(threadSummary.d);
                    g.a(a2);
                }
            }
            g.b(true);
            g.c(!z);
            g.a(j);
            b = threadsCollection.b();
            size = b.size();
            for (i = 0; i < size; i++) {
                m10404b((ThreadSummary) b.get(i));
            }
            this.f10011l.m10462a();
            g.a(threadsCollection.c());
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10417a(FolderName folderName, ThreadsCollection threadsCollection, long j) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            FolderCacheData g = m10408g(folderName);
            ImmutableList b = threadsCollection.b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                ThreadSummary threadSummary = (ThreadSummary) b.get(i);
                m10409i(threadSummary.a);
                g.a(threadSummary);
                m10428a(threadSummary, j);
            }
            g.a(threadsCollection.c());
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10428a(ThreadSummary threadSummary, long j) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10427a(threadSummary);
            this.f10011l.m10468d(threadSummary.a).c(j);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10427a(ThreadSummary threadSummary) {
        m10429a(threadSummary, null);
    }

    public final void m10429a(ThreadSummary threadSummary, @Nullable MessageDraft messageDraft) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadSummary.a);
            ThreadSummary V = ThreadSummary.newBuilder().a(threadSummary).a(messageDraft).V();
            FolderCacheData g = m10408g(V.A);
            m10397a(V, this.f10011l.m10465b(V.a));
            this.f10011l.m10463a(V);
            g.b(V);
            m10404b(V);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    @Nullable
    public final Message m10438b(String str) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            Message a2 = this.f10012m.m10470a(str);
            if (a != null) {
                a.close();
            }
            return a2;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final ThreadsCollection m10450d(FolderName folderName) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            FolderCacheData g = m10408g(folderName);
            ThreadsCollection threadsCollection = new ThreadsCollection(ImmutableList.copyOf(g.a().a()), g.b());
            if (a != null) {
                a.close();
            }
            return threadsCollection;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final MessagesCollection m10439b(ThreadKey threadKey) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadKey);
            MessagesCollection b = this.f10012m.m10474b(threadKey);
            if (a != null) {
                a.close();
            }
            return b;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10422a(MessagesCollection messagesCollection) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            ThreadKey a2 = messagesCollection.a();
            m10409i(a2);
            this.f10012m.m10472a(messagesCollection, (User) this.f10005f.get());
            this.f10011l.m10468d(a2).c();
            ThreadSummary b = this.f10011l.m10465b(a2);
            if (b == null) {
                m10407e();
            } else if (!m10400a(b, messagesCollection.c())) {
                m10407e();
            }
            m10405c(messagesCollection);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus> m10446c(String str) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus> a2 = this.f10014o.m10485a(str);
            if (a != null) {
                a.close();
            }
            return a2;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10433a(ImmutableList<ThreadEventReminder> immutableList) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            this.f10014o.m10486a((ImmutableList) immutableList);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    private static boolean m10400a(ThreadSummary threadSummary, @Nullable Message message) {
        if (message == null && threadSummary == null) {
            return true;
        }
        if (threadSummary == null || message == null) {
            if (threadSummary != null && ThreadKey.d(threadSummary.a) && threadSummary.f == 0) {
                return true;
            }
            return false;
        } else if (threadSummary.f == -1 || threadSummary.f == message.g) {
            return true;
        } else {
            return false;
        }
    }

    private void m10404b(ThreadSummary threadSummary) {
        ThreadLocalState d = this.f10011l.m10468d(threadSummary.a);
        if (threadSummary.f()) {
            d.a(threadSummary.c - 1);
        } else {
            d.a(threadSummary.c);
        }
    }

    public final void m10416a(FolderName folderName, ThreadKey threadKey) {
        ImmutableList immutableList;
        m10409i(threadKey);
        if (threadKey == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.of(threadKey);
        }
        m10419a(folderName, immutableList);
    }

    public final void m10419a(FolderName folderName, ImmutableList<ThreadKey> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadKey threadKey = (ThreadKey) immutableList.get(i);
            m10409i(threadKey);
            m10403b(folderName, threadKey);
        }
    }

    private void m10403b(@Nullable FolderName folderName, ThreadKey threadKey) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            this.f10011l.m10460a(threadKey);
            this.f10013n.m10482b(threadKey);
            this.f10012m.m10473a(threadKey);
            if (folderName != null) {
                m10408g(folderName).a(threadKey);
            }
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10425a(ThreadKey threadKey, Set<String> set) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadKey);
            MessagesCollection b = this.f10012m.m10474b(threadKey);
            if (b != null) {
                this.f10012m.m10472a(m10392a(b, (Set) set), (User) this.f10005f.get());
                m10399a(b.b(), (Set) set);
                if (a != null) {
                    a.close();
                    return;
                }
                return;
            } else if (a != null) {
                a.close();
                return;
            } else {
                return;
            }
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    private static MessagesCollection m10392a(MessagesCollection messagesCollection, Set<String> set) {
        Builder builder = ImmutableList.builder();
        ImmutableList immutableList = messagesCollection.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) immutableList.get(i);
            if (!set.contains(message.a)) {
                builder.c(message);
            }
        }
        return new MessagesCollection(messagesCollection.a, builder.b(), messagesCollection.c);
    }

    private void m10399a(List<Message> list, Set<String> set) {
        for (Message message : list) {
            if (set.contains(message.a)) {
                ((GloballyDeletedMessagesPlaceholderCache) this.f10007h.get()).a(message, ((MessengerUserNameUtil) this.f10009j.get()).m10369a(message.e));
            }
            GloballyDeletedMessagesPlaceholderCache globallyDeletedMessagesPlaceholderCache = (GloballyDeletedMessagesPlaceholderCache) this.f10007h.get();
            globallyDeletedMessagesPlaceholderCache.i.remove(message.a);
        }
    }

    public final boolean m10437a(ThreadKey threadKey, int i) {
        Throwable th;
        boolean z = false;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadKey);
            ThreadSummary b = this.f10011l.m10465b(threadKey);
            if (i == 0) {
                if (b != null) {
                    z = true;
                }
                if (a != null) {
                    a.close();
                }
            } else {
                ThreadLocalState d = this.f10011l.m10468d(threadKey);
                if (d == null || !d.a()) {
                    MessagesCollection b2 = this.f10012m.m10474b(threadKey);
                    if (b2 == null) {
                        if (a != null) {
                            a.close();
                        }
                    } else if (b == null) {
                        if (a != null) {
                            a.close();
                        }
                    } else if (m10400a(b, m10402b(b2))) {
                        z = b2.a(i);
                        if (a != null) {
                            a.close();
                        }
                    } else if (a != null) {
                        a.close();
                    }
                } else if (a != null) {
                    a.close();
                }
            }
            return z;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10430a(ThreadSummary threadSummary, MessagesCollection messagesCollection) {
        Throwable th;
        Throwable th2;
        CloseableLock a = this.f10010k.m10458a();
        try {
            m10409i(threadSummary.a);
            if (this.f10011l.m10467c(threadSummary.a)) {
                m10393a(messagesCollection.b(0), messagesCollection, -1, StitchOperationType.MESSAGE_ADDED);
            } else {
                m10422a(messagesCollection);
            }
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10420a(Message message) {
        Throwable th;
        Throwable th2;
        CloseableLock a = this.f10010k.m10458a();
        try {
            ThreadKey threadKey = message.b;
            m10409i(threadKey);
            MessagesCollection b = this.f10012m.m10474b(threadKey);
            if (b != null) {
                Builder builder = ImmutableList.builder();
                ImmutableList b2 = b.b();
                int size = b2.size();
                int i = 0;
                Object obj = null;
                while (i < size) {
                    Object obj2;
                    Message message2 = (Message) b2.get(i);
                    if (message.n.equals(message2.n)) {
                        builder.c(message);
                        obj2 = 1;
                    } else if (message2.l == MessageType.PENDING_SEND && Objects.equal(message.A, message2.A)) {
                        builder.c(Message.newBuilder().a(message2).a(MessageType.FAILED_SEND).a(SendError.a(SendErrorType.EARLIER_MESSAGE_FROM_THREAD_FAILED)).R());
                        obj2 = obj;
                    } else {
                        builder.c(message2);
                        obj2 = obj;
                    }
                    i++;
                    obj = obj2;
                }
                this.f10012m.m10472a(new MessagesCollection(b.a(), builder.b(), b.e()), (User) this.f10005f.get());
                if (obj == null) {
                    m10393a(message, null, -1, StitchOperationType.MESSAGE_ADDED);
                }
                ThreadSummary a2 = m10410a(threadKey);
                if (a2 != null) {
                    ThreadSummaryBuilder a3 = ThreadSummary.newBuilder().a(a2);
                    a3.c(true);
                    a3.e(true);
                    m10427a(a3.V());
                }
                if (a != null) {
                    a.close();
                    return;
                }
                return;
            } else if (a != null) {
                a.close();
                return;
            } else {
                return;
            }
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10424a(ThreadKey threadKey, ThreadKey threadKey2) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            ThreadSummary a2 = this.f10011l.m10460a(threadKey);
            if (a2 != null) {
                this.f10011l.m10463a(ThreadSummary.newBuilder().a(a2).a(threadKey2).V());
            }
            if (this.f10013n.m10482b(threadKey)) {
                this.f10013n.m10477a(threadKey2);
            }
            for (FolderCacheData folderCacheData : this.f10015p.values()) {
                if (folderCacheData.a(threadKey) != null) {
                    folderCacheData.a(ThreadSummary.newBuilder().a(a2).a(threadKey2).V());
                }
            }
            MessagesCollection b = this.f10012m.m10474b(threadKey);
            if (b != null) {
                Builder builder = new Builder();
                ImmutableList b2 = b.b();
                int size = b2.size();
                for (int i = 0; i < size; i++) {
                    builder.c(Message.newBuilder().a((Message) b2.get(i)).a(threadKey2).R());
                }
                MessagesCollection messagesCollection = new MessagesCollection(threadKey2, builder.b(), b.e());
                this.f10012m.m10473a(threadKey);
                this.f10012m.m10472a(messagesCollection, (User) this.f10005f.get());
            }
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10426a(ThreadKey threadKey, boolean z) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            ThreadSummary a2 = this.f10011l.m10460a(threadKey);
            if (a2 != null) {
                this.f10011l.m10463a(ThreadSummary.newBuilder().a(a2).a(z).V());
            }
            for (FolderCacheData folderCacheData : this.f10015p.values()) {
                ThreadSummary a3 = folderCacheData.a(threadKey);
                if (a3 != null) {
                    folderCacheData.a(ThreadSummary.newBuilder().a(a3).a(z).V());
                }
            }
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10442b(ImmutableList<Message> immutableList) {
        Throwable th;
        Throwable th2;
        LinkedHashMultimap u = LinkedHashMultimap.u();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) immutableList.get(i);
            m10409i(message.b);
            u.a(message.b, message.n);
        }
        CloseableLock a = this.f10010k.m10458a();
        try {
            for (ThreadKey threadKey : u.p()) {
                Collection c = u.c(threadKey);
                MessagesCollection b = this.f10012m.m10474b(threadKey);
                if (b != null) {
                    Object obj = null;
                    Builder builder = ImmutableList.builder();
                    ImmutableList b2 = b.b();
                    int size2 = b2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2;
                        Message message2 = (Message) b2.get(i2);
                        if (c.contains(message2.n)) {
                            builder.c(Message.newBuilder().a(message2).a(MessageType.FAILED_SEND).a(SendError.a(SendErrorType.PENDING_SEND_ON_STARTUP)).R());
                            obj2 = 1;
                        } else {
                            builder.c(message2);
                            obj2 = obj;
                        }
                        i2++;
                        obj = obj2;
                    }
                    if (obj != null) {
                        this.f10012m.m10472a(new MessagesCollection(b.a(), builder.b(), b.e()), (User) this.f10005f.get());
                        ThreadSummary a2 = m10410a(threadKey);
                        if (a2 != null) {
                            ThreadSummaryBuilder a3 = ThreadSummary.newBuilder().a(a2);
                            a3.c(true);
                            a3.e(true);
                            m10427a(a3.V());
                        }
                    } else if (a != null) {
                        a.close();
                        return;
                    } else {
                        return;
                    }
                } else if (a != null) {
                    a.close();
                    return;
                } else {
                    return;
                }
            }
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10441b(Message message) {
        Throwable th;
        Throwable th2;
        CloseableLock a = this.f10010k.m10458a();
        try {
            m10409i(message.b);
            Message a2 = this.f10012m.m10469a(message.b, message.n);
            this.f10003d.get();
            if (ThreadSummaryStitching.a(message, a2)) {
                m10393a(message, null, -1, StitchOperationType.MESSAGE_ADDED);
                ThreadSummary a3 = m10410a(message.b);
                if (a3 != null) {
                    m10429a(a3, null);
                }
                if (a != null) {
                    a.close();
                    return;
                }
                return;
            } else if (a != null) {
                a.close();
                return;
            } else {
                return;
            }
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10432a(UpdateMessageSendErrorParams updateMessageSendErrorParams) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            ThreadKey threadKey = updateMessageSendErrorParams.c;
            m10409i(threadKey);
            MessagesCollection b = this.f10012m.m10474b(threadKey);
            Builder builder = ImmutableList.builder();
            ImmutableList b2 = b.b();
            int size = b2.size();
            for (int i = 0; i < size; i++) {
                Message message = (Message) b2.get(i);
                if (updateMessageSendErrorParams.b.equals(message.n)) {
                    builder.c(Message.newBuilder().a(message).a(MessageType.FAILED_SEND).a(updateMessageSendErrorParams.a).R());
                } else {
                    builder.c(message);
                }
            }
            this.f10012m.m10472a(new MessagesCollection(b.a(), builder.b(), b.e()), (User) this.f10005f.get());
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10421a(@Nullable Message message, @Nullable MessagesCollection messagesCollection, long j) {
        Throwable th;
        Throwable th2;
        CloseableLock a = this.f10010k.m10458a();
        try {
            m10393a(message, messagesCollection, j, StitchOperationType.MESSAGE_ADDED);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final FolderCounts m10453e(FolderName folderName) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            FolderCounts f = m10408g(folderName).f();
            if (a != null) {
                a.close();
            }
            return f;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10415a(FolderName folderName, FolderCounts folderCounts) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10408g(folderName).a(folderCounts);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    @GuardedBy("mThreadsCacheLock")
    private void m10393a(@Nullable Message message, @Nullable MessagesCollection messagesCollection, long j, StitchOperationType stitchOperationType) {
        if (message != null) {
            m10409i(message.b);
            ThreadKey threadKey = message.b;
            ThreadLocalState d = this.f10011l.m10468d(threadKey);
            ThreadSummary b = this.f10011l.m10465b(threadKey);
            if (b == null) {
                m10407e();
                d.b();
                return;
            }
            boolean c = MessageUtil.c(message);
            MessagesCollection b2 = this.f10012m.m10474b(threadKey);
            if (b2 == null) {
                b2 = new MessagesCollection(threadKey, ImmutableList.of(), false);
                m10407e();
                d.b();
            } else if (message.o && !c) {
                m10407e();
                d.b();
            }
            if (m10401a(c, message, j, b, messagesCollection, b2)) {
                m10407e();
                d.b();
            }
            ((GloballyDeletedMessagesPlaceholderCache) this.f10007h.get()).a(message);
            MessagesCollection a = m10391a(message, messagesCollection, b2);
            m10394a(message, messagesCollection, b2, a);
            ThreadSummary a2 = ((ThreadSummaryStitching) this.f10003d.get()).a(b, message, a, j, stitchOperationType);
            FolderCacheData g = m10408g(a2.A);
            m10397a(a2, this.f10011l.m10465b(b.a));
            this.f10011l.m10463a(a2);
            g.b(a2);
            this.f10012m.m10472a(a, (User) this.f10005f.get());
            m10395a(message, a2);
            m10404b(a2);
        }
    }

    private boolean m10401a(boolean z, Message message, long j, ThreadSummary threadSummary, MessagesCollection messagesCollection, MessagesCollection messagesCollection2) {
        if (z) {
            return false;
        }
        if (message.o) {
            return false;
        }
        if (j == threadSummary.d + 1) {
            return false;
        }
        boolean z2 = ((Boolean) this.f10006g.get()).booleanValue() && this.f10008i.a(238, false);
        if (!z2) {
            if (messagesCollection == null) {
                return true;
            }
            if (!((MessagesCollectionMerger) this.f10002c.get()).c(messagesCollection, messagesCollection2)) {
                return true;
            }
        }
        return false;
    }

    private MessagesCollection m10391a(Message message, @Nullable MessagesCollection messagesCollection, @Nullable MessagesCollection messagesCollection2) {
        if (messagesCollection == null) {
            messagesCollection = MessagesCollection.a(message);
        }
        return ((MessagesCollectionMerger) this.f10002c.get()).a(messagesCollection, messagesCollection2);
    }

    private void m10395a(Message message, ThreadSummary threadSummary) {
        if (MessageUtil.Z(message)) {
            Builder builder = new Builder();
            ImmutableList immutableList = threadSummary.J;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadEventReminder threadEventReminder = (ThreadEventReminder) immutableList.get(i);
                Map hashMap = new HashMap();
                hashMap.putAll(this.f10014o.m10485a(threadEventReminder.a));
                if (threadEventReminder.e != null) {
                    hashMap.putAll(threadEventReminder.e);
                }
                ThreadEventReminder.Builder builder2 = new ThreadEventReminder.Builder(threadEventReminder);
                builder2.e = ImmutableMap.copyOf(hashMap);
                builder.c(builder2.g());
            }
            this.f10014o.m10486a(builder.b());
        }
    }

    private void m10394a(Message message, @Nullable MessagesCollection messagesCollection, @Nullable MessagesCollection messagesCollection2, MessagesCollection messagesCollection3) {
        if (BLog.b(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f10001b.logName).append(" Merged messages:\n  New Message:\n");
            m10398a(stringBuilder, MessagesCollection.a(message), 1);
            stringBuilder.append("  Recent Messages:\n");
            m10398a(stringBuilder, messagesCollection, 5);
            stringBuilder.append("  Loaded Messages:\n");
            m10398a(stringBuilder, messagesCollection2, 5);
            stringBuilder.append("  Result:\n");
            m10398a(stringBuilder, messagesCollection3, 8);
            stringBuilder.append("\n");
        }
    }

    private void m10405c(MessagesCollection messagesCollection) {
        if (BLog.b(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  ").append(this.f10001b.logName).append(" Messages:\n");
            m10398a(stringBuilder, messagesCollection, 8);
            stringBuilder.append("\n");
        }
    }

    private void m10397a(ThreadSummary threadSummary, @Nullable ThreadSummary threadSummary2) {
        if (BLog.b(2)) {
            String threadSummary3 = threadSummary.toString();
            if (threadSummary2 == null || !Objects.equal(threadSummary3, threadSummary2.toString())) {
                new StringBuilder().append("  ").append(this.f10001b.logName).append(" ThreadSummary: ").append(threadSummary3);
            }
        }
    }

    private static void m10398a(StringBuilder stringBuilder, MessagesCollection messagesCollection, int i) {
        if (messagesCollection == null || messagesCollection.f()) {
            stringBuilder.append("    none\n");
            return;
        }
        int i2 = 0;
        while (i2 < i && i2 < messagesCollection.g()) {
            stringBuilder.append("   ").append(messagesCollection.b(i2)).append("\n");
            i2++;
        }
    }

    public final void m10413a() {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            this.f10011l.m10466b();
            this.f10012m.m10471a();
            for (FolderCacheData h : this.f10015p.values()) {
                h.h();
            }
            this.f10015p.clear();
            this.f10013n.m10484d();
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final long m10454f(FolderName folderName) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            long e = m10408g(folderName).e();
            if (a != null) {
                a.close();
            }
            return e;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final long m10445c(ThreadKey threadKey) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadKey);
            long g = this.f10011l.m10468d(threadKey).g();
            if (a != null) {
                a.close();
            }
            return g;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10423a(ThreadKey threadKey, long j, long j2) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadKey);
            ThreadLocalState d = this.f10011l.m10468d(threadKey);
            ThreadSummary a2 = m10410a(threadKey);
            if (a2 != null && j >= a2.k) {
                m10427a(ThreadSummary.newBuilder().a(a2).d(j2).f(j).V());
                d.b(a2.c);
                if (a != null) {
                    a.close();
                    return;
                }
                return;
            } else if (a != null) {
                a.close();
                return;
            } else {
                return;
            }
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10431a(MarkThreadFields markThreadFields) {
        Throwable th;
        long j = 0;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            ThreadKey threadKey = markThreadFields.a;
            m10409i(threadKey);
            long j2 = markThreadFields.b ? 0 : 1;
            if (markThreadFields.b) {
                j = markThreadFields.e;
            }
            ThreadSummary a2 = m10410a(threadKey);
            if (a2 != null) {
                m10427a(ThreadSummary.newBuilder().a(a2).h(j2).f(j).V());
            }
            for (FolderCacheData folderCacheData : this.f10015p.values()) {
                ThreadSummary a3 = folderCacheData.a(threadKey);
                if (a3 != null) {
                    folderCacheData.a(ThreadSummary.newBuilder().a(a3).h(j2).f(j).V());
                }
            }
            this.f10011l.m10468d(threadKey).b(markThreadFields.c);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final long m10449d(ThreadKey threadKey) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadKey);
            long f = this.f10011l.m10468d(threadKey).f();
            if (a != null) {
                a.close();
            }
            return f;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    final boolean m10448c(Message message) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(message.b);
            Message b = m10438b(message.a);
            long j = message.g;
            if (b != null) {
                j = Math.min(j, b.g);
            }
            boolean z = m10449d(message.b) >= j;
            if (a != null) {
                a.close();
            }
            return z;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final long m10452e(ThreadKey threadKey) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadKey);
            long e = this.f10011l.m10468d(threadKey).e();
            if (a != null) {
                a.close();
            }
            return e;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final long m10455f(ThreadKey threadKey) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadKey);
            long d = this.f10011l.m10468d(threadKey).d();
            if (a != null) {
                a.close();
            }
            return d;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10435a(List<ThreadSummary> list, long j, boolean z) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            for (ThreadSummary threadSummary : list) {
                m10409i(threadSummary.a);
            }
            this.f10011l.m10464a((Iterable) list);
            this.f10013n.m10478a(Collections2.a(list, ThreadSummaryUtil.a));
            this.f10013n.m10476a(j);
            this.f10013n.m10479a(true);
            this.f10013n.m10481b(!z);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10414a(long j) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            this.f10013n.m10476a(j);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10434a(List<ThreadKey> list) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            for (ThreadKey i : list) {
                m10409i(i);
            }
            this.f10013n.m10478a((Iterable) list);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public final void m10456g(ThreadKey threadKey) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadKey);
            this.f10013n.m10477a(threadKey);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final void m10457h(ThreadKey threadKey) {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            m10409i(threadKey);
            this.f10013n.m10482b(threadKey);
            if (a != null) {
                a.close();
                return;
            }
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final ImmutableList<ThreadSummary> m10440b() {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            ImmutableList a2 = this.f10013n.m10475a();
            Builder builder = ImmutableList.builder();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                ThreadSummary a3 = m10410a((ThreadKey) a2.get(i));
                if (a3 != null) {
                    builder.c(a3);
                }
            }
            ImmutableList<ThreadSummary> b = builder.b();
            if (a != null) {
                a.close();
            }
            return b;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final long m10444c() {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            long b = this.f10013n.m10480b();
            if (a != null) {
                a.close();
            }
            return b;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public final boolean m10451d() {
        Throwable th;
        CloseableLock a = this.f10010k.m10458a();
        Throwable th2 = null;
        try {
            boolean c = this.f10013n.m10483c();
            if (a != null) {
                a.close();
            }
            return c;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    public void clearUserData() {
        m10413a();
    }

    private void m10409i(@Nullable ThreadKey threadKey) {
        if (ThreadKey.d(threadKey)) {
            m10396a(threadKey, CacheType.SMS);
        } else if (ThreadKey.g(threadKey)) {
            m10396a(threadKey, CacheType.TINCAN);
        } else if (threadKey != null) {
            m10396a(threadKey, CacheType.FACEBOOK);
        }
    }

    private void m10396a(ThreadKey threadKey, CacheType cacheType) {
        Preconditions.checkArgument(this.f10001b == cacheType, "Tried to use %s in %s cache", new Object[]{threadKey, this.f10001b});
    }
}
