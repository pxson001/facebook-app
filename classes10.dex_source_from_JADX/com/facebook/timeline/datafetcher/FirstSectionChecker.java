package com.facebook.timeline.datafetcher;

import com.facebook.graphql.model.GraphQLTimelineSectionsConnection;

/* compiled from: group_docs_and_files */
public class FirstSectionChecker {
    public static void m10525a(GraphQLTimelineSectionsConnection graphQLTimelineSectionsConnection) {
        if (graphQLTimelineSectionsConnection == null) {
            throw new IllegalArgumentException("Expected a non-null first section");
        } else if (graphQLTimelineSectionsConnection.a() == null) {
            throw new IllegalArgumentException("Expected a non-null node list");
        } else if (graphQLTimelineSectionsConnection.a().isEmpty()) {
            throw new IllegalArgumentException("Expected a non-empty node list");
        }
    }
}
