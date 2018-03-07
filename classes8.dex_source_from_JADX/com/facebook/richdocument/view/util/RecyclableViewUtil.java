package com.facebook.richdocument.view.util;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.richdocument.model.data.AnnotatableBlock;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.ImageBlockData;
import com.facebook.richdocument.model.data.SlideshowBlockData;
import com.facebook.richdocument.model.data.impl.MapBlockDataImpl;
import com.facebook.richdocument.view.RichDocumentAdapter;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: openidConnectEmailConfirmation */
public class RecyclableViewUtil {
    private final RichDocumentAdapter f7052a;
    private final SparseArray<ViewCountEstimator> f7053b = new C08001(this);
    public final SparseIntArray f7054c = new C08012(this);

    /* compiled from: openidConnectEmailConfirmation */
    class C08001 extends SparseArray<ViewCountEstimator> {
        final /* synthetic */ RecyclableViewUtil f7050a;

        C08001(RecyclableViewUtil recyclableViewUtil) {
            this.f7050a = recyclableViewUtil;
            put(2130906884, new UFIViewCountEstimator());
            put(2130906862, new TextAnnotationViewCountEstimator());
            put(2130906878, new ImageMediaFrameCountEstimator());
        }
    }

    /* compiled from: openidConnectEmailConfirmation */
    class C08012 extends SparseIntArray {
        final /* synthetic */ RecyclableViewUtil f7051a;

        C08012(RecyclableViewUtil recyclableViewUtil) {
            this.f7051a = recyclableViewUtil;
            put(2130906884, RichDocumentUIConfig.f6532C);
            put(2130906862, RichDocumentUIConfig.f6533D);
            put(2130906878, RichDocumentUIConfig.f6534E);
        }
    }

    /* compiled from: openidConnectEmailConfirmation */
    interface ViewCountEstimator {
        int mo436a(BlockData blockData);
    }

    /* compiled from: openidConnectEmailConfirmation */
    class ImageMediaFrameCountEstimator implements ViewCountEstimator {
        ImageMediaFrameCountEstimator() {
        }

        public final int mo436a(BlockData blockData) {
            if ((blockData instanceof ImageBlockData) || (blockData instanceof MapBlockDataImpl)) {
                return 1;
            }
            if (!(blockData instanceof SlideshowBlockData) || ((SlideshowBlockData) blockData).mo304a() == null) {
                return 0;
            }
            return ((SlideshowBlockData) blockData).mo304a().m5459c();
        }
    }

    /* compiled from: openidConnectEmailConfirmation */
    class TextAnnotationViewCountEstimator implements ViewCountEstimator {
        TextAnnotationViewCountEstimator() {
        }

        public final int mo436a(BlockData blockData) {
            int i = 0;
            if (!(blockData instanceof AnnotatableBlock)) {
                return 0;
            }
            int i2;
            AnnotatableBlock annotatableBlock = (AnnotatableBlock) blockData;
            if (annotatableBlock.mo273c() != null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (annotatableBlock.iV_() != null) {
                i2++;
            }
            if (annotatableBlock.mo274e() != null) {
                i2++;
            }
            if (!(blockData instanceof SlideshowBlockData) || ((SlideshowBlockData) blockData).mo304a() == null || ((SlideshowBlockData) blockData).mo304a().m5459c() <= 0) {
                return i2;
            }
            SlideshowBlockData slideshowBlockData = (SlideshowBlockData) blockData;
            int c = slideshowBlockData.mo304a().m5459c();
            while (i < c) {
                BlockData a = slideshowBlockData.mo304a().m5457a(i);
                if (a instanceof AnnotatableBlock) {
                    annotatableBlock = (AnnotatableBlock) a;
                    if (annotatableBlock.mo273c() != null) {
                        i2++;
                    }
                    if (annotatableBlock.iV_() != null) {
                        i2++;
                    }
                    if (annotatableBlock.mo274e() != null) {
                        i2++;
                    }
                }
                i++;
            }
            return i2;
        }
    }

    /* compiled from: openidConnectEmailConfirmation */
    class UFIViewCountEstimator implements ViewCountEstimator {
        UFIViewCountEstimator() {
        }

        public final int mo436a(BlockData blockData) {
            int i = 0;
            if (blockData instanceof AnnotatableBlock) {
                int i2;
                AnnotatableBlock annotatableBlock = (AnnotatableBlock) blockData;
                if (annotatableBlock.mo280j() == null || annotatableBlock.mo281k() == null) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (!(blockData instanceof SlideshowBlockData) || ((SlideshowBlockData) blockData).mo304a() == null || ((SlideshowBlockData) blockData).mo304a().m5459c() <= 0) {
                    return i2;
                }
                SlideshowBlockData slideshowBlockData = (SlideshowBlockData) blockData;
                int c = slideshowBlockData.mo304a().m5459c();
                int i3 = 0;
                i = i2;
                while (i3 < c) {
                    int i4;
                    BlockData a = slideshowBlockData.mo304a().m5457a(i3);
                    if (!(a instanceof AnnotatableBlock) || ((AnnotatableBlock) a).mo280j() == null || ((AnnotatableBlock) a).mo281k() == null) {
                        i4 = i;
                    } else {
                        i4 = i + 1;
                    }
                    i3++;
                    i = i4;
                }
            }
            return i;
        }
    }

    public RecyclableViewUtil(RichDocumentAdapter richDocumentAdapter) {
        this.f7052a = richDocumentAdapter;
    }

    public final Map<Integer, Integer> m7363a(Set<Integer> set) {
        Map<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < this.f7052a.aZ_(); i++) {
            Object obj;
            for (Integer num : set) {
                if (this.f7054c.get(num.intValue(), -1) != -1 && hashMap.containsKey(num)) {
                    if (((Integer) hashMap.get(num)).intValue() < this.f7054c.get(num.intValue())) {
                        obj = 1;
                        break;
                    }
                }
                obj = 1;
                break;
            }
            obj = null;
            if (obj == null) {
                break;
            }
            BlockData e = this.f7052a.m6882e(i);
            for (Integer num2 : set) {
                if (this.f7053b.get(num2.intValue()) != null) {
                    int a = ((ViewCountEstimator) this.f7053b.get(num2.intValue())).mo436a(e);
                    if (hashMap.containsKey(num2)) {
                        hashMap.put(num2, Integer.valueOf(((Integer) hashMap.get(num2)).intValue() + a));
                    } else {
                        hashMap.put(num2, Integer.valueOf(a));
                    }
                }
            }
        }
        return hashMap;
    }
}
