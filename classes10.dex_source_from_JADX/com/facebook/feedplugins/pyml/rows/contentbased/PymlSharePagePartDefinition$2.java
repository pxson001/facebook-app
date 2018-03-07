package com.facebook.feedplugins.pyml.rows.contentbased;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: android.intent.action.ACTION_POWER_DISCONNECTED */
public class PymlSharePagePartDefinition$2 implements OnClickListener {
    final /* synthetic */ SuggestedPageUnitItem f19882a;
    final /* synthetic */ PymlSharePagePartDefinition f19883b;

    public PymlSharePagePartDefinition$2(PymlSharePagePartDefinition pymlSharePagePartDefinition, SuggestedPageUnitItem suggestedPageUnitItem) {
        this.f19883b = pymlSharePagePartDefinition;
        this.f19882a = suggestedPageUnitItem;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1220419411);
        this.f19883b.e.a(view, LinkifyTargetBuilder.a(this.f19882a.m()), null);
        Logger.a(2, EntryType.UI_INPUT_END, 317842367, a);
    }
}
