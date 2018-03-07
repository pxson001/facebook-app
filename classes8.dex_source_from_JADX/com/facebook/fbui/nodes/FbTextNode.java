package com.facebook.fbui.nodes;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.nodes.TextNode;
import javax.inject.Inject;

/* compiled from: hashtag. */
public class FbTextNode extends TextNode implements InjectableComponentWithoutContext {
    @Inject
    FbTextLayoutCacheWarmer f11570a;

    public FbTextNode(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        FbInjector.a(FbTextNode.class, this, context);
        this.x = true;
        this.w = this.f11570a;
    }
}
