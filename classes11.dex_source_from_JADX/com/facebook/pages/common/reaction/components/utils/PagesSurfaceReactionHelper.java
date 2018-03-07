package com.facebook.pages.common.reaction.components.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: selectTextOnFocus */
public class PagesSurfaceReactionHelper<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> {
    private static PagesSurfaceReactionHelper f2126b;
    private static final Object f2127c = new Object();
    public final ReactionActionHandler f2128a;

    private static PagesSurfaceReactionHelper m3151b(InjectorLike injectorLike) {
        return new PagesSurfaceReactionHelper(ReactionActionHandler.a(injectorLike));
    }

    @Inject
    public PagesSurfaceReactionHelper(ReactionActionHandler reactionActionHandler) {
        this.f2128a = reactionActionHandler;
    }

    public final OnClickListener m3152a(@Nullable ReactionStoryAttachmentActionFragment reactionStoryAttachmentActionFragment, E e, String str, String str2) {
        if (reactionStoryAttachmentActionFragment == null) {
            return null;
        }
        final ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = reactionStoryAttachmentActionFragment;
        final E e2 = e;
        final String str3 = str;
        final String str4 = str2;
        return new OnClickListener(this) {
            final /* synthetic */ PagesSurfaceReactionHelper f2125e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 546707233);
                e2.a(str3, str4, this.f2125e.f2128a.a(reactionStoryAttachmentActionFragmentModel, ((HasContext) e2).getContext(), null, ((HasReactionSession) e2).p().a, ((HasReactionSession) e2).p().c, str3));
                Logger.a(2, EntryType.UI_INPUT_END, -1301679280, a);
            }
        };
    }

    public static PagesSurfaceReactionHelper m3150a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesSurfaceReactionHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2127c) {
                PagesSurfaceReactionHelper pagesSurfaceReactionHelper;
                if (a2 != null) {
                    pagesSurfaceReactionHelper = (PagesSurfaceReactionHelper) a2.a(f2127c);
                } else {
                    pagesSurfaceReactionHelper = f2126b;
                }
                if (pagesSurfaceReactionHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3151b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2127c, b3);
                        } else {
                            f2126b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesSurfaceReactionHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
