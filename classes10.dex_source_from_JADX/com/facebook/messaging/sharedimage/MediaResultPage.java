package com.facebook.messaging.sharedimage;

import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryModels.PhotoNodeInfoModel;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryModels.SubsequentSharedPhotosModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: r_{i-1} was zero */
public class MediaResultPage {
    private static final Class<?> f3995g = MediaResultPage.class;
    @Nullable
    public final String f3996a;
    @Nullable
    public final String f3997b;
    public final boolean f3998c;
    public final boolean f3999d;
    public final int f4000e;
    public final ImmutableList<SharedImage> f4001f;

    MediaResultPage(SubsequentSharedPhotosModel subsequentSharedPhotosModel, @Nullable DefaultPageInfoFieldsModel defaultPageInfoFieldsModel) {
        boolean c;
        String str = null;
        int i = 0;
        this.f3996a = defaultPageInfoFieldsModel != null ? defaultPageInfoFieldsModel.v_() : null;
        if (defaultPageInfoFieldsModel != null) {
            str = defaultPageInfoFieldsModel.a();
        }
        this.f3997b = str;
        if (defaultPageInfoFieldsModel != null) {
            c = defaultPageInfoFieldsModel.c();
        } else {
            c = false;
        }
        this.f3998c = c;
        c = defaultPageInfoFieldsModel != null ? defaultPageInfoFieldsModel.b() && this.f3997b != null : false;
        this.f3999d = c;
        this.f4000e = subsequentSharedPhotosModel.a().a();
        Builder builder = ImmutableList.builder();
        ImmutableList a = subsequentSharedPhotosModel.j().a();
        int size = a.size();
        while (i < size) {
            builder.c(SharedImage.m3720a((PhotoNodeInfoModel) a.get(i)));
            i++;
        }
        this.f4001f = builder.b();
    }
}
