package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.TextUtils;
import android.widget.TextView;
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
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.socialgood.ipc.SocialGoodUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: albumArtist */
public class ReactionFundraiserAmountRaisedUnitComponentPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Spannable, HasContext, TextView> {
    public static final Class f19724a = ReactionFundraiserAmountRaisedUnitComponentPartDefinition.class;
    public static final ViewType f19725b = ViewType.a(2130906672);
    private static ReactionFundraiserAmountRaisedUnitComponentPartDefinition f19726e;
    private static final Object f19727f = new Object();
    private final AbstractFbErrorReporter f19728c;
    private final SocialGoodUtil f19729d;

    private static ReactionFundraiserAmountRaisedUnitComponentPartDefinition m23646b(InjectorLike injectorLike) {
        return new ReactionFundraiserAmountRaisedUnitComponentPartDefinition((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), SocialGoodUtil.a(injectorLike));
    }

    public final Object m23648a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        String a;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        Context context = ((HasContext) anyEnvironment).getContext();
        String a2 = reactionUnitComponentNode.f18862b.bg().a();
        if (reactionUnitComponentNode.f18862b.bi() == null || TextUtils.isEmpty(reactionUnitComponentNode.f18862b.bi().a())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            a = reactionUnitComponentNode.f18862b.bi().a();
        } else {
            a = "";
        }
        if (TextUtils.isEmpty(reactionUnitComponentNode.f18862b.bh())) {
            return this.f19729d.a(a, a2, z, ContextCompat.b(context, 2131361916));
        }
        return this.f19729d.a(a, a2, z, reactionUnitComponentNode.f18862b.bh());
    }

    public final boolean m23650a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return (reactionUnitComponentNode.f18862b.bg() == null || TextUtils.isEmpty(reactionUnitComponentNode.f18862b.bg().a())) ? false : true;
    }

    @Inject
    public ReactionFundraiserAmountRaisedUnitComponentPartDefinition(AbstractFbErrorReporter abstractFbErrorReporter, SocialGoodUtil socialGoodUtil) {
        this.f19728c = abstractFbErrorReporter;
        this.f19729d = socialGoodUtil;
    }

    public final ViewType m23647a() {
        return f19725b;
    }

    public static ReactionFundraiserAmountRaisedUnitComponentPartDefinition m23644a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFundraiserAmountRaisedUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19727f) {
                ReactionFundraiserAmountRaisedUnitComponentPartDefinition reactionFundraiserAmountRaisedUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionFundraiserAmountRaisedUnitComponentPartDefinition = (ReactionFundraiserAmountRaisedUnitComponentPartDefinition) a2.a(f19727f);
                } else {
                    reactionFundraiserAmountRaisedUnitComponentPartDefinition = f19726e;
                }
                if (reactionFundraiserAmountRaisedUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23646b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19727f, b3);
                        } else {
                            f19726e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFundraiserAmountRaisedUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m23645a(ReactionUnitComponentNode reactionUnitComponentNode, Spannable spannable, HasContext hasContext, TextView textView) {
        Context context = hasContext.getContext();
        if (TextUtils.isEmpty(reactionUnitComponentNode.m22885f().bj())) {
            textView.setTextColor(ContextCompat.b(context, 2131361916));
        } else {
            try {
                textView.setTextColor(Color.parseColor("#" + reactionUnitComponentNode.m22885f().bj()));
            } catch (IllegalArgumentException e) {
                this.f19728c.b(f19724a.getSimpleName(), "Malformed color sent from server: " + reactionUnitComponentNode.m22885f().bj());
            }
        }
        textView.setText(spannable);
    }
}
