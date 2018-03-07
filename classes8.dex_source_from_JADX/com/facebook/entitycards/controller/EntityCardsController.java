package com.facebook.entitycards.controller;

import android.os.Bundle;
import com.facebook.entitycards.analytics.EntityCardAnalyticsEventListener;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.AbstractEntityCardsDataSource.C11881;
import com.facebook.entitycards.model.EntityCardFetchErrorService;
import com.facebook.entitycards.model.EntityCardsCardSupportDeclaration;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycards.view.EntityCardsBaseCardTypes;
import com.facebook.entitycards.view.EntityCardsCardType;
import com.facebook.inject.Assisted;
import com.facebook.presenter.ViewPresenter;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: image_xxhdpi */
public class EntityCardsController {
    private final EntityCardsBaseCardTypes f10949a;
    private final ImmutableSet<EntityCardsCardType> f10950b;
    private final ImmutableMap<Class<?>, EntityCardController<?>> f10951c;

    /* compiled from: image_xxhdpi */
    public abstract class EntityCardController<T> {
        public abstract EntityCardsCardType mo792a(T t);

        public abstract ViewPresenter mo793a(T t, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, EntityCardsActivityController entityCardsActivityController, EntityCardFetchErrorService entityCardFetchErrorService, EntityCardAnalyticsEventListener entityCardAnalyticsEventListener, Bundle bundle);
    }

    @Inject
    public EntityCardsController(@Assisted RecyclableViewPoolManager recyclableViewPoolManager, @Assisted Set<EntityCardsCardSupportDeclaration> set, EntityCardsBaseCardTypes entityCardsBaseCardTypes) {
        this.f10949a = entityCardsBaseCardTypes;
        Builder builder = ImmutableMap.builder();
        builder.a(this.f10949a.mo795b());
        ImmutableSet.Builder builder2 = ImmutableSet.builder();
        Iterator it = this.f10949a.mo794a().iterator();
        while (it.hasNext()) {
            EntityCardsCardType entityCardsCardType = (EntityCardsCardType) it.next();
            builder2.c(entityCardsCardType);
            recyclableViewPoolManager.a(entityCardsCardType.a(), entityCardsCardType.b(), entityCardsCardType.c());
        }
        for (EntityCardsCardSupportDeclaration entityCardsCardSupportDeclaration : set) {
            builder.a(entityCardsCardSupportDeclaration.mo795b());
            UnmodifiableIterator it2 = entityCardsCardSupportDeclaration.mo794a().iterator();
            while (it2.hasNext()) {
                entityCardsCardType = (EntityCardsCardType) it2.next();
                builder2.c(entityCardsCardType);
                recyclableViewPoolManager.a(entityCardsCardType.a(), entityCardsCardType.b(), entityCardsCardType.c());
            }
        }
        this.f10951c = builder.b();
        this.f10950b = builder2.b();
    }

    public final EntityCardsCardType m12888a(Object obj) {
        EntityCardsCardType a;
        EntityCardController entityCardController = (EntityCardController) this.f10951c.get(obj.getClass());
        if (entityCardController != null) {
            a = entityCardController.mo792a(obj);
        } else {
            a = null;
        }
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("EntityCardsController does not recognize a type for model " + obj.getClass());
    }

    public final ViewPresenter m12889a(Object obj, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, C11761 c11761, C11881 c11881, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, Bundle bundle) {
        ViewPresenter a;
        EntityCardController entityCardController = (EntityCardController) this.f10951c.get(obj.getClass());
        if (entityCardController != null) {
            a = entityCardController.mo793a(obj, entityCardsDatasourceEventBus, c11761, c11881, entityCardsAnalyticsLogger, bundle);
        } else {
            a = null;
        }
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("EntityCardsController does not recognize a presenter for model " + obj.getClass());
    }
}
