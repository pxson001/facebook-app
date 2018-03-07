package com.facebook.growth.nux.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.api.growth.profile.SetProfilePhotoParams;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.camera.activity.CameraActivity;
import com.facebook.camera.ipc.CameraIntentBuilder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.growth.nux.NUXFragment;
import com.facebook.growth.util.DeviceOwnerProfilePhotoUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
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
import com.facebook.photos.upload.disk.NoDiskSpaceException;
import com.facebook.photos.upload.disk.TempFiles;
import com.facebook.photos.upload.disk.UploadTempFileManager;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: p2p_set_pin */
public class NUXProfilePhotoImportGoogleFragment extends NUXFragment {
    public static final CallerContext an = CallerContext.a(NUXProfilePhotoImportGoogleFragment.class);
    private static final Class<?> ao = NUXProfilePhotoImportGoogleFragment.class;
    @Inject
    @LoggedInUser
    Provider<User> f7479a;
    @Inject
    Toaster al;
    @Inject
    Lazy<UploadTempFileManager> am;
    private String ap;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f7480b;
    @Inject
    DeviceOwnerProfilePhotoUtil f7481c;
    @Inject
    Provider<FbDraweeControllerBuilder> f7482d;
    @Inject
    public IPhotoIntentBuilder f7483e;
    @Inject
    CameraIntentBuilder f7484f;
    @Inject
    public SecureContextHelper f7485g;
    @Inject
    TasksManager f7486h;
    @Inject
    DefaultBlueServiceOperationFactory f7487i;

    /* compiled from: p2p_set_pin */
    class C08222 implements OnClickListener {
        final /* synthetic */ NUXProfilePhotoImportGoogleFragment f7466a;

