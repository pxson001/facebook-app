package com.facebook.localcontent.menus;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.localcontent.analytics.LocalContentMenuLogger;
import com.facebook.localcontent.menus.PhotoMenuUploadItemBinder.C16341;
import com.facebook.localcontent.menus.PhotoMenuUploadItemBinder.C16352;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PhotoMenuUploadStartedEvent;
import com.facebook.pages.common.viewercontextutils.ViewerContextUtil;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: ec_config_cover_photo */
public class PhotoMenuUploadFragment extends FbFragment implements CanHandleBackPressed {
    private static final CallerContext am = CallerContext.a(PhotoMenuUploadFragment.class);
    private static final String an = PhotoMenuUploadFragment.class.getSimpleName();
    @Inject
    AbstractFbErrorReporter f15026a;
    @Inject
    public Lazy<ViewerContextUtil> al;
    public ImageWithTextView ao;
    private LinearLayout ap;
    private LayoutInflater aq;
    public ArrayList<PhotoMenuUploadItemModel> ar;
    public long as;
    public ViewerContext at;
    private Optional<HasTitleBar> au;
    @Inject
    public GlyphColorizer f15027b;
    @Inject
    LocalContentMenuLogger f15028c;
    @Inject
    PageScopedEventBus f15029d;
    @Inject
    public SecureContextHelper f15030e;
    @Inject
    public TasksManager f15031f;
    @Inject
    Lazy<Toaster> f15032g;
    @Inject
    UploadManager f15033h;
    @Inject
    UploadOperationFactory f15034i;

    /* compiled from: ec_config_cover_photo */
    class C16271 implements OnTouchListener {
        final /* synthetic */ PhotoMenuUploadFragment f15018a;

        C16271(PhotoMenuUploadFragment photoMenuUploadFragment) {
            this.f15018a = photoMenuUploadFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            KeyboardUtils.a(this.f15018a.o());
            return true;
        }
    }

    /* compiled from: ec_config_cover_photo */
    class C16282 extends OnToolbarButtonListener {
        final /* synthetic */ PhotoMenuUploadFragment f15019a;

        C16282(PhotoMenuUploadFragment photoMenuUploadFragment) {
            this.f15019a = photoMenuUploadFragment;
        }

