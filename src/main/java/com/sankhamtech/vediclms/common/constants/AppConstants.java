package com.sankhamtech.vediclms.common.constants;

public final class AppConstants {

    private AppConstants() {
        // prevent instantiation
    }

    // Public URLs
    public static final String LOGIN_PAGE = "/public/login";
    public static final String PURCHASE_PAGE = "/public/purchase";

    // Success redirects
    public static final String DASHBOARD_URL = "/dashboard";

    // Failure redirects
    public static final String LOGIN_FAILURE = LOGIN_PAGE + "?error=oauth_failed";
}