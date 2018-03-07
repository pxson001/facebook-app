package com.facebook.storyteller.models;

import com.google.flatbuffers.Table;

/* compiled from: graphql_ids */
public final class Burst extends Table {
    public final int m11440a() {
        int a = m11443a(6);
        return a != 0 ? this.f10991b.getInt(a + this.f10990a) : -1;
    }

    public final StoryTellerItem m11441a(StoryTellerItem storyTellerItem, int i) {
        int a = m11443a(8);
        return a != 0 ? storyTellerItem.m11454a(m11444b(m11447e(a) + (i * 4)), this.f10991b) : null;
    }

    public final int m11442b() {
        int a = m11443a(8);
        return a != 0 ? m11446d(a) : 0;
    }
}
