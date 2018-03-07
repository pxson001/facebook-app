package com.facebook.ui.drawers;

/* compiled from: ensureSync full refresh delayed because it was already performed recently. */
public /* synthetic */ class DrawerController$1 {
    public static final /* synthetic */ int[] f15254a = new int[Drawer.values().length];
    public static final /* synthetic */ int[] f15255b = new int[DrawerState.values().length];

    static {
        try {
            f15255b[DrawerState.SHOWING_LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f15255b[DrawerState.SHOWING_RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f15255b[DrawerState.CLOSED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f15254a[Drawer.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f15254a[Drawer.RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
    }
}
