package com.facebook.ui.drawers;

import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: query_title */
public abstract class OneSidedDrawerAnimationStateListener {
    private Drawer f8414a;
    public DrawerState f8415b;
    public DrawerState f8416c;
    public boolean f8417d = false;

    /* compiled from: query_title */
    /* synthetic */ class C03671 {
        static final /* synthetic */ int[] f8418a = new int[Drawer.values().length];

        static {
            try {
                f8418a[Drawer.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8418a[Drawer.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public abstract void mo1744a(SingleDrawerState singleDrawerState);

    public abstract void mo1745b(SingleDrawerState singleDrawerState);

    public abstract void mo1746c(SingleDrawerState singleDrawerState);

    public OneSidedDrawerAnimationStateListener(Drawer drawer) {
        this.f8414a = drawer;
        switch (C03671.f8418a[drawer.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f8415b = DrawerState.SHOWING_LEFT;
                this.f8416c = DrawerState.SHOWING_RIGHT;
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f8415b = DrawerState.SHOWING_RIGHT;
                this.f8416c = DrawerState.SHOWING_LEFT;
                return;
            default:
                return;
        }
    }

    public static SingleDrawerState m12961c(DrawerState drawerState) {
        if (drawerState == DrawerState.CLOSED) {
            return SingleDrawerState.CLOSED;
        }
        return SingleDrawerState.OPENED;
    }
}
