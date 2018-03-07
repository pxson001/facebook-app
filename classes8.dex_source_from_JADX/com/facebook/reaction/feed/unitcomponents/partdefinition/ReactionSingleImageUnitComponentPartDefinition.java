package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.today.common.HasNotifications;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: account_recovery_validate_code */
public class ReactionSingleImageUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, FbDraweeView> {
    public static final ViewType f20071a = new C21471();
    private static final CallerContext f20072b = CallerContext.a(ReactionSingleImageUnitComponentPartDefinition.class, "reaction_images");
    private static ReactionSingleImageUnitComponentPartDefinition f20073e;
    private static final Object f20074f = new Object();
    private final BasicReactionActionPartDefinition f20075c;
    private final FbDraweePartDefinition f20076d;

    /* compiled from: account_recovery_validate_code */
    final class C21471 extends ViewType {
        C21471() {
        }

        public final View m23961a(Context context) {
            FbDraweeView fbDraweeView = new FbDraweeView(context);
            ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).b(2131361970);
            fbDraweeView.setScaleType(ScaleType.CENTER_CROP);
            return fbDraweeView;
        }
    }

    /* compiled from: account_recovery_validate_code */
    public /* synthetic */ class C21482 {
        public static final /* synthetic */ int[] f20070a = new int[GraphQLReactionUnitComponentStyle.values().length];

        static {
            try {
                f20070a[GraphQLReactionUnitComponentStyle.SINGLE_WIDE_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    private static ReactionSingleImageUnitComponentPartDefinition m23963b(InjectorLike injectorLike) {
        return new ReactionSingleImageUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), FbDraweePartDefinition.a(injectorLike));
    }

    public final Object m23965a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        float f;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        FbDraweePartDefinition fbDraweePartDefinition = this.f20076d;
        Builder a = FbDraweePartDefinition.a().a(((ReactionImageFields) reactionUnitComponentNode.f18862b.aW().get(0)).b());
        a.c = f20072b;
        Builder builder = a;
        if (canLaunchReactionIntent instanceof HasNotifications) {
            f = 2.65f;
        } else {
            float f2;
            switch (C21482.f20070a[reactionUnitComponentNode.f18862b.a().ordinal()]) {
                case 1:
                    f2 = 1.5f;
                    break;
                default:
                    f2 = 1.7777778f;
                    break;
            }
            f = f2;
        }
        builder.b = f;
        subParts.a(fbDraweePartDefinition, builder.a());
        if (reactionUnitComponentNode.f18862b.v() != null) {
            subParts.a(this.f20075c, new Props(reactionUnitComponentNode.f18862b.v(), null, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, null, null));
        }
        return null;
    }

    public final boolean m23966a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.aW().isEmpty() || Strings.isNullOrEmpty(((ReactionImageFields) reactionUnitComponentFields.aW().get(0)).b())) ? false : true;
    }

    public static ReactionSingleImageUnitComponentPartDefinition m23962a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSingleImageUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20074f) {
                ReactionSingleImageUnitComponentPartDefinition reactionSingleImageUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionSingleImageUnitComponentPartDefinition = (ReactionSingleImageUnitComponentPartDefinition) a2.a(f20074f);
                } else {
                    reactionSingleImageUnitComponentPartDefinition = f20073e;
                }
                if (reactionSingleImageUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23963b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20074f, b3);
                        } else {
                            f20073e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSingleImageUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionSingleImageUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, FbDraweePartDefinition fbDraweePartDefinition) {
        this.f20075c = basicReactionActionPartDefinition;
        this.f20076d = fbDraweePartDefinition;
    }

    public final ViewType m23964a() {
        return f20071a;
    }
}
