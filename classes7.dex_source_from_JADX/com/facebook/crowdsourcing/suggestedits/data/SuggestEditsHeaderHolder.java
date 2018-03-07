package com.facebook.crowdsourcing.suggestedits.data;

import android.support.v4.app.Fragment;
import android.view.View;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsHeader;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.helper.ExtractValuesHelper;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.view.controller.SuggestEditsViewControllerManager;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: collection_name */
public class SuggestEditsHeaderHolder implements SuggestEditsFieldChangedListener<SuggestEditsHeader> {
    private final Fragment f17665a;
    private final SuggestEditsController f17666b;
    private final String f17667c;
    public SuggestEditsViewControllerManager f17668d;
    public SuggestEditsHeaderState f17669e;
    public final View f17670f;

    @Inject
    public SuggestEditsHeaderHolder(@Assisted Fragment fragment, @Assisted SuggestEditsController suggestEditsController, @Assisted View view, @Assisted SuggestEditsHeaderState suggestEditsHeaderState, @Assisted String str, SuggestEditsViewControllerManager suggestEditsViewControllerManager) {
        this.f17665a = fragment;
        this.f17666b = suggestEditsController;
        this.f17670f = view;
        this.f17669e = suggestEditsHeaderState;
        this.f17667c = str;
        this.f17668d = suggestEditsViewControllerManager;
    }

    public final SuggestEditsHeaderModel m21511c() {
        return this.f17669e.f17673c;
    }

    private void m21507b(SuggestEditsHeaderModel suggestEditsHeaderModel) {
        this.f17669e.f17674d = this.f17669e.f17673c;
        m21509a(suggestEditsHeaderModel);
    }

    public final void m21509a(SuggestEditsHeaderModel suggestEditsHeaderModel) {
        if (this.f17669e.f17671a) {
            this.f17666b.m21473a();
            this.f17669e.f17673c = suggestEditsHeaderModel;
        } else {
            this.f17669e = new SuggestEditsHeaderState(suggestEditsHeaderModel, true);
        }
        this.f17668d.m21672a(this.f17670f, this, null, SuggestEditsListViewType.PAGE_HEADER, this, this.f17666b, SuggestEditsInputType.PHOTO_PICKER, this.f17665a, this.f17667c);
    }

    public final String mo1368a() {
        return "header_field";
    }

    public final boolean m21512e() {
        return m21506a(this.f17669e.f17672b, this.f17669e.f17673c);
    }

    public static boolean m21506a(SuggestEditsHeaderModel suggestEditsHeaderModel, SuggestEditsHeaderModel suggestEditsHeaderModel2) {
        String d = ExtractValuesHelper.m21536d(suggestEditsHeaderModel);
        String d2 = ExtractValuesHelper.m21536d(suggestEditsHeaderModel2);
        if (d2 != null && !d2.equals(d)) {
            return true;
        }
        if (d2 != null || d == null) {
            return false;
        }
        return true;
    }

    public final void m21513h() {
        m21507b(SuggestEditsFieldMutator.m21505b(this.f17669e.f17673c, ExtractValuesHelper.m21536d(this.f17669e.f17672b)));
    }

    public final void m21514i() {
        m21507b(SuggestEditsFieldMutator.m21505b(this.f17669e.f17673c, ExtractValuesHelper.m21536d(this.f17669e.f17674d)));
    }
}
