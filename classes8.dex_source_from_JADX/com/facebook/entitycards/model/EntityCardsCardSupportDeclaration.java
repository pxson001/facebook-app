package com.facebook.entitycards.model;

import com.facebook.entitycards.controller.EntityCardsController.EntityCardController;
import com.facebook.entitycards.view.EntityCardsCardType;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/* compiled from: ia_tracker_node_id */
public interface EntityCardsCardSupportDeclaration {
    ImmutableSet<EntityCardsCardType> mo794a();

    ImmutableMap<Class<?>, EntityCardController<?>> mo795b();

    boolean mo796c();
}
