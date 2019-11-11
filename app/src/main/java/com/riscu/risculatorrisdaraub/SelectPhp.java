package com.riscu.risculatorrisdaraub;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class SelectPhp {

    @SerializedName("harga_id")
    @Expose
    private String hargaId;

    @SerializedName("harga_semasa")
    @Expose
    private String hargaSemasa;

    @SerializedName("trk_semasa")
    @Expose
    private String trksemasa;

    public String getHargaId() {
        return hargaId;
    }

    public void setHargaId(String hargaId) {
        this.hargaId = hargaId;
    }

    public String getHargaSemasa() {
        return hargaSemasa;
    }

    public void setHargaSemasa(String hargaSemasa) {
        this.hargaSemasa = hargaSemasa;
    }

    public String getTrksemasa() {

        return trksemasa;
    }

    public void setTrksemasa(String trksemasa) {
        this.trksemasa = trksemasa;
    }

}