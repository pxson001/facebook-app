package com.facebook.entitycards.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import com.facebook.entitycards.EntityCardsAdapter;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.analytics.EntityCardsScrollTTITracker;
import com.facebook.entitycards.controller.EntityCardsController;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.AbstractEntityCardsDataSource.C11881;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: ia_webview_share_url */
public interface EntityCardsDataSource {

    /* compiled from: ia_webview_share_url */
    public enum State {
        UNINITIALIZED,
        PRELIMINARY_INITIALIZED,
        INITIAL_ENTITIES_LOADED
    }

    EntityCardsAdapter mo777a(EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, EntityCardsController entityCardsController, EntityCardsDataSource entityCardsDataSource, C11761 c11761, EntityCardsScrollTTITracker entityCardsScrollTTITracker, LayoutInflater layoutInflater, RecyclableViewPoolManager recyclableViewPoolManager, Integer num, Bundle bundle);

    EntityCardsDatasourceEventBus mo775a();

    String mo778a(Object obj);

    void mo779a(EntityCardsScrollDirection entityCardsScrollDirection);

    C11881 mo776d();

    ListenableFuture<Void> mo782e();

    void mo783f();

    ImmutableList<String> mo784g();

    Optional<Bundle> mo785h();

    int mo786i();

    boolean mo787j();

    int mo788k();
}
