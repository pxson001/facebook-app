package com.facebook.composer.inlinesprouts.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fundraiser_campaign_fragment_no_selected_payment_method */
public class InlineSproutsStateSerializer extends JsonSerializer<InlineSproutsState> {
    public final void m8095a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        InlineSproutsState inlineSproutsState = (InlineSproutsState) obj;
        if (inlineSproutsState == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m8094b(inlineSproutsState, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(InlineSproutsState.class, new InlineSproutsStateSerializer());
    }

    private static void m8094b(InlineSproutsState inlineSproutsState, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "is_facecast_nux_showing", Boolean.valueOf(inlineSproutsState.isFacecastNuxShowing()));
        AutoGenJsonHelper.a(jsonGenerator, "is_inline_sprouts_open", Boolean.valueOf(inlineSproutsState.isInlineSproutsOpen()));
        AutoGenJsonHelper.a(jsonGenerator, "is_location_attached", Boolean.valueOf(inlineSproutsState.isLocationAttached()));
        AutoGenJsonHelper.a(jsonGenerator, "is_media_attached", Boolean.valueOf(inlineSproutsState.isMediaAttached()));
        AutoGenJsonHelper.a(jsonGenerator, "is_minutiae_attached", Boolean.valueOf(inlineSproutsState.isMinutiaeAttached()));
        AutoGenJsonHelper.a(jsonGenerator, "is_tag_people_attached", Boolean.valueOf(inlineSproutsState.isTagPeopleAttached()));
        AutoGenJsonHelper.a(jsonGenerator, "is_video_tagging_prompt_showing", Boolean.valueOf(inlineSproutsState.isVideoTaggingPromptShowing()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "sprouts_metadata_flow_state", inlineSproutsState.getSproutsMetadataFlowState());
    }
}
