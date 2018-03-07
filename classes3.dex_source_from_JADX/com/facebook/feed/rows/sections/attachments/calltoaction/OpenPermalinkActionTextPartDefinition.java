package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.attachments.angora.AttachmentHasRating;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.text.CustomFontUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Unexpected error in prefetching task */
public class OpenPermalinkActionTextPartDefinition<V extends View & AngoraAttachment & AttachmentHasSubcontext & AttachmentHasRating> extends BaseSinglePartDefinition<GraphQLStoryAttachment, State, AnyEnvironment, V> {
    private static OpenPermalinkActionTextPartDefinition f338b;
    private static final Object f339c = new Object();
    private final CustomFontUtil f340a;

    private static OpenPermalinkActionTextPartDefinition m300b(InjectorLike injectorLike) {
        return new OpenPermalinkActionTextPartDefinition(CustomFontUtil.a(injectorLike));
    }

    public final Object m301a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) obj, -1580386863);
        Spannable spannableStringBuilder = new SpannableStringBuilder(a.V());
        spannableStringBuilder.setSpan(CustomFontUtil.a(), 0, a.V().length(), 17);
        return new State(spannableStringBuilder, new SpannableStringBuilder(a.Q()), a.aB());
    }

    public final /* bridge */ /* synthetic */ void m302a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1638655287);
        m299a((State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -188062243, a);
    }

    @Inject
    public OpenPermalinkActionTextPartDefinition(CustomFontUtil customFontUtil) {
        this.f340a = customFontUtil;
    }

    public static OpenPermalinkActionTextPartDefinition m298a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OpenPermalinkActionTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f339c) {
                OpenPermalinkActionTextPartDefinition openPermalinkActionTextPartDefinition;
                if (a2 != null) {
                    openPermalinkActionTextPartDefinition = (OpenPermalinkActionTextPartDefinition) a2.a(f339c);
                } else {
                    openPermalinkActionTextPartDefinition = f338b;
                }
                if (openPermalinkActionTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m300b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f339c, b3);
                        } else {
                            f338b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = openPermalinkActionTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m299a(State state, V v) {
        ((AttachmentHasRating) v).setShowRating(false);
        ((AttachmentHasRating) v).setRating(0.0f);
        ((AttachmentHasRating) v).setNumberOfStars(0);
        ((AttachmentHasLabel) v).setTitle(state.a);
        ((AttachmentHasLabel) v).setContextText(state.b);
        ((AttachmentHasSubcontext) v).setSubcontextText(null);
        GenericActionButtonView actionButton = ((AttachmentHasButton) v).getActionButton();
        actionButton.a.setText(state.c);
        actionButton.setVisibility(!TextUtils.isEmpty(state.c) ? 0 : 8);
    }

    public final void m303b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasClear) view).a();
    }
}
