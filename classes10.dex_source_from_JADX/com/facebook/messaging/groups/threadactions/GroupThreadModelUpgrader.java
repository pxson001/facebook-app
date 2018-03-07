package com.facebook.messaging.groups.threadactions;

import android.net.Uri;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummary.GroupType;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: shared_prefs_not_initialized */
public class GroupThreadModelUpgrader {
    private final Provider<UserKey> f2585a;

    @Inject
    public GroupThreadModelUpgrader(Provider<UserKey> provider) {
        this.f2585a = provider;
    }

    public final ThreadSummary m2578a(ThreadSummary threadSummary, Uri uri) {
        ThreadSummaryBuilder a = ThreadSummary.newBuilder().a(threadSummary);
        a.N = GroupType.HIDDEN;
        a = a;
        a.H = uri;
        ThreadSummaryBuilder threadSummaryBuilder = a;
        UserKey userKey = (UserKey) this.f2585a.get();
        if (threadSummary.a(userKey).e) {
            return threadSummaryBuilder.V();
        }
        List<ThreadParticipant> list = threadSummaryBuilder.h;
        Builder builder = ImmutableList.builder();
        for (ThreadParticipant threadParticipant : list) {
            if (userKey.equals(threadParticipant.b())) {
                ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
                threadParticipantBuilder.a(threadParticipant);
                threadParticipantBuilder.e = true;
                builder.c(threadParticipantBuilder.f());
            } else {
                builder.c(threadParticipant);
            }
        }
        threadSummaryBuilder.h = builder.b();
        return threadSummaryBuilder.V();
    }
}
