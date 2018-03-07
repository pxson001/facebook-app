package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLStoryHeaderStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: len is negative */
public final class GraphQLStoryHeader extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStoryHeader> CREATOR = new C09231();
    @Nullable
    GraphQLStoryActionLink f17673d;
    @Nullable
    GraphQLImage f17674e;
    @Nullable
    GraphQLTextWithEntities f17675f;
    @Nullable
    GraphQLImage f17676g;
    List<GraphQLStoryHeaderStyle> f17677h;
    @Nullable
    GraphQLTextWithEntities f17678i;
    @Nullable
    GraphQLTextWithEntities f17679j;

    /* compiled from: len is negative */
    final class C09231 implements Creator<GraphQLStoryHeader> {
        C09231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStoryHeader(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStoryHeader[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryActionLink m24862a() {
        this.f17673d = (GraphQLStoryActionLink) super.m9947a(this.f17673d, 0, GraphQLStoryActionLink.class);
        return this.f17673d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24864j() {
        this.f17674e = (GraphQLImage) super.m9947a(this.f17674e, 1, GraphQLImage.class);
        return this.f17674e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24865k() {
        this.f17675f = (GraphQLTextWithEntities) super.m9947a(this.f17675f, 2, GraphQLTextWithEntities.class);
        return this.f17675f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24866l() {
        this.f17676g = (GraphQLImage) super.m9947a(this.f17676g, 3, GraphQLImage.class);
        return this.f17676g;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryHeaderStyle> m24867m() {
        this.f17677h = super.m9953b(this.f17677h, 4, GraphQLStoryHeaderStyle.class);
        return (ImmutableList) this.f17677h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24868n() {
        this.f17678i = (GraphQLTextWithEntities) super.m9947a(this.f17678i, 5, GraphQLTextWithEntities.class);
        return this.f17678i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24869o() {
        this.f17679j = (GraphQLTextWithEntities) super.m9947a(this.f17679j, 6, GraphQLTextWithEntities.class);
        return this.f17679j;
    }

    public final int jK_() {
        return 80421826;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24862a() != null) {
            GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) graphQLModelMutatingVisitor.mo2928b(m24862a());
            if (m24862a() != graphQLStoryActionLink) {
                graphQLVisitableModel = (GraphQLStoryHeader) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17673d = graphQLStoryActionLink;
            }
        }
        if (m24864j() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24864j());
            if (m24864j() != graphQLImage) {
                graphQLVisitableModel = (GraphQLStoryHeader) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17674e = graphQLImage;
            }
        }
        if (m24865k() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24865k());
            if (m24865k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryHeader) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17675f = graphQLTextWithEntities;
            }
        }
        if (m24866l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24866l());
            if (m24866l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLStoryHeader) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17676g = graphQLImage;
            }
        }
        if (m24868n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24868n());
            if (m24868n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryHeader) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17678i = graphQLTextWithEntities;
            }
        }
        if (m24869o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24869o());
            if (m24869o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryHeader) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17679j = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLStoryHeader() {
        super(8);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24862a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24864j());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24865k());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24866l());
        int e = flatBufferBuilder.m21514e(m24867m());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24868n());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m24869o());
        flatBufferBuilder.m21510c(7);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, a4);
        flatBufferBuilder.m21507b(4, e);
        flatBufferBuilder.m21507b(5, a5);
        flatBufferBuilder.m21507b(6, a6);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStoryHeader(Parcel parcel) {
        super(8);
        this.f17673d = (GraphQLStoryActionLink) parcel.readValue(GraphQLStoryActionLink.class.getClassLoader());
        this.f17674e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17675f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17676g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17677h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryHeaderStyle.class.getClassLoader()));
        this.f17678i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17679j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24862a());
        parcel.writeValue(m24864j());
        parcel.writeValue(m24865k());
        parcel.writeValue(m24866l());
        parcel.writeList(m24867m());
        parcel.writeValue(m24868n());
        parcel.writeValue(m24869o());
    }
}
