package blockly.API;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ObterToken {

public static final int TIMEOUT = 300;

/**
 *
 * @author Ícaro Antunes
 * @since 23/10/2024, 09:38:29
 *
 */
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   private Var url = Var.VAR_NULL;
   private Var dados = Var.VAR_NULL;
   private Var resposta = Var.VAR_NULL;
   private Var error = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         System.out.println(
        Var.valueOf("INICIO AUTH").getObjectAsString());
        url =
        cronapi.util.Operations.getSystemParameter(
        Var.valueOf("API_URL_TOKEN"));
        System.out.println(url.getObjectAsString());
        if (
        cronapi.logic.Operations.isNullOrEmpty(url).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Url de autenticação inválida ou nula")));
        } else {
            dados =
            cronapi.json.Operations.toJson(
            cronapi.util.Operations.getURLFromOthers(
            Var.valueOf("POST"),
            Var.valueOf("application/json"), url, Var.VAR_NULL, Var.VAR_NULL,
            cronapi.map.Operations.toJson(
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("app",
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("appName",
            cronapi.util.Operations.getSystemParameter(
            Var.valueOf("API_APP_NAME"))) , Var.valueOf("appId",
            cronapi.util.Operations.getSystemParameter(
            Var.valueOf("API_APP_ID"))))) , Var.valueOf("inscricaoNacional",
            cronapi.util.Operations.getSystemParameter(
            Var.valueOf("API_INSCRICAO_NACIONAL"))))),
            Var.valueOf(""),
            Var.valueOf("BODY")));
            resposta =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_TRUE) , Var.valueOf("dados",
            cronapi.json.Operations.getJsonOrMapField(
            cronapi.json.Operations.getJsonOrMapField(dados,
            Var.valueOf("data")),
            Var.valueOf("token"))));
            System.out.println(resposta.getObjectAsString());
        }
     } catch (Exception error_exception) {
          error = Var.valueOf(error_exception);
         resposta =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("dados",
        Var.VAR_NULL));
        System.out.println(resposta.getObjectAsString());
     }
    return resposta;
   }
 }.call();
}

}

