package com.facebook.entitycards.controller;

import android.os.Bundle;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.AbstractEntityCardsDataSource.C11881;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: image_portrait_width */
public class EntityCardsPresenterRegistryProvider extends AbstractAssistedProvider<EntityCardsPresenterRegistry> {
    public static EntityCardsPresenterRegistry m12892a(Bundle bundle, EntityCardsController entityCardsController, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, C11761 c11761, C11881 c11881, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger) {
        return new EntityCardsPresenterRegistry(bundle, entityCardsController, entityCardsDatasourceEventBus, c11761, c11881, entityCardsAnalyticsLogger);
    }
}
