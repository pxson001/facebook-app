package com.facebook.feedplugins.hpp.ui;

import android.graphics.PointF;
import android.net.Uri;
import android.view.View.OnClickListener;
import com.facebook.common.util.Tuple;
import com.facebook.graphql.model.GraphQLEntityCardContextItem;
import com.google.common.collect.ImmutableList;

/* compiled from: current_battery_level */
public class MobilePageAdminPanelPagePartDefinition$State {
    public final MobilePageAdminPanelPagePartDefinition$AymtData f7839a;
    public boolean f7840b;
    public final long f7841c;
    public final Uri f7842d;
    public final Uri f7843e;
    public final String f7844f;
    public final StringBuilder f7845g;
    public final String f7846h;
    public final OnClickListener f7847i;
    public final PointF f7848j;
    public final ImmutableList<Tuple<GraphQLEntityCardContextItem, OnClickListener>> f7849k;

    public MobilePageAdminPanelPagePartDefinition$State(MobilePageAdminPanelPagePartDefinition$AymtData mobilePageAdminPanelPagePartDefinition$AymtData, boolean z, long j, String str, String str2, Uri uri, Uri uri2, StringBuilder stringBuilder, OnClickListener onClickListener, PointF pointF, ImmutableList<Tuple<GraphQLEntityCardContextItem, OnClickListener>> immutableList) {
        this.f7839a = mobilePageAdminPanelPagePartDefinition$AymtData;
        this.f7840b = z;
        this.f7841c = j;
        this.f7844f = str;
        this.f7846h = str2;
        this.f7842d = uri;
        this.f7843e = uri2;
        this.f7845g = stringBuilder;
        this.f7847i = onClickListener;
        this.f7848j = pointF;
        this.f7849k = immutableList;
    }
}
