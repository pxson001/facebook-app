package com.facebook.groups.gysc.model;

import com.facebook.groups.gysc.protocol.FetchGroupsGyscModels.FetchGroupCreationSuggestionsModel.GroupsYouShouldCreateModel.NodesModel;

/* compiled from: paymentsFlowType */
public class SuggestionUnitsRowModel {
    public boolean f6945a;
    public NodesModel f6946b;

    /* compiled from: paymentsFlowType */
    public class Builder {
        public NodesModel f6944a;
    }

    public SuggestionUnitsRowModel(NodesModel nodesModel) {
        this.f6946b = nodesModel;
    }

    public final boolean m7224b() {
        return this.f6945a;
    }

    public final NodesModel m7225c() {
        return this.f6946b;
    }
}
