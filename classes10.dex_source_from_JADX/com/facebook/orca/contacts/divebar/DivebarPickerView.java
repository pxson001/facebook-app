package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.MessengerEntryLogger;
import com.facebook.analytics.MessengerEntryLogger.EntryPoints;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.util.LoggerUtils;
import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.contacts.picker.ContactPickerGroupRow;
import com.facebook.contacts.picker.ContactPickerHeaderViewManager;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.picker.ContactPickerView.OnRowClickedListener;
import com.facebook.contacts.picker.ContactPickerViewFilterState;
import com.facebook.contacts.picker.DivebarSearchableContactPickerView;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.orca.contacts.divebar.DivebarFragment.AnonymousClass12;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher;
import com.facebook.quickpromotion.ui.QuickPromotionDivebarViewFactory;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelperProvider;
import com.facebook.user.model.User;
import com.facebook.widget.CustomViewGroup;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: onPeerDisconnected */
public class DivebarPickerView extends CustomViewGroup {
    public final DivebarSearchableContactPickerView f5873a;
    public final ViewGroup f5874b;
    public final ContactPickerHeaderViewManager f5875c;
    public final DivebarChatAvailabilityWarning f5876d;
    public QuickPromotionDiveBarViewController f5877e;
    public MessengerEntryLogger f5878f;
    public AnalyticsLogger f5879g;
    public BaseAnalyticsConfig f5880h;
    public DivebarViewListener f5881i;
    @Nullable
    public AnonymousClass12 f5882j;

    /* compiled from: onPeerDisconnected */
    class C08641 implements OnRowClickedListener {
        final /* synthetic */ DivebarPickerView f5866a;

        C08641(DivebarPickerView divebarPickerView) {
            this.f5866a = divebarPickerView;
        }

        public final void m5536a(ContactPickerRow contactPickerRow, int i) {
            DivebarPickerView.m5537a(this.f5866a, contactPickerRow, i);
        }
    }

    /* compiled from: onPeerDisconnected */
    public class C08652 {
        public final /* synthetic */ DivebarPickerView f5867a;

        C08652(DivebarPickerView divebarPickerView) {
            this.f5867a = divebarPickerView;
        }
    }

    /* compiled from: onPeerDisconnected */
    public class C08663 {
        public final /* synthetic */ DivebarPickerView f5868a;

        C08663(DivebarPickerView divebarPickerView) {
            this.f5868a = divebarPickerView;
        }
    }

    /* compiled from: onPeerDisconnected */
    public class C08674 {
        public final /* synthetic */ DivebarPickerView f5869a;

        C08674(DivebarPickerView divebarPickerView) {
            this.f5869a = divebarPickerView;
        }
    }

    /* compiled from: onPeerDisconnected */
    public class C08685 {
        public final /* synthetic */ DivebarPickerView f5870a;

        C08685(DivebarPickerView divebarPickerView) {
            this.f5870a = divebarPickerView;
        }
    }

    /* compiled from: onPeerDisconnected */
    class C08696 implements OnFocusChangeListener {
        final /* synthetic */ DivebarPickerView f5871a;

        C08696(DivebarPickerView divebarPickerView) {
            this.f5871a = divebarPickerView;
        }

        public void onFocusChange(View view, boolean z) {
            int i;
            int i2 = 8;
            ViewGroup viewGroup = this.f5871a.f5874b;
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            viewGroup.setVisibility(i);
            DivebarChatAvailabilityWarning divebarChatAvailabilityWarning = this.f5871a.f5876d;
            if (!z) {
                i2 = 0;
            }
            divebarChatAvailabilityWarning.setVisibility(i2);
        }
    }

