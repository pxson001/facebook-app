package com.facebook.places.checkin.launcher;

import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.ExplicitPlaceModel;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration.Builder;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: instagram_layout */
public class PlacePickerLauncher {
    public final Provider<SecureContextHelper> f11026a;

    public static PlacePickerLauncher m13011b(InjectorLike injectorLike) {
        return new PlacePickerLauncher(IdBasedSingletonScopeProvider.a(injectorLike, 968));
    }

    @Inject
    public PlacePickerLauncher(Provider<SecureContextHelper> provider) {
        this.f11026a = provider;
    }

    public static Builder m13010a(SearchType searchType, String str, @Nullable ExplicitPlaceModel explicitPlaceModel) {
        Builder newBuilder = PlacePickerConfiguration.newBuilder();
        newBuilder.p = searchType;
        newBuilder = newBuilder;
        newBuilder.j = str;
        newBuilder = newBuilder;
        if (explicitPlaceModel != null) {
            CheckinPlaceModel.Builder builder = new CheckinPlaceModel.Builder();
            builder.f = explicitPlaceModel.c();
            builder = builder;
            builder.h = explicitPlaceModel.d();
            newBuilder.a = builder.a();
        } else {
            newBuilder.f = true;
        }
        return newBuilder;
    }
}
