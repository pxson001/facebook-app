package com.facebook.redspace.abtest;

import com.facebook.qe.api.QeAccessor;

/* compiled from: should_show */
public enum RedSpaceFriendsLayout {
    GRID,
    LIST;

    public static RedSpaceFriendsLayout getLayout(QeAccessor qeAccessor) {
        if (qeAccessor.a(ExperimentsForRedSpaceExperimentsModule.e, false)) {
            return qeAccessor.a(ExperimentsForRedSpaceExperimentsModule.i, false) ? GRID : LIST;
        } else {
            return LIST;
        }
    }
}
