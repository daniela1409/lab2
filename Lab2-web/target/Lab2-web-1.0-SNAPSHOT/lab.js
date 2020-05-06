/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function tipoDeTarjeta(element) {
    console.log(element);
    var tipoTarjeta;
    var tarjeta = element.value;
    tipoTarjeta = tarjeta.substring(0, 5);
    var tipoTarjetaTextBox = document.getElementById('j_idt6:tipoDeTarjeta');
    tipoTarjeta = parseInt(tipoTarjeta);
    if (tipoTarjeta >= 11111 && tipoTarjeta <= 22222) {
        //American Express
        tipoTarjetaTextBox.value = "American Express";
    } else if (tipoTarjeta >= 33334 && tipoTarjeta <= 44444) {
        // Diners:
        tipoTarjetaTextBox.value = "Diners";
    } else if (tipoTarjeta >= 55555 && tipoTarjeta <= 66666) {
        // Visa:
        tipoTarjetaTextBox.value = "Visa";
    } else if (tipoTarjeta >= 77777 && tipoTarjeta <= 88888) {
        // Mastercard:
        tipoTarjetaTextBox.value = "Mastercard";
    } else {
        alert("No se reonoce el numero de tarjeta ingresado, por favor validar")
    }
    console.log(tipoTarjeta);
}
function validarCvv(element) {
    var numbers = /^[0-9]+$/;
    var cvv = document.getElementById('j_idt6:cvv');
    if (!element.value.match(numbers) && element.value.length == 3)
    {
        cvv.value = null;
        alert('Por favor ingrese un numero de cvv valido');
    }
}

function validateRangeValue(element) {
    var valor = document.getElementById('j_idt6:valor');
    if (parseInt(element.value) < 500 || parseInt(element.value) > 10000)
    {
        valor.value = null;
        alert('Por favor ingrese un valor valido');
    }
}