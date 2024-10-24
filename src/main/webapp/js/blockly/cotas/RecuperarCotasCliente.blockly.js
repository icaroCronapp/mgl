window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.cotas = window.blockly.js.blockly.cotas || {};
window.blockly.js.blockly.cotas.RecuperarCotasCliente = window.blockly.js.blockly.cotas.RecuperarCotasCliente || {};

/**
 * @function Executar
 *
 *
 *
 *
 * @author Ericles Alberto De Jesus Ribeiro
 * @since 22/10/2024, 10:40:48
 *
 */
window.blockly.js.blockly.cotas.RecuperarCotasCliente.ExecutarArgs = [];
window.blockly.js.blockly.cotas.RecuperarCotasCliente.Executar = async function() {
 var respostaAuth, dadosCotas;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.API.ObterToken:Executar', async function(sender_respostaAuth) {
      respostaAuth = sender_respostaAuth;
    //
    console.log(respostaAuth);
    //
    if (this.cronapi.json.getProperty(respostaAuth, 'sucesso')) {
      //
      this.cronapi.util.callServerBlocklyAsynchronous('blockly.API.RecuperarCotas:Executar', async function(sender_dadosCotas) {
          dadosCotas = sender_dadosCotas;
        //
        console.log(dadosCotas);
      }.bind(this), this.cronapi.json.getProperty(respostaAuth, 'dados'));
    } else {
      //
      this.cronapi.screen.notify('error','Ocorreu um erro inesperado!');
    }
  }.bind(this));
}
