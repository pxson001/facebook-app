package com.facebook.friends.service;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.friends.protocol.AddFriendListMemberMethod;
import com.facebook.friends.protocol.BlacklistPeopleYouMayInviteMethod;
import com.facebook.friends.protocol.BlacklistPeopleYouMayKnowMethod;
import com.facebook.friends.protocol.BlacklistPeopleYouShouldFollowMethod;
import com.facebook.friends.protocol.BlockUserMethod;
import com.facebook.friends.protocol.MarkFriendRequestsSeenMethod;
import com.facebook.friends.protocol.PokeUserMethod;
import com.facebook.friends.protocol.RemoveFriendListMemberMethod;
import com.facebook.friends.protocol.SetNotificationPreferenceMethod;
import com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod;
import com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod.Params;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: mSuggestedCoverPhotos */
public class FriendingServiceHandler implements BlueServiceHandler {
    private static FriendingServiceHandler f10834m;
    private static final Object f10835n = new Object();
    public final Provider<SingleMethodRunner> f10836a;
    public final Lazy<UpdatePeopleYouMayKnowHistoryMethod> f10837b;
    public final Lazy<SetNotificationPreferenceMethod> f10838c;
    public final Lazy<BlockUserMethod> f10839d;
    public final Lazy<PokeUserMethod> f10840e;
    public final Lazy<AddFriendListMemberMethod> f10841f;
    public final Lazy<RemoveFriendListMemberMethod> f10842g;
    public final Lazy<MarkFriendRequestsSeenMethod> f10843h;
    public final Lazy<BlacklistPeopleYouMayInviteMethod> f10844i;
    public final Lazy<BlacklistPeopleYouMayKnowMethod> f10845j;
    public final Lazy<BlacklistPeopleYouShouldFollowMethod> f10846k;
    public final Lazy<GraphQLCacheManager> f10847l;

