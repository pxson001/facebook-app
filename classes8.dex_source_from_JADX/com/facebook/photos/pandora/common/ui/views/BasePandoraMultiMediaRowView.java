package com.facebook.photos.pandora.common.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.accessibility.AccessibilityNodeProvider;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.dialtone.common.IsDialtonePhotoFeatureEnabled;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.DegradableDraweeController;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.feed.rows.core.ViewBindingsMap;
import com.facebook.feed.rows.core.parts.SinglePartDefinitionBinder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.util.VideoPlayIconDrawingHelper;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition.Props;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegate.VideoSizeAndBackgroundOverride;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLVideoConversionHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.events.PandoraEventBus;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEvent;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow;
import com.facebook.photos.pandora.logging.PandoraLoadedCounter;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.photos.pandora.logging.PandoraSequences;
import com.facebook.photos.pandora.protocols.PandoraModelConversionHelper;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;
import com.facebook.sequencelogger.Sequence;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.google.android.gms.cast.internal.ICastDeviceController */
public class BasePandoraMultiMediaRowView extends CustomViewGroup implements OnTouchListener {
    private static final CallerContext f17512i = CallerContext.a(BasePandoraMultiMediaRowView.class, "photo_pandora");
    private static final boolean f17513j = (VERSION.SDK_INT < 11);
    @Inject
    public Lazy<PandoraEventBus> f17514a;
    @Inject
    Provider<FbDraweeControllerBuilder> f17515b;
    @Inject
    PandoraSequenceLogger f17516c;
    @Inject
    PandoraLoadedCounter f17517d;
    @Inject
    @IsDialtonePhotoFeatureEnabled
    Provider<Boolean> f17518e;
    @Inject
    VideoPlayIconDrawingHelper f17519f;
    @Inject
    PandoraInlineVideoPartDefinitionBinderProvider f17520g;
    @Inject
    Lazy<DefaultTimeFormatUtil> f17521h;
    private int f17522k;
    public final ThumbnailEntry[] f17523l = new ThumbnailEntry[getNumOfItems()];
    public PandoraInstanceId f17524m;
    public PandoraRequestSource f17525n;
    public String f17526o;
    public boolean f17527p;
    private boolean f17528q;
    private boolean f17529r;
    private ThumbnailEntry f17530s;
    private InlineVideoAttachmentView f17531t;
    private PandoraInlineVideoPartDefinitionBinder f17532u;
    private PandoraAccessibilityHelper f17533v;

