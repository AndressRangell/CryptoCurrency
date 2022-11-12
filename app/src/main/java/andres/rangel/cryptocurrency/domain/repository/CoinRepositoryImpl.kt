package andres.rangel.cryptocurrency.domain.repository

import andres.rangel.cryptocurrency.data.remote.CoinPaprikaApi
import andres.rangel.cryptocurrency.data.remote.dto.CoinDetailDto
import andres.rangel.cryptocurrency.data.remote.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}