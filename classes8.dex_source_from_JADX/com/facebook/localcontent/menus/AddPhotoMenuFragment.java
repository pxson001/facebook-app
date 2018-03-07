package com.facebook.localcontent.menus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.localcontent.menus.PhotoMenuUploadLauncher.C16381;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ec_intro_animation */
public class AddPhotoMenuFragment extends FbFragment {
    @Inject
    public PhotoMenuUploadLauncher f14947a;
    private String f14948b;
    private ViewerContext f14949c;
    public Button f14950d;
    public Button f14951e;

    /* compiled from: ec_intro_animation */
    public class C16181 implements OnClickListener {
        final /* synthetic */ AddPhotoMenuFragment f14945a;

        public C16181(AddPhotoMenuFragment addPhotoMenuFragment) {
            this.f14945a = addPhotoMenuFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 951389084);
            PhotoMenuUploadLauncher photoMenuUploadLauncher = this.f14945a.f14947a;
            Context context = this.f14945a.getContext();
            photoMenuUploadLauncher.f15058b.a(SimplePickerIntent.a(context, new Builder(SimplePickerSource.PHOTO_MENU_UPLOAD).k().i().a(Action.NONE)), 26002, (Activity) ContextUtils.a(context, Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, 520140277, a);
        }
    }

    /* compiled from: ec_intro_animation */
    public class C16192 implements OnClickListener {
        final /* synthetic */ AddPhotoMenuFragment f14946a;

        public C16192(AddPhotoMenuFragment addPhotoMenuFragment) {
            this.f14946a = addPhotoMenuFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -190682153);
            PhotoMenuUploadLauncher photoMenuUploadLauncher = this.f14946a.f14947a;
            Activity activity = (Activity) ContextUtils.a(this.f14946a.getContext(), Activity.class);
            photoMenuUploadLauncher.f15057a.a(activity).a(new String[]{"android.permission.CAMERA"}, new C16381(photoMenuUploadLauncher, activity));
            Logger.a(2, EntryType.UI_INPUT_END, 49097852, a);
        }
    }

    public static void m17418a(Object obj, Context context) {
        ((AddPhotoMenuFragment) obj).f14947a = PhotoMenuUploadLauncher.m17481a(FbInjector.get(context));
    }

    public final void m17422c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AddPhotoMenuFragment.class;
        m17418a((Object) this, getContext());
        this.f14948b = this.s.getString("com.facebook.katana.profile.id");
        this.f14949c = (ViewerContext) this.s.getParcelable("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT");
    }

    public final View m17419a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1354194196);
        View inflate = layoutInflater.inflate(2130903164, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1107799790, a);
        return inflate;
    }

    public final void m17421a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f14950d = (Button) e(2131559367);
        this.f14951e = (Button) e(2131559368);
        this.f14950d.setOnClickListener(new C16181(this));
        this.f14951e.setOnClickListener(new C16192(this));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1689243170);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239109);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 778983588, a);
    }

    public final void m17420a(int i, int i2, Intent intent) {
        if (i2 != -1) {
            return;
        }
        if (i == 26001) {
            o().onBackPressed();
            return;
        }
        Object obj = (i == 26003 || i == 26002) ? 1 : null;
        if (obj != null) {
            this.f14947a.m17484a(i, (Fragment) this, Long.valueOf(this.f14948b), this.f14949c, intent);
        }
    }
}
