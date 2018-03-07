package com.facebook.katana.platform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.platform.PlatformAnalyticsEventBuilder;
import com.facebook.platform.common.PlatformAppResults;
import com.facebook.platform.common.action.AbstractPlatformActionExecutor;
import com.facebook.platform.common.action.PlatformAppCall;
import com.facebook.platform.composer.composer.PlatformComposerActivity;
import com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger;
import com.facebook.platform.server.handler.ParcelableString;
import com.facebook.platform.server.protocol.GetAppPermissionsMethod.Params;
import com.facebook.platform.server.protocol.GetAppPermissionsMethod.Result;
import com.facebook.platform.server.protocol.GetCanonicalProfileIdsMethod;
import com.facebook.platform.server.protocol.ResolveTaggableProfileIdsMethod;
import com.facebook.platformattribution.PlatformAttributionLaunchHelper;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: unexpected json error */
public abstract class BaseShareDialogExecutor extends AbstractPlatformActionExecutor {
    private static final Class<?> f1042k = BaseShareDialogExecutor.class;
    protected boolean f1043a;
    public final DefaultBlueServiceOperationFactory f1044b;
    protected final AnalyticsLogger f1045c;
    public final boolean f1046d;
    public final Activity f1047e;
    public final PlatformAppCall f1048f;
    public final Executor f1049g;
    public final ListeningExecutorService f1050h;
    protected final PlatformAttributionLaunchHelper f1051i;
    protected final PlatformComposerPerformanceLogger f1052j;
    public final int f1053l;
    public final SecureContextHelper f1054m;
    public boolean f1055n;
    public boolean f1056o;

    /* compiled from: unexpected json error */
    class C01661 implements FutureCallback<OperationResult> {
        final /* synthetic */ BaseShareDialogExecutor f1030a;

        C01661(BaseShareDialogExecutor baseShareDialogExecutor) {
            this.f1030a = baseShareDialogExecutor;
        }

        public void onSuccess(Object obj) {
            boolean z;
            Result result = (Result) ((OperationResult) obj).h();
            this.f1030a.f1055n = result.a;
            List list = result.b;
            BaseShareDialogExecutor baseShareDialogExecutor = this.f1030a;
            if (list.contains("publish_stream") || list.contains("publish_actions")) {
                z = true;
            } else {
                z = false;
            }
            baseShareDialogExecutor.f1056o = z;
        }

        public void onFailure(Throwable th) {
            this.f1030a.f1055n = false;
            this.f1030a.f1056o = false;
        }
    }

    /* compiled from: unexpected json error */
    public class C01672 implements FutureCallback<Builder> {
        final /* synthetic */ BaseShareDialogExecutor f1031a;

        public C01672(BaseShareDialogExecutor baseShareDialogExecutor) {
            this.f1031a = baseShareDialogExecutor;
        }

        public void onSuccess(Object obj) {
            Builder builder = (Builder) obj;
            ComposerTargetData composerTargetData = null;
            Preconditions.checkNotNull(builder);
            this.f1031a.f1051i.b("on_return_to_main_app", this.f1031a.f1048f.e, null);
            builder.setInitialAppAttribution(new ComposerAppAttribution(this.f1031a.f1048f.e, this.f1031a.f1048f.f, this.f1031a.f1048f.g, this.f1031a.f1048f.h));
            Bundle bundleExtra = this.f1031a.f1047e.getIntent().getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
            if (bundleExtra != null) {
                composerTargetData = (ComposerTargetData) bundleExtra.getParcelable("com.facebook.platform.target.DATA");
            }
            if (composerTargetData != null) {
                builder.setInitialTargetData(composerTargetData);
            }
            this.f1031a.f1054m.a(PlatformComposerActivity.a(this.f1031a.f1047e, this.f1031a.f1048f.j, builder.a(), true), this.f1031a.f1053l, this.f1031a.f1047e);
            this.f1031a.f1045c.c(this.f1031a.mo40b("platform_share_show_dialog").a());
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: unexpected json error */
    class C01705 implements Function<ArrayList<String>, ImmutableList<ComposerTaggedUser>> {
        final /* synthetic */ BaseShareDialogExecutor f1036a;

        C01705(BaseShareDialogExecutor baseShareDialogExecutor) {
            this.f1036a = baseShareDialogExecutor;
        }

        public Object apply(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            ImmutableList.Builder builder = ImmutableList.builder();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Long e = BaseShareDialogExecutor.m1078e((String) arrayList.get(i));
                if (e != null) {
                    builder.c(ComposerTaggedUser.a(e.longValue()).a());
                }
            }
            return builder.b();
        }

        public boolean equals(Object obj) {
            return false;
        }
    }

