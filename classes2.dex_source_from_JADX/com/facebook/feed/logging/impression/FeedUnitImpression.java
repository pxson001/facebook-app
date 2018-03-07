package com.facebook.feed.logging.impression;

import com.facebook.common.util.StringLocaleUtil;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.BaseImpression;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.Impression.ImpressionType;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.google.common.collect.ImmutableMap;

/* compiled from: invited */
public class FeedUnitImpression {
    public final FeedUnitImpressionType f19513a;
    public final Object f19514b;
    public BaseImpression f19515c;
    public ImpressionType f19516d;
    public ArrayNode f19517e;
    public long f19518f;
    public final int f19519g;
    public long f19520h;
    public int f19521i;
    public int f19522j;
    public String f19523k;
    public int f19524l;
    public boolean f19525m;
    public int f19526n;
    public String f19527o;
    public int f19528p;
    public int f19529q = 0;
    public ImmutableMap<String, String> f19530r;

    public FeedUnitImpression(FeedUnitImpressionType feedUnitImpressionType, Object obj, ArrayNode arrayNode) {
        this.f19513a = feedUnitImpressionType;
        this.f19514b = obj;
        this.f19515c = null;
        this.f19518f = 0;
        this.f19517e = arrayNode;
        this.f19519g = obj instanceof ScrollableItemListFeedUnit ? ((ScrollableItemListFeedUnit) obj).ac_() : 0;
        this.f19520h = 0;
        this.f19521i = -1;
        this.f19522j = -1;
        this.f19524l = -1;
        this.f19525m = false;
        this.f19523k = "unknown";
        this.f19526n = -1;
        this.f19527o = null;
        this.f19528p = -1;
    }

    public final boolean m27208a() {
        if (this.f19514b == null) {
            return false;
        }
        if (this.f19514b instanceof HideableUnit) {
            StoryVisibility o = ((HideableUnit) this.f19514b).mo2879o();
            if (o == StoryVisibility.HIDDEN || o == StoryVisibility.GONE) {
                return false;
            }
        }
        if (this.f19513a == FeedUnitImpressionType.NON_SPONSORED_IMPRESSION || this.f19513a == FeedUnitImpressionType.SPONSORED_IMPRESSION || m27210b()) {
            return true;
        }
        return false;
    }

    public final boolean m27210b() {
        return this.f19517e != null && (!(this.f19517e.mo715k() == JsonNodeType.STRING && this.f19517e.m5205q()) && (this.f19517e.mo715k() == JsonNodeType.STRING || this.f19517e.mo712e() != 0));
    }

    public String toString() {
        String simpleName = this.f19514b.getClass().getSimpleName();
        String str = this.f19519g > 0 ? "(idx=" + this.f19519g + ")" : "";
        return StringLocaleUtil.m21640a("%s : %s %s", simpleName, this.f19516d, str);
    }

    public final FeedUnitImpressionType m27211c() {
        return this.f19513a;
    }

    public final FeedUnitImpression m27206a(BaseImpression baseImpression) {
        this.f19515c = baseImpression;
        return this;
    }

    public final FeedUnitImpression m27207a(ImpressionType impressionType) {
        this.f19516d = impressionType;
        return this;
    }

    public final int m27212m() {
        return this.f19521i;
    }

    public final FeedUnitImpression m27209b(int i) {
        this.f19521i = i;
        return this;
    }

    public final int m27213s() {
        return this.f19529q;
    }
}
