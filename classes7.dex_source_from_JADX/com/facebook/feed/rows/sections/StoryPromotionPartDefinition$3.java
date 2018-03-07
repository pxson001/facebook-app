package com.facebook.feed.rows.sections;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.BoostedComponentModule;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.Event;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.config.application.Product;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.graphql.model.GraphQLAYMTNativeMobileAction;
import com.facebook.graphql.model.GraphQLBoostedComponentMessage;
import com.facebook.graphql.model.GraphQLError;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: \s+ */
public class StoryPromotionPartDefinition$3 implements OnClickListener {
    final /* synthetic */ StoryPromotionPartDefinition$State f20416a;
    final /* synthetic */ GraphQLBoostedComponentMessage f20417b;
    final /* synthetic */ GraphQLAYMTNativeMobileAction f20418c;
    final /* synthetic */ StoryPromotionPartDefinition f20419d;

    public StoryPromotionPartDefinition$3(StoryPromotionPartDefinition storyPromotionPartDefinition, StoryPromotionPartDefinition$State storyPromotionPartDefinition$State, GraphQLBoostedComponentMessage graphQLBoostedComponentMessage, GraphQLAYMTNativeMobileAction graphQLAYMTNativeMobileAction) {
        this.f20419d = storyPromotionPartDefinition;
        this.f20416a = storyPromotionPartDefinition$State;
        this.f20417b = graphQLBoostedComponentMessage;
        this.f20418c = graphQLAYMTNativeMobileAction;
    }

    public void onClick(final View view) {
        Object a;
        int a2 = Logger.a(2, EntryType.UI_INPUT_START, -628863836);
        final BoostedComponentModule boostedComponentModule = StoryPromotionPartDefinition.e(this.f20419d, this.f20416a.f20434h) ? BoostedComponentModule.BOOSTED_EVENT_MOBILE_MODULE : BoostedComponentModule.BOOSTED_POST_MOBILE_MODULE;
        StoryPromotionPartDefinition storyPromotionPartDefinition = this.f20419d;
        StoryPromotionPartDefinition$State storyPromotionPartDefinition$State = this.f20416a;
        Object obj = null;
        GraphQLStory graphQLStory = storyPromotionPartDefinition$State.f20434h;
        Map hashMap = new HashMap();
        hashMap.put("post_id", graphQLStory.ai());
        hashMap.put("page_id", StoryActorHelper.b(graphQLStory) != null ? StoryActorHelper.b(graphQLStory).H() : null);
        hashMap.put("placement", storyPromotionPartDefinition$State.f20428b);
        if (FeedStoryUtil.d(storyPromotionPartDefinition$State.f20434h) != null) {
            a = FeedStoryUtil.d(storyPromotionPartDefinition$State.f20434h).a();
        } else {
            a = null;
        }
        hashMap.put("ineligible_reason", a);
        if (storyPromotionPartDefinition$State.f20434h.an() != null) {
            GraphQLBoostedComponentMessage n = storyPromotionPartDefinition$State.f20434h.an().n();
            GraphQLError j = n != null ? n.j() : null;
            if (j != null) {
                hashMap.put("error_code", String.valueOf(j.a()));
                hashMap.put("error_type", j.k());
                hashMap.put("error_description", j.j());
                if (n.a() != null) {
                    obj = n.a().k();
                }
                hashMap.put("link", obj);
            }
        }
        hashMap.put("flow", "ineligible");
        final Map map = hashMap;
        this.f20419d.g.a(boostedComponentModule, Event.EVENT_CREATE_DIALOG_OPEN, map, this.f20419d.i);
        new FbAlertDialogBuilder(view.getContext()).a(this.f20417b.n().a()).b(this.f20417b.m().a()).a(this.f20418c.j().a(), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ StoryPromotionPartDefinition$3 f20415d;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f20415d.f20419d.g.a(boostedComponentModule, Event.EVENT_CLIENT_INELIGIBLE_FLOW_ACTION_CLICK, map, this.f20415d.f20419d.i);
                StoryPromotionPartDefinition storyPromotionPartDefinition = this.f20415d.f20419d;
                Context context = view.getContext();
                String k = this.f20415d.f20418c.k();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(268435456);
                intent.putExtra("force_in_app_browser", true);
                intent.putExtra("should_hide_menu", true);
                if (storyPromotionPartDefinition.j.j == Product.PAA) {
                    intent.setData(Uri.parse(k));
                    storyPromotionPartDefinition.e.b(intent, context);
                } else if (storyPromotionPartDefinition.j.j == Product.FB4A) {
                    intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(k))));
                    storyPromotionPartDefinition.e.a(intent, context);
                }
            }
        }).b(2131234069, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ StoryPromotionPartDefinition$3 f20411c;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f20411c.f20419d.g.a(boostedComponentModule, Event.EVENT_CLIENT_INELIGIBLE_FLOW_CANCEL, map, this.f20411c.f20419d.i);
            }
        }).a().show();
        LogUtils.a(2108277190, a2);
    }
}
