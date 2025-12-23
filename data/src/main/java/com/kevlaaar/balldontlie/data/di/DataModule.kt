package com.kevlaaar.balldontlie.data.di

import com.kevlaaar.baldontlie.domain.repository.GamesRepository
import com.kevlaaar.baldontlie.domain.repository.PlayerRepository
import com.kevlaaar.baldontlie.domain.repository.TeamsRepository
import com.kevlaaar.balldontlie.data.repository.GamesRepositoryImpl
import com.kevlaaar.balldontlie.data.repository.PlayersRepositoryImpl
import com.kevlaaar.balldontlie.data.repository.TeamsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindGamesRepository(
        impl: GamesRepositoryImpl
    ): GamesRepository

    @Binds
    @Singleton
    abstract fun bindPlayersRepository(
        impl: PlayersRepositoryImpl
    ): PlayerRepository

    @Binds
    @Singleton
    abstract fun bindTeamsRepository(
        impl: TeamsRepositoryImpl
    ): TeamsRepository

}