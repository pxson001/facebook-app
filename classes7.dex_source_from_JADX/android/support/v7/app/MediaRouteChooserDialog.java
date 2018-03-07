package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: custom_cta_mobile_contact_us_tapped_phone */
public class MediaRouteChooserDialog extends Dialog {
    private final MediaRouter f16221a;
    private final MediaRouterCallback f16222b;
    public MediaRouteSelector f16223c;
    private ArrayList<RouteInfo> f16224d;
    private RouteAdapter f16225e;
    private ListView f16226f;
    private boolean f16227g;

    /* compiled from: custom_cta_mobile_contact_us_tapped_phone */
    final class MediaRouterCallback extends Callback {
        final /* synthetic */ MediaRouteChooserDialog f16217a;

        public MediaRouterCallback(MediaRouteChooserDialog mediaRouteChooserDialog) {
            this.f16217a = mediaRouteChooserDialog;
        }

        public final void mo1248a(MediaRouter mediaRouter, RouteInfo routeInfo) {
            this.f16217a.m20274a();
        }

        public final void mo1247a(MediaRouter mediaRouter) {
            this.f16217a.m20274a();
        }

        public final void mo1250b(MediaRouter mediaRouter) {
            this.f16217a.m20274a();
        }

        public final void mo1246a(RouteInfo routeInfo) {
            this.f16217a.dismiss();
        }
    }

    /* compiled from: custom_cta_mobile_contact_us_tapped_phone */
    final class RouteAdapter extends ArrayAdapter<RouteInfo> implements OnItemClickListener {
        final /* synthetic */ MediaRouteChooserDialog f16218a;
        private final LayoutInflater f16219b;

        public RouteAdapter(MediaRouteChooserDialog mediaRouteChooserDialog, Context context, List<RouteInfo> list) {
            this.f16218a = mediaRouteChooserDialog;
            super(context, 0, list);
            this.f16219b = LayoutInflater.from(context);
        }

        public final boolean areAllItemsEnabled() {
            return false;
        }

        public final boolean isEnabled(int i) {
            return ((RouteInfo) getItem(i)).f16309f;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f16219b.inflate(2130905308, viewGroup, false);
            }
            RouteInfo routeInfo = (RouteInfo) getItem(i);
            TextView textView = (TextView) view.findViewById(16908309);
            ((TextView) view.findViewById(16908308)).setText(routeInfo.f16307d);
            String str = routeInfo.f16308e;
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
                textView.setText("");
            } else {
                textView.setVisibility(0);
                textView.setText(str);
            }
            view.setEnabled(routeInfo.f16309f);
            return view;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            RouteInfo routeInfo = (RouteInfo) getItem(i);
            if (routeInfo.f16309f) {
                routeInfo.m20378n();
                this.f16218a.dismiss();
            }
        }
    }

    /* compiled from: custom_cta_mobile_contact_us_tapped_phone */
    final class RouteComparator implements Comparator<RouteInfo> {
        public static final RouteComparator f16220a = new RouteComparator();

        private RouteComparator() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((RouteInfo) obj).f16307d.compareTo(((RouteInfo) obj2).f16307d);
        }
    }

    public MediaRouteChooserDialog(Context context) {
        this(context, 0);
    }

    private MediaRouteChooserDialog(Context context, int i) {
        super(MediaRouterThemeHelper.m20289a(context, true), i);
        this.f16223c = MediaRouteSelector.f16268a;
        this.f16221a = MediaRouter.m20380a(getContext());
        this.f16222b = new MediaRouterCallback(this);
    }

    public final void m20275a(@NonNull MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.f16223c.equals(mediaRouteSelector)) {
            this.f16223c = mediaRouteSelector;
            if (this.f16227g) {
                this.f16221a.m20391a(this.f16222b);
                this.f16221a.m20390a(mediaRouteSelector, this.f16222b, 1);
            }
            m20274a();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(3);
        setContentView(2130905306);
        setTitle(2131238217);
        getWindow().setFeatureDrawableResource(3, MediaRouterThemeHelper.m20288a(getContext(), 2130773716));
        this.f16224d = new ArrayList();
        this.f16225e = new RouteAdapter(this, getContext(), this.f16224d);
        this.f16226f = (ListView) findViewById(2131563928);
        this.f16226f.setAdapter(this.f16225e);
        this.f16226f.setOnItemClickListener(this.f16225e);
        this.f16226f.setEmptyView(findViewById(16908292));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f16227g = true;
        this.f16221a.m20390a(this.f16223c, this.f16222b, 1);
        m20274a();
    }

    public void onDetachedFromWindow() {
        this.f16227g = false;
        this.f16221a.m20391a(this.f16222b);
        super.onDetachedFromWindow();
    }

    public final void m20274a() {
        if (this.f16227g) {
            this.f16224d.clear();
            this.f16224d.addAll(MediaRouter.m20381a());
            List list = this.f16224d;
            int size = list.size();
            while (true) {
                int i = size - 1;
                if (size > 0) {
                    Object obj;
                    RouteInfo routeInfo = (RouteInfo) list.get(i);
                    if (!routeInfo.m20377g() && routeInfo.f16309f && routeInfo.m20373a(this.f16223c)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        list.remove(i);
                        size = i;
                    } else {
                        size = i;
                    }
                } else {
                    Collections.sort(this.f16224d, RouteComparator.f16220a);
                    AdapterDetour.a(this.f16225e, -561884566);
                    return;
                }
            }
        }
    }
}
