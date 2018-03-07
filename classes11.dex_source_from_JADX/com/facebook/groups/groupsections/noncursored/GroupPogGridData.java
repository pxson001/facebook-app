package com.facebook.groups.groupsections.noncursored;

import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLLeavingGroupScenario;
import com.facebook.groups.groupsections.noncursored.protocol.FetchGroupSectionModels.FetchGroupSectionModel.ActorModel.GroupsModel.NodesModel;

/* compiled from: \) */
public class GroupPogGridData {
    public String f10223a;
    public String f10224b;
    public String f10225c;
    public long f10226d;
    public long f10227e;
    public int f10228f;
    public boolean f10229g;
    public boolean f10230h;
    public boolean f10231i;
    public boolean f10232j;
    public GraphQLGroupSubscriptionLevel f10233k;
    public GraphQLLeavingGroupScenario f10234l;

    public GroupPogGridData(NodesModel nodesModel) {
        boolean z = false;
        this.f10223a = nodesModel.m10690n();
        this.f10224b = nodesModel.m10693q();
        this.f10229g = nodesModel.m10688l();
        this.f10230h = nodesModel.m10689m();
        this.f10225c = null;
        if (!(nodesModel.m10686j() == null || nodesModel.m10686j().a() == null || nodesModel.m10686j().a().a() == null)) {
            this.f10225c = nodesModel.m10686j().a().a().a();
        }
        this.f10228f = 0;
        if (nodesModel.m10687k() != null) {
            this.f10228f = nodesModel.m10687k().a();
        }
        this.f10231i = nodesModel.m10691o();
        this.f10227e = nodesModel.m10692p();
        this.f10226d = nodesModel.m10695s();
        if (nodesModel.m10694r() == GraphQLGroupJoinState.MEMBER) {
            z = true;
        }
        this.f10232j = z;
        this.f10233k = nodesModel.m10697u();
        this.f10234l = nodesModel.m10696t();
    }

    public GroupPogGridData(GroupPogGridData groupPogGridData) {
        this.f10223a = groupPogGridData.f10223a;
        this.f10224b = groupPogGridData.f10224b;
        this.f10229g = groupPogGridData.f10229g;
        this.f10230h = groupPogGridData.f10230h;
        this.f10225c = groupPogGridData.f10225c;
        this.f10228f = groupPogGridData.f10228f;
        this.f10231i = groupPogGridData.f10231i;
        this.f10227e = groupPogGridData.f10227e;
        this.f10226d = groupPogGridData.f10226d;
        this.f10232j = groupPogGridData.f10232j;
        this.f10233k = groupPogGridData.f10233k;
        this.f10234l = groupPogGridData.f10234l;
    }
}
