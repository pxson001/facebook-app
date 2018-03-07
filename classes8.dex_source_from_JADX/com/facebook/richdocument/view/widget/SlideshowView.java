package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.genesis.BlockViewHolderFactoryProvider;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.ImageBlockData;
import com.facebook.richdocument.model.data.VideoBlockData;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBVideo;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.MediaView;
import com.facebook.richdocument.view.widget.media.MediaViewDelegate;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnItemClickListener;
import javax.inject.Inject;

/* compiled from: offer_fbid */
public class SlideshowView extends BetterRecyclerView implements MediaView {
    @Inject
    RichDocumentAnalyticsLogger f7492l;
    @Inject
    public BlockViewHolderFactoryProvider f7493m;
    public MediaViewDelegate f7494n;
    protected int f7495o;
    protected int f7496p;
    public int f7497q;

    /* compiled from: offer_fbid */
    class C08571 implements OnItemClickListener {
        final /* synthetic */ SlideshowView f7490a;

        C08571(SlideshowView slideshowView) {
            this.f7490a = slideshowView;
        }

        public final void m7695a(BetterRecyclerView betterRecyclerView, View view, int i, long j) {
            this.f7490a.getMediaFrame().mo482c();
        }
    }

    /* compiled from: offer_fbid */
    class SlideshowLayoutManager extends BetterLinearLayoutManager {
        private final OrientationHelper f7491a = OrientationHelper.a(this, this.j);

        public SlideshowLayoutManager(Context context, int i, boolean z) {
            super(context, i, z);
        }

        protected final int m7696a(State state) {
            return this.f7491a.f();
        }
    }

    private static <T extends View> void m7702a(Class<T> cls, T t) {
        m7703a((Object) t, t.getContext());
    }

    private static void m7703a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SlideshowView) obj).m7701a(RichDocumentAnalyticsLogger.m5360a(fbInjector), (BlockViewHolderFactoryProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(BlockViewHolderFactoryProvider.class));
    }

    public SlideshowView(Context context) {
        this(context, null);
    }

    public SlideshowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideshowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7702a(SlideshowView.class, (View) this);
        m7704p();
    }

    private void m7704p() {
        setLayoutManager(new SlideshowLayoutManager(getContext(), 0, false));
        this.f7494n = new MediaViewDelegate(this);
        setOnItemClickListener(new C08571(this));
    }

    private void m7701a(RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, BlockViewHolderFactoryProvider blockViewHolderFactoryProvider) {
        this.f7492l = richDocumentAnalyticsLogger;
        this.f7493m = blockViewHolderFactoryProvider;
    }

    public MediaFrame getMediaFrame() {
        return (MediaFrame) getParent().getParent();
    }

    public final boolean m7706b(int i, int i2) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        this.f7495o = linearLayoutManager.l();
        this.f7496p = linearLayoutManager.n();
        if (this.f7495o == this.f7496p) {
            return false;
        }
        boolean z;
        View c = linearLayoutManager.c(this.f7495o);
        View c2 = linearLayoutManager.c(this.f7496p);
        int width = getWidth();
        if (((float) Math.abs(i)) <= RichDocumentUIConfig.f6565r) {
            int a = m7699a(c, width);
            int a2 = m7699a(c2, width);
            if (a >= a2) {
                c2 = c;
            }
            a(c2.getLeft() - ((width - c2.getWidth()) / 2), 0);
            if (a < a2) {
                z = true;
            }
            z = false;
        } else if (i > 0) {
            a(c2.getLeft() - ((width - c2.getWidth()) / 2), 0);
            z = true;
        } else {
            a(c.getLeft() - ((width - c.getWidth()) / 2), 0);
            z = false;
        }
        m7705b(z);
        return true;
    }

    protected void m7705b(boolean z) {
        if (z) {
            this.f7492l.m5364a("swipe", this.f7495o + 2, this.f7497q);
        }
    }

    private static int m7699a(View view, int i) {
        return Math.min(view.getRight(), i) - Math.max(0, view.getLeft());
    }

    public void m7707o() {
    }

    protected void onMeasure(int i, int i2) {
        Rect a = this.f7494n.m7853a();
        super.onMeasure(MeasureSpec.makeMeasureSpec(a.width(), 1073741824), MeasureSpec.makeMeasureSpec(a.height(), 1073741824));
    }

    public float getMediaAspectRatio() {
        return this.f7494n.f7604b;
    }

    public View getView() {
        return this;
    }

    public final boolean ja_() {
        return false;
    }

    public static float m7697a(RichDocumentBlocksImpl richDocumentBlocksImpl) {
        int i = 0;
        if (richDocumentBlocksImpl == null || richDocumentBlocksImpl.m5459c() == 0) {
            return 0.0f;
        }
        int i2;
        float[] fArr = new float[richDocumentBlocksImpl.m5459c()];
        for (i2 = 0; i2 < richDocumentBlocksImpl.m5459c(); i2++) {
            fArr[i2] = m7698a(richDocumentBlocksImpl.m5457a(i2));
        }
        int[] iArr = new int[richDocumentBlocksImpl.m5459c()];
        i2 = 0;
        int i3 = 0;
        while (i < richDocumentBlocksImpl.m5459c()) {
            iArr[i] = m7700a(fArr, fArr[i], (float) RichDocumentUIConfig.f6561n);
            if (iArr[i] > i3) {
                i3 = iArr[i];
                i2 = i;
            }
            i++;
        }
        return fArr[i2];
    }

    protected static int m7700a(float[] fArr, float f, float f2) {
        int i = 0;
        for (float f3 : fArr) {
            if (Math.abs(f3 - f) <= f2) {
                i++;
            }
        }
        return i;
    }

    private static float m7698a(BlockData blockData) {
        if ((blockData instanceof ImageBlockData) && ((ImageBlockData) blockData).mo289a() != null) {
            FBFullImageFragmentModel c = ((ImageBlockData) blockData).mo289a().mo316c();
            return ((float) c.bD_()) / ((float) c.a());
        } else if (!(blockData instanceof VideoBlockData) || ((VideoBlockData) blockData).mo305p() == null) {
            return 0.0f;
        } else {
            FBVideo p = ((VideoBlockData) blockData).mo305p();
            return ((float) p.mo338y()) / ((float) p.mo320g());
        }
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -887999814);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -165604634, a);
    }

    public int getSlideCount() {
        return this.o.aZ_();
    }
}
