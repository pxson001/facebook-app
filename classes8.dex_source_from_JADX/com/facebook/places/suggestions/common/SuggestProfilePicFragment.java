package com.facebook.places.suggestions.common;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import java.io.File;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: secondary */
public class SuggestProfilePicFragment extends FbFragment {
    private static final CallerContext f3787a = CallerContext.a(SuggestProfilePicFragment.class, "place_home");
    public boolean al = false;
    private View am;
    private Button an;
    public long ao = 0;
    private Uri ap = null;
    public CrowdsourcingSource aq;
    public CrowdEntryPoint ar;
    public CrowdEndpoint as;
    private final OnClickListener at = new C04821(this);
    @Nullable
    public PhotoListener f3788b;
    private SecureContextHelper f3789c;
    private Toaster f3790d;
    private SimpleExecutor f3791e;
    private FbDraweeControllerBuilder f3792f;
    public FbDraweeView f3793g;
    public PhotoItem f3794h;
    public boolean f3795i = false;

    /* compiled from: secondary */
    public interface PhotoListener {
        void mo195c();
    }

    /* compiled from: secondary */
    class C04821 implements OnClickListener {
        final /* synthetic */ SuggestProfilePicFragment f3782a;

        C04821(SuggestProfilePicFragment suggestProfilePicFragment) {
            this.f3782a = suggestProfilePicFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1411028922);
            if (this.f3782a.f3794h == null || SuggestProfilePicFragment.ar(this.f3782a)) {
                this.f3782a.m3668b();
                Logger.a(2, EntryType.UI_INPUT_END, 911022609, a);
                return;
            }
            this.f3782a.f3793g.showContextMenu();
            LogUtils.a(-1171362996, a);
        }
    }

    /* compiled from: secondary */
    class C04832 implements Callable<Void> {
        final /* synthetic */ SuggestProfilePicFragment f3783a;

        C04832(SuggestProfilePicFragment suggestProfilePicFragment) {
            this.f3783a = suggestProfilePicFragment;
        }

        public Object call() {
            return null;
        }
    }

    /* compiled from: secondary */
    class C04843 implements FutureCallback<Void> {
        final /* synthetic */ SuggestProfilePicFragment f3784a;

        C04843(SuggestProfilePicFragment suggestProfilePicFragment) {
            this.f3784a = suggestProfilePicFragment;
        }

        public void onSuccess(Object obj) {
            SuggestProfilePicConfirmationFragment suggestProfilePicConfirmationFragment = new SuggestProfilePicConfirmationFragment();
            suggestProfilePicConfirmationFragment.a(this.f3784a, -1);
            suggestProfilePicConfirmationFragment.a(this.f3784a.s(), "dialog");
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: secondary */
    public class SuggestProfilePicConfirmationFragment extends DialogFragment {

        /* compiled from: secondary */
        class C04851 implements DialogInterface.OnClickListener {
            final /* synthetic */ SuggestProfilePicConfirmationFragment f3785a;

            C04851(SuggestProfilePicConfirmationFragment suggestProfilePicConfirmationFragment) {
                this.f3785a = suggestProfilePicConfirmationFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                ((SuggestProfilePicFragment) this.f3785a.t).m3673e();
            }
        }

        /* compiled from: secondary */
        class C04862 implements DialogInterface.OnClickListener {
            final /* synthetic */ SuggestProfilePicConfirmationFragment f3786a;

            C04862(SuggestProfilePicConfirmationFragment suggestProfilePicConfirmationFragment) {
                this.f3786a = suggestProfilePicConfirmationFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                SuggestProfilePicFragment.as((SuggestProfilePicFragment) this.f3786a.t);
            }
        }

        public final Dialog m3649c(Bundle bundle) {
            return new Builder(o()).b(2131235208).a(2131235209, new C04862(this)).b(2131235210, new C04851(this)).a();
        }
    }

    private static <T extends InjectableComponentWithContext> void m3652a(Class<T> cls, T t) {
        m3653a((Object) t, t.getContext());
    }

    private static void m3653a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SuggestProfilePicFragment) obj).m3651a(SimpleExecutor.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), Toaster.b(fbInjector), FbDraweeControllerBuilder.b(fbInjector));
    }

    public final void m3666a(@Nullable PhotoListener photoListener) {
        this.f3788b = photoListener;
    }

    public final void m3672c(Bundle bundle) {
        super.c(bundle);
        m3652a(SuggestProfilePicFragment.class, (InjectableComponentWithContext) this);
        this.f3791e.a();
    }

    @Inject
    private void m3651a(SimpleExecutor simpleExecutor, SecureContextHelper secureContextHelper, Toaster toaster, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f3791e = simpleExecutor;
        this.f3789c = secureContextHelper;
        this.f3790d = toaster;
        this.f3792f = fbDraweeControllerBuilder;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1447991619);
        super.mi_();
        this.f3791e.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1519859138, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1320206903);
        super.mj_();
        this.f3791e.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2108652513, a);
    }

    public final PhotoItem m3659a(long j) {
        if (aq()) {
            getContext().startService(new Intent(getContext(), SuggestProfilePicUploadService.class).putExtra("page_id", j).putExtra("photo_item", this.f3794h).putExtra("source", this.aq).putExtra("entry_point", this.ar).putExtra("endpoint", this.as));
        }
        return this.f3794h;
    }

    public final void m3668b() {
        m3654b(SimplePickerIntent.a(getContext(), new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.PLACE_PROFILE_PIC_SUGGESTS).k().h().i().a(Action.LAUNCH_GENERIC_CROPPER)), 943);
    }

    public final void m3673e() {
        this.f3794h = null;
        at();
        if (this.f3788b != null) {
            this.f3788b.mo195c();
        }
    }

    public final boolean aq() {
        return this.f3794h != null;
    }

    public final View m3658a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 414183253);
        View inflate = layoutInflater.inflate(2130907312, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1356334604, a);
        return inflate;
    }

    public final void m3674e(Bundle bundle) {
        bundle.putParcelable("SuggestProfilePicFragment.media_item", this.f3794h);
        bundle.putLong("place_id", this.ao);
        bundle.putSerializable("source", this.aq);
        bundle.putSerializable("entry_point", this.ar);
        bundle.putSerializable("endpoint", this.as);
        bundle.putParcelable("current_image_uri", this.ap);
        bundle.putBoolean("SuggestProfilePicFragment.confirm_dialog", this.f3795i);
        bundle.putBoolean("display_as_cover_photo", this.al);
        super.e(bundle);
    }

    public final void m3662a(View view, Bundle bundle) {
        if (bundle != null) {
            this.f3794h = (PhotoItem) bundle.getParcelable("SuggestProfilePicFragment.media_item");
            this.f3795i = bundle.getBoolean("SuggestProfilePicFragment.confirm_dialog");
            this.al = bundle.getBoolean("display_as_cover_photo");
            this.ao = bundle.getLong("place_id");
            this.aq = (CrowdsourcingSource) bundle.getSerializable("source");
            this.ar = (CrowdEntryPoint) bundle.getSerializable("entry_point");
            this.as = (CrowdEndpoint) bundle.getSerializable("endpoint");
            if (this.ap == null) {
                this.ap = (Uri) bundle.getParcelable("current_image_uri");
            }
        }
        this.f3793g = (FbDraweeView) view.findViewById(2131567760);
        if (!this.al) {
            ((GenericDraweeHierarchy) this.f3793g.getHierarchy()).b(2130842668);
        }
        this.f3793g.setOnCreateContextMenuListener(this);
        this.am = view.findViewById(2131567761);
        this.an = (Button) view.findViewById(2131567762);
        if (this.al) {
            this.an.setVisibility(0);
            this.an.setOnClickListener(this.at);
        } else {
            this.an.setVisibility(8);
            this.f3793g.setOnClickListener(this.at);
        }
        at();
    }

    public final void m3667a(boolean z) {
        this.al = z;
    }

    public final void m3665a(CrowdsourcingSource crowdsourcingSource) {
        this.aq = crowdsourcingSource;
    }

    public final void m3664a(CrowdEntryPoint crowdEntryPoint) {
        this.ar = crowdEntryPoint;
    }

    public final void m3663a(CrowdEndpoint crowdEndpoint) {
        this.as = crowdEndpoint;
    }

    public final void m3669b(long j) {
        this.ao = j;
    }

    public final void m3661a(Uri uri) {
        this.ap = uri;
        if (this.f3793g != null) {
            at();
        }
    }

    public static boolean ar(SuggestProfilePicFragment suggestProfilePicFragment) {
        return suggestProfilePicFragment.ao != 0;
    }

    public final void m3670b(boolean z) {
        this.f3795i = z;
    }

    private void m3654b(Intent intent, int i) {
        this.f3789c.a(intent, i, this);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        ao().getMenuInflater().inflate(2131820546, contextMenu);
    }

    public final boolean m3671b(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131568605) {
            m3668b();
            return true;
        } else if (menuItem.getItemId() != 2131568606) {
            return false;
        } else {
            m3673e();
            return true;
        }
    }

    public final void m3660a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 943) {
                boolean z;
                EditGalleryIpcBundle editGalleryIpcBundle = (EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a);
                if (editGalleryIpcBundle == null || editGalleryIpcBundle.b == null) {
                    z = false;
                } else {
                    z = true;
                }
                Preconditions.checkState(z);
                this.f3794h = new PhotoItemBuilder().b(editGalleryIpcBundle.b.getPath()).d("image/jpeg").a();
                if (this.f3795i) {
                    this.f3791e.a(new C04832(this), new C04843(this));
                } else {
                    as(this);
                }
            }
            super.a(i, i2, intent);
        }
    }

    public static void as(SuggestProfilePicFragment suggestProfilePicFragment) {
        if (suggestProfilePicFragment.f3788b != null) {
            suggestProfilePicFragment.f3788b.mo195c();
        }
        suggestProfilePicFragment.at();
        if (ar(suggestProfilePicFragment)) {
            suggestProfilePicFragment.f3790d.b(new ToastBuilder(2131235135));
            suggestProfilePicFragment.m3659a(suggestProfilePicFragment.ao);
        }
    }

    private void at() {
        if (aq()) {
            ImageRequestBuilder a = ImageRequestBuilder.a(Uri.fromFile(new File(this.f3794h.e())));
            a.d = new ResizeOptions(jW_().getDisplayMetrics().widthPixels, jW_().getDisplayMetrics().heightPixels);
            this.f3793g.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f3792f.b(this.f3793g.getController())).a(f3787a).c(a.m())).s());
            this.am.setVisibility(8);
            this.an.setVisibility(8);
            return;
        }
        this.f3793g.setController(((FbDraweeControllerBuilder) this.f3792f.b(this.f3793g.getController())).a(f3787a).b(this.ap).s());
        if (this.al) {
            this.am.setVisibility(8);
        } else {
            this.am.setVisibility(0);
        }
    }
}
