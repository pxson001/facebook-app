package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.support.v7.internal.widget.TintCheckBox;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.common.util.StringUtil;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.enums.GraphQLPageCtaConfigFieldType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.calltoaction.analytics.PageCallToActionAnalytics;
import com.facebook.pages.common.surface.calltoaction.analytics.PageCallToActionEvent;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.widget.CustomLinearLayout;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: could not extract style from =  */
public class PageCallToActionLinkoutFieldsContainer extends CustomLinearLayout {
    @Inject
    public PageCallToActionAnalytics f16831a;
    @Inject
    public PageCallToActionUtil f16832b;
    @Inject
    public FunnelLoggerImpl f16833c;
    private final Map<String, PageCallToActionLinkoutGenericView> f16834d = new ArrayMap(3);
    private String f16835e;
    public String f16836f;
    public boolean f16837g;
    public CustomLinearLayout f16838h;
    private TintCheckBox f16839i;
    private PageCallToActionLinkoutGenericView f16840j;

    /* compiled from: could not extract style from =  */
    class C18231 implements OnCheckedChangeListener {
        final /* synthetic */ PageCallToActionLinkoutFieldsContainer f16829a;

        C18231(PageCallToActionLinkoutFieldsContainer pageCallToActionLinkoutFieldsContainer) {
            this.f16829a = pageCallToActionLinkoutFieldsContainer;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                this.f16829a.f16838h.setVisibility(0);
                this.f16829a.f16831a.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_CHECK_DEEPLINK, this.f16829a.f16836f));
                this.f16829a.f16833c.b(this.f16829a.f16837g ? FunnelRegistry.O : FunnelRegistry.N, "check_deeplink_box");
                return;
            }
            this.f16829a.f16838h.setVisibility(8);
            this.f16829a.f16831a.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_ADMIN_CALL_TO_ACTION_UNCHECK_DEEPLINK, this.f16829a.f16836f));
            this.f16829a.f16833c.b(this.f16829a.f16837g ? FunnelRegistry.O : FunnelRegistry.N, "uncheck_deeplink_box");
        }
    }

    /* compiled from: could not extract style from =  */
    /* synthetic */ class C18242 {
        static final /* synthetic */ int[] f16830a = new int[GraphQLPageCtaConfigFieldType.values().length];

        static {
            try {
                f16830a[GraphQLPageCtaConfigFieldType.URL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16830a[GraphQLPageCtaConfigFieldType.DEEPLINK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static <T extends View> void m20087a(Class<T> cls, T t) {
        m20088a((Object) t, t.getContext());
    }

    private static void m20088a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PageCallToActionLinkoutFieldsContainer pageCallToActionLinkoutFieldsContainer = (PageCallToActionLinkoutFieldsContainer) obj;
        PageCallToActionAnalytics b = PageCallToActionAnalytics.m19690b(injectorLike);
        PageCallToActionUtil a = PageCallToActionUtil.m20160a(injectorLike);
        FunnelLoggerImpl a2 = FunnelLoggerImpl.a(injectorLike);
        pageCallToActionLinkoutFieldsContainer.f16831a = b;
        pageCallToActionLinkoutFieldsContainer.f16832b = a;
        pageCallToActionLinkoutFieldsContainer.f16833c = a2;
    }

    public PageCallToActionLinkoutFieldsContainer(Context context) {
        super(context);
        m20090b();
    }

    public PageCallToActionLinkoutFieldsContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m20090b();
    }

    protected PageCallToActionLinkoutFieldsContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20090b();
    }

    private void m20090b() {
        m20087a(PageCallToActionLinkoutFieldsContainer.class, (View) this);
        setContentView(2130905979);
        this.f16840j = (PageCallToActionLinkoutGenericView) a(2131565386);
        this.f16839i = (TintCheckBox) a(2131565387);
        this.f16839i.setText(getContext().getResources().getString(2131239556));
        this.f16838h = (CustomLinearLayout) a(2131565388);
        this.f16839i.setOnCheckedChangeListener(new C18231(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m20093a(boolean r11, com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionAdminConfigModel r12, java.lang.String r13) {
        /*
        r10 = this;
        r2 = 1;
        r4 = 0;
        r10.f16837g = r11;
        r5 = com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.m20175e(r12);
        if (r5 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r10.f16836f = r13;
        r0 = r10.f16838h;
        r0.removeAllViews();
        r6 = r5.size();
        r3 = r4;
        r1 = r4;
    L_0x0018:
        if (r3 >= r6) goto L_0x00a0;
    L_0x001a:
        r0 = r5.get(r3);
        r0 = (com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionConfigFieldsModel) r0;
        if (r0 == 0) goto L_0x0031;
    L_0x0022:
        r7 = r0.mo1025c();
        r8 = com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionLinkoutFieldsContainer.C18242.f16830a;
        r7 = r7.ordinal();
        r7 = r8[r7];
        switch(r7) {
            case 1: goto L_0x0037;
            case 2: goto L_0x0061;
            default: goto L_0x0031;
        };
    L_0x0031:
        r0 = r1;
    L_0x0032:
        r1 = r3 + 1;
        r3 = r1;
        r1 = r0;
        goto L_0x0018;
    L_0x0037:
        r7 = r10.f16840j;
        r8 = r0.mo1028j();
        r7 = r7.m20095a(r8);
        r8 = r0.ky_();
        r7 = r7.m20096b(r8);
        r8 = r0.mo1026d();
        r7.m20097c(r8);
        r0 = r0.mo1024b();
        r10.f16835e = r0;
        r0 = r10.f16834d;
        r7 = r10.f16835e;
        r8 = r10.f16840j;
        r0.put(r7, r8);
        r0 = r1;
        goto L_0x0032;
    L_0x0061:
        r7 = new com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionLinkoutGenericView;
        r8 = r10.getContext();
        r7.<init>(r8);
        r8 = r0.mo1028j();
        r8 = r8.toString();
        r7 = r7.m20095a(r8);
        r8 = r0.ky_();
        r7 = r7.m20096b(r8);
        r8 = r0.mo1026d();
        r7 = r7.m20097c(r8);
        r8 = r10.f16838h;
        r8.addView(r7);
        r8 = r10.f16834d;
        r9 = r0.mo1024b();
        r8.put(r9, r7);
        r0 = r0.mo1026d();
        r0 = com.facebook.common.util.StringUtil.a(r0);
        if (r0 != 0) goto L_0x0031;
    L_0x009e:
        r0 = r2;
        goto L_0x0032;
    L_0x00a0:
        if (r1 == 0) goto L_0x00ac;
    L_0x00a2:
        r0 = r10.f16839i;
        r0.setChecked(r2);
        r0 = r10.f16838h;
        r0.setVisibility(r4);
    L_0x00ac:
        r0 = r10.f16840j;
        r0.requestFocus();
        r0 = r10.f16840j;
        r0 = r0.getEditText();
        r0 = com.facebook.common.util.StringUtil.a(r0);
        if (r0 == 0) goto L_0x000a;
    L_0x00bd:
        r0 = r10.f16832b;
        r0.m20177a();
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionLinkoutFieldsContainer.a(boolean, com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels$CallToActionAdminConfigModel, java.lang.String):void");
    }

    public Map<String, String> getFieldValues() {
        ArrayMap arrayMap = new ArrayMap();
        if (this.f16839i.isChecked()) {
            for (Entry entry : this.f16834d.entrySet()) {
                Object editText = ((PageCallToActionLinkoutGenericView) entry.getValue()).getEditText();
                if (!StringUtil.a(editText)) {
                    if (this.f16835e.equals(entry.getKey())) {
                        editText = PageCallToActionUtil.m20172c((String) editText);
                    }
                    arrayMap.put(entry.getKey(), editText);
                }
            }
            return arrayMap;
        }
        if (!StringUtil.a(this.f16835e)) {
            arrayMap.put(this.f16835e, PageCallToActionUtil.m20172c(this.f16840j.getEditText()));
        }
        return arrayMap;
    }

    public final PageCallToActionErrorState m20092a() {
        PageCallToActionErrorState pageCallToActionErrorState = PageCallToActionErrorState.NONE;
        String editText = this.f16840j.getEditText();
        if (StringUtil.a(editText)) {
            this.f16833c.a(this.f16837g ? FunnelRegistry.O : FunnelRegistry.N, "error_message_shown", "empty_link");
            pageCallToActionErrorState = PageCallToActionErrorState.EMPTY;
        }
        if (!(pageCallToActionErrorState != PageCallToActionErrorState.NONE || this.f16840j == null || PageCallToActionUtil.m20169a(editText))) {
            this.f16832b.m20178a((View) this);
            this.f16833c.a(this.f16837g ? FunnelRegistry.O : FunnelRegistry.N, "error_message_shown", "invalid_link");
            pageCallToActionErrorState = PageCallToActionErrorState.INVALID;
        }
        if (pageCallToActionErrorState != PageCallToActionErrorState.NONE) {
            this.f16840j.setError(getContext().getResources().getString(2131239570));
        }
        return pageCallToActionErrorState;
    }
}
