package com.facebook.feedplugins.video;

import android.view.View;
import com.facebook.components.ComponentContext;
import com.facebook.components.Size;
import com.facebook.components.ThreadUtils;
import com.facebook.components.annotations.MountSpec;
import com.facebook.components.fallback.FallbackViewCreator;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import java.lang.ref.WeakReference;

@MountSpec
/* compiled from: fonts */
public class RichVideoRowPartDefinitionFallbackComponentSpec {
    private static WeakReference<RichVideoAttachmentView> f13105a;

    public static void m14768a(ComponentContext componentContext, int i, int i2, Size size, FallbackViewCreator<RichVideoAttachmentView> fallbackViewCreator, SimpleRenderer simpleRenderer) {
        ThreadUtils.b();
        View view = f13105a != null ? (RichVideoAttachmentView) f13105a.get() : null;
        if (view == null || !componentContext.equals(view.getContext())) {
            view = (RichVideoAttachmentView) fallbackViewCreator.a(componentContext);
            f13105a = new WeakReference(view);
        }
        simpleRenderer.a(view);
        FallbackViewCreator.a(view, i, i2, size);
        simpleRenderer.a();
    }
}
