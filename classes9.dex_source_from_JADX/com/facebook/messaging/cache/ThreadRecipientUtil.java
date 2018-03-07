package com.facebook.messaging.cache;

import com.facebook.auth.module.UserKey_ViewerContextUserKeyMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.user.module.UserNameUtil;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messenger_video_too_short_dialog */
public class ThreadRecipientUtil {
    private final UserKey f9566a;
    private final DataCache f9567b;
    private final UserNameUtil f9568c;
    private final UserCache f9569d;

    public static ThreadRecipientUtil m10165b(InjectorLike injectorLike) {
        return new ThreadRecipientUtil(UserKey_ViewerContextUserKeyMethodAutoProvider.b(injectorLike), DataCache.a(injectorLike), UserNameUtil.a(injectorLike), UserCache.a(injectorLike));
    }

    @Inject
    public ThreadRecipientUtil(UserKey userKey, DataCache dataCache, UserNameUtil userNameUtil, UserCache userCache) {
        this.f9566a = userKey;
        this.f9567b = dataCache;
        this.f9568c = userNameUtil;
        this.f9569d = userCache;
    }

    @Nullable
    public final String m10169a(ThreadSummary threadSummary) {
        return this.f9568c.a(m10166d(threadSummary));
    }

    public static ThreadRecipientUtil m10162a(InjectorLike injectorLike) {
        return m10165b(injectorLike);
    }

    @Nullable
    public final String m10171b(ThreadSummary threadSummary) {
        User d = m10166d(threadSummary);
        return d == null ? null : d.k();
    }

    @Nullable
    private User m10166d(ThreadSummary threadSummary) {
        if (threadSummary == null || (!ThreadKey.b(threadSummary.a) && !ThreadKey.g(threadSummary.a))) {
            return null;
        }
        return this.f9569d.a(UserKey.b(Long.toString(threadSummary.a.d)));
    }

    public final ImmutableList<User> m10168a(@Nullable ThreadKey threadKey) {
        if (threadKey == null) {
            return RegularImmutableList.a;
        }
        if (threadKey.a == Type.ONE_TO_ONE) {
            return m10163a(threadKey, false);
        }
        return m10167e(this.f9567b.a(threadKey));
    }

    private ImmutableList<User> m10167e(@Nullable ThreadSummary threadSummary) {
        return m10164a(threadSummary, false);
    }

    public final ImmutableList<User> m10170b(@Nullable ThreadKey threadKey) {
        if (threadKey == null) {
            return RegularImmutableList.a;
        }
        if (threadKey.a == Type.ONE_TO_ONE) {
            return m10163a(threadKey, true);
        }
        return m10172c(this.f9567b.a(threadKey));
    }

    public final ImmutableList<User> m10172c(@Nullable ThreadSummary threadSummary) {
        return m10164a(threadSummary, true);
    }

    private ImmutableList<User> m10163a(@Nullable ThreadKey threadKey, boolean z) {
        Builder builder = ImmutableList.builder();
        if (threadKey != null && threadKey.a == Type.ONE_TO_ONE) {
            if (!threadKey.e()) {
                builder.c(UserKey.b(String.valueOf(threadKey.d)));
            }
            if (!z) {
                builder.c(this.f9566a);
            }
        }
        return this.f9569d.a(builder.b());
    }

    private ImmutableList<User> m10164a(@Nullable ThreadSummary threadSummary, boolean z) {
        Builder builder = ImmutableList.builder();
        if (!(threadSummary == null || threadSummary.h == null)) {
            ImmutableList immutableList = threadSummary.h;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
                UserKey b = threadParticipant.b();
                if (!(b == null || (z && Objects.equal(this.f9566a, b)))) {
                    builder.c(threadParticipant.b());
                }
            }
        }
        return this.f9569d.a(builder.b());
    }
}
