package com.facebook.photos.pandora.protocols;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import javax.annotation.Nullable;

/* compiled from: has_unread_content */
public class PandoraQueryInterfaces {

    /* compiled from: has_unread_content */
    public interface PandoraMediaImageWithFeedbackFields extends SizeAwareMedia {
        @Nullable
        GraphQLObjectType mo1104b();

        @Nullable
        DefaultImageFields bc_();

        @Nullable
        DefaultImageFields bd_();

        @Nullable
        DefaultImageFields be_();

        @Nullable
        DefaultVect2Fields mo1108c();

        @Nullable
        String mo1109d();

        @Nullable
        DefaultImageFields mo1110g();

        @Nullable
        DefaultFeedbackFields mo1111l();

        @Nullable
        DefaultImageFields mo1112n();

        @Nullable
        DefaultImageFields mo1113q();

        @Nullable
        DefaultImageFields mo1114r();

        @Nullable
        DefaultImageFields mo1115s();

        @Nullable
        DefaultImageFields mo1116u();

        @Nullable
        DefaultImageFields mo1117v();

        @Nullable
        DefaultImageFields mo1118y();

        @Nullable
        DefaultImageFields mo1119z();
    }
}
