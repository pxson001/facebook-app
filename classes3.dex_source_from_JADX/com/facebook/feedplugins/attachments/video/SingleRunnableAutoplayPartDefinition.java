package com.facebook.feedplugins.attachments.video;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.DefaultVideoAutoplayManager;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ufi/reactions/v2/84x84/haha */
public class SingleRunnableAutoplayPartDefinition<E extends HasPersistentState, V extends View> extends BaseSinglePartDefinition<Props, InlineVideoPersistentState, E, V> {
    private static SingleRunnableAutoplayPartDefinition f116d;
    private static final Object f117e = new Object();
    private final DefaultVideoAutoplayManager<V> f118a;
    private final VideoAutoPlaySettingsChecker f119b;
    private final VideoLoggingUtils f120c;

    private static SingleRunnableAutoplayPartDefinition m117b(InjectorLike injectorLike) {
        return new SingleRunnableAutoplayPartDefinition(DefaultVideoAutoplayManager.a(injectorLike), VideoAutoPlaySettingsChecker.a(injectorLike), VideoLoggingUtils.a(injectorLike));
    }

    public final Object m118a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        return (InlineVideoPersistentState) ((HasPersistentState) anyEnvironment).a(props.a, props.b);
    }

    public final /* bridge */ /* synthetic */ void m119a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2033103379);
        m116a((Props) obj, (InlineVideoPersistentState) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -133244845, a);
    }

    private void m116a(Props props, InlineVideoPersistentState inlineVideoPersistentState, V v) {
        VideoViewController videoViewController = inlineVideoPersistentState.c;
        if (inlineVideoPersistentState.c == null) {
            videoViewController = props.g.a(inlineVideoPersistentState, props.c, props.d, props.e, props.f, this.f119b, this.f120c);
            inlineVideoPersistentState.c = videoViewController;
        }
        this.f118a.a(v, videoViewController);
    }

    public static SingleRunnableAutoplayPartDefinition m115a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SingleRunnableAutoplayPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f117e) {
                SingleRunnableAutoplayPartDefinition singleRunnableAutoplayPartDefinition;
                if (a2 != null) {
                    singleRunnableAutoplayPartDefinition = (SingleRunnableAutoplayPartDefinition) a2.a(f117e);
                } else {
                    singleRunnableAutoplayPartDefinition = f116d;
                }
                if (singleRunnableAutoplayPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m117b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f117e, b3);
                        } else {
                            f116d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = singleRunnableAutoplayPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SingleRunnableAutoplayPartDefinition(DefaultVideoAutoplayManager defaultVideoAutoplayManager, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils) {
        this.f118a = defaultVideoAutoplayManager;
        this.f119b = videoAutoPlaySettingsChecker;
        this.f120c = videoLoggingUtils;
    }
}
