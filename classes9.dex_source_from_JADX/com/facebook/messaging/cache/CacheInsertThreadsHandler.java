package com.facebook.messaging.cache;

import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.Assisted;
import com.facebook.messaging.media.upload.MediaUploadCache;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.DeleteMessagesResult;
import com.facebook.messaging.service.model.FetchPinnedThreadsResult;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.Mark;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.service.model.MarkThreadFields.MarkThreadFieldsBuilder;
import com.facebook.messaging.service.model.MarkThreadsParams;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.sharedimage.gqlrequest.SharedMediaHistoryRequestFactory;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.presence.configs.PresenceLruCacheXConfig;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: minCropWidth */
public class CacheInsertThreadsHandler {
    public final ThreadsCache f9449a;
    public final ThreadDisplayCache f9450b;
    private final DefaultPresenceManager f9451c;
    private final ThreadParticipantUtils f9452d;
    private final ViewerContextManager f9453e;
    private final GraphQLCacheManager f9454f;
    private final SharedMediaHistoryRequestFactory f9455g;
    private final MessagesBroadcaster f9456h;
    private final MessageUtil f9457i;
    private final MediaUploadCache f9458j;
    private final Provider<XConfigReader> f9459k;
    public final UserCache f9460l;

    public final void m9933a(NewMessageResult newMessageResult) {
        Message message = newMessageResult.f17253a;
        this.f9449a.a(message, newMessageResult.f17254b, -1);
        this.f9450b.m10143a(message.e.b, message.c);
        this.f9456h.b();
    }

