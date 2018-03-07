package com.facebook.groups.feed.menu.common;

import android.content.Context;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.feed.protocol.FeedStoryMutationsModels.GroupReportStoryToAdminMutationModel;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: viewDidAppear */
public class GroupsReportToAdminHelper$2 implements FutureCallback<GraphQLResult<GroupReportStoryToAdminMutationModel>> {
    final /* synthetic */ Context f510a;
    final /* synthetic */ GroupsReportToAdminHelper f511b;

    public GroupsReportToAdminHelper$2(GroupsReportToAdminHelper groupsReportToAdminHelper, Context context) {
        this.f511b = groupsReportToAdminHelper;
        this.f510a = context;
    }

    public void onSuccess(Object obj) {
        new Builder(this.f510a).b(this.f510a.getResources().getString(2131233448)).a(17039370, null).b();
    }

    public void onFailure(Throwable th) {
        new Builder(this.f510a).b(this.f510a.getResources().getString(2131233449)).a(17039370, null).b();
    }
}
