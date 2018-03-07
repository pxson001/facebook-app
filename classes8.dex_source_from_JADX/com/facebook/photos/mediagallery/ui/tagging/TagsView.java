package com.facebook.photos.mediagallery.ui.tagging;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.FaceBoxInfo;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.TagInfoQuery.Edges;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxInfoModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel;
import com.facebook.photos.mediagallery.ui.tagging.MediaTaggingController.C03002;
import com.facebook.photos.tagging.shared.layout.TagWithFacebox;
import com.facebook.photos.tagging.shared.layout.TagsViewLayoutHelper;
import com.facebook.photos.tagging.shared.layout.TagsViewLayoutHelperProvider;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: skip_query */
public class TagsView extends CustomFrameLayout {
    private final C03002 f2569a;
    public TagsViewLayoutHelper<TagView> f2570b;
    private FaceBoxInfoUtils f2571c;
    private BiMap<TagView, Edges> f2572d = HashBiMap.a();

    @Inject
    public TagsView(@Assisted Context context, @Assisted C03002 c03002, TagsViewLayoutHelperProvider tagsViewLayoutHelperProvider, FaceBoxInfoUtils faceBoxInfoUtils) {
        super(context);
        this.f2569a = c03002;
        this.f2570b = tagsViewLayoutHelperProvider.a(this, getResources().getDimension(2131430317));
        this.f2571c = faceBoxInfoUtils;
    }

    public final void m2673a(ImmutableList<Edges> immutableList, ImmutableSet<RectF> immutableSet, ImmutableBiMap<Edges, FaceBoxInfo> immutableBiMap) {
        removeAllViews();
        this.f2572d.clear();
        List<EdgesModel> a = Lists.a(immutableList);
        a.addAll(immutableBiMap.keySet());
        for (EdgesModel edgesModel : a) {
            TagView a2 = m2670a(edgesModel);
            addView(a2, new LayoutParams(-2, -2));
            this.f2572d.put(a2, edgesModel);
        }
        Map c = Maps.c();
        for (EdgesModel edgesModel2 : a) {
            FaceBoxInfoModel faceBoxInfoModel = (FaceBoxInfoModel) immutableBiMap.get(edgesModel2);
            c.put(this.f2572d.a_().get(edgesModel2), new TagWithFacebox(new PointF((float) edgesModel2.c().b().a(), (float) edgesModel2.c().b().b()), faceBoxInfoModel != null ? FaceBoxInfoUtils.m2616a(faceBoxInfoModel) : null));
        }
        this.f2570b.a(immutableSet);
        this.f2570b.a(c);
    }

    @Nullable
    public final EdgesModel m2671a(TagView tagView) {
        Preconditions.checkNotNull(tagView);
        return (EdgesModel) this.f2572d.get(tagView);
    }

    public final void m2672a() {
        for (TagView tagView : this.f2572d.keySet()) {
            if (tagView.f2536c.isShown()) {
                tagView.startAnimation(tagView.f2544l);
            }
        }
    }

    private TagView m2670a(EdgesModel edgesModel) {
        return new TagView(getContext(), edgesModel.c().a(), false, edgesModel.b().d(), this.f2569a);
    }
}
