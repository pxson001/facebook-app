package com.facebook.feedplugins.attachments.poll;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THIS_WEEK */
public class PollOptionTextWithProgressBarPartDefinition extends MultiRowSinglePartDefinition<Props, State, AnyEnvironment, PollOptionTextViewWithProgressBar> {
    public static final ViewType f22705a = new C19761();
    private static PollOptionTextWithProgressBarPartDefinition f22706c;
    private static final Object f22707d = new Object();
    private final ClickListenerPartDefinition f22708b;

    /* compiled from: THIS_WEEK */
    final class C19761 extends ViewType {
        C19761() {
        }

        public final View m25330a(Context context) {
            return new PollOptionTextViewWithProgressBar(context);
        }
    }

    @Immutable
    /* compiled from: THIS_WEEK */
    public class Props {
        public final int f22698a;
        public final int f22699b;
        public final OnClickListener f22700c;
        public final String f22701d;

        public Props(int i, int i2, String str, OnClickListener onClickListener) {
            this.f22698a = i;
            this.f22699b = i2;
            this.f22700c = onClickListener;
            this.f22701d = str;
        }
    }

    @Immutable
    /* compiled from: THIS_WEEK */
    public class State {
        public final String f22702a;
        public final int f22703b;
        public final int f22704c;

        public State(String str, int i, int i2) {
            this.f22702a = str;
            this.f22703b = i;
            this.f22704c = i2;
        }
    }

    private static PollOptionTextWithProgressBarPartDefinition m25332b(InjectorLike injectorLike) {
        return new PollOptionTextWithProgressBarPartDefinition(ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m25334a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f22708b, props.f22700c);
        return new State(props.f22701d, props.f22698a, props.f22699b);
    }

    public final /* bridge */ /* synthetic */ void m25335a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -639844715);
        State state = (State) obj2;
        PollOptionTextViewWithProgressBar pollOptionTextViewWithProgressBar = (PollOptionTextViewWithProgressBar) view;
        pollOptionTextViewWithProgressBar.setText(state.f22702a);
        pollOptionTextViewWithProgressBar.setProgress(((float) state.f22704c) / ((float) state.f22703b));
        Logger.a(8, EntryType.MARK_POP, 1308062860, a);
    }

    public final boolean m25336a(Object obj) {
        return true;
    }

    public static PollOptionTextWithProgressBarPartDefinition m25331a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PollOptionTextWithProgressBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22707d) {
                PollOptionTextWithProgressBarPartDefinition pollOptionTextWithProgressBarPartDefinition;
                if (a2 != null) {
                    pollOptionTextWithProgressBarPartDefinition = (PollOptionTextWithProgressBarPartDefinition) a2.a(f22707d);
                } else {
                    pollOptionTextWithProgressBarPartDefinition = f22706c;
                }
                if (pollOptionTextWithProgressBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25332b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22707d, b3);
                        } else {
                            f22706c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pollOptionTextWithProgressBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<PollOptionTextViewWithProgressBar> m25333a() {
        return f22705a;
    }

    @Inject
    public PollOptionTextWithProgressBarPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f22708b = clickListenerPartDefinition;
    }
}
