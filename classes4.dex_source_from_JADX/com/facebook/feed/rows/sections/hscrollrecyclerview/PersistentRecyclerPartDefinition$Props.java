package com.facebook.feed.rows.sections.hscrollrecyclerview;

import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.multirow.api.AnyEnvironment;

/* compiled from: device_free_space */
public class PersistentRecyclerPartDefinition$Props<SubProps, E extends AnyEnvironment> {
    public final PageStyle f13887a;
    public final int f13888b;
    public final PersistentRecyclerPartDefinition$Callbacks<SubProps, E> f13889c;
    public final String f13890d;
    public final CacheableEntity f13891e;

    public PersistentRecyclerPartDefinition$Props(PageStyle pageStyle, int i, PersistentRecyclerPartDefinition$Callbacks<SubProps, E> persistentRecyclerPartDefinition$Callbacks, String str, CacheableEntity cacheableEntity) {
        this.f13887a = pageStyle;
        this.f13888b = i;
        this.f13889c = persistentRecyclerPartDefinition$Callbacks;
        this.f13890d = str;
        this.f13891e = cacheableEntity;
    }
}
