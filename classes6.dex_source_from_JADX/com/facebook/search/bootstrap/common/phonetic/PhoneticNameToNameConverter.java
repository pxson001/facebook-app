package com.facebook.search.bootstrap.common.phonetic;

import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.search.graphql.SearchEntityModels.PhoneticNameModel;
import com.facebook.search.graphql.SearchEntityModels.PhoneticNameModel.PartsModel;
import com.facebook.user.model.Name;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;

/* compiled from: extra_finish_on_launch_edit_shop */
public class PhoneticNameToNameConverter {
    public static Name m23189a(@Nonnull PhoneticNameModel phoneticNameModel) {
        String str = null;
        Preconditions.checkNotNull(phoneticNameModel, "The phoneticName cannot be null.");
        String b = phoneticNameModel.m23496b();
        ImmutableList a = phoneticNameModel.m23495a();
        if (b == null) {
            return Name.k();
        }
        int size = a.size();
        int i = 0;
        String str2 = null;
        while (i < size) {
            PartsModel partsModel = (PartsModel) a.get(i);
            int b2 = partsModel.m23490b();
            int a2 = partsModel.m23486a();
            GraphQLStructuredNamePart c = partsModel.m23491c();
            int offsetByCodePoints = b.offsetByCodePoints(0, b2);
            String substring = b.substring(offsetByCodePoints, b.offsetByCodePoints(offsetByCodePoints, a2));
            if (Objects.equal(c, GraphQLStructuredNamePart.FIRST)) {
                String str3 = str;
                str = substring;
                substring = str3;
            } else if (Objects.equal(c, GraphQLStructuredNamePart.LAST)) {
                str = str2;
            } else {
                substring = str;
                str = str2;
            }
            i++;
            str2 = str;
            str = substring;
        }
        return new Name(str2, str, b);
    }
}
