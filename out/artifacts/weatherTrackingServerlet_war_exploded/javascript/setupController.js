/**
 * Created by David on 14/05/2015.
 */

(function (){

    window.onload = function() {



        var setup = document.getElementById("setup");
        var checkboxes = document.getElementsByName('sensor');
        var data = new FormData();
        var request = new XMLHttpRequest();
            request.open("POST", "/add",true);
            request.onload = function () {
                console.log("result: " + request.responseText);

                       for (var i = 0; i < checkboxes.length; i++) {

                           if (checkboxes[i].checked) {
                               data.append("sensor", checkboxes[i].value);
                               checkboxes[i].value = request.responseText;
                               console.log("checked");

                           } else {
                               data.append("sensor", 0);
                               console.log("not checked\n");
                           }


                       }


                };

            request.send(data);


    };

}());