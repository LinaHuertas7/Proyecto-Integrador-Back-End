window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_paciente_form');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        try {
            let pacienteId = $("#paciente_id").val();
            const url= "/pacientes";
        let formData = {
            id: $("#paciente_id").val(),
            nombre : $("#nombre").val(),
            apellido :  $("#apellido").val(),
            dni: $('#dni').val(),
            domicilio: {
                 calle: $('#calle').val(),
                 numero: $('#numero').val(),
                 localidad: $('#localidad').val(),
                 provincia: $('#provincia').val(),
            }
        }
            const settings = {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData)
            }
            fetch(url,settings)
                .then(response => response.json())
                .then(data => {
                    let paciente = data;

                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong> Paciente actualizado </strong></div>'


                    $("#tr_" + pacienteId + " td.td_first_name").text(paciente.nombre.toUpperCase());
                    $("#tr_" + pacienteId + " td.td_last_name").text(paciente.apellido.toUpperCase());
                    $("#tr_" + pacienteId + " td.td_domicilio.calle").text(domicilio.calle);
                    $("#tr_" + pacienteId + " td.td_domicilio.numero").text(domicilio.numero);                    $("#tr_" + pacienteId + " td.td_matricula").text(odontologo.matricula);
                    $("#tr_" + pacienteId + " td.td_domicilio.localidad").text(domicilio.localidad);
                    $("#tr_" + pacienteId + " td.td_domicilio.provincia").text(domicilio.provincia);




                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                }).catch(error =>{
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error </strong></div>';

                $("#response").empty();
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});
            })

        } catch(error){
            console.log(error);
            alert(error);
        }
    });

});
function find(id) {
    const url = '/pacientes'+"/"+id;
    const settings = {
        method: 'GET'
    }

    fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            let paciente = data;
            $("#paciente_id").val(paciente.id);
            $("#nombre").val(paciente.nombre);
            $("#apellido").val(paciente.apellido);
            $("#calle").val(domicilio.calle);
            $("#numero").val(domicilio.numero);
            $("#localidad").val(domicilio.localidad);
            $("#provincia").val(domicilio.provincia);
            $("#div_paciente_updating").css({"display": "block"});
        }).catch(error =>{
        console.log(error);
        alert("Error -> " + error);
    })


}
/*
window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_paciente_form');

    formulario.addEventListener('submit', function (event) {
        const formData = {
            id: document.querySelector('#id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            domicilio: {
                calle: document.querySelector('#calle').value,
                numero: document.querySelector('#numero').value,
                localidad: document.querySelector('#localidad').value,
                provincia: document.querySelector('#provincia').value
            }
        };
        const url = '/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
        fetch(url,settings)
            .then(response => response.json())

    })
})

function findBy(id) {
    const url = '/pacientes'+"/"+id;
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            let paciente = data;
            document.querySelector('#id').value = paciente.id;
            document.querySelector('#nombre').value = paciente.nombre;
            document.querySelector('#apellido').value = paciente.apellido;
            document.querySelector('#dni').value = paciente.dni;
            document.querySelector('#calle').value = paciente.domicilio.calle;
            document.querySelector('#numero').value = paciente.domicilio.numero;
            document.querySelector('#localidad').value = paciente.domicilio.localidad;
            document.querySelector('#provincia').value = paciente.domicilio.provincia;

            document.querySelector('#div_paciente_updating').style.display = "block";
        }).catch(error => {
        alert("Error: " + error);
    })
}*/
