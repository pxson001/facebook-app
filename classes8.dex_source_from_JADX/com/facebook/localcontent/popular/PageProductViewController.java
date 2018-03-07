package com.facebook.localcontent.popular;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.fbui.widget.contentview.ContentViewWithButton.Theme;
import com.facebook.graphql.calls.PageProductLikeInputData;
import com.facebook.graphql.calls.PageProductUnlikeInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.localcontent.event.LocalContentEventBus;
import com.facebook.localcontent.event.LocalContentEvents.PageProductLikeUpdatedEvent;
import com.facebook.localcontent.protocol.graphql.PopularProductFragmentsModels.PageProductModel;
import com.facebook.localcontent.protocol.graphql.PopularProductFragmentsModels.PageProductModel.Builder;
import com.facebook.localcontent.protocol.graphql.PopularProductMutations.PageProductLikeMutationString;
import com.facebook.localcontent.protocol.graphql.PopularProductMutations.PageProductUnlikeMutationString;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: documentID */
public class PageProductViewController {
    public static final String f15233a = PageProductViewController.class.getSimpleName();
    public final AbstractFbErrorReporter f15234b;
    public final GraphQLQueryExecutor f15235c;
    public final LocalContentEventBus f15236d;
    public final TasksManager<String> f15237e;
    private final Toaster f15238f;

    /* compiled from: documentID */
    public class C16622 extends AbstractDisposableFutureCallback<GraphQLResult<?>> {
        final /* synthetic */ ContentViewWithButton f15230a;
        final /* synthetic */ PageProductModel f15231b;
        final /* synthetic */ PageProductViewController f15232c;

        public C16622(PageProductViewController pageProductViewController, ContentViewWithButton contentViewWithButton, PageProductModel pageProductModel) {
            this.f15232c = pageProductViewController;
            this.f15230a = contentViewWithButton;
            this.f15231b = pageProductModel;
        }

        protected final void m17663a(Throwable th) {
            PageProductViewController.m17665d(this.f15232c, this.f15230a, this.f15231b);
        }
    }

    @Inject
    public PageProductViewController(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, LocalContentEventBus localContentEventBus, TasksManager tasksManager, Toaster toaster) {
        this.f15234b = abstractFbErrorReporter;
        this.f15235c = graphQLQueryExecutor;
        this.f15236d = localContentEventBus;
        this.f15237e = tasksManager;
        this.f15238f = toaster;
    }

    public final void m17666a(ContentViewWithButton contentViewWithButton, PageProductModel pageProductModel) {
        contentViewWithButton.setTitleText(pageProductModel.d());
        contentViewWithButton.setActionButtonTheme(Theme.NONE);
        m17664b(contentViewWithButton, pageProductModel);
    }

    private void m17664b(final ContentViewWithButton contentViewWithButton, final PageProductModel pageProductModel) {
        CharSequence string;
        Context context = contentViewWithButton.getContext();
        String str = null;
        if (pageProductModel.b()) {
            if (pageProductModel.g() != null) {
                str = pageProductModel.g().a();
            }
        } else if (pageProductModel.cR_() != null) {
            str = pageProductModel.cR_().a();
        }
        contentViewWithButton.setSubtitleText(str);
        GlyphView glyphView = (GlyphView) contentViewWithButton.findViewById(2131566176);
        glyphView.setSelected(pageProductModel.b());
        if (pageProductModel.b()) {
            string = context.getString(2131233268);
        } else {
            string = context.getString(2131233267);
        }
        glyphView.setContentDescription(string);
        glyphView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageProductViewController f15229c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1820351242);
                PageProductViewController pageProductViewController = this.f15229c;
                ContentViewWithButton contentViewWithButton = contentViewWithButton;
                PageProductModel pageProductModel = pageProductModel;
                PageProductModel a2 = PageProductModel.a(pageProductModel);
                if (a2 == null) {
                    pageProductViewController.f15234b.a(PageProductViewController.f15233a, "Trying to like null product");
                } else {
                    boolean z;
                    MutationRequest a3;
                    Builder builder = new Builder();
                    Builder builder2 = new Builder();
                    builder2.a = a2.b();
                    builder2.b = a2.c();
                    builder2.c = a2.d();
                    builder2.d = a2.j();
                    builder2.e = a2.k();
                    builder = builder2;
                    if (pageProductModel.b()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    builder.a = z;
                    pageProductViewController.f15236d.a(new PageProductLikeUpdatedEvent(builder.a()));
                    String c = pageProductModel.c();
                    GraphQlQueryString pageProductUnlikeMutationString;
                    if (pageProductModel.b()) {
                        PageProductUnlikeInputData a4 = new PageProductUnlikeInputData().a(c).a(PageProductUnlikeInputData.Context.AFTER_PARTY_POPULAR_AT_ANDROID);
                        pageProductUnlikeMutationString = new PageProductUnlikeMutationString();
                        pageProductUnlikeMutationString.a("input", a4);
                        a3 = GraphQLRequest.a(pageProductUnlikeMutationString);
                    } else {
                        PageProductLikeInputData a5 = new PageProductLikeInputData().a(c).a(PageProductLikeInputData.Context.AFTER_PARTY_POPULAR_AT_ANDROID);
                        pageProductUnlikeMutationString = new PageProductLikeMutationString();
                        pageProductUnlikeMutationString.a("input", a5);
                        a3 = GraphQLRequest.a(pageProductUnlikeMutationString);
                    }
                    pageProductViewController.f15237e.a("task_key_mutate_like" + c, pageProductViewController.f15235c.a(a3, OfflineQueryBehavior.b), new C16622(pageProductViewController, contentViewWithButton, pageProductModel));
                }
                Logger.a(2, EntryType.UI_INPUT_END, 698284860, a);
            }
        });
    }

    public static void m17665d(PageProductViewController pageProductViewController, ContentViewWithButton contentViewWithButton, PageProductModel pageProductModel) {
        pageProductViewController.m17664b(contentViewWithButton, pageProductModel);
        pageProductViewController.f15238f.b(new ToastBuilder(pageProductModel.b() ? contentViewWithButton.getContext().getString(2131239094) : contentViewWithButton.getContext().getString(2131239093)));
    }
}
