package com.facebook.goodfriends.data;

import android.app.Activity;
import android.content.Intent;
import com.facebook.debug.log.BLog;
import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger.Event;
import com.facebook.goodfriends.audience.AudienceFragment;
import com.facebook.goodfriends.audience.AudienceFragment.2;
import com.facebook.goodfriends.audience.AudienceRecyclerAdapter;
import com.facebook.goodfriends.protocol.GoodFriendsMutatorsModels.FriendListUpdateMembersFieldsModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mSrcUrl */
public class FriendStateMutationHelper {
    public final GraphQLQueryExecutor f10912a;
    public final Executor f10913b;
    public final Provider<String> f10914c;

    /* compiled from: mSrcUrl */
    public class C06741 implements FutureCallback<GraphQLResult<FriendListUpdateMembersFieldsModel>> {
        final /* synthetic */ 2 f10910a;
        final /* synthetic */ FriendStateMutationHelper f10911b;

        public C06741(FriendStateMutationHelper friendStateMutationHelper, 2 2) {
            this.f10911b = friendStateMutationHelper;
            this.f10910a = 2;
        }

        public void onSuccess(@Nullable Object obj) {
            boolean z;
            2 2 = this.f10910a;
            2.a.aq.hide();
            Intent intent = new Intent();
            String str = "has_good_friends";
            if (2.a.g.o > 0) {
                z = true;
            } else {
                z = false;
            }
            intent.putExtra(str, z);
            str = "audience_changed";
            AudienceRecyclerAdapter audienceRecyclerAdapter = 2.a.g;
            if (audienceRecyclerAdapter.j.isEmpty() && audienceRecyclerAdapter.k.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            intent.putExtra(str, z);
            Activity ao = 2.a.ao();
            if (ao == null) {
                ao = (Activity) Preconditions.checkNotNull(2.a.o());
            }
            2.a.d.a(2.a.g.o, 2.a.g.l());
            2.a.d.a(Event.PICKER_CLOSE);
            ao.setResult(-1, intent);
            ao.finish();
        }

        public void onFailure(Throwable th) {
            this.f10910a.a.aq.hide();
            BLog.b(AudienceFragment.a, "Error while mutation", th);
        }
    }

    @Inject
    public FriendStateMutationHelper(GraphQLQueryExecutor graphQLQueryExecutor, Executor executor, Provider<String> provider) {
        this.f10912a = graphQLQueryExecutor;
        this.f10913b = executor;
        this.f10914c = provider;
    }
}
