package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.api.ufiservices.common.CommentLoadDirection;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.LoadMoreCommentsView;
import com.facebook.feedback.ui.LoadMoreCommentsView.Listener;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_disabled */
public class LoadMoreCommentsPartDefinition extends MultiRowSinglePartDefinition<Props, Listener, CommentsEnvironment, LoadMoreCommentsView> {
    public static final ViewType f5073a = new C04991();
    private static LoadMoreCommentsPartDefinition f5074d;
    private static final Object f5075e = new Object();
    private final CommentStylingPartDefinition f5076b;
    public final boolean f5077c;

    /* compiled from: ridge_disabled */
    final class C04991 extends ViewType {
        C04991() {
        }

        public final View m5547a(Context context) {
            return new LoadMoreCommentsView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    /* compiled from: ridge_disabled */
    public class Props implements RootProps {
        public final GraphQLFeedback f5070a;
        public final CommentLoadDirection f5071b;
        public final CommentLevel f5072c;

        public Props(GraphQLFeedback graphQLFeedback, CommentLoadDirection commentLoadDirection, CommentLevel commentLevel) {
            this.f5070a = graphQLFeedback;
            this.f5071b = commentLoadDirection;
            this.f5072c = commentLevel;
        }
    }

    private static LoadMoreCommentsPartDefinition m5551b(InjectorLike injectorLike) {
        return new LoadMoreCommentsPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m5553a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        subParts.a(this.f5076b, new com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props(CommentLevel.TOP_LEVEL.equals(props.f5072c) ? CommentRowPadding.NO_OFFSET : CommentRowPadding.PROFILE_PICTURE_OFFSET));
        return new Listener(this) {
            final /* synthetic */ LoadMoreCommentsPartDefinition f5069c;

            public final void mo202a() {
                BaseCommentsEnvironment baseCommentsEnvironment = baseCommentsEnvironment;
                baseCommentsEnvironment.f4807d.m5153a(props.f5070a, props.f5071b);
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m5554a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1501849537);
        Props props = (Props) obj;
        LoadMoreCommentsView loadMoreCommentsView = (LoadMoreCommentsView) view;
        loadMoreCommentsView.f4615i = (Listener) obj2;
        loadMoreCommentsView.m5162a(CommentOrderType.getOrder(props.f5070a), props.f5071b);
        if ((CommentOrderType.RANKED_ORDER.equals(CommentOrderType.getOrder(props.f5070a)) ? CommentLoadDirection.LOAD_AFTER : CommentLoadDirection.LOAD_BEFORE) == props.f5071b) {
            Props props2 = new Props(props.f5070a, props.f5071b.equals(CommentLoadDirection.LOAD_BEFORE) ? CommentLoadDirection.LOAD_AFTER : CommentLoadDirection.LOAD_BEFORE, props.f5072c);
            if (this.f5077c && !m5550a(props2)) {
                loadMoreCommentsView.callOnClick();
            }
        }
        Logger.a(8, EntryType.MARK_POP, 556914662, a);
    }

    public final void m5556b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        LoadMoreCommentsView loadMoreCommentsView = (LoadMoreCommentsView) view;
        loadMoreCommentsView.f4615i = null;
        loadMoreCommentsView.setOnClickListener(null);
    }

    public static LoadMoreCommentsPartDefinition m5549a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LoadMoreCommentsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5075e) {
                LoadMoreCommentsPartDefinition loadMoreCommentsPartDefinition;
                if (a2 != null) {
                    loadMoreCommentsPartDefinition = (LoadMoreCommentsPartDefinition) a2.a(f5075e);
                } else {
                    loadMoreCommentsPartDefinition = f5074d;
                }
                if (loadMoreCommentsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5551b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5075e, b3);
                        } else {
                            f5074d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = loadMoreCommentsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LoadMoreCommentsPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition, QeAccessor qeAccessor) {
        this.f5076b = commentStylingPartDefinition;
        this.f5077c = qeAccessor.a(ExperimentsForFeedbackTestModule.a, false);
    }

    public final ViewType m5552a() {
        return f5073a;
    }

    public final boolean m5555a(Object obj) {
        return true;
    }

    public static boolean m5550a(Props props) {
        if (props.f5071b.equals(CommentLoadDirection.LOAD_BEFORE)) {
            return GraphQLHelper.j(props.f5070a);
        }
        return GraphQLHelper.k(props.f5070a);
    }
}
