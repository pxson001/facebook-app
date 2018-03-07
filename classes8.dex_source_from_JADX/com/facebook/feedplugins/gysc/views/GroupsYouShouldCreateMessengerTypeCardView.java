package com.facebook.feedplugins.gysc.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.groups.widget.actionbuttonwithdivider.HscrollActionButtonWithVerticalDivider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.google.common.collect.ImmutableList;

/* compiled from: friends_center_suggestions_tab */
public class GroupsYouShouldCreateMessengerTypeCardView extends PagerItemWrapperLayout implements RecyclableView {
    public FacepileView f12871a = ((FacepileView) findViewById(2131562743));
    public TextView f12872b = ((TextView) findViewById(2131562746));
    public TextView f12873c = ((TextView) findViewById(2131562747));
    public HscrollActionButtonWithVerticalDivider f12874d = ((HscrollActionButtonWithVerticalDivider) findViewById(2131562748));
    public boolean f12875e;
    public View f12876f;

    public GroupsYouShouldCreateMessengerTypeCardView(Context context) {
        super(context);
        setContentView(2130904700);
        this.f12874d.setDividerColor(getResources().getColor(2131361862));
        this.f12874d.setDividerThicknessPx(getResources().getDimensionPixelSize(2131427379));
        this.f12874d.setDividerMarginPx(getResources().getDimensionPixelSize(2131430270));
    }

    public void setSuggestGroupName(String str) {
        this.f12872b.setText(str);
    }

    public final void m14623a(int i, String str) {
        CharSequence charSequence;
        if (str != null) {
            Resources resources = getResources();
            StringBuffer stringBuffer = new StringBuffer(str);
            if (i > 1) {
                stringBuffer.append(" + ").append(resources.getQuantityString(2131689630, i - 1, new Object[]{Integer.valueOf(i - 1)}));
            }
            charSequence = stringBuffer;
        } else {
            charSequence = null;
        }
        this.f12873c.setText(charSequence);
    }

    public void setButtonOnclickListener(OnClickListener onClickListener) {
        this.f12874d.setOnClickListener(onClickListener);
    }

    public final void m14624a(ImmutableList<String> immutableList, int i) {
        this.f12871a.setFaceCountForOverflow(i);
        this.f12871a.setFaceStrings(immutableList);
    }

    public void setFaces(ImmutableList<String> immutableList) {
        this.f12871a.setFaceStrings(immutableList);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2102939771);
        super.onAttachedToWindow();
        this.f12875e = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1679631605, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1470489948);
        super.onDetachedFromWindow();
        this.f12875e = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2009175201, a);
    }

    public final boolean m14625a() {
        return this.f12875e;
    }
}
