package com.facebook.groups.groupactions;

import com.facebook.graphql.calls.GroupLeaveInputData.Source;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLLeavingGroupScenario;

/* compiled from: ThreadListFragment.onViewCreatedInbox2Views */
public class GroupLeaveActionData {
    public String f22565a;
    public String f22566b;
    private int f22567c;
    private GraphQLGroupVisibility f22568d;
    public GraphQLLeavingGroupScenario f22569e;
    public GraphQLGroupSubscriptionLevel f22570f;
    public Source f22571g;

    public GroupLeaveActionData(String str, String str2, int i, GraphQLGroupVisibility graphQLGroupVisibility, GraphQLLeavingGroupScenario graphQLLeavingGroupScenario, GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel, Source source) {
        this.f22565a = str;
        this.f22566b = str2;
        this.f22567c = i;
        this.f22568d = graphQLGroupVisibility;
        this.f22569e = graphQLLeavingGroupScenario;
        this.f22570f = graphQLGroupSubscriptionLevel;
        this.f22571g = source;
    }
}
