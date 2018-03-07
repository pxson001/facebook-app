package com.facebook.localcontent.photos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.enums.GraphQLAvailablePhotoCategoryEnum;
import com.facebook.graphql.enums.GraphQLPhotosByCategoryEntryPoint;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLInterfaces.AvailableCategoriesQuery.PhotosByCategory.AvailableCategories;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLModels.AvailableCategoriesQueryModel.PhotosByCategoryModel.AvailableCategoriesModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: document_title */
public class PhotosByCategoryPagerAdapter extends FragmentStatePagerAdapter {
    private final CallerContext f15197a;
    private final int f15198b;
    private final GraphQLPhotosByCategoryEntryPoint f15199c;
    private final boolean f15200d;
    private final String f15201e;
    private final ImmutableList<? extends AvailableCategories> f15202f;

    public PhotosByCategoryPagerAdapter(FragmentManager fragmentManager, CallerContext callerContext, int i, @Nullable GraphQLPhotosByCategoryEntryPoint graphQLPhotosByCategoryEntryPoint, boolean z, String str, ImmutableList<? extends AvailableCategories> immutableList) {
        super(fragmentManager);
        this.f15197a = callerContext;
        this.f15198b = i;
        this.f15199c = graphQLPhotosByCategoryEntryPoint;
        this.f15200d = z;
        this.f15201e = str;
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            AvailableCategoriesModel availableCategoriesModel = (AvailableCategoriesModel) immutableList.get(i2);
            if (availableCategoriesModel.a() != GraphQLAvailablePhotoCategoryEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                builder.c(availableCategoriesModel);
            }
        }
        this.f15202f = builder.b();
    }

    @Nullable
    public final CharSequence J_(int i) {
        return ((AvailableCategoriesModel) this.f15202f.get(i)).c();
    }

    public final Fragment m17647a(int i) {
        AvailableCategoriesModel availableCategoriesModel = (AvailableCategoriesModel) this.f15202f.get(i);
        return PhotoCategoryFragment.m17633a(i, this.f15199c, this.f15201e, i == this.f15198b, availableCategoriesModel.a(), this.f15200d, availableCategoriesModel.d(), availableCategoriesModel.b(), this.f15197a);
    }

    public final int m17648b() {
        return this.f15202f.size();
    }
}
