package com.facebook.katana.activity;

import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccount.FetchWorkCommunitiesFromPersonalAccountQueryString;
import com.facebook.work.postloginnux.PostLoginNuxManager;
import com.facebook.work.postloginnux.PostLoginNuxManager.C18151;
import com.google.common.util.concurrent.Futures;

/* compiled from: SDK_VERSION */
class FbMainTabActivity$37 implements Runnable {
    final /* synthetic */ FbMainTabActivity f24221a;

    FbMainTabActivity$37(FbMainTabActivity fbMainTabActivity) {
        this.f24221a = fbMainTabActivity;
    }

    public void run() {
        PostLoginNuxManager postLoginNuxManager = (PostLoginNuxManager) this.f24221a.ar.get();
        FbMainTabActivity fbMainTabActivity = this.f24221a;
        if (!postLoginNuxManager.f13032e.a(PostLoginNuxManager.f13030c, false) && !postLoginNuxManager.f13032e.a(PostLoginNuxManager.f13029b, false)) {
            postLoginNuxManager.f13037j = postLoginNuxManager.f13034g.a(GraphQLRequest.a(new FetchWorkCommunitiesFromPersonalAccountQueryString()));
            Futures.a(postLoginNuxManager.f13037j, new C18151(postLoginNuxManager, fbMainTabActivity));
        }
    }
}
