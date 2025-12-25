package com.kevlaaar.balldontlie.core.network.api

import com.kevlaaar.balldontlie.core.network.model.GamesResponse
import com.kevlaaar.balldontlie.core.network.model.PlayersResponse
import com.kevlaaar.balldontlie.core.network.model.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BallDontLieApi {

    @GET("games")
    suspend fun getGames(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 25,
        @Query("dates[]") dates: List<String>? = null,
        @Query("team_ids[]") teamIds: List<Int>? = null
    ): GamesResponse

    @GET("teams")
    suspend fun getTeams(): TeamsResponse

    @GET("players")
    suspend fun getPlayers(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 25,
        @Query("search") search: String? = null
    ): PlayersResponse

}