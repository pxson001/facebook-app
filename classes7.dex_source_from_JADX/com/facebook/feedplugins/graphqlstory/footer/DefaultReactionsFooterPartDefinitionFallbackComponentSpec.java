package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.view.View;
import com.facebook.components.ComponentContext;
import com.facebook.components.Size;
import com.facebook.components.ThreadUtils;
import com.facebook.components.annotations.MountSpec;
import com.facebook.components.fallback.FallbackViewCreator;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import java.lang.ref.WeakReference;

@MountSpec
/* compiled from: SouvenirBurstItem.serialize */
public class DefaultReactionsFooterPartDefinitionFallbackComponentSpec {
    private static WeakReference<ReactionsFooterView> f23211a;

    public static void m25604a(ComponentContext componentContext, int i, int i2, Size size, FallbackViewCreator<ReactionsFooterView> fallbackViewCreator, SimpleRenderer simpleRenderer) {
        ThreadUtils.b();
        View view = f23211a != null ? (ReactionsFooterView) f23211a.get() : null;
        if (view == null || !componentContext.equals(view.getContext())) {
            view = (ReactionsFooterView) fallbackViewCreator.mo1573a((Context) componentContext);
            f23211a = new WeakReference(view);
        }
        simpleRenderer.a(view);
        FallbackViewCreator.m20654a(view, i, i2, size);
        simpleRenderer.a();
    }
}
