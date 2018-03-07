package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
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
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesColorPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: analytics_bundle */
public class ReactionBannerHighlightableUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Drawable, E, LinearLayout> {
    public static final String f19554a = ReactionBannerHighlightableUnitComponentPartDefinition.class.getSimpleName();
    public static final ViewType f19555b = ViewType.a(2130906616);
    public static final int f19556c = 2131361916;
    private static ReactionBannerHighlightableUnitComponentPartDefinition f19557g;
    private static final Object f19558h = new Object();
    private final AbstractFbErrorReporter f19559d;
    private final ReactionTextWithEntitiesColorPartDefinition f19560e;
    private final ReactionTextWithEntitiesPartDefinition f19561f;

    private static ReactionBannerHighlightableUnitComponentPartDefinition m23493b(InjectorLike injectorLike) {
        return new ReactionBannerHighlightableUnitComponentPartDefinition((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ReactionTextWithEntitiesColorPartDefinition.m23420a(injectorLike), ReactionTextWithEntitiesPartDefinition.m23423a(injectorLike));
    }

    public final Object m23495a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int b;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        String k = reactionUnitComponentNode.m22887k();
        String l = reactionUnitComponentNode.m22888l();
        ReactionUnitComponentFields f = reactionUnitComponentNode.m22885f();
        Context context = ((HasContext) canLaunchReactionIntent).getContext();
        if (TextUtils.isEmpty(f.aL())) {
            b = ContextCompat.b(context, f19556c);
        } else {
            try {
                b = Color.parseColor("#" + f.aL());
            } catch (IllegalArgumentException e) {
                int b2 = ContextCompat.b(context, f19556c);
                this.f19559d.b(f19554a, "Malformed color sent from server: " + f.aL());
                b = b2;
            }
        }
        subParts.a(2131566634, this.f19561f, new Props(f.bv(), k, l));
        subParts.a(2131566634, this.f19560e, Integer.valueOf(b));
        LinkableTextWithEntities linkableTextWithEntities = null;
        if (!(f.cG() == null || TextUtils.isEmpty(f.cG().a()))) {
            linkableTextWithEntities = f.cG();
            subParts.a(2131566635, this.f19560e, Integer.valueOf(b));
        }
        subParts.a(2131566635, this.f19561f, new Props(linkableTextWithEntities, k, l));
        LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.a(context, 2130842886);
        ((GradientDrawable) layerDrawable.findDrawableByLayerId(2131568595)).setStroke(context.getResources().getDimensionPixelSize(2131431362), b);
        return layerDrawable;
    }

    public final /* bridge */ /* synthetic */ void m23496a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -164334412);
        Drawable drawable = (Drawable) obj2;
        LinearLayout linearLayout = (LinearLayout) view;
        if (VERSION.SDK_INT < 16) {
            linearLayout.setBackgroundDrawable(drawable);
        } else {
            linearLayout.setBackground(drawable);
        }
        Logger.a(8, EntryType.MARK_POP, 1913871152, a);
    }

    public final boolean m23497a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return (reactionUnitComponentNode.f18862b.bv() == null || TextUtils.isEmpty(reactionUnitComponentNode.f18862b.bv().a())) ? false : true;
    }

    public static ReactionBannerHighlightableUnitComponentPartDefinition m23492a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionBannerHighlightableUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19558h) {
                ReactionBannerHighlightableUnitComponentPartDefinition reactionBannerHighlightableUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionBannerHighlightableUnitComponentPartDefinition = (ReactionBannerHighlightableUnitComponentPartDefinition) a2.a(f19558h);
                } else {
                    reactionBannerHighlightableUnitComponentPartDefinition = f19557g;
                }
                if (reactionBannerHighlightableUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23493b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19558h, b3);
                        } else {
                            f19557g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionBannerHighlightableUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionBannerHighlightableUnitComponentPartDefinition(AbstractFbErrorReporter abstractFbErrorReporter, ReactionTextWithEntitiesColorPartDefinition reactionTextWithEntitiesColorPartDefinition, ReactionTextWithEntitiesPartDefinition reactionTextWithEntitiesPartDefinition) {
        this.f19559d = abstractFbErrorReporter;
        this.f19560e = reactionTextWithEntitiesColorPartDefinition;
        this.f19561f = reactionTextWithEntitiesPartDefinition;
    }

    public final ViewType m23494a() {
        return f19555b;
    }
}
