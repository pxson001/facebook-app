package com.facebook.photos.simplepicker.controller;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.TriState;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerConfiguration;
import com.facebook.photos.base.media.MediaItemsOperator;
import com.facebook.photos.base.media.MediaItemsOperator.SelectMode;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.simplepicker.PrefilledTaggingCallback;
import com.facebook.photos.simplepicker.SimplePickerFlowLogger;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03806;
import com.facebook.photos.simplepicker.abtest.SimplePickerExperimentsUtil;
import com.facebook.photos.simplepicker.controller.SimplePickerViewController.C04061;
import com.facebook.photos.simplepicker.logging.SimplePickerSequences;
import com.facebook.photos.simplepicker.view.PickerPlayableView;
import com.facebook.photos.simplepicker.view.SelectableView;
import com.facebook.qe.api.QeAccessor;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.toaster.ToastProperties;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: share_offer */
public class PickerSelectionController {
    public final Map<MediaItem, Integer> f3094a;
    private final Set<MediaItemsOperator> f3095b;
    public final SimplePickerFlowLogger f3096c;
    private final int f3097d;
    private final Lazy<Toaster> f3098e;
    private final C03806 f3099f;
    public final SequenceLogger f3100g;
    private final QeAccessor f3101h;
    public C04061 f3102i = new C04061(this);
    private boolean f3103j;
    private boolean f3104k;
    public boolean f3105l;
    public int f3106m;
    private ToastProperties f3107n;
    public boolean f3108o;
    private final boolean f3109p;
    private MediaItem f3110q;
    private Lazy<FbErrorReporter> f3111r;
    private PickerPlayableView f3112s = null;
    private PickerPlayableView f3113t = null;
    private int f3114u = 0;

    /* compiled from: share_offer */
    class C03991 implements Comparator<MediaItem> {
        final /* synthetic */ PickerSelectionController f3093a;

        C03991(PickerSelectionController pickerSelectionController) {
            this.f3093a = pickerSelectionController;
        }

        public int compare(Object obj, Object obj2) {
            return ((Integer) this.f3093a.f3094a.get((MediaItem) obj)).intValue() - ((Integer) this.f3093a.f3094a.get((MediaItem) obj2)).intValue();
        }
    }

    @Inject
    public PickerSelectionController(@Assisted SimplePickerConfiguration simplePickerConfiguration, @Assisted PrefilledTaggingCallback prefilledTaggingCallback, Lazy<Toaster> lazy, SimplePickerFlowLogger simplePickerFlowLogger, Provider<TriState> provider, Provider<Integer> provider2, SequenceLogger sequenceLogger, Lazy<FbErrorReporter> lazy2, QeAccessor qeAccessor) {
        this.f3103j = simplePickerConfiguration.a;
        this.f3109p = simplePickerConfiguration.i;
        this.f3099f = prefilledTaggingCallback;
        this.f3098e = lazy;
        this.f3096c = simplePickerFlowLogger;
        this.f3108o = provider.get() == TriState.YES;
        if (simplePickerConfiguration.r <= 0) {
            this.f3097d = ((Integer) provider2.get()).intValue();
        } else {
            this.f3097d = Math.min(((Integer) provider2.get()).intValue(), simplePickerConfiguration.r);
        }
        this.f3100g = sequenceLogger;
        this.f3094a = Maps.c();
        this.f3095b = Sets.a();
        m3125a(false);
        this.f3111r = lazy2;
        this.f3101h = qeAccessor;
    }

