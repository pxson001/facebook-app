package com.facebook.quickpromotion.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import javax.inject.Inject;

/* compiled from: question_answer_tap */
public class QuickPromotionTabFragmentFactory implements IFragmentFactory {
    private QuickPromotionFragmentFactory f4838a;

    @Inject
    public QuickPromotionTabFragmentFactory(QuickPromotionFragmentFactory quickPromotionFragmentFactory) {
        this.f4838a = quickPromotionFragmentFactory;
    }

    public final Fragment m4710a(Intent intent) {
        return this.f4838a.m4681a(intent);
    }
}
