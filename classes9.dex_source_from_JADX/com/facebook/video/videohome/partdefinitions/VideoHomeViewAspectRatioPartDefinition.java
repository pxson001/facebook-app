package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: signInResultCode */
public class VideoHomeViewAspectRatioPartDefinition extends BaseSinglePartDefinition<Float, Void, AnyEnvironment, View> {
    private static VideoHomeViewAspectRatioPartDefinition f3271b;
    private static final Object f3272c = new Object();
    public final Display f3273a;

    private static VideoHomeViewAspectRatioPartDefinition m3119b(InjectorLike injectorLike) {
        return new VideoHomeViewAspectRatioPartDefinition(WindowManagerMethodAutoProvider.b(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m3120a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2051151540);
        float floatValue = ((Float) obj).floatValue();
        if (floatValue > 0.0f) {
            Point point = new Point();
            this.f3273a.getSize(point);
            int i = (int) (((float) point.x) / floatValue);
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
        Logger.a(8, EntryType.MARK_POP, -1492582889, a);
    }

    @Inject
    public VideoHomeViewAspectRatioPartDefinition(WindowManager windowManager) {
        this.f3273a = windowManager.getDefaultDisplay();
    }

    public static VideoHomeViewAspectRatioPartDefinition m3118a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeViewAspectRatioPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3272c) {
                VideoHomeViewAspectRatioPartDefinition videoHomeViewAspectRatioPartDefinition;
                if (a2 != null) {
                    videoHomeViewAspectRatioPartDefinition = (VideoHomeViewAspectRatioPartDefinition) a2.a(f3272c);
                } else {
                    videoHomeViewAspectRatioPartDefinition = f3271b;
                }
                if (videoHomeViewAspectRatioPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3119b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3272c, b3);
                        } else {
                            f3271b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeViewAspectRatioPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
