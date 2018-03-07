package com.facebook.messaging.threadview.rows;

/* compiled from: pma_deeplinking */
public enum RowItemGrouping {
    DEFAULT(false, false, false),
    DEFAULT_WITH_DIVIDER(false, false, true),
    ONLY_WITH_NEWER_ROW(true, false, false),
    ONLY_WITH_NEWER_ROW_WITH_DIVIDER(true, false, true),
    ONLY_WITH_OLDER_ROW(false, true, false),
    WITH_OLDER_AND_NEW_ROWS(true, true, false);
    
    public final boolean groupWithNewerRow;
    public final boolean groupWithOlderRow;
    public final boolean hasTimestapDividerAbove;

    public static RowItemGrouping forGrouping(boolean z, boolean z2, boolean z3) {
        if (z && z2) {
            return WITH_OLDER_AND_NEW_ROWS;
        }
        if (z) {
            return z3 ? ONLY_WITH_NEWER_ROW_WITH_DIVIDER : ONLY_WITH_NEWER_ROW;
        } else {
            if (z2) {
                return ONLY_WITH_OLDER_ROW;
            }
            return z3 ? DEFAULT_WITH_DIVIDER : DEFAULT;
        }
    }

    private RowItemGrouping(boolean z, boolean z2, boolean z3) {
        this.groupWithNewerRow = z;
        this.groupWithOlderRow = z2;
        this.hasTimestapDividerAbove = z3;
    }
}
