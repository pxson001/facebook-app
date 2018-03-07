package com.facebook.photos.mediagallery.util;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.LocationSuggestionModel.LocationTagSuggestionModel;
import javax.inject.Inject;

/* compiled from: is_join_request_sent */
public class SuggestedLocationUtils {
    private final AnalyticsLogger f10799a;

    public static SuggestedLocationUtils m12823a(InjectorLike injectorLike) {
        return new SuggestedLocationUtils(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SuggestedLocationUtils(AnalyticsLogger analyticsLogger) {
        this.f10799a = analyticsLogger;
    }

    public final void m12825a(LocationTagSuggestionModel locationTagSuggestionModel, MediaMetadata mediaMetadata) {
        m12824a("photo_location_suggestion_effective", locationTagSuggestionModel, mediaMetadata);
    }

    public final void m12826b(LocationTagSuggestionModel locationTagSuggestionModel, MediaMetadata mediaMetadata) {
        m12824a("photo_location_suggestion_appears", locationTagSuggestionModel, mediaMetadata);
    }

    public final void m12827c(LocationTagSuggestionModel locationTagSuggestionModel, MediaMetadata mediaMetadata) {
        m12824a("photo_location_suggestion_accept", locationTagSuggestionModel, mediaMetadata);
    }

    public final void m12828d(LocationTagSuggestionModel locationTagSuggestionModel, MediaMetadata mediaMetadata) {
        m12824a("photo_location_suggestion_reject", locationTagSuggestionModel, mediaMetadata);
    }

    private void m12824a(String str, LocationTagSuggestionModel locationTagSuggestionModel, MediaMetadata mediaMetadata) {
        this.f10799a.a(new HoneyClientEvent(str).b("session_id", locationTagSuggestionModel.b()).b("place_id", locationTagSuggestionModel.a().c()).b("photo_id", mediaMetadata.d()).b("photo_owner_id", mediaMetadata.N().c()));
    }
}
