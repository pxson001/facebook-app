package com.facebook.reaction.composer;

import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;

/* compiled from: query_data */
public interface ReactionComposerManager {
    void mo231a(@Nullable MinutiaeObject minutiaeObject);

    void mo232a(ComposerShareParams composerShareParams);

    void mo233a(@Nullable CheckinPlaceModel checkinPlaceModel);

    void mo234a(ImmutableList<Long> immutableList);

    void mo235a(ImmutableSet<Long> immutableSet);

    void mo236a(CharSequence charSequence);

    void mo237a(Long l);

    void mo238b();

    void mo239c();
}
