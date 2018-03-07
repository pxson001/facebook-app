package com.facebook.friendsharing.suggestedcoverphotos.prompt;

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
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ProfileDetailsQuery */
public class CoverPhotoPromptPartDefinition extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, CoverPhotoPromptClickListener, InlineComposerEnvironment, V2PromptFlyoutView> {
    public static final ViewType f24316a = new C21191();
    private static CoverPhotoPromptPartDefinition f24317g;
    private static final Object f24318h = new Object();
    private final InlineComposerPromptFlyoutPartDefinition f24319b;
    private final InlineComposerPersistentStateHelper f24320c;
    private final CoverPhotoPromptViewAnimationBuilderProvider f24321d;
    private final CoverPhotoPromptClickListenerProvider f24322e;
    public CoverPhotoPromptClickListener f24323f;

    /* compiled from: ProfileDetailsQuery */
    final class C21191 extends ViewType {
        C21191() {
        }

        public final View m26511a(Context context) {
            Object v2PromptFlyoutView = new V2PromptFlyoutView(context);
            v2PromptFlyoutView.getAttachmentInsertPoint().addView(new CoverPhotoPromptView(context).mo1476a());
            return v2PromptFlyoutView;
        }
    }

    private static CoverPhotoPromptPartDefinition m26513b(InjectorLike injectorLike) {
        return new CoverPhotoPromptPartDefinition(InlineComposerPromptFlyoutPartDefinition.a(injectorLike), InlineComposerPersistentStateHelper.b(injectorLike), (CoverPhotoPromptViewAnimationBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CoverPhotoPromptViewAnimationBuilderProvider.class), (CoverPhotoPromptClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CoverPhotoPromptClickListenerProvider.class));
    }

    public final Object m26515a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        InlineComposerEnvironment inlineComposerEnvironment = (InlineComposerEnvironment) anyEnvironment;
        subParts.a(this.f24319b, new Props(promptPartDefinitionProps.c, promptPartDefinitionProps.c.g(), promptPartDefinitionProps.a, promptPartDefinitionProps.b, this.f24320c.b(promptPartDefinitionProps.a)));
        CoverPhotoPromptViewAnimationBuilderProvider coverPhotoPromptViewAnimationBuilderProvider = this.f24321d;
        SubParts subParts2 = subParts;
        this.f24320c.a(subParts2, promptPartDefinitionProps.a, promptPartDefinitionProps.b, CoverPhotoPromptPartDefinition.class, new CoverPhotoPromptViewAnimationBuilder(ScreenUtil.a(coverPhotoPromptViewAnimationBuilderProvider), DefaultAnimationPartFactory.a(coverPhotoPromptViewAnimationBuilderProvider), inlineComposerEnvironment.getContext()));
        this.f24323f = this.f24322e.a(promptPartDefinitionProps.a);
        return this.f24323f;
    }

    public final /* bridge */ /* synthetic */ void m26516a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 379208796);
        V2PromptFlyoutView v2PromptFlyoutView = (V2PromptFlyoutView) view;
        ((CoverPhotoPromptView) v2PromptFlyoutView.getV2AttachmentView()).m26524a(((PromptPartDefinitionProps) obj).a);
        v2PromptFlyoutView.getFlyoutView().setOnClickListener(this.f24323f);
        v2PromptFlyoutView.getAttachmentInsertPoint().setVisibility(0);
        Logger.a(8, EntryType.MARK_POP, 1192622787, a);
    }

    public final boolean m26517a(Object obj) {
        PromptObject a = InlineComposerPromptSession.a(((PromptPartDefinitionProps) obj).a);
        if (!(a instanceof ProductionPromptObject)) {
            return false;
        }
        ImmutableList s = ((ProductionPromptObject) a).a.s();
        return (s == null || s.isEmpty()) ? false : true;
    }

    public final void m26518b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        V2PromptFlyoutView v2PromptFlyoutView = (V2PromptFlyoutView) view;
        v2PromptFlyoutView.getFlyoutView().setOnClickListener(null);
        v2PromptFlyoutView.getAttachmentInsertPoint().setVisibility(8);
    }

    @Inject
    public CoverPhotoPromptPartDefinition(InlineComposerPromptFlyoutPartDefinition inlineComposerPromptFlyoutPartDefinition, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper, CoverPhotoPromptViewAnimationBuilderProvider coverPhotoPromptViewAnimationBuilderProvider, CoverPhotoPromptClickListenerProvider coverPhotoPromptClickListenerProvider) {
        this.f24319b = inlineComposerPromptFlyoutPartDefinition;
        this.f24320c = inlineComposerPersistentStateHelper;
        this.f24321d = coverPhotoPromptViewAnimationBuilderProvider;
        this.f24322e = coverPhotoPromptClickListenerProvider;
    }

    public static CoverPhotoPromptPartDefinition m26512a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CoverPhotoPromptPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24318h) {
                CoverPhotoPromptPartDefinition coverPhotoPromptPartDefinition;
                if (a2 != null) {
                    coverPhotoPromptPartDefinition = (CoverPhotoPromptPartDefinition) a2.a(f24318h);
                } else {
                    coverPhotoPromptPartDefinition = f24317g;
                }
                if (coverPhotoPromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26513b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24318h, b3);
                        } else {
                            f24317g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = coverPhotoPromptPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m26514a() {
        return f24316a;
    }
}
