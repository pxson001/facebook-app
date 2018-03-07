package com.facebook.photos.base.analytics.upload;

import com.facebook.common.util.StringUtil;
import java.util.HashMap;

/* compiled from: injected_trending_topic_id */
public class PublishStageBaseParams {
    private final String f12690a;
    private final int f12691b;
    private final int f12692c;
    private final int f12693d;
    private final int f12694e;
    private final int f12695f;

    /* compiled from: injected_trending_topic_id */
    public class Builder {
        public String f12684a = null;
        public int f12685b = 0;
        public int f12686c;
        public int f12687d = 0;
        public int f12688e = 0;
        public int f12689f = 0;
    }

    public PublishStageBaseParams(Builder builder) {
        this.f12690a = builder.f12684a;
        this.f12691b = builder.f12685b;
        this.f12692c = builder.f12686c;
        this.f12693d = builder.f12687d;
        this.f12694e = builder.f12688e;
        this.f12695f = builder.f12689f;
    }

    public final HashMap<String, String> m20076a(HashMap<String, String> hashMap) {
        if (!StringUtil.a(this.f12690a)) {
            hashMap.put("target_type", this.f12690a);
        }
        hashMap.put("batch_size", Integer.toString(this.f12691b));
        hashMap.put("media_attachment_count", Integer.toString(this.f12692c));
        hashMap.put("xy_tag_count", Integer.toString(this.f12693d));
        hashMap.put("with_tag_count", Integer.toString(this.f12694e));
        hashMap.put("auto_retry_count", Integer.toString(this.f12695f));
        return hashMap;
    }
}
