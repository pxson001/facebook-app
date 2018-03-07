package com.facebook.composer.minutiae;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel;

/* compiled from: total_assets_within_bursts_count */
public class MinutiaeTypeaheadEventBuilder {
    public String f1445a = null;
    public int f1446b = 0;
    public int f1447c = 0;
    public boolean f1448d = false;
    public String f1449e = null;
    public int f1450f = -1;
    public String f1451g;

    public MinutiaeTypeaheadEventBuilder(String str) {
        this.f1451g = str;
    }

    public final MinutiaeTypeaheadEventBuilder m1535a(TaggableObjectEdgeModel taggableObjectEdgeModel, int i) {
        this.f1449e = taggableObjectEdgeModel.af_() != null ? taggableObjectEdgeModel.af_().d() : null;
        this.f1450f = i;
        this.f1448d = true;
        return this;
    }

    public static void m1534a(HoneyClientEvent honeyClientEvent, String str, String str2) {
        if (str2 != null) {
            honeyClientEvent.b(str, str2);
        }
    }
}
