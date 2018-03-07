package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TKEY;>;) */
public class ComposerLocationInfoSerializer extends JsonSerializer<ComposerLocationInfo> {
    public final void m23346a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerLocationInfo composerLocationInfo = (ComposerLocationInfo) obj;
        if (composerLocationInfo == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23345b(composerLocationInfo, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerLocationInfo.class, new ComposerLocationInfoSerializer());
    }

    private static void m23345b(ComposerLocationInfo composerLocationInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "tagged_place", composerLocationInfo.mTaggedPlace);
        AutoGenJsonHelper.a(jsonGenerator, "place_attachment_removed", Boolean.valueOf(composerLocationInfo.mPlaceAttachmentRemoved));
        AutoGenJsonHelper.a(jsonGenerator, "text_only_place", composerLocationInfo.mTextOnlyPlace);
        AutoGenJsonHelper.a(jsonGenerator, "is_checkin", Boolean.valueOf(composerLocationInfo.mIsCheckin));
        AutoGenJsonHelper.a(jsonGenerator, "xed_location", Boolean.valueOf(composerLocationInfo.mXedLocation));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "implicit_loc", composerLocationInfo.mImplicitLoc);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "lightweight_place_picker_places", composerLocationInfo.mLightweightPlacePickerPlaces);
        AutoGenJsonHelper.a(jsonGenerator, "lightweight_place_picker_session_id", composerLocationInfo.mLightweightPlacePickerSessionId);
        AutoGenJsonHelper.a(jsonGenerator, "lightweight_place_picker_search_results_id", composerLocationInfo.mLightweightPlacePickerSearchResultsId);
        AutoGenJsonHelper.a(jsonGenerator, "implicit_location_disabled_by_user", Boolean.valueOf(composerLocationInfo.mImplicitLocationDisabledByUser));
    }
}
