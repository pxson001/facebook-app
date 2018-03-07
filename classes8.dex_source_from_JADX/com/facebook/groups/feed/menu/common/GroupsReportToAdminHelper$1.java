package com.facebook.groups.feed.menu.common;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupReportStoryToAdminInputData;
import com.facebook.graphql.calls.GroupReportStoryToAdminInputData.Source;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FeedStoryMutations.GroupReportStoryToAdminMutationString;
import com.google.common.util.concurrent.Futures;

/* compiled from: viewDidAppear */
class GroupsReportToAdminHelper$1 implements OnClickListener {
    final /* synthetic */ Context f507a;
    final /* synthetic */ GraphQLStory f508b;
    final /* synthetic */ GroupsReportToAdminHelper f509c;

    GroupsReportToAdminHelper$1(GroupsReportToAdminHelper groupsReportToAdminHelper, Context context, GraphQLStory graphQLStory) {
        this.f509c = groupsReportToAdminHelper;
        this.f507a = context;
        this.f508b = graphQLStory;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        GroupsReportToAdminHelper groupsReportToAdminHelper = this.f509c;
        Context context = this.f507a;
        GraphQLStory graphQLStory = this.f508b;
        GraphQLStory graphQLStory2 = this.f508b;
        if (graphQLStory2 == null || graphQLStory2.aJ() == null || graphQLStory2.aJ().b() == null) {
            str = null;
        } else {
            str = graphQLStory2.aJ().b();
        }
        String str2 = str;
        GroupReportStoryToAdminInputData groupReportStoryToAdminInputData = new GroupReportStoryToAdminInputData();
        groupReportStoryToAdminInputData.a("actor_id", groupsReportToAdminHelper.a);
        GraphQlCallInput graphQlCallInput = groupReportStoryToAdminInputData;
        graphQlCallInput.a("story_id", graphQLStory.c());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("source", Source.TREEHOUSE_GROUP_MALL);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("group_id", str2);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString groupReportStoryToAdminMutationString = new GroupReportStoryToAdminMutationString();
        groupReportStoryToAdminMutationString.a("input", graphQlCallInput);
        Futures.a(groupsReportToAdminHelper.b.a(GraphQLRequest.a(groupReportStoryToAdminMutationString)), new GroupsReportToAdminHelper$2(groupsReportToAdminHelper, context), groupsReportToAdminHelper.c);
    }
}
