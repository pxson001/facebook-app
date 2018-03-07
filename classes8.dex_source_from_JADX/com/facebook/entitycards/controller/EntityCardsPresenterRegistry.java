package com.facebook.entitycards.controller;

import android.os.Bundle;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.AbstractEntityCardsDataSource.C11881;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.inject.Assisted;
import com.facebook.presenter.ViewPresenter;
import com.google.common.collect.Maps;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: image_thumbnail_width */
public class EntityCardsPresenterRegistry {
    public final Bundle f10952a;
    public final EntityCardsController f10953b;
    public final EntityCardsDatasourceEventBus f10954c;
    public final C11761 f10955d;
    public final C11881 f10956e;
    public final EntityCardsAnalyticsLogger f10957f;
    private final HashMap<Object, ViewPresenter> f10958g = Maps.c();

    @Inject
    public EntityCardsPresenterRegistry(@Assisted Bundle bundle, @Assisted EntityCardsController entityCardsController, @Assisted EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, @Assisted C11761 c11761, @Assisted C11881 c11881, @Assisted EntityCardsAnalyticsLogger entityCardsAnalyticsLogger) {
        this.f10952a = bundle;
        this.f10954c = entityCardsDatasourceEventBus;
        this.f10955d = c11761;
        this.f10956e = c11881;
        this.f10953b = entityCardsController;
        this.f10957f = entityCardsAnalyticsLogger;
    }

    public final ViewPresenter m12891a(Object obj) {
        if (this.f10958g.containsKey(obj)) {
            return (ViewPresenter) this.f10958g.get(obj);
        }
        ViewPresenter a = this.f10953b.m12889a(obj, this.f10954c, this.f10955d, this.f10956e, this.f10957f, this.f10952a);
        this.f10958g.put(obj, a);
        return a;
    }
}
