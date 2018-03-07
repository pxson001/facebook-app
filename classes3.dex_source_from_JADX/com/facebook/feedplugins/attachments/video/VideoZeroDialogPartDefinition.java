package com.facebook.feedplugins.attachments.video;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: ufi/reactions/v2/84x84/wow */
public class VideoZeroDialogPartDefinition<V extends View> extends BaseSinglePartDefinition<Props, State, AnyEnvironment, V> {
    private static VideoZeroDialogPartDefinition f97c;
    private static final Object f98d = new Object();
    private final Provider<ZeroDialogController> f99a;
    private final String f100b;

    private static VideoZeroDialogPartDefinition m93b(InjectorLike injectorLike) {
        return new VideoZeroDialogPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 2365));
    }

    public final Object m94a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        State state = new State(new ZeroDialogListener(((Props) obj).a), (ZeroDialogController) this.f99a.get());
        state.b.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, this.f100b, state.a);
        state.c = new DelegateClickListener(state);
        return state;
    }

    public final /* bridge */ /* synthetic */ void m95a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1151337462);
        Props props = (Props) obj;
        State state = (State) obj2;
        state.a.b = view;
        DelegateClickListener delegateClickListener = state.c;
        View view2 = (View) props.b.apply(view);
        if (view2 != null) {
            if (view2 instanceof InlineVideoAttachmentView) {
                InlineVideoAttachmentView inlineVideoAttachmentView = (InlineVideoAttachmentView) view2;
                inlineVideoAttachmentView.b.a(delegateClickListener, inlineVideoAttachmentView);
            } else {
                view2.setOnClickListener(delegateClickListener);
            }
        }
        Logger.a(8, EntryType.MARK_POP, -180112312, a);
    }

    public final void m96b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Props props = (Props) obj;
        State state = (State) obj2;
        if (state != null) {
            state.a.b = null;
            View view2 = (View) props.b.apply(view);
            if (view2 != null) {
                if (view2 instanceof InlineVideoAttachmentView) {
                    InlineVideoAttachmentView inlineVideoAttachmentView = (InlineVideoAttachmentView) view2;
                    inlineVideoAttachmentView.b.a(null, inlineVideoAttachmentView);
                } else {
                    view2.setOnClickListener(null);
                }
            }
        }
    }

    public static VideoZeroDialogPartDefinition m92a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoZeroDialogPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f98d) {
                VideoZeroDialogPartDefinition videoZeroDialogPartDefinition;
                if (a2 != null) {
                    videoZeroDialogPartDefinition = (VideoZeroDialogPartDefinition) a2.a(f98d);
                } else {
                    videoZeroDialogPartDefinition = f97c;
                }
                if (videoZeroDialogPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m93b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f98d, b3);
                        } else {
                            f97c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoZeroDialogPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoZeroDialogPartDefinition(Resources resources, Provider<ZeroDialogController> provider) {
        this.f100b = resources.getString(2131232932);
        this.f99a = provider;
    }
}
