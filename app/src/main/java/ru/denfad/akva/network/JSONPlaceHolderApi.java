package ru.denfad.akva.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.denfad.akva.models.Data;

public interface JSONPlaceHolderApi {

    @GET("/index/")
    public Call<Data> getDiagnoses();
}
