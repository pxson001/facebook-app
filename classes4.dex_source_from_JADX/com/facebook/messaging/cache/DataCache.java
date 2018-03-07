package com.facebook.messaging.cache;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.folders.ThreadTypeFilter;
import com.facebook.messaging.model.folders.ThreadsCacheType;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.sms.abtest.AnonymousSmsThreadStateHelper;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.threads.util.SmsMessengerThreadListMergeUtil;
import com.facebook.messaging.tincan.gatekeepers.TincanGatekeepers;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
@ThreadSafe
/* compiled from: is_marked_as_spam */
public class DataCache {
    private static final Class<?> f9977a = DataCache.class;
    private static final Object f9978k = new Object();
    private final Provider<Boolean> f9979b;
    private final MessengerUserNameUtil f9980c;
    private final FbObjectMapper f9981d;
    private final ThreadsCache f9982e;
    private final ThreadsCache f9983f;
    private final ThreadsCache f9984g;
    private final SmsIntegrationState f9985h;
    private final TincanGatekeepers f9986i;
    private final Lazy<AnonymousSmsThreadStateHelper> f9987j;

    private static DataCache m10342b(InjectorLike injectorLike) {
        return new DataCache(IdBasedProvider.a(injectorLike, 4143), MessengerUserNameUtil.m10367a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), ThreadsCache_FacebookMessagesMethodAutoProvider.m10384a(injectorLike), ThreadsCache_SmsMessagesMethodAutoProvider.m10487a(injectorLike), ThreadsCache_TincanMessagesMethodAutoProvider.m10489a(injectorLike), SmsIntegrationState.m10491a(injectorLike), TincanGatekeepers.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8447));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.cache.DataCache m10341a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9978k;	 Catch:{ all -> 0x006c }
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
        r1 = m10342b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9978k;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.DataCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.cache.DataCache) r0;	 Catch:{  }
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
        r0 = f9978k;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.DataCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.DataCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.cache.DataCache");
    }

    @Inject
    public DataCache(Provider<Boolean> provider, MessengerUserNameUtil messengerUserNameUtil, FbObjectMapper fbObjectMapper, ThreadsCache threadsCache, ThreadsCache threadsCache2, ThreadsCache threadsCache3, SmsIntegrationState smsIntegrationState, TincanGatekeepers tincanGatekeepers, Lazy<AnonymousSmsThreadStateHelper> lazy) {
        this.f9979b = provider;
        this.f9980c = messengerUserNameUtil;
        this.f9981d = fbObjectMapper;
        this.f9982e = threadsCache;
        this.f9983f = threadsCache2;
        this.f9984g = threadsCache3;
        this.f9985h = smsIntegrationState;
        this.f9986i = tincanGatekeepers;
        this.f9987j = lazy;
    }

    public final boolean m10357a(FolderName folderName, ThreadTypeFilter threadTypeFilter) {
        boolean z = folderName == FolderName.INBOX || threadTypeFilter != ThreadTypeFilter.SMS;
        Preconditions.checkArgument(z);
        if (threadTypeFilter == ThreadTypeFilter.SMS) {
            if (m10344b() && this.f9983f.m10436a(folderName)) {
                return true;
            }
            return false;
        } else if (threadTypeFilter == ThreadTypeFilter.NON_SMS) {
            if (!this.f9982e.m10436a(folderName)) {
                return false;
            }
            if (!this.f9986i.a() || this.f9984g.m10436a(folderName)) {
                return true;
            }
            return false;
        } else if (threadTypeFilter != ThreadTypeFilter.ALL || !this.f9982e.m10436a(folderName)) {
            return false;
        } else {
            if (m10344b() && !this.f9983f.m10436a(folderName)) {
                return false;
            }
            if (!this.f9986i.a() || this.f9984g.m10436a(folderName)) {
                return true;
            }
            return false;
        }
    }

    public final boolean m10358a(Message message) {
        return (message == null || message.b == null || !m10346e(message.b).m10448c(message)) ? false : true;
    }

    @Nullable
    public final String m10353a(ThreadKey threadKey, ParticipantInfo participantInfo) {
        if (((Boolean) this.f9979b.get()).booleanValue()) {
            String c = m10345c(threadKey, participantInfo);
            if (c != null) {
                return c;
            }
        }
        return this.f9980c.m10370b(participantInfo);
    }

    @Nullable
    public final String m10362b(ThreadKey threadKey, ParticipantInfo participantInfo) {
        if (((Boolean) this.f9979b.get()).booleanValue()) {
            String c = m10345c(threadKey, participantInfo);
            if (c != null) {
                return c;
            }
        }
        return this.f9980c.m10369a(participantInfo);
    }

    @Nullable
    public final ImmutableList<String> m10351a(ThreadKey threadKey, List<ParticipantInfo> list, boolean z, @Nullable Builder<ParticipantInfo> builder) {
        Map map;
        String str;
        Builder builder2 = ImmutableList.builder();
        if (((Boolean) this.f9979b.get()).booleanValue()) {
            ThreadSummary a = m10348a(threadKey);
            if (a != null) {
                ImmutableMap a2 = a.D.g.a(this.f9981d);
                map = a2.isEmpty() ? null : a2;
                for (ParticipantInfo participantInfo : list) {
                    str = map != null ? null : (String) map.get(participantInfo.b.b());
                    if (Strings.isNullOrEmpty(str)) {
                        str = this.f9980c.m10369a(participantInfo);
                        if (Strings.isNullOrEmpty(str)) {
                            if (z || Strings.isNullOrEmpty(participantInfo.d)) {
                                str = null;
                            } else {
                                str = participantInfo.d;
                            }
                        }
                    }
                    if (!Strings.isNullOrEmpty(str)) {
                        builder2.c(str);
                        if (builder != null) {
                            builder.c(participantInfo);
                        }
                    }
                }
                return builder2.b();
            }
        }
        map = null;
        for (ParticipantInfo participantInfo2 : list) {
            if (map != null) {
            }
            if (Strings.isNullOrEmpty(str)) {
                str = this.f9980c.m10369a(participantInfo2);
                if (Strings.isNullOrEmpty(str)) {
                    if (z) {
                    }
                    str = null;
                }
            }
            if (!Strings.isNullOrEmpty(str)) {
                builder2.c(str);
                if (builder != null) {
                    builder.c(participantInfo2);
                }
            }
        }
        return builder2.b();
    }

    public final ThreadsCollection m10361b(FolderName folderName, ThreadTypeFilter threadTypeFilter) {
        Object obj = 1;
        boolean z = folderName == FolderName.INBOX || threadTypeFilter != ThreadTypeFilter.SMS;
        Preconditions.checkState(z);
        if (threadTypeFilter != ThreadTypeFilter.SMS) {
            if (threadTypeFilter == ThreadTypeFilter.NON_SMS || !m10344b()) {
                obj = null;
            }
            boolean a = this.f9986i.a();
            ThreadsCollection d = this.f9982e.m10450d(folderName);
            if (obj == null && !a) {
                return d;
            }
            Collection arrayList = new ArrayList(3);
            arrayList.add(d);
            if (obj != null) {
                arrayList.add(this.f9983f.m10450d(folderName));
            }
            if (a) {
                arrayList.add(this.f9984g.m10450d(folderName));
            }
            return SmsMessengerThreadListMergeUtil.a(arrayList);
        } else if (m10344b()) {
            return this.f9983f.m10450d(folderName);
        } else {
            return ThreadsCollection.b;
        }
    }

    @Nullable
    public final ThreadSummary m10348a(ThreadKey threadKey) {
        return threadKey == null ? null : m10346e(threadKey).m10410a(threadKey);
    }

    @Deprecated
    @Nullable
    public final ThreadSummary m10349a(String str) {
        return this.f9982e.m10412a(str);
    }

    @Nullable
    public final MessagesCollection m10360b(ThreadKey threadKey) {
        return threadKey == null ? null : m10346e(threadKey).m10439b(threadKey);
    }

    @Nullable
    public final ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus> m10352a(@Nullable ThreadKey threadKey, @Nullable String str) {
        return (threadKey == null || str == null) ? null : m10346e(threadKey).m10446c(str);
    }

    public final FolderCounts m10347a(FolderName folderName) {
        return this.f9982e.m10453e(folderName);
    }

    public final ImmutableList<ThreadSummary> m10350a() {
        return this.f9982e.m10440b();
    }

    public final void m10356a(MarkThreadFields markThreadFields) {
        m10346e(markThreadFields.a).m10431a(markThreadFields);
    }

    public final long m10365c(ThreadKey threadKey) {
        return m10346e(threadKey).m10449d(threadKey);
    }

    public final long m10364c(FolderName folderName, ThreadTypeFilter threadTypeFilter) {
        long min;
        boolean z = folderName == FolderName.INBOX || threadTypeFilter != ThreadTypeFilter.SMS;
        Preconditions.checkArgument(z);
        if (threadTypeFilter != ThreadTypeFilter.SMS) {
            min = Math.min(Long.MAX_VALUE, this.f9982e.m10454f(folderName));
        } else {
            min = Long.MAX_VALUE;
        }
        if (threadTypeFilter != ThreadTypeFilter.NON_SMS && m10344b()) {
            min = Math.min(min, this.f9983f.m10454f(folderName));
        }
        if (threadTypeFilter == ThreadTypeFilter.SMS || !this.f9986i.a()) {
            return min;
        }
        return Math.min(min, this.f9984g.m10454f(folderName));
    }

    public final boolean m10363b(FolderName folderName) {
        if (!this.f9982e.m10443b(folderName)) {
            return false;
        }
        if (m10344b() && !this.f9983f.m10443b(folderName)) {
            return false;
        }
        if (!this.f9986i.a() || this.f9984g.m10443b(folderName)) {
            return true;
        }
        return false;
    }

    public final long m10366d(ThreadKey threadKey) {
        return m10346e(threadKey).m10445c(threadKey);
    }

    public final boolean m10359a(ThreadKey threadKey, int i) {
        return m10346e(threadKey).m10437a(threadKey, i);
    }

    private ThreadsCache m10346e(ThreadKey threadKey) {
        switch (1.a[threadKey.a.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return this.f9982e;
            case 6:
                return this.f9983f;
            case 7:
                return this.f9984g;
            default:
                throw new IllegalArgumentException("Thread Key with unexpected type: " + threadKey);
        }
    }

    @Nullable
    private ThreadsCache m10343b(ThreadsCacheType threadsCacheType) {
        switch (1.b[threadsCacheType.ordinal()]) {
            case 1:
                if (m10344b()) {
                    return this.f9983f;
                }
                return null;
            case 2:
                return this.f9982e;
            case 3:
                if (this.f9986i.a()) {
                    return this.f9984g;
                }
                return null;
            default:
                return null;
        }
    }

    public final void m10354a(ThreadsCacheType threadsCacheType) {
        ThreadsCache b = m10343b(threadsCacheType);
        if (b != null) {
            b.m10413a();
        }
    }

    public final void m10355a(ThreadsCacheType threadsCacheType, ImmutableList<Message> immutableList) {
        ThreadsCache b = m10343b(threadsCacheType);
        if (b != null) {
            b.m10442b((ImmutableList) immutableList);
        }
    }

    @Nullable
    private String m10345c(ThreadKey threadKey, ParticipantInfo participantInfo) {
        ThreadSummary a = m10348a(threadKey);
        if (a != null) {
            Object a2 = a.D.g.a(participantInfo.b.b(), this.f9981d);
            if (!StringUtil.a(a2)) {
                return a2;
            }
        }
        return null;
    }

    private boolean m10344b() {
        return ((AnonymousSmsThreadStateHelper) this.f9987j.get()).a() || this.f9985h.m10496a();
    }
}
