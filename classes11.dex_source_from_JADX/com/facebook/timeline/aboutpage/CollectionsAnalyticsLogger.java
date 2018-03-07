package com.facebook.timeline.aboutpage;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.profile.api.RelationshipType;
import java.util.HashSet;
import java.util.Set;

/* compiled from: NOT_VISIBLE */
public abstract class CollectionsAnalyticsLogger {
    public final AnalyticsLogger f12997a;
    public boolean f12998b;
    private final Set<String> f12999c = new HashSet();

    public abstract String mo370b();

    public CollectionsAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f12997a = analyticsLogger;
    }

    public final void m13740a(String str, RelationshipType relationshipType) {
        if (!this.f12998b) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("view");
            honeyClientEvent.c = mo370b();
            honeyClientEvent = honeyClientEvent;
            honeyClientEvent.b("profile_id", str);
            if (relationshipType != RelationshipType.UNDEFINED) {
                honeyClientEvent.a("relationship_type", relationshipType.getValue());
            }
            this.f12997a.c(honeyClientEvent);
            this.f12998b = true;
        }
    }

    public final void m13741a(String str, RelationshipType relationshipType, String str2, String str3) {
        if (!this.f12999c.contains(str3)) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("view_collection");
            honeyClientEvent.c = mo370b();
            honeyClientEvent = honeyClientEvent;
            honeyClientEvent.b("profile_id", str);
            if (relationshipType != RelationshipType.UNDEFINED) {
                honeyClientEvent.a("relationship_type", relationshipType.getValue());
            }
            honeyClientEvent.b("active_app_id", str2);
            honeyClientEvent.b("active_collection_id", str3);
            this.f12997a.c(honeyClientEvent);
            this.f12999c.add(str3);
        }
    }

    public static RelationshipType m13739a(ProfileViewerContext profileViewerContext) {
        if (GraphQLFriendshipStatus.ARE_FRIENDS.equals(profileViewerContext.c)) {
            return RelationshipType.FRIEND;
        }
        if (profileViewerContext.f()) {
            return RelationshipType.SELF;
        }
        if (GraphQLSubscribeStatus.IS_SUBSCRIBED.equals(profileViewerContext.d)) {
            return RelationshipType.SUBSCRIBED_TO;
        }
        return RelationshipType.UNKNOWN_RELATIONSHIP;
    }
}
