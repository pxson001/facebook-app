package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notif_ids[] */
public class ReactionPhotoFullWidthPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<Props, Void, E, PagerItemWrapperLayout> {
    public static final ViewType f6933a = ViewType.a(2130906704);
    private static final CallerContext f6934b = CallerContext.a(ReactionPhotoFullWidthPartDefinition.class, "reaction_photos");
    private static ReactionPhotoFullWidthPartDefinition f6935f;
    private static final Object f6936g = new Object();
    private final ClickListenerPartDefinition f6937c;
    private final FbDraweePartDefinition<E> f6938d;
    private final ReactionIntentFactory f6939e;

    private static ReactionPhotoFullWidthPartDefinition m7254b(InjectorLike injectorLike) {
        return new ReactionPhotoFullWidthPartDefinition(ClickListenerPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), ReactionIntentFactory.a(injectorLike));
    }

    public final Object m7256a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        subParts.a(this.f6937c, new 1(this, canLaunchReactionIntent, props, ReactionIntentFactory.a(((HasContext) canLaunchReactionIntent).getContext(), Long.parseLong(props.a.d()), props.b, props.a.be_().b())));
        FbDraweePartDefinition fbDraweePartDefinition = this.f6938d;
        Builder a = FbDraweePartDefinition.a().a(props.a.be_().b());
        a.c = f6934b;
        a = a;
        a.b = 1.5f;
        subParts.a(2131566768, fbDraweePartDefinition, a.a());
        return null;
    }

    public final boolean m7257a(Object obj) {
        Props props = (Props) obj;
        return (props.a == null || Strings.isNullOrEmpty(props.a.d()) || props.a.be_() == null || Strings.isNullOrEmpty(props.a.be_().b())) ? false : true;
    }

    public static ReactionPhotoFullWidthPartDefinition m7253a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPhotoFullWidthPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6936g) {
                ReactionPhotoFullWidthPartDefinition reactionPhotoFullWidthPartDefinition;
                if (a2 != null) {
                    reactionPhotoFullWidthPartDefinition = (ReactionPhotoFullWidthPartDefinition) a2.a(f6936g);
                } else {
                    reactionPhotoFullWidthPartDefinition = f6935f;
                }
                if (reactionPhotoFullWidthPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7254b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6936g, b3);
                        } else {
                            f6935f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPhotoFullWidthPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionPhotoFullWidthPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, ReactionIntentFactory reactionIntentFactory) {
        this.f6937c = clickListenerPartDefinition;
        this.f6938d = fbDraweePartDefinition;
        this.f6939e = reactionIntentFactory;
    }

    public final ViewType m7255a() {
        return f6933a;
    }
}
