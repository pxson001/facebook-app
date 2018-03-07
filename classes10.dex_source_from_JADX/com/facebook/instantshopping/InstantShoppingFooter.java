package com.facebook.instantshopping;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.common.util.SizeUtil;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentElementType;
import com.facebook.instantshopping.model.block.InstantShoppingBlocksUtil;
import com.facebook.instantshopping.model.block.footer.InstantShoppingFooterWithButtonsWrapper;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingFooterElementFragment.FooterElements;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel.DocumentBodyElementsModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel.FooterElementsModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingFooterElementFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel.NodeModel;
import com.facebook.instantshopping.presenter.FooterImageBlockPresenter;
import com.facebook.instantshopping.presenter.FooterWithButtonsBlockPresenter;
import com.facebook.instantshopping.view.block.HeaderBlockView;
import com.facebook.instantshopping.view.block.impl.FooterBlockViewImpl;
import com.facebook.instantshopping.view.block.impl.FooterImageBlockViewImpl;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: StatusThreadViewActivity created without a ThreadKey */
public class InstantShoppingFooter {
    private final View f23446a;
    private boolean f23447b;
    public LinearLayout f23448c;
    public FooterWithButtonsBlockPresenter f23449d;
    private FrameLayout f23450e;

    /* compiled from: StatusThreadViewActivity created without a ThreadKey */
    /* synthetic */ class C33821 {
        static final /* synthetic */ int[] f23445a = new int[GraphQLInstantShoppingDocumentElementType.values().length];

        static {
            try {
                f23445a[GraphQLInstantShoppingDocumentElementType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23445a[GraphQLInstantShoppingDocumentElementType.TOGGLE_BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23445a[GraphQLInstantShoppingDocumentElementType.BUTTON.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public InstantShoppingFooter(View view, boolean z) {
        this.f23446a = view;
        this.f23447b = z;
        this.f23450e = (FrameLayout) view.findViewById(2131563309);
    }

    public final void m24779a(ImmutableList<FooterElementsModel> immutableList, InstantShoppingDocumentFragmentModel instantShoppingDocumentFragmentModel) {
        DocumentBodyElementsModel k = instantShoppingDocumentFragmentModel.k();
        if (k != null) {
            NodeModel a;
            String str;
            ImmutableList a2 = k.a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                ShoppingDocumentElementsEdgeModel shoppingDocumentElementsEdgeModel = (ShoppingDocumentElementsEdgeModel) a2.get(i);
                if (shoppingDocumentElementsEdgeModel.a() != null && shoppingDocumentElementsEdgeModel.a().c() == GraphQLInstantShoppingDocumentElementType.FOOTER) {
                    a = shoppingDocumentElementsEdgeModel.a();
                    break;
                }
            }
            a = null;
            if (a == null || a.d() == null) {
                str = null;
            } else {
                str = a.d().b();
            }
            m24774a(str);
            if (m24777b((ImmutableList) immutableList)) {
                m24776b(true);
            } else if (a == null || a.z().isEmpty()) {
                m24775b();
                m24771a();
                m24776b(false);
            } else {
                m24776b(true);
                m24773a(a.z());
            }
        }
    }

    private void m24774a(String str) {
        String c = m24778c(str);
        Object obj = null;
        if (c != null && ((float) Color.alpha(Color.parseColor(c))) < 255.0f) {
            obj = 1;
        }
        if (obj != null) {
            this.f23448c = (LinearLayout) this.f23446a.findViewById(2131563247);
            m24771a();
        } else {
            this.f23448c = (LinearLayout) this.f23446a.findViewById(2131563246);
            m24775b();
        }
        if (c != null) {
            this.f23448c.setBackground(new ColorDrawable(Color.parseColor(c)));
        }
    }

    private void m24773a(ImmutableList<? extends FooterElements> immutableList) {
        if (immutableList.size() > 0) {
            InstantShoppingFooterElementFragmentModel.FooterElementsModel footerElementsModel = (InstantShoppingFooterElementFragmentModel.FooterElementsModel) immutableList.get(0);
            switch (C33821.f23445a[footerElementsModel.c().ordinal()]) {
                case 1:
                    HeaderBlockView footerImageBlockViewImpl = new FooterImageBlockViewImpl(this.f23448c);
                    footerImageBlockViewImpl.a(new FooterImageBlockPresenter(footerImageBlockViewImpl, footerElementsModel));
                    FooterWithButtonsBlockPresenter footerWithButtonsBlockPresenter = this.f23449d;
                    InstantShoppingBlocksUtil.m24893a();
                    footerWithButtonsBlockPresenter.m25003b();
                    return;
                default:
                    InstantShoppingFooterWithButtonsWrapper instantShoppingFooterWithButtonsWrapper = new InstantShoppingFooterWithButtonsWrapper();
                    instantShoppingFooterWithButtonsWrapper.f23593b = immutableList;
                    m24772a(instantShoppingFooterWithButtonsWrapper);
                    return;
            }
        }
    }

    private boolean m24777b(ImmutableList<FooterElementsModel> immutableList) {
        if (immutableList == null || immutableList.isEmpty()) {
            return false;
        }
        InstantShoppingFooterWithButtonsWrapper instantShoppingFooterWithButtonsWrapper = new InstantShoppingFooterWithButtonsWrapper();
        instantShoppingFooterWithButtonsWrapper.f23592a = immutableList;
        m24772a(instantShoppingFooterWithButtonsWrapper);
        return true;
    }

    private void m24772a(InstantShoppingFooterWithButtonsWrapper instantShoppingFooterWithButtonsWrapper) {
        FooterBlockViewImpl footerBlockViewImpl = new FooterBlockViewImpl(this.f23448c.findViewById(2131563248));
        this.f23449d = new FooterWithButtonsBlockPresenter(footerBlockViewImpl, instantShoppingFooterWithButtonsWrapper);
        footerBlockViewImpl.a(this.f23449d);
        FooterWithButtonsBlockPresenter footerWithButtonsBlockPresenter = this.f23449d;
        InstantShoppingBlocksUtil.m24893a();
        footerWithButtonsBlockPresenter.m25003b();
    }

    @Nullable
    private static String m24778c(String str) {
        if (str == null) {
            return null;
        }
        return !str.startsWith("#") ? "#" + str : str;
    }

    private void m24771a() {
        View findViewById = this.f23446a.findViewById(2131563246);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        layoutParams.height = 0;
        layoutParams.setMargins(0, 0, 0, 0);
        findViewById.setLayoutParams(layoutParams);
    }

    private void m24775b() {
        View findViewById = this.f23446a.findViewById(2131563247);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.height = 0;
        layoutParams.setMargins(0, 0, 0, 0);
        findViewById.setLayoutParams(layoutParams);
    }

    private void m24776b(boolean z) {
        if (this.f23447b) {
            Context context = this.f23446a.getContext();
            int dimension = (int) context.getResources().getDimension(2131432868);
            int a = SizeUtil.a(context, 10.0f);
            dimension = z ? a + dimension : a;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f23450e.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = dimension;
            }
            this.f23450e.setLayoutParams(marginLayoutParams);
            return;
        }
        this.f23450e.setVisibility(8);
    }
}
