package com.kmutt.android.fitbitapi.exception;

import android.support.annotation.RestrictTo;

import java.util.Collection;

public class MissingScopesException extends FitbitAPIException {

    private Collection<RestrictTo.Scope> scopes;

    public MissingScopesException(Collection<RestrictTo.Scope> scopes) {
        this.scopes = scopes;
    }

    public Collection<RestrictTo.Scope> getScopes() {
        return scopes;
    }
}
