package com.facebook.messaging.cache;

import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: is_exposure_holdout */
public class EventReminderMembersCache {
    private final ThreadsCacheLock f10031a;
    private final Map<String, ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus>> f10032b = new HashMap();

    public EventReminderMembersCache(ThreadsCacheLock threadsCacheLock) {
        this.f10031a = threadsCacheLock;
    }

    public final ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus> m10485a(String str) {
        this.f10031a.m10459b();
        return (ImmutableMap) this.f10032b.get(str);
    }

    public final void m10486a(ImmutableList<ThreadEventReminder> immutableList) {
        this.f10031a.m10459b();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadEventReminder threadEventReminder = (ThreadEventReminder) immutableList.get(i);
            this.f10032b.put(threadEventReminder.a, threadEventReminder.e);
        }
    }
}
