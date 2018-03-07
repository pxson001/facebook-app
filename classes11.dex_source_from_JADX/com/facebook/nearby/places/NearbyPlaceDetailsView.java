package com.facebook.nearby.places;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPageVisitsConnection;
import com.facebook.graphql.model.GraphQLStreetAddress;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.maps.Locations;
import com.facebook.maps.MapsLocationUtils;
import com.facebook.nearby.annotations.IsFacepileInNearbyPlaceResultsEnabled;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper.ImageSize;
import com.facebook.nearby.model.TypeaheadPlace;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.BrowseNearbyPlacesFullImageFragmentModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.PageVisitsModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesOldFlowFriendsWhoVisitedFragmentModel.FriendsWhoVisitedModel.EdgesModel.NodeModel;
import com.facebook.saved.gating.annotations.IsSavedForLaterEnabled;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: unknown_error_info_ */
public class NearbyPlaceDetailsView extends CustomRelativeLayout {
    private static final CallerContext f451d = CallerContext.a(NearbyPlaceDetailsView.class, "nearby_places");
    @Inject
    @IsSavedForLaterEnabled
    Provider<TriState> f452a;
    @Inject
    @IsFacepileInNearbyPlaceResultsEnabled
    Provider<TriState> f453b;
    @Inject
    MapsLocationUtils f454c;
    private final float f455e;
    private final float f456f;
    private final FbDraweeView f457g;
    private final TextView f458h;
    private final FacepileView f459i;
    private final TextView f460j;
    private final TextView f461k;
    private final FrameLayout f462l;
    private final RatingBar f463m;
    private final ImageView f464n;
    private final TextView f465o;
    private final TextView f466p;
    private ForegroundColorSpan f467q;
    private final TextView f468r;
    private final Resources f469s;

    private static <T extends View> void m558a(Class<T> cls, T t) {
        m559a((Object) t, t.getContext());
    }

