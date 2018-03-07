package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.StarRatingFragmentParser;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.StarRatingFragmentParser.HistogramParser;
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

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -501497470)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: sendInstantly */
public final class AppFragmentsGraphQLModels$StarRatingFragmentModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private List<HistogramModel> f4070d;
    private int f4071e;
    private int f4072f;
    private double f4073g;

    /* compiled from: sendInstantly */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(AppFragmentsGraphQLModels$StarRatingFragmentModel.class, new Deserializer());
        }

        public Object m3985a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(StarRatingFragmentParser.m4042a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object appFragmentsGraphQLModels$StarRatingFragmentModel = new AppFragmentsGraphQLModels$StarRatingFragmentModel();
            ((BaseModel) appFragmentsGraphQLModels$StarRatingFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (appFragmentsGraphQLModels$StarRatingFragmentModel instanceof Postprocessable) {
                return ((Postprocessable) appFragmentsGraphQLModels$StarRatingFragmentModel).a();
            }
            return appFragmentsGraphQLModels$StarRatingFragmentModel;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 969844198)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sendInstantly */
    public final class HistogramModel extends BaseModel implements GraphQLVisitableModel {
        private int f4068d;
        private int f4069e;

        /* compiled from: sendInstantly */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(HistogramModel.class, new Deserializer());
            }

            public Object m3986a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(HistogramParser.m4041b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object histogramModel = new HistogramModel();
                ((BaseModel) histogramModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (histogramModel instanceof Postprocessable) {
                    return ((Postprocessable) histogramModel).a();
                }
                return histogramModel;
            }
        }

        /* compiled from: sendInstantly */
        public class Serializer extends JsonSerializer<HistogramModel> {
            public final void m3987a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                HistogramModel histogramModel = (HistogramModel) obj;
                if (histogramModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(histogramModel.m3988a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    histogramModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                HistogramParser.m4040a(histogramModel.w_(), histogramModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(HistogramModel.class, new Serializer());
            }
        }

        public HistogramModel() {
            super(2);
        }

        public final int jK_() {
            return -1009757106;
        }

        public final GraphQLVisitableModel m3989a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3988a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f4068d, 0);
            flatBufferBuilder.a(1, this.f4069e, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3990a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4068d = mutableFlatBuffer.a(i, 0, 0);
            this.f4069e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    /* compiled from: sendInstantly */
    public class Serializer extends JsonSerializer<AppFragmentsGraphQLModels$StarRatingFragmentModel> {
        public final void m3991a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            AppFragmentsGraphQLModels$StarRatingFragmentModel appFragmentsGraphQLModels$StarRatingFragmentModel = (AppFragmentsGraphQLModels$StarRatingFragmentModel) obj;
            if (appFragmentsGraphQLModels$StarRatingFragmentModel.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(appFragmentsGraphQLModels$StarRatingFragmentModel.m3993a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                appFragmentsGraphQLModels$StarRatingFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            StarRatingFragmentParser.m4043a(appFragmentsGraphQLModels$StarRatingFragmentModel.w_(), appFragmentsGraphQLModels$StarRatingFragmentModel.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(AppFragmentsGraphQLModels$StarRatingFragmentModel.class, new Serializer());
        }
    }

    public AppFragmentsGraphQLModels$StarRatingFragmentModel() {
        super(4);
    }

    @Nonnull
    private ImmutableList<HistogramModel> m3992a() {
        this.f4070d = super.a(this.f4070d, 0, HistogramModel.class);
        return (ImmutableList) this.f4070d;
    }

    public final int jK_() {
        return -1854235203;
    }

    public final GraphQLVisitableModel m3994a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3992a() != null) {
            Builder a = ModelHelper.a(m3992a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (AppFragmentsGraphQLModels$StarRatingFragmentModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f4070d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m3993a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m3992a());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, this.f4071e, 0);
        flatBufferBuilder.a(2, this.f4072f, 0);
        flatBufferBuilder.a(3, this.f4073g, 0.0d);
        i();
        return flatBufferBuilder.d();
    }

    public final void m3995a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4071e = mutableFlatBuffer.a(i, 1, 0);
        this.f4072f = mutableFlatBuffer.a(i, 2, 0);
        this.f4073g = mutableFlatBuffer.a(i, 3, 0.0d);
    }
}
