package com.facebook.photos.creativeediting.swipeable.prompt.v3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition.Props;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.creativeediting.model.DraweeSwipeableItem;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableDrawHelper;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.creativeediting.swipeable.prompt.ExperimentsForSwipeablePromptModule;
import com.facebook.productionprompts.common.v3.ImageHolder;
import com.facebook.productionprompts.common.v3.OverlappingImageBlockLayout;
import com.facebook.productionprompts.common.v3.V3PromptsDraweeHelper;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: source_image_config */
public class FramePromptSmallPartDefinition<E extends HasPositionInformation & PromptViewStateUpdater & HasContext> extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, State, E, OverlappingImageBlockLayout> {
    public static final ViewType f2329a = new C02781();
    private static FramePromptSmallPartDefinition f2330g;
    private static final Object f2331h = new Object();
    private final QeAccessor f2332b;
    private final SwipeableParamsHelper f2333c;
    private final Resources f2334d;
    private final V3PromptsDraweeHelper f2335e;
    private final BaseV3PromptPartDefinition f2336f;

    /* compiled from: source_image_config */
    final class C02781 extends ViewType {
        C02781() {
        }

        public final View m2440a(Context context) {
            return new OverlappingImageBlockLayout(context);
        }
    }

    @VisibleForTesting
    /* compiled from: source_image_config */
    public class FrameOverlappingImageDrawer implements ImageHolder {
        private final DraweeSwipeableItem f2323a;
        private final Resources f2324b;
        private final ImmutableList<DraweeHolder> f2325c;
        private RectF f2326d;

        public FrameOverlappingImageDrawer(DraweeSwipeableItem draweeSwipeableItem, Resources resources) {
            this.f2323a = draweeSwipeableItem;
            this.f2324b = resources;
            Builder builder = new Builder();
            if (draweeSwipeableItem.c != null) {
                builder.c(draweeSwipeableItem.c);
            }
            for (DraweeHolder c : draweeSwipeableItem.b.values()) {
                builder.c(c);
            }
            this.f2325c = builder.b();
        }

        public final ImmutableList<DraweeHolder> m2441a() {
            return this.f2325c;
        }

        public final void m2442a(Canvas canvas, int i, int i2) {
            if (this.f2323a != null) {
                if (this.f2326d == null) {
                    this.f2326d = new RectF(0.0f, 0.0f, (float) i, (float) i2);
                }
                Drawable drawable = this.f2324b.getDrawable(2130840415);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                ImmutableList c = this.f2323a.c();
                int size = c.size();
                for (int i3 = 0; i3 < size; i3++) {
                    StickerParams stickerParams = (StickerParams) c.get(i3);
                    if (this.f2323a.a(stickerParams) != null) {
                        SwipeableDrawHelper.a(canvas, this.f2323a.a(stickerParams).h(), stickerParams, 0, this.f2326d);
                    }
                }
            }
        }
    }

    /* compiled from: source_image_config */
    public class State {
        public final FrameOverlappingImageDrawer f2327a;
        public final FrameOverlappingImageDrawer f2328b;

        public State(FrameOverlappingImageDrawer frameOverlappingImageDrawer, FrameOverlappingImageDrawer frameOverlappingImageDrawer2) {
            this.f2327a = frameOverlappingImageDrawer;
            this.f2328b = frameOverlappingImageDrawer2;
        }
    }

    private static FramePromptSmallPartDefinition m2445b(InjectorLike injectorLike) {
        return new FramePromptSmallPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SwipeableParamsHelper.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), V3PromptsDraweeHelper.m4380b(injectorLike), BaseV3PromptPartDefinition.a(injectorLike));
    }

    public final Object m2447a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(this.f2336f, Props.a(promptPartDefinitionProps));
        ImmutableList a = this.f2333c.a(((ProductionPromptObject) promptPartDefinitionProps.a.a).a.m(), this.f2334d.getDimensionPixelSize(2131430425), this.f2334d.getDimensionPixelSize(2131430425));
        return new State(m2443a((SwipeableParams) a.get(0), ((HasContext) hasPositionInformation).getContext()), a.size() > 1 ? m2443a((SwipeableParams) a.get(1), ((HasContext) hasPositionInformation).getContext()) : null);
    }

    public final /* bridge */ /* synthetic */ void m2448a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -370164540);
        State state = (State) obj2;
        ((OverlappingImageBlockLayout) view).m4373a(state.f2327a, state.f2328b);
        Logger.a(8, EntryType.MARK_POP, -1055914096, a);
    }

    public final boolean m2449a(Object obj) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        if (!(promptPartDefinitionProps == null || promptPartDefinitionProps.a == null || !(promptPartDefinitionProps.a.a instanceof ProductionPromptObject))) {
            ProductionPromptObject productionPromptObject = (ProductionPromptObject) promptPartDefinitionProps.a.a;
            Object obj2 = (productionPromptObject == null || productionPromptObject.a == null || productionPromptObject.a.m() == null) ? null : 1;
            if (obj2 != null && this.f2332b.a(ExperimentsForSwipeablePromptModule.f2286a, false)) {
                return true;
            }
        }
        return false;
    }

    public static FramePromptSmallPartDefinition m2444a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FramePromptSmallPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2331h) {
                FramePromptSmallPartDefinition framePromptSmallPartDefinition;
                if (a2 != null) {
                    framePromptSmallPartDefinition = (FramePromptSmallPartDefinition) a2.a(f2331h);
                } else {
                    framePromptSmallPartDefinition = f2330g;
                }
                if (framePromptSmallPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2445b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2331h, b3);
                        } else {
                            f2330g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = framePromptSmallPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FramePromptSmallPartDefinition(QeAccessor qeAccessor, SwipeableParamsHelper swipeableParamsHelper, Resources resources, V3PromptsDraweeHelper v3PromptsDraweeHelper, BaseV3PromptPartDefinition baseV3PromptPartDefinition) {
        this.f2332b = qeAccessor;
        this.f2333c = swipeableParamsHelper;
        this.f2334d = resources;
        this.f2335e = v3PromptsDraweeHelper;
        this.f2336f = baseV3PromptPartDefinition;
    }

    public final ViewType<OverlappingImageBlockLayout> m2446a() {
        return f2329a;
    }

    private FrameOverlappingImageDrawer m2443a(SwipeableParams swipeableParams, Context context) {
        DraweeSwipeableItem draweeSwipeableItem = new DraweeSwipeableItem(null, "");
        ImmutableList a = swipeableParams.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            StickerParams stickerParams = (StickerParams) a.get(i);
            draweeSwipeableItem.a(stickerParams, this.f2335e.m4381a(stickerParams.d(), context));
        }
        return new FrameOverlappingImageDrawer(draweeSwipeableItem, this.f2334d);
    }
}
