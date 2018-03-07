package com.facebook.events.dashboard;

/* compiled from: composer/?link={%s}&app_id={%s}&name={%s}&caption={%s}&description={%s}&picture={%s}&quote={%s}&%s={!%s false}&%s={!%s false} */
public enum DashboardFilterType {
    UPCOMING(2131237123, 2130838367, 2130838368),
    INVITED(2131237125, 2130838363, 2130838364),
    BIRTHDAYS(2131237126, 2130838361, 2130838362),
    HOSTING(2131237127, 2130838361, 2130838362),
    PAST(2131237124, 2130838365, 2130838366);
    
    public final int iconResId;
    public final int menuStringResId;
    public final int selectedIconResId;

    private DashboardFilterType(int i, int i2, int i3) {
        this.menuStringResId = i;
        this.iconResId = i2;
        this.selectedIconResId = i3;
    }
}
