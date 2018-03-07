package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import javax.inject.Inject;

@ContextScoped
/* compiled from: action_when_done */
public class ReactionProgressBarUnitComponentPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, HasContext, ProgressBar> {
    public static final Class f20011a = ReactionProgressBarUnitComponentPartDefinition.class;
    public static final ViewType f20012b = ViewType.a(2130906647);
    public static final int f20013c = 2131361916;
    private static ReactionProgressBarUnitComponentPartDefinition f20014e;
    private static final Object f20015f = new Object();
    private final AbstractFbErrorReporter f20016d;

    /* compiled from: action_when_done */
    public class State {
        public final int f20008a;
        public final int f20009b;
        public final Drawable f20010c;

        public State(int i, int i2, Drawable drawable) {
            this.f20008a = i;
            this.f20009b = i2;
            this.f20010c = drawable;
        }
    }

    private static ReactionProgressBarUnitComponentPartDefinition m23902b(InjectorLike injectorLike) {
        return new ReactionProgressBarUnitComponentPartDefinition((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final Object m23904a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int b;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        int i = 3;
        Context context = ((HasContext) anyEnvironment).getContext();
        if (TextUtils.isEmpty(reactionUnitComponentNode.m22885f().cb())) {
            b = ContextCompat.b(context, f20013c);
        } else {
            try {
                b = Color.parseColor("#" + reactionUnitComponentNode.m22885f().cb());
            } catch (IllegalArgumentException e) {
                int b2 = ContextCompat.b(context, f20013c);
                this.f20016d.b(f20011a.getSimpleName(), "Malformed color sent from server: " + reactionUnitComponentNode.m22885f().cb());
                b = b2;
            }
        }
        LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.a(context, 2130842918);
        Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301);
        findDrawableByLayerId.setColorFilter(b, Mode.SRC_ATOP);
        findDrawableByLayerId.setAlpha(Color.alpha(b));
        int bJ = (int) (reactionUnitComponentNode.m22885f().bJ() * 100.0d);
        if (bJ >= 3) {
            i = bJ;
        }
        return new State(i, b, layerDrawable);
    }

    public final /* bridge */ /* synthetic */ void m23905a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1111208408);
        State state = (State) obj2;
        ProgressBar progressBar = (ProgressBar) view;
        progressBar.setProgressDrawable(state.f20010c);
        progressBar.setProgress(0);
        progressBar.setProgress(state.f20008a);
        Logger.a(8, EntryType.MARK_POP, -1408816186, a);
    }

    public final boolean m23906a(Object obj) {
        int bJ = (int) (((ReactionUnitComponentNode) obj).f18862b.bJ() * 100.0d);
        return bJ >= 0 && bJ <= 100;
    }

    @Inject
    public ReactionProgressBarUnitComponentPartDefinition(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f20016d = abstractFbErrorReporter;
    }

    public static ReactionProgressBarUnitComponentPartDefinition m23901a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionProgressBarUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20015f) {
                ReactionProgressBarUnitComponentPartDefinition reactionProgressBarUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionProgressBarUnitComponentPartDefinition = (ReactionProgressBarUnitComponentPartDefinition) a2.a(f20015f);
                } else {
                    reactionProgressBarUnitComponentPartDefinition = f20014e;
                }
                if (reactionProgressBarUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23902b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20015f, b3);
                        } else {
                            f20014e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionProgressBarUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23903a() {
        return f20012b;
    }
}
