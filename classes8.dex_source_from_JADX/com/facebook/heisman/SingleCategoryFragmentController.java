package com.facebook.heisman;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Filter.FilterListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.heisman.ProfilePictureOverlayPivotQueryExecutor.C00951;
import com.facebook.heisman.ProfilePictureOverlayPivotQueryExecutor.C00962;
import com.facebook.heisman.SingleCategoryFragment.SingleCategoryFragmentDelegate;
import com.facebook.heisman.intent.ProfilePictureOverlayPivotIntentData;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryFieldsModel;
import com.facebook.heisman.protocol.ProfileOverlayPagesByCategoryGraphQL.ProfileOverlayPagesCategoryQueryString;
import com.facebook.heisman.protocol.ProfileOverlayPagesByImageOverlayGraphQL.ProfileOverlayPagesByImageOverlayQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.State;
import com.facebook.widget.loadingindicator.LoadingIndicatorState;
import com.facebook.widget.loadingindicator.LoadingIndicatorState.Builder;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: user_clicked_to_expand */
public class SingleCategoryFragmentController {
    @Inject
    @ForUiThread
    volatile Provider<Executor> f781a = UltralightRuntime.a;
    @Inject
    volatile Provider<ProfilePictureOverlayPivotQueryExecutor> f782b = UltralightRuntime.a;
    public final Activity f783c;
    public final SingleCategoryFragmentDelegate f784d;
    public final FbEditText f785e;
    public final ImageButton f786f;
    public final LoadingIndicatorView f787g;
    public final BetterRecyclerView f788h;
    public final ProfilePictureOverlayPivotIntentData f789i;
    @Inject
    public ProfilePictureOverlayAnalyticsLogger f790j;
    @Inject
    public ProfilePictureOverlayPivotAdapterProvider f791k;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f792l = UltralightRuntime.b;
    private final TextWatcher f793m = new C00981(this);
    private final OnClickListener f794n = new C00992(this);
    public FilterListener f795o;
    public ProfilePictureOverlayPivotAdapter f796p;
    public int f797q;

    /* compiled from: user_clicked_to_expand */
    class C00981 implements TextWatcher {
        final /* synthetic */ SingleCategoryFragmentController f775a;

        /* compiled from: user_clicked_to_expand */
        class C00971 implements FilterListener {
            final /* synthetic */ C00981 f774a;

            C00971(C00981 c00981) {
                this.f774a = c00981;
            }

            public void onFilterComplete(int i) {
                this.f774a.f775a.f796p.notifyDataSetChanged();
            }
        }

        C00981(SingleCategoryFragmentController singleCategoryFragmentController) {
            this.f775a = singleCategoryFragmentController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f775a.f796p != null) {
                if (this.f775a.f795o == null) {
                    this.f775a.f795o = new C00971(this);
                }
                this.f775a.f796p.getFilter().filter(charSequence, this.f775a.f795o);
                if (StringUtil.a(charSequence)) {
                    this.f775a.f786f.setVisibility(8);
                } else {
                    this.f775a.f786f.setVisibility(0);
                }
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: user_clicked_to_expand */
    class C00992 implements OnClickListener {
        final /* synthetic */ SingleCategoryFragmentController f776a;

        C00992(SingleCategoryFragmentController singleCategoryFragmentController) {
            this.f776a = singleCategoryFragmentController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1785773671);
            this.f776a.f785e.setText("");
            Logger.a(2, EntryType.UI_INPUT_END, 1188560192, a);
        }
    }

    /* compiled from: user_clicked_to_expand */
    class C01003 implements RetryClickedListener {
        final /* synthetic */ SingleCategoryFragmentController f777a;

        C01003(SingleCategoryFragmentController singleCategoryFragmentController) {
            this.f777a = singleCategoryFragmentController;
        }

        public final void m815a() {
            SingleCategoryFragmentController.m820b(this.f777a);
        }
    }

    /* compiled from: user_clicked_to_expand */
    class C01014 implements RetryClickedListener {
        final /* synthetic */ SingleCategoryFragmentController f778a;

        C01014(SingleCategoryFragmentController singleCategoryFragmentController) {
            this.f778a = singleCategoryFragmentController;
        }

        public final void m816a() {
            SingleCategoryFragmentController.m821c(this.f778a);
        }
    }

    @Inject
    public SingleCategoryFragmentController(@Assisted Activity activity, @Assisted SingleCategoryFragmentDelegate singleCategoryFragmentDelegate, @Assisted FrameLayout frameLayout, @Assisted LoadingIndicatorView loadingIndicatorView, @Assisted BetterRecyclerView betterRecyclerView, @Assisted ProfilePictureOverlayPivotIntentData profilePictureOverlayPivotIntentData) {
        this.f783c = activity;
        this.f784d = singleCategoryFragmentDelegate;
        this.f785e = (FbEditText) frameLayout.findViewById(2131560492);
        this.f786f = (ImageButton) frameLayout.findViewById(2131560324);
        this.f787g = loadingIndicatorView;
        this.f788h = betterRecyclerView;
        this.f789i = profilePictureOverlayPivotIntentData;
        frameLayout.setVisibility(0);
        this.f785e.setHint(2131238442);
        this.f785e.addTextChangedListener(this.f793m);
        this.f786f.setOnClickListener(this.f794n);
    }