    private static void m559a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NearbyPlaceDetailsView) obj).m560a(IdBasedProvider.a(fbInjector, 767), IdBasedProvider.a(fbInjector, 717), MapsLocationUtils.b(fbInjector));
    }

    private void m560a(Provider<TriState> provider, Provider<TriState> provider2, MapsLocationUtils mapsLocationUtils) {
        this.f452a = provider;
        this.f453b = provider2;
        this.f454c = mapsLocationUtils;
    }

    public NearbyPlaceDetailsView(Context context) {
        this(context, null);
    }

    public NearbyPlaceDetailsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyPlaceDetailsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905380);
        m558a(NearbyPlaceDetailsView.class, (View) this);
        this.f458h = (TextView) a(2131562901);
        this.f457g = (FbDraweeView) a(2131560323);
        this.f459i = (FacepileView) a(2131564067);
        this.f460j = (TextView) a(2131564075);
        this.f461k = (TextView) a(2131564074);
        this.f468r = (TextView) a(2131564066);
        this.f462l = (FrameLayout) a(2131564069);
        this.f463m = (RatingBar) a(2131564070);
        this.f466p = (TextView) a(2131564073);
        this.f464n = (ImageView) a(2131564071);
        this.f465o = (TextView) a(2131564072);
        this.f467q = new ForegroundColorSpan(getResources().getColor(2131363042));
        this.f469s = context.getResources();
        this.f455e = (float) SizeUtil.c(this.f469s, 2131427400);
        this.f456f = (float) SizeUtil.c(this.f469s, 2131427402);
    }

    public final void m563a(NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper, Location location) {
        int size;
        int i;
        int i2;
        GraphQLSavedState cB;
        Preconditions.checkNotNull(nearbyPlaceEdgeWrapper);
        this.f458h.setText(nearbyPlaceEdgeWrapper.m504h());
        this.f457g.a(Uri.parse(nearbyPlaceEdgeWrapper.m508m()), f451d);
        if (location == null) {
            this.f468r.setVisibility(8);
        } else {
            this.f468r.setVisibility(0);
            this.f468r.setText(this.f454c.a(location, nearbyPlaceEdgeWrapper.m502f()));
        }
        if (m561a()) {
            this.f460j.setVisibility(8);
            List arrayList = new ArrayList();
            if (nearbyPlaceEdgeWrapper.f385d != null) {
                ImmutableList j = nearbyPlaceEdgeWrapper.f385d.j();
                if (j != null) {
                    size = j.size();
                }
                size = 0;
            } else {
                if (nearbyPlaceEdgeWrapper.f388g != null) {
                    size = nearbyPlaceEdgeWrapper.f388g.j().size();
                }
                size = 0;
            }
            i = size;
            i2 = 0;
            while (i2 < i && i2 < 3) {
                String str;
                ImageSize imageSize;
                String str2;
                if (nearbyPlaceEdgeWrapper.f385d != null) {
                    GraphQLUser a = NearbyPlaceEdgeWrapper.m493a(nearbyPlaceEdgeWrapper.f385d, i2);
                    imageSize = ImageSize.SIZE_DEFAULT;
                    GraphQLImage graphQLImage = null;
                    if (a != null) {
                        switch (imageSize) {
                            case SIZE_50:
                                graphQLImage = a.az();
                                break;
                            case SIZE_LARGE:
                            case SIZE_74:
                            case SIZE_60:
                                graphQLImage = a.aA();
                                break;
                            case SIZE_32:
                            case SIZE_SMALL:
                                graphQLImage = a.ay();
                                break;
                            case SIZE_DEFAULT:
                                graphQLImage = a.aI();
                                break;
                        }
                    }
                    if (graphQLImage == null) {
                        str2 = "";
                    } else {
                        str2 = graphQLImage.b();
                    }
                    str = str2;
                } else if (nearbyPlaceEdgeWrapper.f388g != null) {
                    NodeModel a2 = NearbyPlaceEdgeWrapper.m494a(nearbyPlaceEdgeWrapper.f388g, i2);
                    imageSize = ImageSize.SIZE_DEFAULT;
                    BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel = null;
                    if (a2 != null) {
                        switch (imageSize) {
                            case SIZE_50:
                            case SIZE_LARGE:
                                browseNearbyPlacesFullImageFragmentModel = a2.l();
                                break;
                            case SIZE_32:
                            case SIZE_SMALL:
                            case SIZE_DEFAULT:
                                browseNearbyPlacesFullImageFragmentModel = a2.k();
                                break;
                        }
                    }
                    if (browseNearbyPlacesFullImageFragmentModel == null) {
                        str2 = "";
                    } else {
                        str2 = browseNearbyPlacesFullImageFragmentModel.d();
                    }
                    str = str2;
                } else {
                    str = "";
                }
                arrayList.add(new Face(Uri.parse(str)));
                i2++;
            }
            this.f459i.setFaces(arrayList);
            this.f459i.setFaceCountForOverflow(nearbyPlaceEdgeWrapper.m498b() - i2);
            this.f459i.setGravity(5);
            this.f459i.setVisibility(0);
        } else {
            this.f459i.setVisibility(8);
            CharSequence a3 = nearbyPlaceEdgeWrapper.m497a(this.f469s);
            if (TextUtils.isEmpty(a3)) {
                this.f460j.setVisibility(8);
            } else {
                this.f460j.setVisibility(0);
                this.f460j.setText(a3);
            }
        }
        if (nearbyPlaceEdgeWrapper.f384c != null) {
            cB = nearbyPlaceEdgeWrapper.f384c.cB();
        } else if (nearbyPlaceEdgeWrapper.f386e != null) {
            cB = GraphQLSavedState.NOT_SAVED;
        } else {
            cB = GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        GraphQLSavedState graphQLSavedState = cB;
        if (m562b() && graphQLSavedState == GraphQLSavedState.SAVED) {
            this.f462l.setVisibility(8);
            this.f466p.setVisibility(8);
            this.f464n.setVisibility(0);
            this.f465o.setVisibility(0);
        } else {
            this.f464n.setVisibility(8);
            this.f465o.setVisibility(8);
            double i3 = nearbyPlaceEdgeWrapper.m505i();
            if (i3 > 0.0d) {
                this.f462l.setVisibility(0);
                this.f466p.setVisibility(8);
                this.f463m.setRating((float) i3);
                this.f463m.setVisibility(0);
            } else {
                this.f462l.setVisibility(8);
            }
        }
        ImmutableList l = nearbyPlaceEdgeWrapper.m507l();
        if (l != null) {
            i2 = l.size();
        } else {
            i2 = 0;
        }
        if (nearbyPlaceEdgeWrapper.f384c != null) {
            GraphQLPageVisitsConnection aS = nearbyPlaceEdgeWrapper.f384c.aS();
            if (aS != null) {
                size = aS.a();
            }
            size = 0;
        } else {
            if (nearbyPlaceEdgeWrapper.f387f != null) {
                PageVisitsModel o = nearbyPlaceEdgeWrapper.f387f.o();
                if (o != null) {
                    size = o.a();
                }
            }
            size = 0;
        }
        i = size;
        if (i2 == 0 && i == 0) {
            this.f466p.setVisibility(8);
        } else {
            this.f466p.setVisibility(0);
            this.f466p.setText(m557a(i, (String) l.get(0)));
        }
        this.f461k.setVisibility(8);
    }

    public final void m564a(TypeaheadPlace typeaheadPlace, Location location) {
        this.f458h.setText(typeaheadPlace.f397b);
        this.f457g.a(Uri.parse(typeaheadPlace.f399d.b()), f451d);
        this.f463m.setVisibility(8);
        this.f464n.setVisibility(8);
        this.f465o.setVisibility(8);
        this.f461k.setVisibility(0);
        if (m562b() && typeaheadPlace.f406k == GraphQLSavedState.SAVED) {
            this.f464n.setVisibility(0);
            this.f465o.setVisibility(0);
        } else if (typeaheadPlace.f398c > 0.0d) {
            this.f463m.setVisibility(0);
            this.f463m.setRating((float) typeaheadPlace.f398c);
        }
        if (typeaheadPlace.f405j) {
            this.f461k.setText(getPermanentlyClosedText());
            this.f461k.setTextSize(this.f456f);
        } else {
            CharSequence p;
            TextView textView = this.f461k;
            List list = typeaheadPlace.f401f;
            GraphQLStreetAddress graphQLStreetAddress = typeaheadPlace.f402g;
            CharSequence charSequence = "";
            String str = "";
            if (!(list == null || list.isEmpty())) {
                charSequence = (String) list.get(0);
            }
            if (graphQLStreetAddress != null) {
                if (!StringUtil.a(graphQLStreetAddress.p())) {
                    p = graphQLStreetAddress.p();
                } else if (!StringUtil.a(graphQLStreetAddress.k())) {
                    p = graphQLStreetAddress.k();
                }
                if (!StringUtil.a(charSequence)) {
                    if (StringUtil.a(p)) {
                        p = charSequence + " · " + p;
                    } else {
                        p = charSequence;
                    }
                }
                textView.setText(p);
                this.f461k.setTextSize(this.f455e);
            }
            Object obj = str;
            if (StringUtil.a(charSequence)) {
                if (StringUtil.a(p)) {
                    p = charSequence + " · " + p;
                } else {
                    p = charSequence;
                }
            }
            textView.setText(p);
            this.f461k.setTextSize(this.f455e);
        }
        if (location == null) {
            this.f468r.setVisibility(8);
        } else {
            this.f468r.setVisibility(0);
            this.f468r.setText(this.f454c.a(location, Locations.a(typeaheadPlace.f400e.a(), typeaheadPlace.f400e.b())));
        }
        this.f466p.setVisibility(8);
        this.f459i.setVisibility(8);
        this.f460j.setVisibility(8);
    }

    private boolean m561a() {
        return ((TriState) this.f453b.get()).asBoolean(false);
    }

    private boolean m562b() {
        return ((TriState) this.f452a.get()).asBoolean(false);
    }

    private String m557a(int i, String str) {
        String quantityString = this.f469s.getQuantityString(2131689656, i, new Object[]{Integer.valueOf(i)});
        String string = this.f469s.getString(2131236634);
        int i2 = !StringUtil.a(str) ? 1 : 0;
        if (i > 0 && i2 != 0) {
            return Joiner.on(" ").join(str, string, new Object[]{quantityString}).toString();
        } else if (i == 0 && i2 != 0) {
            return str;
        } else {
            if (i <= 0 || i2 != 0) {
                return "";
            }
            return quantityString;
        }
    }

    private SpannableStringBuilder getPermanentlyClosedText() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Object string = this.f469s.getString(2131235391);
        spannableStringBuilder.append(string);
        spannableStringBuilder.setSpan(this.f467q, 0, string.length(), 33);
        return spannableStringBuilder;
    }
}
