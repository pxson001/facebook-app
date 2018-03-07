package com.facebook.http.debug;

import android.annotation.SuppressLint;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Sets;
import java.util.Set;
import org.apache.http.HttpHost;

@SuppressLint({"UsingDefaultJsonDeserializer"})
/* compiled from: not present in emulated superclass */
public final class NetworkStatsHolder {
    public Set<HttpHost> f12183a = Sets.m1313a();
    @JsonProperty("bytesHeaders")
    public final ByteTransferCounter bytesHeaders = new ByteTransferCounter();
    @JsonProperty("bytesPayload")
    public final ByteTransferCounter bytesPayload = new ByteTransferCounter();
    @JsonProperty("numConnections")
    public int numConnections;
    @JsonProperty("numGets")
    public int numGets;
    @JsonProperty("numPosts")
    public int numPosts;
    @JsonProperty("requestName")
    public final String requestName;
    @JsonProperty("totalHttpFlows")
    public int totalHttpFlows;

    public NetworkStatsHolder(String str) {
        this.requestName = str;
    }
}
