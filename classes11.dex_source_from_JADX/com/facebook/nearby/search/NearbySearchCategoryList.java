package com.facebook.nearby.search;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.nearby.common.NearbyTopic;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;

/* compiled from: topShow */
public class NearbySearchCategoryList {
    private static NearbySearchCategoryList f736j;
    public final NearbyTopic f737a;
    public final NearbyTopic f738b;
    public final NearbyTopic f739c;
    public final NearbyTopic f740d;
    public final NearbyTopic f741e;
    public final NearbyTopic f742f;
    public final NearbyTopic f743g;
    public final NearbyTopic f744h;
    public final ImmutableMap<String, ImmutableList<NearbyTopic>> f745i;

    private NearbySearchCategoryList(Context context) {
        Resources resources = context.getResources();
        this.f737a = new NearbyTopic(Sets.a(new Long[]{Long.valueOf(-1)}), resources.getString(2131236640));
        this.f738b = new NearbyTopic(Sets.a(new Long[]{Long.valueOf(273819889375819L)}), resources.getString(2131236642));
        this.f739c = new NearbyTopic(Sets.a(new Long[]{Long.valueOf(128673187201735L), Long.valueOf(197871390225897L)}), resources.getString(2131236643));
        this.f740d = new NearbyTopic(Sets.a(new Long[]{Long.valueOf(354275401259620L)}), resources.getString(2131236644));
        this.f741e = new NearbyTopic(Sets.a(new Long[]{Long.valueOf(272705352802676L)}), resources.getString(2131236645));
        this.f742f = new NearbyTopic(Sets.a(new Long[]{Long.valueOf(133436743388217L)}), resources.getString(2131236646));
        this.f743g = new NearbyTopic(Sets.a(new Long[]{Long.valueOf(164243073639257L)}), resources.getString(2131236647));
        this.f744h = new NearbyTopic(Sets.a(new Long[]{Long.valueOf(200600219953504L)}), resources.getString(2131236648));
        Builder builder = new Builder();
        ImmutableList.Builder builder2 = new ImmutableList.Builder();
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(273819889375819L)}), resources.getString(2131236650)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(149803325077018L)}), resources.getString(2131236653)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(187827497907070L)}), resources.getString(2131236654)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(150534008338515L)}), resources.getString(2131236655)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(192108214153222L)}), resources.getString(2131236656)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(197871390225897L)}), resources.getString(2131236657)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(174483852595760L)}), resources.getString(2131236658)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(188334264523313L)}), resources.getString(2131236659)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(168976549819329L)}), resources.getString(2131236660)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(200863816597800L), Long.valueOf(215290398491661L)}), resources.getString(2131236661)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(129539913784760L)}), resources.getString(2131236662)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(193831710644458L)}), resources.getString(2131236663)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(199035016778342L)}), resources.getString(2131236664)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(150896171638138L)}), resources.getString(2131236665)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(176960322351733L)}), resources.getString(2131236666)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(199377230079198L)}), resources.getString(2131236667)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(180256082015845L)}), resources.getString(2131236668)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(184460441595855L)}), resources.getString(2131236669)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(198367566846946L)}), resources.getString(2131236670)));
        builder2.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(155136917876965L), Long.valueOf(211063415594061L)}), resources.getString(2131236671)));
        ImmutableList b = builder2.b();
        ImmutableList.Builder builder3 = new ImmutableList.Builder();
        builder3.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(133436743388217L)}), resources.getString(2131236651)));
        builder3.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(197384240287028L)}), resources.getString(2131236689)));
        builder3.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(192511100766680L)}), resources.getString(2131236690)));
        builder3.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(197817313562497L)}), resources.getString(2131236691)));
        builder3.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(179943432047564L), Long.valueOf(103436486409265L), Long.valueOf(181815448531059L), Long.valueOf(210881938937928L), Long.valueOf(207290352633942L)}), resources.getString(2131236692)));
        ImmutableList b2 = builder3.b();
        ImmutableList.Builder builder4 = new ImmutableList.Builder();
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(200600219953504L)}), resources.getString(2131236652)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(417935738217839L)}), resources.getString(2131236672)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(197048876974331L)}), resources.getString(2131236673)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(186230924744328L)}), resources.getString(2131236674)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(139823692748565L)}), resources.getString(2131236675)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(200253979990258L)}), resources.getString(2131236676)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(344508555610070L)}), resources.getString(2131236677)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(150108431712141L)}), resources.getString(2131236678)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(162845797101278L)}), resources.getString(2131236679)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(108427109235243L)}), resources.getString(2131236680)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(188031587886173L)}), resources.getString(2131236681)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(424974910863603L)}), resources.getString(2131236682)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(110249975723427L)}), resources.getString(2131236683)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(109527622457518L)}), resources.getString(2131236684)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(139225689474222L)}), resources.getString(2131236685)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(186982054657561L)}), resources.getString(2131236686)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(178680352174443L)}), resources.getString(2131236687)));
        builder4.c(new NearbyTopic(Sets.a(new Long[]{Long.valueOf(187070794658134L)}), resources.getString(2131236688)));
        ImmutableList b3 = builder4.b();
        builder.b(resources.getString(2131236642), b);
        builder.b(resources.getString(2131236646), b2);
        builder.b(resources.getString(2131236648), b3);
        this.f745i = builder.b();
    }

    public static NearbySearchCategoryList m1028a(Context context) {
        if (f736j == null) {
            f736j = new NearbySearchCategoryList(context);
        }
        return f736j;
    }
}