    /* compiled from: unexpected json error */
    public class C01716 implements Function<List<ArrayList<String>>, ArrayList<String>> {
        final /* synthetic */ BaseShareDialogExecutor f1037a;

        public C01716(BaseShareDialogExecutor baseShareDialogExecutor) {
            this.f1037a = baseShareDialogExecutor;
        }

        public Object apply(Object obj) {
            List<ArrayList> list = (List) obj;
            Collection hashSet = new HashSet();
            for (ArrayList arrayList : list) {
                if (arrayList != null) {
                    hashSet.addAll(arrayList);
                }
            }
            return new ArrayList(hashSet);
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    public abstract ListenableFuture<OperationResult> mo39a(Intent intent);

    protected PlatformAnalyticsEventBuilder mo40b(String str) {
        PlatformAnalyticsEventBuilder platformAnalyticsEventBuilder = new PlatformAnalyticsEventBuilder(str, "platform_native_share");
        platformAnalyticsEventBuilder.c = this.f1048f.e;
        return platformAnalyticsEventBuilder;
    }

    public BaseShareDialogExecutor(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, AnalyticsLogger analyticsLogger, Executor executor, Activity activity, int i, PlatformAppCall platformAppCall, boolean z, ListeningExecutorService listeningExecutorService, PlatformAttributionLaunchHelper platformAttributionLaunchHelper, PlatformComposerPerformanceLogger platformComposerPerformanceLogger, SecureContextHelper secureContextHelper) {
        this.f1053l = i;
        this.f1047e = activity;
        this.f1044b = defaultBlueServiceOperationFactory;
        this.f1045c = analyticsLogger;
        this.f1048f = platformAppCall;
        this.f1046d = z;
        this.f1049g = executor;
        this.f1050h = listeningExecutorService;
        this.f1051i = platformAttributionLaunchHelper;
        this.f1052j = platformComposerPerformanceLogger;
        this.f1054m = secureContextHelper;
    }

    public void mo42a(Bundle bundle) {
        if (bundle != null) {
            boolean z;
            if (bundle == null || !bundle.getBoolean("is_ui_showing")) {
                z = false;
            } else {
                z = true;
            }
            this.f1043a = z;
            this.f1055n = bundle.getBoolean("app_is_installed");
            this.f1056o = bundle.getBoolean("app_has_publish");
        }
        if (!this.f1043a) {
            this.f1043a = true;
            this.f1052j.a();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("app_info", new Params(this.f1048f.e));
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f1044b, "platform_get_app_permissions", bundle2, -1288610044).a(), new C01661(this), this.f1049g);
            ListenableFuture b = mo41b();
            if (b != null) {
                Futures.a(b, new C01672(this), this.f1049g);
            }
        }
    }

    protected final void m1083a(String str) {
        PlatformComposerPerformanceLogger platformComposerPerformanceLogger = this.f1052j;
        platformComposerPerformanceLogger.a.c(platformComposerPerformanceLogger.c);
        AnalyticsLogger analyticsLogger = this.f1045c;
        PlatformAnalyticsEventBuilder b = mo40b("platform_share_failed_with_error");
        b.f = str;
        analyticsLogger.c(b.a());
        c(PlatformAppResults.a(this.f1048f, "ApplicationError", str));
    }

    public ListenableFuture<Builder> mo41b() {
        return Futures.a(null);
    }

    public void mo43b(Bundle bundle) {
        bundle.putBoolean("is_ui_showing", this.f1043a);
        bundle.putBoolean("app_is_installed", this.f1055n);
        bundle.putBoolean("app_has_publish", this.f1056o);
    }

