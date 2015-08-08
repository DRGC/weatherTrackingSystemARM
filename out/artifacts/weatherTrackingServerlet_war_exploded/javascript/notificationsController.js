/**
 * Created by David on 14/05/2015.
 */

(function (){

    window.onload = function() {



        var notification = document.getElementById("notification");
        var emailInput = document.getElementById('email');
        var temperatureInput = document.getElementById("temperatureThreshold");
        var humidityInput = document.getElementById("humidityThreshold");
        var lightInput = document.getElementById("lightThreshold");
        var data = new FormData();
        var request = new XMLHttpRequest();
            request.open("POST", "/add",true);
            request.onload = function () {
                console.log(emailInput.value());
                console.log(temperatureInput.value());
                console.log(humidityInput.value());
                console.log(lightInput.value);
                data.append("email", emailInput.value());
                data.append("temperatureThreshold", temperatureInput.value());
                data.append("humidityThreshold", humidityInput.value());
                data.append("lightThreshold", humidityInput.value());
                };

            request.send(data);


    };

}());