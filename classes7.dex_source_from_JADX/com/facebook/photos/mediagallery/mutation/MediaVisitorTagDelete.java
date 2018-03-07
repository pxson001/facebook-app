package com.facebook.photos.mediagallery.mutation;

import com.facebook.common.util.StringUtil;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: is_rich_notif */
public class MediaVisitorTagDelete extends MediaVisitor {

    /* compiled from: is_rich_notif */
    class C09211 extends SimpleMediaTransform {
        final /* synthetic */ NodeModel f10775a;

        C09211(String str, NodeModel nodeModel) {
            this.f10775a = nodeModel;
            super(str);
        }

        public final MediaMetadataModel mo605a(MediaMetadataModel mediaMetadataModel) {
            if (mediaMetadataModel.as() == null || mediaMetadataModel.as().a() == null) {
                return mediaMetadataModel;
            }
            Builder builder = ImmutableList.builder();
            ImmutableList a = mediaMetadataModel.as().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                NodeModel j = edgesModel.j();
                NodeModel nodeModel = this.f10775a;
                Object obj = null;
                Preconditions.checkNotNull(nodeModel);
                if (j != null && StringUtil.a(j.d(), nodeModel.d()) && (j.c().equals(nodeModel.c()) || nodeModel.c().equals("-1"))) {
                    obj = 1;
                }
                if (obj == null) {
                    builder.c(edgesModel);
                } else {
                    this.f10775a.c();
                    this.f10775a.d();
                }
            }
            TagInfoQueryModel.Builder builder2 = new TagInfoQueryModel.Builder();
            builder2.a = builder.b();
            TagInfoQueryModel a2 = builder2.a();
            MediaMetadataModel.Builder a3 = MediaMetadataModel.Builder.a(mediaMetadataModel);
            a3.S = a2;
            return a3.a();
        }
    }

    public MediaVisitorTagDelete(String str, NodeModel nodeModel) {
        super(str, new C09211(str, nodeModel));
    }
}
