package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TKey; */
public class ComposerLocationInfoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13969a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerLocationInfo.class, new ComposerLocationInfoDeserializer());
        m23343e();
    }

    public ComposerLocationInfoDeserializer() {
        a(ComposerLocationInfo.class);
    }

    private static synchronized Map<String, FbJsonField> m23343e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerLocationInfoDeserializer.class) {
            if (f13969a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("tagged_place", FbJsonField.jsonField(ComposerLocationInfo.class.getDeclaredField("mTaggedPlace")));
                    builder.b("place_attachment_removed", FbJsonField.jsonField(ComposerLocationInfo.class.getDeclaredField("mPlaceAttachmentRemoved")));
                    builder.b("text_only_place", FbJsonField.jsonField(ComposerLocationInfo.class.getDeclaredField("mTextOnlyPlace")));
                    builder.b("is_checkin", FbJsonField.jsonField(ComposerLocationInfo.class.getDeclaredField("mIsCheckin")));
                    builder.b("xed_location", FbJsonField.jsonField(ComposerLocationInfo.class.getDeclaredField("mXedLocation")));
                    builder.b("implicit_loc", FbJsonField.jsonField(ComposerLocationInfo.class.getDeclaredField("mImplicitLoc")));
                    builder.b("lightweight_place_picker_places", FbJsonField.jsonField(ComposerLocationInfo.class.getDeclaredField("mLightweightPlacePickerPlaces"), CheckinPlaceModel.class));
                    builder.b("lightweight_place_picker_session_id", FbJsonField.jsonField(ComposerLocationInfo.class.getDeclaredField("mLightweightPlacePickerSessionId")));
                    builder.b("lightweight_place_picker_search_results_id", FbJsonField.jsonField(ComposerLocationInfo.class.getDeclaredField("mLightweightPlacePickerSearchResultsId")));
                    builder.b("implicit_location_disabled_by_user", FbJsonField.jsonField(ComposerLocationInfo.class.getDeclaredField("mImplicitLocationDisabledByUser")));
                    f13969a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13969a;
        }
        return map;
    }

    public final FbJsonField m23344a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23343e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23343e().keySet());
    }
}
