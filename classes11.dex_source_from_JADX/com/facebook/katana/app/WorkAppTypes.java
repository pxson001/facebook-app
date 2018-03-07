package com.facebook.katana.app;

import com.facebook.common.build.SignatureType;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.IntendedAudience;
import com.facebook.config.application.Product;

/* compiled from: VideoHubFragment */
public class WorkAppTypes {
    public static final FbAppType f10396a = new FbAppType("workdev", f10399d, f10400e, "b10f10a8f07b7eb4fe37065fc16cce1b", "0SmP9AZrwrsbrHR2RyVaQ-sqRoukl2MAjk04Ibg", "Xo8WBi6jzSxKDVR4drqm84yr9iU", "https://m.facebook.com/mobile_builds", IntendedAudience.DEVELOPMENT, Product.FB4A, SignatureType.DEBUG);
    public static final FbAppType f10397b = new FbAppType("work-in-house", f10399d, f10400e, "b10f10a8f07b7eb4fe37065fc16cce1b", "0e1ruJ7mZbBXS0h1Ffa7wWK4SMcshAyydjcm1qg", "pLdFLi7Y9fGRBYynu_0msNMhS_w", "https://m.facebook.com/mobile_builds", IntendedAudience.FACEBOOK, Product.FB4A, SignatureType.IN_HOUSE);
    public static final FbAppType f10398c = new FbAppType("work", f10399d, f10400e, "b10f10a8f07b7eb4fe37065fc16cce1b", "0e1ruJ7mZbBWslnLnQQ5RPITlJs7QBrg8JYbTyg", "ijxLJi1yGs1JpL-X1SExmchvork", "https://play.google.com/store/apps/details?id=com.facebook.work", IntendedAudience.PUBLIC, Product.FB4A, SignatureType.PROD);
    private static final String f10399d;
    private static final String f10400e;

    static {
        String l = Long.toString(1442593136019356L);
        f10399d = l;
        f10400e = l;
    }
}
