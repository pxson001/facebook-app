package com.facebook.feed.sponsored;

import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.graphql.model.BaseImpression;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.OrganicImpression;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.SponsoredImpression;

/* compiled from: me_user_version */
public class SponsoredUtils {
    public static boolean m21145a(FeedUnit feedUnit) {
        if (!(feedUnit instanceof Sponsorable)) {
            return false;
        }
        SponsoredImpression ab_ = ((Sponsorable) feedUnit).ab_();
        if (ab_ == null || !ab_.mo3121k()) {
            return false;
        }
        return true;
    }

    public static BaseImpression m21143a(Sponsorable sponsorable) {
        BaseImpression ab_ = sponsorable.ab_();
        if (ab_ != null && ab_.mo3121k()) {
            return ab_;
        }
        if (sponsorable instanceof GraphQLStory) {
            return OrganicImpression.m27468a((GraphQLStory) sponsorable);
        }
        return null;
    }

    public static Sponsorable m21144a(Object obj) {
        if (obj instanceof Sponsorable) {
            return (Sponsorable) obj;
        }
        if (obj instanceof GraphQLFeedUnitEdge) {
            return m21144a(((GraphQLFeedUnitEdge) obj).mo2540c());
        }
        if (obj instanceof BoundedAdapter) {
            return m21144a((Object) ((BoundedAdapter) obj).f13449d);
        }
        return null;
    }
}
