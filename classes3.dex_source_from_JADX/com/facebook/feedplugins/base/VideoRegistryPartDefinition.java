package com.facebook.feedplugins.base;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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

@ContextScoped
/* compiled from: ufi/reactions/v2/84x84/sad */
public class VideoRegistryPartDefinition extends BaseSinglePartDefinition<GraphQLStoryAttachment, Void, CanShowVideoInFullScreen, View> {
    private static VideoRegistryPartDefinition f101a;
    private static final Object f102b = new Object();

    private static VideoRegistryPartDefinition m97a() {
        return new VideoRegistryPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m99a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1897826849);
        ((CanShowVideoInFullScreen) anyEnvironment).a((GraphQLStoryAttachment) obj, view);
        Logger.a(8, EntryType.MARK_POP, 2139367869, a);
    }

    public final void m100b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((CanShowVideoInFullScreen) anyEnvironment).a((GraphQLStoryAttachment) obj);
    }

    public static VideoRegistryPartDefinition m98a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoRegistryPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f102b) {
                VideoRegistryPartDefinition videoRegistryPartDefinition;
                if (a3 != null) {
                    videoRegistryPartDefinition = (VideoRegistryPartDefinition) a3.a(f102b);
                } else {
                    videoRegistryPartDefinition = f101a;
                }
                if (videoRegistryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m97a();
                        if (a3 != null) {
                            a3.a(f102b, a2);
                        } else {
                            f101a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = videoRegistryPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
