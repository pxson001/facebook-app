package com.facebook.crowdsourcing.suggestedits.view.controller;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.crowdsourcing.enums.SuggestEditsInputStyle;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.picker.SuggestEditsPickerLauncher;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedField.UserValues.Edges;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldMutator;
import com.facebook.crowdsourcing.suggestedits.helper.ExtractValuesHelper;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.view.SuggestEditsMultiValueView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: chevron */
public class SuggestEditsMultiValueViewController implements SuggestEditsViewController<SuggestEditsMultiValueView, SuggestEditsField> {
    private final AbstractFbErrorReporter f17795a;
    public final SuggestEditsPickerLauncher f17796b;

    public final Object mo1372a(View view, Object obj, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        return (SuggestEditsField) obj;
    }

    public final /* bridge */ /* synthetic */ void mo1373a(View view, Object obj, @Nullable Object obj2, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment, String str) {
        m21636a((SuggestEditsMultiValueView) view, (SuggestEditsField) obj, (SuggestEditsField) obj2, suggestEditsFieldChangedListener, suggestEditsInputType, fragment);
    }

    @Inject
    public SuggestEditsMultiValueViewController(AbstractFbErrorReporter abstractFbErrorReporter, SuggestEditsPickerLauncher suggestEditsPickerLauncher) {
        this.f17795a = abstractFbErrorReporter;
        this.f17796b = suggestEditsPickerLauncher;
    }

    public final SuggestEditsListViewType mo1371a() {
        return SuggestEditsListViewType.MULTI_VALUE_FIELD;
    }

    public final View mo1370a(ViewGroup viewGroup) {
        return (SuggestEditsMultiValueView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907307, viewGroup, false);
    }

    private void m21636a(SuggestEditsMultiValueView suggestEditsMultiValueView, SuggestEditsField suggestEditsField, @Nullable SuggestEditsField suggestEditsField2, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment) {
        suggestEditsMultiValueView.m21574a();
        ImmutableList of = suggestEditsField2 == null ? ImmutableList.of() : ExtractValuesHelper.m21539g(suggestEditsField2);
        ImmutableList g = ExtractValuesHelper.m21539g(suggestEditsField);
        int i = 0;
        int size = of.size();
        int i2 = 0;
        while (i2 < size) {
            int i3;
            EdgesModel edgesModel = (EdgesModel) of.get(i2);
            if (m21638a(edgesModel)) {
                Optional a = m21635a(g, edgesModel);
                if (a.isPresent()) {
                    suggestEditsMultiValueView.m21575a(edgesModel.m2588a().m2570b().m2548b(), ExtractValuesHelper.m21530a(suggestEditsField), m21634a(suggestEditsField, ((Integer) a.get()).intValue(), suggestEditsFieldChangedListener));
                    i3 = i + 1;
                    i2++;
                    i = i3;
                } else {
                    suggestEditsMultiValueView.m21576b(edgesModel.m2588a().m2570b().m2548b(), ExtractValuesHelper.m21530a(suggestEditsField), m21633a(suggestEditsField, i, edgesModel, suggestEditsFieldChangedListener));
                }
            }
            i3 = i;
            i2++;
            i = i3;
        }
        for (i = 0; i < g.size(); i++) {
            edgesModel = (EdgesModel) g.get(i);
            Optional a2 = m21635a(of, edgesModel);
            if (m21638a(edgesModel) && !a2.isPresent()) {
                suggestEditsMultiValueView.m21575a(edgesModel.m2588a().m2570b().m2548b(), ExtractValuesHelper.m21530a(suggestEditsField), m21634a(suggestEditsField, i, suggestEditsFieldChangedListener));
            }
        }
        suggestEditsMultiValueView.setAddText(suggestEditsField.mo106a());
        if (suggestEditsInputType != null) {
            m21637a(suggestEditsMultiValueView, suggestEditsField, suggestEditsFieldChangedListener, suggestEditsInputType, fragment);
        }
    }

    private Optional<Integer> m21635a(ImmutableList<? extends Edges> immutableList, Edges edges) {
        for (int i = 0; i < immutableList.size(); i++) {
            Object obj;
            EdgesModel edgesModel = (EdgesModel) immutableList.get(i);
            if (m21638a(edgesModel) && m21638a((EdgesModel) edges) && edgesModel.m2588a().m2570b().m2547a().equals(edges.m2588a().m2570b().m2547a())) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return Optional.of(Integer.valueOf(i));
            }
        }
        return Absent.INSTANCE;
    }

    private void m21637a(SuggestEditsMultiValueView suggestEditsMultiValueView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsInputType suggestEditsInputType, Fragment fragment) {
        if (suggestEditsInputType.getInputStyle() != SuggestEditsInputStyle.PICKER) {
            this.f17795a.a("SuggestEdits", "Input style not supported by field");
            return;
        }
        final SuggestEditsField suggestEditsField2 = suggestEditsField;
        final SuggestEditsInputType suggestEditsInputType2 = suggestEditsInputType;
        final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener2 = suggestEditsFieldChangedListener;
        final Fragment fragment2 = fragment;
        suggestEditsMultiValueView.setAddValueListener(new OnClickListener(this) {
            final /* synthetic */ SuggestEditsMultiValueViewController f17785e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1472368160);
                this.f17785e.f17796b.m21362a(suggestEditsField2, suggestEditsInputType2, suggestEditsFieldChangedListener2, fragment2);
                Logger.a(2, EntryType.UI_INPUT_END, 1059829652, a);
            }
        });
    }

    private OnClickListener m21634a(final SuggestEditsField suggestEditsField, final int i, final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        return new OnClickListener(this) {
            final /* synthetic */ SuggestEditsMultiValueViewController f17789d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1774050935);
                suggestEditsFieldChangedListener.mo1369a(SuggestEditsFieldMutator.m21491a(suggestEditsField, i));
                Logger.a(2, EntryType.UI_INPUT_END, -1167639482, a);
            }
        };
    }

    private OnClickListener m21633a(SuggestEditsField suggestEditsField, int i, EdgesModel edgesModel, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener2 = suggestEditsFieldChangedListener;
        final SuggestEditsField suggestEditsField2 = suggestEditsField;
        final int i2 = i;
        final EdgesModel edgesModel2 = edgesModel;
        return new OnClickListener(this) {
            final /* synthetic */ SuggestEditsMultiValueViewController f17794e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1076501260);
                suggestEditsFieldChangedListener2.mo1369a(SuggestEditsFieldMutator.m21492a(suggestEditsField2, i2, edgesModel2));
                Logger.a(2, EntryType.UI_INPUT_END, -462107838, a);
            }
        };
    }

    public static boolean m21638a(EdgesModel edgesModel) {
        return (edgesModel.m2588a() == null || edgesModel.m2588a().m2570b() == null || Strings.isNullOrEmpty(edgesModel.m2588a().m2570b().m2547a()) || Strings.isNullOrEmpty(edgesModel.m2588a().m2570b().m2548b())) ? false : true;
    }
}
