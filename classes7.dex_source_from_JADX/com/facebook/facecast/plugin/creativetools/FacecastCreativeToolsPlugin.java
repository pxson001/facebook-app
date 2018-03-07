package com.facebook.facecast.plugin.creativetools;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.facecast.plugin.FacecastBasePlugin;
import com.facebook.facecast.plugin.creativetools.CreativeToolsPackSelectorTray.CreativeToolsPackSelectorTrayListener;

/* compiled from: batch_size */
public class FacecastCreativeToolsPlugin extends FacecastBasePlugin implements CreativeToolsPackSelectorTrayListener {
    public final CreativeToolsPackSelectorTray f18736c;
    public final CreativeToolsTray f18737d;

    public FacecastCreativeToolsPlugin(Context context) {
        this(context, null);
    }

    private FacecastCreativeToolsPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastCreativeToolsPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904199);
        this.f18736c = (CreativeToolsPackSelectorTray) a(2131561625);
        this.f18737d = (CreativeToolsTray) a(2131561626);
        this.f18736c.f18718g = this;
    }

    public final void mo1439a(CreativeToolsPack creativeToolsPack) {
        this.f18737d.setCreativeToolsPack(creativeToolsPack);
    }
}
