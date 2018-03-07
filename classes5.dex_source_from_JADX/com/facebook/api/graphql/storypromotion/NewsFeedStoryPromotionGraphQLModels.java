package com.facebook.api.graphql.storypromotion;

import com.facebook.api.graphql.storypromotion.NewsFeedStoryPromotionGraphQLInterfaces.SponsoredDataFields;
import com.facebook.api.graphql.storypromotion.NewsFeedStoryPromotionGraphQLParsers.SponsoredDataFieldsParser;
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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: target_id */
public class NewsFeedStoryPromotionGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2077077588)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: target_id */
    public final class SponsoredDataFieldsModel extends BaseModel implements SponsoredDataFields, GraphQLVisitableModel {
        @Nullable
        private String f2154d;
        private boolean f2155e;
        private boolean f2156f;
        private boolean f2157g;
        private boolean f2158h;
        private int f2159i;
        private boolean f2160j;
        private boolean f2161k;
        private boolean f2162l;
        @Nullable
        private String f2163m;
        private boolean f2164n;
        private boolean f2165o;
        private int f2166p;
        private int f2167q;

        /* compiled from: target_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SponsoredDataFieldsModel.class, new Deserializer());
            }

            public Object m2958a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SponsoredDataFieldsParser.m2971a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object sponsoredDataFieldsModel = new SponsoredDataFieldsModel();
                ((BaseModel) sponsoredDataFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (sponsoredDataFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) sponsoredDataFieldsModel).a();
                }
                return sponsoredDataFieldsModel;
            }
        }

        /* compiled from: target_id */
        public class Serializer extends JsonSerializer<SponsoredDataFieldsModel> {
            public final void m2959a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SponsoredDataFieldsModel sponsoredDataFieldsModel = (SponsoredDataFieldsModel) obj;
                if (sponsoredDataFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(sponsoredDataFieldsModel.m2961a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    sponsoredDataFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SponsoredDataFieldsParser.m2972a(sponsoredDataFieldsModel.w_(), sponsoredDataFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(SponsoredDataFieldsModel.class, new Serializer());
            }
        }

        public SponsoredDataFieldsModel() {
            super(14);
        }

        @Nullable
        public final String m2963a() {
            this.f2154d = super.a(this.f2154d, 0);
            return this.f2154d;
        }

        public final boolean m2965b() {
            a(0, 1);
            return this.f2155e;
        }

        public final boolean m2966c() {
            a(0, 2);
            return this.f2156f;
        }

        public final int m2967d() {
            a(0, 5);
            return this.f2159i;
        }

        public final boolean K_() {
            a(0, 6);
            return this.f2160j;
        }

        public final boolean m2968g() {
            a(0, 7);
            return this.f2161k;
        }

        @Nullable
        private String m2960l() {
            this.f2163m = super.a(this.f2163m, 9);
            return this.f2163m;
        }

        public final boolean L_() {
            a(1, 2);
            return this.f2164n;
        }

        public final boolean M_() {
            a(1, 3);
            return this.f2165o;
        }

        public final int m2969j() {
            a(1, 4);
            return this.f2166p;
        }

        public final int m2970k() {
            a(1, 5);
            return this.f2167q;
        }

        public final int jK_() {
            return 516771939;
        }

        public final GraphQLVisitableModel m2962a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2961a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2963a());
            int b2 = flatBufferBuilder.b(m2960l());
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f2155e);
            flatBufferBuilder.a(2, this.f2156f);
            flatBufferBuilder.a(3, this.f2157g);
            flatBufferBuilder.a(4, this.f2158h);
            flatBufferBuilder.a(5, this.f2159i, 0);
            flatBufferBuilder.a(6, this.f2160j);
            flatBufferBuilder.a(7, this.f2161k);
            flatBufferBuilder.a(8, this.f2162l);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.a(10, this.f2164n);
            flatBufferBuilder.a(11, this.f2165o);
            flatBufferBuilder.a(12, this.f2166p, 0);
            flatBufferBuilder.a(13, this.f2167q, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2964a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2155e = mutableFlatBuffer.a(i, 1);
            this.f2156f = mutableFlatBuffer.a(i, 2);
            this.f2157g = mutableFlatBuffer.a(i, 3);
            this.f2158h = mutableFlatBuffer.a(i, 4);
            this.f2159i = mutableFlatBuffer.a(i, 5, 0);
            this.f2160j = mutableFlatBuffer.a(i, 6);
            this.f2161k = mutableFlatBuffer.a(i, 7);
            this.f2162l = mutableFlatBuffer.a(i, 8);
            this.f2164n = mutableFlatBuffer.a(i, 10);
            this.f2165o = mutableFlatBuffer.a(i, 11);
            this.f2166p = mutableFlatBuffer.a(i, 12, 0);
            this.f2167q = mutableFlatBuffer.a(i, 13, 0);
        }
    }
}
