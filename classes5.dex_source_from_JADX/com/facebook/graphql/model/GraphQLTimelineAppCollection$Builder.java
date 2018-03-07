package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: UNKNOWN_REPORT_PLACE */
public class GraphQLTimelineAppCollection$Builder extends Builder {
    @Nullable
    public GraphQLTimelineAppCollectionMembershipStateInfo f13285d;
    @Nullable
    public GraphQLTimelineAppCollectionMembershipStateInfo f13286e;
    @Nullable
    public GraphQLTimelineAppSection f13287f;
    @Nullable
    public GraphQLApplication f13288g;
    @Nullable
    public String f13289h;
    @Nullable
    public String f13290i;
    @Nullable
    public String f13291j;
    @Nullable
    public GraphQLMediaSet f13292k;
    @Nullable
    public String f13293l;
    @Nullable
    public GraphQLPrivacyOption f13294m;
    @Nullable
    public GraphQLTextWithEntities f13295n;
    @Nullable
    public GraphQLTimelineAppCollectionMembershipStateInfo f13296o;
    @Nullable
    public GraphQLSavedDashboardSection f13297p;
    public ImmutableList<GraphQLTimelineAppCollectionStyle> f13298q;
    public boolean f13299r;
    @Nullable
    public String f13300s;
    @Nullable
    public String f13301t;
    @Nullable
    public String f13302u;

    public GraphQLTimelineAppCollection$Builder() {
        Preconditions.checkState(this instanceof GraphQLTimelineAppCollection$Builder);
    }
}
