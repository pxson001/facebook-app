package com.facebook.messaging.location.renderer;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.fbui.nodes.GlyphNode;
import com.facebook.nodes.NodeView;
import com.facebook.nodes.TextNode;
import javax.annotation.Nullable;

/* compiled from: selected_host */
public class LocationMapDetailsView extends NodeView {
    private TextNode f3013a;
    private TextNode f3014b;
    private GlyphNode f3015c;

    public LocationMapDetailsView(Context context) {
        super(context);
        m2985a();
    }

    public LocationMapDetailsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2985a();
    }

    public LocationMapDetailsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2985a();
    }

    private void m2985a() {
        setContentNode(2130905119);
        this.f3013a = (TextNode) a(2131563540);
        this.f3014b = (TextNode) a(2131563541);
        this.f3015c = (GlyphNode) a(2131563542);
    }

    public final void m2986a(@Nullable String str, @Nullable String str2, int i) {
        this.f3013a.a(str);
        this.f3014b.a(str2);
        this.f3015c.a(getContext(), i);
    }
}
