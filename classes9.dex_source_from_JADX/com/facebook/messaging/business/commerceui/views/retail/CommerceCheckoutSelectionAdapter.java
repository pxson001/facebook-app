package com.facebook.messaging.business.commerceui.views.retail;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsInterfaces.MessengerCommerceFetchProductGroupQuery.Group.ProductItemsEdge.Nodes;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.MessengerCommerceFetchProductGroupQueryModel.GroupModel.ProductItemsEdgeModel.NodesModel;
import com.facebook.messaging.business.commerceui.utils.ProductVariantHelper;
import com.facebook.messaging.business.commerceui.utils.ProductVariantHelper.VariantValuesCollection;
import com.facebook.messaging.business.commerceui.views.retail.CommerceCheckoutSelectionFragment.C09633;
import com.facebook.messaging.business.common.helper.LogoViewHelper;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.LogoImage;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.FlowLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: null_content_fragment */
public class CommerceCheckoutSelectionAdapter extends Adapter<ViewHolder> {
    public ProductVariantHelper f8454a;
    public LogoViewHelper f8455b;
    public C09633 f8456c;
    public LogoImage f8457d;
    public String f8458e;

    /* compiled from: null_content_fragment */
    enum ButtonState {
        ENABLED,
        DISABLED,
        SELECTED
    }

    /* compiled from: null_content_fragment */
    public class HeaderLogoViewHolder extends ViewHolder {
        public final /* synthetic */ CommerceCheckoutSelectionAdapter f8449l;
        public FbDraweeView f8450m;

        public HeaderLogoViewHolder(CommerceCheckoutSelectionAdapter commerceCheckoutSelectionAdapter, LinearLayout linearLayout) {
            this.f8449l = commerceCheckoutSelectionAdapter;
            super(linearLayout);
            this.f8450m = (FbDraweeView) linearLayout.findViewById(2131564656);
        }
    }

    /* compiled from: null_content_fragment */
    public class ItemPreviewViewHolder extends ViewHolder {
        private CommerceCheckoutSelectionItemPreviewView f8451l;

        public ItemPreviewViewHolder(CommerceCheckoutSelectionItemPreviewView commerceCheckoutSelectionItemPreviewView) {
            super(commerceCheckoutSelectionItemPreviewView);
            this.f8451l = commerceCheckoutSelectionItemPreviewView;
        }

        public final void m8711a(@Nullable String str, @Nullable String str2, ImmutableList<String> immutableList, @Nullable String str3) {
            CommerceCheckoutSelectionItemPreviewView commerceCheckoutSelectionItemPreviewView = this.f8451l;
            int i = 8;
            if (str != null) {
                commerceCheckoutSelectionItemPreviewView.f8472a.a(Uri.parse(str), CallerContext.a(CommerceCheckoutSelectionItemPreviewView.class));
            }
            commerceCheckoutSelectionItemPreviewView.f8473b.setText(str2);
            commerceCheckoutSelectionItemPreviewView.f8475d.setVisibility(Strings.isNullOrEmpty(str3) ? 8 : 0);
            commerceCheckoutSelectionItemPreviewView.f8475d.setText(str3);
            commerceCheckoutSelectionItemPreviewView.f8474c.removeAllViews();
            FlowLayout flowLayout = commerceCheckoutSelectionItemPreviewView.f8474c;
            if (!immutableList.isEmpty()) {
                i = 0;
            }
            flowLayout.setVisibility(i);
            int i2 = 0;
            while (i2 < immutableList.size()) {
                BetterTextView betterTextView = (BetterTextView) LayoutInflater.from(commerceCheckoutSelectionItemPreviewView.getContext()).inflate(2130905625, commerceCheckoutSelectionItemPreviewView.f8474c, false);
                betterTextView.setText(i2 == immutableList.size() + -1 ? (String) immutableList.get(i2) : ((String) immutableList.get(i2)) + " · ");
                commerceCheckoutSelectionItemPreviewView.f8474c.addView(betterTextView);
                i2++;
            }
        }
    }

    /* compiled from: null_content_fragment */
    public class VariantTitleViewHolder extends ViewHolder {
        public BetterTextView f8452l;

        public VariantTitleViewHolder(BetterTextView betterTextView) {
            super(betterTextView);
            this.f8452l = (BetterTextView) betterTextView.findViewById(2131564667);
        }
    }

    /* compiled from: null_content_fragment */
    public class VariantViewHolder extends ViewHolder {
        public FbButton f8453l;

