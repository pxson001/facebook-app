package com.facebook.feed.rows.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Lazy;
import com.facebook.ui.toaster.Toaster;

/* compiled from: friending_set_notification_preference */
public class CopyStoryTextListener extends SimpleOnGestureListener {
    public final Lazy<Toaster> f23094a;
    public final GraphQLStory f23095b;
    public final Context f23096c;
    public PopoverMenuWindow f23097d;
    public View f23098e;
    public boolean f23099f = false;

    @SuppressLint({"ConstructorMayLeakThis"})
    public CopyStoryTextListener(Lazy<Toaster> lazy, GraphQLStory graphQLStory, Context context) {
        this.f23094a = lazy;
        this.f23095b = graphQLStory;
        this.f23096c = context;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.f23098e != null) {
            if (this.f23097d == null) {
                this.f23097d = new FigPopoverMenuWindow(this.f23096c, 1);
                PopoverMenu popoverMenu = new PopoverMenu(this.f23096c);
                this.f23097d.a(popoverMenu);
                popoverMenu.a(2131233492).setOnMenuItemClickListener(new 1(this));
            }
            this.f23099f = true;
            this.f23097d.f(this.f23098e);
        }
    }
}
