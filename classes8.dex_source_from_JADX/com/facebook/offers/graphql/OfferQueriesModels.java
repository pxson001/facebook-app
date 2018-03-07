package com.facebook.offers.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCouponClaimLocation;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.offers.graphql.OfferQueriesInterfaces.CouponData;
import com.facebook.offers.graphql.OfferQueriesInterfaces.OfferClaimData;
import com.facebook.offers.graphql.OfferQueriesParsers.CouponDataParser;
import com.facebook.offers.graphql.OfferQueriesParsers.CouponDataParser.MessageParser;
import com.facebook.offers.graphql.OfferQueriesParsers.CouponDataParser.PhotoParser;
import com.facebook.offers.graphql.OfferQueriesParsers.ImageDataParser;
import com.facebook.offers.graphql.OfferQueriesParsers.OfferClaimDataParser;
import com.facebook.offers.graphql.OfferQueriesParsers.OfferDataParser;
import com.facebook.offers.graphql.OfferQueriesParsers.OfferDetailQueryParser;
import com.facebook.offers.graphql.OfferQueriesParsers.OfferOwnerParser;
import com.facebook.offers.graphql.OfferQueriesParsers.OfferStoryAttachmentFieldsParser;
import com.facebook.offers.graphql.OfferQueriesParsers.OfferStoryAttachmentFieldsParser.MediaParser;
import com.facebook.offers.graphql.OfferQueriesParsers.OfferStoryFieldsParser;
import com.facebook.offers.graphql.OfferQueriesParsers.OfferStoryFieldsParser.ShareableParser;
import com.facebook.offers.graphql.OfferQueriesParsers.OfferViewDataParser;
import com.facebook.offers.graphql.OfferQueriesParsers.PhotoDataParser;
import com.facebook.offers.graphql.OfferQueriesParsers.VideoDataParser;
import com.facebook.offers.graphql.OfferQueriesParsers.VideoDataParser.TitleParser;
import com.facebook.offers.graphql.OfferQueriesParsers.VideoDataParser.VideoThumbnailsParser;
import com.facebook.offers.graphql.OfferQueriesParsers.VideoDataParser.VideoThumbnailsParser.NodesParser;
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

/* compiled from: current_location_city */
public class OfferQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1483505897)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class CouponDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, CouponData {
        @Nullable
        private GraphQLCouponClaimLocation f16340d;
        private long f16341e;
        private int f16342f;
        private boolean f16343g;
        @Nullable
        private String f16344h;
        private boolean f16345i;
        private boolean f16346j;
        private boolean f16347k;
        @Nullable
        private MessageModel f16348l;
        @Nullable
        private String f16349m;
        @Nullable
        private OfferOwnerModel f16350n;
        @Nullable
        private PhotoModel f16351o;
        @Nullable
        private String f16352p;
        @Nullable
        private String f16353q;
        @Nullable
        private String f16354r;
        @Nullable
        private String f16355s;

        /* compiled from: current_location_city */
        public final class Builder {
            @Nullable
            public GraphQLCouponClaimLocation f16320a;
            public long f16321b;
            public int f16322c;
            public boolean f16323d;
            @Nullable
            public String f16324e;
            public boolean f16325f;
            public boolean f16326g;
            public boolean f16327h;
            @Nullable
            public MessageModel f16328i;
            @Nullable
            public String f16329j;
            @Nullable
            public OfferOwnerModel f16330k;
            @Nullable
            public PhotoModel f16331l;
            @Nullable
            public String f16332m;
            @Nullable
            public String f16333n;
            @Nullable
            public String f16334o;
            @Nullable
            public String f16335p;