    public static void m21491a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BasePandoraMultiMediaRowView) obj).m21490a(IdBasedSingletonScopeProvider.b(injectorLike, 9375), IdBasedProvider.a(injectorLike, 1117), PandoraSequenceLogger.m21549a(injectorLike), PandoraLoadedCounter.m21547a(injectorLike), IdBasedProvider.a(injectorLike, 3959), VideoPlayIconDrawingHelper.a(injectorLike), (PandoraInlineVideoPartDefinitionBinderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PandoraInlineVideoPartDefinitionBinderProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 610));
    }

    private void m21490a(Lazy<PandoraEventBus> lazy, Provider<FbDraweeControllerBuilder> provider, PandoraSequenceLogger pandoraSequenceLogger, PandoraLoadedCounter pandoraLoadedCounter, Provider<Boolean> provider2, VideoPlayIconDrawingHelper videoPlayIconDrawingHelper, PandoraInlineVideoPartDefinitionBinderProvider pandoraInlineVideoPartDefinitionBinderProvider, Lazy<DefaultTimeFormatUtil> lazy2) {
        this.f17514a = lazy;
        this.f17515b = provider;
        this.f17516c = pandoraSequenceLogger;
        this.f17517d = pandoraLoadedCounter;
        this.f17518e = provider2;
        this.f17519f = videoPlayIconDrawingHelper;
        this.f17520g = pandoraInlineVideoPartDefinitionBinderProvider;
        this.f17521h = lazy2;
    }

    public BasePandoraMultiMediaRowView(Context context) {
        super(context);
    }

    protected void mo1048a() {
        int i;
        int i2 = 0;
        Class cls = BasePandoraMultiMediaRowView.class;
        m21491a((Object) this, getContext());
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131363277)));
        this.f17522k = getResources().getColor(2131363279);
        int color = getResources().getColor(2131363278);
        setWillNotCacheDrawing(true);
        setWillNotDraw(false);
        setOnTouchListener(this);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        if (f17513j) {
            i = 0;
        } else {
            i = 200;
        }
        genericDraweeHierarchyBuilder.d = i;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = genericDraweeHierarchyBuilder;
        while (i2 < getNumOfItems()) {
            if (!f17513j) {
                genericDraweeHierarchyBuilder2.f = new ColorDrawable(color);
            }
            this.f17523l[i2] = new ThumbnailEntry(DraweeHolder.a(genericDraweeHierarchyBuilder2.u(), getContext()));
            this.f17523l[i2].f17566a.setCallback(this);
            i2++;
        }
        this.f17533v = new PandoraAccessibilityHelper(this);
    }

    public void mo1049a(PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow, PandoraInstanceId pandoraInstanceId, PandoraRequestSource pandoraRequestSource, String str, boolean z, boolean z2, boolean z3, @Nullable PandoraInlineVideoEnvironment pandoraInlineVideoEnvironment) {
        this.f17524m = pandoraInstanceId;
        this.f17525n = pandoraRequestSource;
        this.f17526o = str;
        this.f17527p = z;
        this.f17528q = z2;
        this.f17529r = z3;
        if (this.f17529r && pandoraInlineVideoEnvironment != null && this.f17531t == null) {
            this.f17531t = new InlineVideoAttachmentView(getContext());
            addView(this.f17531t);
            PandoraInlineVideoPartDefinitionBinderProvider pandoraInlineVideoPartDefinitionBinderProvider = this.f17520g;
            this.f17532u = new PandoraInlineVideoPartDefinitionBinder(pandoraInlineVideoEnvironment, InlineVideoPartDefinition.a(pandoraInlineVideoPartDefinitionBinderProvider), (AbstractFbErrorReporter) FbErrorReporterImpl.a(pandoraInlineVideoPartDefinitionBinderProvider));
        }
    }

    public final void m21501b() {
        if (this.f17529r) {
            int height;
            if (this.f17530s != null) {
                PandoraInlineVideoPartDefinitionBinder pandoraInlineVideoPartDefinitionBinder = this.f17532u;
                InlineVideoAttachmentView inlineVideoAttachmentView = this.f17531t;
                ViewBindingsMap.a(inlineVideoAttachmentView);
                pandoraInlineVideoPartDefinitionBinder.f17550d.b(inlineVideoAttachmentView);
                this.f17530s = null;
                this.f17531t.setVisibility(8);
            }
            for (ThumbnailEntry thumbnailEntry : this.f17523l) {
                if (thumbnailEntry.f17572g != null) {
                    this.f17530s = thumbnailEntry;
                    break;
                }
            }
            if (m21493a(this.f17530s)) {
                this.f17531t.setVisibility(0);
                Builder a = Builder.a(StoryAttachmentHelper.o(this.f17530s.f17572g.z()));
                a.l = GraphQLVideoConversionHelper.a(this.f17530s.f17572g);
                FeedProps a2 = FeedProps.c(this.f17530s.f17572g.z()).a(a.a());
                PandoraInlineVideoPartDefinitionBinder pandoraInlineVideoPartDefinitionBinder2 = this.f17532u;
                int width = this.f17530s.f17567b.width();
                height = this.f17530s.f17567b.height();
                InlineVideoAttachmentView inlineVideoAttachmentView2 = this.f17531t;
                pandoraInlineVideoPartDefinitionBinder2.f17550d = new SinglePartDefinitionBinder(new Props(a2, -1, Optional.of(new VideoSizeAndBackgroundOverride(width, height, 0)), new AtomicReference()), pandoraInlineVideoPartDefinitionBinder2.f17547a);
                pandoraInlineVideoPartDefinitionBinder2.f17550d.a(pandoraInlineVideoPartDefinitionBinder2.f17548b);
                ViewBindingsMap.a(inlineVideoAttachmentView2, pandoraInlineVideoPartDefinitionBinder2.f17550d, pandoraInlineVideoPartDefinitionBinder2.f17549c);
                pandoraInlineVideoPartDefinitionBinder2.f17550d.a(inlineVideoAttachmentView2);
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        for (ThumbnailEntry thumbnailEntry : this.f17523l) {
            if (thumbnailEntry.f17566a != null) {
                thumbnailEntry.f17566a.draw(canvas);
                if (thumbnailEntry.f17572g != null) {
                    this.f17519f.a(canvas, thumbnailEntry.f17566a.getBounds());
                }
            }
        }
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f17529r && m21493a(this.f17530s)) {
            this.f17531t.measure(MeasureSpec.makeMeasureSpec(this.f17530s.f17567b.width(), 1073741824), MeasureSpec.makeMeasureSpec(this.f17530s.f17567b.height(), 1073741824));
        }
        int defaultSize = View.getDefaultSize(getSuggestedMinimumHeight(), i2);
        int rowHeight = getRowHeight();
        if (rowHeight == defaultSize) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), rowHeight);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f17529r && m21493a(this.f17530s)) {
            this.f17531t.layout(this.f17530s.f17567b.left, this.f17530s.f17567b.top, this.f17530s.f17567b.right, this.f17530s.f17567b.bottom);
        }
    }

    private static boolean m21493a(ThumbnailEntry thumbnailEntry) {
        return (thumbnailEntry == null || thumbnailEntry.f17572g == null || thumbnailEntry.f17572g.z() == null || StoryAttachmentHelper.o(thumbnailEntry.f17572g.z()) == null) ? false : true;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 256073801);
        super.onAttachedToWindow();
        m21495d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1899170014, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        m21496e();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m21495d();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1642138216);
        super.onDetachedFromWindow();
        m21496e();
        m21502c();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 127530151, a);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable)) {
            return true;
        }
        for (ThumbnailEntry thumbnailEntry : this.f17523l) {
            if (thumbnailEntry.f17566a == drawable) {
                return true;
            }
        }
        return false;
    }

    private void m21495d() {
        for (ThumbnailEntry thumbnailEntry : this.f17523l) {
            thumbnailEntry.f17568c.b();
        }
    }

    private void m21496e() {
        for (ThumbnailEntry thumbnailEntry : this.f17523l) {
            thumbnailEntry.f17568c.d();
        }
    }

    protected final void m21499a(Rect rect, Uri uri, PandoraMediaModel pandoraMediaModel, int i, final String str) {
        if (uri != null) {
            if (this.f17527p) {
                this.f17516c.m21551a("LoadImageThumbnail");
            }
            C18611 c18611 = new BaseControllerListener(this) {
                final /* synthetic */ BasePandoraMultiMediaRowView f17511b;

                public final void m21487a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                    int i;
                    if (this.f17511b.f17527p) {
                        this.f17511b.f17516c.m21552a("LoadImageThumbnail", "ExtraImageThumbnailType", str);
                    }
                    if (str.equals("LoadLandscapeImageThumbnail") || str.equals("LoadPortraitImageThumbnail")) {
                        i = 6;
                    } else if (str.equals("LoadSquareImageThumbnail")) {
                        i = 4;
                    } else {
                        i = 1;
                    }
                    PandoraLoadedCounter pandoraLoadedCounter = this.f17511b.f17517d;
                    String str2 = this.f17511b.f17526o;
                    if (!Strings.isNullOrEmpty(str2)) {
                        if (str2.equals("LoadScreenImagesPhotosOf")) {
                            pandoraLoadedCounter.f17576a += i;
                        }
                        if (str2.equals("LoadScreenImagesUploads")) {
                            pandoraLoadedCounter.f17577b += i;
                        }
                        if (str2.equals("LoadScreenImagesAlbum")) {
                            pandoraLoadedCounter.f17578c += i;
                        }
                    }
                    pandoraLoadedCounter = this.f17511b.f17517d;
                    str2 = this.f17511b.f17526o;
                    int i2 = -1;
                    if (!Strings.isNullOrEmpty(str2)) {
                        if (str2.equals("LoadScreenImagesPhotosOf")) {
                            i2 = pandoraLoadedCounter.f17576a;
                        } else if (str2.equals("LoadScreenImagesUploads")) {
                            i2 = pandoraLoadedCounter.f17577b;
                        } else if (str2.equals("LoadScreenImagesAlbum")) {
                            i2 = pandoraLoadedCounter.f17578c;
                        }
                    }
                    int i3 = i2;
                    if (i3 >= 12 && i3 - i < 12 && this.f17511b.f17527p) {
                        this.f17511b.f17516c.m21552a("LoadScreenImages", "ExtraLoadScreenImagesSource", this.f17511b.f17526o);
                        this.f17511b.f17516c.f17580a.b(PandoraSequences.f17581a);
                    }
                }

                public final void m21488b(String str, Throwable th) {
                    if (this.f17511b.f17527p) {
                        PandoraSequenceLogger pandoraSequenceLogger = this.f17511b.f17516c;
                        String str2 = "LoadImageThumbnail";
                        String str3 = str;
                        Sequence e = pandoraSequenceLogger.f17580a.e(PandoraSequences.f17581a);
                        if (e != null) {
                            SequenceLoggerDetour.c(e, str2, null, ImmutableBiMap.b("ExtraImageThumbnailType", str3), -273932505);
                        }
                    }
                }
            };
            ThumbnailEntry thumbnailEntry = this.f17523l[i];
            FbPipelineDraweeController s = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f17515b.get()).a(f17512i).b(thumbnailEntry.f17568c.f)).a(c18611)).b(uri).s();
            thumbnailEntry.f17567b = rect;
            thumbnailEntry.f17568c.a(s);
            thumbnailEntry.f17569d = pandoraMediaModel.d();
            thumbnailEntry.f17570e = uri;
            thumbnailEntry.f17571f = PandoraModelConversionHelper.a(pandoraMediaModel);
            thumbnailEntry.f17572g = PandoraModelConversionHelper.b(pandoraMediaModel);
            thumbnailEntry.f17566a.setVisible(this.f17528q, true);
            thumbnailEntry.f17566a.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            thumbnailEntry.f17573h = m21489a(pandoraMediaModel, thumbnailEntry.f17572g == null);
        }
    }

    private CharSequence m21489a(PandoraMediaModel pandoraMediaModel, boolean z) {
        if (pandoraMediaModel.j() != null) {
            CharSequence j = pandoraMediaModel.j();
        } else {
            Object string = getContext().getString(z ? 2131230814 : 2131230815);
        }
        if (pandoraMediaModel.B() == null) {
            return j;
        }
        String a = ((DefaultTimeFormatUtil) this.f17521h.get()).a(TimeFormatStyle.EXACT_STREAM_RELATIVE_STYLE, pandoraMediaModel.B().d() * 1000);
        StringBuilder stringBuilder = new StringBuilder((j.length() + 2) + a.length());
        stringBuilder.append(j);
        stringBuilder.append(". ");
        stringBuilder.append(a);
        return stringBuilder;
    }

    protected final void m21502c() {
        m21496e();
        for (ThumbnailEntry thumbnailEntry : this.f17523l) {
            thumbnailEntry.f17566a.setBounds(0, 0, 0, 0);
            thumbnailEntry.f17568c.a(null);
            thumbnailEntry.f17569d = "";
            thumbnailEntry.f17570e = null;
            thumbnailEntry.f17573h = "";
        }
    }

    private void m21492a(String str, Uri uri, GraphQLPhoto graphQLPhoto) {
        ((PandoraEventBus) this.f17514a.get()).a(new LaunchConsumptionGalleryEvent(str, uri, this.f17524m, this.f17525n, graphQLPhoto));
    }

    private ThumbnailEntry m21494b(int i, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i < 0) {
            i = 0;
        }
        for (ThumbnailEntry thumbnailEntry : this.f17523l) {
            if (thumbnailEntry.f17567b != null && thumbnailEntry.f17567b.contains(r6, r7)) {
                return thumbnailEntry;
            }
        }
        return null;
    }

    final int m21497a(int i, int i2) {
        int i3 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i < 0) {
            i = 0;
        }
        while (i3 < this.f17523l.length) {
            ThumbnailEntry thumbnailEntry = this.f17523l[i3];
            if (thumbnailEntry.f17567b != null && thumbnailEntry.f17567b.contains(r4, r5)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            return false;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            for (ThumbnailEntry thumbnailEntry : this.f17523l) {
                if (thumbnailEntry.f17566a != null) {
                    thumbnailEntry.f17566a.setColorFilter(null);
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 3) {
            return true;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        ThumbnailEntry b = m21494b((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
        if (b == null) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                b.f17566a.setColorFilter(this.f17522k, Mode.SRC_OVER);
                break;
            case 1:
                if (!((Boolean) this.f17518e.get()).booleanValue()) {
                    if (b.f17572g == null) {
                        m21492a(b.f17569d, b.f17570e, b.f17571f);
                        break;
                    }
                    ((PandoraEventBus) this.f17514a.get()).a(new LaunchConsumptionGalleryEvent(b.f17569d, this.f17524m, this.f17525n, b.f17572g));
                    break;
                }
                ((DegradableDraweeController) b.f17568c.f).c();
                break;
        }
        invalidate(b.f17567b.left, b.f17567b.top, b.f17567b.right, b.f17567b.bottom);
        return true;
    }

    protected int getRowHeight() {
        return 0;
    }

    public int getNumOfItems() {
        return 1;
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        return (AccessibilityNodeProvider) this.f17533v.b;
    }

    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f17533v == null || !this.f17533v.a(motionEvent)) {
            return super.dispatchHoverEvent(motionEvent);
        }
        return true;
    }
}
