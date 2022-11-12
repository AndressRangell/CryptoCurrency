package andres.rangel.cryptocurrency.presentation.coin_detail

import andres.rangel.cryptocurrency.domain.model.Coin
import andres.rangel.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