            public final CouponDataModel m19106a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = flatBufferBuilder.a(this.f16320a);
                int b = flatBufferBuilder.b(this.f16324e);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f16328i);
                int b2 = flatBufferBuilder.b(this.f16329j);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f16330k);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f16331l);
                int b3 = flatBufferBuilder.b(this.f16332m);
                int b4 = flatBufferBuilder.b(this.f16333n);
                int b5 = flatBufferBuilder.b(this.f16334o);
                int b6 = flatBufferBuilder.b(this.f16335p);
                flatBufferBuilder.c(16);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f16321b, 0);
                flatBufferBuilder.a(2, this.f16322c, 0);
                flatBufferBuilder.a(3, this.f16323d);
                flatBufferBuilder.b(4, b);
                flatBufferBuilder.a(5, this.f16325f);
                flatBufferBuilder.a(6, this.f16326g);
                flatBufferBuilder.a(7, this.f16327h);
                flatBufferBuilder.b(8, a2);
                flatBufferBuilder.b(9, b2);
                flatBufferBuilder.b(10, a3);
                flatBufferBuilder.b(11, a4);
                flatBufferBuilder.b(12, b3);
                flatBufferBuilder.b(13, b4);
                flatBufferBuilder.b(14, b5);
                flatBufferBuilder.b(15, b6);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CouponDataModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CouponDataModel.class, new Deserializer());
            }

            public Object m19107a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CouponDataParser.m19396a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object couponDataModel = new CouponDataModel();
                ((BaseModel) couponDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (couponDataModel instanceof Postprocessable) {
                    return ((Postprocessable) couponDataModel).a();
                }
                return couponDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: current_location_city */
        public final class MessageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f16337d;

            /* compiled from: current_location_city */
            public final class Builder {
                @Nullable
                public String f16336a;
            }

            /* compiled from: current_location_city */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageModel.class, new Deserializer());
                }

                public Object m19108a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageParser.m19392a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageModel = new MessageModel();
                    ((BaseModel) messageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageModel instanceof Postprocessable) {
                        return ((Postprocessable) messageModel).a();
                    }
                    return messageModel;
                }
            }

            /* compiled from: current_location_city */
            public class Serializer extends JsonSerializer<MessageModel> {
                public final void m19109a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageModel messageModel = (MessageModel) obj;
                    if (messageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageModel.m19111a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageParser.m19393a(messageModel.w_(), messageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessageModel.class, new Serializer());
                }
            }

            public MessageModel() {
                super(1);
            }

            public MessageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m19113a() {
                this.f16337d = super.a(this.f16337d, 0);
                return this.f16337d;
            }

            public static MessageModel m19110a(MessageModel messageModel) {
                if (messageModel == null) {
                    return null;
                }
                if (messageModel instanceof MessageModel) {
                    return messageModel;
                }
                Builder builder = new Builder();
                builder.f16336a = messageModel.m19113a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f16336a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MessageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m19112a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19111a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19113a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -691496622)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: current_location_city */
        public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ImageDataModel f16339d;

            /* compiled from: current_location_city */
            public final class Builder {
                @Nullable
                public ImageDataModel f16338a;
            }

            /* compiled from: current_location_city */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                }

                public Object m19114a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoParser.m19394a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photoModel = new PhotoModel();
                    ((BaseModel) photoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photoModel instanceof Postprocessable) {
                        return ((Postprocessable) photoModel).a();
                    }
                    return photoModel;
                }
            }

            /* compiled from: current_location_city */
            public class Serializer extends JsonSerializer<PhotoModel> {
                public final void m19115a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoModel photoModel = (PhotoModel) obj;
                    if (photoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoModel.m19117a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoParser.m19395a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ImageDataModel m19119a() {
                return m19120j();
            }

            public PhotoModel() {
                super(1);
            }

            public PhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final ImageDataModel m19120j() {
                this.f16339d = (ImageDataModel) super.a(this.f16339d, 0, ImageDataModel.class);
                return this.f16339d;
            }

            public static PhotoModel m19116a(PhotoModel photoModel) {
                if (photoModel == null) {
                    return null;
                }
                if (photoModel instanceof PhotoModel) {
                    return photoModel;
                }
                Builder builder = new Builder();
                builder.f16338a = ImageDataModel.m19148a(photoModel.m19119a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f16338a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m19118a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19120j() != null) {
                    ImageDataModel imageDataModel = (ImageDataModel) graphQLModelMutatingVisitor.b(m19120j());
                    if (m19120j() != imageDataModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16339d = imageDataModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19117a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19120j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<CouponDataModel> {
            public final void m19121a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CouponDataModel couponDataModel = (CouponDataModel) obj;
                if (couponDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(couponDataModel.m19124a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    couponDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CouponDataParser.m19397a(couponDataModel.w_(), couponDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CouponDataModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MessageModel mo993k() {
            return m19143s();
        }

        @Nullable
        public final /* synthetic */ OfferOwnerModel mo995m() {
            return m19144t();
        }

        @Nullable
        public final /* synthetic */ PhotoModel mo996n() {
            return m19145u();
        }

        public CouponDataModel() {
            super(16);
        }

        public CouponDataModel(MutableFlatBuffer mutableFlatBuffer) {
            super(16);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m19128a(String str, ConsistencyTuple consistencyTuple) {
            if ("has_viewer_claimed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(jL_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
                return;
            }
            consistencyTuple.a();
        }

        public final void m19129a(String str, Object obj, boolean z) {
            if ("has_viewer_claimed".equals(str)) {
                m19123a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        public final GraphQLCouponClaimLocation mo985b() {
            this.f16340d = (GraphQLCouponClaimLocation) super.b(this.f16340d, 0, GraphQLCouponClaimLocation.class, GraphQLCouponClaimLocation.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f16340d;
        }

        public final long mo986c() {
            a(0, 1);
            return this.f16341e;
        }

        public final int mo987d() {
            a(0, 2);
            return this.f16342f;
        }

        public final boolean jL_() {
            a(0, 3);
            return this.f16343g;
        }

        private void m19123a(boolean z) {
            this.f16343g = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, z);
            }
        }

        @Nullable
        public final String mo988g() {
            this.f16344h = super.a(this.f16344h, 4);
            return this.f16344h;
        }

        public final boolean jM_() {
            a(0, 5);
            return this.f16345i;
        }

        public final boolean jN_() {
            a(0, 6);
            return this.f16346j;
        }

        public final boolean mo989j() {
            a(0, 7);
            return this.f16347k;
        }

        @Nullable
        public final MessageModel m19143s() {
            this.f16348l = (MessageModel) super.a(this.f16348l, 8, MessageModel.class);
            return this.f16348l;
        }

        @Nullable
        public final String mo994l() {
            this.f16349m = super.a(this.f16349m, 9);
            return this.f16349m;
        }

        @Nullable
        public final OfferOwnerModel m19144t() {
            this.f16350n = (OfferOwnerModel) super.a(this.f16350n, 10, OfferOwnerModel.class);
            return this.f16350n;
        }

        @Nullable
        public final PhotoModel m19145u() {
            this.f16351o = (PhotoModel) super.a(this.f16351o, 11, PhotoModel.class);
            return this.f16351o;
        }

        @Nullable
        public final String mo997o() {
            this.f16352p = super.a(this.f16352p, 12);
            return this.f16352p;
        }

        @Nullable
        public final String mo998p() {
            this.f16353q = super.a(this.f16353q, 13);
            return this.f16353q;
        }

        @Nullable
        public final String mo999q() {
            this.f16354r = super.a(this.f16354r, 14);
            return this.f16354r;
        }

        @Nullable
        public final String mo1000r() {
            this.f16355s = super.a(this.f16355s, 15);
            return this.f16355s;
        }

        public static CouponDataModel m19122a(CouponData couponData) {
            if (couponData == null) {
                return null;
            }
            if (couponData instanceof CouponDataModel) {
                return (CouponDataModel) couponData;
            }
            Builder builder = new Builder();
            builder.f16320a = couponData.mo985b();
            builder.f16321b = couponData.mo986c();
            builder.f16322c = couponData.mo987d();
            builder.f16323d = couponData.jL_();
            builder.f16324e = couponData.mo988g();
            builder.f16325f = couponData.jM_();
            builder.f16326g = couponData.jN_();
            builder.f16327h = couponData.mo989j();
            builder.f16328i = MessageModel.m19110a(couponData.mo993k());
            builder.f16329j = couponData.mo994l();
            builder.f16330k = OfferOwnerModel.m19236a(couponData.mo995m());
            builder.f16331l = PhotoModel.m19116a(couponData.mo996n());
            builder.f16332m = couponData.mo997o();
            builder.f16333n = couponData.mo998p();
            builder.f16334o = couponData.mo999q();
            builder.f16335p = couponData.mo1000r();
            return builder.m19106a();
        }

        @Nullable
        public final String m19126a() {
            return mo988g();
        }

        public final int jK_() {
            return 2024260678;
        }

        public final GraphQLVisitableModel m19125a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19143s() != null) {
                MessageModel messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m19143s());
                if (m19143s() != messageModel) {
                    graphQLVisitableModel = (CouponDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16348l = messageModel;
                }
            }
            if (m19144t() != null) {
                OfferOwnerModel offerOwnerModel = (OfferOwnerModel) graphQLModelMutatingVisitor.b(m19144t());
                if (m19144t() != offerOwnerModel) {
                    graphQLVisitableModel = (CouponDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16350n = offerOwnerModel;
                }
            }
            if (m19145u() != null) {
                PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m19145u());
                if (m19145u() != photoModel) {
                    graphQLVisitableModel = (CouponDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16351o = photoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19124a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(mo985b());
            int b = flatBufferBuilder.b(mo988g());
            int a2 = ModelHelper.a(flatBufferBuilder, m19143s());
            int b2 = flatBufferBuilder.b(mo994l());
            int a3 = ModelHelper.a(flatBufferBuilder, m19144t());
            int a4 = ModelHelper.a(flatBufferBuilder, m19145u());
            int b3 = flatBufferBuilder.b(mo997o());
            int b4 = flatBufferBuilder.b(mo998p());
            int b5 = flatBufferBuilder.b(mo999q());
            int b6 = flatBufferBuilder.b(mo1000r());
            flatBufferBuilder.c(16);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f16341e, 0);
            flatBufferBuilder.a(2, this.f16342f, 0);
            flatBufferBuilder.a(3, this.f16343g);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.a(5, this.f16345i);
            flatBufferBuilder.a(6, this.f16346j);
            flatBufferBuilder.a(7, this.f16347k);
            flatBufferBuilder.b(8, a2);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.b(10, a3);
            flatBufferBuilder.b(11, a4);
            flatBufferBuilder.b(12, b3);
            flatBufferBuilder.b(13, b4);
            flatBufferBuilder.b(14, b5);
            flatBufferBuilder.b(15, b6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19127a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f16341e = mutableFlatBuffer.a(i, 1, 0);
            this.f16342f = mutableFlatBuffer.a(i, 2, 0);
            this.f16343g = mutableFlatBuffer.a(i, 3);
            this.f16345i = mutableFlatBuffer.a(i, 5);
            this.f16346j = mutableFlatBuffer.a(i, 6);
            this.f16347k = mutableFlatBuffer.a(i, 7);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 842551240)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class ImageDataModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f16357d;

        /* compiled from: current_location_city */
        public final class Builder {
            @Nullable
            public String f16356a;
        }

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ImageDataModel.class, new Deserializer());
            }

            public Object m19146a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ImageDataParser.m19398a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object imageDataModel = new ImageDataModel();
                ((BaseModel) imageDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (imageDataModel instanceof Postprocessable) {
                    return ((Postprocessable) imageDataModel).a();
                }
                return imageDataModel;
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<ImageDataModel> {
            public final void m19147a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ImageDataModel imageDataModel = (ImageDataModel) obj;
                if (imageDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(imageDataModel.m19149a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    imageDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ImageDataParser.m19399a(imageDataModel.w_(), imageDataModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ImageDataModel.class, new Serializer());
            }
        }

        public ImageDataModel() {
            super(1);
        }

        public ImageDataModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m19151a() {
            this.f16357d = super.a(this.f16357d, 0);
            return this.f16357d;
        }

        public static ImageDataModel m19148a(ImageDataModel imageDataModel) {
            if (imageDataModel == null) {
                return null;
            }
            if (imageDataModel instanceof ImageDataModel) {
                return imageDataModel;
            }
            Builder builder = new Builder();
            builder.f16356a = imageDataModel.m19151a();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f16356a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ImageDataModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m19150a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m19149a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m19151a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1623608777)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class OfferClaimDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, OfferClaimData {
        @Nullable
        private String f16369d;
        private long f16370e;
        @Nullable
        private String f16371f;
        @Nullable
        private ImageDataModel f16372g;
        private boolean f16373h;
        private boolean f16374i;
        @Nullable
        private OfferDataModel f16375j;
        @Nullable
        private String f16376k;
        @Nullable
        private OfferViewDataModel f16377l;
        @Nullable
        private OfferStoryFieldsModel f16378m;
        @Nullable
        private OfferStoryFieldsModel f16379n;

        /* compiled from: current_location_city */
        public final class Builder {
            @Nullable
            public String f16358a;
            public long f16359b;
            @Nullable
            public String f16360c;
            @Nullable
            public ImageDataModel f16361d;
            public boolean f16362e;
            public boolean f16363f;
            @Nullable
            public OfferDataModel f16364g;
            @Nullable
            public String f16365h;
            @Nullable
            public OfferViewDataModel f16366i;
            @Nullable
            public OfferStoryFieldsModel f16367j;
            @Nullable
            public OfferStoryFieldsModel f16368k;

            public static Builder m19152a(OfferClaimDataModel offerClaimDataModel) {
                Builder builder = new Builder();
                builder.f16358a = offerClaimDataModel.mo1004s();
                builder.f16359b = offerClaimDataModel.mo1005t();
                builder.f16360c = offerClaimDataModel.mo1003g();
                builder.f16361d = offerClaimDataModel.m19164j();
                builder.f16362e = offerClaimDataModel.mo1007v();
                builder.f16363f = offerClaimDataModel.mo1008w();
                builder.f16364g = offerClaimDataModel.m19165k();
                builder.f16365h = offerClaimDataModel.mo1010y();
                builder.f16366i = offerClaimDataModel.m19166l();
                builder.f16367j = offerClaimDataModel.m19167m();
                builder.f16368k = offerClaimDataModel.m19168n();
                return builder;
            }

            public final OfferClaimDataModel m19153a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f16358a);
                int b2 = flatBufferBuilder.b(this.f16360c);
                int a = ModelHelper.a(flatBufferBuilder, this.f16361d);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f16364g);
                int b3 = flatBufferBuilder.b(this.f16365h);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f16366i);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f16367j);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f16368k);
                flatBufferBuilder.c(11);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f16359b, 0);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a);
                flatBufferBuilder.a(4, this.f16362e);
                flatBufferBuilder.a(5, this.f16363f);
                flatBufferBuilder.b(6, a2);
                flatBufferBuilder.b(7, b3);
                flatBufferBuilder.b(8, a3);
                flatBufferBuilder.b(9, a4);
                flatBufferBuilder.b(10, a5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OfferClaimDataModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferClaimDataModel.class, new Deserializer());
            }

            public Object m19154a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(OfferClaimDataParser.m19400a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object offerClaimDataModel = new OfferClaimDataModel();
                ((BaseModel) offerClaimDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (offerClaimDataModel instanceof Postprocessable) {
                    return ((Postprocessable) offerClaimDataModel).a();
                }
                return offerClaimDataModel;
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<OfferClaimDataModel> {
            public final void m19155a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                OfferClaimDataModel offerClaimDataModel = (OfferClaimDataModel) obj;
                if (offerClaimDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerClaimDataModel.m19159a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerClaimDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                OfferClaimDataParser.m19401a(offerClaimDataModel.w_(), offerClaimDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(OfferClaimDataModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ OfferStoryFieldsModel mo1001A() {
            return m19167m();
        }

        @Nullable
        public final /* synthetic */ OfferStoryFieldsModel mo1002B() {
            return m19168n();
        }

        @Nullable
        public final /* synthetic */ ImageDataModel mo1006u() {
            return m19164j();
        }

        @Nullable
        public final /* synthetic */ OfferDataModel mo1009x() {
            return m19165k();
        }

        @Nullable
        public final /* synthetic */ OfferViewDataModel mo1011z() {
            return m19166l();
        }

        public OfferClaimDataModel() {
            super(11);
        }

        public OfferClaimDataModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String mo1004s() {
            this.f16369d = super.a(this.f16369d, 0);
            return this.f16369d;
        }

        public final long mo1005t() {
            a(0, 1);
            return this.f16370e;
        }

        @Nullable
        public final String mo1003g() {
            this.f16371f = super.a(this.f16371f, 2);
            return this.f16371f;
        }

        @Nullable
        public final ImageDataModel m19164j() {
            this.f16372g = (ImageDataModel) super.a(this.f16372g, 3, ImageDataModel.class);
            return this.f16372g;
        }

        public final boolean mo1007v() {
            a(0, 4);
            return this.f16373h;
        }

        public final boolean mo1008w() {
            a(0, 5);
            return this.f16374i;
        }

        @Nullable
        public final OfferDataModel m19165k() {
            this.f16375j = (OfferDataModel) super.a(this.f16375j, 6, OfferDataModel.class);
            return this.f16375j;
        }

        @Nullable
        public final String mo1010y() {
            this.f16376k = super.a(this.f16376k, 7);
            return this.f16376k;
        }

        @Nullable
        public final OfferViewDataModel m19166l() {
            this.f16377l = (OfferViewDataModel) super.a(this.f16377l, 8, OfferViewDataModel.class);
            return this.f16377l;
        }

        @Nullable
        public final OfferStoryFieldsModel m19167m() {
            this.f16378m = (OfferStoryFieldsModel) super.a(this.f16378m, 9, OfferStoryFieldsModel.class);
            return this.f16378m;
        }

        @Nullable
        public final OfferStoryFieldsModel m19168n() {
            this.f16379n = (OfferStoryFieldsModel) super.a(this.f16379n, 10, OfferStoryFieldsModel.class);
            return this.f16379n;
        }

        public static OfferClaimDataModel m19156a(OfferClaimData offerClaimData) {
            if (offerClaimData == null) {
                return null;
            }
            if (offerClaimData instanceof OfferClaimDataModel) {
                return (OfferClaimDataModel) offerClaimData;
            }
            Builder builder = new Builder();
            builder.f16358a = offerClaimData.mo1004s();
            builder.f16359b = offerClaimData.mo1005t();
            builder.f16360c = offerClaimData.mo1003g();
            builder.f16361d = ImageDataModel.m19148a(offerClaimData.mo1006u());
            builder.f16362e = offerClaimData.mo1007v();
            builder.f16363f = offerClaimData.mo1008w();
            builder.f16364g = OfferDataModel.m19180a(offerClaimData.mo1009x());
            builder.f16365h = offerClaimData.mo1010y();
            builder.f16366i = OfferViewDataModel.m19284a(offerClaimData.mo1011z());
            builder.f16367j = OfferStoryFieldsModel.m19272a(offerClaimData.mo1001A());
            builder.f16368k = OfferStoryFieldsModel.m19272a(offerClaimData.mo1002B());
            return builder.m19153a();
        }

        @Nullable
        public final String m19161a() {
            return mo1003g();
        }

        public final int jK_() {
            return 2129040224;
        }

        public final GraphQLVisitableModel m19160a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            OfferStoryFieldsModel offerStoryFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19164j() != null) {
                ImageDataModel imageDataModel = (ImageDataModel) graphQLModelMutatingVisitor.b(m19164j());
                if (m19164j() != imageDataModel) {
                    graphQLVisitableModel = (OfferClaimDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16372g = imageDataModel;
                }
            }
            if (m19165k() != null) {
                OfferDataModel offerDataModel = (OfferDataModel) graphQLModelMutatingVisitor.b(m19165k());
                if (m19165k() != offerDataModel) {
                    graphQLVisitableModel = (OfferClaimDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16375j = offerDataModel;
                }
            }
            if (m19166l() != null) {
                OfferViewDataModel offerViewDataModel = (OfferViewDataModel) graphQLModelMutatingVisitor.b(m19166l());
                if (m19166l() != offerViewDataModel) {
                    graphQLVisitableModel = (OfferClaimDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16377l = offerViewDataModel;
                }
            }
            if (m19167m() != null) {
                offerStoryFieldsModel = (OfferStoryFieldsModel) graphQLModelMutatingVisitor.b(m19167m());
                if (m19167m() != offerStoryFieldsModel) {
                    graphQLVisitableModel = (OfferClaimDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16378m = offerStoryFieldsModel;
                }
            }
            if (m19168n() != null) {
                offerStoryFieldsModel = (OfferStoryFieldsModel) graphQLModelMutatingVisitor.b(m19168n());
                if (m19168n() != offerStoryFieldsModel) {
                    graphQLVisitableModel = (OfferClaimDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16379n = offerStoryFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19159a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo1004s());
            int b2 = flatBufferBuilder.b(mo1003g());
            int a = ModelHelper.a(flatBufferBuilder, m19164j());
            int a2 = ModelHelper.a(flatBufferBuilder, m19165k());
            int b3 = flatBufferBuilder.b(mo1010y());
            int a3 = ModelHelper.a(flatBufferBuilder, m19166l());
            int a4 = ModelHelper.a(flatBufferBuilder, m19167m());
            int a5 = ModelHelper.a(flatBufferBuilder, m19168n());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f16370e, 0);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.a(4, this.f16373h);
            flatBufferBuilder.a(5, this.f16374i);
            flatBufferBuilder.b(6, a2);
            flatBufferBuilder.b(7, b3);
            flatBufferBuilder.b(8, a3);
            flatBufferBuilder.b(9, a4);
            flatBufferBuilder.b(10, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19162a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f16370e = mutableFlatBuffer.a(i, 1, 0);
            this.f16373h = mutableFlatBuffer.a(i, 4);
            this.f16374i = mutableFlatBuffer.a(i, 5);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1240416667)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class OfferDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private int f16391d;
        @Nullable
        private String f16392e;
        private int f16393f;
        @Nullable
        private String f16394g;
        @Nullable
        private String f16395h;
        private long f16396i;
        @Nullable
        private String f16397j;
        @Nullable
        private String f16398k;
        @Nullable
        private String f16399l;
        @Nullable
        private OfferOwnerModel f16400m;
        @Nullable
        private String f16401n;

        /* compiled from: current_location_city */
        public final class Builder {
            public int f16380a;
            @Nullable
            public String f16381b;
            public int f16382c;
            @Nullable
            public String f16383d;
            @Nullable
            public String f16384e;
            public long f16385f;
            @Nullable
            public String f16386g;
            @Nullable
            public String f16387h;
            @Nullable
            public String f16388i;
            @Nullable
            public OfferOwnerModel f16389j;
            @Nullable
            public String f16390k;

            public final OfferDataModel m19177a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f16381b);
                int b2 = flatBufferBuilder.b(this.f16383d);
                int b3 = flatBufferBuilder.b(this.f16384e);
                int b4 = flatBufferBuilder.b(this.f16386g);
                int b5 = flatBufferBuilder.b(this.f16387h);
                int b6 = flatBufferBuilder.b(this.f16388i);
                int a = ModelHelper.a(flatBufferBuilder, this.f16389j);
                int b7 = flatBufferBuilder.b(this.f16390k);
                flatBufferBuilder.c(11);
                flatBufferBuilder.a(0, this.f16380a, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f16382c, 0);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.a(5, this.f16385f, 0);
                flatBufferBuilder.b(6, b4);
                flatBufferBuilder.b(7, b5);
                flatBufferBuilder.b(8, b6);
                flatBufferBuilder.b(9, a);
                flatBufferBuilder.b(10, b7);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OfferDataModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferDataModel.class, new Deserializer());
            }

            public Object m19178a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(OfferDataParser.m19402a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object offerDataModel = new OfferDataModel();
                ((BaseModel) offerDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (offerDataModel instanceof Postprocessable) {
                    return ((Postprocessable) offerDataModel).a();
                }
                return offerDataModel;
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<OfferDataModel> {
            public final void m19179a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                OfferDataModel offerDataModel = (OfferDataModel) obj;
                if (offerDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerDataModel.m19182a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                OfferDataParser.m19403a(offerDataModel.w_(), offerDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(OfferDataModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ OfferOwnerModel m19192l() {
            return m19181n();
        }

        public OfferDataModel() {
            super(11);
        }

        public OfferDataModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m19186b() {
            a(0, 0);
            return this.f16391d;
        }

        @Nullable
        public final String m19187c() {
            this.f16392e = super.a(this.f16392e, 1);
            return this.f16392e;
        }

        public final int m19188d() {
            a(0, 2);
            return this.f16393f;
        }

        @Nullable
        public final String jO_() {
            this.f16394g = super.a(this.f16394g, 3);
            return this.f16394g;
        }

        @Nullable
        public final String m19189g() {
            this.f16395h = super.a(this.f16395h, 4);
            return this.f16395h;
        }

        public final long jP_() {
            a(0, 5);
            return this.f16396i;
        }

        @Nullable
        public final String jQ_() {
            this.f16397j = super.a(this.f16397j, 6);
            return this.f16397j;
        }

        @Nullable
        public final String m19190j() {
            this.f16398k = super.a(this.f16398k, 7);
            return this.f16398k;
        }

        @Nullable
        public final String m19191k() {
            this.f16399l = super.a(this.f16399l, 8);
            return this.f16399l;
        }

        @Nullable
        private OfferOwnerModel m19181n() {
            this.f16400m = (OfferOwnerModel) super.a(this.f16400m, 9, OfferOwnerModel.class);
            return this.f16400m;
        }

        @Nullable
        public final String m19193m() {
            this.f16401n = super.a(this.f16401n, 10);
            return this.f16401n;
        }

        public static OfferDataModel m19180a(OfferDataModel offerDataModel) {
            if (offerDataModel == null) {
                return null;
            }
            if (offerDataModel instanceof OfferDataModel) {
                return offerDataModel;
            }
            Builder builder = new Builder();
            builder.f16380a = offerDataModel.m19186b();
            builder.f16381b = offerDataModel.m19187c();
            builder.f16382c = offerDataModel.m19188d();
            builder.f16383d = offerDataModel.jO_();
            builder.f16384e = offerDataModel.m19189g();
            builder.f16385f = offerDataModel.jP_();
            builder.f16386g = offerDataModel.jQ_();
            builder.f16387h = offerDataModel.m19190j();
            builder.f16388i = offerDataModel.m19191k();
            builder.f16389j = OfferOwnerModel.m19236a(offerDataModel.m19192l());
            builder.f16390k = offerDataModel.m19193m();
            return builder.m19177a();
        }

        @Nullable
        public final String m19184a() {
            return jQ_();
        }

        public final int jK_() {
            return 76098108;
        }

        public final GraphQLVisitableModel m19183a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19181n() != null) {
                OfferOwnerModel offerOwnerModel = (OfferOwnerModel) graphQLModelMutatingVisitor.b(m19181n());
                if (m19181n() != offerOwnerModel) {
                    graphQLVisitableModel = (OfferDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16400m = offerOwnerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19182a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m19187c());
            int b2 = flatBufferBuilder.b(jO_());
            int b3 = flatBufferBuilder.b(m19189g());
            int b4 = flatBufferBuilder.b(jQ_());
            int b5 = flatBufferBuilder.b(m19190j());
            int b6 = flatBufferBuilder.b(m19191k());
            int a = ModelHelper.a(flatBufferBuilder, m19181n());
            int b7 = flatBufferBuilder.b(m19193m());
            flatBufferBuilder.c(11);
            flatBufferBuilder.a(0, this.f16391d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f16393f, 0);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.a(5, this.f16396i, 0);
            flatBufferBuilder.b(6, b4);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.b(8, b6);
            flatBufferBuilder.b(9, a);
            flatBufferBuilder.b(10, b7);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19185a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f16391d = mutableFlatBuffer.a(i, 0, 0);
            this.f16393f = mutableFlatBuffer.a(i, 2, 0);
            this.f16396i = mutableFlatBuffer.a(i, 5, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -398019522)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class OfferDetailQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, CouponData, OfferClaimData {
        @Nullable
        private OfferStoryFieldsModel f16402A;
        @Nullable
        private OfferStoryFieldsModel f16403B;
        @Nullable
        private String f16404C;
        @Nullable
        private String f16405D;
        @Nullable
        private GraphQLObjectType f16406d;
        @Nullable
        private String f16407e;
        private long f16408f;
        @Nullable
        private GraphQLCouponClaimLocation f16409g;
        private long f16410h;
        private int f16411i;
        private boolean f16412j;
        @Nullable
        private String f16413k;
        @Nullable
        private ImageDataModel f16414l;
        private boolean f16415m;
        private boolean f16416n;
        private boolean f16417o;
        private boolean f16418p;
        @Nullable
        private MessageModel f16419q;
        @Nullable
        private String f16420r;
        private boolean f16421s;
        @Nullable
        private OfferDataModel f16422t;
        @Nullable
        private String f16423u;
        @Nullable
        private OfferViewDataModel f16424v;
        @Nullable
        private OfferOwnerModel f16425w;
        @Nullable
        private PhotoModel f16426x;
        @Nullable
        private String f16427y;
        @Nullable
        private String f16428z;

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferDetailQueryModel.class, new Deserializer());
            }

            public Object m19194a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(OfferDetailQueryParser.m19404a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object offerDetailQueryModel = new OfferDetailQueryModel();
                ((BaseModel) offerDetailQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (offerDetailQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) offerDetailQueryModel).a();
                }
                return offerDetailQueryModel;
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<OfferDetailQueryModel> {
            public final void m19195a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                OfferDetailQueryModel offerDetailQueryModel = (OfferDetailQueryModel) obj;
                if (offerDetailQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerDetailQueryModel.m19207a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerDetailQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                OfferDetailQueryParser.m19405a(offerDetailQueryModel.w_(), offerDetailQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(OfferDetailQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ OfferStoryFieldsModel mo1001A() {
            return m19203J();
        }

        @Nullable
        public final /* synthetic */ OfferStoryFieldsModel mo1002B() {
            return m19204K();
        }

        @Nullable
        public final /* synthetic */ MessageModel mo993k() {
            return m19198E();
        }

        @Nullable
        public final /* synthetic */ OfferOwnerModel mo995m() {
            return m19201H();
        }

        @Nullable
        public final /* synthetic */ PhotoModel mo996n() {
            return m19202I();
        }

        @Nullable
        public final /* synthetic */ ImageDataModel mo1006u() {
            return m19197D();
        }

        @Nullable
        public final /* synthetic */ OfferDataModel mo1009x() {
            return m19199F();
        }

        @Nullable
        public final /* synthetic */ OfferViewDataModel mo1011z() {
            return m19200G();
        }

        public OfferDetailQueryModel() {
            super(27);
        }

        public final void m19211a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19212a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m19196C() {
            if (this.b != null && this.f16406d == null) {
                this.f16406d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f16406d;
        }

        @Nullable
        public final String mo1004s() {
            this.f16407e = super.a(this.f16407e, 1);
            return this.f16407e;
        }

        public final long mo1005t() {
            a(0, 2);
            return this.f16408f;
        }

        @Nullable
        public final GraphQLCouponClaimLocation mo985b() {
            this.f16409g = (GraphQLCouponClaimLocation) super.b(this.f16409g, 3, GraphQLCouponClaimLocation.class, GraphQLCouponClaimLocation.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f16409g;
        }

        public final long mo986c() {
            a(0, 4);
            return this.f16410h;
        }

        public final int mo987d() {
            a(0, 5);
            return this.f16411i;
        }

        public final boolean jL_() {
            a(0, 6);
            return this.f16412j;
        }

        @Nullable
        public final String mo1003g() {
            this.f16413k = super.a(this.f16413k, 7);
            return this.f16413k;
        }

        @Nullable
        private ImageDataModel m19197D() {
            this.f16414l = (ImageDataModel) super.a(this.f16414l, 8, ImageDataModel.class);
            return this.f16414l;
        }

        public final boolean jM_() {
            a(1, 1);
            return this.f16415m;
        }

        public final boolean jN_() {
            a(1, 2);
            return this.f16416n;
        }

        public final boolean mo989j() {
            a(1, 3);
            return this.f16417o;
        }

        public final boolean mo1007v() {
            a(1, 4);
            return this.f16418p;
        }

        @Nullable
        private MessageModel m19198E() {
            this.f16419q = (MessageModel) super.a(this.f16419q, 13, MessageModel.class);
            return this.f16419q;
        }

        @Nullable
        public final String mo994l() {
            this.f16420r = super.a(this.f16420r, 14);
            return this.f16420r;
        }

        public final boolean mo1008w() {
            a(1, 7);
            return this.f16421s;
        }

        @Nullable
        private OfferDataModel m19199F() {
            this.f16422t = (OfferDataModel) super.a(this.f16422t, 16, OfferDataModel.class);
            return this.f16422t;
        }

        @Nullable
        public final String mo1010y() {
            this.f16423u = super.a(this.f16423u, 17);
            return this.f16423u;
        }

        @Nullable
        private OfferViewDataModel m19200G() {
            this.f16424v = (OfferViewDataModel) super.a(this.f16424v, 18, OfferViewDataModel.class);
            return this.f16424v;
        }

        @Nullable
        private OfferOwnerModel m19201H() {
            this.f16425w = (OfferOwnerModel) super.a(this.f16425w, 19, OfferOwnerModel.class);
            return this.f16425w;
        }

        @Nullable
        private PhotoModel m19202I() {
            this.f16426x = (PhotoModel) super.a(this.f16426x, 20, PhotoModel.class);
            return this.f16426x;
        }

        @Nullable
        public final String mo997o() {
            this.f16427y = super.a(this.f16427y, 21);
            return this.f16427y;
        }

        @Nullable
        public final String mo998p() {
            this.f16428z = super.a(this.f16428z, 22);
            return this.f16428z;
        }

        @Nullable
        private OfferStoryFieldsModel m19203J() {
            this.f16402A = (OfferStoryFieldsModel) super.a(this.f16402A, 23, OfferStoryFieldsModel.class);
            return this.f16402A;
        }

        @Nullable
        private OfferStoryFieldsModel m19204K() {
            this.f16403B = (OfferStoryFieldsModel) super.a(this.f16403B, 24, OfferStoryFieldsModel.class);
            return this.f16403B;
        }

        @Nullable
        public final String mo999q() {
            this.f16404C = super.a(this.f16404C, 25);
            return this.f16404C;
        }

        @Nullable
        public final String mo1000r() {
            this.f16405D = super.a(this.f16405D, 26);
            return this.f16405D;
        }

        @Nullable
        public final String m19209a() {
            return mo1003g();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m19208a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            OfferStoryFieldsModel offerStoryFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19197D() != null) {
                ImageDataModel imageDataModel = (ImageDataModel) graphQLModelMutatingVisitor.b(m19197D());
                if (m19197D() != imageDataModel) {
                    graphQLVisitableModel = (OfferDetailQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16414l = imageDataModel;
                }
            }
            if (m19198E() != null) {
                MessageModel messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m19198E());
                if (m19198E() != messageModel) {
                    graphQLVisitableModel = (OfferDetailQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16419q = messageModel;
                }
            }
            if (m19199F() != null) {
                OfferDataModel offerDataModel = (OfferDataModel) graphQLModelMutatingVisitor.b(m19199F());
                if (m19199F() != offerDataModel) {
                    graphQLVisitableModel = (OfferDetailQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16422t = offerDataModel;
                }
            }
            if (m19200G() != null) {
                OfferViewDataModel offerViewDataModel = (OfferViewDataModel) graphQLModelMutatingVisitor.b(m19200G());
                if (m19200G() != offerViewDataModel) {
                    graphQLVisitableModel = (OfferDetailQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16424v = offerViewDataModel;
                }
            }
            if (m19201H() != null) {
                OfferOwnerModel offerOwnerModel = (OfferOwnerModel) graphQLModelMutatingVisitor.b(m19201H());
                if (m19201H() != offerOwnerModel) {
                    graphQLVisitableModel = (OfferDetailQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16425w = offerOwnerModel;
                }
            }
            if (m19202I() != null) {
                PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m19202I());
                if (m19202I() != photoModel) {
                    graphQLVisitableModel = (OfferDetailQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16426x = photoModel;
                }
            }
            if (m19203J() != null) {
                offerStoryFieldsModel = (OfferStoryFieldsModel) graphQLModelMutatingVisitor.b(m19203J());
                if (m19203J() != offerStoryFieldsModel) {
                    graphQLVisitableModel = (OfferDetailQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16402A = offerStoryFieldsModel;
                }
            }
            if (m19204K() != null) {
                offerStoryFieldsModel = (OfferStoryFieldsModel) graphQLModelMutatingVisitor.b(m19204K());
                if (m19204K() != offerStoryFieldsModel) {
                    graphQLVisitableModel = (OfferDetailQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16403B = offerStoryFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19207a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19196C());
            int b = flatBufferBuilder.b(mo1004s());
            int a2 = flatBufferBuilder.a(mo985b());
            int b2 = flatBufferBuilder.b(mo1003g());
            int a3 = ModelHelper.a(flatBufferBuilder, m19197D());
            int a4 = ModelHelper.a(flatBufferBuilder, m19198E());
            int b3 = flatBufferBuilder.b(mo994l());
            int a5 = ModelHelper.a(flatBufferBuilder, m19199F());
            int b4 = flatBufferBuilder.b(mo1010y());
            int a6 = ModelHelper.a(flatBufferBuilder, m19200G());
            int a7 = ModelHelper.a(flatBufferBuilder, m19201H());
            int a8 = ModelHelper.a(flatBufferBuilder, m19202I());
            int b5 = flatBufferBuilder.b(mo997o());
            int b6 = flatBufferBuilder.b(mo998p());
            int a9 = ModelHelper.a(flatBufferBuilder, m19203J());
            int a10 = ModelHelper.a(flatBufferBuilder, m19204K());
            int b7 = flatBufferBuilder.b(mo999q());
            int b8 = flatBufferBuilder.b(mo1000r());
            flatBufferBuilder.c(27);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f16408f, 0);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.a(4, this.f16410h, 0);
            flatBufferBuilder.a(5, this.f16411i, 0);
            flatBufferBuilder.a(6, this.f16412j);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, a3);
            flatBufferBuilder.a(9, this.f16415m);
            flatBufferBuilder.a(10, this.f16416n);
            flatBufferBuilder.a(11, this.f16417o);
            flatBufferBuilder.a(12, this.f16418p);
            flatBufferBuilder.b(13, a4);
            flatBufferBuilder.b(14, b3);
            flatBufferBuilder.a(15, this.f16421s);
            flatBufferBuilder.b(16, a5);
            flatBufferBuilder.b(17, b4);
            flatBufferBuilder.b(18, a6);
            flatBufferBuilder.b(19, a7);
            flatBufferBuilder.b(20, a8);
            flatBufferBuilder.b(21, b5);
            flatBufferBuilder.b(22, b6);
            flatBufferBuilder.b(23, a9);
            flatBufferBuilder.b(24, a10);
            flatBufferBuilder.b(25, b7);
            flatBufferBuilder.b(26, b8);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19210a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f16408f = mutableFlatBuffer.a(i, 2, 0);
            this.f16410h = mutableFlatBuffer.a(i, 4, 0);
            this.f16411i = mutableFlatBuffer.a(i, 5, 0);
            this.f16412j = mutableFlatBuffer.a(i, 6);
            this.f16415m = mutableFlatBuffer.a(i, 9);
            this.f16416n = mutableFlatBuffer.a(i, 10);
            this.f16417o = mutableFlatBuffer.a(i, 11);
            this.f16418p = mutableFlatBuffer.a(i, 12);
            this.f16421s = mutableFlatBuffer.a(i, 15);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -901674221)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class OfferOwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f16433d;
        @Nullable
        private String f16434e;
        @Nullable
        private String f16435f;
        @Nullable
        private ImageDataModel f16436g;

        /* compiled from: current_location_city */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f16429a;
            @Nullable
            public String f16430b;
            @Nullable
            public String f16431c;
            @Nullable
            public ImageDataModel f16432d;
        }

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferOwnerModel.class, new Deserializer());
            }

            public Object m19234a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(OfferOwnerParser.m19406a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object offerOwnerModel = new OfferOwnerModel();
                ((BaseModel) offerOwnerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (offerOwnerModel instanceof Postprocessable) {
                    return ((Postprocessable) offerOwnerModel).a();
                }
                return offerOwnerModel;
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<OfferOwnerModel> {
            public final void m19235a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                OfferOwnerModel offerOwnerModel = (OfferOwnerModel) obj;
                if (offerOwnerModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerOwnerModel.m19238a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerOwnerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                OfferOwnerParser.m19407a(offerOwnerModel.w_(), offerOwnerModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(OfferOwnerModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ImageDataModel jR_() {
            return m19237j();
        }

        public OfferOwnerModel() {
            super(4);
        }

        public OfferOwnerModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m19241a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19242a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType m19243b() {
            if (this.b != null && this.f16433d == null) {
                this.f16433d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f16433d;
        }

        @Nullable
        public final String m19244c() {
            this.f16434e = super.a(this.f16434e, 1);
            return this.f16434e;
        }

        @Nullable
        public final String m19245d() {
            this.f16435f = super.a(this.f16435f, 2);
            return this.f16435f;
        }

        @Nullable
        private ImageDataModel m19237j() {
            this.f16436g = (ImageDataModel) super.a(this.f16436g, 3, ImageDataModel.class);
            return this.f16436g;
        }

        public static OfferOwnerModel m19236a(OfferOwnerModel offerOwnerModel) {
            if (offerOwnerModel == null) {
                return null;
            }
            if (offerOwnerModel instanceof OfferOwnerModel) {
                return offerOwnerModel;
            }
            Builder builder = new Builder();
            builder.f16429a = offerOwnerModel.m19243b();
            builder.f16430b = offerOwnerModel.m19244c();
            builder.f16431c = offerOwnerModel.m19245d();
            builder.f16432d = ImageDataModel.m19148a(offerOwnerModel.jR_());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f16429a);
            int b = flatBufferBuilder.b(builder.f16430b);
            int b2 = flatBufferBuilder.b(builder.f16431c);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f16432d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new OfferOwnerModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m19240a() {
            return m19244c();
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m19239a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19237j() != null) {
                ImageDataModel imageDataModel = (ImageDataModel) graphQLModelMutatingVisitor.b(m19237j());
                if (m19237j() != imageDataModel) {
                    graphQLVisitableModel = (OfferOwnerModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16436g = imageDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19238a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19243b());
            int b = flatBufferBuilder.b(m19244c());
            int b2 = flatBufferBuilder.b(m19245d());
            int a2 = ModelHelper.a(flatBufferBuilder, m19237j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 521032814)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class OfferStoryAttachmentFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MediaModel f16443d;
        @Nullable
        private String f16444e;

        /* compiled from: current_location_city */
        public final class Builder {
            @Nullable
            public MediaModel f16437a;
            @Nullable
            public String f16438b;
        }

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferStoryAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m19246a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(OfferStoryAttachmentFieldsParser.m19410b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object offerStoryAttachmentFieldsModel = new OfferStoryAttachmentFieldsModel();
                ((BaseModel) offerStoryAttachmentFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (offerStoryAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) offerStoryAttachmentFieldsModel).a();
                }
                return offerStoryAttachmentFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1208800293)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: current_location_city */
        public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f16441d;
            @Nullable
            private ImageDataModel f16442e;

            /* compiled from: current_location_city */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f16439a;
                @Nullable
                public ImageDataModel f16440b;
            }

            /* compiled from: current_location_city */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                }

                public Object m19247a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaParser.m19408a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaModel = new MediaModel();
                    ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaModel).a();
                    }
                    return mediaModel;
                }
            }

            /* compiled from: current_location_city */
            public class Serializer extends JsonSerializer<MediaModel> {
                public final void m19248a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaModel mediaModel = (MediaModel) obj;
                    if (mediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaModel.m19251a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaParser.m19409a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ImageDataModel m19254b() {
                return m19250j();
            }

            public MediaModel() {
                super(2);
            }

            public MediaModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType m19252a() {
                if (this.b != null && this.f16441d == null) {
                    this.f16441d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f16441d;
            }

            @Nullable
            private ImageDataModel m19250j() {
                this.f16442e = (ImageDataModel) super.a(this.f16442e, 1, ImageDataModel.class);
                return this.f16442e;
            }

            public static MediaModel m19249a(MediaModel mediaModel) {
                if (mediaModel == null) {
                    return null;
                }
                if (mediaModel instanceof MediaModel) {
                    return mediaModel;
                }
                Builder builder = new Builder();
                builder.f16439a = mediaModel.m19252a();
                builder.f16440b = ImageDataModel.m19148a(mediaModel.m19254b());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f16439a);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f16440b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MediaModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 74219460;
            }

            public final GraphQLVisitableModel m19253a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19250j() != null) {
                    ImageDataModel imageDataModel = (ImageDataModel) graphQLModelMutatingVisitor.b(m19250j());
                    if (m19250j() != imageDataModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16442e = imageDataModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19251a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19252a());
                int a2 = ModelHelper.a(flatBufferBuilder, m19250j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<OfferStoryAttachmentFieldsModel> {
            public final void m19255a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                OfferStoryAttachmentFieldsModel offerStoryAttachmentFieldsModel = (OfferStoryAttachmentFieldsModel) obj;
                if (offerStoryAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerStoryAttachmentFieldsModel.m19258a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerStoryAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                OfferStoryAttachmentFieldsParser.m19411b(offerStoryAttachmentFieldsModel.w_(), offerStoryAttachmentFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(OfferStoryAttachmentFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MediaModel m19260a() {
            return m19257j();
        }

        public OfferStoryAttachmentFieldsModel() {
            super(2);
        }

        public OfferStoryAttachmentFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private MediaModel m19257j() {
            this.f16443d = (MediaModel) super.a(this.f16443d, 0, MediaModel.class);
            return this.f16443d;
        }

        @Nullable
        public final String m19261b() {
            this.f16444e = super.a(this.f16444e, 1);
            return this.f16444e;
        }

        public static OfferStoryAttachmentFieldsModel m19256a(OfferStoryAttachmentFieldsModel offerStoryAttachmentFieldsModel) {
            if (offerStoryAttachmentFieldsModel == null) {
                return null;
            }
            if (offerStoryAttachmentFieldsModel instanceof OfferStoryAttachmentFieldsModel) {
                return offerStoryAttachmentFieldsModel;
            }
            Builder builder = new Builder();
            builder.f16437a = MediaModel.m19249a(offerStoryAttachmentFieldsModel.m19260a());
            builder.f16438b = offerStoryAttachmentFieldsModel.m19261b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f16437a);
            int b = flatBufferBuilder.b(builder.f16438b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new OfferStoryAttachmentFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1267730472;
        }

        public final GraphQLVisitableModel m19259a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19257j() != null) {
                MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m19257j());
                if (m19257j() != mediaModel) {
                    graphQLVisitableModel = (OfferStoryAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16443d = mediaModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19258a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19257j());
            int b = flatBufferBuilder.b(m19261b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1479610716)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class OfferStoryFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private List<OfferStoryAttachmentFieldsModel> f16452d;
        @Nullable
        private String f16453e;
        @Nullable
        private ShareableModel f16454f;

        /* compiled from: current_location_city */
        public final class Builder {
            @Nullable
            public ImmutableList<OfferStoryAttachmentFieldsModel> f16445a;
            @Nullable
            public String f16446b;
            @Nullable
            public ShareableModel f16447c;
        }

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferStoryFieldsModel.class, new Deserializer());
            }

            public Object m19262a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(OfferStoryFieldsParser.m19414a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object offerStoryFieldsModel = new OfferStoryFieldsModel();
                ((BaseModel) offerStoryFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (offerStoryFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) offerStoryFieldsModel).a();
                }
                return offerStoryFieldsModel;
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<OfferStoryFieldsModel> {
            public final void m19263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                OfferStoryFieldsModel offerStoryFieldsModel = (OfferStoryFieldsModel) obj;
                if (offerStoryFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerStoryFieldsModel.m19274a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerStoryFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                OfferStoryFieldsParser.m19415a(offerStoryFieldsModel.w_(), offerStoryFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(OfferStoryFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: current_location_city */
        public final class ShareableModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f16450d;
            @Nullable
            private String f16451e;

            /* compiled from: current_location_city */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f16448a;
                @Nullable
                public String f16449b;
            }

            /* compiled from: current_location_city */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ShareableModel.class, new Deserializer());
                }

                public Object m19264a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ShareableParser.m19412a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object shareableModel = new ShareableModel();
                    ((BaseModel) shareableModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (shareableModel instanceof Postprocessable) {
                        return ((Postprocessable) shareableModel).a();
                    }
                    return shareableModel;
                }
            }

            /* compiled from: current_location_city */
            public class Serializer extends JsonSerializer<ShareableModel> {
                public final void m19265a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ShareableModel shareableModel = (ShareableModel) obj;
                    if (shareableModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(shareableModel.m19267a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        shareableModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ShareableParser.m19413a(shareableModel.w_(), shareableModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ShareableModel.class, new Serializer());
                }
            }

            public ShareableModel() {
                super(2);
            }

            public ShareableModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType m19270b() {
                if (this.b != null && this.f16450d == null) {
                    this.f16450d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f16450d;
            }

            @Nullable
            public final String m19271c() {
                this.f16451e = super.a(this.f16451e, 1);
                return this.f16451e;
            }

            public static ShareableModel m19266a(ShareableModel shareableModel) {
                if (shareableModel == null) {
                    return null;
                }
                if (shareableModel instanceof ShareableModel) {
                    return shareableModel;
                }
                Builder builder = new Builder();
                builder.f16448a = shareableModel.m19270b();
                builder.f16449b = shareableModel.m19271c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f16448a);
                int b = flatBufferBuilder.b(builder.f16449b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ShareableModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m19269a() {
                return m19271c();
            }

            public final int jK_() {
                return 2080559107;
            }

            public final GraphQLVisitableModel m19268a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19267a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19270b());
                int b = flatBufferBuilder.b(m19271c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ ShareableModel m19281d() {
            return m19273j();
        }

        public OfferStoryFieldsModel() {
            super(3);
        }

        public OfferStoryFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m19277a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19278a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<OfferStoryAttachmentFieldsModel> m19279b() {
            this.f16452d = super.a(this.f16452d, 0, OfferStoryAttachmentFieldsModel.class);
            return (ImmutableList) this.f16452d;
        }

        @Nullable
        public final String m19280c() {
            this.f16453e = super.a(this.f16453e, 1);
            return this.f16453e;
        }

        @Nullable
        private ShareableModel m19273j() {
            this.f16454f = (ShareableModel) super.a(this.f16454f, 2, ShareableModel.class);
            return this.f16454f;
        }

        public static OfferStoryFieldsModel m19272a(OfferStoryFieldsModel offerStoryFieldsModel) {
            if (offerStoryFieldsModel == null) {
                return null;
            }
            if (offerStoryFieldsModel instanceof OfferStoryFieldsModel) {
                return offerStoryFieldsModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < offerStoryFieldsModel.m19279b().size(); i++) {
                builder2.c(OfferStoryAttachmentFieldsModel.m19256a((OfferStoryAttachmentFieldsModel) offerStoryFieldsModel.m19279b().get(i)));
            }
            builder.f16445a = builder2.b();
            builder.f16446b = offerStoryFieldsModel.m19280c();
            builder.f16447c = ShareableModel.m19266a(offerStoryFieldsModel.m19281d());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f16445a);
            int b = flatBufferBuilder.b(builder.f16446b);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f16447c);
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new OfferStoryFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m19276a() {
            return m19280c();
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m19275a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            ShareableModel shareableModel;
            h();
            if (m19279b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m19279b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    OfferStoryFieldsModel offerStoryFieldsModel = (OfferStoryFieldsModel) ModelHelper.a(null, this);
                    offerStoryFieldsModel.f16452d = a.b();
                    graphQLVisitableModel = offerStoryFieldsModel;
                    if (m19273j() != null) {
                        shareableModel = (ShareableModel) graphQLModelMutatingVisitor.b(m19273j());
                        if (m19273j() != shareableModel) {
                            graphQLVisitableModel = (OfferStoryFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16454f = shareableModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m19273j() != null) {
                shareableModel = (ShareableModel) graphQLModelMutatingVisitor.b(m19273j());
                if (m19273j() != shareableModel) {
                    graphQLVisitableModel = (OfferStoryFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16454f = shareableModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m19274a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19279b());
            int b = flatBufferBuilder.b(m19280c());
            int a2 = ModelHelper.a(flatBufferBuilder, m19273j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2010256447)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class OfferViewDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f16459d;
        @Nullable
        private OfferDataModel f16460e;
        @Nullable
        private List<PhotoDataModel> f16461f;
        @Nullable
        private List<VideoDataModel> f16462g;

        /* compiled from: current_location_city */
        public final class Builder {
            @Nullable
            public String f16455a;
            @Nullable
            public OfferDataModel f16456b;
            @Nullable
            public ImmutableList<PhotoDataModel> f16457c;
            @Nullable
            public ImmutableList<VideoDataModel> f16458d;
        }

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferViewDataModel.class, new Deserializer());
            }

            public Object m19282a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(OfferViewDataParser.m19416a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object offerViewDataModel = new OfferViewDataModel();
                ((BaseModel) offerViewDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (offerViewDataModel instanceof Postprocessable) {
                    return ((Postprocessable) offerViewDataModel).a();
                }
                return offerViewDataModel;
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<OfferViewDataModel> {
            public final void m19283a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                OfferViewDataModel offerViewDataModel = (OfferViewDataModel) obj;
                if (offerViewDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerViewDataModel.m19286a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerViewDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                OfferViewDataParser.m19417a(offerViewDataModel.w_(), offerViewDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(OfferViewDataModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ OfferDataModel m19290c() {
            return m19285j();
        }

        public OfferViewDataModel() {
            super(4);
        }

        public OfferViewDataModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m19289b() {
            this.f16459d = super.a(this.f16459d, 0);
            return this.f16459d;
        }

        @Nullable
        private OfferDataModel m19285j() {
            this.f16460e = (OfferDataModel) super.a(this.f16460e, 1, OfferDataModel.class);
            return this.f16460e;
        }

        @Nonnull
        public final ImmutableList<PhotoDataModel> m19291d() {
            this.f16461f = super.a(this.f16461f, 2, PhotoDataModel.class);
            return (ImmutableList) this.f16461f;
        }

        @Nonnull
        public final ImmutableList<VideoDataModel> jS_() {
            this.f16462g = super.a(this.f16462g, 3, VideoDataModel.class);
            return (ImmutableList) this.f16462g;
        }

        public static OfferViewDataModel m19284a(OfferViewDataModel offerViewDataModel) {
            int i = 0;
            if (offerViewDataModel == null) {
                return null;
            }
            if (offerViewDataModel instanceof OfferViewDataModel) {
                return offerViewDataModel;
            }
            Builder builder = new Builder();
            builder.f16455a = offerViewDataModel.m19289b();
            builder.f16456b = OfferDataModel.m19180a(offerViewDataModel.m19290c());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i2 = 0; i2 < offerViewDataModel.m19291d().size(); i2++) {
                builder2.c(PhotoDataModel.m19346a((PhotoDataModel) offerViewDataModel.m19291d().get(i2)));
            }
            builder.f16457c = builder2.b();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            while (i < offerViewDataModel.jS_().size()) {
                builder3.c(VideoDataModel.m19373a((VideoDataModel) offerViewDataModel.jS_().get(i)));
                i++;
            }
            builder.f16458d = builder3.b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f16455a);
            int a = ModelHelper.a(flatBufferBuilder, builder.f16456b);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f16457c);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f16458d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new OfferViewDataModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m19288a() {
            return m19289b();
        }

        public final int jK_() {
            return -346399999;
        }

        public final GraphQLVisitableModel m19287a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            com.google.common.collect.ImmutableList.Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19285j() != null) {
                OfferDataModel offerDataModel = (OfferDataModel) graphQLModelMutatingVisitor.b(m19285j());
                if (m19285j() != offerDataModel) {
                    graphQLVisitableModel = (OfferViewDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16460e = offerDataModel;
                }
            }
            if (m19291d() != null) {
                a = ModelHelper.a(m19291d(), graphQLModelMutatingVisitor);
                if (a != null) {
                    OfferViewDataModel offerViewDataModel = (OfferViewDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    offerViewDataModel.f16461f = a.b();
                    graphQLVisitableModel = offerViewDataModel;
                }
            }
            if (jS_() != null) {
                a = ModelHelper.a(jS_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    offerViewDataModel = (OfferViewDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    offerViewDataModel.f16462g = a.b();
                    graphQLVisitableModel = offerViewDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19286a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m19289b());
            int a = ModelHelper.a(flatBufferBuilder, m19285j());
            int a2 = ModelHelper.a(flatBufferBuilder, m19291d());
            int a3 = ModelHelper.a(flatBufferBuilder, jS_());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -246252717)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class OffersWalletQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ActorModel f16479d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -475893516)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: current_location_city */
        public final class ActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f16475d;
            @Nullable
            private ClaimedCouponsModel f16476e;
            @Nullable
            private ClaimedOffersModel f16477f;
            @Nullable
            private String f16478g;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1579609008)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: current_location_city */
            public final class ClaimedCouponsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f16467d;
                @Nullable
                private PageInfoModel f16468e;

                /* compiled from: current_location_city */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.class;
                        r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m19292a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedCouponsParser.m19422a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -715334568)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: current_location_city */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private CouponDataModel f16463d;

                    /* compiled from: current_location_city */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.class;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel$EdgesModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m19293a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r10 = this;
                            r8 = 1;
                            r6 = 0;
                            r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r4.<init>(r5);
                            r5 = com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedCouponsParser.EdgesParser.m19418b(r11, r4);
                            r4.d(r5);
                            r4 = r4.e();
                            r5 = java.nio.ByteBuffer.wrap(r4);
                            r4 = 0;
                            r5.position(r4);
                            r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r7 = r6;
                            r9 = r6;
                            r4.<init>(r5, r6, r7, r8, r9);
                            r5 = 4;
                            r6 = java.lang.Boolean.valueOf(r8);
                            r4.a(r5, r6);
                            r2 = r4;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel$EdgesModel;
                            r1.<init>();
                            r4 = r2.a;
                            r0 = r4;
                            r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r0 = r1;
                            r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                            r0.a(r2, r3, r11);
                            r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                            if (r0 == 0) goto L_0x0048;
                        L_0x0042:
                            r1 = (com.facebook.common.json.Postprocessable) r1;
                            r1 = r1.a();
                        L_0x0048:
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: current_location_city */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m19294a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r7 = this;
                            r8 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m19295a(r0);
                            r0.d(r1);
                            r0 = r0.e();
                            r1 = java.nio.ByteBuffer.wrap(r0);
                            r0 = 0;
                            r1.position(r0);
                            r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r4 = 1;
                            r3 = r2;
                            r5 = r2;
                            r0.<init>(r1, r2, r3, r4, r5);
                            r6 = r0.a;
                            r1 = r6;
                            r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                            r8.a(r0, r1);
                        L_0x0035:
                            r0 = r8.w_();
                            r1 = r8.u_();
                            com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedCouponsParser.EdgesParser.m19419b(r0, r1, r9, r10);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                        }

                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.class;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel$EdgesModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.Serializer.<clinit>():void");
                        }
                    }

                    public EdgesModel() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 1;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    public final com.facebook.offers.graphql.OfferQueriesModels.CouponDataModel m19297a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r0 = r3.f16463d;
                        r1 = 0;
                        r2 = com.facebook.offers.graphql.OfferQueriesModels.CouponDataModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.offers.graphql.OfferQueriesModels.CouponDataModel) r0;
                        r3.f16463d = r0;
                        r0 = r3.f16463d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.a():com.facebook.offers.graphql.OfferQueriesModels$CouponDataModel");
                    }

                    public final int jK_() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = -200132379; // 0xfffffffff41238e5 float:-4.633968E31 double:NaN;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m19296a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r1 = 0;
                        r3.h();
                        r0 = r3.m19297a();
                        if (r0 == 0) goto L_0x0022;
                    L_0x000a:
                        r0 = r3.m19297a();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.offers.graphql.OfferQueriesModels.CouponDataModel) r0;
                        r2 = r3.m19297a();
                        if (r2 == r0) goto L_0x0022;
                    L_0x001a:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel) r1;
                        r1.f16463d = r0;
                    L_0x0022:
                        r3.i();
                        if (r1 != 0) goto L_0x0028;
                    L_0x0027:
                        return r3;
                    L_0x0028:
                        r3 = r1;
                        goto L_0x0027;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m19295a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r2.h();
                        r0 = r2.m19297a();
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                        r1 = 1;
                        r3.c(r1);
                        r1 = 0;
                        r3.b(r1, r0);
                        r2.i();
                        r0 = r3.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1638106720)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: current_location_city */
                public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f16464d;
                    private boolean f16465e;
                    @Nullable
                    private String f16466f;

                    /* compiled from: current_location_city */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.class;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel$PageInfoModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m19298a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r10 = this;
                            r8 = 1;
                            r6 = 0;
                            r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r4.<init>(r5);
                            r5 = com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedCouponsParser.PageInfoParser.m19420a(r11, r4);
                            r4.d(r5);
                            r4 = r4.e();
                            r5 = java.nio.ByteBuffer.wrap(r4);
                            r4 = 0;
                            r5.position(r4);
                            r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r7 = r6;
                            r9 = r6;
                            r4.<init>(r5, r6, r7, r8, r9);
                            r5 = 4;
                            r6 = java.lang.Boolean.valueOf(r8);
                            r4.a(r5, r6);
                            r2 = r4;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel$PageInfoModel;
                            r1.<init>();
                            r4 = r2.a;
                            r0 = r4;
                            r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r0 = r1;
                            r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                            r0.a(r2, r3, r11);
                            r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                            if (r0 == 0) goto L_0x0048;
                        L_0x0042:
                            r1 = (com.facebook.common.json.Postprocessable) r1;
                            r1 = r1.a();
                        L_0x0048:
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: current_location_city */
                    public class Serializer extends JsonSerializer<PageInfoModel> {
                        public final void m19299a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r7 = this;
                            r8 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m19302a(r0);
                            r0.d(r1);
                            r0 = r0.e();
                            r1 = java.nio.ByteBuffer.wrap(r0);
                            r0 = 0;
                            r1.position(r0);
                            r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r4 = 1;
                            r3 = r2;
                            r5 = r2;
                            r0.<init>(r1, r2, r3, r4, r5);
                            r6 = r0.a;
                            r1 = r6;
                            r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                            r8.a(r0, r1);
                        L_0x0035:
                            r0 = r8.w_();
                            r1 = r8.u_();
                            com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedCouponsParser.PageInfoParser.m19421a(r0, r1, r9);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                        }

                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.class;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel$PageInfoModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.Serializer.<clinit>():void");
                        }
                    }

                    public PageInfoModel() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 3;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m19300a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = r2.f16464d;
                        r1 = 0;
                        r0 = super.a(r0, r1);
                        r2.f16464d = r0;
                        r0 = r2.f16464d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.a():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m19301j() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = r2.f16466f;
                        r1 = 2;
                        r0 = super.a(r0, r1);
                        r2.f16466f = r0;
                        r0 = r2.f16466f;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.j():java.lang.String");
                    }

                    public final int jK_() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 923779069; // 0x370fbffd float:8.568165E-6 double:4.564075023E-315;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m19303a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.h();
                        r0.i();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m19302a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r3.h();
                        r0 = r3.m19300a();
                        r0 = r4.b(r0);
                        r1 = r3.m19301j();
                        r1 = r4.b(r1);
                        r2 = 3;
                        r4.c(r2);
                        r2 = 0;
                        r4.b(r2, r0);
                        r0 = 1;
                        r2 = r3.f16465e;
                        r4.a(r0, r2);
                        r0 = 2;
                        r4.b(r0, r1);
                        r3.i();
                        r0 = r4.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }

                    public final void m19304a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        super.a(r2, r3, r4);
                        r0 = 1;
                        r0 = r2.a(r3, r0);
                        r1.f16465e = r0;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                    }
                }

                /* compiled from: current_location_city */
                public class Serializer extends JsonSerializer<ClaimedCouponsModel> {
                    public final void m19305a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m19307a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedCouponsParser.m19423a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.class;
                        r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.Serializer.<clinit>():void");
                    }
                }

                public ClaimedCouponsModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 2;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.<init>():void");
                }

                @javax.annotation.Nonnull
                public final com.google.common.collect.ImmutableList<com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel> m19309a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f16467d;
                    r1 = 0;
                    r2 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.EdgesModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f16467d = r0;
                    r0 = r3.f16467d;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.a():com.google.common.collect.ImmutableList<com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel$EdgesModel>");
                }

                @javax.annotation.Nullable
                private com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel m19306j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f16468e;
                    r1 = 1;
                    r2 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel) r0;
                    r3.f16468e = r0;
                    r0 = r3.f16468e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.j():com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel$PageInfoModel");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = -1457763322; // 0xffffffffa91c4c06 float:-3.4704898E-14 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m19308a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = 0;
                    r3.h();
                    r1 = r3.m19309a();
                    if (r1 == 0) goto L_0x0047;
                L_0x000a:
                    r1 = r3.m19309a();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                    if (r1 == 0) goto L_0x0047;
                L_0x0014:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                    r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel) r0;
                    r1 = r1.b();
                    r0.f16467d = r1;
                    r1 = r0;
                L_0x0021:
                    r0 = r3.m19306j();
                    if (r0 == 0) goto L_0x003f;
                L_0x0027:
                    r0 = r3.m19306j();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.PageInfoModel) r0;
                    r2 = r3.m19306j();
                    if (r2 == r0) goto L_0x003f;
                L_0x0037:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel) r1;
                    r1.f16468e = r0;
                L_0x003f:
                    r3.i();
                    if (r1 != 0) goto L_0x0045;
                L_0x0044:
                    return r3;
                L_0x0045:
                    r3 = r1;
                    goto L_0x0044;
                L_0x0047:
                    r1 = r0;
                    goto L_0x0021;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m19307a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r3.h();
                    r0 = r3.m19309a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                    r1 = r3.m19306j();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r1);
                    r2 = 2;
                    r4.c(r2);
                    r2 = 0;
                    r4.b(r2, r0);
                    r0 = 1;
                    r4.b(r0, r1);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -931596907)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: current_location_city */
            public final class ClaimedOffersModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f16473d;
                @Nullable
                private PageInfoModel f16474e;

                /* compiled from: current_location_city */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.class;
                        r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m19310a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedOffersParser.m19428a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -2031637149)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: current_location_city */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private OfferClaimDataModel f16469d;

                    /* compiled from: current_location_city */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.class;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel$EdgesModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m19311a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r10 = this;
                            r8 = 1;
                            r6 = 0;
                            r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r4.<init>(r5);
                            r5 = com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedOffersParser.EdgesParser.m19424b(r11, r4);
                            r4.d(r5);
                            r4 = r4.e();
                            r5 = java.nio.ByteBuffer.wrap(r4);
                            r4 = 0;
                            r5.position(r4);
                            r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r7 = r6;
                            r9 = r6;
                            r4.<init>(r5, r6, r7, r8, r9);
                            r5 = 4;
                            r6 = java.lang.Boolean.valueOf(r8);
                            r4.a(r5, r6);
                            r2 = r4;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel$EdgesModel;
                            r1.<init>();
                            r4 = r2.a;
                            r0 = r4;
                            r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r0 = r1;
                            r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                            r0.a(r2, r3, r11);
                            r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                            if (r0 == 0) goto L_0x0048;
                        L_0x0042:
                            r1 = (com.facebook.common.json.Postprocessable) r1;
                            r1 = r1.a();
                        L_0x0048:
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: current_location_city */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m19312a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r7 = this;
                            r8 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m19313a(r0);
                            r0.d(r1);
                            r0 = r0.e();
                            r1 = java.nio.ByteBuffer.wrap(r0);
                            r0 = 0;
                            r1.position(r0);
                            r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r4 = 1;
                            r3 = r2;
                            r5 = r2;
                            r0.<init>(r1, r2, r3, r4, r5);
                            r6 = r0.a;
                            r1 = r6;
                            r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                            r8.a(r0, r1);
                        L_0x0035:
                            r0 = r8.w_();
                            r1 = r8.u_();
                            com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedOffersParser.EdgesParser.m19425b(r0, r1, r9, r10);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                        }

                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.class;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel$EdgesModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.Serializer.<clinit>():void");
                        }
                    }

                    public EdgesModel() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 1;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    public final com.facebook.offers.graphql.OfferQueriesModels.OfferClaimDataModel m19315a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r0 = r3.f16469d;
                        r1 = 0;
                        r2 = com.facebook.offers.graphql.OfferQueriesModels.OfferClaimDataModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.offers.graphql.OfferQueriesModels.OfferClaimDataModel) r0;
                        r3.f16469d = r0;
                        r0 = r3.f16469d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.a():com.facebook.offers.graphql.OfferQueriesModels$OfferClaimDataModel");
                    }

                    public final int jK_() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 1083729445; // 0x40986625 float:4.762469 double:5.35433488E-315;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m19314a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r1 = 0;
                        r3.h();
                        r0 = r3.m19315a();
                        if (r0 == 0) goto L_0x0022;
                    L_0x000a:
                        r0 = r3.m19315a();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.offers.graphql.OfferQueriesModels.OfferClaimDataModel) r0;
                        r2 = r3.m19315a();
                        if (r2 == r0) goto L_0x0022;
                    L_0x001a:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel) r1;
                        r1.f16469d = r0;
                    L_0x0022:
                        r3.i();
                        if (r1 != 0) goto L_0x0028;
                    L_0x0027:
                        return r3;
                    L_0x0028:
                        r3 = r1;
                        goto L_0x0027;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m19313a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r2.h();
                        r0 = r2.m19315a();
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                        r1 = 1;
                        r3.c(r1);
                        r1 = 0;
                        r3.b(r1, r0);
                        r2.i();
                        r0 = r3.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1638106720)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: current_location_city */
                public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f16470d;
                    private boolean f16471e;
                    @Nullable
                    private String f16472f;

                    /* compiled from: current_location_city */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.class;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel$PageInfoModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m19316a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r10 = this;
                            r8 = 1;
                            r6 = 0;
                            r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r4.<init>(r5);
                            r5 = com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedOffersParser.PageInfoParser.m19426a(r11, r4);
                            r4.d(r5);
                            r4 = r4.e();
                            r5 = java.nio.ByteBuffer.wrap(r4);
                            r4 = 0;
                            r5.position(r4);
                            r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r7 = r6;
                            r9 = r6;
                            r4.<init>(r5, r6, r7, r8, r9);
                            r5 = 4;
                            r6 = java.lang.Boolean.valueOf(r8);
                            r4.a(r5, r6);
                            r2 = r4;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel$PageInfoModel;
                            r1.<init>();
                            r4 = r2.a;
                            r0 = r4;
                            r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r0 = r1;
                            r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                            r0.a(r2, r3, r11);
                            r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                            if (r0 == 0) goto L_0x0048;
                        L_0x0042:
                            r1 = (com.facebook.common.json.Postprocessable) r1;
                            r1 = r1.a();
                        L_0x0048:
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: current_location_city */
                    public class Serializer extends JsonSerializer<PageInfoModel> {
                        public final void m19317a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r7 = this;
                            r8 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m19320a(r0);
                            r0.d(r1);
                            r0 = r0.e();
                            r1 = java.nio.ByteBuffer.wrap(r0);
                            r0 = 0;
                            r1.position(r0);
                            r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r4 = 1;
                            r3 = r2;
                            r5 = r2;
                            r0.<init>(r1, r2, r3, r4, r5);
                            r6 = r0.a;
                            r1 = r6;
                            r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                            r8.a(r0, r1);
                        L_0x0035:
                            r0 = r8.w_();
                            r1 = r8.u_();
                            com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedOffersParser.PageInfoParser.m19427a(r0, r1, r9);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                        }

                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.class;
                            r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel$PageInfoModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.Serializer.<clinit>():void");
                        }
                    }

                    public PageInfoModel() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 3;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m19318a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = r2.f16470d;
                        r1 = 0;
                        r0 = super.a(r0, r1);
                        r2.f16470d = r0;
                        r0 = r2.f16470d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.a():java.lang.String");
                    }

                    @javax.annotation.Nullable
                    private java.lang.String m19319j() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r0 = r2.f16472f;
                        r1 = 2;
                        r0 = super.a(r0, r1);
                        r2.f16472f = r0;
                        r0 = r2.f16472f;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.j():java.lang.String");
                    }

                    public final int jK_() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 923779069; // 0x370fbffd float:8.568165E-6 double:4.564075023E-315;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m19321a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.h();
                        r0.i();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m19320a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r3.h();
                        r0 = r3.m19318a();
                        r0 = r4.b(r0);
                        r1 = r3.m19319j();
                        r1 = r4.b(r1);
                        r2 = 3;
                        r4.c(r2);
                        r2 = 0;
                        r4.b(r2, r0);
                        r0 = 1;
                        r2 = r3.f16471e;
                        r4.a(r0, r2);
                        r0 = 2;
                        r4.b(r0, r1);
                        r3.i();
                        r0 = r4.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }

                    public final void m19322a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        super.a(r2, r3, r4);
                        r0 = 1;
                        r0 = r2.a(r3, r0);
                        r1.f16471e = r0;
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                    }
                }

                /* compiled from: current_location_city */
                public class Serializer extends JsonSerializer<ClaimedOffersModel> {
                    public final void m19323a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m19325a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.ClaimedOffersParser.m19429a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.class;
                        r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.Serializer.<clinit>():void");
                    }
                }

                public ClaimedOffersModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 2;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.<init>():void");
                }

                @javax.annotation.Nonnull
                public final com.google.common.collect.ImmutableList<com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel> m19327a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f16473d;
                    r1 = 0;
                    r2 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f16473d = r0;
                    r0 = r3.f16473d;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.a():com.google.common.collect.ImmutableList<com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel$EdgesModel>");
                }

                @javax.annotation.Nullable
                private com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel m19324j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f16474e;
                    r1 = 1;
                    r2 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel) r0;
                    r3.f16474e = r0;
                    r0 = r3.f16474e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.j():com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel$PageInfoModel");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = -1424258746; // 0xffffffffab1b8946 float:-5.5257567E-13 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m19326a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = 0;
                    r3.h();
                    r1 = r3.m19327a();
                    if (r1 == 0) goto L_0x0047;
                L_0x000a:
                    r1 = r3.m19327a();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                    if (r1 == 0) goto L_0x0047;
                L_0x0014:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                    r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel) r0;
                    r1 = r1.b();
                    r0.f16473d = r1;
                    r1 = r0;
                L_0x0021:
                    r0 = r3.m19324j();
                    if (r0 == 0) goto L_0x003f;
                L_0x0027:
                    r0 = r3.m19324j();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.PageInfoModel) r0;
                    r2 = r3.m19324j();
                    if (r2 == r0) goto L_0x003f;
                L_0x0037:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel) r1;
                    r1.f16474e = r0;
                L_0x003f:
                    r3.i();
                    if (r1 != 0) goto L_0x0045;
                L_0x0044:
                    return r3;
                L_0x0045:
                    r3 = r1;
                    goto L_0x0044;
                L_0x0047:
                    r1 = r0;
                    goto L_0x0021;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m19325a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r3.h();
                    r0 = r3.m19327a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                    r1 = r3.m19324j();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r1);
                    r2 = 2;
                    r4.c(r2);
                    r2 = 0;
                    r4.b(r2, r0);
                    r0 = 1;
                    r4.b(r0, r1);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: current_location_city */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.class;
                    r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m19328a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.m19430a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: current_location_city */
            public class Serializer extends JsonSerializer<ActorModel> {
                public final void m19329a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m19332a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.m19431a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.class;
                    r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.Serializer.<clinit>():void");
                }
            }

            public ActorModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 4;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.<init>():void");
            }

            public final void m19335a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r2.a();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
            }

            public final void m19336a(java.lang.String r1, java.lang.Object r2, boolean r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.a(java.lang.String, java.lang.Object, boolean):void");
            }

            @javax.annotation.Nullable
            private com.facebook.graphql.enums.GraphQLObjectType m19330l() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r0 = r4.b;
                if (r0 == 0) goto L_0x0017;
            L_0x0004:
                r0 = r4.f16475d;
                if (r0 != 0) goto L_0x0017;
            L_0x0008:
                r0 = r4.b;
                r1 = r4.c;
                r2 = 0;
                r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                r0 = r0.d(r1, r2, r3);
                r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                r4.f16475d = r0;
            L_0x0017:
                r0 = r4.f16475d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.l():com.facebook.graphql.enums.GraphQLObjectType");
            }

            @javax.annotation.Nullable
            public final com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel m19337j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f16476e;
                r1 = 1;
                r2 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel) r0;
                r3.f16476e = r0;
                r0 = r3.f16476e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.j():com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedCouponsModel");
            }

            @javax.annotation.Nullable
            public final com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel m19338k() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f16477f;
                r1 = 2;
                r2 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel) r0;
                r3.f16477f = r0;
                r0 = r3.f16477f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.k():com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel$ClaimedOffersModel");
            }

            @javax.annotation.Nullable
            private java.lang.String m19331m() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.f16478g;
                r1 = 3;
                r0 = super.a(r0, r1);
                r2.f16478g = r0;
                r0 = r2.f16478g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.m():java.lang.String");
            }

            @javax.annotation.Nullable
            public final java.lang.String m19334a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m19331m();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.a():java.lang.String");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 63093205; // 0x3c2b9d5 float:1.144496E-36 double:3.1172185E-316;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m19333a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r1 = 0;
                r3.h();
                r0 = r3.m19337j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m19337j();
                r0 = r4.b(r0);
                r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel) r0;
                r2 = r3.m19337j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel) r1;
                r1.f16476e = r0;
            L_0x0022:
                r0 = r3.m19338k();
                if (r0 == 0) goto L_0x0040;
            L_0x0028:
                r0 = r3.m19338k();
                r0 = r4.b(r0);
                r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel) r0;
                r2 = r3.m19338k();
                if (r2 == r0) goto L_0x0040;
            L_0x0038:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel) r1;
                r1.f16477f = r0;
            L_0x0040:
                r3.i();
                if (r1 != 0) goto L_0x0046;
            L_0x0045:
                return r3;
            L_0x0046:
                r3 = r1;
                goto L_0x0045;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m19332a(com.facebook.flatbuffers.FlatBufferBuilder r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r5.h();
                r0 = r5.m19330l();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r0);
                r1 = r5.m19337j();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r1);
                r2 = r5.m19338k();
                r2 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r2);
                r3 = r5.m19331m();
                r3 = r6.b(r3);
                r4 = 4;
                r6.c(r4);
                r4 = 0;
                r6.b(r4, r0);
                r0 = 1;
                r6.b(r0, r1);
                r0 = 2;
                r6.b(r0, r2);
                r0 = 3;
                r6.b(r0, r3);
                r5.i();
                r0 = r6.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.class;
                r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m19339a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r2 = com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.m19432a(r6);
                r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<OffersWalletQueryModel> {
            public final void m19340a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r8 = this;
                r9 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m19341a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r9.a(r0, r1);
            L_0x0035:
                r0 = r9.w_();
                r1 = r9.u_();
                r10.f();
                r6 = 0;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x004f;
            L_0x0047:
                r7 = "actor";
                r10.a(r7);
                com.facebook.offers.graphql.OfferQueriesParsers.OffersWalletQueryParser.ActorParser.m19431a(r0, r6, r10, r11);
            L_0x004f:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.class;
                r1 = new com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.Serializer.<clinit>():void");
            }
        }

        public OffersWalletQueryModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 1;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.<init>():void");
        }

        @javax.annotation.Nullable
        public final com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel m19343a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f16479d;
            r1 = 0;
            r2 = com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel) r0;
            r3.f16479d = r0;
            r0 = r3.f16479d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.a():com.facebook.offers.graphql.OfferQueriesModels$OffersWalletQueryModel$ActorModel");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = -1732764110; // 0xffffffff98b81e32 float:-4.7593375E-24 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m19342a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m19343a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m19343a();
            r0 = r4.b(r0);
            r0 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel) r0;
            r2 = r3.m19343a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel) r1;
            r1.f16479d = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m19341a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r2.h();
            r0 = r2.m19343a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
            r1 = 1;
            r3.c(r1);
            r1 = 0;
            r3.b(r1, r0);
            r2.i();
            r0 = r3.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -691496622)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class PhotoDataModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ImageDataModel f16481d;

        /* compiled from: current_location_city */
        public final class Builder {
            @Nullable
            public ImageDataModel f16480a;
        }

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhotoDataModel.class, new Deserializer());
            }

            public Object m19344a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PhotoDataParser.m19433b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object photoDataModel = new PhotoDataModel();
                ((BaseModel) photoDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (photoDataModel instanceof Postprocessable) {
                    return ((Postprocessable) photoDataModel).a();
                }
                return photoDataModel;
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<PhotoDataModel> {
            public final void m19345a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PhotoDataModel photoDataModel = (PhotoDataModel) obj;
                if (photoDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photoDataModel.m19348a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photoDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PhotoDataParser.m19434b(photoDataModel.w_(), photoDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PhotoDataModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ImageDataModel m19350a() {
            return m19347j();
        }

        public PhotoDataModel() {
            super(1);
        }

        public PhotoDataModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private ImageDataModel m19347j() {
            this.f16481d = (ImageDataModel) super.a(this.f16481d, 0, ImageDataModel.class);
            return this.f16481d;
        }

        public static PhotoDataModel m19346a(PhotoDataModel photoDataModel) {
            if (photoDataModel == null) {
                return null;
            }
            if (photoDataModel instanceof PhotoDataModel) {
                return photoDataModel;
            }
            Builder builder = new Builder();
            builder.f16480a = ImageDataModel.m19148a(photoDataModel.m19350a());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f16480a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new PhotoDataModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m19349a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19347j() != null) {
                ImageDataModel imageDataModel = (ImageDataModel) graphQLModelMutatingVisitor.b(m19347j());
                if (m19347j() != imageDataModel) {
                    graphQLVisitableModel = (PhotoDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16481d = imageDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19348a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19347j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 416657963)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_location_city */
    public final class VideoDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private int f16505d;
        private int f16506e;
        @Nullable
        private String f16507f;
        private int f16508g;
        private int f16509h;
        @Nullable
        private String f16510i;
        private int f16511j;
        @Nullable
        private String f16512k;
        private boolean f16513l;
        private int f16514m;
        @Nullable
        private String f16515n;
        @Nullable
        private TitleModel f16516o;
        @Nullable
        private String f16517p;
        @Nullable
        private VideoThumbnailsModel f16518q;
        private int f16519r;

        /* compiled from: current_location_city */
        public final class Builder {
            public int f16482a;
            public int f16483b;
            @Nullable
            public String f16484c;
            public int f16485d;
            public int f16486e;
            @Nullable
            public String f16487f;
            public int f16488g;
            @Nullable
            public String f16489h;
            public boolean f16490i;
            public int f16491j;
            @Nullable
            public String f16492k;
            @Nullable
            public TitleModel f16493l;
            @Nullable
            public String f16494m;
            @Nullable
            public VideoThumbnailsModel f16495n;
            public int f16496o;
        }

        /* compiled from: current_location_city */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoDataModel.class, new Deserializer());
            }

            public Object m19351a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(VideoDataParser.m19442b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object videoDataModel = new VideoDataModel();
                ((BaseModel) videoDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (videoDataModel instanceof Postprocessable) {
                    return ((Postprocessable) videoDataModel).a();
                }
                return videoDataModel;
            }
        }

        /* compiled from: current_location_city */
        public class Serializer extends JsonSerializer<VideoDataModel> {
            public final void m19352a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                VideoDataModel videoDataModel = (VideoDataModel) obj;
                if (videoDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoDataModel.m19376a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                VideoDataParser.m19443b(videoDataModel.w_(), videoDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(VideoDataModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1581737376)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: current_location_city */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f16499d;
            @Nullable
            private String f16500e;

            /* compiled from: current_location_city */
            public final class Builder {
                @Nullable
                public String f16497a;
                @Nullable
                public String f16498b;
            }

            /* compiled from: current_location_city */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m19353a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m19435a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object titleModel = new TitleModel();
                    ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (titleModel instanceof Postprocessable) {
                        return ((Postprocessable) titleModel).a();
                    }
                    return titleModel;
                }
            }

            /* compiled from: current_location_city */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m19354a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m19356a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m19436a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(2);
            }

            public TitleModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m19358a() {
                this.f16499d = super.a(this.f16499d, 0);
                return this.f16499d;
            }

            @Nullable
            public final String m19359b() {
                this.f16500e = super.a(this.f16500e, 1);
                return this.f16500e;
            }

            public static TitleModel m19355a(TitleModel titleModel) {
                if (titleModel == null) {
                    return null;
                }
                if (titleModel instanceof TitleModel) {
                    return titleModel;
                }
                Builder builder = new Builder();
                builder.f16497a = titleModel.m19358a();
                builder.f16498b = titleModel.m19359b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f16497a);
                int b2 = flatBufferBuilder.b(builder.f16498b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TitleModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m19357a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19356a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19358a());
                int b2 = flatBufferBuilder.b(m19359b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 818163086)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: current_location_city */
        public final class VideoThumbnailsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f16504d;

            /* compiled from: current_location_city */
            public final class Builder {
                @Nullable
                public ImmutableList<NodesModel> f16501a;
            }

            /* compiled from: current_location_city */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoThumbnailsModel.class, new Deserializer());
                }

                public Object m19360a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoThumbnailsParser.m19439a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoThumbnailsModel = new VideoThumbnailsModel();
                    ((BaseModel) videoThumbnailsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoThumbnailsModel instanceof Postprocessable) {
                        return ((Postprocessable) videoThumbnailsModel).a();
                    }
                    return videoThumbnailsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -691496622)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: current_location_city */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ImageDataModel f16503d;

                /* compiled from: current_location_city */
                public final class Builder {
                    @Nullable
                    public ImageDataModel f16502a;
                }

                /* compiled from: current_location_city */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m19361a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m19437b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: current_location_city */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m19362a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m19365a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m19438b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ImageDataModel m19367a() {
                    return m19364j();
                }

                public NodesModel() {
                    super(1);
                }

                public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(r3, FlatBuffer.a(r3.a));
                }

                @Nullable
                private ImageDataModel m19364j() {
                    this.f16503d = (ImageDataModel) super.a(this.f16503d, 0, ImageDataModel.class);
                    return this.f16503d;
                }

                public static NodesModel m19363a(NodesModel nodesModel) {
                    if (r8 == null) {
                        return null;
                    }
                    if (r8 instanceof NodesModel) {
                        return r8;
                    }
                    Builder builder = new Builder();
                    builder.f16502a = ImageDataModel.m19148a(r8.m19367a());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f16502a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 645333713;
                }

                public final GraphQLVisitableModel m19366a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m19364j() != null) {
                        ImageDataModel imageDataModel = (ImageDataModel) r4.b(m19364j());
                        if (m19364j() != imageDataModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f16503d = imageDataModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m19365a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(r3, m19364j());
                    r3.c(1);
                    r3.b(0, a);
                    i();
                    return r3.d();
                }
            }

            /* compiled from: current_location_city */
            public class Serializer extends JsonSerializer<VideoThumbnailsModel> {
                public final void m19368a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoThumbnailsModel videoThumbnailsModel = (VideoThumbnailsModel) r8;
                    if (videoThumbnailsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoThumbnailsModel.m19370a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoThumbnailsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoThumbnailsParser.m19440a(videoThumbnailsModel.w_(), videoThumbnailsModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(VideoThumbnailsModel.class, new Serializer());
                }
            }

            public VideoThumbnailsModel() {
                super(1);
            }

            public VideoThumbnailsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(r3, FlatBuffer.a(r3.a));
            }

            @Nonnull
            public final ImmutableList<NodesModel> m19372a() {
                this.f16504d = super.a(this.f16504d, 0, NodesModel.class);
                return (ImmutableList) this.f16504d;
            }

            public static VideoThumbnailsModel m19369a(VideoThumbnailsModel videoThumbnailsModel) {
                if (r10 == null) {
                    return null;
                }
                if (r10 instanceof VideoThumbnailsModel) {
                    return r10;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < r10.m19372a().size(); i++) {
                    builder2.c(NodesModel.m19363a((NodesModel) r10.m19372a().get(i)));
                }
                builder.f16501a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f16501a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new VideoThumbnailsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -808556480;
            }

            public final GraphQLVisitableModel m19371a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19372a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m19372a(), r3);
                    if (a != null) {
                        graphQLVisitableModel = (VideoThumbnailsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16504d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19370a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r3, m19372a());
                r3.c(1);
                r3.b(0, a);
                i();
                return r3.d();
            }
        }

        @Nullable
        public final /* synthetic */ TitleModel m19388n() {
            return m19374r();
        }

        @Nullable
        public final /* synthetic */ VideoThumbnailsModel m19390p() {
            return m19375s();
        }

        public VideoDataModel() {
            super(15);
        }

        public VideoDataModel(MutableFlatBuffer mutableFlatBuffer) {
            super(15);
            a(r3, FlatBuffer.a(r3.a));
        }

        public final int m19380b() {
            a(0, 0);
            return this.f16505d;
        }

        public final int m19381c() {
            a(0, 1);
            return this.f16506e;
        }

        @Nullable
        public final String m19382d() {
            this.f16507f = super.a(this.f16507f, 2);
            return this.f16507f;
        }

        public final int jT_() {
            a(0, 3);
            return this.f16508g;
        }

        public final int m19383g() {
            a(0, 4);
            return this.f16509h;
        }

        @Nullable
        public final String jU_() {
            this.f16510i = super.a(this.f16510i, 5);
            return this.f16510i;
        }

        public final int jV_() {
            a(0, 6);
            return this.f16511j;
        }

        @Nullable
        public final String m19384j() {
            this.f16512k = super.a(this.f16512k, 7);
            return this.f16512k;
        }

        public final boolean m19385k() {
            a(1, 0);
            return this.f16513l;
        }

        public final int m19386l() {
            a(1, 1);
            return this.f16514m;
        }

        @Nullable
        public final String m19387m() {
            this.f16515n = super.a(this.f16515n, 10);
            return this.f16515n;
        }

        @Nullable
        private TitleModel m19374r() {
            this.f16516o = (TitleModel) super.a(this.f16516o, 11, TitleModel.class);
            return this.f16516o;
        }

        @Nullable
        public final String m19389o() {
            this.f16517p = super.a(this.f16517p, 12);
            return this.f16517p;
        }

        @Nullable
        private VideoThumbnailsModel m19375s() {
            this.f16518q = (VideoThumbnailsModel) super.a(this.f16518q, 13, VideoThumbnailsModel.class);
            return this.f16518q;
        }

        public final int m19391q() {
            a(1, 6);
            return this.f16519r;
        }

        public static VideoDataModel m19373a(VideoDataModel videoDataModel) {
            if (r14 == null) {
                return null;
            }
            if (r14 instanceof VideoDataModel) {
                return r14;
            }
            Builder builder = new Builder();
            builder.f16482a = r14.m19380b();
            builder.f16483b = r14.m19381c();
            builder.f16484c = r14.m19382d();
            builder.f16485d = r14.jT_();
            builder.f16486e = r14.m19383g();
            builder.f16487f = r14.jU_();
            builder.f16488g = r14.jV_();
            builder.f16489h = r14.m19384j();
            builder.f16490i = r14.m19385k();
            builder.f16491j = r14.m19386l();
            builder.f16492k = r14.m19387m();
            builder.f16493l = TitleModel.m19355a(r14.m19388n());
            builder.f16494m = r14.m19389o();
            builder.f16495n = VideoThumbnailsModel.m19369a(r14.m19390p());
            builder.f16496o = r14.m19391q();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f16484c);
            int b2 = flatBufferBuilder.b(builder.f16487f);
            int b3 = flatBufferBuilder.b(builder.f16489h);
            int b4 = flatBufferBuilder.b(builder.f16492k);
            int a = ModelHelper.a(flatBufferBuilder, builder.f16493l);
            int b5 = flatBufferBuilder.b(builder.f16494m);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f16495n);
            flatBufferBuilder.c(15);
            flatBufferBuilder.a(0, builder.f16482a, 0);
            flatBufferBuilder.a(1, builder.f16483b, 0);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.a(3, builder.f16485d, 0);
            flatBufferBuilder.a(4, builder.f16486e, 0);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.a(6, builder.f16488g, 0);
            flatBufferBuilder.b(7, b3);
            flatBufferBuilder.a(8, builder.f16490i);
            flatBufferBuilder.a(9, builder.f16491j, 0);
            flatBufferBuilder.b(10, b4);
            flatBufferBuilder.b(11, a);
            flatBufferBuilder.b(12, b5);
            flatBufferBuilder.b(13, a2);
            flatBufferBuilder.a(14, builder.f16496o, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new VideoDataModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m19378a() {
            return m19384j();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m19377a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19374r() != null) {
                TitleModel titleModel = (TitleModel) r4.b(m19374r());
                if (m19374r() != titleModel) {
                    graphQLVisitableModel = (VideoDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16516o = titleModel;
                }
            }
            if (m19375s() != null) {
                VideoThumbnailsModel videoThumbnailsModel = (VideoThumbnailsModel) r4.b(m19375s());
                if (m19375s() != videoThumbnailsModel) {
                    graphQLVisitableModel = (VideoDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16518q = videoThumbnailsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19376a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = r11.b(m19382d());
            int b2 = r11.b(jU_());
            int b3 = r11.b(m19384j());
            int b4 = r11.b(m19387m());
            int a = ModelHelper.a(r11, m19374r());
            int b5 = r11.b(m19389o());
            int a2 = ModelHelper.a(r11, m19375s());
            r11.c(15);
            r11.a(0, this.f16505d, 0);
            r11.a(1, this.f16506e, 0);
            r11.b(2, b);
            r11.a(3, this.f16508g, 0);
            r11.a(4, this.f16509h, 0);
            r11.b(5, b2);
            r11.a(6, this.f16511j, 0);
            r11.b(7, b3);
            r11.a(8, this.f16513l);
            r11.a(9, this.f16514m, 0);
            r11.b(10, b4);
            r11.b(11, a);
            r11.b(12, b5);
            r11.b(13, a2);
            r11.a(14, this.f16519r, 0);
            i();
            return r11.d();
        }

        public final void m19379a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(r3, r4, r5);
            this.f16505d = r3.a(r4, 0, 0);
            this.f16506e = r3.a(r4, 1, 0);
            this.f16508g = r3.a(r4, 3, 0);
            this.f16509h = r3.a(r4, 4, 0);
            this.f16511j = r3.a(r4, 6, 0);
            this.f16513l = r3.a(r4, 8);
            this.f16514m = r3.a(r4, 9, 0);
            this.f16519r = r3.a(r4, 14, 0);
        }
    }
}
