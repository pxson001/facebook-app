package com.facebook.composer.privacy.common;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.selector.AudienceTypeaheadFragment;
import com.facebook.privacy.selector.AudienceTypeaheadFragment.DataProvider;
import com.facebook.privacy.selector.AudienceTypeaheadFragment.SelectorListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: target page id is null */
public class ComposerAudienceFragment extends FbDialogFragment {
    public AudienceTypeaheadFragment am;
    public AudienceDialogData an;

    /* compiled from: target page id is null */
    public class C02022 implements OnClickListener {
        final /* synthetic */ ComposerAudienceFragment f1960a;

        public C02022(ComposerAudienceFragment composerAudienceFragment) {
            this.f1960a = composerAudienceFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1515775037);
            this.f1960a.f.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -20066451, a);
        }
    }

    /* compiled from: target page id is null */
    public class AudienceDialogData {
        public final DataProvider f1961a;
        public final OnAudienceSelectedListener f1962b;
        @Nullable
        public final SelectorListener f1963c;

        public AudienceDialogData(DataProvider dataProvider, OnAudienceSelectedListener onAudienceSelectedListener, @Nullable SelectorListener selectorListener) {
            this.f1961a = dataProvider;
            this.f1962b = onAudienceSelectedListener;
            this.f1963c = selectorListener;
        }
    }

    /* compiled from: target page id is null */
    public interface OnAudienceSelectedListener {
        void mo488a(SelectablePrivacyData selectablePrivacyData);
    }

    public final void m1912a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1249751906);
        super.a(bundle);
        a(2, 2131625364);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 917028992, a);
    }

    public final Dialog m1914c(Bundle bundle) {
        return new Dialog(this, an(), d()) {
            final /* synthetic */ ComposerAudienceFragment f1959a;

            public void onBackPressed() {
                if (this.f1959a.O_()) {
                    super.onBackPressed();
                }
            }
        };
    }

    public final View m1911a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -815255678);
        if (bundle != null) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1926278307, a);
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130903661, viewGroup, false);
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) viewGroup2.findViewById(2131560493);
        fb4aTitleBar.setTitle(2131234251);
        fb4aTitleBar.setButtonSpecs(RegularImmutableList.a);
        fb4aTitleBar.a(new C02022(this));
        Preconditions.checkNotNull(this.an, "Audience dialog data was not set!");
        this.am = (AudienceTypeaheadFragment) s().a(2131559741);
        this.am.a(this.an.f1961a);
        if (this.an.f1963c != null) {
            this.am.a(this.an.f1963c);
        }
        LogUtils.f(-2074136018, a);
        return viewGroup2;
    }

    public final void m1913a(AudienceDialogData audienceDialogData) {
        Preconditions.checkState(this.am == null, "Typeahead data must be set before starting the fragment!");
        this.an = (AudienceDialogData) Preconditions.checkNotNull(audienceDialogData);
    }

    public final boolean O_() {
        if (this.am == null) {
            return true;
        }
        if (!this.am.b()) {
            return false;
        }
        this.an.f1962b.mo488a(this.am.e());
        return true;
    }
}
