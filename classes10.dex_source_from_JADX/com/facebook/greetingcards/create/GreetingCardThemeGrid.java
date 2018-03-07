package com.facebook.greetingcards.create;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.querybuilder.common.ScaleInputPixelRatio;
import com.facebook.greetingcards.create.FetchThemePreviewGraphQL.FetchThemePreviewQueryString;
import com.facebook.greetingcards.create.FetchThemePreviewGraphQLModels.FetchThemePreviewQueryModel;
import com.facebook.greetingcards.create.FetchThemePreviewGraphQLModels.FetchThemePreviewQueryModel.TemplatePreviewImagesModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: {events_creation_story_cache_id} */
public class GreetingCardThemeGrid extends TableLayout {
    private Provider<FbDraweeControllerBuilder> f100a;
    private GraphQLQueryExecutor f101b;
    private Executor f102c;
    public String f103d;
    public String f104e;
    private final HashMap<String, View> f105f = Maps.c();

    /* compiled from: {events_creation_story_cache_id} */
    class C00182 implements FutureCallback<GraphQLResult<FetchThemePreviewQueryModel>> {
        final /* synthetic */ GreetingCardThemeGrid f99a;

        C00182(GreetingCardThemeGrid greetingCardThemeGrid) {
            this.f99a = greetingCardThemeGrid;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f99a.f103d = ((FetchThemePreviewQueryModel) graphQLResult.e).m46j();
            GreetingCardThemeGrid.setupCells(this.f99a, ((FetchThemePreviewQueryModel) graphQLResult.e).m47k());
        }

        public void onFailure(Throwable th) {
            BLog.b(getClass(), "Error loading themes", th);
        }
    }

    private static <T extends View> void m117a(Class<T> cls, T t) {
        m118a((Object) t, t.getContext());
    }

    private static void m118a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GreetingCardThemeGrid) obj).m119a(IdBasedProvider.a(fbInjector, 1117), GraphQLQueryExecutor.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    @Inject
    private void m119a(Provider<FbDraweeControllerBuilder> provider, GraphQLQueryExecutor graphQLQueryExecutor, Executor executor) {
        this.f100a = provider;
        this.f101b = graphQLQueryExecutor;
        this.f102c = executor;
    }

    public GreetingCardThemeGrid(Context context) {
        super(context);
        m115a();
    }

    public GreetingCardThemeGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m115a();
    }

    private void m115a() {
        m117a(GreetingCardThemeGrid.class, (View) this);
    }

    private FbDraweeView m113a(final String str, String str2) {
        FbDraweeView fbDraweeView = new FbDraweeView(getContext());
        fbDraweeView.setAspectRatio(1.0f);
        fbDraweeView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GreetingCardThemeGrid f98b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -372878500);
                this.f98b.setSelectedTheme(str);
                Logger.a(2, EntryType.UI_INPUT_END, -156308052, a);
            }
        });
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getContext().getResources());
        genericDraweeHierarchyBuilder.f = new ColorDrawable(-3355444);
        fbDraweeView.setHierarchy(genericDraweeHierarchyBuilder.f(getContext().getResources().getDrawable(2130840771)).u());
        fbDraweeView.setController(((FbDraweeControllerBuilder) this.f100a.get()).a(str2).a(CallerContext.a(getClass(), "greeting_cards")).s());
        return fbDraweeView;
    }

    public final void m120a(String str) {
        ScaleInputPixelRatio a = GraphQlQueryDefaults.a();
        GraphQlQueryString fetchThemePreviewQueryString = new FetchThemePreviewQueryString();
        fetchThemePreviewQueryString.a("scale", a).a("rootID", str);
        Futures.a(this.f101b.a(GraphQLRequest.a(fetchThemePreviewQueryString).a(GraphQLCachePolicy.a).a(604800)), new C00182(this), this.f102c);
    }

    public String getSelectedTheme() {
        return this.f104e;
    }

    public String getTemplateId() {
        return this.f103d;
    }

    public void setSelectedTheme(String str) {
        View view = (View) this.f105f.get(str);
        if (view != null) {
            view.setSelected(true);
            View view2 = (View) this.f105f.get(this.f104e);
            if (!(view2 == null || view2 == view)) {
                view2.setSelected(false);
            }
        }
        this.f104e = str;
    }

    public static void setupCells(GreetingCardThemeGrid greetingCardThemeGrid, ImmutableList immutableList) {
        greetingCardThemeGrid.removeAllViews();
        View tableRow = new TableRow(greetingCardThemeGrid.getContext());
        LayoutParams layoutParams = new TableLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        tableRow.setLayoutParams(layoutParams);
        LayoutParams layoutParams2 = new TableRow.LayoutParams(-1, -2);
        int dimensionPixelSize = greetingCardThemeGrid.getResources().getDimensionPixelSize(2131434014);
        layoutParams2.setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        layoutParams2.weight = 1.0f;
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            TemplatePreviewImagesModel templatePreviewImagesModel = (TemplatePreviewImagesModel) immutableList.get(i);
            FbDraweeView a = greetingCardThemeGrid.m113a(templatePreviewImagesModel.m39j(), templatePreviewImagesModel.m38a().m34a());
            a.setLayoutParams(layoutParams2);
            tableRow.addView(a);
            greetingCardThemeGrid.f105f.put(templatePreviewImagesModel.m39j(), a);
            dimensionPixelSize = i2 + 1;
            if (dimensionPixelSize == 3) {
                greetingCardThemeGrid.addView(tableRow);
                View tableRow2 = new TableRow(greetingCardThemeGrid.getContext());
                tableRow2.setLayoutParams(layoutParams);
                tableRow = tableRow2;
                dimensionPixelSize = 0;
            }
            i++;
            i2 = dimensionPixelSize;
        }
        if (i2 > 0) {
            for (dimensionPixelSize = i2; dimensionPixelSize < 3; dimensionPixelSize++) {
                View view = new View(greetingCardThemeGrid.getContext());
                view.setLayoutParams(layoutParams2);
                tableRow.addView(view);
            }
            greetingCardThemeGrid.addView(tableRow);
        }
        if (greetingCardThemeGrid.f104e != null && greetingCardThemeGrid.f105f.containsKey(greetingCardThemeGrid.f104e)) {
            ((View) greetingCardThemeGrid.f105f.get(greetingCardThemeGrid.f104e)).setSelected(true);
        } else if (!immutableList.isEmpty()) {
            greetingCardThemeGrid.setSelectedTheme(((TemplatePreviewImagesModel) immutableList.get(0)).m39j());
        }
    }
}
