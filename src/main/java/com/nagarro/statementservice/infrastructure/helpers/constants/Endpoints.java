package com.nagarro.statementservice.infrastructure.helpers.constants;

public class Endpoints {
    public static class Authentication {
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        private Authentication() {}
    }

    public static class Statement {
        public static final String RESOURCE = "/statement";
        private Statement() {}
    }

    public static class Account {
        public static final String RESOURCE = "/account";
        private Account() {}
    }

    private Endpoints() {}
}
