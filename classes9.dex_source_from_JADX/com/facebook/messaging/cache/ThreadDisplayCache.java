package com.facebook.messaging.cache;

import com.facebook.auth.module.UserKey_ViewerContextUserKeyMethodAutoProvider;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@UserScoped
/* compiled from: metab_tapped_gysc_create_group */
public class ThreadDisplayCache implements IHaveUserData {
    private static final Object f9550e = new Object();
    private final DataCache f9551a;
    public final Cache<ThreadKey, ParticipantListResult> f9552b;
    public final Map<String, Long> f9553c;
    public final UserKey f9554d;

    @Immutable
    /* compiled from: metab_tapped_gysc_create_group */
    class ParticipantListResult {
        public final long f9547a;
        public final ImmutableList<ParticipantInfo> f9548b;
        public final ImmutableList<String> f9549c;

        ParticipantListResult(long j, ImmutableList<ParticipantInfo> immutableList, ImmutableList<String> immutableList2) {
            this.f9547a = j;
            this.f9548b = immutableList;
            this.f9549c = immutableList2;
        }
    }

    private static ThreadDisplayCache m10137b(InjectorLike injectorLike) {
        return new ThreadDisplayCache(DataCache.a(injectorLike), UserKey_ViewerContextUserKeyMethodAutoProvider.b(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.cache.ThreadDisplayCache m10136a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9550e;	 Catch:{ all -> 0x006c }
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
        r1 = m10137b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9550e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.ThreadDisplayCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.cache.ThreadDisplayCache) r0;	 Catch:{  }
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
        r0 = f9550e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.ThreadDisplayCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.ThreadDisplayCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.cache.ThreadDisplayCache");
    }

    @Inject
    public ThreadDisplayCache(DataCache dataCache, UserKey userKey) {
        this.f9551a = dataCache;
        CacheBuilder newBuilder = CacheBuilder.newBuilder();
        boolean z = true;
        Preconditions.checkState(newBuilder.f == -1, "initial capacity was already set to %s", new Object[]{Integer.valueOf(newBuilder.f)});
        if (128 < null) {
            z = false;
        }
        Preconditions.checkArgument(z);
        newBuilder.f = 128;
        this.f9552b = newBuilder.b(2).j().q();
        this.f9553c = Maps.e();
        this.f9554d = userKey;
    }

    public final void m10142a() {
        this.f9552b.a();
    }

    public final List<String> m10141a(ThreadSummary threadSummary) {
        ParticipantListResult participantListResult = (ParticipantListResult) this.f9552b.a(threadSummary.a);
        if (participantListResult == null || participantListResult.f9547a != threadSummary.c) {
            participantListResult = m10139d(threadSummary);
            this.f9552b.a(threadSummary.a, participantListResult);
        }
        return participantListResult.f9549c;
    }

    public final List<ParticipantInfo> m10144b(ThreadSummary threadSummary) {
        ParticipantListResult participantListResult = (ParticipantListResult) this.f9552b.a(threadSummary.a);
        if (participantListResult == null || participantListResult.f9547a != threadSummary.c) {
            participantListResult = m10139d(threadSummary);
            this.f9552b.a(threadSummary.a, participantListResult);
        }
        return participantListResult.f9548b;
    }

    private ParticipantListResult m10139d(ThreadSummary threadSummary) {
        ImmutableList immutableList;
        ThreadKey threadKey = threadSummary.a;
        if (threadKey.a == Type.ONE_TO_ONE) {
            ImmutableList of;
            ImmutableList immutableList2 = threadSummary.h;
            int size = immutableList2.size();
            for (int i = 0; i < size; i++) {
                ThreadParticipant threadParticipant = (ThreadParticipant) immutableList2.get(i);
                if (!Objects.equal(threadParticipant.b(), this.f9554d)) {
                    of = ImmutableList.of(threadParticipant.a);
                    break;
                }
            }
            of = RegularImmutableList.a;
            immutableList = of;
        } else {
            immutableList = m10140f(threadSummary);
        }
        Builder builder = ImmutableList.builder();
        if (immutableList.size() == 1) {
            Builder builder2 = ImmutableList.builder();
            ParticipantInfo participantInfo = (ParticipantInfo) immutableList.iterator().next();
            String a = this.f9551a.a(threadKey, participantInfo);
            if (a != null) {
                builder.c(participantInfo);
                builder2.c(a);
            } else {
                BLog.c("ThreadDisplayCache", "ParticipantInfo [%s]", new Object[]{participantInfo});
            }
            return new ParticipantListResult(threadSummary.c, builder.b(), builder2.b());
        }
        return new ParticipantListResult(threadSummary.c, builder.b(), this.f9551a.a(threadKey, immutableList, true, builder));
    }

    private ImmutableList<ParticipantInfo> m10140f(ThreadSummary threadSummary) {
        int i;
        int i2 = 0;
        Map linkedHashMap = new LinkedHashMap();
        ImmutableList immutableList = threadSummary.o;
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            ParticipantInfo participantInfo = (ParticipantInfo) immutableList.get(i);
            if (!Objects.equal(participantInfo.b, this.f9554d)) {
                linkedHashMap.put(participantInfo.b, participantInfo);
            }
        }
        Set<UserKey> hashSet = new HashSet(linkedHashMap.keySet());
        ImmutableList immutableList2 = threadSummary.h;
        int size2 = immutableList2.size();
        for (i = 0; i < size2; i++) {
            hashSet.remove(((ThreadParticipant) immutableList2.get(i)).b());
        }
        for (UserKey remove : hashSet) {
            linkedHashMap.remove(remove);
        }
        ImmutableList immutableList3 = threadSummary.h;
        int size3 = immutableList3.size();
        while (i2 < size3) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList3.get(i2);
            if (!(Objects.equal(threadParticipant.b(), this.f9554d) || linkedHashMap.containsKey(threadParticipant.b()))) {
                linkedHashMap.put(threadParticipant.b(), threadParticipant.a);
            }
            i2++;
        }
        return ImmutableList.copyOf(linkedHashMap.values());
    }

    public static int m10138c(ThreadSummary threadSummary) {
        return threadSummary.h.size();
    }

    public final void m10143a(UserKey userKey, long j) {
        if (userKey != null) {
            Long l = (Long) this.f9553c.get(userKey.c());
            if (l == null || l.longValue() < j) {
                this.f9553c.put(userKey.c(), Long.valueOf(j));
            }
        }
    }

    public void clearUserData() {
        m10142a();
    }
}
