package com.facebook.crowdsourcing.suggestedits.view.controller;

import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.crowdsourcing.enums.SuggestEditsInputStyle;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.picker.SuggestEditsPickerLauncher;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel.NodeModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsOptionModel;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsContextMenuManager;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldMutator;
import com.facebook.crowdsourcing.suggestedits.helper.ExtractValuesHelper;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.view.SuggestEditsLocationView;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ci/ */
public class SuggestEditsLocationViewController implements SuggestEditsViewController<SuggestEditsLocationView, SuggestEditsField> {
    private final SuggestEditsContextMenuManager f17760a;
    private final AbstractFbErrorReporter f17761b;
    public final SuggestEditsPickerLauncher f17762c;

    public final /* bridge */ /* synthetic */ void mo1373a(View view, Object obj, @Nullable Object obj2, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, @Nullable Fragment fragment, String str) {
        m21618a((SuggestEditsLocationView) view, (SuggestEditsField) obj, suggestEditsFieldChangedListener, suggestEditsController, suggestEditsInputType, fragment);
    }

    @Inject
    public SuggestEditsLocationViewController(AbstractFbErrorReporter abstractFbErrorReporter, SuggestEditsContextMenuManager suggestEditsContextMenuManager, SuggestEditsPickerLauncher suggestEditsPickerLauncher) {
        this.f17760a = suggestEditsContextMenuManager;
        this.f17761b = abstractFbErrorReporter;
        this.f17762c = suggestEditsPickerLauncher;
    }

    public final SuggestEditsListViewType mo1371a() {
        return SuggestEditsListViewType.LOCATION;
    }

    public final View mo1370a(ViewGroup viewGroup) {
        return (SuggestEditsLocationView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907304, viewGroup, false);
    }

    private void m21618a(final SuggestEditsLocationView suggestEditsLocationView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, final SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment) {
        suggestEditsLocationView.m21565a();
        suggestEditsLocationView.setCityHintText(suggestEditsField.mo107b());
        suggestEditsLocationView.setStreetAddressHintText(suggestEditsField.ex_());
        suggestEditsLocationView.setZipHintText(suggestEditsField.mo114j());
        NodeModel f = ExtractValuesHelper.m21538f(suggestEditsField);
        if (f != null) {
            suggestEditsLocationView.setCity(f.m2571c() == null ? null : f.m2571c().m2533d());
            suggestEditsLocationView.setZip(f.m2580p());
            suggestEditsLocationView.setMapLocation(ExtractValuesHelper.m21540h(suggestEditsField));
        }
        suggestEditsLocationView.setIcon(ExtractValuesHelper.m21530a(suggestEditsField));
        OnClickListener a = this.f17760a.m21460a(suggestEditsLocationView.getActionButtonView(), suggestEditsField, suggestEditsFieldChangedListener, null);
        suggestEditsLocationView.setActionButtonOnClickListener(a);
        m21616a(suggestEditsLocationView, suggestEditsField, f, a);
        suggestEditsLocationView.setTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SuggestEditsLocationViewController f17750c;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                suggestEditsController.m21473a();
                suggestEditsLocationView.setTextChangedListener(null);
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        m21617a(suggestEditsLocationView, suggestEditsField, suggestEditsFieldChangedListener, suggestEditsInputType, fragment);
    }

    public static SuggestEditsField m21615a(SuggestEditsLocationView suggestEditsLocationView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        NodeModel f = ExtractValuesHelper.m21538f(suggestEditsField);
        if (f != null && suggestEditsLocationView.getStreetAddress().equals(f.m2574j()) && suggestEditsLocationView.getZip().equals(f.m2580p())) {
            return suggestEditsField;
        }
        suggestEditsField = SuggestEditsFieldMutator.m21499a(suggestEditsField, suggestEditsLocationView.getStreetAddress(), suggestEditsLocationView.getZip());
        suggestEditsFieldChangedListener.mo1369a(suggestEditsField);
        return suggestEditsField;
    }

    private void m21617a(final SuggestEditsLocationView suggestEditsLocationView, final SuggestEditsField suggestEditsField, final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsInputType suggestEditsInputType, Fragment fragment) {
        if (suggestEditsInputType == null || suggestEditsInputType.getInputStyle() != SuggestEditsInputStyle.LOCATION) {
            this.f17761b.a("SuggestEdits", "Input style not supported by field");
            return;
        }
        final SuggestEditsLocationView suggestEditsLocationView2 = suggestEditsLocationView;
        final SuggestEditsField suggestEditsField2 = suggestEditsField;
        final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener2 = suggestEditsFieldChangedListener;
        final Fragment fragment2 = fragment;
        suggestEditsLocationView.setCityOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SuggestEditsLocationViewController f17755e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1568443062);
                this.f17755e.f17762c.m21362a(SuggestEditsLocationViewController.m21615a(suggestEditsLocationView2, suggestEditsField2, suggestEditsFieldChangedListener2), SuggestEditsInputType.CITY_PICKER, suggestEditsFieldChangedListener2, fragment2);
                Logger.a(2, EntryType.UI_INPUT_END, -837039206, a);
            }
        });
        suggestEditsLocationView.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ SuggestEditsLocationViewController f17759d;

            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    SuggestEditsLocationViewController.m21615a(suggestEditsLocationView, suggestEditsField, suggestEditsFieldChangedListener);
                }
            }
        });
    }

    private static void m21616a(SuggestEditsLocationView suggestEditsLocationView, SuggestEditsField suggestEditsField, NodeModel nodeModel, OnClickListener onClickListener) {
        if (suggestEditsField.ew_() == GraphQLSuggestEditsFieldOptionType.HAS_VALUE) {
            String str;
            if ("<<not-applicable>>".equals(nodeModel.m2574j())) {
                str = null;
            } else {
                str = nodeModel.m2574j();
            }
            suggestEditsLocationView.setStreetAddress(str);
        } else if (suggestEditsField.ew_() == GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE) {
            SuggestEditsOptionModel i = ExtractValuesHelper.m21541i(suggestEditsField);
            suggestEditsLocationView.setStreetAddressHintText(i == null ? "" : i.m2837b());
            suggestEditsLocationView.setStreetAddress(null);
            suggestEditsLocationView.setStreetAddressFieldFocusable(false);
            suggestEditsLocationView.setStreetAddressOnClickListener(onClickListener);
        }
    }
}
