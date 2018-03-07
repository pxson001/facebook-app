package com.facebook.events.ui.location;

import android.app.Activity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration.Builder;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import javax.inject.Inject;

/* compiled from: appinvites */
public class LocationPickerLauncher {
    private final SecureContextHelper f19477a;
    public boolean f19478b;
    public EventLocationModel f19479c;

    public static LocationPickerLauncher m19659b(InjectorLike injectorLike) {
        return new LocationPickerLauncher((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public LocationPickerLauncher(SecureContextHelper secureContextHelper) {
        this.f19477a = secureContextHelper;
    }

    public final LocationPickerLauncher m19660a(EventLocationModel eventLocationModel) {
        this.f19479c = eventLocationModel;
        return this;
    }

    public final LocationPickerLauncher m19661a(boolean z) {
        this.f19478b = z;
        return this;
    }

    public final void m19662a(Activity activity, int i) {
        Builder newBuilder = PlacePickerConfiguration.newBuilder();
        newBuilder.p = SearchType.EVENT;
        newBuilder = newBuilder;
        if (this.f19479c != null) {
            if (this.f19479c.f19461a != null) {
                newBuilder.a = CheckinPlaceModel.a(this.f19479c.f19461a);
            } else if (this.f19479c.f19463c != null) {
                newBuilder.k = this.f19479c.f19463c;
            }
        }
        if (this.f19478b) {
            newBuilder.h = true;
        }
        this.f19477a.a(CheckinIntentCreator.a(activity, newBuilder.a()), i, activity);
    }

    public static LocationPickerLauncher m19658a(InjectorLike injectorLike) {
        return m19659b(injectorLike);
    }
}
