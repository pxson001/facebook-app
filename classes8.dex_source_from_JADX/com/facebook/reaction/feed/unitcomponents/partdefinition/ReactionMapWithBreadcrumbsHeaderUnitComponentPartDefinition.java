package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.subparts.ReactionExtendedWidthPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionMapPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionMapPartDefinition.Props;
import com.facebook.reaction.feed.unitcomponents.subpart.TextMovementMethodPartDefinition;
import com.facebook.reaction.feed.unitcomponents.util.ReactionActionClickableSpan;
import com.facebook.reaction.feed.unitcomponents.util.ReactionSpannableStringUtil;
import com.facebook.reaction.feed.unitcomponents.util.ReactionSpannableStringUtil.TokenReplacerProps;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.BreadcrumbsModel;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: add_photo_button */
public class ReactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, CustomFrameLayout> {
    public static final ViewType f19876a = ViewType.a(2130906681);
    private static ReactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition f19877h;
    private static final Object f19878i = new Object();
    private final ReactionActionHandler f19879b;
    private final ReactionExtendedWidthPartDefinition f19880c;
    private final ReactionMapPartDefinition f19881d;
    private final BasicReactionActionPartDefinition f19882e;
    private final TextMovementMethodPartDefinition f19883f;
    private final TextPartDefinition f19884g;

    private static ReactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition m23785b(InjectorLike injectorLike) {
        return new ReactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition(ReactionActionHandler.m22673a(injectorLike), ReactionExtendedWidthPartDefinition.m23412a(injectorLike), ReactionMapPartDefinition.m23415a(injectorLike), BasicReactionActionPartDefinition.m22984a(injectorLike), TextMovementMethodPartDefinition.m24363a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23787a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(reactionUnitComponentFields.bP().a());
        ImmutableList O = reactionUnitComponentFields.O();
        if (O.isEmpty()) {
            obj2 = null;
        } else {
            int size = O.size();
            for (int i = 0; i < size; i++) {
                BreadcrumbsModel breadcrumbsModel = (BreadcrumbsModel) O.get(i);
                if (breadcrumbsModel.b() == null || TextUtils.isEmpty(breadcrumbsModel.b().a())) {
                    obj2 = null;
                    break;
                }
            }
            obj2 = 1;
        }
        if (obj2 != null) {
            m23784a(canLaunchReactionIntent, spannableStringBuilder, reactionUnitComponentNode);
        }
        subParts.a(2131566736, this.f19884g, reactionUnitComponentFields.cU().a());
        subParts.a(2131566737, this.f19884g, spannableStringBuilder);
        subParts.a(2131566737, this.f19883f, LinkMovementMethod.getInstance());
        subParts.a(2131566735, this.f19881d, new Props(reactionUnitComponentFields.bn(), reactionUnitComponentFields.bt()));
        subParts.a(2131566735, this.f19880c, Float.valueOf(1.62f));
        if (reactionUnitComponentFields.v() != null) {
            subParts.a(2131566738, this.f19882e, new BasicReactionActionPartDefinition.Props(reactionUnitComponentFields.v(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        return null;
    }

    public final boolean m23788a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.cU() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.cU().a()) || reactionUnitComponentFields.bP() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bP().a()) || reactionUnitComponentFields.bn() == null) ? false : true;
    }

    public static ReactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition m23783a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19878i) {
                ReactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition reactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition = (ReactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition) a2.a(f19878i);
                } else {
                    reactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition = f19877h;
                }
                if (reactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23785b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19878i, b3);
                        } else {
                            f19877h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionMapWithBreadcrumbsHeaderUnitComponentPartDefinition(ReactionActionHandler reactionActionHandler, ReactionExtendedWidthPartDefinition reactionExtendedWidthPartDefinition, ReactionMapPartDefinition reactionMapPartDefinition, BasicReactionActionPartDefinition basicReactionActionPartDefinition, TextMovementMethodPartDefinition textMovementMethodPartDefinition, TextPartDefinition textPartDefinition) {
        this.f19879b = reactionActionHandler;
        this.f19880c = reactionExtendedWidthPartDefinition;
        this.f19881d = reactionMapPartDefinition;
        this.f19882e = basicReactionActionPartDefinition;
        this.f19883f = textMovementMethodPartDefinition;
        this.f19884g = textPartDefinition;
    }

    public final ViewType<CustomFrameLayout> m23786a() {
        return f19876a;
    }

    private void m23784a(E e, SpannableStringBuilder spannableStringBuilder, ReactionUnitComponentNode reactionUnitComponentNode) {
        Resources resources = ((HasContext) e).getContext().getResources();
        spannableStringBuilder.append(resources.getString(2131237290));
        String k = reactionUnitComponentNode.m22887k();
        String l = reactionUnitComponentNode.m22888l();
        ReactionUnitComponentFields f = reactionUnitComponentNode.m22885f();
        if (f.O().size() > 1) {
            BreadcrumbsModel breadcrumbsModel = (BreadcrumbsModel) f.O().get(0);
            BreadcrumbsModel breadcrumbsModel2 = (BreadcrumbsModel) f.O().get(1);
            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
            spannableStringBuilder2.append(ReactionSpannableStringUtil.m24368a(resources.getString(2131237291, new Object[]{"{neighborhood}", "{city}"}), resources, new TokenReplacerProps("{neighborhood}", breadcrumbsModel.b().a(), new ReactionActionClickableSpan(breadcrumbsModel.a(), this.f19879b, e, k, l)), new TokenReplacerProps("{city}", breadcrumbsModel2.b().a(), new ReactionActionClickableSpan(breadcrumbsModel2.a(), this.f19879b, e, k, l))));
            return;
        }
        breadcrumbsModel = (BreadcrumbsModel) f.O().get(0);
        ReactionSpannableStringUtil.m24376a(spannableStringBuilder, breadcrumbsModel.b().a(), new ReactionActionClickableSpan(breadcrumbsModel.a(), this.f19879b, e, k, l));
    }
}
