package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.inlinecomposer.InlineComposerV2HeaderView;
import com.facebook.feed.inlinecomposer.multirow.animations.PromptIconAnimationBuilder;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper.CanHideShowPromptOnClickListener;
import com.facebook.feed.inlinecomposer.multirow.common.PromptImpressionLoggerPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.PromptPersitentState;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptIcon;
import com.facebook.feed.inlinecomposer.v2attachment.CanRenderV2Prompt;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater.TapSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.PromptSleepHelper;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.PromptViewState$Visibility;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import com.facebook.widget.ShimmerFrameLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: music */
public class InlineComposerPromptIconPartDefinition<V extends View & HasPromptIcon & HasPromptFlyout, E extends HasPersistentState & PromptViewStateUpdater> extends BaseSinglePartDefinition<Props, State, E, V> {
    private static final CallerContext f13183a = CallerContext.m9060a(InlineComposerPromptIconPartDefinition.class);
    private static InlineComposerPromptIconPartDefinition f13184h;
    private static final Object f13185i = new Object();
    public final PromptsExperimentHelper f13186b;
    private final PromptSleepHelper f13187c;
    private final DefaultAnimationPartFactory f13188d;
    public final InlineComposerPersistentStateHelper f13189e;
    private final FbDraweeControllerBuilder f13190f;
    private final PromptImpressionLoggerPartDefinition f13191g;

    @Immutable
    /* compiled from: music */
    public class Props {
        public final CanRenderV2Prompt f14306a;
        public final V2Attachment f14307b;
        @Nullable
        public final InlineComposerPromptSession f14308c;
        public final boolean f14309d;
        public final CacheableEntity f14310e;

        public Props(CanRenderV2Prompt canRenderV2Prompt, V2Attachment v2Attachment, InlineComposerPromptSession inlineComposerPromptSession, boolean z, CacheableEntity cacheableEntity) {
            this.f14306a = canRenderV2Prompt;
            this.f14307b = v2Attachment;
            this.f14308c = inlineComposerPromptSession;
            this.f14309d = z;
            this.f14310e = cacheableEntity;
        }
    }

    /* compiled from: music */
    class IconOnClickListener implements CanHideShowPromptOnClickListener<FbDraweeView> {
        final /* synthetic */ InlineComposerPromptIconPartDefinition f14318a;
        private FbDraweeView f14319b;
        private InlineComposerPromptSession f14320c;
        private final PromptViewStateUpdater f14321d;

        public final void mo2757a(View view, InlineComposerPromptSession inlineComposerPromptSession) {
            this.f14319b = (FbDraweeView) view;
            this.f14320c = inlineComposerPromptSession;
        }

