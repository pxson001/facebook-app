package com.facebook.photos.mediagallery.ui.tagging;

import android.graphics.RectF;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.tagging.TaggingHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.FaceBoxInfo;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.TagInfoQuery.Edges;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxInfoModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: slideshow_picker_nux_dismissed */
public class TagToFaceBoxMapper {
    private final TaggingHelper f2504a;
    private final FaceBoxInfoUtils f2505b;
    public LinkedList<Edges> f2506c = Lists.b();
    public BiMap<RectF, FaceBoxInfo> f2507d = HashBiMap.a();
    public BiMap<Edges, FaceBoxInfo> f2508e = HashBiMap.a();

    public static TagToFaceBoxMapper m2641a(InjectorLike injectorLike) {
        return new TagToFaceBoxMapper(TaggingHelper.a(injectorLike), FaceBoxInfoUtils.m2618a(injectorLike));
    }

    @Inject
    public TagToFaceBoxMapper(TaggingHelper taggingHelper, FaceBoxInfoUtils faceBoxInfoUtils) {
        this.f2504a = taggingHelper;
        this.f2505b = faceBoxInfoUtils;
    }

    public final ImmutableBiMap<RectF, FaceBoxInfo> m2642a() {
        return ImmutableBiMap.a(this.f2507d);
    }

    public final void m2643a(@Nullable MediaMetadata mediaMetadata) {
        this.f2506c.clear();
        this.f2507d.clear();
        this.f2508e.clear();
        if (mediaMetadata != null) {
            if (!(mediaMetadata.U() == null || mediaMetadata.U().a() == null)) {
                this.f2506c.addAll(mediaMetadata.U().a());
            }
            if (!(mediaMetadata.B() == null || mediaMetadata.B().a() == null)) {
                ImmutableList a = mediaMetadata.B().a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    FaceBoxInfoModel faceBoxInfoModel = (FaceBoxInfoModel) a.get(i);
                    if (!(faceBoxInfoModel.b() == null || faceBoxInfoModel.c() == null)) {
                        this.f2507d.put(FaceBoxInfoUtils.m2616a(faceBoxInfoModel), faceBoxInfoModel);
                    }
                }
            }
            ListIterator listIterator = this.f2506c.listIterator();
            while (listIterator.hasNext()) {
                EdgesModel edgesModel = (EdgesModel) listIterator.next();
                FaceBoxInfoModel faceBoxInfoModel2 = null;
                double d = Double.MAX_VALUE;
                for (FaceBoxInfoModel faceBoxInfoModel3 : this.f2507d.c()) {
                    FaceBoxInfoModel faceBoxInfoModel32;
                    double a2 = m2639a(edgesModel, faceBoxInfoModel32);
                    if (a2 >= 1.5d || (faceBoxInfoModel2 != null && a2 >= r2)) {
                        faceBoxInfoModel32 = faceBoxInfoModel2;
                    } else {
                        d = a2;
                    }
                    faceBoxInfoModel2 = faceBoxInfoModel32;
                }
                if (faceBoxInfoModel2 != null && m2640a(faceBoxInfoModel2, this.f2506c) == edgesModel) {
                    this.f2508e.put(edgesModel, faceBoxInfoModel2);
                    this.f2507d.a_().remove(faceBoxInfoModel2);
                    listIterator.remove();
                }
            }
        }
    }

    @Nullable
    private Edges m2640a(FaceBoxInfo faceBoxInfo, LinkedList<Edges> linkedList) {
        Edges edges = null;
        double d = Double.MAX_VALUE;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            EdgesModel edgesModel = (EdgesModel) it.next();
            if (!this.f2508e.containsKey(edgesModel)) {
                EdgesModel edgesModel2;
                double d2;
                double a = m2639a(edgesModel, (FaceBoxInfoModel) faceBoxInfo);
                if (a < d) {
                    double d3 = a;
                    edgesModel2 = edgesModel;
                    d2 = d3;
                } else {
                    edgesModel2 = edges;
                    d2 = d;
                }
                d = d2;
                edges = edgesModel2;
            }
        }
        return edges;
    }

    private double m2639a(EdgesModel edgesModel, FaceBoxInfoModel faceBoxInfoModel) {
        Preconditions.checkNotNull(edgesModel);
        Preconditions.checkNotNull(faceBoxInfoModel);
        return TaggingHelper.a((float) edgesModel.c().b().a(), (float) edgesModel.c().b().b(), (float) faceBoxInfoModel.b().a(), (float) faceBoxInfoModel.b().b(), FaceBoxInfoUtils.m2616a(faceBoxInfoModel));
    }
}
