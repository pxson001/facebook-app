package com.facebook.reviews.protocol.graphql;

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
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsParsers.PageOverallStarRatingParser;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsParsers.PageOverallStarRatingParser.HistogramParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: setIsThrowbackPost */
public class PageReviewsFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1612985132)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: setIsThrowbackPost */
    public final class PageOverallStarRatingModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<HistogramModel> f4637d;
        private int f4638e;
        private int f4639f;
        private double f4640g;

        /* compiled from: setIsThrowbackPost */
        public final class Builder {
            @Nullable
            public ImmutableList<HistogramModel> f4629a;
            public int f4630b;
            public int f4631c;
            public double f4632d;

            public final PageOverallStarRatingModel m7139a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f4629a);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f4630b, 0);
                flatBufferBuilder.a(2, this.f4631c, 0);
                flatBufferBuilder.a(3, this.f4632d, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageOverallStarRatingModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: setIsThrowbackPost */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageOverallStarRatingModel.class, new Deserializer());
            }

            public Object m7140a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageOverallStarRatingParser.m7161a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageOverallStarRatingModel = new PageOverallStarRatingModel();
                ((BaseModel) pageOverallStarRatingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageOverallStarRatingModel instanceof Postprocessable) {
                    return ((Postprocessable) pageOverallStarRatingModel).a();
                }
                return pageOverallStarRatingModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 969844198)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setIsThrowbackPost */
        public final class HistogramModel extends BaseModel implements GraphQLVisitableModel {
            private int f4635d;
            private int f4636e;

            /* compiled from: setIsThrowbackPost */
            public final class Builder {
                public int f4633a;
                public int f4634b;
            }

            /* compiled from: setIsThrowbackPost */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(HistogramModel.class, new Deserializer());
                }

                public Object m7141a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HistogramParser.m7160b(jsonParser, flatBufferBuilder));
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

            /* compiled from: setIsThrowbackPost */
            public class Serializer extends JsonSerializer<HistogramModel> {
                public final void m7142a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    HistogramModel histogramModel = (HistogramModel) obj;
                    if (histogramModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(histogramModel.m7145a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        histogramModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HistogramParser.m7159a(histogramModel.w_(), histogramModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(HistogramModel.class, new Serializer());
                }
            }

            public HistogramModel() {
                super(2);
            }

            public HistogramModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m7144a() {
                a(0, 0);
                return this.f4635d;
            }

            public final int m7148b() {
                a(0, 1);
                return this.f4636e;
            }

            public static HistogramModel m7143a(HistogramModel histogramModel) {
                if (histogramModel == null) {
                    return null;
                }
                if (histogramModel instanceof HistogramModel) {
                    return histogramModel;
                }
                Builder builder = new Builder();
                builder.f4633a = histogramModel.m7144a();
                builder.f4634b = histogramModel.m7148b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, builder.f4633a, 0);
                flatBufferBuilder.a(1, builder.f4634b, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new HistogramModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1009757106;
            }

            public final GraphQLVisitableModel m7146a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7145a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f4635d, 0);
                flatBufferBuilder.a(1, this.f4636e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7147a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f4635d = mutableFlatBuffer.a(i, 0, 0);
                this.f4636e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: setIsThrowbackPost */
        public class Serializer extends JsonSerializer<PageOverallStarRatingModel> {
            public final void m7149a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageOverallStarRatingModel pageOverallStarRatingModel = (PageOverallStarRatingModel) obj;
                if (pageOverallStarRatingModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageOverallStarRatingModel.m7151a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageOverallStarRatingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageOverallStarRatingParser.m7162a(pageOverallStarRatingModel.w_(), pageOverallStarRatingModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageOverallStarRatingModel.class, new Serializer());
            }
        }

        public PageOverallStarRatingModel() {
            super(4);
        }

        public PageOverallStarRatingModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<HistogramModel> m7153a() {
            this.f4637d = super.a(this.f4637d, 0, HistogramModel.class);
            return (ImmutableList) this.f4637d;
        }

        public final int m7155b() {
            a(0, 1);
            return this.f4638e;
        }

        public final int m7156c() {
            a(0, 2);
            return this.f4639f;
        }

        public final double m7157d() {
            a(0, 3);
            return this.f4640g;
        }

        public static PageOverallStarRatingModel m7150a(PageOverallStarRatingModel pageOverallStarRatingModel) {
            if (pageOverallStarRatingModel == null) {
                return null;
            }
            if (pageOverallStarRatingModel instanceof PageOverallStarRatingModel) {
                return pageOverallStarRatingModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < pageOverallStarRatingModel.m7153a().size(); i++) {
                builder2.c(HistogramModel.m7143a((HistogramModel) pageOverallStarRatingModel.m7153a().get(i)));
            }
            builder.f4629a = builder2.b();
            builder.f4630b = pageOverallStarRatingModel.m7155b();
            builder.f4631c = pageOverallStarRatingModel.m7156c();
            builder.f4632d = pageOverallStarRatingModel.m7157d();
            return builder.m7139a();
        }

        public final int jK_() {
            return -1854235203;
        }

        public final GraphQLVisitableModel m7152a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7153a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m7153a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PageOverallStarRatingModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4637d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7151a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7153a());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f4638e, 0);
            flatBufferBuilder.a(2, this.f4639f, 0);
            flatBufferBuilder.a(3, this.f4640g, 0.0d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m7154a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4638e = mutableFlatBuffer.a(i, 1, 0);
            this.f4639f = mutableFlatBuffer.a(i, 2, 0);
            this.f4640g = mutableFlatBuffer.a(i, 3, 0.0d);
        }
    }
}
