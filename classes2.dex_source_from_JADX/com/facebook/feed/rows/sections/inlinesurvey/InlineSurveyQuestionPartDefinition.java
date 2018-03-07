package com.facebook.feed.rows.sections.inlinesurvey;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
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
import com.google.common.base.Strings;

@ContextScoped
/* compiled from: in_progress_login_timestamp */
public class InlineSurveyQuestionPartDefinition extends MultiRowSinglePartDefinition<Props, State, FeedEnvironment, InlineSurveyQuestionView> {
    public static final ViewType f20259a = new C08201();
    private static InlineSurveyQuestionPartDefinition f20260b;
    private static final Object f20261c = new Object();

    /* compiled from: in_progress_login_timestamp */
    final class C08201 extends ViewType {
        C08201() {
        }

        public final View mo1995a(Context context) {
            return new InlineSurveyQuestionView(context);
        }
    }

    private static InlineSurveyQuestionPartDefinition m27930b() {
        return new InlineSurveyQuestionPartDefinition();
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        return new State(new 2(this, props, feedEnvironment), new 3(this, props, feedEnvironment));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 807456125);
        m27929a((Props) obj, (State) obj2, (InlineSurveyQuestionView) view);
        Logger.a(8, EntryType.MARK_POP, 587378255, a);
    }

    public final boolean m27934a(Object obj) {
        Props props = (Props) obj;
        return (Strings.isNullOrEmpty(props.c) || props.e.e || (!props.a && !props.e.b)) ? false : true;
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        InlineSurveyQuestionView inlineSurveyQuestionView = (InlineSurveyQuestionView) view;
        inlineSurveyQuestionView.setAnswerClickListener(null);
        inlineSurveyQuestionView.a(false, null);
    }

    public static InlineSurveyQuestionPartDefinition m27928a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineSurveyQuestionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20261c) {
                InlineSurveyQuestionPartDefinition inlineSurveyQuestionPartDefinition;
                if (a2 != null) {
                    inlineSurveyQuestionPartDefinition = (InlineSurveyQuestionPartDefinition) a2.mo818a(f20261c);
                } else {
                    inlineSurveyQuestionPartDefinition = f20260b;
                }
                if (inlineSurveyQuestionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        b3 = m27930b();
                        if (a2 != null) {
                            a2.mo822a(f20261c, b3);
                        } else {
                            f20260b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineSurveyQuestionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType<InlineSurveyQuestionView> mo2547a() {
        return f20259a;
    }

    private static void m27929a(Props props, State state, InlineSurveyQuestionView inlineSurveyQuestionView) {
        inlineSurveyQuestionView.d.setText(props.c);
        inlineSurveyQuestionView.setAnswerButtonTexts(props.d);
        inlineSurveyQuestionView.setAnswerClickListener(state.a);
        boolean z = props.a;
        InlineSurveyPersistentState inlineSurveyPersistentState = props.e;
        inlineSurveyQuestionView.a.clearCheck();
        int childCount = inlineSurveyQuestionView.a.getChildCount();
        int i = 0;
        while (i < childCount) {
            RadioButton radioButton = (RadioButton) inlineSurveyQuestionView.a.getChildAt(i);
            if (z) {
                radioButton.setChecked(inlineSurveyPersistentState.f == i);
            } else {
                radioButton.setChecked(inlineSurveyPersistentState.g == i);
            }
            i++;
        }
        inlineSurveyQuestionView.a(props.a, state.b);
    }
}