        public VariantViewHolder(FrameLayout frameLayout) {
            super(frameLayout);
            this.f8453l = (FbButton) frameLayout.findViewById(2131564655);
        }

        public final void m8712a(String str, ButtonState buttonState) {
            this.f8453l.setText(str);
            switch (buttonState) {
                case DISABLED:
                    this.f8453l.setEnabled(false);
                    this.f8453l.setSelected(false);
                    return;
                case SELECTED:
                    this.f8453l.setEnabled(true);
                    this.f8453l.setSelected(true);
                    return;
                default:
                    this.f8453l.setEnabled(true);
                    this.f8453l.setSelected(false);
                    return;
            }
        }
    }

    @Inject
    public CommerceCheckoutSelectionAdapter(ProductVariantHelper productVariantHelper, LogoViewHelper logoViewHelper) {
        this.f8454a = productVariantHelper;
        this.f8455b = logoViewHelper;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (!Strings.isNullOrEmpty(m8717g(i))) {
            return 2;
        }
        int i2 = 0;
        String[] strArr = this.f8454a.f8411c[m8718h(this, i)[0]].f8406a;
        int length = strArr.length;
        int i3 = 0;
        while (i2 < length) {
            i3 = Math.max(i3, strArr[i2].length());
            i2++;
        }
        return i3 > 4 ? 4 : 3;
    }

    @Nullable
    public final String m8721d() {
        ImmutableList g = m8716g();
        if (g == null || g.isEmpty() || g.size() != 1) {
            return null;
        }
        return ((NodesModel) m8716g().get(0)).d();
    }

