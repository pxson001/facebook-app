package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ViewColorPartDefinition;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sms/mms thread deletion failed. # threads = %d */
public class VideoHomeGapPartDefinition extends MultiRowSinglePartDefinition<Props, State, AnyEnvironment, View> {
    public static ViewType<View> f3068a = ViewType.a(2130904578);
    private static VideoHomeGapPartDefinition f3069d;
    private static final Object f3070e = new Object();
    private final Resources f3071b;
    private final ViewColorPartDefinition f3072c;

    /* compiled from: sms/mms thread deletion failed. # threads = %d */
    public class Props {
        @DimenRes
        public final int f3065a;
        @ColorRes
        public final int f3066b;

        public Props(int i, int i2) {
            this.f3065a = i;
            this.f3066b = i2;
        }
    }

    @Immutable
    /* compiled from: sms/mms thread deletion failed. # threads = %d */
    public class State {
        public final int f3067a;

        public State(int i) {
            this.f3067a = i;
        }
    }

    private static VideoHomeGapPartDefinition m2938b(InjectorLike injectorLike) {
        return new VideoHomeGapPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), ViewColorPartDefinition.a(injectorLike));
    }

    public final Object m2940a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f3072c, Integer.valueOf(props.f3066b));
        return new State(this.f3071b.getDimensionPixelSize(props.f3065a));
    }

    public final /* bridge */ /* synthetic */ void m2941a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -93938728);
        view.setMinimumHeight(((State) obj2).f3067a);
        Logger.a(8, EntryType.MARK_POP, -1541158287, a);
    }

    public final boolean m2942a(Object obj) {
        return ((Props) obj).f3065a != 0;
    }

    @Inject
    public VideoHomeGapPartDefinition(Resources resources, ViewColorPartDefinition viewColorPartDefinition) {
        this.f3071b = resources;
        this.f3072c = viewColorPartDefinition;
    }

    public static VideoHomeGapPartDefinition m2937a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeGapPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3070e) {
                VideoHomeGapPartDefinition videoHomeGapPartDefinition;
                if (a2 != null) {
                    videoHomeGapPartDefinition = (VideoHomeGapPartDefinition) a2.a(f3070e);
                } else {
                    videoHomeGapPartDefinition = f3069d;
                }
                if (videoHomeGapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2938b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3070e, b3);
                        } else {
                            f3069d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeGapPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<View> m2939a() {
        return f3068a;
    }
}
