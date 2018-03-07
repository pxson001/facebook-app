package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: short */
public final class GraphQLGoodwillHappyBirthdayCard extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillHappyBirthdayCard> CREATOR = new 1();
    public List<GraphQLStoryActionLink> f2217d;
    @Nullable
    public GraphQLGoodwillHappyBirthdayStoriesConnection f2218e;
    @Nullable
    public GraphQLImage f2219f;
    @Nullable
    public GraphQLTextWithEntities f2220g;
    @Nullable
    public GraphQLTextWithEntities f2221h;

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m2408a() {
        this.f2217d = super.a(this.f2217d, 0, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f2217d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillHappyBirthdayStoriesConnection m2409j() {
        this.f2218e = (GraphQLGoodwillHappyBirthdayStoriesConnection) super.a(this.f2218e, 1, GraphQLGoodwillHappyBirthdayStoriesConnection.class);
        return this.f2218e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m2410k() {
        this.f2219f = (GraphQLImage) super.a(this.f2219f, 2, GraphQLImage.class);
        return this.f2219f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m2411l() {
        this.f2220g = (GraphQLTextWithEntities) super.a(this.f2220g, 3, GraphQLTextWithEntities.class);
        return this.f2220g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m2412m() {
        this.f2221h = (GraphQLTextWithEntities) super.a(this.f2221h, 4, GraphQLTextWithEntities.class);
        return this.f2221h;
    }

    public final int jK_() {
        return -943604802;
    }

    public final GraphQLVisitableModel m2407a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLGoodwillHappyBirthdayStoriesConnection graphQLGoodwillHappyBirthdayStoriesConnection;
        GraphQLImage graphQLImage;
        GraphQLTextWithEntities graphQLTextWithEntities;
        h();
        if (m2408a() != null) {
            Builder a = ModelHelper.a(m2408a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGoodwillHappyBirthdayCard graphQLGoodwillHappyBirthdayCard = (GraphQLGoodwillHappyBirthdayCard) ModelHelper.a(null, this);
                graphQLGoodwillHappyBirthdayCard.f2217d = a.b();
                graphQLVisitableModel = graphQLGoodwillHappyBirthdayCard;
                if (m2409j() != null) {
                    graphQLGoodwillHappyBirthdayStoriesConnection = (GraphQLGoodwillHappyBirthdayStoriesConnection) graphQLModelMutatingVisitor.b(m2409j());
                    if (m2409j() != graphQLGoodwillHappyBirthdayStoriesConnection) {
                        graphQLVisitableModel = (GraphQLGoodwillHappyBirthdayCard) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2218e = graphQLGoodwillHappyBirthdayStoriesConnection;
                    }
                }
                if (m2410k() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m2410k());
                    if (m2410k() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLGoodwillHappyBirthdayCard) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2219f = graphQLImage;
                    }
                }
                if (m2411l() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m2411l());
                    if (m2411l() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGoodwillHappyBirthdayCard) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2220g = graphQLTextWithEntities;
                    }
                }
                if (m2412m() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m2412m());
                    if (m2412m() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGoodwillHappyBirthdayCard) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2221h = graphQLTextWithEntities;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m2409j() != null) {
            graphQLGoodwillHappyBirthdayStoriesConnection = (GraphQLGoodwillHappyBirthdayStoriesConnection) graphQLModelMutatingVisitor.b(m2409j());
            if (m2409j() != graphQLGoodwillHappyBirthdayStoriesConnection) {
                graphQLVisitableModel = (GraphQLGoodwillHappyBirthdayCard) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f2218e = graphQLGoodwillHappyBirthdayStoriesConnection;
            }
        }
        if (m2410k() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m2410k());
            if (m2410k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillHappyBirthdayCard) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f2219f = graphQLImage;
            }
        }
        if (m2411l() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m2411l());
            if (m2411l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillHappyBirthdayCard) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f2220g = graphQLTextWithEntities;
            }
        }
        if (m2412m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m2412m());
            if (m2412m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillHappyBirthdayCard) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f2221h = graphQLTextWithEntities;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLGoodwillHappyBirthdayCard() {
        super(6);
    }

    public final int m2406a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2408a());
        int a2 = ModelHelper.a(flatBufferBuilder, m2409j());
        int a3 = ModelHelper.a(flatBufferBuilder, m2410k());
        int a4 = ModelHelper.a(flatBufferBuilder, m2411l());
        int a5 = ModelHelper.a(flatBufferBuilder, m2412m());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, a4);
        flatBufferBuilder.b(4, a5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillHappyBirthdayCard(Parcel parcel) {
        super(6);
        this.f2217d = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f2218e = (GraphQLGoodwillHappyBirthdayStoriesConnection) parcel.readValue(GraphQLGoodwillHappyBirthdayStoriesConnection.class.getClassLoader());
        this.f2219f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f2220g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f2221h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m2408a());
        parcel.writeValue(m2409j());
        parcel.writeValue(m2410k());
        parcel.writeValue(m2411l());
        parcel.writeValue(m2412m());
    }
}
