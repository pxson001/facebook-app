package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.common.util.SizeUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentAlignmentDescriptorType;
import com.facebook.graphql.enums.GraphQLInstantShoppingPresentationStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.model.block.text.InstantShoppingText.InstantShoppingTextBuilder;
import com.facebook.instantshopping.model.block.text.InstantShoppingTextBlockWrapper;
import com.facebook.instantshopping.model.data.InstantShoppingBlockData;
import com.facebook.instantshopping.model.data.InstantShoppingMediaBlock;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingTextElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingTextMetricsDescriptorFragmentModel;
import com.facebook.instantshopping.utils.InstantShoppingTextUtils;
import com.facebook.richdocument.genesis.BlockViewHolderFactoryProvider;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.ImageBlockData;
import com.facebook.richdocument.view.RichDocumentAdapter;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.widget.SlideshowView;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: SHARE_ITEM */
public class InstantShoppingSlideshowView extends SlideshowView {
    @Inject
    public InstantShoppingTextUtils f23920r;
    @Inject
    public ScreenUtil f23921s;
    @Inject
    InstantShoppingAnalyticsLogger f23922t;
    @Inject
    BlockViewHolderFactoryProvider f23923u;
    public InstantShoppingSlideChangeListener f23924v;
    private int f23925w;
    private RichDocumentBlocksImpl f23926x;

    /* compiled from: SHARE_ITEM */
    public interface InstantShoppingSlideChangeListener {
        void mo1036a(int i);
    }

    private static <T extends View> void m25194a(Class<T> cls, T t) {
        m25195a((Object) t, t.getContext());
    }

