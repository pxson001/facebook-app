package com.facebook.entitycards.view;

import com.facebook.entitycards.controller.EntityCardsController;
import com.facebook.entitycards.controller.EntityCardsPresenterRegistry;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;

/* compiled from: home_%s_update_camera_icon_tapped */
public class EntityCardContainerPresenterProvider extends AbstractAssistedProvider<EntityCardContainerPresenter> {
    public final EntityCardContainerPresenter m13042a(EntityCardsController entityCardsController, Object obj, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, EntityCardsPresenterRegistry entityCardsPresenterRegistry, RecyclableViewPoolManager recyclableViewPoolManager, Object obj2) {
        return new EntityCardContainerPresenter(entityCardsController, obj, entityCardsDatasourceEventBus, entityCardsPresenterRegistry, recyclableViewPoolManager, obj2, EntityCardsViewFactory.m13071a(this), ViewHelperViewAnimatorFactory.a(this));
    }
}
