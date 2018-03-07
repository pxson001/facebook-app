package com.facebook.content;

/* compiled from: zh */
public abstract class SecureContentProvider extends AbstractContentProvider {
    protected final boolean mo9b() {
        return PermissionChecks.a(getContext());
    }
}
