package com.facebook.pages.common.surface.tabs.tabbar.management;

import com.facebook.graphql.enums.GraphQLPagePresenceTabContentType;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.google.common.collect.ImmutableMap;

/* compiled from: request_sent */
public class PagesSurfaceSupportedTabs {
    public static final ImmutableMap<GraphQLPagePresenceTabType, Boolean> f2553a = ImmutableMap.builder().b(GraphQLPagePresenceTabType.ABOUT, Boolean.valueOf(true)).b(GraphQLPagePresenceTabType.EVENTS, Boolean.valueOf(true)).b(GraphQLPagePresenceTabType.HOME, Boolean.valueOf(true)).b(GraphQLPagePresenceTabType.LOCATIONS, Boolean.valueOf(true)).b(GraphQLPagePresenceTabType.PHOTOS, Boolean.valueOf(true)).b(GraphQLPagePresenceTabType.POSTS, Boolean.valueOf(true)).b(GraphQLPagePresenceTabType.REVIEWS, Boolean.valueOf(true)).b(GraphQLPagePresenceTabType.SERVICES, Boolean.valueOf(true)).b(GraphQLPagePresenceTabType.SHOP, Boolean.valueOf(true)).b(GraphQLPagePresenceTabType.VIDEOS, Boolean.valueOf(true)).b(GraphQLPagePresenceTabType.ACTIVITY, Boolean.valueOf(true)).b(GraphQLPagePresenceTabType.GROUPS, Boolean.valueOf(true)).b();
    public static final ImmutableMap<GraphQLPagePresenceTabContentType, Boolean> f2554b = ImmutableMap.of(GraphQLPagePresenceTabContentType.CUSTOM, Boolean.valueOf(true), GraphQLPagePresenceTabContentType.REACTION_SURFACE, Boolean.valueOf(true));
}