    public final void m9934a(NewMessageResult newMessageResult, long j) {
        Message message = newMessageResult.f17253a;
        this.f9449a.a(message, newMessageResult.f17254b, j);
        ImmutableList immutableList = message.i;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (((Attachment) immutableList.get(i)).g != null) {
                this.f9454f.a(this.f9455g.m17195a(message.b, ""));
                break;
            }
        }
        if (!this.f9457i.P(message)) {
            this.f9450b.m10143a(message.e.b, message.c);
            this.f9456h.b();
        }
        if (MessageUtil.Z(message)) {
            this.f9456h.e(message.b);
        }
    }

    @Inject
    public CacheInsertThreadsHandler(@Assisted ThreadsCache threadsCache, ThreadDisplayCache threadDisplayCache, PresenceManager presenceManager, ThreadParticipantUtils threadParticipantUtils, ViewerContextManager viewerContextManager, GraphQLCacheManager graphQLCacheManager, SharedMediaHistoryRequestFactory sharedMediaHistoryRequestFactory, MessagesBroadcaster messagesBroadcaster, MessageUtil messageUtil, MediaUploadCache mediaUploadCache, Provider<XConfigReader> provider, UserCache userCache) {
        this.f9449a = threadsCache;
        this.f9450b = threadDisplayCache;
        this.f9451c = presenceManager;
        this.f9452d = threadParticipantUtils;
        this.f9453e = viewerContextManager;
        this.f9454f = graphQLCacheManager;
        this.f9455g = sharedMediaHistoryRequestFactory;
        this.f9456h = messagesBroadcaster;
        this.f9457i = messageUtil;
        this.f9458j = mediaUploadCache;
        this.f9459k = provider;
        this.f9460l = userCache;
    }

    public final void m9916a() {
        this.f9449a.a();
        this.f9450b.m10142a();
    }

    public final void m9931a(FetchThreadListResult fetchThreadListResult) {
        int i = 0;
        FolderName folderName = fetchThreadListResult.f17132b;
        this.f9460l.a(fetchThreadListResult.f17134d);
        this.f9449a.a(folderName, fetchThreadListResult.f17137g);
        this.f9449a.a(fetchThreadListResult.f17132b, fetchThreadListResult.f17133c, fetchThreadListResult.f17142l, false);
        if (fetchThreadListResult.f17132b == FolderName.INBOX) {
            Collection<UserKey> a = Lists.a();
            int a2 = ((XConfigReader) this.f9459k.get()).a(PresenceLruCacheXConfig.e, 10);
            ImmutableList immutableList = fetchThreadListResult.f17133c.c;
            int size = immutableList.size();
            while (i < size) {
                ThreadParticipant b = this.f9452d.m10160b((ThreadSummary) immutableList.get(i));
                if (b != null) {
                    a.add(b.b());
                }
                if (a.size() >= a2) {
                    break;
                }
                i++;
            }
            DefaultPresenceManager defaultPresenceManager = this.f9451c;
            Object obj = null;
            for (UserKey userKey : a) {
                Object obj2;
                if (((UserKey) defaultPresenceManager.D.a(userKey, userKey)) == null && defaultPresenceManager.C.a(userKey) == null && !defaultPresenceManager.E.contains(userKey)) {
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
                obj = obj2;
            }
            if (obj != null) {
                defaultPresenceManager.a();
            }
        }
        this.f9450b.m10142a();
    }

    public final void m9930a(FetchPinnedThreadsResult fetchPinnedThreadsResult, boolean z) {
        Object obj = (fetchPinnedThreadsResult.f17101c.isEmpty() && fetchPinnedThreadsResult.f17102d) ? 1 : null;
        if (obj == null) {
            this.f9449a.a(fetchPinnedThreadsResult.f17101c, fetchPinnedThreadsResult.f17100b, z);
        } else {
            this.f9449a.a(fetchPinnedThreadsResult.f17100b);
        }
    }

    public final void m9919a(FolderName folderName, FolderCounts folderCounts) {
        this.f9449a.a(folderName, folderCounts);
    }

    public final void m9918a(FolderName folderName, long j) {
        FolderCounts e = this.f9449a.e(folderName);
        if (e != null) {
            m9919a(folderName, new FolderCounts(e.b, 0, j, e.e));
        }
    }

    public final void m9917a(int i, FetchThreadResult fetchThreadResult) {
        ThreadSummary threadSummary = fetchThreadResult.f17180c;
        if (fetchThreadResult.f17182e != null) {
            this.f9460l.a(fetchThreadResult.f17182e);
        }
        this.f9450b.m10142a();
        if (threadSummary != null) {
            this.f9449a.a(threadSummary, fetchThreadResult.f17183f);
            if (i > 0) {
                this.f9449a.a(fetchThreadResult.f17181d);
            }
            if (threadSummary.a.a == Type.ONE_TO_ONE) {
                ImmutableList immutableList = fetchThreadResult.f17181d.b;
                int size = immutableList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Message message = (Message) immutableList.get(i2);
                    UserKey userKey = message.e.b;
                    UserKey userKey2 = new UserKey(User.Type.FACEBOOK, this.f9453e.d().mUserId);
                    if (!Objects.equal(userKey, userKey2)) {
                        this.f9450b.m10143a(userKey2, message.c);
                        break;
                    }
                }
            }
            this.f9456h.a(threadSummary.a, threadSummary.c);
        }
    }

    public final void m9932a(FetchThreadResult fetchThreadResult) {
        ThreadSummary threadSummary = fetchThreadResult.f17180c;
        if (fetchThreadResult.f17182e != null) {
            this.f9460l.a(fetchThreadResult.f17182e);
        }
        this.f9449a.a(threadSummary, fetchThreadResult.f17183f);
        this.f9449a.a(threadSummary, fetchThreadResult.f17181d);
        this.f9450b.m10142a();
        this.f9456h.a(threadSummary.a);
    }

    public final void m9924a(Message message) {
        this.f9449a.b(message);
    }

    public final void m9922a(FolderName folderName, MarkThreadsParams markThreadsParams) {
        int i;
        if (markThreadsParams.f17215a == Mark.READ) {
            ImmutableList immutableList = markThreadsParams.f17217c;
            int size = immutableList.size();
            for (i = 0; i < size; i++) {
                this.f9449a.a((MarkThreadFields) immutableList.get(i));
            }
        } else if (markThreadsParams.f17215a == Mark.ARCHIVED || markThreadsParams.f17215a == Mark.SPAM) {
            Builder builder = new Builder();
            ImmutableList immutableList2 = markThreadsParams.f17217c;
            int size2 = immutableList2.size();
            for (i = 0; i < size2; i++) {
                builder.c(((MarkThreadFields) immutableList2.get(i)).f17204a);
            }
            this.f9449a.a(folderName, builder.b());
        }
    }

    public final void m9927a(ThreadKey threadKey, ThreadKey threadKey2) {
        this.f9449a.a(threadKey, threadKey2);
    }

    public final void m9926a(ThreadKey threadKey, long j, long j2) {
        this.f9449a.a(threadKey, j, j2);
    }

    public final void m9925a(ThreadKey threadKey) {
        ThreadsCache threadsCache = this.f9449a;
        MarkThreadFieldsBuilder markThreadFieldsBuilder = new MarkThreadFieldsBuilder();
        markThreadFieldsBuilder.f17198a = threadKey;
        markThreadFieldsBuilder = markThreadFieldsBuilder;
        markThreadFieldsBuilder.f17200c = 0;
        threadsCache.a(markThreadFieldsBuilder.m17152a());
    }

    public final void m9929a(ThreadSummary threadSummary, long j) {
        this.f9449a.a(threadSummary, j);
    }

    public final void m9937b(ThreadSummary threadSummary, long j) {
        this.f9449a.a(threadSummary, j);
    }

    public final void m9920a(FolderName folderName, ThreadKey threadKey) {
        m9923a(folderName, ImmutableList.of(threadKey));
    }

    public final void m9923a(FolderName folderName, ImmutableList<ThreadKey> immutableList) {
        this.f9449a.a(folderName, immutableList);
        this.f9456h.c(immutableList);
    }

    public final void m9936b(FolderName folderName, ThreadKey threadKey) {
        this.f9449a.a(folderName, threadKey);
    }

    public final void m9921a(FolderName folderName, DeleteMessagesResult deleteMessagesResult) {
        ThreadKey threadKey = deleteMessagesResult.f17030c;
        if (threadKey != null) {
            ImmutableSet immutableSet = deleteMessagesResult.f17031d;
            this.f9458j.a(deleteMessagesResult.f17033f);
            this.f9449a.a(threadKey, immutableSet);
            if (deleteMessagesResult.f17034g) {
                m9920a(folderName, threadKey);
            } else if (deleteMessagesResult.f17029b != null) {
                this.f9449a.a(deleteMessagesResult.f17029b);
            }
        }
    }

    public final void m9928a(ThreadKey threadKey, Set<String> set) {
        this.f9449a.a(threadKey, set);
    }

    public final void m9939b(NewMessageResult newMessageResult) {
        m9934a(newMessageResult, -1);
    }

    public final void m9938b(FetchThreadResult fetchThreadResult) {
        ThreadSummary threadSummary = fetchThreadResult.f17180c;
        this.f9449a.a(threadSummary, fetchThreadResult.f17183f);
        this.f9460l.a(fetchThreadResult.f17182e);
        if (!this.f9452d.m10161c(threadSummary)) {
            m9920a(threadSummary.A, threadSummary.a);
        }
        this.f9450b.m10142a();
        this.f9456h.a(threadSummary.a);
    }

    public final void m9940c(ThreadSummary threadSummary, long j) {
        this.f9449a.a(threadSummary, j);
        ThreadDisplayCache threadDisplayCache = this.f9450b;
        threadDisplayCache.f9552b.b(threadSummary.a);
    }

    public final void m9935a(User user) {
        this.f9460l.a(ImmutableList.of(user));
    }
}
