package com.facebook.groups.gysc.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.analytics.GroupsAnalyticsLogger;
import com.facebook.groups.gysc.model.Enums.Location;
import com.facebook.groups.gysc.model.SuggestionUnitsRowModel;
import com.facebook.groups.gysc.protocol.FetchGroupsGyscModels.FetchGroupCreationSuggestionsModel.GroupsYouShouldCreateModel.NodesModel;
import com.facebook.groups.gysc.protocol.FetchGroupsGyscModels.FetchGroupCreationSuggestionsModel.GroupsYouShouldCreateModel.NodesModel.SuggestedMembersModel;
import com.facebook.groups.widget.actionbuttonwithdivider.HscrollActionButtonWithVerticalDivider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: payment_transfer */
public class GYSCCardView extends CustomLinearLayout {
    @Inject
    public FbUriIntentHandler f6970a;
    @Inject
    public GroupsAnalyticsLogger f6971b;
    @Inject
    public Resources f6972c;
    public FacepileView f6973d = ((FacepileView) findViewById(2131562743));
    public FbTextView f6974e = ((FbTextView) findViewById(2131562746));
    public FbTextView f6975f = ((FbTextView) findViewById(2131562747));
    public HscrollActionButtonWithVerticalDivider f6976g = ((HscrollActionButtonWithVerticalDivider) findViewById(2131562748));
    public Location f6977h;

    public static void m7298a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GYSCCardView gYSCCardView = (GYSCCardView) obj;
        FbUriIntentHandler a = FbUriIntentHandler.a(fbInjector);
        GroupsAnalyticsLogger a2 = GroupsAnalyticsLogger.a(fbInjector);
        Resources a3 = ResourcesMethodAutoProvider.a(fbInjector);
        gYSCCardView.f6970a = a;
        gYSCCardView.f6971b = a2;
        gYSCCardView.f6972c = a3;
    }

    public GYSCCardView(Context context) {
        super(context);
        Class cls = GYSCCardView.class;
        m7298a((Object) this, getContext());
        setContentView(2130904700);
        setOrientation(1);
        setMinimumWidth(context.getResources().getDimensionPixelOffset(2131433298));
        this.f6976g.setDividerColor(this.f6972c.getColor(2131361862));
        this.f6976g.setDividerThicknessPx(this.f6972c.getDimensionPixelSize(2131427379));
        this.f6976g.setDividerMarginPx(this.f6972c.getDimensionPixelSize(2131430270));
    }

    public final void m7299a(SuggestionUnitsRowModel suggestionUnitsRowModel, Location location) {
        this.f6977h = location;
        if (suggestionUnitsRowModel != null && suggestionUnitsRowModel.f6946b != null) {
            NodesModel c = suggestionUnitsRowModel.m7225c();
            this.f6974e.setText(c.m7260a());
            List arrayList = new ArrayList();
            if (c.m7262k() == null || c.m7262k().isEmpty()) {
                this.f6975f.setVisibility(8);
            } else {
                int size = c.m7262k().size();
                StringBuffer stringBuffer = new StringBuffer(((SuggestedMembersModel) c.m7262k().get(0)).m7244k());
                if (size > 1) {
                    stringBuffer.append(" + ").append(getResources().getQuantityString(2131689754, size - 1, new Object[]{Integer.valueOf(size - 1)}));
                }
                this.f6975f.setText(stringBuffer.toString());
                this.f6975f.setVisibility(0);
                for (size = 0; size < c.m7262k().size(); size++) {
                    arrayList.add(((SuggestedMembersModel) c.m7262k().get(size)).m7243j());
                }
            }
            if (suggestionUnitsRowModel.m7224b()) {
                this.f6976g.setImageDrawable(getResources().getDrawable(2130840679));
                this.f6976g.setOnClickListener(null);
                this.f6974e.setOnClickListener(null);
                this.f6975f.setOnClickListener(null);
            } else {
                OnClickListener a = m7295a(StringUtil.b(",", new Object[]{arrayList}), m7297a(c.m7261j()), c.m7264m().name(), c.m7263l());
                this.f6976g.setOnClickListener(a);
                this.f6974e.setOnClickListener(a);
                if (this.f6975f.getVisibility() == 0) {
                    this.f6975f.setOnClickListener(a);
                }
            }
            this.f6973d.setFaceCountForOverflow(c.m7262k().size());
            this.f6973d.setFaceStrings(m7296a(suggestionUnitsRowModel));
        }
    }

    private OnClickListener m7295a(String str, String str2, String str3, String str4) {
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        return new OnClickListener(this) {
            final /* synthetic */ GYSCCardView f6969e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -864054084);
                Bundle bundle = new Bundle();
                bundle.putString("group_name", this.f6969e.f6974e.getText().toString());
                bundle.putString("group_members", str5);
                bundle.putString("group_visibility", str6);
                bundle.putString("ref", GYSCCardView.getSourceReference(this.f6969e));
                bundle.putString("suggestion_category", str7);
                bundle.putString("suggestion_identifier", str8);
                GYSCCardView gYSCCardView = this.f6969e;
                gYSCCardView.f6970a.a(view.getContext(), FBLinks.D, bundle);
                if (this.f6969e.f6977h == Location.ME_TAB) {
                    this.f6969e.f6971b.b("metab_tapped_gysc_create_group");
                }
                this.f6969e.f6971b.a(str7, str8, GYSCCardView.getSourceReference(this.f6969e));
                Logger.a(2, EntryType.UI_INPUT_END, 1792893733, a);
            }
        };
    }

    public static String getSourceReference(GYSCCardView gYSCCardView) {
        return gYSCCardView.f6977h == Location.ME_TAB ? "gysc_tab" : "gysc_creation_tab";
    }

    private static String m7297a(GraphQLGroupVisibility graphQLGroupVisibility) {
        if (GraphQLGroupVisibility.OPEN.equals(graphQLGroupVisibility)) {
            return "Open";
        }
        if (GraphQLGroupVisibility.CLOSED.equals(graphQLGroupVisibility)) {
            return "Closed";
        }
        if (GraphQLGroupVisibility.SECRET.equals(graphQLGroupVisibility)) {
            return "Secret";
        }
        return null;
    }

    private static ImmutableList<String> m7296a(SuggestionUnitsRowModel suggestionUnitsRowModel) {
        NodesModel nodesModel = suggestionUnitsRowModel.f6946b;
        if (nodesModel == null) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList k = nodesModel.m7262k();
        int size = k.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            SuggestedMembersModel suggestedMembersModel = (SuggestedMembersModel) k.get(i);
            if (suggestedMembersModel == null || suggestedMembersModel.m7245l() == null || suggestedMembersModel.m7245l().m7236a() == null) {
                i3 = i2;
            } else {
                builder.c(suggestedMembersModel.m7245l().m7236a());
                i3 = i2 + 1;
            }
            if (i3 >= 5) {
                break;
            }
            i++;
            i2 = i3;
        }
        return builder.b();
    }
}
