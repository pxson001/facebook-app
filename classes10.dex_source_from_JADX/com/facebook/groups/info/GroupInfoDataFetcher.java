package com.facebook.groups.info;

import android.content.res.Resources;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.info.protocol.FetchGroupInfoPageData.FetchGroupInfoPageDataString;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: ThreadItemView.update */
public class GroupInfoDataFetcher {
    private final GraphQLQueryExecutor f22693a;
    private final DefaultAndroidThreadUtil f22694b;
    private final SizeAwareImageUtil f22695c;
    private final Resources f22696d;
    private final AutomaticPhotoCaptioningUtils f22697e;

    public static GroupInfoDataFetcher m23635b(InjectorLike injectorLike) {
        return new GroupInfoDataFetcher(GraphQLQueryExecutor.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), SizeAwareImageUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike));
    }

    @Inject
    public GroupInfoDataFetcher(GraphQLQueryExecutor graphQLQueryExecutor, DefaultAndroidThreadUtil defaultAndroidThreadUtil, SizeAwareImageUtil sizeAwareImageUtil, Resources resources, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f22693a = graphQLQueryExecutor;
        this.f22694b = defaultAndroidThreadUtil;
        this.f22695c = sizeAwareImageUtil;
        this.f22696d = resources;
        this.f22697e = automaticPhotoCaptioningUtils;
    }

    public final void m23636a(String str, String str2, String str3, String str4, String str5, String str6, GraphQLCachePolicy graphQLCachePolicy, FutureCallback<GraphQLResult<FetchGroupInfoPageDataModel>> futureCallback) {
        GraphQlQueryString fetchGroupInfoPageDataString = new FetchGroupInfoPageDataString();
        fetchGroupInfoPageDataString.a("group_id", str);
        fetchGroupInfoPageDataString.a("group_events_page_size", str2);
        fetchGroupInfoPageDataString.a("group_mediaset_page_size", str4);
        fetchGroupInfoPageDataString.a("photo_for_launcher_shortcut_size", str6);
        fetchGroupInfoPageDataString.a("cover_photo_size", Integer.valueOf(this.f22696d.getDimensionPixelSize(2131434316)));
        fetchGroupInfoPageDataString.a("profile_image_size", String.valueOf(this.f22696d.getDimensionPixelSize(2131434274)));
        if (str3 != null) {
            fetchGroupInfoPageDataString.a("group_events_page_cursor", str3);
        }
        if (str5 != null) {
            fetchGroupInfoPageDataString.a("group_mediaset_page_cursor", str5);
        }
        fetchGroupInfoPageDataString.a("automatic_photo_captioning_enabled", Boolean.toString(this.f22697e.a()));
        this.f22695c.a(fetchGroupInfoPageDataString);
        GraphQLQueryExecutor graphQLQueryExecutor = this.f22693a;
        GraphQLRequest a = GraphQLRequest.a(fetchGroupInfoPageDataString).a(graphQLCachePolicy);
        a.b = true;
        this.f22694b.a(graphQLQueryExecutor.a(a.a(604800)), futureCallback);
    }
}
