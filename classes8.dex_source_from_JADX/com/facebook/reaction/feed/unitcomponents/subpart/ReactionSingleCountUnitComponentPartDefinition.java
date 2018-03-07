package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCountsComponentFragmentModel.CountsModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ZZZ) */
public class ReactionSingleCountUnitComponentPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, LinearLayout> {
    private static ReactionSingleCountUnitComponentPartDefinition f20687d;
    private static final Object f20688e = new Object();
    private final TextPartDefinition f20689a;
    private final BasicReactionActionPartDefinition f20690b;
    private final NumberTruncationUtil f20691c;

    /* compiled from: ZZZ) */
    public class Props {
        public final CountsModel f20684a;
        public final String f20685b;
        public final String f20686c;

        public Props(CountsModel countsModel, String str, String str2) {
            this.f20684a = countsModel;
            this.f20685b = str;
            this.f20686c = str2;
        }
    }

    private static ReactionSingleCountUnitComponentPartDefinition m24357b(InjectorLike injectorLike) {
        return new ReactionSingleCountUnitComponentPartDefinition(TextPartDefinition.a(injectorLike), NumberTruncationUtil.a(injectorLike), BasicReactionActionPartDefinition.m22984a(injectorLike));
    }

    public final Object m24358a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(2131566782, this.f20689a, props.f20684a.c().a());
        subParts.a(2131566783, this.f20689a, this.f20691c.a(props.f20684a.b()));
        if (props.f20684a.a() != null) {
            subParts.a(this.f20690b, new com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props(props.f20684a.a(), props.f20685b, props.f20686c));
        }
        return null;
    }

    @Inject
    public ReactionSingleCountUnitComponentPartDefinition(TextPartDefinition textPartDefinition, NumberTruncationUtil numberTruncationUtil, BasicReactionActionPartDefinition basicReactionActionPartDefinition) {
        this.f20689a = textPartDefinition;
        this.f20691c = numberTruncationUtil;
        this.f20690b = basicReactionActionPartDefinition;
    }

    public static ReactionSingleCountUnitComponentPartDefinition m24356a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSingleCountUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20688e) {
                ReactionSingleCountUnitComponentPartDefinition reactionSingleCountUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionSingleCountUnitComponentPartDefinition = (ReactionSingleCountUnitComponentPartDefinition) a2.a(f20688e);
                } else {
                    reactionSingleCountUnitComponentPartDefinition = f20687d;
                }
                if (reactionSingleCountUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24357b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20688e, b3);
                        } else {
                            f20687d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSingleCountUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
