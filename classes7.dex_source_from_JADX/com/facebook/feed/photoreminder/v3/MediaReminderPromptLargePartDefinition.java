package com.facebook.feed.photoreminder.v3;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition.Props;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper;
import com.facebook.feed.photoreminder.MediaReminderAnimationBuilder;
import com.facebook.feed.photoreminder.MediaReminderUtil;
import com.facebook.feed.photoreminder.PhotoReminderV2View;
import com.facebook.feed.photoreminder.model.MediaReminderModel;
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
import com.facebook.productionprompts.common.v3.PromptConfidenceHelper;
import javax.inject.Inject;

@ContextScoped
/* compiled from: admin_click_recent_mentions */
public class MediaReminderPromptLargePartDefinition<E extends HasContext & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, Void, E, MediaReminderV3LargeView> {
    public static final ViewType f19773a = new C17181();
    private static MediaReminderPromptLargePartDefinition f19774f;
    private static final Object f19775g = new Object();
    private final MediaReminderAnimationBuilder f19776b;
    private final InlineComposerPersistentStateHelper f19777c;
    private final MediaReminderUtil f19778d;
    private final BaseV3PromptPartDefinition f19779e;

    /* compiled from: admin_click_recent_mentions */
    final class C17181 extends ViewType {
        C17181() {
        }

        public final View m23032a(Context context) {
            return new MediaReminderV3LargeView(context);
        }
    }

    private static MediaReminderPromptLargePartDefinition m23034b(InjectorLike injectorLike) {
        return new MediaReminderPromptLargePartDefinition(MediaReminderAnimationBuilder.m22954b(injectorLike), InlineComposerPersistentStateHelper.b(injectorLike), BaseV3PromptPartDefinition.m22760a(injectorLike), MediaReminderUtil.a(injectorLike));
    }

    public final Object m23036a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        this.f19777c.a(subParts, promptPartDefinitionProps.a, promptPartDefinitionProps.b, MediaReminderPromptLargePartDefinition.class, this.f19776b);
        subParts.a(this.f19779e, new Props(promptPartDefinitionProps, false));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23037a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -204412644);
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        MediaReminderV3LargeView mediaReminderV3LargeView = (MediaReminderV3LargeView) view;
        MediaReminderModel mediaReminderModel = ((PhotoReminderPromptObject) promptPartDefinitionProps.a.a).a;
        PhotoReminderV2View v2AttachmentView = mediaReminderV3LargeView.getV2AttachmentView();
        v2AttachmentView.m23013a(mediaReminderModel);
        v2AttachmentView.setPromptSession(promptPartDefinitionProps.a);
        Logger.a(8, EntryType.MARK_POP, -271081212, a);
    }

    public final boolean m23038a(Object obj) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        return MediaReminderUtil.a(promptPartDefinitionProps) && PromptConfidenceHelper.a(promptPartDefinitionProps);
    }

    public final void m23039b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((MediaReminderV3LargeView) view).getV2AttachmentView().setPromptSession(null);
    }

    @Inject
    public MediaReminderPromptLargePartDefinition(MediaReminderAnimationBuilder mediaReminderAnimationBuilder, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper, BaseV3PromptPartDefinition baseV3PromptPartDefinition, MediaReminderUtil mediaReminderUtil) {
        this.f19776b = mediaReminderAnimationBuilder;
        this.f19777c = inlineComposerPersistentStateHelper;
        this.f19778d = mediaReminderUtil;
        this.f19779e = baseV3PromptPartDefinition;
    }

    public static MediaReminderPromptLargePartDefinition m23033a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaReminderPromptLargePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19775g) {
                MediaReminderPromptLargePartDefinition mediaReminderPromptLargePartDefinition;
                if (a2 != null) {
                    mediaReminderPromptLargePartDefinition = (MediaReminderPromptLargePartDefinition) a2.a(f19775g);
                } else {
                    mediaReminderPromptLargePartDefinition = f19774f;
                }
                if (mediaReminderPromptLargePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23034b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19775g, b3);
                        } else {
                            f19774f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaReminderPromptLargePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23035a() {
        return f19773a;
    }
}
