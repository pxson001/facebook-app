package com.facebook.photos.creativeediting.swipeable.prompt;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutPartDefinition.Props;
import com.facebook.feed.inlinecomposer.multirow.common.views.V2PromptFlyoutView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptObject;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import javax.inject.Inject;

@ContextScoped
/* compiled from: souvenir_pager_indicator_index */
public class FramePromptsPromptPartDefinition<E extends HasContext & HasPersistentState> extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, FramePromptClickListener, E, V2PromptFlyoutView> {
    public static final ViewType f2312a = new C02761();
    private static FramePromptsPromptPartDefinition f2313g;
    private static final Object f2314h = new Object();
    private final InlineComposerPromptFlyoutPartDefinition f2315b;
    private final InlineComposerPersistentStateHelper f2316c;
    private final FramePromptClickListener f2317d;
    private final FramePromptViewAnimationBuilderProvider f2318e;
    private final QeAccessor f2319f;

    /* compiled from: souvenir_pager_indicator_index */
    final class C02761 extends ViewType {
        C02761() {
        }

        public final View m2431a(Context context) {
            V2PromptFlyoutView v2PromptFlyoutView = new V2PromptFlyoutView(context);
            v2PromptFlyoutView.getAttachmentInsertPoint().addView(new FramePromptView(context).m2425a());
            return v2PromptFlyoutView;
        }
    }

    private static FramePromptsPromptPartDefinition m2433b(InjectorLike injectorLike) {
        return new FramePromptsPromptPartDefinition(InlineComposerPromptFlyoutPartDefinition.a(injectorLike), InlineComposerPersistentStateHelper.b(injectorLike), FramePromptClickListener.b(injectorLike), (FramePromptViewAnimationBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FramePromptViewAnimationBuilderProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m2435a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f2315b, new Props(promptPartDefinitionProps.c, promptPartDefinitionProps.c.g(), promptPartDefinitionProps.a, promptPartDefinitionProps.b, this.f2316c.b(promptPartDefinitionProps.a)));
        FramePromptViewAnimationBuilderProvider framePromptViewAnimationBuilderProvider = this.f2318e;
        SubParts subParts2 = subParts;
        this.f2316c.a(subParts2, promptPartDefinitionProps.a, promptPartDefinitionProps.b, FramePromptsPromptPartDefinition.class, new FramePromptViewAnimationBuilder(ScreenUtil.a(framePromptViewAnimationBuilderProvider), DefaultAnimationPartFactory.a(framePromptViewAnimationBuilderProvider), hasContext.getContext()));
        return this.f2317d;
    }

    public final /* bridge */ /* synthetic */ void m2436a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1728280771);
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        FramePromptClickListener framePromptClickListener = (FramePromptClickListener) obj2;
        V2PromptFlyoutView v2PromptFlyoutView = (V2PromptFlyoutView) view;
        ((FramePromptView) v2PromptFlyoutView.getV2AttachmentView()).m2426a(promptPartDefinitionProps.a);
        framePromptClickListener.c = promptPartDefinitionProps.a;
        v2PromptFlyoutView.getFlyoutView().setOnClickListener(framePromptClickListener);
        v2PromptFlyoutView.getAttachmentInsertPoint().setVisibility(0);
        Logger.a(8, EntryType.MARK_POP, -723505454, a);
    }

    public final boolean m2437a(Object obj) {
        PromptObject a = InlineComposerPromptSession.a(((PromptPartDefinitionProps) obj).a);
        if (a instanceof ProductionPromptObject) {
            return ((ProductionPromptObject) a).a.m() != null && this.f2319f.a(ExperimentsForSwipeablePromptModule.f2286a, false);
        } else {
            return false;
        }
    }

    public final void m2438b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        V2PromptFlyoutView v2PromptFlyoutView = (V2PromptFlyoutView) view;
        ((FramePromptClickListener) obj2).c = null;
        v2PromptFlyoutView.getFlyoutView().setOnClickListener(null);
        v2PromptFlyoutView.getAttachmentInsertPoint().setVisibility(8);
    }

    @Inject
    public FramePromptsPromptPartDefinition(InlineComposerPromptFlyoutPartDefinition inlineComposerPromptFlyoutPartDefinition, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper, FramePromptClickListener framePromptClickListener, FramePromptViewAnimationBuilderProvider framePromptViewAnimationBuilderProvider, QeAccessor qeAccessor) {
        this.f2315b = inlineComposerPromptFlyoutPartDefinition;
        this.f2316c = inlineComposerPersistentStateHelper;
        this.f2317d = framePromptClickListener;
        this.f2318e = framePromptViewAnimationBuilderProvider;
        this.f2319f = qeAccessor;
    }

    public static FramePromptsPromptPartDefinition m2432a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FramePromptsPromptPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2314h) {
                FramePromptsPromptPartDefinition framePromptsPromptPartDefinition;
                if (a2 != null) {
                    framePromptsPromptPartDefinition = (FramePromptsPromptPartDefinition) a2.a(f2314h);
                } else {
                    framePromptsPromptPartDefinition = f2313g;
                }
                if (framePromptsPromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2433b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2314h, b3);
                        } else {
                            f2313g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = framePromptsPromptPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m2434a() {
        return f2312a;
    }
}
