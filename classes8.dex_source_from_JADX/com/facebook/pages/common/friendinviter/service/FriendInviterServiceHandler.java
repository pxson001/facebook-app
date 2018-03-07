package com.facebook.pages.common.friendinviter.service;

import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.friendinviter.protocol.FetchFriendsYouMayInviteMethod;
import com.facebook.pages.common.friendinviter.protocol.SendPageLikeInviteMethod;
import com.facebook.pages.common.friendinviter.protocol.SendPageLikeInviteMethod.Params;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: crypted_id */
public class FriendInviterServiceHandler implements BlueServiceHandler {
    public final Provider<SingleMethodRunner> f16566a;
    public final Lazy<SendPageLikeInviteMethod> f16567b;
    public final Lazy<FetchFriendsYouMayInviteMethod> f16568c;

    @Inject
    public FriendInviterServiceHandler(Provider<SingleMethodRunner> provider, Lazy<SendPageLikeInviteMethod> lazy, Lazy<FetchFriendsYouMayInviteMethod> lazy2) {
        this.f16566a = provider;
        this.f16567b = lazy;
        this.f16568c = lazy2;
    }

    public final OperationResult m19568a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("send_page_like_invite".equals(str)) {
            ((AbstractSingleMethodRunner) this.f16566a.get()).a((ApiMethod) this.f16567b.get(), (Params) operationParams.c.getParcelable("sendPageLikeInviteParams"));
            return OperationResult.a;
        } else if ("friends_you_may_invite".equals(str)) {
            return OperationResult.a(((AbstractSingleMethodRunner) this.f16566a.get()).a((ApiMethod) this.f16568c.get(), (FetchFriendsYouMayInviteMethod.Params) operationParams.c.getParcelable("fetchFriendsYouMayInviteParams")));
        } else {
            throw new ApiMethodNotFoundException(str);
        }
    }
}
