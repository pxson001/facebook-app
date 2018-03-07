package com.facebook.multirow.parts;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileView;
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
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: num_substories */
public class FacepilePartDefinition extends MultiRowSinglePartDefinition<Props, State, AnyEnvironment, FacepileView> {
    public static final ViewType f7893a = new C06331();
    public static final CallerContext f7894b = CallerContext.a(FacepilePartDefinition.class, "unknown");
    private static FacepilePartDefinition f7895f;
    private static final Object f7896g = new Object();
    public final GenericDraweeHierarchyBuilder f7897c;
    public final FbDraweeControllerBuilder f7898d;
    private final ClickListenerPartDefinition f7899e;

    /* compiled from: num_substories */
    final class C06331 extends ViewType {
        C06331() {
        }

        public final View m9526a(Context context) {
            return new FacepileView(context);
        }
    }

    @Immutable
    /* compiled from: num_substories */
    public final class Props {
        public final ImmutableList<Uri> f7884a;
        @Nullable
        public final OnClickListener f7885b;
        public final int f7886c;
        @Nullable
        public final RoundingParams f7887d;
        @Nullable
        public final Integer f7888e;
        @Nullable
        public final Integer f7889f;

        public Props(ImmutableList<Uri> immutableList, @Nullable OnClickListener onClickListener, int i) {
            this(immutableList, onClickListener, i, null, null, null);
        }

        public Props(ImmutableList<Uri> immutableList, @Nullable OnClickListener onClickListener, int i, RoundingParams roundingParams) {
            this(immutableList, onClickListener, i, roundingParams, null, null);
        }

        public Props(ImmutableList<Uri> immutableList, OnClickListener onClickListener, int i, RoundingParams roundingParams, Integer num, Integer num2) {
            this.f7884a = immutableList;
            this.f7885b = onClickListener;
            this.f7886c = i;
            this.f7887d = roundingParams;
            this.f7888e = num;
            this.f7889f = num2;
        }
    }

    @Immutable
    /* compiled from: num_substories */
    public final class State {
        public final MultiDraweeHolder<GenericDraweeHierarchy> f7890a;
        @Nullable
        public final List<Face> f7891b;
        public final int f7892c;

        public State(List<Face> list, MultiDraweeHolder<GenericDraweeHierarchy> multiDraweeHolder, int i) {
            this.f7891b = list;
            this.f7890a = multiDraweeHolder;
            this.f7892c = i;
        }
    }

    private static FacepilePartDefinition m9528b(InjectorLike injectorLike) {
        return new FacepilePartDefinition(ClickListenerPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    public final Object m9530a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        State state;
        Props props = (Props) obj;
        if (props.f7885b != null) {
            subParts.a(this.f7899e, props.f7885b);
        }
        int i = props.f7886c;
        List<Face> a = FacepileView.a(props.f7884a);
        if (a == null) {
            state = new State(a, null, i);
        } else {
            MultiDraweeHolder multiDraweeHolder = new MultiDraweeHolder();
            this.f7898d.a(f7894b);
            for (Face face : a) {
                if (!(face == null || face.a == null)) {
                    FbPipelineDraweeController s = this.f7898d.b(face.a).s();
                    GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = this.f7897c;
                    genericDraweeHierarchyBuilder.u = props.f7887d;
                    DraweeHolder draweeHolder = new DraweeHolder(genericDraweeHierarchyBuilder.u());
                    draweeHolder.a(s);
                    face.b = draweeHolder.h();
                    multiDraweeHolder.a(draweeHolder);
                }
            }
            state = new State(a, multiDraweeHolder, i);
        }
        return state;
    }

    public final /* bridge */ /* synthetic */ void m9531a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1497629826);
        Props props = (Props) obj;
        State state = (State) obj2;
        FacepileView facepileView = (FacepileView) view;
        facepileView.a(state.f7891b, state.f7890a);
        facepileView.setFaceCountForOverflow(state.f7892c);
        if (props.f7889f != null) {
            facepileView.setHorizontalPadding(props.f7889f.intValue());
        }
        if (props.f7888e != null) {
            facepileView.setFaceSize(props.f7888e.intValue());
        }
        Logger.a(8, EntryType.MARK_POP, -1670686151, a);
    }

    public static FacepilePartDefinition m9527a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FacepilePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7896g) {
                FacepilePartDefinition facepilePartDefinition;
                if (a2 != null) {
                    facepilePartDefinition = (FacepilePartDefinition) a2.a(f7896g);
                } else {
                    facepilePartDefinition = f7895f;
                }
                if (facepilePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9528b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7896g, b3);
                        } else {
                            f7895f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = facepilePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FacepilePartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, Resources resources, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f7899e = clickListenerPartDefinition;
        this.f7897c = new GenericDraweeHierarchyBuilder(resources);
        this.f7898d = fbDraweeControllerBuilder;
    }

    public final boolean m9532a(Object obj) {
        return true;
    }

    public final ViewType<FacepileView> m9529a() {
        return f7893a;
    }
}
