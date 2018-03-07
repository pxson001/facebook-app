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
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel.NodeModel.Builder;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsContextMenuManager;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldMutator;
import com.facebook.crowdsourcing.suggestedits.helper.ExtractValuesHelper;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.view.SuggestEditsTextFieldView;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: check_in */
public class SuggestEditsTextFieldViewController implements SuggestEditsViewController<SuggestEditsTextFieldView, SuggestEditsField> {
    private static final String f17826a = SuggestEditsTextFieldViewController.class.getSimpleName();
    private final SuggestEditsContextMenuManager f17827b;
    private final AbstractFbErrorReporter f17828c;
    public final SuggestEditsPickerLauncher f17829d;

    /* compiled from: check_in */
    /* synthetic */ class C15064 {
        static final /* synthetic */ int[] f17824a = new int[GraphQLSuggestEditsFieldOptionType.values().length];

        static {
            f17825b = new int[SuggestEditsInputStyle.values().length];
            try {
                f17825b[SuggestEditsInputStyle.INLINE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17825b[SuggestEditsInputStyle.PICKER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17824a[GraphQLSuggestEditsFieldOptionType.HAS_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17824a[GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final /* bridge */ /* synthetic */ void mo1373a(View view, Object obj, @Nullable Object obj2, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment, String str) {
        m21656a((SuggestEditsTextFieldView) view, (SuggestEditsField) obj, suggestEditsFieldChangedListener, suggestEditsController, suggestEditsInputType, fragment);
    }

    @Inject
    public SuggestEditsTextFieldViewController(SuggestEditsPickerLauncher suggestEditsPickerLauncher, AbstractFbErrorReporter abstractFbErrorReporter, SuggestEditsContextMenuManager suggestEditsContextMenuManager) {
        this.f17829d = suggestEditsPickerLauncher;
        this.f17828c = abstractFbErrorReporter;
        this.f17827b = suggestEditsContextMenuManager;
    }

    public final SuggestEditsListViewType mo1371a() {
        return SuggestEditsListViewType.TEXT_FIELD;
    }

    public final View mo1370a(ViewGroup viewGroup) {
        return (SuggestEditsTextFieldView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907311, viewGroup, false);
    }

    private void m21656a(SuggestEditsTextFieldView suggestEditsTextFieldView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment) {
        suggestEditsTextFieldView.m21592a();
        OnClickListener a = this.f17827b.m21460a(suggestEditsTextFieldView.f17730c, suggestEditsField, suggestEditsFieldChangedListener, null);
        suggestEditsTextFieldView.setActionButtonOnClickListener(a);
        switch (C15064.f17824a[suggestEditsField.ew_().ordinal()]) {
            case 1:
                m21657b(suggestEditsTextFieldView, suggestEditsField, suggestEditsFieldChangedListener, suggestEditsController, suggestEditsInputType, fragment);
                return;
            case 2:
                suggestEditsTextFieldView.setFieldText(ExtractValuesHelper.m21541i(suggestEditsField).m2837b());
                suggestEditsTextFieldView.setIcon(ExtractValuesHelper.m21530a(suggestEditsField));
                suggestEditsTextFieldView.setFieldOnClickListener(a);
                return;
            default:
                this.f17828c.a(f17826a, "Trying to bind view with unsupported option selected: " + suggestEditsField.ew_());
                return;
        }
    }

    public static SuggestEditsField m21654a(SuggestEditsTextFieldView suggestEditsTextFieldView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        if (suggestEditsTextFieldView.getText().equals(ExtractValuesHelper.m21535d(suggestEditsField))) {
            return suggestEditsField;
        }
        String text = suggestEditsTextFieldView.getText();
        NodeModel a = NodeModel.m2566a(ExtractValuesHelper.m21538f(suggestEditsField));
        if (a == null) {
            a = new Builder().m2563a();
        }
        suggestEditsField = SuggestEditsFieldMutator.m21493a(suggestEditsField, SuggestEditsFieldMutator.m21501a(a, text));
        suggestEditsFieldChangedListener.mo1369a(suggestEditsField);
        return suggestEditsField;
    }

    private void m21657b(final SuggestEditsTextFieldView suggestEditsTextFieldView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, final SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, @Nullable Fragment fragment) {
        suggestEditsTextFieldView.setFieldHintText(suggestEditsField.mo113g());
        suggestEditsTextFieldView.setFieldText(ExtractValuesHelper.m21535d(suggestEditsField));
        suggestEditsTextFieldView.setIcon(ExtractValuesHelper.m21530a(suggestEditsField));
        suggestEditsTextFieldView.setTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SuggestEditsTextFieldViewController f17814c;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                suggestEditsController.m21473a();
                suggestEditsTextFieldView.setTextChangedListener(null);
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        if (suggestEditsInputType != null) {
            m21655a(suggestEditsTextFieldView, suggestEditsField, suggestEditsFieldChangedListener, suggestEditsInputType, fragment);
        }
    }

    private void m21655a(final SuggestEditsTextFieldView suggestEditsTextFieldView, final SuggestEditsField suggestEditsField, final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsInputType suggestEditsInputType, Fragment fragment) {
        switch (suggestEditsInputType.getInputStyle()) {
            case INLINE:
                suggestEditsTextFieldView.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                    final /* synthetic */ SuggestEditsTextFieldViewController f17818d;

                    public void onFocusChange(View view, boolean z) {
                        if (!z) {
                            SuggestEditsTextFieldViewController.m21654a(suggestEditsTextFieldView, suggestEditsField, suggestEditsFieldChangedListener);
                        }
                    }
                });
                return;
            case PICKER:
                final SuggestEditsField suggestEditsField2 = suggestEditsField;
                final SuggestEditsInputType suggestEditsInputType2 = suggestEditsInputType;
                final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener2 = suggestEditsFieldChangedListener;
                final Fragment fragment2 = fragment;
                suggestEditsTextFieldView.setFieldOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SuggestEditsTextFieldViewController f17823e;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -986095779);
                        this.f17823e.f17829d.m21362a(suggestEditsField2, suggestEditsInputType2, suggestEditsFieldChangedListener2, fragment2);
                        Logger.a(2, EntryType.UI_INPUT_END, 489278591, a);
                    }
                });
                return;
            default:
                this.f17828c.a(f17826a, "Input style not supported by field");
                return;
        }
    }
}
