package com.facebook.storyteller.models;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Struct;

/* compiled from: measureWithLargestChild linear layout attribute requires Honeycomb or later */
public final class Location extends Struct {
    public static int m10767a(FlatBufferBuilder flatBufferBuilder, double d, double d2) {
        flatBufferBuilder.a(8, 16);
        flatBufferBuilder.a(d2);
        flatBufferBuilder.a(d);
        return flatBufferBuilder.a();
    }
}
