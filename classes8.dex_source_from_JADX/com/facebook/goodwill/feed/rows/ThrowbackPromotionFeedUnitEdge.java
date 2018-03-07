package com.facebook.goodwill.feed.rows;

import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.BaseFeedUnit;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.HasFeedUnit;

/* compiled from: fb4a_draft_composer_post_clicked */
public class ThrowbackPromotionFeedUnitEdge extends GraphQLFeedUnitEdge {

    /* compiled from: fb4a_draft_composer_post_clicked */
    public class ThrowbackPromotionFeedUnit extends BaseFeedUnit implements HasFeedUnit {
        private String f13775a;
        public String f13776b;
        public FeedUnit f13777c;
        public boolean f13778d;

        ThrowbackPromotionFeedUnit(String str, String str2, FeedUnit feedUnit, boolean z) {
            this.f13775a = str;
            this.f13776b = str2;
            this.f13777c = feedUnit;
            this.f13778d = z;
        }

        public final MutableFlatBuffer w_() {
            return null;
        }

        public final FeedUnit m15437c() {
            return this.f13777c;
        }
    }

    public ThrowbackPromotionFeedUnitEdge(String str, String str2, FeedUnit feedUnit, boolean z) {
        this.i = new ThrowbackPromotionFeedUnit(str, str2, feedUnit, z);
        this.f = str + str2;
    }

    public String toString() {
        return "GoodwillThrowback.PERMALINK_PROMOTION";
    }
}
