package com.facebook.feed.model;

import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.BaseFeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;

/* compiled from: last_hit_previously_ranked_stories_time */
public class GapFeedEdge extends GraphQLFeedUnitEdge {

    /* compiled from: last_hit_previously_ranked_stories_time */
    public class GapFeedUnit extends BaseFeedUnit {
        public final String f17969a;

        public GapFeedUnit(String str) {
            this.f17969a = str;
        }

        public final MutableFlatBuffer w_() {
            return null;
        }
    }

    public GapFeedEdge(String str, String str2, String str3, String str4) {
        this.f12980i = new GapFeedUnit(str4);
        this.f12977f = str3;
        this.f12982k = str;
        this.f12976e = str2;
    }

    public String toString() {
        return "FEED_GAP_ROW";
    }
}
