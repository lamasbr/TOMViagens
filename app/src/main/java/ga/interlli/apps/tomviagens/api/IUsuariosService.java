package ga.interlli.apps.tomviagens.api;

import java.util.List;

import ga.interlli.apps.tomviagens.models.Usuario;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IUsuariosService {

    @GET("usuarios/all")
    @Headers("Accept: application/json")
    Call<List<Usuario>> findAllUsers();

    @GET("usuarios/{id}")
    @Headers("Accept: application/json")
    Call<ResponseBody> getUserById(
            @Path("id") int id,
            @Header("code") String token);

    @POST("usuarios")
    @Headers("Accept: application/json")
    Call<ResponseBody> createUser(@Body Usuario usuario);

    @POST("usuarios/login")
    @Headers("Accept: application/json")
    Call<ResponseBody> loginUser(
            @Field("login") String login,
            @Field("senha") String senha
    );
}
