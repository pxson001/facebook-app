package com.facebook.reaction.feed.rows.subparts;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.reaction.feed.rows.ui.ReactionTitleAndLabelView;

@ContextScoped
/* compiled from: android_native_article_webview_ad_report */
public class ReactionTitleAndLabelViewPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, ReactionTitleAndLabelView> {
    private static ReactionTitleAndLabelViewPartDefinition f19451a;
    private static final Object f19452b = new Object();

    /* compiled from: android_native_article_webview_ad_report */
    public class Props {
        public final String f19446a;
        public final String f19447b;
        public final int f19448c;
        public final int f19449d;
        public final boolean f19450e;

        public Props(String str, String str2, int i, int i2) {
            this(str, str2, i, i2, true);
        }

        public Props(String str, String str2, int i, int i2, boolean z) {
            this.f19446a = str;
            this.f19447b = str2;
            this.f19448c = i;
            this.f19449d = i2;
            this.f19450e = z;
        }
    }

    private static ReactionTitleAndLabelViewPartDefinition m23427a() {
        return new ReactionTitleAndLabelViewPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m23429a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 292063075);
        Props props = (Props) obj;
        ReactionTitleAndLabelView reactionTitleAndLabelView = (ReactionTitleAndLabelView) view;
        if (props.f19450e) {
            reactionTitleAndLabelView.setVisibility(0);
            reactionTitleAndLabelView.setTitle(props.f19446a);
            reactionTitleAndLabelView.setLabel(props.f19447b);
            reactionTitleAndLabelView.setTitleTextAppearance(props.f19448c);
            reactionTitleAndLabelView.setLabelTextAppearance(props.f19449d);
        } else {
            reactionTitleAndLabelView.setVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, 2097564309, a);
    }

    public static ReactionTitleAndLabelViewPartDefinition m23428a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionTitleAndLabelViewPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f19452b) {
                ReactionTitleAndLabelViewPartDefinition reactionTitleAndLabelViewPartDefinition;
                if (a3 != null) {
                    reactionTitleAndLabelViewPartDefinition = (ReactionTitleAndLabelViewPartDefinition) a3.a(f19452b);
                } else {
                    reactionTitleAndLabelViewPartDefinition = f19451a;
                }
                if (reactionTitleAndLabelViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23427a();
                        if (a3 != null) {
                            a3.a(f19452b, a2);
                        } else {
                            f19451a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = reactionTitleAndLabelViewPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
