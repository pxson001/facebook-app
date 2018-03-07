package com.facebook.search.events;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader;
import com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader.BootstrapEntitySource;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TimeToFetchPageHeaderDataFromServer */
public class FriendshipEventSubscriber {
    private static FriendshipEventSubscriber f21865d;
    private static final Object f21866e = new Object();
    public FriendingEventBus f21867a;
    public final FriendshipStatusChangedEventSubscriber f21868b = new FriendshipStatusChangedEventSubscriber(this);
    public Lazy<BootstrapEntitiesLoader> f21869c;

    /* compiled from: TimeToFetchPageHeaderDataFromServer */
    class FriendshipStatusChangedEventSubscriber extends com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ FriendshipEventSubscriber f21864a;

        public FriendshipStatusChangedEventSubscriber(FriendshipEventSubscriber friendshipEventSubscriber) {
            this.f21864a = friendshipEventSubscriber;
        }

        public final void m25347b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null && !friendshipStatusChangedEvent.c) {
                if (friendshipStatusChangedEvent.b == GraphQLFriendshipStatus.INCOMING_REQUEST || friendshipStatusChangedEvent.b == GraphQLFriendshipStatus.OUTGOING_REQUEST || friendshipStatusChangedEvent.b == GraphQLFriendshipStatus.ARE_FRIENDS || friendshipStatusChangedEvent.b == GraphQLFriendshipStatus.CAN_REQUEST) {
                    long j = friendshipStatusChangedEvent.a;
                    Builder builder = new Builder();
                    builder.c(Long.valueOf(j));
                    ((BootstrapEntitiesLoader) this.f21864a.f21869c.get()).a(builder.b(), BootstrapEntitySource.FRIENDSHIP_STATUS_CHANGE);
                }
            }
        }
    }

    private static FriendshipEventSubscriber m25349b(InjectorLike injectorLike) {
        return new FriendshipEventSubscriber(FriendingEventBus.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10475));
    }

    @Inject
    public FriendshipEventSubscriber(FriendingEventBus friendingEventBus, Lazy<BootstrapEntitiesLoader> lazy) {
        this.f21867a = friendingEventBus;
        this.f21869c = lazy;
    }

    public final void m25350a() {
        this.f21867a.a(this.f21868b);
    }

    public static FriendshipEventSubscriber m25348a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendshipEventSubscriber b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21866e) {
                FriendshipEventSubscriber friendshipEventSubscriber;
                if (a2 != null) {
                    friendshipEventSubscriber = (FriendshipEventSubscriber) a2.a(f21866e);
                } else {
                    friendshipEventSubscriber = f21865d;
                }
                if (friendshipEventSubscriber == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25349b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21866e, b3);
                        } else {
                            f21865d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendshipEventSubscriber;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
