package com.facebook.entitycards.controller;

import com.facebook.entitycards.model.EntityCardsCardSupportDeclaration;
import com.facebook.entitycards.view.EntityCardsBaseCardTypes;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import java.util.Set;

/* compiled from: image_xhdpi */
public class EntityCardsControllerProvider extends AbstractAssistedProvider<EntityCardsController> {
    public final EntityCardsController m12890a(RecyclableViewPoolManager recyclableViewPoolManager, Set<EntityCardsCardSupportDeclaration> set) {
        return new EntityCardsController(recyclableViewPoolManager, set, EntityCardsBaseCardTypes.m13061a(this));
    }
}
