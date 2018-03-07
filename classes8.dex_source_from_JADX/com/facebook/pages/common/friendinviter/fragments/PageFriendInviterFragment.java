package com.facebook.pages.common.friendinviter.fragments;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.friendinviter.protocol.FetchFriendsYouMayInviteMethod;
import com.facebook.pages.common.friendinviter.protocol.FriendsYouMayInviteModels.FriendsYouMayInviteQueryModel.FriendsYouMayInviteModel;
import com.facebook.pages.common.friendinviter.protocol.FriendsYouMayInviteModels.FriendsYouMayInviteQueryModel.FriendsYouMayInviteModel.NodesModel;
import com.facebook.pages.common.friendinviter.protocol.SendPageLikeInviteMethod.Params;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cta_linkout_view */
public class PageFriendInviterFragment extends GenericFriendsSelectorFragment {
    @Inject
    public Lazy<AndroidThreadUtil> au;
    @Inject
    public DefaultBlueServiceOperationFactory av;
    @Inject
    public Lazy<Toaster> aw;
    @DefaultExecutorService
    @Inject
    public ExecutorService ax;
    public String ay;

    /* compiled from: cta_linkout_view */
    class C17921 implements Function<OperationResult, ImmutableMap<String, ImmutableList<User>>> {
        final /* synthetic */ PageFriendInviterFragment f16554a;

        /* compiled from: cta_linkout_view */
        class C17911 implements Comparator<User> {
            final /* synthetic */ C17921 f16553a;

            C17911(C17921 c17921) {
                this.f16553a = c17921;
            }

            public int compare(Object obj, Object obj2) {
                User user = (User) obj;
                User user2 = (User) obj2;
                if (user.e == null || user2.e == null) {
                    return 0;
                }
                return user.e.g().compareTo(user2.e.g());
            }
        }

        C17921(PageFriendInviterFragment pageFriendInviterFragment) {
            this.f16554a = pageFriendInviterFragment;
        }

        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            Builder builder = ImmutableMap.builder();
            if (operationResult == null) {
                return builder.b();
            }
            FriendsYouMayInviteModel friendsYouMayInviteModel = (FriendsYouMayInviteModel) operationResult.h();
            if (friendsYouMayInviteModel == null || friendsYouMayInviteModel.m19553a() == null) {
                return builder.b();
            }
            Collection arrayList = new ArrayList();
            ImmutableList a = friendsYouMayInviteModel.m19553a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) a.get(i);
                DefaultImageFieldsModel l = nodesModel.m19549l();
                if (!(nodesModel.m19547j() == null || nodesModel.m19548k() == null || l == null)) {
                    UserBuilder a2 = new UserBuilder().a(Type.FACEBOOK, nodesModel.m19547j());
                    a2.g = new Name(nodesModel.m19548k());
                    UserBuilder userBuilder = a2;
                    userBuilder.n = l.b();
                    arrayList.add(userBuilder.aa());
                }
            }
            Collections.sort(arrayList, new C17911(this));
            builder.b(GenericFriendsSelectorFragment.a, ImmutableList.copyOf(arrayList));
            return builder.b();
        }
    }

    /* compiled from: cta_linkout_view */
    class C17932 extends OperationResultFutureCallback {
        final /* synthetic */ PageFriendInviterFragment f16555a;

        C17932(PageFriendInviterFragment pageFriendInviterFragment) {
            this.f16555a = pageFriendInviterFragment;
        }

        protected final void m19528a(ServiceException serviceException) {
            ((Toaster) this.f16555a.aw.get()).b(new ToastBuilder(this.f16555a.jW_().getString(2131239344)));
        }

        protected final void m19529a(Object obj) {
            ((Toaster) this.f16555a.aw.get()).b(new ToastBuilder(2131237292));
            this.f16555a.aI();
        }
    }

    public static void m19530a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageFriendInviterFragment pageFriendInviterFragment = (PageFriendInviterFragment) obj;
        Lazy a = IdBasedLazy.a(fbInjector, 517);
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        Lazy a2 = IdBasedLazy.a(fbInjector, 3588);
        ExecutorService executorService = (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector);
        pageFriendInviterFragment.au = a;
        pageFriendInviterFragment.av = b;
        pageFriendInviterFragment.aw = a2;
        pageFriendInviterFragment.ax = executorService;
    }

    public final void m19532c(Bundle bundle) {
        Class cls = PageFriendInviterFragment.class;
        m19530a(this, getContext());
        super.c(bundle);
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.ay = (String) bundle2.get("page_id");
        }
    }

    protected final boolean m19531a(String str) {
        return true;
    }

    protected final boolean at() {
        return true;
    }

    protected final void aH() {
        ImmutableList ax = ax();
        int size = ax.size();
        for (int i = 0; i < size; i++) {
            String str = (String) ax.get(i);
            Bundle bundle = new Bundle();
            bundle.putParcelable("sendPageLikeInviteParams", new Params(this.ay, str));
            ((DefaultAndroidThreadUtil) this.au.get()).a(BlueServiceOperationFactoryDetour.a(this.av, "send_page_like_invite", bundle, -1374295322).a(), new C17932(this));
        }
    }

    protected final ListenableFuture<ImmutableMap<String, ImmutableList<User>>> ay() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchFriendsYouMayInviteParams", new FetchFriendsYouMayInviteMethod.Params(this.ay, 0, 300));
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.av, "friends_you_may_invite", bundle, 1370063296).a(), new C17921(this), this.ax);
    }
}
