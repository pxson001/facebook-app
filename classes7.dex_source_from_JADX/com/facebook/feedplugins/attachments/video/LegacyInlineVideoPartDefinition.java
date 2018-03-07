package com.facebook.feedplugins.attachments.video;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition.State;
import com.facebook.feedplugins.links.AttachmentCallToActionButtonLinkPartDefinition;
import com.facebook.feedplugins.links.AttachmentCallToActionButtonLinkPartDefinition$Props;
import com.facebook.feedplugins.links.DefaultLinkedViewAdapter;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.video.player.BaseInlineVideoPlayer;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TEXTS */
public class LegacyInlineVideoPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation> extends BaseSinglePartDefinition<State, Void, E, InlineVideoAttachmentView> {
    private static LegacyInlineVideoPartDefinition f22835d;
    private static final Object f22836e = new Object();
    private final DefaultLinkedViewAdapter f22837a;
    private final AttachmentCallToActionButtonLinkPartDefinition<E> f22838b;
    public final CallToActionUtil f22839c;

    private static LegacyInlineVideoPartDefinition m25398b(InjectorLike injectorLike) {
        return new LegacyInlineVideoPartDefinition(DefaultLinkedViewAdapter.a(injectorLike), AttachmentCallToActionButtonLinkPartDefinition.a(injectorLike), CallToActionUtil.b(injectorLike));
    }

    public final Object m25399a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        State state = (State) obj;
        if (this.f22839c.c((GraphQLStoryAttachment) state.f22779a.a)) {
            subParts.a(2131563186, this.f22838b, new AttachmentCallToActionButtonLinkPartDefinition$Props(state.f22779a, this.f22837a));
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m25400a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1694451854);
        State state = (State) obj;
        InlineVideoAttachmentView inlineVideoAttachmentView = (InlineVideoAttachmentView) view;
        if (this.f22839c.c((GraphQLStoryAttachment) state.f22779a.a)) {
            BaseInlineVideoPlayer baseInlineVideoPlayer = inlineVideoAttachmentView.a;
            baseInlineVideoPlayer.d();
            baseInlineVideoPlayer.a(2131558543, "video_cta_end_screen_click");
            baseInlineVideoPlayer.a(state.f22799u.aB(), state.f22799u.R(), state.f22798t);
            baseInlineVideoPlayer.setEndScreenVideoPlayerListener(state.f22800v);
            baseInlineVideoPlayer.c();
            if (state.f22789k.a) {
                baseInlineVideoPlayer.e();
            } else {
                baseInlineVideoPlayer.f();
            }
        }
        Logger.a(8, EntryType.MARK_POP, -1816531849, a);
    }

    public final void m25401b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        BaseInlineVideoPlayer baseInlineVideoPlayer = ((InlineVideoAttachmentView) view).a;
        if (baseInlineVideoPlayer != null) {
            if (baseInlineVideoPlayer.a()) {
                baseInlineVideoPlayer.setEndScreenVideoPlayerListener(null);
            }
            baseInlineVideoPlayer.f();
            baseInlineVideoPlayer.setVideoListener(null);
            baseInlineVideoPlayer.a(null);
        }
    }

    @Inject
    public LegacyInlineVideoPartDefinition(DefaultLinkedViewAdapter defaultLinkedViewAdapter, AttachmentCallToActionButtonLinkPartDefinition attachmentCallToActionButtonLinkPartDefinition, CallToActionUtil callToActionUtil) {
        this.f22837a = defaultLinkedViewAdapter;
        this.f22838b = attachmentCallToActionButtonLinkPartDefinition;
        this.f22839c = callToActionUtil;
    }

    public static LegacyInlineVideoPartDefinition m25397a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LegacyInlineVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22836e) {
                LegacyInlineVideoPartDefinition legacyInlineVideoPartDefinition;
                if (a2 != null) {
                    legacyInlineVideoPartDefinition = (LegacyInlineVideoPartDefinition) a2.a(f22836e);
                } else {
                    legacyInlineVideoPartDefinition = f22835d;
                }
                if (legacyInlineVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25398b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22836e, b3);
                        } else {
                            f22835d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = legacyInlineVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
