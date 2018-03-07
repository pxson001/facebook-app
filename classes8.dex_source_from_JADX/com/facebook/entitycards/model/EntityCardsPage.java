package com.facebook.entitycards.model;

import com.facebook.entitycards.collect.ImmutableOffsetArray;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

/* compiled from: ia_related_article_block */
public class EntityCardsPage {
    public final ImmutableOffsetArray<String> f11035a;
    public final ImmutableMap<String, ?> f11036b;

    public static boolean m12980a(ImmutableOffsetArray<String> immutableOffsetArray, ImmutableMap<String, ?> immutableMap) {
        if (immutableOffsetArray.m12838b() != immutableMap.size()) {
            return false;
        }
        for (int i = 0; i < immutableOffsetArray.m12838b(); i++) {
            if (!immutableMap.containsKey((String) immutableOffsetArray.m12839b(i))) {
                return false;
            }
        }
        return true;
    }

    public EntityCardsPage(ImmutableOffsetArray<String> immutableOffsetArray, ImmutableMap<String, ?> immutableMap) {
        Preconditions.checkArgument(m12980a(immutableOffsetArray, immutableMap));
        this.f11035a = immutableOffsetArray;
        this.f11036b = immutableMap;
    }

    public final ImmutableOffsetArray<String> m12981b() {
        return this.f11035a;
    }
}
