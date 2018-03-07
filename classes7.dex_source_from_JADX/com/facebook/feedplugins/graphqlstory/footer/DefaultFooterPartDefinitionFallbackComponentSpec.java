package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.view.View;
import com.facebook.components.ComponentContext;
import com.facebook.components.Size;
import com.facebook.components.ThreadUtils;
import com.facebook.components.annotations.MountSpec;
import com.facebook.components.fallback.FallbackViewCreator;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import java.lang.ref.WeakReference;

@MountSpec
/* compiled from: SouvenirTemplateGen */
public class DefaultFooterPartDefinitionFallbackComponentSpec {
    private static WeakReference<DefaultFooterView> f23195a;

    public static void m25591a(ComponentContext componentContext, int i, int i2, Size size, FallbackViewCreator<DefaultFooterView> fallbackViewCreator, SimpleRenderer simpleRenderer) {
        ThreadUtils.b();
        View view = f23195a != null ? (DefaultFooterView) f23195a.get() : null;
        if (view == null || !componentContext.equals(view.getContext())) {
            view = (DefaultFooterView) fallbackViewCreator.mo1573a((Context) componentContext);
            f23195a = new WeakReference(view);
        }
        simpleRenderer.a(view);
        FallbackViewCreator.m20654a(view, i, i2, size);
        simpleRenderer.a();
    }
}