    public final ViewHolder m8719a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new HeaderLogoViewHolder(this, (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130905623, viewGroup, false));
        }
        if (i == 1) {
            return new ItemPreviewViewHolder(new CommerceCheckoutSelectionItemPreviewView(viewGroup.getContext()));
        }
        if (i == 2) {
            return new VariantTitleViewHolder((BetterTextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130905628, viewGroup, false));
        }
        if (i == 3) {
            return new VariantViewHolder((FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130905622, viewGroup, false));
        }
        if (i == 4) {
            return new VariantViewHolder((FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130905626, viewGroup, false));
        }
        return null;
    }

    public final void m8720a(ViewHolder viewHolder, final int i) {
        switch (getItemViewType(i)) {
            case 0:
                HeaderLogoViewHolder headerLogoViewHolder = (HeaderLogoViewHolder) viewHolder;
                headerLogoViewHolder.f8449l.f8455b.m9023a(this.f8457d, headerLogoViewHolder.f8450m, CallerContext.a(HeaderLogoViewHolder.class));
                return;
            case 1:
                String str;
                ImmutableList g = m8716g();
                ItemPreviewViewHolder itemPreviewViewHolder = (ItemPreviewViewHolder) viewHolder;
                if (g.isEmpty() || ((NodesModel) g.get(0)).cd_() == null) {
                    String str2;
                    if (this.f8454a.f8412d == null || this.f8454a.f8412d.isEmpty()) {
                        str2 = null;
                    } else {
                        str2 = ((NodesModel) this.f8454a.f8412d.get(0)).cd_().a();
                    }
                    str = str2;
                } else {
                    str = ((NodesModel) g.get(0)).cd_().a();
                }
                String str3 = this.f8458e;
                ProductVariantHelper productVariantHelper = this.f8454a;
                Builder builder = new Builder();
                for (int i2 = 0; i2 < productVariantHelper.f8409a; i2++) {
                    String str4;
                    VariantValuesCollection variantValuesCollection = productVariantHelper.f8411c[i2];
                    if (variantValuesCollection.f8408c < 0 || variantValuesCollection.f8408c >= variantValuesCollection.f8406a.length) {
                        str4 = "";
                    } else {
                        str4 = variantValuesCollection.f8406a[variantValuesCollection.f8408c];
                    }
                    String str5 = str4;
                    if (!Strings.isNullOrEmpty(str5)) {
                        builder.c(str5);
                    }
                }
                itemPreviewViewHolder.m8711a(str, str3, builder.b(), this.f8454a.m8682c());
                return;
            case 2:
                VariantTitleViewHolder variantTitleViewHolder = (VariantTitleViewHolder) viewHolder;
                variantTitleViewHolder.f8452l.setText(m8717g(i));
                return;
            case 3:
            case 4:
                VariantViewHolder variantViewHolder = (VariantViewHolder) viewHolder;
                int[] h = m8718h(this, i);
                variantViewHolder.m8712a(m8713a(h), m8714b(h));
                variantViewHolder.f8453l.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ CommerceCheckoutSelectionAdapter f8447b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 325859429);
                        int[] h = CommerceCheckoutSelectionAdapter.m8718h(this.f8447b, i);
                        if (h != null) {
                            Object obj;
                            int i = h[0];
                            int i2 = h[1];
                            VariantValuesCollection[] variantValuesCollectionArr = this.f8447b.f8454a.f8411c;
                            CommerceCheckoutSelectionAdapter commerceCheckoutSelectionAdapter = this.f8447b;
                            if (variantValuesCollectionArr[i].f8408c == i2) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                variantValuesCollectionArr[i].f8408c = -1;
                            } else {
                                variantValuesCollectionArr[i].f8408c = i2;
                            }
                            CommerceCheckoutSelectionAdapter.m8715f(this.f8447b);
                            this.f8447b.notifyDataSetChanged();
                        }
                        LogUtils.a(659012645, a);
                    }
                });
                return;
            default:
                return;
        }
    }

    public final int aZ_() {
        int i = 0;
        VariantValuesCollection[] variantValuesCollectionArr = this.f8454a.f8411c;
        if (!(variantValuesCollectionArr == null || variantValuesCollectionArr.length == 0)) {
            i = 2;
            int i2 = 0;
            while (i2 < variantValuesCollectionArr.length) {
                int length = (variantValuesCollectionArr[i2].f8406a.length + 1) + i;
                i2++;
                i = length;
            }
        }
        return i;
    }

    @Nullable
    private String m8717g(int i) {
        int i2 = 2;
        VariantValuesCollection[] variantValuesCollectionArr = this.f8454a.f8411c;
        for (int i3 = 0; i3 < variantValuesCollectionArr.length; i3++) {
            if (i < i2) {
                return null;
            }
            if (i == i2) {
                return (String) this.f8454a.f8410b.get(i3);
            }
            i2 += variantValuesCollectionArr[i3].f8406a.length + 1;
        }
        return null;
    }

    @Nullable
    private String m8713a(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        VariantValuesCollection[] variantValuesCollectionArr = this.f8454a.f8411c;
        int i = iArr[0];
        int i2 = iArr[1];
        if (i < 0 || i >= variantValuesCollectionArr.length || i2 < 0 || i2 >= variantValuesCollectionArr[i].f8406a.length) {
            return null;
        }
        return variantValuesCollectionArr[i].f8406a[i2];
    }

    private ButtonState m8714b(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return ButtonState.DISABLED;
        }
        int i = iArr[0];
        int i2 = iArr[1];
        if (this.f8454a.f8411c[i].f8408c == i2) {
            return ButtonState.SELECTED;
        }
        int[] a = this.f8454a.m8681a();
        a[i] = i2;
        if (this.f8454a.m8679a(a).size() > 0) {
            return ButtonState.ENABLED;
        }
        return ButtonState.DISABLED;
    }

    public static void m8715f(CommerceCheckoutSelectionAdapter commerceCheckoutSelectionAdapter) {
        if (commerceCheckoutSelectionAdapter.f8456c != null) {
            Object obj = null;
            for (int i : commerceCheckoutSelectionAdapter.f8454a.m8681a()) {
                if (i == -1) {
                    break;
                }
            }
            obj = 1;
            if (obj != null) {
                commerceCheckoutSelectionAdapter.f8456c.f8461a.al.setEnabled(true);
            } else {
                commerceCheckoutSelectionAdapter.f8456c.f8461a.al.setEnabled(false);
            }
        }
    }

    @Nullable
    public static int[] m8718h(CommerceCheckoutSelectionAdapter commerceCheckoutSelectionAdapter, int i) {
        int i2 = i - 3;
        VariantValuesCollection[] variantValuesCollectionArr = commerceCheckoutSelectionAdapter.f8454a.f8411c;
        int i3 = i2;
        for (i2 = 0; i2 < variantValuesCollectionArr.length; i2++) {
            if (i3 < 0) {
                return null;
            }
            if (i3 < variantValuesCollectionArr[i2].f8406a.length) {
                return new int[]{i2, i3};
            }
            i3 -= variantValuesCollectionArr[i2].f8406a.length + 1;
        }
        return null;
    }

    private ImmutableList<Nodes> m8716g() {
        return this.f8454a.m8679a(this.f8454a.m8681a());
    }
}
