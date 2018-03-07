package com.facebook.location.write.graphql;

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
import com.facebook.location.write.graphql.LocationMutationsParsers.LocationUpdateMutationParser;
import com.facebook.location.write.graphql.LocationMutationsParsers.LocationUpdateMutationParser.ViewerParser;
import com.facebook.location.write.graphql.LocationMutationsParsers.ViewerLocationCoordinateParser;
import com.facebook.location.write.graphql.LocationMutationsParsers.ViewerLocationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: Unexpected type  */
public class LocationMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1570336537)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Unexpected type  */
    public final class LocationUpdateMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f10450d;

        /* compiled from: Unexpected type  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LocationUpdateMutationModel.class, new Deserializer());
            }

            public Object m10845a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LocationUpdateMutationParser.m10868a(jsonParser);
                Object locationUpdateMutationModel = new LocationUpdateMutationModel();
                ((BaseModel) locationUpdateMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (locationUpdateMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) locationUpdateMutationModel).a();
                }
                return locationUpdateMutationModel;
            }
        }

        /* compiled from: Unexpected type  */
        public class Serializer extends JsonSerializer<LocationUpdateMutationModel> {
            public final void m10846a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LocationUpdateMutationModel locationUpdateMutationModel = (LocationUpdateMutationModel) obj;
                if (locationUpdateMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(locationUpdateMutationModel.m10853a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    locationUpdateMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = locationUpdateMutationModel.w_();
                int u_ = locationUpdateMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    ViewerParser.m10867a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LocationUpdateMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 583205169)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Unexpected type  */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ViewerLocationModel f10449d;

            /* compiled from: Unexpected type  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m10847a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m10866a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            /* compiled from: Unexpected type  */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m10848a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m10850a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerParser.m10867a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            private ViewerLocationModel m10849a() {
                this.f10449d = (ViewerLocationModel) super.a(this.f10449d, 0, ViewerLocationModel.class);
                return this.f10449d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m10851a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10849a() != null) {
                    ViewerLocationModel viewerLocationModel = (ViewerLocationModel) graphQLModelMutatingVisitor.b(m10849a());
                    if (m10849a() != viewerLocationModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10449d = viewerLocationModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10850a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10849a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public LocationUpdateMutationModel() {
            super(1);
        }

        @Nullable
        private ViewerModel m10852a() {
            this.f10450d = (ViewerModel) super.a(this.f10450d, 0, ViewerModel.class);
            return this.f10450d;
        }

        public final int jK_() {
            return 1668903215;
        }

        public final GraphQLVisitableModel m10854a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10852a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m10852a());
                if (m10852a() != viewerModel) {
                    graphQLVisitableModel = (LocationUpdateMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10450d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10853a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10852a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 41380103)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Unexpected type  */
    public final class ViewerLocationCoordinateModel extends BaseModel implements GraphQLVisitableModel {
        private double f10451d;
        private double f10452e;
        private double f10453f;

        /* compiled from: Unexpected type  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ViewerLocationCoordinateModel.class, new Deserializer());
            }

            public Object m10855a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ViewerLocationCoordinateParser.m10869a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object viewerLocationCoordinateModel = new ViewerLocationCoordinateModel();
                ((BaseModel) viewerLocationCoordinateModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (viewerLocationCoordinateModel instanceof Postprocessable) {
                    return ((Postprocessable) viewerLocationCoordinateModel).a();
                }
                return viewerLocationCoordinateModel;
            }
        }

        /* compiled from: Unexpected type  */
        public class Serializer extends JsonSerializer<ViewerLocationCoordinateModel> {
            public final void m10856a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ViewerLocationCoordinateModel viewerLocationCoordinateModel = (ViewerLocationCoordinateModel) obj;
                if (viewerLocationCoordinateModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(viewerLocationCoordinateModel.m10857a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    viewerLocationCoordinateModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ViewerLocationCoordinateParser.m10870a(viewerLocationCoordinateModel.w_(), viewerLocationCoordinateModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ViewerLocationCoordinateModel.class, new Serializer());
            }
        }

        public ViewerLocationCoordinateModel() {
            super(3);
        }

        public final int jK_() {
            return -2102570600;
        }

        public final GraphQLVisitableModel m10858a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10857a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f10451d, 0.0d);
            flatBufferBuilder.a(1, this.f10452e, 0.0d);
            flatBufferBuilder.a(2, this.f10453f, 0.0d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10859a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10451d = mutableFlatBuffer.a(i, 0, 0.0d);
            this.f10452e = mutableFlatBuffer.a(i, 1, 0.0d);
            this.f10453f = mutableFlatBuffer.a(i, 2, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 153967807)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Unexpected type  */
    public final class ViewerLocationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerLocationCoordinateModel f10454d;
        private int f10455e;

        /* compiled from: Unexpected type  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ViewerLocationModel.class, new Deserializer());
            }

            public Object m10860a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ViewerLocationParser.m10871a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object viewerLocationModel = new ViewerLocationModel();
                ((BaseModel) viewerLocationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (viewerLocationModel instanceof Postprocessable) {
                    return ((Postprocessable) viewerLocationModel).a();
                }
                return viewerLocationModel;
            }
        }

        /* compiled from: Unexpected type  */
        public class Serializer extends JsonSerializer<ViewerLocationModel> {
            public final void m10861a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ViewerLocationModel viewerLocationModel = (ViewerLocationModel) obj;
                if (viewerLocationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(viewerLocationModel.m10863a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    viewerLocationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ViewerLocationParser.m10872a(viewerLocationModel.w_(), viewerLocationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ViewerLocationModel.class, new Serializer());
            }
        }

        public ViewerLocationModel() {
            super(2);
        }

        @Nullable
        private ViewerLocationCoordinateModel m10862a() {
            this.f10454d = (ViewerLocationCoordinateModel) super.a(this.f10454d, 0, ViewerLocationCoordinateModel.class);
            return this.f10454d;
        }

        public final int jK_() {
            return -800993273;
        }

        public final GraphQLVisitableModel m10864a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10862a() != null) {
                ViewerLocationCoordinateModel viewerLocationCoordinateModel = (ViewerLocationCoordinateModel) graphQLModelMutatingVisitor.b(m10862a());
                if (m10862a() != viewerLocationCoordinateModel) {
                    graphQLVisitableModel = (ViewerLocationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10454d = viewerLocationCoordinateModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10863a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10862a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f10455e, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10865a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10455e = mutableFlatBuffer.a(i, 1, 0);
        }
    }
}
