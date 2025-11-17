package ted.gun0912.movie.local.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ted.gun0912.movie.local.room.AppDatabase
import ted.gun0912.movie.local.room.RoomConstant
import ted.gun0912.movie.local.room.dao.MovieDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object LocalRoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            RoomConstant.ROOM_DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideMovieDao(database: AppDatabase): MovieDao = database.movieDao()
}
