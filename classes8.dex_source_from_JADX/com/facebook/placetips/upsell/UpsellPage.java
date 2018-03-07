package com.facebook.placetips.upsell;

import android.support.v4.app.Fragment;
import com.google.common.base.Throwables;
import javax.annotation.Nullable;

/* compiled from: can't serialize the module view size */
public enum UpsellPage {
    INTRO_NOTIFICATIONS_LS("intro_notifications_ls", PlaceTipsUpsellIntroFragment.class),
    TURN_ON_NOTIFICATIONS_LS("turn_on_notifications_ls", PlaceTipsUpsellTurnOnNotificationsFragment.class),
    PLACES_SAVE_INTRO("places_save_intro", PlaceTipsSaveUpsellIntroFragment.class),
    NETWORK_ERROR("network_error", PlaceTipsUpsellErrorFragment.class),
    CONFIRMATION("confirmation", PlaceTipsUpsellConfirmationFragment.class);
    
    private final Class<? extends Fragment> mFragmentClass;
    private final String mId;

    @Nullable
    public static UpsellPage fromId(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (UpsellPage upsellPage : values()) {
            if (str.equals(upsellPage.mId)) {
                return upsellPage;
            }
        }
        return null;
    }

    private UpsellPage(String str, Class<? extends Fragment> cls) {
        this.mId = str;
        this.mFragmentClass = cls;
    }

    public final Fragment createNewFragment() {
        Throwable e;
        try {
            return (Fragment) this.mFragmentClass.newInstance();
        } catch (InstantiationException e2) {
            e = e2;
            throw Throwables.propagate(e);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw Throwables.propagate(e);
        }
    }

    public final String getId() {
        return this.mId;
    }
}
