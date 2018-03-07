package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.ui.util.ViewIdUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerFragment.62;
import com.facebook.composer.analytics.PhotoSequences;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.Builder;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsComposerDrawn;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsMultimediaSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLogger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLogger.EventListener;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLoggerProvider;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageParams;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.widget.ScrollingAwareScrollView;
import com.facebook.widget.ScrollingAwareScrollView.OnScrollListener;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@NotThreadSafe
/* compiled from: commercial_break_eligible */
public class UnderwoodController<DataProvider extends ProvidesAttachments & ProvidesContentType & ProvidesIsComposerDrawn & ProvidesIsMultimediaSupported & ProvidesSessionId & ProvidesConfiguration & ProvidesTargetData> implements ComposerEventHandler {
    private static final SpringConfig f17180c = SpringConfig.a(120.0d, 12.0d);
    public static final ComposerEventOriginator f17181d = ComposerEventOriginator.a(UnderwoodController.class);
    private CreativeEditingUsageLogger f17182A;
    public AttachmentsViewEventListener f17183B;
    private FbSharedPreferences f17184C;
    public boolean f17185D;
    private int f17186E;
    public Spring f17187F;
    private final Provider<Integer> f17188G;
    public int f17189H;
    private boolean f17190I;
    private boolean f17191J = true;
    private boolean f17192K = false;
    public 62 f17193L;
    public String f17194M;
    public int f17195N = 0;
    public int f17196O;
    public boolean f17197P = false;
    public boolean f17198Q = true;
    public boolean f17199R = false;
    public double f17200S = 0.0d;
    public int f17201T = 0;
    public boolean f17202U = false;
    public int f17203V = 0;
    private boolean f17204W;
    private boolean f17205X;
    public DataProvider f17206Y;
    private VerticalAttachmentViewControllerProvider f17207Z;
    @VisibleForTesting
    public List<ComposerAttachment> f17208a;
    private SphericalPhotoAttachmentViewControllerProvider aa;
    private VideoPreviewAttachmentViewControllerProvider ab;
    private SlideshowAttachmentViewControllerProvider ac;
    @VisibleForTesting
    public List<UnderwoodAttachmentViewController> f17209b;
    private final boolean f17210e;
    private final Context f17211f;
    public final LayoutInflater f17212g;
    private final AttachmentEventsListener f17213h;
    private final TasksManager<Integer> f17214i;
    private final ComposerAttachmentViewUtility f17215j;
    public final UnderwoodLogger f17216k;
    public final PhotoSequences f17217l;
    private final AbstractFbErrorReporter f17218m;
    public final MediaItemFactory f17219n;
    private final EventListener f17220o = new CreativeEditingLoggerListener(this);
    private final CreativeEditingUsageLoggerProvider f17221p;
    public Map<String, CreativeEditingUsageParams> f17222q = new HashMap();
    private final CreativeEditingFileManager f17223r;
    public final OnGlobalLayoutListener f17224s = new C14011(this);
    private final C14022 f17225t = new C14022(this);
    private View f17226u;
    @Nullable
    private FragmentManager f17227v;
    public ScrollingAwareScrollView f17228w;
    @Nullable
    public FrameLayout f17229x;
    public LinearLayout f17230y;
    public VerticalAttachmentViewsContainer f17231z;

    /* compiled from: commercial_break_eligible */
    class C14011 implements OnGlobalLayoutListener {
        final /* synthetic */ UnderwoodController f17172a;

        C14011(UnderwoodController underwoodController) {
            this.f17172a = underwoodController;
        }

        public void onGlobalLayout() {
            if (this.f17172a.f17203V != this.f17172a.f17228w.getMeasuredHeight()) {
                this.f17172a.f17203V = this.f17172a.f17228w.getMeasuredHeight();
                UnderwoodController.m21157m(this.f17172a);
            }
        }
    }

    /* compiled from: commercial_break_eligible */
    public class C14022 {
        final /* synthetic */ UnderwoodController f17173a;

        C14022(UnderwoodController underwoodController) {
            this.f17173a = underwoodController;
        }

