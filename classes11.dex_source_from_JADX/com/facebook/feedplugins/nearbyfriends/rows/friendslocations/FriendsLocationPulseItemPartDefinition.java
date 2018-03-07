package com.facebook.feedplugins.nearbyfriends.rows.friendslocations;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.android.maps.model.LatLngBounds.Builder;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feedplugins.nearbyfriends.rows.ui.FriendsLocationsPageView;
import com.facebook.feedplugins.nearbyfriends.rows.util.FriendsNearbyFeedUnitAnalyticsLogger;
import com.facebook.graphql.model.GraphQLFriendsLocationsCluster;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.delegate.CameraUpdateDelegate;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapDelegate.OnMapClickListener;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: com.facebook.ipc.model.FacebookProfileDeserializer */
public class FriendsLocationPulseItemPartDefinition extends BaseSinglePartDefinitionWithViewType<FriendsNearbyItemPartDefinition$Props, State, AnyEnvironment, FriendsLocationsPageView> {
    public static final CallerContext f8446a = CallerContext.a(FriendsLocationPulseItemPartDefinition.class, "native_newsfeed");
    public static final String f8447b = StringFormatUtil.formatStrLocaleSafe(FBLinks.cQ, "feed_friends_locations_pulse");
    private static FriendsLocationPulseItemPartDefinition f8448g;
    private static final Object f8449h = new Object();
    private final FriendsLocationsPulsePagePartDefinition f8450c;
    public final FriendsNearbyFeedUnitAnalyticsLogger f8451d;
    public final SecureContextHelper f8452e;
    public final Context f8453f;

    /* compiled from: com.facebook.ipc.model.FacebookProfileDeserializer */
    public class State {
        public final OnMapReadyDelegateCallback f8444a;
        public final Uri f8445b;

        public State(OnMapReadyDelegateCallback onMapReadyDelegateCallback, Uri uri) {
            this.f8444a = onMapReadyDelegateCallback;
            this.f8445b = uri;
        }
    }

