package com.facebook.groups.editsettings.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.resources.ui.FbTextView;

/* compiled from: Unable to update unit of type  */
public class GroupPurposeItemView extends ImageBlockLayout {
    public static final CallerContext f21671h = CallerContext.a(GroupPurposeItemView.class);
    public FbDraweeView f21672i = ((FbDraweeView) getView(2131562716));
    public FbTextView f21673j = ((FbTextView) getView(2131562717));
    public GlyphView f21674k = ((GlyphView) getView(2131562718));

    public GroupPurposeItemView(Context context) {
        super(context);
        setContentView(2130904689);
        setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(2131434293)));
    }
}
