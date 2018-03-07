package com.facebook.composer.lifeevent.type;

import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventCategoriesFieldsModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventFieldsModel;
import com.google.common.collect.ImmutableList;

/* compiled from: controlCategories= */
public class ComposerLifeEventTypeSuggestionCategoryModel {
    public final String f16797a;
    public ImmutableList<LifeEventFieldsModel> f16798b;
    private boolean f16799c = false;

    public ComposerLifeEventTypeSuggestionCategoryModel(LifeEventCategoriesFieldsModel lifeEventCategoriesFieldsModel) {
        this.f16797a = lifeEventCategoriesFieldsModel.j();
        this.f16798b = lifeEventCategoriesFieldsModel.a().a();
    }
}
