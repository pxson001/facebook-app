package com.facebook.growth.nux.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.api.growth.profile.SetProfilePhotoParams;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.camera.activity.CameraActivity;
import com.facebook.camera.ipc.CameraIntentBuilder;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.growth.nux.GrowthNUXConstants;
import com.facebook.growth.nux.NUXFragment;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.katana.activity.media.DefaultPhotoIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.status.NuxStepListener;
import com.facebook.photos.intent.IPhotoIntentBuilder;
import com.facebook.registration.activity.RegistrationLoginActivity.9;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.ActionSheetDialogBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: p2p_settings_contact_us_tap */
public class NUXProfilePhotoFragment extends NUXFragment {
    private static final Class<?> f7452h = NUXProfilePhotoFragment.class;
    @Inject
    public DefaultBlueServiceOperationFactory f7453a;
    public long al;
    public boolean am;
    public 9 an;
    public boolean ao = true;
    @Inject
    public CameraIntentBuilder f7454b;
    @Inject
    @IsWorkBuild
    Boolean f7455c;
    @Inject
    @LoggedInUserId
    Provider<String> f7456d;
    @Inject
    public IPhotoIntentBuilder f7457e;
    @Inject
    public SecureContextHelper f7458f;
    @Inject
    ActivityRuntimePermissionsManagerProvider f7459g;
    private ActivityRuntimePermissionsManager f7460i;

    /* compiled from: p2p_settings_contact_us_tap */
    class C08131 implements OnClickListener {
        final /* synthetic */ NUXProfilePhotoFragment f7442a;

