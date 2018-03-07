package com.facebook.pages.app.data.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.app.data.graphql.SetPageAwayToggleGraphQLParsers.SetPageAwayToggleMutationParser;
import com.facebook.pages.app.data.graphql.SetPageAwayToggleGraphQLParsers.SetPageAwayToggleMutationParser.PageParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: tapped_like_page_in_category */
public class SetPageAwayToggleGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1620326396)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tapped_like_page_in_category */
    public final class SetPageAwayToggleMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageModel f1130d;

        /* compiled from: tapped_like_page_in_category */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SetPageAwayToggleMutationModel.class, new Deserializer());
            }

            public Object m1511a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SetPageAwayToggleMutationParser.m1527a(jsonParser);
                Object setPageAwayToggleMutationModel = new SetPageAwayToggleMutationModel();
                ((BaseModel) setPageAwayToggleMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (setPageAwayToggleMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) setPageAwayToggleMutationModel).a();
                }
                return setPageAwayToggleMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 940608632)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tapped_like_page_in_category */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f1128d;
            private boolean f1129e;

            /* compiled from: tapped_like_page_in_category */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m1512a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m1525a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageModel = new PageModel();
                    ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageModel instanceof Postprocessable) {
                        return ((Postprocessable) pageModel).a();
                    }
                    return pageModel;
                }
            }

            /* compiled from: tapped_like_page_in_category */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m1513a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m1515a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m1526a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(2);
            }

            public final void m1519a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1520a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m1514j() {
                this.f1128d = super.a(this.f1128d, 0);
                return this.f1128d;
            }

            @Nullable
            public final String m1517a() {
                return m1514j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m1516a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1515a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1514j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f1129e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1518a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1129e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: tapped_like_page_in_category */
        public class Serializer extends JsonSerializer<SetPageAwayToggleMutationModel> {
            public final void m1521a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SetPageAwayToggleMutationModel setPageAwayToggleMutationModel = (SetPageAwayToggleMutationModel) obj;
                if (setPageAwayToggleMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(setPageAwayToggleMutationModel.m1523a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    setPageAwayToggleMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = setPageAwayToggleMutationModel.w_();
                int u_ = setPageAwayToggleMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageParser.m1526a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SetPageAwayToggleMutationModel.class, new Serializer());
            }
        }

        public SetPageAwayToggleMutationModel() {
            super(1);
        }

        @Nullable
        private PageModel m1522a() {
            this.f1130d = (PageModel) super.a(this.f1130d, 0, PageModel.class);
            return this.f1130d;
        }

        public final int jK_() {
            return 906852570;
        }

        public final GraphQLVisitableModel m1524a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1522a() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m1522a());
                if (m1522a() != pageModel) {
                    graphQLVisitableModel = (SetPageAwayToggleMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1130d = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1523a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1522a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
