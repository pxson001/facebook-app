package com.facebook.ufiservices.util;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.uri.NativeUri;
import com.facebook.common.uri.NativeUri.Builder;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer.1;
import com.facebook.intent.external.ExternalIntentHandler;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.intent.ufiservices.DefaultUriIntentGenerator;
import com.facebook.ufiservices.util.LinkifyUtil.ClickableEntitySpanWithCallback;
import com.facebook.ufiservices.util.LinkifyUtil.ExternalClickableSpanCallback;
import com.fasterxml.jackson.databind.JsonNode;
import java.lang.ref.WeakReference;

/* compiled from: native_heap_allocated */
public class LinkifyUtil$ExternalClickableSpan extends ClickableEntitySpanWithCallback {
    public WeakReference<ExternalClickableSpanCallback> f12855c;
    final /* synthetic */ LinkifyUtil f12856d;
    private final ExternalIntentHandler f12857e;
    public String f12858f = null;
    public String f12859g = null;

    public LinkifyUtil$ExternalClickableSpan(LinkifyUtil linkifyUtil, String str, ExternalIntentHandler externalIntentHandler, Context context, JsonNode jsonNode) {
        this.f12856d = linkifyUtil;
        super(linkifyUtil, str, context, jsonNode, 0, null, null);
        this.f12857e = externalIntentHandler;
    }

    protected final void m13711a(Context context, String str, JsonNode jsonNode, boolean z, TrackingNode trackingNode) {
        Intent a;
        1 1 = this.f12855c != null ? (1) this.f12855c.get() : null;
        if (1 != null) {
            1.a(this);
        }
        if (NativeThirdPartyUriHelper.a(str)) {
            UriIntentMapper uriIntentMapper = (UriIntentMapper) this.f12856d.u.get();
            Builder f = NativeUri.f();
            f.a = str;
            f = f;
            f.e = "NEWSFEED";
            a = uriIntentMapper.a(context, f.a());
        } else {
            a = ((DefaultUriIntentGenerator) this.f12856d.s.get()).m13211a(str);
        }
        if (a != null) {
            if (jsonNode != null && jsonNode.e() > 0) {
                a.putExtra("tracking_codes", jsonNode.toString());
            }
            this.f12857e.a(a, context, jsonNode, z, trackingNode);
        }
    }
}
