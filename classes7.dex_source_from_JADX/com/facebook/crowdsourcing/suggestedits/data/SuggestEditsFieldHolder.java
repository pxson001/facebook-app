package com.facebook.crowdsourcing.suggestedits.data;

import android.support.v4.app.Fragment;
import android.view.View;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.view.controller.SuggestEditsViewControllerManager;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: com.amazon.mp3.artist */
public class SuggestEditsFieldHolder implements SuggestEditsFieldChangedListener<SuggestEditsField> {
    public final SuggestEditsViewControllerManager f17656a;
    private final Fragment f17657b;
    private final SuggestEditsController f17658c;
    private final SuggestEditsInputType f17659d;
    public final SuggestEditsField f17660e;
    public final View f17661f;
    public final SuggestEditsListViewType f17662g;
    private final String f17663h;
    public SuggestEditsField f17664i;

    public final void mo1369a(Object obj) {
        m21485c((SuggestEditsField) obj);
        this.f17658c.m21473a();
    }

    @Inject
    public SuggestEditsFieldHolder(SuggestEditsViewControllerManager suggestEditsViewControllerManager, @Assisted Fragment fragment, @Assisted SuggestEditsController suggestEditsController, @Assisted SuggestEditsField suggestEditsField, @Assisted SuggestEditsInputType suggestEditsInputType, @Assisted View view, @Assisted SuggestEditsListViewType suggestEditsListViewType, @Assisted String str) {
        this.f17656a = suggestEditsViewControllerManager;
        this.f17657b = fragment;
        this.f17658c = suggestEditsController;
        this.f17660e = suggestEditsField;
        this.f17664i = suggestEditsField;
        this.f17659d = suggestEditsInputType;
        this.f17661f = view;
        this.f17662g = suggestEditsListViewType;
        this.f17663h = str;
    }

    public final void m21487a(SuggestEditsField suggestEditsField) {
        m21485c(suggestEditsField);
    }

    private void m21485c(SuggestEditsField suggestEditsField) {
        this.f17664i = suggestEditsField;
        this.f17656a.m21672a(this.f17661f, this.f17664i, this.f17660e, this.f17662g, this, this.f17658c, this.f17659d, this.f17657b, this.f17663h);
    }

    public final String mo1368a() {
        return this.f17664i == null ? null : this.f17664i.mo109d();
    }

    public final SuggestEditsField m21489c() {
        return this.f17664i;
    }
}
