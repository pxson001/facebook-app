package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedback.ui.environment.HasCommentActions;
import com.facebook.feedback.ui.environment.HasCommentStylingResolver;
import com.facebook.feedback.ui.environment.HasLoggingParams;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.feedback.ui.rows.views.ViewMoreRepliesView;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.resources.ui.FbTextView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: review_needy_place_card_tapped */
public class ViewMoreRepliesPartDefinition<E extends HasCommentActions & HasCommentStylingResolver & HasLoggingParams> extends MultiRowSinglePartDefinition<Props, Void, E, FbTextView> {
    public static final ViewType f5137a = new C05071();
    private static ViewMoreRepliesPartDefinition f5138e;
    private static final Object f5139f = new Object();
    private final TextPartDefinition f5140b;
    private final CommentStylingPartDefinition f5141c;
    private final Resources f5142d;

    /* compiled from: review_needy_place_card_tapped */
    final class C05071 extends ViewType {
        C05071() {
        }

        public final View m5594a(Context context) {
            return new ViewMoreRepliesView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    /* compiled from: review_needy_place_card_tapped */
    public class Props {
        public final GraphQLComment f5133a;
        public final ImmutableList<GraphQLComment> f5134b;
        public final boolean f5135c;
        public final OnClickListener f5136d;

        public Props(GraphQLComment graphQLComment, ImmutableList<GraphQLComment> immutableList, boolean z, OnClickListener onClickListener) {
            this.f5133a = graphQLComment;
            this.f5134b = immutableList;
            this.f5135c = z;
            this.f5136d = onClickListener;
        }
    }

    private static ViewMoreRepliesPartDefinition m5596b(InjectorLike injectorLike) {
        return new ViewMoreRepliesPartDefinition(TextPartDefinition.a(injectorLike), CommentStylingPartDefinition.m5508a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m5598a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        int f = GraphQLHelper.f(props.f5133a.l()) - props.f5134b.size();
        subParts.a(this.f5140b, this.f5142d.getQuantityString(props.f5135c ? 2131689547 : 2131689548, f, new Object[]{Integer.valueOf(f)}));
        subParts.a(this.f5141c, new com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props(CommentRowPadding.PROFILE_PICTURE_OFFSET));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m5599a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1857278170);
        ((FbTextView) view).setOnClickListener(((Props) obj).f5136d);
        Logger.a(8, EntryType.MARK_POP, 319082938, a);
    }

    public final boolean m5600a(Object obj) {
        Props props = (Props) obj;
        GraphQLFeedback l = props.f5133a.l();
        if (l != null && GraphQLHelper.f(l) > props.f5134b.size()) {
            return true;
        }
        return false;
    }

    public final void m5601b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((FbTextView) view).setOnClickListener(null);
    }

    public static ViewMoreRepliesPartDefinition m5595a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ViewMoreRepliesPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5139f) {
                ViewMoreRepliesPartDefinition viewMoreRepliesPartDefinition;
                if (a2 != null) {
                    viewMoreRepliesPartDefinition = (ViewMoreRepliesPartDefinition) a2.a(f5139f);
                } else {
                    viewMoreRepliesPartDefinition = f5138e;
                }
                if (viewMoreRepliesPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5596b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5139f, b3);
                        } else {
                            f5138e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = viewMoreRepliesPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ViewMoreRepliesPartDefinition(TextPartDefinition textPartDefinition, CommentStylingPartDefinition commentStylingPartDefinition, Resources resources) {
        this.f5140b = textPartDefinition;
        this.f5141c = commentStylingPartDefinition;
        this.f5142d = resources;
    }

    public final ViewType m5597a() {
        return f5137a;
    }
}
