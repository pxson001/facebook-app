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
import com.facebook.graphql.deserializers.GraphQLGoodwillAnniversaryCampaignDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: group_cover_photo */
public final class GraphQLGoodwillAnniversaryCampaign extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillAnniversaryCampaign> CREATOR = new C03381();
    List<GraphQLStoryAttachment> f3852d;
    @Nullable
    GraphQLTextWithEntities f3853e;
    @Nullable
    GraphQLImage f3854f;
    @Nullable
    GraphQLImage f3855g;
    @Nullable
    GraphQLTextWithEntities f3856h;
    @Nullable
    GraphQLTextWithEntities f3857i;
    @Nullable
    String f3858j;
    @Nullable
    GraphQLMediaSet f3859k;
    List<GraphQLStoryAttachment> f3860l;
    @Nullable
    GraphQLTextWithEntities f3861m;
    @Nullable
    GraphQLImage f3862n;
    @Nullable
    GraphQLTextWithEntities f3863o;
    @Nullable
    GraphQLTextWithEntities f3864p;
    @Nullable
    String f3865q;

    /* compiled from: group_cover_photo */
    final class C03381 implements Creator<GraphQLGoodwillAnniversaryCampaign> {
        C03381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillAnniversaryCampaign(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillAnniversaryCampaign[i];
        }
    }

    /* compiled from: group_cover_photo */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillAnniversaryCampaign.class, new Deserializer());
        }

        public Object m7768a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillAnniversaryCampaignDeserializer.m4997a(jsonParser, (short) 47);
            Object graphQLGoodwillAnniversaryCampaign = new GraphQLGoodwillAnniversaryCampaign();
            ((BaseModel) graphQLGoodwillAnniversaryCampaign).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillAnniversaryCampaign instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillAnniversaryCampaign).a();
            }
            return graphQLGoodwillAnniversaryCampaign;
        }
    }

    /* compiled from: group_cover_photo */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillAnniversaryCampaign> {
        public final void m7769a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillAnniversaryCampaign graphQLGoodwillAnniversaryCampaign = (GraphQLGoodwillAnniversaryCampaign) obj;
            GraphQLGoodwillAnniversaryCampaignDeserializer.m4998a(graphQLGoodwillAnniversaryCampaign.w_(), graphQLGoodwillAnniversaryCampaign.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillAnniversaryCampaign.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillAnniversaryCampaign.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m7773j() {
        this.f3852d = super.a(this.f3852d, 0, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f3852d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7774k() {
        this.f3853e = (GraphQLTextWithEntities) super.a(this.f3853e, 1, GraphQLTextWithEntities.class);
        return this.f3853e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7775l() {
        this.f3854f = (GraphQLImage) super.a(this.f3854f, 2, GraphQLImage.class);
        return this.f3854f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7776m() {
        this.f3855g = (GraphQLImage) super.a(this.f3855g, 3, GraphQLImage.class);
        return this.f3855g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7777n() {
        this.f3856h = (GraphQLTextWithEntities) super.a(this.f3856h, 4, GraphQLTextWithEntities.class);
        return this.f3856h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7778o() {
        this.f3857i = (GraphQLTextWithEntities) super.a(this.f3857i, 5, GraphQLTextWithEntities.class);
        return this.f3857i;
    }

    @FieldOffset
    @Nullable
    public final String m7779p() {
        this.f3858j = super.a(this.f3858j, 6);
        return this.f3858j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaSet m7780q() {
        this.f3859k = (GraphQLMediaSet) super.a(this.f3859k, 7, GraphQLMediaSet.class);
        return this.f3859k;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m7781r() {
        this.f3860l = super.a(this.f3860l, 8, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f3860l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7782s() {
        this.f3861m = (GraphQLTextWithEntities) super.a(this.f3861m, 9, GraphQLTextWithEntities.class);
        return this.f3861m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7783t() {
        this.f3862n = (GraphQLImage) super.a(this.f3862n, 10, GraphQLImage.class);
        return this.f3862n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7784u() {
        this.f3863o = (GraphQLTextWithEntities) super.a(this.f3863o, 11, GraphQLTextWithEntities.class);
        return this.f3863o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7785v() {
        this.f3864p = (GraphQLTextWithEntities) super.a(this.f3864p, 12, GraphQLTextWithEntities.class);
        return this.f3864p;
    }

    @FieldOffset
    @Nullable
    public final String m7786w() {
        this.f3865q = super.a(this.f3865q, 13);
        return this.f3865q;
    }

    @Nullable
    public final String m7772a() {
        return m7779p();
    }

    public final int jK_() {
        return 2042542609;
    }

    public final GraphQLVisitableModel m7771a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLGoodwillAnniversaryCampaign graphQLGoodwillAnniversaryCampaign;
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLImage graphQLImage;
        GraphQLMediaSet graphQLMediaSet;
        Builder a;
        h();
        if (m7773j() != null) {
            Builder a2 = ModelHelper.a(m7773j(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLGoodwillAnniversaryCampaign = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(null, this);
                graphQLGoodwillAnniversaryCampaign.f3852d = a2.b();
                graphQLVisitableModel = graphQLGoodwillAnniversaryCampaign;
                if (m7774k() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7774k());
                    if (m7774k() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3853e = graphQLTextWithEntities;
                    }
                }
                if (m7775l() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7775l());
                    if (m7775l() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3854f = graphQLImage;
                    }
                }
                if (m7776m() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7776m());
                    if (m7776m() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3855g = graphQLImage;
                    }
                }
                if (m7777n() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7777n());
                    if (m7777n() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3856h = graphQLTextWithEntities;
                    }
                }
                if (m7778o() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7778o());
                    if (m7778o() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3857i = graphQLTextWithEntities;
                    }
                }
                if (m7780q() != null) {
                    graphQLMediaSet = (GraphQLMediaSet) graphQLModelMutatingVisitor.b(m7780q());
                    if (m7780q() != graphQLMediaSet) {
                        graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3859k = graphQLMediaSet;
                    }
                }
                if (m7781r() != null) {
                    a = ModelHelper.a(m7781r(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLGoodwillAnniversaryCampaign = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLGoodwillAnniversaryCampaign.f3860l = a.b();
                        graphQLVisitableModel = graphQLGoodwillAnniversaryCampaign;
                    }
                }
                if (m7782s() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7782s());
                    if (m7782s() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3861m = graphQLTextWithEntities;
                    }
                }
                if (m7783t() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7783t());
                    if (m7783t() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3862n = graphQLImage;
                    }
                }
                if (m7784u() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7784u());
                    if (m7784u() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3863o = graphQLTextWithEntities;
                    }
                }
                if (m7785v() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7785v());
                    if (m7785v() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3864p = graphQLTextWithEntities;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m7774k() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7774k());
            if (m7774k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3853e = graphQLTextWithEntities;
            }
        }
        if (m7775l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7775l());
            if (m7775l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3854f = graphQLImage;
            }
        }
        if (m7776m() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7776m());
            if (m7776m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3855g = graphQLImage;
            }
        }
        if (m7777n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7777n());
            if (m7777n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3856h = graphQLTextWithEntities;
            }
        }
        if (m7778o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7778o());
            if (m7778o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3857i = graphQLTextWithEntities;
            }
        }
        if (m7780q() != null) {
            graphQLMediaSet = (GraphQLMediaSet) graphQLModelMutatingVisitor.b(m7780q());
            if (m7780q() != graphQLMediaSet) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3859k = graphQLMediaSet;
            }
        }
        if (m7781r() != null) {
            a = ModelHelper.a(m7781r(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillAnniversaryCampaign = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillAnniversaryCampaign.f3860l = a.b();
                graphQLVisitableModel = graphQLGoodwillAnniversaryCampaign;
            }
        }
        if (m7782s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7782s());
            if (m7782s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3861m = graphQLTextWithEntities;
            }
        }
        if (m7783t() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7783t());
            if (m7783t() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3862n = graphQLImage;
            }
        }
        if (m7784u() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7784u());
            if (m7784u() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3863o = graphQLTextWithEntities;
            }
        }
        if (m7785v() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7785v());
            if (m7785v() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillAnniversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3864p = graphQLTextWithEntities;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLGoodwillAnniversaryCampaign() {
        super(15);
    }

    public final int m7770a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7773j());
        int a2 = ModelHelper.a(flatBufferBuilder, m7774k());
        int a3 = ModelHelper.a(flatBufferBuilder, m7775l());
        int a4 = ModelHelper.a(flatBufferBuilder, m7776m());
        int a5 = ModelHelper.a(flatBufferBuilder, m7777n());
        int a6 = ModelHelper.a(flatBufferBuilder, m7778o());
        int b = flatBufferBuilder.b(m7779p());
        int a7 = ModelHelper.a(flatBufferBuilder, m7780q());
        int a8 = ModelHelper.a(flatBufferBuilder, m7781r());
        int a9 = ModelHelper.a(flatBufferBuilder, m7782s());
        int a10 = ModelHelper.a(flatBufferBuilder, m7783t());
        int a11 = ModelHelper.a(flatBufferBuilder, m7784u());
        int a12 = ModelHelper.a(flatBufferBuilder, m7785v());
        int b2 = flatBufferBuilder.b(m7786w());
        flatBufferBuilder.c(14);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, a4);
        flatBufferBuilder.b(4, a5);
        flatBufferBuilder.b(5, a6);
        flatBufferBuilder.b(6, b);
        flatBufferBuilder.b(7, a7);
        flatBufferBuilder.b(8, a8);
        flatBufferBuilder.b(9, a9);
        flatBufferBuilder.b(10, a10);
        flatBufferBuilder.b(11, a11);
        flatBufferBuilder.b(12, a12);
        flatBufferBuilder.b(13, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillAnniversaryCampaign(Parcel parcel) {
        super(15);
        this.f3852d = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f3853e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3854f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3855g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3856h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3857i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3858j = parcel.readString();
        this.f3859k = (GraphQLMediaSet) parcel.readValue(GraphQLMediaSet.class.getClassLoader());
        this.f3860l = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f3861m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3862n = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3863o = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3864p = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3865q = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m7773j());
        parcel.writeValue(m7774k());
        parcel.writeValue(m7775l());
        parcel.writeValue(m7776m());
        parcel.writeValue(m7777n());
        parcel.writeValue(m7778o());
        parcel.writeString(m7779p());
        parcel.writeValue(m7780q());
        parcel.writeList(m7781r());
        parcel.writeValue(m7782s());
        parcel.writeValue(m7783t());
        parcel.writeValue(m7784u());
        parcel.writeValue(m7785v());
        parcel.writeString(m7786w());
    }
}
