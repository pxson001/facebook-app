package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
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
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ui.ReactionImageWithOverlayGridItemView;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitImageWithOverlayComponentFragementModel.ImagesWithOverlayModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: admin_display_preference */
public class ReactionImageWithOverlaySingleItemUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<Props, State, E, ReactionImageWithOverlayGridItemView> {
    public static final ViewType f19847a = new C21311();
    private static final CallerContext f19848b = CallerContext.a(ReactionImageWithOverlayGridUnitComponentPartDefinition.class, "reaction_photos");
    private static ReactionImageWithOverlaySingleItemUnitComponentPartDefinition f19849e;
    private static final Object f19850f = new Object();
    private final FbDraweeControllerBuilder f19851c;
    private final BasicReactionActionPartDefinition f19852d;

    /* compiled from: admin_display_preference */
    final class C21311 extends ViewType {
        C21311() {
        }

        public final View m23750a(Context context) {
            return new ReactionImageWithOverlayGridItemView(context);
        }
    }

    /* compiled from: admin_display_preference */
    public class Props {
        public final ImagesWithOverlayModel f19840a;
        public final String f19841b;
        public final String f19842c;

        public Props(ImagesWithOverlayModel imagesWithOverlayModel, String str, String str2) {
            this.f19840a = imagesWithOverlayModel;
            this.f19841b = str;
            this.f19842c = str2;
        }
    }

    /* compiled from: admin_display_preference */
    public class State {
        public final String f19843a;
        public final DraweeController f19844b;
        public final DraweeController f19845c;
        public final String f19846d;

        public State(String str, DraweeController draweeController, DraweeController draweeController2, String str2) {
            this.f19843a = str;
            this.f19844b = draweeController;
            this.f19845c = draweeController2;
            this.f19846d = str2;
        }
    }

    private static ReactionImageWithOverlaySingleItemUnitComponentPartDefinition m23752b(InjectorLike injectorLike) {
        return new ReactionImageWithOverlaySingleItemUnitComponentPartDefinition(FbDraweeControllerBuilder.b(injectorLike), BasicReactionActionPartDefinition.m22984a(injectorLike));
    }

    public final Object m23754a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        DraweeController draweeController;
        Props props = (Props) obj;
        DraweeController draweeController2 = null;
        ImagesWithOverlayModel imagesWithOverlayModel = props.f19840a;
        subParts.a(this.f19852d, new com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props(imagesWithOverlayModel.a(), props.f19841b, props.f19842c));
        if (imagesWithOverlayModel.gm_() == null || imagesWithOverlayModel.gm_().b() == null) {
            draweeController = null;
        } else {
            draweeController = this.f19851c.a(f19848b).b(Uri.parse(imagesWithOverlayModel.gm_().b())).s();
        }
        if (!(imagesWithOverlayModel.c() == null || imagesWithOverlayModel.c().b() == null)) {
            draweeController2 = this.f19851c.a(f19848b).b(Uri.parse(imagesWithOverlayModel.c().b())).s();
        }
        return new State(imagesWithOverlayModel.d(), draweeController2, draweeController, imagesWithOverlayModel.b());
    }

    public final /* bridge */ /* synthetic */ void m23755a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1000667598);
        State state = (State) obj2;
        ((ReactionImageWithOverlayGridItemView) view).m24051a(state.f19843a, state.f19845c, state.f19844b, state.f19846d);
        Logger.a(8, EntryType.MARK_POP, 733651558, a);
    }

    public final void m23757b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ReactionImageWithOverlayGridItemView) view).m24051a(null, null, null, null);
    }

    public static ReactionImageWithOverlaySingleItemUnitComponentPartDefinition m23751a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionImageWithOverlaySingleItemUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19850f) {
                ReactionImageWithOverlaySingleItemUnitComponentPartDefinition reactionImageWithOverlaySingleItemUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionImageWithOverlaySingleItemUnitComponentPartDefinition = (ReactionImageWithOverlaySingleItemUnitComponentPartDefinition) a2.a(f19850f);
                } else {
                    reactionImageWithOverlaySingleItemUnitComponentPartDefinition = f19849e;
                }
                if (reactionImageWithOverlaySingleItemUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23752b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19850f, b3);
                        } else {
                            f19849e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionImageWithOverlaySingleItemUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionImageWithOverlaySingleItemUnitComponentPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, BasicReactionActionPartDefinition basicReactionActionPartDefinition) {
        this.f19851c = fbDraweeControllerBuilder;
        this.f19852d = basicReactionActionPartDefinition;
    }

    public final ViewType m23753a() {
        return f19847a;
    }

    public final boolean m23756a(Object obj) {
        return true;
    }
}