    public final void m1081a(int i, int i2, Intent intent) {
        if (i != this.f1053l) {
            return;
        }
        if (i2 == 0) {
            Object obj;
            if (intent == null || !(intent.hasExtra("com.facebook.platform.extra.COMPOSER_ERROR") || intent.hasExtra("com.facebook.platform.extra.COMPOSER_EXCEPTION"))) {
                obj = null;
            } else {
                obj = 1;
            }
            PlatformAppCall platformAppCall;
            if (obj != null) {
                Bundle a;
                AnalyticsLogger analyticsLogger = this.f1045c;
                PlatformAnalyticsEventBuilder b = mo40b("platform_share_failed_with_error");
                b.f = intent.getStringExtra("com.facebook.platform.extra.COMPOSER_ERROR");
                analyticsLogger.c(b.a((Throwable) intent.getSerializableExtra("com.facebook.platform.extra.COMPOSER_EXCEPTION")).a());
                platformAppCall = this.f1048f;
                if (intent.hasExtra("com.facebook.platform.extra.COMPOSER_ERROR") && intent.hasExtra("com.facebook.platform.extra.COMPOSER_EXCEPTION")) {
                    a = PlatformAppResults.a(platformAppCall, (Throwable) intent.getSerializableExtra("com.facebook.platform.extra.COMPOSER_EXCEPTION"), intent.getStringExtra("com.facebook.platform.extra.COMPOSER_ERROR"));
                } else if (intent.hasExtra("com.facebook.platform.extra.COMPOSER_EXCEPTION")) {
                    a = PlatformAppResults.a(platformAppCall, (Throwable) intent.getSerializableExtra("com.facebook.platform.extra.COMPOSER_EXCEPTION"), "An unknown error occurred.");
                } else {
                    a = PlatformAppResults.a(platformAppCall, "ApplicationError", intent.getStringExtra("com.facebook.platform.extra.COMPOSER_ERROR"));
                }
                c(a);
                return;
            }
            this.f1045c.c(mo40b("platform_share_cancel_dialog").a());
            platformAppCall = this.f1048f;
            boolean z = this.f1055n;
            boolean z2 = platformAppCall != null && platformAppCall.d();
            String str = z2 ? "didComplete" : "com.facebook.platform.extra.DID_COMPLETE";
            String str2 = z2 ? "completionGesture" : "com.facebook.platform.extra.COMPLETION_GESTURE";
            Bundle bundle = new Bundle();
            bundle.putBoolean(str, true);
            if (z) {
                bundle.putString(str2, "cancel");
            }
            d(bundle);
            return;
        }
        this.f1043a = false;
        ListenableFuture a2 = mo39a(intent);
        final DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(this.f1047e, 2131241488);
        dialogBasedProgressIndicator.a();
        Futures.a(a2, new FutureCallback<OperationResult>(this) {
            final /* synthetic */ BaseShareDialogExecutor f1033b;

            public void onSuccess(Object obj) {
                Object c;
                BaseShareDialogExecutor baseShareDialogExecutor;
                PlatformAppCall platformAppCall;
                boolean z;
                boolean z2;
                String str;
                String str2;
                String str3;
                Bundle bundle;
                OperationResult operationResult = (OperationResult) obj;
                this.f1033b.f1045c.c(this.f1033b.mo40b("platform_share_finished_publish").a());
                String str4 = operationResult.c;
                if (str4 == null) {
                    GraphQLStory graphQLStory = (GraphQLStory) operationResult.k();
                    if (graphQLStory != null) {
                        c = graphQLStory.c();
                        baseShareDialogExecutor = this.f1033b;
                        platformAppCall = this.f1033b.f1048f;
                        z = this.f1033b.f1055n;
                        z2 = this.f1033b.f1056o;
                        boolean z3 = platformAppCall == null && platformAppCall.d();
                        str = z3 ? "didComplete" : "com.facebook.platform.extra.DID_COMPLETE";
                        str2 = z3 ? "completionGesture" : "com.facebook.platform.extra.COMPLETION_GESTURE";
                        str3 = z3 ? "postId" : "com.facebook.platform.extra.POST_ID";
                        bundle = new Bundle();
                        bundle.putBoolean(str, true);
                        if (z) {
                            bundle.putString(str2, "post");
                        }
                        if (z2 && !StringUtil.a(c)) {
                            bundle.putString(str3, c);
                        }
                        baseShareDialogExecutor.d(bundle);
                        dialogBasedProgressIndicator.b();
                    }
                }
                String str5 = str4;
                baseShareDialogExecutor = this.f1033b;
                platformAppCall = this.f1033b.f1048f;
                z = this.f1033b.f1055n;
                z2 = this.f1033b.f1056o;
                if (platformAppCall == null) {
                }
                if (z3) {
                }
                if (z3) {
                }
                if (z3) {
                }
                bundle = new Bundle();
                bundle.putBoolean(str, true);
                if (z) {
                    bundle.putString(str2, "post");
                }
                bundle.putString(str3, c);
                baseShareDialogExecutor.d(bundle);
                dialogBasedProgressIndicator.b();
            }

            public void onFailure(Throwable th) {
                this.f1033b.f1045c.c(this.f1033b.mo40b("platform_share_failed_publish").a(th).a());
                this.f1033b.c(PlatformAppResults.a(this.f1033b.f1048f, th, "Error publishing message"));
                dialogBasedProgressIndicator.b();
            }
        }, this.f1049g);
    }