        C08222(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment) {
            this.f7466a = nUXProfilePhotoImportGoogleFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -651067254);
            NUXProfilePhotoImportGoogleFragment.m7790b(this.f7466a, view);
            Logger.a(2, EntryType.UI_INPUT_END, 768499838, a);
        }
    }

    /* compiled from: p2p_set_pin */
    class C08233 implements OnClickListener {
        final /* synthetic */ NUXProfilePhotoImportGoogleFragment f7467a;

        C08233(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment) {
            this.f7467a = nUXProfilePhotoImportGoogleFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1744305276);
            NUXProfilePhotoImportGoogleFragment.as(this.f7467a);
            Logger.a(2, EntryType.UI_INPUT_END, 537107549, a);
        }
    }

    /* compiled from: p2p_set_pin */
    class C08244 implements OnClickListener {
        final /* synthetic */ NUXProfilePhotoImportGoogleFragment f7468a;

        C08244(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment) {
            this.f7468a = nUXProfilePhotoImportGoogleFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -634986882);
            NUXProfilePhotoImportGoogleFragment.ar(this.f7468a);
            Logger.a(2, EntryType.UI_INPUT_END, -870930866, a);
        }
    }

    /* compiled from: p2p_set_pin */
    class C08287 implements OnMenuItemClickListener {
        final /* synthetic */ NUXProfilePhotoImportGoogleFragment f7475a;

        C08287(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment) {
            this.f7475a = nUXProfilePhotoImportGoogleFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            NUXProfilePhotoImportGoogleFragment.as(this.f7475a);
            return true;
        }
    }

    /* compiled from: p2p_set_pin */
    class C08298 implements OnMenuItemClickListener {
        final /* synthetic */ NUXProfilePhotoImportGoogleFragment f7476a;

        C08298(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment) {
            this.f7476a = nUXProfilePhotoImportGoogleFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            NUXProfilePhotoImportGoogleFragment.ar(this.f7476a);
            return true;
        }
    }

    public static void m7788a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NUXProfilePhotoImportGoogleFragment) obj).m7789a(IdBasedProvider.a(fbInjector, 3595), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), DeviceOwnerProfilePhotoUtil.b(fbInjector), IdBasedProvider.a(fbInjector, 1117), (IPhotoIntentBuilder) DefaultPhotoIntentBuilder.a(fbInjector), CameraIntentBuilder.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), TasksManager.b(fbInjector), DefaultBlueServiceOperationFactory.b(fbInjector), Toaster.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 9458));
    }

    private void m7789a(Provider<User> provider, ListeningExecutorService listeningExecutorService, DeviceOwnerProfilePhotoUtil deviceOwnerProfilePhotoUtil, Provider<FbDraweeControllerBuilder> provider2, IPhotoIntentBuilder iPhotoIntentBuilder, CameraIntentBuilder cameraIntentBuilder, SecureContextHelper secureContextHelper, TasksManager tasksManager, BlueServiceOperationFactory blueServiceOperationFactory, Toaster toaster, Lazy<UploadTempFileManager> lazy) {
        this.f7479a = provider;
        this.f7480b = listeningExecutorService;
        this.f7481c = deviceOwnerProfilePhotoUtil;
        this.f7482d = provider2;
        this.f7483e = iPhotoIntentBuilder;
        this.f7484f = cameraIntentBuilder;
        this.f7485g = secureContextHelper;
        this.f7486h = tasksManager;
        this.f7487i = blueServiceOperationFactory;
        this.al = toaster;
        this.am = lazy;
    }

    public final void m7797c(Bundle bundle) {
        super.c(bundle);
        this.ap = SafeUUIDGenerator.a().toString();
        Class cls = NUXProfilePhotoImportGoogleFragment.class;
        m7788a((Object) this, getContext());
    }

    public final View m7794a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 176445339);
        View inflate = layoutInflater.inflate(2130904435, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1937777797, a);
        return inflate;
    }

    public final void m7796a(View view, Bundle bundle) {
        super.a(view, bundle);
        FbDraweeView fbDraweeView = (FbDraweeView) e(2131562188);
        Button button = (Button) e(2131562190);
        Button button2 = (Button) e(2131562191);
        ((TextView) e(2131562189)).setText(((User) this.f7479a.get()).j());
        Resources resources = getContext().getResources();
        final Uri a = this.f7481c.a();
        if (a != null) {
            button.setText(resources.getString(2131230730).toUpperCase(resources.getConfiguration().locale));
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NUXProfilePhotoImportGoogleFragment f7465b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -36944573);
                    NUXProfilePhotoImportGoogleFragment.m7786a(this.f7465b, a);
                    Logger.a(2, EntryType.UI_INPUT_END, 1019870990, a);
                }
            });
            button2.setText(2131236362);
            button2.setOnClickListener(new C08222(this));
        } else {
            button.setText(2131236358);
            button.setOnClickListener(new C08233(this));
            button2.setText(2131236359);
            button2.setOnClickListener(new C08244(this));
            if (m7792e()) {
                button.setVisibility(0);
            } else {
                button.setVisibility(8);
            }
        }
        fbDraweeView.a(a, an);
    }

    public final void m7795a(int i, int i2, Intent intent) {
        if (i == 422 || i == 423) {
            if (i2 == -1) {
                Bundle extras = intent.getExtras();
                if (extras == null || !extras.containsKey(EditGalleryIpcBundle.a)) {
                    at(this);
                } else {
                    EditGalleryIpcBundle editGalleryIpcBundle = (EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a);
                    if (editGalleryIpcBundle == null || editGalleryIpcBundle.b == null) {
                        at(this);
                    } else {
                        m7791b(this, editGalleryIpcBundle.b.getPath());
                    }
                }
            }
        } else if (i != 421) {
            BLog.b(ao, "Unexpected request code received %s", new Object[]{String.valueOf(i)});
        } else if (i2 == 5) {
            Uri i3 = CameraActivity.i();
            if (i3 == null || i3.getPath() == null) {
                at(this);
                return;
            }
            this.f7485g.a(this.f7483e.a(i3.getPath()), 422, this);
        }
    }

    public final void m7793I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1943416085);
        this.f7486h.c();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1013015526, a);
    }

    private boolean m7792e() {
        PackageManager packageManager = getContext().getPackageManager();
        return packageManager.hasSystemFeature("android.hardware.camera") || packageManager.hasSystemFeature("android.hardware.camera.front");
    }

    public static void m7786a(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment, final Uri uri) {
        final String aq = nUXProfilePhotoImportGoogleFragment.aq();
        if (aq == null) {
            at(nUXProfilePhotoImportGoogleFragment);
        } else {
            nUXProfilePhotoImportGoogleFragment.f7486h.a(null, new Callable<ListenableFuture<?>>(nUXProfilePhotoImportGoogleFragment) {
                final /* synthetic */ NUXProfilePhotoImportGoogleFragment f7472c;

                /* compiled from: p2p_set_pin */
                class C08251 implements Callable<Void> {
                    final /* synthetic */ C08265 f7469a;

                    C08251(C08265 c08265) {
                        this.f7469a = c08265;
                    }

                    public Object call() {
                        NUXProfilePhotoImportGoogleFragment.m7787a(this.f7469a.f7472c, uri, aq);
                        return null;
                    }
                }

                public Object call() {
                    return this.f7472c.f7480b.a(new C08251(this));
                }
            }, new AbstractDisposableFutureCallback<Void>(nUXProfilePhotoImportGoogleFragment) {
                final /* synthetic */ NUXProfilePhotoImportGoogleFragment f7474b;

                protected final void m7784a(@Nullable Object obj) {
                    NUXProfilePhotoImportGoogleFragment.m7791b(this.f7474b, aq);
                }

                protected final void m7785a(Throwable th) {
                    NUXProfilePhotoImportGoogleFragment.at(this.f7474b);
                }
            });
        }
    }

    public static void m7787a(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment, Uri uri, String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        InputStream inputStream = null;
        Preconditions.checkNotNull(str);
        try {
            InputStream createInputStream = nUXProfilePhotoImportGoogleFragment.getContext().getContentResolver().openAssetFileDescriptor(uri, "r").createInputStream();
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    ByteStreams.a(createInputStream, fileOutputStream);
                    if (createInputStream != null) {
                        try {
                            createInputStream.close();
                        } catch (Throwable e2) {
                            BLog.b(ao, "failed to close Google picture temp file input stream", e2);
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e22) {
                        BLog.b(ao, "failed to close Google picture destination file output stream", e22);
                    }
                } catch (Throwable th) {
                    e22 = th;
                    inputStream = createInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3) {
                            BLog.b(ao, "failed to close Google picture temp file input stream", e3);
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            BLog.b(ao, "failed to close Google picture destination file output stream", e4);
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                fileOutputStream = null;
                inputStream = createInputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e22;
            }
        } catch (Throwable th3) {
            e22 = th3;
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
    }

    @Nullable
    private String aq() {
        UploadTempFileManager uploadTempFileManager = (UploadTempFileManager) this.am.get();
        File a = uploadTempFileManager.a(ao.getSimpleName(), this.ap);
        if (a != null) {
            return a.getPath();
        }
        try {
            TempFiles a2 = uploadTempFileManager.a(ao.getSimpleName(), 5242880, 1048576);
            if (a2 == null) {
                return null;
            }
            return a2.b().getPath();
        } catch (NoDiskSpaceException e) {
            return null;
        }
    }

    public static void ar(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment) {
        nUXProfilePhotoImportGoogleFragment.f7485g.a(SimplePickerIntent.a(nUXProfilePhotoImportGoogleFragment.getContext(), new Builder(SimplePickerSource.PROFILEPIC_NUX).k().h().i().a(Action.LAUNCH_PROFILE_PIC_CROPPER)), 423, nUXProfilePhotoImportGoogleFragment);
    }

    public static void as(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment) {
        CameraIntentBuilder c = nUXProfilePhotoImportGoogleFragment.f7484f.b(true).c(true);
        c.b = nUXProfilePhotoImportGoogleFragment.ao();
        CameraIntentBuilder d = c.d(true);
        d.c = Long.parseLong(((User) nUXProfilePhotoImportGoogleFragment.f7479a.get()).a);
        nUXProfilePhotoImportGoogleFragment.f7485g.a(d.a(1).a(), 421, nUXProfilePhotoImportGoogleFragment);
    }

    public static void m7790b(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment, View view) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(nUXProfilePhotoImportGoogleFragment.getContext());
        PopoverMenu c = figPopoverMenuWindow.c();
        Resources resources = nUXProfilePhotoImportGoogleFragment.getContext().getResources();
        if (nUXProfilePhotoImportGoogleFragment.m7792e()) {
            c.a(resources.getString(2131236358)).setOnMenuItemClickListener(new C08287(nUXProfilePhotoImportGoogleFragment));
        }
        c.a(resources.getString(2131236359)).setOnMenuItemClickListener(new C08298(nUXProfilePhotoImportGoogleFragment));
        figPopoverMenuWindow.a(view);
    }

    public static void m7791b(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment, final String str) {
        final DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(nUXProfilePhotoImportGoogleFragment.getContext(), 2131236363);
        dialogBasedProgressIndicator.a();
        Parcelable setProfilePhotoParams = new SetProfilePhotoParams(Long.parseLong(((User) nUXProfilePhotoImportGoogleFragment.f7479a.get()).a), str);
        final Bundle bundle = new Bundle();
        bundle.putParcelable("growthSetProfilePhotoParams", setProfilePhotoParams);
        nUXProfilePhotoImportGoogleFragment.f7486h.a(null, new Callable<ListenableFuture<OperationResult>>(nUXProfilePhotoImportGoogleFragment) {
            final /* synthetic */ NUXProfilePhotoImportGoogleFragment f7478b;

            public Object call() {
                return BlueServiceOperationFactoryDetour.a(this.f7478b.f7487i, "growth_set_profile_photo", bundle, ErrorPropagation.BY_ERROR_CODE, NUXProfilePhotoImportGoogleFragment.an, 98107190).a();
            }
        }, new AbstractDisposableFutureCallback<OperationResult>(nUXProfilePhotoImportGoogleFragment) {
            final /* synthetic */ NUXProfilePhotoImportGoogleFragment f7463c;

            protected final void m7782a(Object obj) {
                m7781d();
                if (this.f7463c.ao() instanceof NuxStepListener) {
                    ((NuxStepListener) this.f7463c.ao()).b("upload_profile_pic");
                }
            }

            protected final void m7783a(Throwable th) {
                m7781d();
                NUXProfilePhotoImportGoogleFragment.at(this.f7463c);
            }

            private void m7781d() {
                new File(str).delete();
                dialogBasedProgressIndicator.b();
            }
        });
    }

    public static void at(NUXProfilePhotoImportGoogleFragment nUXProfilePhotoImportGoogleFragment) {
        nUXProfilePhotoImportGoogleFragment.al.b(new ToastBuilder(2131236364));
    }
}
