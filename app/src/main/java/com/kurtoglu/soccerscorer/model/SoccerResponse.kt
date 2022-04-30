package com.kurtoglu.soccerscorer.model


import com.google.gson.annotations.SerializedName

class SoccerResponse : ArrayList<SoccerResponse.SoccerResponseItem>(){
    data class SoccerResponseItem(
    @SerializedName("Dakika")
    val dakika: String,
    @SerializedName("FirsTeam")
    val firsTeam: String,
    @SerializedName("LigImage")
    val ligImage: String,
    @SerializedName("LigName")
    val ligName: String,
    @SerializedName("MacID")
    val macID: String,
    @SerializedName("MacSaati")
    val macSaati: String,
    @SerializedName("MacSonucu")
    val macSonucu: String,
    @SerializedName("SecondTeam")
    val secondTeam: String,
    @SerializedName("SkorID")
    val skorID: String,
    @SerializedName("UpdateDateTime")
    val updateDateTime: String
)
}