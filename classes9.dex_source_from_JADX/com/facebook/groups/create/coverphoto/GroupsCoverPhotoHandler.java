package com.facebook.groups.create.coverphoto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.groups.create.coverphoto.event.GroupCoverPhotoUpdateEvent;
import com.facebook.groups.create.coverphoto.event.GroupCoverPhotoUpdateEventBus;
import com.facebook.groups.create.protocol.GroupCreationActionHandler;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;
import java.io.File;
import javax.inject.Inject;

/* compiled from: peer_first_name */
public class GroupsCoverPhotoHandler {
    private final DefaultAndroidThreadUtil f6771a;
    public final GroupCoverPhotoUpdateEventBus f6772b;
    private final GroupCreationActionHandler f6773c;
    private final SecureContextHelper f6774d;
    public final Toaster f6775e;

    public static GroupsCoverPhotoHandler m7091b(InjectorLike injectorLike) {
        return new GroupsCoverPhotoHandler(DefaultAndroidThreadUtil.b(injectorLike), GroupCoverPhotoUpdateEventBus.m7098a(injectorLike), GroupCreationActionHandler.m7117b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), Toaster.b(injectorLike));
    }

    @Inject
    public GroupsCoverPhotoHandler(DefaultAndroidThreadUtil defaultAndroidThreadUtil, GroupCoverPhotoUpdateEventBus groupCoverPhotoUpdateEventBus, GroupCreationActionHandler groupCreationActionHandler, SecureContextHelper secureContextHelper, Toaster toaster) {
        this.f6771a = defaultAndroidThreadUtil;
        this.f6772b = groupCoverPhotoUpdateEventBus;
        this.f6773c = groupCreationActionHandler;
        this.f6774d = secureContextHelper;
        this.f6775e = toaster;
    }

    public static GroupsCoverPhotoHandler m7090a(InjectorLike injectorLike) {
        return m7091b(injectorLike);
    }

    public final void m7094a(String str, Uri uri, FutureCallback<String> futureCallback) {
        SettableFuture f = SettableFuture.f();
        this.f6773c.m7119a(str, uri, f, null, false);
        this.f6775e.a(new ToastBuilder(2131239957));
        this.f6771a.a(f, futureCallback);
    }

    public final void m7093a(String str, final Uri uri) {
        m7094a(str, uri, new FutureCallback<String>(this) {
            final /* synthetic */ GroupsCoverPhotoHandler f6770b;

            public void onSuccess(Object obj) {
                String str = (String) obj;
                this.f6770b.f6775e.a(new ToastBuilder(2131238095));
                Uri uri = uri;
                if (!(uri == null || StringUtil.a(uri.getPath()))) {
                    File file = new File(uri.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                }
                this.f6770b.f6772b.a(new GroupCoverPhotoUpdateEvent(str));
            }

            public void onFailure(Throwable th) {
            }
        });
    }

    public final void m7092a(Context context, int i) {
        Builder a = new Builder(SimplePickerSource.GROUP).h().i().k().a(Action.LAUNCH_COVER_PIC_CROPPER);
        Intent intent = new Intent(context, SimplePickerLauncherActivity.class);
        intent.putExtra("extra_simple_picker_launcher_settings", a.r());
        this.f6774d.a(intent, i, (Activity) ContextUtils.a(context, Activity.class));
    }
}
