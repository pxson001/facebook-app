package com.facebook.feed.photoreminder;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutPartDefinition.Props;
import com.facebook.feed.inlinecomposer.multirow.common.views.V2PromptFlyoutView;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: admin_tapped_add_to_favorites */
public class MediaReminderPromptsPromptPartDefinition<E extends HasContext & HasPersistentState> extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, Void, E, V2PromptFlyoutView> {
    public static final ViewType f19688a = new C17071();
    private static MediaReminderPromptsPromptPartDefinition f19689f;
    private static final Object f19690g = new Object();
    private final InlineComposerPromptFlyoutPartDefinition f19691b;
    private final MediaReminderAnimationBuilder f19692c;
    private final InlineComposerPersistentStateHelper f19693d;
    private final MediaReminderUtil f19694e;

    /* compiled from: admin_tapped_add_to_favorites */
    final class C17071 extends ViewType {
        C17071() {
        }

        public final View m22956a(Context context) {
            Object v2PromptFlyoutView = new V2PromptFlyoutView(context);
            v2PromptFlyoutView.getAttachmentInsertPoint().addView(new PhotoReminderV2View(context).mo1476a());
            v2PromptFlyoutView.getAttachmentInsertPoint().addView(new View(context));
            return v2PromptFlyoutView;
        }
    }

    private static MediaReminderPromptsPromptPartDefinition m22958b(InjectorLike injectorLike) {
        return new MediaReminderPromptsPromptPartDefinition(InlineComposerPromptFlyoutPartDefinition.a(injectorLike), MediaReminderAnimationBuilder.m22954b(injectorLike), InlineComposerPersistentStateHelper.b(injectorLike), MediaReminderUtil.a(injectorLike));
    }

    public final Object m22960a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        subParts.a(this.f19691b, new Props(promptPartDefinitionProps.c, promptPartDefinitionProps.c.g(), promptPartDefinitionProps.a, promptPartDefinitionProps.b, this.f19693d.b(promptPartDefinitionProps.a)));
        this.f19693d.a(subParts, promptPartDefinitionProps.a, promptPartDefinitionProps.b, MediaReminderPromptsPromptPartDefinition.class, this.f19692c);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m22961a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 365180908);
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        V2PromptFlyoutView v2PromptFlyoutView = (V2PromptFlyoutView) view;
        PhotoReminderV2View photoReminderV2View = (PhotoReminderV2View) v2PromptFlyoutView.getV2AttachmentView();
        photoReminderV2View.m23013a(((PhotoReminderPromptObject) promptPartDefinitionProps.a.a).a);
        photoReminderV2View.setPromptSession(promptPartDefinitionProps.a);
        v2PromptFlyoutView.getAttachmentInsertPoint().setVisibility(0);
        Logger.a(8, EntryType.MARK_POP, 215717997, a);
    }

    public final boolean m22962a(Object obj) {
        return MediaReminderUtil.a((PromptPartDefinitionProps) obj);
    }

    public final void m22963b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        V2PromptFlyoutView v2PromptFlyoutView = (V2PromptFlyoutView) view;
        ((PhotoReminderV2View) v2PromptFlyoutView.getV2AttachmentView()).setPromptSession(null);
        v2PromptFlyoutView.getAttachmentInsertPoint().setVisibility(8);
    }

    @Inject
    public MediaReminderPromptsPromptPartDefinition(InlineComposerPromptFlyoutPartDefinition inlineComposerPromptFlyoutPartDefinition, MediaReminderAnimationBuilder mediaReminderAnimationBuilder, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper, MediaReminderUtil mediaReminderUtil) {
        this.f19691b = inlineComposerPromptFlyoutPartDefinition;
        this.f19692c = mediaReminderAnimationBuilder;
        this.f19693d = inlineComposerPersistentStateHelper;
        this.f19694e = mediaReminderUtil;
    }

    public final ViewType m22959a() {
        return f19688a;
    }

    public static MediaReminderPromptsPromptPartDefinition m22957a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaReminderPromptsPromptPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19690g) {
                MediaReminderPromptsPromptPartDefinition mediaReminderPromptsPromptPartDefinition;
                if (a2 != null) {
                    mediaReminderPromptsPromptPartDefinition = (MediaReminderPromptsPromptPartDefinition) a2.a(f19690g);
                } else {
                    mediaReminderPromptsPromptPartDefinition = f19689f;
                }
                if (mediaReminderPromptsPromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22958b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19690g, b3);
                        } else {
                            f19689f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaReminderPromptsPromptPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
