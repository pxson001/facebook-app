package com.facebook.resources.impl.model;

import com.google.common.collect.ImmutableMap;

/* compiled from: download_asset */
public class StringResources$Plural {
    public final ImmutableMap<PluralCategory, String> f13694a;

    public StringResources$Plural(ImmutableMap<PluralCategory, String> immutableMap) {
        this.f13694a = immutableMap;
    }

    public final boolean m14457a(PluralCategory pluralCategory) {
        return this.f13694a.containsKey(pluralCategory);
    }

    public final String m14458b(PluralCategory pluralCategory) {
        return (String) this.f13694a.get(pluralCategory);
    }

    public boolean equals(Object obj) {
        if (obj instanceof StringResources$Plural) {
            if (this.f13694a.equals(((StringResources$Plural) obj).f13694a)) {
                return true;
            }
        }
        return false;
    }
}
