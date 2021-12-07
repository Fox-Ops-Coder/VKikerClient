package com.foxdev.vkikermodule.net;

public final class Endpoints {
    public static final String LEADERBOARD_ENDPOINT = "/leaderboard";
    public static final String LOBBY = "/battle/lobby";
    public static final String GET_USER = "/user/{userId}";
    public static final String AUTH = "/auth/registration";
    public static final String LOG_IN = "/auth/authorization/{userName}";
    public static final String UPDATE_FCM = "/auth/fcm";
    public static final String DUEL_INVITATION = "/battle/duel";
    public static final String DUEL_ACCEPT = "/battle/accept";
    public static final String BATTLE_READY = "/battle/ready/{userId}";
    public static final String STOP_BATTLE = "/battle/stop/{userId}";
    public static final String SEND_BATTLE_RESULTS = "/battle/result";
}
