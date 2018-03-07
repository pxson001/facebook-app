package com.facebook.groups.feed.data;

import android.content.res.Resources;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupViewerStatus;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/pages/edit/info/%s */
public class GroupsFeedHeaderFetcher {
    public static final GraphQLCachePolicy f14019a = GraphQLCachePolicy.d;
    public final GraphQLQueryExecutor f14020b;
    public final DefaultAndroidThreadUtil f14021c;
    public final ViewerStatusCache f14022d;
    public final ScreenUtil f14023e;
    public final AutomaticPhotoCaptioningUtils f14024f;
    public final Resources f14025g;

    /* compiled from: faceweb/f?href=/pages/edit/info/%s */
    public class C14901 implements FutureCallback<GraphQLResult<FetchGroupInformationModel>> {
        final /* synthetic */ String f14017a;
        final /* synthetic */ GroupsFeedHeaderFetcher f14018b;

        public C14901(GroupsFeedHeaderFetcher groupsFeedHeaderFetcher, String str) {
            this.f14018b = groupsFeedHeaderFetcher;
            this.f14017a = str;
        }

        public void onSuccess(Object obj) {
            this.f14018b.f14022d.m15637a(this.f14017a, (GroupViewerStatus) ((GraphQLResult) obj).e);
        }

        public void onFailure(Throwable th) {
        }
    }

    public static GroupsFeedHeaderFetcher m15611a(InjectorLike injectorLike) {
        return new GroupsFeedHeaderFetcher(GraphQLQueryExecutor.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), ViewerStatusCache.m15635a(injectorLike), ScreenUtil.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GroupsFeedHeaderFetcher(GraphQLQueryExecutor graphQLQueryExecutor, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ViewerStatusCache viewerStatusCache, ScreenUtil screenUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils, Resources resources) {
        this.f14020b = graphQLQueryExecutor;
        this.f14021c = defaultAndroidThreadUtil;
        this.f14022d = viewerStatusCache;
        this.f14023e = screenUtil;
        this.f14024f = automaticPhotoCaptioningUtils;
        this.f14025g = resources;
    }
}
