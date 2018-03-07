package com.facebook.messaging.media.mediapicker;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.BugReportCategory;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.fullscreendialog.FullScreenDialogParams;
import com.facebook.messaging.media.loader.LocalMediaLoader;
import com.facebook.messaging.media.loader.LocalMediaLoaderParams;
import com.facebook.messaging.media.mediapicker.MediaPickerActivity.MediaPickerListener;
import com.facebook.messaging.media.mediapicker.SelectionState.SelectionListener;
import com.facebook.messaging.media.picking.MessengerStartVideoEditHelper;
import com.facebook.messaging.media.picking.VideoFormatChecker;
import com.facebook.messaging.media.upload.ExperimentsForMediaUploadModule;
import com.facebook.messaging.media.upload.MediaPreUploadPhotoHelper;
import com.facebook.messaging.media.upload.MediaPreUploadPhotoHelper.C13381;
import com.facebook.messaging.media.upload.MediaPreUploadPhotoHelper.C13392;
import com.facebook.messaging.media.upload.MediaResourceChecker;
import com.facebook.messaging.media.upload.MediaResourceChecker.Result;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.photos.editing.MessengerPhotoEditDialogFragment;
import com.facebook.messaging.photos.editing.MessengerPhotoEditDialogFragment.Listener;
import com.facebook.photos.annotation.MaxNumberPhotosPerUpload;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CountBadge;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mCampType */
public class MediaPickerFragment extends FbFragment implements OnClickListener {
    @Inject
    BugReportOperationLogger f11690a;
    private int aA;
    private int aB;
    private int aC;
    private int aD;
    private int aE;
    public final List<Long> aF = new ArrayList();
    public final Map<Long, MediaResource> aG = new HashMap();
    public MediaPickerEnvironment aH;
    public SelectedMode aI = SelectedMode.ALL;
    public SelectionState aJ;
    @Nullable
    public MediaPickerListener aK;
    @Inject
    MessengerStartVideoEditHelper al;
    @Inject
    Toaster am;
    @Inject
    VideoFormatChecker an;
    private final LoaderCallback ao = new LoaderCallback(this);
    private final PhotoEditorListener ap = new PhotoEditorListener(this);
    private RadioButton aq;
    private LinearLayout ar;
    private ViewGroup as;
    public CountBadge at;
    private ImageView au;
    private RecyclerView av;
    private RadioButton aw;
    private MediaPickerGridAdapter ax;
    private GridLayoutManager ay;
    private int az;
    @Inject
    DynamicMediaPickerPreference f11691b;
    @Inject
    @ForUiThread
    Executor f11692c;
    @Inject
    AbstractFbErrorReporter f11693d;
    @Inject
    @MaxNumberPhotosPerUpload
    Provider<Integer> f11694e;
    @Inject
    MediaPreUploadPhotoHelper f11695f;
    @Inject
    MediaPickerGridAdapterProvider f11696g;
    @Inject
    LocalMediaLoader f11697h;
    @Inject
    MediaResourceChecker f11698i;

    /* compiled from: mCampType */
    class CheckerCallback implements FutureCallback<Result> {
        final /* synthetic */ MediaPickerFragment f11684a;
        private final MediaResource f11685b;

