package com.facebook.feedplugins.attachments.video;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.videos.ui.FullscreenVideoAttachmentView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPrefetcher;
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

@ContextScoped
/* compiled from: translationX */
public class FullscreenVideoCoverPartDefinition<E extends HasPrefetcher & HasFeedListType> extends BaseSinglePartDefinition<VideoAttachmentProps, Void, E, FullscreenVideoAttachmentView> {
    private static FullscreenVideoCoverPartDefinition f230a;
    private static final Object f231b = new Object();

    private static FullscreenVideoCoverPartDefinition m208a() {
        return new FullscreenVideoCoverPartDefinition();
    }

    public final Object m210a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasPrefetcher hasPrefetcher = (HasPrefetcher) anyEnvironment;
        ((VideoAttachmentProps) obj).a.a(FeedAnalyticsUtil.a(((HasFeedListType) hasPrefetcher).c()), hasPrefetcher);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m211a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -354434147);
        ((VideoAttachmentProps) obj).a.a((FullscreenVideoAttachmentView) view);
        Logger.a(8, EntryType.MARK_POP, -393090132, a);
    }

    public static FullscreenVideoCoverPartDefinition m209a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FullscreenVideoCoverPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f231b) {
                FullscreenVideoCoverPartDefinition fullscreenVideoCoverPartDefinition;
                if (a3 != null) {
                    fullscreenVideoCoverPartDefinition = (FullscreenVideoCoverPartDefinition) a3.a(f231b);
                } else {
                    fullscreenVideoCoverPartDefinition = f230a;
                }
                if (fullscreenVideoCoverPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m208a();
                        if (a3 != null) {
                            a3.a(f231b, a2);
                        } else {
                            f230a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = fullscreenVideoCoverPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
