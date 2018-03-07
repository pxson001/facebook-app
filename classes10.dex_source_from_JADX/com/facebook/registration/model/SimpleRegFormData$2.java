package com.facebook.registration.model;

import com.facebook.registration.constants.RegErrorCategory;

/* compiled from: keyboard_popup */
public /* synthetic */ class SimpleRegFormData$2 {
    public static final /* synthetic */ int[] f8904a = new int[RegErrorCategory.values().length];

    static {
        try {
            f8904a[RegErrorCategory.PHONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f8904a[RegErrorCategory.EMAIL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f8904a[RegErrorCategory.NAME.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f8904a[RegErrorCategory.BIRTHDAY.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f8904a[RegErrorCategory.GENDER.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f8904a[RegErrorCategory.PASSWORD.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
