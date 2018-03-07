package com.facebook.adinterfaces;

import com.facebook.adinterfaces.external.ObjectiveType;

/* compiled from: account_business_info */
public class AdInterfacesCreativeHelper {

    /* compiled from: account_business_info */
    public /* synthetic */ class C24751 {
        public static final /* synthetic */ int[] f21486a = new int[ObjectiveType.values().length];

        static {
            try {
                f21486a[ObjectiveType.PAGE_LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21486a[ObjectiveType.PAGE_LIKE_EDIT_CREATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: account_business_info */
    public class Dimension {
        public final int f21487a;
        public final int f21488b;

        public Dimension(int i, int i2) {
            this.f21487a = i2;
            this.f21488b = i;
        }
    }

    public static Dimension m22434b(ObjectiveType objectiveType) {
        switch (C24751.f21486a[objectiveType.ordinal()]) {
            case 1:
            case 2:
                return new Dimension(400, 150);
            default:
                return new Dimension(254, 133);
        }
    }
}
