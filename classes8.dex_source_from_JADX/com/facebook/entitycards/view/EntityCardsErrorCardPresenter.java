package com.facebook.entitycards.view;

import com.facebook.entitycards.model.AbstractEntityCardsDataSource.C11881;
import com.facebook.entitycards.model.ScrollLoadError;
import com.facebook.presenter.ViewPresenter;
import com.google.common.base.Optional;

/* compiled from: home_%s_photo_picker_cancelled */
public class EntityCardsErrorCardPresenter extends ViewPresenter<EntityCardsErrorCardView> {
    public final ScrollLoadError f11124a;
    public final C11881 f11125b;

    public final void mo790b(Object obj) {
        EntityCardsErrorCardView entityCardsErrorCardView = (EntityCardsErrorCardView) obj;
        entityCardsErrorCardView.f11129c = null;
        super.mo790b(entityCardsErrorCardView);
    }

    public EntityCardsErrorCardPresenter(ScrollLoadError scrollLoadError, C11881 c11881) {
        this.f11124a = scrollLoadError;
        this.f11125b = c11881;
    }

    protected final void mo789b() {
        Optional a = m13028a();
        if (a.isPresent()) {
            ((EntityCardsErrorCardView) a.get()).f11129c = this;
        }
    }
}
