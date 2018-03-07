package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.enums.GraphQLPageCtaConfigFieldType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionConfigFieldsModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PhoneNumberCommonFieldsModel;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.framerateprogressbar.FrameRateProgressBar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: coupon_fbid */
public class PageCallToActionInputFieldsContainer extends CustomLinearLayout {
    @Inject
    PageCallToActionInputFactoryProvider f16824a;
    @Inject
    PageCallToActionUtil f16825b;
    private final Map<String, PageCallToActionInput> f16826c = new ArrayMap(2);
    private AlertDialog f16827d;

    private static <T extends View> void m20076a(Class<T> cls, T t) {
        m20077a((Object) t, t.getContext());
    }

    private static void m20077a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PageCallToActionInputFieldsContainer) obj).m20075a((PageCallToActionInputFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PageCallToActionInputFactoryProvider.class), PageCallToActionUtil.m20160a(injectorLike));
    }

    private void m20075a(PageCallToActionInputFactoryProvider pageCallToActionInputFactoryProvider, PageCallToActionUtil pageCallToActionUtil) {
        this.f16824a = pageCallToActionInputFactoryProvider;
        this.f16825b = pageCallToActionUtil;
    }

    public PageCallToActionInputFieldsContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m20079b();
    }

    private void m20079b() {
        m20076a(PageCallToActionInputFieldsContainer.class, (View) this);
    }

    public Map<String, String> getFieldValues() {
        ArrayMap arrayMap = new ArrayMap(2);
        for (Entry entry : this.f16826c.entrySet()) {
            PageCallToActionInput pageCallToActionInput = (PageCallToActionInput) entry.getValue();
            if (pageCallToActionInput instanceof PageCallToActionGroupView) {
                arrayMap.putAll(((PageCallToActionGroupView) pageCallToActionInput).getChildInputValues());
            } else if (!(StringUtil.a((CharSequence) entry.getKey()) || entry.getValue() == null || StringUtil.a(((PageCallToActionInput) entry.getValue()).getValue()))) {
                arrayMap.put(entry.getKey(), pageCallToActionInput.getValue());
            }
        }
        return arrayMap;
    }

    public final void m20082a(@Nullable PhoneNumberCommonFieldsModel phoneNumberCommonFieldsModel, String str, @Nullable List<CallToActionConfigFieldsModel> list, String str2) {
        m20080c();
        if (!StringUtil.a(str)) {
            addView(this.f16825b.m20176a((CharSequence) str, (ViewGroup) this));
        }
        if (list != null) {
            Object obj = null;
            for (CallToActionConfigFieldsModel callToActionConfigFieldsModel : list) {
                if (callToActionConfigFieldsModel != null) {
                    String j = callToActionConfigFieldsModel.mo1028j();
                    if (!StringUtil.a(j)) {
                        if (callToActionConfigFieldsModel.mo1025c() == GraphQLPageCtaConfigFieldType.GROUP) {
                            m20078a(j);
                        } else {
                            addView(this.f16825b.m20182b(j, this));
                        }
                    }
                    CharSequence l = callToActionConfigFieldsModel.m19853l();
                    if (!StringUtil.a(l)) {
                        addView(this.f16825b.m20183c(l, this));
                    }
                    PageCallToActionInputFactoryProvider pageCallToActionInputFactoryProvider = this.f16824a;
                    PageCallToActionInput a = new PageCallToActionInputFactory((Context) pageCallToActionInputFactoryProvider.getInstance(Context.class), IdBasedSingletonScopeProvider.b(pageCallToActionInputFactoryProvider, 8995), IdBasedLazy.a(pageCallToActionInputFactoryProvider, 8994), str2).m20074a(phoneNumberCommonFieldsModel, callToActionConfigFieldsModel, this);
                    if (a != null) {
                        this.f16826c.put(callToActionConfigFieldsModel.mo1024b(), a);
                        View view = a.getView();
                        addView(view);
                        if (a.mo1032a() && r1 == null) {
                            obj = 1;
                            view.requestFocus();
                            if (StringUtil.a(a.getValue())) {
                                this.f16825b.m20177a();
                            }
                        }
                        obj = obj;
                    }
                }
            }
        }
    }

    private void m20078a(String str) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131432980);
        FbTextView a = this.f16825b.m20176a((CharSequence) str, (ViewGroup) this);
        a.setPadding(0, dimensionPixelSize, 0, 0);
        addView(a);
    }

    public final PageCallToActionErrorState m20081a() {
        PageCallToActionErrorState pageCallToActionErrorState = PageCallToActionErrorState.NONE;
        PageCallToActionErrorState pageCallToActionErrorState2 = pageCallToActionErrorState;
        for (Entry value : this.f16826c.entrySet()) {
            PageCallToActionInput pageCallToActionInput = (PageCallToActionInput) value.getValue();
            PageCallToActionErrorState b = pageCallToActionInput.mo1033b();
            if (b == PageCallToActionErrorState.NONE) {
                pageCallToActionInput.mo1036e();
            } else {
                pageCallToActionInput.mo1034c();
                pageCallToActionErrorState2 = b;
            }
        }
        if (pageCallToActionErrorState2 != PageCallToActionErrorState.NONE) {
            this.f16825b.m20178a((View) this);
        }
        return pageCallToActionErrorState2;
    }

    public final void m20083a(boolean z) {
        if (z) {
            if (this.f16827d == null) {
                this.f16827d = new Builder(getContext(), 2131626266).b((FrameRateProgressBar) LayoutInflater.from(getContext()).inflate(2130906078, null)).a();
            }
            this.f16827d.show();
            return;
        }
        if (this.f16827d != null) {
            this.f16827d.dismiss();
        }
        this.f16825b.m20178a((View) this);
    }

    public final void m20084c(int i) {
        new Builder(getContext()).a(2131230761).b(i).c(true).a(2131230726, null).b();
    }

    private void m20080c() {
        removeAllViews();
        this.f16826c.clear();
    }
}