    public static void m820b(SingleCategoryFragmentController singleCategoryFragmentController) {
        ProfilePictureOverlayPivotQueryExecutor profilePictureOverlayPivotQueryExecutor = (ProfilePictureOverlayPivotQueryExecutor) singleCategoryFragmentController.f782b.get();
        singleCategoryFragmentController.f787g.a();
        String str = singleCategoryFragmentController.f789i.b;
        GraphQLRequest a = GraphQLRequest.a((ProfileOverlayPagesByImageOverlayQueryString) new ProfileOverlayPagesByImageOverlayQueryString().a("image_overlay_id", str).a("page_logo_size", Integer.valueOf(GraphQlQueryDefaults.c())).a("image_high_width", profilePictureOverlayPivotQueryExecutor.f768c.x())).a(RequestPriority.INTERACTIVE);
        a.f = ProfilePictureOverlayPivotQueryExecutor.f765a;
        singleCategoryFragmentController.m819a(Futures.a(profilePictureOverlayPivotQueryExecutor.f767b.a(a.a(GraphQLCachePolicy.a).a(3600)), new C00951(profilePictureOverlayPivotQueryExecutor, str), DirectExecutor.INSTANCE), new C01003(singleCategoryFragmentController));
    }

    public static void m821c(SingleCategoryFragmentController singleCategoryFragmentController) {
        ProfilePictureOverlayPivotQueryExecutor profilePictureOverlayPivotQueryExecutor = (ProfilePictureOverlayPivotQueryExecutor) singleCategoryFragmentController.f782b.get();
        singleCategoryFragmentController.f787g.a();
        String str = singleCategoryFragmentController.f789i.c;
        GraphQlQueryString profileOverlayPagesCategoryQueryString = new ProfileOverlayPagesCategoryQueryString();
        profileOverlayPagesCategoryQueryString.a("category_id", str).a("page_logo_size", Integer.valueOf(GraphQlQueryDefaults.c())).a("image_high_width", profilePictureOverlayPivotQueryExecutor.f768c.x());
        GraphQLRequest a = GraphQLRequest.a(profileOverlayPagesCategoryQueryString).a(RequestPriority.INTERACTIVE);
        a.f = ProfilePictureOverlayPivotQueryExecutor.f765a;
        singleCategoryFragmentController.m819a(Futures.a(profilePictureOverlayPivotQueryExecutor.f767b.a(a.a(GraphQLCachePolicy.a).a(3600)), new C00962(profilePictureOverlayPivotQueryExecutor, str), DirectExecutor.INSTANCE), new C01014(singleCategoryFragmentController));
    }

    private void m819a(ListenableFuture<ProfileOverlayCategoryFieldsModel> listenableFuture, final RetryClickedListener retryClickedListener) {
        Futures.a(listenableFuture, new AbstractDisposableFutureCallback<ProfileOverlayCategoryFieldsModel>(this) {
            final /* synthetic */ SingleCategoryFragmentController f780b;

            protected final void m817a(Object obj) {
                ProfileOverlayCategoryFieldsModel profileOverlayCategoryFieldsModel = (ProfileOverlayCategoryFieldsModel) obj;
                if (profileOverlayCategoryFieldsModel.k() != null) {
                    this.f780b.f784d.mo17b(profileOverlayCategoryFieldsModel.k().a());
                }
                ImmutableList a = profileOverlayCategoryFieldsModel.j().a();
                this.f780b.f797q = a.size();
                this.f780b.f796p = new ProfilePictureOverlayPivotAdapter(a, this.f780b, LayoutInflaterMethodAutoProvider.b(this.f780b.f791k));
                ProfileOverlayPageRecyclerViewInitializer.m646a(this.f780b.f788h, this.f780b.f796p, this.f780b.f783c);
                this.f780b.f787g.b();
            }

            protected final void m818a(Throwable th) {
                if (!(th instanceof IOException)) {
                    ((AbstractFbErrorReporter) this.f780b.f792l.get()).a("pivot_load_failed", th);
                }
                Builder newBuilder = LoadingIndicatorState.newBuilder();
                newBuilder.a = State.ERROR;
                newBuilder = newBuilder;
                newBuilder.b = this.f780b.f783c.getString(2131230758);
                this.f780b.f787g.a(newBuilder.a(), retryClickedListener);
            }
        }, (Executor) this.f781a.get());
    }

    final void m822a(Provider<Executor> provider, Provider<ProfilePictureOverlayPivotQueryExecutor> provider2, ProfilePictureOverlayAnalyticsLogger profilePictureOverlayAnalyticsLogger, ProfilePictureOverlayPivotAdapterProvider profilePictureOverlayPivotAdapterProvider, com.facebook.inject.Lazy<FbErrorReporter> lazy) {
        this.f781a = provider;
        this.f782b = provider2;
        this.f790j = profilePictureOverlayAnalyticsLogger;
        this.f791k = profilePictureOverlayPivotAdapterProvider;
        this.f792l = lazy;
    }
}
