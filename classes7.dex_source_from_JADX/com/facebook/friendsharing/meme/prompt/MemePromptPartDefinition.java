package com.facebook.friendsharing.meme.prompt;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerEnvironment;
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
/* compiled from: Ripple drawable is not available on android API <21 */
public class MemePromptPartDefinition extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, MemePromptClickListener, InlineComposerEnvironment, V2PromptFlyoutView> {
    public static final ViewType f23958a = new C20761();
    private static MemePromptPartDefinition f23959g;
    private static final Object f23960h = new Object();
    private final InlineComposerPromptFlyoutPartDefinition f23961b;
    private final InlineComposerPersistentStateHelper f23962c;
    private final MemePromptClickListenerProvider f23963d;
    private final QeAccessor f23964e;
    private final MemePromptViewAnimationBuilderProvider f23965f;

    /* compiled from: Ripple drawable is not available on android API <21 */
    final class C20761 extends ViewType {
        C20761() {
        }

        public final View m26075a(Context context) {
            Object v2PromptFlyoutView = new V2PromptFlyoutView(context);
            v2PromptFlyoutView.getAttachmentInsertPoint().addView(new MemePromptView(context).mo1476a());
            return v2PromptFlyoutView;
        }
    }

    private static MemePromptPartDefinition m26077b(InjectorLike injectorLike) {
        return new MemePromptPartDefinition(InlineComposerPromptFlyoutPartDefinition.a(injectorLike), InlineComposerPersistentStateHelper.b(injectorLike), (MemePromptClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MemePromptClickListenerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (MemePromptViewAnimationBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MemePromptViewAnimationBuilderProvider.class));
    }

    public final Object m26079a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        InlineComposerEnvironment inlineComposerEnvironment = (InlineComposerEnvironment) anyEnvironment;
        subParts.a(this.f23961b, new Props(promptPartDefinitionProps.c, promptPartDefinitionProps.c.g(), promptPartDefinitionProps.a, promptPartDefinitionProps.b, this.f23962c.b(promptPartDefinitionProps.a)));
        if (this.f23964e.a(ExperimentsForMemePromptModule.f23953b, false)) {
            MemePromptViewAnimationBuilderProvider memePromptViewAnimationBuilderProvider = this.f23965f;
            SubParts subParts2 = subParts;
            this.f23962c.a(subParts2, promptPartDefinitionProps.a, promptPartDefinitionProps.b, MemePromptPartDefinition.class, new MemePromptViewAnimationBuilder(ScreenUtil.a(memePromptViewAnimationBuilderProvider), DefaultAnimationPartFactory.a(memePromptViewAnimationBuilderProvider), inlineComposerEnvironment.getContext()));
        }
        return this.f23963d.a(promptPartDefinitionProps.a);
    }

    public final /* bridge */ /* synthetic */ void m26080a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1080871523);
        MemePromptClickListener memePromptClickListener = (MemePromptClickListener) obj2;
        V2PromptFlyoutView v2PromptFlyoutView = (V2PromptFlyoutView) view;
        ((MemePromptView) v2PromptFlyoutView.getV2AttachmentView()).m26097a(((PromptPartDefinitionProps) obj).a);
        v2PromptFlyoutView.getFlyoutView().setOnClickListener(memePromptClickListener);
        v2PromptFlyoutView.getAttachmentInsertPoint().setVisibility(0);
        Logger.a(8, EntryType.MARK_POP, -448555704, a);
    }

    public final boolean m26081a(Object obj) {
        PromptObject a = InlineComposerPromptSession.a(((PromptPartDefinitionProps) obj).a);
        if (!(a instanceof ProductionPromptObject)) {
            return false;
        }
        if (this.f23964e.a(ExperimentsForMemePromptModule.f23952a, false)) {
            return ((ProductionPromptObject) a).a.r() != null;
        } else {
            return false;
        }
    }

    public final void m26082b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        V2PromptFlyoutView v2PromptFlyoutView = (V2PromptFlyoutView) view;
        v2PromptFlyoutView.getFlyoutView().setOnClickListener(null);
        v2PromptFlyoutView.getAttachmentInsertPoint().setVisibility(8);
    }

    @Inject
    public MemePromptPartDefinition(InlineComposerPromptFlyoutPartDefinition inlineComposerPromptFlyoutPartDefinition, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper, MemePromptClickListenerProvider memePromptClickListenerProvider, QeAccessor qeAccessor, MemePromptViewAnimationBuilderProvider memePromptViewAnimationBuilderProvider) {
        this.f23961b = inlineComposerPromptFlyoutPartDefinition;
        this.f23962c = inlineComposerPersistentStateHelper;
        this.f23963d = memePromptClickListenerProvider;
        this.f23964e = qeAccessor;
        this.f23965f = memePromptViewAnimationBuilderProvider;
    }

    public static MemePromptPartDefinition m26076a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MemePromptPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23960h) {
                MemePromptPartDefinition memePromptPartDefinition;
                if (a2 != null) {
                    memePromptPartDefinition = (MemePromptPartDefinition) a2.a(f23960h);
                } else {
                    memePromptPartDefinition = f23959g;
                }
                if (memePromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26077b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23960h, b3);
                        } else {
                            f23959g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = memePromptPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m26078a() {
        return f23958a;
    }
}
