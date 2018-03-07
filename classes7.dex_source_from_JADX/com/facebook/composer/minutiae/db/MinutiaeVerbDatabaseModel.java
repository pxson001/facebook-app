package com.facebook.composer.minutiae.db;

import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.GlyphModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.IconImageLargeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel.AllIconsModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel.Builder;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbModelEdge;

/* compiled from: topLoadingError */
public class MinutiaeVerbDatabaseModel {
    public final String f1509a;
    public final String f1510b;
    public final String f1511c;
    public final String f1512d;
    public final boolean f1513e;
    public final boolean f1514f;
    public final boolean f1515g;
    public final boolean f1516h;
    public final String f1517i;
    public final String f1518j;
    public final int f1519k;
    public final int f1520l;

    /* compiled from: topLoadingError */
    public class MinutiaeDatabaseModelBuilder {
        public int f1497a;
        public int f1498b;
        public String f1499c;
        public String f1500d;
        public String f1501e;
        public String f1502f;
        public boolean f1503g = false;
        public boolean f1504h = false;
        public boolean f1505i = false;
        public boolean f1506j = true;
        public String f1507k;
        public String f1508l;

        public final MinutiaeVerbDatabaseModel m1579a() {
            return new MinutiaeVerbDatabaseModel(this);
        }
    }

    public MinutiaeVerbDatabaseModel(MinutiaeDatabaseModelBuilder minutiaeDatabaseModelBuilder) {
        this.f1509a = minutiaeDatabaseModelBuilder.f1499c;
        this.f1510b = minutiaeDatabaseModelBuilder.f1500d;
        this.f1511c = minutiaeDatabaseModelBuilder.f1501e;
        this.f1512d = minutiaeDatabaseModelBuilder.f1502f;
        this.f1513e = minutiaeDatabaseModelBuilder.f1503g;
        this.f1514f = minutiaeDatabaseModelBuilder.f1504h;
        this.f1515g = minutiaeDatabaseModelBuilder.f1505i;
        this.f1516h = minutiaeDatabaseModelBuilder.f1506j;
        this.f1517i = minutiaeDatabaseModelBuilder.f1507k;
        this.f1518j = minutiaeDatabaseModelBuilder.f1508l;
        this.f1519k = minutiaeDatabaseModelBuilder.f1497a;
        this.f1520l = minutiaeDatabaseModelBuilder.f1498b;
    }

    public static MinutiaeVerbDatabaseModel m1580a(int i, MinutiaeVerbModelEdge minutiaeVerbModelEdge) {
        MinutiaeTaggableActivity minutiaeTaggableActivity = minutiaeVerbModelEdge.f1703a;
        MinutiaeDatabaseModelBuilder minutiaeDatabaseModelBuilder = new MinutiaeDatabaseModelBuilder();
        minutiaeDatabaseModelBuilder.f1499c = minutiaeTaggableActivity.j();
        minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
        minutiaeDatabaseModelBuilder.f1500d = minutiaeTaggableActivity.l();
        minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
        minutiaeDatabaseModelBuilder.f1497a = i;
        minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
        minutiaeDatabaseModelBuilder.f1501e = minutiaeTaggableActivity.n();
        minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
        minutiaeDatabaseModelBuilder.f1502f = minutiaeTaggableActivity.o();
        minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
        minutiaeDatabaseModelBuilder.f1503g = minutiaeTaggableActivity.k();
        minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
        minutiaeDatabaseModelBuilder.f1504h = minutiaeTaggableActivity.p();
        minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
        minutiaeDatabaseModelBuilder.f1505i = minutiaeTaggableActivity.r();
        minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
        minutiaeDatabaseModelBuilder.f1506j = minutiaeTaggableActivity.q();
        minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
        minutiaeDatabaseModelBuilder.f1507k = minutiaeTaggableActivity.A().a();
        minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
        minutiaeDatabaseModelBuilder.f1508l = minutiaeTaggableActivity.z().a();
        minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
        minutiaeDatabaseModelBuilder.f1498b = minutiaeTaggableActivity.B().a();
        return minutiaeDatabaseModelBuilder.m1579a();
    }

    public final MinutiaeVerbModelEdge m1581a() {
        Builder builder = new Builder();
        builder.d = this.f1509a;
        builder = builder;
        builder.f = this.f1510b;
        builder = builder;
        builder.h = this.f1511c;
        builder = builder;
        builder.o = this.f1512d;
        builder = builder;
        builder.e = this.f1513e;
        builder = builder;
        builder.p = this.f1514f;
        builder = builder;
        builder.r = this.f1515g;
        builder = builder;
        builder.q = this.f1516h;
        builder = builder;
        GlyphModel.Builder builder2 = new GlyphModel.Builder();
        builder2.a = this.f1517i;
        builder.b = builder2.a();
        builder = builder;
        IconImageLargeModel.Builder builder3 = new IconImageLargeModel.Builder();
        builder3.a = this.f1518j;
        builder.c = builder3.a();
        builder = builder;
        AllIconsModel.Builder builder4 = new AllIconsModel.Builder();
        builder4.a = this.f1520l;
        builder.a = builder4.a();
        return new MinutiaeVerbModelEdge((MinutiaeTaggableActivity) builder.a());
    }
}
