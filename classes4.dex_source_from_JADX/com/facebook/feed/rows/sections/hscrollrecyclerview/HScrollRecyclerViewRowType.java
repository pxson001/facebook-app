package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.facebook.widget.hscrollrecyclerview.KeepAttachedHScrollRecyclerView;

/* compiled from: feedAwesomizerProfilePicture */
public class HScrollRecyclerViewRowType {
    public static final ViewType f11901a = new C05771();
    public static final ViewType f11902b = new C05782();
    public static final ViewType f11903c = new C05793();

    /* compiled from: feedAwesomizerProfilePicture */
    final class C05771 extends ViewType {
        C05771() {
        }

        public final View m12503a(Context context) {
            return (HScrollRecyclerView) LayoutInflater.from(context).inflate(2130904812, null);
        }
    }

    /* compiled from: feedAwesomizerProfilePicture */
    final class C05782 extends ViewType {
        C05782() {
        }

        public final View m12504a(Context context) {
            return (HScrollRecyclerView) LayoutInflater.from(context).inflate(2130904813, null);
        }
    }

    /* compiled from: feedAwesomizerProfilePicture */
    final class C05793 extends ViewType {
        C05793() {
        }

        public final View m12505a(Context context) {
            return (KeepAttachedHScrollRecyclerView) LayoutInflater.from(context).inflate(2130904994, null);
        }
    }
}
