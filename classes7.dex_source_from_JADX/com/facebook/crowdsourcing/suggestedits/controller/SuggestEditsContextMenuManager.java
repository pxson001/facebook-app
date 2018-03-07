package com.facebook.crowdsourcing.suggestedits.controller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsFieldModel.OptionsModel.EdgesModel;
import com.facebook.crowdsourcing.suggestedits.helper.ExtractValuesHelper;
import com.facebook.crowdsourcing.suggestedits.helper.SuggestEditsSupportedFieldOptions;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.view.controller.SuggestEditsMultiTextFieldViewController.C14921;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.popovermenuitemwithuriicon.PopoverMenuItemWithUriIcon;
import com.facebook.widget.popovermenuitemwithuriicon.PopoverMenuItemWithUriIconProvider;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: com.apple.iTunes */
public class SuggestEditsContextMenuManager {
    private PopoverMenuItemWithUriIconProvider f17600a;

    public static SuggestEditsContextMenuManager m21459b(InjectorLike injectorLike) {
        return new SuggestEditsContextMenuManager((PopoverMenuItemWithUriIconProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PopoverMenuItemWithUriIconProvider.class));
    }

    @Inject
    public SuggestEditsContextMenuManager(PopoverMenuItemWithUriIconProvider popoverMenuItemWithUriIconProvider) {
        this.f17600a = popoverMenuItemWithUriIconProvider;
    }

    public final OnClickListener m21460a(final View view, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, @Nullable C14921 c14921) {
        final Optional a = m21457a(view.getContext(), suggestEditsField, suggestEditsFieldChangedListener, c14921);
        if (a.isPresent()) {
            view.setVisibility(0);
            return new OnClickListener(this) {
                final /* synthetic */ SuggestEditsContextMenuManager f17594c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 319699795);
                    ((PopoverMenuWindow) a.get()).f(view);
                    Logger.a(2, EntryType.UI_INPUT_END, -1330268130, a);
                }
            };
        }
        view.setVisibility(8);
        return null;
    }

    private Optional<PopoverMenuWindow> m21457a(Context context, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, @Nullable SuggestEditsContextOptionClickListener suggestEditsContextOptionClickListener) {
        if (suggestEditsField.ey_() == null || suggestEditsField.ey_().m2739a().isEmpty()) {
            Absent.withType();
        }
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(context);
        PopoverMenu c = figPopoverMenuWindow.c();
        ImmutableList a = suggestEditsField.ey_().m2739a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            if (edgesModel.m2733a() != null && SuggestEditsSupportedFieldOptions.m21552a(edgesModel.m2733a().m2840g())) {
                boolean equals = GraphQLSuggestEditsFieldOptionType.ADD_VALUE.equals(edgesModel.m2733a().m2840g());
                boolean z = suggestEditsField.ew_() != null && suggestEditsField.ew_().equals(edgesModel.m2733a().m2840g());
                String a2 = ExtractValuesHelper.m21531a(edgesModel.m2733a(), z);
                if (!equals || !suggestEditsField.ew_().equals(GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE)) {
                    m21458a(c, edgesModel.m2733a().ez_(), a2, suggestEditsField, z, suggestEditsContextOptionClickListener, edgesModel.m2733a().m2840g(), suggestEditsFieldChangedListener);
                }
            }
        }
        return c.getCount() > 0 ? Optional.of(figPopoverMenuWindow) : Absent.withType();
    }

    private void m21458a(PopoverMenu popoverMenu, String str, String str2, SuggestEditsField suggestEditsField, boolean z, @Nullable C14921 c14921, GraphQLSuggestEditsFieldOptionType graphQLSuggestEditsFieldOptionType, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        PopoverMenuItemWithUriIcon a = this.f17600a.a(popoverMenu, str);
        boolean z2 = c14921 == null || c14921.m21623b(graphQLSuggestEditsFieldOptionType);
        a.setCheckable(z2);
        a.setChecked(z);
        final C14921 c149212 = c14921;
        final GraphQLSuggestEditsFieldOptionType graphQLSuggestEditsFieldOptionType2 = graphQLSuggestEditsFieldOptionType;
        final SuggestEditsField suggestEditsField2 = suggestEditsField;
        final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener2 = suggestEditsFieldChangedListener;
        a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ SuggestEditsContextMenuManager f17599e;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onMenuItemClick(android.view.MenuItem r8) {
                /*
                r7 = this;
                r2 = 1;
                r0 = r2;
                if (r0 == 0) goto L_0x0021;
            L_0x0005:
                r0 = r2;
                r1 = r3;
                r3 = com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType.ADD_VALUE;
                r3 = r3.equals(r1);
                if (r3 == 0) goto L_0x002f;
            L_0x0011:
                r3 = r0.f17766d;
                r4 = r0.f17763a;
                r5 = r0.f17764b;
                r6 = r0.f17765c;
                com.facebook.crowdsourcing.suggestedits.view.controller.SuggestEditsMultiTextFieldViewController.m21628b(r3, r4, r5, r6);
                r3 = 1;
            L_0x001d:
                r0 = r3;
                if (r0 == 0) goto L_0x0021;
            L_0x0020:
                return r2;
            L_0x0021:
                r0 = r4;
                r1 = r3;
                r0 = com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldMutator.m21495a(r0, r1);
                r1 = r5;
                r1.mo1369a(r0);
                goto L_0x0020;
            L_0x002f:
                r3 = 0;
                goto L_0x001d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsContextMenuManager.2.onMenuItemClick(android.view.MenuItem):boolean");
            }
        });
        a.a(str2);
        popoverMenu.a(a);
    }
}
