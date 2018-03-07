package com.facebook.composer.lifeevent.interstitial;

import com.facebook.composer.lifeevent.model.ComposerLifeEventModel.Builder;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.TypeAheadSuggestionFieldsModel;

/* compiled from: copyright_monitor_suspend */
public class ComposerLifeEventMarriageInterstitialFragment extends ComposerLifeEventRelationshipInterstitialFragment {
    protected final String mo1289e() {
        return b(2131234174);
    }

    protected final Builder mo1290a(Builder builder, TypeAheadSuggestionFieldsModel typeAheadSuggestionFieldsModel) {
        builder.a = a(2131234186, new Object[]{typeAheadSuggestionFieldsModel.k()});
        Builder builder2 = builder;
        builder2.f = typeAheadSuggestionFieldsModel.j();
        builder2 = builder2;
        builder2.g = typeAheadSuggestionFieldsModel.k();
        return builder2;
    }
}