        public IconOnClickListener(InlineComposerPromptIconPartDefinition inlineComposerPromptIconPartDefinition, PromptViewStateUpdater promptViewStateUpdater) {
            this.f14318a = inlineComposerPromptIconPartDefinition;
            this.f14321d = promptViewStateUpdater;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -238912887);
            Preconditions.checkNotNull(this.f14319b);
            view.setOnClickListener(null);
            PromptsExperimentHelper promptsExperimentHelper = this.f14318a.f13186b;
            if (1 != 0) {
                this.f14318a.f13189e.m19398a(this.f14320c, this.f14321d, TapSource.ICON);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1575303591, a);
        }
    }

    /* compiled from: music */
    public class State {
        public final PromptPersitentState f14330a;
        final boolean f14331b;
        final CanHideShowPromptOnClickListener f14332c;
        final ColorMatrixColorFilter f14333d;
        public DraweeController f14334e;
        public ShimmerFrameLayout f14335f;

        State(PromptPersitentState promptPersitentState, boolean z, CanHideShowPromptOnClickListener canHideShowPromptOnClickListener, ColorMatrixColorFilter colorMatrixColorFilter) {
            this.f14330a = promptPersitentState;
            this.f14331b = z;
            this.f14332c = canHideShowPromptOnClickListener;
            this.f14333d = colorMatrixColorFilter;
        }
    }

    private static InlineComposerPromptIconPartDefinition m19384b(InjectorLike injectorLike) {
        return new InlineComposerPromptIconPartDefinition(PromptsExperimentHelper.m15312b(injectorLike), PromptSleepHelper.m18816b(injectorLike), DefaultAnimationPartFactory.m19389a(injectorLike), InlineComposerPersistentStateHelper.m19396b(injectorLike), FbDraweeControllerBuilder.m19410b(injectorLike), PromptImpressionLoggerPartDefinition.m19482a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        CanHideShowPromptOnClickListener iconOnClickListener = new IconOnClickListener(this, (PromptViewStateUpdater) hasPersistentState);
        boolean z = props.f14308c == null ? false : ((PromptPersitentState) hasPersistentState.mo2425a(InlineComposerPersistentStateHelper.m19395a(props.f14308c), props.f14310e)) == PromptPersitentState.f14327c;
        boolean z2 = z;
        this.f13189e.m19397a(subParts, props.f14308c, props.f14310e, InlineComposerPromptIconPartDefinition.class, new PromptIconAnimationBuilder(this.f13188d, iconOnClickListener));
        com.facebook.feed.inlinecomposer.multirow.common.PromptImpressionLoggerPartDefinition.Props props2 = new com.facebook.feed.inlinecomposer.multirow.common.PromptImpressionLoggerPartDefinition.Props(props.f14306a, props.f14308c, hasPersistentState, props.f14310e);
        subParts.mo2756a(this.f13191g, props2);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        State state = new State(props2.f14326c, z2, iconOnClickListener, new ColorMatrixColorFilter(colorMatrix));
        if (props.f14306a != null) {
            state.f14334e = m19381a(props.f14306a, state);
        }
        return state;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -978418145);
        m19383a((Props) obj, (State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 1619149140, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        ((HasPromptIcon) view).getIconView().setOnClickListener(null);
        if (state.f14335f != null) {
            state.f14335f = null;
            ((HasPromptIcon) view).getIconView().setController(null);
        }
    }

    public static InlineComposerPromptIconPartDefinition m19382a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerPromptIconPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13185i) {
                InlineComposerPromptIconPartDefinition inlineComposerPromptIconPartDefinition;
                if (a2 != null) {
                    inlineComposerPromptIconPartDefinition = (InlineComposerPromptIconPartDefinition) a2.mo818a(f13185i);
                } else {
                    inlineComposerPromptIconPartDefinition = f13184h;
                }
                if (inlineComposerPromptIconPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19384b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13185i, b3);
                        } else {
                            f13184h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerPromptIconPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InlineComposerPromptIconPartDefinition(PromptsExperimentHelper promptsExperimentHelper, PromptSleepHelper promptSleepHelper, DefaultAnimationPartFactory defaultAnimationPartFactory, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper, FbDraweeControllerBuilder fbDraweeControllerBuilder, PromptImpressionLoggerPartDefinition promptImpressionLoggerPartDefinition) {
        this.f13186b = promptsExperimentHelper;
        this.f13187c = promptSleepHelper;
        this.f13188d = defaultAnimationPartFactory;
        this.f13189e = inlineComposerPersistentStateHelper;
        this.f13190f = fbDraweeControllerBuilder;
        this.f13191g = promptImpressionLoggerPartDefinition;
    }

    private void m19383a(Props props, State state, V v) {
        CanRenderV2Prompt canRenderV2Prompt = props.f14306a;
        if (canRenderV2Prompt != null) {
            View iconView = ((HasPromptIcon) v).getIconView();
            ShimmerFrameLayout shimmerContainer = ((HasPromptIcon) v).getShimmerContainer();
            if (shimmerContainer == null || state.f14334e == null) {
                iconView.m20507a(canRenderV2Prompt.mo2630f(), f13183a);
            } else {
                state.f14335f = shimmerContainer;
                shimmerContainer.m20805b();
                iconView.setController(state.f14334e);
            }
            iconView.setVisibility(props.f14309d ? 8 : 0);
            state.f14332c.mo2757a(iconView, props.f14308c);
            Preconditions.checkNotNull(props.f14308c);
            if (!state.f14331b || state.f14330a.f14329b) {
                Object obj;
                if (props.f14308c.f13411c.a.equals(PromptViewState$Visibility.MINIMIZED) && state.f14330a.f14328a.equals(PromptViewState$Visibility.MINIMIZED)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    return;
                }
            }
            PromptSleepHelper promptSleepHelper = this.f13187c;
            String c = props.f14308c.f13409a.mo2494c();
            if (c != null) {
                promptSleepHelper.f12770a.m18826b(c);
            }
            iconView.setScaleX(0.8f);
            iconView.setScaleY(0.8f);
            ((GenericDraweeHierarchy) iconView.getHierarchy()).m20596a(state.f14333d);
            return;
        }
        FbDraweeView iconView2 = ((HasPromptIcon) v).getIconView();
        if (1 != 0) {
            iconView2.setVisibility(8);
        } else if (iconView2 != null) {
            iconView2.setVisibility(8);
        }
        if (!this.f13186b.m15315d()) {
            InlineComposerV2HeaderView inlineComposerV2HeaderView = (InlineComposerV2HeaderView) v;
            LayoutParams layoutParams = inlineComposerV2HeaderView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = inlineComposerV2HeaderView.getCollapsedHeight();
                inlineComposerV2HeaderView.requestLayout();
            }
        }
    }

    private DraweeController m19381a(CanRenderV2Prompt canRenderV2Prompt, State state) {
        return ((FbDraweeControllerBuilder) this.f13190f.m19417a(f13183a).m19424b(canRenderV2Prompt.mo2630f()).m19440a(new 1(this, state))).m19435s();
    }
}
