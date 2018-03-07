package com.facebook.feed.rows.styling;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.graphql.model.FeedUnit;
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
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: show_aggregate_post_button */
public class PaddingPartDefinition extends BaseSinglePartDefinition<PaddingData, Rect, AnyEnvironment, View> {
    private static PaddingPartDefinition f3748c;
    private static final Object f3749d = new Object();
    private final Context f3750a;
    private final BasePaddingStyleResolver f3751b;

    @Immutable
    /* compiled from: show_aggregate_post_button */
    public class PaddingData {
        public final FeedUnit f3744a;
        public final PaddingStyle f3745b;
        public final Position f3746c;
        public final int f3747d;

        public PaddingData(FeedUnit feedUnit, PaddingStyle paddingStyle, Position position, int i) {
            this.f3744a = feedUnit;
            this.f3745b = paddingStyle;
            this.f3746c = position;
            this.f3747d = i;
        }
    }

    private static PaddingPartDefinition m4419b(InjectorLike injectorLike) {
        return new PaddingPartDefinition((Context) injectorLike.getInstance(Context.class), (BasePaddingStyleResolver) DefaultPaddingStyleResolver.a(injectorLike));
    }

    public final Object m4420a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PaddingData paddingData = (PaddingData) obj;
        Rect rect = new Rect();
        BackgroundStyles.a(paddingData.f3746c, paddingData.f3747d, this.f3751b, paddingData.f3745b, this.f3750a, rect);
        return rect;
    }

    public final /* bridge */ /* synthetic */ void m4421a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 364513074);
        Rect rect = (Rect) obj2;
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        Logger.a(8, EntryType.MARK_POP, 1493756138, a);
    }

    @Inject
    public PaddingPartDefinition(Context context, BasePaddingStyleResolver basePaddingStyleResolver) {
        this.f3750a = context;
        this.f3751b = basePaddingStyleResolver;
    }

    public static PaddingPartDefinition m4418a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PaddingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3749d) {
                PaddingPartDefinition paddingPartDefinition;
                if (a2 != null) {
                    paddingPartDefinition = (PaddingPartDefinition) a2.a(f3749d);
                } else {
                    paddingPartDefinition = f3748c;
                }
                if (paddingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4419b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3749d, b3);
                        } else {
                            f3748c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = paddingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
