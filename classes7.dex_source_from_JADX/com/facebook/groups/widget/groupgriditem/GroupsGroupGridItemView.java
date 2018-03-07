package com.facebook.groups.widget.groupgriditem;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.groups.groupsections.noncursored.GroupPogGridData;
import com.facebook.groups.widget.grouproundicon.GroupsEmptyDrawablePicker;
import com.facebook.uicontrib.pog.PogView;

/* compiled from: profile_context_item_vpv */
public class GroupsGroupGridItemView extends PogView {
    private static final CallerContext f5940g = CallerContext.a(GroupsGroupGridItemView.class, "landing");

    public GroupsGroupGridItemView(Context context) {
        super(context);
    }

    public final void m7561a(GroupPogGridData groupPogGridData, double d) {
        m7559a(groupPogGridData.a, groupPogGridData.c, groupPogGridData.f, groupPogGridData.b, d, f5940g);
    }

    protected final int mo333a(String str) {
        return GroupsEmptyDrawablePicker.m7604a(false);
    }
}
