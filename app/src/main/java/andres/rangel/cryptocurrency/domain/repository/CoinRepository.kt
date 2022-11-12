package andres.rangel.cryptocurrency.domain.repository

import andres.rangel.cryptocurrency.data.remote.dto.CoinDetailDto
import andres.rangel.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}