        public void onSuccess(Object obj) {
            switch ((Result) obj) {
                case VALID:
                    MediaResourceBuilder a = MediaResource.a().a(this.f11685b);
                    a.k = this.f11684a.aH.f11682f;
                    a = a;
                    a.l = this.f11684a.aH.f11681e;
                    MediaResource C = a.C();
                    MediaPreUploadPhotoHelper mediaPreUploadPhotoHelper = this.f11684a.f11695f;
                    Context context = this.f11684a.getContext();
                    if (mediaPreUploadPhotoHelper.f11866g.a(ExperimentsForMediaUploadModule.f11834f, false) && (!mediaPreUploadPhotoHelper.f11866g.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMediaUploadModule.f11835g, false) || mediaPreUploadPhotoHelper.f11867h.c())) {
                        ListenableFuture a2 = mediaPreUploadPhotoHelper.f11860a.a(new C13381(mediaPreUploadPhotoHelper, C, context));
                        mediaPreUploadPhotoHelper.f11865f.a(C, a2);
                        Futures.a(a2, new C13392(mediaPreUploadPhotoHelper, C), mediaPreUploadPhotoHelper.f11864e);
                    }
                    return;
                case NONEXISTENT:
                    m12337a("File does not exist", 2131240895);
                    return;
                case INACCESSIBLE:
                    m12337a("File not accessible", 2131240894);
                    return;
                case CORRUPTED:
                    m12337a("Media corrupted", 2131240896);
                    return;
                default:
                    return;
            }
        }

        public CheckerCallback(MediaPickerFragment mediaPickerFragment, MediaResource mediaResource) {
            this.f11684a = mediaPickerFragment;
            this.f11685b = mediaResource;
        }

        public void onFailure(Throwable th) {
            m12338a("Unknown media error", 2131240896, th);
        }

        private void m12337a(String str, int i) {
            m12338a(str, i, null);
        }