        public final UnderwoodAttachmentViewController m21134a(int i) {
            return (UnderwoodAttachmentViewController) this.f17173a.f17209b.get(i);
        }
    }

    /* compiled from: commercial_break_eligible */
    public class C14033 implements OnScrollListener {
        final /* synthetic */ UnderwoodController f17174a;

        public C14033(UnderwoodController underwoodController) {
            this.f17174a = underwoodController;
        }

        public final void m21135a(int i, int i2) {
            if (this.f17174a.f17201T == 0) {
                this.f17174a.f17201T = this.f17174a.f17228w.getChildAt(0).getMeasuredHeight() - this.f17174a.f17228w.getMeasuredHeight();
            }
            if (this.f17174a.f17201T != 0) {
                double d = (((double) i) / ((double) this.f17174a.f17201T)) * 100.0d;
                if (d > this.f17174a.f17200S) {
                    this.f17174a.f17200S = d;
                }
            }
            UnderwoodController.m21157m(this.f17174a);
        }
    }

    /* compiled from: commercial_break_eligible */
    public class C14044 implements OnClickListener {
        final /* synthetic */ UnderwoodController f17175a;

        public C14044(UnderwoodController underwoodController) {
            this.f17175a = underwoodController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 349130277);
            this.f17175a.f17183B.m21062a();
            this.f17175a.f17216k.f17234a.e();
            Logger.a(2, EntryType.UI_INPUT_END, -744601178, a);
        }
    }

    /* compiled from: commercial_break_eligible */
    /* synthetic */ class C14055 {
        static final /* synthetic */ int[] f17176a = new int[TriState.values().length];

        static {
            try {
                f17176a[TriState.YES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17176a[TriState.NO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17176a[TriState.UNSET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: commercial_break_eligible */
    public class AttachmentEventsListener {
        public final /* synthetic */ UnderwoodController f17177a;

        public AttachmentEventsListener(UnderwoodController underwoodController) {
            this.f17177a = underwoodController;
        }

        public final void m21136a(ComposerAttachment composerAttachment) {
            if (this.f17177a.f17187F.k()) {
                this.f17177a.f17183B.m21065a(composerAttachment, null);
            }
        }

        public final void m21139b(ComposerAttachment composerAttachment) {
            if (this.f17177a.f17187F.k()) {
                boolean z;
                this.f17177a.f17228w.requestFocus();
                this.f17177a.f17189H = this.f17177a.f17208a.indexOf(composerAttachment);
                Spring spring = this.f17177a.f17187F;
                if (this.f17177a.f17189H == this.f17177a.f17208a.size() - 1 || ((ProvidesContentType) this.f17177a.f17206Y).c() == ComposerContentType.SLIDESHOW) {
                    z = true;
                } else {
                    z = false;
                }
                spring.c = z;
                spring.a(1.0d).b(0.0d);
            }
        }

        public final void m21140c(ComposerAttachment composerAttachment) {
            this.f17177a.f17228w.requestFocus();
            UnderwoodController underwoodController = this.f17177a;
            underwoodController.f17195N++;
            if (this.f17177a.f17195N == this.f17177a.f17196O) {
                PhotoSequences photoSequences = this.f17177a.f17217l;
                String str = this.f17177a.f17194M;
                photoSequences.b.b(PhotoSequences.a, str, null, photoSequences.c.now());
            }
            MediaItem b = composerAttachment.b();
            if (this.f17177a.f17195N == 1 && MediaType.PHOTO.equals(b.m()) && ImageFormatChecker.a(b.f().getPath()) == ImageFormat.JPEG) {
                this.f17177a.f17183B.m21067c();
            }
        }

        public final void m21137a(ComposerAttachment composerAttachment, MediaItem mediaItem, CreativeEditingData creativeEditingData, boolean z, boolean z2) {
            int indexOf = this.f17177a.f17208a.indexOf(composerAttachment);
            if (indexOf != -1) {
                composerAttachment.b().f = null;
                Builder a = Builder.a(composerAttachment);
                a.e = creativeEditingData;
                ComposerAttachment a2 = a.a(mediaItem, this.f17177a.f17219n).a();
                boolean z3 = (Objects.equal(composerAttachment.b(), mediaItem) && creativeEditingData.o() == null && !z2) ? false : true;
                if (!this.f17177a.f17199R) {
                    this.f17177a.f17199R = z3;
                }
                AttachmentsViewEventListener attachmentsViewEventListener = this.f17177a.f17183B;
                ComposerEventOriginator composerEventOriginator = UnderwoodController.f17181d;
                attachmentsViewEventListener.m21063a(indexOf, a2, z3, z2);
                if (!z) {
                    this.f17177a.f17183B.m21066b();
                }
            }
        }

        public final void m21138a(ComposerAttachment composerAttachment, MediaItem mediaItem, VideoCreativeEditingData videoCreativeEditingData) {
            int indexOf = this.f17177a.f17208a.indexOf(composerAttachment);
            if (indexOf != -1) {
                composerAttachment.b().f = null;
                Builder a = Builder.a(composerAttachment);
                a.f = videoCreativeEditingData;
                ComposerAttachment a2 = a.a(mediaItem, this.f17177a.f17219n).a();
                AttachmentsViewEventListener attachmentsViewEventListener = this.f17177a.f17183B;
                ComposerEventOriginator composerEventOriginator = UnderwoodController.f17181d;
                attachmentsViewEventListener.m21063a(indexOf, a2, false, true);
            }
        }
    }

    /* compiled from: commercial_break_eligible */
    class CreativeEditingLoggerListener implements EventListener {
        final /* synthetic */ UnderwoodController f17178a;

        public CreativeEditingLoggerListener(UnderwoodController underwoodController) {
            this.f17178a = underwoodController;
        }

        public final void mo490a(String str) {
            CreativeEditingUsageParams b = m21141b(str);
            Map map = this.f17178a.f17222q;
            CreativeEditingUsageParams.Builder a = CreativeEditingUsageParams.m11495a(b);
            a.f9535d = b.f9550d + 1;
            map.put(str, a.m11494a());
        }

        public final void mo491a(String str, int i) {
            CreativeEditingUsageParams b = m21141b(str);
            Map map = this.f17178a.f17222q;
            CreativeEditingUsageParams.Builder a = CreativeEditingUsageParams.m11495a(b);
            a.f9537f = b.f9552f + i;
            map.put(str, a.m11494a());
        }

        public final void mo493b(String str, int i) {
            CreativeEditingUsageParams b = m21141b(str);
            Map map = this.f17178a.f17222q;
            CreativeEditingUsageParams.Builder a = CreativeEditingUsageParams.m11495a(b);
            a.f9536e = b.f9551e + i;
            map.put(str, a.m11494a());
        }

        public final void mo494c(String str, int i) {
            CreativeEditingUsageParams b = m21141b(str);
            Map map = this.f17178a.f17222q;
            CreativeEditingUsageParams.Builder a = CreativeEditingUsageParams.m11495a(b);
            a.f9538g = b.f9553g + i;
            map.put(str, a.m11494a());
        }

        public final void mo495d(String str, int i) {
            CreativeEditingUsageParams b = m21141b(str);
            Map map = this.f17178a.f17222q;
            CreativeEditingUsageParams.Builder a = CreativeEditingUsageParams.m11495a(b);
            a.f9539h = b.f9554h + i;
            map.put(str, a.m11494a());
        }

        public final void mo496e(String str, int i) {
            CreativeEditingUsageParams b = m21141b(str);
            Map map = this.f17178a.f17222q;
            CreativeEditingUsageParams.Builder a = CreativeEditingUsageParams.m11495a(b);
            a.f9544m = (b.f9559m + i) % 360;
            map.put(str, a.m11494a());
        }

        public final void mo492a(String str, SwipeableParams swipeableParams, int i) {
            CreativeEditingUsageParams b = m21141b(str);
            Map map = this.f17178a.f17222q;
            CreativeEditingUsageParams.Builder a = CreativeEditingUsageParams.m11495a(b);
            a.f9540i = b.f9555i + 1;
            CreativeEditingUsageParams.Builder builder = a;
            builder.f9545n = swipeableParams.b;
            map.put(str, builder.m11494a());
        }

        private CreativeEditingUsageParams m21141b(String str) {
            Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
            if (!this.f17178a.f17222q.containsKey(str)) {
                this.f17178a.f17222q.put(str, CreativeEditingUsageParams.newBuilder().m11494a());
            }
            return (CreativeEditingUsageParams) this.f17178a.f17222q.get(str);
        }
    }

    /* compiled from: commercial_break_eligible */
    class RemovePhotoSpringListener extends SimpleSpringListener {
        final /* synthetic */ UnderwoodController f17179a;

        public RemovePhotoSpringListener(UnderwoodController underwoodController) {
            this.f17179a = underwoodController;
        }

        public final void m21149a(Spring spring) {
            ((UnderwoodAttachmentViewController) this.f17179a.f17209b.get(this.f17179a.f17189H)).mo1340a((float) spring.d());
            UnderwoodController.m21157m(this.f17179a);
            this.f17179a.f17231z.requestLayout();
        }

        public final void m21150b(Spring spring) {
            if (this.f17179a.f17197P) {
                this.f17179a.f17183B.m21064a((ComposerAttachment) this.f17179a.f17208a.get(this.f17179a.f17189H));
                this.f17179a.f17216k.f17234a.d();
            }
            this.f17179a.f17189H = -1;
        }
    }

    public static UnderwoodController m21155b(InjectorLike injectorLike) {
        return new UnderwoodController((Context) injectorLike.getInstance(Context.class), LayoutInflaterMethodAutoProvider.a(injectorLike), TasksManager.a(injectorLike), ComposerAttachmentViewUtility.m21070a(injectorLike), UnderwoodLogger.m21167a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SpringSystem.a(injectorLike), PhotoSequences.a(injectorLike), IdBasedProvider.a(injectorLike, 4421), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (CreativeEditingUsageLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CreativeEditingUsageLoggerProvider.class), MediaItemFactory.a(injectorLike), CreativeEditingFileManager.a(injectorLike), (VerticalAttachmentViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VerticalAttachmentViewControllerProvider.class), (SphericalPhotoAttachmentViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SphericalPhotoAttachmentViewControllerProvider.class), (VideoPreviewAttachmentViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoPreviewAttachmentViewControllerProvider.class), (SlideshowAttachmentViewControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SlideshowAttachmentViewControllerProvider.class));
    }

    @Inject
    public UnderwoodController(Context context, LayoutInflater layoutInflater, TasksManager tasksManager, ComposerAttachmentViewUtility composerAttachmentViewUtility, UnderwoodLogger underwoodLogger, FbSharedPreferences fbSharedPreferences, SpringSystem springSystem, PhotoSequences photoSequences, Provider<Integer> provider, FbErrorReporter fbErrorReporter, CreativeEditingUsageLoggerProvider creativeEditingUsageLoggerProvider, MediaItemFactory mediaItemFactory, CreativeEditingFileManager creativeEditingFileManager, VerticalAttachmentViewControllerProvider verticalAttachmentViewControllerProvider, SphericalPhotoAttachmentViewControllerProvider sphericalPhotoAttachmentViewControllerProvider, VideoPreviewAttachmentViewControllerProvider videoPreviewAttachmentViewControllerProvider, SlideshowAttachmentViewControllerProvider slideshowAttachmentViewControllerProvider) {
        this.f17211f = context;
        this.f17207Z = verticalAttachmentViewControllerProvider;
        this.aa = sphericalPhotoAttachmentViewControllerProvider;
        this.ab = videoPreviewAttachmentViewControllerProvider;
        this.ac = slideshowAttachmentViewControllerProvider;
        this.f17212g = layoutInflater;
        this.f17214i = tasksManager;
        this.f17215j = composerAttachmentViewUtility;
        this.f17216k = underwoodLogger;
        this.f17184C = fbSharedPreferences;
        this.f17223r = creativeEditingFileManager;
        this.f17187F = springSystem.a().a(1.0d).l().a(f17180c).a(new RemovePhotoSpringListener(this));
        this.f17188G = provider;
        this.f17217l = photoSequences;
        this.f17218m = fbErrorReporter;
        this.f17221p = creativeEditingUsageLoggerProvider;
        this.f17219n = mediaItemFactory;
        this.f17189H = -1;
        this.f17186E = 0;
        this.f17208a = Lists.b();
        this.f17209b = Lists.b();
        this.f17213h = new AttachmentEventsListener(this);
        this.f17210e = this.f17184C.a(ComposerPrefKeys.j, true);
    }

    public final void m21158a(ViewGroup viewGroup, ScrollingAwareScrollView scrollingAwareScrollView, LinearLayout linearLayout, boolean z, boolean z2, DataProvider dataProvider) {
        FragmentManager fragmentManager;
        this.f17191J = z;
        this.f17192K = z2;
        this.f17194M = ((ProvidesSessionId) dataProvider).ab();
        this.f17182A = this.f17221p.m11493a(this.f17194M);
        this.f17226u = viewGroup;
        View view = this.f17226u;
        Preconditions.checkNotNull(view);
        FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(view.getContext(), FragmentManagerHost.class);
        if (fragmentManagerHost == null || !fragmentManagerHost.kO_().c()) {
            fragmentManager = null;
        } else {
            fragmentManager = fragmentManagerHost.kO_();
        }
        this.f17227v = fragmentManager;
        this.f17204W = ((ProvidesConfiguration) dataProvider).o().isEdit();
        this.f17205X = ((ProvidesConfiguration) dataProvider).o().canViewerEditPostMedia();
        this.f17202U = ((ProvidesIsMultimediaSupported) dataProvider).K();
        this.f17228w = scrollingAwareScrollView;
        this.f17228w.setTag("tag_scroll_View");
        this.f17228w.setFocusable(true);
        this.f17228w.setFocusableInTouchMode(true);
        this.f17228w.setDescendantFocusability(131072);
        this.f17228w.a(new C14033(this));
        this.f17228w.getViewTreeObserver().addOnGlobalLayoutListener(this.f17224s);
        this.f17231z = new VerticalAttachmentViewsContainer(this.f17211f);
        this.f17231z.f17330a = this.f17225t;
        this.f17230y = linearLayout;
        this.f17230y.addView(this.f17231z, new LayoutParams(-1, -2));
        this.f17190I = true;
        this.f17206Y = dataProvider;
        this.f17197P = true;
    }

    public final void m21162a(ImmutableMap<String, CreativeEditingUsageParams> immutableMap) {
        this.f17222q = new HashMap();
        Iterator it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            this.f17222q.put(entry.getKey(), entry.getValue());
        }
    }

    public final void m21163b(boolean z) {
        for (Entry entry : this.f17222q.entrySet()) {
            CreativeEditingUsageParams.Builder a = CreativeEditingUsageParams.m11495a((CreativeEditingUsageParams) entry.getValue());
            String str = (String) entry.getKey();
            Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
            for (ComposerAttachment composerAttachment : this.f17208a) {
                if (str.equals(composerAttachment.b().d().toString())) {
                    break;
                }
            }
            ComposerAttachment composerAttachment2 = null;
            ComposerAttachment composerAttachment3 = composerAttachment2;
            a.f9534c = z;
            if (composerAttachment3 != null) {
                a.f9533b = false;
                CreativeEditingData e = composerAttachment3.e();
                if (e != null) {
                    boolean z2;
                    a.f9541j = e.d().size();
                    CreativeEditingUsageParams.Builder builder = a;
                    builder.f9542k = e.e().size();
                    CreativeEditingUsageParams.Builder builder2 = builder;
                    if (e.c() != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    builder2.f9532a = z2;
                    builder2.f9545n = e.a();
                }
            } else {
                a.f9533b = true;
            }
            if (((CreativeEditingUsageParams) entry.getValue()).m11496a()) {
                a.f9546o = EntryPoint.COMPOSER;
            }
            CreativeEditingUsageParams a2 = a.m11494a();
            if (((CreativeEditingUsageParams) entry.getValue()).m11496a()) {
                this.f17182A.m11492a(str, a2);
            }
            entry.setValue(a2);
        }
    }

    public final List<Float> m21164f() {
        List<Float> a = Lists.a();
        for (UnderwoodAttachmentViewController c : this.f17209b) {
            a.add(Float.valueOf(c.mo1345c()));
        }
        return a;
    }

    public final void m21161a(ImmutableList<ComposerAttachment> immutableList, boolean z) {
        boolean z2 = true;
        int i = 0;
        this.f17196O = immutableList.size();
        if (!immutableList.isEmpty() && this.f17209b.isEmpty()) {
            this.f17228w.requestFocus();
        }
        Iterator it = this.f17208a.iterator();
        while (it.hasNext()) {
            ComposerAttachment composerAttachment = (ComposerAttachment) it.next();
            if (m21151a(composerAttachment, (List) immutableList) == -1 || z) {
                m21154a(composerAttachment, false);
                it.remove();
            }
        }
        int i2 = 0;
        while (i2 < immutableList.size()) {
            composerAttachment = (ComposerAttachment) immutableList.get(i2);
            int a = m21151a(composerAttachment, this.f17208a);
            if (a == -1) {
                m21156b(composerAttachment, i2);
            } else if (this.f17209b.size() < i2 + 1 || m21152a(i2).getClass().equals(((UnderwoodAttachmentViewController) this.f17209b.get(i2)).getClass())) {
                Object obj;
                if (a == i2) {
                    obj = 1;
                } else if (a >= this.f17209b.size() || i2 >= this.f17209b.size()) {
                    obj = null;
                } else {
                    this.f17231z.removeViewAt(a);
                    this.f17231z.addView(((UnderwoodAttachmentViewController) this.f17209b.get(a)).mo1351h(), i2);
                    this.f17208a.add(i2, this.f17208a.remove(a));
                    this.f17209b.add(i2, this.f17209b.remove(a));
                    int i3 = 1;
                }
                if (obj != null) {
                    this.f17208a.set(i2, composerAttachment);
                    ((UnderwoodAttachmentViewController) this.f17209b.get(i2)).mo1344b(composerAttachment);
                } else {
                    SoftErrorBuilder a2 = SoftError.a(getClass().getSimpleName(), "Unexpected failure: could not move attachment. \nfrom position: " + a + "\nto position: " + i2 + "\nmAttachments size: " + this.f17208a.size() + "\nmAttachmentControllers size: " + this.f17209b.size());
                    a2.d = true;
                    this.f17218m.a(a2.g());
                }
            } else {
                m21153a(composerAttachment, i2);
            }
            i2++;
        }
        if (this.f17208a.size() > 1) {
            for (UnderwoodAttachmentViewController underwoodAttachmentViewController : this.f17209b) {
                if (this.f17198Q) {
                    underwoodAttachmentViewController.mo1347d();
                } else {
                    underwoodAttachmentViewController.mo1348e();
                }
            }
        } else if (this.f17209b.size() == 1) {
            ((UnderwoodAttachmentViewController) this.f17209b.get(0)).mo1349f();
        }
        if (this.f17230y == null) {
            boolean z3;
            String simpleName = getClass().getSimpleName();
            StringBuilder append = new StringBuilder("Unexpected failure: attempting to set attachments before initializing. \nmIsInitialized: ").append(this.f17197P).append("\nmIsNewSession: ").append(this.f17191J).append("\nmAttachments is null: ").append(this.f17208a == null).append("\nmAttachmentViews is null: ");
            if (this.f17209b == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            StringBuilder append2 = append.append(z3).append("\nmAttachmentViewsContainer is null: ");
            if (this.f17231z != null) {
                z2 = false;
            }
            this.f17218m.a(SoftError.a(simpleName, append2.append(z2).append("\nmTotalAttachments: ").append(this.f17196O).toString()).g());
            return;
        }
        LinearLayout linearLayout = this.f17230y;
        if (this.f17208a.isEmpty()) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        m21165h();
    }

    private void m21153a(ComposerAttachment composerAttachment, int i) {
        this.f17231z.removeView(((UnderwoodAttachmentViewController) this.f17209b.get(i)).mo1351h());
        this.f17209b.remove(this.f17209b.get(i));
        this.f17208a.remove(i);
        m21156b(composerAttachment, i);
    }

    public final void m21160a(ImmutableList<PhotoItem> immutableList, TriState triState) {
        switch (C14055.f17176a[triState.ordinal()]) {
            case 1:
                this.f17190I = true;
                break;
            case 2:
                this.f17190I = false;
                break;
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            UnderwoodAttachmentViewController underwoodAttachmentViewController;
            PhotoItem photoItem = (PhotoItem) immutableList.get(i);
            for (UnderwoodAttachmentViewController underwoodAttachmentViewController2 : this.f17209b) {
                if (underwoodAttachmentViewController2.mo1352i().b().c() == photoItem.c()) {
                    underwoodAttachmentViewController = underwoodAttachmentViewController2;
                    if (underwoodAttachmentViewController != null) {
                        underwoodAttachmentViewController.mo1341a(this.f17190I);
                    }
                }
            }
            UnderwoodAttachmentViewController underwoodAttachmentViewController22 = null;
            underwoodAttachmentViewController = underwoodAttachmentViewController22;
            if (underwoodAttachmentViewController != null) {
                underwoodAttachmentViewController.mo1341a(this.f17190I);
            }
        }
    }

    private void m21156b(ComposerAttachment composerAttachment, int i) {
        this.f17208a.add(i, composerAttachment);
        UnderwoodAttachmentViewController a = m21152a(i);
        this.f17209b.add(i, a);
        a.mo1346c(composerAttachment);
        if (i > this.f17209b.size()) {
            this.f17231z.addView(a.mo1351h());
        } else {
            this.f17231z.addView(a.mo1351h(), i);
        }
        if (((ComposerAttachment) this.f17208a.get(i)).h() == -1) {
            Builder a2 = Builder.a((ComposerAttachment) this.f17208a.get(i));
            a2.h = a.mo1351h().getId();
            ComposerAttachment a3 = a2.a();
            this.f17208a.set(i, a3);
            a.mo1344b(a3);
            this.f17183B.m21063a(i, a3, false, false);
        }
        Object obj = null;
        if (composerAttachment.b() != null) {
            obj = composerAttachment.b().d().toString();
        }
        if (obj != null && !this.f17222q.containsKey(obj)) {
            this.f17222q.put(obj, CreativeEditingUsageParams.newBuilder().m11494a());
        }
    }

    private void m21154a(ComposerAttachment composerAttachment, boolean z) {
        int indexOf = this.f17208a.indexOf(composerAttachment);
        if (indexOf >= 0) {
            if (z) {
                this.f17208a.remove(indexOf);
            }
            View h = ((UnderwoodAttachmentViewController) this.f17209b.remove(indexOf)).mo1351h();
            String mediaIdKey = composerAttachment.b().d().toString();
            if (this.f17222q.containsKey(mediaIdKey)) {
                CreativeEditingUsageParams creativeEditingUsageParams = (CreativeEditingUsageParams) this.f17222q.get(mediaIdKey);
                CreativeEditingData e = composerAttachment.e();
                if (e != null && creativeEditingUsageParams.m11496a()) {
                    boolean z2;
                    Map map = this.f17222q;
                    CreativeEditingUsageParams.Builder a = CreativeEditingUsageParams.m11495a(creativeEditingUsageParams);
                    a.f9541j = e.d().size();
                    a = a;
                    a.f9542k = e.e().size();
                    CreativeEditingUsageParams.Builder builder = a;
                    if (e.c() != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    builder.f9532a = z2;
                    map.put(mediaIdKey, builder.m11494a());
                }
            }
            this.f17231z.removeView(h);
        }
    }

    private UnderwoodAttachmentViewController m21152a(int i) {
        UnderwoodAttachmentViewController underwoodAttachmentViewController;
        SphericalPhotoAttachmentViewController a = this.aa.m21122a(this.f17206Y, this.f17213h);
        VideoPreviewAttachmentViewController a2 = this.ab.m21261a(this.f17206Y, this.f17213h, this.f17227v, this.f17194M);
        ImmutableList of = ImmutableList.of(a, a2, this.ac.m21105a(this.f17206Y, Integer.valueOf(i), this.f17213h), this.f17207Z.m21231a(this.f17227v, Integer.valueOf(this.f17186E), Integer.valueOf(i), this.f17194M, this.f17204W, this.f17205X, this.f17213h, this.f17220o, this.f17206Y, this.f17193L, this.f17190I, this.f17199R, this.f17228w));
        int size = of.size();
        for (int i2 = 0; i2 < size; i2++) {
            UnderwoodAttachmentViewController underwoodAttachmentViewController2 = (UnderwoodAttachmentViewController) of.get(i2);
            if (underwoodAttachmentViewController2.mo1342a((ComposerAttachment) this.f17208a.get(i))) {
                underwoodAttachmentViewController = underwoodAttachmentViewController2;
                break;
            }
        }
        underwoodAttachmentViewController = null;
        Preconditions.checkNotNull(underwoodAttachmentViewController, "Attachment type is not supported!");
        View h = underwoodAttachmentViewController.mo1351h();
        int h2 = ((ComposerAttachment) this.f17208a.get(i)).h();
        if (h2 == -1) {
            h2 = ViewIdUtil.a();
        }
        h.setId(h2);
        if (i == 0) {
            h.setTag("first_attachment_view");
        }
        return underwoodAttachmentViewController;
    }

    public static void m21157m(UnderwoodController underwoodController) {
        for (UnderwoodAttachmentViewController underwoodAttachmentViewController : underwoodController.f17209b) {
            underwoodAttachmentViewController.mo1339a();
            underwoodAttachmentViewController.mo1343b();
        }
    }

    public final void m21165h() {
        if (this.f17197P && !this.f17192K) {
            int i = (this.f17208a.isEmpty() || this.f17208a.size() >= ((Integer) this.f17188G.get()).intValue() || !this.f17185D || !(((ComposerAttachment) this.f17208a.get(0)).b().m() == MediaType.PHOTO || this.f17202U)) ? 0 : 1;
            if (i != 0 || this.f17229x != null) {
                if (this.f17229x == null) {
                    this.f17212g.inflate(2130907601, this.f17230y);
                    this.f17229x = (FrameLayout) this.f17230y.findViewById(2131563423);
                    ((TextView) this.f17229x.findViewById(2131568181)).setText(this.f17202U ? 2131234722 : 2131234721);
                    this.f17229x.setVisibility(8);
                    this.f17229x.setOnClickListener(new C14044(this));
                }
                FrameLayout frameLayout = this.f17229x;
                if (i != 0) {
                    i = 0;
                } else {
                    i = 8;
                }
                frameLayout.setVisibility(i);
            }
        }
    }

    private static int m21151a(ComposerAttachment composerAttachment, List<ComposerAttachment> list) {
        MediaItem b = composerAttachment.b();
        for (int i = 0; i < list.size(); i++) {
            MediaItem b2 = ((ComposerAttachment) list.get(i)).b();
            if (b.c() == b2.c() && b.g() == b2.g() && b.e().equals(b2.e())) {
                return i;
            }
        }
        return -1;
    }

    public final void m21159a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        for (UnderwoodAttachmentViewController a : this.f17209b) {
            a.a(composerEvent, composerEventOriginator);
        }
    }

    public final void m21166i() {
        if (!Strings.isNullOrEmpty(this.f17194M)) {
            this.f17223r.a(this.f17194M);
        }
    }
}
