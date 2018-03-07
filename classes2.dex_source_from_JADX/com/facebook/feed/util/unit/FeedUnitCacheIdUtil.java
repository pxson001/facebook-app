package com.facebook.feed.util.unit;

import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;

/* compiled from: messenger_thread_action_panel */
public class FeedUnitCacheIdUtil {
    public static String m20097a(Object obj) {
        if (m20098b(obj)) {
            CacheableEntity c = obj instanceof GraphQLFeedUnitEdge ? ((GraphQLFeedUnitEdge) obj).mo2540c() : (CacheableEntity) obj;
            if (c.mo2507g() != null) {
                return c.mo2507g();
            }
            if (m20099c(c)) {
                return String.valueOf(((GraphQLStory) c).m22336V());
            }
            throw new UnsupportedOperationException("Could not identify a cache ID for object " + obj);
        }
        throw new UnsupportedOperationException("Could not identify a cache ID for object " + obj);
    }

    private static boolean m20099c(Object obj) {
        if (!(obj instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) obj;
        if (graphQLStory.mo2507g() != null || graphQLStory.m22336V() == 0) {
            return false;
        }
        return true;
    }

    public static boolean m20098b(Object obj) {
        if (!(obj instanceof CacheableEntity) && !(obj instanceof GraphQLFeedUnitEdge)) {
            return false;
        }
        if (obj instanceof GraphQLFeedUnitEdge) {
            obj = ((GraphQLFeedUnitEdge) obj).mo2540c();
        } else {
            CacheableEntity cacheableEntity = (CacheableEntity) obj;
        }
        if (obj.mo2507g() != null) {
            return true;
        }
        return m20099c(obj);
    }
}
