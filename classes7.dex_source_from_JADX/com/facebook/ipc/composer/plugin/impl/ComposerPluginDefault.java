package com.facebook.ipc.composer.plugin.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.ipc.composer.plugin.C1356xf36cc009;
import com.facebook.ipc.composer.plugin.C1357xfc1bb422;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$PrivacyDelegateGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginAllowsCheckinGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginAllowsDraftSavingGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginAllowsLiveGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginAllowsMinutiaeGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginAllowsPhotoGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginAllowsSubmitGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginAllowsTaggingPeopleGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginAreAttachmentsReadOnlyGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginHasUserEditedContentGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginIsDatePickerSupportedGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginPublishButtonTextGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginStatusHintGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginSurveyConstraintGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$ProvidesPluginTitleGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: connecting */
public abstract class ComposerPluginDefault implements ComposerEventHandler, C1356xf36cc009, ComposerPluginGetters$ProvidesPluginAllowsCheckinGetter, ComposerPluginGetters$ProvidesPluginAllowsDraftSavingGetter, ComposerPluginGetters$ProvidesPluginAllowsLiveGetter, ComposerPluginGetters$ProvidesPluginAllowsMinutiaeGetter, ComposerPluginGetters$ProvidesPluginAllowsPhotoGetter, ComposerPluginGetters$ProvidesPluginAllowsSubmitGetter, ComposerPluginGetters$ProvidesPluginAllowsTaggingPeopleGetter, ComposerPluginGetters$ProvidesPluginAreAttachmentsReadOnlyGetter, ComposerPluginGetters$ProvidesPluginHasUserEditedContentGetter, ComposerPluginGetters$ProvidesPluginIsDatePickerSupportedGetter, ComposerPluginGetters$ProvidesPluginPublishButtonTextGetter, C1357xfc1bb422, ComposerPluginGetters$ProvidesPluginStatusHintGetter, ComposerPluginGetters$ProvidesPluginSurveyConstraintGetter, ComposerPluginGetters$ProvidesPluginTitleGetter {
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16893A = ad();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16894B = ae();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16895C = af();
    @Nullable
    public final ComposerPluginGetters$Getter<String> f16896D = ag();
    @Nullable
    public final ComposerPluginGetters$Getter<String> f16897E = az();
    @Nullable
    public final ComposerPluginGetters$Getter<String> f16898F = ax();
    @Nullable
    public final ComposerPluginGetters$Getter<String> f16899G = ay();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16900H = aA();
    @Nullable
    private final ComposerPluginGetters$Getter<String> f16901I = aB();
    @Nullable
    public final ComposerPluginGetters$Getter<SearchType> f16902J = aC();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16903K = aD();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16904L = aE();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16905M = aF();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16906N = aG();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16907O = aH();
    @Nullable
    public final ComposerPluginGetters$Getter<Bundle> f16908P = aI();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16909Q = aJ();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16910R = aK();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16911S = aL();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16912T = aM();
    @Nullable
    public final ComposerPluginGetters$Getter<ImmutableList<String>> f16913U = aN();
    @Nullable
    private final ComposerPluginGetters$Getter<TagTypeaheadDataSource> f16914V = aO();
    private final WeakReference<ComposerPluginSession> f16915a;
    public final Context f16916b;
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16917c = mo1319H();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16918d = m20866I();
    @Nullable
    private final ComposerPluginGetters$Getter<String> f16919e = m20864G();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16920f = mo1454J();
    @Nullable
    private final ComposerPluginGetters$Getter<String> f16921g = m20868K();
    @Nullable
    private final ComposerPluginGetters$Getter<ImmutableMap<String, String>> f16922h = null;
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16923i = mo1320L();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16924j = mo1321M();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16925k = m20871N();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16926l = m20872O();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16927m = mo1322P();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16928n = mo1323Q();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16929o = mo1325S();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16930p = mo1326T();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16931q = m20878U();
    @Nullable
    private final ComposerPluginGetters$Getter<Intent> f16932r = mo1327V();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16933s = mo1324R();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16934t = m20880W();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16935u = mo1328X();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16936v = m20882Y();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16937w = m20883Z();
    @Nullable
    public final ComposerPluginGetters$BooleanGetter f16938x = aa();
    @Nullable
    public final ComposerPluginGetters$PrivacyDelegateGetter f16939y = ab();
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16940z = ac();

    protected ComposerPluginDefault(Context context, ComposerPluginSession composerPluginSession) {
        this.f16916b = context;
        this.f16915a = new WeakReference(Preconditions.checkNotNull(composerPluginSession));
    }

    public final ComposerPluginSession m20863E() {
        return (ComposerPluginSession) Preconditions.checkNotNull(this.f16915a.get(), "Session expired");
    }

    public InstanceState m20884a() {
        return InstanceState.a;
    }

    public void m20885a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
    }

    @Nullable
    public final ComposerPluginGetters$Getter<String> as() {
        return this.f16919e;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<String> m20864G() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter am() {
        return this.f16917c;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter mo1319H() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter m20866I() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter ah() {
        return this.f16920f;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter mo1454J() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$Getter<String> aw() {
        return this.f16921g;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<String> m20868K() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$Getter<ImmutableMap<String, String>> av() {
        return this.f16922h;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter al() {
        return this.f16923i;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter mo1320L() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter ak() {
        return this.f16924j;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter mo1321M() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter aq() {
        return this.f16925k;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter m20871N() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter an() {
        return this.f16926l;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter m20872O() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter ai() {
        return this.f16927m;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter mo1322P() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter aj() {
        return this.f16928n;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter mo1323Q() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter ao() {
        return this.f16933s;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter mo1324R() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter mo1325S() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter mo1326T() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter m20890g() {
        return this.f16931q;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter m20878U() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$Getter<Intent> m20894z() {
        return this.f16932r;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<Intent> mo1327V() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter m20880W() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter ap() {
        return this.f16935u;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter mo1328X() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter m20882Y() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter m20883Z() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter aa() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$PrivacyDelegateGetter ab() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter ac() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter m20862A() {
        return this.f16893A;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter ad() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter at() {
        return this.f16894B;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter ae() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter af() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<String> ag() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<String> ax() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<String> ay() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<String> az() {
        return null;
    }

    protected ComposerPluginGetters$BooleanGetter aA() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$Getter<String> au() {
        return this.f16901I;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<String> aB() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<SearchType> aC() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter aD() {
        return null;
    }

    public boolean m20886a(ViewStub viewStub) {
        return false;
    }

    public void m20888b(ViewStub viewStub) {
    }

    public void m20887b() {
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter ar() {
        return this.f16904L;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter aE() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter aF() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter aG() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter aH() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$Getter<Bundle> m20891l() {
        return this.f16908P;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<Bundle> aI() {
        return null;
    }

    @Nullable
    public ComposerPluginGetters$BooleanGetter m20892r() {
        return this.f16909Q;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter aJ() {
        return null;
    }

    @Nullable
    public ComposerPluginGetters$BooleanGetter mo1334f() {
        return this.f16910R;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter aK() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter aL() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$BooleanGetter aM() {
        return null;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<ImmutableList<String>> aN() {
        return null;
    }

    @Nullable
    public final ComposerPluginGetters$Getter<TagTypeaheadDataSource> m20893w() {
        return this.f16914V;
    }

    @Nullable
    protected ComposerPluginGetters$Getter<TagTypeaheadDataSource> aO() {
        return null;
    }
}
