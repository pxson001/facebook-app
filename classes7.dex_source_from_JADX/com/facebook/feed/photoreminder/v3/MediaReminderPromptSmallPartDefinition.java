package com.facebook.feed.photoreminder.v3;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.view.View;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition.Props;
import com.facebook.feed.inlinecomposer.multirow.common.PromptActionHandlePartDefinition;
import com.facebook.feed.photoreminder.MediaReminderUtil;
import com.facebook.feed.photoreminder.model.MediaModel;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.productionprompts.common.v3.ImageHolder;
import com.facebook.productionprompts.common.v3.OverlappingImageBlockLayout;
import com.facebook.productionprompts.common.v3.PromptConfidenceHelper;
import com.facebook.productionprompts.common.v3.V3PromptsDraweeHelper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: admin_click_recent_activity */
public class MediaReminderPromptSmallPartDefinition<E extends HasPositionInformation & HasContext> extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, State, E, OverlappingImageBlockLayout> {
    public static final ViewType<OverlappingImageBlockLayout> f19789a = new C17191();
    private static MediaReminderPromptSmallPartDefinition f19790g;
    private static final Object f19791h = new Object();
    private final PromptActionContextFactory f19792b;
    private final PromptActionHandlePartDefinition f19793c;
    private final V3PromptsDraweeHelper f19794d;
    public final MediaReminderUtil f19795e;
    private final BaseV3PromptPartDefinition f19796f;

    /* compiled from: admin_click_recent_activity */
    final class C17191 extends ViewType<OverlappingImageBlockLayout> {
        C17191() {
        }

        public final View m23044a(Context context) {
            return new OverlappingImageBlockLayout(context);
        }
    }

    @VisibleForTesting
    /* compiled from: admin_click_recent_activity */
    class ImageHolderImpl implements ImageHolder {
        private final ImmutableList<DraweeHolder> f19785a;
        private final Uri f19786b;

        public ImageHolderImpl(Uri uri, DraweeHolder draweeHolder) {
            this.f19786b = uri;
            this.f19785a = ImmutableList.of(draweeHolder);
        }

        public final void mo1481a(Canvas canvas, int i, int i2) {
            ((DraweeHolder) this.f19785a.get(0)).h().setBounds(0, 0, i, i2);
            ((DraweeHolder) this.f19785a.get(0)).h().draw(canvas);
        }

        public final ImmutableList<DraweeHolder> mo1480a() {
            return this.f19785a;
        }
    }

    /* compiled from: admin_click_recent_activity */
    public class State {
        public final ImageHolder f19787a;
        public final ImageHolder f19788b;

        public State(ImageHolder imageHolder, ImageHolder imageHolder2) {
            this.f19787a = imageHolder;
            this.f19788b = imageHolder2;
        }
    }

    private static MediaReminderPromptSmallPartDefinition m23051b(InjectorLike injectorLike) {
        return new MediaReminderPromptSmallPartDefinition(PromptActionContextFactory.b(injectorLike), PromptActionHandlePartDefinition.m22770a(injectorLike), BaseV3PromptPartDefinition.m22760a(injectorLike), V3PromptsDraweeHelper.b(injectorLike), MediaReminderUtil.a(injectorLike));
    }

    public final Object m23053a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(this.f19796f, new Props(promptPartDefinitionProps, false));
        subParts.a(this.f19793c, PromptActionHandlePartDefinition.Props.m22769a(PromptActionContextFactory.a(SafeUUIDGenerator.a().toString()), promptPartDefinitionProps));
        ImmutableList a = ((PhotoReminderPromptObject) promptPartDefinitionProps.a.a).a.a();
        ImageHolder a2 = m23050a(((MediaModel) a.get(0)).f19772d, ((HasContext) hasPositionInformation).getContext());
        ImageHolder imageHolder = null;
        if (a.size() > 1) {
            imageHolder = m23050a(((MediaModel) a.get(1)).f19772d, ((HasContext) hasPositionInformation).getContext());
        }
        return new State(a2, imageHolder);
    }

    public final /* bridge */ /* synthetic */ void m23054a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1419848202);
        State state = (State) obj2;
        ((OverlappingImageBlockLayout) view).a(state.f19787a, state.f19788b);
        this.f19795e.c();
        Logger.a(8, EntryType.MARK_POP, -1844423976, a);
    }

    public final boolean m23055a(Object obj) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        if (MediaReminderUtil.a(promptPartDefinitionProps)) {
            if ((!PromptConfidenceHelper.a(promptPartDefinitionProps) ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public static MediaReminderPromptSmallPartDefinition m23049a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaReminderPromptSmallPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19791h) {
                MediaReminderPromptSmallPartDefinition mediaReminderPromptSmallPartDefinition;
                if (a2 != null) {
                    mediaReminderPromptSmallPartDefinition = (MediaReminderPromptSmallPartDefinition) a2.a(f19791h);
                } else {
                    mediaReminderPromptSmallPartDefinition = f19790g;
                }
                if (mediaReminderPromptSmallPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23051b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19791h, b3);
                        } else {
                            f19790g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaReminderPromptSmallPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MediaReminderPromptSmallPartDefinition(PromptActionContextFactory promptActionContextFactory, PromptActionHandlePartDefinition promptActionHandlePartDefinition, BaseV3PromptPartDefinition baseV3PromptPartDefinition, V3PromptsDraweeHelper v3PromptsDraweeHelper, MediaReminderUtil mediaReminderUtil) {
        this.f19792b = promptActionContextFactory;
        this.f19796f = baseV3PromptPartDefinition;
        this.f19793c = promptActionHandlePartDefinition;
        this.f19794d = v3PromptsDraweeHelper;
        this.f19795e = mediaReminderUtil;
    }

    public final ViewType<OverlappingImageBlockLayout> m23052a() {
        return f19789a;
    }

    private ImageHolder m23050a(Uri uri, Context context) {
        return new ImageHolderImpl(uri, this.f19794d.a(uri, context));
    }
}
