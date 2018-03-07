package com.facebook.ufiservices.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnCancelListener;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: crop_rect_right */
public class CommentMenuHelper {
    public final Context f18308a;
    public final ViewerContext f18309b;
    private final Provider<Boolean> f18310c;
    private final PendingCommentCache f18311d;
    public final Lazy<FbErrorReporter> f18312e;

    /* compiled from: crop_rect_right */
    public class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ OnCommentClickListener f18284a;
        final /* synthetic */ GraphQLComment f18285b;
        final /* synthetic */ CommentMenuHelper f18286c;

        public AnonymousClass10(CommentMenuHelper commentMenuHelper, OnCommentClickListener onCommentClickListener, GraphQLComment graphQLComment) {
            this.f18286c = commentMenuHelper;
            this.f18284a = onCommentClickListener;
            this.f18285b = graphQLComment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f18286c.f18309b.mIsPageContext) {
                this.f18284a.m26830a(this.f18286c.f18309b.mUserId, this.f18285b);
                this.f18284a.m26829a(this.f18285b);
                return;
            }
            ((AbstractFbErrorReporter) this.f18286c.f18312e.get()).b(getClass().getSimpleName(), "Fail to log banning user actions in comments list: not Page Viewer Context");
        }
    }

    /* compiled from: crop_rect_right */
    class C13516 implements OnMenuItemClickListener {
        final /* synthetic */ CommentMenuHelper f18302a;

        C13516(CommentMenuHelper commentMenuHelper) {
            this.f18302a = commentMenuHelper;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: crop_rect_right */
    class C13527 implements OnCancelListener {
        final /* synthetic */ CommentMenuHelper f18303a;

        C13527(CommentMenuHelper commentMenuHelper) {
            this.f18303a = commentMenuHelper;
        }

        public final boolean m26827a() {
            return false;
        }
    }

    /* compiled from: crop_rect_right */
    class C13538 implements OnDismissListener {
        final /* synthetic */ CommentMenuHelper f18304a;

        C13538(CommentMenuHelper commentMenuHelper) {
            this.f18304a = commentMenuHelper;
        }

        public final boolean m26828a(PopoverWindow popoverWindow) {
            return false;
        }
    }

    /* compiled from: crop_rect_right */
    public class C13549 implements OnClickListener {
        final /* synthetic */ OnCommentClickListener f18305a;
        final /* synthetic */ GraphQLComment f18306b;
        final /* synthetic */ CommentMenuHelper f18307c;

        public C13549(CommentMenuHelper commentMenuHelper, OnCommentClickListener onCommentClickListener, GraphQLComment graphQLComment) {
            this.f18307c = commentMenuHelper;
            this.f18305a = onCommentClickListener;
            this.f18306b = graphQLComment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18305a.m26829a(this.f18306b);
        }
    }

    /* compiled from: crop_rect_right */
    public interface OnCommentClickListener {
        void m26829a(GraphQLComment graphQLComment);

        void m26830a(String str, GraphQLComment graphQLComment);

        void m26831b(GraphQLComment graphQLComment);

        void m26832c(GraphQLComment graphQLComment);

        void m26833d(GraphQLComment graphQLComment);
    }

    public static CommentMenuHelper m26834b(InjectorLike injectorLike) {
        return new CommentMenuHelper((Context) injectorLike.getInstance(Context.class), ViewerContextMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 4357), PendingCommentCache.m26489a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public CommentMenuHelper(Context context, ViewerContext viewerContext, Provider<Boolean> provider, PendingCommentCache pendingCommentCache, Lazy<FbErrorReporter> lazy) {
        this.f18308a = context;
        this.f18309b = viewerContext;
        this.f18310c = provider;
        this.f18311d = pendingCommentCache;
        this.f18312e = lazy;
    }

    public final boolean m26839a(final GraphQLComment graphQLComment, View view, Context context, final OnCommentClickListener onCommentClickListener) {
        if (context == null || !m26838a(graphQLComment)) {
            return false;
        }
        Object obj;
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(this.f18308a, 1);
        PopoverMenu c = figPopoverMenuWindow.c();
        if (!(graphQLComment.s() == null || StringUtil.a(graphQLComment.s().a()))) {
            c.a(context.getString(2131233270)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ CommentMenuHelper f18289c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    onCommentClickListener.m26832c(graphQLComment);
                    return false;
                }
            });
        }
        if (m26835b(graphQLComment)) {
            c.a(context.getString(2131233271)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ CommentMenuHelper f18292c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    CommentMenuHelper commentMenuHelper = this.f18292c;
                    GraphQLComment graphQLComment = graphQLComment;
                    OnCommentClickListener onCommentClickListener = onCommentClickListener;
                    Context context = this.f18292c.f18308a;
                    new FbAlertDialogBuilder(context).b(context.getResources().getString(2131233452)).a(2131233456, new C13549(commentMenuHelper, onCommentClickListener, graphQLComment)).b(2131233563, null).b();
                    return false;
                }
            });
        }
        if (!graphQLComment.t() || !this.f18309b.mIsPageContext || graphQLComment.r() == null || graphQLComment.r().H() == null || graphQLComment.r().H().equals(this.f18309b.mUserId)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            c.a(context.getString(2131233278)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ CommentMenuHelper f18295c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    CommentMenuHelper commentMenuHelper = this.f18295c;
                    GraphQLComment graphQLComment = graphQLComment;
                    OnCommentClickListener onCommentClickListener = onCommentClickListener;
                    Context context = this.f18295c.f18308a;
                    new FbAlertDialogBuilder(context).b(context.getResources().getString(2131233453)).a(2131233457, new AnonymousClass10(commentMenuHelper, onCommentClickListener, graphQLComment)).b(2131233563, null).b();
                    return false;
                }
            });
        }
        if (m26836c(graphQLComment)) {
            c.a(context.getString(2131233272)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ CommentMenuHelper f18298c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    onCommentClickListener.m26831b(graphQLComment);
                    return false;
                }
            });
        }
        if (m26837d(graphQLComment)) {
            c.a(context.getString(2131233273)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ CommentMenuHelper f18301c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    onCommentClickListener.m26833d(graphQLComment);
                    return false;
                }
            });
        }
        c.a(context.getString(2131230727)).setOnMenuItemClickListener(new C13516(this));
        figPopoverMenuWindow.I = new C13527(this);
        figPopoverMenuWindow.H = new C13538(this);
        figPopoverMenuWindow.f(view);
        return true;
    }

    public final boolean m26838a(@Nullable GraphQLComment graphQLComment) {
        if (graphQLComment == null) {
            return false;
        }
        if (GraphQLCommentHelper.g(graphQLComment)) {
            return m26835b(graphQLComment);
        }
        if (m26836c(graphQLComment) || m26835b(graphQLComment) || GraphQLCommentHelper.b(graphQLComment) || (graphQLComment.s() != null && !StringUtil.a(graphQLComment.s().a()))) {
            return true;
        }
        return false;
    }

    private boolean m26835b(GraphQLComment graphQLComment) {
        return (graphQLComment.t() && graphQLComment.l() != null) || this.f18311d.m26494c(graphQLComment.H()) == GraphQLFeedOptimisticPublishState.OFFLINE;
    }

    private boolean m26836c(GraphQLComment graphQLComment) {
        return ((Boolean) this.f18310c.get()).booleanValue() && graphQLComment.u() && graphQLComment.l() != null && !GraphQLCommentHelper.g(graphQLComment);
    }

    private boolean m26837d(GraphQLComment graphQLComment) {
        return (m26835b(graphQLComment) || GraphQLCommentHelper.g(graphQLComment)) ? false : true;
    }
}
