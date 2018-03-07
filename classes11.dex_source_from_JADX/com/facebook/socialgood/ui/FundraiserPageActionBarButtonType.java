package com.facebook.socialgood.ui;

/* compiled from: OFF */
public enum FundraiserPageActionBarButtonType {
    SHARE(2131236865, 2130840097),
    INVITE(2131237042, 2130839845),
    GO_TO_PAGE(2131242336, 0),
    REPORT_FUNDRAISER(2131242337, 0),
    COPY_LINK(2131237049, 0);
    
    private final int mIconResId;
    private final int mTitleResId;

    private FundraiserPageActionBarButtonType(int i, int i2) {
        this.mTitleResId = i;
        this.mIconResId = i2;
    }

    public final int getTitleResId() {
        return this.mTitleResId;
    }

    public final int getIconResId() {
        return this.mIconResId;
    }

    public static FundraiserPageActionBarButtonType fromOrdinal(int i) {
        return values()[i];
    }

    public final boolean isOverflow() {
        return this.mIconResId == 0;
    }
}
