package com.facebook.today.ui.components.partdefinition;

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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.common.ReactionDividerUnitComponentPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.today.ui.components.view.EventDescriptionComponentView;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: trending_items */
public class EventDescriptionUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession & HasReactionAnalyticsParams> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, EventDescriptionComponentView> {
    public static final ViewType f1273a = new C01221();
    private static EventDescriptionUnitComponentPartDefinition f1274d;
    private static final Object f1275e = new Object();
    private final BasicReactionActionPartDefinition f1276b;
    private final ReactionDividerUnitComponentPartDefinition f1277c;

    /* compiled from: trending_items */
    final class C01221 extends ViewType {
        C01221() {
        }

        public final View m1426a(Context context) {
            return new EventDescriptionComponentView(context);
        }
    }

    /* compiled from: trending_items */
    public class State {
        @Nullable
        public final String f1272a;

        public State(String str) {
            this.f1272a = str;
        }
    }

    private static EventDescriptionUnitComponentPartDefinition m1429b(InjectorLike injectorLike) {
        return new EventDescriptionUnitComponentPartDefinition(BasicReactionActionPartDefinition.a(injectorLike), ReactionDividerUnitComponentPartDefinition.a(injectorLike));
    }

    private static void m1428a(ReactionUnitComponentNode reactionUnitComponentNode, State state, EventDescriptionComponentView eventDescriptionComponentView) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        String bz = reactionUnitComponentFields.bz();
        String al = reactionUnitComponentFields.al();
        eventDescriptionComponentView.f1363b.setText(bz + "\n" + al);
        Object obj = al + "\n" + bz;
        CharSequence spannableStringBuilder = new SpannableStringBuilder(obj);
        spannableStringBuilder.setSpan(eventDescriptionComponentView.f1364c, 0, al.length(), 17);
        spannableStringBuilder.setSpan(eventDescriptionComponentView.f1365d, al.length() + 1, obj.length(), 17);
        eventDescriptionComponentView.f1363b.setText(spannableStringBuilder);
        CharSequence a = reactionUnitComponentFields.bv().a();
        CharSequence a2 = reactionUnitComponentFields.cG().a();
        CharSequence charSequence = state.f1272a;
        eventDescriptionComponentView.f1362a.setTitleText(a);
        eventDescriptionComponentView.f1362a.setSubtitleText(a2);
        if (!Strings.isNullOrEmpty(charSequence)) {
            eventDescriptionComponentView.f1362a.setMetaText(charSequence);
        }
    }

    public final Object m1431a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        subParts.a(this.f1276b, new Props(reactionUnitComponentFields.v(), reactionUnitComponentNode.c, reactionUnitComponentNode.d));
        subParts.a(this.f1277c, reactionUnitComponentNode);
        return new State(reactionUnitComponentFields.cO() == null ? null : reactionUnitComponentFields.cO().a());
    }

    public final /* bridge */ /* synthetic */ void m1432a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 554960999);
        m1428a((ReactionUnitComponentNode) obj, (State) obj2, (EventDescriptionComponentView) view);
        Logger.a(8, EntryType.MARK_POP, 678198227, a);
    }

    public final boolean m1433a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (Strings.isNullOrEmpty(reactionUnitComponentFields.bz()) || Strings.isNullOrEmpty(reactionUnitComponentFields.al()) || reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.cG() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.cG().a()) || reactionUnitComponentFields.v() == null) ? false : true;
    }

    public static EventDescriptionUnitComponentPartDefinition m1427a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventDescriptionUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1275e) {
                EventDescriptionUnitComponentPartDefinition eventDescriptionUnitComponentPartDefinition;
                if (a2 != null) {
                    eventDescriptionUnitComponentPartDefinition = (EventDescriptionUnitComponentPartDefinition) a2.a(f1275e);
                } else {
                    eventDescriptionUnitComponentPartDefinition = f1274d;
                }
                if (eventDescriptionUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1429b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1275e, b3);
                        } else {
                            f1274d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventDescriptionUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public EventDescriptionUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition) {
        this.f1276b = basicReactionActionPartDefinition;
        this.f1277c = reactionDividerUnitComponentPartDefinition;
    }

    public final ViewType m1430a() {
        return f1273a;
    }
}
