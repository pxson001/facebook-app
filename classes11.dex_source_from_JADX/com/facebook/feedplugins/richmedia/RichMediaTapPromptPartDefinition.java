package com.facebook.feedplugins.richmedia;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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

@ContextScoped
/* compiled from: buttonNegative */
public class RichMediaTapPromptPartDefinition<V extends View & AttachmentHasTapPrompt> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPersistentState, V> {
    private static RichMediaTapPromptPartDefinition f9214a;
    private static final Object f9215b = new Object();

    private static RichMediaTapPromptPartDefinition m9868a() {
        return new RichMediaTapPromptPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9871a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1712856511);
        m9870a((FeedProps) obj, (HasPersistentState) anyEnvironment, view);
        Logger.a(8, EntryType.MARK_POP, 1526887364, a);
    }

    private static void m9870a(FeedProps<GraphQLStoryAttachment> feedProps, HasPersistentState hasPersistentState, V v) {
        GraphQLStory c = AttachmentProps.c(feedProps);
        if (c != null) {
            RichMediaStoryPersistentState richMediaStoryPersistentState = (RichMediaStoryPersistentState) hasPersistentState.a(new RichMediaStoryKey(c), c);
            if (richMediaStoryPersistentState.f9212b) {
                ((AttachmentHasTapPrompt) v).L_(3000);
                richMediaStoryPersistentState.f9212b = false;
                return;
            }
            ((AttachmentHasTapPrompt) v).mo252c();
        }
    }

    public static RichMediaTapPromptPartDefinition m9869a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichMediaTapPromptPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f9215b) {
                RichMediaTapPromptPartDefinition richMediaTapPromptPartDefinition;
                if (a3 != null) {
                    richMediaTapPromptPartDefinition = (RichMediaTapPromptPartDefinition) a3.a(f9215b);
                } else {
                    richMediaTapPromptPartDefinition = f9214a;
                }
                if (richMediaTapPromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9868a();
                        if (a3 != null) {
                            a3.a(f9215b, a2);
                        } else {
                            f9214a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = richMediaTapPromptPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
