package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: location must have latitude/longitude */
public final class GraphQLTimelineAppSection extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLTimelineAppSection> CREATOR = new 1();
    @Nullable
    GraphQLTimelineAppCollectionsConnection f16711d;
    @Nullable
    GraphQLTimelineAppCollectionsConnection f16712e;
    @Nullable
    GraphQLTimelineAppCollectionsConnection f16713f;
    @Nullable
    GraphQLImage f16714g;
    @Nullable
    String f16715h;
    @Nullable
    String f16716i;
    GraphQLTimelineAppSectionType f16717j;
    @Nullable
    String f16718k;
    @Nullable
    GraphQLTextWithEntities f16719l;
    @Nullable
    GraphQLTextWithEntities f16720m;
    @Nullable
    GraphQLTextWithEntities f16721n;
    @Nullable
    String f16722o;
    @Nullable
    String f16723p;

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollectionsConnection m23623j() {
        this.f16711d = (GraphQLTimelineAppCollectionsConnection) super.m9947a(this.f16711d, 0, GraphQLTimelineAppCollectionsConnection.class);
        return this.f16711d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollectionsConnection m23624k() {
        this.f16712e = (GraphQLTimelineAppCollectionsConnection) super.m9947a(this.f16712e, 1, GraphQLTimelineAppCollectionsConnection.class);
        return this.f16712e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollectionsConnection m23625l() {
        this.f16713f = (GraphQLTimelineAppCollectionsConnection) super.m9947a(this.f16713f, 2, GraphQLTimelineAppCollectionsConnection.class);
        return this.f16713f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23626m() {
        this.f16714g = (GraphQLImage) super.m9947a(this.f16714g, 4, GraphQLImage.class);
        return this.f16714g;
    }

    @FieldOffset
    @Nullable
    public final String m23627n() {
        this.f16715h = super.m9948a(this.f16715h, 5);
        return this.f16715h;
    }

    @FieldOffset
    @Nullable
    public final String m23628o() {
        this.f16716i = super.m9948a(this.f16716i, 6);
        return this.f16716i;
    }

    @FieldOffset
    public final GraphQLTimelineAppSectionType m23629p() {
        this.f16717j = (GraphQLTimelineAppSectionType) super.m9945a(this.f16717j, 7, GraphQLTimelineAppSectionType.class, GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16717j;
    }

    @FieldOffset
    @Nullable
    public final String m23630q() {
        this.f16718k = super.m9948a(this.f16718k, 9);
        return this.f16718k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23631r() {
        this.f16719l = (GraphQLTextWithEntities) super.m9947a(this.f16719l, 10, GraphQLTextWithEntities.class);
        return this.f16719l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23632s() {
        this.f16720m = (GraphQLTextWithEntities) super.m9947a(this.f16720m, 11, GraphQLTextWithEntities.class);
        return this.f16720m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23633t() {
        this.f16721n = (GraphQLTextWithEntities) super.m9947a(this.f16721n, 12, GraphQLTextWithEntities.class);
        return this.f16721n;
    }

    @FieldOffset
    @Nullable
    public final String m23634u() {
        this.f16722o = super.m9948a(this.f16722o, 13);
        return this.f16722o;
    }

    @FieldOffset
    @Nullable
    public final String m23635v() {
        this.f16723p = super.m9948a(this.f16723p, 14);
        return this.f16723p;
    }

    @Nullable
    public final String mo2834a() {
        return m23627n();
    }

    public final int jK_() {
        return 1842803909;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTimelineAppCollectionsConnection graphQLTimelineAppCollectionsConnection;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23623j() != null) {
            graphQLTimelineAppCollectionsConnection = (GraphQLTimelineAppCollectionsConnection) graphQLModelMutatingVisitor.mo2928b(m23623j());
            if (m23623j() != graphQLTimelineAppCollectionsConnection) {
                graphQLVisitableModel = (GraphQLTimelineAppSection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16711d = graphQLTimelineAppCollectionsConnection;
            }
        }
        if (m23624k() != null) {
            graphQLTimelineAppCollectionsConnection = (GraphQLTimelineAppCollectionsConnection) graphQLModelMutatingVisitor.mo2928b(m23624k());
            if (m23624k() != graphQLTimelineAppCollectionsConnection) {
                graphQLVisitableModel = (GraphQLTimelineAppSection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16712e = graphQLTimelineAppCollectionsConnection;
            }
        }
        if (m23625l() != null) {
            graphQLTimelineAppCollectionsConnection = (GraphQLTimelineAppCollectionsConnection) graphQLModelMutatingVisitor.mo2928b(m23625l());
            if (m23625l() != graphQLTimelineAppCollectionsConnection) {
                graphQLVisitableModel = (GraphQLTimelineAppSection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16713f = graphQLTimelineAppCollectionsConnection;
            }
        }
        if (m23626m() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23626m());
            if (m23626m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTimelineAppSection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16714g = graphQLImage;
            }
        }
        if (m23631r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23631r());
            if (m23631r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLTimelineAppSection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16719l = graphQLTextWithEntities;
            }
        }
        if (m23632s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23632s());
            if (m23632s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLTimelineAppSection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16720m = graphQLTextWithEntities;
            }
        }
        if (m23633t() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23633t());
            if (m23633t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLTimelineAppSection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16721n = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTimelineAppSection() {
        super(16);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23623j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23624k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23625l());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23626m());
        int b = flatBufferBuilder.m21502b(m23627n());
        int b2 = flatBufferBuilder.m21502b(m23628o());
        int b3 = flatBufferBuilder.m21502b(m23630q());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23631r());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23632s());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m23633t());
        int b4 = flatBufferBuilder.m21502b(m23634u());
        int b5 = flatBufferBuilder.m21502b(m23635v());
        flatBufferBuilder.m21510c(15);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(4, a4);
        flatBufferBuilder.m21507b(5, b);
        flatBufferBuilder.m21507b(6, b2);
        flatBufferBuilder.m21496a(7, m23629p() == GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23629p());
        flatBufferBuilder.m21507b(9, b3);
        flatBufferBuilder.m21507b(10, a5);
        flatBufferBuilder.m21507b(11, a6);
        flatBufferBuilder.m21507b(12, a7);
        flatBufferBuilder.m21507b(13, b4);
        flatBufferBuilder.m21507b(14, b5);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTimelineAppSection(Parcel parcel) {
        super(16);
        this.f16711d = (GraphQLTimelineAppCollectionsConnection) parcel.readValue(GraphQLTimelineAppCollectionsConnection.class.getClassLoader());
        this.f16712e = (GraphQLTimelineAppCollectionsConnection) parcel.readValue(GraphQLTimelineAppCollectionsConnection.class.getClassLoader());
        this.f16713f = (GraphQLTimelineAppCollectionsConnection) parcel.readValue(GraphQLTimelineAppCollectionsConnection.class.getClassLoader());
        this.f16714g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16715h = parcel.readString();
        this.f16716i = parcel.readString();
        this.f16717j = GraphQLTimelineAppSectionType.fromString(parcel.readString());
        this.f16718k = parcel.readString();
        this.f16719l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16720m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16721n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16722o = parcel.readString();
        this.f16723p = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m23623j());
        parcel.writeValue(m23624k());
        parcel.writeValue(m23625l());
        parcel.writeValue(m23626m());
        parcel.writeString(m23627n());
        parcel.writeString(m23628o());
        parcel.writeString(m23629p().name());
        parcel.writeString(m23630q());
        parcel.writeValue(m23631r());
        parcel.writeValue(m23632s());
        parcel.writeValue(m23633t());
        parcel.writeString(m23634u());
        parcel.writeString(m23635v());
    }
}
