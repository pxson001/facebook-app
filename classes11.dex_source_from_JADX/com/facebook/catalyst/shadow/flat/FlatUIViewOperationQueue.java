package com.facebook.catalyst.shadow.flat;

import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.NoSuchNativeViewException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.UIViewOperationQueue.UIOperation;
import javax.annotation.Nullable;

/* compiled from: login_with_facebook */
final class FlatUIViewOperationQueue extends UIViewOperationQueue {
    public static final int[] f5728a = new int[4];
    public final FlatNativeViewHierarchyManager f5729b;
    private final ProcessLayoutRequests f5730c = new ProcessLayoutRequests(this);

    /* compiled from: login_with_facebook */
    public final class DetachAllChildrenFromViews implements UIOperation {
        final /* synthetic */ FlatUIViewOperationQueue f5694a;
        @Nullable
        public int[] f5695b;

        public DetachAllChildrenFromViews(FlatUIViewOperationQueue flatUIViewOperationQueue) {
            this.f5694a = flatUIViewOperationQueue;
        }

        public final void m7048a() {
            this.f5694a.f5729b.m6979b(this.f5695b);
        }
    }

    /* compiled from: login_with_facebook */
    final class DropViews implements UIOperation {
        final /* synthetic */ FlatUIViewOperationQueue f5696a;
        private final int[] f5697b;

        public DropViews(FlatUIViewOperationQueue flatUIViewOperationQueue, int[] iArr) {
            this.f5696a = flatUIViewOperationQueue;
            this.f5697b = iArr;
        }

        public final void m7049a() {
            this.f5696a.f5729b.m6977a(this.f5697b);
        }
    }

    /* compiled from: login_with_facebook */
    final class MeasureVirtualView implements UIOperation {
        final /* synthetic */ FlatUIViewOperationQueue f5698a;
        private final int f5699b;
        private final float f5700c;
        private final float f5701d;
        private final float f5702e;
        private final float f5703f;
        private final Callback f5704g;

        private MeasureVirtualView(FlatUIViewOperationQueue flatUIViewOperationQueue, int i, float f, float f2, float f3, float f4, Callback callback) {
            this.f5698a = flatUIViewOperationQueue;
            this.f5699b = i;
            this.f5700c = f;
            this.f5701d = f2;
            this.f5702e = f3;
            this.f5703f = f4;
            this.f5704g = callback;
        }

        public final void m7050a() {
            try {
                this.f5698a.f5729b.a(this.f5699b, FlatUIViewOperationQueue.f5728a);
                float f = (float) FlatUIViewOperationQueue.f5728a[1];
                float f2 = (float) FlatUIViewOperationQueue.f5728a[2];
                float f3 = (float) FlatUIViewOperationQueue.f5728a[3];
                float c = PixelUtil.c(((float) FlatUIViewOperationQueue.f5728a[0]) + (this.f5700c * f2));
                f = PixelUtil.c(f + (this.f5701d * f3));
                f2 = PixelUtil.c(f2 * this.f5702e);
                f3 = PixelUtil.c(f3 * this.f5703f);
                this.f5704g.a(new Object[]{Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(c), Float.valueOf(f)});
            } catch (NoSuchNativeViewException e) {
                this.f5704g.a(new Object[0]);
            }
        }
    }

    /* compiled from: login_with_facebook */
    final class ProcessLayoutRequests implements UIOperation {
        final /* synthetic */ FlatUIViewOperationQueue f5705a;

        public ProcessLayoutRequests(FlatUIViewOperationQueue flatUIViewOperationQueue) {
            this.f5705a = flatUIViewOperationQueue;
        }

