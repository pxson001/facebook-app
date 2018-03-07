package com.facebook.messaging.service.model;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.user.model.User;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: createThreadId */
public class FetchGroupThreadsResultBuilder {
    public DataFreshnessResult f17053a;
    public ThreadsCollection f17054b;
    public List<User> f17055c = RegularImmutableList.a;
    public long f17056d = -1;
    public long f17057e = -1;

    FetchGroupThreadsResultBuilder() {
    }

    public final SearchThreadNameAndParticipantsResult m17085f() {
        return new SearchThreadNameAndParticipantsResult(this);
    }
}
