package com.facebook.messaging.events.banner;

import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.ThreadRecipientUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: socksPort */
public class EventReminderMembersUtil {
    private static final Comparator<User> f2319a = new C03881();
    private final Provider<UserKey> f2320b;
    private final ThreadRecipientUtil f2321c;

    /* compiled from: socksPort */
    final class C03881 implements Comparator<User> {
        C03881() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((User) obj).h().compareTo(((User) obj2).h());
        }
    }

    /* compiled from: socksPort */
    /* synthetic */ class C03892 {
        static final /* synthetic */ int[] f2318a = new int[GraphQLLightweightEventGuestStatus.values().length];

        static {
            try {
                f2318a[GraphQLLightweightEventGuestStatus.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2318a[GraphQLLightweightEventGuestStatus.DECLINED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static EventReminderMembersUtil m2177b(InjectorLike injectorLike) {
        return new EventReminderMembersUtil(IdBasedProvider.a(injectorLike, 3597), ThreadRecipientUtil.b(injectorLike));
    }

    @Inject
    public EventReminderMembersUtil(Provider<UserKey> provider, ThreadRecipientUtil threadRecipientUtil) {
        this.f2320b = provider;
        this.f2321c = threadRecipientUtil;
    }

    @Nullable
    public final EventReminderMembers m2178a(ThreadKey threadKey, @Nullable ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus> immutableMap) {
        if (immutableMap == null) {
            return null;
        }
        ImmutableList a = this.f2321c.a(threadKey);
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLLightweightEventGuestStatus graphQLLightweightEventGuestStatus;
            User user = (User) a.get(i);
            if (immutableMap.get(user.T) == null) {
                graphQLLightweightEventGuestStatus = GraphQLLightweightEventGuestStatus.INVITED;
            } else {
                graphQLLightweightEventGuestStatus = (GraphQLLightweightEventGuestStatus) immutableMap.get(user.T);
            }
            switch (C03892.f2318a[graphQLLightweightEventGuestStatus.ordinal()]) {
                case 1:
                    arrayList.add(user);
                    break;
                case 2:
                    arrayList2.add(user);
                    break;
                default:
                    arrayList3.add(user);
                    break;
            }
        }
        Collections.sort(arrayList, f2319a);
        Collections.sort(arrayList2, f2319a);
        Collections.sort(arrayList3, f2319a);
        GraphQLLightweightEventGuestStatus graphQLLightweightEventGuestStatus2 = (GraphQLLightweightEventGuestStatus) immutableMap.get(this.f2320b.get());
        if (graphQLLightweightEventGuestStatus2 == null) {
            graphQLLightweightEventGuestStatus2 = GraphQLLightweightEventGuestStatus.INVITED;
        }
        return new EventReminderMembers(graphQLLightweightEventGuestStatus2, ImmutableList.copyOf(arrayList), ImmutableList.copyOf(arrayList2), ImmutableList.copyOf(arrayList3));
    }
}
