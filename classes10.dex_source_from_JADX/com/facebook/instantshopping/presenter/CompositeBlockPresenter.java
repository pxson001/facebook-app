package com.facebook.instantshopping.presenter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.facebook.common.util.SizeUtil;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentElementType;
import com.facebook.inject.FbInjector;
import com.facebook.instantshopping.model.block.InstantShoppingBlocksUtil;
import com.facebook.instantshopping.model.data.CompositeBlockData;
import com.facebook.instantshopping.model.data.impl.BaseInstantShoppingMediaBlock.BaseInstantShoppingMediaBlockBuilder;
import com.facebook.instantshopping.model.data.impl.ColorPickerBlockDataImpl;
import com.facebook.instantshopping.model.data.impl.CompositeBlockDataImpl;
import com.facebook.instantshopping.model.data.impl.InstantShoppingImageBlockDataImpl.InstantShoppingImageBlockDataBuilder;
import com.facebook.instantshopping.model.data.impl.InstantShoppingTextBlockDataImpl;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingCompositeBlockElementFragmentModel.BlockElementsModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingElementDescriptorFragmentModel;
import com.facebook.instantshopping.view.block.CompositeBlockView;
import com.facebook.instantshopping.view.block.impl.CompositeBlockViewImpl;
import com.facebook.richdocument.genesis.BlockViewHolderFactory;
import com.facebook.richdocument.genesis.BlockViewHolderFactoryProvider;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: SUGGESTED_CONTENT */
public class CompositeBlockPresenter extends AbstractBlockPresenter<CompositeBlockView, CompositeBlockData> {
    @Inject
    public BlockViewHolderFactoryProvider f23668d;
    private int f23669e;
    private List<BlockViewHolder> f23670f;
    private final LinearLayout f23671g = ((LinearLayout) ((CompositeBlockViewImpl) this.d).iY_().findViewById(2131563254));
    private final BlockViewHolderFactory f23672h;

    /* compiled from: SUGGESTED_CONTENT */
    public /* synthetic */ class C33971 {
        public static final /* synthetic */ int[] f23667a = new int[GraphQLInstantShoppingDocumentElementType.values().length];

        static {
            try {
                f23667a[GraphQLInstantShoppingDocumentElementType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23667a[GraphQLInstantShoppingDocumentElementType.RICH_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23667a[GraphQLInstantShoppingDocumentElementType.COLOR_SELECTOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void m24995a(Object obj, Context context) {
        ((CompositeBlockPresenter) obj).f23668d = (BlockViewHolderFactoryProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(BlockViewHolderFactoryProvider.class);
    }

    public final void m24996a(BlockData blockData) {
        int i;
        BlockElementsModel blockElementsModel;
        CompositeBlockDataImpl compositeBlockDataImpl = (CompositeBlockDataImpl) blockData;
        int i2 = 0;
        this.f23669e = compositeBlockDataImpl.mo1000B();
        ImmutableList iF_ = compositeBlockDataImpl.f23641a.iF_();
        if (this.f23670f == null) {
            this.f23670f = new ArrayList();
            int size = iF_.size();
            for (i = 0; i < size; i++) {
                blockElementsModel = (BlockElementsModel) iF_.get(i);
                BlockViewHolder a;
                switch (C33971.f23667a[blockElementsModel.c().ordinal()]) {
                    case 1:
                        a = this.f23672h.a(114, this.f23671g);
                        this.f23670f.add(a);
                        m24994a(blockElementsModel, a);
                        break;
                    case 2:
                        a = this.f23672h.a(112, this.f23671g);
                        m24994a(blockElementsModel, a);
                        this.f23670f.add(a);
                        break;
                    case 3:
                        if (blockElementsModel.g() > 0 && blockElementsModel.g() < 100) {
                            a = this.f23672h.a(111, this.f23671g);
                            m24994a(blockElementsModel, a);
                            this.f23670f.add(a);
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        while (i2 < iF_.size()) {
            InstantShoppingTextBlockDataImpl b;
            blockElementsModel = (BlockElementsModel) iF_.get(i2);
            i = this.f23669e;
            switch (C33971.f23667a[blockElementsModel.c().ordinal()]) {
                case 1:
                    BaseInstantShoppingMediaBlockBuilder instantShoppingImageBlockDataBuilder = new InstantShoppingImageBlockDataBuilder(blockElementsModel, i, 114);
                    instantShoppingImageBlockDataBuilder.f23618k = false;
                    b = instantShoppingImageBlockDataBuilder.b();
                    break;
                case 2:
                    b = new InstantShoppingTextBlockDataImpl(blockElementsModel, i, InstantShoppingBlocksUtil.m24896b(blockElementsModel.iJ_()));
                    break;
                case 3:
                    b = new ColorPickerBlockDataImpl(blockElementsModel, 111, blockElementsModel.g());
                    break;
                default:
                    b = null;
                    break;
            }
            BlockData blockData2 = b;
            if (blockData2 != null) {
                if (this.f23671g.getChildAt(i2) != null) {
                    this.f23671g.removeViewAt(i2);
                }
                this.f23671g.addView(((BlockViewHolder) this.f23670f.get(i2)).a, i2);
                ((BlockViewHolder) this.f23670f.get(i2)).a(blockData2);
            }
            i2++;
        }
    }

    public CompositeBlockPresenter(CompositeBlockViewImpl compositeBlockViewImpl) {
        super(compositeBlockViewImpl);
        Class cls = CompositeBlockPresenter.class;
        m24995a((Object) this, getContext());
        this.f23672h = this.f23668d.a(null);
    }

    private void m24994a(BlockElementsModel blockElementsModel, BlockViewHolder blockViewHolder) {
        InstantShoppingElementDescriptorFragmentModel d = blockElementsModel.d();
        if (d != null) {
            int a;
            int a2;
            int a3;
            int a4;
            View view = blockViewHolder.a;
            LayoutParams layoutParams = (MarginLayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new MarginLayoutParams(-2, -2);
            }
            if (d.d() != null) {
                a = m24991a(d.d());
            } else {
                a = layoutParams.leftMargin;
            }
            if (d.iM_() != null) {
                a2 = m24991a(d.iM_());
            } else {
                a2 = layoutParams.rightMargin;
            }
            if (d.iN_() != null) {
                a3 = m24991a(d.iN_());
            } else {
                a3 = layoutParams.topMargin;
            }
            if (d.c() != null) {
                a4 = m24991a(d.c());
            } else {
                a4 = layoutParams.bottomMargin;
            }
            layoutParams.setMargins(a, a3, a2, a4);
            view.setLayoutParams(layoutParams);
            m24993a(view, d.b());
        }
    }

    private int m24991a(String str) {
        return SizeUtil.a(getContext(), (float) m24992a(str, 0));
    }

    private static void m24993a(View view, String str) {
        if (str != null) {
            if (!str.startsWith("#")) {
                str = "#" + str;
            }
            view.setBackgroundColor(Color.parseColor(str));
        }
    }

    private static int m24992a(String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return i;
    }
}
