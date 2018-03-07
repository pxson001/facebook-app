package com.facebook.feed.workingrange;

import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.workingrange.core.SnapshotWithVisiblity;
import com.facebook.workingrange.core.WorkingRangeBounds;
import com.facebook.workingrange.core.WorkingRangeSnapshot;

/* compiled from: onEnterFullScreen() is called twice before exit */
public class FeedVisibleRange<Item, Snapshot extends SnapshotWithVisiblity<Item>> {
    public final WorkingRangeBounds m16465a(WorkingRangeSnapshot workingRangeSnapshot) {
        SnapshotWithVisiblity snapshotWithVisiblity = (SnapshotWithVisiblity) workingRangeSnapshot;
        Object obj = -1;
        int a = snapshotWithVisiblity.a();
        int b = snapshotWithVisiblity.b();
        if (!(a == Integer.MIN_VALUE || b == Integer.MIN_VALUE)) {
            obj = (a == -1 || b == -1) ? 1 : null;
        }
        switch (obj) {
            case -1:
                return WorkingRangeBounds.f11140c;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return WorkingRangeBounds.f11138a;
            default:
                int a2 = snapshotWithVisiblity.a();
                int b2 = snapshotWithVisiblity.b();
                if (a2 == Integer.MIN_VALUE || b2 == Integer.MIN_VALUE) {
                    return WorkingRangeBounds.f11140c;
                }
                return WorkingRangeBounds.m16466b(a2, b2);
        }
    }
}
