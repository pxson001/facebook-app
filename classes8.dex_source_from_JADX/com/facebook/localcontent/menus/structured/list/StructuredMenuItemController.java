package com.facebook.localcontent.menus.structured.list;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.graphql.calls.PageProductLikeInputData;
import com.facebook.graphql.calls.PageProductUnlikeInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.localcontent.menus.structured.list.StructuredMenuListAdapter.C16551;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListModels.MenuItemModel;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListModels.MenuItemModel.Builder;
import com.facebook.localcontent.protocol.graphql.StructuredMenuMutations.MenuItemLikeMutationString;
import com.facebook.localcontent.protocol.graphql.StructuredMenuMutations.MenuItemUnlikeMutationString;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.springbutton.SpringScaleButton;
import com.facebook.widget.springbutton.TouchSpring;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: duplicate_override_ids */
public class StructuredMenuItemController {
    private static final String f15157a = StructuredMenuItemController.class.getSimpleName();
    public final int f15158b = this.f15163g.getDimensionPixelSize(2131432701);
    public final int f15159c = this.f15163g.getDimensionPixelSize(2131432699);
    public final int f15160d = this.f15163g.getDimensionPixelSize(2131432698);
    private final AbstractFbErrorReporter f15161e;
    private final GraphQLQueryExecutor f15162f;
    private final Resources f15163g;
    private final TasksManager<String> f15164h;
    private final Toaster f15165i;
    private final Provider<TouchSpring> f15166j;

    @Inject
    public StructuredMenuItemController(FbErrorReporter fbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, TasksManager tasksManager, Toaster toaster, Provider<TouchSpring> provider) {
        this.f15161e = fbErrorReporter;
        this.f15162f = graphQLQueryExecutor;
        this.f15163g = resources;
        this.f15164h = tasksManager;
        this.f15165i = toaster;
        this.f15166j = provider;
    }

    public final void m17596a(ContentViewWithButton contentViewWithButton, MenuItemModel menuItemModel, C16551 c16551, boolean z) {
        contentViewWithButton.setTitleText(menuItemModel.cP_());
        contentViewWithButton.setSubtitleText(menuItemModel.b());
        m17593a(contentViewWithButton, menuItemModel, c16551);
        int i = 0;
        int i2 = z ? this.f15158b : this.f15159c;
        boolean a = RTLUtil.a(contentViewWithButton.getContext());
        int i3 = a ? 0 : this.f15160d;
        if (a) {
            i = this.f15160d;
        }
        contentViewWithButton.setPadding(i3, i2, i, contentViewWithButton.getPaddingBottom());
    }

    private void m17593a(final ContentViewWithButton contentViewWithButton, final MenuItemModel menuItemModel, final C16551 c16551) {
        CharSequence string;
        Context context = contentViewWithButton.getContext();
        String str = null;
        if (menuItemModel.c()) {
            if (menuItemModel.cQ_() != null) {
                str = menuItemModel.cQ_().a();
            }
        } else if (menuItemModel.g() != null) {
            str = menuItemModel.g().a();
        }
        contentViewWithButton.setMetaText(str);
        SpringScaleButton springScaleButton = (SpringScaleButton) contentViewWithButton.findViewById(2131567733);
        springScaleButton.setSelected(menuItemModel.c());
        if (menuItemModel.c()) {
            string = context.getString(2131233268);
        } else {
            string = context.getString(2131233267);
        }
        springScaleButton.setContentDescription(string);
        springScaleButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StructuredMenuItemController f15152d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1163388159);
                StructuredMenuItemController.m17594b(this.f15152d, contentViewWithButton, menuItemModel, c16551);
                Logger.a(2, EntryType.UI_INPUT_END, 661088877, a);
            }
        });
        springScaleButton.a((TouchSpring) this.f15166j.get());
    }

    public static void m17594b(StructuredMenuItemController structuredMenuItemController, final ContentViewWithButton contentViewWithButton, final MenuItemModel menuItemModel, final C16551 c16551) {
        MenuItemModel a = MenuItemModel.a(menuItemModel);
        if (a == null) {
            structuredMenuItemController.f15161e.a(f15157a, "Trying to like null product");
            return;
        }
        boolean z;
        MutationRequest a2;
        Builder builder = new Builder();
        Builder builder2 = new Builder();
        builder2.a = a.b();
        builder2.b = a.c();
        builder2.c = a.d();
        builder2.d = a.cP_();
        builder2.e = a.j();
        builder2.f = a.k();
        builder = builder2;
        if (menuItemModel.c()) {
            z = false;
        } else {
            z = true;
        }
        builder.b = z;
        a = builder.a();
        c16551.m17597a(a);
        structuredMenuItemController.m17593a(contentViewWithButton, a, c16551);
        String d = menuItemModel.d();
        if (menuItemModel.c()) {
            PageProductUnlikeInputData a3 = new PageProductUnlikeInputData().a(d).a(PageProductUnlikeInputData.Context.AFTER_PARTY_POPULAR_AT_ANDROID);
            GraphQlQueryString menuItemUnlikeMutationString = new MenuItemUnlikeMutationString();
            menuItemUnlikeMutationString.a("input", a3);
            a2 = GraphQLRequest.a(menuItemUnlikeMutationString);
        } else {
            a2 = m17592a(d);
        }
        structuredMenuItemController.f15164h.a("task_key_mutate_like" + d, structuredMenuItemController.f15162f.a(a2, OfflineQueryBehavior.b), new AbstractDisposableFutureCallback<GraphQLResult<?>>(structuredMenuItemController) {
            final /* synthetic */ StructuredMenuItemController f15156d;

            protected final void m17591a(Throwable th) {
                StructuredMenuItemController.m17595c(this.f15156d, contentViewWithButton, menuItemModel, c16551);
            }
        });
    }

    private static MutationRequest m17592a(String str) {
        PageProductLikeInputData a = new PageProductLikeInputData().a(str).a(PageProductLikeInputData.Context.AFTER_PARTY_POPULAR_AT_ANDROID);
        GraphQlQueryString menuItemLikeMutationString = new MenuItemLikeMutationString();
        menuItemLikeMutationString.a("input", a);
        return GraphQLRequest.a(menuItemLikeMutationString);
    }

    public static void m17595c(StructuredMenuItemController structuredMenuItemController, ContentViewWithButton contentViewWithButton, MenuItemModel menuItemModel, C16551 c16551) {
        c16551.m17597a(MenuItemModel.a(menuItemModel));
        structuredMenuItemController.m17593a(contentViewWithButton, menuItemModel, c16551);
        structuredMenuItemController.f15165i.b(new ToastBuilder(menuItemModel.c() ? contentViewWithButton.getContext().getString(2131239094) : contentViewWithButton.getContext().getString(2131239093)));
    }
}
