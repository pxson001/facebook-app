package com.facebook.events.eventsdiscovery;

import android.content.Context;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.resources.ui.FbTextView;

/* compiled from: com.facebook.messaging.sms.migration.END_FLOW */
public class EventsDiscoveryFilterGroupView extends ImageBlockLayout {
    public GlyphView f17262h = ((GlyphView) getView(2131561535));
    public FbTextView f17263i = ((FbTextView) getView(2131561536));
    public FbTextView f17264j = ((FbTextView) getView(2131561537));

    public EventsDiscoveryFilterGroupView(Context context) {
        super(context);
        setContentView(2130904147);
        setGravity(17);
        setThumbnailGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131434209);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131434211);
        setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        setBackgroundColor(getResources().getColor(2131361920));
        a(0, getResources().getDimensionPixelSize(2131427380), 0, 0);
        setBorderColor(getResources().getColor(2131362101));
    }
}