    /* compiled from: onPeerDisconnected */
    /* synthetic */ class C08707 {
        static final /* synthetic */ int[] f5872a = new int[ContactRowSectionType.values().length];

        static {
            try {
                f5872a[ContactRowSectionType.ACTIVE_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5872a[ContactRowSectionType.AUTO_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5872a[ContactRowSectionType.FAVORITES.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5872a[ContactRowSectionType.NEARBY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5872a[ContactRowSectionType.SEARCH_RESULT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5872a[ContactRowSectionType.SUGGESTIONS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5872a[ContactRowSectionType.TOP_FRIENDS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f5872a[ContactRowSectionType.UNKNOWN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public static void m5538a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DivebarPickerView divebarPickerView = (DivebarPickerView) obj;
        QuickPromotionDiveBarViewController quickPromotionDiveBarViewController = new QuickPromotionDiveBarViewController(InterstitialManager.a(fbInjector), new QuickPromotionDivebarViewFactory((QuickPromotionViewHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(QuickPromotionViewHelperProvider.class), QuickPromotionImageFetcher.a(fbInjector)));
        MessengerEntryLogger a = MessengerEntryLogger.a(fbInjector);
        AnalyticsLogger a2 = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        BaseAnalyticsConfig baseAnalyticsConfig = (BaseAnalyticsConfig) FbAnalyticsConfig.a(fbInjector);
        divebarPickerView.f5877e = quickPromotionDiveBarViewController;
        divebarPickerView.f5878f = a;
        divebarPickerView.f5879g = a2;
        divebarPickerView.f5880h = baseAnalyticsConfig;
    }

    public DivebarPickerView(Context context, BaseSearchableContactPickerListAdapter baseSearchableContactPickerListAdapter) {
        super(context);
        this.f5873a = new DivebarSearchableContactPickerView(context, baseSearchableContactPickerListAdapter, 2130905671);
        this.f5873a.j = true;
        this.f5873a.setSearchHint(context.getString(2131231202));
        addView(this.f5873a);
        this.f5876d = (DivebarChatAvailabilityWarning) getView(2131564798);
        this.f5876d.setVisibility(0);
        this.f5873a.g.c = new C08641(this);
        this.f5873a.b = new C08652(this);
        this.f5873a.c = new C08663(this);
        this.f5873a.d = new C08674(this);
        this.f5873a.l = new C08685(this);
        this.f5874b = (ViewGroup) getView(2131564797);
        this.f5875c = new ContactPickerHeaderViewManager(this.f5874b);
        Class cls = DivebarPickerView.class;
        m5538a(this, getContext());
        this.f5873a.k = new C08696(this);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f5882j != null) {
            AnonymousClass12 anonymousClass12 = this.f5882j;
            anonymousClass12.f5805a.aE.f5882j = null;
            anonymousClass12.f5805a.aA.b(6225921, (short) 2);
        }
    }

    public ContactPickerHeaderViewManager getContactPickerHeaderViewManager() {
        return this.f5875c;
    }

    public static void m5537a(DivebarPickerView divebarPickerView, ContactPickerRow contactPickerRow, int i) {
        if (divebarPickerView.f5881i == null) {
            return;
        }
        if (contactPickerRow instanceof ContactPickerUserRow) {
            boolean z;
            divebarPickerView.f5878f.a(EntryPoints.DIVEBAR);
            ContactPickerUserRow contactPickerUserRow = (ContactPickerUserRow) contactPickerRow;
            divebarPickerView.setLastNavigationTapPoint(contactPickerRow);
            DivebarViewListener divebarViewListener = divebarPickerView.f5881i;
            User user = contactPickerUserRow.a;
            DivebarSearchableContactPickerView divebarSearchableContactPickerView = divebarPickerView.f5873a;
            if (ContactPickerViewFilterState.FILTERED == divebarSearchableContactPickerView.e || ContactPickerViewFilterState.FILTERING == divebarSearchableContactPickerView.e) {
                z = true;
            } else {
                z = false;
            }
            divebarViewListener.m5547a(user, z, contactPickerRow, "divebar", i);
        } else if (contactPickerRow instanceof ContactPickerGroupRow) {
            divebarPickerView.f5881i.m5546a(((ContactPickerGroupRow) contactPickerRow).a, contactPickerRow, "divebar");
        }
    }

    private void setLastNavigationTapPoint(ContactPickerRow contactPickerRow) {
        String str;
        switch (C08707.f5872a[((ContactRowSectionType) ((ContactPickerUserRow) contactPickerRow).m).ordinal()]) {
            case 1:
                str = "via_chat_bar_active_chats_section";
                break;
            case 2:
                str = "via_chat_bar_auto_complete_section";
                break;
            case 3:
                str = "via_chat_bar_favorite_friends_section";
                break;
            case 4:
                str = "via_chat_bar_nearby_friends_section";
                break;
            case 5:
                str = "via_chat_bar_search_result_section";
                break;
            case 6:
                str = "via_chat_bar_suggestions_section";
                break;
            case 7:
                str = "via_chat_bar_top_friends_section";
                break;
            case 8:
                str = "via_chat_bar_unknown_section";
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            LoggerUtils.a(getContext()).a(str);
        }
    }

    public String getSearchBoxText() {
        return this.f5873a.getSearchBoxText();
    }

    public final void m5540a(ImmutableList<ContactPickerRow> immutableList) {
        this.f5873a.a(immutableList);
        this.f5876d.mo217f();
    }

    public final void m5539a() {
        this.f5873a.d();
    }
}
