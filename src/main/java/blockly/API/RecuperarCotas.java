package blockly.API;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class RecuperarCotas {

public static final int TIMEOUT = 300;

/**
 *
 * @param token
 *
 * @author Ícaro Antunes
 * @since 24/10/2024, 09:03:59
 *
 */
public static Var Executar(@ParamMetaData(description = "token", id = "3eb3b4dd") Var token) throws Exception {
 return new Callable<Var>() {

   private Var url = Var.VAR_NULL;
   private Var dados = Var.VAR_NULL;
   private Var resposta = Var.VAR_NULL;
   private Var error = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         System.out.println(
        Var.valueOf("INICIO COTAS").getObjectAsString());
        url =
        cronapi.util.Operations.getSystemParameter(
        Var.valueOf("API_URL_COTAS"));
        System.out.println(url.getObjectAsString());
        if (
        cronapi.logic.Operations.isNullOrEmpty(url).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Url inválida ou nula")));
        } else {
            dados =
            cronapi.json.Operations.toJson(
            cronapi.util.Operations.getURLFromOthers(
            Var.valueOf("GET"),
            Var.valueOf("application/json"), url, Var.VAR_NULL,
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("Authorization",
            Var.valueOf(montarBearer(token)))), Var.VAR_NULL,
            Var.valueOf(""),
            Var.valueOf("BODY")));
            System.out.println(dados.getObjectAsString());
            resposta =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_TRUE) , Var.valueOf("dados",
            cronapi.json.Operations.getJsonOrMapField(dados,
            Var.valueOf("data"))));
        }
     } catch (Exception error_exception) {
          error = Var.valueOf(error_exception);
         resposta =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("dados",
        Var.VAR_NULL));
     }
    return resposta;
   }
 }.call();
}

/**
 *
 * @param token
 *
 * @author Ícaro Antunes
 * @since 24/10/2024, 09:03:59
 *
 */
public static Var montarBearer(@ParamMetaData(description = "token", id = "c96ca5a3") Var token) throws Exception {
 return new Callable<Var>() {

   private Var url = Var.VAR_NULL;
   private Var dados = Var.VAR_NULL;
   private Var resposta = Var.VAR_NULL;
   private Var error = Var.VAR_NULL;

   public Var call() throws Exception {
    return
Var.valueOf(
Var.valueOf("Bearer ").getObjectAsString() +
token.getObjectAsString());
   }
 }.call();
}

}