        public final void m7051a() {
            int size = FlatViewGroup.f5731a.size();
            for (int i = 0; i != size; i++) {
                FlatViewGroup flatViewGroup = (FlatViewGroup) FlatViewGroup.f5731a.get(i);
                int i2 = 0;
                flatViewGroup.f5739i = false;
                int childCount = flatViewGroup.getChildCount();
                while (i2 != childCount) {
                    View childAt = flatViewGroup.getChildAt(i2);
                    if (childAt.isLayoutRequested()) {
                        childAt.measure(MeasureSpec.makeMeasureSpec(childAt.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(childAt.getHeight(), 1073741824));
                        childAt.layout(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                    }
                    i2++;
                }
            }
            FlatViewGroup.f5731a.clear();
        }
    }

    /* compiled from: login_with_facebook */
    final class SetPadding implements UIOperation {
        final /* synthetic */ FlatUIViewOperationQueue f5706a;
        private final int f5707b;
        private final int f5708c;
        private final int f5709d;
        private final int f5710e;
        private final int f5711f;

        private SetPadding(FlatUIViewOperationQueue flatUIViewOperationQueue, int i, int i2, int i3, int i4, int i5) {
            this.f5706a = flatUIViewOperationQueue;
            this.f5707b = i;
            this.f5708c = i2;
            this.f5709d = i3;
            this.f5710e = i4;
            this.f5711f = i5;
        }

        public final void m7052a() {
            this.f5706a.f5729b.m6978b(this.f5707b, this.f5708c, this.f5709d, this.f5710e, this.f5711f);
        }
    }

    /* compiled from: login_with_facebook */
    final class UpdateMountState implements UIOperation {
        final /* synthetic */ FlatUIViewOperationQueue f5712a;
        private final int f5713b;
        @Nullable
        private final DrawCommand[] f5714c;
        @Nullable
        private final AttachDetachListener[] f5715d;
        @Nullable
        private final NodeRegion[] f5716e;
        private final boolean f5717f;

        private UpdateMountState(FlatUIViewOperationQueue flatUIViewOperationQueue, int i, @Nullable DrawCommand[] drawCommandArr, @Nullable AttachDetachListener[] attachDetachListenerArr, @Nullable NodeRegion[] nodeRegionArr, boolean z) {
            this.f5712a = flatUIViewOperationQueue;
            this.f5713b = i;
            this.f5714c = drawCommandArr;
            this.f5715d = attachDetachListenerArr;
            this.f5716e = nodeRegionArr;
            this.f5717f = z;
        }

        public final void m7053a() {
            this.f5712a.f5729b.m6975a(this.f5713b, this.f5714c, this.f5715d, this.f5716e, this.f5717f);
        }
    }

    /* compiled from: login_with_facebook */
    public final class UpdateViewBounds implements UIOperation {
        final /* synthetic */ FlatUIViewOperationQueue f5718a;
        private final int f5719b;
        private final int f5720c;
        private final int f5721d;
        private final int f5722e;
        private final int f5723f;

        private UpdateViewBounds(FlatUIViewOperationQueue flatUIViewOperationQueue, int i, int i2, int i3, int i4, int i5) {
            this.f5718a = flatUIViewOperationQueue;
            this.f5719b = i;
            this.f5720c = i2;
            this.f5721d = i3;
            this.f5722e = i4;
            this.f5723f = i5;
        }

        public final void m7054a() {
            this.f5718a.f5729b.m6972a(this.f5719b, this.f5720c, this.f5721d, this.f5722e, this.f5723f);
        }
    }

    /* compiled from: login_with_facebook */
    final class UpdateViewGroup implements UIOperation {
        final /* synthetic */ FlatUIViewOperationQueue f5724a;
        private final int f5725b;
        private final int[] f5726c;
        private final int[] f5727d;

        public UpdateViewGroup(FlatUIViewOperationQueue flatUIViewOperationQueue, int i, int[] iArr, int[] iArr2) {
            this.f5724a = flatUIViewOperationQueue;
            this.f5725b = i;
            this.f5726c = iArr;
            this.f5727d = iArr2;
        }

        public final void m7055a() {
            this.f5724a.f5729b.m6974a(this.f5725b, this.f5726c, this.f5727d);
        }
    }

    public FlatUIViewOperationQueue(ReactApplicationContext reactApplicationContext, FlatNativeViewHierarchyManager flatNativeViewHierarchyManager) {
        super(reactApplicationContext, flatNativeViewHierarchyManager);
        this.f5729b = flatNativeViewHierarchyManager;
    }

    public final void m7061a(int i, @Nullable DrawCommand[] drawCommandArr, @Nullable AttachDetachListener[] attachDetachListenerArr, @Nullable NodeRegion[] nodeRegionArr, boolean z) {
        a(new UpdateMountState(i, drawCommandArr, attachDetachListenerArr, nodeRegionArr, z));
    }

    public final void m7060a(int i, int[] iArr, int[] iArr2) {
        a(new UpdateViewGroup(this, i, iArr, iArr2));
    }

    public final UpdateViewBounds m7058a(int i, int i2, int i3, int i4, int i5) {
        return new UpdateViewBounds(i, i2, i3, i4, i5);
    }

    public final void m7062a(UpdateViewBounds updateViewBounds) {
        a(updateViewBounds);
    }

    public final void m7064b(int i, int i2, int i3, int i4, int i5) {
        a(new SetPadding(i, i2, i3, i4, i5));
    }

    public final void m7063a(int[] iArr) {
        a(new DropViews(this, iArr));
    }

    public final void m7059a(int i, float f, float f2, float f3, float f4, Callback callback) {
        a(new MeasureVirtualView(i, f, f2, f3, f4, callback));
    }

    public final void m7065e() {
        a(this.f5730c);
    }

    public final DetachAllChildrenFromViews m7066f() {
        DetachAllChildrenFromViews detachAllChildrenFromViews = new DetachAllChildrenFromViews(this);
        a(detachAllChildrenFromViews);
        return detachAllChildrenFromViews;
    }
}
