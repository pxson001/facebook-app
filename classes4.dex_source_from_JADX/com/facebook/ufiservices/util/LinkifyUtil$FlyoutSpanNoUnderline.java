package com.facebook.ufiservices.util;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.ufiservices.flyout.C0346x25f16e6a;
import com.facebook.ufiservices.flyout.ProfileListPopoverLauncher;
import com.facebook.ufiservices.source.UFISource;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: native_heap_allocated */
public class LinkifyUtil$FlyoutSpanNoUnderline extends ClickableSpan {
    final /* synthetic */ LinkifyUtil f7297a;
    public final List<? extends C0346x25f16e6a> f7298b;
    private final JsonNode f7299c;
    private final int f7300d;

    public LinkifyUtil$FlyoutSpanNoUnderline(LinkifyUtil linkifyUtil, ImmutableList<? extends C0346x25f16e6a> immutableList, JsonNode jsonNode, int i) {
        this.f7297a = linkifyUtil;
        this.f7298b = immutableList;
        this.f7299c = jsonNode;
        this.f7300d = i;
    }

    public void onClick(View view) {
        if (this.f7298b != null && this.f7298b.size() != 0) {
            String str;
            HoneyAnalyticsEvent honeyAnalyticsEvent;
            int i;
            this.f7297a.k.get();
            JsonNode jsonNode = this.f7299c;
            if (Objects.equal(this.f7297a.r.get(), UFISource.FEED)) {
                str = "native_newsfeed";
            } else {
                str = "dash";
            }
            if (jsonNode == null || jsonNode.e() == 0) {
                honeyAnalyticsEvent = null;
            } else {
                HoneyClientEvent a = new HoneyClientEvent("open_people_list").a("tracking", jsonNode);
                a.c = str;
                honeyAnalyticsEvent = a;
            }
            this.f7297a.l.c(honeyAnalyticsEvent);
            if (((C0346x25f16e6a) this.f7298b.get(0)).mo612j() != null) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                ((ProfileListPopoverLauncher) this.f7297a.q.get()).b(view.getContext(), this.f7298b);
                return;
            }
            ProfileListPopoverLauncher profileListPopoverLauncher = (ProfileListPopoverLauncher) this.f7297a.q.get();
            Context context = view.getContext();
            List arrayList = new ArrayList();
            for (C0346x25f16e6a g : this.f7298b) {
                arrayList.add(g.mo611g());
            }
            profileListPopoverLauncher.a(context, arrayList);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.f7297a.j.getResources().getColor(this.f7300d));
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
