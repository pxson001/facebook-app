package com.facebook.katana.platform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.platform.common.PlatformAppResults;
import com.facebook.platform.common.action.AbstractPlatformActionExecutor;
import com.facebook.platform.common.action.PlatformAppCall;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.inject.Inject;

/* compiled from: typeahead_logger_data_state */
public class LegacyShareDialogActionExecutor extends AbstractPlatformActionExecutor {
    protected boolean f1087a;
    private final Activity f1088b;
    private final ComposerPublishServiceHelper f1089c;
    private final ComposerLauncher f1090d;
    private final ComposerConfigurationFactory f1091e;
    public final PlatformAppCall f1092f;
    public final CheckinPlaceModel f1093g;
    public final ImmutableList<ComposerTaggedUser> f1094h;
    public final String f1095i;

    @Inject
    public LegacyShareDialogActionExecutor(@Assisted Activity activity, @Assisted PlatformActivityLegacyShareDialogRequest platformActivityLegacyShareDialogRequest, ComposerPublishServiceHelper composerPublishServiceHelper, ComposerLauncher composerLauncher, ComposerConfigurationFactory composerConfigurationFactory) {
        this.f1088b = activity;
        this.f1089c = composerPublishServiceHelper;
        this.f1090d = composerLauncher;
        this.f1091e = composerConfigurationFactory;
        this.f1092f = platformActivityLegacyShareDialogRequest.a;
        this.f1093g = m1118a(platformActivityLegacyShareDialogRequest.f1126b);
        this.f1094h = m1119a((List) platformActivityLegacyShareDialogRequest.f1127c);
        this.f1095i = platformActivityLegacyShareDialogRequest.f1128d;
    }

    public final void m1122b(Bundle bundle) {
        bundle.putBoolean("is_ui_showing", this.f1087a);
    }

    public final void m1120a(int i, int i2, Intent intent) {
        if (i != 51) {
            return;
        }
        if (i2 == 0) {
            c(PlatformAppResults.a(this.f1092f, "User canceled message"));
            return;
        }
        this.f1087a = false;
        ListenableFuture c = this.f1089c.c(intent);
        final DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(this.f1088b, 2131241488);
        dialogBasedProgressIndicator.a();
        Futures.a(c, new FutureCallback<OperationResult>(this) {
            final /* synthetic */ LegacyShareDialogActionExecutor f1086b;

            public void onSuccess(Object obj) {
                this.f1086b.d(new Bundle());
                dialogBasedProgressIndicator.b();
            }

            public void onFailure(Throwable th) {
                this.f1086b.c(PlatformAppResults.a(this.f1086b.f1092f, th));
                dialogBasedProgressIndicator.b();
            }
        });
    }

    public final void m1121a(Bundle bundle) {
        boolean z;
        if (bundle == null || !bundle.getBoolean("is_ui_showing")) {
            z = false;
        } else {
            z = true;
        }
        this.f1087a = z;
        if (!this.f1087a) {
            this.f1087a = true;
            ComposerLauncher composerLauncher = this.f1090d;
            Builder nectarModule = ComposerConfigurationFactory.a(ComposerSourceSurface.THIRD_PARTY_APP_VIA_FB_API, "legacyShareDialogActionExecutor").setNectarModule("platform_composer");
            if (this.f1093g != null) {
                nectarModule.setInitialLocationInfo(ComposerLocationInfo.newBuilder().b(this.f1093g).b());
            }
            if (!this.f1094h.isEmpty()) {
                nectarModule.setInitialTaggedUsers(this.f1094h);
            }
            if (!StringUtil.a(this.f1095i)) {
                nectarModule.setInitialShareParams(ComposerShareParams.Builder.a(this.f1095i).b());
            }
            composerLauncher.a(null, nectarModule.a(), 51, this.f1088b);
        }
    }

    private static ImmutableList<ComposerTaggedUser> m1119a(List<String> list) {
        ImmutableList.Builder builder = ImmutableList.builder();
        try {
            for (String parseLong : list) {
                builder.c(ComposerTaggedUser.a(Long.parseLong(parseLong)).a());
            }
            return builder.b();
        } catch (NumberFormatException e) {
            return ImmutableList.of();
        }
    }

    private static CheckinPlaceModel m1118a(String str) {
        try {
            Long.parseLong(str);
            return new CheckinPlaceModel.Builder().a(str).a();
        } catch (Exception e) {
            return null;
        }
    }
}
