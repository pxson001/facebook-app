package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;

@ContextScoped
/* compiled from: ar_search_captcha_required */
public class ReactionAttachmentActionPartDefinition<E extends CanLaunchReactionIntent & HasReactionInteractionTracker> extends BaseSinglePartDefinition<Props, OnClickListener, E, View> {
    private static ReactionAttachmentActionPartDefinition f19326a;
    private static final Object f19327b = new Object();

    /* compiled from: ar_search_captcha_required */
    public class Props {
        public final ReactionAttachmentIntent f19323a;
        public final String f19324b;
        public final String f19325c;

        public Props(ReactionAttachmentIntent reactionAttachmentIntent, String str, String str2) {
            this.f19323a = reactionAttachmentIntent;
            this.f19324b = str;
            this.f19325c = str2;
        }
    }

    private static ReactionAttachmentActionPartDefinition m23323a() {
        return new ReactionAttachmentActionPartDefinition();
    }

    public final Object m23325a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        return new OnClickListener(this) {
            final /* synthetic */ ReactionAttachmentActionPartDefinition f19322c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1158990879);
                canLaunchReactionIntent.mo695a(props.f19324b, props.f19325c, props.f19323a);
                Logger.a(2, EntryType.UI_INPUT_END, -1843271304, a);
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m23326a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -17336272);
        view.setOnClickListener((OnClickListener) obj2);
        Logger.a(8, EntryType.MARK_POP, 162713743, a);
    }

    public static ReactionAttachmentActionPartDefinition m23324a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionAttachmentActionPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f19327b) {
                ReactionAttachmentActionPartDefinition reactionAttachmentActionPartDefinition;
                if (a3 != null) {
                    reactionAttachmentActionPartDefinition = (ReactionAttachmentActionPartDefinition) a3.a(f19327b);
                } else {
                    reactionAttachmentActionPartDefinition = f19326a;
                }
                if (reactionAttachmentActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23323a();
                        if (a3 != null) {
                            a3.a(f19327b, a2);
                        } else {
                            f19326a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = reactionAttachmentActionPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }

    public final void m23327b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setOnClickListener(null);
    }
}
