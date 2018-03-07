package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
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
import com.facebook.pages.common.reaction.components.utils.PagesSurfaceReactionHelper;
import com.facebook.pages.common.reaction.ui.PageAddressNavigationComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setListView called with null listview */
public class PageAddressNavigationUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageAddressNavigationComponentView> {
    public static final ViewType f1857a = new C02451();
    private static PageAddressNavigationUnitComponentPartDefinition f1858c;
    private static final Object f1859d = new Object();
    private final PagesSurfaceReactionHelper<E> f1860b;

    /* compiled from: setListView called with null listview */
    final class C02451 extends ViewType {
        C02451() {
        }

        public final View m2903a(Context context) {
            return new PageAddressNavigationComponentView(context);
        }
    }

    /* compiled from: setListView called with null listview */
    public class State {
        public final String f1854a;
        public final String f1855b;
        public final OnClickListener f1856c;

        public State(String str, String str2, OnClickListener onClickListener) {
            this.f1854a = str;
            this.f1855b = str2;
            this.f1856c = onClickListener;
        }
    }

    private static PageAddressNavigationUnitComponentPartDefinition m2905b(InjectorLike injectorLike) {
        return new PageAddressNavigationUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m2907a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        String a = (reactionUnitComponentFields.cL() == null || StringUtil.a(reactionUnitComponentFields.cL().a())) ? null : reactionUnitComponentFields.cL().a();
        return new State(reactionUnitComponentFields.cU().a(), a, this.f1860b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m2908a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1556697350);
        State state = (State) obj2;
        PageAddressNavigationComponentView pageAddressNavigationComponentView = (PageAddressNavigationComponentView) view;
        CharSequence charSequence = state.f1854a;
        CharSequence charSequence2 = state.f1855b;
        int i = 0;
        int i2 = !StringUtil.a(charSequence2) ? 1 : 0;
        pageAddressNavigationComponentView.f2142c.setText(charSequence);
        if (i2 != 0) {
            pageAddressNavigationComponentView.f2143d.setText(charSequence2);
        }
        BetterTextView betterTextView = pageAddressNavigationComponentView.f2143d;
        if (i2 == 0) {
            i = 8;
        }
        betterTextView.setVisibility(i);
        pageAddressNavigationComponentView.setOnClickListener(state.f1856c);
        Logger.a(8, EntryType.MARK_POP, -1508722479, a);
    }

    public final boolean m2909a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.cU() == null || StringUtil.a(reactionUnitComponentFields.cU().a())) ? false : true;
    }

    public final void m2910b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageAddressNavigationComponentView) view).setOnClickListener(null);
    }

    public final ViewType m2906a() {
        return f1857a;
    }

    public static PageAddressNavigationUnitComponentPartDefinition m2904a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageAddressNavigationUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1859d) {
                PageAddressNavigationUnitComponentPartDefinition pageAddressNavigationUnitComponentPartDefinition;
                if (a2 != null) {
                    pageAddressNavigationUnitComponentPartDefinition = (PageAddressNavigationUnitComponentPartDefinition) a2.a(f1859d);
                } else {
                    pageAddressNavigationUnitComponentPartDefinition = f1858c;
                }
                if (pageAddressNavigationUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2905b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1859d, b3);
                        } else {
                            f1858c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageAddressNavigationUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageAddressNavigationUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1860b = pagesSurfaceReactionHelper;
    }
}
