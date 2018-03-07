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
import com.facebook.graphql.deserializers.GraphQLTimelineAppCollectionItemDeserializer;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionItemType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
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
/* compiled from: UNKNOWN_REPORT_PAGE */
public final class GraphQLTimelineAppCollectionItem extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLTimelineAppCollectionItem> CREATOR = new C12521();
    @Nullable
    GraphQLTextWithEntities f13303d;
    GraphQLTimelineAppCollectionItemType f13304e;
    long f13305f;
    @Nullable
    GraphQLFeedback f13306g;
    @Nullable
    GraphQLExternalUrl f13307h;
    @Nullable
    GraphQLImage f13308i;
    @Nullable
    String f13309j;
    @Nullable
    GraphQLImage f13310k;
    @Nullable
    GraphQLImage f13311l;
    @Nullable
    GraphQLNode f13312m;
    @Nullable
    GraphQLNode f13313n;
    @Nullable
    GraphQLPrivacyScope f13314o;
    @Nullable
    GraphQLImage f13315p;
    @Nullable
    GraphQLImage f13316q;
    @Nullable
    GraphQLRating f13317r;
    @Nullable
    FeedUnit f13318s;
    @Nullable
    GraphQLTextWithEntities f13319t;
    @Nullable
    GraphQLImage f13320u;
    @Nullable
    GraphQLTextWithEntities f13321v;
    @Nullable
    GraphQLTextWithEntities f13322w;
    @Nullable
    String f13323x;
    @Nullable
    public String f13324y;

    /* compiled from: UNKNOWN_REPORT_PAGE */
    final class C12521 implements Creator<GraphQLTimelineAppCollectionItem> {
        C12521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTimelineAppCollectionItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTimelineAppCollectionItem[i];
        }
    }

    /* compiled from: UNKNOWN_REPORT_PAGE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTimelineAppCollectionItem.class, new Deserializer());
        }

        public Object m22119a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTimelineAppCollectionItemDeserializer.m6072a(jsonParser, (short) 103);
            Object graphQLTimelineAppCollectionItem = new GraphQLTimelineAppCollectionItem();
            ((BaseModel) graphQLTimelineAppCollectionItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTimelineAppCollectionItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLTimelineAppCollectionItem).a();
            }
            return graphQLTimelineAppCollectionItem;
        }
    }

    /* compiled from: UNKNOWN_REPORT_PAGE */
    public final class Serializer extends JsonSerializer<GraphQLTimelineAppCollectionItem> {
        public final void m22120a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTimelineAppCollectionItem graphQLTimelineAppCollectionItem = (GraphQLTimelineAppCollectionItem) obj;
            GraphQLTimelineAppCollectionItemDeserializer.m6073a(graphQLTimelineAppCollectionItem.w_(), graphQLTimelineAppCollectionItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLTimelineAppCollectionItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLTimelineAppCollectionItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22132j() {
        this.f13303d = (GraphQLTextWithEntities) super.a(this.f13303d, 0, GraphQLTextWithEntities.class);
        return this.f13303d;
    }

    @FieldOffset
    public final GraphQLTimelineAppCollectionItemType m22133k() {
        this.f13304e = (GraphQLTimelineAppCollectionItemType) super.a(this.f13304e, 1, GraphQLTimelineAppCollectionItemType.class, GraphQLTimelineAppCollectionItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f13304e;
    }

    @FieldOffset
    public final long m22134l() {
        a(0, 2);
        return this.f13305f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m22135m() {
        this.f13306g = (GraphQLFeedback) super.a(this.f13306g, 3, GraphQLFeedback.class);
        return this.f13306g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLExternalUrl m22136n() {
        this.f13307h = (GraphQLExternalUrl) super.a(this.f13307h, 4, GraphQLExternalUrl.class);
        return this.f13307h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22137o() {
        this.f13308i = (GraphQLImage) super.a(this.f13308i, 6, GraphQLImage.class);
        return this.f13308i;
    }

    @FieldOffset
    @Nullable
    public final String m22138p() {
        this.f13309j = super.a(this.f13309j, 7);
        return this.f13309j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22139q() {
        this.f13310k = (GraphQLImage) super.a(this.f13310k, 8, GraphQLImage.class);
        return this.f13310k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22140r() {
        this.f13311l = (GraphQLImage) super.a(this.f13311l, 9, GraphQLImage.class);
        return this.f13311l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNode m22141s() {
        this.f13312m = (GraphQLNode) super.a(this.f13312m, 10, GraphQLNode.class);
        return this.f13312m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNode m22142t() {
        this.f13313n = (GraphQLNode) super.a(this.f13313n, 11, GraphQLNode.class);
        return this.f13313n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m22143u() {
        this.f13314o = (GraphQLPrivacyScope) super.a(this.f13314o, 12, GraphQLPrivacyScope.class);
        return this.f13314o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22144v() {
        this.f13315p = (GraphQLImage) super.a(this.f13315p, 13, GraphQLImage.class);
        return this.f13315p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22145w() {
        this.f13316q = (GraphQLImage) super.a(this.f13316q, 14, GraphQLImage.class);
        return this.f13316q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLRating m22146x() {
        this.f13317r = (GraphQLRating) super.a(this.f13317r, 15, GraphQLRating.class);
        return this.f13317r;
    }

    @FieldOffset
    @Nullable
    public final FeedUnit m22147y() {
        this.f13318s = (FeedUnit) super.a(this.f13318s, 17, VirtualFlattenableResolverImpl.a);
        return this.f13318s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22148z() {
        this.f13319t = (GraphQLTextWithEntities) super.a(this.f13319t, 18, GraphQLTextWithEntities.class);
        return this.f13319t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22121A() {
        this.f13320u = (GraphQLImage) super.a(this.f13320u, 19, GraphQLImage.class);
        return this.f13320u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22122B() {
        this.f13321v = (GraphQLTextWithEntities) super.a(this.f13321v, 20, GraphQLTextWithEntities.class);
        return this.f13321v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22123C() {
        this.f13322w = (GraphQLTextWithEntities) super.a(this.f13322w, 21, GraphQLTextWithEntities.class);
        return this.f13322w;
    }

    @FieldOffset
    @Nullable
    public final String m22124D() {
        this.f13323x = super.a(this.f13323x, 22);
        return this.f13323x;
    }

    @FieldOffset
    @Nullable
    public final String m22125E() {
        this.f13324y = super.a(this.f13324y, 23);
        return this.f13324y;
    }

    @Nullable
    public final String m22128a() {
        return m22138p();
    }

    public final int jK_() {
        return -154776335;
    }

    public final GraphQLVisitableModel m22127a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLImage graphQLImage;
        GraphQLNode graphQLNode;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22132j() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m22132j());
            if (m22132j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f13303d = graphQLTextWithEntities;
            }
        }
        if (m22135m() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m22135m());
            if (m22135m() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13306g = graphQLFeedback;
            }
        }
        if (m22136n() != null) {
            GraphQLExternalUrl graphQLExternalUrl = (GraphQLExternalUrl) graphQLModelMutatingVisitor.b(m22136n());
            if (m22136n() != graphQLExternalUrl) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13307h = graphQLExternalUrl;
            }
        }
        if (m22137o() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m22137o());
            if (m22137o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13308i = graphQLImage;
            }
        }
        if (m22139q() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m22139q());
            if (m22139q() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13310k = graphQLImage;
            }
        }
        if (m22140r() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m22140r());
            if (m22140r() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13311l = graphQLImage;
            }
        }
        if (m22141s() != null) {
            graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.b(m22141s());
            if (m22141s() != graphQLNode) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13312m = graphQLNode;
            }
        }
        if (m22142t() != null) {
            graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.b(m22142t());
            if (m22142t() != graphQLNode) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13313n = graphQLNode;
            }
        }
        if (m22143u() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.b(m22143u());
            if (m22143u() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13314o = graphQLPrivacyScope;
            }
        }
        if (m22144v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m22144v());
            if (m22144v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13315p = graphQLImage;
            }
        }
        if (m22145w() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m22145w());
            if (m22145w() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13316q = graphQLImage;
            }
        }
        if (m22146x() != null) {
            GraphQLRating graphQLRating = (GraphQLRating) graphQLModelMutatingVisitor.b(m22146x());
            if (m22146x() != graphQLRating) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13317r = graphQLRating;
            }
        }
        if (m22147y() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.b(m22147y());
            if (m22147y() != feedUnit) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13318s = feedUnit;
            }
        }
        if (m22148z() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m22148z());
            if (m22148z() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13319t = graphQLTextWithEntities;
            }
        }
        if (m22121A() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m22121A());
            if (m22121A() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13320u = graphQLImage;
            }
        }
        if (m22122B() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m22122B());
            if (m22122B() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13321v = graphQLTextWithEntities;
            }
        }
        if (m22123C() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m22123C());
            if (m22123C() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13322w = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void m22130a(String str, ConsistencyTuple consistencyTuple) {
        if ("locally_updated_containing_collection_id".equals(str)) {
            consistencyTuple.a = m22125E();
            consistencyTuple.b = u_();
            consistencyTuple.c = 23;
            return;
        }
        consistencyTuple.a();
    }

    public final void m22131a(String str, Object obj, boolean z) {
        if ("locally_updated_containing_collection_id".equals(str)) {
            String str2 = (String) obj;
            this.f13324y = str2;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 23, str2);
            }
        }
    }

    public GraphQLTimelineAppCollectionItem() {
        super(25);
    }

    public final void m22129a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13305f = mutableFlatBuffer.a(i, 2, 0);
    }

    public final int m22126a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22132j());
        int a2 = ModelHelper.a(flatBufferBuilder, m22135m());
        int a3 = ModelHelper.a(flatBufferBuilder, m22136n());
        int a4 = ModelHelper.a(flatBufferBuilder, m22137o());
        int b = flatBufferBuilder.b(m22138p());
        int a5 = ModelHelper.a(flatBufferBuilder, m22139q());
        int a6 = ModelHelper.a(flatBufferBuilder, m22140r());
        int a7 = ModelHelper.a(flatBufferBuilder, m22141s());
        int a8 = ModelHelper.a(flatBufferBuilder, m22142t());
        int a9 = ModelHelper.a(flatBufferBuilder, m22143u());
        int a10 = ModelHelper.a(flatBufferBuilder, m22144v());
        int a11 = ModelHelper.a(flatBufferBuilder, m22145w());
        int a12 = ModelHelper.a(flatBufferBuilder, m22146x());
        int a13 = flatBufferBuilder.a(m22147y(), VirtualFlattenableResolverImpl.a);
        int a14 = ModelHelper.a(flatBufferBuilder, m22148z());
        int a15 = ModelHelper.a(flatBufferBuilder, m22121A());
        int a16 = ModelHelper.a(flatBufferBuilder, m22122B());
        int a17 = ModelHelper.a(flatBufferBuilder, m22123C());
        int b2 = flatBufferBuilder.b(m22124D());
        int b3 = flatBufferBuilder.b(m22125E());
        flatBufferBuilder.c(24);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m22133k() == GraphQLTimelineAppCollectionItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m22133k());
        flatBufferBuilder.a(2, m22134l(), 0);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(6, a4);
        flatBufferBuilder.b(7, b);
        flatBufferBuilder.b(8, a5);
        flatBufferBuilder.b(9, a6);
        flatBufferBuilder.b(10, a7);
        flatBufferBuilder.b(11, a8);
        flatBufferBuilder.b(12, a9);
        flatBufferBuilder.b(13, a10);
        flatBufferBuilder.b(14, a11);
        flatBufferBuilder.b(15, a12);
        flatBufferBuilder.b(17, a13);
        flatBufferBuilder.b(18, a14);
        flatBufferBuilder.b(19, a15);
        flatBufferBuilder.b(20, a16);
        flatBufferBuilder.b(21, a17);
        flatBufferBuilder.b(22, b2);
        flatBufferBuilder.b(23, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTimelineAppCollectionItem(Parcel parcel) {
        super(25);
        this.f13303d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13304e = GraphQLTimelineAppCollectionItemType.fromString(parcel.readString());
        this.f13305f = parcel.readLong();
        this.f13306g = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f13307h = (GraphQLExternalUrl) parcel.readValue(GraphQLExternalUrl.class.getClassLoader());
        this.f13308i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13309j = parcel.readString();
        this.f13310k = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13311l = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13324y = parcel.readString();
        this.f13312m = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
        this.f13313n = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
        this.f13314o = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f13315p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13316q = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13317r = (GraphQLRating) parcel.readValue(GraphQLRating.class.getClassLoader());
        this.f13318s = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
        this.f13319t = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13320u = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13321v = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13322w = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13323x = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22132j());
        parcel.writeString(m22133k().name());
        parcel.writeLong(m22134l());
        parcel.writeValue(m22135m());
        parcel.writeValue(m22136n());
        parcel.writeValue(m22137o());
        parcel.writeString(m22138p());
        parcel.writeValue(m22139q());
        parcel.writeValue(m22140r());
        parcel.writeString(m22125E());
        parcel.writeValue(m22141s());
        parcel.writeValue(m22142t());
        parcel.writeValue(m22143u());
        parcel.writeValue(m22144v());
        parcel.writeValue(m22145w());
        parcel.writeValue(m22146x());
        parcel.writeValue(m22147y());
        parcel.writeValue(m22148z());
        parcel.writeValue(m22121A());
        parcel.writeValue(m22122B());
        parcel.writeValue(m22123C());
        parcel.writeString(m22124D());
    }
}
