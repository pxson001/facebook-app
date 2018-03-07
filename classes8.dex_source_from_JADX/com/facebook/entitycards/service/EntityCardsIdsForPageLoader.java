package com.facebook.entitycards.service;

import android.os.Bundle;
import com.facebook.entitycards.collect.ImmutableOffsetArray;
import com.facebook.entitycards.model.EntityCardsScrollDirection;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: idleReason */
public interface EntityCardsIdsForPageLoader {
    Optional<Bundle> mo772a();

    ListenableFuture<ImmutableOffsetArray<String>> mo773a(EntityCardsScrollDirection entityCardsScrollDirection, int i);

    boolean mo774a(EntityCardsScrollDirection entityCardsScrollDirection);
}