    public final ListenableFuture<Builder> m1080a(ArrayList<String> arrayList, final Builder builder) {
        if (arrayList.isEmpty()) {
            return Futures.a(builder);
        }
        return Futures.a(m1076a((ArrayList) arrayList), new Function<ImmutableList<ComposerTaggedUser>, Builder>(this) {
            final /* synthetic */ BaseShareDialogExecutor f1035b;

            public Object apply(@Nullable Object obj) {
                ImmutableList immutableList = (ImmutableList) obj;
                if (!(immutableList == null || immutableList.isEmpty())) {
                    builder.setInitialTaggedUsers(immutableList);
                }
                return builder;
            }

            public boolean equals(@Nullable Object obj) {
                return false;
            }
        }, this.f1049g);
    }

    private ListenableFuture<ImmutableList<ComposerTaggedUser>> m1076a(ArrayList<String> arrayList) {
        ListenableFuture a;
        if (arrayList == null || arrayList.isEmpty()) {
            a = Futures.a(new ArrayList());
        } else {
            final ArrayList arrayList2 = new ArrayList();
            final ArrayList arrayList3 = new ArrayList();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                String str = (String) arrayList.get(i);
                if (m1078e(str) != null) {
                    arrayList2.add(str);
                } else {
                    arrayList3.add(str);
                }
            }
            Iterable arrayList4 = new ArrayList();
            if (!arrayList2.isEmpty()) {
                arrayList4.add(this.f1050h.a(new Callable<ArrayList<String>>(this) {
                    final /* synthetic */ BaseShareDialogExecutor f1041b;

                    public Object call() {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("app_scoped_ids", new GetCanonicalProfileIdsMethod.Params(arrayList2));
                        try {
                            HashMap j = ((OperationResult) FutureDetour.a(BlueServiceOperationFactoryDetour.a(this.f1041b.f1044b, "platform_get_canonical_profile_ids", bundle, ErrorPropagation.BY_EXCEPTION, null, -1875409473).a(), 1914575573)).j();
                            ArrayList arrayList = new ArrayList();
                            for (ParcelableString a : j.values()) {
                                arrayList.add(a.a());
                            }
                            return arrayList;
                        } catch (Exception e) {
                            this.f1041b.m1083a(e.getMessage());
                            return null;
                        }
                    }
                }));
            }
            if (!arrayList3.isEmpty()) {
                arrayList4.add(this.f1050h.a(new Callable<ArrayList<String>>(this) {
                    final /* synthetic */ BaseShareDialogExecutor f1039b;

                    public Object call() {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("taggable_ids", new ResolveTaggableProfileIdsMethod.Params(arrayList3));
                        try {
                            HashMap j = ((OperationResult) FutureDetour.a(BlueServiceOperationFactoryDetour.a(this.f1039b.f1044b, "platform_resolve_taggable_profile_ids", bundle, ErrorPropagation.BY_EXCEPTION, null, 1394026575).a(), -297672492)).j();
                            ArrayList arrayList = new ArrayList();
                            for (ParcelableString a : j.values()) {
                                arrayList.add(a.a());
                            }
                            return arrayList;
                        } catch (Exception e) {
                            this.f1039b.m1083a(e.getMessage());
                            return null;
                        }
                    }
                }));
            }
            a = Futures.a(Futures.b(arrayList4), new C01716(this), this.f1050h);
        }
        return Futures.a(a, new C01705(this), this.f1049g);
    }

    public static Long m1078e(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static CheckinPlaceModel m1077c(String str) {
        try {
            Long.parseLong(str);
            return new CheckinPlaceModel.Builder().a(str).a();
        } catch (Exception e) {
            return null;
        }
    }
}
