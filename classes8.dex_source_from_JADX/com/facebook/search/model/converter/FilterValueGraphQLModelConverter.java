package com.facebook.search.model.converter;

import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLModels.FB4AGraphSearchFilterValueFragmentModel;
import com.facebook.search.results.protocol.filters.FilterValue;
import com.facebook.search.results.protocol.filters.FilterValue.Builder;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/* compiled from: narrow_portrait_height */
public class FilterValueGraphQLModelConverter {
    public static FilterValueGraphQLModelConverter m25805a(InjectorLike injectorLike) {
        return new FilterValueGraphQLModelConverter();
    }

    public static FilterValue m25806a(FB4AGraphSearchFilterValueFragmentModel fB4AGraphSearchFilterValueFragmentModel) {
        String str = null;
        Preconditions.checkNotNull(fB4AGraphSearchFilterValueFragmentModel);
        if (Strings.isNullOrEmpty(fB4AGraphSearchFilterValueFragmentModel.m8318c())) {
            throw new GraphSearchException(GraphSearchError.BAD_FILTER, "Filter Value Missing Value ");
        } else if (Strings.isNullOrEmpty(fB4AGraphSearchFilterValueFragmentModel.m8317b())) {
            throw new GraphSearchException(GraphSearchError.BAD_FILTER, "Filter Value Missing Text ");
        } else {
            String str2;
            if (fB4AGraphSearchFilterValueFragmentModel.m8319d() == null || fB4AGraphSearchFilterValueFragmentModel.m8319d().m8311b() == null) {
                str2 = null;
            } else {
                str2 = fB4AGraphSearchFilterValueFragmentModel.m8319d().m8311b().b();
            }
            if (fB4AGraphSearchFilterValueFragmentModel.m8319d() != null) {
                str = fB4AGraphSearchFilterValueFragmentModel.m8319d().m8308a();
            }
            Builder g = FilterValue.m10136g();
            g.f8684b = fB4AGraphSearchFilterValueFragmentModel.m8318c();
            g = g;
            g.f8683a = fB4AGraphSearchFilterValueFragmentModel.m8317b();
            g = g;
            g.f8685c = str;
            Builder builder = g;
            builder.f8686d = fB4AGraphSearchFilterValueFragmentModel.m8316a();
            builder = builder;
            builder.f8687e = str2;
            return builder.m10135f();
        }
    }
}
