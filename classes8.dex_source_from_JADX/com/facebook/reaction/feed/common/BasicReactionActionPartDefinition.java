package com.facebook.reaction.feed.common;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.today.common.HasNotifications;
import com.facebook.ui.touchlistener.HighlightViewOnTouchListener;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bellerophon_start */
public class BasicReactionActionPartDefinition<E extends HasReactionSession & CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams> extends BaseSinglePartDefinition<Props, State, E, View> {
    private static BasicReactionActionPartDefinition f18964b;
    private static final Object f18965c = new Object();
    public final ReactionActionHandler f18966a;

    /* compiled from: bellerophon_start */
    public class Props {
        public final ReactionStoryAttachmentActionFragmentModel f18957a;
        public final OnClickListener f18958b;
        @Nullable
        public final OnTouchListener f18959c;
        public final String f18960d;
        public final String f18961e;
        @Nullable
        public final String f18962f;

        public Props(ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel, @Nullable String str, String str2, String str3, @Nullable OnClickListener onClickListener, @Nullable OnTouchListener onTouchListener) {
            this.f18957a = reactionStoryAttachmentActionFragmentModel;
            this.f18960d = str2;
            this.f18961e = str3;
            this.f18962f = str;
            this.f18958b = onClickListener;
            this.f18959c = onTouchListener;
        }

        public Props(ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel, @Nullable String str, String str2, String str3) {
            this(reactionStoryAttachmentActionFragmentModel, str, str2, str3, null, new HighlightViewOnTouchListener());
        }

        public Props(ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel, String str, String str2) {
            this(reactionStoryAttachmentActionFragmentModel, reactionStoryAttachmentActionFragmentModel.fU_() != null ? reactionStoryAttachmentActionFragmentModel.fU_().a() : null, str, str2);
        }
    }

    /* compiled from: bellerophon_start */
    public class State {
        public final OnClickListener f18963a;

        public State(OnClickListener onClickListener) {
            this.f18963a = onClickListener;
        }
    }

    private static BasicReactionActionPartDefinition m22985b(InjectorLike injectorLike) {
        return new BasicReactionActionPartDefinition(ReactionActionHandler.m22673a(injectorLike));
    }

    public final Object m22986a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final HasReactionSession hasReactionSession = (HasReactionSession) anyEnvironment;
        return new State(new OnClickListener(this) {
            final /* synthetic */ BasicReactionActionPartDefinition f18956c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 591914712);
                if (props.f18958b != null) {
                    props.f18958b.onClick(view);
                }
                if (hasReactionSession instanceof HasNotifications) {
                    ((HasNotifications) hasReactionSession).mo972a();
                    ((HasNotifications) hasReactionSession).mo978b(props.f18960d);
                }
                ((CanLaunchReactionIntent) hasReactionSession).mo695a(props.f18960d, props.f18961e, this.f18956c.f18966a.m22677a(props.f18957a, ((HasContext) hasReactionSession).getContext(), props.f18962f, hasReactionSession.mo704p().f18658a, hasReactionSession.mo704p().f18660c, props.f18960d, props.f18961e, ((HasReactionAnalyticsParams) hasReactionSession).mo706r()));
                Logger.a(2, EntryType.UI_INPUT_END, -1572944263, a);
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m22987a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1557585529);
        Props props = (Props) obj;
        view.setOnClickListener(((State) obj2).f18963a);
        view.setOnTouchListener(props.f18959c);
        Logger.a(8, EntryType.MARK_POP, 658645957, a);
    }

    public final void m22988b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setOnClickListener(null);
        view.setOnTouchListener(null);
    }

    public static BasicReactionActionPartDefinition m22984a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicReactionActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18965c) {
                BasicReactionActionPartDefinition basicReactionActionPartDefinition;
                if (a2 != null) {
                    basicReactionActionPartDefinition = (BasicReactionActionPartDefinition) a2.a(f18965c);
                } else {
                    basicReactionActionPartDefinition = f18964b;
                }
                if (basicReactionActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22985b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18965c, b3);
                        } else {
                            f18964b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = basicReactionActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public BasicReactionActionPartDefinition(ReactionActionHandler reactionActionHandler) {
        this.f18966a = reactionActionHandler;
    }
}
