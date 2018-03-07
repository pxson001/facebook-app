package com.facebook.pages.common.surface.util;

import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import java.util.HashMap;

/* compiled from: redspace_home_self_content */
public class PagesReactionActionStyleToTabTypeMapper {
    public static final HashMap<GraphQLReactionStoryActionStyle, GraphQLPagePresenceTabType> f2703a = new C03601();

    /* compiled from: redspace_home_self_content */
    final class C03601 extends HashMap<GraphQLReactionStoryActionStyle, GraphQLPagePresenceTabType> {
        C03601() {
            put(GraphQLReactionStoryActionStyle.OPEN_PAGE_INFO, GraphQLPagePresenceTabType.ABOUT);
            put(GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_VIDEO_PLAYLISTS, GraphQLPagePresenceTabType.VIDEOS);
            put(GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_VIDEOS, GraphQLPagePresenceTabType.VIDEOS);
            put(GraphQLReactionStoryActionStyle.VIEW_PAGE_EVENTS, GraphQLPagePresenceTabType.EVENTS);
            put(GraphQLReactionStoryActionStyle.VIEW_PAGE_SERVICES, GraphQLPagePresenceTabType.SERVICES);
            put(GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_REVIEWS, GraphQLPagePresenceTabType.REVIEWS);
            put(GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_PHOTOS, GraphQLPagePresenceTabType.PHOTOS);
            put(GraphQLReactionStoryActionStyle.VIEW_PAGE_CHILD_LOCATIONS, GraphQLPagePresenceTabType.LOCATIONS);
            put(GraphQLReactionStoryActionStyle.PAGE_COMMERCE_OPEN_COLLECTION, GraphQLPagePresenceTabType.SHOP);
            put(GraphQLReactionStoryActionStyle.PAGE_COMMERCE_OPEN_STORE, GraphQLPagePresenceTabType.SHOP);
        }
    }
}
