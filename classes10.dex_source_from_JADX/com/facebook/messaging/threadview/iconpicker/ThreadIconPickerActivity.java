package com.facebook.messaging.threadview.iconpicker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.fbservice.ops.BlueServiceFragment;
import com.facebook.fbservice.ops.BlueServiceOperation.OnCompletedListener;
import com.facebook.fbservice.ops.BlueServiceOperation.State;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.messaging.media.mediapicker.dialog.CropImageParams;
import com.facebook.messaging.media.mediapicker.dialog.CropImageParamsBuilder;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogFragment;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogFragment.Listener;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogParams;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogParamsBuilder;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaSource;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.facebook.messaging.service.model.ModifyThreadParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;
import java.util.List;

/* compiled from: possible_join_approval_settings */
public class ThreadIconPickerActivity extends FbFragmentActivity implements AnalyticsActivity {
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AnalyticsLogger> f4718p = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ErrorDialogs> f4719q = UltralightRuntime.b;
    private BlueServiceFragment f4720r;
    private ThreadKey f4721s;
    private Listener f4722t = new C06541(this);

    /* compiled from: possible_join_approval_settings */
    class C06541 implements Listener {
        final /* synthetic */ ThreadIconPickerActivity f4716a;

        C06541(ThreadIconPickerActivity threadIconPickerActivity) {
            this.f4716a = threadIconPickerActivity;
        }

        public final void m4272a(List<MediaResource> list) {
            this.f4716a.m4279a((MediaResource) list.get(0));
        }

        public final void m4271a() {
            this.f4716a.finish();
        }

        public final void m4273b() {
            this.f4716a.finish();
        }
    }

    /* compiled from: possible_join_approval_settings */
    class C06552 extends OnCompletedListener {
        final /* synthetic */ ThreadIconPickerActivity f4717a;

        C06552(ThreadIconPickerActivity threadIconPickerActivity) {
            this.f4717a = threadIconPickerActivity;
        }

        public final void m4274a(OperationResult operationResult) {
            this.f4717a.finish();
        }

        public final void m4275a(ServiceException serviceException) {
            ErrorDialogs errorDialogs = (ErrorDialogs) this.f4717a.f4719q.get();
            ErrorDialogParamsBuilder b = ErrorDialogParams.a(this.f4717a.getResources()).a(2131230721).b(2131230762);
            b.i = this.f4717a;
            errorDialogs.a(b.l());
        }
    }

    private static <T extends Context> void m4280a(Class<T> cls, T t) {
        m4281a((Object) t, (Context) t);
    }

    public static void m4281a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ThreadIconPickerActivity) obj).m4277a(IdBasedSingletonScopeProvider.b(fbInjector, 175), IdBasedLazy.a(fbInjector, 3559));
    }

    public final void m4282a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof PickMediaDialogFragment) {
            ((PickMediaDialogFragment) fragment).aE = this.f4722t;
        }
    }

    public final String am_() {
        return "thread_icon";
    }

    public final void m4283b(Bundle bundle) {
        super.b(bundle);
        Class cls = ThreadIconPickerActivity.class;
        m4281a((Object) this, (Context) this);
        this.f4721s = (ThreadKey) getIntent().getParcelableExtra("threadKey");
        this.f4720r = BlueServiceFragment.a(this, "setPhotoOperation");
        this.f4720r.b = new C06552(this);
        this.f4720r.a(new DialogBasedProgressIndicator(this, 2131231505));
    }

    private void m4277a(com.facebook.inject.Lazy<AnalyticsLogger> lazy, com.facebook.inject.Lazy<ErrorDialogs> lazy2) {
        this.f4718p = lazy;
        this.f4719q = lazy2;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Intent intent = getIntent();
        if (intent.getBooleanExtra("remove", false)) {
            m4279a(null);
        } else if (bundle == null) {
            PickMediaSource pickMediaSource = (PickMediaSource) intent.getSerializableExtra("mediaSource");
            CropImageParamsBuilder cropImageParamsBuilder = new CropImageParamsBuilder();
            cropImageParamsBuilder.a = getResources().getDimensionPixelSize(2131428576);
            cropImageParamsBuilder = cropImageParamsBuilder;
            cropImageParamsBuilder.b = getResources().getDimensionPixelSize(2131428577);
            cropImageParamsBuilder = cropImageParamsBuilder;
            cropImageParamsBuilder.c = 1;
            cropImageParamsBuilder = cropImageParamsBuilder;
            cropImageParamsBuilder.d = 1;
            CropImageParams cropImageParams = new CropImageParams(cropImageParamsBuilder);
            PickMediaDialogParamsBuilder newBuilder = PickMediaDialogParams.newBuilder();
            newBuilder.a = pickMediaSource;
            PickMediaDialogParamsBuilder pickMediaDialogParamsBuilder = newBuilder;
            pickMediaDialogParamsBuilder.d = ImmutableSet.of(Type.PHOTO);
            pickMediaDialogParamsBuilder = pickMediaDialogParamsBuilder;
            pickMediaDialogParamsBuilder.b = cropImageParams;
            PickMediaDialogFragment a = PickMediaDialogFragment.a(pickMediaDialogParamsBuilder.j());
            a.aE = this.f4722t;
            a.a(kO_(), "pick_media_dialog");
        }
    }

    private void m4279a(MediaResource mediaResource) {
        if (this.f4720r.b() == State.INIT) {
            ModifyThreadParamsBuilder modifyThreadParamsBuilder = new ModifyThreadParamsBuilder();
            modifyThreadParamsBuilder.a = this.f4721s;
            ModifyThreadParams q = modifyThreadParamsBuilder.a(mediaResource).q();
            Bundle bundle = new Bundle();
            bundle.putParcelable("modifyThreadParams", q);
            this.f4720r.a("modify_thread", bundle);
            AnalyticsLogger analyticsLogger = (AnalyticsLogger) this.f4718p.get();
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("set");
            honeyClientEvent.c = am_();
            honeyClientEvent = honeyClientEvent.a("thread_key", this.f4721s);
            honeyClientEvent.d = "thread_image";
            analyticsLogger.a(honeyClientEvent);
        }
    }
}
