package com.facebook.crowdsourcing.suggestedits.view.controller;

import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.internal.Preconditions;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsOptionModel;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsContextMenuManager;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldMutator;
import com.facebook.crowdsourcing.suggestedits.helper.ExtractValuesHelper;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.view.SuggestEditsMultiTextFieldView;
import com.facebook.crowdsourcing.suggestedits.view.SuggestEditsMultiTextFieldView.OnFocusChangeListenerWithChildIndex;
import com.facebook.crowdsourcing.suggestedits.view.SuggestEditsTextFieldView;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: childAtomSize should be positive */
public class SuggestEditsMultiTextFieldViewController implements SuggestEditsViewController<SuggestEditsMultiTextFieldView, SuggestEditsField> {
    private static final String f17778a = SuggestEditsMultiTextFieldViewController.class.getSimpleName();
    private final SuggestEditsContextMenuManager f17779b;
    private final AbstractFbErrorReporter f17780c;

    /* compiled from: childAtomSize should be positive */
    /* synthetic */ class C14965 {
        static final /* synthetic */ int[] f17777a = new int[GraphQLSuggestEditsFieldOptionType.values().length];

        static {
            try {
                f17777a[GraphQLSuggestEditsFieldOptionType.HAS_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17777a[GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public final /* bridge */ /* synthetic */ void mo1373a(View view, Object obj, @Nullable Object obj2, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment, String str) {
        m21627a((SuggestEditsMultiTextFieldView) view, (SuggestEditsField) obj, suggestEditsFieldChangedListener, suggestEditsController, suggestEditsInputType);
    }

    @Inject
    public SuggestEditsMultiTextFieldViewController(AbstractFbErrorReporter abstractFbErrorReporter, SuggestEditsContextMenuManager suggestEditsContextMenuManager) {
        this.f17780c = abstractFbErrorReporter;
        this.f17779b = suggestEditsContextMenuManager;
    }

    public final SuggestEditsListViewType mo1371a() {
        return SuggestEditsListViewType.MULTI_TEXT_FIELD;
    }

    public final View mo1370a(ViewGroup viewGroup) {
        return (SuggestEditsMultiTextFieldView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907305, viewGroup, false);
    }

    private void m21627a(final SuggestEditsMultiTextFieldView suggestEditsMultiTextFieldView, final SuggestEditsField suggestEditsField, final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsController suggestEditsController, SuggestEditsInputType suggestEditsInputType) {
        suggestEditsMultiTextFieldView.m21570a();
        OnClickListener a = this.f17779b.m21460a(suggestEditsMultiTextFieldView.f17707a.f17730c, suggestEditsField, suggestEditsFieldChangedListener, new Object(this) {
            public final /* synthetic */ SuggestEditsMultiTextFieldViewController f17766d;

            public final boolean m21623b(GraphQLSuggestEditsFieldOptionType graphQLSuggestEditsFieldOptionType) {
                return !GraphQLSuggestEditsFieldOptionType.ADD_VALUE.equals(graphQLSuggestEditsFieldOptionType);
            }
        });
        switch (C14965.f17777a[suggestEditsField.ew_().ordinal()]) {
            case 1:
                m21626a(suggestEditsMultiTextFieldView, suggestEditsField, suggestEditsFieldChangedListener, suggestEditsController, a);
                break;
            case 2:
                String str;
                SuggestEditsOptionModel i = ExtractValuesHelper.m21541i(suggestEditsField);
                SuggestEditsTextFieldView suggestEditsTextFieldView = suggestEditsMultiTextFieldView.f17707a;
                if (i == null) {
                    str = "";
                } else {
                    str = i.m2837b();
                }
                suggestEditsTextFieldView.setFieldText(str);
                suggestEditsMultiTextFieldView.f17707a.setIcon(ExtractValuesHelper.m21530a(suggestEditsField));
                suggestEditsMultiTextFieldView.f17707a.setFieldOnClickListener(a);
                break;
            default:
                this.f17780c.a(f17778a, "Trying to bind view with unsupported option selected: " + suggestEditsField.ew_());
                return;
        }
        if (suggestEditsInputType != null) {
            suggestEditsMultiTextFieldView.setOnFocusChangeListener(new OnFocusChangeListenerWithChildIndex(this) {
                final /* synthetic */ SuggestEditsMultiTextFieldViewController f17776d;

                public final void mo1374a(View view, boolean z, int i) {
                    if (z) {
                        View childAt = suggestEditsMultiTextFieldView.getChildAt(i);
                        if (childAt instanceof SuggestEditsTextFieldView) {
                            ((SuggestEditsTextFieldView) childAt).f17728a.requestFocus();
                            return;
                        }
                        return;
                    }
                    if ((view instanceof EditText) && Strings.isNullOrEmpty(((EditText) view).getText().toString()) && suggestEditsMultiTextFieldView.getValues().size() > 1) {
                        suggestEditsMultiTextFieldView.removeViewAt(i);
                    }
                    SuggestEditsMultiTextFieldViewController.m21625a(suggestEditsMultiTextFieldView, suggestEditsField, suggestEditsFieldChangedListener);
                }
            });
        }
    }

    public static SuggestEditsField m21625a(SuggestEditsMultiTextFieldView suggestEditsMultiTextFieldView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        if (ExtractValuesHelper.m21542j(suggestEditsField).equals(suggestEditsMultiTextFieldView.getValues())) {
            return suggestEditsField;
        }
        suggestEditsField = SuggestEditsFieldMutator.m21498a(suggestEditsField, suggestEditsMultiTextFieldView.getValues());
        suggestEditsFieldChangedListener.mo1369a(suggestEditsField);
        return suggestEditsField;
    }

    private void m21626a(SuggestEditsMultiTextFieldView suggestEditsMultiTextFieldView, final SuggestEditsField suggestEditsField, final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, final SuggestEditsController suggestEditsController, OnClickListener onClickListener) {
        ImmutableList j = ExtractValuesHelper.m21542j(suggestEditsField);
        SuggestEditsTextFieldView suggestEditsTextFieldView = suggestEditsMultiTextFieldView.f17707a;
        suggestEditsTextFieldView.setFieldText(!j.isEmpty() ? (String) j.get(0) : "");
        suggestEditsTextFieldView.setIcon(ExtractValuesHelper.m21530a(suggestEditsField));
        suggestEditsTextFieldView.setFieldHintText(suggestEditsField.mo113g());
        suggestEditsTextFieldView.setTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SuggestEditsMultiTextFieldViewController f17768b;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                suggestEditsController.m21473a();
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        suggestEditsTextFieldView.setActionButtonOnClickListener(onClickListener);
        for (int i = 1; i < j.size(); i++) {
            String str = (String) j.get(i);
            SuggestEditsTextFieldView a = suggestEditsMultiTextFieldView.m21569a(str, new OnClickListener(this) {
                final /* synthetic */ SuggestEditsMultiTextFieldViewController f17772d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1669239308);
                    suggestEditsFieldChangedListener.mo1369a(SuggestEditsFieldMutator.m21491a(suggestEditsField, i));
                    Logger.a(2, EntryType.UI_INPUT_END, -1064567944, a);
                }
            }, suggestEditsController, ExtractValuesHelper.m21530a(suggestEditsField));
            if (Strings.isNullOrEmpty(str)) {
                a.f17728a.requestFocus();
            }
        }
    }

    public static void m21628b(SuggestEditsMultiTextFieldViewController suggestEditsMultiTextFieldViewController, SuggestEditsMultiTextFieldView suggestEditsMultiTextFieldView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        SuggestEditsTextFieldView suggestEditsTextFieldView = (SuggestEditsTextFieldView) Preconditions.a(suggestEditsMultiTextFieldView.getLastTextFieldView());
        if (suggestEditsTextFieldView.hasFocus()) {
            suggestEditsField = m21625a(suggestEditsMultiTextFieldView, suggestEditsField, suggestEditsFieldChangedListener);
        }
        if (!Strings.isNullOrEmpty(suggestEditsTextFieldView.getText())) {
            suggestEditsFieldChangedListener.mo1369a(SuggestEditsFieldMutator.m21500a("", suggestEditsField));
        }
        suggestEditsMultiTextFieldView.getLastTextFieldView().f17728a.requestFocus();
    }
}
