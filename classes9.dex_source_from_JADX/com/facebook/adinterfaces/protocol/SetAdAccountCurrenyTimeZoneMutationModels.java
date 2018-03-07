package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.SetAdAccountCurrenyTimeZoneMutationParsers.FBPageSetAdAccountCurrenyTimeZoneParser;
import com.facebook.adinterfaces.protocol.SetAdAccountCurrenyTimeZoneMutationParsers.FBPageSetAdAccountCurrenyTimeZoneParser.AdAccountParser;
import com.facebook.adinterfaces.protocol.SetAdAccountCurrenyTimeZoneMutationParsers.FBPageSetAdAccountCurrenyTimeZoneParser.AdAccountParser.TimezoneInfoParser;
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
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: Video Channel Feed */
public class SetAdAccountCurrenyTimeZoneMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 230732612)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Video Channel Feed */
    public final class FBPageSetAdAccountCurrenyTimeZoneModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AdAccountModel f22415d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 831955410)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Video Channel Feed */
        public final class AdAccountModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f22413d;
            @Nullable
            private TimezoneInfoModel f22414e;

            /* compiled from: Video Channel Feed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdAccountModel.class, new Deserializer());
                }

                public Object m24270a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdAccountParser.m24288a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object adAccountModel = new AdAccountModel();
                    ((BaseModel) adAccountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (adAccountModel instanceof Postprocessable) {
                        return ((Postprocessable) adAccountModel).a();
                    }
                    return adAccountModel;
                }
            }

            /* compiled from: Video Channel Feed */
            public class Serializer extends JsonSerializer<AdAccountModel> {
                public final void m24271a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdAccountModel adAccountModel = (AdAccountModel) obj;
                    if (adAccountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adAccountModel.m24279a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adAccountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdAccountParser.m24289a(adAccountModel.w_(), adAccountModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AdAccountModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 855047979)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: Video Channel Feed */
            public final class TimezoneInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f22412d;

                /* compiled from: Video Channel Feed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TimezoneInfoModel.class, new Deserializer());
                    }

                    public Object m24272a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TimezoneInfoParser.m24286a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object timezoneInfoModel = new TimezoneInfoModel();
                        ((BaseModel) timezoneInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (timezoneInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) timezoneInfoModel).a();
                        }
                        return timezoneInfoModel;
                    }
                }

                /* compiled from: Video Channel Feed */
                public class Serializer extends JsonSerializer<TimezoneInfoModel> {
                    public final void m24273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TimezoneInfoModel timezoneInfoModel = (TimezoneInfoModel) obj;
                        if (timezoneInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(timezoneInfoModel.m24275a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            timezoneInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TimezoneInfoParser.m24287a(timezoneInfoModel.w_(), timezoneInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TimezoneInfoModel.class, new Serializer());
                    }
                }

                public TimezoneInfoModel() {
                    super(1);
                }

                @Nullable
                private String m24274a() {
                    this.f22412d = super.a(this.f22412d, 0);
                    return this.f22412d;
                }

                public final int jK_() {
                    return 1290195047;
                }

                public final GraphQLVisitableModel m24276a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m24275a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m24274a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public AdAccountModel() {
                super(2);
            }

            @Nullable
            private String m24277a() {
                this.f22413d = super.a(this.f22413d, 0);
                return this.f22413d;
            }

            @Nullable
            private TimezoneInfoModel m24278j() {
                this.f22414e = (TimezoneInfoModel) super.a(this.f22414e, 1, TimezoneInfoModel.class);
                return this.f22414e;
            }

            public final int jK_() {
                return 1449252970;
            }

            public final GraphQLVisitableModel m24280a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24278j() != null) {
                    TimezoneInfoModel timezoneInfoModel = (TimezoneInfoModel) graphQLModelMutatingVisitor.b(m24278j());
                    if (m24278j() != timezoneInfoModel) {
                        graphQLVisitableModel = (AdAccountModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22414e = timezoneInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24279a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24277a());
                int a = ModelHelper.a(flatBufferBuilder, m24278j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: Video Channel Feed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBPageSetAdAccountCurrenyTimeZoneModel.class, new Deserializer());
            }

            public Object m24281a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBPageSetAdAccountCurrenyTimeZoneParser.m24290a(jsonParser);
                Object fBPageSetAdAccountCurrenyTimeZoneModel = new FBPageSetAdAccountCurrenyTimeZoneModel();
                ((BaseModel) fBPageSetAdAccountCurrenyTimeZoneModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBPageSetAdAccountCurrenyTimeZoneModel instanceof Postprocessable) {
                    return ((Postprocessable) fBPageSetAdAccountCurrenyTimeZoneModel).a();
                }
                return fBPageSetAdAccountCurrenyTimeZoneModel;
            }
        }

        /* compiled from: Video Channel Feed */
        public class Serializer extends JsonSerializer<FBPageSetAdAccountCurrenyTimeZoneModel> {
            public final void m24282a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBPageSetAdAccountCurrenyTimeZoneModel fBPageSetAdAccountCurrenyTimeZoneModel = (FBPageSetAdAccountCurrenyTimeZoneModel) obj;
                if (fBPageSetAdAccountCurrenyTimeZoneModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBPageSetAdAccountCurrenyTimeZoneModel.m24284a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBPageSetAdAccountCurrenyTimeZoneModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBPageSetAdAccountCurrenyTimeZoneModel.w_();
                int u_ = fBPageSetAdAccountCurrenyTimeZoneModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("ad_account");
                    AdAccountParser.m24289a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBPageSetAdAccountCurrenyTimeZoneModel.class, new Serializer());
            }
        }

        public FBPageSetAdAccountCurrenyTimeZoneModel() {
            super(1);
        }

        @Nullable
        private AdAccountModel m24283a() {
            this.f22415d = (AdAccountModel) super.a(this.f22415d, 0, AdAccountModel.class);
            return this.f22415d;
        }

        public final int jK_() {
            return 357496523;
        }

        public final GraphQLVisitableModel m24285a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24283a() != null) {
                AdAccountModel adAccountModel = (AdAccountModel) graphQLModelMutatingVisitor.b(m24283a());
                if (m24283a() != adAccountModel) {
                    graphQLVisitableModel = (FBPageSetAdAccountCurrenyTimeZoneModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22415d = adAccountModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24284a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24283a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
