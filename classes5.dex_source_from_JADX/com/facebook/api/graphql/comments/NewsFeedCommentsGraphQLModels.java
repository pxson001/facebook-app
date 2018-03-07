package com.facebook.api.graphql.comments;

import com.facebook.api.graphql.comments.NewsFeedCommentsGraphQLParsers.TopLevelCommentsConnectionFragmentParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: app_power */
public class NewsFeedCommentsGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1535562863)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: app_power */
    public final class TopLevelCommentsConnectionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private int f9219d;
        @Nullable
        private List<GraphQLComment> f9220e;
        @Nullable
        private DefaultPageInfoFieldsModel f9221f;
        private int f9222g;

        /* compiled from: app_power */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TopLevelCommentsConnectionFragmentModel.class, new Deserializer());
            }

            public Object m15669a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TopLevelCommentsConnectionFragmentParser.m15680a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object topLevelCommentsConnectionFragmentModel = new TopLevelCommentsConnectionFragmentModel();
                ((BaseModel) topLevelCommentsConnectionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (topLevelCommentsConnectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) topLevelCommentsConnectionFragmentModel).a();
                }
                return topLevelCommentsConnectionFragmentModel;
            }
        }

        /* compiled from: app_power */
        public class Serializer extends JsonSerializer<TopLevelCommentsConnectionFragmentModel> {
            public final void m15670a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TopLevelCommentsConnectionFragmentModel topLevelCommentsConnectionFragmentModel = (TopLevelCommentsConnectionFragmentModel) obj;
                if (topLevelCommentsConnectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(topLevelCommentsConnectionFragmentModel.m15674a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    topLevelCommentsConnectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TopLevelCommentsConnectionFragmentParser.m15681a(topLevelCommentsConnectionFragmentModel.w_(), topLevelCommentsConnectionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TopLevelCommentsConnectionFragmentModel.class, new Serializer());
            }
        }

        public TopLevelCommentsConnectionFragmentModel() {
            super(4);
        }

        public final int m15673a() {
            a(0, 0);
            return this.f9219d;
        }

        public final void m15676a(int i) {
            this.f9219d = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 0, i);
            }
        }

        @Nonnull
        private ImmutableList<GraphQLComment> m15671k() {
            this.f9220e = super.a(this.f9220e, 1, GraphQLComment.class);
            return (ImmutableList) this.f9220e;
        }

        @Nullable
        private DefaultPageInfoFieldsModel m15672l() {
            this.f9221f = (DefaultPageInfoFieldsModel) super.a(this.f9221f, 2, DefaultPageInfoFieldsModel.class);
            return this.f9221f;
        }

        public final int m15679j() {
            a(0, 3);
            return this.f9222g;
        }

        public final void m15678b(int i) {
            this.f9222g = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 3, i);
            }
        }

        public final int jK_() {
            return 899897761;
        }

        public final GraphQLVisitableModel m15675a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m15671k() != null) {
                Builder a = ModelHelper.a(m15671k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    TopLevelCommentsConnectionFragmentModel topLevelCommentsConnectionFragmentModel = (TopLevelCommentsConnectionFragmentModel) ModelHelper.a(null, this);
                    topLevelCommentsConnectionFragmentModel.f9220e = a.b();
                    graphQLVisitableModel = topLevelCommentsConnectionFragmentModel;
                    if (m15672l() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15672l());
                        if (m15672l() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (TopLevelCommentsConnectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9221f = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m15672l() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15672l());
                if (m15672l() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (TopLevelCommentsConnectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9221f = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m15674a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15671k());
            int a2 = ModelHelper.a(flatBufferBuilder, m15672l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f9219d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, this.f9222g, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15677a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9219d = mutableFlatBuffer.a(i, 0, 0);
            this.f9222g = mutableFlatBuffer.a(i, 3, 0);
        }
    }
}
