let ver=document.getElementById("ver");
let clave=document.getElementById("clave")
let icono=document.getElementById("icono")
let con=true

ver.addEventListener("click", function(){
    if (con==true) {
        clave.type="correo"
        icono.classList.add("fa-eye-slash")
        con=false
    } else {
        clave.type="password"
        icono.classList.remove("fa-eye-slash")
        con=true
    }
})

function validar() {
	var correo = document.getElementById("correo").value;
	var password = document.getElementById("contraseña").value;

	var expresion_correo =
		/^(([^<>()\[\]\\.,;:\s@”]+(\.[^<>()\[\]\\.,;:\s@”]+)*)|(“.+”))@((\[[0–9]{1,3}\.[0–9]{1,3}\.[0–9]{1,3}\.[0–9]{1,3}])|(([a-zA-Z\-0–9]+\.)+[a-zA-Z]{2,}))$/;

	var expresion_contraseña =
		/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])([A-Za-z\d$@$!%*?&]|[^ ]){8,15}$/;
	if (correo == "" || password == "") {
		alert("Debe ingresar correo y contraseña");
		return false;
	} else if (correo.length > 50) {
		alert("El correo no puede tener mas de 50 caracteres");
		return false;
	} else if (!expresion_correo.test(correo)) {
		alert("El correo no cumple con la estructura correcta");
		return false;
	} else if (password.length > 15) {
		alert("La contraseña no puede contener mas de 15 caracteres");
		return false;
	} else if (!expresion_contraseña.test(password)) {
		alert(
			"La contraseña debe ser de minimo 8 y maximo 15 caracteres, debe tener al menos 1 mayuscula y 1 minuscula, al menos 1 digito, no debe tener espacios en blanco y debe contener un caracter especial"
		);
		return false;
	}

	return true;
}
