package com.facebook.feedplugins.researchpoll;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.researchpoll.views.ResearchPollResultItemView;
import com.facebook.feedplugins.researchpoll.views.ResearchPollResultView;
import com.facebook.graphql.model.GraphQLResearchPollMultipleChoiceResponse;
import com.facebook.graphql.model.GraphQLResearchPollQuestionRespondersConnection;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;

@ContextScoped
/* compiled from: notification_sync */
public class ResultItemPartDefinition extends BaseSinglePartDefinitionWithViewType<Props, State, AnyEnvironment, ResearchPollResultView> {
    public static final ViewType<ResearchPollResultView> f6779a = new C03171();
    private static ResultItemPartDefinition f6780b;
    private static final Object f6781c = new Object();

    /* compiled from: notification_sync */
    final class C03171 extends ViewType<ResearchPollResultView> {
        C03171() {
        }

        public final View m7151a(Context context) {
            return new ResearchPollResultView(context);
        }
    }

    private static ResultItemPartDefinition m7147b() {
        return new ResultItemPartDefinition();
    }

    public final Object m7149a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        ImmutableList a = ResearchPollUnitHelper.a(props.a);
        int[] iArr = new int[a.size()];
        String[] strArr = new String[a.size()];
        String o = props.a.o();
        GraphQLResearchPollQuestionRespondersConnection m = props.a.m();
        int a2 = m.a() == 0 ? 1 : m.a();
        for (int i = 0; i < a.size(); i++) {
            iArr[i] = Math.round((float) ((((GraphQLResearchPollMultipleChoiceResponse) a.get(i)).m().a() * 100) / a2));
            strArr[i] = ((GraphQLResearchPollMultipleChoiceResponse) a.get(i)).j();
        }
        return new State(strArr, o, iArr, a);
    }

    public final /* bridge */ /* synthetic */ void m7150a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int i;
        int a = Logger.a(8, EntryType.MARK_PUSH, 749192328);
        Props props = (Props) obj;
        State state = (State) obj2;
        ResearchPollResultView researchPollResultView = (ResearchPollResultView) view;
        researchPollResultView.a.setText(state.b);
        for (i = 0; i < state.d.size(); i++) {
            String str = state.a[i];
            int i2 = state.c[i];
            ResearchPollResultItemView researchPollResultItemView = researchPollResultView.b[i];
            researchPollResultItemView.setText(str);
            researchPollResultItemView.setProgress(i2);
            researchPollResultItemView.setVisibility(0);
        }
        for (i = props.b; i < 5; i++) {
            researchPollResultView.b[i].setVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, -884335126, a);
    }

    public static ResultItemPartDefinition m7146a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResultItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6781c) {
                ResultItemPartDefinition resultItemPartDefinition;
                if (a2 != null) {
                    resultItemPartDefinition = (ResultItemPartDefinition) a2.a(f6781c);
                } else {
                    resultItemPartDefinition = f6780b;
                }
                if (resultItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m7147b();
                        if (a2 != null) {
                            a2.a(f6781c, b3);
                        } else {
                            f6780b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = resultItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ResearchPollResultView> m7148a() {
        return f6779a;
    }
}
