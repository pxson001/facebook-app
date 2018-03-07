package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLQuickPromotionCreativeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: VIEW_PAGE_SETTINGS */
public final class GraphQLQuickPromotionCreative extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQuickPromotionCreative> CREATOR = new C11931();
    @Nullable
    public GraphQLStoryAttachment f12849d;
    @Nullable
    public GraphQLImage f12850e;
    @Nullable
    public GraphQLTextWithEntities f12851f;
    @Nullable
    public GraphQLQuickPromotionAction f12852g;
    @Nullable
    public GraphQLTextWithEntities f12853h;
    @Nullable
    public GraphQLImage f12854i;
    @Nullable
    public GraphQLImage f12855j;
    @Nullable
    public GraphQLQuickPromotionAction f12856k;
    @Nullable
    public GraphQLQuickPromotionAction f12857l;
    @Nullable
    public GraphQLTextWithEntities f12858m;
    @Nullable
    public GraphQLTextWithEntities f12859n;

    /* compiled from: VIEW_PAGE_SETTINGS */
    final class C11931 implements Creator<GraphQLQuickPromotionCreative> {
        C11931() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuickPromotionCreative(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuickPromotionCreative[i];
        }
    }

    /* compiled from: VIEW_PAGE_SETTINGS */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionCreative.class, new Deserializer());
        }

        public Object m21213a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQuickPromotionCreativeDeserializer.m5747a(jsonParser, (short) 362);
            Object graphQLQuickPromotionCreative = new GraphQLQuickPromotionCreative();
            ((BaseModel) graphQLQuickPromotionCreative).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQuickPromotionCreative instanceof Postprocessable) {
                return ((Postprocessable) graphQLQuickPromotionCreative).a();
            }
            return graphQLQuickPromotionCreative;
        }
    }

    /* compiled from: VIEW_PAGE_SETTINGS */
    public final class Serializer extends JsonSerializer<GraphQLQuickPromotionCreative> {
        public final void m21214a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQuickPromotionCreative graphQLQuickPromotionCreative = (GraphQLQuickPromotionCreative) obj;
            GraphQLQuickPromotionCreativeDeserializer.m5748b(graphQLQuickPromotionCreative.w_(), graphQLQuickPromotionCreative.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLQuickPromotionCreative.class, new Serializer());
            FbSerializerProvider.a(GraphQLQuickPromotionCreative.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryAttachment m21216a() {
        this.f12849d = (GraphQLStoryAttachment) super.a(this.f12849d, 0, GraphQLStoryAttachment.class);
        return this.f12849d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21218j() {
        this.f12850e = (GraphQLImage) super.a(this.f12850e, 1, GraphQLImage.class);
        return this.f12850e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21219k() {
        this.f12851f = (GraphQLTextWithEntities) super.a(this.f12851f, 2, GraphQLTextWithEntities.class);
        return this.f12851f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLQuickPromotionAction m21220l() {
        this.f12852g = (GraphQLQuickPromotionAction) super.a(this.f12852g, 3, GraphQLQuickPromotionAction.class);
        return this.f12852g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21221m() {
        this.f12853h = (GraphQLTextWithEntities) super.a(this.f12853h, 4, GraphQLTextWithEntities.class);
        return this.f12853h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21222n() {
        this.f12854i = (GraphQLImage) super.a(this.f12854i, 5, GraphQLImage.class);
        return this.f12854i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21223o() {
        this.f12855j = (GraphQLImage) super.a(this.f12855j, 6, GraphQLImage.class);
        return this.f12855j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLQuickPromotionAction m21224p() {
        this.f12856k = (GraphQLQuickPromotionAction) super.a(this.f12856k, 7, GraphQLQuickPromotionAction.class);
        return this.f12856k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLQuickPromotionAction m21225q() {
        this.f12857l = (GraphQLQuickPromotionAction) super.a(this.f12857l, 8, GraphQLQuickPromotionAction.class);
        return this.f12857l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21226r() {
        this.f12858m = (GraphQLTextWithEntities) super.a(this.f12858m, 9, GraphQLTextWithEntities.class);
        return this.f12858m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21227s() {
        this.f12859n = (GraphQLTextWithEntities) super.a(this.f12859n, 11, GraphQLTextWithEntities.class);
        return this.f12859n;
    }

    public final int jK_() {
        return -641058011;
    }

    public final GraphQLVisitableModel m21217a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLQuickPromotionAction graphQLQuickPromotionAction;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21216a() != null) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) graphQLModelMutatingVisitor.b(m21216a());
            if (m21216a() != graphQLStoryAttachment) {
                graphQLVisitableModel = (GraphQLQuickPromotionCreative) ModelHelper.a(null, this);
                graphQLVisitableModel.f12849d = graphQLStoryAttachment;
            }
        }
        if (m21218j() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21218j());
            if (m21218j() != graphQLImage) {
                graphQLVisitableModel = (GraphQLQuickPromotionCreative) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12850e = graphQLImage;
            }
        }
        if (m21219k() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21219k());
            if (m21219k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLQuickPromotionCreative) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12851f = graphQLTextWithEntities;
            }
        }
        if (m21220l() != null) {
            graphQLQuickPromotionAction = (GraphQLQuickPromotionAction) graphQLModelMutatingVisitor.b(m21220l());
            if (m21220l() != graphQLQuickPromotionAction) {
                graphQLVisitableModel = (GraphQLQuickPromotionCreative) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12852g = graphQLQuickPromotionAction;
            }
        }
        if (m21221m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21221m());
            if (m21221m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLQuickPromotionCreative) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12853h = graphQLTextWithEntities;
            }
        }
        if (m21222n() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21222n());
            if (m21222n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLQuickPromotionCreative) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12854i = graphQLImage;
            }
        }
        if (m21223o() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21223o());
            if (m21223o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLQuickPromotionCreative) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12855j = graphQLImage;
            }
        }
        if (m21224p() != null) {
            graphQLQuickPromotionAction = (GraphQLQuickPromotionAction) graphQLModelMutatingVisitor.b(m21224p());
            if (m21224p() != graphQLQuickPromotionAction) {
                graphQLVisitableModel = (GraphQLQuickPromotionCreative) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12856k = graphQLQuickPromotionAction;
            }
        }
        if (m21225q() != null) {
            graphQLQuickPromotionAction = (GraphQLQuickPromotionAction) graphQLModelMutatingVisitor.b(m21225q());
            if (m21225q() != graphQLQuickPromotionAction) {
                graphQLVisitableModel = (GraphQLQuickPromotionCreative) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12857l = graphQLQuickPromotionAction;
            }
        }
        if (m21226r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21226r());
            if (m21226r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLQuickPromotionCreative) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12858m = graphQLTextWithEntities;
            }
        }
        if (m21227s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21227s());
            if (m21227s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLQuickPromotionCreative) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12859n = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLQuickPromotionCreative() {
        super(13);
    }

    public final int m21215a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21216a());
        int a2 = ModelHelper.a(flatBufferBuilder, m21218j());
        int a3 = ModelHelper.a(flatBufferBuilder, m21219k());
        int a4 = ModelHelper.a(flatBufferBuilder, m21220l());
        int a5 = ModelHelper.a(flatBufferBuilder, m21221m());
        int a6 = ModelHelper.a(flatBufferBuilder, m21222n());
        int a7 = ModelHelper.a(flatBufferBuilder, m21223o());
        int a8 = ModelHelper.a(flatBufferBuilder, m21224p());
        int a9 = ModelHelper.a(flatBufferBuilder, m21225q());
        int a10 = ModelHelper.a(flatBufferBuilder, m21226r());
        int a11 = ModelHelper.a(flatBufferBuilder, m21227s());
        flatBufferBuilder.c(12);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, a4);
        flatBufferBuilder.b(4, a5);
        flatBufferBuilder.b(5, a6);
        flatBufferBuilder.b(6, a7);
        flatBufferBuilder.b(7, a8);
        flatBufferBuilder.b(8, a9);
        flatBufferBuilder.b(9, a10);
        flatBufferBuilder.b(11, a11);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQuickPromotionCreative(Parcel parcel) {
        super(13);
        this.f12849d = (GraphQLStoryAttachment) parcel.readValue(GraphQLStoryAttachment.class.getClassLoader());
        this.f12850e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12851f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12852g = (GraphQLQuickPromotionAction) parcel.readValue(GraphQLQuickPromotionAction.class.getClassLoader());
        this.f12853h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12854i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12855j = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12856k = (GraphQLQuickPromotionAction) parcel.readValue(GraphQLQuickPromotionAction.class.getClassLoader());
        this.f12857l = (GraphQLQuickPromotionAction) parcel.readValue(GraphQLQuickPromotionAction.class.getClassLoader());
        this.f12858m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12859n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21216a());
        parcel.writeValue(m21218j());
        parcel.writeValue(m21219k());
        parcel.writeValue(m21220l());
        parcel.writeValue(m21221m());
        parcel.writeValue(m21222n());
        parcel.writeValue(m21223o());
        parcel.writeValue(m21224p());
        parcel.writeValue(m21225q());
        parcel.writeValue(m21226r());
        parcel.writeValue(m21227s());
    }
}
