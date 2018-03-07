package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feedplugins.spannable.PersistentSpannableWithoutLayoutInput;
import com.facebook.feedplugins.spannable.SpannableInTextViewPartDefinition;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
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
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.rows.subparts.InactiveTextWithEntitiesPartDefinition;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.timeline.util.TimelineViewHelper;
import com.facebook.ufiservices.util.LinkifyUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: airplane_mode_on */
public class ReactionHeaderWithVerifiedBadgeComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPrefetcher> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, ImageBlockLayout> {
    public static final ViewType f19775a = ViewType.a(2130906674);
    private static final CallerContext f19776b = CallerContext.a(ReactionHeaderWithVerifiedBadgeComponentPartDefinition.class, "social_good");
    private static ReactionHeaderWithVerifiedBadgeComponentPartDefinition f19777g;
    private static final Object f19778h = new Object();
    private final SpannableInTextViewPartDefinition f19779c;
    private final InactiveTextWithEntitiesPartDefinition f19780d;
    private final FbDraweePartDefinition f19781e;
    public final LinkifyUtil f19782f;

    /* compiled from: airplane_mode_on */
    class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        final /* synthetic */ ReactionHeaderWithVerifiedBadgeComponentPartDefinition f19769a;
        private final ReactionUnitComponentNode f19770b;
        private final Context f19771c;

        public final Object m23680a() {
            CharSequence valueOf;
            ReactionUnitComponentFields reactionUnitComponentFields = this.f19770b.f18862b;
            if (reactionUnitComponentFields.bv().b() == null) {
                valueOf = SpannableString.valueOf(reactionUnitComponentFields.bv().a());
            } else {
                Object a = this.f19769a.f19782f.a(reactionUnitComponentFields.bv(), true, null);
            }
            return new PersistentSpannable(TimelineViewHelper.a(reactionUnitComponentFields.bf(), false, new SpannableStringBuilder(valueOf), 2130843879, 0, this.f19771c, this.f19771c.getResources().getDimensionPixelSize(2131431450), this.f19771c.getResources().getDimensionPixelSize(2131431451), null), false);
        }

        public PersistentSpannableKey(ReactionHeaderWithVerifiedBadgeComponentPartDefinition reactionHeaderWithVerifiedBadgeComponentPartDefinition, ReactionUnitComponentNode reactionUnitComponentNode, Context context) {
            this.f19769a = reactionHeaderWithVerifiedBadgeComponentPartDefinition;
            this.f19770b = reactionUnitComponentNode;
            this.f19771c = context;
        }

        public final Object m23681b() {
            return this.f19770b.g();
        }
    }

    /* compiled from: airplane_mode_on */
    class ReactionHeaderWithVerifiedBadgeComponentPersistentSpannableInput extends PersistentSpannableWithoutLayoutInput {
        final /* synthetic */ ReactionHeaderWithVerifiedBadgeComponentPartDefinition f19772a;
        private final ReactionUnitComponentNode f19773b;
        private final ContextStateKey<String, PersistentSpannable> f19774c;

        public ReactionHeaderWithVerifiedBadgeComponentPersistentSpannableInput(ReactionHeaderWithVerifiedBadgeComponentPartDefinition reactionHeaderWithVerifiedBadgeComponentPartDefinition, ReactionUnitComponentNode reactionUnitComponentNode, Context context) {
            this.f19772a = reactionHeaderWithVerifiedBadgeComponentPartDefinition;
            this.f19773b = reactionUnitComponentNode;
            this.f19774c = new PersistentSpannableKey(reactionHeaderWithVerifiedBadgeComponentPartDefinition, reactionUnitComponentNode, context);
        }

        public final ContextStateKey<String, PersistentSpannable> m23683a() {
            return this.f19774c;
        }

        @Nullable
        public final GraphQLTextWithEntities m23684b() {
            return DefaultGraphQLConversionHelper.a(this.f19773b.f18862b.bv());
        }

        public final CacheableEntity m23685c() {
            return this.f19773b;
        }

        public final int m23682a(Spannable spannable) {
            return 0;
        }
    }

    private static ReactionHeaderWithVerifiedBadgeComponentPartDefinition m23687b(InjectorLike injectorLike) {
        return new ReactionHeaderWithVerifiedBadgeComponentPartDefinition(SpannableInTextViewPartDefinition.a(injectorLike), InactiveTextWithEntitiesPartDefinition.m23402a(injectorLike), FbDraweePartDefinition.a(injectorLike), LinkifyUtil.a(injectorLike));
    }

    public final Object m23689a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(2131566721, this.f19779c, new ReactionHeaderWithVerifiedBadgeComponentPersistentSpannableInput(this, reactionUnitComponentNode, ((HasContext) canLaunchReactionIntent).getContext()));
        subParts.a(2131566722, this.f19780d, reactionUnitComponentFields.cG());
        FbDraweePartDefinition fbDraweePartDefinition = this.f19781e;
        Builder a = new Builder().a(reactionUnitComponentFields.aI().b());
        a.c = f19776b;
        a = a;
        a.f = true;
        subParts.a(2131566720, fbDraweePartDefinition, a.a());
        return null;
    }

    public final boolean m23690a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || TextUtils.isEmpty(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.aI() == null || TextUtils.isEmpty(reactionUnitComponentFields.aI().b())) ? false : true;
    }

    public static ReactionHeaderWithVerifiedBadgeComponentPartDefinition m23686a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionHeaderWithVerifiedBadgeComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19778h) {
                ReactionHeaderWithVerifiedBadgeComponentPartDefinition reactionHeaderWithVerifiedBadgeComponentPartDefinition;
                if (a2 != null) {
                    reactionHeaderWithVerifiedBadgeComponentPartDefinition = (ReactionHeaderWithVerifiedBadgeComponentPartDefinition) a2.a(f19778h);
                } else {
                    reactionHeaderWithVerifiedBadgeComponentPartDefinition = f19777g;
                }
                if (reactionHeaderWithVerifiedBadgeComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23687b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19778h, b3);
                        } else {
                            f19777g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionHeaderWithVerifiedBadgeComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23688a() {
        return f19775a;
    }

    @Inject
    public ReactionHeaderWithVerifiedBadgeComponentPartDefinition(SpannableInTextViewPartDefinition spannableInTextViewPartDefinition, InactiveTextWithEntitiesPartDefinition inactiveTextWithEntitiesPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, LinkifyUtil linkifyUtil) {
        this.f19779c = spannableInTextViewPartDefinition;
        this.f19780d = inactiveTextWithEntitiesPartDefinition;
        this.f19781e = fbDraweePartDefinition;
        this.f19782f = linkifyUtil;
    }
}
