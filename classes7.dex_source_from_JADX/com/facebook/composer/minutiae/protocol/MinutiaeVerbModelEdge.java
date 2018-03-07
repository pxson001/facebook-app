package com.facebook.composer.minutiae.protocol;

import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQLModels.FetchRankedVerbsQueryModel.MinutiaeSuggestionsModel.NodesModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;

/* compiled from: time_duration */
public class MinutiaeVerbModelEdge {
    public final MinutiaeTaggableActivity f1703a;
    public final String f1704b;

    public MinutiaeVerbModelEdge(MinutiaeTaggableActivity minutiaeTaggableActivity) {
        this.f1703a = minutiaeTaggableActivity;
        this.f1704b = null;
    }

    public MinutiaeVerbModelEdge(NodesModel nodesModel) {
        this.f1703a = nodesModel.j();
        this.f1704b = nodesModel.a();
    }
}
