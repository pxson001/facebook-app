package com.facebook.rtc.fbwebrtcnew;

import com.facebook.rtc.fbwebrtcnew.FbWebrtcCallModel.CallDirection;
import com.facebook.rtc.fbwebrtcnew.FbWebrtcCallModel.CallProtocol;
import com.facebook.rtc.fbwebrtcnew.FbWebrtcCallModel.CallType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/* compiled from: application/x-x509-user-cert */
public class FbWebrtcCallProperties {
    public long f19655a;
    public ImmutableList<String> f19656b;
    public ImmutableMap<String, FbWebrtcConferenceUserState> f19657c;
    public CallType f19658d;
    public CallDirection f19659e;
    public CallProtocol f19660f;
    public String f19661g;
    public String f19662h;
    public String f19663i;
    public boolean f19664j;
    public boolean f19665k;
    public boolean f19666l;
    public boolean f19667m;
    public boolean f19668n;
    public boolean f19669o;
    public long f19670p;
    public long f19671q;
    public FbWebrtcCallState f19672r;

    public FbWebrtcCallProperties(FbWebrtcCallPropertiesBuilder fbWebrtcCallPropertiesBuilder) {
        this.f19655a = fbWebrtcCallPropertiesBuilder.f19673a;
        this.f19656b = fbWebrtcCallPropertiesBuilder.f19674b;
        this.f19657c = fbWebrtcCallPropertiesBuilder.f19675c;
        this.f19658d = fbWebrtcCallPropertiesBuilder.f19676d;
        this.f19659e = fbWebrtcCallPropertiesBuilder.f19677e;
        this.f19660f = fbWebrtcCallPropertiesBuilder.f19678f;
        this.f19661g = fbWebrtcCallPropertiesBuilder.f19679g;
        this.f19662h = fbWebrtcCallPropertiesBuilder.f19680h;
        this.f19663i = fbWebrtcCallPropertiesBuilder.f19681i;
        this.f19664j = fbWebrtcCallPropertiesBuilder.f19682j;
        this.f19665k = fbWebrtcCallPropertiesBuilder.f19683k;
        this.f19666l = fbWebrtcCallPropertiesBuilder.f19684l;
        this.f19667m = fbWebrtcCallPropertiesBuilder.f19685m;
        this.f19668n = fbWebrtcCallPropertiesBuilder.f19686n;
        this.f19669o = fbWebrtcCallPropertiesBuilder.f19687o;
        this.f19670p = fbWebrtcCallPropertiesBuilder.f19688p;
        this.f19671q = fbWebrtcCallPropertiesBuilder.f19689q;
        this.f19672r = fbWebrtcCallPropertiesBuilder.f19690r;
    }
}