    private static void m25195a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((InstantShoppingSlideshowView) obj).m25193a(InstantShoppingTextUtils.b(injectorLike), ScreenUtil.a(injectorLike), InstantShoppingAnalyticsLogger.m24853a(injectorLike), (BlockViewHolderFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BlockViewHolderFactoryProvider.class));
    }

    private void m25193a(InstantShoppingTextUtils instantShoppingTextUtils, ScreenUtil screenUtil, InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger, BlockViewHolderFactoryProvider blockViewHolderFactoryProvider) {
        this.f23920r = instantShoppingTextUtils;
        this.f23921s = screenUtil;
        this.f23922t = instantShoppingAnalyticsLogger;
        this.f23923u = blockViewHolderFactoryProvider;
    }

    public InstantShoppingSlideshowView(Context context) {
        super(context);
        m25194a(InstantShoppingSlideshowView.class, (View) this);
    }

    public InstantShoppingSlideshowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25194a(InstantShoppingSlideshowView.class, (View) this);
    }

    public final void m25198o() {
        this.f23925w = 0;
    }

    public InstantShoppingSlideshowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setInstantShoppingSlides(RichDocumentBlocksImpl richDocumentBlocksImpl) {
        this.f23926x = richDocumentBlocksImpl;
        setAdapter(new RichDocumentAdapter(getContext(), richDocumentBlocksImpl, this.f23923u.a(null), (LinearLayoutManager) getLayoutManager(), this, null));
        this.f23922t.m24856a(((InstantShoppingBlockData) richDocumentBlocksImpl.a(this.f23925w)).mo1008C());
        this.n.b = m25189a(richDocumentBlocksImpl);
    }

    public void setSlideChangeListener(InstantShoppingSlideChangeListener instantShoppingSlideChangeListener) {
        this.f23924v = instantShoppingSlideChangeListener;
    }

    protected final void m25197b(boolean z) {
        if (this.f23925w > this.o && !z) {
            this.f23925w--;
        } else if (this.f23925w < this.p && z) {
            this.f23925w++;
        }
        this.f23922t.m24856a(((InstantShoppingBlockData) this.f23926x.a(this.f23925w)).mo1008C());
        this.f23924v.mo1036a(this.f23925w);
    }

    private float m25189a(RichDocumentBlocksImpl richDocumentBlocksImpl) {
        int i = 0;
        if (richDocumentBlocksImpl.c() == 0) {
            return 0.0f;
        }
        int i2;
        Object obj;
        float[] fArr = new float[richDocumentBlocksImpl.c()];
        for (i2 = 0; i2 < richDocumentBlocksImpl.c(); i2++) {
            fArr[i2] = m25190a(richDocumentBlocksImpl.a(i2));
        }
        int c = richDocumentBlocksImpl.c();
        for (int i3 = 0; i3 < c; i3++) {
            BlockData a = richDocumentBlocksImpl.a(i3);
            if (a instanceof InstantShoppingMediaBlock) {
                InstantShoppingMediaBlock instantShoppingMediaBlock = (InstantShoppingMediaBlock) a;
                obj = (instantShoppingMediaBlock.mo1009D() == null || instantShoppingMediaBlock.mo1009D().isEmpty() || instantShoppingMediaBlock.mo1010E().contains(GraphQLInstantShoppingPresentationStyle.FIT_TO_HEIGHT)) ? null : 1;
                if (obj == null) {
                    obj = 1;
                    break;
                }
            }
        }
        obj = null;
        if (obj != null) {
            return m25191a(fArr);
        }
        int[] iArr = new int[richDocumentBlocksImpl.c()];
        i2 = 0;
        int i4 = 0;
        while (i < richDocumentBlocksImpl.c()) {
            iArr[i] = SlideshowView.a(fArr, fArr[i], (float) RichDocumentUIConfig.n);
            if (iArr[i] > i4) {
                i4 = iArr[i];
                i2 = i;
            }
            i++;
        }
        return fArr[i2];
    }

    private static float m25191a(float[] fArr) {
        int i = 0;
        float f = fArr[0];
        while (i < fArr.length) {
            f = Math.min(fArr[i], f);
            i++;
        }
        return f;
    }

    private float m25190a(BlockData blockData) {
        if (!(blockData instanceof ImageBlockData) || ((ImageBlockData) blockData).a() == null || ((ImageBlockData) blockData).a().c() == null) {
            return 0.0f;
        }
        FBFullImageFragmentModel c = ((ImageBlockData) blockData).a().c();
        float b = m25196b(blockData);
        return ((float) c.bD_()) / (((float) (b > 0.0f ? SizeUtil.a(getContext(), 30.0f) : 0)) + (((float) c.a()) + b));
    }

    private float m25196b(BlockData blockData) {
        if (!(blockData instanceof InstantShoppingMediaBlock)) {
            return 0.0f;
        }
        if (((InstantShoppingMediaBlock) blockData).mo1009D() == null || ((InstantShoppingMediaBlock) blockData).mo1009D().isEmpty()) {
            return 0.0f;
        }
        InstantShoppingTextBlockWrapper instantShoppingTextBlockWrapper = new InstantShoppingTextBlockWrapper((InstantShoppingTextElementFragment) ((InstantShoppingMediaBlock) blockData).mo1009D().get(0));
        RichText a = m25192a(getContext(), instantShoppingTextBlockWrapper);
        InstantShoppingTextMetricsDescriptorFragmentModel nu_ = instantShoppingTextBlockWrapper.nu_();
        BetterTextView betterTextView = new BetterTextView(getContext());
        betterTextView.setText(a.a);
        if (nu_ != null) {
            this.f23920r.a(betterTextView, GraphQLInstantShoppingDocumentAlignmentDescriptorType.LEFT, nu_);
        }
        betterTextView.measure(MeasureSpec.makeMeasureSpec(this.f23921s.c() - (SizeUtil.a(getContext(), 20.0f) * 2), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        return (float) betterTextView.getMeasuredHeight();
    }

    private static RichText m25192a(Context context, InstantShoppingTextBlockWrapper instantShoppingTextBlockWrapper) {
        return new InstantShoppingTextBuilder(context, instantShoppingTextBlockWrapper.m24906f()).a(instantShoppingTextBlockWrapper).a();
    }
}