        C08131(NUXProfilePhotoFragment nUXProfilePhotoFragment) {
            this.f7442a = nUXProfilePhotoFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -760292220);
            this.f7442a.m7779b();
            Logger.a(2, EntryType.UI_INPUT_END, 2031099743, a);
        }
    }

    /* compiled from: p2p_settings_contact_us_tap */
    class C08142 implements OnClickListener {
        final /* synthetic */ NUXProfilePhotoFragment f7443a;

        C08142(NUXProfilePhotoFragment nUXProfilePhotoFragment) {
            this.f7443a = nUXProfilePhotoFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1558072235);
            NUXProfilePhotoFragment.ar(this.f7443a);
            Logger.a(2, EntryType.UI_INPUT_END, 37871235, a);
        }
    }

    /* compiled from: p2p_settings_contact_us_tap */
    class C08153 implements OnClickListener {
        final /* synthetic */ NUXProfilePhotoFragment f7444a;

        C08153(NUXProfilePhotoFragment nUXProfilePhotoFragment) {
            this.f7444a = nUXProfilePhotoFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -882694705);
            NUXProfilePhotoFragment nUXProfilePhotoFragment = this.f7444a;
            ActionSheetDialogBuilder actionSheetDialogBuilder = new ActionSheetDialogBuilder(nUXProfilePhotoFragment.getContext());
            Resources resources = nUXProfilePhotoFragment.getContext().getResources();
            actionSheetDialogBuilder.a(resources.getString(2131236358), new C08175(nUXProfilePhotoFragment));
            actionSheetDialogBuilder.a(resources.getString(2131236359), new C08186(nUXProfilePhotoFragment));
            actionSheetDialogBuilder.show();
            Logger.a(2, EntryType.UI_INPUT_END, 126618853, a);
        }
    }

    /* compiled from: p2p_settings_contact_us_tap */
    class C08164 implements OnClickListener {
        final /* synthetic */ NUXProfilePhotoFragment f7445a;

        C08164(NUXProfilePhotoFragment nUXProfilePhotoFragment) {
            this.f7445a = nUXProfilePhotoFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 847614171);
            this.f7445a.m7779b();
            Logger.a(2, EntryType.UI_INPUT_END, -1539603954, a);
        }
    }

    /* compiled from: p2p_settings_contact_us_tap */
    public class C08175 implements DialogInterface.OnClickListener {
        final /* synthetic */ NUXProfilePhotoFragment f7446a;

        public C08175(NUXProfilePhotoFragment nUXProfilePhotoFragment) {
            this.f7446a = nUXProfilePhotoFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            NUXProfilePhotoFragment.ar(this.f7446a);
        }
    }

    /* compiled from: p2p_settings_contact_us_tap */
    public class C08186 implements DialogInterface.OnClickListener {
        final /* synthetic */ NUXProfilePhotoFragment f7447a;

        public C08186(NUXProfilePhotoFragment nUXProfilePhotoFragment) {
            this.f7447a = nUXProfilePhotoFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7447a.m7779b();
        }
    }

    /* compiled from: p2p_settings_contact_us_tap */
    class C08197 extends AbstractRuntimePermissionsListener {
        final /* synthetic */ NUXProfilePhotoFragment f7448a;

        C08197(NUXProfilePhotoFragment nUXProfilePhotoFragment) {
            this.f7448a = nUXProfilePhotoFragment;
        }

        public final void m7770a() {
            NUXProfilePhotoFragment nUXProfilePhotoFragment = this.f7448a;
            CameraIntentBuilder c = nUXProfilePhotoFragment.f7454b.b(true).c(true);
            c.b = nUXProfilePhotoFragment.o();
            c = c.d(true);
            c.c = nUXProfilePhotoFragment.al;
            nUXProfilePhotoFragment.f7458f.a(c.a(1).a(), 421, nUXProfilePhotoFragment);
            nUXProfilePhotoFragment.am = false;
        }
    }

    public static void m7774a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NUXProfilePhotoFragment) obj).m7773a(DefaultBlueServiceOperationFactory.b(fbInjector), CameraIntentBuilder.b(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 4442), (IPhotoIntentBuilder) DefaultPhotoIntentBuilder.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (ActivityRuntimePermissionsManagerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class));
    }

    private void m7773a(BlueServiceOperationFactory blueServiceOperationFactory, CameraIntentBuilder cameraIntentBuilder, Boolean bool, Provider<String> provider, IPhotoIntentBuilder iPhotoIntentBuilder, SecureContextHelper secureContextHelper, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider) {
        this.f7453a = blueServiceOperationFactory;
        this.f7454b = cameraIntentBuilder;
        this.f7455c = bool;
        this.f7456d = provider;
        this.f7457e = iPhotoIntentBuilder;
        this.f7458f = secureContextHelper;
        this.f7459g = activityRuntimePermissionsManagerProvider;
    }

    public final void m7780c(Bundle bundle) {
        super.c(bundle);
        Class cls = NUXProfilePhotoFragment.class;
        m7774a((Object) this, getContext());
        this.f7460i = this.f7459g.a(o());
        if (StringUtil.a((CharSequence) this.f7456d.get())) {
            this.al = -1;
        } else {
            this.al = Long.parseLong((String) this.f7456d.get());
        }
    }

    public final View m7777a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1991631049);
        ViewGroup frameLayout = new FrameLayout(o());
        m7772a(layoutInflater, frameLayout);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 722918832, a);
        return frameLayout;
    }

    public final void m7778a(int i, int i2, Intent intent) {
        if (i == 422 || i == 423) {
            if (i2 == -1) {
                m7775b(intent);
            }
        } else if (i != 421) {
            BLog.b(f7452h, "Unexpected request code received %s", new Object[]{String.valueOf(i)});
        } else if (i2 == 5) {
            Uri i3 = CameraActivity.i();
            if (i3 == null || i3.getPath() == null) {
                at(this);
                return;
            }
            this.f7458f.a(this.f7457e.a(i3.getPath()), 422, this);
        }
    }

    public final void m7776I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 336462712);
        this.f7457e = null;
        this.f7458f = null;
        this.f7453a = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1366163192, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m7772a(LayoutInflater.from(o()), (ViewGroup) this.T);
    }

    private void m7772a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Object obj;
        viewGroup.removeAllViewsInLayout();
        View inflate = layoutInflater.inflate(2130904433, viewGroup, true);
        ((TextView) inflate.findViewById(2131562184)).setText(this.f7455c.booleanValue() ? 2131236357 : 2131236356);
        ImageView imageView = (ImageView) inflate.findViewById(2131562185);
        ((Button) inflate.findViewById(2131562187)).setOnClickListener(new C08131(this));
        Button button = (Button) inflate.findViewById(2131562186);
        button.setOnClickListener(new C08142(this));
        PackageManager packageManager = getContext().getPackageManager();
        if (packageManager.hasSystemFeature("android.hardware.camera") || packageManager.hasSystemFeature("android.hardware.camera.front")) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            button.setVisibility(0);
            imageView.setOnClickListener(new C08153(this));
            return;
        }
        button.setVisibility(8);
        imageView.setOnClickListener(new C08164(this));
    }

    protected final void m7779b() {
        this.f7458f.a(SimplePickerIntent.a(getContext(), new Builder(SimplePickerSource.PROFILEPIC_NUX).k().h().i().a(Action.LAUNCH_PROFILE_PIC_CROPPER)), 423, this);
        this.am = true;
    }

    public static void ar(NUXProfilePhotoFragment nUXProfilePhotoFragment) {
        nUXProfilePhotoFragment.f7460i.a(GrowthNUXConstants.f7403a, new C08197(nUXProfilePhotoFragment));
    }

    private void m7775b(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey(EditGalleryIpcBundle.a)) {
            at(this);
            return;
        }
        EditGalleryIpcBundle editGalleryIpcBundle = (EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a);
        if (editGalleryIpcBundle == null || editGalleryIpcBundle.b == null) {
            at(this);
            return;
        }
        if (this.an != null) {
            this.an.a(editGalleryIpcBundle.b.getPath());
        }
        if (this.ao) {
            String path = editGalleryIpcBundle.b.getPath();
            final DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(getContext(), 2131236363);
            dialogBasedProgressIndicator.a();
            final File file = new File(path);
            Parcelable setProfilePhotoParams = new SetProfilePhotoParams(this.al, path, "nux", this.am ? "upload" : "camera");
            Bundle bundle = new Bundle();
            bundle.putParcelable("growthSetProfilePhotoParams", setProfilePhotoParams);
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f7453a, "growth_set_profile_photo", bundle, -484066545).a(), new FutureCallback<OperationResult>(this) {
                final /* synthetic */ NUXProfilePhotoFragment f7451c;

                public void onFailure(Throwable th) {
                    m7771b();
                    NUXProfilePhotoFragment.at(this.f7451c);
                }

                public void onSuccess(Object obj) {
                    m7771b();
                    if (this.f7451c.an != null) {
                        9 9 = this.f7451c.an;
                    }
                    if (this.f7451c.o() instanceof NuxStepListener) {
                        ((NuxStepListener) this.f7451c.o()).b("upload_profile_pic");
                    }
                }

                private void m7771b() {
                    file.delete();
                    dialogBasedProgressIndicator.b();
                }
            });
        }
    }

    public static void at(NUXProfilePhotoFragment nUXProfilePhotoFragment) {
        Toaster.a(nUXProfilePhotoFragment.getContext(), 2131236364);
    }
}
