package com.facebook.graphql.model;

import android.net.Uri;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;

/* compiled from: use_liger */
public class PropertyBag implements Cloneable {
    @Nullable
    public GraphQLGraphSearchResultDecoration f14844A;
    public boolean f14845B;
    @Nullable
    public String f14846C;
    public int f14847D;
    @Nullable
    public ImmutableSet<String> f14848E;
    @Nullable
    public Integer f14849F;
    @Nullable
    public SponsoredImpression f14850G;
    @Nullable
    public ArrayNode f14851H;
    @Nullable
    public String f14852a;
    @Nullable
    public SponsoredImpression f14853b;
    @Nullable
    public ArrayNode f14854c;
    @Nullable
    public Uri f14855d;
    @Nullable
    public String f14856e;
    @Nullable
    public String f14857f;
    @Nullable
    public String f14858g;
    @Nullable
    public String f14859h;
    @Nullable
    public String f14860i;
    public boolean f14861j;
    @Nullable
    public String f14862k;
    @Nullable
    public FeedUnit f14863l;
    public boolean f14864m;
    @Nullable
    public FeedUnitMediaLoadedInfo f14865n;
    public int f14866o;
    public boolean f14867p;
    public boolean f14868q;
    public int f14869r;
    public boolean f14870s;
    public boolean f14871t;
    public int f14872u;
    @Nullable
    public String f14873v;
    @Nullable
    public OrganicImpression f14874w;
    @Nullable
    public String f14875x;
    public boolean f14876y;
    @Nullable
    public String f14877z;

    /* compiled from: use_liger */
    public interface HasProperty {
        PropertyBag U_();
    }

    public Object clone() {
        try {
            PropertyBag propertyBag = (PropertyBag) super.clone();
            propertyBag.f14853b = null;
            return propertyBag;
        } catch (Throwable e) {
            throw new RuntimeException("Not able to clone PropertyBag", e);
        }
    }
}
