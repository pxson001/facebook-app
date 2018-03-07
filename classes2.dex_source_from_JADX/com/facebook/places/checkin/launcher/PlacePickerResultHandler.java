package com.facebook.places.checkin.launcher;

import android.content.Intent;
import com.facebook.checkin.socialsearch.utils.AddPlaceListItemToCommentMutationHelper;
import com.facebook.checkin.socialsearch.utils.AddPlaceListItemToCommentMutationHelper.1;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.controllercallbacks.fragment.ActivityResultUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.mediagallery.mutation.MediaMutationGenerator;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: photo_clicked_cold */
public class PlacePickerResultHandler extends BaseController implements ActivityResultCallback {
    private static final String f10081a = PlacePickerResultHandler.class.getSimpleName();
    private final Lazy<MediaMutationGenerator> f10082b;
    public final Lazy<AddPlaceListItemToCommentMutationHelper> f10083c;
    private final AbstractFbErrorReporter f10084d;

    public static PlacePickerResultHandler m15170b(InjectorLike injectorLike) {
        return new PlacePickerResultHandler(IdBasedLazy.m1808a(injectorLike, 9349), IdBasedLazy.m1808a(injectorLike, 5044), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public PlacePickerResultHandler(Lazy<MediaMutationGenerator> lazy, Lazy<AddPlaceListItemToCommentMutationHelper> lazy2, FbErrorReporter fbErrorReporter) {
        this.f10082b = lazy;
        this.f10083c = lazy2;
        this.f10084d = fbErrorReporter;
    }

    public final void m15172a(Intent intent) {
        String stringExtra = intent.getStringExtra("launcher_type");
        boolean z = true;
        switch (stringExtra.hashCode()) {
            case -194012942:
                if (stringExtra.equals("add_location_comment_place_info")) {
                    z = true;
                    break;
                }
                break;
            case 1618932029:
                if (stringExtra.equals("suggest_photo_location")) {
                    z = true;
                    break;
                }
                break;
            case 2010994167:
                if (stringExtra.equals("edit_photo_location")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                m15169a(intent, true);
                return;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m15169a(intent, false);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                String stringExtra2 = intent.getStringExtra("comment_id");
                CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
                if (!(stringExtra2 == null || checkinPlaceModel == null)) {
                    GraphQLStory graphQLStory = (GraphQLStory) intent.getParcelableExtra("story_for_social_search");
                    AddPlaceListItemToCommentMutationHelper addPlaceListItemToCommentMutationHelper = (AddPlaceListItemToCommentMutationHelper) this.f10083c.get();
                    String cf_ = checkinPlaceModel.cf_();
                    FutureCallback futureCallback = null;
                    if (graphQLStory != null) {
                        futureCallback = new 1(addPlaceListItemToCommentMutationHelper, cf_, graphQLStory, stringExtra2);
                    }
                    addPlaceListItemToCommentMutationHelper.a(stringExtra2, cf_, futureCallback);
                }
                return;
            default:
                this.f10084d.m2340a(f10081a, "No matching LauncherType found");
                return;
        }
    }

    public static PlacePickerResultHandler m15168a(InjectorLike injectorLike) {
        return m15170b(injectorLike);
    }

    private void m15169a(Intent intent, boolean z) {
        String str = null;
        String stringExtra = intent.getStringExtra("media_id");
        if (stringExtra != null) {
            CheckinPlaceModel checkinPlaceModel;
            if (intent.getBooleanExtra("extra_xed_location", false)) {
                checkinPlaceModel = null;
            } else if (intent.hasExtra("text_only_place")) {
                checkinPlaceModel = null;
                str = intent.getStringExtra("text_only_place");
            } else {
                checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
            }
            if (z) {
                ((MediaMutationGenerator) this.f10082b.get()).a(stringExtra, checkinPlaceModel, str);
            } else {
                ((MediaMutationGenerator) this.f10082b.get()).b(stringExtra, checkinPlaceModel, str);
            }
        }
    }

    public final void mo1941a(int i, int i2, Intent intent) {
        if (ActivityResultUtil.a(5002, i, i2, intent)) {
            m15172a(intent);
        }
    }
}
