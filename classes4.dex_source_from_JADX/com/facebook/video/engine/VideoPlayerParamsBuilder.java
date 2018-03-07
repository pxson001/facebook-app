package com.facebook.video.engine;

import com.facebook.spherical.model.SphericalVideoParams;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: photo_tags */
public class VideoPlayerParamsBuilder {
    public List<VideoDataSource> f4851a = Lists.a();
    public String f4852b = "";
    public int f4853c = 0;
    public String f4854d = "";
    public ArrayNode f4855e = new ArrayNode(JsonNodeFactory.a);
    public boolean f4856f = false;
    public boolean f4857g = false;
    public boolean f4858h = false;
    public int f4859i = 0;
    public int f4860j = 0;
    public int f4861k = 0;
    @Nullable
    public SphericalVideoParams f4862l = null;
    public boolean f4863m = false;
    public boolean f4864n = false;
    public int f4865o = 0;
    public int f4866p = -1;
    public int f4867q = -1;
    public boolean f4868r = false;
    public boolean f4869s = false;

    public final VideoPlayerParamsBuilder m5262a(VideoPlayerParams videoPlayerParams) {
        this.f4851a = videoPlayerParams.f4832a;
        this.f4852b = videoPlayerParams.f4833b;
        this.f4853c = videoPlayerParams.f4834c;
        this.f4854d = videoPlayerParams.f4835d;
        this.f4855e = videoPlayerParams.f4836e;
        this.f4856f = videoPlayerParams.f4837f;
        this.f4857g = videoPlayerParams.f4840i;
        this.f4858h = videoPlayerParams.f4839h;
        this.f4859i = videoPlayerParams.f4847p;
        this.f4860j = videoPlayerParams.f4848q;
        this.f4861k = videoPlayerParams.f4849r;
        this.f4862l = videoPlayerParams.f4850s;
        this.f4863m = videoPlayerParams.f4841j;
        this.f4864n = videoPlayerParams.f4842k;
        this.f4865o = videoPlayerParams.f4843l;
        this.f4866p = videoPlayerParams.f4844m;
        this.f4867q = videoPlayerParams.f4845n;
        this.f4868r = videoPlayerParams.f4846o;
        this.f4869s = videoPlayerParams.m5256b();
        return this;
    }

    public final VideoPlayerParamsBuilder m5264a(List<VideoDataSource> list) {
        this.f4851a = Lists.a(list);
        return this;
    }

    public final VideoPlayerParamsBuilder m5261a(VideoDataSource videoDataSource) {
        this.f4851a.add(videoDataSource);
        return this;
    }

    public final VideoPlayerParamsBuilder m5263a(String str) {
        this.f4852b = str;
        return this;
    }

    public final VideoPlayerParamsBuilder m5258a(int i) {
        this.f4853c = i;
        return this;
    }

    public final VideoPlayerParamsBuilder m5265a(boolean z) {
        this.f4856f = z;
        return this;
    }

    public final VideoPlayerParamsBuilder m5267b(boolean z) {
        this.f4858h = z;
        return this;
    }

    public final VideoPlayerParamsBuilder m5268c(boolean z) {
        this.f4857g = z;
        return this;
    }

    public final VideoPlayerParamsBuilder m5259a(int i, int i2) {
        this.f4859i = i;
        this.f4860j = i2;
        return this;
    }

    public final VideoPlayerParamsBuilder m5266b(int i) {
        this.f4861k = i;
        return this;
    }

    public final VideoPlayerParamsBuilder m5260a(@Nullable SphericalVideoParams sphericalVideoParams) {
        this.f4862l = sphericalVideoParams;
        return this;
    }

    public final VideoPlayerParams m5271m() {
        return new VideoPlayerParams(this);
    }

    public final VideoPlayerParamsBuilder m5269d(boolean z) {
        this.f4863m = z;
        return this;
    }

    public final VideoPlayerParamsBuilder m5270e(boolean z) {
        this.f4864n = z;
        return this;
    }
}
