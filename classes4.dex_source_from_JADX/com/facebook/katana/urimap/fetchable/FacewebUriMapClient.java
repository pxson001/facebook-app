package com.facebook.katana.urimap.fetchable;

/* compiled from: suffix */
class FacewebUriMapClient extends UriMapClient {
    public static Class<?> f1577a = FacewebUriMapClient.class;
    private final UriTemplateMapParser f1578b;

    public FacewebUriMapClient(UriTemplateMapParser uriTemplateMapParser) {
        this.f1578b = uriTemplateMapParser;
    }

    public final String mo103a() {
        return FacewebUriMap.class.getSimpleName();
    }

    public final String mo104a(Object obj) {
        return "urimap";
    }

    public final int mo105b(Object obj, Object obj2) {
        return 3600;
    }

    public final int mo107c(Object obj, Object obj2) {
        return 3600;
    }

    protected final String mo106b() {
        return "android_faceweb";
    }

    protected final String mo108c() {
        return "urimap";
    }

    protected final UriTemplateMapParser mo109d() {
        return this.f1578b;
    }
}
