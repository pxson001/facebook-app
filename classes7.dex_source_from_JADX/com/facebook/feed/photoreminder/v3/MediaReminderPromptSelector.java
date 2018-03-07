package com.facebook.feed.photoreminder.v3;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.photoreminder.MediaReminderUtil;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: admin_click_recent_check_ins */
public class MediaReminderPromptSelector<E extends HasPositionInformation & PromptViewStateUpdater & HasContext & HasPersistentState> extends BaseMultiRowGroupPartDefinition<PromptPartDefinitionProps, Void, E> {
    private static MediaReminderPromptSelector f19780d;
    private static final Object f19781e = new Object();
    private final Lazy<MediaReminderPromptSmallPartDefinition<E>> f19782a;
    private final Lazy<MediaReminderPromptLargePartDefinition<E>> f19783b;
    private final MediaReminderUtil f19784c;

    private static MediaReminderPromptSelector m23041b(InjectorLike injectorLike) {
        return new MediaReminderPromptSelector(IdBasedLazy.a(injectorLike, 5880), IdBasedLazy.a(injectorLike, 5878), MediaReminderUtil.a(injectorLike));
    }

    public final Object m23042a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f19782a, promptPartDefinitionProps).a(this.f19783b, promptPartDefinitionProps);
        return null;
    }

    public final boolean m23043a(Object obj) {
        return MediaReminderUtil.a((PromptPartDefinitionProps) obj);
    }

    @Inject
    public MediaReminderPromptSelector(Lazy<MediaReminderPromptSmallPartDefinition> lazy, Lazy<MediaReminderPromptLargePartDefinition> lazy2, MediaReminderUtil mediaReminderUtil) {
        this.f19782a = lazy;
        this.f19783b = lazy2;
        this.f19784c = mediaReminderUtil;
    }

    public static MediaReminderPromptSelector m23040a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaReminderPromptSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19781e) {
                MediaReminderPromptSelector mediaReminderPromptSelector;
                if (a2 != null) {
                    mediaReminderPromptSelector = (MediaReminderPromptSelector) a2.a(f19781e);
                } else {
                    mediaReminderPromptSelector = f19780d;
                }
                if (mediaReminderPromptSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23041b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19781e, b3);
                        } else {
                            f19780d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaReminderPromptSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
