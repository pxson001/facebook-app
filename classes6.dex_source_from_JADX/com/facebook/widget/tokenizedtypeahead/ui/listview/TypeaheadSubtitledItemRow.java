package com.facebook.widget.tokenizedtypeahead.ui.listview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.CustomViewGroup;

/* compiled from: com.facebook.platform.protocol.METHOD_ARGS */
public class TypeaheadSubtitledItemRow extends CustomViewGroup {
    public static final CallerContext f20150a = CallerContext.a(TypeaheadSubtitledItemRow.class);
    public final TextView f20151b;
    public final TextView f20152c;
    public final GlyphView f20153d;
    public final ToggleButton f20154e;
    public final FbDraweeView f20155f;

    public TypeaheadSubtitledItemRow(Context context) {
        this(context, 2130907578);
    }

    public TypeaheadSubtitledItemRow(Context context, @LayoutRes int i) {
        super(context);
        setContentView(i);
        this.f20151b = (TextView) getView(2131561318);
        this.f20153d = (GlyphView) getView(2131568152);
        this.f20154e = (ToggleButton) getView(2131561316);
        this.f20152c = (TextView) getView(2131561319);
        this.f20155f = (FbDraweeView) getView(2131561317);
    }
}