    private static FriendingServiceHandler m17417b(InjectorLike injectorLike) {
        return new FriendingServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), IdBasedLazy.a(injectorLike, 6704), IdBasedLazy.a(injectorLike, 6703), IdBasedLazy.a(injectorLike, 6698), IdBasedLazy.a(injectorLike, 6701), IdBasedLazy.a(injectorLike, 6694), IdBasedLazy.a(injectorLike, 6702), IdBasedSingletonScopeProvider.b(injectorLike, 6700), IdBasedLazy.a(injectorLike, 6695), IdBasedLazy.a(injectorLike, 6696), IdBasedLazy.a(injectorLike, 6697), IdBasedSingletonScopeProvider.b(injectorLike, 2179));
    }

    public final OperationResult m17418a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("friending_update_people_you_may_know_history".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10836a.get()).a((ApiMethod) this.f10837b.get(), (Params) operationParams.c.getParcelable("updatePeopleYouMayKnowHistory"));
            return OperationResult.a;
        } else if ("friending_set_notification_preference".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10836a.get()).a((ApiMethod) this.f10838c.get(), (SetNotificationPreferenceMethod.Params) operationParams.c.getParcelable("setNotificationPreference"));
            return OperationResult.a;
        } else if ("friending_block_user".equals(str) || "friending_block_multiple_users".equals(str)) {
            BlockUserMethod.Params params = (BlockUserMethod.Params) operationParams.c.getParcelable("blockUser");
            if (params == null) {
                r2 = OperationResult.a(ErrorCode.API_ERROR);
            } else {
                HashSet hashSet;
                GraphQLCacheManager graphQLCacheManager = (GraphQLCacheManager) this.f10847l.get();
                if (params.f10674c) {
                    hashSet = new HashSet(params.f10675d);
                } else {
                    hashSet = ImmutableSet.of(String.valueOf(params.f10672a));
                }
                graphQLCacheManager.a(hashSet);
                ((AbstractSingleMethodRunner) this.f10836a.get()).a((ApiMethod) this.f10839d.get(), params);
                r2 = OperationResult.a;
            }
            return r2;
        } else if ("friending_poke_user".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10836a.get()).a((ApiMethod) this.f10840e.get(), (PokeUserMethod.Params) operationParams.c.getParcelable("pokeUser"));
            return OperationResult.a;
        } else if ("friending_add_friend_list_member".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10836a.get()).a((ApiMethod) this.f10841f.get(), (AddFriendListMemberMethod.Params) operationParams.c.getParcelable("addFriendListMemberParams"));
            return OperationResult.a;
        } else if ("friending_remove_friend_list_member".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10836a.get()).a((ApiMethod) this.f10842g.get(), (RemoveFriendListMemberMethod.Params) operationParams.c.getParcelable("removeFriendListMemberParams"));
            return OperationResult.a;
        } else if ("friending_mark_friend_requests_seen".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10836a.get()).a((ApiMethod) this.f10843h.get(), null);
            return OperationResult.a;
        } else if ("friending_blacklist_people_you_may_invite".equals(str)) {
            r4 = operationParams.c.getString("blacklistPeopleYouMayInviteParamsKey");
            if (StringUtil.a(r4)) {
                r2 = OperationResult.a(ErrorCode.OTHER);
            } else if (((Boolean) ((AbstractSingleMethodRunner) this.f10836a.get()).a((ApiMethod) this.f10844i.get(), r4, operationParams.e)).booleanValue()) {
                r2 = OperationResult.a;
            } else {
                r2 = OperationResult.a(ErrorCode.OTHER);
            }
            return r2;
        } else if ("friending_blacklist_people_you_may_know".equals(str)) {
            r4 = operationParams.c.getString("blacklistPeopleYouMayKnowParamsKey");
            if (StringUtil.a(r4)) {
                r2 = OperationResult.a(ErrorCode.OTHER);
            } else if (((Boolean) ((AbstractSingleMethodRunner) this.f10836a.get()).a((ApiMethod) this.f10845j.get(), r4, operationParams.e)).booleanValue()) {
                r2 = OperationResult.a;
            } else {
                r2 = OperationResult.a(ErrorCode.OTHER);
            }
            return r2;
        } else if ("friending_blacklist_people_you_should_follow".equals(str)) {
            r4 = operationParams.c.getString("blacklistPeopleYouShouldFollowParamsKey");
            r2 = StringUtil.a(r4) ? OperationResult.a(ErrorCode.OTHER) : ((Boolean) ((AbstractSingleMethodRunner) this.f10836a.get()).a((ApiMethod) this.f10846k.get(), r4, operationParams.e)).booleanValue() ? OperationResult.a : OperationResult.a(ErrorCode.OTHER);
            return r2;
        } else {
            throw new IllegalArgumentException("Unknown operation type");
        }
    }

    public static FriendingServiceHandler m17416a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendingServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10835n) {
                FriendingServiceHandler friendingServiceHandler;
                if (a2 != null) {
                    friendingServiceHandler = (FriendingServiceHandler) a2.a(f10835n);
                } else {
                    friendingServiceHandler = f10834m;
                }
                if (friendingServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m17417b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10835n, b3);
                        } else {
                            f10834m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendingServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FriendingServiceHandler(Provider<SingleMethodRunner> provider, Lazy<UpdatePeopleYouMayKnowHistoryMethod> lazy, Lazy<SetNotificationPreferenceMethod> lazy2, Lazy<BlockUserMethod> lazy3, Lazy<PokeUserMethod> lazy4, Lazy<AddFriendListMemberMethod> lazy5, Lazy<RemoveFriendListMemberMethod> lazy6, Lazy<MarkFriendRequestsSeenMethod> lazy7, Lazy<BlacklistPeopleYouMayInviteMethod> lazy8, Lazy<BlacklistPeopleYouMayKnowMethod> lazy9, Lazy<BlacklistPeopleYouShouldFollowMethod> lazy10, Lazy<GraphQLCacheManager> lazy11) {
        this.f10836a = provider;
        this.f10837b = lazy;
        this.f10838c = lazy2;
        this.f10839d = lazy3;
        this.f10840e = lazy4;
        this.f10841f = lazy5;
        this.f10842g = lazy6;
        this.f10843h = lazy7;
        this.f10844i = lazy8;
        this.f10845j = lazy9;
        this.f10846k = lazy10;
        this.f10847l = lazy11;
    }
}
