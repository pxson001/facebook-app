package com.facebook.groups.info.navigation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel;
import com.facebook.groups.navigation.GroupsNavigationSecondaryActionDelegate;

/* compiled from: This will be applied automatically. */
public abstract class AbstractGroupInfoSecondaryActionDelegate implements GroupsNavigationSecondaryActionDelegate {
    protected FetchGroupInfoPageDataModel f22715a;
    protected Context f22716b;

    public final void m23681a(FetchGroupInfoPageDataModel fetchGroupInfoPageDataModel, Context context) {
        this.f22715a = fetchGroupInfoPageDataModel;
        this.f22716b = context;
    }

    public Drawable mo993a() {
        return null;
    }

    public String mo994b() {
        return null;
    }

    public void mo995c() {
    }

    public final boolean m23684d() {
        return (this.f22715a == null || this.f22715a.m23872Q() == null || this.f22715a.m23872Q() == GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || this.f22715a.m23872Q() == GraphQLGroupVisibility.SECRET) ? false : true;
    }
}
