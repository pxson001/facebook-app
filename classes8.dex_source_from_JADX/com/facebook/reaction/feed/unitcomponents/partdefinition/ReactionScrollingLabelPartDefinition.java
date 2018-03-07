package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.reaction.feed.persistentstate.ReactionTabSwitcherKey;
import com.facebook.reaction.feed.persistentstate.ReactionTabSwitcherPersistentState;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionTabSwitcherComponentFragmentModel.TabsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

@ContextScoped
/* compiled from: action_bar */
public class ReactionScrollingLabelPartDefinition<E extends HasContext & HasPersistentState & HasInvalidate> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, HorizontalScrollView> {
    public static final ViewType f20053a = ViewType.a(2130906709);
    private static ReactionScrollingLabelPartDefinition f20054b;
    private static final Object f20055c = new Object();

    /* compiled from: action_bar */
    public class State {
        public final List<TextView> f20052a;

        public State(List<TextView> list) {
            this.f20052a = list;
        }
    }

    private static ReactionScrollingLabelPartDefinition m23933b() {
        return new ReactionScrollingLabelPartDefinition();
    }

    public final Object m23935a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        ImmutableList dn = ((ReactionUnitComponentModel) reactionUnitComponentNode.f18862b).dn();
        final ReactionTabSwitcherPersistentState reactionTabSwitcherPersistentState = (ReactionTabSwitcherPersistentState) ((HasPersistentState) hasContext).a(new ReactionTabSwitcherKey(reactionUnitComponentNode.f18863c), reactionUnitComponentNode);
        OnClickListener c21441 = new OnClickListener(this) {
            final /* synthetic */ ReactionScrollingLabelPartDefinition f20051c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1760360376);
                reactionTabSwitcherPersistentState.f19183a = ((Integer) view.getTag()).intValue();
                ((HasInvalidate) hasContext).hL_();
                Logger.a(2, EntryType.UI_INPUT_END, -841057286, a);
            }
        };
        List arrayList = new ArrayList();
        for (int i = 0; i < dn.size(); i++) {
            TextView a = m23931a(hasContext.getContext(), ((TabsModel) dn.get(i)).b().a(), c21441, i);
            arrayList.add(a);
            if (i < dn.size() - 1) {
                arrayList.add(m23930a(hasContext.getContext()));
            }
            int i2 = reactionTabSwitcherPersistentState.f19183a;
            if (i2 == i) {
                a.setTypeface(null, 1);
            } else if (i2 < 0 || i2 >= dn.size()) {
                ((TextView) arrayList.get(0)).setTypeface(null, 1);
            }
        }
        return new State(arrayList);
    }

    public final boolean m23937a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        if (!(reactionUnitComponentFields instanceof ReactionUnitComponentModel)) {
            return false;
        }
        ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) reactionUnitComponentFields;
        if (CollectionUtil.a(reactionUnitComponentModel.dn())) {
            return false;
        }
        ImmutableList dn = reactionUnitComponentModel.dn();
        int size = dn.size();
        for (int i = 0; i < size; i++) {
            TabsModel tabsModel = (TabsModel) dn.get(i);
            if (tabsModel.b() == null || Strings.isNullOrEmpty(tabsModel.b().a()) || tabsModel.a() == null) {
                return false;
            }
        }
        return true;
    }

    public final void m23938b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ViewGroup) ((HorizontalScrollView) view).findViewById(2131566776)).removeAllViews();
    }

    public final ViewType<HorizontalScrollView> m23934a() {
        return f20053a;
    }

    public static ReactionScrollingLabelPartDefinition m23932a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionScrollingLabelPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20055c) {
                ReactionScrollingLabelPartDefinition reactionScrollingLabelPartDefinition;
                if (a2 != null) {
                    reactionScrollingLabelPartDefinition = (ReactionScrollingLabelPartDefinition) a2.a(f20055c);
                } else {
                    reactionScrollingLabelPartDefinition = f20054b;
                }
                if (reactionScrollingLabelPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m23933b();
                        if (a2 != null) {
                            a2.a(f20055c, b3);
                        } else {
                            f20054b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionScrollingLabelPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static TextView m23931a(Context context, String str, OnClickListener onClickListener, int i) {
        TextView textView = (TextView) LayoutInflater.from(context).inflate(2130906719, null, false);
        textView.setText(str);
        textView.setOnClickListener(onClickListener);
        textView.setTag(Integer.valueOf(i));
        return textView;
    }

    private static TextView m23930a(Context context) {
        TextView textView = new TextView(context);
        textView.setText("•");
        return textView;
    }
}
