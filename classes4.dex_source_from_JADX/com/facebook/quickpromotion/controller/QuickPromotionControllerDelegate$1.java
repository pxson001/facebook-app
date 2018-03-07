package com.facebook.quickpromotion.controller;

import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.google.common.primitives.Longs;
import java.util.Comparator;

/* compiled from: record_remote_raw_video */
public class QuickPromotionControllerDelegate$1 implements Comparator<QuickPromotionDefinition> {
    final /* synthetic */ QuickPromotionControllerDelegate f3553a;

    public QuickPromotionControllerDelegate$1(QuickPromotionControllerDelegate quickPromotionControllerDelegate) {
        this.f3553a = quickPromotionControllerDelegate;
    }

    public int compare(Object obj, Object obj2) {
        return Longs.m1257a(((QuickPromotionDefinition) obj).priority, ((QuickPromotionDefinition) obj2).priority);
    }
}
