package ca.tetervak.paperrockorscissors.data.local

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun gameService(): GameService = GameServiceImpl()
}