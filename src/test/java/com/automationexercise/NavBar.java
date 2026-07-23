package com.automationexercise;

import java.util.Locale;
import java.util.Set;

public enum NavBar {

    HOME("home"),
    PRODUCTS("products"),
    CART("cart"),
    SIGNUP_LOGIN("signup", "login", "signup and login"),
    TEST_CASES("test cases"),
    API_TESTING("api test cases", "api tests"),
    VIDEO_TUTORIALS("video tutorials"),
    CONTACT_US("contact us"),

    // Special-case
    DELETE("delete"),
    LOGOUT("logout")

    ;

    private final Set<String> alias;

    NavBar(Set<String> alias) {
        this.alias = alias;
    }

    NavBar(String... alias) {
        this(Set.of(alias));
    }

    public static NavBar find(String text) {
        for (var bar : values()) {
            if (bar.alias.contains(text.toLowerCase(Locale.ROOT))) {
                return bar;
            }
        }

        return null;
    }

    public int position() {
        return this.position(AutomationExerciseTestSuite.isLoggedIn());
    }

    /**
     *
     * Used to calculate the position of the element in the navbar
     * <br>
     * We add 1 when the user is logged in as the 'Logout' and 'Delete' functions are inserted where the 'Signup/Login' function usually is
     *
     * @param loggedIn If the user is logged in
     * @return The position in the navbar
     */
    public int position(boolean loggedIn) {
        if (!loggedIn) {
            if (this == DELETE || this == LOGOUT) {
                throw new IllegalArgumentException("You cannot use the DELETE or LOGOUT navbar element unless you are logged in");
            }

            return this.ordinal();
        }

        var ordinal = this.ordinal();

        if (ordinal < 3) {
            return ordinal;
        }

        if (this == LOGOUT) {
            return 3;
        }

        if (this == DELETE) {
            return 4;
        }

        return ordinal + 1;
    }
}