    private static FriendsLocationPulseItemPartDefinition m9356b(InjectorLike injectorLike) {
        return new FriendsLocationPulseItemPartDefinition(FriendsLocationsPulsePagePartDefinition.m9393a(injectorLike), FriendsNearbyFeedUnitAnalyticsLogger.m9411b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m9358a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FriendsNearbyItemPartDefinition$Props friendsNearbyItemPartDefinition$Props = (FriendsNearbyItemPartDefinition$Props) obj;
        subParts.a(this.f8450c, friendsNearbyItemPartDefinition$Props);
        final GraphQLLocation j = friendsNearbyItemPartDefinition$Props.f8549b.j();
        final ImmutableList r = friendsNearbyItemPartDefinition$Props.f8549b.r();
        OnMapReadyDelegateCallback c10441 = new OnMapReadyDelegateCallback(this) {
            final /* synthetic */ FriendsLocationPulseItemPartDefinition f8443d;

            /* compiled from: com.facebook.ipc.model.FacebookProfileDeserializer */
            class C10431 implements OnMapClickListener {
                final /* synthetic */ C10441 f8439a;

                C10431(C10441 c10441) {
                    this.f8439a = c10441;
                }

                public final void m9349a() {
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(FriendsLocationPulseItemPartDefinition.f8447b));
                    intent.addFlags(268435456);
                    this.f8439a.f8443d.f8452e.a(intent, this.f8439a.f8443d.f8453f);
                    this.f8439a.f8443d.f8451d.m9417c(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                }
            }

            public final void m9350a(MapDelegate mapDelegate) {
                CameraUpdateDelegate a;
                int i;
                int i2 = 0;
                mapDelegate.a();
                GraphQLLocation a2;
                if (j == null && r.size() == 1) {
                    a2 = ((GraphQLFriendsLocationsCluster) r.get(0)).a();
                    a = CameraUpdateFactoryDelegate.a(new LatLng(a2.a(), a2.b()), 7.0f);
                } else {
                    Builder a3 = LatLngBounds.a();
                    int size = r.size();
                    for (i = 0; i < size; i++) {
                        a2 = ((GraphQLFriendsLocationsCluster) r.get(i)).a();
                        a3.a(new LatLng(a2.a(), a2.b()));
                    }
                    LatLngBounds a4 = a3.a();
                    if (j != null) {
                        LatLng latLng = new LatLng(j.a(), j.b());
                        a4 = FriendsLocationPulseItemPartDefinition.m9355b(a3.a(latLng).a(), latLng);
                    }
                    a = CameraUpdateFactoryDelegate.a(a4, this.f8443d.f8453f.getResources().getDimensionPixelSize(2131430217));
                }
                mapDelegate.a(a);
                i = r.size();
                while (i2 < i) {
                    GraphQLFriendsLocationsCluster graphQLFriendsLocationsCluster = (GraphQLFriendsLocationsCluster) r.get(i2);
                    GraphQLLocation a5 = graphQLFriendsLocationsCluster.a();
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.b = new LatLng(a5.a(), a5.b());
                    MarkerOptions markerOptions2 = markerOptions;
                    markerOptions2.c = BitmapDescriptorFactory.a(FriendsLocationPulseItemPartDefinition.m9354b(this.f8443d.f8453f, graphQLFriendsLocationsCluster.j()));
                    mapDelegate.a(markerOptions2.a(0.5f, 0.5f));
                    i2++;
                }
                mapDelegate.a(new C10431(this));
            }
        };
        Uri uri = null;
        if (friendsNearbyItemPartDefinition$Props.f8549b.o() != null) {
            GraphQLImage graphQLImage;
            GraphQLProfile a = FeedUnitItemProfileHelper.a(friendsNearbyItemPartDefinition$Props.f8549b);
            if (a == null || !GraphQLHelper.a(a)) {
                graphQLImage = null;
            } else {
                graphQLImage = a.ai();
            }
            GraphQLImage graphQLImage2 = graphQLImage;
            if (graphQLImage2 != null) {
                uri = Uri.parse(graphQLImage2.b());
            }
        }
        return new State(c10441, uri);
    }

    public final /* bridge */ /* synthetic */ void m9359a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -380675259);
        State state = (State) obj2;
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setPulseMapReadyCallback(state.f8444a);
        friendsLocationsPageView.m9407a(state.f8445b, f8446a);
        Logger.a(8, EntryType.MARK_POP, 1237532298, a);
    }

    public final void m9360b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setPulseMapReadyCallback(null);
        friendsLocationsPageView.m9407a(null, null);
    }

    public static FriendsLocationPulseItemPartDefinition m9353a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationPulseItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8449h) {
                FriendsLocationPulseItemPartDefinition friendsLocationPulseItemPartDefinition;
                if (a2 != null) {
                    friendsLocationPulseItemPartDefinition = (FriendsLocationPulseItemPartDefinition) a2.a(f8449h);
                } else {
                    friendsLocationPulseItemPartDefinition = f8448g;
                }
                if (friendsLocationPulseItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9356b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8449h, b3);
                        } else {
                            f8448g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsLocationPulseItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FriendsLocationPulseItemPartDefinition(FriendsLocationsPulsePagePartDefinition friendsLocationsPulsePagePartDefinition, FriendsNearbyFeedUnitAnalyticsLogger friendsNearbyFeedUnitAnalyticsLogger, SecureContextHelper secureContextHelper, Context context) {
        this.f8450c = friendsLocationsPulsePagePartDefinition;
        this.f8451d = friendsNearbyFeedUnitAnalyticsLogger;
        this.f8452e = secureContextHelper;
        this.f8453f = context;
    }

    public final ViewType<FriendsLocationsPageView> m9357a() {
        return FriendsNearbyItemPartDefinition.a;
    }

    public static LatLngBounds m9355b(LatLngBounds latLngBounds, LatLng latLng) {
        double b = (double) Projection.b(latLng.a);
        double max = Math.max(b - ((double) Projection.b(latLngBounds.b.a)), ((double) Projection.b(latLngBounds.c.a)) - b);
        double d = b - max;
        double a = d < 0.0d ? 90.0d : Projection.a(d);
        d = b + max;
        d = d > 1.0d ? -90.0d : Projection.a(d);
        b = latLngBounds.b.b;
        max = latLngBounds.c.b;
        double a2 = m9352a(max, latLng.b);
        double a3 = m9352a(latLng.b, b);
        if (a2 > a3) {
            b = m9351a(latLng.b + a2);
        } else {
            max = m9351a(latLng.b - a3);
        }
        return new LatLngBounds(new LatLng(d, max), new LatLng(a, b));
    }

    private static double m9351a(double d) {
        if (d > 180.0d) {
            return d - 360.0d;
        }
        if (d < -180.0d) {
            return d + 180.0d;
        }
        return d;
    }

    private static double m9352a(double d, double d2) {
        double d3 = d2 - d;
        return ((double) (d3 < 0.0d ? 360 : 0)) + d3;
    }

    public static Bitmap m9354b(Context context, int i) {
        Resources resources = context.getResources();
        String valueOf = String.valueOf(i);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430220);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131430221);
        if (i > 20) {
            valueOf = "20+";
            dimensionPixelSize += dimensionPixelSize2 * 2;
        } else if (i > 9) {
            dimensionPixelSize += dimensionPixelSize2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable drawable = resources.getDrawable(2130840464);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        drawable.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(resources.getColor(2131361920));
        paint.setTextSize((float) resources.getDimensionPixelSize(2131427397));
        Rect rect = new Rect();
        paint.getTextBounds(valueOf, 0, valueOf.length(), rect);
        canvas.drawText(valueOf, (float) ((dimensionPixelSize - rect.width()) / 2), (float) ((dimensionPixelSize + rect.height()) / 2), paint);
        return createBitmap;
    }
}
