package com.facebook.pages.launchpoint.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.controller.connectioncontroller.adapters.RecyclerViewConnectionAdapter;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.EmptyConnectionState;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.launchpoint.analytics.PagesLaunchpointFunnelActions;
import com.facebook.pages.launchpoint.graphql.FetchPagesLaunchpointDiscoverGraphQLModels.FetchPagesLaunchpointDiscoverQueryModel.PagesYouMayLikeModel.NodesModel;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: page_identity_data_graphql_returned_null */
public class PagesLaunchpointDiscoverFragmentAdapter extends Adapter<ViewHolder> implements RecyclerViewConnectionAdapter<NodesModel> {
    public static final CallerContext f4295b = CallerContext.a(PagesLaunchpointDiscoverFragmentAdapter.class, "pages_launchpoint", "PROFILE_PHOTO");
    private ConnectionState<NodesModel> f4296a = EmptyConnectionState.a;
    public final FbUriIntentHandler f4297c;
    private final NumberTruncationUtil f4298d;
    public final RawLikeHelper f4299e;
    public final FunnelLoggerImpl f4300f;
    public final Context f4301g;
    public final HashMap<String, Boolean> f4302h = new HashMap();

    /* compiled from: page_identity_data_graphql_returned_null */
    public class PymlViewHolder extends ViewHolder {
        public View f4289l;
        public FbDraweeView f4290m;
        public FbTextView f4291n;
        public FbTextView f4292o;
        public FbTextView f4293p;
        public GlyphView f4294q;

        public PymlViewHolder(View view) {
            super(view);
            this.f4289l = view;
            this.f4290m = (FbDraweeView) view.findViewById(2131566590);
            this.f4290m.setAspectRatio(1.0f);
            this.f4291n = (FbTextView) view.findViewById(2131566593);
            this.f4292o = (FbTextView) view.findViewById(2131566591);
            this.f4293p = (FbTextView) view.findViewById(2131566592);
            this.f4294q = (GlyphView) view.findViewById(2131566595);
        }

        public final void m5243a(String str) {
            this.f4290m.a(Uri.parse(str), PagesLaunchpointDiscoverFragmentAdapter.f4295b);
        }

        public final void m5244b(boolean z) {
            this.f4294q.setSelected(z);
        }
    }

    @Inject
    public PagesLaunchpointDiscoverFragmentAdapter(FbUriIntentHandler fbUriIntentHandler, NumberTruncationUtil numberTruncationUtil, FunnelLoggerImpl funnelLoggerImpl, RawLikeHelper rawLikeHelper, @Assisted Context context) {
        this.f4297c = fbUriIntentHandler;
        this.f4298d = numberTruncationUtil;
        this.f4299e = rawLikeHelper;
        this.f4300f = funnelLoggerImpl;
        this.f4301g = context;
    }

    public final void m5246a(ViewHolder viewHolder, int i) {
        final PymlViewHolder pymlViewHolder = (PymlViewHolder) viewHolder;
        pymlViewHolder.f4289l.setPadding(0, 0, 0, 0);
        NodesModel nodesModel = (NodesModel) this.f4296a.a(i);
        final String l = nodesModel.m5330l();
        if (nodesModel.m5333o() != null) {
            pymlViewHolder.m5243a(nodesModel.m5333o().m5318a());
        }
        pymlViewHolder.f4290m.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagesLaunchpointDiscoverFragmentAdapter f4282b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 717922917);
                this.f4282b.f4297c.a(this.f4282b.f4301g, StringFormatUtil.formatStrLocaleSafe(FBLinks.af, l));
                Logger.a(2, EntryType.UI_INPUT_END, -1784975808, a);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < nodesModel.m5328j().size(); i2++) {
            stringBuilder.append((String) nodesModel.m5328j().get(i2));
            if (i2 != nodesModel.m5328j().size() - 1) {
                stringBuilder.append("/");
            }
        }
        if (nodesModel.m5332n() != null) {
            CharSequence quantityString = this.f4301g.getResources().getQuantityString(2131689731, nodesModel.m5332n().m5310a(), new Object[]{this.f4298d.a(nodesModel.m5332n().m5310a()), Integer.valueOf(3)});
            pymlViewHolder.f4293p.setText(stringBuilder.toString());
            pymlViewHolder.f4291n.setText(quantityString);
        }
        pymlViewHolder.f4292o.setText(nodesModel.m5331m());
        if (!this.f4302h.containsKey(l)) {
            this.f4302h.put(l, Boolean.valueOf(nodesModel.m5329k()));
        }
        pymlViewHolder.m5244b(nodesModel.m5329k());
        pymlViewHolder.f4294q.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagesLaunchpointDiscoverFragmentAdapter f4288c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1518937744);
                final boolean booleanValue = ((Boolean) this.f4288c.f4302h.get(l)).booleanValue();
                final boolean z = !booleanValue;
                this.f4288c.f4302h.put(l, Boolean.valueOf(z));
                this.f4288c.f4300f.a(FunnelRegistry.M, z ? PagesLaunchpointFunnelActions.f4307a : PagesLaunchpointFunnelActions.f4308b, l);
                pymlViewHolder.m5244b(z);
                this.f4288c.f4299e.a(l, z, null, "reaction_dialog", null, null, null, false, new MutationCallback<String>(this) {
                    final /* synthetic */ C06012 f4285c;

                    public final /* bridge */ /* synthetic */ void m5239a(Object obj) {
                    }

                    public final /* bridge */ /* synthetic */ void m5242c(Object obj) {
                    }

                    public final void m5241b(Object obj) {
                        this.f4285c.f4288c.f4300f.a(FunnelRegistry.M, z ? PagesLaunchpointFunnelActions.f4309c : PagesLaunchpointFunnelActions.f4310d, l);
                    }

                    public final void m5240a(Object obj, ServiceException serviceException) {
                        this.f4285c.f4288c.f4302h.put(l, Boolean.valueOf(booleanValue));
                        pymlViewHolder.m5244b(booleanValue);
                        this.f4285c.f4288c.f4300f.a(FunnelRegistry.M, z ? PagesLaunchpointFunnelActions.f4311e : PagesLaunchpointFunnelActions.f4312f, l);
                    }
                });
                LogUtils.a(214589141, a);
            }
        });
    }

    public final int aZ_() {
        return this.f4296a.d();
    }

    public final ViewHolder m5245a(ViewGroup viewGroup, int i) {
        return new PymlViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130906595, viewGroup, false));
    }

    public final void m5247a(ConnectionState<NodesModel> connectionState) {
        this.f4296a = connectionState;
    }

    public final void b_(int i, int i2) {
        c(i, i2);
    }
}
