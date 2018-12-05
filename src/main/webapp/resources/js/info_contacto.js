function createNewInput() {
    var container = document.getElementById("info-contacto");
    var new_div = document.createElement("div");
    
    var new_input = document.createElement("input");
    new_input.name = "contacto.contacto";

    var break_line = document.createElement("br");

    var new_select = document.createElement("select");
    new_select.name = "contacto.tipoContacto";
    var selectValues = ["1","2","3","4","5"];
    var selectOptions = ["Telefono", "Correo", "Movil", "Facebook", "Twitter"];

    for (var i = 0; i < selectValues.length; i++) {
        var option = document.createElement("option");
        option.value = selectValues[i];
        option.text = selectOptions[i];
        new_select.appendChild(option);
    }

    new_div.appendChild(new_input);
    new_div.appendChild(break_line);
    new_div.appendChild(new_select);
    
    container.appendChild(new_div);
    container.appendChild(break_line);
}

document.getElementById("agregar-info-contacto").addEventListener("click", createNewInput);