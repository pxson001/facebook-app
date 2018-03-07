package com.facebook.entitycards.model.event;

import com.facebook.common.util.StringUtil;
import com.google.common.base.Preconditions;

/* compiled from: home_edit_updated */
public class EntityModelLoadErrorEvent extends EntityCardsModelEvent {
    public final String f11086a;

    public EntityModelLoadErrorEvent(String str) {
        Preconditions.checkArgument(!StringUtil.a(str));
        this.f11086a = str;
    }
}
