package andres.rangel.cryptocurrency.domain.use_case.get_coin

import andres.rangel.cryptocurrency.common.Resource
import andres.rangel.cryptocurrency.data.remote.dto.toCoin
import andres.rangel.cryptocurrency.data.remote.dto.toCoinDetail
import andres.rangel.cryptocurrency.domain.model.Coin
import andres.rangel.cryptocurrency.domain.model.CoinDetail
import andres.rangel.cryptocurrency.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

}