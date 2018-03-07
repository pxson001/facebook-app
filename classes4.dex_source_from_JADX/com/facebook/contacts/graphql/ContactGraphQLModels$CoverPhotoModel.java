package com.facebook.contacts.graphql;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -875281755)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: requires_approval */
public final class ContactGraphQLModels$CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private PhotoModel f3689d;

    public ContactGraphQLModels$CoverPhotoModel() {
        super(1);
    }

    public ContactGraphQLModels$CoverPhotoModel(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    public final PhotoModel m4133a() {
        this.f3689d = (PhotoModel) super.a(this.f3689d, 0, PhotoModel.class);
        return this.f3689d;
    }

    public final int jK_() {
        return 497264923;
    }

    public final GraphQLVisitableModel m4134a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m4133a() != null) {
            PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m4133a());
            if (m4133a() != photoModel) {
                graphQLVisitableModel = (ContactGraphQLModels$CoverPhotoModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f3689d = photoModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m4132a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m4133a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
