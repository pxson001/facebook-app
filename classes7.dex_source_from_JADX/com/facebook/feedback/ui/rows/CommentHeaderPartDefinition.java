package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.views.CommentHeaderView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
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
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.widget.text.markdown.Markdown;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_opt_in_nux_close */
public class CommentHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLComment>, State, CommentsEnvironment, CommentHeaderView> {
    private static CommentHeaderPartDefinition f4932d;
    private static final Object f4933e = new Object();
    private final GatekeeperStoreImpl f4934a;
    private final LinkifyUtil f4935b;
    private final CommentHeaderBasePartDefinition f4936c;

    /* compiled from: ridge_opt_in_nux_close */
    public class State {
        public final CharSequence f4930a;
        public boolean f4931b;

        public State(CharSequence charSequence) {
            this.f4930a = charSequence;
        }
    }

    private static CommentHeaderPartDefinition m5437b(InjectorLike injectorLike) {
        return new CommentHeaderPartDefinition(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), LinkifyUtil.a(injectorLike), CommentHeaderBasePartDefinition.m5432a(injectorLike));
    }

    public final Object m5439a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        JsonNode jsonNode;
        FeedProps feedProps = (FeedProps) obj;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        GraphQLComment graphQLComment = (GraphQLComment) feedProps.a;
        subParts.a(this.f4936c, feedProps);
        if (baseCommentsEnvironment.f4810g == null) {
            jsonNode = null;
        } else {
            jsonNode = baseCommentsEnvironment.f4810g.a;
        }
        Context context = baseCommentsEnvironment.getContext();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130773278, typedValue, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, new int[]{16842904});
        int resourceId = obtainStyledAttributes.getResourceId(0, 2131361848);
        obtainStyledAttributes.recycle();
        Object a = this.f4935b.a(LinkifyUtilConverter.c(graphQLComment.s()), true, jsonNode, resourceId);
        GraphQLTextWithEntities P = ((GraphQLComment) feedProps.a).P();
        boolean z = P != null && this.f4934a.a(149, false);
        return new State(z ? Markdown.a(a, P.a()) : LinkifyUtil.a(a));
    }

    public final /* bridge */ /* synthetic */ void m5440a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -436086335);
        State state = (State) obj2;
        CommentHeaderView commentHeaderView = (CommentHeaderView) view;
        GraphQLComment graphQLComment = (GraphQLComment) ((FeedProps) obj).a;
        if (GraphQLHelper.b(graphQLComment)) {
            commentHeaderView.m5634a(state.f4930a, graphQLComment.y(), GraphQLHelper.a(graphQLComment));
            if (state.f4931b) {
                commentHeaderView.mo280h();
            }
        } else {
            commentHeaderView.setBody(state.f4930a);
        }
        Logger.a(8, EntryType.MARK_POP, 553975856, a);
    }

    public final void m5442b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((State) obj2).f4931b = ((CommentHeaderView) view).m5626g();
    }

    public static CommentHeaderPartDefinition m5436a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4933e) {
                CommentHeaderPartDefinition commentHeaderPartDefinition;
                if (a2 != null) {
                    commentHeaderPartDefinition = (CommentHeaderPartDefinition) a2.a(f4933e);
                } else {
                    commentHeaderPartDefinition = f4932d;
                }
                if (commentHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5437b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4933e, b3);
                        } else {
                            f4932d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CommentHeaderPartDefinition(GatekeeperStoreImpl gatekeeperStoreImpl, LinkifyUtil linkifyUtil, CommentHeaderBasePartDefinition commentHeaderBasePartDefinition) {
        this.f4934a = gatekeeperStoreImpl;
        this.f4935b = linkifyUtil;
        this.f4936c = commentHeaderBasePartDefinition;
    }

    public final ViewType m5438a() {
        return CommentHeaderView.f5181m;
    }

    public final boolean m5441a(Object obj) {
        return true;
    }
}
