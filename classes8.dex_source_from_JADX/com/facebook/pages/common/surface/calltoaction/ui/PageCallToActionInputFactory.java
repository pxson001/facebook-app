package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import com.facebook.graphql.enums.GraphQLPageCtaConfigFieldType;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.surface.calltoaction.analytics.PageCallToActionAnalytics;
import com.facebook.pages.common.surface.calltoaction.analytics.PageCallToActionEvent;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLInterfaces.CallToActionConfigCommonFields;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLInterfaces.CallToActionConfigCommonFields.Subfields.Nodes;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionConfigFieldsModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PhoneNumberCommonFieldsModel;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.widget.SwitchCompat;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Observer;
import javax.inject.Inject;

/* compiled from: coupons_shown */
public class PageCallToActionInputFactory {
    public final LayoutInflater f16820a;
    public final Lazy<PageCallToActionUtil> f16821b;
    public final String f16822c;
    public final Lazy<PageCallToActionAnalytics> f16823d;

    /* compiled from: coupons_shown */
    public interface CallToActionFieldLogger {
        void mo1039a(String... strArr);
    }

    /* compiled from: coupons_shown */
    /* synthetic */ class C18225 {
        static final /* synthetic */ int[] f16819a = new int[GraphQLPageCtaConfigFieldType.values().length];

        static {
            try {
                f16819a[GraphQLPageCtaConfigFieldType.PHONE_NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16819a[GraphQLPageCtaConfigFieldType.EMAIL_ADDRESS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16819a[GraphQLPageCtaConfigFieldType.SELECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16819a[GraphQLPageCtaConfigFieldType.URL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f16819a[GraphQLPageCtaConfigFieldType.TEXT_WITH_ENTITIES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f16819a[GraphQLPageCtaConfigFieldType.TEXT_MULTILINE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f16819a[GraphQLPageCtaConfigFieldType.GROUP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f16819a[GraphQLPageCtaConfigFieldType.TEXT_WITH_CLEARBUTTON.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f16819a[GraphQLPageCtaConfigFieldType.CHECK_BOX.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    @Inject
    public PageCallToActionInputFactory(Context context, Lazy<PageCallToActionUtil> lazy, Lazy<PageCallToActionAnalytics> lazy2, @Assisted String str) {
        this.f16820a = LayoutInflater.from(context);
        this.f16821b = lazy;
        this.f16823d = lazy2;
        this.f16822c = str;
    }

    @Nullable
    public final PageCallToActionInput m20074a(@Nullable PhoneNumberCommonFieldsModel phoneNumberCommonFieldsModel, CallToActionConfigCommonFields callToActionConfigCommonFields, PageCallToActionInputFieldsContainer pageCallToActionInputFieldsContainer) {
        switch (C18225.f16819a[callToActionConfigCommonFields.mo1025c().ordinal()]) {
            case 1:
                String l;
                boolean z = false;
                PageCallToActionInput pageCallToActionInput = (PageCallToActionPhoneNumberEditView) this.f16820a.inflate(2130905984, pageCallToActionInputFieldsContainer, false);
                String ky_ = callToActionConfigCommonFields.ky_();
                if (phoneNumberCommonFieldsModel != null) {
                    z = true;
                }
                this.f16821b.get();
                if (phoneNumberCommonFieldsModel != null) {
                    l = phoneNumberCommonFieldsModel.m19910l();
                } else {
                    l = null;
                }
                pageCallToActionInput.m20116a(ky_, z, l, ((PageCallToActionUtil) this.f16821b.get()).m20181b(phoneNumberCommonFieldsModel), callToActionConfigCommonFields.mo1026d());
                return pageCallToActionInput;
            case 2:
                return m20068c(callToActionConfigCommonFields, pageCallToActionInputFieldsContainer);
            case 3:
                return m20065a(callToActionConfigCommonFields, pageCallToActionInputFieldsContainer);
            case 4:
                return m20066b(callToActionConfigCommonFields, pageCallToActionInputFieldsContainer);
            case 5:
                return m20071e(callToActionConfigCommonFields, pageCallToActionInputFieldsContainer);
            case 6:
                return m20072f(callToActionConfigCommonFields, pageCallToActionInputFieldsContainer);
            case 7:
                return m20069c(phoneNumberCommonFieldsModel, callToActionConfigCommonFields, pageCallToActionInputFieldsContainer);
            case 8:
                return m20070d(callToActionConfigCommonFields, pageCallToActionInputFieldsContainer);
            case 9:
                return m20073g(callToActionConfigCommonFields, pageCallToActionInputFieldsContainer);
            default:
                return null;
        }
    }

    private PageCallToActionInput m20065a(final CallToActionConfigCommonFields callToActionConfigCommonFields, PageCallToActionInputFieldsContainer pageCallToActionInputFieldsContainer) {
        PageCallToActionSelectView pageCallToActionSelectView = (PageCallToActionSelectView) this.f16820a.inflate(2130905987, pageCallToActionInputFieldsContainer, false);
        pageCallToActionSelectView.m20124a(callToActionConfigCommonFields.kz_(), callToActionConfigCommonFields.mo1026d(), new CallToActionFieldLogger(this) {
            final /* synthetic */ PageCallToActionInputFactory f16812b;

            public final void mo1039a(String... strArr) {
                PageCallToActionAnalytics pageCallToActionAnalytics = (PageCallToActionAnalytics) this.f16812b.f16823d.get();
                String str = this.f16812b.f16822c;
                String b = callToActionConfigCommonFields.mo1024b();
                pageCallToActionAnalytics.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_CALL_TO_ACTION_SWITCH_SELECT_OPTIONS, str).b("field_key", b).b("option_name", PageCallToActionInputFactory.m20067b(strArr)));
            }
        });
        return pageCallToActionSelectView;
    }

    private PageCallToActionInput m20066b(final CallToActionConfigCommonFields callToActionConfigCommonFields, PageCallToActionInputFieldsContainer pageCallToActionInputFieldsContainer) {
        PageCallToActionUrlEditView pageCallToActionUrlEditView = (PageCallToActionUrlEditView) this.f16820a.inflate(2130905993, pageCallToActionInputFieldsContainer, false);
        pageCallToActionUrlEditView.m20150a(callToActionConfigCommonFields.mo1026d(), new CallToActionFieldLogger(this) {
            final /* synthetic */ PageCallToActionInputFactory f16814b;

            public final void mo1039a(String... strArr) {
                PageCallToActionAnalytics pageCallToActionAnalytics = (PageCallToActionAnalytics) this.f16814b.f16823d.get();
                String str = this.f16814b.f16822c;
                String b = callToActionConfigCommonFields.mo1024b();
                pageCallToActionAnalytics.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_CALL_TO_ACTION_INVALID_URL, str).b("field_key", b).b("error", PageCallToActionInputFactory.m20067b(strArr)));
            }
        });
        return pageCallToActionUrlEditView;
    }

    private PageCallToActionInput m20068c(final CallToActionConfigCommonFields callToActionConfigCommonFields, PageCallToActionInputFieldsContainer pageCallToActionInputFieldsContainer) {
        PageCallToActionEmailEditView pageCallToActionEmailEditView = (PageCallToActionEmailEditView) this.f16820a.inflate(2130905973, pageCallToActionInputFieldsContainer, false);
        pageCallToActionEmailEditView.m20047a(callToActionConfigCommonFields.ky_(), callToActionConfigCommonFields.mo1026d(), new CallToActionFieldLogger(this) {
            final /* synthetic */ PageCallToActionInputFactory f16816b;

            public final void mo1039a(String... strArr) {
                PageCallToActionAnalytics pageCallToActionAnalytics = (PageCallToActionAnalytics) this.f16816b.f16823d.get();
                String str = this.f16816b.f16822c;
                String b = callToActionConfigCommonFields.mo1024b();
                pageCallToActionAnalytics.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_CALL_TO_ACTION_INVALID_EMAIL, str).b("field_key", b).b("error", PageCallToActionInputFactory.m20067b(strArr)));
            }
        });
        return pageCallToActionEmailEditView;
    }

    private PageCallToActionInput m20070d(CallToActionConfigCommonFields callToActionConfigCommonFields, PageCallToActionInputFieldsContainer pageCallToActionInputFieldsContainer) {
        PageCallToActionTextWithClearButtonEditView pageCallToActionTextWithClearButtonEditView = (PageCallToActionTextWithClearButtonEditView) this.f16820a.inflate(2130905989, pageCallToActionInputFieldsContainer, false);
        pageCallToActionTextWithClearButtonEditView.m20132a(callToActionConfigCommonFields.ky_(), callToActionConfigCommonFields.mo1026d());
        return pageCallToActionTextWithClearButtonEditView;
    }

    private PageCallToActionInput m20071e(final CallToActionConfigCommonFields callToActionConfigCommonFields, PageCallToActionInputFieldsContainer pageCallToActionInputFieldsContainer) {
        PageCallToActionTextWithEntitiesView pageCallToActionTextWithEntitiesView = (PageCallToActionTextWithEntitiesView) this.f16820a.inflate(2130905991, pageCallToActionInputFieldsContainer, false);
        pageCallToActionTextWithEntitiesView.m20143a(callToActionConfigCommonFields.mo1023a(), new CallToActionFieldLogger(this) {
            final /* synthetic */ PageCallToActionInputFactory f16818b;

            public final void mo1039a(String... strArr) {
                PageCallToActionAnalytics pageCallToActionAnalytics = (PageCallToActionAnalytics) this.f16818b.f16823d.get();
                String str = this.f16818b.f16822c;
                String b = callToActionConfigCommonFields.mo1024b();
                pageCallToActionAnalytics.f16655a.a(PageCallToActionAnalytics.m19689a(PageCallToActionEvent.EVENT_CALL_TO_ACTION_TAP_ENTITY_LINK, str).b("field_key", b).b("url", PageCallToActionInputFactory.m20067b(strArr)));
            }
        });
        return pageCallToActionTextWithEntitiesView;
    }

    private PageCallToActionInput m20072f(CallToActionConfigCommonFields callToActionConfigCommonFields, PageCallToActionInputFieldsContainer pageCallToActionInputFieldsContainer) {
        int parseInt;
        PageCallToActionMultiLineTextView pageCallToActionMultiLineTextView = (PageCallToActionMultiLineTextView) this.f16820a.inflate(2130905982, pageCallToActionInputFieldsContainer, false);
        if (callToActionConfigCommonFields.kA_() != null) {
            ImmutableList a = callToActionConfigCommonFields.kA_().mo1022a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                Nodes nodes = (Nodes) a.get(i);
                if (GraphQLPageCtaConfigFieldType.TEXT_MULTILINE_CHAR_LIMIT == nodes.mo1020c()) {
                    parseInt = Integer.parseInt(nodes.mo1021d());
                    break;
                }
            }
        }
        parseInt = 0;
        int i2 = parseInt;
        if (i2 == 0) {
            pageCallToActionMultiLineTextView.m20102a(callToActionConfigCommonFields.ky_(), callToActionConfigCommonFields.mo1026d());
        } else {
            pageCallToActionMultiLineTextView.m20103a(callToActionConfigCommonFields.ky_(), callToActionConfigCommonFields.mo1026d(), i2);
        }
        return pageCallToActionMultiLineTextView;
    }

    private static PageCallToActionInput m20073g(CallToActionConfigCommonFields callToActionConfigCommonFields, PageCallToActionInputFieldsContainer pageCallToActionInputFieldsContainer) {
        PageCallToActionInput pageCallToActionCheckboxView = new PageCallToActionCheckboxView(new SwitchCompat(pageCallToActionInputFieldsContainer.getContext()));
        pageCallToActionCheckboxView.f16797b.setText(callToActionConfigCommonFields.mo1028j());
        pageCallToActionCheckboxView.f16797b.setChecked(Boolean.TRUE.toString().equalsIgnoreCase(callToActionConfigCommonFields.mo1026d()));
        return pageCallToActionCheckboxView;
    }

    @Nullable
    private PageCallToActionInput m20069c(PhoneNumberCommonFieldsModel phoneNumberCommonFieldsModel, CallToActionConfigCommonFields callToActionConfigCommonFields, PageCallToActionInputFieldsContainer pageCallToActionInputFieldsContainer) {
        PageCallToActionCheckboxView pageCallToActionCheckboxView = null;
        CallToActionConfigFieldsModel callToActionConfigFieldsModel = (CallToActionConfigFieldsModel) callToActionConfigCommonFields;
        if (callToActionConfigFieldsModel.m19852k() == null || callToActionConfigFieldsModel.m19852k().mo1022a() == null || callToActionConfigFieldsModel.m19852k().mo1022a().size() == 0) {
            return null;
        }
        PageCallToActionGroupView pageCallToActionGroupView = (PageCallToActionGroupView) this.f16820a.inflate(2130905977, pageCallToActionInputFieldsContainer, false);
        int i = 0;
        while (i < callToActionConfigFieldsModel.m19852k().mo1022a().size()) {
            PageCallToActionCheckboxView pageCallToActionCheckboxView2;
            CallToActionConfigCommonFields callToActionConfigCommonFields2 = (CallToActionConfigCommonFields) callToActionConfigFieldsModel.m19852k().mo1022a().get(i);
            PageCallToActionInput a = m20074a(phoneNumberCommonFieldsModel, callToActionConfigCommonFields2, pageCallToActionInputFieldsContainer);
            pageCallToActionGroupView.m20054a(callToActionConfigCommonFields2.mo1024b(), a, callToActionConfigCommonFields2.mo1027g());
            if (pageCallToActionCheckboxView != null) {
                if (a instanceof Observer) {
                    Observer observer = (Observer) a;
                    pageCallToActionCheckboxView.f16796a.addObserver(observer);
                    observer.update(pageCallToActionCheckboxView.f16796a, Boolean.valueOf(pageCallToActionCheckboxView.f16797b.isChecked()));
                    pageCallToActionCheckboxView2 = pageCallToActionCheckboxView;
                }
                pageCallToActionCheckboxView2 = pageCallToActionCheckboxView;
            } else {
                if (a instanceof PageCallToActionCheckboxView) {
                    boolean z;
                    if (pageCallToActionCheckboxView == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    pageCallToActionCheckboxView2 = (PageCallToActionCheckboxView) a;
                }
                pageCallToActionCheckboxView2 = pageCallToActionCheckboxView;
            }
            i++;
            pageCallToActionCheckboxView = pageCallToActionCheckboxView2;
        }
        return pageCallToActionGroupView;
    }

    @Nullable
    public static String m20067b(String... strArr) {
        return strArr.length > 0 ? strArr[0] : null;
    }
}