        private void m12338a(String str, int i, @Nullable Throwable th) {
            this.f11684a.aJ.m12384b(this.f11685b);
            this.f11684a.f11693d.a("MediaPicker", str, th);
            CharSequence b = this.f11684a.b(i);
            Toaster toaster = this.f11684a.am;
            ToastBuilder toastBuilder = new ToastBuilder(b);
            toastBuilder.b = 17;
            toaster.b(toastBuilder);
        }
    }

    /* compiled from: mCampType */
    public class ItemClickListener {
        public final /* synthetic */ MediaPickerFragment f11686a;

        public ItemClickListener(MediaPickerFragment mediaPickerFragment) {
            this.f11686a = mediaPickerFragment;
        }

        public final void m12340a(MediaResource mediaResource) {
            MediaPickerFragment.m12355a(this.f11686a, mediaResource.d.toString());
            if (this.f11686a.aH.f11678b) {
                this.f11686a.m12359b(ImmutableList.of(mediaResource));
            } else if (mediaResource.d == Type.PHOTO) {
                MessengerPhotoEditDialogFragment.m16212a(mediaResource, FullScreenDialogParams.a(), false).a(this.f11686a.s(), "photo_edit_dialog_fragment_tag");
            } else {
                m12339c(mediaResource);
            }
        }

        private void m12339c(MediaResource mediaResource) {
            File file = new File(mediaResource.c.getPath());
            if (file.isFile() && file.length() < 1024) {
                new Builder(this.f11686a.getContext()).a(2131240899).b(2131240900).a(true).a(2131230756, null).b();
            } else if (this.f11686a.an.m12436a(mediaResource.c, "messenger_video_edit")) {
                this.f11686a.al.m12423a(this.f11686a.getContext(), mediaResource, this.f11686a.D, "VIDEO_EDIT", null, null, false);
            }
        }
    }

    /* compiled from: mCampType */
    class LoaderCallback extends AbstractFbLoaderCallback<LocalMediaLoaderParams, ImmutableList<MediaResource>, Throwable> {
        final /* synthetic */ MediaPickerFragment f11687a;

        public LoaderCallback(MediaPickerFragment mediaPickerFragment) {
            this.f11687a = mediaPickerFragment;
        }

        public final void m12341b(Object obj, Object obj2) {
            this.f11687a.m12356a((ImmutableList) obj2);
        }

        public final void m12342c(Object obj, Object obj2) {
            new Builder(this.f11687a.getContext()).a(1 != 0 ? 2131240876 : 2131240877).b(2131240878).a(false).a(2131230756, null).b();
        }
    }

    /* compiled from: mCampType */
    public class MediaSelectionStateListener implements SelectionListener {
        public final /* synthetic */ MediaPickerFragment f11688a;

        public MediaSelectionStateListener(MediaPickerFragment mediaPickerFragment) {
            this.f11688a = mediaPickerFragment;
        }

        public final void mo455a(long j, boolean z) {
            if (this.f11688a.at != null) {
                MediaResource mediaResource = (MediaResource) this.f11688a.aG.get(Long.valueOf(j));
                if (mediaResource == null) {
                    m12344b();
                    return;
                }
                if (z) {
                    this.f11688a.at.a();
                    Futures.a(this.f11688a.f11698i.m12468a(mediaResource), new CheckerCallback(this.f11688a, mediaResource), this.f11688a.f11692c);
                } else {
                    MediaPreUploadPhotoHelper mediaPreUploadPhotoHelper = this.f11688a.f11695f;
                    if (mediaPreUploadPhotoHelper.f11866g.a(ExperimentsForMediaUploadModule.f11833e, false)) {
                        ListenableFuture listenableFuture = (ListenableFuture) mediaPreUploadPhotoHelper.f11865f.a(mediaResource);
                        if (listenableFuture != null) {
                            listenableFuture.cancel(true);
                            mediaPreUploadPhotoHelper.f11865f.b(mediaResource);
                        }
                        ((MediaUploadManagerImpl) mediaPreUploadPhotoHelper.f11863d.get()).b(mediaResource);
                    }
                    m12344b();
                }
                MediaPickerFragment.ay(this.f11688a);
            }
        }

        private void m12344b() {
            this.f11688a.at.b();
            if (this.f11688a.aJ.m12383b() == 0 && this.f11688a.aI == SelectedMode.SELECTED) {
                this.f11688a.m12366b();
            }
        }
    }

    /* compiled from: mCampType */
    class PhotoEditorListener implements Listener {
        final /* synthetic */ MediaPickerFragment f11689a;

        public PhotoEditorListener(MediaPickerFragment mediaPickerFragment) {
            this.f11689a = mediaPickerFragment;
        }

        public final void mo457a(MediaResource mediaResource) {
            this.f11689a.aG.put(Long.valueOf(mediaResource.g), mediaResource);
            this.f11689a.aJ.m12382a(mediaResource);
            MediaPickerFragment.ar(this.f11689a);
        }

        public final void mo458b(MediaResource mediaResource) {
        }

        public final void mo456a() {
        }
    }

    /* compiled from: mCampType */
    public enum SelectedMode {
        ALL,
        SELECTED
    }

    public static void m12357a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MediaPickerFragment) obj).m12353a(BugReportOperationLogger.a(injectorLike), DynamicMediaPickerPreference.m12321a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4421), MediaPreUploadPhotoHelper.m12465b(injectorLike), (MediaPickerGridAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MediaPickerGridAdapterProvider.class), LocalMediaLoader.m12315b(injectorLike), MediaResourceChecker.m12467b(injectorLike), MessengerStartVideoEditHelper.m12422b(injectorLike), Toaster.b(injectorLike), VideoFormatChecker.m12435b(injectorLike));
    }

    private void m12353a(BugReportOperationLogger bugReportOperationLogger, DynamicMediaPickerPreference dynamicMediaPickerPreference, Executor executor, FbErrorReporter fbErrorReporter, Provider<Integer> provider, MediaPreUploadPhotoHelper mediaPreUploadPhotoHelper, MediaPickerGridAdapterProvider mediaPickerGridAdapterProvider, LocalMediaLoader localMediaLoader, MediaResourceChecker mediaResourceChecker, MessengerStartVideoEditHelper messengerStartVideoEditHelper, Toaster toaster, VideoFormatChecker videoFormatChecker) {
        this.f11690a = bugReportOperationLogger;
        this.f11691b = dynamicMediaPickerPreference;
        this.f11692c = executor;
        this.f11693d = fbErrorReporter;
        this.f11694e = provider;
        this.f11695f = mediaPreUploadPhotoHelper;
        this.f11696g = mediaPickerGridAdapterProvider;
        this.f11697h = localMediaLoader;
        this.f11698i = mediaResourceChecker;
        this.al = messengerStartVideoEditHelper;
        this.am = toaster;
        this.an = videoFormatChecker;
    }

    public final void m12367c(Bundle bundle) {
        super.c(bundle);
        Class cls = MediaPickerFragment.class;
        m12357a((Object) this, getContext());
        if (bundle == null) {
            this.aH = (MediaPickerEnvironment) this.s.getParcelable("extra_environment");
            if (this.aH == null) {
                this.aH = MediaPickerEnvironment.f11677a;
            }
            List<MediaItem> parcelableArrayList = this.s.getParcelableArrayList("extra_selection");
            if (parcelableArrayList != null) {
                for (MediaItem d : parcelableArrayList) {
                    this.aF.add(Long.valueOf(d.d().b));
                }
                return;
            }
            return;
        }
        m12360n(bundle);
    }

    private void m12360n(Bundle bundle) {
        this.aH = (MediaPickerEnvironment) bundle.getParcelable("environment");
        this.az = bundle.getInt("grid_view_scroll_position", 0);
        this.aA = bundle.getInt("grid_view_scroll_offset", 0);
        this.aI = (SelectedMode) bundle.getSerializable("selected_mode");
        for (long valueOf : bundle.getLongArray("selection")) {
            this.aF.add(Long.valueOf(valueOf));
        }
    }

    public final View m12363a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1166860740);
        View inflate = layoutInflater.inflate(2130905180, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 524232875, a);
        return inflate;
    }

    public final void m12365a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.aq = (RadioButton) e(2131563731);
        this.ar = (LinearLayout) e(2131563728);
        this.as = (ViewGroup) e(2131563725);
        this.at = (CountBadge) e(2131563734);
        this.au = (ImageView) e(2131563733);
        this.av = (RecyclerView) e(2131563724);
        this.aw = (RadioButton) e(2131563732);
        this.aq.setOnClickListener(this);
        this.au.setOnClickListener(this);
        this.aw.setOnClickListener(this);
        this.ay = (GridLayoutManager) this.av.getLayoutManager();
        this.aJ = new SelectionState(((Integer) this.f11694e.get()).intValue());
        this.aJ.m12381a(new MediaSelectionStateListener(this));
        MediaPickerGridAdapterProvider mediaPickerGridAdapterProvider = this.f11696g;
        this.ax = new MediaPickerGridAdapter((Context) mediaPickerGridAdapterProvider.getInstance(Context.class), LayoutInflaterMethodAutoProvider.b(mediaPickerGridAdapterProvider), (PhotoItemControllerProvider) mediaPickerGridAdapterProvider.getOnDemandAssistedProviderForStaticDi(PhotoItemControllerProvider.class), (VideoItemControllerProvider) mediaPickerGridAdapterProvider.getOnDemandAssistedProviderForStaticDi(VideoItemControllerProvider.class), this.aH);
        this.av.setAdapter(this.ax);
        m12352a(this.az, this.aA);
        if (this.aH.f11678b) {
            view.findViewById(2131563729).setVisibility(8);
            view.findViewById(2131563730).setVisibility(8);
            this.av.setPadding(0, 0, 0, 0);
            this.at.setVisibility(8);
            this.aI = SelectedMode.ALL;
            this.au.setVisibility(8);
            return;
        }
        ay(this);
        if (this.aI == SelectedMode.SELECTED) {
            this.aw.setChecked(true);
        }
    }

    public final void m12368e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("environment", this.aH);
        bundle.putInt("grid_view_scroll_position", this.az);
        bundle.putInt("grid_view_scroll_offset", this.aA);
        bundle.putSerializable("selected_mode", this.aI);
        String str = "selection";
        SelectionState selectionState = this.aJ;
        long[] jArr = new long[selectionState.f11737c.size()];
        int i = 0;
        for (Long longValue : selectionState.f11737c) {
            jArr[i] = longValue.longValue();
            i++;
        }
        bundle.putLongArray(str, jArr);
    }

    public final void m12362H() {
        int i = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 793803272);
        super.H();
        KeyboardUtils.a(getContext(), this.T);
        this.az = this.ay.l();
        View childAt = this.av.getChildAt(0);
        if (childAt != null) {
            i = childAt.getTop();
        }
        this.aA = i;
        LogUtils.f(1636479563, a);
    }

    public final void m12361G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1564464941);
        super.G();
        this.at.setVisibility(0);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -385275172, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1739779575);
        super.mi_();
        this.f11697h.a(this.ao);
        this.f11697h.a(new LocalMediaLoaderParams(this.aH.f11679c));
        if (this.aH.f11680d) {
            this.au.setImageResource(2130841192);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 362815497, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2104046695);
        super.mj_();
        this.f11697h.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -722045197, a);
    }

    public final void m12364a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof MessengerPhotoEditDialogFragment) {
            ((MessengerPhotoEditDialogFragment) fragment).ax = this.ap;
        }
    }

    private void m12356a(ImmutableList<MediaResource> immutableList) {
        int i;
        this.aG.clear();
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            MediaResource mediaResource = (MediaResource) immutableList.get(i);
            this.aG.put(Long.valueOf(mediaResource.g), mediaResource);
        }
        if (this.aJ != null) {
            ArrayList a = Lists.a(Collections.unmodifiableList(this.aJ.f11737c));
            int size2 = a.size();
            for (i = 0; i < size2; i++) {
                long longValue = ((Long) a.get(i)).longValue();
                if (!this.aG.containsKey(Long.valueOf(longValue))) {
                    this.aJ.m12380a(longValue);
                }
            }
        }
        for (Long longValue2 : this.aF) {
            long longValue3 = longValue2.longValue();
            if (this.aG.containsKey(Long.valueOf(longValue3))) {
                this.aJ.m12382a((MediaResource) this.aG.get(Long.valueOf(longValue3)));
            }
        }
        SelectionListener selectionListener = this.ax;
        SelectionState selectionState = this.aJ;
        if (selectionListener.f11712j != null) {
            selectionListener.f11712j.f11736b.remove(selectionListener);
        }
        selectionListener.f11712j = selectionState;
        selectionListener.f11712j.m12381a(selectionListener);
        this.ax.f11711i = new ItemClickListener(this);
        MediaPickerGridAdapter mediaPickerGridAdapter = this.ax;
        mediaPickerGridAdapter.f11714l = Ordering.a(MediaResource.a).c(ImmutableList.copyOf(this.aG.values()));
        mediaPickerGridAdapter.f11715m = Lists.a(Iterables.c(mediaPickerGridAdapter.f11714l, mediaPickerGridAdapter.f11703a));
        mediaPickerGridAdapter.notifyDataSetChanged();
        ax();
        aw();
        this.ax.m12374a(this.aI);
        this.at.setVisibility(0);
    }

    public static void ar(MediaPickerFragment mediaPickerFragment) {
        m12355a(mediaPickerFragment, "post_photo_button");
        if (!mediaPickerFragment.aG.isEmpty() && mediaPickerFragment.aJ.m12383b() != 0) {
            ArrayList arrayList;
            mediaPickerFragment.f11691b.m12325b();
            ArrayList a = Lists.a();
            if (mediaPickerFragment.aG.isEmpty()) {
                arrayList = a;
            } else {
                Iterator it = mediaPickerFragment.aJ.iterator();
                while (it.hasNext()) {
                    MediaResource mediaResource = (MediaResource) mediaPickerFragment.aG.get(Long.valueOf(((Long) it.next()).longValue()));
                    if (mediaResource != null) {
                        a.add(mediaResource);
                    }
                }
                arrayList = a;
            }
            mediaPickerFragment.m12359b(ImmutableList.copyOf(arrayList));
        }
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1071906329);
        int id = view.getId();
        if (id == 2131563733) {
            ar(this);
        } else if (id == 2131563731) {
            au();
        } else if (id == 2131563732) {
            at();
        }
        LogUtils.a(-908222655, a);
    }

    private void at() {
        av();
        m12355a(this, "selected_tab");
        this.aw.setChecked(true);
        this.aI = SelectedMode.SELECTED;
        if (this.aJ.m12383b() > 0) {
            this.ax.m12374a(SelectedMode.SELECTED);
            m12352a(this.aB, this.aD);
            return;
        }
        this.as.setVisibility(0);
        this.av.setVisibility(8);
    }

    private void au() {
        av();
        m12355a(this, "all_tab");
        this.aq.setChecked(true);
        this.aI = SelectedMode.ALL;
        this.av.setVisibility(0);
        this.as.setVisibility(8);
        this.ax.m12374a(SelectedMode.ALL);
        m12352a(this.aC, this.aE);
    }

    private void av() {
        int i = 0;
        View childAt = this.av.getChildAt(0);
        int l = this.ay.l();
        if (childAt != null) {
            i = childAt.getTop();
        }
        if (this.aI == SelectedMode.SELECTED) {
            this.aB = l;
            this.aD = i;
        } else if (this.aI == SelectedMode.ALL) {
            this.aC = l;
            this.aE = i;
        }
    }

    private void m12352a(int i, int i2) {
        this.ay.d(i, i2);
    }

    public final void m12366b() {
        KeyboardUtils.a(getContext(), this.T);
        this.as.setVisibility(0);
        this.aq.setVisibility(0);
        this.aw.setVisibility(0);
        this.av.setVisibility(0);
        aw();
    }

    private void aw() {
        this.at.setCount(this.aJ.m12383b());
        ay(this);
    }

    private void ax() {
        if (this.aG.isEmpty()) {
            KeyboardUtils.a(getContext(), this.T);
            this.ar.setVisibility(0);
            this.T.findViewById(2131563730).setVisibility(8);
            return;
        }
        this.ar.setVisibility(8);
        if (!this.aH.f11678b) {
            this.T.findViewById(2131563730).setVisibility(0);
        }
    }

    public static void ay(MediaPickerFragment mediaPickerFragment) {
        int b = mediaPickerFragment.aJ.m12383b();
        boolean z = b > 0;
        mediaPickerFragment.au.setEnabled(z);
        mediaPickerFragment.au.setAlpha(z ? 1.0f : 0.5f);
        mediaPickerFragment.au.setContentDescription(z ? mediaPickerFragment.jW_().getQuantityString(2131689777, b, new Object[]{Integer.valueOf(b)}) : mediaPickerFragment.jW_().getString(2131240886));
        mediaPickerFragment.at.setEnabled(z);
        mediaPickerFragment.at.setContentDescription(mediaPickerFragment.au.getContentDescription());
    }

    public static void m12355a(MediaPickerFragment mediaPickerFragment, String str) {
        mediaPickerFragment.f11690a.a("Click on " + str, BugReportCategory.MEDIA_PICKER);
    }

    private void m12359b(ImmutableList<MediaResource> immutableList) {
        if (this.aK != null) {
            ImmutableList.Builder builder = ImmutableList.builder();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                MediaResourceBuilder a = MediaResource.a().a((MediaResource) immutableList.get(i));
                a.k = this.aH.f11682f;
                a = a;
                a.c = Source.MEDIA_PICKER_GALLERY;
                a = a;
                a.l = this.aH.f11681e;
                builder.c(a.C());
            }
            this.aK.m12327a(builder.b());
        }
    }
}
