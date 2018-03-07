package com.facebook.api.graphql.commentservice;

import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateShimMutationFragmentModel;
import com.facebook.api.graphql.commentservice.CommentsServiceParsers.CommentCreateShimMutationFragmentParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: app_id */
public class C0961x910e0042 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(CommentCreateShimMutationFragmentModel.class, new C0961x910e0042());
    }

    public Object m15711a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = CommentCreateShimMutationFragmentParser.m15739a(jsonParser);
        Object commentCreateShimMutationFragmentModel = new CommentCreateShimMutationFragmentModel();
        ((BaseModel) commentCreateShimMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (commentCreateShimMutationFragmentModel instanceof Postprocessable) {
            return ((Postprocessable) commentCreateShimMutationFragmentModel).a();
        }
        return commentCreateShimMutationFragmentModel;
    }
}