    public final void m3132a(ImmutableList<MediaItem> immutableList) {
        Preconditions.checkNotNull(immutableList);
        this.f3094a.clear();
        for (int i = 0; i < immutableList.size(); i++) {
            this.f3094a.put(immutableList.get(i), Integer.valueOf(i + 1));
        }
        this.f3106m = this.f3094a.size();
        m3125a(false);
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            m3126b((MediaItem) immutableList.get(i2));
        }
        for (MediaItemsOperator mediaItemsOperator : this.f3095b) {
            int size2 = immutableList.size();
            for (size = 0; size < size2; size++) {
                mediaItemsOperator.a((MediaItem) immutableList.get(size), SelectMode.PRESELECTED);
            }
        }
    }

    public final ImmutableList<MediaItem> m3129a() {
        Collection a = Lists.a(this.f3094a.keySet());
        Collections.sort(a, new C03991(this));
        return ImmutableList.copyOf(a);
    }

    public final void m3131a(SelectableView selectableView) {
        MediaItem mediaItem = selectableView.getMediaItem();
        if (this.f3094a.containsKey(mediaItem)) {
            selectableView.mo154a(((Integer) this.f3094a.get(mediaItem)).intValue(), this.f3105l);
        } else if (selectableView.isSelected()) {
            selectableView.mo155e();
        }
    }

    public final void m3134b(SelectableView selectableView) {
        if (selectableView.mo156f()) {
            boolean a = SimplePickerExperimentsUtil.m2989a(this.f3101h);
            if (selectableView.isSelected()) {
                if (this.f3112s != null && selectableView.getItemType().equals(PickerGridItemType.VIDEO) && a && selectableView.getId() == ((SelectableView) this.f3112s).getId()) {
                    if (this.f3113t != null) {
                        this.f3113t.hO_();
                    }
                    ((PickerPlayableView) selectableView).mo173a(selectableView.getSelectedOrder());
                    this.f3113t = (PickerPlayableView) selectableView;
                }
                m3128d(selectableView);
                return;
            }
            this.f3099f.f2906a.aq();
            Sequence e = this.f3100g.e(SimplePickerSequences.f3186a);
            if (e != null) {
                SequenceLoggerDetour.e(e, "GridItemSelected", -493329093);
            }
            MediaItem mediaItem = selectableView.getMediaItem();
            if (mediaItem != null && m3133a(mediaItem)) {
                if (this.f3108o) {
                    this.f3096c.m2938a(mediaItem.m().toString(), selectableView.getIndex());
                }
                selectableView.mo154a(this.f3106m, this.f3105l);
            }
            if (selectableView.getItemType().equals(PickerGridItemType.VIDEO) && a) {
                if (this.f3112s != null) {
                    this.f3112s.hN_();
                }
                if (this.f3113t != null) {
                    this.f3113t.hO_();
                }
                this.f3112s = (PickerPlayableView) selectableView;
                this.f3112s.mo175h();
            }
        }
    }

    public final void m3130a(MediaItemsOperator mediaItemsOperator) {
        Preconditions.checkNotNull(mediaItemsOperator);
        this.f3095b.add(mediaItemsOperator);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m3133a(com.facebook.ipc.media.MediaItem r10) {
        /*
        r9 = this;
        r2 = 1;
        r1 = 0;
        r0 = r9.f3094a;
        r0 = r0.containsKey(r10);
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        return r0;
    L_0x000c:
        r0 = r10 instanceof com.facebook.photos.base.media.VideoItem;
        if (r0 == 0) goto L_0x0064;
    L_0x0010:
        r0 = r10.e();
        if (r0 == 0) goto L_0x0064;
    L_0x0016:
        r0 = new java.io.File;
        r3 = r10.e();
        r0.<init>(r3);
        r3 = r0.isFile();
        if (r3 == 0) goto L_0x0064;
    L_0x0025:
        r4 = r0.length();
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 <= 0) goto L_0x0045;
    L_0x0030:
        r0 = r9.f3098e;
        r0 = r0.get();
        r0 = (com.facebook.ui.toaster.Toaster) r0;
        r2 = new com.facebook.ui.toaster.ToastBuilder;
        r3 = 2131234415; // 0x7f080e6f float:1.8084995E38 double:1.0529697077E-314;
        r2.<init>(r3);
        r0.b(r2);
        r0 = r1;
        goto L_0x000b;
    L_0x0045:
        r4 = r0.length();
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x0064;
    L_0x004f:
        r0 = r9.f3098e;
        r0 = r0.get();
        r0 = (com.facebook.ui.toaster.Toaster) r0;
        r2 = new com.facebook.ui.toaster.ToastBuilder;
        r3 = 2131234416; // 0x7f080e70 float:1.8084997E38 double:1.052969708E-314;
        r2.<init>(r3);
        r0.b(r2);
        r0 = r1;
        goto L_0x000b;
    L_0x0064:
        r0 = r10 instanceof com.facebook.photos.base.media.PhotoItem;
        if (r0 == 0) goto L_0x00e7;
    L_0x0068:
        r0 = r10;
        r0 = (com.facebook.photos.base.media.PhotoItem) r0;
        r8 = r0.c;
        r0 = r8;
        if (r0 == 0) goto L_0x00e7;
    L_0x0070:
        r0 = r9.m3127b();
        if (r0 == 0) goto L_0x008b;
    L_0x0076:
        r0 = r9.f3098e;
        r0 = r0.get();
        r0 = (com.facebook.ui.toaster.Toaster) r0;
        r2 = new com.facebook.ui.toaster.ToastBuilder;
        r3 = 2131234403; // 0x7f080e63 float:1.808497E38 double:1.052969702E-314;
        r2.<init>(r3);
        r0.b(r2);
        r0 = r1;
        goto L_0x000b;
    L_0x008b:
        r0 = r9.f3114u;
        if (r0 != 0) goto L_0x0168;
    L_0x008f:
        r0 = r9.f3106m;
        if (r0 <= 0) goto L_0x0168;
    L_0x0093:
        r0 = r2;
    L_0x0094:
        if (r0 == 0) goto L_0x00a9;
    L_0x0096:
        r0 = r9.f3098e;
        r0 = r0.get();
        r0 = (com.facebook.ui.toaster.Toaster) r0;
        r3 = new com.facebook.ui.toaster.ToastBuilder;
        r4 = 2131234404; // 0x7f080e64 float:1.8084973E38 double:1.0529697023E-314;
        r3.<init>(r4);
        r0.b(r3);
    L_0x00a9:
        r0 = r9.f3106m;
        if (r0 <= 0) goto L_0x013c;
    L_0x00ad:
        r0 = r9.f3109p;
        if (r0 != 0) goto L_0x00ef;
    L_0x00b1:
        r0 = r10 instanceof com.facebook.photos.base.media.VideoItem;
        r3 = r9.f3104k;
        r0 = r0 ^ r3;
        if (r0 == 0) goto L_0x00ef;
    L_0x00b8:
        r0 = r9.f3107n;
        if (r0 == 0) goto L_0x00ce;
    L_0x00bc:
        r0 = r9.f3107n;
        r8 = r0.a;
        r8 = r8.getView();
        r8 = r8.getWindowVisibility();
        if (r8 != 0) goto L_0x016b;
    L_0x00ca:
        r8 = 1;
    L_0x00cb:
        r0 = r8;
        if (r0 != 0) goto L_0x00e4;
    L_0x00ce:
        r0 = r9.f3098e;
        r0 = r0.get();
        r0 = (com.facebook.ui.toaster.Toaster) r0;
        r2 = new com.facebook.ui.toaster.ToastBuilder;
        r3 = 2131234402; // 0x7f080e62 float:1.8084969E38 double:1.0529697013E-314;
        r2.<init>(r3);
        r0 = r0.b(r2);
        r9.f3107n = r0;
    L_0x00e4:
        r0 = r1;
        goto L_0x000b;
    L_0x00e7:
        r0 = r9.m3127b();
        if (r0 == 0) goto L_0x0168;
    L_0x00ed:
        r0 = r2;
        goto L_0x0094;
    L_0x00ef:
        r0 = r9.f3106m;
        r3 = r9.f3097d;
        if (r0 < r3) goto L_0x0115;
    L_0x00f5:
        r0 = r9.f3098e;
        r0 = r0.get();
        r0 = (com.facebook.ui.toaster.Toaster) r0;
        r3 = new com.facebook.ui.toaster.ToastBuilder;
        r4 = 2131234405; // 0x7f080e65 float:1.8084975E38 double:1.0529697027E-314;
        r2 = new java.lang.Object[r2];
        r5 = r9.f3097d;
        r5 = java.lang.Integer.valueOf(r5);
        r2[r1] = r5;
        r3.<init>(r4, r2);
        r0.b(r3);
        r0 = r1;
        goto L_0x000b;
    L_0x0115:
        r0 = r9.f3105l;
        if (r0 != 0) goto L_0x013c;
    L_0x0119:
        r0 = r9.f3102i;
        r0 = r0.m3154a();
        r3 = r0.iterator();
    L_0x0123:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0133;
    L_0x0129:
        r0 = r3.next();
        r0 = (com.facebook.photos.simplepicker.view.SelectableView) r0;
        r0.mo155e();
        goto L_0x0123;
    L_0x0133:
        r0 = r9.f3094a;
        r0.clear();
        r9.f3106m = r1;
        r9.f3114u = r1;
    L_0x013c:
        r9.m3126b(r10);
        r0 = r9.f3094a;
        r1 = r9.f3106m;
        r1 = r1 + 1;
        r9.f3106m = r1;
        r1 = java.lang.Integer.valueOf(r1);
        r0.put(r10, r1);
        r0 = r10 instanceof com.facebook.photos.base.media.PhotoItem;
        if (r0 == 0) goto L_0x0160;
    L_0x0152:
        r0 = r10;
        r0 = (com.facebook.photos.base.media.PhotoItem) r0;
        r8 = r0.c;
        r0 = r8;
        if (r0 == 0) goto L_0x0160;
    L_0x015a:
        r0 = r9.f3114u;
        r0 = r0 + 1;
        r9.f3114u = r0;
    L_0x0160:
        r0 = com.facebook.photos.base.media.MediaItemsOperator.SelectMode.SELECT;
        r9.m3124a(r10, r0);
        r0 = r2;
        goto L_0x000b;
    L_0x0168:
        r0 = r1;
        goto L_0x0094;
    L_0x016b:
        r8 = 0;
        goto L_0x00cb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.simplepicker.controller.PickerSelectionController.a(com.facebook.ipc.media.MediaItem):boolean");
    }

    private void m3128d(SelectableView selectableView) {
        MediaItem mediaItem = selectableView.getMediaItem();
        if (this.f3108o) {
            String str;
            SimplePickerFlowLogger simplePickerFlowLogger = this.f3096c;
            if (selectableView == null || selectableView.getMediaItem() == null || selectableView.getMediaItem().l() == null) {
                str = "";
            } else {
                str = selectableView.getMediaItem().l().toString();
            }
            simplePickerFlowLogger.m2942c(str);
        }
        int selectedOrder = selectableView.getSelectedOrder();
        selectableView.mo155e();
        if (!(mediaItem == null || !mediaItem.equals(this.f3110q) || this.f3109p)) {
            m3125a(false);
        }
        if (mediaItem != null) {
            this.f3094a.remove(mediaItem);
            this.f3106m--;
        } else {
            ((AbstractFbErrorReporter) this.f3111r.get()).a(PickerSelectionController.class.getSimpleName(), "getMediaItem is null");
        }
        if ((mediaItem instanceof PhotoItem) && ((PhotoItem) mediaItem).c) {
            this.f3114u--;
        }
        for (MediaItem mediaItem2 : this.f3094a.keySet()) {
            int intValue = ((Integer) this.f3094a.get(mediaItem2)).intValue();
            if (intValue > selectedOrder) {
                this.f3094a.put(mediaItem2, Integer.valueOf(intValue - 1));
            }
        }
        for (SelectableView selectableView2 : this.f3102i.m3154a()) {
            if (selectableView2.isSelected() && selectableView2.getSelectedOrder() > selectedOrder) {
                selectableView2.mo154a(selectableView2.getSelectedOrder() - 1, this.f3105l);
            }
        }
        if (selectableView.getMediaItem() != null) {
            m3124a(selectableView.getMediaItem(), SelectMode.DESELECT);
        }
    }

    private void m3124a(MediaItem mediaItem, SelectMode selectMode) {
        Preconditions.checkNotNull(mediaItem);
        for (MediaItemsOperator a : this.f3095b) {
            a.a(mediaItem, selectMode);
        }
    }

    private void m3126b(MediaItem mediaItem) {
        if (mediaItem instanceof VideoItem) {
            this.f3110q = mediaItem;
            m3125a(true);
        }
    }

    private void m3125a(boolean z) {
        if (!z) {
            this.f3110q = null;
        }
        this.f3104k = z;
        boolean z2 = this.f3103j && (!this.f3104k || this.f3109p);
        this.f3105l = z2;
    }

    private boolean m3127b() {
        return this.f3114u == 1 && this.f3106m == 1;
    }
}
