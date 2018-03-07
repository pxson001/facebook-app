package com.facebook.graphql.calls;

/* compiled from: popular_at_add_item */
public final class StoreLocatorInputStoreLocatorArgs extends GraphQlCallInput {

    /* compiled from: popular_at_add_item */
    public final class GeoBoundingBox extends GraphQlCallInput {
        public final GeoBoundingBox m4489a(Double d) {
            a("north", d);
            return this;
        }

        public final GeoBoundingBox m4490b(Double d) {
            a("west", d);
            return this;
        }

        public final GeoBoundingBox m4491c(Double d) {
            a("south", d);
            return this;
        }

        public final GeoBoundingBox m4492d(Double d) {
            a("east", d);
            return this;
        }
    }

    public final StoreLocatorInputStoreLocatorArgs m4494a(String str) {
        a("ad_id", str);
        return this;
    }

    public final StoreLocatorInputStoreLocatorArgs m4495b(String str) {
        a("parent_page_id", str);
        return this;
    }

    public final StoreLocatorInputStoreLocatorArgs m4496c(String str) {
        a("page_set_id", str);
        return this;
    }

    public final StoreLocatorInputStoreLocatorArgs m4493a(GeoBoundingBox geoBoundingBox) {
        a("geo_bounding_box", geoBoundingBox);
        return this;
    }
}
