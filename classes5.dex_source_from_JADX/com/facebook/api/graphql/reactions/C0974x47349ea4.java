package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: android_place_picker_long_press_report_duplicates */
public class C0974x47349ea4 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ViewerReactionsMutationFragmentModel.class, new C0974x47349ea4());
    }

    public Object m17104a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = ViewerReactionsMutationFragmentParser.m17178a(jsonParser);
        Object viewerReactionsMutationFragmentModel = new ViewerReactionsMutationFragmentModel();
        ((BaseModel) viewerReactionsMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (viewerReactionsMutationFragmentModel instanceof Postprocessable) {
            return ((Postprocessable) viewerReactionsMutationFragmentModel).a();
        }
        return viewerReactionsMutationFragmentModel;
    }
}
