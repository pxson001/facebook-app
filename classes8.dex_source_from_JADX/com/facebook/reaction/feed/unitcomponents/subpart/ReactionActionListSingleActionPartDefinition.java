package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasContext;
import com.facebook.infer.annotation.PerformanceCritical;
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
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.action.ReactionActionIconMapper;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleActionSelectorPartDefinition.Props;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [^\d+] */
public class ReactionActionListSingleActionPartDefinition<E extends HasReactionSession & CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams> extends BaseSinglePartDefinition<Props, Void, E, LinearLayout> implements MultiRowPartWithIsNeeded<Props, E> {
    private static ReactionActionListSingleActionPartDefinition f20543g;
    private static final Object f20544h = new Object();
    private final ReactionActionIconMapper f20545a;
    private final BasicReactionActionPartDefinition f20546b;
    private final ReactionDrawableIconPartDefinition f20547c;
    private final TextPartDefinition f20548d;
    private final ReactionUriIconPartDefinition f20549e;
    private final Product f20550f;

    private static ReactionActionListSingleActionPartDefinition m24293b(InjectorLike injectorLike) {
        return new ReactionActionListSingleActionPartDefinition(ReactionActionIconMapper.m22679a(injectorLike), BasicReactionActionPartDefinition.m22984a(injectorLike), ReactionDrawableIconPartDefinition.m24306a(injectorLike), TextPartDefinition.a(injectorLike), ReactionUriIconPartDefinition.m24360a(injectorLike), ProductMethodAutoProvider.b(injectorLike));
    }

    public final Object m24294a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f20546b, new BasicReactionActionPartDefinition.Props(props.f20670a, props.f20671b.f18863c, props.f20671b.f18864d));
        Drawable a = this.f20545a.m22681a(props.f20670a.j());
        Object b = props.f20670a.d() != null ? props.f20670a.d().b() : null;
        if (b != null) {
            subParts.a(2131566665, this.f20549e, b);
        } else {
            subParts.a(2131566665, this.f20547c, new ReactionDrawableIconPartDefinition.Props(a));
        }
        subParts.a(2131566666, this.f20548d, props.f20670a.fU_().a());
        return null;
    }

    @PerformanceCritical
    public final /* bridge */ /* synthetic */ void m24295a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 77540609);
        m24292a((HasReactionSession) anyEnvironment, (LinearLayout) view);
        Logger.a(8, EntryType.MARK_POP, -40265579, a);
    }

    public final boolean m24296a(Object obj) {
        Props props = (Props) obj;
        return (props.f20670a.fU_() == null || Strings.isNullOrEmpty(props.f20670a.fU_().a()) || props.f20670a.j() == null) ? false : true;
    }

    public static ReactionActionListSingleActionPartDefinition m24291a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionActionListSingleActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20544h) {
                ReactionActionListSingleActionPartDefinition reactionActionListSingleActionPartDefinition;
                if (a2 != null) {
                    reactionActionListSingleActionPartDefinition = (ReactionActionListSingleActionPartDefinition) a2.a(f20544h);
                } else {
                    reactionActionListSingleActionPartDefinition = f20543g;
                }
                if (reactionActionListSingleActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24293b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20544h, b3);
                        } else {
                            f20543g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionActionListSingleActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionActionListSingleActionPartDefinition(ReactionActionIconMapper reactionActionIconMapper, BasicReactionActionPartDefinition basicReactionActionPartDefinition, ReactionDrawableIconPartDefinition reactionDrawableIconPartDefinition, TextPartDefinition textPartDefinition, ReactionUriIconPartDefinition reactionUriIconPartDefinition, Product product) {
        this.f20545a = reactionActionIconMapper;
        this.f20546b = basicReactionActionPartDefinition;
        this.f20547c = reactionDrawableIconPartDefinition;
        this.f20548d = textPartDefinition;
        this.f20549e = reactionUriIconPartDefinition;
        this.f20550f = product;
    }

    @PerformanceCritical
    private void m24292a(E e, LinearLayout linearLayout) {
        if (this.f20550f == Product.PAA) {
            FbDraweeView fbDraweeView = (FbDraweeView) linearLayout.findViewById(2131566665);
            if (fbDraweeView != null) {
                fbDraweeView.setColorFilter(-11643291, Mode.SRC_ATOP);
            }
            FbTextView fbTextView = (FbTextView) linearLayout.findViewById(2131566666);
            if (fbTextView != null) {
                fbTextView.setTextColor(((HasContext) e).getContext().getResources().getColor(2131361973));
            }
        }
    }
}
