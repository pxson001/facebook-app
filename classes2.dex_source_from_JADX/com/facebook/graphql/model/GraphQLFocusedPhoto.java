package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: local_story_visibility */
public final class GraphQLFocusedPhoto extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFocusedPhoto> CREATOR = new C08071();
    @Nullable
    public GraphQLVect2 f17008d;
    @Nullable
    public GraphQLPhoto f17009e;

    /* compiled from: local_story_visibility */
    final class C08071 implements Creator<GraphQLFocusedPhoto> {
        C08071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFocusedPhoto(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFocusedPhoto[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLVect2 m23995a() {
        this.f17008d = (GraphQLVect2) super.m9947a(this.f17008d, 0, GraphQLVect2.class);
        return this.f17008d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m23997j() {
        this.f17009e = (GraphQLPhoto) super.m9947a(this.f17009e, 1, GraphQLPhoto.class);
        return this.f17009e;
    }

    public final int jK_() {
        return 497264923;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23995a() != null) {
            GraphQLVect2 graphQLVect2 = (GraphQLVect2) graphQLModelMutatingVisitor.mo2928b(m23995a());
            if (m23995a() != graphQLVect2) {
                graphQLVisitableModel = (GraphQLFocusedPhoto) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17008d = graphQLVect2;
            }
        }
        if (m23997j() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(m23997j());
            if (m23997j() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLFocusedPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17009e = graphQLPhoto;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFocusedPhoto() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23995a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23997j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFocusedPhoto(Parcel parcel) {
        super(3);
        this.f17008d = (GraphQLVect2) parcel.readValue(GraphQLVect2.class.getClassLoader());
        this.f17009e = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m23995a());
        parcel.writeValue(m23997j());
    }

    public GraphQLFocusedPhoto(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17008d = builder.d;
        this.f17009e = builder.e;
    }
}
