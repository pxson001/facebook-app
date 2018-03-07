package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.pages.common.reaction.ui.PageAppointmentStatusComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.common.ReactionDividerUnitComponentPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setIsMinutiaeAttached */
public class PageAppointmentStatusUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession & HasReactionAnalyticsParams> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, PageAppointmentStatusComponentView> {
    public static final ViewType f1878a = new C02461();
    private static PageAppointmentStatusUnitComponentPartDefinition f1879d;
    private static final Object f1880e = new Object();
    private final BasicReactionActionPartDefinition f1881b;
    private final ReactionDividerUnitComponentPartDefinition f1882c;

    /* compiled from: setIsMinutiaeAttached */
    final class C02461 extends ViewType {
        C02461() {
        }

        public final View m2926a(Context context) {
            return new PageAppointmentStatusComponentView(context);
        }
    }

    private static PageAppointmentStatusUnitComponentPartDefinition m2929b(InjectorLike injectorLike) {
        return new PageAppointmentStatusUnitComponentPartDefinition(BasicReactionActionPartDefinition.a(injectorLike), ReactionDividerUnitComponentPartDefinition.a(injectorLike));
    }

    private static void m2928a(ReactionUnitComponentNode reactionUnitComponentNode, PageAppointmentStatusComponentView pageAppointmentStatusComponentView) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        String bz = reactionUnitComponentFields.bz();
        String al = reactionUnitComponentFields.al();
        Object obj = al + "\n" + bz;
        CharSequence spannableStringBuilder = new SpannableStringBuilder(obj);
        spannableStringBuilder.setSpan(pageAppointmentStatusComponentView.f2146c, 0, al.length(), 17);
        spannableStringBuilder.setSpan(pageAppointmentStatusComponentView.f2147d, al.length() + 1, obj.length(), 17);
        pageAppointmentStatusComponentView.f2145b.setText(spannableStringBuilder);
        CharSequence a = reactionUnitComponentFields.bv().a();
        CharSequence a2 = reactionUnitComponentFields.cG().a();
        pageAppointmentStatusComponentView.f2144a.setTitleText(a);
        pageAppointmentStatusComponentView.f2144a.setSubtitleText(a2);
    }

    public final Object m2931a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        subParts.a(this.f1881b, new Props(reactionUnitComponentNode.b.v(), reactionUnitComponentNode.c, reactionUnitComponentNode.d));
        subParts.a(this.f1882c, reactionUnitComponentNode);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m2932a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -762441845);
        m2928a((ReactionUnitComponentNode) obj, (PageAppointmentStatusComponentView) view);
        Logger.a(8, EntryType.MARK_POP, 918842150, a);
    }

    public final boolean m2933a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (Strings.isNullOrEmpty(reactionUnitComponentFields.bz()) || Strings.isNullOrEmpty(reactionUnitComponentFields.al()) || reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.cG() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.cG().a()) || reactionUnitComponentFields.v() == null) ? false : true;
    }

    @Inject
    public PageAppointmentStatusUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition) {
        this.f1881b = basicReactionActionPartDefinition;
        this.f1882c = reactionDividerUnitComponentPartDefinition;
    }

    public static PageAppointmentStatusUnitComponentPartDefinition m2927a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageAppointmentStatusUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1880e) {
                PageAppointmentStatusUnitComponentPartDefinition pageAppointmentStatusUnitComponentPartDefinition;
                if (a2 != null) {
                    pageAppointmentStatusUnitComponentPartDefinition = (PageAppointmentStatusUnitComponentPartDefinition) a2.a(f1880e);
                } else {
                    pageAppointmentStatusUnitComponentPartDefinition = f1879d;
                }
                if (pageAppointmentStatusUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2929b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1880e, b3);
                        } else {
                            f1879d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageAppointmentStatusUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m2930a() {
        return f1878a;
    }
}
