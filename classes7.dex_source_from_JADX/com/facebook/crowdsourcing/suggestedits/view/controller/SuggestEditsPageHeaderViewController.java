package com.facebook.crowdsourcing.suggestedits.view.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.picker.SuggestEditsPickerLauncher;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsPhotoContextMenuManager;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsPhotoContextMenuManager.C14761;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldMutator;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsHeaderHolder;
import com.facebook.crowdsourcing.suggestedits.helper.ExtractValuesHelper;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.view.SuggestEditsPageHeaderView;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: checkin_button_clicked */
public class SuggestEditsPageHeaderViewController implements SuggestEditsViewController<SuggestEditsPageHeaderView, SuggestEditsHeaderHolder> {
    private final Provider<Boolean> f17807a;
    public final Provider<Boolean> f17808b;
    public final UriIntentMapper f17809c;
    public final SecureContextHelper f17810d;
    private final SuggestEditsPhotoContextMenuManager f17811e;

    public static SuggestEditsPageHeaderViewController m21645b(InjectorLike injectorLike) {
        return new SuggestEditsPageHeaderViewController(IdBasedProvider.a(injectorLike, 3949), IdBasedProvider.a(injectorLike, 3950), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), new SuggestEditsPhotoContextMenuManager(IdBasedProvider.a(injectorLike, 3949), SuggestEditsPickerLauncher.m21358a(injectorLike)));
    }

    public final /* bridge */ /* synthetic */ void mo1373a(View view, Object obj, Object obj2, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment, String str) {
        m21644a((SuggestEditsPageHeaderView) view, (SuggestEditsHeaderHolder) obj, suggestEditsFieldChangedListener, suggestEditsController, fragment, str);
    }

    @Inject
    public SuggestEditsPageHeaderViewController(Provider<Boolean> provider, Provider<Boolean> provider2, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, SuggestEditsPhotoContextMenuManager suggestEditsPhotoContextMenuManager) {
        this.f17807a = provider;
        this.f17808b = provider2;
        this.f17809c = uriIntentMapper;
        this.f17810d = secureContextHelper;
        this.f17811e = suggestEditsPhotoContextMenuManager;
    }

    public final SuggestEditsListViewType mo1371a() {
        return SuggestEditsListViewType.PAGE_HEADER;
    }

    public final View mo1370a(ViewGroup viewGroup) {
        return (SuggestEditsPageHeaderView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907298, viewGroup, false);
    }

    private void m21644a(final SuggestEditsPageHeaderView suggestEditsPageHeaderView, final SuggestEditsHeaderHolder suggestEditsHeaderHolder, final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, final SuggestEditsController suggestEditsController, Fragment fragment, final String str) {
        Spanned spanned;
        boolean z;
        Object obj;
        int i;
        if (((Boolean) this.f17807a.get()).booleanValue()) {
            suggestEditsPageHeaderView.setAddPhotoImageResource(2130839749);
        }
        Context context = suggestEditsPageHeaderView.getContext();
        int c = suggestEditsHeaderHolder.m21511c().m2764c();
        if (c == 0) {
            spanned = null;
        } else {
            spanned = Html.fromHtml(context.getResources().getQuantityString(2131689727, c, new Object[]{Integer.valueOf(c)}));
        }
        Spanned spanned2 = spanned;
        suggestEditsHeaderHolder.m21511c();
        suggestEditsPageHeaderView.m21587a(spanned2, new OnClickListener(this) {
            final /* synthetic */ SuggestEditsPageHeaderViewController f17799c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1345911411);
                if (((Boolean) this.f17799c.f17808b.get()).booleanValue()) {
                    Intent a2 = this.f17799c.f17809c.a(suggestEditsPageHeaderView.getContext(), StringFormatUtil.a(FBLinks.ak, new Object[]{str}));
                    if (a2 != null) {
                        this.f17799c.f17810d.a(a2, suggestEditsPageHeaderView.getContext());
                    }
                }
                Logger.a(2, EntryType.UI_INPUT_END, 2146636367, a);
            }
        });
        suggestEditsPageHeaderView.setPageName(ExtractValuesHelper.m21534c(suggestEditsHeaderHolder.m21511c()));
        suggestEditsPageHeaderView.m21590b();
        SuggestEditsHeaderModel c2 = suggestEditsHeaderHolder.m21511c();
        if (c2.m2758a() == null || !c2.m2758a().m2600a()) {
            z = false;
        } else {
            z = true;
        }
        suggestEditsPageHeaderView.setPageNameEditable(z);
        suggestEditsPageHeaderView.setPhoto(ExtractValuesHelper.m21536d(suggestEditsHeaderHolder.m21511c()));
        if (Strings.isNullOrEmpty(ExtractValuesHelper.m21536d(suggestEditsHeaderHolder.f17669e.f17673c))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        suggestEditsPageHeaderView.setPhotoGradientVisibility(i);
        c2 = suggestEditsHeaderHolder.m21511c();
        if (c2.m2763b() == null || !c2.m2763b().m2600a()) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = z;
        suggestEditsPageHeaderView.setPhotoEditable(z2);
        if (z2) {
            suggestEditsPageHeaderView.setCameraButtonOnClickListener(new C14761(this.f17811e, fragment, suggestEditsHeaderHolder, suggestEditsFieldChangedListener));
        }
        suggestEditsPageHeaderView.m21589a(new OnFocusChangeListener(this) {
            final /* synthetic */ SuggestEditsPageHeaderViewController f17803d;

            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    SuggestEditsPageHeaderViewController.m21643a(suggestEditsPageHeaderView, suggestEditsHeaderHolder, suggestEditsFieldChangedListener);
                }
            }
        });
        if (suggestEditsHeaderHolder.f17669e.f17671a) {
            suggestEditsPageHeaderView.m21588a(new TextWatcher(this) {
                final /* synthetic */ SuggestEditsPageHeaderViewController f17806c;

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    suggestEditsController.m21473a();
                    suggestEditsPageHeaderView.m21586a();
                }

                public void afterTextChanged(Editable editable) {
                }
            });
        }
    }

    public static SuggestEditsHeaderHolder m21643a(SuggestEditsPageHeaderView suggestEditsPageHeaderView, SuggestEditsHeaderHolder suggestEditsHeaderHolder, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        if (!suggestEditsPageHeaderView.getPageName().equals(ExtractValuesHelper.m21534c(suggestEditsHeaderHolder.m21511c()))) {
            suggestEditsFieldChangedListener.mo1369a(SuggestEditsFieldMutator.m21504a(suggestEditsHeaderHolder.m21511c(), suggestEditsPageHeaderView.getPageName()));
        }
        return suggestEditsHeaderHolder;
    }
}
