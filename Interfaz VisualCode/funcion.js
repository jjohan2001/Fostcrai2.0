function login(){
    var user, password
    user = document.getElementById("username").value;
    password = document.getElementById("password").value;

    if( username == "prueba" && password == "12345"){
        window.location = "home.html";
    } else{
        alert("Datos incorrectos")
    }
}