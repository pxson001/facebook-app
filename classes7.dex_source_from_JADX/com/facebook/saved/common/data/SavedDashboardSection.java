package com.facebook.saved.common.data;

import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;

/* compiled from: fetch_before_comments_ */
public class SavedDashboardSection {
    public GraphQLSavedDashboardSectionType f14406a;
    public int f14407b;

    public SavedDashboardSection(GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType, int i) {
        this.f14406a = graphQLSavedDashboardSectionType;
        this.f14407b = i;
    }

    public final GraphQLSavedDashboardSectionType m18286a() {
        return this.f14406a;
    }
}
