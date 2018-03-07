package com.fasterxml.jackson.core;

import com.facebook.infer.annotation.Strict;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import javax.annotation.Nullable;

/* compiled from: text/plain */
public interface TreeNode {
    JsonParser mo720a(ObjectCodec objectCodec);

    JsonToken mo706a();

    @Strict
    @Nullable
    TreeNode mo707a(String str);

    NumberType mo721b();

    JsonParser mo722c();
}
