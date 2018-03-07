package com.facebook.http.observer;

import android.annotation.SuppressLint;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.facebook.http.protocol.HttpWireCallback;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

@SuppressLint({"UsingDefaultJsonDeserializer"})
/* compiled from: numPosts */
public class HttpFlowStatistics {
    public long f11994a;
    public TriState f11995b = TriState.UNSET;
    @JsonProperty("bytes_read_by_app")
    public final ByteCounter bytesReadByApp = new ByteCounter(Absent.INSTANCE);
    public final String f11996c;
    public TriState f11997d = TriState.UNSET;
    public String f11998e = null;
    public String f11999f = null;
    public String f12000g = null;
    public String f12001h = null;
    public String f12002i = null;
    public boolean f12003j = false;
    private HttpWireCallback f12004k = null;
    @JsonProperty("request_body")
    public final ByteCounter requestBodyBytes = new ByteCounter(Absent.INSTANCE);
    @JsonProperty("request_header")
    public final ByteCounter requestHeaderBytes = new ByteCounter(Absent.INSTANCE);
    @JsonProperty("response_body")
    public final ByteCounter responseBodyBytes;
    @JsonProperty("response_header")
    public final ByteCounter responseHeaderBytes = new ByteCounter(Absent.INSTANCE);

    public HttpFlowStatistics(String str, DownloadBandwidthManager downloadBandwidthManager, MonotonicClock monotonicClock, HttpWireCallback httpWireCallback) {
        this.f11996c = (String) Preconditions.checkNotNull(str);
        this.responseBodyBytes = new ByteCounter(Optional.of(new ResponseBandwidthManager(downloadBandwidthManager, monotonicClock)));
        this.f12004k = httpWireCallback;
    }

    public final void m17690a(boolean z) {
        this.f11995b = (TriState) Preconditions.checkNotNull(TriState.valueOf(z));
    }

    public final HttpWireCallback m17691b() {
        return this.f12004k;
    }

    public final void m17689a(String str) {
        this.f11998e = str;
    }

    public final String m17695d() {
        return this.f12000g;
    }

    public final void m17692b(String str) {
        this.f12000g = str;
    }

    public final void m17694c(String str) {
        this.f11999f = str;
    }

    public final String m17697e() {
        return this.f12001h;
    }

    public final void m17696d(String str) {
        this.f12001h = str;
    }

    public final String m17698g() {
        return this.f11996c;
    }

    public final void m17693b(boolean z) {
        this.f11997d = TriState.valueOf(z);
    }

    public final void m17699h() {
        if (!this.f11997d.isSet()) {
            this.f11997d = TriState.valueOf(false);
        }
    }

    public final long m17700i() {
        return this.requestHeaderBytes.f12005a + this.requestBodyBytes.f12005a;
    }

    public final String m17701k() {
        return this.f12002i;
    }

    public final void m17688a(long j) {
        this.f11994a = j;
    }

    public final long m17702l() {
        return this.f11994a;
    }
}
