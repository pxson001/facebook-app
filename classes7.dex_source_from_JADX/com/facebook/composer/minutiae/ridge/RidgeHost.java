package com.facebook.composer.minutiae.ridge;

import com.facebook.composer.minutiae.MinutiaeFragment;
import com.facebook.composer.minutiae.MinutiaeSuggestionAdapter;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration;
import com.facebook.composer.minutiae.view.RidgeRefreshableListViewContainer;
import com.google.common.base.Optional;

/* compiled from: total_likes_label */
public interface RidgeHost extends MinutiaeFragment {
    boolean aq();

    MinutiaeConfiguration ar();

    MinutiaeSuggestionAdapter as();

    Optional<RidgeRefreshableListViewContainer> at();

    boolean au();

    Optional<MinutiaeTaggableActivity> av();

    RidgeHostActivity mo80e();
}
