package com.facebook.reaction.feed.corecomponents;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.widget.Text;
import com.facebook.feed.environment.HasContext;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponent;
import com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponent.Builder;
import com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponent.State;
import com.facebook.reaction.feed.corecomponents.spec.ReactionCoreComponent;
import com.facebook.reaction.feed.corecomponents.spec.ReactionCoreImageComponent;
import com.facebook.reaction.feed.corecomponents.spec.ReactionCoreImageTextComponent;
import com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponent;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bellerophon_error */
public class ReactionCoreComponentsBuilder<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> {
    private static ReactionCoreComponentsBuilder f18977g;
    private static final Object f18978h = new Object();
    private final ReactionActionDelegateComponent f18979a;
    private final ReactionCoreComponent f18980b;
    private final ReactionCoreButtonComponent f18981c;
    private final ReactionCoreImageComponent f18982d;
    private final ReactionCoreImageTextComponent f18983e;
    private final ReactionCoreTextComponent f18984f;

    /* compiled from: bellerophon_error */
    /* synthetic */ class C20831 {
        static final /* synthetic */ int[] f18976a = new int[GraphQLReactionUnitComponentStyle.values().length];

        static {
            try {
                f18976a[GraphQLReactionUnitComponentStyle.CORE_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18976a[GraphQLReactionUnitComponentStyle.CORE_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18976a[GraphQLReactionUnitComponentStyle.CORE_IMAGE_TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18976a[GraphQLReactionUnitComponentStyle.CORE_TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static ReactionCoreComponentsBuilder m23009b(InjectorLike injectorLike) {
        return new ReactionCoreComponentsBuilder(ReactionActionDelegateComponent.m24063a(injectorLike), ReactionCoreComponent.m23076a(injectorLike), ReactionCoreButtonComponent.m23062a(injectorLike), ReactionCoreImageComponent.m23090a(injectorLike), ReactionCoreImageTextComponent.m23099a(injectorLike), ReactionCoreTextComponent.m23109a(injectorLike));
    }

    public final Component m23011a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        return this.f18979a.m24066a(componentContext).m24058a(reactionUnitComponentFields.v()).m24057a((CanLaunchReactionIntent) e).m24055a(this.f18980b.m23078a(componentContext).m23073a(reactionUnitComponentFields.Y()).m23070a(reactionUnitComponentFields.Z()).m23071a(reactionUnitComponentFields.ac()).m23072a(reactionUnitComponentFields.ad()).m23069a(m23006a(componentContext, reactionUnitComponentFields))).m24060b(reactionUnitComponentNode.f18863c).m24061c(reactionUnitComponentNode.f18864d).d();
    }

    @Inject
    public ReactionCoreComponentsBuilder(ReactionActionDelegateComponent reactionActionDelegateComponent, ReactionCoreComponent reactionCoreComponent, ReactionCoreButtonComponent reactionCoreButtonComponent, ReactionCoreImageComponent reactionCoreImageComponent, ReactionCoreImageTextComponent reactionCoreImageTextComponent, ReactionCoreTextComponent reactionCoreTextComponent) {
        this.f18979a = reactionActionDelegateComponent;
        this.f18980b = reactionCoreComponent;
        this.f18981c = reactionCoreButtonComponent;
        this.f18982d = reactionCoreImageComponent;
        this.f18983e = reactionCoreImageTextComponent;
        this.f18984f = reactionCoreTextComponent;
    }

    public static ReactionCoreComponentsBuilder m23007a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCoreComponentsBuilder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18978h) {
                ReactionCoreComponentsBuilder reactionCoreComponentsBuilder;
                if (a2 != null) {
                    reactionCoreComponentsBuilder = (ReactionCoreComponentsBuilder) a2.a(f18978h);
                } else {
                    reactionCoreComponentsBuilder = f18977g;
                }
                if (reactionCoreComponentsBuilder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23009b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18978h, b3);
                        } else {
                            f18977g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCoreComponentsBuilder;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static boolean m23008a(ReactionUnitComponentFields reactionUnitComponentFields) {
        switch (C20831.f18976a[reactionUnitComponentFields.a().ordinal()]) {
            case 1:
                return m23010b(reactionUnitComponentFields);
            case 2:
                if (reactionUnitComponentFields.af() == null || TextUtils.isEmpty(reactionUnitComponentFields.af().b()) || reactionUnitComponentFields.X() <= 0.0d) {
                    return false;
                }
                return true;
            case 3:
                if (!m23010b(reactionUnitComponentFields) || reactionUnitComponentFields.af() == null || TextUtils.isEmpty(reactionUnitComponentFields.af().b()) || reactionUnitComponentFields.ab() == null) {
                    return false;
                }
                return true;
            case 4:
                return m23010b(reactionUnitComponentFields);
            default:
                return false;
        }
    }

    private static boolean m23010b(ReactionUnitComponentFields reactionUnitComponentFields) {
        return (reactionUnitComponentFields.b() == null || TextUtils.isEmpty(reactionUnitComponentFields.b().a()) || reactionUnitComponentFields.c() == null) ? false : true;
    }

    private Component m23006a(ComponentContext componentContext, ReactionUnitComponentFields reactionUnitComponentFields) {
        switch (C20831.f18976a[reactionUnitComponentFields.a().ordinal()]) {
            case 1:
                State state = new State(this.f18981c);
                Builder builder = (Builder) ReactionCoreButtonComponent.f19017b.a();
                if (builder == null) {
                    builder = new Builder();
                }
                Builder.m23059a(builder, componentContext, 0, state);
                Builder builder2 = builder;
                builder2.f19009a.f19014b = reactionUnitComponentFields.aa();
                builder2 = builder2;
                builder2.f19009a.f19015c = reactionUnitComponentFields.ae();
                builder2 = builder2;
                builder2.f19009a.f19013a = reactionUnitComponentFields;
                builder2.f19012d.set(0);
                return builder2.d();
            case 2:
                ReactionCoreImageComponent.State state2 = new ReactionCoreImageComponent.State(this.f18982d);
                ReactionCoreImageComponent.Builder builder3 = (ReactionCoreImageComponent.Builder) ReactionCoreImageComponent.f19052b.a();
                if (builder3 == null) {
                    builder3 = new ReactionCoreImageComponent.Builder();
                }
                ReactionCoreImageComponent.Builder.m23087a(builder3, componentContext, 0, state2);
                ReactionCoreImageComponent.Builder builder4 = builder3;
                builder4.f19045a.f19050b = (float) reactionUnitComponentFields.X();
                builder4.f19048d.set(1);
                builder4 = builder4;
                builder4.f19045a.f19049a = reactionUnitComponentFields.af();
                builder4.f19048d.set(0);
                return builder4.d();
            case 3:
                ReactionCoreImageTextComponent.State state3 = new ReactionCoreImageTextComponent.State(this.f18983e);
                ReactionCoreImageTextComponent.Builder builder5 = (ReactionCoreImageTextComponent.Builder) ReactionCoreImageTextComponent.f19069b.a();
                if (builder5 == null) {
                    builder5 = new ReactionCoreImageTextComponent.Builder();
                }
                ReactionCoreImageTextComponent.Builder.m23096a(builder5, componentContext, 0, state3);
                ReactionCoreImageTextComponent.Builder builder6 = builder5;
                builder6.f19061a.f19067c = reactionUnitComponentFields.ab();
                builder6 = builder6;
                builder6.f19061a.f19065a = reactionUnitComponentFields.af();
                builder6.f19064d.set(0);
                builder6 = builder6;
                builder6.f19061a.f19066b = reactionUnitComponentFields;
                builder6.f19064d.set(1);
                return builder6.d();
            case 4:
                return this.f18984f.m23111a(componentContext).m23106a(reactionUnitComponentFields).d();
            default:
                return Text.a(componentContext).a(new String()).d();
        }
    }
}
