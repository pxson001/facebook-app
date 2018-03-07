package com.facebook.photos.mediagallery.mutation;

import android.graphics.PointF;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoModel.TaggerModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: is_saved_place */
public class MediaVisitorTagAdd extends MediaVisitor {

    /* compiled from: is_saved_place */
    class C09201 extends SimpleMediaTransform {
        final /* synthetic */ String f10771a;
        final /* synthetic */ String f10772b;
        final /* synthetic */ double f10773c;
        final /* synthetic */ double f10774d;

        C09201(String str, String str2, String str3, double d, double d2) {
            this.f10771a = str2;
            this.f10772b = str3;
            this.f10773c = d;
            this.f10774d = d2;
            super(str);
        }

        public final MediaMetadataModel mo605a(MediaMetadataModel mediaMetadataModel) {
            Builder builder = ImmutableList.builder();
            if (!(mediaMetadataModel.as() == null || mediaMetadataModel.as().a() == null)) {
                builder.b(mediaMetadataModel.as().a());
                ImmutableList a = mediaMetadataModel.as().a();
                int size = a.size();
                int i = 0;
                while (i < size) {
                    EdgesModel edgesModel = (EdgesModel) a.get(i);
                    String c = edgesModel.j().c();
                    String d = edgesModel.j().d();
                    if (d == null || this.f10771a == null || !d.equals(this.f10771a) || c == null || this.f10772b == null || !c.equals(this.f10772b)) {
                        i++;
                    } else {
                        BLog.c("MediaVisitorTagAdd", "MG.Tag added multiple times for same user");
                        return mediaMetadataModel;
                    }
                }
            }
            Double.valueOf(this.f10773c);
            Double.valueOf(this.f10774d);
            builder.c(MediaVisitorTagAdd.m12798b(this.f10772b, this.f10773c, this.f10774d, this.f10771a));
            TagInfoQueryModel.Builder builder2 = new TagInfoQueryModel.Builder();
            builder2.a = builder.b();
            TagInfoQueryModel a2 = builder2.a();
            MediaMetadataModel.Builder a3 = MediaMetadataModel.Builder.a(mediaMetadataModel);
            a3.S = a2;
            return a3.a();
        }
    }

    private static EdgesModel m12798b(String str, double d, double d2, String str2) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        TagInfoModel.Builder builder = new TagInfoModel.Builder();
        TaggerModel.Builder builder2 = new TaggerModel.Builder();
        builder2.b = str2;
        builder2 = builder2;
        builder2.a = new GraphQLObjectType(2645995);
        builder.c = builder2.a();
        builder = builder;
        builder.a = true;
        builder = builder;
        DefaultVect2FieldsModel.Builder builder3 = new DefaultVect2FieldsModel.Builder();
        builder3.a = d;
        builder3 = builder3;
        builder3.b = d2;
        builder.b = builder3.a();
        TagInfoModel a = builder.a();
        int i = str.equals("-1") ? -776825814 : 2645995;
        EdgesModel.Builder builder4 = new EdgesModel.Builder();
        builder4.a = str;
        builder4 = builder4;
        NodeModel.Builder builder5 = new NodeModel.Builder();
        builder5.b = str;
        builder5 = builder5;
        builder5.c = str2;
        builder5 = builder5;
        builder5.a = new GraphQLObjectType(i);
        builder4.b = builder5.a();
        EdgesModel.Builder builder6 = builder4;
        builder6.c = a;
        return builder6.a();
    }

    public MediaVisitorTagAdd(String str, TaggingProfile taggingProfile, PointF pointF) {
        this(str, Long.toString(taggingProfile.b), taggingProfile.a.i(), (double) pointF.x, (double) pointF.y);
    }

    private MediaVisitorTagAdd(String str, String str2, String str3, double d, double d2) {
        super(str, new C09201(str, str3, str2, d, d2));
    }
}
