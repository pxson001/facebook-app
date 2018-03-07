package com.facebook.composer.inlinesprouts.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.composer.inlinesprouts.model.InlineSproutsState.Builder;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fundraiser_campaign_fragment_model_null */
public class InlineSproutsState_BuilderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f6656a;

    static {
        GlobalAutoGenDeserializerCache.a(Builder.class, new InlineSproutsState_BuilderDeserializer());
        m8096e();
    }

    public InlineSproutsState_BuilderDeserializer() {
        a(Builder.class);
    }

    private static synchronized Map<String, FbJsonField> m8096e() {
        Map<String, FbJsonField> map;
        synchronized (InlineSproutsState_BuilderDeserializer.class) {
            if (f6656a == null) {
                try {
                    ImmutableMap.Builder builder = new ImmutableMap.Builder();
                    builder.b("is_facecast_nux_showing", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsFacecastNuxShowing", new Class[]{Boolean.TYPE})));
                    builder.b("is_inline_sprouts_open", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsInlineSproutsOpen", new Class[]{Boolean.TYPE})));
                    builder.b("is_location_attached", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsLocationAttached", new Class[]{Boolean.TYPE})));
                    builder.b("is_media_attached", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsMediaAttached", new Class[]{Boolean.TYPE})));
                    builder.b("is_minutiae_attached", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsMinutiaeAttached", new Class[]{Boolean.TYPE})));
                    builder.b("is_tag_people_attached", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsTagPeopleAttached", new Class[]{Boolean.TYPE})));
                    builder.b("is_video_tagging_prompt_showing", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsVideoTaggingPromptShowing", new Class[]{Boolean.TYPE})));
                    builder.b("sprouts_metadata_flow_state", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setSproutsMetadataFlowState", new Class[]{InlineSproutsStateSpec$SproutsMetadataFlow.class})));
                    f6656a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f6656a;
        }
        return map;
    }

    public final FbJsonField m8097a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8096e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8096e().keySet());
    }
}
