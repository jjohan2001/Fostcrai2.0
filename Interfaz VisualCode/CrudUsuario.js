var app = {
    backend: 'http://localhost:8080/api/usuarios',
    table : null,
    init: function(){
        app.initDatatable('#usuarios');

        

        $('#save').click(function(){
            
            const nombres = document.getElementById("nombre").value;
            const apellidos = document.getElementById("apellido").value;
            const cedula = document.getElementById("cedula").value;
            const celular = document.getElementById("celular").value;
            const correo = document.getElementById("correo").value;
            const password = document.getElementById("password").value;
            const rol = document.getElementById("rol").value;


            if (nombres =='') {
                setTimeout(function(){
                    $("#validacionN").html("<span style='color:red'>Complete el campo</span>").fadeOut(4000);
                },1000);

                $('#nombre').focus();
                return false;
            }else if (apellidos =='') {
                setTimeout(function(){
                    $("#validacionA").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#apellido').focus();
                return false;
            }else if (correo =='') {
                setTimeout(function(){
                    $("#validacionE").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#correo').focus();
                return false;
            }else if (cedula =='') {
                setTimeout(function(){
                    $("#validacionCi").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#cedula').focus();
                return false;
            }else if (password =='') {
                setTimeout(function(){
                    $("#validacionP").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#password').focus();
                return false;
            }else if (celular =='') {
                setTimeout(function(){
                    $("#validacionO").html("<span style='color:red'>Ingrese un Celular/span>").fadeOut(2000);
                },1000);

                $('#celular').focus();
                return false;
            }else if (direccion =='') {
                setTimeout(function(){
                    $("#validacionT").html("<span style='color:red'>Complete el campo</span>").fadeOut(2000);
                },1000);

                $('#direccion').focus();
                return false;
            }else if(rol == ''){
                setTimeout(function(){
                    $("#validacionR").html("<span style='color:red'>Ingre Rol</span>").fadeOut(2000);
                },1000);

                $('#rol').focus();
                return false;
            }
            app.save({
                id_usuario :$('#id').val(),
                nombre : $('#nombre').val(),
                apellido: $('#apellido').val(),
                cedula : $('#cedula').val(),
                celular : $('#celular').val(),
                correo : $('#correo').val(),
                direccion : $('#direccion').val(),
                password : $('#password').val(),
                rol : $('#rol').val()
            });
        });
    },
    initDatatable : function(id){
        app.table = $(id).DataTable({
            ajax : {
                url : app.backend + '/all',
                dataSrc : function(json){
                    return json;
                }
            },
            dom: 'Bfrtip',
            columns : [
                {data: "id"},
                {data : "nombre"},
                {data : "apellido"},
                {data : "cedula"},
                {data : "celular"},
                {data : "correo"},
                {data : "direccion"},
                {data : "password"},
                {data : "rol"}
            ],
            buttons: [
                {
                    text : 'Crear',
                    action : function(e, dt, node, config){
                        app.cleanForm();
                        $('#usuarioModal').modal();
                    }
                },
                {
                    text : 'Editar',
                    action : function(e, dt, node, config){
                        var data = dt.rows('.table-active').data()[0];
                        app.setDataToModal(data);
                        $('#usuarioModal').modal();
                    }
                },
                {
                    text : 'Eliminar',
                    action : function(e, dt, node, config){
                        var data = dt.rows('.table-active').data()[0];
                        Swal.fire({
                            title: 'Seguro que desea eliminar este registro?',
                            text: "No podra recuperar el registro",
                            icon: 'warning',
                            showCancelButton: true,
                            confirmButtonColor: '#3085d6',
                            cancelButtonColor: '#d33',
                            confirmButtonText: 'delete'
                          }).then((result) => {
                            if (result.isConfirmed) {
                              Swal.fire(
                                app.delete(data.id),
                                'Deleted!',
                                'Your file has been deleted.',
                                'success'
                              )
                            }
                        })
                    }
                }
            ]
        });

        $('#usuarios tbody').on('click', 'tr', function(){
            if($(this).hasClass('table-active')){
               $(this).removeClass('table-active');
            }else{
                app.table.$('tr.table-active').removeClass('table-active');
                $(this).addClass('table-active');
            }
        });
    },
    setDataToModal : function(data){
        $('#id').val(data.id_usuario);
        $('#nombre').val(data.nombre);
        $('#apellido').val(data.apellido);
        $('#cedula').val(data.cedula);
        $('#celular').val(data.celular);
        $('#correo').val(data.correo);
        $('#direccion').val(data.direccion);
        $('#password').val(data.password);
        $('#rol').val(data.rol);
    },
    cleanForm: function(){
        $('#id').val('');
        $('#nombre').val('');
        $('#apellido').val('');
        $('#cedula').val('');
        $('#celular').val('');
        $('#correo').val('');
        $('#direccion').val('');
        $('#password').val('');
        $('#rol').val('');
    },
    save : function(data) {
        $.ajax({
            url: app.backend + '/save',
            data : JSON.stringify(data),
            method: 'POST',
            dataType : 'json',
            contentType: "application/json; charset=utf-8",
            success : function(json) {
                setTimeout(function(){
                    $("#msg").text('Se guardó la persona correctamente').fadeOut(5000);
                },100);
                $("#msg").show();
                $('#usuarioModal').modal('hide');
                app.table.ajax.reload();
            },
            error : function(error) {
                $("msg").text(error.error);
                $("msg").show();
            }
        })
    },
    delete : function(id) {
        $.ajax({
            url: app.backend + '/delete/'+id,
            method: 'GET',
            dataType : 'json',
            contentType: "application/json; charset=utf-8",
            success : function(json) {
                setTimeout(function(){
                    $("#msg").text('Se elimino correctamente').fadeOut(5000);
                },100);
                $("#msg").show();
                app.table.ajax.reload();
            },
            error : function(error) {
                $("msg").text(error.error);
                $("msg").show();
            }
        })
    }
};


$(document).ready(function(){
    app.init();
});