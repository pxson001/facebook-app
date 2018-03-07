package com.facebook.groups.memberpicker;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationModels.GroupAddMembersMutationModel;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: expiration_date_edit_text */
public class MemberPickerMutationResultHelper {
    private final Resources f14601a;

    public static MemberPickerMutationResultHelper m16481a(InjectorLike injectorLike) {
        return new MemberPickerMutationResultHelper(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MemberPickerMutationResultHelper(Resources resources) {
        this.f14601a = resources;
    }

    public final String m16485a(GraphQLResult<GroupAddMembersMutationModel> graphQLResult, int i) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        if (((GroupAddMembersMutationModel) graphQLResult.e).m16576a() != null) {
            size = ((GroupAddMembersMutationModel) graphQLResult.e).m16576a().size();
        } else {
            size = 0;
        }
        if (((GroupAddMembersMutationModel) graphQLResult.e).m16580m() != null) {
            size2 = ((GroupAddMembersMutationModel) graphQLResult.e).m16580m().size();
        } else {
            size2 = 0;
        }
        if (((GroupAddMembersMutationModel) graphQLResult.e).m16577j() != null) {
            size3 = ((GroupAddMembersMutationModel) graphQLResult.e).m16577j().size();
        } else {
            size3 = 0;
        }
        if (((GroupAddMembersMutationModel) graphQLResult.e).m16578k() != null) {
            size4 = ((GroupAddMembersMutationModel) graphQLResult.e).m16578k().size();
        } else {
            size4 = 0;
        }
        if (((GroupAddMembersMutationModel) graphQLResult.e).m16581n() != null) {
            size5 = ((GroupAddMembersMutationModel) graphQLResult.e).m16581n().size();
        } else {
            size5 = 0;
        }
        if (((GroupAddMembersMutationModel) graphQLResult.e).m16579l() != null) {
            size6 = ((GroupAddMembersMutationModel) graphQLResult.e).m16579l().size();
        } else {
            size6 = 0;
        }
        return m16484a(i, size, size5, size2, size3, size4, size6);
    }

    private String m16484a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i2 + i3;
        if ((i8 + i4 == 0 ? 1 : null) != null) {
            return this.f14601a.getQuantityString(2131689738, i, new Object[]{Integer.valueOf(i)});
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = (i2 != 0 || i3 == 0) ? null : 1;
        String a = m16482a(i4, i6);
        String a2 = m16483a(i8, i5, i7);
        String quantityString = this.f14601a.getQuantityString(2131689743, i8, new Object[]{Integer.valueOf(i8)});
        if (!Strings.isNullOrEmpty(a2)) {
            stringBuilder.append(a2);
        }
        if (!Strings.isNullOrEmpty(a)) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(a);
        }
        if (!(obj == null || stringBuilder.length() == 0)) {
            stringBuilder.append(' ');
            stringBuilder.append(quantityString);
        }
        return stringBuilder.toString();
    }

    private String m16482a(int i, int i2) {
        if (i == 0) {
            return "";
        }
        if (i2 != 0) {
            return this.f14601a.getQuantityString(2131689741, i, new Object[]{Integer.valueOf(i)});
        }
        return this.f14601a.getQuantityString(2131689742, i, new Object[]{Integer.valueOf(i)});
    }

    private String m16483a(int i, int i2, int i3) {
        if (i == 0) {
            return "";
        }
        if (i2 == 0 && i3 == 0) {
            return this.f14601a.getQuantityString(2131689740, i, new Object[]{Integer.valueOf(i)});
        }
        return this.f14601a.getQuantityString(2131689739, i, new Object[]{Integer.valueOf(i)});
    }
}
