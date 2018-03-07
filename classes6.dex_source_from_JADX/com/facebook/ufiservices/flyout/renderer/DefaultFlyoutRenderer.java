package com.facebook.ufiservices.flyout.renderer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.inject.InjectorLike;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: custom_tag_links */
public class DefaultFlyoutRenderer implements IFlyoutRenderer {
    public final Context f18138a;
    public final SecureContextHelper f18139b;
    public final AnalyticsLogger f18140c;
    public final GraphQLLinkExtractor f18141d;
    private final OnClickListener f18142e = new C13222(this);
    public final OnClickListener f18143f = new C13211(this);

    /* compiled from: custom_tag_links */
    class C13211 implements OnClickListener {
        final /* synthetic */ DefaultFlyoutRenderer f18136a;

        C13211(DefaultFlyoutRenderer defaultFlyoutRenderer) {
            this.f18136a = defaultFlyoutRenderer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1692006920);
            LinkifyTargetGraphQL linkifyTargetGraphQL = (LinkifyTargetGraphQL) view.getTag(2131558516);
            DefaultFlyoutRenderer defaultFlyoutRenderer = this.f18136a;
            Preconditions.checkNotNull(linkifyTargetGraphQL);
            String a2 = defaultFlyoutRenderer.f18141d.a(linkifyTargetGraphQL.b(), linkifyTargetGraphQL.d());
            if (Strings.isNullOrEmpty(a2)) {
                Logger.a(2, EntryType.UI_INPUT_END, -442137679, a);
                return;
            }
            this.f18136a.f18140c.c((HoneyClientEvent) view.getTag(2131558518));
            Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse(a2));
            Bundle bundle = (Bundle) view.getTag(2131558517);
            if (bundle == null) {
                bundle = new Bundle();
            }
            ModelBundle.m25597a(bundle, linkifyTargetGraphQL.b().g(), linkifyTargetGraphQL.d(), linkifyTargetGraphQL.ad_() != null ? linkifyTargetGraphQL.ad_().b() : null, linkifyTargetGraphQL.C_());
            data.putExtras(bundle);
            this.f18136a.f18139b.a(data, view.getContext());
            LogUtils.a(1106443446, a);
        }
    }

    /* compiled from: custom_tag_links */
    class C13222 implements OnClickListener {
        final /* synthetic */ DefaultFlyoutRenderer f18137a;

        C13222(DefaultFlyoutRenderer defaultFlyoutRenderer) {
            this.f18137a = defaultFlyoutRenderer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1992870577);
            String str = (String) view.getTag(2131558527);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.f18137a.f18139b.a(intent, this.f18137a.f18138a);
            this.f18137a.f18140c.c((HoneyClientEvent) view.getTag(2131558518));
            Logger.a(2, EntryType.UI_INPUT_END, 1973596773, a);
        }
    }

    private static DefaultFlyoutRenderer m26686b(InjectorLike injectorLike) {
        return new DefaultFlyoutRenderer(ActivityMethodAutoProvider.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), GraphQLLinkExtractor.a(injectorLike));
    }

    @Inject
    public DefaultFlyoutRenderer(Activity activity, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, GraphQLLinkExtractor graphQLLinkExtractor) {
        this.f18138a = activity;
        this.f18139b = secureContextHelper;
        this.f18140c = analyticsLogger;
        this.f18141d = graphQLLinkExtractor;
    }

    public final void mo1386a(View view, GraphQLProfile graphQLProfile, HoneyClientEvent honeyClientEvent) {
        LinkifyTargetGraphQL a = LinkifyTargetBuilder.a(graphQLProfile);
        if (view == null || a == null) {
            view.setOnClickListener(null);
            return;
        }
        view.setTag(2131558518, honeyClientEvent);
        view.setTag(2131558516, a);
        view.setTag(2131558517, null);
        view.setOnClickListener(this.f18143f);
    }
}
