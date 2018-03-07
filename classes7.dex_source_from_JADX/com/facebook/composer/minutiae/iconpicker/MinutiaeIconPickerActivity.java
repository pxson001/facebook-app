package com.facebook.composer.minutiae.iconpicker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQL.FetchTaggableActivityForOldIconPickerString;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeIcon;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityIconsModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.error.GenericErrorView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: tooltipBody */
public class MinutiaeIconPickerActivity extends FbFragmentActivity {
    private static final String f1529p = MinutiaeIconPickerActivity.class.getSimpleName();
    public View f1530q;
    public GenericErrorView f1531r;
    public GraphQLQueryExecutor f1532s;
    public DefaultAndroidThreadUtil f1533t;

    /* compiled from: tooltipBody */
    class C01431 implements OnClickListener {
        final /* synthetic */ MinutiaeIconPickerActivity f1524a;

        C01431(MinutiaeIconPickerActivity minutiaeIconPickerActivity) {
            this.f1524a = minutiaeIconPickerActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 317407792);
            this.f1524a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1957230553, a);
        }
    }

    /* compiled from: tooltipBody */
    class C01442 extends OnToolbarButtonListener {
        final /* synthetic */ MinutiaeIconPickerActivity f1525a;

        C01442(MinutiaeIconPickerActivity minutiaeIconPickerActivity) {
            this.f1525a = minutiaeIconPickerActivity;
        }

        public final void m1584a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            MinutiaeObject minutiaeObject = (MinutiaeObject) this.f1525a.getIntent().getParcelableExtra("minutiae_object");
            Intent intent = new Intent();
            intent.putExtra("minutiae_object", minutiaeObject);
            this.f1525a.setResult(-1, intent);
            this.f1525a.finish();
        }
    }

    private static <T extends Context> void m1591a(Class<T> cls, T t) {
        m1592a((Object) t, (Context) t);
    }

    public static void m1592a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MinutiaeIconPickerActivity minutiaeIconPickerActivity = (MinutiaeIconPickerActivity) obj;
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        DefaultAndroidThreadUtil b = DefaultAndroidThreadUtil.b(fbInjector);
        minutiaeIconPickerActivity.f1532s = a;
        minutiaeIconPickerActivity.f1533t = b;
    }

    public final void m1595b(Bundle bundle) {
        super.b(bundle);
        Class cls = MinutiaeIconPickerActivity.class;
        m1592a((Object) this, (Context) this);
        setContentView(2130903706);
        this.f1530q = a(2131559308);
        this.f1531r = (GenericErrorView) a(2131560576);
        this.f1530q.setVisibility(0);
        this.f1531r.setVisibility(8);
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setTitle(getString(2131234671));
        fbTitleBar.a(new C01431(this));
        if (getIntent().getBooleanExtra("is_skippable", false)) {
            Builder a = TitleBarButtonSpec.a();
            a.g = getResources().getString(2131230751);
            fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
            fbTitleBar.setOnToolbarButtonListener(new C01442(this));
        }
        ArrayList arrayList = (ArrayList) FlatBufferModelHelper.b(getIntent(), "icons");
        MinutiaeObject minutiaeObject = (MinutiaeObject) getIntent().getParcelableExtra("minutiae_object");
        if (arrayList == null || arrayList.isEmpty()) {
            m1590a(minutiaeObject);
        } else {
            m1593a(arrayList, minutiaeObject);
        }
    }

    private void m1593a(ArrayList<? extends MinutiaeIcon> arrayList, MinutiaeObject minutiaeObject) {
        this.f1530q.setVisibility(8);
        this.f1531r.setVisibility(8);
        FragmentTransaction a = kO_().a();
        MinutiaeIconPickerFragment minutiaeIconPickerFragment = new MinutiaeIconPickerFragment();
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "custom_icons", (List) Preconditions.checkNotNull(arrayList));
        bundle.putParcelable("minutiae_object", (Parcelable) Preconditions.checkNotNull(minutiaeObject));
        minutiaeIconPickerFragment.g(bundle);
        a = a.b(2131558429, minutiaeIconPickerFragment);
        if (!kO_().g()) {
            a.c();
        }
    }

    private void m1590a(final MinutiaeObject minutiaeObject) {
        GraphQlQueryParamSet graphQlQueryParamSet = new GraphQlQueryParamSet();
        graphQlQueryParamSet.a("image_scale", GraphQlQueryDefaults.a());
        graphQlQueryParamSet.a("minutiae_image_size_large", "32");
        graphQlQueryParamSet.a("taggable_activity_id", minutiaeObject.verb.l());
        this.f1533t.a(this.f1532s.a(GraphQLRequest.a(new FetchTaggableActivityForOldIconPickerString()).a(GraphQLCachePolicy.a).a(1209600).a(graphQlQueryParamSet)), new AbstractDisposableFutureCallback<GraphQLResult<MinutiaeTaggableActivityIconsModel>>(this) {
            final /* synthetic */ MinutiaeIconPickerActivity f1528b;

            /* compiled from: tooltipBody */
            class C01451 implements OnClickListener {
                final /* synthetic */ C01463 f1526a;

                C01451(C01463 c01463) {
                    this.f1526a = c01463;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 916506987);
                    this.f1526a.f1528b.m1590a(minutiaeObject);
                    Logger.a(2, EntryType.UI_INPUT_END, 1894634925, a);
                }
            }

            protected final void m1585a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult.e == null || ((MinutiaeTaggableActivityIconsModel) graphQLResult.e).a() == null || ((MinutiaeTaggableActivityIconsModel) graphQLResult.e).a().a() == null) {
                    m1586a(new IOException("Unexpected null results from Graphql"));
                }
                this.f1528b.m1593a(Lists.a(((MinutiaeTaggableActivityIconsModel) graphQLResult.e).a().a()), minutiaeObject);
            }

            protected final void m1586a(Throwable th) {
                this.f1528b.f1530q.setVisibility(8);
                this.f1528b.f1531r.setVisibility(0);
                if (ErrorCodeUtil.a(th) == ErrorCode.CONNECTION_FAILURE) {
                    this.f1528b.f1531r.m19992a();
                } else {
                    this.f1528b.f1531r.m19993b();
                }
                this.f1528b.f1531r.setOnClickListener(new C01451(this));
            }
        });
    }
}
