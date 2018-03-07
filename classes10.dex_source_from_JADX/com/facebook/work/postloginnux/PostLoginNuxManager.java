package com.facebook.work.postloginnux;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel;
import com.facebook.work.auth.request.protocol.FetchWorkCommunitiesFromPersonalAccountModels.FetchWorkCommunitiesFromPersonalAccountQueryModel.WorkCommunityModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: exception with filtering groups */
public class PostLoginNuxManager {
    private static final PrefKey f13028a;
    public static final PrefKey f13029b;
    public static final PrefKey f13030c = ((PrefKey) f13028a.a("skip_post_login_nuxes"));
    public static final CallerContext f13031d = CallerContext.a(PostLoginNuxManager.class, "unknown");
    public final FbSharedPreferences f13032e;
    public final AbstractFbErrorReporter f13033f;
    public final GraphQLQueryExecutor f13034g;
    public final Handler f13035h;
    public final FbDraweeControllerBuilder f13036i;
    public GraphQLQueryFuture<GraphQLResult<FetchWorkCommunitiesFromPersonalAccountQueryModel>> f13037j;
    public String f13038k = "";
    public String f13039l = "";

    /* compiled from: exception with filtering groups */
    public class C18151 implements FutureCallback<GraphQLResult<FetchWorkCommunitiesFromPersonalAccountQueryModel>> {
        final /* synthetic */ Activity f13021a;
        final /* synthetic */ PostLoginNuxManager f13022b;

        /* compiled from: exception with filtering groups */
        class C18141 implements Runnable {
            final /* synthetic */ C18151 f13020a;

            C18141(C18151 c18151) {
                this.f13020a = c18151;
            }

            public void run() {
                PostLoginNuxManager postLoginNuxManager = this.f13020a.f13022b;
                Context context = this.f13020a.f13021a;
                CharSequence charSequence = this.f13020a.f13022b.f13038k;
                Object obj = this.f13020a.f13022b.f13039l;
                if (StringUtil.a(charSequence) || StringUtil.a(obj)) {
                    postLoginNuxManager.f13033f.a(postLoginNuxManager.getClass().getSimpleName(), "Company name or logo was null");
                    postLoginNuxManager.m13104a();
                    return;
                }
                View inflate = LayoutInflater.from(context).inflate(2130906352, null);
                Button button = (Button) inflate.findViewById(2131566195);
                TextView textView = (TextView) inflate.findViewById(2131566193);
                TextView textView2 = (TextView) inflate.findViewById(2131566194);
                Resources resources = context.getResources();
                CharSequence string = resources.getString(2131241411);
                CharSequence string2 = resources.getString(2131241412, new Object[]{charSequence});
                textView.setText(string);
                textView2.setText(string2);
                FbDraweeView fbDraweeView = (FbDraweeView) inflate.findViewById(2131566192);
                fbDraweeView.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) postLoginNuxManager.f13036i.a(new C18162(postLoginNuxManager, fbDraweeView))).b(Uri.parse(obj)).a(PostLoginNuxManager.f13031d).b(fbDraweeView.getController())).s());
                AlertDialog a = new Builder(context).b(inflate).a(new C18173(postLoginNuxManager)).a();
                button.setOnClickListener(new C18184(postLoginNuxManager, a));
                a.show();
            }
        }

        public C18151(PostLoginNuxManager postLoginNuxManager, Activity activity) {
            this.f13022b = postLoginNuxManager;
            this.f13021a = activity;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((FetchWorkCommunitiesFromPersonalAccountQueryModel) graphQLResult.e).m13089a() != null) {
                WorkCommunityModel a = ((FetchWorkCommunitiesFromPersonalAccountQueryModel) graphQLResult.e).m13089a();
                this.f13022b.f13038k = a.m13065j();
                if (a.m13066k() != null) {
                    this.f13022b.f13039l = a.m13066k().m13057a();
                }
                if (!this.f13022b.f13038k.isEmpty() && !this.f13022b.f13039l.isEmpty()) {
                    HandlerDetour.a(this.f13022b.f13035h, new C18141(this), -1671294602);
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: exception with filtering groups */
    public class C18162 extends BaseControllerListener<ImageInfo> {
        final /* synthetic */ FbDraweeView f13023a;
        final /* synthetic */ PostLoginNuxManager f13024b;

        public C18162(PostLoginNuxManager postLoginNuxManager, FbDraweeView fbDraweeView) {
            this.f13024b = postLoginNuxManager;
            this.f13023a = fbDraweeView;
        }

        public final void m13102a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            CloseableImage closeableImage = (CloseableImage) obj;
            if (closeableImage != null) {
                this.f13023a.setAspectRatio((float) (closeableImage.f() / closeableImage.g()));
            }
        }
    }

    /* compiled from: exception with filtering groups */
    public class C18173 implements OnDismissListener {
        final /* synthetic */ PostLoginNuxManager f13025a;

        public C18173(PostLoginNuxManager postLoginNuxManager) {
            this.f13025a = postLoginNuxManager;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f13025a.m13104a();
        }
    }

    /* compiled from: exception with filtering groups */
    public class C18184 implements OnClickListener {
        final /* synthetic */ AlertDialog f13026a;
        final /* synthetic */ PostLoginNuxManager f13027b;

        public C18184(PostLoginNuxManager postLoginNuxManager, AlertDialog alertDialog) {
            this.f13027b = postLoginNuxManager;
            this.f13026a = alertDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -975402177);
            this.f13026a.dismiss();
            Logger.a(2, EntryType.UI_INPUT_END, -1763486253, a);
        }
    }

    public static PostLoginNuxManager m13103b(InjectorLike injectorLike) {
        return new PostLoginNuxManager((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("work_login/");
        f13028a = prefKey;
        f13029b = (PrefKey) prefKey.a("post_login_nux_seen");
    }

    @Inject
    public PostLoginNuxManager(FbSharedPreferences fbSharedPreferences, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, Handler handler, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f13032e = fbSharedPreferences;
        this.f13033f = abstractFbErrorReporter;
        this.f13034g = graphQLQueryExecutor;
        this.f13035h = handler;
        this.f13036i = fbDraweeControllerBuilder;
    }

    public final void m13104a() {
        this.f13032e.edit().putBoolean(f13029b, true).commit();
    }
}
