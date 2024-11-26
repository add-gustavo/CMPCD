document.getElementById('nomelogin').addEventListener('blur', function () {
    var nomeLogin = document.getElementById('nomelogin').value;
    console.log("Valor enviado (nomeLogin):", nomeLogin);

    fetch('/cadastromunicipal/controlenomelogin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ nomeLogin: nomeLogin })
    })
        .then(response => response.json())
        .then(data => {
            console.log("Resposta recebida:", data);

            var nomeLoginError = document.getElementById('nomeLoginError');
            var submitButton = document.getElementById('submitButton');

            if (data.exists) {
                nomeLoginError.style.display = 'inline';
                submitButton.disabled = true;
            } else {
                nomeLoginError.style.display = 'none';
                submitButton.disabled = false;
            }
        })
        .catch(error => console.error('Erro:', error));
});

document.getElementById('email').addEventListener('blur', function () {
    var email = document.getElementById('email').value;
    console.log("Valor enviado (email):", email);

    fetch('/cadastromunicipal/controleemail', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email: email })
    })
        .then(response => response.json())
        .then(data => {
            console.log("Resposta recebida:", data);

            var nomeLoginError = document.getElementById('nomeLoginError');
            var submitButton = document.getElementById('submitButton');

            if (data.exists) {
                nomeLoginError.style.display = 'inline';
                submitButton.disabled = true;
            } else {
                nomeLoginError.style.display = 'none';
                submitButton.disabled = false;
            }
        })
        .catch(error => console.error('Erro:', error));
});

function validarSenhas() {
    var senha = document.getElementById('senha').value;
    var confirmarSenha = document.getElementById('confirmarsenha').value;
    var submitButton = document.getElementById('submitButton'); // Obtendo o botão de envio

    if (senha !== confirmarSenha) {
        alert("As senhas não coincidem. Tente novamente.");
        submitButton.disabled = true; // Desabilitar o botão de envio
        return false; // Impede o envio do formulário
    } else {
        submitButton.disabled = false; // Habilitar o botão de envio se as senhas coincidirem
    }

    // Se as senhas coincidirem, o formulário será enviado
    return true;
}

// Captura o evento de clique no botão de envio
document.getElementById('submitButton').addEventListener('click', function () {
    // Antes de submeter o formulário, valida as senhas
    if (validarSenhas()) {
        // Se as senhas coincidirem, submete o formulário
        document.querySelector('form').submit();
    }
});