        public final void m17459a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            LocalContentMenuLogger localContentMenuLogger = this.f15019a.f15028c;
            String l = Long.toString(this.f15019a.as);
            int size = this.f15019a.ar.size();
            PhotoMenuUploadFragment photoMenuUploadFragment = this.f15019a;
            int size2 = photoMenuUploadFragment.ar.size();
            int i = 0;
            int i2 = 0;
            while (i < size2) {
                int i3;
                if (Strings.isNullOrEmpty(((PhotoMenuUploadItemModel) photoMenuUploadFragment.ar.get(i)).f15041d)) {
                    i3 = i2;
                } else {
                    i3 = i2 + 1;
                }
                i++;
                i2 = i3;
            }
            localContentMenuLogger.f14941a.a(LocalContentMenuLogger.m17411e("upload_photo_menu_upload_button_click", l).a("photo_labels_count", i2).a("photos_total_count", size));
            PhotoMenuUploadFragment.aw(this.f15019a);
        }
    }

    /* compiled from: ec_config_cover_photo */
    public class C16293 implements OnClickListener {
        final /* synthetic */ PhotoMenuUploadFragment f15020a;

        public C16293(PhotoMenuUploadFragment photoMenuUploadFragment) {
            this.f15020a = photoMenuUploadFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 698341754);
            this.f15020a.f15028c.m17413f(Long.toString(this.f15020a.as));
            PhotoMenuUploadFragment photoMenuUploadFragment = this.f15020a;
            photoMenuUploadFragment.f15030e.a(SimplePickerIntent.a(photoMenuUploadFragment.getContext(), new Builder(SimplePickerSource.PHOTO_MENU_UPLOAD).k().i().a(Action.NONE)), 26002, (Activity) ContextUtils.a(photoMenuUploadFragment.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, 1177158865, a);
        }
    }

    /* compiled from: ec_config_cover_photo */
    class C16304 implements DialogInterface.OnClickListener {
        final /* synthetic */ PhotoMenuUploadFragment f15021a;

        C16304(PhotoMenuUploadFragment photoMenuUploadFragment) {
            this.f15021a = photoMenuUploadFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f15021a.o().setResult(-1);
            this.f15021a.o().finish();
        }
    }

    /* compiled from: ec_config_cover_photo */
    public class C16315 implements DialogInterface.OnClickListener {
        final /* synthetic */ PhotoMenuUploadFragment f15022a;

        public C16315(PhotoMenuUploadFragment photoMenuUploadFragment) {
            this.f15022a = photoMenuUploadFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: ec_config_cover_photo */
    public class C16326 implements DialogInterface.OnClickListener {
        final /* synthetic */ PhotoMenuUploadFragment f15023a;

        public C16326(PhotoMenuUploadFragment photoMenuUploadFragment) {
            this.f15023a = photoMenuUploadFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            PhotoMenuUploadFragment.aC(this.f15023a);
        }
    }

    public static void m17464a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PhotoMenuUploadFragment) obj).m17462a((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), GlyphColorizer.a(fbInjector), LocalContentMenuLogger.m17409b(fbInjector), PageScopedEventBus.m19596a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), TasksManager.b(fbInjector), IdBasedLazy.a(fbInjector, 3588), UploadManager.a(fbInjector), UploadOperationFactory.b(fbInjector), IdBasedLazy.a(fbInjector, 9011));
    }

    public final void m17472c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PhotoMenuUploadFragment.class;
        m17464a((Object) this, getContext());
        this.as = this.s.getLong("com.facebook.katana.profile.id");
        this.au = Optional.fromNullable(a(HasTitleBar.class));
        this.at = (ViewerContext) this.s.getParcelable("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT");
        if (this.at == null) {
            final ProgressDialog a = ProgressDialog.a(getContext(), null, jW_().getString(2131230739), true, false);
            this.f15031f.a("fetch_viewer_context" + this.as, ((ViewerContextUtil) this.al.get()).m20220a(String.valueOf(this.as)), new AbstractDisposableFutureCallback<ViewerContext>(this) {
                final /* synthetic */ PhotoMenuUploadFragment f15025b;

                protected final void m17460a(Object obj) {
                    this.f15025b.at = (ViewerContext) obj;
                    a.dismiss();
                }

                protected final void m17461a(Throwable th) {
                    ((Toaster) this.f15025b.f15032g.get()).a(new ToastBuilder(2131230758));
                    a.dismiss();
                    PhotoMenuUploadFragment.aC(this.f15025b);
                }
            });
        }
        this.f15028c.m17412e(Long.toString(this.as));
    }

    public final View m17469a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1388290002);
        this.aq = layoutInflater;
        View inflate = this.aq.inflate(2130906198, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2123609553, a);
        return inflate;
    }

    public final void m17470a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.ao = (ImageWithTextView) e(2131565906);
        this.ap = (LinearLayout) e(2131565905);
        this.ap.setOnTouchListener(new C16271(this));
        this.ao.setText(2131239100);
        this.ao.setImageDrawable(this.f15027b.a(2130839749, -10972929));
        this.ao.setOnClickListener(new C16293(this));
        this.ar = bundle == null ? null : bundle.getParcelableArrayList("photo_menu_uploads_models");
        if (this.ar != null) {
            m17466b();
            return;
        }
        this.ar = new ArrayList();
        aq();
    }

    private void m17462a(FbErrorReporter fbErrorReporter, GlyphColorizer glyphColorizer, LocalContentMenuLogger localContentMenuLogger, PageScopedEventBus pageScopedEventBus, SecureContextHelper secureContextHelper, TasksManager tasksManager, Lazy<Toaster> lazy, UploadManager uploadManager, UploadOperationFactory uploadOperationFactory, Lazy<ViewerContextUtil> lazy2) {
        this.f15026a = fbErrorReporter;
        this.f15027b = glyphColorizer;
        this.f15028c = localContentMenuLogger;
        this.f15029d = pageScopedEventBus;
        this.f15030e = secureContextHelper;
        this.f15031f = tasksManager;
        this.f15032g = lazy;
        this.f15033h = uploadManager;
        this.f15034i = uploadOperationFactory;
        this.al = lazy2;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 350178507);
        super.mi_();
        as();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1737133172, a);
    }

    public final void m17473e(Bundle bundle) {
        bundle.putParcelableArrayList("photo_menu_uploads_models", this.ar);
    }

    public final void m17471b(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 26002) {
            m17467b(intent);
        }
    }

    public final void m17474g(int i) {
        KeyboardUtils.a(o());
        Preconditions.checkPositionIndex(i, this.ar.size());
        this.f15028c.m17414g(Long.toString(this.as));
        this.ar.remove(i);
        this.ap.removeViewAt(i);
        m17468h(i);
    }

    public final boolean O_() {
        if (this.ar.isEmpty()) {
            aC(this);
        } else {
            new FbAlertDialogBuilder(getContext()).a(2131239114).b(2131239115).a(true).a(2131239116, new C16326(this)).b(2131239117, new C16315(this)).a().show();
        }
        return true;
    }

    private void m17466b() {
        for (int i = 0; i < this.ar.size(); i++) {
            this.ap.addView(ar());
        }
        m17468h(0);
    }

    private void m17467b(Intent intent) {
        m17465a(intent.getParcelableArrayListExtra("extra_media_items"));
    }

    private void m17465a(ArrayList<MediaItem> arrayList) {
        if (arrayList == null) {
            this.f15026a.b(an, "Null media items were provided.");
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m17463a((MediaItem) arrayList.get(i));
        }
        LocalContentMenuLogger localContentMenuLogger = this.f15028c;
        String l = Long.toString(this.as);
        size = arrayList.size();
        localContentMenuLogger.f14941a.a(LocalContentMenuLogger.m17411e("upload_photo_menu_photos_selected", l).a("photos_selected_count", size).a("photos_total_count", this.ar.size()));
    }

    private void m17463a(MediaItem mediaItem) {
        this.ar.add(new PhotoMenuUploadItemModel(mediaItem));
        View ar = ar();
        this.ap.addView(ar);
        m17468h(this.ar.size() - 1);
        ar.requestFocus();
    }

    private View ar() {
        return this.aq.inflate(2130906199, this.ap, false);
    }

    private void m17468h(int i) {
        while (i < this.ar.size()) {
            PhotoMenuUploadItemView photoMenuUploadItemView = (PhotoMenuUploadItemView) this.ap.getChildAt(i);
            PhotoMenuUploadItemModel photoMenuUploadItemModel = (PhotoMenuUploadItemModel) this.ar.get(i);
            CallerContext callerContext = am;
            photoMenuUploadItemView.clearFocus();
            photoMenuUploadItemView.setDescription(photoMenuUploadItemModel.f15041d);
            photoMenuUploadItemView.m17478a(photoMenuUploadItemModel.f15038a.f(), photoMenuUploadItemModel.f15039b, photoMenuUploadItemModel.f15040c, callerContext);
            photoMenuUploadItemView.setPhotoNumber(i + 1);
            photoMenuUploadItemView.setDescriptionWatcher(new C16341(photoMenuUploadItemModel));
            photoMenuUploadItemView.setRemoveButtonOnClickListener(new C16352(this, i));
            i++;
        }
        at();
    }

    private void as() {
        at();
        if (this.au.isPresent()) {
            ((HasTitleBar) this.au.get()).a(new C16282(this));
        }
    }

    private void at() {
        boolean z = this.ar != null && this.ar.size() > 0;
        if (this.au.isPresent()) {
            HasTitleBar hasTitleBar = (HasTitleBar) this.au.get();
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.g = b(2131239104);
            a = a;
            a.d = z;
            hasTitleBar.a(a.a());
        }
    }

    public static void aw(PhotoMenuUploadFragment photoMenuUploadFragment) {
        if (photoMenuUploadFragment.ar.size() != 0) {
            UploadOperationFactory uploadOperationFactory = photoMenuUploadFragment.f15034i;
            ImmutableList.Builder builder = ImmutableList.builder();
            int size = photoMenuUploadFragment.ar.size();
            for (int i = 0; i < size; i++) {
                builder.c(((PhotoMenuUploadItemModel) photoMenuUploadFragment.ar.get(i)).f15038a);
            }
            photoMenuUploadFragment.f15033h.a(uploadOperationFactory.a(builder.b(), photoMenuUploadFragment.az(), photoMenuUploadFragment.as, photoMenuUploadFragment.at, SafeUUIDGenerator.a().toString()));
            photoMenuUploadFragment.f15029d.a(new PhotoMenuUploadStartedEvent(Long.valueOf(photoMenuUploadFragment.as)));
            KeyboardUtils.a(photoMenuUploadFragment.o());
            photoMenuUploadFragment.ax();
        }
    }

    private void ax() {
        new FbAlertDialogBuilder(getContext()).a(2131239106).b(2131239107).a(false).a(2131230756, new C16304(this)).a().show();
    }

    private ImmutableList<Bundle> az() {
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = this.ar.size();
        for (int i = 0; i < size; i++) {
            PhotoMenuUploadItemModel photoMenuUploadItemModel = (PhotoMenuUploadItemModel) this.ar.get(i);
            Bundle bundle = new Bundle();
            if (!Strings.isNullOrEmpty(photoMenuUploadItemModel.f15041d)) {
                bundle.putString("caption", photoMenuUploadItemModel.f15041d);
            }
            builder.c(bundle);
        }
        return builder.b();
    }

    public static void aC(PhotoMenuUploadFragment photoMenuUploadFragment) {
        Activity ao = photoMenuUploadFragment.ao();
        if (ao != null) {
            ao.finish();
        }
    }

    private void aq() {
        m17465a(this.s.getParcelableArrayList("extra_media_items"));
    }
}
