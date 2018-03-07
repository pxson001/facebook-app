package com.facebook.messaging.model.share;

import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.momentsinvite.model.MomentsInviteData;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: upload-video-chunk-receive */
public class ShareBuilder {
    public String f2195a;
    public String f2196b;
    public String f2197c;
    public String f2198d;
    public String f2199e;
    public String f2200f;
    public List<ShareMedia> f2201g = Collections.emptyList();
    public List<ShareProperty> f2202h = Collections.emptyList();
    public OpenGraphActionRobotext f2203i;
    public String f2204j;
    public String f2205k;
    public CommerceData f2206l;
    public MomentsInviteData f2207m;

    public final ShareBuilder m3474b(String str) {
        this.f2197c = str;
        return this;
    }

    public final ShareBuilder m3476c(String str) {
        this.f2198d = str;
        return this;
    }

    public final ShareBuilder m3477d(String str) {
        this.f2199e = str;
        return this;
    }

    public final ShareBuilder m3473a(List<ShareMedia> list) {
        this.f2201g = list;
        return this;
    }

    public final ShareBuilder m3478e(String str) {
        this.f2200f = str;
        return this;
    }

    public final ShareBuilder m3475b(List<ShareProperty> list) {
        this.f2202h = list;
        return this;
    }

    public final ShareBuilder m3472a(@Nullable OpenGraphActionRobotext openGraphActionRobotext) {
        this.f2203i = openGraphActionRobotext;
        return this;
    }

    public final ShareBuilder m3479f(@Nullable String str) {
        this.f2204j = str;
        return this;
    }

    public final ShareBuilder m3480g(@Nullable String str) {
        this.f2205k = str;
        return this;
    }

    public final ShareBuilder m3470a(@Nullable CommerceData commerceData) {
        this.f2206l = commerceData;
        return this;
    }

    public final ShareBuilder m3471a(@Nullable MomentsInviteData momentsInviteData) {
        this.f2207m = momentsInviteData;
        return this;
    }

    public final Share m3481n() {
        return new Share(this);
    }
}
